package primitiveae;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import customtypes.GeneMention;
import utils.MentionSpan;
import edu.stanford.nlp.util.IntervalTree;

/**
 * Takes all annotations, decides which overlapping annotations to take! 
 * It will make sure no overlapping instances are preserved! 
 * It takes a preferred class as argument.
 * It is a greedy approach which might not be optimal but is faster.
 * Also note the original GeneMentions that are selected are preserved:
 * So confidence and casProcessorID can be traced back in later stages!
 */
public class AnnotationMerger extends JCasAnnotator_ImplBase {

	private String preferred;
	
	@Override
	public void initialize(UimaContext aContext) throws ResourceInitializationException
	{
		super.initialize(aContext);
		preferred = (String) aContext.getConfigParameterValue("PreferredClass");
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		IntervalTree<Integer, MentionSpan> intTree = new IntervalTree<Integer, MentionSpan>();
		
		FSIterator<Annotation> allMentionsIt = aJCas.getAnnotationIndex(GeneMention.type).iterator();
		
		HashMap<MentionSpan, Integer> spanCounts = new HashMap<MentionSpan, Integer>();
		// need to remember exactly which mention we kept
		HashMap<MentionSpan, MentionSpan> spanKeys = new HashMap<MentionSpan, MentionSpan>();
		
		// add mentions to the interval tree
		// also count which identical spans occur multiple times
		// removes overlapping instances
		
		ArrayList<MentionSpan> toRemove = new ArrayList<MentionSpan>();
		while(allMentionsIt.hasNext())
		{
			GeneMention ment = (GeneMention)allMentionsIt.next();
			
			MentionSpan span = new MentionSpan(ment);
			
			// count identical spans
			if (!spanCounts.containsKey(span))
			{
				spanKeys.put(span, span);
				spanCounts.put(span, 1);
			}else{
				MentionSpan key = spanKeys.get(span); // lets not change the key
				spanCounts.put(key, 1+spanCounts.get(key));
				// also if known remove this span
				toRemove.add(span);
				continue; // don't add it to the interval tree since we already have the same span
			}
			
			intTree.add(span);
		}
		
		for(MentionSpan msp : toRemove)
		{
			msp.getGene().removeFromIndexes();
		}
		// the interval tree remove method throws random nullpointer exceptions thus we need an alternative.
		HashSet<MentionSpan> deleted = new HashSet<MentionSpan>();
		// Now keep only probable instances 
		for(MentionSpan msp : spanCounts.keySet())
		{
			if(spanCounts.get(msp) < 2 && !msp.getGene().getCasProcessorId().equals(preferred))
			{
				deleted.add(msp);
				msp.getGene().removeFromIndexes();
			}
		}
		
		// second round of cleaning remove overlapping instances
		for(MentionSpan msp : spanCounts.keySet())
		{
			if(deleted.contains(msp))
			{
				continue;
			}
			
			if(msp.getGene().getCasProcessorId().equals(preferred))
			{
				// remove all mentions that overlap with mentions that were found by lingpipe
				for(MentionSpan ovrlap : intTree.getOverlapping(msp))
				{
					if(ovrlap == msp) // don't remove 
					{
						continue;
					}
					deleted.add(ovrlap);
					ovrlap.getGene().removeFromIndexes();
					
				}
			}
		}
	}

}

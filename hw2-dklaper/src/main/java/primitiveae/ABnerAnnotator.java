package primitiveae;

import java.util.Vector;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import customtypes.GeneMention;
import abner.Tagger;

/**
 * Use ABner for annotation based on the BIOCreative model
 * 
 */
public class ABnerAnnotator extends JCasAnnotator_ImplBase {

	private Tagger tag;

	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		super.initialize(aContext);
		Integer mode = Tagger.BIOCREATIVE;
		try{
			mode = Tagger.class.getField((String)aContext.getConfigParameterValue("modelName")).getInt(null);
		}catch(Exception e) // ignore  if can't be found
		{}
		tag = new Tagger(mode);
	}

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {

		String text = aJCas.getDocumentText();
		@SuppressWarnings("unchecked")
		Vector<String[][]> vres = tag.getSegments(text);

		int currentBeginIdx = 0; // unfortunately ABner doesn't give indices so
									// we need to count (and it's tokenized!)
		
		// iterate through sentences (because ABNer's sentence tokenization is a bit flaky)
		for (int s = 0; s < vres.size(); ++s) {
			String[][] segments = vres.get(s);

			// iterate through each segment
			for (int i = 0; i < segments[0].length; ++i) {
				String nonWS = segments[0][i].replaceAll("\\s", "");
				if (!segments[1][i].equals("O")) // current group is not
													// Non-entity
				{
					GeneMention mention = new GeneMention(aJCas,
							currentBeginIdx, currentBeginIdx + nonWS.length()
									- 1);
					mention.setCasProcessorId(this.getClass().getName());
					mention.setConfidence(0.6); // approx. reported performance
					mention.addToIndexes();
					mention.setMentionText(segments[0][i]);
				}

				currentBeginIdx += nonWS.length();
			}
		}
	}

}

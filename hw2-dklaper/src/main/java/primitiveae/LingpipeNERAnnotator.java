package primitiveae;

import java.io.File;

import org.apache.uima.UIMARuntimeException;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.*;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.ScoredObject;

import customtypes.*;

/**
 * Applies a Lingpipe Chunker loaded from a model file
 * 
 */
public class LingpipeNERAnnotator extends JCasAnnotator_ImplBase {

	private NBestChunker chunker;
	@Override
	public void initialize(UimaContext aUimaContext)
	{
		try {
			chunker = (NBestChunker)AbstractExternalizable.readObject(new File(aUimaContext.getResourceFilePath("LingpipeModel")));
		} catch (Exception e) {
			throw new UIMARuntimeException(e);
		} 
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		String text = aJCas.getSofaDataString();
		// get top 1 chunking 
		ScoredObject<Chunking> chunkres = chunker.nBest(text.toCharArray(), 0, text.length(), 1).next();
		double conf = chunkres.score();
		for(Chunk chunk : chunkres.getObject().chunkSet())
		{
			// adapt indices to non whitespace
			int begin = text.substring(0, chunk.start()).replaceAll("\\s", "").length(); 
			int end = -1+text.substring(0, chunk.end()).replaceAll("\\s", "").length(); 
			// add mention to CAS
			GeneMention mention = new GeneMention(aJCas, begin, end);
			mention.setMentionText(text.substring(chunk.start(), chunk.end()));
			mention.setCasProcessorId(this.getClass().getName());
			mention.setConfidence(conf);
			mention.addToIndexes();
		}
	}
	

}

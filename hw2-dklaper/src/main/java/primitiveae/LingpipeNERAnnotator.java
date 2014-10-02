package primitiveae;

import java.io.File;

import org.apache.uima.UIMARuntimeException;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import com.aliasi.chunk.*;
import com.aliasi.util.AbstractExternalizable;
import customtypes.*;

/**
 * Applies a Lingpipe Chunker loaded from a model file
 * 
 */
public class LingpipeNERAnnotator extends JCasAnnotator_ImplBase {

	private Chunker chunker;
	@Override
	public void initialize(UimaContext aUimaContext)
	{
		try {
			chunker = (Chunker)AbstractExternalizable.readObject(new File(aUimaContext.getResourceFilePath("LingpipeModel")));
		} catch (Exception e) {
			throw new UIMARuntimeException(e);
		} 
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		
		String text = aJCas.getSofaDataString();
		Chunking chunkres = chunker.chunk(text);
		for(Chunk chunk : chunkres.chunkSet())
		{
			// adapt indices to non whitespace
			int begin = text.substring(0, chunk.start()).replaceAll("\\s", "").length(); 
			int end = -1+text.substring(0, chunk.end()).replaceAll("\\s", "").length(); 
			// add mention to CAS
			GeneMention mention = new GeneMention(aJCas, begin, end);
			mention.setMentionText(text.substring(chunk.start(), chunk.end()));
			mention.addToIndexes();
		}
	}
	

}

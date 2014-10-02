package primitiveae;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.uima.UIMARuntimeException;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import customtypes.*;

/**
 * Baseline Annotator using PosTagNamedEntityRecognizer
 * 
 * Because of the unfortunate consequence of being in the default package 
 * I decided to use reflection (mainly for training, I guess I could have just moved the class to package)
 */
public class BaselineAnnotator extends JCasAnnotator_ImplBase {

	private Object namedEntityRecognizer;
	private Method getGeneSpans;
	@Override
	public void initialize(UimaContext aContext)
	{
		try {
			// Get the class from the default package and create instance
			Class<?> cls = Class.forName("PosTagNamedEntityRecognizer");
			Constructor<?> constr = cls.getConstructor();
			namedEntityRecognizer = constr.newInstance();
			// get the relevant method
			getGeneSpans = cls.getMethod("getGeneSpans", String.class);
		} catch (Exception e) {
			throw new UIMARuntimeException(e);
		} 
	}
	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		try {
			// call the method on the created instance to get all detected
			@SuppressWarnings("unchecked")
			Map<Integer, Integer> res = (Map<Integer, Integer>)getGeneSpans.invoke(namedEntityRecognizer, aJCas.getSofaDataString());
			String text = aJCas.getSofaDataString();
			// iterate through found mentions
			for(Map.Entry<Integer, Integer> entry : res.entrySet())
			{
				// Use offsets with only non white space
				int begin = text.substring(0, entry.getKey()).replaceAll("\\s", "").length();
				int end = -1+text.substring(0, entry.getValue()).replaceAll("\\s", "").length();
				// add the mention
				GeneMention gen = new GeneMention(aJCas, begin, end);
				gen.setMentionText(text.substring(entry.getKey(), entry.getValue()));
				gen.addToIndexes();
			}
			
		} catch (Exception e) {
			throw new UIMARuntimeException(e);
		}

	}

}

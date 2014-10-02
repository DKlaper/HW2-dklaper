
/* First created by JCasGen Wed Oct 01 19:07:51 EDT 2014 */
package customtypes;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.cas.TOP_Type;

/** Identify the sentence
 * Updated by JCasGen Wed Oct 01 20:04:32 EDT 2014
 * @generated */
public class SentenceMetadata_Type extends TOP_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SentenceMetadata_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = SentenceMetadata_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SentenceMetadata(addr, SentenceMetadata_Type.this);
  			   SentenceMetadata_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SentenceMetadata(addr, SentenceMetadata_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = SentenceMetadata.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("customtypes.SentenceMetadata");
 
  /** @generated */
  final Feature casFeat_sentenceID;
  /** @generated */
  final int     casFeatCode_sentenceID;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSentenceID(int addr) {
        if (featOkTst && casFeat_sentenceID == null)
      jcas.throwFeatMissing("sentenceID", "customtypes.SentenceMetadata");
    return ll_cas.ll_getStringValue(addr, casFeatCode_sentenceID);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSentenceID(int addr, String v) {
        if (featOkTst && casFeat_sentenceID == null)
      jcas.throwFeatMissing("sentenceID", "customtypes.SentenceMetadata");
    ll_cas.ll_setStringValue(addr, casFeatCode_sentenceID, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public SentenceMetadata_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_sentenceID = jcas.getRequiredFeatureDE(casType, "sentenceID", "uima.cas.String", featOkTst);
    casFeatCode_sentenceID  = (null == casFeat_sentenceID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_sentenceID).getCode();

  }
}



    

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
import edu.cmu.deiis.types.Annotation_Type;

/** A gene mention including text
 * Updated by JCasGen Wed Oct 01 20:04:32 EDT 2014
 * @generated */
public class GeneMention_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GeneMention_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GeneMention_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GeneMention(addr, GeneMention_Type.this);
  			   GeneMention_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GeneMention(addr, GeneMention_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GeneMention.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("customtypes.GeneMention");
 
  /** @generated */
  final Feature casFeat_mentionText;
  /** @generated */
  final int     casFeatCode_mentionText;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getMentionText(int addr) {
        if (featOkTst && casFeat_mentionText == null)
      jcas.throwFeatMissing("mentionText", "customtypes.GeneMention");
    return ll_cas.ll_getStringValue(addr, casFeatCode_mentionText);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setMentionText(int addr, String v) {
        if (featOkTst && casFeat_mentionText == null)
      jcas.throwFeatMissing("mentionText", "customtypes.GeneMention");
    ll_cas.ll_setStringValue(addr, casFeatCode_mentionText, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public GeneMention_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_mentionText = jcas.getRequiredFeatureDE(casType, "mentionText", "uima.cas.String", featOkTst);
    casFeatCode_mentionText  = (null == casFeat_mentionText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_mentionText).getCode();

  }
}



    
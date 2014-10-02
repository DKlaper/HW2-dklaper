

/* First created by JCasGen Wed Oct 01 19:07:51 EDT 2014 */
package customtypes;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;


/** A gene mention including text
 * Updated by JCasGen Wed Oct 01 20:04:32 EDT 2014
 * XML source: /usr/data/CMU/791/HW2-dklaper/hw2-dklaper/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class GeneMention extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneMention.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GeneMention() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public GeneMention(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public GeneMention(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public GeneMention(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: mentionText

  /** getter for mentionText - gets Text covered by mention
   * @generated
   * @return value of the feature 
   */
  public String getMentionText() {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_mentionText == null)
      jcasType.jcas.throwFeatMissing("mentionText", "customtypes.GeneMention");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneMention_Type)jcasType).casFeatCode_mentionText);}
    
  /** setter for mentionText - sets Text covered by mention 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMentionText(String v) {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_mentionText == null)
      jcasType.jcas.throwFeatMissing("mentionText", "customtypes.GeneMention");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneMention_Type)jcasType).casFeatCode_mentionText, v);}    
  }

    


/* First created by JCasGen Wed Oct 01 19:07:51 EDT 2014 */
package customtypes;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** Identify the sentence
 * Updated by JCasGen Wed Oct 01 20:04:32 EDT 2014
 * XML source: /usr/data/CMU/791/HW2-dklaper/hw2-dklaper/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class SentenceMetadata extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SentenceMetadata.class);
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
  protected SentenceMetadata() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public SentenceMetadata(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public SentenceMetadata(JCas jcas) {
    super(jcas);
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
  //* Feature: sentenceID

  /** getter for sentenceID - gets sentence identifier
   * @generated
   * @return value of the feature 
   */
  public String getSentenceID() {
    if (SentenceMetadata_Type.featOkTst && ((SentenceMetadata_Type)jcasType).casFeat_sentenceID == null)
      jcasType.jcas.throwFeatMissing("sentenceID", "customtypes.SentenceMetadata");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SentenceMetadata_Type)jcasType).casFeatCode_sentenceID);}
    
  /** setter for sentenceID - sets sentence identifier 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentenceID(String v) {
    if (SentenceMetadata_Type.featOkTst && ((SentenceMetadata_Type)jcasType).casFeat_sentenceID == null)
      jcasType.jcas.throwFeatMissing("sentenceID", "customtypes.SentenceMetadata");
    jcasType.ll_cas.ll_setStringValue(addr, ((SentenceMetadata_Type)jcasType).casFeatCode_sentenceID, v);}    
  }

    
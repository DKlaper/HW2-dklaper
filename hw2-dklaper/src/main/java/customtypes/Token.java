

/* First created by JCasGen Wed Oct 01 19:07:51 EDT 2014 */
package customtypes;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Custom Token that contains pos
 * Updated by JCasGen Wed Oct 01 20:04:32 EDT 2014
 * XML source: /usr/data/CMU/791/HW2-dklaper/hw2-dklaper/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Token extends edu.cmu.deiis.types.Token {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Token.class);
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
  protected Token() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Token(JCas jcas, int begin, int end) {
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
  //* Feature: partOfSpeech

  /** getter for partOfSpeech - gets 
   * @generated
   * @return value of the feature 
   */
  public String getPartOfSpeech() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_partOfSpeech == null)
      jcasType.jcas.throwFeatMissing("partOfSpeech", "customtypes.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_partOfSpeech);}
    
  /** setter for partOfSpeech - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPartOfSpeech(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_partOfSpeech == null)
      jcasType.jcas.throwFeatMissing("partOfSpeech", "customtypes.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_partOfSpeech, v);}    
   
    
  //*--------------*
  //* Feature: wordform

  /** getter for wordform - gets wordform of this token (so we don't have to calculate offsets all the time)
   * @generated
   * @return value of the feature 
   */
  public String getWordform() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_wordform == null)
      jcasType.jcas.throwFeatMissing("wordform", "customtypes.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_wordform);}
    
  /** setter for wordform - sets wordform of this token (so we don't have to calculate offsets all the time) 
   * @generated
   * @param v value to set into the feature 
   */
  public void setWordform(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_wordform == null)
      jcasType.jcas.throwFeatMissing("wordform", "customtypes.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_wordform, v);}    
  }

    
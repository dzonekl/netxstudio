/**
 */
package com.netxforge.smi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.smi.AttributeValue#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link com.netxforge.smi.AttributeValue#getText <em>Text</em>}</li>
 *   <li>{@link com.netxforge.smi.AttributeValue#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.AttributeValue#getSubType <em>Sub Type</em>}</li>
 *   <li>{@link com.netxforge.smi.AttributeValue#getObjectRef <em>Object Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.AttributeValue#getInteger <em>Integer</em>}</li>
 *   <li>{@link com.netxforge.smi.AttributeValue#getSequenceOf <em>Sequence Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.smi.SmiPackage#getAttributeValue()
 * @model
 * @generated
 */
public interface AttributeValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifier</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier</em>' containment reference.
   * @see #setIdentifier(Identifier)
   * @see com.netxforge.smi.SmiPackage#getAttributeValue_Identifier()
   * @model containment="true"
   * @generated
   */
  Identifier getIdentifier();

  /**
   * Sets the value of the '{@link com.netxforge.smi.AttributeValue#getIdentifier <em>Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier</em>' containment reference.
   * @see #getIdentifier()
   * @generated
   */
  void setIdentifier(Identifier value);

  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see com.netxforge.smi.SmiPackage#getAttributeValue_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link com.netxforge.smi.AttributeValue#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' reference.
   * @see #setTypeRef(Referenceable)
   * @see com.netxforge.smi.SmiPackage#getAttributeValue_TypeRef()
   * @model
   * @generated
   */
  Referenceable getTypeRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.AttributeValue#getTypeRef <em>Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' reference.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(Referenceable value);

  /**
   * Returns the value of the '<em><b>Sub Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Type</em>' containment reference.
   * @see #setSubType(ASN1_SIMPLE)
   * @see com.netxforge.smi.SmiPackage#getAttributeValue_SubType()
   * @model containment="true"
   * @generated
   */
  ASN1_SIMPLE getSubType();

  /**
   * Sets the value of the '{@link com.netxforge.smi.AttributeValue#getSubType <em>Sub Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sub Type</em>' containment reference.
   * @see #getSubType()
   * @generated
   */
  void setSubType(ASN1_SIMPLE value);

  /**
   * Returns the value of the '<em><b>Object Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Object Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Object Ref</em>' containment reference.
   * @see #setObjectRef(BracedObjectReference)
   * @see com.netxforge.smi.SmiPackage#getAttributeValue_ObjectRef()
   * @model containment="true"
   * @generated
   */
  BracedObjectReference getObjectRef();

  /**
   * Sets the value of the '{@link com.netxforge.smi.AttributeValue#getObjectRef <em>Object Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Object Ref</em>' containment reference.
   * @see #getObjectRef()
   * @generated
   */
  void setObjectRef(BracedObjectReference value);

  /**
   * Returns the value of the '<em><b>Integer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integer</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integer</em>' containment reference.
   * @see #setInteger(ASN1_SIMPLE)
   * @see com.netxforge.smi.SmiPackage#getAttributeValue_Integer()
   * @model containment="true"
   * @generated
   */
  ASN1_SIMPLE getInteger();

  /**
   * Sets the value of the '{@link com.netxforge.smi.AttributeValue#getInteger <em>Integer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integer</em>' containment reference.
   * @see #getInteger()
   * @generated
   */
  void setInteger(ASN1_SIMPLE value);

  /**
   * Returns the value of the '<em><b>Sequence Of</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sequence Of</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sequence Of</em>' containment reference.
   * @see #setSequenceOf(ASN1_SEQUENCE_OF)
   * @see com.netxforge.smi.SmiPackage#getAttributeValue_SequenceOf()
   * @model containment="true"
   * @generated
   */
  ASN1_SEQUENCE_OF getSequenceOf();

  /**
   * Sets the value of the '{@link com.netxforge.smi.AttributeValue#getSequenceOf <em>Sequence Of</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sequence Of</em>' containment reference.
   * @see #getSequenceOf()
   * @generated
   */
  void setSequenceOf(ASN1_SEQUENCE_OF value);

} // AttributeValue

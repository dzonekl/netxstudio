/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.ASN1_SEQUENCE_OF;
import com.netxforge.smi.ASN1_SIMPLE;
import com.netxforge.smi.AttributeValue;
import com.netxforge.smi.BracedObjectReference;
import com.netxforge.smi.Identifier;
import com.netxforge.smi.Referenceable;
import com.netxforge.smi.SmiPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.AttributeValueImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.AttributeValueImpl#getText <em>Text</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.AttributeValueImpl#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.AttributeValueImpl#getSubType <em>Sub Type</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.AttributeValueImpl#getObjectRef <em>Object Ref</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.AttributeValueImpl#getInteger <em>Integer</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.AttributeValueImpl#getSequenceOf <em>Sequence Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeValueImpl extends MinimalEObjectImpl.Container implements AttributeValue
{
  /**
   * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentifier()
   * @generated
   * @ordered
   */
  protected Identifier identifier;

  /**
   * The default value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected static final String TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getText()
   * @generated
   * @ordered
   */
  protected String text = TEXT_EDEFAULT;

  /**
   * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeRef()
   * @generated
   * @ordered
   */
  protected Referenceable typeRef;

  /**
   * The cached value of the '{@link #getSubType() <em>Sub Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubType()
   * @generated
   * @ordered
   */
  protected ASN1_SIMPLE subType;

  /**
   * The cached value of the '{@link #getObjectRef() <em>Object Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjectRef()
   * @generated
   * @ordered
   */
  protected BracedObjectReference objectRef;

  /**
   * The cached value of the '{@link #getInteger() <em>Integer</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInteger()
   * @generated
   * @ordered
   */
  protected ASN1_SIMPLE integer;

  /**
   * The cached value of the '{@link #getSequenceOf() <em>Sequence Of</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSequenceOf()
   * @generated
   * @ordered
   */
  protected ASN1_SEQUENCE_OF sequenceOf;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeValueImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SmiPackage.Literals.ATTRIBUTE_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier getIdentifier()
  {
    return identifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIdentifier(Identifier newIdentifier, NotificationChain msgs)
  {
    Identifier oldIdentifier = identifier;
    identifier = newIdentifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER, oldIdentifier, newIdentifier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIdentifier(Identifier newIdentifier)
  {
    if (newIdentifier != identifier)
    {
      NotificationChain msgs = null;
      if (identifier != null)
        msgs = ((InternalEObject)identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER, null, msgs);
      if (newIdentifier != null)
        msgs = ((InternalEObject)newIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER, null, msgs);
      msgs = basicSetIdentifier(newIdentifier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER, newIdentifier, newIdentifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getText()
  {
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setText(String newText)
  {
    String oldText = text;
    text = newText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__TEXT, oldText, text));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable getTypeRef()
  {
    if (typeRef != null && typeRef.eIsProxy())
    {
      InternalEObject oldTypeRef = (InternalEObject)typeRef;
      typeRef = (Referenceable)eResolveProxy(oldTypeRef);
      if (typeRef != oldTypeRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SmiPackage.ATTRIBUTE_VALUE__TYPE_REF, oldTypeRef, typeRef));
      }
    }
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Referenceable basicGetTypeRef()
  {
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeRef(Referenceable newTypeRef)
  {
    Referenceable oldTypeRef = typeRef;
    typeRef = newTypeRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__TYPE_REF, oldTypeRef, typeRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_SIMPLE getSubType()
  {
    return subType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSubType(ASN1_SIMPLE newSubType, NotificationChain msgs)
  {
    ASN1_SIMPLE oldSubType = subType;
    subType = newSubType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE, oldSubType, newSubType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSubType(ASN1_SIMPLE newSubType)
  {
    if (newSubType != subType)
    {
      NotificationChain msgs = null;
      if (subType != null)
        msgs = ((InternalEObject)subType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE, null, msgs);
      if (newSubType != null)
        msgs = ((InternalEObject)newSubType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE, null, msgs);
      msgs = basicSetSubType(newSubType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE, newSubType, newSubType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BracedObjectReference getObjectRef()
  {
    return objectRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetObjectRef(BracedObjectReference newObjectRef, NotificationChain msgs)
  {
    BracedObjectReference oldObjectRef = objectRef;
    objectRef = newObjectRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF, oldObjectRef, newObjectRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObjectRef(BracedObjectReference newObjectRef)
  {
    if (newObjectRef != objectRef)
    {
      NotificationChain msgs = null;
      if (objectRef != null)
        msgs = ((InternalEObject)objectRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF, null, msgs);
      if (newObjectRef != null)
        msgs = ((InternalEObject)newObjectRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF, null, msgs);
      msgs = basicSetObjectRef(newObjectRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF, newObjectRef, newObjectRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_SIMPLE getInteger()
  {
    return integer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInteger(ASN1_SIMPLE newInteger, NotificationChain msgs)
  {
    ASN1_SIMPLE oldInteger = integer;
    integer = newInteger;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__INTEGER, oldInteger, newInteger);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInteger(ASN1_SIMPLE newInteger)
  {
    if (newInteger != integer)
    {
      NotificationChain msgs = null;
      if (integer != null)
        msgs = ((InternalEObject)integer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__INTEGER, null, msgs);
      if (newInteger != null)
        msgs = ((InternalEObject)newInteger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__INTEGER, null, msgs);
      msgs = basicSetInteger(newInteger, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__INTEGER, newInteger, newInteger));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASN1_SEQUENCE_OF getSequenceOf()
  {
    return sequenceOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSequenceOf(ASN1_SEQUENCE_OF newSequenceOf, NotificationChain msgs)
  {
    ASN1_SEQUENCE_OF oldSequenceOf = sequenceOf;
    sequenceOf = newSequenceOf;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF, oldSequenceOf, newSequenceOf);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSequenceOf(ASN1_SEQUENCE_OF newSequenceOf)
  {
    if (newSequenceOf != sequenceOf)
    {
      NotificationChain msgs = null;
      if (sequenceOf != null)
        msgs = ((InternalEObject)sequenceOf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF, null, msgs);
      if (newSequenceOf != null)
        msgs = ((InternalEObject)newSequenceOf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF, null, msgs);
      msgs = basicSetSequenceOf(newSequenceOf, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF, newSequenceOf, newSequenceOf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER:
        return basicSetIdentifier(null, msgs);
      case SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE:
        return basicSetSubType(null, msgs);
      case SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF:
        return basicSetObjectRef(null, msgs);
      case SmiPackage.ATTRIBUTE_VALUE__INTEGER:
        return basicSetInteger(null, msgs);
      case SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF:
        return basicSetSequenceOf(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER:
        return getIdentifier();
      case SmiPackage.ATTRIBUTE_VALUE__TEXT:
        return getText();
      case SmiPackage.ATTRIBUTE_VALUE__TYPE_REF:
        if (resolve) return getTypeRef();
        return basicGetTypeRef();
      case SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE:
        return getSubType();
      case SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF:
        return getObjectRef();
      case SmiPackage.ATTRIBUTE_VALUE__INTEGER:
        return getInteger();
      case SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF:
        return getSequenceOf();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER:
        setIdentifier((Identifier)newValue);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__TEXT:
        setText((String)newValue);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__TYPE_REF:
        setTypeRef((Referenceable)newValue);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE:
        setSubType((ASN1_SIMPLE)newValue);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF:
        setObjectRef((BracedObjectReference)newValue);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__INTEGER:
        setInteger((ASN1_SIMPLE)newValue);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF:
        setSequenceOf((ASN1_SEQUENCE_OF)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER:
        setIdentifier((Identifier)null);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__TEXT:
        setText(TEXT_EDEFAULT);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__TYPE_REF:
        setTypeRef((Referenceable)null);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE:
        setSubType((ASN1_SIMPLE)null);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF:
        setObjectRef((BracedObjectReference)null);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__INTEGER:
        setInteger((ASN1_SIMPLE)null);
        return;
      case SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF:
        setSequenceOf((ASN1_SEQUENCE_OF)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SmiPackage.ATTRIBUTE_VALUE__IDENTIFIER:
        return identifier != null;
      case SmiPackage.ATTRIBUTE_VALUE__TEXT:
        return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
      case SmiPackage.ATTRIBUTE_VALUE__TYPE_REF:
        return typeRef != null;
      case SmiPackage.ATTRIBUTE_VALUE__SUB_TYPE:
        return subType != null;
      case SmiPackage.ATTRIBUTE_VALUE__OBJECT_REF:
        return objectRef != null;
      case SmiPackage.ATTRIBUTE_VALUE__INTEGER:
        return integer != null;
      case SmiPackage.ATTRIBUTE_VALUE__SEQUENCE_OF:
        return sequenceOf != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (text: ");
    result.append(text);
    result.append(')');
    return result.toString();
  }

} //AttributeValueImpl

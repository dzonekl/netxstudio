/**
 */
package com.netxforge.smi.impl;

import com.netxforge.smi.Imports;
import com.netxforge.smi.Macro;
import com.netxforge.smi.Module;
import com.netxforge.smi.ObjectIdentifier;
import com.netxforge.smi.SmiPackage;
import com.netxforge.smi.TypeDefinition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.smi.impl.ModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ModuleImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ModuleImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ModuleImpl#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ModuleImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link com.netxforge.smi.impl.ModuleImpl#getMacros <em>Macros</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends MinimalEObjectImpl.Container implements Module
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImports()
   * @generated
   * @ordered
   */
  protected Imports imports;

  /**
   * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObjects()
   * @generated
   * @ordered
   */
  protected EList<com.netxforge.smi.Object> objects;

  /**
   * The cached value of the '{@link #getIdentifiers() <em>Identifiers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentifiers()
   * @generated
   * @ordered
   */
  protected EList<ObjectIdentifier> identifiers;

  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<TypeDefinition> types;

  /**
   * The cached value of the '{@link #getMacros() <em>Macros</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMacros()
   * @generated
   * @ordered
   */
  protected EList<Macro> macros;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModuleImpl()
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
    return SmiPackage.Literals.MODULE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MODULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Imports getImports()
  {
    return imports;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetImports(Imports newImports, NotificationChain msgs)
  {
    Imports oldImports = imports;
    imports = newImports;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SmiPackage.MODULE__IMPORTS, oldImports, newImports);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImports(Imports newImports)
  {
    if (newImports != imports)
    {
      NotificationChain msgs = null;
      if (imports != null)
        msgs = ((InternalEObject)imports).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MODULE__IMPORTS, null, msgs);
      if (newImports != null)
        msgs = ((InternalEObject)newImports).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SmiPackage.MODULE__IMPORTS, null, msgs);
      msgs = basicSetImports(newImports, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SmiPackage.MODULE__IMPORTS, newImports, newImports));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<com.netxforge.smi.Object> getObjects()
  {
    if (objects == null)
    {
      objects = new EObjectContainmentEList<com.netxforge.smi.Object>(com.netxforge.smi.Object.class, this, SmiPackage.MODULE__OBJECTS);
    }
    return objects;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ObjectIdentifier> getIdentifiers()
  {
    if (identifiers == null)
    {
      identifiers = new EObjectContainmentEList<ObjectIdentifier>(ObjectIdentifier.class, this, SmiPackage.MODULE__IDENTIFIERS);
    }
    return identifiers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TypeDefinition> getTypes()
  {
    if (types == null)
    {
      types = new EObjectContainmentEList<TypeDefinition>(TypeDefinition.class, this, SmiPackage.MODULE__TYPES);
    }
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Macro> getMacros()
  {
    if (macros == null)
    {
      macros = new EObjectContainmentEList<Macro>(Macro.class, this, SmiPackage.MODULE__MACROS);
    }
    return macros;
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
      case SmiPackage.MODULE__IMPORTS:
        return basicSetImports(null, msgs);
      case SmiPackage.MODULE__OBJECTS:
        return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
      case SmiPackage.MODULE__IDENTIFIERS:
        return ((InternalEList<?>)getIdentifiers()).basicRemove(otherEnd, msgs);
      case SmiPackage.MODULE__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
      case SmiPackage.MODULE__MACROS:
        return ((InternalEList<?>)getMacros()).basicRemove(otherEnd, msgs);
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
      case SmiPackage.MODULE__NAME:
        return getName();
      case SmiPackage.MODULE__IMPORTS:
        return getImports();
      case SmiPackage.MODULE__OBJECTS:
        return getObjects();
      case SmiPackage.MODULE__IDENTIFIERS:
        return getIdentifiers();
      case SmiPackage.MODULE__TYPES:
        return getTypes();
      case SmiPackage.MODULE__MACROS:
        return getMacros();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SmiPackage.MODULE__NAME:
        setName((String)newValue);
        return;
      case SmiPackage.MODULE__IMPORTS:
        setImports((Imports)newValue);
        return;
      case SmiPackage.MODULE__OBJECTS:
        getObjects().clear();
        getObjects().addAll((Collection<? extends com.netxforge.smi.Object>)newValue);
        return;
      case SmiPackage.MODULE__IDENTIFIERS:
        getIdentifiers().clear();
        getIdentifiers().addAll((Collection<? extends ObjectIdentifier>)newValue);
        return;
      case SmiPackage.MODULE__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends TypeDefinition>)newValue);
        return;
      case SmiPackage.MODULE__MACROS:
        getMacros().clear();
        getMacros().addAll((Collection<? extends Macro>)newValue);
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
      case SmiPackage.MODULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SmiPackage.MODULE__IMPORTS:
        setImports((Imports)null);
        return;
      case SmiPackage.MODULE__OBJECTS:
        getObjects().clear();
        return;
      case SmiPackage.MODULE__IDENTIFIERS:
        getIdentifiers().clear();
        return;
      case SmiPackage.MODULE__TYPES:
        getTypes().clear();
        return;
      case SmiPackage.MODULE__MACROS:
        getMacros().clear();
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
      case SmiPackage.MODULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SmiPackage.MODULE__IMPORTS:
        return imports != null;
      case SmiPackage.MODULE__OBJECTS:
        return objects != null && !objects.isEmpty();
      case SmiPackage.MODULE__IDENTIFIERS:
        return identifiers != null && !identifiers.isEmpty();
      case SmiPackage.MODULE__TYPES:
        return types != null && !types.isEmpty();
      case SmiPackage.MODULE__MACROS:
        return macros != null && !macros.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ModuleImpl

/**
 */
package tbd.params.xml.ns.yang.network.topology.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import tbd.params.xml.ns.yang.network.topology.TerminationPointType;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Termination Point Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TerminationPointTypeImpl#getTpId <em>Tp Id</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TerminationPointTypeImpl#getTpRef <em>Tp Ref</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.TerminationPointTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TerminationPointTypeImpl extends MinimalEObjectImpl.Container implements TerminationPointType {
	/**
	 * The default value of the '{@link #getTpId() <em>Tp Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTpId()
	 * @generated
	 * @ordered
	 */
	protected static final String TP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTpId() <em>Tp Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTpId()
	 * @generated
	 * @ordered
	 */
	protected String tpId = TP_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTpRef() <em>Tp Ref</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTpRef()
	 * @generated
	 * @ordered
	 */
	protected EList<String> tpRef;

	/**
	 * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAny()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap any;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminationPointTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.TERMINATION_POINT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTpId() {
		return tpId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTpId(String newTpId) {
		String oldTpId = tpId;
		tpId = newTpId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.TERMINATION_POINT_TYPE__TP_ID, oldTpId, tpId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getTpRef() {
		if (tpRef == null) {
			tpRef = new EDataTypeEList<String>(String.class, this, TopologyPackage.TERMINATION_POINT_TYPE__TP_REF);
		}
		return tpRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.TERMINATION_POINT_TYPE__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TopologyPackage.TERMINATION_POINT_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TopologyPackage.TERMINATION_POINT_TYPE__TP_ID:
				return getTpId();
			case TopologyPackage.TERMINATION_POINT_TYPE__TP_REF:
				return getTpRef();
			case TopologyPackage.TERMINATION_POINT_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TopologyPackage.TERMINATION_POINT_TYPE__TP_ID:
				setTpId((String)newValue);
				return;
			case TopologyPackage.TERMINATION_POINT_TYPE__TP_REF:
				getTpRef().clear();
				getTpRef().addAll((Collection<? extends String>)newValue);
				return;
			case TopologyPackage.TERMINATION_POINT_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case TopologyPackage.TERMINATION_POINT_TYPE__TP_ID:
				setTpId(TP_ID_EDEFAULT);
				return;
			case TopologyPackage.TERMINATION_POINT_TYPE__TP_REF:
				getTpRef().clear();
				return;
			case TopologyPackage.TERMINATION_POINT_TYPE__ANY:
				getAny().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TopologyPackage.TERMINATION_POINT_TYPE__TP_ID:
				return TP_ID_EDEFAULT == null ? tpId != null : !TP_ID_EDEFAULT.equals(tpId);
			case TopologyPackage.TERMINATION_POINT_TYPE__TP_REF:
				return tpRef != null && !tpRef.isEmpty();
			case TopologyPackage.TERMINATION_POINT_TYPE__ANY:
				return any != null && !any.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (tpId: ");
		result.append(tpId);
		result.append(", tpRef: ");
		result.append(tpRef);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //TerminationPointTypeImpl

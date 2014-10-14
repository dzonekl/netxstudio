/**
 */
package tbd.params.xml.ns.yang.network.topology.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import tbd.params.xml.ns.yang.network.topology.SourceType;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.SourceTypeImpl#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.SourceTypeImpl#getSourceTp <em>Source Tp</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.SourceTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceTypeImpl extends MinimalEObjectImpl.Container implements SourceType {
	/**
	 * The default value of the '{@link #getSourceNode() <em>Source Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceNode()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_NODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceNode() <em>Source Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceNode()
	 * @generated
	 * @ordered
	 */
	protected String sourceNode = SOURCE_NODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceTp() <em>Source Tp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTp()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_TP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceTp() <em>Source Tp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceTp()
	 * @generated
	 * @ordered
	 */
	protected String sourceTp = SOURCE_TP_EDEFAULT;

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
	protected SourceTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.SOURCE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceNode() {
		return sourceNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceNode(String newSourceNode) {
		String oldSourceNode = sourceNode;
		sourceNode = newSourceNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.SOURCE_TYPE__SOURCE_NODE, oldSourceNode, sourceNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceTp() {
		return sourceTp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceTp(String newSourceTp) {
		String oldSourceTp = sourceTp;
		sourceTp = newSourceTp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.SOURCE_TYPE__SOURCE_TP, oldSourceTp, sourceTp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.SOURCE_TYPE__ANY);
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
			case TopologyPackage.SOURCE_TYPE__ANY:
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
			case TopologyPackage.SOURCE_TYPE__SOURCE_NODE:
				return getSourceNode();
			case TopologyPackage.SOURCE_TYPE__SOURCE_TP:
				return getSourceTp();
			case TopologyPackage.SOURCE_TYPE__ANY:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TopologyPackage.SOURCE_TYPE__SOURCE_NODE:
				setSourceNode((String)newValue);
				return;
			case TopologyPackage.SOURCE_TYPE__SOURCE_TP:
				setSourceTp((String)newValue);
				return;
			case TopologyPackage.SOURCE_TYPE__ANY:
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
			case TopologyPackage.SOURCE_TYPE__SOURCE_NODE:
				setSourceNode(SOURCE_NODE_EDEFAULT);
				return;
			case TopologyPackage.SOURCE_TYPE__SOURCE_TP:
				setSourceTp(SOURCE_TP_EDEFAULT);
				return;
			case TopologyPackage.SOURCE_TYPE__ANY:
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
			case TopologyPackage.SOURCE_TYPE__SOURCE_NODE:
				return SOURCE_NODE_EDEFAULT == null ? sourceNode != null : !SOURCE_NODE_EDEFAULT.equals(sourceNode);
			case TopologyPackage.SOURCE_TYPE__SOURCE_TP:
				return SOURCE_TP_EDEFAULT == null ? sourceTp != null : !SOURCE_TP_EDEFAULT.equals(sourceTp);
			case TopologyPackage.SOURCE_TYPE__ANY:
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
		result.append(" (sourceNode: ");
		result.append(sourceNode);
		result.append(", sourceTp: ");
		result.append(sourceTp);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //SourceTypeImpl

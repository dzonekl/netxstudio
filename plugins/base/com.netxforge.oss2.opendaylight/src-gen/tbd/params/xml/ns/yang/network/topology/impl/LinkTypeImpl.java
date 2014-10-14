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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import tbd.params.xml.ns.yang.network.topology.DestinationType;
import tbd.params.xml.ns.yang.network.topology.LinkType;
import tbd.params.xml.ns.yang.network.topology.SourceType;
import tbd.params.xml.ns.yang.network.topology.SupportingLinkType;
import tbd.params.xml.ns.yang.network.topology.TopologyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl#getLinkId <em>Link Id</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl#getSupportingLink <em>Supporting Link</em>}</li>
 *   <li>{@link tbd.params.xml.ns.yang.network.topology.impl.LinkTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkTypeImpl extends MinimalEObjectImpl.Container implements LinkType {
	/**
	 * The default value of the '{@link #getLinkId() <em>Link Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkId()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkId() <em>Link Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkId()
	 * @generated
	 * @ordered
	 */
	protected String linkId = LINK_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected SourceType source;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected DestinationType destination;

	/**
	 * The cached value of the '{@link #getSupportingLink() <em>Supporting Link</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportingLink()
	 * @generated
	 * @ordered
	 */
	protected EList<SupportingLinkType> supportingLink;

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
	protected LinkTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TopologyPackage.Literals.LINK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkId() {
		return linkId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkId(String newLinkId) {
		String oldLinkId = linkId;
		linkId = newLinkId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.LINK_TYPE__LINK_ID, oldLinkId, linkId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceType getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(SourceType newSource, NotificationChain msgs) {
		SourceType oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TopologyPackage.LINK_TYPE__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(SourceType newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.LINK_TYPE__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.LINK_TYPE__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.LINK_TYPE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DestinationType getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(DestinationType newDestination, NotificationChain msgs) {
		DestinationType oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TopologyPackage.LINK_TYPE__DESTINATION, oldDestination, newDestination);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(DestinationType newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject)destination).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.LINK_TYPE__DESTINATION, null, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject)newDestination).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TopologyPackage.LINK_TYPE__DESTINATION, null, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TopologyPackage.LINK_TYPE__DESTINATION, newDestination, newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupportingLinkType> getSupportingLink() {
		if (supportingLink == null) {
			supportingLink = new EObjectContainmentEList<SupportingLinkType>(SupportingLinkType.class, this, TopologyPackage.LINK_TYPE__SUPPORTING_LINK);
		}
		return supportingLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, TopologyPackage.LINK_TYPE__ANY);
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
			case TopologyPackage.LINK_TYPE__SOURCE:
				return basicSetSource(null, msgs);
			case TopologyPackage.LINK_TYPE__DESTINATION:
				return basicSetDestination(null, msgs);
			case TopologyPackage.LINK_TYPE__SUPPORTING_LINK:
				return ((InternalEList<?>)getSupportingLink()).basicRemove(otherEnd, msgs);
			case TopologyPackage.LINK_TYPE__ANY:
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
			case TopologyPackage.LINK_TYPE__LINK_ID:
				return getLinkId();
			case TopologyPackage.LINK_TYPE__SOURCE:
				return getSource();
			case TopologyPackage.LINK_TYPE__DESTINATION:
				return getDestination();
			case TopologyPackage.LINK_TYPE__SUPPORTING_LINK:
				return getSupportingLink();
			case TopologyPackage.LINK_TYPE__ANY:
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
			case TopologyPackage.LINK_TYPE__LINK_ID:
				setLinkId((String)newValue);
				return;
			case TopologyPackage.LINK_TYPE__SOURCE:
				setSource((SourceType)newValue);
				return;
			case TopologyPackage.LINK_TYPE__DESTINATION:
				setDestination((DestinationType)newValue);
				return;
			case TopologyPackage.LINK_TYPE__SUPPORTING_LINK:
				getSupportingLink().clear();
				getSupportingLink().addAll((Collection<? extends SupportingLinkType>)newValue);
				return;
			case TopologyPackage.LINK_TYPE__ANY:
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
			case TopologyPackage.LINK_TYPE__LINK_ID:
				setLinkId(LINK_ID_EDEFAULT);
				return;
			case TopologyPackage.LINK_TYPE__SOURCE:
				setSource((SourceType)null);
				return;
			case TopologyPackage.LINK_TYPE__DESTINATION:
				setDestination((DestinationType)null);
				return;
			case TopologyPackage.LINK_TYPE__SUPPORTING_LINK:
				getSupportingLink().clear();
				return;
			case TopologyPackage.LINK_TYPE__ANY:
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
			case TopologyPackage.LINK_TYPE__LINK_ID:
				return LINK_ID_EDEFAULT == null ? linkId != null : !LINK_ID_EDEFAULT.equals(linkId);
			case TopologyPackage.LINK_TYPE__SOURCE:
				return source != null;
			case TopologyPackage.LINK_TYPE__DESTINATION:
				return destination != null;
			case TopologyPackage.LINK_TYPE__SUPPORTING_LINK:
				return supportingLink != null && !supportingLink.isEmpty();
			case TopologyPackage.LINK_TYPE__ANY:
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
		result.append(" (linkId: ");
		result.append(linkId);
		result.append(", any: ");
		result.append(any);
		result.append(')');
		return result.toString();
	}

} //LinkTypeImpl

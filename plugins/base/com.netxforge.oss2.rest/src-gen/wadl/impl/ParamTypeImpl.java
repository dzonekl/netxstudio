/**
 */
package wadl.impl;

import java.util.Collection;

import javax.xml.namespace.QName;

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

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import wadl.DocType;
import wadl.LinkType;
import wadl.OptionType;
import wadl.ParamStyle;
import wadl.ParamType;
import wadl.WadlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Param Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link wadl.impl.ParamTypeImpl#getDoc <em>Doc</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getOption <em>Option</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getLink <em>Link</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getDefault <em>Default</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getFixed <em>Fixed</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getHref <em>Href</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getPath <em>Path</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#isRepeating <em>Repeating</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link wadl.impl.ParamTypeImpl#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParamTypeImpl extends MinimalEObjectImpl.Container implements ParamType {
	/**
	 * The cached value of the '{@link #getDoc() <em>Doc</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoc()
	 * @generated
	 * @ordered
	 */
	protected EList<DocType> doc;

	/**
	 * The cached value of the '{@link #getOption() <em>Option</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOption()
	 * @generated
	 * @ordered
	 */
	protected EList<OptionType> option;

	/**
	 * The cached value of the '{@link #getLink() <em>Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLink()
	 * @generated
	 * @ordered
	 */
	protected LinkType link;

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
	 * The default value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefault() <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefault()
	 * @generated
	 * @ordered
	 */
	protected String default_ = DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixed() <em>Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixed()
	 * @generated
	 * @ordered
	 */
	protected static final String FIXED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFixed() <em>Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixed()
	 * @generated
	 * @ordered
	 */
	protected String fixed = FIXED_EDEFAULT;

	/**
	 * The default value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected static final String HREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHref() <em>Href</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHref()
	 * @generated
	 * @ordered
	 */
	protected String href = HREF_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #isRepeating() <em>Repeating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRepeating()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REPEATING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRepeating() <em>Repeating</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRepeating()
	 * @generated
	 * @ordered
	 */
	protected boolean repeating = REPEATING_EDEFAULT;

	/**
	 * This is true if the Repeating attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean repeatingESet;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * This is true if the Required attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean requiredESet;

	/**
	 * The default value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected static final ParamStyle STYLE_EDEFAULT = ParamStyle.PLAIN;

	/**
	 * The cached value of the '{@link #getStyle() <em>Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected ParamStyle style = STYLE_EDEFAULT;

	/**
	 * This is true if the Style attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean styleESet;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final QName TYPE_EDEFAULT = (QName)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.eINSTANCE.getQName(), "xs:string");

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected QName type = TYPE_EDEFAULT;

	/**
	 * This is true if the Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean typeESet;

	/**
	 * The cached value of the '{@link #getAnyAttribute() <em>Any Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnyAttribute()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap anyAttribute;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParamTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WadlPackage.Literals.PARAM_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DocType> getDoc() {
		if (doc == null) {
			doc = new EObjectContainmentEList<DocType>(DocType.class, this, WadlPackage.PARAM_TYPE__DOC);
		}
		return doc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OptionType> getOption() {
		if (option == null) {
			option = new EObjectContainmentEList<OptionType>(OptionType.class, this, WadlPackage.PARAM_TYPE__OPTION);
		}
		return option;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkType getLink() {
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLink(LinkType newLink, NotificationChain msgs) {
		LinkType oldLink = link;
		link = newLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__LINK, oldLink, newLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLink(LinkType newLink) {
		if (newLink != link) {
			NotificationChain msgs = null;
			if (link != null)
				msgs = ((InternalEObject)link).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WadlPackage.PARAM_TYPE__LINK, null, msgs);
			if (newLink != null)
				msgs = ((InternalEObject)newLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WadlPackage.PARAM_TYPE__LINK, null, msgs);
			msgs = basicSetLink(newLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__LINK, newLink, newLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		if (any == null) {
			any = new BasicFeatureMap(this, WadlPackage.PARAM_TYPE__ANY);
		}
		return any;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefault() {
		return default_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(String newDefault) {
		String oldDefault = default_;
		default_ = newDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__DEFAULT, oldDefault, default_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFixed() {
		return fixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixed(String newFixed) {
		String oldFixed = fixed;
		fixed = newFixed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__FIXED, oldFixed, fixed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHref() {
		return href;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHref(String newHref) {
		String oldHref = href;
		href = newHref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__HREF, oldHref, href));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRepeating() {
		return repeating;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeating(boolean newRepeating) {
		boolean oldRepeating = repeating;
		repeating = newRepeating;
		boolean oldRepeatingESet = repeatingESet;
		repeatingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__REPEATING, oldRepeating, repeating, !oldRepeatingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRepeating() {
		boolean oldRepeating = repeating;
		boolean oldRepeatingESet = repeatingESet;
		repeating = REPEATING_EDEFAULT;
		repeatingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WadlPackage.PARAM_TYPE__REPEATING, oldRepeating, REPEATING_EDEFAULT, oldRepeatingESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRepeating() {
		return repeatingESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		boolean oldRequiredESet = requiredESet;
		requiredESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__REQUIRED, oldRequired, required, !oldRequiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRequired() {
		boolean oldRequired = required;
		boolean oldRequiredESet = requiredESet;
		required = REQUIRED_EDEFAULT;
		requiredESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WadlPackage.PARAM_TYPE__REQUIRED, oldRequired, REQUIRED_EDEFAULT, oldRequiredESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRequired() {
		return requiredESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamStyle getStyle() {
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyle(ParamStyle newStyle) {
		ParamStyle oldStyle = style;
		style = newStyle == null ? STYLE_EDEFAULT : newStyle;
		boolean oldStyleESet = styleESet;
		styleESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__STYLE, oldStyle, style, !oldStyleESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStyle() {
		ParamStyle oldStyle = style;
		boolean oldStyleESet = styleESet;
		style = STYLE_EDEFAULT;
		styleESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WadlPackage.PARAM_TYPE__STYLE, oldStyle, STYLE_EDEFAULT, oldStyleESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStyle() {
		return styleESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(QName newType) {
		QName oldType = type;
		type = newType;
		boolean oldTypeESet = typeESet;
		typeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WadlPackage.PARAM_TYPE__TYPE, oldType, type, !oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetType() {
		QName oldType = type;
		boolean oldTypeESet = typeESet;
		type = TYPE_EDEFAULT;
		typeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WadlPackage.PARAM_TYPE__TYPE, oldType, TYPE_EDEFAULT, oldTypeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return typeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAnyAttribute() {
		if (anyAttribute == null) {
			anyAttribute = new BasicFeatureMap(this, WadlPackage.PARAM_TYPE__ANY_ATTRIBUTE);
		}
		return anyAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WadlPackage.PARAM_TYPE__DOC:
				return ((InternalEList<?>)getDoc()).basicRemove(otherEnd, msgs);
			case WadlPackage.PARAM_TYPE__OPTION:
				return ((InternalEList<?>)getOption()).basicRemove(otherEnd, msgs);
			case WadlPackage.PARAM_TYPE__LINK:
				return basicSetLink(null, msgs);
			case WadlPackage.PARAM_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
			case WadlPackage.PARAM_TYPE__ANY_ATTRIBUTE:
				return ((InternalEList<?>)getAnyAttribute()).basicRemove(otherEnd, msgs);
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
			case WadlPackage.PARAM_TYPE__DOC:
				return getDoc();
			case WadlPackage.PARAM_TYPE__OPTION:
				return getOption();
			case WadlPackage.PARAM_TYPE__LINK:
				return getLink();
			case WadlPackage.PARAM_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case WadlPackage.PARAM_TYPE__DEFAULT:
				return getDefault();
			case WadlPackage.PARAM_TYPE__FIXED:
				return getFixed();
			case WadlPackage.PARAM_TYPE__HREF:
				return getHref();
			case WadlPackage.PARAM_TYPE__ID:
				return getId();
			case WadlPackage.PARAM_TYPE__NAME:
				return getName();
			case WadlPackage.PARAM_TYPE__PATH:
				return getPath();
			case WadlPackage.PARAM_TYPE__REPEATING:
				return isRepeating();
			case WadlPackage.PARAM_TYPE__REQUIRED:
				return isRequired();
			case WadlPackage.PARAM_TYPE__STYLE:
				return getStyle();
			case WadlPackage.PARAM_TYPE__TYPE:
				return getType();
			case WadlPackage.PARAM_TYPE__ANY_ATTRIBUTE:
				if (coreType) return getAnyAttribute();
				return ((FeatureMap.Internal)getAnyAttribute()).getWrapper();
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
			case WadlPackage.PARAM_TYPE__DOC:
				getDoc().clear();
				getDoc().addAll((Collection<? extends DocType>)newValue);
				return;
			case WadlPackage.PARAM_TYPE__OPTION:
				getOption().clear();
				getOption().addAll((Collection<? extends OptionType>)newValue);
				return;
			case WadlPackage.PARAM_TYPE__LINK:
				setLink((LinkType)newValue);
				return;
			case WadlPackage.PARAM_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case WadlPackage.PARAM_TYPE__DEFAULT:
				setDefault((String)newValue);
				return;
			case WadlPackage.PARAM_TYPE__FIXED:
				setFixed((String)newValue);
				return;
			case WadlPackage.PARAM_TYPE__HREF:
				setHref((String)newValue);
				return;
			case WadlPackage.PARAM_TYPE__ID:
				setId((String)newValue);
				return;
			case WadlPackage.PARAM_TYPE__NAME:
				setName((String)newValue);
				return;
			case WadlPackage.PARAM_TYPE__PATH:
				setPath((String)newValue);
				return;
			case WadlPackage.PARAM_TYPE__REPEATING:
				setRepeating((Boolean)newValue);
				return;
			case WadlPackage.PARAM_TYPE__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case WadlPackage.PARAM_TYPE__STYLE:
				setStyle((ParamStyle)newValue);
				return;
			case WadlPackage.PARAM_TYPE__TYPE:
				setType((QName)newValue);
				return;
			case WadlPackage.PARAM_TYPE__ANY_ATTRIBUTE:
				((FeatureMap.Internal)getAnyAttribute()).set(newValue);
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
			case WadlPackage.PARAM_TYPE__DOC:
				getDoc().clear();
				return;
			case WadlPackage.PARAM_TYPE__OPTION:
				getOption().clear();
				return;
			case WadlPackage.PARAM_TYPE__LINK:
				setLink((LinkType)null);
				return;
			case WadlPackage.PARAM_TYPE__ANY:
				getAny().clear();
				return;
			case WadlPackage.PARAM_TYPE__DEFAULT:
				setDefault(DEFAULT_EDEFAULT);
				return;
			case WadlPackage.PARAM_TYPE__FIXED:
				setFixed(FIXED_EDEFAULT);
				return;
			case WadlPackage.PARAM_TYPE__HREF:
				setHref(HREF_EDEFAULT);
				return;
			case WadlPackage.PARAM_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case WadlPackage.PARAM_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WadlPackage.PARAM_TYPE__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case WadlPackage.PARAM_TYPE__REPEATING:
				unsetRepeating();
				return;
			case WadlPackage.PARAM_TYPE__REQUIRED:
				unsetRequired();
				return;
			case WadlPackage.PARAM_TYPE__STYLE:
				unsetStyle();
				return;
			case WadlPackage.PARAM_TYPE__TYPE:
				unsetType();
				return;
			case WadlPackage.PARAM_TYPE__ANY_ATTRIBUTE:
				getAnyAttribute().clear();
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
			case WadlPackage.PARAM_TYPE__DOC:
				return doc != null && !doc.isEmpty();
			case WadlPackage.PARAM_TYPE__OPTION:
				return option != null && !option.isEmpty();
			case WadlPackage.PARAM_TYPE__LINK:
				return link != null;
			case WadlPackage.PARAM_TYPE__ANY:
				return any != null && !any.isEmpty();
			case WadlPackage.PARAM_TYPE__DEFAULT:
				return DEFAULT_EDEFAULT == null ? default_ != null : !DEFAULT_EDEFAULT.equals(default_);
			case WadlPackage.PARAM_TYPE__FIXED:
				return FIXED_EDEFAULT == null ? fixed != null : !FIXED_EDEFAULT.equals(fixed);
			case WadlPackage.PARAM_TYPE__HREF:
				return HREF_EDEFAULT == null ? href != null : !HREF_EDEFAULT.equals(href);
			case WadlPackage.PARAM_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case WadlPackage.PARAM_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WadlPackage.PARAM_TYPE__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case WadlPackage.PARAM_TYPE__REPEATING:
				return isSetRepeating();
			case WadlPackage.PARAM_TYPE__REQUIRED:
				return isSetRequired();
			case WadlPackage.PARAM_TYPE__STYLE:
				return isSetStyle();
			case WadlPackage.PARAM_TYPE__TYPE:
				return isSetType();
			case WadlPackage.PARAM_TYPE__ANY_ATTRIBUTE:
				return anyAttribute != null && !anyAttribute.isEmpty();
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
		result.append(" (any: ");
		result.append(any);
		result.append(", default: ");
		result.append(default_);
		result.append(", fixed: ");
		result.append(fixed);
		result.append(", href: ");
		result.append(href);
		result.append(", id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", path: ");
		result.append(path);
		result.append(", repeating: ");
		if (repeatingESet) result.append(repeating); else result.append("<unset>");
		result.append(", required: ");
		if (requiredESet) result.append(required); else result.append("<unset>");
		result.append(", style: ");
		if (styleESet) result.append(style); else result.append("<unset>");
		result.append(", type: ");
		if (typeESet) result.append(type); else result.append("<unset>");
		result.append(", anyAttribute: ");
		result.append(anyAttribute);
		result.append(')');
		return result.toString();
	}

} //ParamTypeImpl

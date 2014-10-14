/**
 */
package wadl.impl;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import wadl.ApplicationType;
import wadl.DocType;
import wadl.DocumentRoot;
import wadl.GrammarsType;
import wadl.HTTPMethods;
import wadl.IncludeType;
import wadl.LinkType;
import wadl.MethodType;
import wadl.OptionType;
import wadl.ParamStyle;
import wadl.ParamType;
import wadl.RepresentationType;
import wadl.RequestType;
import wadl.ResourceType;
import wadl.ResourceTypeType;
import wadl.ResourcesType;
import wadl.ResponseType;
import wadl.WadlFactory;
import wadl.WadlPackage;

import wadl.util.WadlValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WadlPackageImpl extends EPackageImpl implements WadlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass docTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass grammarsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass includeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paramTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass representationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourcesTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceTypeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responseTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum httpMethodsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum paramStyleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType httpMethodsObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType methodEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType paramStyleObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resourceTypeListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType statusCodeListEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriListEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see wadl.WadlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WadlPackageImpl() {
		super(eNS_URI, WadlFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link WadlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WadlPackage init() {
		if (isInited) return (WadlPackage)EPackage.Registry.INSTANCE.getEPackage(WadlPackage.eNS_URI);

		// Obtain or create and register package
		WadlPackageImpl theWadlPackage = (WadlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WadlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WadlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLNamespacePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWadlPackage.createPackageContents();

		// Initialize created meta-data
		theWadlPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theWadlPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return WadlValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theWadlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WadlPackage.eNS_URI, theWadlPackage);
		return theWadlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationType() {
		return applicationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationType_Doc() {
		return (EReference)applicationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationType_Grammars() {
		return (EReference)applicationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationType_Resources() {
		return (EReference)applicationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationType_Group() {
		return (EAttribute)applicationTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationType_ResourceType() {
		return (EReference)applicationTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationType_Method() {
		return (EReference)applicationTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationType_Representation() {
		return (EReference)applicationTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationType_Param() {
		return (EReference)applicationTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getApplicationType_Any() {
		return (EAttribute)applicationTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocType() {
		return docTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocType_Mixed() {
		return (EAttribute)docTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocType_Any() {
		return (EAttribute)docTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocType_Lang() {
		return (EAttribute)docTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocType_Title() {
		return (EAttribute)docTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocType_AnyAttribute() {
		return (EAttribute)docTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Application() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Doc() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Grammars() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Include() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Link() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Method() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Option() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Param() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Representation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Request() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Resource() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_ResourceType() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Resources() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Response() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGrammarsType() {
		return grammarsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGrammarsType_Doc() {
		return (EReference)grammarsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGrammarsType_Include() {
		return (EReference)grammarsTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGrammarsType_Any() {
		return (EAttribute)grammarsTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncludeType() {
		return includeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIncludeType_Doc() {
		return (EReference)includeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncludeType_Href() {
		return (EAttribute)includeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIncludeType_AnyAttribute() {
		return (EAttribute)includeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkType() {
		return linkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkType_Doc() {
		return (EReference)linkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Any() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Rel() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_ResourceType() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Rev() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_AnyAttribute() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodType() {
		return methodTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodType_Doc() {
		return (EReference)methodTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodType_Request() {
		return (EReference)methodTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodType_Response() {
		return (EReference)methodTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodType_Any() {
		return (EAttribute)methodTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodType_Href() {
		return (EAttribute)methodTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodType_Id() {
		return (EAttribute)methodTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodType_Name() {
		return (EAttribute)methodTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethodType_AnyAttribute() {
		return (EAttribute)methodTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptionType() {
		return optionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOptionType_Doc() {
		return (EReference)optionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptionType_Any() {
		return (EAttribute)optionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptionType_MediaType() {
		return (EAttribute)optionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptionType_Value() {
		return (EAttribute)optionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOptionType_AnyAttribute() {
		return (EAttribute)optionTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParamType() {
		return paramTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParamType_Doc() {
		return (EReference)paramTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParamType_Option() {
		return (EReference)paramTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParamType_Link() {
		return (EReference)paramTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Any() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Default() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Fixed() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Href() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Id() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Name() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Path() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Repeating() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Required() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Style() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_Type() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParamType_AnyAttribute() {
		return (EAttribute)paramTypeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepresentationType() {
		return representationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepresentationType_Doc() {
		return (EReference)representationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRepresentationType_Param() {
		return (EReference)representationTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationType_Any() {
		return (EAttribute)representationTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationType_Element() {
		return (EAttribute)representationTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationType_Href() {
		return (EAttribute)representationTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationType_Id() {
		return (EAttribute)representationTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationType_MediaType() {
		return (EAttribute)representationTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationType_Profile() {
		return (EAttribute)representationTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepresentationType_AnyAttribute() {
		return (EAttribute)representationTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequestType() {
		return requestTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequestType_Doc() {
		return (EReference)requestTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequestType_Param() {
		return (EReference)requestTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequestType_Representation() {
		return (EReference)requestTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestType_Any() {
		return (EAttribute)requestTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRequestType_AnyAttribute() {
		return (EAttribute)requestTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourcesType() {
		return resourcesTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourcesType_Doc() {
		return (EReference)resourcesTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourcesType_Resource() {
		return (EReference)resourcesTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcesType_Any() {
		return (EAttribute)resourcesTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcesType_Base() {
		return (EAttribute)resourcesTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcesType_AnyAttribute() {
		return (EAttribute)resourcesTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceType() {
		return resourceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_Doc() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_Param() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Group() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_Method() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceType_Resource() {
		return (EReference)resourceTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Any() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Id() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Path() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_QueryType() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_Type() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceType_AnyAttribute() {
		return (EAttribute)resourceTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceTypeType() {
		return resourceTypeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceTypeType_Doc() {
		return (EReference)resourceTypeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceTypeType_Param() {
		return (EReference)resourceTypeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTypeType_Group() {
		return (EAttribute)resourceTypeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceTypeType_Method() {
		return (EReference)resourceTypeTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceTypeType_Resource() {
		return (EReference)resourceTypeTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTypeType_Any() {
		return (EAttribute)resourceTypeTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTypeType_Id() {
		return (EAttribute)resourceTypeTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceTypeType_AnyAttribute() {
		return (EAttribute)resourceTypeTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponseType() {
		return responseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponseType_Doc() {
		return (EReference)responseTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponseType_Param() {
		return (EReference)responseTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResponseType_Representation() {
		return (EReference)responseTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponseType_Any() {
		return (EAttribute)responseTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponseType_Status() {
		return (EAttribute)responseTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponseType_AnyAttribute() {
		return (EAttribute)responseTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHTTPMethods() {
		return httpMethodsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParamStyle() {
		return paramStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHTTPMethodsObject() {
		return httpMethodsObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMethod() {
		return methodEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getParamStyleObject() {
		return paramStyleObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getResourceTypeList() {
		return resourceTypeListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStatusCodeList() {
		return statusCodeListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUriList() {
		return uriListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WadlFactory getWadlFactory() {
		return (WadlFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		applicationTypeEClass = createEClass(APPLICATION_TYPE);
		createEReference(applicationTypeEClass, APPLICATION_TYPE__DOC);
		createEReference(applicationTypeEClass, APPLICATION_TYPE__GRAMMARS);
		createEReference(applicationTypeEClass, APPLICATION_TYPE__RESOURCES);
		createEAttribute(applicationTypeEClass, APPLICATION_TYPE__GROUP);
		createEReference(applicationTypeEClass, APPLICATION_TYPE__RESOURCE_TYPE);
		createEReference(applicationTypeEClass, APPLICATION_TYPE__METHOD);
		createEReference(applicationTypeEClass, APPLICATION_TYPE__REPRESENTATION);
		createEReference(applicationTypeEClass, APPLICATION_TYPE__PARAM);
		createEAttribute(applicationTypeEClass, APPLICATION_TYPE__ANY);

		docTypeEClass = createEClass(DOC_TYPE);
		createEAttribute(docTypeEClass, DOC_TYPE__MIXED);
		createEAttribute(docTypeEClass, DOC_TYPE__ANY);
		createEAttribute(docTypeEClass, DOC_TYPE__LANG);
		createEAttribute(docTypeEClass, DOC_TYPE__TITLE);
		createEAttribute(docTypeEClass, DOC_TYPE__ANY_ATTRIBUTE);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__APPLICATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DOC);
		createEReference(documentRootEClass, DOCUMENT_ROOT__GRAMMARS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__INCLUDE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__LINK);
		createEReference(documentRootEClass, DOCUMENT_ROOT__METHOD);
		createEReference(documentRootEClass, DOCUMENT_ROOT__OPTION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PARAM);
		createEReference(documentRootEClass, DOCUMENT_ROOT__REPRESENTATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__REQUEST);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCE_TYPE);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESOURCES);
		createEReference(documentRootEClass, DOCUMENT_ROOT__RESPONSE);

		grammarsTypeEClass = createEClass(GRAMMARS_TYPE);
		createEReference(grammarsTypeEClass, GRAMMARS_TYPE__DOC);
		createEReference(grammarsTypeEClass, GRAMMARS_TYPE__INCLUDE);
		createEAttribute(grammarsTypeEClass, GRAMMARS_TYPE__ANY);

		includeTypeEClass = createEClass(INCLUDE_TYPE);
		createEReference(includeTypeEClass, INCLUDE_TYPE__DOC);
		createEAttribute(includeTypeEClass, INCLUDE_TYPE__HREF);
		createEAttribute(includeTypeEClass, INCLUDE_TYPE__ANY_ATTRIBUTE);

		linkTypeEClass = createEClass(LINK_TYPE);
		createEReference(linkTypeEClass, LINK_TYPE__DOC);
		createEAttribute(linkTypeEClass, LINK_TYPE__ANY);
		createEAttribute(linkTypeEClass, LINK_TYPE__REL);
		createEAttribute(linkTypeEClass, LINK_TYPE__RESOURCE_TYPE);
		createEAttribute(linkTypeEClass, LINK_TYPE__REV);
		createEAttribute(linkTypeEClass, LINK_TYPE__ANY_ATTRIBUTE);

		methodTypeEClass = createEClass(METHOD_TYPE);
		createEReference(methodTypeEClass, METHOD_TYPE__DOC);
		createEReference(methodTypeEClass, METHOD_TYPE__REQUEST);
		createEReference(methodTypeEClass, METHOD_TYPE__RESPONSE);
		createEAttribute(methodTypeEClass, METHOD_TYPE__ANY);
		createEAttribute(methodTypeEClass, METHOD_TYPE__HREF);
		createEAttribute(methodTypeEClass, METHOD_TYPE__ID);
		createEAttribute(methodTypeEClass, METHOD_TYPE__NAME);
		createEAttribute(methodTypeEClass, METHOD_TYPE__ANY_ATTRIBUTE);

		optionTypeEClass = createEClass(OPTION_TYPE);
		createEReference(optionTypeEClass, OPTION_TYPE__DOC);
		createEAttribute(optionTypeEClass, OPTION_TYPE__ANY);
		createEAttribute(optionTypeEClass, OPTION_TYPE__MEDIA_TYPE);
		createEAttribute(optionTypeEClass, OPTION_TYPE__VALUE);
		createEAttribute(optionTypeEClass, OPTION_TYPE__ANY_ATTRIBUTE);

		paramTypeEClass = createEClass(PARAM_TYPE);
		createEReference(paramTypeEClass, PARAM_TYPE__DOC);
		createEReference(paramTypeEClass, PARAM_TYPE__OPTION);
		createEReference(paramTypeEClass, PARAM_TYPE__LINK);
		createEAttribute(paramTypeEClass, PARAM_TYPE__ANY);
		createEAttribute(paramTypeEClass, PARAM_TYPE__DEFAULT);
		createEAttribute(paramTypeEClass, PARAM_TYPE__FIXED);
		createEAttribute(paramTypeEClass, PARAM_TYPE__HREF);
		createEAttribute(paramTypeEClass, PARAM_TYPE__ID);
		createEAttribute(paramTypeEClass, PARAM_TYPE__NAME);
		createEAttribute(paramTypeEClass, PARAM_TYPE__PATH);
		createEAttribute(paramTypeEClass, PARAM_TYPE__REPEATING);
		createEAttribute(paramTypeEClass, PARAM_TYPE__REQUIRED);
		createEAttribute(paramTypeEClass, PARAM_TYPE__STYLE);
		createEAttribute(paramTypeEClass, PARAM_TYPE__TYPE);
		createEAttribute(paramTypeEClass, PARAM_TYPE__ANY_ATTRIBUTE);

		representationTypeEClass = createEClass(REPRESENTATION_TYPE);
		createEReference(representationTypeEClass, REPRESENTATION_TYPE__DOC);
		createEReference(representationTypeEClass, REPRESENTATION_TYPE__PARAM);
		createEAttribute(representationTypeEClass, REPRESENTATION_TYPE__ANY);
		createEAttribute(representationTypeEClass, REPRESENTATION_TYPE__ELEMENT);
		createEAttribute(representationTypeEClass, REPRESENTATION_TYPE__HREF);
		createEAttribute(representationTypeEClass, REPRESENTATION_TYPE__ID);
		createEAttribute(representationTypeEClass, REPRESENTATION_TYPE__MEDIA_TYPE);
		createEAttribute(representationTypeEClass, REPRESENTATION_TYPE__PROFILE);
		createEAttribute(representationTypeEClass, REPRESENTATION_TYPE__ANY_ATTRIBUTE);

		requestTypeEClass = createEClass(REQUEST_TYPE);
		createEReference(requestTypeEClass, REQUEST_TYPE__DOC);
		createEReference(requestTypeEClass, REQUEST_TYPE__PARAM);
		createEReference(requestTypeEClass, REQUEST_TYPE__REPRESENTATION);
		createEAttribute(requestTypeEClass, REQUEST_TYPE__ANY);
		createEAttribute(requestTypeEClass, REQUEST_TYPE__ANY_ATTRIBUTE);

		resourcesTypeEClass = createEClass(RESOURCES_TYPE);
		createEReference(resourcesTypeEClass, RESOURCES_TYPE__DOC);
		createEReference(resourcesTypeEClass, RESOURCES_TYPE__RESOURCE);
		createEAttribute(resourcesTypeEClass, RESOURCES_TYPE__ANY);
		createEAttribute(resourcesTypeEClass, RESOURCES_TYPE__BASE);
		createEAttribute(resourcesTypeEClass, RESOURCES_TYPE__ANY_ATTRIBUTE);

		resourceTypeEClass = createEClass(RESOURCE_TYPE);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__DOC);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__PARAM);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__GROUP);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__METHOD);
		createEReference(resourceTypeEClass, RESOURCE_TYPE__RESOURCE);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__ANY);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__ID);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__PATH);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__QUERY_TYPE);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__TYPE);
		createEAttribute(resourceTypeEClass, RESOURCE_TYPE__ANY_ATTRIBUTE);

		resourceTypeTypeEClass = createEClass(RESOURCE_TYPE_TYPE);
		createEReference(resourceTypeTypeEClass, RESOURCE_TYPE_TYPE__DOC);
		createEReference(resourceTypeTypeEClass, RESOURCE_TYPE_TYPE__PARAM);
		createEAttribute(resourceTypeTypeEClass, RESOURCE_TYPE_TYPE__GROUP);
		createEReference(resourceTypeTypeEClass, RESOURCE_TYPE_TYPE__METHOD);
		createEReference(resourceTypeTypeEClass, RESOURCE_TYPE_TYPE__RESOURCE);
		createEAttribute(resourceTypeTypeEClass, RESOURCE_TYPE_TYPE__ANY);
		createEAttribute(resourceTypeTypeEClass, RESOURCE_TYPE_TYPE__ID);
		createEAttribute(resourceTypeTypeEClass, RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE);

		responseTypeEClass = createEClass(RESPONSE_TYPE);
		createEReference(responseTypeEClass, RESPONSE_TYPE__DOC);
		createEReference(responseTypeEClass, RESPONSE_TYPE__PARAM);
		createEReference(responseTypeEClass, RESPONSE_TYPE__REPRESENTATION);
		createEAttribute(responseTypeEClass, RESPONSE_TYPE__ANY);
		createEAttribute(responseTypeEClass, RESPONSE_TYPE__STATUS);
		createEAttribute(responseTypeEClass, RESPONSE_TYPE__ANY_ATTRIBUTE);

		// Create enums
		httpMethodsEEnum = createEEnum(HTTP_METHODS);
		paramStyleEEnum = createEEnum(PARAM_STYLE);

		// Create data types
		httpMethodsObjectEDataType = createEDataType(HTTP_METHODS_OBJECT);
		methodEDataType = createEDataType(METHOD);
		paramStyleObjectEDataType = createEDataType(PARAM_STYLE_OBJECT);
		resourceTypeListEDataType = createEDataType(RESOURCE_TYPE_LIST);
		statusCodeListEDataType = createEDataType(STATUS_CODE_LIST);
		uriListEDataType = createEDataType(URI_LIST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLNamespacePackage theXMLNamespacePackage = (XMLNamespacePackage)EPackage.Registry.INSTANCE.getEPackage(XMLNamespacePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(applicationTypeEClass, ApplicationType.class, "ApplicationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplicationType_Doc(), this.getDocType(), null, "doc", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationType_Grammars(), this.getGrammarsType(), null, "grammars", null, 0, 1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationType_Resources(), this.getResourcesType(), null, "resources", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationType_ResourceType(), this.getResourceTypeType(), null, "resourceType", null, 0, -1, ApplicationType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationType_Method(), this.getMethodType(), null, "method", null, 0, -1, ApplicationType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationType_Representation(), this.getRepresentationType(), null, "representation", null, 0, -1, ApplicationType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getApplicationType_Param(), this.getParamType(), null, "param", null, 0, -1, ApplicationType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getApplicationType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ApplicationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(docTypeEClass, DocType.class, "DocType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocType_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, DocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, DocType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocType_Lang(), theXMLNamespacePackage.getLangType(), "lang", null, 0, 1, DocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocType_Title(), theXMLTypePackage.getString(), "title", null, 0, 1, DocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, DocType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Application(), this.getApplicationType(), null, "application", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Doc(), this.getDocType(), null, "doc", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Grammars(), this.getGrammarsType(), null, "grammars", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Include(), this.getIncludeType(), null, "include", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Link(), this.getLinkType(), null, "link", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Method(), this.getMethodType(), null, "method", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Option(), this.getOptionType(), null, "option", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Param(), this.getParamType(), null, "param", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Representation(), this.getRepresentationType(), null, "representation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Request(), this.getRequestType(), null, "request", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Resource(), this.getResourceType(), null, "resource", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_ResourceType(), this.getResourceTypeType(), null, "resourceType", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Resources(), this.getResourcesType(), null, "resources", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Response(), this.getResponseType(), null, "response", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(grammarsTypeEClass, GrammarsType.class, "GrammarsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGrammarsType_Doc(), this.getDocType(), null, "doc", null, 0, -1, GrammarsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGrammarsType_Include(), this.getIncludeType(), null, "include", null, 0, -1, GrammarsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGrammarsType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, GrammarsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(includeTypeEClass, IncludeType.class, "IncludeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIncludeType_Doc(), this.getDocType(), null, "doc", null, 0, -1, IncludeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIncludeType_Href(), theXMLTypePackage.getAnyURI(), "href", null, 0, 1, IncludeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIncludeType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, IncludeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkTypeEClass, LinkType.class, "LinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkType_Doc(), this.getDocType(), null, "doc", null, 0, -1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Rel(), theXMLTypePackage.getToken(), "rel", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_ResourceType(), theXMLTypePackage.getAnyURI(), "resourceType", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Rev(), theXMLTypePackage.getToken(), "rev", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodTypeEClass, MethodType.class, "MethodType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodType_Doc(), this.getDocType(), null, "doc", null, 0, -1, MethodType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodType_Request(), this.getRequestType(), null, "request", null, 0, 1, MethodType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodType_Response(), this.getResponseType(), null, "response", null, 0, -1, MethodType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, MethodType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodType_Href(), theXMLTypePackage.getAnyURI(), "href", null, 0, 1, MethodType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, MethodType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodType_Name(), this.getMethod(), "name", null, 0, 1, MethodType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, MethodType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(optionTypeEClass, OptionType.class, "OptionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptionType_Doc(), this.getDocType(), null, "doc", null, 0, -1, OptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOptionType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, OptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOptionType_MediaType(), theXMLTypePackage.getString(), "mediaType", null, 0, 1, OptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOptionType_Value(), theXMLTypePackage.getString(), "value", null, 1, 1, OptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOptionType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, OptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paramTypeEClass, ParamType.class, "ParamType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParamType_Doc(), this.getDocType(), null, "doc", null, 0, -1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParamType_Option(), this.getOptionType(), null, "option", null, 0, -1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParamType_Link(), this.getLinkType(), null, "link", null, 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Default(), theXMLTypePackage.getString(), "default", null, 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Fixed(), theXMLTypePackage.getString(), "fixed", null, 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Href(), theXMLTypePackage.getAnyURI(), "href", null, 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Name(), theXMLTypePackage.getNMTOKEN(), "name", null, 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Path(), theXMLTypePackage.getString(), "path", null, 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Repeating(), theXMLTypePackage.getBoolean(), "repeating", "false", 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Required(), theXMLTypePackage.getBoolean(), "required", "false", 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Style(), this.getParamStyle(), "style", null, 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_Type(), theXMLTypePackage.getQName(), "type", "xs:string", 0, 1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParamType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, ParamType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(representationTypeEClass, RepresentationType.class, "RepresentationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepresentationType_Doc(), this.getDocType(), null, "doc", null, 0, -1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepresentationType_Param(), this.getParamType(), null, "param", null, 0, -1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepresentationType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepresentationType_Element(), theXMLTypePackage.getQName(), "element", null, 0, 1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepresentationType_Href(), theXMLTypePackage.getAnyURI(), "href", null, 0, 1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepresentationType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepresentationType_MediaType(), theXMLTypePackage.getString(), "mediaType", null, 0, 1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepresentationType_Profile(), this.getUriList(), "profile", null, 0, 1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepresentationType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, RepresentationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requestTypeEClass, RequestType.class, "RequestType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequestType_Doc(), this.getDocType(), null, "doc", null, 0, -1, RequestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequestType_Param(), this.getParamType(), null, "param", null, 0, -1, RequestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequestType_Representation(), this.getRepresentationType(), null, "representation", null, 0, -1, RequestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, RequestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequestType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, RequestType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourcesTypeEClass, ResourcesType.class, "ResourcesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourcesType_Doc(), this.getDocType(), null, "doc", null, 0, -1, ResourcesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourcesType_Resource(), this.getResourceType(), null, "resource", null, 1, -1, ResourcesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcesType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ResourcesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcesType_Base(), theXMLTypePackage.getAnyURI(), "base", null, 0, 1, ResourcesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcesType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, ResourcesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceTypeEClass, ResourceType.class, "ResourceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceType_Doc(), this.getDocType(), null, "doc", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_Param(), this.getParamType(), null, "param", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_Method(), this.getMethodType(), null, "method", null, 0, -1, ResourceType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getResourceType_Resource(), this.getResourceType(), null, "resource", null, 0, -1, ResourceType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Path(), theXMLTypePackage.getString(), "path", null, 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_QueryType(), theXMLTypePackage.getString(), "queryType", "application/x-www-form-urlencoded", 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_Type(), this.getResourceTypeList(), "type", null, 0, 1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, ResourceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceTypeTypeEClass, ResourceTypeType.class, "ResourceTypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceTypeType_Doc(), this.getDocType(), null, "doc", null, 0, -1, ResourceTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceTypeType_Param(), this.getParamType(), null, "param", null, 0, -1, ResourceTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceTypeType_Group(), ecorePackage.getEFeatureMapEntry(), "group", null, 0, -1, ResourceTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceTypeType_Method(), this.getMethodType(), null, "method", null, 0, -1, ResourceTypeType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getResourceTypeType_Resource(), this.getResourceType(), null, "resource", null, 0, -1, ResourceTypeType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceTypeType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ResourceTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceTypeType_Id(), theXMLTypePackage.getID(), "id", null, 0, 1, ResourceTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceTypeType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, ResourceTypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(responseTypeEClass, ResponseType.class, "ResponseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResponseType_Doc(), this.getDocType(), null, "doc", null, 0, -1, ResponseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponseType_Param(), this.getParamType(), null, "param", null, 0, -1, ResponseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResponseType_Representation(), this.getRepresentationType(), null, "representation", null, 0, -1, ResponseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResponseType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, ResponseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResponseType_Status(), this.getStatusCodeList(), "status", null, 0, 1, ResponseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResponseType_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, ResponseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(httpMethodsEEnum, HTTPMethods.class, "HTTPMethods");
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.GET);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.POST);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.PUT);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.HEAD);
		addEEnumLiteral(httpMethodsEEnum, HTTPMethods.DELETE);

		initEEnum(paramStyleEEnum, ParamStyle.class, "ParamStyle");
		addEEnumLiteral(paramStyleEEnum, ParamStyle.PLAIN);
		addEEnumLiteral(paramStyleEEnum, ParamStyle.QUERY);
		addEEnumLiteral(paramStyleEEnum, ParamStyle.MATRIX);
		addEEnumLiteral(paramStyleEEnum, ParamStyle.HEADER);
		addEEnumLiteral(paramStyleEEnum, ParamStyle.TEMPLATE);

		// Initialize data types
		initEDataType(httpMethodsObjectEDataType, HTTPMethods.class, "HTTPMethodsObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(methodEDataType, Object.class, "Method", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(paramStyleObjectEDataType, ParamStyle.class, "ParamStyleObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(resourceTypeListEDataType, List.class, "ResourceTypeList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(statusCodeListEDataType, List.class, "StatusCodeList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriListEDataType, List.class, "UriList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (applicationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "application_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getApplicationType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getApplicationType_Grammars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "grammars",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getApplicationType_Resources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resources",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getApplicationType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:3"
		   });	
		addAnnotation
		  (getApplicationType_ResourceType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resource_type",
			 "namespace", "##targetNamespace",
			 "group", "#group:3"
		   });	
		addAnnotation
		  (getApplicationType_Method(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "method",
			 "namespace", "##targetNamespace",
			 "group", "#group:3"
		   });	
		addAnnotation
		  (getApplicationType_Representation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "representation",
			 "namespace", "##targetNamespace",
			 "group", "#group:3"
		   });	
		addAnnotation
		  (getApplicationType_Param(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "param",
			 "namespace", "##targetNamespace",
			 "group", "#group:3"
		   });	
		addAnnotation
		  (getApplicationType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":8",
			 "processing", "lax"
		   });	
		addAnnotation
		  (docTypeEClass, 
		   source, 
		   new String[] {
			 "name", "doc_._type",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getDocType_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getDocType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getDocType_Lang(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "lang",
			 "namespace", "http://www.w3.org/XML/1998/namespace"
		   });	
		addAnnotation
		  (getDocType_Title(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "title"
		   });	
		addAnnotation
		  (getDocType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":4",
			 "processing", "lax"
		   });	
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });	
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });	
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });	
		addAnnotation
		  (getDocumentRoot_Application(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "application",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Grammars(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "grammars",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Include(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "include",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Link(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Method(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "method",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Option(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "option",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Param(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "param",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Representation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "representation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Request(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "request",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Resource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resource",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_ResourceType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resource_type",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Resources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resources",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getDocumentRoot_Response(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "response",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (grammarsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "grammars_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getGrammarsType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getGrammarsType_Include(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "include",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getGrammarsType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });	
		addAnnotation
		  (httpMethodsEEnum, 
		   source, 
		   new String[] {
			 "name", "HTTPMethods"
		   });	
		addAnnotation
		  (httpMethodsObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "HTTPMethods:Object",
			 "baseType", "HTTPMethods"
		   });	
		addAnnotation
		  (includeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "include_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getIncludeType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getIncludeType_Href(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "href"
		   });	
		addAnnotation
		  (getIncludeType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });	
		addAnnotation
		  (linkTypeEClass, 
		   source, 
		   new String[] {
			 "name", "link_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getLinkType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getLinkType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getLinkType_Rel(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rel"
		   });	
		addAnnotation
		  (getLinkType_ResourceType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "resource_type"
		   });	
		addAnnotation
		  (getLinkType_Rev(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "rev"
		   });	
		addAnnotation
		  (getLinkType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":5",
			 "processing", "lax"
		   });	
		addAnnotation
		  (methodEDataType, 
		   source, 
		   new String[] {
			 "name", "Method",
			 "memberTypes", "HTTPMethods http://www.eclipse.org/emf/2003/XMLType#NMTOKEN"
		   });	
		addAnnotation
		  (methodTypeEClass, 
		   source, 
		   new String[] {
			 "name", "method_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getMethodType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMethodType_Request(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "request",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMethodType_Response(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "response",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getMethodType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getMethodType_Href(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "href"
		   });	
		addAnnotation
		  (getMethodType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getMethodType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getMethodType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":7",
			 "processing", "lax"
		   });	
		addAnnotation
		  (optionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "option_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getOptionType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getOptionType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getOptionType_MediaType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "mediaType"
		   });	
		addAnnotation
		  (getOptionType_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value"
		   });	
		addAnnotation
		  (getOptionType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":4",
			 "processing", "lax"
		   });	
		addAnnotation
		  (paramStyleEEnum, 
		   source, 
		   new String[] {
			 "name", "ParamStyle"
		   });	
		addAnnotation
		  (paramStyleObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ParamStyle:Object",
			 "baseType", "ParamStyle"
		   });	
		addAnnotation
		  (paramTypeEClass, 
		   source, 
		   new String[] {
			 "name", "param_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getParamType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getParamType_Option(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "option",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getParamType_Link(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getParamType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getParamType_Default(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "default"
		   });	
		addAnnotation
		  (getParamType_Fixed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fixed"
		   });	
		addAnnotation
		  (getParamType_Href(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "href"
		   });	
		addAnnotation
		  (getParamType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getParamType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });	
		addAnnotation
		  (getParamType_Path(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "path"
		   });	
		addAnnotation
		  (getParamType_Repeating(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "repeating"
		   });	
		addAnnotation
		  (getParamType_Required(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "required"
		   });	
		addAnnotation
		  (getParamType_Style(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "style"
		   });	
		addAnnotation
		  (getParamType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });	
		addAnnotation
		  (getParamType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":14",
			 "processing", "lax"
		   });	
		addAnnotation
		  (representationTypeEClass, 
		   source, 
		   new String[] {
			 "name", "representation_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRepresentationType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRepresentationType_Param(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "param",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRepresentationType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getRepresentationType_Element(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "element"
		   });	
		addAnnotation
		  (getRepresentationType_Href(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "href"
		   });	
		addAnnotation
		  (getRepresentationType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getRepresentationType_MediaType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "mediaType"
		   });	
		addAnnotation
		  (getRepresentationType_Profile(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "profile"
		   });	
		addAnnotation
		  (getRepresentationType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":8",
			 "processing", "lax"
		   });	
		addAnnotation
		  (requestTypeEClass, 
		   source, 
		   new String[] {
			 "name", "request_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getRequestType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRequestType_Param(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "param",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRequestType_Representation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "representation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getRequestType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getRequestType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":4",
			 "processing", "lax"
		   });	
		addAnnotation
		  (resourcesTypeEClass, 
		   source, 
		   new String[] {
			 "name", "resources_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getResourcesType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResourcesType_Resource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resource",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResourcesType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":2",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getResourcesType_Base(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "base"
		   });	
		addAnnotation
		  (getResourcesType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":4",
			 "processing", "lax"
		   });	
		addAnnotation
		  (resourceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "resource_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getResourceType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResourceType_Param(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "param",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResourceType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:2"
		   });	
		addAnnotation
		  (getResourceType_Method(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "method",
			 "namespace", "##targetNamespace",
			 "group", "#group:2"
		   });	
		addAnnotation
		  (getResourceType_Resource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resource",
			 "namespace", "##targetNamespace",
			 "group", "#group:2"
		   });	
		addAnnotation
		  (getResourceType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":5",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getResourceType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getResourceType_Path(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "path"
		   });	
		addAnnotation
		  (getResourceType_QueryType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "queryType"
		   });	
		addAnnotation
		  (getResourceType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });	
		addAnnotation
		  (getResourceType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":10",
			 "processing", "lax"
		   });	
		addAnnotation
		  (resourceTypeListEDataType, 
		   source, 
		   new String[] {
			 "name", "resource_type_list",
			 "itemType", "http://www.eclipse.org/emf/2003/XMLType#anyURI"
		   });	
		addAnnotation
		  (resourceTypeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "resource_type_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getResourceTypeType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResourceTypeType_Param(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "param",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResourceTypeType_Group(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "group:2"
		   });	
		addAnnotation
		  (getResourceTypeType_Method(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "method",
			 "namespace", "##targetNamespace",
			 "group", "#group:2"
		   });	
		addAnnotation
		  (getResourceTypeType_Resource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "resource",
			 "namespace", "##targetNamespace",
			 "group", "#group:2"
		   });	
		addAnnotation
		  (getResourceTypeType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":5",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getResourceTypeType_Id(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "id"
		   });	
		addAnnotation
		  (getResourceTypeType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":7",
			 "processing", "lax"
		   });	
		addAnnotation
		  (responseTypeEClass, 
		   source, 
		   new String[] {
			 "name", "response_._type",
			 "kind", "elementOnly"
		   });	
		addAnnotation
		  (getResponseType_Doc(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "doc",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResponseType_Param(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "param",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResponseType_Representation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "representation",
			 "namespace", "##targetNamespace"
		   });	
		addAnnotation
		  (getResponseType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":3",
			 "processing", "lax"
		   });	
		addAnnotation
		  (getResponseType_Status(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "status"
		   });	
		addAnnotation
		  (getResponseType_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":5",
			 "processing", "lax"
		   });	
		addAnnotation
		  (statusCodeListEDataType, 
		   source, 
		   new String[] {
			 "name", "statusCodeList",
			 "itemType", "http://www.eclipse.org/emf/2003/XMLType#unsignedInt"
		   });	
		addAnnotation
		  (uriListEDataType, 
		   source, 
		   new String[] {
			 "name", "uriList",
			 "itemType", "http://www.eclipse.org/emf/2003/XMLType#anyURI"
		   });
	}

} //WadlPackageImpl

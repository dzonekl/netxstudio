/**
 */
package wadl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import wadl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see wadl.WadlPackage
 * @generated
 */
public class WadlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WadlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WadlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WadlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WadlSwitch<Adapter> modelSwitch =
		new WadlSwitch<Adapter>() {
			@Override
			public Adapter caseApplicationType(ApplicationType object) {
				return createApplicationTypeAdapter();
			}
			@Override
			public Adapter caseDocType(DocType object) {
				return createDocTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseGrammarsType(GrammarsType object) {
				return createGrammarsTypeAdapter();
			}
			@Override
			public Adapter caseIncludeType(IncludeType object) {
				return createIncludeTypeAdapter();
			}
			@Override
			public Adapter caseLinkType(LinkType object) {
				return createLinkTypeAdapter();
			}
			@Override
			public Adapter caseMethodType(MethodType object) {
				return createMethodTypeAdapter();
			}
			@Override
			public Adapter caseOptionType(OptionType object) {
				return createOptionTypeAdapter();
			}
			@Override
			public Adapter caseParamType(ParamType object) {
				return createParamTypeAdapter();
			}
			@Override
			public Adapter caseRepresentationType(RepresentationType object) {
				return createRepresentationTypeAdapter();
			}
			@Override
			public Adapter caseRequestType(RequestType object) {
				return createRequestTypeAdapter();
			}
			@Override
			public Adapter caseResourcesType(ResourcesType object) {
				return createResourcesTypeAdapter();
			}
			@Override
			public Adapter caseResourceType(ResourceType object) {
				return createResourceTypeAdapter();
			}
			@Override
			public Adapter caseResourceTypeType(ResourceTypeType object) {
				return createResourceTypeTypeAdapter();
			}
			@Override
			public Adapter caseResponseType(ResponseType object) {
				return createResponseTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link wadl.ApplicationType <em>Application Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.ApplicationType
	 * @generated
	 */
	public Adapter createApplicationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.DocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.DocType
	 * @generated
	 */
	public Adapter createDocTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.GrammarsType <em>Grammars Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.GrammarsType
	 * @generated
	 */
	public Adapter createGrammarsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.IncludeType <em>Include Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.IncludeType
	 * @generated
	 */
	public Adapter createIncludeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.LinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.LinkType
	 * @generated
	 */
	public Adapter createLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.MethodType <em>Method Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.MethodType
	 * @generated
	 */
	public Adapter createMethodTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.OptionType <em>Option Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.OptionType
	 * @generated
	 */
	public Adapter createOptionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.ParamType <em>Param Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.ParamType
	 * @generated
	 */
	public Adapter createParamTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.RepresentationType <em>Representation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.RepresentationType
	 * @generated
	 */
	public Adapter createRepresentationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.RequestType <em>Request Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.RequestType
	 * @generated
	 */
	public Adapter createRequestTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.ResourcesType <em>Resources Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.ResourcesType
	 * @generated
	 */
	public Adapter createResourcesTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.ResourceType
	 * @generated
	 */
	public Adapter createResourceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.ResourceTypeType <em>Resource Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.ResourceTypeType
	 * @generated
	 */
	public Adapter createResourceTypeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link wadl.ResponseType <em>Response Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see wadl.ResponseType
	 * @generated
	 */
	public Adapter createResponseTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WadlAdapterFactory

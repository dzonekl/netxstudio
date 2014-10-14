/**
 */
package wadl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 *    <div xmlns="http://www.w3.org/1999/xhtml">
 *     <h1>About the XML namespace</h1>
 * 
 *     <div class="bodytext">
 *      <p>
 *       This schema document describes the XML namespace, in a form
 *       suitable for import by other schema documents.
 *      </p>
 *      <p>
 *       See <a href="http://www.w3.org/XML/1998/namespace.html">
 *       http://www.w3.org/XML/1998/namespace.html</a> and
 *       <a href="http://www.w3.org/TR/REC-xml">
 *       http://www.w3.org/TR/REC-xml</a> for information 
 *       about this namespace.
 *      </p>
 *      <p>
 *       Note that local names in this namespace are intended to be
 *       defined only by the World Wide Web Consortium or its subgroups.
 *       The names currently defined in this namespace are listed below.
 *       They should not be used with conflicting semantics by any Working
 *       Group, specification, or document instance.
 *      </p>
 *      <p>   
 *       See further below in this document for more information about <a href="#usage">how to refer to this schema document from your own
 *       XSD schema documents</a> and about <a href="#nsversioning">the
 *       namespace-versioning policy governing this schema document</a>.
 *      </p>
 *     </div>
 *    </div>
 *   
 * 
 *    <div xmlns="http://www.w3.org/1999/xhtml">
 *    
 *     <h3>Father (in any context at all)</h3> 
 * 
 *     <div class="bodytext">
 *      <p>
 *       denotes Jon Bosak, the chair of 
 *       the original XML Working Group.  This name is reserved by 
 *       the following decision of the W3C XML Plenary and 
 *       XML Coordination groups:
 *      </p>
 *      <blockquote>
 *        <p>
 * 	In appreciation for his vision, leadership and
 * 	dedication the W3C XML Plenary on this 10th day of
 * 	February, 2000, reserves for Jon Bosak in perpetuity
 * 	the XML name "xml:Father".
 *        </p>
 *      </blockquote>
 *     </div>
 *    </div>
 *   
 * 
 *    <div id="usage" xml:id="usage" xmlns="http://www.w3.org/1999/xhtml">
 *     <h2>
 *       <a name="usage">About this schema document</a>
 *     </h2>
 * 
 *     <div class="bodytext">
 *      <p>
 *       This schema defines attributes and an attribute group suitable
 *       for use by schemas wishing to allow <code>xml:base</code>,
 *       <code>xml:lang</code>, <code>xml:space</code> or
 *       <code>xml:id</code> attributes on elements they define.
 *      </p>
 *      <p>
 *       To enable this, such a schema must import this schema for
 *       the XML namespace, e.g. as follows:
 *      </p>
 *      <pre>
 *           &lt;schema . . .&gt;
 *            . . .
 *            &lt;import namespace="http://www.w3.org/XML/1998/namespace"
 *                       schemaLocation="http://www.w3.org/2001/xml.xsd"/&gt;
 *      </pre>
 *      <p>
 *       or
 *      </p>
 *      <pre>
 *            &lt;import namespace="http://www.w3.org/XML/1998/namespace"
 *                       schemaLocation="http://www.w3.org/2009/01/xml.xsd"/&gt;
 *      </pre>
 *      <p>
 *       Subsequently, qualified reference to any of the attributes or the
 *       group defined below will have the desired effect, e.g.
 *      </p>
 *      <pre>
 *           &lt;type . . .&gt;
 *            . . .
 *            &lt;attributeGroup ref="xml:specialAttrs"/&gt;
 *      </pre>
 *      <p>
 *       will define a type which will schema-validate an instance element
 *       with any of those attributes.
 *      </p>
 *     </div>
 *    </div>
 *   
 * 
 *    <div id="nsversioning" xml:id="nsversioning" xmlns="http://www.w3.org/1999/xhtml">
 *     <h2>
 *       <a name="nsversioning">Versioning policy for this schema document</a>
 *     </h2>
 *     <div class="bodytext">
 *      <p>
 *       In keeping with the XML Schema WG's standard versioning
 *       policy, this schema document will persist at
 *       <a href="http://www.w3.org/2009/01/xml.xsd">
 *        http://www.w3.org/2009/01/xml.xsd</a>.
 *      </p>
 *      <p>
 *       At the date of issue it can also be found at
 *       <a href="http://www.w3.org/2001/xml.xsd">
 *        http://www.w3.org/2001/xml.xsd</a>.
 *      </p>
 *      <p>
 *       The schema document at that URI may however change in the future,
 *       in order to remain compatible with the latest version of XML
 *       Schema itself, or with the XML namespace itself.  In other words,
 *       if the XML Schema or XML namespaces change, the version of this
 *       document at <a href="http://www.w3.org/2001/xml.xsd">
 *        http://www.w3.org/2001/xml.xsd 
 *       </a> 
 *       will change accordingly; the version at 
 *       <a href="http://www.w3.org/2009/01/xml.xsd">
 *        http://www.w3.org/2009/01/xml.xsd 
 *       </a> 
 *       will not change.
 *      </p>
 *      <p>
 *       Previous dated (and unchanging) versions of this schema 
 *       document are at:
 *      </p>
 *      <ul>
 *       <li>
 *           <a href="http://www.w3.org/2009/01/xml.xsd">
 * 	http://www.w3.org/2009/01/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2007/08/xml.xsd">
 * 	http://www.w3.org/2007/08/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2004/10/xml.xsd">
 * 	http://www.w3.org/2004/10/xml.xsd</a>
 *         </li>
 *       <li>
 *           <a href="http://www.w3.org/2001/03/xml.xsd">
 * 	http://www.w3.org/2001/03/xml.xsd</a>
 *         </li>
 *      </ul>
 *     </div>
 *    </div>
 *   
 * <!-- end-model-doc -->
 * @see wadl.WadlFactory
 * @model kind="package"
 * @generated
 */
public interface WadlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wadl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://wadl.dev.java.net/2009/02";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wadl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WadlPackage eINSTANCE = wadl.impl.WadlPackageImpl.init();

	/**
	 * The meta object id for the '{@link wadl.impl.ApplicationTypeImpl <em>Application Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.ApplicationTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getApplicationType()
	 * @generated
	 */
	int APPLICATION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__GRAMMARS = 1;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__RESOURCES = 2;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__GROUP = 3;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__RESOURCE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Method</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__METHOD = 5;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__REPRESENTATION = 6;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__PARAM = 7;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE__ANY = 8;

	/**
	 * The number of structural features of the '<em>Application Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Application Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.DocTypeImpl <em>Doc Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.DocTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getDocType()
	 * @generated
	 */
	int DOC_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE__ANY = 1;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE__LANG = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE__TITLE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Doc Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Doc Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOC_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.DocumentRootImpl
	 * @see wadl.impl.WadlPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__APPLICATION = 3;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DOC = 4;

	/**
	 * The feature id for the '<em><b>Grammars</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__GRAMMARS = 5;

	/**
	 * The feature id for the '<em><b>Include</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__INCLUDE = 6;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LINK = 7;

	/**
	 * The feature id for the '<em><b>Method</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__METHOD = 8;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OPTION = 9;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PARAM = 10;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__REPRESENTATION = 11;

	/**
	 * The feature id for the '<em><b>Request</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__REQUEST = 12;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE = 13;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCE_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESOURCES = 15;

	/**
	 * The feature id for the '<em><b>Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__RESPONSE = 16;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 17;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.GrammarsTypeImpl <em>Grammars Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.GrammarsTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getGrammarsType()
	 * @generated
	 */
	int GRAMMARS_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMARS_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Include</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMARS_TYPE__INCLUDE = 1;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMARS_TYPE__ANY = 2;

	/**
	 * The number of structural features of the '<em>Grammars Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMARS_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Grammars Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAMMARS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.IncludeTypeImpl <em>Include Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.IncludeTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getIncludeType()
	 * @generated
	 */
	int INCLUDE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_TYPE__HREF = 1;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_TYPE__ANY_ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Include Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Include Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.LinkTypeImpl <em>Link Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.LinkTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getLinkType()
	 * @generated
	 */
	int LINK_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__ANY = 1;

	/**
	 * The feature id for the '<em><b>Rel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__REL = 2;

	/**
	 * The feature id for the '<em><b>Resource Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__RESOURCE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Rev</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__REV = 4;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__ANY_ATTRIBUTE = 5;

	/**
	 * The number of structural features of the '<em>Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.MethodTypeImpl <em>Method Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.MethodTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getMethodType()
	 * @generated
	 */
	int METHOD_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Request</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE__REQUEST = 1;

	/**
	 * The feature id for the '<em><b>Response</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE__RESPONSE = 2;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE__ANY = 3;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE__HREF = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE__ID = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE__NAME = 6;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE__ANY_ATTRIBUTE = 7;

	/**
	 * The number of structural features of the '<em>Method Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Method Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.OptionTypeImpl <em>Option Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.OptionTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getOptionType()
	 * @generated
	 */
	int OPTION_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_TYPE__ANY = 1;

	/**
	 * The feature id for the '<em><b>Media Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_TYPE__MEDIA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_TYPE__VALUE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_TYPE__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Option Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Option Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.ParamTypeImpl <em>Param Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.ParamTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getParamType()
	 * @generated
	 */
	int PARAM_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__OPTION = 1;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__LINK = 2;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__ANY = 3;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__DEFAULT = 4;

	/**
	 * The feature id for the '<em><b>Fixed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__FIXED = 5;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__HREF = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__ID = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__NAME = 8;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__PATH = 9;

	/**
	 * The feature id for the '<em><b>Repeating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__REPEATING = 10;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__REQUIRED = 11;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__STYLE = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__TYPE = 13;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE__ANY_ATTRIBUTE = 14;

	/**
	 * The number of structural features of the '<em>Param Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE_FEATURE_COUNT = 15;

	/**
	 * The number of operations of the '<em>Param Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAM_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.RepresentationTypeImpl <em>Representation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.RepresentationTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getRepresentationType()
	 * @generated
	 */
	int REPRESENTATION_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__PARAM = 1;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__ANY = 2;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Href</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__HREF = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__ID = 5;

	/**
	 * The feature id for the '<em><b>Media Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__MEDIA_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__PROFILE = 7;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE__ANY_ATTRIBUTE = 8;

	/**
	 * The number of structural features of the '<em>Representation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Representation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPRESENTATION_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.RequestTypeImpl <em>Request Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.RequestTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getRequestType()
	 * @generated
	 */
	int REQUEST_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TYPE__PARAM = 1;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TYPE__REPRESENTATION = 2;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TYPE__ANY = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TYPE__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Request Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Request Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.ResourcesTypeImpl <em>Resources Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.ResourcesTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getResourcesType()
	 * @generated
	 */
	int RESOURCES_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_TYPE__RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_TYPE__ANY = 2;

	/**
	 * The feature id for the '<em><b>Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_TYPE__BASE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_TYPE__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>Resources Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_TYPE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Resources Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCES_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.ResourceTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getResourceType()
	 * @generated
	 */
	int RESOURCE_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__PARAM = 1;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__GROUP = 2;

	/**
	 * The feature id for the '<em><b>Method</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__METHOD = 3;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ANY = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ID = 6;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__PATH = 7;

	/**
	 * The feature id for the '<em><b>Query Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__QUERY_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__TYPE = 9;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE__ANY_ATTRIBUTE = 10;

	/**
	 * The number of structural features of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Resource Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.ResourceTypeTypeImpl <em>Resource Type Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.ResourceTypeTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getResourceTypeType()
	 * @generated
	 */
	int RESOURCE_TYPE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE__PARAM = 1;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE__GROUP = 2;

	/**
	 * The feature id for the '<em><b>Method</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE__METHOD = 3;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE__RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE__ANY = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE__ID = 6;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE = 7;

	/**
	 * The number of structural features of the '<em>Resource Type Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Resource Type Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TYPE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.impl.ResponseTypeImpl <em>Response Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.impl.ResponseTypeImpl
	 * @see wadl.impl.WadlPackageImpl#getResponseType()
	 * @generated
	 */
	int RESPONSE_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Doc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TYPE__DOC = 0;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TYPE__PARAM = 1;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TYPE__REPRESENTATION = 2;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TYPE__ANY = 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TYPE__STATUS = 4;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TYPE__ANY_ATTRIBUTE = 5;

	/**
	 * The number of structural features of the '<em>Response Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TYPE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Response Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESPONSE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link wadl.HTTPMethods <em>HTTP Methods</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.HTTPMethods
	 * @see wadl.impl.WadlPackageImpl#getHTTPMethods()
	 * @generated
	 */
	int HTTP_METHODS = 15;

	/**
	 * The meta object id for the '{@link wadl.ParamStyle <em>Param Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.ParamStyle
	 * @see wadl.impl.WadlPackageImpl#getParamStyle()
	 * @generated
	 */
	int PARAM_STYLE = 16;

	/**
	 * The meta object id for the '<em>HTTP Methods Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.HTTPMethods
	 * @see wadl.impl.WadlPackageImpl#getHTTPMethodsObject()
	 * @generated
	 */
	int HTTP_METHODS_OBJECT = 17;

	/**
	 * The meta object id for the '<em>Method</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see wadl.impl.WadlPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 18;

	/**
	 * The meta object id for the '<em>Param Style Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see wadl.ParamStyle
	 * @see wadl.impl.WadlPackageImpl#getParamStyleObject()
	 * @generated
	 */
	int PARAM_STYLE_OBJECT = 19;

	/**
	 * The meta object id for the '<em>Resource Type List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see wadl.impl.WadlPackageImpl#getResourceTypeList()
	 * @generated
	 */
	int RESOURCE_TYPE_LIST = 20;

	/**
	 * The meta object id for the '<em>Status Code List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see wadl.impl.WadlPackageImpl#getStatusCodeList()
	 * @generated
	 */
	int STATUS_CODE_LIST = 21;

	/**
	 * The meta object id for the '<em>Uri List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see wadl.impl.WadlPackageImpl#getUriList()
	 * @generated
	 */
	int URI_LIST = 22;


	/**
	 * Returns the meta object for class '{@link wadl.ApplicationType <em>Application Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application Type</em>'.
	 * @see wadl.ApplicationType
	 * @generated
	 */
	EClass getApplicationType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ApplicationType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.ApplicationType#getDoc()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Doc();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.ApplicationType#getGrammars <em>Grammars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Grammars</em>'.
	 * @see wadl.ApplicationType#getGrammars()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Grammars();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ApplicationType#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see wadl.ApplicationType#getResources()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Resources();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ApplicationType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see wadl.ApplicationType#getGroup()
	 * @see #getApplicationType()
	 * @generated
	 */
	EAttribute getApplicationType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ApplicationType#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Type</em>'.
	 * @see wadl.ApplicationType#getResourceType()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_ResourceType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ApplicationType#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Method</em>'.
	 * @see wadl.ApplicationType#getMethod()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Method();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ApplicationType#getRepresentation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Representation</em>'.
	 * @see wadl.ApplicationType#getRepresentation()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Representation();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ApplicationType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see wadl.ApplicationType#getParam()
	 * @see #getApplicationType()
	 * @generated
	 */
	EReference getApplicationType_Param();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ApplicationType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.ApplicationType#getAny()
	 * @see #getApplicationType()
	 * @generated
	 */
	EAttribute getApplicationType_Any();

	/**
	 * Returns the meta object for class '{@link wadl.DocType <em>Doc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Doc Type</em>'.
	 * @see wadl.DocType
	 * @generated
	 */
	EClass getDocType();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.DocType#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see wadl.DocType#getMixed()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_Mixed();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.DocType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.DocType#getAny()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.DocType#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see wadl.DocType#getLang()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_Lang();

	/**
	 * Returns the meta object for the attribute '{@link wadl.DocType#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see wadl.DocType#getTitle()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_Title();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.DocType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.DocType#getAnyAttribute()
	 * @see #getDocType()
	 * @generated
	 */
	EAttribute getDocType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see wadl.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see wadl.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link wadl.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see wadl.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link wadl.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see wadl.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application</em>'.
	 * @see wadl.DocumentRoot#getApplication()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Application();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Doc</em>'.
	 * @see wadl.DocumentRoot#getDoc()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Doc();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getGrammars <em>Grammars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Grammars</em>'.
	 * @see wadl.DocumentRoot#getGrammars()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Grammars();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Include</em>'.
	 * @see wadl.DocumentRoot#getInclude()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Include();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see wadl.DocumentRoot#getLink()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Link();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Method</em>'.
	 * @see wadl.DocumentRoot#getMethod()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Method();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Option</em>'.
	 * @see wadl.DocumentRoot#getOption()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Option();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Param</em>'.
	 * @see wadl.DocumentRoot#getParam()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Param();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getRepresentation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Representation</em>'.
	 * @see wadl.DocumentRoot#getRepresentation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Representation();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Request</em>'.
	 * @see wadl.DocumentRoot#getRequest()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Request();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource</em>'.
	 * @see wadl.DocumentRoot#getResource()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Resource();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Type</em>'.
	 * @see wadl.DocumentRoot#getResourceType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_ResourceType();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resources</em>'.
	 * @see wadl.DocumentRoot#getResources()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Resources();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.DocumentRoot#getResponse <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Response</em>'.
	 * @see wadl.DocumentRoot#getResponse()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Response();

	/**
	 * Returns the meta object for class '{@link wadl.GrammarsType <em>Grammars Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grammars Type</em>'.
	 * @see wadl.GrammarsType
	 * @generated
	 */
	EClass getGrammarsType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.GrammarsType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.GrammarsType#getDoc()
	 * @see #getGrammarsType()
	 * @generated
	 */
	EReference getGrammarsType_Doc();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.GrammarsType#getInclude <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Include</em>'.
	 * @see wadl.GrammarsType#getInclude()
	 * @see #getGrammarsType()
	 * @generated
	 */
	EReference getGrammarsType_Include();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.GrammarsType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.GrammarsType#getAny()
	 * @see #getGrammarsType()
	 * @generated
	 */
	EAttribute getGrammarsType_Any();

	/**
	 * Returns the meta object for class '{@link wadl.IncludeType <em>Include Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include Type</em>'.
	 * @see wadl.IncludeType
	 * @generated
	 */
	EClass getIncludeType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.IncludeType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.IncludeType#getDoc()
	 * @see #getIncludeType()
	 * @generated
	 */
	EReference getIncludeType_Doc();

	/**
	 * Returns the meta object for the attribute '{@link wadl.IncludeType#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see wadl.IncludeType#getHref()
	 * @see #getIncludeType()
	 * @generated
	 */
	EAttribute getIncludeType_Href();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.IncludeType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.IncludeType#getAnyAttribute()
	 * @see #getIncludeType()
	 * @generated
	 */
	EAttribute getIncludeType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.LinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Type</em>'.
	 * @see wadl.LinkType
	 * @generated
	 */
	EClass getLinkType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.LinkType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.LinkType#getDoc()
	 * @see #getLinkType()
	 * @generated
	 */
	EReference getLinkType_Doc();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.LinkType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.LinkType#getAny()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.LinkType#getRel <em>Rel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rel</em>'.
	 * @see wadl.LinkType#getRel()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_Rel();

	/**
	 * Returns the meta object for the attribute '{@link wadl.LinkType#getResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Type</em>'.
	 * @see wadl.LinkType#getResourceType()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_ResourceType();

	/**
	 * Returns the meta object for the attribute '{@link wadl.LinkType#getRev <em>Rev</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rev</em>'.
	 * @see wadl.LinkType#getRev()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_Rev();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.LinkType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.LinkType#getAnyAttribute()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.MethodType <em>Method Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Type</em>'.
	 * @see wadl.MethodType
	 * @generated
	 */
	EClass getMethodType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.MethodType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.MethodType#getDoc()
	 * @see #getMethodType()
	 * @generated
	 */
	EReference getMethodType_Doc();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.MethodType#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Request</em>'.
	 * @see wadl.MethodType#getRequest()
	 * @see #getMethodType()
	 * @generated
	 */
	EReference getMethodType_Request();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.MethodType#getResponse <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Response</em>'.
	 * @see wadl.MethodType#getResponse()
	 * @see #getMethodType()
	 * @generated
	 */
	EReference getMethodType_Response();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.MethodType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.MethodType#getAny()
	 * @see #getMethodType()
	 * @generated
	 */
	EAttribute getMethodType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.MethodType#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see wadl.MethodType#getHref()
	 * @see #getMethodType()
	 * @generated
	 */
	EAttribute getMethodType_Href();

	/**
	 * Returns the meta object for the attribute '{@link wadl.MethodType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see wadl.MethodType#getId()
	 * @see #getMethodType()
	 * @generated
	 */
	EAttribute getMethodType_Id();

	/**
	 * Returns the meta object for the attribute '{@link wadl.MethodType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see wadl.MethodType#getName()
	 * @see #getMethodType()
	 * @generated
	 */
	EAttribute getMethodType_Name();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.MethodType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.MethodType#getAnyAttribute()
	 * @see #getMethodType()
	 * @generated
	 */
	EAttribute getMethodType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.OptionType <em>Option Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Type</em>'.
	 * @see wadl.OptionType
	 * @generated
	 */
	EClass getOptionType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.OptionType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.OptionType#getDoc()
	 * @see #getOptionType()
	 * @generated
	 */
	EReference getOptionType_Doc();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.OptionType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.OptionType#getAny()
	 * @see #getOptionType()
	 * @generated
	 */
	EAttribute getOptionType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.OptionType#getMediaType <em>Media Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Media Type</em>'.
	 * @see wadl.OptionType#getMediaType()
	 * @see #getOptionType()
	 * @generated
	 */
	EAttribute getOptionType_MediaType();

	/**
	 * Returns the meta object for the attribute '{@link wadl.OptionType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see wadl.OptionType#getValue()
	 * @see #getOptionType()
	 * @generated
	 */
	EAttribute getOptionType_Value();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.OptionType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.OptionType#getAnyAttribute()
	 * @see #getOptionType()
	 * @generated
	 */
	EAttribute getOptionType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.ParamType <em>Param Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Param Type</em>'.
	 * @see wadl.ParamType
	 * @generated
	 */
	EClass getParamType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ParamType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.ParamType#getDoc()
	 * @see #getParamType()
	 * @generated
	 */
	EReference getParamType_Doc();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ParamType#getOption <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Option</em>'.
	 * @see wadl.ParamType#getOption()
	 * @see #getParamType()
	 * @generated
	 */
	EReference getParamType_Option();

	/**
	 * Returns the meta object for the containment reference '{@link wadl.ParamType#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see wadl.ParamType#getLink()
	 * @see #getParamType()
	 * @generated
	 */
	EReference getParamType_Link();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ParamType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.ParamType#getAny()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see wadl.ParamType#getDefault()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Default();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#getFixed <em>Fixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed</em>'.
	 * @see wadl.ParamType#getFixed()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Fixed();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see wadl.ParamType#getHref()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Href();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see wadl.ParamType#getId()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Id();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see wadl.ParamType#getName()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Name();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see wadl.ParamType#getPath()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Path();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#isRepeating <em>Repeating</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repeating</em>'.
	 * @see wadl.ParamType#isRepeating()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Repeating();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see wadl.ParamType#isRequired()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Required();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see wadl.ParamType#getStyle()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Style();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ParamType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see wadl.ParamType#getType()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_Type();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ParamType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.ParamType#getAnyAttribute()
	 * @see #getParamType()
	 * @generated
	 */
	EAttribute getParamType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.RepresentationType <em>Representation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Representation Type</em>'.
	 * @see wadl.RepresentationType
	 * @generated
	 */
	EClass getRepresentationType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.RepresentationType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.RepresentationType#getDoc()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EReference getRepresentationType_Doc();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.RepresentationType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see wadl.RepresentationType#getParam()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EReference getRepresentationType_Param();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.RepresentationType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.RepresentationType#getAny()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EAttribute getRepresentationType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.RepresentationType#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see wadl.RepresentationType#getElement()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EAttribute getRepresentationType_Element();

	/**
	 * Returns the meta object for the attribute '{@link wadl.RepresentationType#getHref <em>Href</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Href</em>'.
	 * @see wadl.RepresentationType#getHref()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EAttribute getRepresentationType_Href();

	/**
	 * Returns the meta object for the attribute '{@link wadl.RepresentationType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see wadl.RepresentationType#getId()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EAttribute getRepresentationType_Id();

	/**
	 * Returns the meta object for the attribute '{@link wadl.RepresentationType#getMediaType <em>Media Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Media Type</em>'.
	 * @see wadl.RepresentationType#getMediaType()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EAttribute getRepresentationType_MediaType();

	/**
	 * Returns the meta object for the attribute '{@link wadl.RepresentationType#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile</em>'.
	 * @see wadl.RepresentationType#getProfile()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EAttribute getRepresentationType_Profile();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.RepresentationType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.RepresentationType#getAnyAttribute()
	 * @see #getRepresentationType()
	 * @generated
	 */
	EAttribute getRepresentationType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.RequestType <em>Request Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request Type</em>'.
	 * @see wadl.RequestType
	 * @generated
	 */
	EClass getRequestType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.RequestType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.RequestType#getDoc()
	 * @see #getRequestType()
	 * @generated
	 */
	EReference getRequestType_Doc();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.RequestType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see wadl.RequestType#getParam()
	 * @see #getRequestType()
	 * @generated
	 */
	EReference getRequestType_Param();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.RequestType#getRepresentation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Representation</em>'.
	 * @see wadl.RequestType#getRepresentation()
	 * @see #getRequestType()
	 * @generated
	 */
	EReference getRequestType_Representation();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.RequestType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.RequestType#getAny()
	 * @see #getRequestType()
	 * @generated
	 */
	EAttribute getRequestType_Any();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.RequestType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.RequestType#getAnyAttribute()
	 * @see #getRequestType()
	 * @generated
	 */
	EAttribute getRequestType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.ResourcesType <em>Resources Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resources Type</em>'.
	 * @see wadl.ResourcesType
	 * @generated
	 */
	EClass getResourcesType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourcesType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.ResourcesType#getDoc()
	 * @see #getResourcesType()
	 * @generated
	 */
	EReference getResourcesType_Doc();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourcesType#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource</em>'.
	 * @see wadl.ResourcesType#getResource()
	 * @see #getResourcesType()
	 * @generated
	 */
	EReference getResourcesType_Resource();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResourcesType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.ResourcesType#getAny()
	 * @see #getResourcesType()
	 * @generated
	 */
	EAttribute getResourcesType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ResourcesType#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base</em>'.
	 * @see wadl.ResourcesType#getBase()
	 * @see #getResourcesType()
	 * @generated
	 */
	EAttribute getResourcesType_Base();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResourcesType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.ResourcesType#getAnyAttribute()
	 * @see #getResourcesType()
	 * @generated
	 */
	EAttribute getResourcesType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.ResourceType <em>Resource Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type</em>'.
	 * @see wadl.ResourceType
	 * @generated
	 */
	EClass getResourceType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourceType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.ResourceType#getDoc()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_Doc();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourceType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see wadl.ResourceType#getParam()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_Param();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResourceType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see wadl.ResourceType#getGroup()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourceType#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Method</em>'.
	 * @see wadl.ResourceType#getMethod()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_Method();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourceType#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource</em>'.
	 * @see wadl.ResourceType#getResource()
	 * @see #getResourceType()
	 * @generated
	 */
	EReference getResourceType_Resource();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResourceType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.ResourceType#getAny()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ResourceType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see wadl.ResourceType#getId()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Id();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ResourceType#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see wadl.ResourceType#getPath()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Path();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ResourceType#getQueryType <em>Query Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Type</em>'.
	 * @see wadl.ResourceType#getQueryType()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_QueryType();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ResourceType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see wadl.ResourceType#getType()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_Type();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResourceType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.ResourceType#getAnyAttribute()
	 * @see #getResourceType()
	 * @generated
	 */
	EAttribute getResourceType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.ResourceTypeType <em>Resource Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Type Type</em>'.
	 * @see wadl.ResourceTypeType
	 * @generated
	 */
	EClass getResourceTypeType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourceTypeType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.ResourceTypeType#getDoc()
	 * @see #getResourceTypeType()
	 * @generated
	 */
	EReference getResourceTypeType_Doc();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourceTypeType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see wadl.ResourceTypeType#getParam()
	 * @see #getResourceTypeType()
	 * @generated
	 */
	EReference getResourceTypeType_Param();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResourceTypeType#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Group</em>'.
	 * @see wadl.ResourceTypeType#getGroup()
	 * @see #getResourceTypeType()
	 * @generated
	 */
	EAttribute getResourceTypeType_Group();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourceTypeType#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Method</em>'.
	 * @see wadl.ResourceTypeType#getMethod()
	 * @see #getResourceTypeType()
	 * @generated
	 */
	EReference getResourceTypeType_Method();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResourceTypeType#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource</em>'.
	 * @see wadl.ResourceTypeType#getResource()
	 * @see #getResourceTypeType()
	 * @generated
	 */
	EReference getResourceTypeType_Resource();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResourceTypeType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.ResourceTypeType#getAny()
	 * @see #getResourceTypeType()
	 * @generated
	 */
	EAttribute getResourceTypeType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ResourceTypeType#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see wadl.ResourceTypeType#getId()
	 * @see #getResourceTypeType()
	 * @generated
	 */
	EAttribute getResourceTypeType_Id();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResourceTypeType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.ResourceTypeType#getAnyAttribute()
	 * @see #getResourceTypeType()
	 * @generated
	 */
	EAttribute getResourceTypeType_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link wadl.ResponseType <em>Response Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Response Type</em>'.
	 * @see wadl.ResponseType
	 * @generated
	 */
	EClass getResponseType();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResponseType#getDoc <em>Doc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Doc</em>'.
	 * @see wadl.ResponseType#getDoc()
	 * @see #getResponseType()
	 * @generated
	 */
	EReference getResponseType_Doc();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResponseType#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Param</em>'.
	 * @see wadl.ResponseType#getParam()
	 * @see #getResponseType()
	 * @generated
	 */
	EReference getResponseType_Param();

	/**
	 * Returns the meta object for the containment reference list '{@link wadl.ResponseType#getRepresentation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Representation</em>'.
	 * @see wadl.ResponseType#getRepresentation()
	 * @see #getResponseType()
	 * @generated
	 */
	EReference getResponseType_Representation();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResponseType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see wadl.ResponseType#getAny()
	 * @see #getResponseType()
	 * @generated
	 */
	EAttribute getResponseType_Any();

	/**
	 * Returns the meta object for the attribute '{@link wadl.ResponseType#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see wadl.ResponseType#getStatus()
	 * @see #getResponseType()
	 * @generated
	 */
	EAttribute getResponseType_Status();

	/**
	 * Returns the meta object for the attribute list '{@link wadl.ResponseType#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see wadl.ResponseType#getAnyAttribute()
	 * @see #getResponseType()
	 * @generated
	 */
	EAttribute getResponseType_AnyAttribute();

	/**
	 * Returns the meta object for enum '{@link wadl.HTTPMethods <em>HTTP Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HTTP Methods</em>'.
	 * @see wadl.HTTPMethods
	 * @generated
	 */
	EEnum getHTTPMethods();

	/**
	 * Returns the meta object for enum '{@link wadl.ParamStyle <em>Param Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Param Style</em>'.
	 * @see wadl.ParamStyle
	 * @generated
	 */
	EEnum getParamStyle();

	/**
	 * Returns the meta object for data type '{@link wadl.HTTPMethods <em>HTTP Methods Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>HTTP Methods Object</em>'.
	 * @see wadl.HTTPMethods
	 * @model instanceClass="wadl.HTTPMethods"
	 *        extendedMetaData="name='HTTPMethods:Object' baseType='HTTPMethods'"
	 * @generated
	 */
	EDataType getHTTPMethodsObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Method</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 *        extendedMetaData="name='Method' memberTypes='HTTPMethods http://www.eclipse.org/emf/2003/XMLType#NMTOKEN'"
	 * @generated
	 */
	EDataType getMethod();

	/**
	 * Returns the meta object for data type '{@link wadl.ParamStyle <em>Param Style Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Param Style Object</em>'.
	 * @see wadl.ParamStyle
	 * @model instanceClass="wadl.ParamStyle"
	 *        extendedMetaData="name='ParamStyle:Object' baseType='ParamStyle'"
	 * @generated
	 */
	EDataType getParamStyleObject();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Resource Type List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Resource Type List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 *        extendedMetaData="name='resource_type_list' itemType='http://www.eclipse.org/emf/2003/XMLType#anyURI'"
	 * @generated
	 */
	EDataType getResourceTypeList();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Status Code List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Status Code List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 *        extendedMetaData="name='statusCodeList' itemType='http://www.eclipse.org/emf/2003/XMLType#unsignedInt'"
	 * @generated
	 */
	EDataType getStatusCodeList();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Uri List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Uri List</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 *        extendedMetaData="name='uriList' itemType='http://www.eclipse.org/emf/2003/XMLType#anyURI'"
	 * @generated
	 */
	EDataType getUriList();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WadlFactory getWadlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link wadl.impl.ApplicationTypeImpl <em>Application Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.ApplicationTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getApplicationType()
		 * @generated
		 */
		EClass APPLICATION_TYPE = eINSTANCE.getApplicationType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__DOC = eINSTANCE.getApplicationType_Doc();

		/**
		 * The meta object literal for the '<em><b>Grammars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__GRAMMARS = eINSTANCE.getApplicationType_Grammars();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__RESOURCES = eINSTANCE.getApplicationType_Resources();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_TYPE__GROUP = eINSTANCE.getApplicationType_Group();

		/**
		 * The meta object literal for the '<em><b>Resource Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__RESOURCE_TYPE = eINSTANCE.getApplicationType_ResourceType();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__METHOD = eINSTANCE.getApplicationType_Method();

		/**
		 * The meta object literal for the '<em><b>Representation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__REPRESENTATION = eINSTANCE.getApplicationType_Representation();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION_TYPE__PARAM = eINSTANCE.getApplicationType_Param();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute APPLICATION_TYPE__ANY = eINSTANCE.getApplicationType_Any();

		/**
		 * The meta object literal for the '{@link wadl.impl.DocTypeImpl <em>Doc Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.DocTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getDocType()
		 * @generated
		 */
		EClass DOC_TYPE = eINSTANCE.getDocType();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE__MIXED = eINSTANCE.getDocType_Mixed();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE__ANY = eINSTANCE.getDocType_Any();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE__LANG = eINSTANCE.getDocType_Lang();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE__TITLE = eINSTANCE.getDocType_Title();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOC_TYPE__ANY_ATTRIBUTE = eINSTANCE.getDocType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.DocumentRootImpl
		 * @see wadl.impl.WadlPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__APPLICATION = eINSTANCE.getDocumentRoot_Application();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DOC = eINSTANCE.getDocumentRoot_Doc();

		/**
		 * The meta object literal for the '<em><b>Grammars</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__GRAMMARS = eINSTANCE.getDocumentRoot_Grammars();

		/**
		 * The meta object literal for the '<em><b>Include</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__INCLUDE = eINSTANCE.getDocumentRoot_Include();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__LINK = eINSTANCE.getDocumentRoot_Link();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__METHOD = eINSTANCE.getDocumentRoot_Method();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__OPTION = eINSTANCE.getDocumentRoot_Option();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PARAM = eINSTANCE.getDocumentRoot_Param();

		/**
		 * The meta object literal for the '<em><b>Representation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__REPRESENTATION = eINSTANCE.getDocumentRoot_Representation();

		/**
		 * The meta object literal for the '<em><b>Request</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__REQUEST = eINSTANCE.getDocumentRoot_Request();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCE = eINSTANCE.getDocumentRoot_Resource();

		/**
		 * The meta object literal for the '<em><b>Resource Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCE_TYPE = eINSTANCE.getDocumentRoot_ResourceType();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESOURCES = eINSTANCE.getDocumentRoot_Resources();

		/**
		 * The meta object literal for the '<em><b>Response</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__RESPONSE = eINSTANCE.getDocumentRoot_Response();

		/**
		 * The meta object literal for the '{@link wadl.impl.GrammarsTypeImpl <em>Grammars Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.GrammarsTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getGrammarsType()
		 * @generated
		 */
		EClass GRAMMARS_TYPE = eINSTANCE.getGrammarsType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMARS_TYPE__DOC = eINSTANCE.getGrammarsType_Doc();

		/**
		 * The meta object literal for the '<em><b>Include</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAMMARS_TYPE__INCLUDE = eINSTANCE.getGrammarsType_Include();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAMMARS_TYPE__ANY = eINSTANCE.getGrammarsType_Any();

		/**
		 * The meta object literal for the '{@link wadl.impl.IncludeTypeImpl <em>Include Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.IncludeTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getIncludeType()
		 * @generated
		 */
		EClass INCLUDE_TYPE = eINSTANCE.getIncludeType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE_TYPE__DOC = eINSTANCE.getIncludeType_Doc();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE_TYPE__HREF = eINSTANCE.getIncludeType_Href();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUDE_TYPE__ANY_ATTRIBUTE = eINSTANCE.getIncludeType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.LinkTypeImpl <em>Link Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.LinkTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getLinkType()
		 * @generated
		 */
		EClass LINK_TYPE = eINSTANCE.getLinkType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_TYPE__DOC = eINSTANCE.getLinkType_Doc();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__ANY = eINSTANCE.getLinkType_Any();

		/**
		 * The meta object literal for the '<em><b>Rel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__REL = eINSTANCE.getLinkType_Rel();

		/**
		 * The meta object literal for the '<em><b>Resource Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__RESOURCE_TYPE = eINSTANCE.getLinkType_ResourceType();

		/**
		 * The meta object literal for the '<em><b>Rev</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__REV = eINSTANCE.getLinkType_Rev();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__ANY_ATTRIBUTE = eINSTANCE.getLinkType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.MethodTypeImpl <em>Method Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.MethodTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getMethodType()
		 * @generated
		 */
		EClass METHOD_TYPE = eINSTANCE.getMethodType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_TYPE__DOC = eINSTANCE.getMethodType_Doc();

		/**
		 * The meta object literal for the '<em><b>Request</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_TYPE__REQUEST = eINSTANCE.getMethodType_Request();

		/**
		 * The meta object literal for the '<em><b>Response</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_TYPE__RESPONSE = eINSTANCE.getMethodType_Response();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_TYPE__ANY = eINSTANCE.getMethodType_Any();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_TYPE__HREF = eINSTANCE.getMethodType_Href();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_TYPE__ID = eINSTANCE.getMethodType_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_TYPE__NAME = eINSTANCE.getMethodType_Name();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_TYPE__ANY_ATTRIBUTE = eINSTANCE.getMethodType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.OptionTypeImpl <em>Option Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.OptionTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getOptionType()
		 * @generated
		 */
		EClass OPTION_TYPE = eINSTANCE.getOptionType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION_TYPE__DOC = eINSTANCE.getOptionType_Doc();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION_TYPE__ANY = eINSTANCE.getOptionType_Any();

		/**
		 * The meta object literal for the '<em><b>Media Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION_TYPE__MEDIA_TYPE = eINSTANCE.getOptionType_MediaType();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION_TYPE__VALUE = eINSTANCE.getOptionType_Value();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION_TYPE__ANY_ATTRIBUTE = eINSTANCE.getOptionType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.ParamTypeImpl <em>Param Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.ParamTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getParamType()
		 * @generated
		 */
		EClass PARAM_TYPE = eINSTANCE.getParamType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_TYPE__DOC = eINSTANCE.getParamType_Doc();

		/**
		 * The meta object literal for the '<em><b>Option</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_TYPE__OPTION = eINSTANCE.getParamType_Option();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAM_TYPE__LINK = eINSTANCE.getParamType_Link();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__ANY = eINSTANCE.getParamType_Any();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__DEFAULT = eINSTANCE.getParamType_Default();

		/**
		 * The meta object literal for the '<em><b>Fixed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__FIXED = eINSTANCE.getParamType_Fixed();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__HREF = eINSTANCE.getParamType_Href();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__ID = eINSTANCE.getParamType_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__NAME = eINSTANCE.getParamType_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__PATH = eINSTANCE.getParamType_Path();

		/**
		 * The meta object literal for the '<em><b>Repeating</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__REPEATING = eINSTANCE.getParamType_Repeating();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__REQUIRED = eINSTANCE.getParamType_Required();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__STYLE = eINSTANCE.getParamType_Style();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__TYPE = eINSTANCE.getParamType_Type();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAM_TYPE__ANY_ATTRIBUTE = eINSTANCE.getParamType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.RepresentationTypeImpl <em>Representation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.RepresentationTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getRepresentationType()
		 * @generated
		 */
		EClass REPRESENTATION_TYPE = eINSTANCE.getRepresentationType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPRESENTATION_TYPE__DOC = eINSTANCE.getRepresentationType_Doc();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPRESENTATION_TYPE__PARAM = eINSTANCE.getRepresentationType_Param();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION_TYPE__ANY = eINSTANCE.getRepresentationType_Any();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION_TYPE__ELEMENT = eINSTANCE.getRepresentationType_Element();

		/**
		 * The meta object literal for the '<em><b>Href</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION_TYPE__HREF = eINSTANCE.getRepresentationType_Href();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION_TYPE__ID = eINSTANCE.getRepresentationType_Id();

		/**
		 * The meta object literal for the '<em><b>Media Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION_TYPE__MEDIA_TYPE = eINSTANCE.getRepresentationType_MediaType();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION_TYPE__PROFILE = eINSTANCE.getRepresentationType_Profile();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPRESENTATION_TYPE__ANY_ATTRIBUTE = eINSTANCE.getRepresentationType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.RequestTypeImpl <em>Request Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.RequestTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getRequestType()
		 * @generated
		 */
		EClass REQUEST_TYPE = eINSTANCE.getRequestType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST_TYPE__DOC = eINSTANCE.getRequestType_Doc();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST_TYPE__PARAM = eINSTANCE.getRequestType_Param();

		/**
		 * The meta object literal for the '<em><b>Representation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUEST_TYPE__REPRESENTATION = eINSTANCE.getRequestType_Representation();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_TYPE__ANY = eINSTANCE.getRequestType_Any();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUEST_TYPE__ANY_ATTRIBUTE = eINSTANCE.getRequestType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.ResourcesTypeImpl <em>Resources Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.ResourcesTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getResourcesType()
		 * @generated
		 */
		EClass RESOURCES_TYPE = eINSTANCE.getResourcesType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCES_TYPE__DOC = eINSTANCE.getResourcesType_Doc();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCES_TYPE__RESOURCE = eINSTANCE.getResourcesType_Resource();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCES_TYPE__ANY = eINSTANCE.getResourcesType_Any();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCES_TYPE__BASE = eINSTANCE.getResourcesType_Base();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCES_TYPE__ANY_ATTRIBUTE = eINSTANCE.getResourcesType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.ResourceTypeImpl <em>Resource Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.ResourceTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getResourceType()
		 * @generated
		 */
		EClass RESOURCE_TYPE = eINSTANCE.getResourceType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__DOC = eINSTANCE.getResourceType_Doc();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__PARAM = eINSTANCE.getResourceType_Param();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__GROUP = eINSTANCE.getResourceType_Group();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__METHOD = eINSTANCE.getResourceType_Method();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE__RESOURCE = eINSTANCE.getResourceType_Resource();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__ANY = eINSTANCE.getResourceType_Any();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__ID = eINSTANCE.getResourceType_Id();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__PATH = eINSTANCE.getResourceType_Path();

		/**
		 * The meta object literal for the '<em><b>Query Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__QUERY_TYPE = eINSTANCE.getResourceType_QueryType();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__TYPE = eINSTANCE.getResourceType_Type();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE__ANY_ATTRIBUTE = eINSTANCE.getResourceType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.ResourceTypeTypeImpl <em>Resource Type Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.ResourceTypeTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getResourceTypeType()
		 * @generated
		 */
		EClass RESOURCE_TYPE_TYPE = eINSTANCE.getResourceTypeType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE_TYPE__DOC = eINSTANCE.getResourceTypeType_Doc();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE_TYPE__PARAM = eINSTANCE.getResourceTypeType_Param();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE_TYPE__GROUP = eINSTANCE.getResourceTypeType_Group();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE_TYPE__METHOD = eINSTANCE.getResourceTypeType_Method();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_TYPE_TYPE__RESOURCE = eINSTANCE.getResourceTypeType_Resource();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE_TYPE__ANY = eINSTANCE.getResourceTypeType_Any();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE_TYPE__ID = eINSTANCE.getResourceTypeType_Id();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TYPE_TYPE__ANY_ATTRIBUTE = eINSTANCE.getResourceTypeType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.impl.ResponseTypeImpl <em>Response Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.impl.ResponseTypeImpl
		 * @see wadl.impl.WadlPackageImpl#getResponseType()
		 * @generated
		 */
		EClass RESPONSE_TYPE = eINSTANCE.getResponseType();

		/**
		 * The meta object literal for the '<em><b>Doc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE_TYPE__DOC = eINSTANCE.getResponseType_Doc();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE_TYPE__PARAM = eINSTANCE.getResponseType_Param();

		/**
		 * The meta object literal for the '<em><b>Representation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESPONSE_TYPE__REPRESENTATION = eINSTANCE.getResponseType_Representation();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE_TYPE__ANY = eINSTANCE.getResponseType_Any();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE_TYPE__STATUS = eINSTANCE.getResponseType_Status();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESPONSE_TYPE__ANY_ATTRIBUTE = eINSTANCE.getResponseType_AnyAttribute();

		/**
		 * The meta object literal for the '{@link wadl.HTTPMethods <em>HTTP Methods</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.HTTPMethods
		 * @see wadl.impl.WadlPackageImpl#getHTTPMethods()
		 * @generated
		 */
		EEnum HTTP_METHODS = eINSTANCE.getHTTPMethods();

		/**
		 * The meta object literal for the '{@link wadl.ParamStyle <em>Param Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.ParamStyle
		 * @see wadl.impl.WadlPackageImpl#getParamStyle()
		 * @generated
		 */
		EEnum PARAM_STYLE = eINSTANCE.getParamStyle();

		/**
		 * The meta object literal for the '<em>HTTP Methods Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.HTTPMethods
		 * @see wadl.impl.WadlPackageImpl#getHTTPMethodsObject()
		 * @generated
		 */
		EDataType HTTP_METHODS_OBJECT = eINSTANCE.getHTTPMethodsObject();

		/**
		 * The meta object literal for the '<em>Method</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see wadl.impl.WadlPackageImpl#getMethod()
		 * @generated
		 */
		EDataType METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em>Param Style Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see wadl.ParamStyle
		 * @see wadl.impl.WadlPackageImpl#getParamStyleObject()
		 * @generated
		 */
		EDataType PARAM_STYLE_OBJECT = eINSTANCE.getParamStyleObject();

		/**
		 * The meta object literal for the '<em>Resource Type List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see wadl.impl.WadlPackageImpl#getResourceTypeList()
		 * @generated
		 */
		EDataType RESOURCE_TYPE_LIST = eINSTANCE.getResourceTypeList();

		/**
		 * The meta object literal for the '<em>Status Code List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see wadl.impl.WadlPackageImpl#getStatusCodeList()
		 * @generated
		 */
		EDataType STATUS_CODE_LIST = eINSTANCE.getStatusCodeList();

		/**
		 * The meta object literal for the '<em>Uri List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see wadl.impl.WadlPackageImpl#getUriList()
		 * @generated
		 */
		EDataType URI_LIST = eINSTANCE.getUriList();

	}

} //WadlPackage

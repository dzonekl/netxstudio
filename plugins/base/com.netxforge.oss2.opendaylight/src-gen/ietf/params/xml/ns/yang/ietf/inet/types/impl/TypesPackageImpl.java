/**
 */
package ietf.params.xml.ns.yang.ietf.inet.types.impl;

import ietf.params.xml.ns.yang.ietf.inet.types.IpVersion;
import ietf.params.xml.ns.yang.ietf.inet.types.TypesFactory;
import ietf.params.xml.ns.yang.ietf.inet.types.TypesPackage;

import ietf.params.xml.ns.yang.ietf.inet.types.util.TypesValidator;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tbd.params.xml.ns.yang.network.topology.TopologyPackage;

import tbd.params.xml.ns.yang.network.topology.impl.TopologyPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ipVersionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType asNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType asNumberObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType domainNameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dscpEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dscpObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hostEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hostMember0EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hostMember1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipAddressEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipAddressMember0EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipAddressMember1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipPrefixEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipPrefixMember0EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipPrefixMember1EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipv4AddressEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipv4PrefixEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipv6AddressEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipv6FlowLabelEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipv6FlowLabelObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipv6PrefixEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ipVersionObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType portNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType portNumberObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType t0EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl() {
		super(eNS_URI, TypesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init() {
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TopologyPackageImpl theTopologyPackage = (TopologyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) instanceof TopologyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TopologyPackage.eNS_URI) : TopologyPackage.eINSTANCE);

		// Create package meta-data objects
		theTypesPackage.createPackageContents();
		theTopologyPackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();
		theTopologyPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theTypesPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return TypesValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TypesPackage.eNS_URI, theTypesPackage);
		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIpVersion() {
		return ipVersionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAsNumber() {
		return asNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAsNumberObject() {
		return asNumberObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDomainName() {
		return domainNameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDscp() {
		return dscpEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDscpObject() {
		return dscpObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHost() {
		return hostEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHostMember0() {
		return hostMember0EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getHostMember1() {
		return hostMember1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpAddress() {
		return ipAddressEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpAddressMember0() {
		return ipAddressMember0EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpAddressMember1() {
		return ipAddressMember1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpPrefix() {
		return ipPrefixEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpPrefixMember0() {
		return ipPrefixMember0EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpPrefixMember1() {
		return ipPrefixMember1EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpv4Address() {
		return ipv4AddressEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpv4Prefix() {
		return ipv4PrefixEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpv6Address() {
		return ipv6AddressEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpv6FlowLabel() {
		return ipv6FlowLabelEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpv6FlowLabelObject() {
		return ipv6FlowLabelObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpv6Prefix() {
		return ipv6PrefixEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIpVersionObject() {
		return ipVersionObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPortNumber() {
		return portNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPortNumberObject() {
		return portNumberObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getT0() {
		return t0EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUri() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactory getTypesFactory() {
		return (TypesFactory)getEFactoryInstance();
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

		// Create enums
		ipVersionEEnum = createEEnum(IP_VERSION);

		// Create data types
		asNumberEDataType = createEDataType(AS_NUMBER);
		asNumberObjectEDataType = createEDataType(AS_NUMBER_OBJECT);
		domainNameEDataType = createEDataType(DOMAIN_NAME);
		dscpEDataType = createEDataType(DSCP);
		dscpObjectEDataType = createEDataType(DSCP_OBJECT);
		hostEDataType = createEDataType(HOST);
		hostMember0EDataType = createEDataType(HOST_MEMBER0);
		hostMember1EDataType = createEDataType(HOST_MEMBER1);
		ipAddressEDataType = createEDataType(IP_ADDRESS);
		ipAddressMember0EDataType = createEDataType(IP_ADDRESS_MEMBER0);
		ipAddressMember1EDataType = createEDataType(IP_ADDRESS_MEMBER1);
		ipPrefixEDataType = createEDataType(IP_PREFIX);
		ipPrefixMember0EDataType = createEDataType(IP_PREFIX_MEMBER0);
		ipPrefixMember1EDataType = createEDataType(IP_PREFIX_MEMBER1);
		ipv4AddressEDataType = createEDataType(IPV4_ADDRESS);
		ipv4PrefixEDataType = createEDataType(IPV4_PREFIX);
		ipv6AddressEDataType = createEDataType(IPV6_ADDRESS);
		ipv6FlowLabelEDataType = createEDataType(IPV6_FLOW_LABEL);
		ipv6FlowLabelObjectEDataType = createEDataType(IPV6_FLOW_LABEL_OBJECT);
		ipv6PrefixEDataType = createEDataType(IPV6_PREFIX);
		ipVersionObjectEDataType = createEDataType(IP_VERSION_OBJECT);
		portNumberEDataType = createEDataType(PORT_NUMBER);
		portNumberObjectEDataType = createEDataType(PORT_NUMBER_OBJECT);
		t0EDataType = createEDataType(T0);
		uriEDataType = createEDataType(URI);
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

		// Initialize enums and add enum literals
		initEEnum(ipVersionEEnum, IpVersion.class, "IpVersion");
		addEEnumLiteral(ipVersionEEnum, IpVersion.UNKNOWN);
		addEEnumLiteral(ipVersionEEnum, IpVersion.IPV4);
		addEEnumLiteral(ipVersionEEnum, IpVersion.IPV6);

		// Initialize data types
		initEDataType(asNumberEDataType, long.class, "AsNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(asNumberObjectEDataType, Long.class, "AsNumberObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(domainNameEDataType, String.class, "DomainName", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dscpEDataType, short.class, "Dscp", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(dscpObjectEDataType, Short.class, "DscpObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(hostEDataType, String.class, "Host", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(hostMember0EDataType, String.class, "HostMember0", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(hostMember1EDataType, String.class, "HostMember1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipAddressEDataType, String.class, "IpAddress", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipAddressMember0EDataType, String.class, "IpAddressMember0", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipAddressMember1EDataType, String.class, "IpAddressMember1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipPrefixEDataType, String.class, "IpPrefix", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipPrefixMember0EDataType, String.class, "IpPrefixMember0", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipPrefixMember1EDataType, String.class, "IpPrefixMember1", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipv4AddressEDataType, String.class, "Ipv4Address", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipv4PrefixEDataType, String.class, "Ipv4Prefix", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipv6AddressEDataType, String.class, "Ipv6Address", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipv6FlowLabelEDataType, long.class, "Ipv6FlowLabel", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipv6FlowLabelObjectEDataType, Long.class, "Ipv6FlowLabelObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipv6PrefixEDataType, String.class, "Ipv6Prefix", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ipVersionObjectEDataType, IpVersion.class, "IpVersionObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(portNumberEDataType, int.class, "PortNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(portNumberObjectEDataType, Integer.class, "PortNumberObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(t0EDataType, String.class, "T0", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, String.class, "Uri", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.w3.org/XML/1998/namespace
		createNamespaceAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.w3.org/XML/1998/namespace</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createNamespaceAnnotations() {
		String source = "http://www.w3.org/XML/1998/namespace";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "lang", "en"
		   });
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
		  (asNumberEDataType, 
		   source, 
		   new String[] {
			 "name", "as-number",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#unsignedInt"
		   });	
		addAnnotation
		  (asNumberObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "as-number:Object",
			 "baseType", "as-number"
		   });	
		addAnnotation
		  (domainNameEDataType, 
		   source, 
		   new String[] {
			 "name", "domain-name",
			 "baseType", "t0",
			 "minLength", "1",
			 "maxLength", "253"
		   });	
		addAnnotation
		  (dscpEDataType, 
		   source, 
		   new String[] {
			 "name", "dscp",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#unsignedByte",
			 "minInclusive", "0",
			 "maxInclusive", "63"
		   });	
		addAnnotation
		  (dscpObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "dscp:Object",
			 "baseType", "dscp"
		   });	
		addAnnotation
		  (hostEDataType, 
		   source, 
		   new String[] {
			 "name", "host",
			 "memberTypes", "host_._member_._0 host_._member_._1"
		   });	
		addAnnotation
		  (hostMember0EDataType, 
		   source, 
		   new String[] {
			 "name", "host_._member_._0",
			 "baseType", "ip-address"
		   });	
		addAnnotation
		  (hostMember1EDataType, 
		   source, 
		   new String[] {
			 "name", "host_._member_._1",
			 "baseType", "domain-name"
		   });	
		addAnnotation
		  (ipAddressEDataType, 
		   source, 
		   new String[] {
			 "name", "ip-address",
			 "memberTypes", "ip-address_._member_._0 ip-address_._member_._1"
		   });	
		addAnnotation
		  (ipAddressMember0EDataType, 
		   source, 
		   new String[] {
			 "name", "ip-address_._member_._0",
			 "baseType", "ipv4-address"
		   });	
		addAnnotation
		  (ipAddressMember1EDataType, 
		   source, 
		   new String[] {
			 "name", "ip-address_._member_._1",
			 "baseType", "ipv6-address"
		   });	
		addAnnotation
		  (ipPrefixEDataType, 
		   source, 
		   new String[] {
			 "name", "ip-prefix",
			 "memberTypes", "ip-prefix_._member_._0 ip-prefix_._member_._1"
		   });	
		addAnnotation
		  (ipPrefixMember0EDataType, 
		   source, 
		   new String[] {
			 "name", "ip-prefix_._member_._0",
			 "baseType", "ipv4-prefix"
		   });	
		addAnnotation
		  (ipPrefixMember1EDataType, 
		   source, 
		   new String[] {
			 "name", "ip-prefix_._member_._1",
			 "baseType", "ipv6-prefix"
		   });	
		addAnnotation
		  (ipv4AddressEDataType, 
		   source, 
		   new String[] {
			 "name", "ipv4-address",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(%25[\\p{N}\\p{L}]+)?"
		   });	
		addAnnotation
		  (ipv4PrefixEDataType, 
		   source, 
		   new String[] {
			 "name", "ipv4-prefix",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])/(([0-9])|([1-2][0-9])|(3[0-2]))"
		   });	
		addAnnotation
		  (ipv6AddressEDataType, 
		   source, 
		   new String[] {
			 "name", "ipv6-address",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "(((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))(%25[\\p{N}\\p{L}]+)?)|((([^:]+:){6}(([^:]+:[^:]+)|(.*\\..*)))|((([^:]+:)*[^:]+)?::(([^:]+:)*[^:]+)?)(%25.+)?)"
		   });	
		addAnnotation
		  (ipv6FlowLabelEDataType, 
		   source, 
		   new String[] {
			 "name", "ipv6-flow-label",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#unsignedInt",
			 "minInclusive", "0",
			 "maxInclusive", "1048575"
		   });	
		addAnnotation
		  (ipv6FlowLabelObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ipv6-flow-label:Object",
			 "baseType", "ipv6-flow-label"
		   });	
		addAnnotation
		  (ipv6PrefixEDataType, 
		   source, 
		   new String[] {
			 "name", "ipv6-prefix",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "(((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))(/(([0-9])|([0-9]{2})|(1[0-1][0-9])|(12[0-8]))))|((([^:]+:){6}(([^:]+:[^:]+)|(.*\\..*)))|((([^:]+:)*[^:]+)?::(([^:]+:)*[^:]+)?)(/.+))"
		   });	
		addAnnotation
		  (ipVersionEEnum, 
		   source, 
		   new String[] {
			 "name", "ip-version"
		   });	
		addAnnotation
		  (ipVersionObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ip-version:Object",
			 "baseType", "ip-version"
		   });	
		addAnnotation
		  (portNumberEDataType, 
		   source, 
		   new String[] {
			 "name", "port-number",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#unsignedShort",
			 "minInclusive", "0",
			 "maxInclusive", "65535"
		   });	
		addAnnotation
		  (portNumberObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "port-number:Object",
			 "baseType", "port-number"
		   });	
		addAnnotation
		  (t0EDataType, 
		   source, 
		   new String[] {
			 "name", "t0",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "pattern", "((([a-zA-Z0-9_]([a-zA-Z0-9\\-_]){0,61})?[a-zA-Z0-9]\\.)*([a-zA-Z0-9_]([a-zA-Z0-9\\-_]){0,61})?[a-zA-Z0-9]\\.?)|\\."
		   });	
		addAnnotation
		  (uriEDataType, 
		   source, 
		   new String[] {
			 "name", "uri",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });
	}

} //TypesPackageImpl

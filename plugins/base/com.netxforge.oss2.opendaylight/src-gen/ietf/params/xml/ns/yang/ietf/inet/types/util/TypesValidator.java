/**
 */
package ietf.params.xml.ns.yang.ietf.inet.types.util;

import ietf.params.xml.ns.yang.ietf.inet.types.*;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see ietf.params.xml.ns.yang.ietf.inet.types.TypesPackage
 * @generated
 */
public class TypesValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final TypesValidator INSTANCE = new TypesValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "ietf.params.xml.ns.yang.ietf.inet.types";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return TypesPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case TypesPackage.IP_VERSION:
				return validateIpVersion((IpVersion)value, diagnostics, context);
			case TypesPackage.AS_NUMBER:
				return validateAsNumber((Long)value, diagnostics, context);
			case TypesPackage.AS_NUMBER_OBJECT:
				return validateAsNumberObject((Long)value, diagnostics, context);
			case TypesPackage.DOMAIN_NAME:
				return validateDomainName((String)value, diagnostics, context);
			case TypesPackage.DSCP:
				return validateDscp((Short)value, diagnostics, context);
			case TypesPackage.DSCP_OBJECT:
				return validateDscpObject((Short)value, diagnostics, context);
			case TypesPackage.HOST:
				return validateHost((String)value, diagnostics, context);
			case TypesPackage.HOST_MEMBER0:
				return validateHostMember0((String)value, diagnostics, context);
			case TypesPackage.HOST_MEMBER1:
				return validateHostMember1((String)value, diagnostics, context);
			case TypesPackage.IP_ADDRESS:
				return validateIpAddress((String)value, diagnostics, context);
			case TypesPackage.IP_ADDRESS_MEMBER0:
				return validateIpAddressMember0((String)value, diagnostics, context);
			case TypesPackage.IP_ADDRESS_MEMBER1:
				return validateIpAddressMember1((String)value, diagnostics, context);
			case TypesPackage.IP_PREFIX:
				return validateIpPrefix((String)value, diagnostics, context);
			case TypesPackage.IP_PREFIX_MEMBER0:
				return validateIpPrefixMember0((String)value, diagnostics, context);
			case TypesPackage.IP_PREFIX_MEMBER1:
				return validateIpPrefixMember1((String)value, diagnostics, context);
			case TypesPackage.IPV4_ADDRESS:
				return validateIpv4Address((String)value, diagnostics, context);
			case TypesPackage.IPV4_PREFIX:
				return validateIpv4Prefix((String)value, diagnostics, context);
			case TypesPackage.IPV6_ADDRESS:
				return validateIpv6Address((String)value, diagnostics, context);
			case TypesPackage.IPV6_FLOW_LABEL:
				return validateIpv6FlowLabel((Long)value, diagnostics, context);
			case TypesPackage.IPV6_FLOW_LABEL_OBJECT:
				return validateIpv6FlowLabelObject((Long)value, diagnostics, context);
			case TypesPackage.IPV6_PREFIX:
				return validateIpv6Prefix((String)value, diagnostics, context);
			case TypesPackage.IP_VERSION_OBJECT:
				return validateIpVersionObject((IpVersion)value, diagnostics, context);
			case TypesPackage.PORT_NUMBER:
				return validatePortNumber((Integer)value, diagnostics, context);
			case TypesPackage.PORT_NUMBER_OBJECT:
				return validatePortNumberObject((Integer)value, diagnostics, context);
			case TypesPackage.T0:
				return validateT0((String)value, diagnostics, context);
			case TypesPackage.URI:
				return validateUri((String)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpVersion(IpVersion ipVersion, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAsNumber(long asNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = xmlTypeValidator.validateUnsignedInt_Min(asNumber, diagnostics, context);
		if (result || diagnostics != null) result &= xmlTypeValidator.validateUnsignedInt_Max(asNumber, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAsNumberObject(Long asNumberObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = xmlTypeValidator.validateUnsignedInt_Min(asNumberObject, diagnostics, context);
		if (result || diagnostics != null) result &= xmlTypeValidator.validateUnsignedInt_Max(asNumberObject, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomainName(String domainName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateT0_Pattern(domainName, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomainName_MinLength(domainName, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomainName_MaxLength(domainName, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MinLength constraint of '<em>Domain Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomainName_MinLength(String domainName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = domainName.length();
		boolean result = length >= 1;
		if (!result && diagnostics != null)
			reportMinLengthViolation(TypesPackage.Literals.DOMAIN_NAME, domainName, length, 1, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MaxLength constraint of '<em>Domain Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomainName_MaxLength(String domainName, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int length = domainName.length();
		boolean result = length <= 253;
		if (!result && diagnostics != null)
			reportMaxLengthViolation(TypesPackage.Literals.DOMAIN_NAME, domainName, length, 253, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDscp(short dscp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateDscp_Min(dscp, diagnostics, context);
		if (result || diagnostics != null) result &= validateDscp_Max(dscp, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateDscp_Min
	 */
	public static final short DSCP__MIN__VALUE = 0;

	/**
	 * Validates the Min constraint of '<em>Dscp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDscp_Min(short dscp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = dscp >= DSCP__MIN__VALUE;
		if (!result && diagnostics != null)
			reportMinViolation(TypesPackage.Literals.DSCP, dscp, DSCP__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateDscp_Max
	 */
	public static final short DSCP__MAX__VALUE = 63;

	/**
	 * Validates the Max constraint of '<em>Dscp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDscp_Max(short dscp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = dscp <= DSCP__MAX__VALUE;
		if (!result && diagnostics != null)
			reportMaxViolation(TypesPackage.Literals.DSCP, dscp, DSCP__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDscpObject(Short dscpObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateDscp_Min(dscpObject, diagnostics, context);
		if (result || diagnostics != null) result &= validateDscp_Max(dscpObject, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHost(String host, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateHost_MemberTypes(host, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MemberTypes constraint of '<em>Host</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHost_MemberTypes(String host, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (diagnostics != null) {
			BasicDiagnostic tempDiagnostics = new BasicDiagnostic();
			if (TypesPackage.Literals.HOST_MEMBER0.isInstance(host)) {
				if (validateHostMember0(host, tempDiagnostics, context)) return true;
			}
			if (TypesPackage.Literals.HOST_MEMBER1.isInstance(host)) {
				if (validateHostMember1(host, tempDiagnostics, context)) return true;
			}
			for (Diagnostic diagnostic : tempDiagnostics.getChildren()) {
				diagnostics.add(diagnostic);
			}
		}
		else {
			if (TypesPackage.Literals.HOST_MEMBER0.isInstance(host)) {
				if (validateHostMember0(host, null, context)) return true;
			}
			if (TypesPackage.Literals.HOST_MEMBER1.isInstance(host)) {
				if (validateHostMember1(host, null, context)) return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHostMember0(String hostMember0, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpAddress_MemberTypes(hostMember0, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateHostMember1(String hostMember1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateDomainName_MinLength(hostMember1, diagnostics, context);
		if (result || diagnostics != null) result &= validateDomainName_MaxLength(hostMember1, diagnostics, context);
		if (result || diagnostics != null) result &= validateT0_Pattern(hostMember1, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpAddress(String ipAddress, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpAddress_MemberTypes(ipAddress, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MemberTypes constraint of '<em>Ip Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpAddress_MemberTypes(String ipAddress, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (diagnostics != null) {
			BasicDiagnostic tempDiagnostics = new BasicDiagnostic();
			if (TypesPackage.Literals.IP_ADDRESS_MEMBER0.isInstance(ipAddress)) {
				if (validateIpAddressMember0(ipAddress, tempDiagnostics, context)) return true;
			}
			if (TypesPackage.Literals.IP_ADDRESS_MEMBER1.isInstance(ipAddress)) {
				if (validateIpAddressMember1(ipAddress, tempDiagnostics, context)) return true;
			}
			for (Diagnostic diagnostic : tempDiagnostics.getChildren()) {
				diagnostics.add(diagnostic);
			}
		}
		else {
			if (TypesPackage.Literals.IP_ADDRESS_MEMBER0.isInstance(ipAddress)) {
				if (validateIpAddressMember0(ipAddress, null, context)) return true;
			}
			if (TypesPackage.Literals.IP_ADDRESS_MEMBER1.isInstance(ipAddress)) {
				if (validateIpAddressMember1(ipAddress, null, context)) return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpAddressMember0(String ipAddressMember0, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv4Address_Pattern(ipAddressMember0, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpAddressMember1(String ipAddressMember1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv6Address_Pattern(ipAddressMember1, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpPrefix(String ipPrefix, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpPrefix_MemberTypes(ipPrefix, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MemberTypes constraint of '<em>Ip Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpPrefix_MemberTypes(String ipPrefix, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (diagnostics != null) {
			BasicDiagnostic tempDiagnostics = new BasicDiagnostic();
			if (TypesPackage.Literals.IP_PREFIX_MEMBER0.isInstance(ipPrefix)) {
				if (validateIpPrefixMember0(ipPrefix, tempDiagnostics, context)) return true;
			}
			if (TypesPackage.Literals.IP_PREFIX_MEMBER1.isInstance(ipPrefix)) {
				if (validateIpPrefixMember1(ipPrefix, tempDiagnostics, context)) return true;
			}
			for (Diagnostic diagnostic : tempDiagnostics.getChildren()) {
				diagnostics.add(diagnostic);
			}
		}
		else {
			if (TypesPackage.Literals.IP_PREFIX_MEMBER0.isInstance(ipPrefix)) {
				if (validateIpPrefixMember0(ipPrefix, null, context)) return true;
			}
			if (TypesPackage.Literals.IP_PREFIX_MEMBER1.isInstance(ipPrefix)) {
				if (validateIpPrefixMember1(ipPrefix, null, context)) return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpPrefixMember0(String ipPrefixMember0, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv4Prefix_Pattern(ipPrefixMember0, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpPrefixMember1(String ipPrefixMember1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv6Prefix_Pattern(ipPrefixMember1, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv4Address(String ipv4Address, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv4Address_Pattern(ipv4Address, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateIpv4Address_Pattern
	 */
	public static final  PatternMatcher [][] IPV4_ADDRESS__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(%[\\p{N}\\p{L}]+)?")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Ipv4 Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv4Address_Pattern(String ipv4Address, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(TypesPackage.Literals.IPV4_ADDRESS, ipv4Address, IPV4_ADDRESS__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv4Prefix(String ipv4Prefix, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv4Prefix_Pattern(ipv4Prefix, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateIpv4Prefix_Pattern
	 */
	public static final  PatternMatcher [][] IPV4_PREFIX__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])/(([0-9])|([1-2][0-9])|(3[0-2]))")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Ipv4 Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv4Prefix_Pattern(String ipv4Prefix, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(TypesPackage.Literals.IPV4_PREFIX, ipv4Prefix, IPV4_PREFIX__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv6Address(String ipv6Address, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv6Address_Pattern(ipv6Address, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateIpv6Address_Pattern
	 */
	public static final  PatternMatcher [][] IPV6_ADDRESS__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("(((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))(%[\\p{N}\\p{L}]+)?)|((([^:]+:){6}(([^:]+:[^:]+)|(.*\\..*)))|((([^:]+:)*[^:]+)?::(([^:]+:)*[^:]+)?)(%.+)?)")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Ipv6 Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv6Address_Pattern(String ipv6Address, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(TypesPackage.Literals.IPV6_ADDRESS, ipv6Address, IPV6_ADDRESS__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv6FlowLabel(long ipv6FlowLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv6FlowLabel_Min(ipv6FlowLabel, diagnostics, context);
		if (result || diagnostics != null) result &= validateIpv6FlowLabel_Max(ipv6FlowLabel, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateIpv6FlowLabel_Min
	 */
	public static final long IPV6_FLOW_LABEL__MIN__VALUE = 0L;

	/**
	 * Validates the Min constraint of '<em>Ipv6 Flow Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv6FlowLabel_Min(long ipv6FlowLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = ipv6FlowLabel >= IPV6_FLOW_LABEL__MIN__VALUE;
		if (!result && diagnostics != null)
			reportMinViolation(TypesPackage.Literals.IPV6_FLOW_LABEL, ipv6FlowLabel, IPV6_FLOW_LABEL__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateIpv6FlowLabel_Max
	 */
	public static final long IPV6_FLOW_LABEL__MAX__VALUE = 1048575L;

	/**
	 * Validates the Max constraint of '<em>Ipv6 Flow Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv6FlowLabel_Max(long ipv6FlowLabel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = ipv6FlowLabel <= IPV6_FLOW_LABEL__MAX__VALUE;
		if (!result && diagnostics != null)
			reportMaxViolation(TypesPackage.Literals.IPV6_FLOW_LABEL, ipv6FlowLabel, IPV6_FLOW_LABEL__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv6FlowLabelObject(Long ipv6FlowLabelObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv6FlowLabel_Min(ipv6FlowLabelObject, diagnostics, context);
		if (result || diagnostics != null) result &= validateIpv6FlowLabel_Max(ipv6FlowLabelObject, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv6Prefix(String ipv6Prefix, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateIpv6Prefix_Pattern(ipv6Prefix, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateIpv6Prefix_Pattern
	 */
	public static final  PatternMatcher [][] IPV6_PREFIX__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("(((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))(/(([0-9])|([0-9]{2})|(1[0-1][0-9])|(12[0-8]))))|((([^:]+:){6}(([^:]+:[^:]+)|(.*\\..*)))|((([^:]+:)*[^:]+)?::(([^:]+:)*[^:]+)?)(/.+))")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>Ipv6 Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpv6Prefix_Pattern(String ipv6Prefix, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(TypesPackage.Literals.IPV6_PREFIX, ipv6Prefix, IPV6_PREFIX__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIpVersionObject(IpVersion ipVersionObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortNumber(int portNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePortNumber_Min(portNumber, diagnostics, context);
		if (result || diagnostics != null) result &= validatePortNumber_Max(portNumber, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePortNumber_Min
	 */
	public static final int PORT_NUMBER__MIN__VALUE = 0;

	/**
	 * Validates the Min constraint of '<em>Port Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortNumber_Min(int portNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = portNumber >= PORT_NUMBER__MIN__VALUE;
		if (!result && diagnostics != null)
			reportMinViolation(TypesPackage.Literals.PORT_NUMBER, portNumber, PORT_NUMBER__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatePortNumber_Max
	 */
	public static final int PORT_NUMBER__MAX__VALUE = 65535;

	/**
	 * Validates the Max constraint of '<em>Port Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortNumber_Max(int portNumber, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = portNumber <= PORT_NUMBER__MAX__VALUE;
		if (!result && diagnostics != null)
			reportMaxViolation(TypesPackage.Literals.PORT_NUMBER, portNumber, PORT_NUMBER__MAX__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePortNumberObject(Integer portNumberObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatePortNumber_Min(portNumberObject, diagnostics, context);
		if (result || diagnostics != null) result &= validatePortNumber_Max(portNumberObject, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateT0(String t0, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateT0_Pattern(t0, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validateT0_Pattern
	 */
	public static final  PatternMatcher [][] T0__PATTERN__VALUES =
		new PatternMatcher [][] {
			new PatternMatcher [] {
				XMLTypeUtil.createPatternMatcher("((([a-zA-Z0-9_]([a-zA-Z0-9\\-_]){0,61})?[a-zA-Z0-9]\\.)*([a-zA-Z0-9_]([a-zA-Z0-9\\-_]){0,61})?[a-zA-Z0-9]\\.?)|\\.")
			}
		};

	/**
	 * Validates the Pattern constraint of '<em>T0</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateT0_Pattern(String t0, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validatePattern(TypesPackage.Literals.T0, t0, T0__PATTERN__VALUES, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUri(String uri, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //TypesValidator

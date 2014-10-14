/**
 */
package ietf.params.xml.ns.yang.ietf.inet.types.impl;

import ietf.params.xml.ns.yang.ietf.inet.types.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.Diagnostician;

import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesFactoryImpl extends EFactoryImpl implements TypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypesFactory init() {
		try {
			TypesFactory theTypesFactory = (TypesFactory)EPackage.Registry.INSTANCE.getEFactory(TypesPackage.eNS_URI);
			if (theTypesFactory != null) {
				return theTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TypesPackage.IP_VERSION:
				return createIpVersionFromString(eDataType, initialValue);
			case TypesPackage.AS_NUMBER:
				return createAsNumberFromString(eDataType, initialValue);
			case TypesPackage.AS_NUMBER_OBJECT:
				return createAsNumberObjectFromString(eDataType, initialValue);
			case TypesPackage.DOMAIN_NAME:
				return createDomainNameFromString(eDataType, initialValue);
			case TypesPackage.DSCP:
				return createDscpFromString(eDataType, initialValue);
			case TypesPackage.DSCP_OBJECT:
				return createDscpObjectFromString(eDataType, initialValue);
			case TypesPackage.HOST:
				return createHostFromString(eDataType, initialValue);
			case TypesPackage.HOST_MEMBER0:
				return createHostMember0FromString(eDataType, initialValue);
			case TypesPackage.HOST_MEMBER1:
				return createHostMember1FromString(eDataType, initialValue);
			case TypesPackage.IP_ADDRESS:
				return createIpAddressFromString(eDataType, initialValue);
			case TypesPackage.IP_ADDRESS_MEMBER0:
				return createIpAddressMember0FromString(eDataType, initialValue);
			case TypesPackage.IP_ADDRESS_MEMBER1:
				return createIpAddressMember1FromString(eDataType, initialValue);
			case TypesPackage.IP_PREFIX:
				return createIpPrefixFromString(eDataType, initialValue);
			case TypesPackage.IP_PREFIX_MEMBER0:
				return createIpPrefixMember0FromString(eDataType, initialValue);
			case TypesPackage.IP_PREFIX_MEMBER1:
				return createIpPrefixMember1FromString(eDataType, initialValue);
			case TypesPackage.IPV4_ADDRESS:
				return createIpv4AddressFromString(eDataType, initialValue);
			case TypesPackage.IPV4_PREFIX:
				return createIpv4PrefixFromString(eDataType, initialValue);
			case TypesPackage.IPV6_ADDRESS:
				return createIpv6AddressFromString(eDataType, initialValue);
			case TypesPackage.IPV6_FLOW_LABEL:
				return createIpv6FlowLabelFromString(eDataType, initialValue);
			case TypesPackage.IPV6_FLOW_LABEL_OBJECT:
				return createIpv6FlowLabelObjectFromString(eDataType, initialValue);
			case TypesPackage.IPV6_PREFIX:
				return createIpv6PrefixFromString(eDataType, initialValue);
			case TypesPackage.IP_VERSION_OBJECT:
				return createIpVersionObjectFromString(eDataType, initialValue);
			case TypesPackage.PORT_NUMBER:
				return createPortNumberFromString(eDataType, initialValue);
			case TypesPackage.PORT_NUMBER_OBJECT:
				return createPortNumberObjectFromString(eDataType, initialValue);
			case TypesPackage.T0:
				return createT0FromString(eDataType, initialValue);
			case TypesPackage.URI:
				return createUriFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TypesPackage.IP_VERSION:
				return convertIpVersionToString(eDataType, instanceValue);
			case TypesPackage.AS_NUMBER:
				return convertAsNumberToString(eDataType, instanceValue);
			case TypesPackage.AS_NUMBER_OBJECT:
				return convertAsNumberObjectToString(eDataType, instanceValue);
			case TypesPackage.DOMAIN_NAME:
				return convertDomainNameToString(eDataType, instanceValue);
			case TypesPackage.DSCP:
				return convertDscpToString(eDataType, instanceValue);
			case TypesPackage.DSCP_OBJECT:
				return convertDscpObjectToString(eDataType, instanceValue);
			case TypesPackage.HOST:
				return convertHostToString(eDataType, instanceValue);
			case TypesPackage.HOST_MEMBER0:
				return convertHostMember0ToString(eDataType, instanceValue);
			case TypesPackage.HOST_MEMBER1:
				return convertHostMember1ToString(eDataType, instanceValue);
			case TypesPackage.IP_ADDRESS:
				return convertIpAddressToString(eDataType, instanceValue);
			case TypesPackage.IP_ADDRESS_MEMBER0:
				return convertIpAddressMember0ToString(eDataType, instanceValue);
			case TypesPackage.IP_ADDRESS_MEMBER1:
				return convertIpAddressMember1ToString(eDataType, instanceValue);
			case TypesPackage.IP_PREFIX:
				return convertIpPrefixToString(eDataType, instanceValue);
			case TypesPackage.IP_PREFIX_MEMBER0:
				return convertIpPrefixMember0ToString(eDataType, instanceValue);
			case TypesPackage.IP_PREFIX_MEMBER1:
				return convertIpPrefixMember1ToString(eDataType, instanceValue);
			case TypesPackage.IPV4_ADDRESS:
				return convertIpv4AddressToString(eDataType, instanceValue);
			case TypesPackage.IPV4_PREFIX:
				return convertIpv4PrefixToString(eDataType, instanceValue);
			case TypesPackage.IPV6_ADDRESS:
				return convertIpv6AddressToString(eDataType, instanceValue);
			case TypesPackage.IPV6_FLOW_LABEL:
				return convertIpv6FlowLabelToString(eDataType, instanceValue);
			case TypesPackage.IPV6_FLOW_LABEL_OBJECT:
				return convertIpv6FlowLabelObjectToString(eDataType, instanceValue);
			case TypesPackage.IPV6_PREFIX:
				return convertIpv6PrefixToString(eDataType, instanceValue);
			case TypesPackage.IP_VERSION_OBJECT:
				return convertIpVersionObjectToString(eDataType, instanceValue);
			case TypesPackage.PORT_NUMBER:
				return convertPortNumberToString(eDataType, instanceValue);
			case TypesPackage.PORT_NUMBER_OBJECT:
				return convertPortNumberObjectToString(eDataType, instanceValue);
			case TypesPackage.T0:
				return convertT0ToString(eDataType, instanceValue);
			case TypesPackage.URI:
				return convertUriToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpVersion createIpVersionFromString(EDataType eDataType, String initialValue) {
		IpVersion result = IpVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createAsNumberFromString(EDataType eDataType, String initialValue) {
		return (Long)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_INT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAsNumberToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_INT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createAsNumberObjectFromString(EDataType eDataType, String initialValue) {
		return createAsNumberFromString(TypesPackage.Literals.AS_NUMBER, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAsNumberObjectToString(EDataType eDataType, Object instanceValue) {
		return convertAsNumberToString(TypesPackage.Literals.AS_NUMBER, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createDomainNameFromString(EDataType eDataType, String initialValue) {
		return createT0FromString(TypesPackage.Literals.T0, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDomainNameToString(EDataType eDataType, Object instanceValue) {
		return convertT0ToString(TypesPackage.Literals.T0, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Short createDscpFromString(EDataType eDataType, String initialValue) {
		return (Short)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_BYTE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDscpToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_BYTE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Short createDscpObjectFromString(EDataType eDataType, String initialValue) {
		return createDscpFromString(TypesPackage.Literals.DSCP, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDscpObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDscpToString(TypesPackage.Literals.DSCP, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createHostFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		String result = null;
		RuntimeException exception = null;
		try {
			result = createHostMember0FromString(TypesPackage.Literals.HOST_MEMBER0, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		try {
			result = createHostMember1FromString(TypesPackage.Literals.HOST_MEMBER1, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		if (result != null || exception == null) return result;
    
		throw exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHostToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		if (TypesPackage.Literals.HOST_MEMBER0.isInstance(instanceValue)) {
			try {
				String value = convertHostMember0ToString(TypesPackage.Literals.HOST_MEMBER0, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		if (TypesPackage.Literals.HOST_MEMBER1.isInstance(instanceValue)) {
			try {
				String value = convertHostMember1ToString(TypesPackage.Literals.HOST_MEMBER1, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		throw new IllegalArgumentException("Invalid value: '"+instanceValue+"' for datatype :"+eDataType.getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createHostMember0FromString(EDataType eDataType, String initialValue) {
		return createIpAddressFromString(TypesPackage.Literals.IP_ADDRESS, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHostMember0ToString(EDataType eDataType, Object instanceValue) {
		return convertIpAddressToString(TypesPackage.Literals.IP_ADDRESS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createHostMember1FromString(EDataType eDataType, String initialValue) {
		return createDomainNameFromString(TypesPackage.Literals.DOMAIN_NAME, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHostMember1ToString(EDataType eDataType, Object instanceValue) {
		return convertDomainNameToString(TypesPackage.Literals.DOMAIN_NAME, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpAddressFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		String result = null;
		RuntimeException exception = null;
		try {
			result = createIpAddressMember0FromString(TypesPackage.Literals.IP_ADDRESS_MEMBER0, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		try {
			result = createIpAddressMember1FromString(TypesPackage.Literals.IP_ADDRESS_MEMBER1, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		if (result != null || exception == null) return result;
    
		throw exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpAddressToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		if (TypesPackage.Literals.IP_ADDRESS_MEMBER0.isInstance(instanceValue)) {
			try {
				String value = convertIpAddressMember0ToString(TypesPackage.Literals.IP_ADDRESS_MEMBER0, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		if (TypesPackage.Literals.IP_ADDRESS_MEMBER1.isInstance(instanceValue)) {
			try {
				String value = convertIpAddressMember1ToString(TypesPackage.Literals.IP_ADDRESS_MEMBER1, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		throw new IllegalArgumentException("Invalid value: '"+instanceValue+"' for datatype :"+eDataType.getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpAddressMember0FromString(EDataType eDataType, String initialValue) {
		return createIpv4AddressFromString(TypesPackage.Literals.IPV4_ADDRESS, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpAddressMember0ToString(EDataType eDataType, Object instanceValue) {
		return convertIpv4AddressToString(TypesPackage.Literals.IPV4_ADDRESS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpAddressMember1FromString(EDataType eDataType, String initialValue) {
		return createIpv6AddressFromString(TypesPackage.Literals.IPV6_ADDRESS, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpAddressMember1ToString(EDataType eDataType, Object instanceValue) {
		return convertIpv6AddressToString(TypesPackage.Literals.IPV6_ADDRESS, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpPrefixFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		String result = null;
		RuntimeException exception = null;
		try {
			result = createIpPrefixMember0FromString(TypesPackage.Literals.IP_PREFIX_MEMBER0, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		try {
			result = createIpPrefixMember1FromString(TypesPackage.Literals.IP_PREFIX_MEMBER1, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		if (result != null || exception == null) return result;
    
		throw exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpPrefixToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		if (TypesPackage.Literals.IP_PREFIX_MEMBER0.isInstance(instanceValue)) {
			try {
				String value = convertIpPrefixMember0ToString(TypesPackage.Literals.IP_PREFIX_MEMBER0, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		if (TypesPackage.Literals.IP_PREFIX_MEMBER1.isInstance(instanceValue)) {
			try {
				String value = convertIpPrefixMember1ToString(TypesPackage.Literals.IP_PREFIX_MEMBER1, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		throw new IllegalArgumentException("Invalid value: '"+instanceValue+"' for datatype :"+eDataType.getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpPrefixMember0FromString(EDataType eDataType, String initialValue) {
		return createIpv4PrefixFromString(TypesPackage.Literals.IPV4_PREFIX, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpPrefixMember0ToString(EDataType eDataType, Object instanceValue) {
		return convertIpv4PrefixToString(TypesPackage.Literals.IPV4_PREFIX, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpPrefixMember1FromString(EDataType eDataType, String initialValue) {
		return createIpv6PrefixFromString(TypesPackage.Literals.IPV6_PREFIX, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpPrefixMember1ToString(EDataType eDataType, Object instanceValue) {
		return convertIpv6PrefixToString(TypesPackage.Literals.IPV6_PREFIX, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpv4AddressFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpv4AddressToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpv4PrefixFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpv4PrefixToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpv6AddressFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpv6AddressToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createIpv6FlowLabelFromString(EDataType eDataType, String initialValue) {
		return (Long)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_INT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpv6FlowLabelToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_INT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long createIpv6FlowLabelObjectFromString(EDataType eDataType, String initialValue) {
		return createIpv6FlowLabelFromString(TypesPackage.Literals.IPV6_FLOW_LABEL, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpv6FlowLabelObjectToString(EDataType eDataType, Object instanceValue) {
		return convertIpv6FlowLabelToString(TypesPackage.Literals.IPV6_FLOW_LABEL, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createIpv6PrefixFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpv6PrefixToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IpVersion createIpVersionObjectFromString(EDataType eDataType, String initialValue) {
		return createIpVersionFromString(TypesPackage.Literals.IP_VERSION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIpVersionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertIpVersionToString(TypesPackage.Literals.IP_VERSION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createPortNumberFromString(EDataType eDataType, String initialValue) {
		return (Integer)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.UNSIGNED_SHORT, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortNumberToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.UNSIGNED_SHORT, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createPortNumberObjectFromString(EDataType eDataType, String initialValue) {
		return createPortNumberFromString(TypesPackage.Literals.PORT_NUMBER, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPortNumberObjectToString(EDataType eDataType, Object instanceValue) {
		return convertPortNumberToString(TypesPackage.Literals.PORT_NUMBER, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createT0FromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertT0ToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createUriFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUriToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesPackage getTypesPackage() {
		return (TypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TypesPackage getPackage() {
		return TypesPackage.eINSTANCE;
	}

} //TypesFactoryImpl

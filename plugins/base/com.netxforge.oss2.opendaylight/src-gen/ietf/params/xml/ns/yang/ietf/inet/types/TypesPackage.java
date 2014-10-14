/**
 */
package ietf.params.xml.ns.yang.ietf.inet.types;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 *       This schema was generated from the YANG module ietf-inet-types
 * 
 *       The schema describes an instance document consisting
 *       of the entire configuration data store, operational
 *       data, rpc operations, and notifications.
 *       This schema can thus NOT be used as-is to
 *       validate NETCONF PDUs.
 *     
 * 
 *       This module contains a collection of generally useful derived
 *       YANG data types for Internet addresses and related things.
 * 
 *       Copyright (c) 2010 IETF Trust and the persons identified as
 *       authors of the code.  All rights reserved.
 * 
 *       Redistribution and use in source and binary forms, with or without
 *       modification, is permitted pursuant to, and subject to the license
 *       terms contained in, the Simplified BSD License set forth in Section
 *       4.c of the IETF Trust's Legal Provisions Relating to IETF Documents
 *       (http://trustee.ietf.org/license-info).
 * 
 *       This version of this YANG module is part of RFC 6021; see
 *       the RFC itself for full legal notices.
 *     
 * <!-- end-model-doc -->
 * @see ietf.params.xml.ns.yang.ietf.inet.types.TypesFactory
 * @model kind="package"
 *        annotation="http://www.w3.org/XML/1998/namespace lang='en'"
 * @generated
 */
public interface TypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "types";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:ietf:params:xml:ns:yang:ietf-inet-types";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "types";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesPackage eINSTANCE = ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link ietf.params.xml.ns.yang.ietf.inet.types.IpVersion <em>Ip Version</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.IpVersion
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpVersion()
	 * @generated
	 */
	int IP_VERSION = 0;

	/**
	 * The meta object id for the '<em>As Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getAsNumber()
	 * @generated
	 */
	int AS_NUMBER = 1;

	/**
	 * The meta object id for the '<em>As Number Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Long
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getAsNumberObject()
	 * @generated
	 */
	int AS_NUMBER_OBJECT = 2;

	/**
	 * The meta object id for the '<em>Domain Name</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getDomainName()
	 * @generated
	 */
	int DOMAIN_NAME = 3;

	/**
	 * The meta object id for the '<em>Dscp</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getDscp()
	 * @generated
	 */
	int DSCP = 4;

	/**
	 * The meta object id for the '<em>Dscp Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Short
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getDscpObject()
	 * @generated
	 */
	int DSCP_OBJECT = 5;

	/**
	 * The meta object id for the '<em>Host</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getHost()
	 * @generated
	 */
	int HOST = 6;

	/**
	 * The meta object id for the '<em>Host Member0</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getHostMember0()
	 * @generated
	 */
	int HOST_MEMBER0 = 7;

	/**
	 * The meta object id for the '<em>Host Member1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getHostMember1()
	 * @generated
	 */
	int HOST_MEMBER1 = 8;

	/**
	 * The meta object id for the '<em>Ip Address</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpAddress()
	 * @generated
	 */
	int IP_ADDRESS = 9;

	/**
	 * The meta object id for the '<em>Ip Address Member0</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpAddressMember0()
	 * @generated
	 */
	int IP_ADDRESS_MEMBER0 = 10;

	/**
	 * The meta object id for the '<em>Ip Address Member1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpAddressMember1()
	 * @generated
	 */
	int IP_ADDRESS_MEMBER1 = 11;

	/**
	 * The meta object id for the '<em>Ip Prefix</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpPrefix()
	 * @generated
	 */
	int IP_PREFIX = 12;

	/**
	 * The meta object id for the '<em>Ip Prefix Member0</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpPrefixMember0()
	 * @generated
	 */
	int IP_PREFIX_MEMBER0 = 13;

	/**
	 * The meta object id for the '<em>Ip Prefix Member1</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpPrefixMember1()
	 * @generated
	 */
	int IP_PREFIX_MEMBER1 = 14;

	/**
	 * The meta object id for the '<em>Ipv4 Address</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv4Address()
	 * @generated
	 */
	int IPV4_ADDRESS = 15;

	/**
	 * The meta object id for the '<em>Ipv4 Prefix</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv4Prefix()
	 * @generated
	 */
	int IPV4_PREFIX = 16;

	/**
	 * The meta object id for the '<em>Ipv6 Address</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv6Address()
	 * @generated
	 */
	int IPV6_ADDRESS = 17;

	/**
	 * The meta object id for the '<em>Ipv6 Flow Label</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv6FlowLabel()
	 * @generated
	 */
	int IPV6_FLOW_LABEL = 18;

	/**
	 * The meta object id for the '<em>Ipv6 Flow Label Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Long
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv6FlowLabelObject()
	 * @generated
	 */
	int IPV6_FLOW_LABEL_OBJECT = 19;

	/**
	 * The meta object id for the '<em>Ipv6 Prefix</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv6Prefix()
	 * @generated
	 */
	int IPV6_PREFIX = 20;

	/**
	 * The meta object id for the '<em>Ip Version Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.IpVersion
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpVersionObject()
	 * @generated
	 */
	int IP_VERSION_OBJECT = 21;

	/**
	 * The meta object id for the '<em>Port Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getPortNumber()
	 * @generated
	 */
	int PORT_NUMBER = 22;

	/**
	 * The meta object id for the '<em>Port Number Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Integer
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getPortNumberObject()
	 * @generated
	 */
	int PORT_NUMBER_OBJECT = 23;

	/**
	 * The meta object id for the '<em>T0</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getT0()
	 * @generated
	 */
	int T0 = 24;

	/**
	 * The meta object id for the '<em>Uri</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getUri()
	 * @generated
	 */
	int URI = 25;


	/**
	 * Returns the meta object for enum '{@link ietf.params.xml.ns.yang.ietf.inet.types.IpVersion <em>Ip Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Ip Version</em>'.
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.IpVersion
	 * @generated
	 */
	EEnum getIpVersion();

	/**
	 * Returns the meta object for data type '<em>As Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>As Number</em>'.
	 * @model instanceClass="long"
	 *        extendedMetaData="name='as-number' baseType='http://www.eclipse.org/emf/2003/XMLType#unsignedInt'"
	 * @generated
	 */
	EDataType getAsNumber();

	/**
	 * Returns the meta object for data type '{@link java.lang.Long <em>As Number Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>As Number Object</em>'.
	 * @see java.lang.Long
	 * @model instanceClass="java.lang.Long"
	 *        extendedMetaData="name='as-number:Object' baseType='as-number'"
	 * @generated
	 */
	EDataType getAsNumberObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Domain Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Domain Name</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='domain-name' baseType='t0' minLength='1' maxLength='253'"
	 * @generated
	 */
	EDataType getDomainName();

	/**
	 * Returns the meta object for data type '<em>Dscp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dscp</em>'.
	 * @model instanceClass="short"
	 *        extendedMetaData="name='dscp' baseType='http://www.eclipse.org/emf/2003/XMLType#unsignedByte' minInclusive='0' maxInclusive='63'"
	 * @generated
	 */
	EDataType getDscp();

	/**
	 * Returns the meta object for data type '{@link java.lang.Short <em>Dscp Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Dscp Object</em>'.
	 * @see java.lang.Short
	 * @model instanceClass="java.lang.Short"
	 *        extendedMetaData="name='dscp:Object' baseType='dscp'"
	 * @generated
	 */
	EDataType getDscpObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Host</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='host' memberTypes='host_._member_._0 host_._member_._1'"
	 * @generated
	 */
	EDataType getHost();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Host Member0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Host Member0</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='host_._member_._0' baseType='ip-address'"
	 * @generated
	 */
	EDataType getHostMember0();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Host Member1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Host Member1</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='host_._member_._1' baseType='domain-name'"
	 * @generated
	 */
	EDataType getHostMember1();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ip Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ip Address</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ip-address' memberTypes='ip-address_._member_._0 ip-address_._member_._1'"
	 * @generated
	 */
	EDataType getIpAddress();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ip Address Member0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ip Address Member0</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ip-address_._member_._0' baseType='ipv4-address'"
	 * @generated
	 */
	EDataType getIpAddressMember0();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ip Address Member1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ip Address Member1</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ip-address_._member_._1' baseType='ipv6-address'"
	 * @generated
	 */
	EDataType getIpAddressMember1();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ip Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ip Prefix</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ip-prefix' memberTypes='ip-prefix_._member_._0 ip-prefix_._member_._1'"
	 * @generated
	 */
	EDataType getIpPrefix();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ip Prefix Member0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ip Prefix Member0</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ip-prefix_._member_._0' baseType='ipv4-prefix'"
	 * @generated
	 */
	EDataType getIpPrefixMember0();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ip Prefix Member1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ip Prefix Member1</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ip-prefix_._member_._1' baseType='ipv6-prefix'"
	 * @generated
	 */
	EDataType getIpPrefixMember1();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ipv4 Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ipv4 Address</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ipv4-address' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(%25[\\p{N}\\p{L}]+)?'"
	 * @generated
	 */
	EDataType getIpv4Address();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ipv4 Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ipv4 Prefix</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ipv4-prefix' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])/(([0-9])|([1-2][0-9])|(3[0-2]))'"
	 * @generated
	 */
	EDataType getIpv4Prefix();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ipv6 Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ipv6 Address</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ipv6-address' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='(((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))(%25[\\p{N}\\p{L}]+)?)|((([^:]+:){6}(([^:]+:[^:]+)|(.*\\..*)))|((([^:]+:)*[^:]+)?::(([^:]+:)*[^:]+)?)(%25.+)?)'"
	 * @generated
	 */
	EDataType getIpv6Address();

	/**
	 * Returns the meta object for data type '<em>Ipv6 Flow Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ipv6 Flow Label</em>'.
	 * @model instanceClass="long"
	 *        extendedMetaData="name='ipv6-flow-label' baseType='http://www.eclipse.org/emf/2003/XMLType#unsignedInt' minInclusive='0' maxInclusive='1048575'"
	 * @generated
	 */
	EDataType getIpv6FlowLabel();

	/**
	 * Returns the meta object for data type '{@link java.lang.Long <em>Ipv6 Flow Label Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ipv6 Flow Label Object</em>'.
	 * @see java.lang.Long
	 * @model instanceClass="java.lang.Long"
	 *        extendedMetaData="name='ipv6-flow-label:Object' baseType='ipv6-flow-label'"
	 * @generated
	 */
	EDataType getIpv6FlowLabelObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Ipv6 Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ipv6 Prefix</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ipv6-prefix' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='(((:|[0-9a-fA-F]{0,4}):)([0-9a-fA-F]{0,4}:){0,5}((([0-9a-fA-F]{0,4}:)?(:|[0-9a-fA-F]{0,4}))|(((25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9]?[0-9])))(/(([0-9])|([0-9]{2})|(1[0-1][0-9])|(12[0-8]))))|((([^:]+:){6}(([^:]+:[^:]+)|(.*\\..*)))|((([^:]+:)*[^:]+)?::(([^:]+:)*[^:]+)?)(/.+))'"
	 * @generated
	 */
	EDataType getIpv6Prefix();

	/**
	 * Returns the meta object for data type '{@link ietf.params.xml.ns.yang.ietf.inet.types.IpVersion <em>Ip Version Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ip Version Object</em>'.
	 * @see ietf.params.xml.ns.yang.ietf.inet.types.IpVersion
	 * @model instanceClass="ietf.params.xml.ns.yang.ietf.inet.types.IpVersion"
	 *        extendedMetaData="name='ip-version:Object' baseType='ip-version'"
	 * @generated
	 */
	EDataType getIpVersionObject();

	/**
	 * Returns the meta object for data type '<em>Port Number</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Port Number</em>'.
	 * @model instanceClass="int"
	 *        extendedMetaData="name='port-number' baseType='http://www.eclipse.org/emf/2003/XMLType#unsignedShort' minInclusive='0' maxInclusive='65535'"
	 * @generated
	 */
	EDataType getPortNumber();

	/**
	 * Returns the meta object for data type '{@link java.lang.Integer <em>Port Number Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Port Number Object</em>'.
	 * @see java.lang.Integer
	 * @model instanceClass="java.lang.Integer"
	 *        extendedMetaData="name='port-number:Object' baseType='port-number'"
	 * @generated
	 */
	EDataType getPortNumberObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>T0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>T0</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='t0' baseType='http://www.eclipse.org/emf/2003/XMLType#string' pattern='((([a-zA-Z0-9_]([a-zA-Z0-9\\-_]){0,61})?[a-zA-Z0-9]\\.)*([a-zA-Z0-9_]([a-zA-Z0-9\\-_]){0,61})?[a-zA-Z0-9]\\.?)|\\.'"
	 * @generated
	 */
	EDataType getT0();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Uri</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='uri' baseType='http://www.eclipse.org/emf/2003/XMLType#string'"
	 * @generated
	 */
	EDataType getUri();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypesFactory getTypesFactory();

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
		 * The meta object literal for the '{@link ietf.params.xml.ns.yang.ietf.inet.types.IpVersion <em>Ip Version</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.IpVersion
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpVersion()
		 * @generated
		 */
		EEnum IP_VERSION = eINSTANCE.getIpVersion();

		/**
		 * The meta object literal for the '<em>As Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getAsNumber()
		 * @generated
		 */
		EDataType AS_NUMBER = eINSTANCE.getAsNumber();

		/**
		 * The meta object literal for the '<em>As Number Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Long
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getAsNumberObject()
		 * @generated
		 */
		EDataType AS_NUMBER_OBJECT = eINSTANCE.getAsNumberObject();

		/**
		 * The meta object literal for the '<em>Domain Name</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getDomainName()
		 * @generated
		 */
		EDataType DOMAIN_NAME = eINSTANCE.getDomainName();

		/**
		 * The meta object literal for the '<em>Dscp</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getDscp()
		 * @generated
		 */
		EDataType DSCP = eINSTANCE.getDscp();

		/**
		 * The meta object literal for the '<em>Dscp Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Short
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getDscpObject()
		 * @generated
		 */
		EDataType DSCP_OBJECT = eINSTANCE.getDscpObject();

		/**
		 * The meta object literal for the '<em>Host</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getHost()
		 * @generated
		 */
		EDataType HOST = eINSTANCE.getHost();

		/**
		 * The meta object literal for the '<em>Host Member0</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getHostMember0()
		 * @generated
		 */
		EDataType HOST_MEMBER0 = eINSTANCE.getHostMember0();

		/**
		 * The meta object literal for the '<em>Host Member1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getHostMember1()
		 * @generated
		 */
		EDataType HOST_MEMBER1 = eINSTANCE.getHostMember1();

		/**
		 * The meta object literal for the '<em>Ip Address</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpAddress()
		 * @generated
		 */
		EDataType IP_ADDRESS = eINSTANCE.getIpAddress();

		/**
		 * The meta object literal for the '<em>Ip Address Member0</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpAddressMember0()
		 * @generated
		 */
		EDataType IP_ADDRESS_MEMBER0 = eINSTANCE.getIpAddressMember0();

		/**
		 * The meta object literal for the '<em>Ip Address Member1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpAddressMember1()
		 * @generated
		 */
		EDataType IP_ADDRESS_MEMBER1 = eINSTANCE.getIpAddressMember1();

		/**
		 * The meta object literal for the '<em>Ip Prefix</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpPrefix()
		 * @generated
		 */
		EDataType IP_PREFIX = eINSTANCE.getIpPrefix();

		/**
		 * The meta object literal for the '<em>Ip Prefix Member0</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpPrefixMember0()
		 * @generated
		 */
		EDataType IP_PREFIX_MEMBER0 = eINSTANCE.getIpPrefixMember0();

		/**
		 * The meta object literal for the '<em>Ip Prefix Member1</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpPrefixMember1()
		 * @generated
		 */
		EDataType IP_PREFIX_MEMBER1 = eINSTANCE.getIpPrefixMember1();

		/**
		 * The meta object literal for the '<em>Ipv4 Address</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv4Address()
		 * @generated
		 */
		EDataType IPV4_ADDRESS = eINSTANCE.getIpv4Address();

		/**
		 * The meta object literal for the '<em>Ipv4 Prefix</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv4Prefix()
		 * @generated
		 */
		EDataType IPV4_PREFIX = eINSTANCE.getIpv4Prefix();

		/**
		 * The meta object literal for the '<em>Ipv6 Address</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv6Address()
		 * @generated
		 */
		EDataType IPV6_ADDRESS = eINSTANCE.getIpv6Address();

		/**
		 * The meta object literal for the '<em>Ipv6 Flow Label</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv6FlowLabel()
		 * @generated
		 */
		EDataType IPV6_FLOW_LABEL = eINSTANCE.getIpv6FlowLabel();

		/**
		 * The meta object literal for the '<em>Ipv6 Flow Label Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Long
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv6FlowLabelObject()
		 * @generated
		 */
		EDataType IPV6_FLOW_LABEL_OBJECT = eINSTANCE.getIpv6FlowLabelObject();

		/**
		 * The meta object literal for the '<em>Ipv6 Prefix</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpv6Prefix()
		 * @generated
		 */
		EDataType IPV6_PREFIX = eINSTANCE.getIpv6Prefix();

		/**
		 * The meta object literal for the '<em>Ip Version Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.IpVersion
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getIpVersionObject()
		 * @generated
		 */
		EDataType IP_VERSION_OBJECT = eINSTANCE.getIpVersionObject();

		/**
		 * The meta object literal for the '<em>Port Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getPortNumber()
		 * @generated
		 */
		EDataType PORT_NUMBER = eINSTANCE.getPortNumber();

		/**
		 * The meta object literal for the '<em>Port Number Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Integer
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getPortNumberObject()
		 * @generated
		 */
		EDataType PORT_NUMBER_OBJECT = eINSTANCE.getPortNumberObject();

		/**
		 * The meta object literal for the '<em>T0</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getT0()
		 * @generated
		 */
		EDataType T0 = eINSTANCE.getT0();

		/**
		 * The meta object literal for the '<em>Uri</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see ietf.params.xml.ns.yang.ietf.inet.types.impl.TypesPackageImpl#getUri()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getUri();

	}

} //TypesPackage

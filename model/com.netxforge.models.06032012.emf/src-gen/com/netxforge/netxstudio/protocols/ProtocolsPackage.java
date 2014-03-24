/**
 * Copyright (c) 2014 NetXForge
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * Christophe Bouhier - initial API and implementation and/or initial documentation
 */
package com.netxforge.netxstudio.protocols;

import com.netxforge.netxstudio.generics.GenericsPackage;

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
 * 		
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.protocols.ProtocolsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 *        annotation="http://www.eclipse.org/edapt historyURI='services.history'"
 * @generated
 */
public interface ProtocolsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "protocols";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/06032012/protocols";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "protocols";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProtocolsPackage eINSTANCE = com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.protocols.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.protocols.impl.MessageImpl
	 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__NAME = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = GenericsPackage.BASE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.protocols.impl.ProcedureImpl <em>Procedure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.protocols.impl.ProcedureImpl
	 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getProcedure()
	 * @generated
	 */
	int PROCEDURE = 1;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__MESSAGES = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE__NAME = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Procedure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEDURE_OPERATION_COUNT = GenericsPackage.BASE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.protocols.impl.ProtocolImpl <em>Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.protocols.impl.ProtocolImpl
	 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getProtocol()
	 * @generated
	 */
	int PROTOCOL = 2;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Procedures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__PROCEDURES = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__BODY_REF = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__NAME = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>OSI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__OSI = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL__SPECIFICATION = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTOCOL_OPERATION_COUNT = GenericsPackage.BASE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.protocols.OSIType <em>OSI Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.protocols.OSIType
	 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getOSIType()
	 * @generated
	 */
	int OSI_TYPE = 3;

	/**
	 * The meta object id for the '<em>OSI Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.protocols.OSIType
	 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getOSITypeObject()
	 * @generated
	 */
	int OSI_TYPE_OBJECT = 4;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.protocols.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see com.netxforge.netxstudio.protocols.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.protocols.Message#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.protocols.Message#getName()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.protocols.Message#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.protocols.Message#getDescription()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Description();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.protocols.Procedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Procedure</em>'.
	 * @see com.netxforge.netxstudio.protocols.Procedure
	 * @generated
	 */
	EClass getProcedure();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.protocols.Procedure#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see com.netxforge.netxstudio.protocols.Procedure#getMessages()
	 * @see #getProcedure()
	 * @generated
	 */
	EReference getProcedure_Messages();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.protocols.Procedure#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.protocols.Procedure#getName()
	 * @see #getProcedure()
	 * @generated
	 */
	EAttribute getProcedure_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.protocols.Protocol <em>Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protocol</em>'.
	 * @see com.netxforge.netxstudio.protocols.Protocol
	 * @generated
	 */
	EClass getProtocol();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.protocols.Protocol#getProcedures <em>Procedures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Procedures</em>'.
	 * @see com.netxforge.netxstudio.protocols.Protocol#getProcedures()
	 * @see #getProtocol()
	 * @generated
	 */
	EReference getProtocol_Procedures();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.protocols.Protocol#getBodyRef <em>Body Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Body Ref</em>'.
	 * @see com.netxforge.netxstudio.protocols.Protocol#getBodyRef()
	 * @see #getProtocol()
	 * @generated
	 */
	EReference getProtocol_BodyRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.protocols.Protocol#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.protocols.Protocol#getDescription()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.protocols.Protocol#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.protocols.Protocol#getName()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.protocols.Protocol#getOSI <em>OSI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>OSI</em>'.
	 * @see com.netxforge.netxstudio.protocols.Protocol#getOSI()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_OSI();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.protocols.Protocol#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification</em>'.
	 * @see com.netxforge.netxstudio.protocols.Protocol#getSpecification()
	 * @see #getProtocol()
	 * @generated
	 */
	EAttribute getProtocol_Specification();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.protocols.OSIType <em>OSI Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>OSI Type</em>'.
	 * @see com.netxforge.netxstudio.protocols.OSIType
	 * @generated
	 */
	EEnum getOSIType();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.protocols.OSIType <em>OSI Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>OSI Type Object</em>'.
	 * @see com.netxforge.netxstudio.protocols.OSIType
	 * @model instanceClass="com.netxforge.netxstudio.protocols.OSIType"
	 *        extendedMetaData="name='OSI_._type:Object' baseType='OSI_._type'"
	 * @generated
	 */
	EDataType getOSITypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProtocolsFactory getProtocolsFactory();

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
		 * The meta object literal for the '{@link com.netxforge.netxstudio.protocols.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.protocols.impl.MessageImpl
		 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__NAME = eINSTANCE.getMessage_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__DESCRIPTION = eINSTANCE.getMessage_Description();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.protocols.impl.ProcedureImpl <em>Procedure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.protocols.impl.ProcedureImpl
		 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getProcedure()
		 * @generated
		 */
		EClass PROCEDURE = eINSTANCE.getProcedure();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEDURE__MESSAGES = eINSTANCE.getProcedure_Messages();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEDURE__NAME = eINSTANCE.getProcedure_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.protocols.impl.ProtocolImpl <em>Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.protocols.impl.ProtocolImpl
		 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getProtocol()
		 * @generated
		 */
		EClass PROTOCOL = eINSTANCE.getProtocol();

		/**
		 * The meta object literal for the '<em><b>Procedures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL__PROCEDURES = eINSTANCE.getProtocol_Procedures();

		/**
		 * The meta object literal for the '<em><b>Body Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTOCOL__BODY_REF = eINSTANCE.getProtocol_BodyRef();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__DESCRIPTION = eINSTANCE.getProtocol_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__NAME = eINSTANCE.getProtocol_Name();

		/**
		 * The meta object literal for the '<em><b>OSI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__OSI = eINSTANCE.getProtocol_OSI();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROTOCOL__SPECIFICATION = eINSTANCE.getProtocol_Specification();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.protocols.OSIType <em>OSI Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.protocols.OSIType
		 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getOSIType()
		 * @generated
		 */
		EEnum OSI_TYPE = eINSTANCE.getOSIType();

		/**
		 * The meta object literal for the '<em>OSI Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.protocols.OSIType
		 * @see com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl#getOSITypeObject()
		 * @generated
		 */
		EDataType OSI_TYPE_OBJECT = eINSTANCE.getOSITypeObject();

	}

} //ProtocolsPackage

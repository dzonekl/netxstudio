/**
 * Copyright (c) 2011 NetXForge
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
package com.netxforge.netxstudio.generics.impl;

import com.netxforge.netxstudio.generics.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.DiagramKindType;
import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Meta;
import com.netxforge.netxstudio.generics.MultiImage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericsFactoryImpl extends EFactoryImpl implements GenericsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GenericsFactory init() {
		try {
			GenericsFactory theGenericsFactory = (GenericsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.netxforge.com/13042011/generics"); 
			if (theGenericsFactory != null) {
				return theGenericsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GenericsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsFactoryImpl() {
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
			case GenericsPackage.COMMIT_LOG_ENTRY: return (EObject)createCommitLogEntry();
			case GenericsPackage.COMPANY: return (EObject)createCompany();
			case GenericsPackage.DATE_TIME_RANGE: return (EObject)createDateTimeRange();
			case GenericsPackage.DIAGRAM_INFO: return (EObject)createDiagramInfo();
			case GenericsPackage.LIFECYCLE: return (EObject)createLifecycle();
			case GenericsPackage.META: return (EObject)createMeta();
			case GenericsPackage.MULTI_IMAGE: return (EObject)createMultiImage();
			case GenericsPackage.PERSON: return (EObject)createPerson();
			case GenericsPackage.ROLE: return (EObject)createRole();
			case GenericsPackage.VALUE: return (EObject)createValue();
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
			case GenericsPackage.ACTION_TYPE:
				return createActionTypeFromString(eDataType, initialValue);
			case GenericsPackage.DIAGRAM_KIND_TYPE:
				return createDiagramKindTypeFromString(eDataType, initialValue);
			case GenericsPackage.EXPANSION_DURATION:
				return createExpansionDurationFromString(eDataType, initialValue);
			case GenericsPackage.ACTION_TYPE_OBJECT:
				return createActionTypeObjectFromString(eDataType, initialValue);
			case GenericsPackage.DESCRIPTION2000:
				return createDescription2000FromString(eDataType, initialValue);
			case GenericsPackage.DIAGRAM_KIND_TYPE_OBJECT:
				return createDiagramKindTypeObjectFromString(eDataType, initialValue);
			case GenericsPackage.EXPANSION_DURATION_OBJECT:
				return createExpansionDurationObjectFromString(eDataType, initialValue);
			case GenericsPackage.EXPRESSION_LINE:
				return createExpressionLineFromString(eDataType, initialValue);
			case GenericsPackage.NAME255:
				return createName255FromString(eDataType, initialValue);
			case GenericsPackage.UNIT_CODE:
				return createUnitCodeFromString(eDataType, initialValue);
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
			case GenericsPackage.ACTION_TYPE:
				return convertActionTypeToString(eDataType, instanceValue);
			case GenericsPackage.DIAGRAM_KIND_TYPE:
				return convertDiagramKindTypeToString(eDataType, instanceValue);
			case GenericsPackage.EXPANSION_DURATION:
				return convertExpansionDurationToString(eDataType, instanceValue);
			case GenericsPackage.ACTION_TYPE_OBJECT:
				return convertActionTypeObjectToString(eDataType, instanceValue);
			case GenericsPackage.DESCRIPTION2000:
				return convertDescription2000ToString(eDataType, instanceValue);
			case GenericsPackage.DIAGRAM_KIND_TYPE_OBJECT:
				return convertDiagramKindTypeObjectToString(eDataType, instanceValue);
			case GenericsPackage.EXPANSION_DURATION_OBJECT:
				return convertExpansionDurationObjectToString(eDataType, instanceValue);
			case GenericsPackage.EXPRESSION_LINE:
				return convertExpressionLineToString(eDataType, instanceValue);
			case GenericsPackage.NAME255:
				return convertName255ToString(eDataType, instanceValue);
			case GenericsPackage.UNIT_CODE:
				return convertUnitCodeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommitLogEntry createCommitLogEntry() {
		CommitLogEntryImpl commitLogEntry = new CommitLogEntryImpl();
		return commitLogEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Company createCompany() {
		CompanyImpl company = new CompanyImpl();
		return company;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTimeRange createDateTimeRange() {
		DateTimeRangeImpl dateTimeRange = new DateTimeRangeImpl();
		return dateTimeRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramInfo createDiagramInfo() {
		DiagramInfoImpl diagramInfo = new DiagramInfoImpl();
		return diagramInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lifecycle createLifecycle() {
		LifecycleImpl lifecycle = new LifecycleImpl();
		return lifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Meta createMeta() {
		MetaImpl meta = new MetaImpl();
		return meta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiImage createMultiImage() {
		MultiImageImpl multiImage = new MultiImageImpl();
		return multiImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Person createPerson() {
		PersonImpl person = new PersonImpl();
		return person;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType createActionTypeFromString(EDataType eDataType, String initialValue) {
		ActionType result = ActionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramKindType createDiagramKindTypeFromString(EDataType eDataType, String initialValue) {
		DiagramKindType result = DiagramKindType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDiagramKindTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDuration createExpansionDurationFromString(EDataType eDataType, String initialValue) {
		ExpansionDuration result = ExpansionDuration.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExpansionDurationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType createActionTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createActionTypeFromString(GenericsPackage.Literals.ACTION_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertActionTypeToString(GenericsPackage.Literals.ACTION_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createDescription2000FromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDescription2000ToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramKindType createDiagramKindTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDiagramKindTypeFromString(GenericsPackage.Literals.DIAGRAM_KIND_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDiagramKindTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDiagramKindTypeToString(GenericsPackage.Literals.DIAGRAM_KIND_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionDuration createExpansionDurationObjectFromString(EDataType eDataType, String initialValue) {
		return createExpansionDurationFromString(GenericsPackage.Literals.EXPANSION_DURATION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExpansionDurationObjectToString(EDataType eDataType, Object instanceValue) {
		return convertExpansionDurationToString(GenericsPackage.Literals.EXPANSION_DURATION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createExpressionLineFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExpressionLineToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createName255FromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertName255ToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createUnitCodeFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnitCodeToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsPackage getGenericsPackage() {
		return (GenericsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GenericsPackage getPackage() {
		return GenericsPackage.eINSTANCE;
	}

} //GenericsFactoryImpl

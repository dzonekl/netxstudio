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
package com.netxforge.netxstudio.generics;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.generics.GenericsFactory
 * @model kind="package"
 * @generated
 */
public interface GenericsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/13042011/generics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "generics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenericsPackage eINSTANCE = com.netxforge.netxstudio.generics.impl.GenericsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.CompanyImpl <em>Company</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.CompanyImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getCompany()
	 * @generated
	 */
	int COMPANY = 0;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__ICONS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__NAME = 1;

	/**
	 * The feature id for the '<em><b>RS Surl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__RS_SURL = 2;

	/**
	 * The feature id for the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__SHORT_NAME = 3;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__SYMBOL = 4;

	/**
	 * The feature id for the '<em><b>Website</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY__WEBSITE = 5;

	/**
	 * The number of structural features of the '<em>Company</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPANY_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.DateTimeRangeImpl <em>Date Time Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.DateTimeRangeImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDateTimeRange()
	 * @generated
	 */
	int DATE_TIME_RANGE = 1;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME_RANGE__BEGIN = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME_RANGE__END = 1;

	/**
	 * The number of structural features of the '<em>Date Time Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_TIME_RANGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.DiagramInfoImpl <em>Diagram Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.DiagramInfoImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDiagramInfo()
	 * @generated
	 */
	int DIAGRAM_INFO = 2;

	/**
	 * The feature id for the '<em><b>Diagram Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_INFO__DIAGRAM_KIND = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_INFO__LOCATION = 1;

	/**
	 * The number of structural features of the '<em>Diagram Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl <em>Lifecycle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.LifecycleImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getLifecycle()
	 * @generated
	 */
	int LIFECYCLE = 3;

	/**
	 * The feature id for the '<em><b>Construction Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE__CONSTRUCTION_DATE = 0;

	/**
	 * The feature id for the '<em><b>In Service Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE__IN_SERVICE_DATE = 1;

	/**
	 * The feature id for the '<em><b>Out Of Service Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE__OUT_OF_SERVICE_DATE = 2;

	/**
	 * The feature id for the '<em><b>Planned Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE__PLANNED_DATE = 3;

	/**
	 * The feature id for the '<em><b>Proposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE__PROPOSED = 4;

	/**
	 * The number of structural features of the '<em>Lifecycle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFECYCLE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.MetaImpl <em>Meta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.MetaImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getMeta()
	 * @generated
	 */
	int META = 4;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META__VERSION = 2;

	/**
	 * The number of structural features of the '<em>Meta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.MultiImageImpl <em>Multi Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.MultiImageImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getMultiImage()
	 * @generated
	 */
	int MULTI_IMAGE = 5;

	/**
	 * The feature id for the '<em><b>Obj16</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_IMAGE__OBJ16 = 0;

	/**
	 * The feature id for the '<em><b>Obj32</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_IMAGE__OBJ32 = 1;

	/**
	 * The feature id for the '<em><b>Obj48</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_IMAGE__OBJ48 = 2;

	/**
	 * The feature id for the '<em><b>Obj96</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_IMAGE__OBJ96 = 3;

	/**
	 * The feature id for the '<em><b>Obj128</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_IMAGE__OBJ128 = 4;

	/**
	 * The number of structural features of the '<em>Multi Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_IMAGE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.PersonImpl <em>Person</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.PersonImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getPerson()
	 * @generated
	 */
	int PERSON = 6;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__ACTIVE = 0;

	/**
	 * The feature id for the '<em><b>Company Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__COMPANY_REF = 1;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__EMAIL = 2;

	/**
	 * The feature id for the '<em><b>First Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__FIRST_NAME = 3;

	/**
	 * The feature id for the '<em><b>Last Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LAST_NAME = 4;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__LOGIN = 5;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON__PASSWORD = 6;

	/**
	 * The number of structural features of the '<em>Person</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSON_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.RoleImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.impl.ValueImpl
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 8;

	/**
	 * The feature id for the '<em><b>Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__TIME_STAMP = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.DiagramKindType <em>Diagram Kind Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.DiagramKindType
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDiagramKindType()
	 * @generated
	 */
	int DIAGRAM_KIND_TYPE = 9;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.generics.ExpansionDuration <em>Expansion Duration</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.ExpansionDuration
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getExpansionDuration()
	 * @generated
	 */
	int EXPANSION_DURATION = 10;

	/**
	 * The meta object id for the '<em>Description2000</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDescription2000()
	 * @generated
	 */
	int DESCRIPTION2000 = 11;

	/**
	 * The meta object id for the '<em>Diagram Kind Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.DiagramKindType
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDiagramKindTypeObject()
	 * @generated
	 */
	int DIAGRAM_KIND_TYPE_OBJECT = 12;

	/**
	 * The meta object id for the '<em>Expansion Duration Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.generics.ExpansionDuration
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getExpansionDurationObject()
	 * @generated
	 */
	int EXPANSION_DURATION_OBJECT = 13;

	/**
	 * The meta object id for the '<em>Expression Line</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getExpressionLine()
	 * @generated
	 */
	int EXPRESSION_LINE = 14;

	/**
	 * The meta object id for the '<em>Name255</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getName255()
	 * @generated
	 */
	int NAME255 = 15;

	/**
	 * The meta object id for the '<em>Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 16;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.Company <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Company</em>'.
	 * @see com.netxforge.netxstudio.generics.Company
	 * @generated
	 */
	EClass getCompany();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.generics.Company#getIcons <em>Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icons</em>'.
	 * @see com.netxforge.netxstudio.generics.Company#getIcons()
	 * @see #getCompany()
	 * @generated
	 */
	EReference getCompany_Icons();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Company#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.generics.Company#getName()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Company#getRSSurl <em>RS Surl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>RS Surl</em>'.
	 * @see com.netxforge.netxstudio.generics.Company#getRSSurl()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_RSSurl();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Company#getShortName <em>Short Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Short Name</em>'.
	 * @see com.netxforge.netxstudio.generics.Company#getShortName()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_ShortName();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Company#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see com.netxforge.netxstudio.generics.Company#getSymbol()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_Symbol();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Company#getWebsite <em>Website</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Website</em>'.
	 * @see com.netxforge.netxstudio.generics.Company#getWebsite()
	 * @see #getCompany()
	 * @generated
	 */
	EAttribute getCompany_Website();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.DateTimeRange <em>Date Time Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date Time Range</em>'.
	 * @see com.netxforge.netxstudio.generics.DateTimeRange
	 * @generated
	 */
	EClass getDateTimeRange();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.DateTimeRange#getBegin <em>Begin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Begin</em>'.
	 * @see com.netxforge.netxstudio.generics.DateTimeRange#getBegin()
	 * @see #getDateTimeRange()
	 * @generated
	 */
	EAttribute getDateTimeRange_Begin();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.DateTimeRange#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see com.netxforge.netxstudio.generics.DateTimeRange#getEnd()
	 * @see #getDateTimeRange()
	 * @generated
	 */
	EAttribute getDateTimeRange_End();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.DiagramInfo <em>Diagram Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Info</em>'.
	 * @see com.netxforge.netxstudio.generics.DiagramInfo
	 * @generated
	 */
	EClass getDiagramInfo();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.DiagramInfo#getDiagramKind <em>Diagram Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagram Kind</em>'.
	 * @see com.netxforge.netxstudio.generics.DiagramInfo#getDiagramKind()
	 * @see #getDiagramInfo()
	 * @generated
	 */
	EAttribute getDiagramInfo_DiagramKind();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.DiagramInfo#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see com.netxforge.netxstudio.generics.DiagramInfo#getLocation()
	 * @see #getDiagramInfo()
	 * @generated
	 */
	EAttribute getDiagramInfo_Location();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.Lifecycle <em>Lifecycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lifecycle</em>'.
	 * @see com.netxforge.netxstudio.generics.Lifecycle
	 * @generated
	 */
	EClass getLifecycle();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Lifecycle#getConstructionDate <em>Construction Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Construction Date</em>'.
	 * @see com.netxforge.netxstudio.generics.Lifecycle#getConstructionDate()
	 * @see #getLifecycle()
	 * @generated
	 */
	EAttribute getLifecycle_ConstructionDate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Lifecycle#getInServiceDate <em>In Service Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Service Date</em>'.
	 * @see com.netxforge.netxstudio.generics.Lifecycle#getInServiceDate()
	 * @see #getLifecycle()
	 * @generated
	 */
	EAttribute getLifecycle_InServiceDate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Lifecycle#getOutOfServiceDate <em>Out Of Service Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Out Of Service Date</em>'.
	 * @see com.netxforge.netxstudio.generics.Lifecycle#getOutOfServiceDate()
	 * @see #getLifecycle()
	 * @generated
	 */
	EAttribute getLifecycle_OutOfServiceDate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Lifecycle#getPlannedDate <em>Planned Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Planned Date</em>'.
	 * @see com.netxforge.netxstudio.generics.Lifecycle#getPlannedDate()
	 * @see #getLifecycle()
	 * @generated
	 */
	EAttribute getLifecycle_PlannedDate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Lifecycle#getProposed <em>Proposed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proposed</em>'.
	 * @see com.netxforge.netxstudio.generics.Lifecycle#getProposed()
	 * @see #getLifecycle()
	 * @generated
	 */
	EAttribute getLifecycle_Proposed();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.Meta <em>Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta</em>'.
	 * @see com.netxforge.netxstudio.generics.Meta
	 * @generated
	 */
	EClass getMeta();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.generics.Meta#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Author</em>'.
	 * @see com.netxforge.netxstudio.generics.Meta#getAuthor()
	 * @see #getMeta()
	 * @generated
	 */
	EReference getMeta_Author();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Meta#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.generics.Meta#getDescription()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Meta#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.netxforge.netxstudio.generics.Meta#getVersion()
	 * @see #getMeta()
	 * @generated
	 */
	EAttribute getMeta_Version();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.MultiImage <em>Multi Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Image</em>'.
	 * @see com.netxforge.netxstudio.generics.MultiImage
	 * @generated
	 */
	EClass getMultiImage();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.MultiImage#getObj16 <em>Obj16</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obj16</em>'.
	 * @see com.netxforge.netxstudio.generics.MultiImage#getObj16()
	 * @see #getMultiImage()
	 * @generated
	 */
	EAttribute getMultiImage_Obj16();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.MultiImage#getObj32 <em>Obj32</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obj32</em>'.
	 * @see com.netxforge.netxstudio.generics.MultiImage#getObj32()
	 * @see #getMultiImage()
	 * @generated
	 */
	EAttribute getMultiImage_Obj32();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.MultiImage#getObj48 <em>Obj48</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obj48</em>'.
	 * @see com.netxforge.netxstudio.generics.MultiImage#getObj48()
	 * @see #getMultiImage()
	 * @generated
	 */
	EAttribute getMultiImage_Obj48();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.MultiImage#getObj96 <em>Obj96</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obj96</em>'.
	 * @see com.netxforge.netxstudio.generics.MultiImage#getObj96()
	 * @see #getMultiImage()
	 * @generated
	 */
	EAttribute getMultiImage_Obj96();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.MultiImage#getObj128 <em>Obj128</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obj128</em>'.
	 * @see com.netxforge.netxstudio.generics.MultiImage#getObj128()
	 * @see #getMultiImage()
	 * @generated
	 */
	EAttribute getMultiImage_Obj128();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.Person <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Person</em>'.
	 * @see com.netxforge.netxstudio.generics.Person
	 * @generated
	 */
	EClass getPerson();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Person#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see com.netxforge.netxstudio.generics.Person#isActive()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Active();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.generics.Person#getCompanyRef <em>Company Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Company Ref</em>'.
	 * @see com.netxforge.netxstudio.generics.Person#getCompanyRef()
	 * @see #getPerson()
	 * @generated
	 */
	EReference getPerson_CompanyRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Person#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see com.netxforge.netxstudio.generics.Person#getEmail()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Email();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Person#getFirstName <em>First Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Name</em>'.
	 * @see com.netxforge.netxstudio.generics.Person#getFirstName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_FirstName();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Person#getLastName <em>Last Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Name</em>'.
	 * @see com.netxforge.netxstudio.generics.Person#getLastName()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_LastName();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Person#getLogin <em>Login</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Login</em>'.
	 * @see com.netxforge.netxstudio.generics.Person#getLogin()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Login();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Person#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.netxforge.netxstudio.generics.Person#getPassword()
	 * @see #getPerson()
	 * @generated
	 */
	EAttribute getPerson_Password();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see com.netxforge.netxstudio.generics.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Role#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.generics.Role#getName()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.generics.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see com.netxforge.netxstudio.generics.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Value#getTimeStamp <em>Time Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Stamp</em>'.
	 * @see com.netxforge.netxstudio.generics.Value#getTimeStamp()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_TimeStamp();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.generics.Value#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see com.netxforge.netxstudio.generics.Value#getValue()
	 * @see #getValue()
	 * @generated
	 */
	EAttribute getValue_Value();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.generics.DiagramKindType <em>Diagram Kind Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Diagram Kind Type</em>'.
	 * @see com.netxforge.netxstudio.generics.DiagramKindType
	 * @generated
	 */
	EEnum getDiagramKindType();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.generics.ExpansionDuration <em>Expansion Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Expansion Duration</em>'.
	 * @see com.netxforge.netxstudio.generics.ExpansionDuration
	 * @generated
	 */
	EEnum getExpansionDuration();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Description2000</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Description2000</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Description2000' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='2000'"
	 * @generated
	 */
	EDataType getDescription2000();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.generics.DiagramKindType <em>Diagram Kind Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Diagram Kind Type Object</em>'.
	 * @see com.netxforge.netxstudio.generics.DiagramKindType
	 * @model instanceClass="com.netxforge.netxstudio.generics.DiagramKindType"
	 *        extendedMetaData="name='DiagramKind_._type:Object' baseType='DiagramKind_._type'"
	 * @generated
	 */
	EDataType getDiagramKindTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.generics.ExpansionDuration <em>Expansion Duration Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Expansion Duration Object</em>'.
	 * @see com.netxforge.netxstudio.generics.ExpansionDuration
	 * @model instanceClass="com.netxforge.netxstudio.generics.ExpansionDuration"
	 *        extendedMetaData="name='ExpansionDuration:Object' baseType='ExpansionDuration'"
	 * @generated
	 */
	EDataType getExpansionDurationObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Expression Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Expression Line</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='ExpressionLine' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='1000'"
	 * @generated
	 */
	EDataType getExpressionLine();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Name255</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Name255</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Name255' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='255'"
	 * @generated
	 */
	EDataType getName255();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Unit</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='Unit' baseType='http://www.eclipse.org/emf/2003/XMLType#string' maxLength='3'"
	 * @generated
	 */
	EDataType getUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GenericsFactory getGenericsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.CompanyImpl <em>Company</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.CompanyImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getCompany()
		 * @generated
		 */
		EClass COMPANY = eINSTANCE.getCompany();

		/**
		 * The meta object literal for the '<em><b>Icons</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPANY__ICONS = eINSTANCE.getCompany_Icons();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__NAME = eINSTANCE.getCompany_Name();

		/**
		 * The meta object literal for the '<em><b>RS Surl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__RS_SURL = eINSTANCE.getCompany_RSSurl();

		/**
		 * The meta object literal for the '<em><b>Short Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__SHORT_NAME = eINSTANCE.getCompany_ShortName();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__SYMBOL = eINSTANCE.getCompany_Symbol();

		/**
		 * The meta object literal for the '<em><b>Website</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPANY__WEBSITE = eINSTANCE.getCompany_Website();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.DateTimeRangeImpl <em>Date Time Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.DateTimeRangeImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDateTimeRange()
		 * @generated
		 */
		EClass DATE_TIME_RANGE = eINSTANCE.getDateTimeRange();

		/**
		 * The meta object literal for the '<em><b>Begin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_TIME_RANGE__BEGIN = eINSTANCE.getDateTimeRange_Begin();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_TIME_RANGE__END = eINSTANCE.getDateTimeRange_End();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.DiagramInfoImpl <em>Diagram Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.DiagramInfoImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDiagramInfo()
		 * @generated
		 */
		EClass DIAGRAM_INFO = eINSTANCE.getDiagramInfo();

		/**
		 * The meta object literal for the '<em><b>Diagram Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_INFO__DIAGRAM_KIND = eINSTANCE.getDiagramInfo_DiagramKind();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGRAM_INFO__LOCATION = eINSTANCE.getDiagramInfo_Location();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl <em>Lifecycle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.LifecycleImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getLifecycle()
		 * @generated
		 */
		EClass LIFECYCLE = eINSTANCE.getLifecycle();

		/**
		 * The meta object literal for the '<em><b>Construction Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE__CONSTRUCTION_DATE = eINSTANCE.getLifecycle_ConstructionDate();

		/**
		 * The meta object literal for the '<em><b>In Service Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE__IN_SERVICE_DATE = eINSTANCE.getLifecycle_InServiceDate();

		/**
		 * The meta object literal for the '<em><b>Out Of Service Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE__OUT_OF_SERVICE_DATE = eINSTANCE.getLifecycle_OutOfServiceDate();

		/**
		 * The meta object literal for the '<em><b>Planned Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE__PLANNED_DATE = eINSTANCE.getLifecycle_PlannedDate();

		/**
		 * The meta object literal for the '<em><b>Proposed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIFECYCLE__PROPOSED = eINSTANCE.getLifecycle_Proposed();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.MetaImpl <em>Meta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.MetaImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getMeta()
		 * @generated
		 */
		EClass META = eINSTANCE.getMeta();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META__AUTHOR = eINSTANCE.getMeta_Author();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META__DESCRIPTION = eINSTANCE.getMeta_Description();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META__VERSION = eINSTANCE.getMeta_Version();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.MultiImageImpl <em>Multi Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.MultiImageImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getMultiImage()
		 * @generated
		 */
		EClass MULTI_IMAGE = eINSTANCE.getMultiImage();

		/**
		 * The meta object literal for the '<em><b>Obj16</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_IMAGE__OBJ16 = eINSTANCE.getMultiImage_Obj16();

		/**
		 * The meta object literal for the '<em><b>Obj32</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_IMAGE__OBJ32 = eINSTANCE.getMultiImage_Obj32();

		/**
		 * The meta object literal for the '<em><b>Obj48</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_IMAGE__OBJ48 = eINSTANCE.getMultiImage_Obj48();

		/**
		 * The meta object literal for the '<em><b>Obj96</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_IMAGE__OBJ96 = eINSTANCE.getMultiImage_Obj96();

		/**
		 * The meta object literal for the '<em><b>Obj128</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_IMAGE__OBJ128 = eINSTANCE.getMultiImage_Obj128();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.PersonImpl <em>Person</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.PersonImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getPerson()
		 * @generated
		 */
		EClass PERSON = eINSTANCE.getPerson();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__ACTIVE = eINSTANCE.getPerson_Active();

		/**
		 * The meta object literal for the '<em><b>Company Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSON__COMPANY_REF = eINSTANCE.getPerson_CompanyRef();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__EMAIL = eINSTANCE.getPerson_Email();

		/**
		 * The meta object literal for the '<em><b>First Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__FIRST_NAME = eINSTANCE.getPerson_FirstName();

		/**
		 * The meta object literal for the '<em><b>Last Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LAST_NAME = eINSTANCE.getPerson_LastName();

		/**
		 * The meta object literal for the '<em><b>Login</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__LOGIN = eINSTANCE.getPerson_Login();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSON__PASSWORD = eINSTANCE.getPerson_Password();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.RoleImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__NAME = eINSTANCE.getRole_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.impl.ValueImpl
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '<em><b>Time Stamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__TIME_STAMP = eINSTANCE.getValue_TimeStamp();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE__VALUE = eINSTANCE.getValue_Value();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.DiagramKindType <em>Diagram Kind Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.DiagramKindType
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDiagramKindType()
		 * @generated
		 */
		EEnum DIAGRAM_KIND_TYPE = eINSTANCE.getDiagramKindType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.generics.ExpansionDuration <em>Expansion Duration</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.ExpansionDuration
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getExpansionDuration()
		 * @generated
		 */
		EEnum EXPANSION_DURATION = eINSTANCE.getExpansionDuration();

		/**
		 * The meta object literal for the '<em>Description2000</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDescription2000()
		 * @generated
		 */
		EDataType DESCRIPTION2000 = eINSTANCE.getDescription2000();

		/**
		 * The meta object literal for the '<em>Diagram Kind Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.DiagramKindType
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getDiagramKindTypeObject()
		 * @generated
		 */
		EDataType DIAGRAM_KIND_TYPE_OBJECT = eINSTANCE.getDiagramKindTypeObject();

		/**
		 * The meta object literal for the '<em>Expansion Duration Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.generics.ExpansionDuration
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getExpansionDurationObject()
		 * @generated
		 */
		EDataType EXPANSION_DURATION_OBJECT = eINSTANCE.getExpansionDurationObject();

		/**
		 * The meta object literal for the '<em>Expression Line</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getExpressionLine()
		 * @generated
		 */
		EDataType EXPRESSION_LINE = eINSTANCE.getExpressionLine();

		/**
		 * The meta object literal for the '<em>Name255</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getName255()
		 * @generated
		 */
		EDataType NAME255 = eINSTANCE.getName255();

		/**
		 * The meta object literal for the '<em>Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see com.netxforge.netxstudio.generics.impl.GenericsPackageImpl#getUnit()
		 * @generated
		 */
		EDataType UNIT = eINSTANCE.getUnit();

	}

} //GenericsPackage

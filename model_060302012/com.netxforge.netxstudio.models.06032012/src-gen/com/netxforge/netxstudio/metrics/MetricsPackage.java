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
package com.netxforge.netxstudio.metrics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.netxforge.netxstudio.generics.GenericsPackage;

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
 * <!-- begin-model-doc -->
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 
 * 			Validation with pattern is not used, considering the limited
 * 			capabilities of
 * 			XSD patterns.
 * 
 * 		
 * 
 * 		
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 
 * 			Validation with pattern is not used, considering the limited
 * 			capabilities of
 * 			XSD patterns.
 * 
 * 		
 * 
 * 		
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.metrics.MetricsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface MetricsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metrics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/06032012/metrics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "metrics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetricsPackage eINSTANCE = com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.DataKindImpl <em>Data Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.DataKindImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getDataKind()
	 * @generated
	 */
	int DATA_KIND = 0;

	/**
	 * The number of structural features of the '<em>Data Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_KIND_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl <em>Identifier Data Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getIdentifierDataKind()
	 * @generated
	 */
	int IDENTIFIER_DATA_KIND = 1;

	/**
	 * The feature id for the '<em><b>Object Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_DATA_KIND__OBJECT_KIND = DATA_KIND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Object Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_DATA_KIND__OBJECT_PROPERTY = DATA_KIND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_DATA_KIND__PATTERN = DATA_KIND_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Identifier Data Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_DATA_KIND_FEATURE_COUNT = DATA_KIND_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MappingImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 2;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Header Mapping Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__HEADER_MAPPING_COLUMNS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Mapping Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DATA_MAPPING_COLUMNS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>First Data Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__FIRST_DATA_ROW = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Header Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__HEADER_ROW = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__INTERVAL_HINT = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MappingColumnImpl <em>Mapping Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MappingColumnImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingColumn()
	 * @generated
	 */
	int MAPPING_COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_COLUMN__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_COLUMN__DATA_TYPE = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_COLUMN__COLUMN = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_COLUMN_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MappingCSVImpl <em>Mapping CSV</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MappingCSVImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingCSV()
	 * @generated
	 */
	int MAPPING_CSV = 4;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV__DELETED = MAPPING__DELETED;

	/**
	 * The feature id for the '<em><b>Header Mapping Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV__HEADER_MAPPING_COLUMNS = MAPPING__HEADER_MAPPING_COLUMNS;

	/**
	 * The feature id for the '<em><b>Data Mapping Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV__DATA_MAPPING_COLUMNS = MAPPING__DATA_MAPPING_COLUMNS;

	/**
	 * The feature id for the '<em><b>First Data Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV__FIRST_DATA_ROW = MAPPING__FIRST_DATA_ROW;

	/**
	 * The feature id for the '<em><b>Header Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV__HEADER_ROW = MAPPING__HEADER_ROW;

	/**
	 * The feature id for the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV__INTERVAL_HINT = MAPPING__INTERVAL_HINT;

	/**
	 * The feature id for the '<em><b>Delimiter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV__DELIMITER = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV__FILTER_PATTERN = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping CSV</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CSV_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl <em>Mapping RDBMS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingRDBMS()
	 * @generated
	 */
	int MAPPING_RDBMS = 5;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__DELETED = MAPPING__DELETED;

	/**
	 * The feature id for the '<em><b>Header Mapping Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__HEADER_MAPPING_COLUMNS = MAPPING__HEADER_MAPPING_COLUMNS;

	/**
	 * The feature id for the '<em><b>Data Mapping Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__DATA_MAPPING_COLUMNS = MAPPING__DATA_MAPPING_COLUMNS;

	/**
	 * The feature id for the '<em><b>First Data Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__FIRST_DATA_ROW = MAPPING__FIRST_DATA_ROW;

	/**
	 * The feature id for the '<em><b>Header Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__HEADER_ROW = MAPPING__HEADER_ROW;

	/**
	 * The feature id for the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__INTERVAL_HINT = MAPPING__INTERVAL_HINT;

	/**
	 * The feature id for the '<em><b>Database Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__DATABASE_TYPE = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__DATE_FORMAT = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Date Time Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__DATE_TIME_FORMAT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__PASSWORD = MAPPING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__QUERY = MAPPING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Time Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__TIME_FORMAT = MAPPING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS__USER = MAPPING_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Mapping RDBMS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RDBMS_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MappingRecordImpl <em>Mapping Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MappingRecordImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingRecord()
	 * @generated
	 */
	int MAPPING_RECORD = 6;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RECORD__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RECORD__COLUMN = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RECORD__COUNT = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RECORD__MESSAGE = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_RECORD_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl <em>Mapping Statistic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingStatistic()
	 * @generated
	 */
	int MAPPING_STATISTIC = 7;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Failed Records</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC__FAILED_RECORDS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC__MAPPING_DURATION = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Period Estimate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC__PERIOD_ESTIMATE = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sub Statistics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC__SUB_STATISTICS = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Interval Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC__INTERVAL_ESTIMATE = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC__MESSAGE = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Total Records</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC__TOTAL_RECORDS = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Mapping Statistic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATISTIC_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl <em>Mapping XLS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MappingXLSImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingXLS()
	 * @generated
	 */
	int MAPPING_XLS = 8;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS__DELETED = MAPPING__DELETED;

	/**
	 * The feature id for the '<em><b>Header Mapping Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS__HEADER_MAPPING_COLUMNS = MAPPING__HEADER_MAPPING_COLUMNS;

	/**
	 * The feature id for the '<em><b>Data Mapping Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS__DATA_MAPPING_COLUMNS = MAPPING__DATA_MAPPING_COLUMNS;

	/**
	 * The feature id for the '<em><b>First Data Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS__FIRST_DATA_ROW = MAPPING__FIRST_DATA_ROW;

	/**
	 * The feature id for the '<em><b>Header Row</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS__HEADER_ROW = MAPPING__HEADER_ROW;

	/**
	 * The feature id for the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS__INTERVAL_HINT = MAPPING__INTERVAL_HINT;

	/**
	 * The feature id for the '<em><b>Filter Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS__FILTER_PATTERN = MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sheet Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS__SHEET_NUMBER = MAPPING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping XLS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_XLS_FEATURE_COUNT = MAPPING_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MetricImpl <em>Metric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MetricImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetric()
	 * @generated
	 */
	int METRIC = 9;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Metrics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__METRICS = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__EXPRESSION_REF = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__DESCRIPTION = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Measurement Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__MEASUREMENT_KIND = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Measurement Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__MEASUREMENT_POINT = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Metric Source Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__METRIC_SOURCE_REF = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__NAME = GenericsPackage.BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Unit Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC__UNIT_REF = GenericsPackage.BASE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Metric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MetricRetentionRuleImpl <em>Metric Retention Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MetricRetentionRuleImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricRetentionRule()
	 * @generated
	 */
	int METRIC_RETENTION_RULE = 10;

	/**
	 * The feature id for the '<em><b>Retention Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE__RETENTION_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE__INTERVAL_HINT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE__PERIOD = 3;

	/**
	 * The number of structural features of the '<em>Metric Retention Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MetricRetentionRulesImpl <em>Metric Retention Rules</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MetricRetentionRulesImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricRetentionRules()
	 * @generated
	 */
	int METRIC_RETENTION_RULES = 11;

	/**
	 * The feature id for the '<em><b>Metric Retention Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULES__METRIC_RETENTION_RULES = 0;

	/**
	 * The number of structural features of the '<em>Metric Retention Rules</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_RETENTION_RULES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl <em>Metric Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MetricSourceImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricSource()
	 * @generated
	 */
	int METRIC_SOURCE = 12;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Metric Mapping</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__METRIC_MAPPING = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statistics</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__STATISTICS = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filter Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__FILTER_PATTERN = GenericsPackage.BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Metric Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__METRIC_LOCATION = GenericsPackage.BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE__NAME = GenericsPackage.BASE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Metric Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_SOURCE_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.MetricValueRangeImpl <em>Metric Value Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.MetricValueRangeImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricValueRange()
	 * @generated
	 */
	int METRIC_VALUE_RANGE = 13;

	/**
	 * The feature id for the '<em><b>Metric Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_VALUE_RANGE__METRIC_VALUES = 0;

	/**
	 * The feature id for the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_VALUE_RANGE__INTERVAL_HINT = 1;

	/**
	 * The feature id for the '<em><b>Kind Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_VALUE_RANGE__KIND_HINT = 2;

	/**
	 * The number of structural features of the '<em>Metric Value Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METRIC_VALUE_RANGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl <em>Value Data Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getValueDataKind()
	 * @generated
	 */
	int VALUE_DATA_KIND = 14;

	/**
	 * The feature id for the '<em><b>Metric Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DATA_KIND__METRIC_REF = DATA_KIND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DATA_KIND__FORMAT = DATA_KIND_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kind Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DATA_KIND__KIND_HINT = DATA_KIND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DATA_KIND__VALUE_KIND = DATA_KIND_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Value Data Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DATA_KIND_FEATURE_COUNT = DATA_KIND_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.DatabaseTypeType <em>Database Type Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.DatabaseTypeType
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getDatabaseTypeType()
	 * @generated
	 */
	int DATABASE_TYPE_TYPE = 15;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.KindHintType <em>Kind Hint Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getKindHintType()
	 * @generated
	 */
	int KIND_HINT_TYPE = 16;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.MetricRetentionPeriod <em>Metric Retention Period</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionPeriod
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricRetentionPeriod()
	 * @generated
	 */
	int METRIC_RETENTION_PERIOD = 17;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.ObjectKindType <em>Object Kind Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.ObjectKindType
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getObjectKindType()
	 * @generated
	 */
	int OBJECT_KIND_TYPE = 18;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.metrics.ValueKindType <em>Value Kind Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.ValueKindType
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getValueKindType()
	 * @generated
	 */
	int VALUE_KIND_TYPE = 19;

	/**
	 * The meta object id for the '<em>Database Type Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.DatabaseTypeType
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getDatabaseTypeTypeObject()
	 * @generated
	 */
	int DATABASE_TYPE_TYPE_OBJECT = 20;

	/**
	 * The meta object id for the '<em>Kind Hint Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getKindHintTypeObject()
	 * @generated
	 */
	int KIND_HINT_TYPE_OBJECT = 21;

	/**
	 * The meta object id for the '<em>Metric Retention Period Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionPeriod
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricRetentionPeriodObject()
	 * @generated
	 */
	int METRIC_RETENTION_PERIOD_OBJECT = 22;

	/**
	 * The meta object id for the '<em>Object Kind Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.ObjectKindType
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getObjectKindTypeObject()
	 * @generated
	 */
	int OBJECT_KIND_TYPE_OBJECT = 23;

	/**
	 * The meta object id for the '<em>Value Kind Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.metrics.ValueKindType
	 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getValueKindTypeObject()
	 * @generated
	 */
	int VALUE_KIND_TYPE_OBJECT = 24;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.DataKind <em>Data Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Kind</em>'.
	 * @see com.netxforge.netxstudio.metrics.DataKind
	 * @generated
	 */
	EClass getDataKind();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind <em>Identifier Data Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier Data Kind</em>'.
	 * @see com.netxforge.netxstudio.metrics.IdentifierDataKind
	 * @generated
	 */
	EClass getIdentifierDataKind();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectKind <em>Object Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Kind</em>'.
	 * @see com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectKind()
	 * @see #getIdentifierDataKind()
	 * @generated
	 */
	EAttribute getIdentifierDataKind_ObjectKind();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectProperty <em>Object Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object Property</em>'.
	 * @see com.netxforge.netxstudio.metrics.IdentifierDataKind#getObjectProperty()
	 * @see #getIdentifierDataKind()
	 * @generated
	 */
	EAttribute getIdentifierDataKind_ObjectProperty();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see com.netxforge.netxstudio.metrics.IdentifierDataKind#getPattern()
	 * @see #getIdentifierDataKind()
	 * @generated
	 */
	EAttribute getIdentifierDataKind_Pattern();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see com.netxforge.netxstudio.metrics.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.metrics.Mapping#getHeaderMappingColumns <em>Header Mapping Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Header Mapping Columns</em>'.
	 * @see com.netxforge.netxstudio.metrics.Mapping#getHeaderMappingColumns()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_HeaderMappingColumns();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.metrics.Mapping#getDataMappingColumns <em>Data Mapping Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Mapping Columns</em>'.
	 * @see com.netxforge.netxstudio.metrics.Mapping#getDataMappingColumns()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_DataMappingColumns();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.Mapping#getFirstDataRow <em>First Data Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>First Data Row</em>'.
	 * @see com.netxforge.netxstudio.metrics.Mapping#getFirstDataRow()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_FirstDataRow();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.Mapping#getHeaderRow <em>Header Row</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header Row</em>'.
	 * @see com.netxforge.netxstudio.metrics.Mapping#getHeaderRow()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_HeaderRow();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.Mapping#getIntervalHint <em>Interval Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval Hint</em>'.
	 * @see com.netxforge.netxstudio.metrics.Mapping#getIntervalHint()
	 * @see #getMapping()
	 * @generated
	 */
	EAttribute getMapping_IntervalHint();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MappingColumn <em>Mapping Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Column</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingColumn
	 * @generated
	 */
	EClass getMappingColumn();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.metrics.MappingColumn#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Type</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingColumn#getDataType()
	 * @see #getMappingColumn()
	 * @generated
	 */
	EReference getMappingColumn_DataType();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingColumn#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingColumn#getColumn()
	 * @see #getMappingColumn()
	 * @generated
	 */
	EAttribute getMappingColumn_Column();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MappingCSV <em>Mapping CSV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping CSV</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingCSV
	 * @generated
	 */
	EClass getMappingCSV();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingCSV#getDelimiter <em>Delimiter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delimiter</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingCSV#getDelimiter()
	 * @see #getMappingCSV()
	 * @generated
	 */
	EAttribute getMappingCSV_Delimiter();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingCSV#getFilterPattern <em>Filter Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter Pattern</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingCSV#getFilterPattern()
	 * @see #getMappingCSV()
	 * @generated
	 */
	EAttribute getMappingCSV_FilterPattern();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MappingRDBMS <em>Mapping RDBMS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping RDBMS</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS
	 * @generated
	 */
	EClass getMappingRDBMS();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getDatabaseType <em>Database Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Database Type</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS#getDatabaseType()
	 * @see #getMappingRDBMS()
	 * @generated
	 */
	EAttribute getMappingRDBMS_DatabaseType();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getDateFormat <em>Date Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Format</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS#getDateFormat()
	 * @see #getMappingRDBMS()
	 * @generated
	 */
	EAttribute getMappingRDBMS_DateFormat();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getDateTimeFormat <em>Date Time Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date Time Format</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS#getDateTimeFormat()
	 * @see #getMappingRDBMS()
	 * @generated
	 */
	EAttribute getMappingRDBMS_DateTimeFormat();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS#getPassword()
	 * @see #getMappingRDBMS()
	 * @generated
	 */
	EAttribute getMappingRDBMS_Password();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS#getQuery()
	 * @see #getMappingRDBMS()
	 * @generated
	 */
	EAttribute getMappingRDBMS_Query();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getTimeFormat <em>Time Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Format</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS#getTimeFormat()
	 * @see #getMappingRDBMS()
	 * @generated
	 */
	EAttribute getMappingRDBMS_TimeFormat();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRDBMS#getUser <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS#getUser()
	 * @see #getMappingRDBMS()
	 * @generated
	 */
	EAttribute getMappingRDBMS_User();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MappingRecord <em>Mapping Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Record</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRecord
	 * @generated
	 */
	EClass getMappingRecord();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRecord#getColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRecord#getColumn()
	 * @see #getMappingRecord()
	 * @generated
	 */
	EAttribute getMappingRecord_Column();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRecord#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRecord#getCount()
	 * @see #getMappingRecord()
	 * @generated
	 */
	EAttribute getMappingRecord_Count();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingRecord#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingRecord#getMessage()
	 * @see #getMappingRecord()
	 * @generated
	 */
	EAttribute getMappingRecord_Message();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MappingStatistic <em>Mapping Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Statistic</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic
	 * @generated
	 */
	EClass getMappingStatistic();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getFailedRecords <em>Failed Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Failed Records</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic#getFailedRecords()
	 * @see #getMappingStatistic()
	 * @generated
	 */
	EReference getMappingStatistic_FailedRecords();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getMappingDuration <em>Mapping Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Duration</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic#getMappingDuration()
	 * @see #getMappingStatistic()
	 * @generated
	 */
	EReference getMappingStatistic_MappingDuration();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getPeriodEstimate <em>Period Estimate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Period Estimate</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic#getPeriodEstimate()
	 * @see #getMappingStatistic()
	 * @generated
	 */
	EReference getMappingStatistic_PeriodEstimate();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getSubStatistics <em>Sub Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Statistics</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic#getSubStatistics()
	 * @see #getMappingStatistic()
	 * @generated
	 */
	EReference getMappingStatistic_SubStatistics();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getIntervalEstimate <em>Interval Estimate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval Estimate</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic#getIntervalEstimate()
	 * @see #getMappingStatistic()
	 * @generated
	 */
	EAttribute getMappingStatistic_IntervalEstimate();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic#getMessage()
	 * @see #getMappingStatistic()
	 * @generated
	 */
	EAttribute getMappingStatistic_Message();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingStatistic#getTotalRecords <em>Total Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Records</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic#getTotalRecords()
	 * @see #getMappingStatistic()
	 * @generated
	 */
	EAttribute getMappingStatistic_TotalRecords();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MappingXLS <em>Mapping XLS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping XLS</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingXLS
	 * @generated
	 */
	EClass getMappingXLS();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingXLS#getFilterPattern <em>Filter Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter Pattern</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingXLS#getFilterPattern()
	 * @see #getMappingXLS()
	 * @generated
	 */
	EAttribute getMappingXLS_FilterPattern();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MappingXLS#getSheetNumber <em>Sheet Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sheet Number</em>'.
	 * @see com.netxforge.netxstudio.metrics.MappingXLS#getSheetNumber()
	 * @see #getMappingXLS()
	 * @generated
	 */
	EAttribute getMappingXLS_SheetNumber();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric
	 * @generated
	 */
	EClass getMetric();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.metrics.Metric#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metrics</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric#getMetrics()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_Metrics();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.metrics.Metric#getExpressionRef <em>Expression Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression Ref</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric#getExpressionRef()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_ExpressionRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.Metric#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric#getDescription()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Description();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.Metric#getMeasurementKind <em>Measurement Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measurement Kind</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric#getMeasurementKind()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_MeasurementKind();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.Metric#getMeasurementPoint <em>Measurement Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measurement Point</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric#getMeasurementPoint()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_MeasurementPoint();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.metrics.Metric#getMetricSourceRef <em>Metric Source Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Source Ref</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric#getMetricSourceRef()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_MetricSourceRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.Metric#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric#getName()
	 * @see #getMetric()
	 * @generated
	 */
	EAttribute getMetric_Name();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.metrics.Metric#getUnitRef <em>Unit Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit Ref</em>'.
	 * @see com.netxforge.netxstudio.metrics.Metric#getUnitRef()
	 * @see #getMetric()
	 * @generated
	 */
	EReference getMetric_UnitRef();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule <em>Metric Retention Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Retention Rule</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRule
	 * @generated
	 */
	EClass getMetricRetentionRule();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getRetentionExpression <em>Retention Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Retention Expression</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRule#getRetentionExpression()
	 * @see #getMetricRetentionRule()
	 * @generated
	 */
	EReference getMetricRetentionRule_RetentionExpression();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval Hint</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRule#getIntervalHint()
	 * @see #getMetricRetentionRule()
	 * @generated
	 */
	EAttribute getMetricRetentionRule_IntervalHint();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRule#getName()
	 * @see #getMetricRetentionRule()
	 * @generated
	 */
	EAttribute getMetricRetentionRule_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRule#getPeriod()
	 * @see #getMetricRetentionRule()
	 * @generated
	 */
	EAttribute getMetricRetentionRule_Period();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MetricRetentionRules <em>Metric Retention Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Retention Rules</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRules
	 * @generated
	 */
	EClass getMetricRetentionRules();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.metrics.MetricRetentionRules#getMetricRetentionRules <em>Metric Retention Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Retention Rules</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRules#getMetricRetentionRules()
	 * @see #getMetricRetentionRules()
	 * @generated
	 */
	EReference getMetricRetentionRules_MetricRetentionRules();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MetricSource <em>Metric Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Source</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricSource
	 * @generated
	 */
	EClass getMetricSource();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.metrics.MetricSource#getMetricMapping <em>Metric Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Metric Mapping</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricSource#getMetricMapping()
	 * @see #getMetricSource()
	 * @generated
	 */
	EReference getMetricSource_MetricMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.metrics.MetricSource#getStatistics <em>Statistics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statistics</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricSource#getStatistics()
	 * @see #getMetricSource()
	 * @generated
	 */
	EReference getMetricSource_Statistics();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MetricSource#getFilterPattern <em>Filter Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter Pattern</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricSource#getFilterPattern()
	 * @see #getMetricSource()
	 * @generated
	 */
	EAttribute getMetricSource_FilterPattern();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MetricSource#getMetricLocation <em>Metric Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metric Location</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricSource#getMetricLocation()
	 * @see #getMetricSource()
	 * @generated
	 */
	EAttribute getMetricSource_MetricLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MetricSource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricSource#getName()
	 * @see #getMetricSource()
	 * @generated
	 */
	EAttribute getMetricSource_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.MetricValueRange <em>Metric Value Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metric Value Range</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricValueRange
	 * @generated
	 */
	EClass getMetricValueRange();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getMetricValues <em>Metric Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metric Values</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricValueRange#getMetricValues()
	 * @see #getMetricValueRange()
	 * @generated
	 */
	EReference getMetricValueRange_MetricValues();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getIntervalHint <em>Interval Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interval Hint</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricValueRange#getIntervalHint()
	 * @see #getMetricValueRange()
	 * @generated
	 */
	EAttribute getMetricValueRange_IntervalHint();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getKindHint <em>Kind Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind Hint</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricValueRange#getKindHint()
	 * @see #getMetricValueRange()
	 * @generated
	 */
	EAttribute getMetricValueRange_KindHint();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.metrics.ValueDataKind <em>Value Data Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Data Kind</em>'.
	 * @see com.netxforge.netxstudio.metrics.ValueDataKind
	 * @generated
	 */
	EClass getValueDataKind();

	/**
	 * Returns the meta object for the reference '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getMetricRef <em>Metric Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metric Ref</em>'.
	 * @see com.netxforge.netxstudio.metrics.ValueDataKind#getMetricRef()
	 * @see #getValueDataKind()
	 * @generated
	 */
	EReference getValueDataKind_MetricRef();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see com.netxforge.netxstudio.metrics.ValueDataKind#getFormat()
	 * @see #getValueDataKind()
	 * @generated
	 */
	EAttribute getValueDataKind_Format();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getKindHint <em>Kind Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind Hint</em>'.
	 * @see com.netxforge.netxstudio.metrics.ValueDataKind#getKindHint()
	 * @see #getValueDataKind()
	 * @generated
	 */
	EAttribute getValueDataKind_KindHint();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.metrics.ValueDataKind#getValueKind <em>Value Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Kind</em>'.
	 * @see com.netxforge.netxstudio.metrics.ValueDataKind#getValueKind()
	 * @see #getValueDataKind()
	 * @generated
	 */
	EAttribute getValueDataKind_ValueKind();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.metrics.DatabaseTypeType <em>Database Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Database Type Type</em>'.
	 * @see com.netxforge.netxstudio.metrics.DatabaseTypeType
	 * @generated
	 */
	EEnum getDatabaseTypeType();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.metrics.KindHintType <em>Kind Hint Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Kind Hint Type</em>'.
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @generated
	 */
	EEnum getKindHintType();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.metrics.MetricRetentionPeriod <em>Metric Retention Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Metric Retention Period</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionPeriod
	 * @generated
	 */
	EEnum getMetricRetentionPeriod();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.metrics.ObjectKindType <em>Object Kind Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Object Kind Type</em>'.
	 * @see com.netxforge.netxstudio.metrics.ObjectKindType
	 * @generated
	 */
	EEnum getObjectKindType();

	/**
	 * Returns the meta object for enum '{@link com.netxforge.netxstudio.metrics.ValueKindType <em>Value Kind Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Value Kind Type</em>'.
	 * @see com.netxforge.netxstudio.metrics.ValueKindType
	 * @generated
	 */
	EEnum getValueKindType();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.metrics.DatabaseTypeType <em>Database Type Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Database Type Type Object</em>'.
	 * @see com.netxforge.netxstudio.metrics.DatabaseTypeType
	 * @model instanceClass="com.netxforge.netxstudio.metrics.DatabaseTypeType"
	 *        extendedMetaData="name='DatabaseType_._type:Object' baseType='DatabaseType_._type'"
	 * @generated
	 */
	EDataType getDatabaseTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.metrics.KindHintType <em>Kind Hint Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Kind Hint Type Object</em>'.
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @model instanceClass="com.netxforge.netxstudio.metrics.KindHintType"
	 *        extendedMetaData="name='KindHintType:Object' baseType='KindHintType'"
	 * @generated
	 */
	EDataType getKindHintTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.metrics.MetricRetentionPeriod <em>Metric Retention Period Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Metric Retention Period Object</em>'.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionPeriod
	 * @model instanceClass="com.netxforge.netxstudio.metrics.MetricRetentionPeriod"
	 *        extendedMetaData="name='MetricRetentionPeriod:Object' baseType='MetricRetentionPeriod'"
	 * @generated
	 */
	EDataType getMetricRetentionPeriodObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.metrics.ObjectKindType <em>Object Kind Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object Kind Type Object</em>'.
	 * @see com.netxforge.netxstudio.metrics.ObjectKindType
	 * @model instanceClass="com.netxforge.netxstudio.metrics.ObjectKindType"
	 *        extendedMetaData="name='ObjectKind_._type:Object' baseType='ObjectKind_._type'"
	 * @generated
	 */
	EDataType getObjectKindTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.netxforge.netxstudio.metrics.ValueKindType <em>Value Kind Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Value Kind Type Object</em>'.
	 * @see com.netxforge.netxstudio.metrics.ValueKindType
	 * @model instanceClass="com.netxforge.netxstudio.metrics.ValueKindType"
	 *        extendedMetaData="name='ValueKind_._type:Object' baseType='ValueKind_._type'"
	 * @generated
	 */
	EDataType getValueKindTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetricsFactory getMetricsFactory();

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
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.DataKindImpl <em>Data Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.DataKindImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getDataKind()
		 * @generated
		 */
		EClass DATA_KIND = eINSTANCE.getDataKind();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl <em>Identifier Data Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.IdentifierDataKindImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getIdentifierDataKind()
		 * @generated
		 */
		EClass IDENTIFIER_DATA_KIND = eINSTANCE.getIdentifierDataKind();

		/**
		 * The meta object literal for the '<em><b>Object Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER_DATA_KIND__OBJECT_KIND = eINSTANCE.getIdentifierDataKind_ObjectKind();

		/**
		 * The meta object literal for the '<em><b>Object Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER_DATA_KIND__OBJECT_PROPERTY = eINSTANCE.getIdentifierDataKind_ObjectProperty();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER_DATA_KIND__PATTERN = eINSTANCE.getIdentifierDataKind_Pattern();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MappingImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Header Mapping Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__HEADER_MAPPING_COLUMNS = eINSTANCE.getMapping_HeaderMappingColumns();

		/**
		 * The meta object literal for the '<em><b>Data Mapping Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__DATA_MAPPING_COLUMNS = eINSTANCE.getMapping_DataMappingColumns();

		/**
		 * The meta object literal for the '<em><b>First Data Row</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__FIRST_DATA_ROW = eINSTANCE.getMapping_FirstDataRow();

		/**
		 * The meta object literal for the '<em><b>Header Row</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__HEADER_ROW = eINSTANCE.getMapping_HeaderRow();

		/**
		 * The meta object literal for the '<em><b>Interval Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING__INTERVAL_HINT = eINSTANCE.getMapping_IntervalHint();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MappingColumnImpl <em>Mapping Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MappingColumnImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingColumn()
		 * @generated
		 */
		EClass MAPPING_COLUMN = eINSTANCE.getMappingColumn();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_COLUMN__DATA_TYPE = eINSTANCE.getMappingColumn_DataType();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_COLUMN__COLUMN = eINSTANCE.getMappingColumn_Column();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MappingCSVImpl <em>Mapping CSV</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MappingCSVImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingCSV()
		 * @generated
		 */
		EClass MAPPING_CSV = eINSTANCE.getMappingCSV();

		/**
		 * The meta object literal for the '<em><b>Delimiter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CSV__DELIMITER = eINSTANCE.getMappingCSV_Delimiter();

		/**
		 * The meta object literal for the '<em><b>Filter Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CSV__FILTER_PATTERN = eINSTANCE.getMappingCSV_FilterPattern();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl <em>Mapping RDBMS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MappingRDBMSImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingRDBMS()
		 * @generated
		 */
		EClass MAPPING_RDBMS = eINSTANCE.getMappingRDBMS();

		/**
		 * The meta object literal for the '<em><b>Database Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RDBMS__DATABASE_TYPE = eINSTANCE.getMappingRDBMS_DatabaseType();

		/**
		 * The meta object literal for the '<em><b>Date Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RDBMS__DATE_FORMAT = eINSTANCE.getMappingRDBMS_DateFormat();

		/**
		 * The meta object literal for the '<em><b>Date Time Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RDBMS__DATE_TIME_FORMAT = eINSTANCE.getMappingRDBMS_DateTimeFormat();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RDBMS__PASSWORD = eINSTANCE.getMappingRDBMS_Password();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RDBMS__QUERY = eINSTANCE.getMappingRDBMS_Query();

		/**
		 * The meta object literal for the '<em><b>Time Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RDBMS__TIME_FORMAT = eINSTANCE.getMappingRDBMS_TimeFormat();

		/**
		 * The meta object literal for the '<em><b>User</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RDBMS__USER = eINSTANCE.getMappingRDBMS_User();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MappingRecordImpl <em>Mapping Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MappingRecordImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingRecord()
		 * @generated
		 */
		EClass MAPPING_RECORD = eINSTANCE.getMappingRecord();

		/**
		 * The meta object literal for the '<em><b>Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RECORD__COLUMN = eINSTANCE.getMappingRecord_Column();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RECORD__COUNT = eINSTANCE.getMappingRecord_Count();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_RECORD__MESSAGE = eINSTANCE.getMappingRecord_Message();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl <em>Mapping Statistic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingStatistic()
		 * @generated
		 */
		EClass MAPPING_STATISTIC = eINSTANCE.getMappingStatistic();

		/**
		 * The meta object literal for the '<em><b>Failed Records</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATISTIC__FAILED_RECORDS = eINSTANCE.getMappingStatistic_FailedRecords();

		/**
		 * The meta object literal for the '<em><b>Mapping Duration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATISTIC__MAPPING_DURATION = eINSTANCE.getMappingStatistic_MappingDuration();

		/**
		 * The meta object literal for the '<em><b>Period Estimate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATISTIC__PERIOD_ESTIMATE = eINSTANCE.getMappingStatistic_PeriodEstimate();

		/**
		 * The meta object literal for the '<em><b>Sub Statistics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_STATISTIC__SUB_STATISTICS = eINSTANCE.getMappingStatistic_SubStatistics();

		/**
		 * The meta object literal for the '<em><b>Interval Estimate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_STATISTIC__INTERVAL_ESTIMATE = eINSTANCE.getMappingStatistic_IntervalEstimate();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_STATISTIC__MESSAGE = eINSTANCE.getMappingStatistic_Message();

		/**
		 * The meta object literal for the '<em><b>Total Records</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_STATISTIC__TOTAL_RECORDS = eINSTANCE.getMappingStatistic_TotalRecords();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MappingXLSImpl <em>Mapping XLS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MappingXLSImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMappingXLS()
		 * @generated
		 */
		EClass MAPPING_XLS = eINSTANCE.getMappingXLS();

		/**
		 * The meta object literal for the '<em><b>Filter Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_XLS__FILTER_PATTERN = eINSTANCE.getMappingXLS_FilterPattern();

		/**
		 * The meta object literal for the '<em><b>Sheet Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_XLS__SHEET_NUMBER = eINSTANCE.getMappingXLS_SheetNumber();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MetricImpl <em>Metric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MetricImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetric()
		 * @generated
		 */
		EClass METRIC = eINSTANCE.getMetric();

		/**
		 * The meta object literal for the '<em><b>Metrics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__METRICS = eINSTANCE.getMetric_Metrics();

		/**
		 * The meta object literal for the '<em><b>Expression Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__EXPRESSION_REF = eINSTANCE.getMetric_ExpressionRef();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__DESCRIPTION = eINSTANCE.getMetric_Description();

		/**
		 * The meta object literal for the '<em><b>Measurement Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__MEASUREMENT_KIND = eINSTANCE.getMetric_MeasurementKind();

		/**
		 * The meta object literal for the '<em><b>Measurement Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__MEASUREMENT_POINT = eINSTANCE.getMetric_MeasurementPoint();

		/**
		 * The meta object literal for the '<em><b>Metric Source Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__METRIC_SOURCE_REF = eINSTANCE.getMetric_MetricSourceRef();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC__NAME = eINSTANCE.getMetric_Name();

		/**
		 * The meta object literal for the '<em><b>Unit Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC__UNIT_REF = eINSTANCE.getMetric_UnitRef();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MetricRetentionRuleImpl <em>Metric Retention Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MetricRetentionRuleImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricRetentionRule()
		 * @generated
		 */
		EClass METRIC_RETENTION_RULE = eINSTANCE.getMetricRetentionRule();

		/**
		 * The meta object literal for the '<em><b>Retention Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_RETENTION_RULE__RETENTION_EXPRESSION = eINSTANCE.getMetricRetentionRule_RetentionExpression();

		/**
		 * The meta object literal for the '<em><b>Interval Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_RETENTION_RULE__INTERVAL_HINT = eINSTANCE.getMetricRetentionRule_IntervalHint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_RETENTION_RULE__NAME = eINSTANCE.getMetricRetentionRule_Name();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_RETENTION_RULE__PERIOD = eINSTANCE.getMetricRetentionRule_Period();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MetricRetentionRulesImpl <em>Metric Retention Rules</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MetricRetentionRulesImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricRetentionRules()
		 * @generated
		 */
		EClass METRIC_RETENTION_RULES = eINSTANCE.getMetricRetentionRules();

		/**
		 * The meta object literal for the '<em><b>Metric Retention Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_RETENTION_RULES__METRIC_RETENTION_RULES = eINSTANCE.getMetricRetentionRules_MetricRetentionRules();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl <em>Metric Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MetricSourceImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricSource()
		 * @generated
		 */
		EClass METRIC_SOURCE = eINSTANCE.getMetricSource();

		/**
		 * The meta object literal for the '<em><b>Metric Mapping</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_SOURCE__METRIC_MAPPING = eINSTANCE.getMetricSource_MetricMapping();

		/**
		 * The meta object literal for the '<em><b>Statistics</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_SOURCE__STATISTICS = eINSTANCE.getMetricSource_Statistics();

		/**
		 * The meta object literal for the '<em><b>Filter Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_SOURCE__FILTER_PATTERN = eINSTANCE.getMetricSource_FilterPattern();

		/**
		 * The meta object literal for the '<em><b>Metric Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_SOURCE__METRIC_LOCATION = eINSTANCE.getMetricSource_MetricLocation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_SOURCE__NAME = eINSTANCE.getMetricSource_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.MetricValueRangeImpl <em>Metric Value Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.MetricValueRangeImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricValueRange()
		 * @generated
		 */
		EClass METRIC_VALUE_RANGE = eINSTANCE.getMetricValueRange();

		/**
		 * The meta object literal for the '<em><b>Metric Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METRIC_VALUE_RANGE__METRIC_VALUES = eINSTANCE.getMetricValueRange_MetricValues();

		/**
		 * The meta object literal for the '<em><b>Interval Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_VALUE_RANGE__INTERVAL_HINT = eINSTANCE.getMetricValueRange_IntervalHint();

		/**
		 * The meta object literal for the '<em><b>Kind Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METRIC_VALUE_RANGE__KIND_HINT = eINSTANCE.getMetricValueRange_KindHint();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl <em>Value Data Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.impl.ValueDataKindImpl
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getValueDataKind()
		 * @generated
		 */
		EClass VALUE_DATA_KIND = eINSTANCE.getValueDataKind();

		/**
		 * The meta object literal for the '<em><b>Metric Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_DATA_KIND__METRIC_REF = eINSTANCE.getValueDataKind_MetricRef();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_DATA_KIND__FORMAT = eINSTANCE.getValueDataKind_Format();

		/**
		 * The meta object literal for the '<em><b>Kind Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_DATA_KIND__KIND_HINT = eINSTANCE.getValueDataKind_KindHint();

		/**
		 * The meta object literal for the '<em><b>Value Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_DATA_KIND__VALUE_KIND = eINSTANCE.getValueDataKind_ValueKind();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.DatabaseTypeType <em>Database Type Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.DatabaseTypeType
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getDatabaseTypeType()
		 * @generated
		 */
		EEnum DATABASE_TYPE_TYPE = eINSTANCE.getDatabaseTypeType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.KindHintType <em>Kind Hint Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.KindHintType
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getKindHintType()
		 * @generated
		 */
		EEnum KIND_HINT_TYPE = eINSTANCE.getKindHintType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.MetricRetentionPeriod <em>Metric Retention Period</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.MetricRetentionPeriod
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricRetentionPeriod()
		 * @generated
		 */
		EEnum METRIC_RETENTION_PERIOD = eINSTANCE.getMetricRetentionPeriod();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.ObjectKindType <em>Object Kind Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.ObjectKindType
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getObjectKindType()
		 * @generated
		 */
		EEnum OBJECT_KIND_TYPE = eINSTANCE.getObjectKindType();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.metrics.ValueKindType <em>Value Kind Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.ValueKindType
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getValueKindType()
		 * @generated
		 */
		EEnum VALUE_KIND_TYPE = eINSTANCE.getValueKindType();

		/**
		 * The meta object literal for the '<em>Database Type Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.DatabaseTypeType
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getDatabaseTypeTypeObject()
		 * @generated
		 */
		EDataType DATABASE_TYPE_TYPE_OBJECT = eINSTANCE.getDatabaseTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Kind Hint Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.KindHintType
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getKindHintTypeObject()
		 * @generated
		 */
		EDataType KIND_HINT_TYPE_OBJECT = eINSTANCE.getKindHintTypeObject();

		/**
		 * The meta object literal for the '<em>Metric Retention Period Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.MetricRetentionPeriod
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getMetricRetentionPeriodObject()
		 * @generated
		 */
		EDataType METRIC_RETENTION_PERIOD_OBJECT = eINSTANCE.getMetricRetentionPeriodObject();

		/**
		 * The meta object literal for the '<em>Object Kind Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.ObjectKindType
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getObjectKindTypeObject()
		 * @generated
		 */
		EDataType OBJECT_KIND_TYPE_OBJECT = eINSTANCE.getObjectKindTypeObject();

		/**
		 * The meta object literal for the '<em>Value Kind Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.metrics.ValueKindType
		 * @see com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl#getValueKindTypeObject()
		 * @generated
		 */
		EDataType VALUE_KIND_TYPE_OBJECT = eINSTANCE.getValueKindTypeObject();

	}

} //MetricsPackage

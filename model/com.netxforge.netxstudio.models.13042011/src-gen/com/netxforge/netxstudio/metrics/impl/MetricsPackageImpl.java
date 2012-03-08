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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.NetxstudioPackage;

import com.netxforge.netxstudio.generics.GenericsPackage;

import com.netxforge.netxstudio.generics.impl.GenericsPackageImpl;

import com.netxforge.netxstudio.geo.GeoPackage;

import com.netxforge.netxstudio.geo.impl.GeoPackageImpl;

import com.netxforge.netxstudio.impl.NetxstudioPackageImpl;

import com.netxforge.netxstudio.library.LibraryPackage;

import com.netxforge.netxstudio.library.impl.LibraryPackageImpl;

import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.DatabaseTypeType;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;

import com.netxforge.netxstudio.operators.OperatorsPackage;

import com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl;

import com.netxforge.netxstudio.protocols.ProtocolsPackage;

import com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl;

import com.netxforge.netxstudio.scheduling.SchedulingPackage;

import com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl;

import com.netxforge.netxstudio.services.ServicesPackage;

import com.netxforge.netxstudio.services.impl.ServicesPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricsPackageImpl extends EPackageImpl implements MetricsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierDataKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCSVEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingRDBMSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingRecordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingStatisticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingXLSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricRetentionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricRetentionRulesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricValueRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueDataKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum databaseTypeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum kindHintTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum metricRetentionPeriodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum objectKindTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum valueKindTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType databaseTypeTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType kindHintTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType metricRetentionPeriodObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectKindTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType valueKindTypeObjectEDataType = null;

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
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetricsPackageImpl() {
		super(eNS_URI, MetricsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MetricsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetricsPackage init() {
		if (isInited) return (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);

		// Obtain or create and register package
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetricsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MetricsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);
		GenericsPackageImpl theGenericsPackage = (GenericsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) instanceof GenericsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) : GenericsPackage.eINSTANCE);
		ServicesPackageImpl theServicesPackage = (ServicesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) instanceof ServicesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) : ServicesPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		OperatorsPackageImpl theOperatorsPackage = (OperatorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) instanceof OperatorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) : OperatorsPackage.eINSTANCE);
		ProtocolsPackageImpl theProtocolsPackage = (ProtocolsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) instanceof ProtocolsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) : ProtocolsPackage.eINSTANCE);
		GeoPackageImpl theGeoPackage = (GeoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) instanceof GeoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) : GeoPackage.eINSTANCE);
		NetxstudioPackageImpl theNetxstudioPackage = (NetxstudioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) instanceof NetxstudioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) : NetxstudioPackage.eINSTANCE);

		// Create package meta-data objects
		theMetricsPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();
		theGenericsPackage.createPackageContents();
		theServicesPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theOperatorsPackage.createPackageContents();
		theProtocolsPackage.createPackageContents();
		theGeoPackage.createPackageContents();
		theNetxstudioPackage.createPackageContents();

		// Initialize created meta-data
		theMetricsPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();
		theGenericsPackage.initializePackageContents();
		theServicesPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theOperatorsPackage.initializePackageContents();
		theProtocolsPackage.initializePackageContents();
		theGeoPackage.initializePackageContents();
		theNetxstudioPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetricsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetricsPackage.eNS_URI, theMetricsPackage);
		return theMetricsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataKind() {
		return dataKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierDataKind() {
		return identifierDataKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifierDataKind_ObjectKind() {
		return (EAttribute)identifierDataKindEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifierDataKind_ObjectProperty() {
		return (EAttribute)identifierDataKindEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifierDataKind_Pattern() {
		return (EAttribute)identifierDataKindEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_HeaderMappingColumns() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_DataMappingColumns() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_FirstDataRow() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_HeaderRow() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMapping_IntervalHint() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingColumn() {
		return mappingColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingColumn_DataType() {
		return (EReference)mappingColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingColumn_Column() {
		return (EAttribute)mappingColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCSV() {
		return mappingCSVEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingCSV_Delimiter() {
		return (EAttribute)mappingCSVEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingCSV_FilterPattern() {
		return (EAttribute)mappingCSVEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingRDBMS() {
		return mappingRDBMSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRDBMS_DatabaseType() {
		return (EAttribute)mappingRDBMSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRDBMS_DateFormat() {
		return (EAttribute)mappingRDBMSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRDBMS_DateTimeFormat() {
		return (EAttribute)mappingRDBMSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRDBMS_Password() {
		return (EAttribute)mappingRDBMSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRDBMS_Query() {
		return (EAttribute)mappingRDBMSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRDBMS_TimeFormat() {
		return (EAttribute)mappingRDBMSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRDBMS_User() {
		return (EAttribute)mappingRDBMSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingRecord() {
		return mappingRecordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRecord_Column() {
		return (EAttribute)mappingRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRecord_Count() {
		return (EAttribute)mappingRecordEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingRecord_Message() {
		return (EAttribute)mappingRecordEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingStatistic() {
		return mappingStatisticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingStatistic_FailedRecords() {
		return (EReference)mappingStatisticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingStatistic_MappingDuration() {
		return (EReference)mappingStatisticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingStatistic_PeriodEstimate() {
		return (EReference)mappingStatisticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingStatistic_SubStatistics() {
		return (EReference)mappingStatisticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingStatistic_IntervalEstimate() {
		return (EAttribute)mappingStatisticEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingStatistic_Message() {
		return (EAttribute)mappingStatisticEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingStatistic_TotalRecords() {
		return (EAttribute)mappingStatisticEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingXLS() {
		return mappingXLSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingXLS_FilterPattern() {
		return (EAttribute)mappingXLSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingXLS_SheetNumber() {
		return (EAttribute)mappingXLSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetric() {
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_Metrics() {
		return (EReference)metricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_ExpressionRef() {
		return (EReference)metricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Description() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_MeasurementKind() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_MeasurementPoint() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_MetricSourceRef() {
		return (EReference)metricEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Name() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_UnitRef() {
		return (EReference)metricEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricRetentionRule() {
		return metricRetentionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricRetentionRule_RetentionExpression() {
		return (EReference)metricRetentionRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricRetentionRule_IntervalHint() {
		return (EAttribute)metricRetentionRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricRetentionRule_Name() {
		return (EAttribute)metricRetentionRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricRetentionRule_Period() {
		return (EAttribute)metricRetentionRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricRetentionRules() {
		return metricRetentionRulesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricRetentionRules_MetricRetentionRules() {
		return (EReference)metricRetentionRulesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricSource() {
		return metricSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricSource_MetricMapping() {
		return (EReference)metricSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricSource_Statistics() {
		return (EReference)metricSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricSource_FilterPattern() {
		return (EAttribute)metricSourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricSource_MetricLocation() {
		return (EAttribute)metricSourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricSource_Name() {
		return (EAttribute)metricSourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricValueRange() {
		return metricValueRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricValueRange_MetricValues() {
		return (EReference)metricValueRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricValueRange_IntervalHint() {
		return (EAttribute)metricValueRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricValueRange_KindHint() {
		return (EAttribute)metricValueRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueDataKind() {
		return valueDataKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValueDataKind_MetricRef() {
		return (EReference)valueDataKindEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueDataKind_Format() {
		return (EAttribute)valueDataKindEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueDataKind_KindHint() {
		return (EAttribute)valueDataKindEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValueDataKind_ValueKind() {
		return (EAttribute)valueDataKindEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDatabaseTypeType() {
		return databaseTypeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getKindHintType() {
		return kindHintTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMetricRetentionPeriod() {
		return metricRetentionPeriodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getObjectKindType() {
		return objectKindTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getValueKindType() {
		return valueKindTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDatabaseTypeTypeObject() {
		return databaseTypeTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getKindHintTypeObject() {
		return kindHintTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMetricRetentionPeriodObject() {
		return metricRetentionPeriodObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObjectKindTypeObject() {
		return objectKindTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getValueKindTypeObject() {
		return valueKindTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsFactory getMetricsFactory() {
		return (MetricsFactory)getEFactoryInstance();
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

		// Create classes and their features
		dataKindEClass = createEClass(DATA_KIND);

		identifierDataKindEClass = createEClass(IDENTIFIER_DATA_KIND);
		createEAttribute(identifierDataKindEClass, IDENTIFIER_DATA_KIND__OBJECT_KIND);
		createEAttribute(identifierDataKindEClass, IDENTIFIER_DATA_KIND__OBJECT_PROPERTY);
		createEAttribute(identifierDataKindEClass, IDENTIFIER_DATA_KIND__PATTERN);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__HEADER_MAPPING_COLUMNS);
		createEReference(mappingEClass, MAPPING__DATA_MAPPING_COLUMNS);
		createEAttribute(mappingEClass, MAPPING__FIRST_DATA_ROW);
		createEAttribute(mappingEClass, MAPPING__HEADER_ROW);
		createEAttribute(mappingEClass, MAPPING__INTERVAL_HINT);

		mappingColumnEClass = createEClass(MAPPING_COLUMN);
		createEReference(mappingColumnEClass, MAPPING_COLUMN__DATA_TYPE);
		createEAttribute(mappingColumnEClass, MAPPING_COLUMN__COLUMN);

		mappingCSVEClass = createEClass(MAPPING_CSV);
		createEAttribute(mappingCSVEClass, MAPPING_CSV__DELIMITER);
		createEAttribute(mappingCSVEClass, MAPPING_CSV__FILTER_PATTERN);

		mappingRDBMSEClass = createEClass(MAPPING_RDBMS);
		createEAttribute(mappingRDBMSEClass, MAPPING_RDBMS__DATABASE_TYPE);
		createEAttribute(mappingRDBMSEClass, MAPPING_RDBMS__DATE_FORMAT);
		createEAttribute(mappingRDBMSEClass, MAPPING_RDBMS__DATE_TIME_FORMAT);
		createEAttribute(mappingRDBMSEClass, MAPPING_RDBMS__PASSWORD);
		createEAttribute(mappingRDBMSEClass, MAPPING_RDBMS__QUERY);
		createEAttribute(mappingRDBMSEClass, MAPPING_RDBMS__TIME_FORMAT);
		createEAttribute(mappingRDBMSEClass, MAPPING_RDBMS__USER);

		mappingRecordEClass = createEClass(MAPPING_RECORD);
		createEAttribute(mappingRecordEClass, MAPPING_RECORD__COLUMN);
		createEAttribute(mappingRecordEClass, MAPPING_RECORD__COUNT);
		createEAttribute(mappingRecordEClass, MAPPING_RECORD__MESSAGE);

		mappingStatisticEClass = createEClass(MAPPING_STATISTIC);
		createEReference(mappingStatisticEClass, MAPPING_STATISTIC__FAILED_RECORDS);
		createEReference(mappingStatisticEClass, MAPPING_STATISTIC__MAPPING_DURATION);
		createEReference(mappingStatisticEClass, MAPPING_STATISTIC__PERIOD_ESTIMATE);
		createEReference(mappingStatisticEClass, MAPPING_STATISTIC__SUB_STATISTICS);
		createEAttribute(mappingStatisticEClass, MAPPING_STATISTIC__INTERVAL_ESTIMATE);
		createEAttribute(mappingStatisticEClass, MAPPING_STATISTIC__MESSAGE);
		createEAttribute(mappingStatisticEClass, MAPPING_STATISTIC__TOTAL_RECORDS);

		mappingXLSEClass = createEClass(MAPPING_XLS);
		createEAttribute(mappingXLSEClass, MAPPING_XLS__FILTER_PATTERN);
		createEAttribute(mappingXLSEClass, MAPPING_XLS__SHEET_NUMBER);

		metricEClass = createEClass(METRIC);
		createEReference(metricEClass, METRIC__METRICS);
		createEReference(metricEClass, METRIC__EXPRESSION_REF);
		createEAttribute(metricEClass, METRIC__DESCRIPTION);
		createEAttribute(metricEClass, METRIC__MEASUREMENT_KIND);
		createEAttribute(metricEClass, METRIC__MEASUREMENT_POINT);
		createEReference(metricEClass, METRIC__METRIC_SOURCE_REF);
		createEAttribute(metricEClass, METRIC__NAME);
		createEReference(metricEClass, METRIC__UNIT_REF);

		metricRetentionRuleEClass = createEClass(METRIC_RETENTION_RULE);
		createEReference(metricRetentionRuleEClass, METRIC_RETENTION_RULE__RETENTION_EXPRESSION);
		createEAttribute(metricRetentionRuleEClass, METRIC_RETENTION_RULE__INTERVAL_HINT);
		createEAttribute(metricRetentionRuleEClass, METRIC_RETENTION_RULE__NAME);
		createEAttribute(metricRetentionRuleEClass, METRIC_RETENTION_RULE__PERIOD);

		metricRetentionRulesEClass = createEClass(METRIC_RETENTION_RULES);
		createEReference(metricRetentionRulesEClass, METRIC_RETENTION_RULES__METRIC_RETENTION_RULES);

		metricSourceEClass = createEClass(METRIC_SOURCE);
		createEReference(metricSourceEClass, METRIC_SOURCE__METRIC_MAPPING);
		createEReference(metricSourceEClass, METRIC_SOURCE__STATISTICS);
		createEAttribute(metricSourceEClass, METRIC_SOURCE__FILTER_PATTERN);
		createEAttribute(metricSourceEClass, METRIC_SOURCE__METRIC_LOCATION);
		createEAttribute(metricSourceEClass, METRIC_SOURCE__NAME);

		metricValueRangeEClass = createEClass(METRIC_VALUE_RANGE);
		createEReference(metricValueRangeEClass, METRIC_VALUE_RANGE__METRIC_VALUES);
		createEAttribute(metricValueRangeEClass, METRIC_VALUE_RANGE__INTERVAL_HINT);
		createEAttribute(metricValueRangeEClass, METRIC_VALUE_RANGE__KIND_HINT);

		valueDataKindEClass = createEClass(VALUE_DATA_KIND);
		createEReference(valueDataKindEClass, VALUE_DATA_KIND__METRIC_REF);
		createEAttribute(valueDataKindEClass, VALUE_DATA_KIND__FORMAT);
		createEAttribute(valueDataKindEClass, VALUE_DATA_KIND__KIND_HINT);
		createEAttribute(valueDataKindEClass, VALUE_DATA_KIND__VALUE_KIND);

		// Create enums
		databaseTypeTypeEEnum = createEEnum(DATABASE_TYPE_TYPE);
		kindHintTypeEEnum = createEEnum(KIND_HINT_TYPE);
		metricRetentionPeriodEEnum = createEEnum(METRIC_RETENTION_PERIOD);
		objectKindTypeEEnum = createEEnum(OBJECT_KIND_TYPE);
		valueKindTypeEEnum = createEEnum(VALUE_KIND_TYPE);

		// Create data types
		databaseTypeTypeObjectEDataType = createEDataType(DATABASE_TYPE_TYPE_OBJECT);
		kindHintTypeObjectEDataType = createEDataType(KIND_HINT_TYPE_OBJECT);
		metricRetentionPeriodObjectEDataType = createEDataType(METRIC_RETENTION_PERIOD_OBJECT);
		objectKindTypeObjectEDataType = createEDataType(OBJECT_KIND_TYPE_OBJECT);
		valueKindTypeObjectEDataType = createEDataType(VALUE_KIND_TYPE_OBJECT);
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

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		GenericsPackage theGenericsPackage = (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);
		LibraryPackage theLibraryPackage = (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		identifierDataKindEClass.getESuperTypes().add(this.getDataKind());
		mappingEClass.getESuperTypes().add(theGenericsPackage.getBase());
		mappingColumnEClass.getESuperTypes().add(theGenericsPackage.getBase());
		mappingCSVEClass.getESuperTypes().add(this.getMapping());
		mappingRDBMSEClass.getESuperTypes().add(this.getMapping());
		mappingRecordEClass.getESuperTypes().add(theGenericsPackage.getBase());
		mappingStatisticEClass.getESuperTypes().add(theGenericsPackage.getBase());
		mappingXLSEClass.getESuperTypes().add(this.getMapping());
		metricEClass.getESuperTypes().add(theGenericsPackage.getBase());
		metricSourceEClass.getESuperTypes().add(theGenericsPackage.getBase());
		valueDataKindEClass.getESuperTypes().add(this.getDataKind());

		// Initialize classes and features; add operations and parameters
		initEClass(dataKindEClass, DataKind.class, "DataKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(identifierDataKindEClass, IdentifierDataKind.class, "IdentifierDataKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifierDataKind_ObjectKind(), this.getObjectKindType(), "objectKind", null, 0, 1, IdentifierDataKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentifierDataKind_ObjectProperty(), theXMLTypePackage.getString(), "objectProperty", null, 0, 1, IdentifierDataKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdentifierDataKind_Pattern(), theXMLTypePackage.getString(), "pattern", null, 0, 1, IdentifierDataKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_HeaderMappingColumns(), this.getMappingColumn(), null, "headerMappingColumns", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_DataMappingColumns(), this.getMappingColumn(), null, "dataMappingColumns", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_FirstDataRow(), theXMLTypePackage.getInt(), "firstDataRow", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_HeaderRow(), theXMLTypePackage.getInt(), "headerRow", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMapping_IntervalHint(), theXMLTypePackage.getInt(), "intervalHint", "60", 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingColumnEClass, MappingColumn.class, "MappingColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingColumn_DataType(), this.getDataKind(), null, "dataType", null, 0, 1, MappingColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingColumn_Column(), theXMLTypePackage.getInt(), "column", null, 0, 1, MappingColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCSVEClass, MappingCSV.class, "MappingCSV", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingCSV_Delimiter(), theXMLTypePackage.getString(), "delimiter", null, 0, 1, MappingCSV.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingCSV_FilterPattern(), theXMLTypePackage.getString(), "filterPattern", null, 0, 1, MappingCSV.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingRDBMSEClass, MappingRDBMS.class, "MappingRDBMS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingRDBMS_DatabaseType(), this.getDatabaseTypeType(), "databaseType", null, 0, 1, MappingRDBMS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingRDBMS_DateFormat(), theXMLTypePackage.getString(), "dateFormat", null, 0, 1, MappingRDBMS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingRDBMS_DateTimeFormat(), theXMLTypePackage.getString(), "dateTimeFormat", null, 0, 1, MappingRDBMS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingRDBMS_Password(), theXMLTypePackage.getString(), "password", null, 0, 1, MappingRDBMS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingRDBMS_Query(), theGenericsPackage.getDescription2000(), "query", null, 0, 1, MappingRDBMS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingRDBMS_TimeFormat(), theXMLTypePackage.getString(), "timeFormat", null, 0, 1, MappingRDBMS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingRDBMS_User(), theXMLTypePackage.getString(), "user", null, 0, 1, MappingRDBMS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingRecordEClass, MappingRecord.class, "MappingRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingRecord_Column(), theXMLTypePackage.getString(), "column", null, 0, 1, MappingRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingRecord_Count(), theXMLTypePackage.getLong(), "count", "1", 0, 1, MappingRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingRecord_Message(), theXMLTypePackage.getString(), "message", null, 0, 1, MappingRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingStatisticEClass, MappingStatistic.class, "MappingStatistic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingStatistic_FailedRecords(), this.getMappingRecord(), null, "failedRecords", null, 0, -1, MappingStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingStatistic_MappingDuration(), theGenericsPackage.getDateTimeRange(), null, "mappingDuration", null, 1, 1, MappingStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingStatistic_PeriodEstimate(), theGenericsPackage.getDateTimeRange(), null, "periodEstimate", null, 1, 1, MappingStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingStatistic_SubStatistics(), this.getMappingStatistic(), null, "subStatistics", null, 0, -1, MappingStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingStatistic_IntervalEstimate(), theXMLTypePackage.getInt(), "intervalEstimate", null, 0, 1, MappingStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingStatistic_Message(), theGenericsPackage.getDescription2000(), "message", null, 0, 1, MappingStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingStatistic_TotalRecords(), theXMLTypePackage.getInt(), "totalRecords", null, 0, 1, MappingStatistic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingXLSEClass, MappingXLS.class, "MappingXLS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingXLS_FilterPattern(), theXMLTypePackage.getString(), "filterPattern", null, 0, 1, MappingXLS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingXLS_SheetNumber(), theXMLTypePackage.getInt(), "sheetNumber", null, 0, 1, MappingXLS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricEClass, Metric.class, "Metric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetric_Metrics(), this.getMetric(), null, "metrics", null, 0, -1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_ExpressionRef(), theLibraryPackage.getExpression(), null, "expressionRef", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_MeasurementKind(), theXMLTypePackage.getString(), "measurementKind", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_MeasurementPoint(), theGenericsPackage.getDescription2000(), "measurementPoint", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_MetricSourceRef(), this.getMetricSource(), null, "metricSourceRef", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_UnitRef(), theLibraryPackage.getUnit(), null, "unitRef", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricRetentionRuleEClass, MetricRetentionRule.class, "MetricRetentionRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricRetentionRule_RetentionExpression(), theLibraryPackage.getExpression(), null, "retentionExpression", null, 0, 1, MetricRetentionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricRetentionRule_IntervalHint(), theXMLTypePackage.getInt(), "intervalHint", null, 0, 1, MetricRetentionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricRetentionRule_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, MetricRetentionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricRetentionRule_Period(), this.getMetricRetentionPeriod(), "period", null, 0, 1, MetricRetentionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricRetentionRulesEClass, MetricRetentionRules.class, "MetricRetentionRules", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricRetentionRules_MetricRetentionRules(), this.getMetricRetentionRule(), null, "metricRetentionRules", null, 0, -1, MetricRetentionRules.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricSourceEClass, MetricSource.class, "MetricSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricSource_MetricMapping(), this.getMapping(), null, "metricMapping", null, 0, 1, MetricSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetricSource_Statistics(), this.getMappingStatistic(), null, "statistics", null, 0, -1, MetricSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricSource_FilterPattern(), theXMLTypePackage.getString(), "filterPattern", null, 0, 1, MetricSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricSource_MetricLocation(), theXMLTypePackage.getAnyURI(), "metricLocation", null, 0, 1, MetricSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricSource_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, MetricSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricValueRangeEClass, MetricValueRange.class, "MetricValueRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricValueRange_MetricValues(), theGenericsPackage.getValue(), null, "metricValues", null, 0, -1, MetricValueRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricValueRange_IntervalHint(), theXMLTypePackage.getInt(), "intervalHint", null, 0, 1, MetricValueRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricValueRange_KindHint(), this.getKindHintType(), "kindHint", null, 0, 1, MetricValueRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueDataKindEClass, ValueDataKind.class, "ValueDataKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValueDataKind_MetricRef(), this.getMetric(), null, "metricRef", null, 0, 1, ValueDataKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueDataKind_Format(), theXMLTypePackage.getString(), "format", null, 0, 1, ValueDataKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueDataKind_KindHint(), this.getKindHintType(), "kindHint", null, 0, 1, ValueDataKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValueDataKind_ValueKind(), this.getValueKindType(), "valueKind", null, 0, 1, ValueDataKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(databaseTypeTypeEEnum, DatabaseTypeType.class, "DatabaseTypeType");
		addEEnumLiteral(databaseTypeTypeEEnum, DatabaseTypeType.ORACLE);
		addEEnumLiteral(databaseTypeTypeEEnum, DatabaseTypeType.POSTGRES);

		initEEnum(kindHintTypeEEnum, KindHintType.class, "KindHintType");
		addEEnumLiteral(kindHintTypeEEnum, KindHintType.BH);
		addEEnumLiteral(kindHintTypeEEnum, KindHintType.AVG);

		initEEnum(metricRetentionPeriodEEnum, MetricRetentionPeriod.class, "MetricRetentionPeriod");
		addEEnumLiteral(metricRetentionPeriodEEnum, MetricRetentionPeriod.ALWAYS);
		addEEnumLiteral(metricRetentionPeriodEEnum, MetricRetentionPeriod.ONE_YEAR);
		addEEnumLiteral(metricRetentionPeriodEEnum, MetricRetentionPeriod.ONE_MONTH);
		addEEnumLiteral(metricRetentionPeriodEEnum, MetricRetentionPeriod.ONE_WEEK);

		initEEnum(objectKindTypeEEnum, ObjectKindType.class, "ObjectKindType");
		addEEnumLiteral(objectKindTypeEEnum, ObjectKindType.NODE);
		addEEnumLiteral(objectKindTypeEEnum, ObjectKindType.EQUIPMENT);
		addEEnumLiteral(objectKindTypeEEnum, ObjectKindType.FUNCTION);
		addEEnumLiteral(objectKindTypeEEnum, ObjectKindType.RELATIONSHIP);

		initEEnum(valueKindTypeEEnum, ValueKindType.class, "ValueKindType");
		addEEnumLiteral(valueKindTypeEEnum, ValueKindType.INTERVAL);
		addEEnumLiteral(valueKindTypeEEnum, ValueKindType.DATE);
		addEEnumLiteral(valueKindTypeEEnum, ValueKindType.TIME);
		addEEnumLiteral(valueKindTypeEEnum, ValueKindType.DATETIME);
		addEEnumLiteral(valueKindTypeEEnum, ValueKindType.NULL);
		addEEnumLiteral(valueKindTypeEEnum, ValueKindType.METRIC);

		// Initialize data types
		initEDataType(databaseTypeTypeObjectEDataType, DatabaseTypeType.class, "DatabaseTypeTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(kindHintTypeObjectEDataType, KindHintType.class, "KindHintTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(metricRetentionPeriodObjectEDataType, MetricRetentionPeriod.class, "MetricRetentionPeriodObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectKindTypeObjectEDataType, ObjectKindType.class, "ObjectKindTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(valueKindTypeObjectEDataType, ValueKindType.class, "ValueKindTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";			
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL",
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL"
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
		  (databaseTypeTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "DatabaseType_._type"
		   });		
		addAnnotation
		  (databaseTypeTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DatabaseType_._type:Object",
			 "baseType", "DatabaseType_._type"
		   });			
		addAnnotation
		  (dataKindEClass, 
		   source, 
		   new String[] {
			 "name", "DataKind",
			 "kind", "empty"
		   });			
		addAnnotation
		  (identifierDataKindEClass, 
		   source, 
		   new String[] {
			 "name", "IdentifierDataKind",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getIdentifierDataKind_ObjectKind(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ObjectKind"
		   });			
		addAnnotation
		  (getIdentifierDataKind_ObjectProperty(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ObjectProperty"
		   });			
		addAnnotation
		  (getIdentifierDataKind_Pattern(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Pattern"
		   });			
		addAnnotation
		  (kindHintTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "KindHintType"
		   });		
		addAnnotation
		  (kindHintTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "KindHintType:Object",
			 "baseType", "KindHintType"
		   });			
		addAnnotation
		  (mappingEClass, 
		   source, 
		   new String[] {
			 "name", "Mapping",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMapping_HeaderMappingColumns(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "HeaderMappingColumns"
		   });		
		addAnnotation
		  (getMapping_DataMappingColumns(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DataMappingColumns"
		   });			
		addAnnotation
		  (getMapping_FirstDataRow(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "FirstDataRow"
		   });			
		addAnnotation
		  (getMapping_HeaderRow(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "HeaderRow"
		   });			
		addAnnotation
		  (getMapping_IntervalHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IntervalHint"
		   });		
		addAnnotation
		  (mappingColumnEClass, 
		   source, 
		   new String[] {
			 "name", "MappingColumn",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMappingColumn_DataType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DataType"
		   });		
		addAnnotation
		  (getMappingColumn_Column(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "column"
		   });			
		addAnnotation
		  (mappingCSVEClass, 
		   source, 
		   new String[] {
			 "name", "MappingCSV",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMappingCSV_Delimiter(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Delimiter"
		   });			
		addAnnotation
		  (getMappingCSV_FilterPattern(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "FilterPattern"
		   });			
		addAnnotation
		  (mappingRDBMSEClass, 
		   source, 
		   new String[] {
			 "name", "MappingRDBMS",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMappingRDBMS_DatabaseType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "DatabaseType"
		   });			
		addAnnotation
		  (getMappingRDBMS_DateFormat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "DateFormat"
		   });			
		addAnnotation
		  (getMappingRDBMS_DateTimeFormat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "DateTimeFormat"
		   });			
		addAnnotation
		  (getMappingRDBMS_Password(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Password"
		   });			
		addAnnotation
		  (getMappingRDBMS_Query(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Query"
		   });			
		addAnnotation
		  (getMappingRDBMS_TimeFormat(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "TimeFormat"
		   });			
		addAnnotation
		  (getMappingRDBMS_User(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "User"
		   });			
		addAnnotation
		  (mappingRecordEClass, 
		   source, 
		   new String[] {
			 "name", "MappingRecord",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getMappingRecord_Column(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Column"
		   });			
		addAnnotation
		  (getMappingRecord_Count(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Count"
		   });			
		addAnnotation
		  (getMappingRecord_Message(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Message"
		   });			
		addAnnotation
		  (mappingStatisticEClass, 
		   source, 
		   new String[] {
			 "name", "MappingStatistic",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMappingStatistic_FailedRecords(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FailedRecords"
		   });			
		addAnnotation
		  (getMappingStatistic_MappingDuration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MappingDuration"
		   });			
		addAnnotation
		  (getMappingStatistic_PeriodEstimate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "PeriodEstimate"
		   });			
		addAnnotation
		  (getMappingStatistic_SubStatistics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "SubStatistics"
		   });			
		addAnnotation
		  (getMappingStatistic_IntervalEstimate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IntervalEstimate"
		   });			
		addAnnotation
		  (getMappingStatistic_Message(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Message"
		   });			
		addAnnotation
		  (getMappingStatistic_TotalRecords(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "TotalRecords"
		   });			
		addAnnotation
		  (mappingXLSEClass, 
		   source, 
		   new String[] {
			 "name", "MappingXLS",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMappingXLS_FilterPattern(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "FilterPattern"
		   });			
		addAnnotation
		  (getMappingXLS_SheetNumber(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SheetNumber"
		   });			
		addAnnotation
		  (metricEClass, 
		   source, 
		   new String[] {
			 "name", "Metric",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMetric_Metrics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Metrics"
		   });			
		addAnnotation
		  (getMetric_ExpressionRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExpressionRef"
		   });			
		addAnnotation
		  (getMetric_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getMetric_MeasurementKind(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MeasurementKind"
		   });			
		addAnnotation
		  (getMetric_MeasurementPoint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MeasurementPoint"
		   });			
		addAnnotation
		  (getMetric_MetricSourceRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MetricSourceRef"
		   });			
		addAnnotation
		  (getMetric_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getMetric_UnitRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "UnitRef"
		   });		
		addAnnotation
		  (metricRetentionPeriodEEnum, 
		   source, 
		   new String[] {
			 "name", "MetricRetentionPeriod"
		   });		
		addAnnotation
		  (metricRetentionPeriodObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "MetricRetentionPeriod:Object",
			 "baseType", "MetricRetentionPeriod"
		   });			
		addAnnotation
		  (metricRetentionRuleEClass, 
		   source, 
		   new String[] {
			 "name", "MetricRetentionRule",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMetricRetentionRule_RetentionExpression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RetentionExpression"
		   });			
		addAnnotation
		  (getMetricRetentionRule_IntervalHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IntervalHint"
		   });			
		addAnnotation
		  (getMetricRetentionRule_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getMetricRetentionRule_Period(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Period"
		   });			
		addAnnotation
		  (metricRetentionRulesEClass, 
		   source, 
		   new String[] {
			 "name", "MetricRetentionRules",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMetricRetentionRules_MetricRetentionRules(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricRetentionRules"
		   });			
		addAnnotation
		  (metricSourceEClass, 
		   source, 
		   new String[] {
			 "name", "MetricSource",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMetricSource_MetricMapping(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricMapping"
		   });			
		addAnnotation
		  (getMetricSource_Statistics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Statistics"
		   });			
		addAnnotation
		  (getMetricSource_FilterPattern(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "FilterPattern"
		   });			
		addAnnotation
		  (getMetricSource_MetricLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MetricLocation"
		   });			
		addAnnotation
		  (getMetricSource_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (metricValueRangeEClass, 
		   source, 
		   new String[] {
			 "name", "MetricValueRange",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMetricValueRange_MetricValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricValues"
		   });			
		addAnnotation
		  (getMetricValueRange_IntervalHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IntervalHint"
		   });		
		addAnnotation
		  (getMetricValueRange_KindHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "KindHint"
		   });		
		addAnnotation
		  (objectKindTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "ObjectKind_._type"
		   });		
		addAnnotation
		  (objectKindTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ObjectKind_._type:Object",
			 "baseType", "ObjectKind_._type"
		   });			
		addAnnotation
		  (valueDataKindEClass, 
		   source, 
		   new String[] {
			 "name", "ValueDataKind",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getValueDataKind_MetricRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricRef"
		   });			
		addAnnotation
		  (getValueDataKind_Format(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Format"
		   });		
		addAnnotation
		  (getValueDataKind_KindHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "KindHint"
		   });			
		addAnnotation
		  (getValueDataKind_ValueKind(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ValueKind"
		   });		
		addAnnotation
		  (valueKindTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "ValueKind_._type"
		   });		
		addAnnotation
		  (valueKindTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ValueKind_._type:Object",
			 "baseType", "ValueKind_._type"
		   });
	}

} //MetricsPackageImpl

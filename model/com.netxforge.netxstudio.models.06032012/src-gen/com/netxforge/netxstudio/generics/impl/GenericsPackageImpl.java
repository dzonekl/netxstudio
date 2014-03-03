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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.ActionType;
import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.generics.CommitLogEntry;
import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.ConfigAttribute;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.DiagramInfo;
import com.netxforge.netxstudio.generics.DiagramKindType;
import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.generics.ExpansionDurationSetting;
import com.netxforge.netxstudio.generics.ExpansionDurationValue;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Meta;
import com.netxforge.netxstudio.generics.MultiImage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.generics.util.GenericsValidator;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.impl.GeoPackageImpl;
import com.netxforge.netxstudio.impl.NetxstudioPackageImpl;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.impl.LibraryPackageImpl;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl;
import com.netxforge.netxstudio.services.ServicesPackage;
import com.netxforge.netxstudio.services.impl.ServicesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenericsPackageImpl extends EPackageImpl implements GenericsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commitLogEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass companyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dateTimeRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expansionDurationSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expansionDurationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lifecycleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum diagramKindTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum expansionDurationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType actionTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType description2000EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType diagramKindTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType expansionDurationObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType expressionLineEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType longTextEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType name255EDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType unitCodeEDataType = null;

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
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GenericsPackageImpl() {
		super(eNS_URI, GenericsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link GenericsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GenericsPackage init() {
		if (isInited) return (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);

		// Obtain or create and register package
		GenericsPackageImpl theGenericsPackage = (GenericsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GenericsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GenericsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);
		ServicesPackageImpl theServicesPackage = (ServicesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) instanceof ServicesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) : ServicesPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		OperatorsPackageImpl theOperatorsPackage = (OperatorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) instanceof OperatorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) : OperatorsPackage.eINSTANCE);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) instanceof MetricsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) : MetricsPackage.eINSTANCE);
		ProtocolsPackageImpl theProtocolsPackage = (ProtocolsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) instanceof ProtocolsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) : ProtocolsPackage.eINSTANCE);
		GeoPackageImpl theGeoPackage = (GeoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) instanceof GeoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) : GeoPackage.eINSTANCE);
		NetxstudioPackageImpl theNetxstudioPackage = (NetxstudioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) instanceof NetxstudioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) : NetxstudioPackage.eINSTANCE);

		// Create package meta-data objects
		theGenericsPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();
		theServicesPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theOperatorsPackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theProtocolsPackage.createPackageContents();
		theGeoPackage.createPackageContents();
		theNetxstudioPackage.createPackageContents();

		// Initialize created meta-data
		theGenericsPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();
		theServicesPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theOperatorsPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theProtocolsPackage.initializePackageContents();
		theGeoPackage.initializePackageContents();
		theNetxstudioPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theGenericsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return GenericsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theGenericsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GenericsPackage.eNS_URI, theGenericsPackage);
		return theGenericsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBase() {
		return baseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBase_Deleted() {
		return (EAttribute)baseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommitLogEntry() {
		return commitLogEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommitLogEntry_Action() {
		return (EAttribute)commitLogEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommitLogEntry_Change() {
		return (EAttribute)commitLogEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommitLogEntry_ObjectId() {
		return (EAttribute)commitLogEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommitLogEntry_TimeStamp() {
		return (EAttribute)commitLogEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommitLogEntry_User() {
		return (EAttribute)commitLogEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompany() {
		return companyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompany_Icons() {
		return (EReference)companyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_Name() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_RSSurl() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_ShortName() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_Symbol() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompany_Website() {
		return (EAttribute)companyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigAttribute() {
		return configAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigAttribute_Name() {
		return (EAttribute)configAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigAttribute_Value() {
		return (EAttribute)configAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDateTimeRange() {
		return dateTimeRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDateTimeRange_Begin() {
		return (EAttribute)dateTimeRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDateTimeRange_End() {
		return (EAttribute)dateTimeRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagramInfo() {
		return diagramInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramInfo_DiagramKind() {
		return (EAttribute)diagramInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramInfo_Location() {
		return (EAttribute)diagramInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpansionDurationSetting() {
		return expansionDurationSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpansionDurationSetting_QuickDuration() {
		return (EReference)expansionDurationSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpansionDurationSetting_ShortDuration() {
		return (EReference)expansionDurationSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpansionDurationSetting_MediumDuration() {
		return (EReference)expansionDurationSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpansionDurationSetting_LongDuration() {
		return (EReference)expansionDurationSettingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpansionDurationValue() {
		return expansionDurationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpansionDurationValue_ExpansionDuration() {
		return (EAttribute)expansionDurationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpansionDurationValue_Value() {
		return (EAttribute)expansionDurationValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLifecycle() {
		return lifecycleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifecycle_ConstructionDate() {
		return (EAttribute)lifecycleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifecycle_InServiceDate() {
		return (EAttribute)lifecycleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifecycle_OutOfServiceDate() {
		return (EAttribute)lifecycleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifecycle_PlannedDate() {
		return (EAttribute)lifecycleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLifecycle_Proposed() {
		return (EAttribute)lifecycleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeta() {
		return metaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeta_Author() {
		return (EReference)metaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeta_Description() {
		return (EAttribute)metaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeta_Version() {
		return (EAttribute)metaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiImage() {
		return multiImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiImage_Obj16() {
		return (EAttribute)multiImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiImage_Obj32() {
		return (EAttribute)multiImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiImage_Obj48() {
		return (EAttribute)multiImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiImage_Obj96() {
		return (EAttribute)multiImageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiImage_Obj128() {
		return (EAttribute)multiImageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Roles() {
		return (EReference)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Active() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_CompanyRef() {
		return (EReference)personEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Email() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_FirstName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_LastName() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Login() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Password() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Name() {
		return (EAttribute)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValue() {
		return valueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValue_TimeStamp() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getValue_Value() {
		return (EAttribute)valueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionType() {
		return actionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDiagramKindType() {
		return diagramKindTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExpansionDuration() {
		return expansionDurationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getActionTypeObject() {
		return actionTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDescription2000() {
		return description2000EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDiagramKindTypeObject() {
		return diagramKindTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getExpansionDurationObject() {
		return expansionDurationObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getExpressionLine() {
		return expressionLineEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLongText() {
		return longTextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getName255() {
		return name255EDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUnitCode() {
		return unitCodeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericsFactory getGenericsFactory() {
		return (GenericsFactory)getEFactoryInstance();
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
		baseEClass = createEClass(BASE);
		createEAttribute(baseEClass, BASE__DELETED);

		commitLogEntryEClass = createEClass(COMMIT_LOG_ENTRY);
		createEAttribute(commitLogEntryEClass, COMMIT_LOG_ENTRY__ACTION);
		createEAttribute(commitLogEntryEClass, COMMIT_LOG_ENTRY__CHANGE);
		createEAttribute(commitLogEntryEClass, COMMIT_LOG_ENTRY__OBJECT_ID);
		createEAttribute(commitLogEntryEClass, COMMIT_LOG_ENTRY__TIME_STAMP);
		createEAttribute(commitLogEntryEClass, COMMIT_LOG_ENTRY__USER);

		companyEClass = createEClass(COMPANY);
		createEReference(companyEClass, COMPANY__ICONS);
		createEAttribute(companyEClass, COMPANY__NAME);
		createEAttribute(companyEClass, COMPANY__RS_SURL);
		createEAttribute(companyEClass, COMPANY__SHORT_NAME);
		createEAttribute(companyEClass, COMPANY__SYMBOL);
		createEAttribute(companyEClass, COMPANY__WEBSITE);

		configAttributeEClass = createEClass(CONFIG_ATTRIBUTE);
		createEAttribute(configAttributeEClass, CONFIG_ATTRIBUTE__NAME);
		createEAttribute(configAttributeEClass, CONFIG_ATTRIBUTE__VALUE);

		dateTimeRangeEClass = createEClass(DATE_TIME_RANGE);
		createEAttribute(dateTimeRangeEClass, DATE_TIME_RANGE__BEGIN);
		createEAttribute(dateTimeRangeEClass, DATE_TIME_RANGE__END);

		diagramInfoEClass = createEClass(DIAGRAM_INFO);
		createEAttribute(diagramInfoEClass, DIAGRAM_INFO__DIAGRAM_KIND);
		createEAttribute(diagramInfoEClass, DIAGRAM_INFO__LOCATION);

		expansionDurationSettingEClass = createEClass(EXPANSION_DURATION_SETTING);
		createEReference(expansionDurationSettingEClass, EXPANSION_DURATION_SETTING__QUICK_DURATION);
		createEReference(expansionDurationSettingEClass, EXPANSION_DURATION_SETTING__SHORT_DURATION);
		createEReference(expansionDurationSettingEClass, EXPANSION_DURATION_SETTING__MEDIUM_DURATION);
		createEReference(expansionDurationSettingEClass, EXPANSION_DURATION_SETTING__LONG_DURATION);

		expansionDurationValueEClass = createEClass(EXPANSION_DURATION_VALUE);
		createEAttribute(expansionDurationValueEClass, EXPANSION_DURATION_VALUE__EXPANSION_DURATION);
		createEAttribute(expansionDurationValueEClass, EXPANSION_DURATION_VALUE__VALUE);

		lifecycleEClass = createEClass(LIFECYCLE);
		createEAttribute(lifecycleEClass, LIFECYCLE__CONSTRUCTION_DATE);
		createEAttribute(lifecycleEClass, LIFECYCLE__IN_SERVICE_DATE);
		createEAttribute(lifecycleEClass, LIFECYCLE__OUT_OF_SERVICE_DATE);
		createEAttribute(lifecycleEClass, LIFECYCLE__PLANNED_DATE);
		createEAttribute(lifecycleEClass, LIFECYCLE__PROPOSED);

		metaEClass = createEClass(META);
		createEReference(metaEClass, META__AUTHOR);
		createEAttribute(metaEClass, META__DESCRIPTION);
		createEAttribute(metaEClass, META__VERSION);

		multiImageEClass = createEClass(MULTI_IMAGE);
		createEAttribute(multiImageEClass, MULTI_IMAGE__OBJ16);
		createEAttribute(multiImageEClass, MULTI_IMAGE__OBJ32);
		createEAttribute(multiImageEClass, MULTI_IMAGE__OBJ48);
		createEAttribute(multiImageEClass, MULTI_IMAGE__OBJ96);
		createEAttribute(multiImageEClass, MULTI_IMAGE__OBJ128);

		personEClass = createEClass(PERSON);
		createEReference(personEClass, PERSON__ROLES);
		createEAttribute(personEClass, PERSON__ACTIVE);
		createEReference(personEClass, PERSON__COMPANY_REF);
		createEAttribute(personEClass, PERSON__EMAIL);
		createEAttribute(personEClass, PERSON__FIRST_NAME);
		createEAttribute(personEClass, PERSON__LAST_NAME);
		createEAttribute(personEClass, PERSON__LOGIN);
		createEAttribute(personEClass, PERSON__PASSWORD);

		roleEClass = createEClass(ROLE);
		createEAttribute(roleEClass, ROLE__NAME);

		valueEClass = createEClass(VALUE);
		createEAttribute(valueEClass, VALUE__TIME_STAMP);
		createEAttribute(valueEClass, VALUE__VALUE);

		// Create enums
		actionTypeEEnum = createEEnum(ACTION_TYPE);
		diagramKindTypeEEnum = createEEnum(DIAGRAM_KIND_TYPE);
		expansionDurationEEnum = createEEnum(EXPANSION_DURATION);

		// Create data types
		actionTypeObjectEDataType = createEDataType(ACTION_TYPE_OBJECT);
		description2000EDataType = createEDataType(DESCRIPTION2000);
		diagramKindTypeObjectEDataType = createEDataType(DIAGRAM_KIND_TYPE_OBJECT);
		expansionDurationObjectEDataType = createEDataType(EXPANSION_DURATION_OBJECT);
		expressionLineEDataType = createEDataType(EXPRESSION_LINE);
		longTextEDataType = createEDataType(LONG_TEXT);
		name255EDataType = createEDataType(NAME255);
		unitCodeEDataType = createEDataType(UNIT_CODE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		commitLogEntryEClass.getESuperTypes().add(this.getBase());
		companyEClass.getESuperTypes().add(this.getBase());
		diagramInfoEClass.getESuperTypes().add(this.getBase());
		expansionDurationSettingEClass.getESuperTypes().add(this.getBase());
		expansionDurationValueEClass.getESuperTypes().add(this.getBase());
		lifecycleEClass.getESuperTypes().add(this.getBase());
		metaEClass.getESuperTypes().add(this.getBase());
		multiImageEClass.getESuperTypes().add(this.getBase());
		personEClass.getESuperTypes().add(this.getBase());
		roleEClass.getESuperTypes().add(this.getBase());

		// Initialize classes and features; add operations and parameters
		initEClass(baseEClass, Base.class, "Base", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBase_Deleted(), theXMLTypePackage.getBoolean(), "deleted", null, 0, 1, Base.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commitLogEntryEClass, CommitLogEntry.class, "CommitLogEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommitLogEntry_Action(), this.getActionType(), "action", null, 0, 1, CommitLogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommitLogEntry_Change(), this.getDescription2000(), "change", null, 0, 1, CommitLogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommitLogEntry_ObjectId(), this.getDescription2000(), "objectId", null, 0, 1, CommitLogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommitLogEntry_TimeStamp(), theXMLTypePackage.getDateTime(), "timeStamp", null, 0, 1, CommitLogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommitLogEntry_User(), theXMLTypePackage.getString(), "user", null, 0, 1, CommitLogEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(companyEClass, Company.class, "Company", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompany_Icons(), this.getMultiImage(), null, "icons", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_Name(), this.getName255(), "name", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_RSSurl(), theXMLTypePackage.getAnyURI(), "rSSurl", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_ShortName(), this.getName255(), "shortName", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_Symbol(), this.getName255(), "symbol", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompany_Website(), theXMLTypePackage.getAnyURI(), "website", null, 0, 1, Company.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configAttributeEClass, ConfigAttribute.class, "ConfigAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigAttribute_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ConfigAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigAttribute_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, ConfigAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dateTimeRangeEClass, DateTimeRange.class, "DateTimeRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDateTimeRange_Begin(), theXMLTypePackage.getDateTime(), "begin", null, 0, 1, DateTimeRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDateTimeRange_End(), theXMLTypePackage.getDateTime(), "end", null, 0, 1, DateTimeRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagramInfoEClass, DiagramInfo.class, "DiagramInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagramInfo_DiagramKind(), this.getDiagramKindType(), "diagramKind", null, 0, 1, DiagramInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramInfo_Location(), theXMLTypePackage.getAnyURI(), "location", null, 0, 1, DiagramInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expansionDurationSettingEClass, ExpansionDurationSetting.class, "ExpansionDurationSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpansionDurationSetting_QuickDuration(), this.getExpansionDurationValue(), null, "quickDuration", null, 0, 1, ExpansionDurationSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpansionDurationSetting_ShortDuration(), this.getExpansionDurationValue(), null, "shortDuration", null, 0, 1, ExpansionDurationSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpansionDurationSetting_MediumDuration(), this.getExpansionDurationValue(), null, "mediumDuration", null, 0, 1, ExpansionDurationSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpansionDurationSetting_LongDuration(), this.getExpansionDurationValue(), null, "longDuration", null, 0, 1, ExpansionDurationSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expansionDurationValueEClass, ExpansionDurationValue.class, "ExpansionDurationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpansionDurationValue_ExpansionDuration(), this.getExpansionDuration(), "expansionDuration", null, 0, 1, ExpansionDurationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpansionDurationValue_Value(), theXMLTypePackage.getInt(), "value", null, 0, 1, ExpansionDurationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lifecycleEClass, Lifecycle.class, "Lifecycle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLifecycle_ConstructionDate(), theXMLTypePackage.getDateTime(), "constructionDate", null, 0, 1, Lifecycle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifecycle_InServiceDate(), theXMLTypePackage.getDateTime(), "inServiceDate", null, 0, 1, Lifecycle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifecycle_OutOfServiceDate(), theXMLTypePackage.getDateTime(), "outOfServiceDate", null, 0, 1, Lifecycle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifecycle_PlannedDate(), theXMLTypePackage.getDateTime(), "plannedDate", null, 0, 1, Lifecycle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLifecycle_Proposed(), theXMLTypePackage.getDateTime(), "proposed", null, 0, 1, Lifecycle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metaEClass, Meta.class, "Meta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeta_Author(), this.getPerson(), null, "author", null, 0, 1, Meta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeta_Description(), this.getDescription2000(), "description", null, 0, 1, Meta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeta_Version(), theXMLTypePackage.getString(), "version", null, 0, 1, Meta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiImageEClass, MultiImage.class, "MultiImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiImage_Obj16(), theXMLTypePackage.getAnyURI(), "obj16", null, 0, 1, MultiImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiImage_Obj32(), theXMLTypePackage.getAnyURI(), "obj32", null, 0, 1, MultiImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiImage_Obj48(), theXMLTypePackage.getAnyURI(), "obj48", null, 0, 1, MultiImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiImage_Obj96(), theXMLTypePackage.getAnyURI(), "obj96", null, 0, 1, MultiImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiImage_Obj128(), theXMLTypePackage.getAnyURI(), "obj128", null, 0, 1, MultiImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPerson_Roles(), this.getRole(), null, "roles", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Active(), theXMLTypePackage.getBoolean(), "active", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_CompanyRef(), this.getCompany(), null, "companyRef", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Email(), theXMLTypePackage.getString(), "email", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_FirstName(), this.getName255(), "firstName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_LastName(), this.getName255(), "lastName", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Login(), this.getName255(), "login", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Password(), theXMLTypePackage.getString(), "password", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRole_Name(), this.getName255(), "name", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValue_TimeStamp(), theXMLTypePackage.getDateTime(), "timeStamp", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValue_Value(), theXMLTypePackage.getDouble(), "value", null, 0, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(actionTypeEEnum, ActionType.class, "ActionType");
		addEEnumLiteral(actionTypeEEnum, ActionType.UPDATE);
		addEEnumLiteral(actionTypeEEnum, ActionType.ADD);
		addEEnumLiteral(actionTypeEEnum, ActionType.DELETE);

		initEEnum(diagramKindTypeEEnum, DiagramKindType.class, "DiagramKindType");
		addEEnumLiteral(diagramKindTypeEEnum, DiagramKindType.NETWORK);
		addEEnumLiteral(diagramKindTypeEEnum, DiagramKindType.FUNCTION);
		addEEnumLiteral(diagramKindTypeEEnum, DiagramKindType.EQUIPMENT);
		addEEnumLiteral(diagramKindTypeEEnum, DiagramKindType.NODE);
		addEEnumLiteral(diagramKindTypeEEnum, DiagramKindType.WIRING);

		initEEnum(expansionDurationEEnum, ExpansionDuration.class, "ExpansionDuration");
		addEEnumLiteral(expansionDurationEEnum, ExpansionDuration.QUICK);
		addEEnumLiteral(expansionDurationEEnum, ExpansionDuration.SHORT);
		addEEnumLiteral(expansionDurationEEnum, ExpansionDuration.MEDIUM);
		addEEnumLiteral(expansionDurationEEnum, ExpansionDuration.LONG);

		// Initialize data types
		initEDataType(actionTypeObjectEDataType, ActionType.class, "ActionTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(description2000EDataType, String.class, "Description2000", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(diagramKindTypeObjectEDataType, DiagramKindType.class, "DiagramKindTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(expansionDurationObjectEDataType, ExpansionDuration.class, "ExpansionDurationObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(expressionLineEDataType, String.class, "ExpressionLine", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(longTextEDataType, String.class, "LongText", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(name255EDataType, String.class, "Name255", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(unitCodeEDataType, String.class, "UnitCode", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
		// teneo.jpa
		createTeneoAnnotations();
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
		  (actionTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "Action_._type"
		   });		
		addAnnotation
		  (actionTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "Action_._type:Object",
			 "baseType", "Action_._type"
		   });			
		addAnnotation
		  (baseEClass, 
		   source, 
		   new String[] {
			 "name", "Base",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getBase_Deleted(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Deleted"
		   });			
		addAnnotation
		  (commitLogEntryEClass, 
		   source, 
		   new String[] {
			 "name", "CommitLogEntry",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getCommitLogEntry_Action(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Action"
		   });			
		addAnnotation
		  (getCommitLogEntry_Change(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Change"
		   });			
		addAnnotation
		  (getCommitLogEntry_ObjectId(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ObjectId"
		   });			
		addAnnotation
		  (getCommitLogEntry_TimeStamp(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "TimeStamp"
		   });			
		addAnnotation
		  (getCommitLogEntry_User(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "User"
		   });			
		addAnnotation
		  (companyEClass, 
		   source, 
		   new String[] {
			 "name", "Company",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getCompany_Icons(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Icons"
		   });			
		addAnnotation
		  (getCompany_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getCompany_RSSurl(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RSSurl"
		   });			
		addAnnotation
		  (getCompany_ShortName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ShortName"
		   });			
		addAnnotation
		  (getCompany_Symbol(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Symbol"
		   });			
		addAnnotation
		  (getCompany_Website(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Website"
		   });			
		addAnnotation
		  (configAttributeEClass, 
		   source, 
		   new String[] {
			 "name", "ConfigAttribute",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getConfigAttribute_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getConfigAttribute_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Value"
		   });			
		addAnnotation
		  (dateTimeRangeEClass, 
		   source, 
		   new String[] {
			 "name", "DateTimeRange",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getDateTimeRange_Begin(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Begin"
		   });			
		addAnnotation
		  (getDateTimeRange_End(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "End"
		   });			
		addAnnotation
		  (description2000EDataType, 
		   source, 
		   new String[] {
			 "name", "Description2000",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "2000"
		   });			
		addAnnotation
		  (diagramInfoEClass, 
		   source, 
		   new String[] {
			 "name", "DiagramInfo",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getDiagramInfo_DiagramKind(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "DiagramKind"
		   });			
		addAnnotation
		  (getDiagramInfo_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Location"
		   });		
		addAnnotation
		  (diagramKindTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "DiagramKind_._type"
		   });		
		addAnnotation
		  (diagramKindTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DiagramKind_._type:Object",
			 "baseType", "DiagramKind_._type"
		   });			
		addAnnotation
		  (expansionDurationEEnum, 
		   source, 
		   new String[] {
			 "name", "ExpansionDuration"
		   });		
		addAnnotation
		  (expansionDurationObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ExpansionDuration:Object",
			 "baseType", "ExpansionDuration"
		   });			
		addAnnotation
		  (expansionDurationSettingEClass, 
		   source, 
		   new String[] {
			 "name", "ExpansionDurationSetting",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getExpansionDurationSetting_QuickDuration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "QuickDuration"
		   });			
		addAnnotation
		  (getExpansionDurationSetting_ShortDuration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ShortDuration"
		   });			
		addAnnotation
		  (getExpansionDurationSetting_MediumDuration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MediumDuration"
		   });			
		addAnnotation
		  (getExpansionDurationSetting_LongDuration(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "LongDuration"
		   });			
		addAnnotation
		  (expansionDurationValueEClass, 
		   source, 
		   new String[] {
			 "name", "ExpansionDurationValue",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getExpansionDurationValue_ExpansionDuration(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ExpansionDuration"
		   });			
		addAnnotation
		  (getExpansionDurationValue_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Value"
		   });			
		addAnnotation
		  (expressionLineEDataType, 
		   source, 
		   new String[] {
			 "name", "ExpressionLine",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "1000"
		   });			
		addAnnotation
		  (lifecycleEClass, 
		   source, 
		   new String[] {
			 "name", "Lifecycle",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getLifecycle_ConstructionDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ConstructionDate"
		   });			
		addAnnotation
		  (getLifecycle_InServiceDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "InServiceDate"
		   });			
		addAnnotation
		  (getLifecycle_OutOfServiceDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "OutOfServiceDate"
		   });			
		addAnnotation
		  (getLifecycle_PlannedDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "PlannedDate"
		   });			
		addAnnotation
		  (getLifecycle_Proposed(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Proposed"
		   });			
		addAnnotation
		  (longTextEDataType, 
		   source, 
		   new String[] {
			 "name", "LongText",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "20000"
		   });			
		addAnnotation
		  (metaEClass, 
		   source, 
		   new String[] {
			 "name", "Meta",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMeta_Author(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Author"
		   });			
		addAnnotation
		  (getMeta_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getMeta_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Version"
		   });			
		addAnnotation
		  (multiImageEClass, 
		   source, 
		   new String[] {
			 "name", "MultiImage",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMultiImage_Obj16(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "obj16"
		   });			
		addAnnotation
		  (getMultiImage_Obj32(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "obj32"
		   });			
		addAnnotation
		  (getMultiImage_Obj48(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "obj48"
		   });			
		addAnnotation
		  (getMultiImage_Obj96(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "obj96"
		   });			
		addAnnotation
		  (getMultiImage_Obj128(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "obj128"
		   });			
		addAnnotation
		  (name255EDataType, 
		   source, 
		   new String[] {
			 "name", "Name255",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "255"
		   });			
		addAnnotation
		  (personEClass, 
		   source, 
		   new String[] {
			 "name", "Person",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPerson_Roles(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Roles"
		   });		
		addAnnotation
		  (getPerson_Active(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Active"
		   });			
		addAnnotation
		  (getPerson_CompanyRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "CompanyRef"
		   });			
		addAnnotation
		  (getPerson_Email(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Email"
		   });			
		addAnnotation
		  (getPerson_FirstName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "FirstName"
		   });			
		addAnnotation
		  (getPerson_LastName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "LastName"
		   });			
		addAnnotation
		  (getPerson_Login(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Login"
		   });			
		addAnnotation
		  (getPerson_Password(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Password"
		   });		
		addAnnotation
		  (roleEClass, 
		   source, 
		   new String[] {
			 "name", "Role",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getRole_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (unitCodeEDataType, 
		   source, 
		   new String[] {
			 "name", "UnitCode",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string",
			 "maxLength", "3"
		   });			
		addAnnotation
		  (valueEClass, 
		   source, 
		   new String[] {
			 "name", "Value",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getValue_TimeStamp(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "TimeStamp"
		   });			
		addAnnotation
		  (getValue_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Value"
		   });
	}

	/**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTeneoAnnotations() {
		String source = "teneo.jpa";				
		addAnnotation
		  (baseEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@MappedSuperclass"
		   });																																																																																																																																				
	}

} //GenericsPackageImpl

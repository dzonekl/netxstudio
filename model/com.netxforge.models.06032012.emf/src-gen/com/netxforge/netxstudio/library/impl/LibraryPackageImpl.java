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
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.NetxstudioPackage;

import com.netxforge.netxstudio.generics.GenericsPackage;

import com.netxforge.netxstudio.generics.impl.GenericsPackageImpl;

import com.netxforge.netxstudio.geo.GeoPackage;

import com.netxforge.netxstudio.geo.impl.GeoPackageImpl;

import com.netxforge.netxstudio.impl.NetxstudioPackageImpl;

import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.EquipmentGroup;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LastEvaluationExpressionResult;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.ProductInfo;
import com.netxforge.netxstudio.library.RangeKind;
import com.netxforge.netxstudio.library.RedundancyType;
import com.netxforge.netxstudio.library.ReferenceNetwork;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.library.StateType;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.netxstudio.library.Vendor;

import com.netxforge.netxstudio.library.util.LibraryValidator;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryPackageImpl extends EPackageImpl implements LibraryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseExpressionResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equipmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equipmentGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lastEvaluationExpressionResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass netXResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceNetworkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toleranceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vendorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum levelKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum rangeKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum redundancyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType levelKindObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rangeKindObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType redundancyTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stateTypeObjectEDataType = null;

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
	 * @see com.netxforge.netxstudio.library.LibraryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LibraryPackageImpl() {
		super(eNS_URI, LibraryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LibraryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LibraryPackage init() {
		if (isInited) return (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);

		// Obtain or create and register package
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LibraryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);
		GenericsPackageImpl theGenericsPackage = (GenericsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) instanceof GenericsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) : GenericsPackage.eINSTANCE);
		ServicesPackageImpl theServicesPackage = (ServicesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) instanceof ServicesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) : ServicesPackage.eINSTANCE);
		OperatorsPackageImpl theOperatorsPackage = (OperatorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) instanceof OperatorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) : OperatorsPackage.eINSTANCE);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) instanceof MetricsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) : MetricsPackage.eINSTANCE);
		ProtocolsPackageImpl theProtocolsPackage = (ProtocolsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) instanceof ProtocolsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) : ProtocolsPackage.eINSTANCE);
		GeoPackageImpl theGeoPackage = (GeoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) instanceof GeoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) : GeoPackage.eINSTANCE);
		NetxstudioPackageImpl theNetxstudioPackage = (NetxstudioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) instanceof NetxstudioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) : NetxstudioPackage.eINSTANCE);

		// Create package meta-data objects
		theLibraryPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();
		theGenericsPackage.createPackageContents();
		theServicesPackage.createPackageContents();
		theOperatorsPackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theProtocolsPackage.createPackageContents();
		theGeoPackage.createPackageContents();
		theNetxstudioPackage.createPackageContents();

		// Initialize created meta-data
		theLibraryPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();
		theGenericsPackage.initializePackageContents();
		theServicesPackage.initializePackageContents();
		theOperatorsPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theProtocolsPackage.initializePackageContents();
		theGeoPackage.initializePackageContents();
		theNetxstudioPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theLibraryPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return LibraryValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theLibraryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LibraryPackage.eNS_URI, theLibraryPackage);
		return theLibraryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseExpressionResult() {
		return baseExpressionResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseResource() {
		return baseResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseResource_DetailDisplay() {
		return (EAttribute)baseResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseResource_ExpressionName() {
		return (EAttribute)baseResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseResource_LongName() {
		return (EAttribute)baseResourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseResource_ShortName() {
		return (EAttribute)baseResourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBaseResource_SummaryDisplay() {
		return (EAttribute)baseResourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBaseResource_UnitRef() {
		return (EReference)baseResourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Lifecycle() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_ResourceRefs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_ConfigAttributes() {
		return (EReference)componentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_MetricRefs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_CapacityExpressionRef() {
		return (EReference)componentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_UtilizationExpressionRef() {
		return (EReference)componentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_ToleranceRefs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_ProtocolRefs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_ParameterRefs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_AllResources() {
		return (EReference)componentEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Diagrams() {
		return (EReference)componentEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Icons() {
		return (EReference)componentEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_Description() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_Duration() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_Name() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquipment() {
		return equipmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipment_Equipments() {
		return (EReference)equipmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipment_EquipmentGroups() {
		return (EReference)equipmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipment_EquipmentRelationshipRefs() {
		return (EReference)equipmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipment_AllEquipments() {
		return (EReference)equipmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquipment_Count() {
		return (EAttribute)equipmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquipment_EquipmentCode() {
		return (EAttribute)equipmentEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquipment_Position() {
		return (EAttribute)equipmentEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquipment_Redundancy() {
		return (EAttribute)equipmentEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquipment_State() {
		return (EAttribute)equipmentEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquipmentGroup() {
		return equipmentGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentGroup_Diagrams() {
		return (EReference)equipmentGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentGroup_EquipmentGroupResources() {
		return (EReference)equipmentGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentGroup_ExpressionRefs() {
		return (EReference)equipmentGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentGroup_EquipmentRefs() {
		return (EReference)equipmentGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentGroup_ParameterRefs() {
		return (EReference)equipmentGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentGroup_AllEquipmentResources() {
		return (EReference)equipmentGroupEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentGroup_AllEquipments() {
		return (EReference)equipmentGroupEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquipmentGroup_Count() {
		return (EAttribute)equipmentGroupEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquipmentGroup_Description() {
		return (EAttribute)equipmentGroupEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquipmentGroup_Name() {
		return (EAttribute)equipmentGroupEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_ExpressionLines() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_EvaluationObject() {
		return (EReference)expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Name() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionResult() {
		return expressionResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionResult_TargetResource() {
		return (EReference)expressionResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionResult_TargetRange() {
		return (EAttribute)expressionResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionResult_TargetValues() {
		return (EReference)expressionResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionResult_TargetIntervalHint() {
		return (EAttribute)expressionResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionResult_TargetKindHint() {
		return (EAttribute)expressionResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Functions() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_FunctionRelationshipRefs() {
		return (EReference)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_AllFunctions() {
		return (EReference)functionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLastEvaluationExpressionResult() {
		return lastEvaluationExpressionResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLastEvaluationExpressionResult_LastEvalResult() {
		return (EAttribute)lastEvaluationExpressionResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Functions() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_NodeTypes() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Equipments() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Metrics() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_MetricSources() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Parameters() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibrary_Protocols() {
		return (EAttribute)libraryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Tolerances() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Expressions() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Units() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibrary_Version() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibrary_Name() {
		return (EAttribute)libraryEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNetXResource() {
		return netXResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetXResource_ComponentRef() {
		return (EReference)netXResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetXResource_MetricRef() {
		return (EReference)netXResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetXResource_MetricValueRanges() {
		return (EReference)netXResourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetXResource_CapacityValues() {
		return (EReference)netXResourceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetXResource_UtilizationValues() {
		return (EReference)netXResourceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetXResource_ForecastCapacityValues() {
		return (EReference)netXResourceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetXResource_ForecastValues() {
		return (EReference)netXResourceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetXResource_TrendedValues() {
		return (EReference)netXResourceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeType() {
		return nodeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeType_Functions() {
		return (EReference)nodeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeType_Equipments() {
		return (EReference)nodeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeType_LeafNode() {
		return (EAttribute)nodeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNodeType_Name() {
		return (EAttribute)nodeTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Description() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_ExpressionName() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Modifiable() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Value() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProductInfo() {
		return productInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProductInfo_EquipmentRef() {
		return (EReference)productInfoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProductInfo_LicensedFunctionRef() {
		return (EReference)productInfoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProductInfo_NodeTypeRef() {
		return (EReference)productInfoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProductInfo_AvailableDate() {
		return (EAttribute)productInfoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProductInfo_EndOfSalesDate() {
		return (EAttribute)productInfoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProductInfo_EndOfSupportDate() {
		return (EAttribute)productInfoEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProductInfo_ProductCode() {
		return (EAttribute)productInfoEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProductInfo_SalesCode() {
		return (EAttribute)productInfoEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProductInfo_UnderDevelopmentDate() {
		return (EAttribute)productInfoEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceNetwork() {
		return referenceNetworkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceNetwork_Diagrams() {
		return (EReference)referenceNetworkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceNetwork_NodeTypes() {
		return (EReference)referenceNetworkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceNetwork_ReferenceNetworks() {
		return (EReference)referenceNetworkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceNetwork_RefRelationships() {
		return (EReference)referenceNetworkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceNetwork_Description() {
		return (EAttribute)referenceNetworkEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceNetwork_Name() {
		return (EAttribute)referenceNetworkEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceRelationship() {
		return referenceRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceRelationship_Name() {
		return (EAttribute)referenceRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceRelationship_ProtocolRef() {
		return (EReference)referenceRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceRelationship_RefInterface1Ref() {
		return (EReference)referenceRelationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceRelationship_RefInterface2Ref() {
		return (EReference)referenceRelationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTolerance() {
		return toleranceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTolerance_ExpressionRef() {
		return (EReference)toleranceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTolerance_Level() {
		return (EAttribute)toleranceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTolerance_Name() {
		return (EAttribute)toleranceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnit() {
		return unitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_Icons() {
		return (EReference)unitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_Code() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_Description() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_Name() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVendor() {
		return vendorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVendor_Products() {
		return (EReference)vendorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLevelKind() {
		return levelKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRangeKind() {
		return rangeKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRedundancyType() {
		return redundancyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStateType() {
		return stateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLevelKindObject() {
		return levelKindObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRangeKindObject() {
		return rangeKindObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRedundancyTypeObject() {
		return redundancyTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStateTypeObject() {
		return stateTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryFactory getLibraryFactory() {
		return (LibraryFactory)getEFactoryInstance();
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
		baseExpressionResultEClass = createEClass(BASE_EXPRESSION_RESULT);

		baseResourceEClass = createEClass(BASE_RESOURCE);
		createEAttribute(baseResourceEClass, BASE_RESOURCE__DETAIL_DISPLAY);
		createEAttribute(baseResourceEClass, BASE_RESOURCE__EXPRESSION_NAME);
		createEAttribute(baseResourceEClass, BASE_RESOURCE__LONG_NAME);
		createEAttribute(baseResourceEClass, BASE_RESOURCE__SHORT_NAME);
		createEAttribute(baseResourceEClass, BASE_RESOURCE__SUMMARY_DISPLAY);
		createEReference(baseResourceEClass, BASE_RESOURCE__UNIT_REF);

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__LIFECYCLE);
		createEReference(componentEClass, COMPONENT__RESOURCE_REFS);
		createEReference(componentEClass, COMPONENT__CONFIG_ATTRIBUTES);
		createEReference(componentEClass, COMPONENT__METRIC_REFS);
		createEReference(componentEClass, COMPONENT__CAPACITY_EXPRESSION_REF);
		createEReference(componentEClass, COMPONENT__UTILIZATION_EXPRESSION_REF);
		createEReference(componentEClass, COMPONENT__TOLERANCE_REFS);
		createEReference(componentEClass, COMPONENT__PROTOCOL_REFS);
		createEReference(componentEClass, COMPONENT__PARAMETER_REFS);
		createEReference(componentEClass, COMPONENT__ALL_RESOURCES);
		createEReference(componentEClass, COMPONENT__DIAGRAMS);
		createEReference(componentEClass, COMPONENT__ICONS);
		createEAttribute(componentEClass, COMPONENT__DESCRIPTION);
		createEAttribute(componentEClass, COMPONENT__DURATION);
		createEAttribute(componentEClass, COMPONENT__NAME);

		equipmentEClass = createEClass(EQUIPMENT);
		createEReference(equipmentEClass, EQUIPMENT__EQUIPMENTS);
		createEReference(equipmentEClass, EQUIPMENT__EQUIPMENT_GROUPS);
		createEReference(equipmentEClass, EQUIPMENT__EQUIPMENT_RELATIONSHIP_REFS);
		createEReference(equipmentEClass, EQUIPMENT__ALL_EQUIPMENTS);
		createEAttribute(equipmentEClass, EQUIPMENT__COUNT);
		createEAttribute(equipmentEClass, EQUIPMENT__EQUIPMENT_CODE);
		createEAttribute(equipmentEClass, EQUIPMENT__POSITION);
		createEAttribute(equipmentEClass, EQUIPMENT__REDUNDANCY);
		createEAttribute(equipmentEClass, EQUIPMENT__STATE);

		equipmentGroupEClass = createEClass(EQUIPMENT_GROUP);
		createEReference(equipmentGroupEClass, EQUIPMENT_GROUP__DIAGRAMS);
		createEReference(equipmentGroupEClass, EQUIPMENT_GROUP__EQUIPMENT_GROUP_RESOURCES);
		createEReference(equipmentGroupEClass, EQUIPMENT_GROUP__EXPRESSION_REFS);
		createEReference(equipmentGroupEClass, EQUIPMENT_GROUP__EQUIPMENT_REFS);
		createEReference(equipmentGroupEClass, EQUIPMENT_GROUP__PARAMETER_REFS);
		createEReference(equipmentGroupEClass, EQUIPMENT_GROUP__ALL_EQUIPMENT_RESOURCES);
		createEReference(equipmentGroupEClass, EQUIPMENT_GROUP__ALL_EQUIPMENTS);
		createEAttribute(equipmentGroupEClass, EQUIPMENT_GROUP__COUNT);
		createEAttribute(equipmentGroupEClass, EQUIPMENT_GROUP__DESCRIPTION);
		createEAttribute(equipmentGroupEClass, EQUIPMENT_GROUP__NAME);

		expressionEClass = createEClass(EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__EXPRESSION_LINES);
		createEReference(expressionEClass, EXPRESSION__EVALUATION_OBJECT);
		createEAttribute(expressionEClass, EXPRESSION__NAME);

		expressionResultEClass = createEClass(EXPRESSION_RESULT);
		createEReference(expressionResultEClass, EXPRESSION_RESULT__TARGET_RESOURCE);
		createEAttribute(expressionResultEClass, EXPRESSION_RESULT__TARGET_RANGE);
		createEReference(expressionResultEClass, EXPRESSION_RESULT__TARGET_VALUES);
		createEAttribute(expressionResultEClass, EXPRESSION_RESULT__TARGET_INTERVAL_HINT);
		createEAttribute(expressionResultEClass, EXPRESSION_RESULT__TARGET_KIND_HINT);

		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__FUNCTIONS);
		createEReference(functionEClass, FUNCTION__FUNCTION_RELATIONSHIP_REFS);
		createEReference(functionEClass, FUNCTION__ALL_FUNCTIONS);

		lastEvaluationExpressionResultEClass = createEClass(LAST_EVALUATION_EXPRESSION_RESULT);
		createEAttribute(lastEvaluationExpressionResultEClass, LAST_EVALUATION_EXPRESSION_RESULT__LAST_EVAL_RESULT);

		libraryEClass = createEClass(LIBRARY);
		createEReference(libraryEClass, LIBRARY__FUNCTIONS);
		createEReference(libraryEClass, LIBRARY__NODE_TYPES);
		createEReference(libraryEClass, LIBRARY__EQUIPMENTS);
		createEReference(libraryEClass, LIBRARY__METRICS);
		createEReference(libraryEClass, LIBRARY__METRIC_SOURCES);
		createEReference(libraryEClass, LIBRARY__PARAMETERS);
		createEAttribute(libraryEClass, LIBRARY__PROTOCOLS);
		createEReference(libraryEClass, LIBRARY__TOLERANCES);
		createEReference(libraryEClass, LIBRARY__EXPRESSIONS);
		createEReference(libraryEClass, LIBRARY__UNITS);
		createEReference(libraryEClass, LIBRARY__VERSION);
		createEAttribute(libraryEClass, LIBRARY__NAME);

		netXResourceEClass = createEClass(NET_XRESOURCE);
		createEReference(netXResourceEClass, NET_XRESOURCE__COMPONENT_REF);
		createEReference(netXResourceEClass, NET_XRESOURCE__METRIC_REF);
		createEReference(netXResourceEClass, NET_XRESOURCE__METRIC_VALUE_RANGES);
		createEReference(netXResourceEClass, NET_XRESOURCE__CAPACITY_VALUES);
		createEReference(netXResourceEClass, NET_XRESOURCE__UTILIZATION_VALUES);
		createEReference(netXResourceEClass, NET_XRESOURCE__FORECAST_CAPACITY_VALUES);
		createEReference(netXResourceEClass, NET_XRESOURCE__FORECAST_VALUES);
		createEReference(netXResourceEClass, NET_XRESOURCE__TRENDED_VALUES);

		nodeTypeEClass = createEClass(NODE_TYPE);
		createEReference(nodeTypeEClass, NODE_TYPE__FUNCTIONS);
		createEReference(nodeTypeEClass, NODE_TYPE__EQUIPMENTS);
		createEAttribute(nodeTypeEClass, NODE_TYPE__LEAF_NODE);
		createEAttribute(nodeTypeEClass, NODE_TYPE__NAME);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__DESCRIPTION);
		createEAttribute(parameterEClass, PARAMETER__EXPRESSION_NAME);
		createEAttribute(parameterEClass, PARAMETER__MODIFIABLE);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEAttribute(parameterEClass, PARAMETER__VALUE);

		productInfoEClass = createEClass(PRODUCT_INFO);
		createEReference(productInfoEClass, PRODUCT_INFO__EQUIPMENT_REF);
		createEReference(productInfoEClass, PRODUCT_INFO__LICENSED_FUNCTION_REF);
		createEReference(productInfoEClass, PRODUCT_INFO__NODE_TYPE_REF);
		createEAttribute(productInfoEClass, PRODUCT_INFO__AVAILABLE_DATE);
		createEAttribute(productInfoEClass, PRODUCT_INFO__END_OF_SALES_DATE);
		createEAttribute(productInfoEClass, PRODUCT_INFO__END_OF_SUPPORT_DATE);
		createEAttribute(productInfoEClass, PRODUCT_INFO__PRODUCT_CODE);
		createEAttribute(productInfoEClass, PRODUCT_INFO__SALES_CODE);
		createEAttribute(productInfoEClass, PRODUCT_INFO__UNDER_DEVELOPMENT_DATE);

		referenceNetworkEClass = createEClass(REFERENCE_NETWORK);
		createEReference(referenceNetworkEClass, REFERENCE_NETWORK__DIAGRAMS);
		createEReference(referenceNetworkEClass, REFERENCE_NETWORK__NODE_TYPES);
		createEReference(referenceNetworkEClass, REFERENCE_NETWORK__REFERENCE_NETWORKS);
		createEReference(referenceNetworkEClass, REFERENCE_NETWORK__REF_RELATIONSHIPS);
		createEAttribute(referenceNetworkEClass, REFERENCE_NETWORK__DESCRIPTION);
		createEAttribute(referenceNetworkEClass, REFERENCE_NETWORK__NAME);

		referenceRelationshipEClass = createEClass(REFERENCE_RELATIONSHIP);
		createEAttribute(referenceRelationshipEClass, REFERENCE_RELATIONSHIP__NAME);
		createEReference(referenceRelationshipEClass, REFERENCE_RELATIONSHIP__PROTOCOL_REF);
		createEReference(referenceRelationshipEClass, REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF);
		createEReference(referenceRelationshipEClass, REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF);

		toleranceEClass = createEClass(TOLERANCE);
		createEReference(toleranceEClass, TOLERANCE__EXPRESSION_REF);
		createEAttribute(toleranceEClass, TOLERANCE__LEVEL);
		createEAttribute(toleranceEClass, TOLERANCE__NAME);

		unitEClass = createEClass(UNIT);
		createEReference(unitEClass, UNIT__ICONS);
		createEAttribute(unitEClass, UNIT__CODE);
		createEAttribute(unitEClass, UNIT__DESCRIPTION);
		createEAttribute(unitEClass, UNIT__NAME);

		vendorEClass = createEClass(VENDOR);
		createEReference(vendorEClass, VENDOR__PRODUCTS);

		// Create enums
		levelKindEEnum = createEEnum(LEVEL_KIND);
		rangeKindEEnum = createEEnum(RANGE_KIND);
		redundancyTypeEEnum = createEEnum(REDUNDANCY_TYPE);
		stateTypeEEnum = createEEnum(STATE_TYPE);

		// Create data types
		levelKindObjectEDataType = createEDataType(LEVEL_KIND_OBJECT);
		rangeKindObjectEDataType = createEDataType(RANGE_KIND_OBJECT);
		redundancyTypeObjectEDataType = createEDataType(REDUNDANCY_TYPE_OBJECT);
		stateTypeObjectEDataType = createEDataType(STATE_TYPE_OBJECT);
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
		GenericsPackage theGenericsPackage = (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		MetricsPackage theMetricsPackage = (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		ProtocolsPackage theProtocolsPackage = (ProtocolsPackage)EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI);
		OperatorsPackage theOperatorsPackage = (OperatorsPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		baseResourceEClass.getESuperTypes().add(theGenericsPackage.getBase());
		componentEClass.getESuperTypes().add(theGenericsPackage.getBase());
		equipmentEClass.getESuperTypes().add(this.getComponent());
		equipmentGroupEClass.getESuperTypes().add(theGenericsPackage.getBase());
		expressionEClass.getESuperTypes().add(theGenericsPackage.getBase());
		expressionResultEClass.getESuperTypes().add(this.getBaseExpressionResult());
		functionEClass.getESuperTypes().add(this.getComponent());
		lastEvaluationExpressionResultEClass.getESuperTypes().add(this.getBaseExpressionResult());
		netXResourceEClass.getESuperTypes().add(this.getBaseResource());
		nodeTypeEClass.getESuperTypes().add(theGenericsPackage.getBase());
		parameterEClass.getESuperTypes().add(theGenericsPackage.getBase());
		productInfoEClass.getESuperTypes().add(theGenericsPackage.getBase());
		referenceNetworkEClass.getESuperTypes().add(theGenericsPackage.getBase());
		referenceRelationshipEClass.getESuperTypes().add(theGenericsPackage.getBase());
		toleranceEClass.getESuperTypes().add(theGenericsPackage.getBase());
		unitEClass.getESuperTypes().add(theGenericsPackage.getBase());
		vendorEClass.getESuperTypes().add(theGenericsPackage.getCompany());

		// Initialize classes, features, and operations; add parameters
		initEClass(baseExpressionResultEClass, BaseExpressionResult.class, "BaseExpressionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(baseResourceEClass, BaseResource.class, "BaseResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBaseResource_DetailDisplay(), theXMLTypePackage.getBoolean(), "detailDisplay", null, 0, 1, BaseResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseResource_ExpressionName(), theGenericsPackage.getName255(), "expressionName", null, 0, 1, BaseResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseResource_LongName(), theGenericsPackage.getDescription2000(), "longName", null, 0, 1, BaseResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseResource_ShortName(), theGenericsPackage.getName255(), "shortName", null, 0, 1, BaseResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBaseResource_SummaryDisplay(), theXMLTypePackage.getBoolean(), "summaryDisplay", null, 0, 1, BaseResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBaseResource_UnitRef(), this.getUnit(), null, "unitRef", null, 0, 1, BaseResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_Lifecycle(), theGenericsPackage.getLifecycle(), null, "lifecycle", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_ResourceRefs(), this.getNetXResource(), this.getNetXResource_ComponentRef(), "resourceRefs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_ConfigAttributes(), theGenericsPackage.getConfigAttribute(), null, "configAttributes", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_MetricRefs(), theMetricsPackage.getMetric(), null, "metricRefs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_CapacityExpressionRef(), this.getExpression(), null, "capacityExpressionRef", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_UtilizationExpressionRef(), this.getExpression(), null, "utilizationExpressionRef", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_ToleranceRefs(), this.getTolerance(), null, "toleranceRefs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_ProtocolRefs(), theProtocolsPackage.getProtocol(), null, "protocolRefs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_ParameterRefs(), this.getParameter(), null, "parameterRefs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_AllResources(), this.getNetXResource(), null, "allResources", null, 0, -1, Component.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Diagrams(), theGenericsPackage.getDiagramInfo(), null, "diagrams", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Icons(), theGenericsPackage.getMultiImage(), null, "icons", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Duration(), theGenericsPackage.getExpansionDuration(), "duration", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equipmentEClass, Equipment.class, "Equipment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquipment_Equipments(), this.getEquipment(), null, "equipments", null, 0, -1, Equipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipment_EquipmentGroups(), this.getEquipmentGroup(), null, "equipmentGroups", null, 0, -1, Equipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipment_EquipmentRelationshipRefs(), theOperatorsPackage.getEquipmentRelationship(), null, "equipmentRelationshipRefs", null, 0, -1, Equipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipment_AllEquipments(), this.getEquipment(), null, "allEquipments", null, 0, -1, Equipment.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipment_Count(), theXMLTypePackage.getInt(), "count", null, 0, 1, Equipment.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipment_EquipmentCode(), theGenericsPackage.getName255(), "equipmentCode", null, 0, 1, Equipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipment_Position(), theGenericsPackage.getName255(), "position", null, 0, 1, Equipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipment_Redundancy(), this.getRedundancyType(), "redundancy", null, 0, 1, Equipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipment_State(), this.getStateType(), "state", null, 0, 1, Equipment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equipmentGroupEClass, EquipmentGroup.class, "EquipmentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquipmentGroup_Diagrams(), theGenericsPackage.getDiagramInfo(), null, "diagrams", null, 0, -1, EquipmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipmentGroup_EquipmentGroupResources(), this.getNetXResource(), null, "equipmentGroupResources", null, 0, -1, EquipmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipmentGroup_ExpressionRefs(), this.getExpression(), null, "expressionRefs", null, 0, -1, EquipmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipmentGroup_EquipmentRefs(), this.getEquipment(), null, "equipmentRefs", null, 0, -1, EquipmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipmentGroup_ParameterRefs(), this.getParameter(), null, "parameterRefs", null, 0, -1, EquipmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipmentGroup_AllEquipmentResources(), this.getNetXResource(), null, "allEquipmentResources", null, 0, -1, EquipmentGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getEquipmentGroup_AllEquipments(), this.getEquipment(), null, "allEquipments", null, 0, -1, EquipmentGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipmentGroup_Count(), theXMLTypePackage.getInt(), "count", null, 0, 1, EquipmentGroup.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipmentGroup_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, EquipmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEquipmentGroup_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, EquipmentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpression_ExpressionLines(), theGenericsPackage.getExpressionLine(), "expressionLines", null, 0, -1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpression_EvaluationObject(), ecorePackage.getEObject(), null, "evaluationObject", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpression_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionResultEClass, ExpressionResult.class, "ExpressionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionResult_TargetResource(), this.getBaseResource(), null, "targetResource", null, 0, 1, ExpressionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpressionResult_TargetRange(), this.getRangeKind(), "targetRange", null, 0, 1, ExpressionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpressionResult_TargetValues(), theGenericsPackage.getValue(), null, "targetValues", null, 0, -1, ExpressionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpressionResult_TargetIntervalHint(), theXMLTypePackage.getInt(), "targetIntervalHint", null, 0, 1, ExpressionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpressionResult_TargetKindHint(), theMetricsPackage.getKindHintType(), "targetKindHint", null, 0, 1, ExpressionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_Functions(), this.getFunction(), null, "functions", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_FunctionRelationshipRefs(), theOperatorsPackage.getFunctionRelationship(), null, "functionRelationshipRefs", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_AllFunctions(), this.getFunction(), null, "allFunctions", null, 0, -1, Function.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(lastEvaluationExpressionResultEClass, LastEvaluationExpressionResult.class, "LastEvaluationExpressionResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLastEvaluationExpressionResult_LastEvalResult(), theXMLTypePackage.getAnySimpleType(), "lastEvalResult", null, 0, 1, LastEvaluationExpressionResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLibrary_Functions(), this.getFunction(), null, "functions", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_NodeTypes(), this.getNodeType(), null, "nodeTypes", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Equipments(), this.getEquipment(), null, "equipments", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Metrics(), theMetricsPackage.getMetric(), null, "metrics", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_MetricSources(), theMetricsPackage.getMetricSource(), null, "metricSources", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibrary_Protocols(), theXMLTypePackage.getString(), "protocols", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Tolerances(), this.getTolerance(), null, "tolerances", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Units(), this.getUnit(), null, "units", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Version(), theGenericsPackage.getMeta(), null, "version", null, 0, 1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibrary_Name(), theGenericsPackage.getName255(), "name", "Library name", 0, 1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(netXResourceEClass, NetXResource.class, "NetXResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNetXResource_ComponentRef(), this.getComponent(), this.getComponent_ResourceRefs(), "componentRef", null, 1, 1, NetXResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetXResource_MetricRef(), theMetricsPackage.getMetric(), null, "metricRef", null, 0, 1, NetXResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetXResource_MetricValueRanges(), theMetricsPackage.getMetricValueRange(), null, "metricValueRanges", null, 0, -1, NetXResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetXResource_CapacityValues(), theGenericsPackage.getValue(), null, "capacityValues", null, 0, -1, NetXResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetXResource_UtilizationValues(), theGenericsPackage.getValue(), null, "utilizationValues", null, 0, -1, NetXResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetXResource_ForecastCapacityValues(), theGenericsPackage.getValue(), null, "forecastCapacityValues", null, 0, -1, NetXResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetXResource_ForecastValues(), theGenericsPackage.getValue(), null, "forecastValues", null, 0, -1, NetXResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetXResource_TrendedValues(), theGenericsPackage.getValue(), null, "trendedValues", null, 0, -1, NetXResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeTypeEClass, NodeType.class, "NodeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeType_Functions(), this.getFunction(), null, "functions", null, 0, -1, NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeType_Equipments(), this.getEquipment(), null, "equipments", null, 0, -1, NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeType_LeafNode(), theXMLTypePackage.getBoolean(), "leafNode", "false", 0, 1, NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNodeType_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, NodeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_ExpressionName(), theGenericsPackage.getName255(), "expressionName", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Modifiable(), theXMLTypePackage.getBoolean(), "modifiable", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Value(), theXMLTypePackage.getDouble(), "value", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(productInfoEClass, ProductInfo.class, "ProductInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProductInfo_EquipmentRef(), this.getEquipment(), null, "equipmentRef", null, 0, -1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProductInfo_LicensedFunctionRef(), this.getFunction(), null, "licensedFunctionRef", null, 0, -1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProductInfo_NodeTypeRef(), this.getNodeType(), null, "nodeTypeRef", null, 0, -1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProductInfo_AvailableDate(), theXMLTypePackage.getDateTime(), "availableDate", null, 0, 1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProductInfo_EndOfSalesDate(), theXMLTypePackage.getDateTime(), "endOfSalesDate", null, 0, 1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProductInfo_EndOfSupportDate(), theXMLTypePackage.getDateTime(), "endOfSupportDate", null, 0, 1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProductInfo_ProductCode(), theGenericsPackage.getName255(), "productCode", null, 0, 1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProductInfo_SalesCode(), theGenericsPackage.getName255(), "salesCode", null, 0, 1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProductInfo_UnderDevelopmentDate(), theXMLTypePackage.getDateTime(), "underDevelopmentDate", null, 0, 1, ProductInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceNetworkEClass, ReferenceNetwork.class, "ReferenceNetwork", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceNetwork_Diagrams(), theGenericsPackage.getDiagramInfo(), null, "diagrams", null, 0, -1, ReferenceNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceNetwork_NodeTypes(), this.getNodeType(), null, "nodeTypes", null, 0, -1, ReferenceNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceNetwork_ReferenceNetworks(), this.getReferenceNetwork(), null, "referenceNetworks", null, 0, -1, ReferenceNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceNetwork_RefRelationships(), this.getReferenceRelationship(), null, "refRelationships", null, 0, -1, ReferenceNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceNetwork_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, ReferenceNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceNetwork_Name(), theGenericsPackage.getName255(), "name", "name", 0, 1, ReferenceNetwork.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceRelationshipEClass, ReferenceRelationship.class, "ReferenceRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceRelationship_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, ReferenceRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceRelationship_ProtocolRef(), theProtocolsPackage.getProtocol(), null, "protocolRef", null, 0, 1, ReferenceRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceRelationship_RefInterface1Ref(), this.getNodeType(), null, "refInterface1Ref", null, 0, 1, ReferenceRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceRelationship_RefInterface2Ref(), this.getNodeType(), null, "refInterface2Ref", null, 0, 1, ReferenceRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toleranceEClass, Tolerance.class, "Tolerance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTolerance_ExpressionRef(), this.getExpression(), null, "expressionRef", null, 0, 1, Tolerance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTolerance_Level(), this.getLevelKind(), "level", null, 0, 1, Tolerance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTolerance_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, Tolerance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnit_Icons(), theGenericsPackage.getMultiImage(), null, "icons", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnit_Code(), theGenericsPackage.getUnitCode(), "code", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnit_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnit_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vendorEClass, Vendor.class, "Vendor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVendor_Products(), this.getProductInfo(), null, "products", null, 0, -1, Vendor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(levelKindEEnum, LevelKind.class, "LevelKind");
		addEEnumLiteral(levelKindEEnum, LevelKind.RED);
		addEEnumLiteral(levelKindEEnum, LevelKind.AMBER);
		addEEnumLiteral(levelKindEEnum, LevelKind.GREEN);
		addEEnumLiteral(levelKindEEnum, LevelKind.YELLOW);

		initEEnum(rangeKindEEnum, RangeKind.class, "RangeKind");
		addEEnumLiteral(rangeKindEEnum, RangeKind.METRIC);
		addEEnumLiteral(rangeKindEEnum, RangeKind.METRICREMOVE);
		addEEnumLiteral(rangeKindEEnum, RangeKind.CAP);
		addEEnumLiteral(rangeKindEEnum, RangeKind.DERIVED);
		addEEnumLiteral(rangeKindEEnum, RangeKind.FORECAST);
		addEEnumLiteral(rangeKindEEnum, RangeKind.FORECASTCAP);
		addEEnumLiteral(rangeKindEEnum, RangeKind.TRENDED);
		addEEnumLiteral(rangeKindEEnum, RangeKind.UTILIZATION);
		addEEnumLiteral(rangeKindEEnum, RangeKind.TOLERANCE);

		initEEnum(redundancyTypeEEnum, RedundancyType.class, "RedundancyType");
		addEEnumLiteral(redundancyTypeEEnum, RedundancyType.N);
		addEEnumLiteral(redundancyTypeEEnum, RedundancyType.N1);
		addEEnumLiteral(redundancyTypeEEnum, RedundancyType._11);

		initEEnum(stateTypeEEnum, StateType.class, "StateType");
		addEEnumLiteral(stateTypeEEnum, StateType.ACTIVE);
		addEEnumLiteral(stateTypeEEnum, StateType.STANDBY);
		addEEnumLiteral(stateTypeEEnum, StateType.IDLE);
		addEEnumLiteral(stateTypeEEnum, StateType.DEFECT);
		addEEnumLiteral(stateTypeEEnum, StateType.RESERVED);

		// Initialize data types
		initEDataType(levelKindObjectEDataType, LevelKind.class, "LevelKindObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(rangeKindObjectEDataType, RangeKind.class, "RangeKindObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(redundancyTypeObjectEDataType, RedundancyType.class, "RedundancyTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stateTypeObjectEDataType, StateType.class, "StateTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
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
		addAnnotation
		  (functionEClass, 
		   source, 
		   new String[] {
			 "constraints", "\n\t\t\t\tValidFunctionName\n\t\t\t"
		   });																																																													
		addAnnotation
		  (nodeTypeEClass, 
		   source, 
		   new String[] {
			 "constraints", "\n\t\t\t\tValidNodeID\n\t\t\t"
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
		  (baseExpressionResultEClass, 
		   source, 
		   new String[] {
			 "name", "BaseExpressionResult",
			 "kind", "empty"
		   });			
		addAnnotation
		  (baseResourceEClass, 
		   source, 
		   new String[] {
			 "name", "BaseResource",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getBaseResource_DetailDisplay(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "DetailDisplay"
		   });			
		addAnnotation
		  (getBaseResource_ExpressionName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ExpressionName"
		   });			
		addAnnotation
		  (getBaseResource_LongName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "LongName"
		   });			
		addAnnotation
		  (getBaseResource_ShortName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ShortName"
		   });			
		addAnnotation
		  (getBaseResource_SummaryDisplay(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SummaryDisplay"
		   });			
		addAnnotation
		  (getBaseResource_UnitRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "UnitRef"
		   });			
		addAnnotation
		  (componentEClass, 
		   source, 
		   new String[] {
			 "name", "Component",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getComponent_Lifecycle(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Lifecycle"
		   });			
		addAnnotation
		  (getComponent_ResourceRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceRefs"
		   });			
		addAnnotation
		  (getComponent_ConfigAttributes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ConfigAttributes"
		   });			
		addAnnotation
		  (getComponent_MetricRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricRefs"
		   });			
		addAnnotation
		  (getComponent_CapacityExpressionRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CapacityExpressionRef"
		   });			
		addAnnotation
		  (getComponent_UtilizationExpressionRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "UtilizationExpressionRef"
		   });			
		addAnnotation
		  (getComponent_ToleranceRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ToleranceRefs"
		   });			
		addAnnotation
		  (getComponent_ProtocolRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ProtocolRefs"
		   });			
		addAnnotation
		  (getComponent_ParameterRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ParameterRefs"
		   });				
		addAnnotation
		  (getComponent_AllResources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AllResources"
		   });			
		addAnnotation
		  (getComponent_Diagrams(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Diagrams"
		   });			
		addAnnotation
		  (getComponent_Icons(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Icons"
		   });			
		addAnnotation
		  (getComponent_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getComponent_Duration(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Duration"
		   });			
		addAnnotation
		  (getComponent_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (equipmentEClass, 
		   source, 
		   new String[] {
			 "name", "Equipment",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getEquipment_Equipments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Equipments"
		   });			
		addAnnotation
		  (getEquipment_EquipmentGroups(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EquipmentGroups"
		   });			
		addAnnotation
		  (getEquipment_EquipmentRelationshipRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EquipmentRelationshipRefs"
		   });				
		addAnnotation
		  (getEquipment_AllEquipments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AllEquipments"
		   });				
		addAnnotation
		  (getEquipment_Count(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Count"
		   });			
		addAnnotation
		  (getEquipment_EquipmentCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "EquipmentCode"
		   });			
		addAnnotation
		  (getEquipment_Position(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Position"
		   });			
		addAnnotation
		  (getEquipment_Redundancy(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Redundancy"
		   });			
		addAnnotation
		  (getEquipment_State(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "State"
		   });			
		addAnnotation
		  (equipmentGroupEClass, 
		   source, 
		   new String[] {
			 "name", "EquipmentGroup",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getEquipmentGroup_Diagrams(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Diagrams"
		   });			
		addAnnotation
		  (getEquipmentGroup_EquipmentGroupResources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EquipmentGroupResources"
		   });			
		addAnnotation
		  (getEquipmentGroup_ExpressionRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExpressionRefs"
		   });			
		addAnnotation
		  (getEquipmentGroup_EquipmentRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EquipmentRefs"
		   });			
		addAnnotation
		  (getEquipmentGroup_ParameterRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ParameterRefs"
		   });				
		addAnnotation
		  (getEquipmentGroup_AllEquipmentResources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AllEquipmentResources"
		   });				
		addAnnotation
		  (getEquipmentGroup_AllEquipments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AllEquipments"
		   });				
		addAnnotation
		  (getEquipmentGroup_Count(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Count"
		   });			
		addAnnotation
		  (getEquipmentGroup_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getEquipmentGroup_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (expressionEClass, 
		   source, 
		   new String[] {
			 "name", "Expression",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getExpression_ExpressionLines(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExpressionLines"
		   });			
		addAnnotation
		  (getExpression_EvaluationObject(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EvaluationObject"
		   });			
		addAnnotation
		  (getExpression_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (expressionResultEClass, 
		   source, 
		   new String[] {
			 "name", "ExpressionResult",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getExpressionResult_TargetResource(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TargetResource"
		   });		
		addAnnotation
		  (getExpressionResult_TargetRange(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TargetRange"
		   });		
		addAnnotation
		  (getExpressionResult_TargetValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TargetValues"
		   });		
		addAnnotation
		  (getExpressionResult_TargetIntervalHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "TargetIntervalHint"
		   });		
		addAnnotation
		  (getExpressionResult_TargetKindHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "TargetKindHint"
		   });					
		addAnnotation
		  (functionEClass, 
		   source, 
		   new String[] {
			 "name", "Function",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getFunction_Functions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Functions"
		   });			
		addAnnotation
		  (getFunction_FunctionRelationshipRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FunctionRelationshipRefs"
		   });				
		addAnnotation
		  (getFunction_AllFunctions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AllFunctions"
		   });			
		addAnnotation
		  (lastEvaluationExpressionResultEClass, 
		   source, 
		   new String[] {
			 "name", "LastEvaluationExpressionResult",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLastEvaluationExpressionResult_LastEvalResult(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "LastEvalResult"
		   });		
		addAnnotation
		  (levelKindEEnum, 
		   source, 
		   new String[] {
			 "name", "LevelKind"
		   });		
		addAnnotation
		  (levelKindObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "LevelKind:Object",
			 "baseType", "LevelKind"
		   });			
		addAnnotation
		  (libraryEClass, 
		   source, 
		   new String[] {
			 "name", "Library",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getLibrary_Functions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Functions"
		   });			
		addAnnotation
		  (getLibrary_NodeTypes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeTypes"
		   });			
		addAnnotation
		  (getLibrary_Equipments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Equipments"
		   });			
		addAnnotation
		  (getLibrary_Metrics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Metrics"
		   });			
		addAnnotation
		  (getLibrary_MetricSources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricSources"
		   });			
		addAnnotation
		  (getLibrary_Parameters(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Parameters"
		   });			
		addAnnotation
		  (getLibrary_Protocols(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Protocols"
		   });			
		addAnnotation
		  (getLibrary_Tolerances(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Tolerances"
		   });			
		addAnnotation
		  (getLibrary_Expressions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Expressions"
		   });			
		addAnnotation
		  (getLibrary_Units(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Units"
		   });			
		addAnnotation
		  (getLibrary_Version(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Version"
		   });			
		addAnnotation
		  (getLibrary_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (netXResourceEClass, 
		   source, 
		   new String[] {
			 "name", "NetXResource",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getNetXResource_ComponentRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ComponentRef"
		   });			
		addAnnotation
		  (getNetXResource_MetricRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricRef"
		   });			
		addAnnotation
		  (getNetXResource_MetricValueRanges(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricValueRanges"
		   });			
		addAnnotation
		  (getNetXResource_CapacityValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CapacityValues"
		   });			
		addAnnotation
		  (getNetXResource_UtilizationValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "UtilizationValues"
		   });			
		addAnnotation
		  (getNetXResource_ForecastCapacityValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ForecastCapacityValues"
		   });			
		addAnnotation
		  (getNetXResource_ForecastValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ForecastValues"
		   });			
		addAnnotation
		  (getNetXResource_TrendedValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TrendedValues"
		   });					
		addAnnotation
		  (nodeTypeEClass, 
		   source, 
		   new String[] {
			 "name", "NodeType",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getNodeType_Functions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Functions"
		   });			
		addAnnotation
		  (getNodeType_Equipments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Equipments"
		   });			
		addAnnotation
		  (getNodeType_LeafNode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "LeafNode"
		   });		
		addAnnotation
		  (getNodeType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
			 "name", "Parameter",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getParameter_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getParameter_ExpressionName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ExpressionName"
		   });			
		addAnnotation
		  (getParameter_Modifiable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Modifiable"
		   });			
		addAnnotation
		  (getParameter_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getParameter_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Value"
		   });			
		addAnnotation
		  (productInfoEClass, 
		   source, 
		   new String[] {
			 "name", "ProductInfo",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getProductInfo_EquipmentRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EquipmentRef"
		   });			
		addAnnotation
		  (getProductInfo_LicensedFunctionRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "LicensedFunctionRef"
		   });			
		addAnnotation
		  (getProductInfo_NodeTypeRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeTypeRef"
		   });			
		addAnnotation
		  (getProductInfo_AvailableDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "AvailableDate"
		   });			
		addAnnotation
		  (getProductInfo_EndOfSalesDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "EndOfSalesDate"
		   });			
		addAnnotation
		  (getProductInfo_EndOfSupportDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "EndOfSupportDate"
		   });			
		addAnnotation
		  (getProductInfo_ProductCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ProductCode"
		   });			
		addAnnotation
		  (getProductInfo_SalesCode(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "SalesCode"
		   });			
		addAnnotation
		  (getProductInfo_UnderDevelopmentDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "UnderDevelopmentDate"
		   });		
		addAnnotation
		  (rangeKindEEnum, 
		   source, 
		   new String[] {
			 "name", "RangeKind"
		   });		
		addAnnotation
		  (rangeKindObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "RangeKind:Object",
			 "baseType", "RangeKind"
		   });		
		addAnnotation
		  (redundancyTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "Redundancy_._type"
		   });		
		addAnnotation
		  (redundancyTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "Redundancy_._type:Object",
			 "baseType", "Redundancy_._type"
		   });			
		addAnnotation
		  (referenceNetworkEClass, 
		   source, 
		   new String[] {
			 "name", "ReferenceNetwork",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getReferenceNetwork_Diagrams(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Diagrams"
		   });			
		addAnnotation
		  (getReferenceNetwork_NodeTypes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeTypes"
		   });			
		addAnnotation
		  (getReferenceNetwork_ReferenceNetworks(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ReferenceNetworks"
		   });			
		addAnnotation
		  (getReferenceNetwork_RefRelationships(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "RefRelationships"
		   });			
		addAnnotation
		  (getReferenceNetwork_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getReferenceNetwork_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (referenceRelationshipEClass, 
		   source, 
		   new String[] {
			 "name", "ReferenceRelationship",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getReferenceRelationship_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getReferenceRelationship_ProtocolRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ProtocolRef"
		   });			
		addAnnotation
		  (getReferenceRelationship_RefInterface1Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefInterface1Ref"
		   });			
		addAnnotation
		  (getReferenceRelationship_RefInterface2Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RefInterface2Ref"
		   });		
		addAnnotation
		  (stateTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "State_._type"
		   });		
		addAnnotation
		  (stateTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "State_._type:Object",
			 "baseType", "State_._type"
		   });			
		addAnnotation
		  (toleranceEClass, 
		   source, 
		   new String[] {
			 "name", "Tolerance",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getTolerance_ExpressionRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ExpressionRef"
		   });			
		addAnnotation
		  (getTolerance_Level(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Level"
		   });			
		addAnnotation
		  (getTolerance_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (unitEClass, 
		   source, 
		   new String[] {
			 "name", "Unit",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getUnit_Icons(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Icons"
		   });			
		addAnnotation
		  (getUnit_Code(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Code"
		   });			
		addAnnotation
		  (getUnit_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getUnit_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (vendorEClass, 
		   source, 
		   new String[] {
			 "name", "Vendor",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getVendor_Products(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Products"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";																																									
		addAnnotation
		  (getComponent_AllResources(), 
		   source, 
		   new String[] {
			 "derivation", "self->closure(equipments).resources->asOrderedSet()\n\t\t\t\t\t\t\t"
		   });																						
		addAnnotation
		  (getEquipment_AllEquipments(), 
		   source, 
		   new String[] {
			 "derivation", "self->closure(equipments)->asOrderedSet()"
		   });				
		addAnnotation
		  (getEquipment_Count(), 
		   source, 
		   new String[] {
			 "derivation", "self.equipments->size()\n\t\t\t\t\t\t"
		   });																								
		addAnnotation
		  (getEquipmentGroup_AllEquipmentResources(), 
		   source, 
		   new String[] {
			 "derivation", "self->closure(equipmentRefs).equipmentResources->asOrderedSet()\n\t\t\t\t\t\t\t"
		   });				
		addAnnotation
		  (getEquipmentGroup_AllEquipments(), 
		   source, 
		   new String[] {
			 "derivation", "\n\t\t\t\t\t\t\t\tself->closure(equipmentRefs)->asOrderedSet()\n\t\t\t\t\t\t\t"
		   });				
		addAnnotation
		  (getEquipmentGroup_Count(), 
		   source, 
		   new String[] {
			 "derivation", "self.equipments->size()\n\t\t\t\t\t\t"
		   });																								
		addAnnotation
		  (functionEClass, 
		   source, 
		   new String[] {
			 "ValidFunctionName", "\n\t\t\t\tnot self.functionName.oclIsUndefined()\n\t\t\t"
		   });								
		addAnnotation
		  (getFunction_AllFunctions(), 
		   source, 
		   new String[] {
			 "derivation", "self->closure(functions)->asOrderedSet()\n\t\t\t\t\t\t\t"
		   });																																																						
		addAnnotation
		  (nodeTypeEClass, 
		   source, 
		   new String[] {
			 "ValidNodeID", "\n\t\t\t\tnot self.nodeID.oclIsUndefined()\n\t\t\t"
		   });																																																																																												
	}

} //LibraryPackageImpl

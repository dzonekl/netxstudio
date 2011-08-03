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
package com.netxforge.netxstudio.operators.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.impl.GenericsPackageImpl;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.impl.GeoPackageImpl;
import com.netxforge.netxstudio.impl.NetxstudioPackageImpl;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.impl.LibraryPackageImpl;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.MarkerKind;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.operators.ResourceExpansion;
import com.netxforge.netxstudio.operators.ResourceForecast;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.Warehouse;
import com.netxforge.netxstudio.operators.util.OperatorsValidator;
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
public class OperatorsPackageImpl extends EPackageImpl implements OperatorsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equipmentRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass networkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceExpansionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceForecastEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceMonitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass warehouseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum markerKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType markerKindObjectEDataType = null;

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
	 * @see com.netxforge.netxstudio.operators.OperatorsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OperatorsPackageImpl() {
		super(eNS_URI, OperatorsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OperatorsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OperatorsPackage init() {
		if (isInited) return (OperatorsPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI);

		// Obtain or create and register package
		OperatorsPackageImpl theOperatorsPackage = (OperatorsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OperatorsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OperatorsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		GenericsPackageImpl theGenericsPackage = (GenericsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) instanceof GenericsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) : GenericsPackage.eINSTANCE);
		ServicesPackageImpl theServicesPackage = (ServicesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) instanceof ServicesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI) : ServicesPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) instanceof MetricsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) : MetricsPackage.eINSTANCE);
		GeoPackageImpl theGeoPackage = (GeoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) instanceof GeoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) : GeoPackage.eINSTANCE);
		ProtocolsPackageImpl theProtocolsPackage = (ProtocolsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) instanceof ProtocolsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) : ProtocolsPackage.eINSTANCE);
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);
		NetxstudioPackageImpl theNetxstudioPackage = (NetxstudioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) instanceof NetxstudioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) : NetxstudioPackage.eINSTANCE);

		// Create package meta-data objects
		theOperatorsPackage.createPackageContents();
		theGenericsPackage.createPackageContents();
		theServicesPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theGeoPackage.createPackageContents();
		theProtocolsPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();
		theNetxstudioPackage.createPackageContents();

		// Initialize created meta-data
		theOperatorsPackage.initializePackageContents();
		theGenericsPackage.initializePackageContents();
		theServicesPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theGeoPackage.initializePackageContents();
		theProtocolsPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();
		theNetxstudioPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theOperatorsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return OperatorsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theOperatorsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OperatorsPackage.eNS_URI, theOperatorsPackage);
		return theOperatorsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquipmentRelationship() {
		return equipmentRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentRelationship_Equipment1Ref() {
		return (EReference)equipmentRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquipmentRelationship_Equipment2Ref() {
		return (EReference)equipmentRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionRelationship() {
		return functionRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionRelationship_Function1Ref() {
		return (EReference)functionRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionRelationship_Function2Ref() {
		return (EReference)functionRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMarker() {
		return markerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarker_ComponentRef() {
		return (EReference)markerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarker_ValueRef() {
		return (EReference)markerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMarker_MarkerResourceRef() {
		return (EReference)markerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarker_Description() {
		return (EAttribute)markerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMarker_Kind() {
		return (EAttribute)markerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNetwork() {
		return networkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_Diagrams() {
		return (EReference)networkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_Nodes() {
		return (EReference)networkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_Networks() {
		return (EReference)networkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_FunctionRelationships() {
		return (EReference)networkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_EquipmentRelationships() {
		return (EReference)networkEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_MetricSources() {
		return (EReference)networkEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNetwork_CreatedByRef() {
		return (EReference)networkEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_CreatedDate() {
		return (EAttribute)networkEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Description() {
		return (EAttribute)networkEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNetwork_Name() {
		return (EAttribute)networkEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Lifecycle() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_NodeType() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_CreatedByRef() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_NodeID() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_OriginalNodeTypeRef() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_RoomRef() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperator() {
		return operatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_Networks() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_Warehouses() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_Services() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_ServiceUsers() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_ResourceExpansions() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationship() {
		return relationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Name() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_NodeID1Ref() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_NodeID2Ref() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_ProtocolRef() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceExpansion() {
		return resourceExpansionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceExpansion_NodeRefs() {
		return (EReference)resourceExpansionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceExpansion_EquipmentRefs() {
		return (EReference)resourceExpansionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceExpansion_FunctionRefs() {
		return (EReference)resourceExpansionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceForecast() {
		return resourceForecastEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceForecast_Markers() {
		return (EReference)resourceForecastEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceMonitor() {
		return resourceMonitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceMonitor_Markers() {
		return (EReference)resourceMonitorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceMonitor_NodeRef() {
		return (EReference)resourceMonitorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceMonitor_ResourceRef() {
		return (EReference)resourceMonitorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceMonitor_End() {
		return (EAttribute)resourceMonitorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceMonitor_Start() {
		return (EAttribute)resourceMonitorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWarehouse() {
		return warehouseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWarehouse_Nodes() {
		return (EReference)warehouseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWarehouse_Equipments() {
		return (EReference)warehouseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWarehouse_Description() {
		return (EAttribute)warehouseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWarehouse_Name() {
		return (EAttribute)warehouseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMarkerKind() {
		return markerKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMarkerKindObject() {
		return markerKindObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorsFactory getOperatorsFactory() {
		return (OperatorsFactory)getEFactoryInstance();
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
		equipmentRelationshipEClass = createEClass(EQUIPMENT_RELATIONSHIP);
		createEReference(equipmentRelationshipEClass, EQUIPMENT_RELATIONSHIP__EQUIPMENT1_REF);
		createEReference(equipmentRelationshipEClass, EQUIPMENT_RELATIONSHIP__EQUIPMENT2_REF);

		functionRelationshipEClass = createEClass(FUNCTION_RELATIONSHIP);
		createEReference(functionRelationshipEClass, FUNCTION_RELATIONSHIP__FUNCTION1_REF);
		createEReference(functionRelationshipEClass, FUNCTION_RELATIONSHIP__FUNCTION2_REF);

		markerEClass = createEClass(MARKER);
		createEReference(markerEClass, MARKER__COMPONENT_REF);
		createEReference(markerEClass, MARKER__VALUE_REF);
		createEReference(markerEClass, MARKER__MARKER_RESOURCE_REF);
		createEAttribute(markerEClass, MARKER__DESCRIPTION);
		createEAttribute(markerEClass, MARKER__KIND);

		networkEClass = createEClass(NETWORK);
		createEReference(networkEClass, NETWORK__DIAGRAMS);
		createEReference(networkEClass, NETWORK__NODES);
		createEReference(networkEClass, NETWORK__NETWORKS);
		createEReference(networkEClass, NETWORK__FUNCTION_RELATIONSHIPS);
		createEReference(networkEClass, NETWORK__EQUIPMENT_RELATIONSHIPS);
		createEReference(networkEClass, NETWORK__METRIC_SOURCES);
		createEReference(networkEClass, NETWORK__CREATED_BY_REF);
		createEAttribute(networkEClass, NETWORK__CREATED_DATE);
		createEAttribute(networkEClass, NETWORK__DESCRIPTION);
		createEAttribute(networkEClass, NETWORK__NAME);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__LIFECYCLE);
		createEReference(nodeEClass, NODE__NODE_TYPE);
		createEReference(nodeEClass, NODE__CREATED_BY_REF);
		createEAttribute(nodeEClass, NODE__NODE_ID);
		createEReference(nodeEClass, NODE__ORIGINAL_NODE_TYPE_REF);
		createEReference(nodeEClass, NODE__ROOM_REF);

		operatorEClass = createEClass(OPERATOR);
		createEReference(operatorEClass, OPERATOR__NETWORKS);
		createEReference(operatorEClass, OPERATOR__WAREHOUSES);
		createEReference(operatorEClass, OPERATOR__SERVICES);
		createEReference(operatorEClass, OPERATOR__SERVICE_USERS);
		createEReference(operatorEClass, OPERATOR__RESOURCE_EXPANSIONS);

		relationshipEClass = createEClass(RELATIONSHIP);
		createEAttribute(relationshipEClass, RELATIONSHIP__NAME);
		createEReference(relationshipEClass, RELATIONSHIP__NODE_ID1_REF);
		createEReference(relationshipEClass, RELATIONSHIP__NODE_ID2_REF);
		createEReference(relationshipEClass, RELATIONSHIP__PROTOCOL_REF);

		resourceExpansionEClass = createEClass(RESOURCE_EXPANSION);
		createEReference(resourceExpansionEClass, RESOURCE_EXPANSION__NODE_REFS);
		createEReference(resourceExpansionEClass, RESOURCE_EXPANSION__EQUIPMENT_REFS);
		createEReference(resourceExpansionEClass, RESOURCE_EXPANSION__FUNCTION_REFS);

		resourceForecastEClass = createEClass(RESOURCE_FORECAST);
		createEReference(resourceForecastEClass, RESOURCE_FORECAST__MARKERS);

		resourceMonitorEClass = createEClass(RESOURCE_MONITOR);
		createEReference(resourceMonitorEClass, RESOURCE_MONITOR__MARKERS);
		createEReference(resourceMonitorEClass, RESOURCE_MONITOR__NODE_REF);
		createEReference(resourceMonitorEClass, RESOURCE_MONITOR__RESOURCE_REF);
		createEAttribute(resourceMonitorEClass, RESOURCE_MONITOR__END);
		createEAttribute(resourceMonitorEClass, RESOURCE_MONITOR__START);

		warehouseEClass = createEClass(WAREHOUSE);
		createEReference(warehouseEClass, WAREHOUSE__NODES);
		createEReference(warehouseEClass, WAREHOUSE__EQUIPMENTS);
		createEAttribute(warehouseEClass, WAREHOUSE__DESCRIPTION);
		createEAttribute(warehouseEClass, WAREHOUSE__NAME);

		// Create enums
		markerKindEEnum = createEEnum(MARKER_KIND);

		// Create data types
		markerKindObjectEDataType = createEDataType(MARKER_KIND_OBJECT);
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
		LibraryPackage theLibraryPackage = (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);
		GenericsPackage theGenericsPackage = (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);
		MetricsPackage theMetricsPackage = (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		GeoPackage theGeoPackage = (GeoPackage)EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI);
		ServicesPackage theServicesPackage = (ServicesPackage)EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI);
		ProtocolsPackage theProtocolsPackage = (ProtocolsPackage)EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		equipmentRelationshipEClass.getESuperTypes().add(this.getRelationship());
		functionRelationshipEClass.getESuperTypes().add(this.getRelationship());
		markerEClass.getESuperTypes().add(theGenericsPackage.getBase());
		networkEClass.getESuperTypes().add(theGenericsPackage.getBase());
		nodeEClass.getESuperTypes().add(theGenericsPackage.getBase());
		operatorEClass.getESuperTypes().add(theGenericsPackage.getCompany());
		relationshipEClass.getESuperTypes().add(theGenericsPackage.getBase());
		resourceExpansionEClass.getESuperTypes().add(theGenericsPackage.getBase());
		resourceForecastEClass.getESuperTypes().add(theGenericsPackage.getBase());
		resourceMonitorEClass.getESuperTypes().add(theGenericsPackage.getBase());
		warehouseEClass.getESuperTypes().add(theGenericsPackage.getBase());

		// Initialize classes and features; add operations and parameters
		initEClass(equipmentRelationshipEClass, EquipmentRelationship.class, "EquipmentRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquipmentRelationship_Equipment1Ref(), theLibraryPackage.getEquipment(), null, "equipment1Ref", null, 0, 1, EquipmentRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquipmentRelationship_Equipment2Ref(), theLibraryPackage.getEquipment(), null, "equipment2Ref", null, 0, 1, EquipmentRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionRelationshipEClass, FunctionRelationship.class, "FunctionRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionRelationship_Function1Ref(), theLibraryPackage.getFunction(), null, "function1Ref", null, 0, 1, FunctionRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionRelationship_Function2Ref(), theLibraryPackage.getFunction(), null, "function2Ref", null, 0, 1, FunctionRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markerEClass, Marker.class, "Marker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMarker_ComponentRef(), theLibraryPackage.getComponent(), null, "componentRef", null, 0, 1, Marker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarker_ValueRef(), theGenericsPackage.getValue(), null, "valueRef", null, 0, 1, Marker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMarker_MarkerResourceRef(), theLibraryPackage.getNetXResource(), null, "markerResourceRef", null, 0, 1, Marker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarker_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, Marker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMarker_Kind(), this.getMarkerKind(), "kind", null, 0, 1, Marker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(networkEClass, Network.class, "Network", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNetwork_Diagrams(), theGenericsPackage.getDiagramInfo(), null, "diagrams", null, 0, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_Nodes(), this.getNode(), null, "nodes", null, 0, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_Networks(), this.getNetwork(), null, "networks", null, 0, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_FunctionRelationships(), this.getFunctionRelationship(), null, "functionRelationships", null, 0, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_EquipmentRelationships(), this.getEquipmentRelationship(), null, "equipmentRelationships", null, 0, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_MetricSources(), theMetricsPackage.getMetricSource(), null, "metricSources", null, 0, -1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNetwork_CreatedByRef(), theGenericsPackage.getPerson(), null, "createdByRef", null, 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_CreatedDate(), theXMLTypePackage.getDateTime(), "createdDate", null, 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNetwork_Name(), theGenericsPackage.getName255(), "name", "name", 0, 1, Network.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_Lifecycle(), theGenericsPackage.getLifecycle(), null, "lifecycle", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_NodeType(), theLibraryPackage.getNodeType(), null, "nodeType", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_CreatedByRef(), theGenericsPackage.getPerson(), null, "createdByRef", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_NodeID(), theGenericsPackage.getName255(), "nodeID", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OriginalNodeTypeRef(), theLibraryPackage.getNodeType(), null, "originalNodeTypeRef", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_RoomRef(), theGeoPackage.getRoom(), null, "roomRef", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperator_Networks(), this.getNetwork(), null, "networks", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_Warehouses(), this.getWarehouse(), null, "warehouses", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_Services(), theServicesPackage.getService(), null, "services", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_ServiceUsers(), theServicesPackage.getServiceUser(), null, "serviceUsers", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperator_ResourceExpansions(), this.getResourceExpansion(), null, "resourceExpansions", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationship_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_NodeID1Ref(), this.getNode(), null, "nodeID1Ref", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_NodeID2Ref(), this.getNode(), null, "nodeID2Ref", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_ProtocolRef(), theProtocolsPackage.getProtocol(), null, "protocolRef", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceExpansionEClass, ResourceExpansion.class, "ResourceExpansion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceExpansion_NodeRefs(), this.getNode(), null, "nodeRefs", null, 0, -1, ResourceExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceExpansion_EquipmentRefs(), theLibraryPackage.getEquipment(), null, "equipmentRefs", null, 0, -1, ResourceExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceExpansion_FunctionRefs(), theLibraryPackage.getFunction(), null, "functionRefs", null, 0, -1, ResourceExpansion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceForecastEClass, ResourceForecast.class, "ResourceForecast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceForecast_Markers(), this.getMarker(), null, "markers", null, 0, -1, ResourceForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceMonitorEClass, ResourceMonitor.class, "ResourceMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceMonitor_Markers(), this.getMarker(), null, "markers", null, 0, -1, ResourceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceMonitor_NodeRef(), this.getNode(), null, "nodeRef", null, 0, 1, ResourceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResourceMonitor_ResourceRef(), theLibraryPackage.getNetXResource(), null, "resourceRef", null, 0, 1, ResourceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceMonitor_End(), theXMLTypePackage.getDateTime(), "end", null, 0, 1, ResourceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceMonitor_Start(), theXMLTypePackage.getDateTime(), "start", null, 0, 1, ResourceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(warehouseEClass, Warehouse.class, "Warehouse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWarehouse_Nodes(), this.getNode(), null, "nodes", null, 0, -1, Warehouse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWarehouse_Equipments(), theLibraryPackage.getEquipment(), null, "equipments", null, 0, -1, Warehouse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWarehouse_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, Warehouse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWarehouse_Name(), theGenericsPackage.getName255(), "name", "name", 0, 1, Warehouse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(markerKindEEnum, MarkerKind.class, "MarkerKind");
		addEEnumLiteral(markerKindEEnum, MarkerKind.VALUE);
		addEEnumLiteral(markerKindEEnum, MarkerKind.INTERNALEVENT);
		addEEnumLiteral(markerKindEEnum, MarkerKind.EXTERNALEVENT);
		addEEnumLiteral(markerKindEEnum, MarkerKind.ACTIONNEEDED);
		addEEnumLiteral(markerKindEEnum, MarkerKind.THRESHOLDREACHED);

		// Initialize data types
		initEDataType(markerKindObjectEDataType, MarkerKind.class, "MarkerKindObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL",
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL"
		   });																																																				
		addAnnotation
		  (nodeEClass, 
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
		  (equipmentRelationshipEClass, 
		   source, 
		   new String[] {
			 "name", "EquipmentRelationship",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getEquipmentRelationship_Equipment1Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Equipment1Ref"
		   });			
		addAnnotation
		  (getEquipmentRelationship_Equipment2Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Equipment2Ref"
		   });			
		addAnnotation
		  (functionRelationshipEClass, 
		   source, 
		   new String[] {
			 "name", "FunctionRelationship",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getFunctionRelationship_Function1Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Function1Ref"
		   });			
		addAnnotation
		  (getFunctionRelationship_Function2Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Function2Ref"
		   });			
		addAnnotation
		  (markerEClass, 
		   source, 
		   new String[] {
			 "name", "Marker",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getMarker_ComponentRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ComponentRef"
		   });			
		addAnnotation
		  (getMarker_ValueRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ValueRef"
		   });			
		addAnnotation
		  (getMarker_MarkerResourceRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MarkerResourceRef"
		   });			
		addAnnotation
		  (getMarker_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getMarker_Kind(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Kind"
		   });			
		addAnnotation
		  (markerKindEEnum, 
		   source, 
		   new String[] {
			 "name", "MarkerKind"
		   });		
		addAnnotation
		  (markerKindObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "MarkerKind:Object",
			 "baseType", "MarkerKind"
		   });			
		addAnnotation
		  (networkEClass, 
		   source, 
		   new String[] {
			 "name", "Network",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getNetwork_Diagrams(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Diagrams"
		   });			
		addAnnotation
		  (getNetwork_Nodes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Nodes"
		   });			
		addAnnotation
		  (getNetwork_Networks(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Networks"
		   });			
		addAnnotation
		  (getNetwork_FunctionRelationships(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FunctionRelationships"
		   });			
		addAnnotation
		  (getNetwork_EquipmentRelationships(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EquipmentRelationships"
		   });			
		addAnnotation
		  (getNetwork_MetricSources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricSources"
		   });			
		addAnnotation
		  (getNetwork_CreatedByRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "CreatedByRef"
		   });			
		addAnnotation
		  (getNetwork_CreatedDate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "CreatedDate"
		   });			
		addAnnotation
		  (getNetwork_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getNetwork_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });					
		addAnnotation
		  (nodeEClass, 
		   source, 
		   new String[] {
			 "name", "Node",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getNode_Lifecycle(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Lifecycle"
		   });			
		addAnnotation
		  (getNode_NodeType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeType"
		   });			
		addAnnotation
		  (getNode_CreatedByRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "CreatedByRef"
		   });			
		addAnnotation
		  (getNode_NodeID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "NodeID"
		   });			
		addAnnotation
		  (getNode_OriginalNodeTypeRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "OriginalNodeTypeRef"
		   });			
		addAnnotation
		  (getNode_RoomRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "RoomRef"
		   });			
		addAnnotation
		  (operatorEClass, 
		   source, 
		   new String[] {
			 "name", "Operator",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getOperator_Networks(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Networks"
		   });			
		addAnnotation
		  (getOperator_Warehouses(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Warehouses"
		   });			
		addAnnotation
		  (getOperator_Services(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Services"
		   });			
		addAnnotation
		  (getOperator_ServiceUsers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceUsers"
		   });			
		addAnnotation
		  (getOperator_ResourceExpansions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceExpansions"
		   });			
		addAnnotation
		  (relationshipEClass, 
		   source, 
		   new String[] {
			 "name", "Relationship",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getRelationship_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getRelationship_NodeID1Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "NodeID1Ref"
		   });			
		addAnnotation
		  (getRelationship_NodeID2Ref(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "NodeID2Ref"
		   });			
		addAnnotation
		  (getRelationship_ProtocolRef(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ProtocolRef"
		   });			
		addAnnotation
		  (resourceExpansionEClass, 
		   source, 
		   new String[] {
			 "name", "ResourceExpansion",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getResourceExpansion_NodeRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeRefs"
		   });			
		addAnnotation
		  (getResourceExpansion_EquipmentRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "EquipmentRefs"
		   });			
		addAnnotation
		  (getResourceExpansion_FunctionRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "FunctionRefs"
		   });			
		addAnnotation
		  (resourceForecastEClass, 
		   source, 
		   new String[] {
			 "name", "ResourceForecast",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getResourceForecast_Markers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Markers"
		   });			
		addAnnotation
		  (resourceMonitorEClass, 
		   source, 
		   new String[] {
			 "name", "ResourceMonitor",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getResourceMonitor_Markers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Markers"
		   });			
		addAnnotation
		  (getResourceMonitor_NodeRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "NodeRef"
		   });			
		addAnnotation
		  (getResourceMonitor_ResourceRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceRef"
		   });			
		addAnnotation
		  (getResourceMonitor_End(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "End"
		   });			
		addAnnotation
		  (getResourceMonitor_Start(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Start"
		   });			
		addAnnotation
		  (warehouseEClass, 
		   source, 
		   new String[] {
			 "name", "Warehouse",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getWarehouse_Nodes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Nodes"
		   });			
		addAnnotation
		  (getWarehouse_Equipments(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Equipments"
		   });			
		addAnnotation
		  (getWarehouse_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getWarehouse_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
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
		  (nodeEClass, 
		   source, 
		   new String[] {
			 "ValidNodeID", "\n\t\t\t\tnot self.nodeID.oclIsUndefined()\n\t\t\t"
		   });																																																																					
	}

} //OperatorsPackageImpl

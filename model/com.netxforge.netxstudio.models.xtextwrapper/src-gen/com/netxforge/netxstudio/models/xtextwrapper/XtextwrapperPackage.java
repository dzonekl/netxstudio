/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.models.xtextwrapper;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.netxforge.netxstudio.models.xtextwrapper.XtextwrapperFactory
 * @model kind="package"
 * @generated
 */
public interface XtextwrapperPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xtextwrapper";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/xtextwrapper";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xw";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtextwrapperPackage eINSTANCE = com.netxforge.netxstudio.models.xtextwrapper.impl.XtextwrapperPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.models.xtextwrapper.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.models.xtextwrapper.impl.ModelImpl
	 * @see com.netxforge.netxstudio.models.xtextwrapper.impl.XtextwrapperPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__SCRIPTS = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.models.xtextwrapper.impl.NetXScriptWrapperImpl <em>Net XScript Wrapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.models.xtextwrapper.impl.NetXScriptWrapperImpl
	 * @see com.netxforge.netxstudio.models.xtextwrapper.impl.XtextwrapperPackageImpl#getNetXScriptWrapper()
	 * @generated
	 */
	int NET_XSCRIPT_WRAPPER = 1;

	/**
	 * The feature id for the '<em><b>As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XSCRIPT_WRAPPER__AS_STRING = 0;

	/**
	 * The feature id for the '<em><b>Xblock</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XSCRIPT_WRAPPER__XBLOCK = 1;

	/**
	 * The number of structural features of the '<em>Net XScript Wrapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NET_XSCRIPT_WRAPPER_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.models.xtextwrapper.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see com.netxforge.netxstudio.models.xtextwrapper.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.models.xtextwrapper.Model#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.models.xtextwrapper.Model#getName()
	 * @see #getModel()
	 * @generated
	 */
	EAttribute getModel_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.models.xtextwrapper.Model#getScripts <em>Scripts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scripts</em>'.
	 * @see com.netxforge.netxstudio.models.xtextwrapper.Model#getScripts()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Scripts();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper <em>Net XScript Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Net XScript Wrapper</em>'.
	 * @see com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper
	 * @generated
	 */
	EClass getNetXScriptWrapper();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper#getAsString <em>As String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>As String</em>'.
	 * @see com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper#getAsString()
	 * @see #getNetXScriptWrapper()
	 * @generated
	 */
	EAttribute getNetXScriptWrapper_AsString();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper#getXblock <em>Xblock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Xblock</em>'.
	 * @see com.netxforge.netxstudio.models.xtextwrapper.NetXScriptWrapper#getXblock()
	 * @see #getNetXScriptWrapper()
	 * @generated
	 */
	EReference getNetXScriptWrapper_Xblock();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XtextwrapperFactory getXtextwrapperFactory();

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
		 * The meta object literal for the '{@link com.netxforge.netxstudio.models.xtextwrapper.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.models.xtextwrapper.impl.ModelImpl
		 * @see com.netxforge.netxstudio.models.xtextwrapper.impl.XtextwrapperPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

		/**
		 * The meta object literal for the '<em><b>Scripts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__SCRIPTS = eINSTANCE.getModel_Scripts();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.models.xtextwrapper.impl.NetXScriptWrapperImpl <em>Net XScript Wrapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.models.xtextwrapper.impl.NetXScriptWrapperImpl
		 * @see com.netxforge.netxstudio.models.xtextwrapper.impl.XtextwrapperPackageImpl#getNetXScriptWrapper()
		 * @generated
		 */
		EClass NET_XSCRIPT_WRAPPER = eINSTANCE.getNetXScriptWrapper();

		/**
		 * The meta object literal for the '<em><b>As String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NET_XSCRIPT_WRAPPER__AS_STRING = eINSTANCE.getNetXScriptWrapper_AsString();

		/**
		 * The meta object literal for the '<em><b>Xblock</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NET_XSCRIPT_WRAPPER__XBLOCK = eINSTANCE.getNetXScriptWrapper_Xblock();

	}

} //XtextwrapperPackage

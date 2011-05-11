/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.models.xtextwrapper.impl;

import com.netxforge.netxstudio.models.xtextwrapper.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextwrapperFactoryImpl extends EFactoryImpl implements XtextwrapperFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XtextwrapperFactory init() {
		try {
			XtextwrapperFactory theXtextwrapperFactory = (XtextwrapperFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.netxforge.com/xtextwrapper"); 
			if (theXtextwrapperFactory != null) {
				return theXtextwrapperFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XtextwrapperFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextwrapperFactoryImpl() {
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
			case XtextwrapperPackage.MODEL: return createModel();
			case XtextwrapperPackage.NET_XSCRIPT_WRAPPER: return createNetXScriptWrapper();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXScriptWrapper createNetXScriptWrapper() {
		NetXScriptWrapperImpl netXScriptWrapper = new NetXScriptWrapperImpl();
		return netXScriptWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextwrapperPackage getXtextwrapperPackage() {
		return (XtextwrapperPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XtextwrapperPackage getPackage() {
		return XtextwrapperPackage.eINSTANCE;
	}

} //XtextwrapperFactoryImpl

package com.netxforge.netxstudio.models.export.tests;
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */


import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>netxstudio</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class NetxstudioTests extends TestSuite {
	
	public static final String FIXTURE_PATH = "/Users/dzonekl/Documents/Spaces/netxstudio.gen4/com.netxforge.netxstudio.fixtures/";
	public static final String PLATFORM_FIXTURE_PATH = "com.netxforge.netxstudio.fixtures/";
	public static final String PLUGIN_FIXTURE_PATH = "platform:/plugin/com.netxforge.netxstudio.fixtures/";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new NetxstudioTests("netxstudio Tests");
		suite.addTestSuite(M2TTest.class);
		return suite;
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetxstudioTests(String name) {
		super(name);
	}

} //NetxstudioTests

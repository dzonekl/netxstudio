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
package com.netxforge.netxstudio.operators.tests;

import com.netxforge.netxstudio.generics.tests.BaseTest;

import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.Warehouse;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Warehouse</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class WarehouseTest extends BaseTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(WarehouseTest.class);
	}

	/**
	 * Constructs a new Warehouse test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WarehouseTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Warehouse test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Warehouse getFixture() {
		return (Warehouse)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OperatorsFactory.eINSTANCE.createWarehouse());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //WarehouseTest

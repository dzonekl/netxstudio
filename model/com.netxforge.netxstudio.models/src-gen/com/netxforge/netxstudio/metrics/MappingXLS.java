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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping XLS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points
 * 				for mapping an XLS file to the NetXStudio model.
 * 				The mapping
 * 				interprets the sheet index, the header row, the data row(s)
 * 				and the
 * 				types of data to be interpreted.
 * 
 * 				The types, are either a value or
 * 				identifier. (Each having it's own
 * 				specialized type).
 * 				Multiple
 * 				identifiers can be defined, the mapping will succeed if all
 * 				identifications succeed.
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MappingXLS#getSheetNumber <em>Sheet Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingXLS()
 * @model extendedMetaData="name='MappingXLS' kind='elementOnly'"
 * @generated
 */
public interface MappingXLS extends Mapping {
	/**
	 * Returns the value of the '<em><b>Sheet Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The SheetNumber attribute holds the index of the
	 * 							XLS sheet to be mapped from.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sheet Number</em>' attribute.
	 * @see #isSetSheetNumber()
	 * @see #unsetSheetNumber()
	 * @see #setSheetNumber(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMappingXLS_SheetNumber()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='SheetNumber'"
	 * @generated
	 */
	int getSheetNumber();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MappingXLS#getSheetNumber <em>Sheet Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sheet Number</em>' attribute.
	 * @see #isSetSheetNumber()
	 * @see #unsetSheetNumber()
	 * @see #getSheetNumber()
	 * @generated
	 */
	void setSheetNumber(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MappingXLS#getSheetNumber <em>Sheet Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSheetNumber()
	 * @see #getSheetNumber()
	 * @see #setSheetNumber(int)
	 * @generated
	 */
	void unsetSheetNumber();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MappingXLS#getSheetNumber <em>Sheet Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sheet Number</em>' attribute is set.
	 * @see #unsetSheetNumber()
	 * @see #getSheetNumber()
	 * @see #setSheetNumber(int)
	 * @generated
	 */
	boolean isSetSheetNumber();

} // MappingXLS

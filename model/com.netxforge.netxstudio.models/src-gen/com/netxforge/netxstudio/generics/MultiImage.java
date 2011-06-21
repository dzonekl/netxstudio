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
package com.netxforge.netxstudio.generics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing an image. The image can be
 * 				specified for various sizes from 16x16 upto 128x128.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.MultiImage#getObj16 <em>Obj16</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.MultiImage#getObj32 <em>Obj32</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.MultiImage#getObj48 <em>Obj48</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.MultiImage#getObj96 <em>Obj96</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.MultiImage#getObj128 <em>Obj128</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getMultiImage()
 * @model extendedMetaData="name='MultiImage' kind='elementOnly'"
 * @generated
 */
public interface MultiImage extends Base {
	/**
	 * Returns the value of the '<em><b>Obj16</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The obj16 attribute, refers to a 16x16 URI of
	 * 								type png or gif.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Obj16</em>' attribute.
	 * @see #setObj16(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getMultiImage_Obj16()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='element' name='obj16'"
	 * @generated
	 */
	String getObj16();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.MultiImage#getObj16 <em>Obj16</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj16</em>' attribute.
	 * @see #getObj16()
	 * @generated
	 */
	void setObj16(String value);

	/**
	 * Returns the value of the '<em><b>Obj32</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The obj32 attribute, refers to a 32x32 URI of
	 * 								type png or gif.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Obj32</em>' attribute.
	 * @see #setObj32(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getMultiImage_Obj32()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='element' name='obj32'"
	 * @generated
	 */
	String getObj32();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.MultiImage#getObj32 <em>Obj32</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj32</em>' attribute.
	 * @see #getObj32()
	 * @generated
	 */
	void setObj32(String value);

	/**
	 * Returns the value of the '<em><b>Obj48</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The obj48 attribute, refers to a 48x48 URI of
	 * 								type png or gif.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Obj48</em>' attribute.
	 * @see #setObj48(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getMultiImage_Obj48()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='element' name='obj48'"
	 * @generated
	 */
	String getObj48();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.MultiImage#getObj48 <em>Obj48</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj48</em>' attribute.
	 * @see #getObj48()
	 * @generated
	 */
	void setObj48(String value);

	/**
	 * Returns the value of the '<em><b>Obj96</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The obj96 attribute, refers to a 96x96 URI of
	 * 								type png or gif.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Obj96</em>' attribute.
	 * @see #setObj96(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getMultiImage_Obj96()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='element' name='obj96'"
	 * @generated
	 */
	String getObj96();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.MultiImage#getObj96 <em>Obj96</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj96</em>' attribute.
	 * @see #getObj96()
	 * @generated
	 */
	void setObj96(String value);

	/**
	 * Returns the value of the '<em><b>Obj128</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The obj128 attribute, refers to a 128x128 URI
	 * 								of
	 * 								type png or gif.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Obj128</em>' attribute.
	 * @see #setObj128(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getMultiImage_Obj128()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='element' name='obj128'"
	 * @generated
	 */
	String getObj128();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.MultiImage#getObj128 <em>Obj128</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj128</em>' attribute.
	 * @see #getObj128()
	 * @generated
	 */
	void setObj128(String value);

} // MultiImage

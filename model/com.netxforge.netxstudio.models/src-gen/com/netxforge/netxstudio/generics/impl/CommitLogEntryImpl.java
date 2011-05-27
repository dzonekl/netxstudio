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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.generics.ActionType;
import com.netxforge.netxstudio.generics.CommitLogEntry;
import com.netxforge.netxstudio.generics.GenericsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Commit Log Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CommitLogEntryImpl#getAction <em>Action</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CommitLogEntryImpl#getChange <em>Change</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CommitLogEntryImpl#getObjectId <em>Object Id</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CommitLogEntryImpl#getTimeStamp <em>Time Stamp</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CommitLogEntryImpl#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommitLogEntryImpl extends CDOObjectImpl implements CommitLogEntry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommitLogEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericsPackage.Literals.COMMIT_LOG_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionType getAction() {
		return (ActionType)eGet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__ACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(ActionType newAction) {
		eSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__ACTION, newAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAction() {
		eUnset(GenericsPackage.Literals.COMMIT_LOG_ENTRY__ACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAction() {
		return eIsSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__ACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getChange() {
		return (String)eGet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__CHANGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChange(String newChange) {
		eSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__CHANGE, newChange);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObjectId() {
		return (String)eGet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__OBJECT_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectId(String newObjectId) {
		eSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__OBJECT_ID, newObjectId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getTimeStamp() {
		return (XMLGregorianCalendar)eGet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__TIME_STAMP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeStamp(XMLGregorianCalendar newTimeStamp) {
		eSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__TIME_STAMP, newTimeStamp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUser() {
		return (String)eGet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUser(String newUser) {
		eSet(GenericsPackage.Literals.COMMIT_LOG_ENTRY__USER, newUser);
	}

} //CommitLogEntryImpl

/*******************************************************************************
 * Copyright (c) May 3, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.test;

import java.util.List;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.netxforge.netxstudio.data.IDataProvider;

/**
 * A test provider which creates dummy objects.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class TestDataProvider implements IDataProvider {

	public EObject getObject() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataProvider#getResource(org.eclipse.emf
	 * .ecore.resource.ResourceSet, int)
	 */
	public Resource getResource(ResourceSet set, int feature) {
		throw new java.lang.UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataProvider#openSession(java.lang.String,
	 * java.lang.String)
	 */
	public void openSession(String uid, String passwd) {
		throw new java.lang.UnsupportedOperationException();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataProvider#getSessionUserID()
	 */
	public String getSessionUserID() {
		throw new java.lang.UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataProvider#getResource(int)
	 */
	public Resource getResource(int feature) {
		throw new java.lang.UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataProvider#getSession()
	 */
	public CDOSession getSession() {
		throw new java.lang.UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataProvider#closeSession()
	 */
	public void closeSession() {
		throw new java.lang.UnsupportedOperationException();
	}

	public CDOTransaction getTransaction() {
		throw new java.lang.UnsupportedOperationException();
	}

	public void commitTransactionThenClose() {
		throw new java.lang.UnsupportedOperationException();
	}

	public void rollbackTransaction() {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getCommitInfoResource(String userID) {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(EStructuralFeature feature) {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(ResourceSet set, EClass clazz) {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(EClass clazz) {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(String path) {
		throw new java.lang.UnsupportedOperationException();
	}

	public CDOSession openSession() {
		throw new java.lang.UnsupportedOperationException();
	}

	public void setDoGetResourceFromOwnTransaction(
			boolean createResourceInSeparateTransaction) {
		throw new java.lang.UnsupportedOperationException();
	}

	public void openSession(String username, String password, String server) {
		throw new java.lang.UnsupportedOperationException();
	}

	public String getServer() {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(URI uri) {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(ResourceSet set, URI uri) {
		throw new java.lang.UnsupportedOperationException();
	}

	public List<Resource> getResources(ResourceSet set, String resourcePath) {
		throw new java.lang.UnsupportedOperationException();
	}

	public void openSession(String username, String password, String server,
			boolean reset) {
		throw new java.lang.UnsupportedOperationException();
	}

	public List<Resource> getResources(String resourcePath) {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(ResourceSet set, String resourcePath) {
		throw new java.lang.UnsupportedOperationException();
	}

	public boolean hasResource(String resourcePath) {
		throw new java.lang.UnsupportedOperationException();
	}

	public boolean hasResource(URI resourceURI) {
		throw new java.lang.UnsupportedOperationException();
	}

	public CDOView getView() {
		throw new java.lang.UnsupportedOperationException();
	}

	public void closeView() {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(CDOView view, EClass clazz) {
		throw new java.lang.UnsupportedOperationException();
	}

	public Resource getResource(CDOView view, String res) {
		throw new java.lang.UnsupportedOperationException();
	}

	public void commitTransaction() {
		throw new java.lang.UnsupportedOperationException();
	}

}

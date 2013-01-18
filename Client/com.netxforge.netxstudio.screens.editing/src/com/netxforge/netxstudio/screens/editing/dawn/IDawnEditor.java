/*******************************************************************************
 * Copyright (c) 2004 - 2011 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Martin Fluegge - initial API and implementation
 ******************************************************************************/
package com.netxforge.netxstudio.screens.editing.dawn;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Martin Fluegge
 */
public interface IDawnEditor {

	// CB Not needed for us.
	// public String getContributorID();

	public CDOView getView();

	public void setDirty();

	/**
	 * @since 1.0
	 */
	public IDawnEditorSupport getDawnEditorSupport();
	
	
	/**
	 * Allow the implememtors to deal with stale references.  
	 * 
	 * @param source
	 * @param feature
	 * @param index
	 * @param target
	 */
	public void handleStale(EObject source, EStructuralFeature feature,
			int index, CDOID target);
}

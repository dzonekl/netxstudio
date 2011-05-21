/**
 * Copyright (c) 2004 - 2011 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Martin Fluegge - initial API and implementation
 */
package com.netxforge.netxstudio.screens.editing.dawn;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOAdapterPolicy;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * @author Martin Fluegge
 * @since 1.0
 */
public class DawnEMFEditorSupport extends DawnAbstractEditorSupport {
	public DawnEMFEditorSupport(IDawnEditor editor) {
		super(editor);
	}

	public void close() {
		CDOView view = getView();
		if (view != null && !view.isClosed()) {
			view.close();
		}
	}

	public void registerListeners() {
		BasicDawnListener listener = new DawnEMFHandler(getEditor());
		CDOView view = getView();
		view.addListener(listener);

		if (view instanceof CDOTransaction) {
			CDOTransaction transaction = (CDOTransaction) view;
			transaction.options().addChangeSubscriptionPolicy(
					CDOAdapterPolicy.CDO);
		}
	}

	@Override
	public void rollback() {
		super.rollback();

		Viewer viewer = ((IViewerProvider) getEditor()).getViewer();
		if (viewer != null) {
			viewer.refresh();
		}
	}
}

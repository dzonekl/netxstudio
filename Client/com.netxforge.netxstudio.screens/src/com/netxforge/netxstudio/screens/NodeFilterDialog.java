/*******************************************************************************
 * Copyright (c) Jun 24, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens;

import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class NodeFilterDialog extends FilteredItemsSelectionDialog {
	private final Resource resource;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resource
	 *            the model resource
	 */
	public NodeFilterDialog(Shell shell, Resource resource) {
		super(shell);
		super.setTitle("Select a Network Element");
		this.resource = resource;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return NodeFilterDialog.this.getText((Node) element);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return NodeFilterDialog.this.getText((Node) element);
			}
		});
	}

	private String getText(Node p) {
		return p.getNodeID();
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<Node>() {

			public int compare(Node o1, Node o2) {
				return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		Node p = (Node) item;
		return getText(p);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = ScreensActivator.getDefault()
				.getDialogSettings().getSection("Roomdialog");

		if (settings == null) {
			settings = ScreensActivator.getDefault().getDialogSettings()
					.addNewSection("Roomdialog");
		}
		return settings;
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {
		
		this.populateContent(contentProvider, itemsFilter, resource.getContents());
	}

	private void populateContent(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, EList<?> list) {
		for (Object o : list) {
			EObject eo = (EObject) o;
			if (eo.eClass().equals(OperatorsPackage.Literals.OPERATOR)) {
				Operator op = (Operator) eo;
				populateContent( contentProvider, itemsFilter, op.getNetworks());
			}
			if (eo.eClass().equals(OperatorsPackage.Literals.NETWORK)) {
				Network net = (Network) eo;
				populateContent( contentProvider, itemsFilter, net.getNodes());
				populateContent( contentProvider, itemsFilter, net.getNetworks());
			}
			if (eo.eClass().equals(OperatorsPackage.Literals.NODE)) {
				contentProvider.add(eo, itemsFilter);
			}
		}

	}
	
	@Override
	protected ItemsFilter createFilter() {
		return new ItemsFilter() {

			@Override
			public boolean isConsistentItem(Object item) {
				return true;
			}

			@Override
			public boolean matchItem(Object item) {
				Node p = (Node) item;
				return matches(p.getNodeID());
			}
		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

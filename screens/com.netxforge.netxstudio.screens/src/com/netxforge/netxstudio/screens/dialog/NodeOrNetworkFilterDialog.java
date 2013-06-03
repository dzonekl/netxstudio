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
package com.netxforge.netxstudio.screens.dialog;

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

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class NodeOrNetworkFilterDialog extends HierarchyFilteredItemsSelectionDialog {
	private final Resource resource;
	private ModelUtils modelUtils;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resource
	 *            the model resource
	 */
	public NodeOrNetworkFilterDialog(Shell shell, Resource resource,
			ModelUtils modelUtils) {
		
		super(shell, true);
		super.setTitle("Select a Network Element or Network");
		
		this.resource = resource;
		this.modelUtils = modelUtils;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return NodeOrNetworkFilterDialog.this.getText(element);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return NodeOrNetworkFilterDialog.this.getText(element);
			}
		});
	}

	private String getText(Object e) {
		
		if( e instanceof String){
			return (String) e;
		}
		
		String indent = "";
		int depth = modelUtils.depthToResource(0, (EObject) e);
		for (int i = 0; i < depth; i++) {
			indent += "   ";
		}

		if (e instanceof Node) {
			return indent + "NE: " + ((Node) e).getNodeID();
		}
		if (e instanceof Network) {
			return indent + "Network: " + ((Network) e).getName();
		}
		return "invalid object";
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<Object>() {
			public int compare(Object o1, Object o2) {

				// Do not sort by name, but by hierarchy
				return 1;
				// if(o1 instanceof Network && o2 instanceof Node){
				// return 1;
				// }
				// return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		return getText(item);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = ScreensActivator.getDefault()
				.getDialogSettings().getSection("NodeOrNetworkDialog");

		if (settings == null) {
			settings = ScreensActivator.getDefault().getDialogSettings()
					.addNewSection("NodeOrNetworkDialog");
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
//				contentProvider.add(eo, itemsFilter);
				Operator op = (Operator) eo;
				populateContent( contentProvider, itemsFilter, op.getNetworks());
			}
			if (eo.eClass().equals(OperatorsPackage.Literals.NETWORK)) {
				contentProvider.add(eo, itemsFilter);
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

				if (item instanceof Node) {
					Node p = (Node) item;
					return matches(p.getNodeID());
				}
				if (item instanceof Network) {
					Network p = (Network) item;
					return matches(p.getName());
				}
				return false;

			}
		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

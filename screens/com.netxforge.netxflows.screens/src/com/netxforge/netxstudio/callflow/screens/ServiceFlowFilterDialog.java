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
package com.netxforge.netxstudio.callflow.screens;

import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.netxforge.netxstudio.callflow.screens.internal.CallFlowsActivator;
import com.netxforge.netxstudio.services.ServiceFlow;

public class ServiceFlowFilterDialog extends FilteredItemsSelectionDialog {
	private final Resource resource;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resource
	 *            the model resource
	 */
	public ServiceFlowFilterDialog(Shell shell, Resource resource) {
		super(shell, true);
		setTitle("Select an existing Service Flow");
		this.resource = resource;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return ServiceFlowFilterDialog.this.getText(

				(ServiceFlow) element

				);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}else if (element instanceof String){
					return (String) element;
				}
				return ServiceFlowFilterDialog.this
						.getText((ServiceFlow) element);
			}
		});
	}

	private String getText(ServiceFlow p) {
		return p.getName();
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<ServiceFlow>() {

			public int compare(ServiceFlow o1, ServiceFlow o2) {
				return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		ServiceFlow p = (ServiceFlow) item;
		return getText(p);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = CallFlowsActivator.getDefault()
				.getDialogSettings().getSection("ServiceFlowdialog");

		if (settings == null) {
			settings = CallFlowsActivator.getDefault().getDialogSettings()
					.addNewSection("ServiceFlowdialog");
		}
		return settings;
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {

		for (EObject p : resource.getContents()) {
			if (progressMonitor.isCanceled()) {
				return;
			}

			contentProvider.add(p, itemsFilter);
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
				ServiceFlow p = (ServiceFlow) item;
				return matches(p.getName());
			}

		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

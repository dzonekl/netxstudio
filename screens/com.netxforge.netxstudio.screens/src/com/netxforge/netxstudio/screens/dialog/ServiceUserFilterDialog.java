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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.services.ServiceUser;

public class ServiceUserFilterDialog extends FilteredItemsSelectionDialog {
	private final Resource resource;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resource
	 *            the model resource
	 */
	public ServiceUserFilterDialog(Shell shell, Resource resource) {
		super(shell);
		setTitle("Select an existing Service User");
		this.resource = resource;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return ServiceUserFilterDialog.this.getText(

				(ServiceUser) element

				);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return ServiceUserFilterDialog.this.getText((ServiceUser) element);
			}
		});
	}

	private String getText(ServiceUser p) {
		return p.getName() ;
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<ServiceUser>() {

			public int compare(ServiceUser o1, ServiceUser o2) {
				return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		ServiceUser p = (ServiceUser) item;
		return getText(p);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = ScreensActivator.getDefault()
				.getDialogSettings().getSection("ServiceUserdialog");

		if (settings == null) {
			settings = ScreensActivator.getDefault().getDialogSettings()
					.addNewSection("ServiceUserdialog");
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
				ServiceUser p = (ServiceUser) item;
				return matches(p.getName());
			}

		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

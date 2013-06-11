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

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class MetricFilterDialog extends FilteredItemsSelectionDialog {
	private final Resource resource;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resource
	 *            the model resource
	 */
	public MetricFilterDialog(Shell shell, Resource resource) {
		super(shell, true);
		super.setTitle("Select an existing Metric");

		this.resource = resource;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return MetricFilterDialog.this.getText(

				(Metric) element

				);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				} else if (element instanceof Metric) {
					return MetricFilterDialog.this.getText((Metric) element);
				}else if( element instanceof String){
					return (String) element;
				}
				return "";
			}
		});
	}

	private String getText(Metric p) {
		StringBuffer buf = new StringBuffer();
		buf.append(p.eIsSet(MetricsPackage.Literals.METRIC__NAME) ? p.getName()
				: "?");
		buf.append(" - ");
		buf.append(p.eIsSet(MetricsPackage.Literals.METRIC__DESCRIPTION) ? p
				.getDescription() : "?");
		return buf.toString();
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<Metric>() {

			public int compare(Metric o1, Metric o2) {
				return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		Metric p = (Metric) item;
		return getText(p);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = ScreensActivator.getInstance()
				.getDialogSettings().getSection("Metricdialog");

		if (settings == null) {
			settings = ScreensActivator.getInstance().getDialogSettings()
					.addNewSection("Metricdialog");
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
				Metric p = (Metric) item;
				return matches(p.getName() + p.getDescription());
			}

		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

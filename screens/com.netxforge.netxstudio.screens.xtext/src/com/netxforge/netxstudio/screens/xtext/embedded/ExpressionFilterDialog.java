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
package com.netxforge.netxstudio.screens.xtext.embedded;

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

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.screens.xtext.internal.Activator;

public class ExpressionFilterDialog extends FilteredItemsSelectionDialog {
	private final Resource resource;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resource
	 *            the model resource
	 */
	public ExpressionFilterDialog(Shell shell, Resource resource) {
		super(shell);
		this.setTitle("Select an existing Expression");
		this.resource = resource;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return ExpressionFilterDialog.this.getText(

				(Expression) element

				);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return ExpressionFilterDialog.this.getText((Expression) element);
			}
		});
	}

	private String getText(Expression p) {
		return p.getName() ;
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<Expression>() {

			public int compare(Expression o1, Expression o2) {
				return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		Expression p = (Expression) item;
		return getText(p);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault()
				.getDialogSettings().getSection("Expressiondialog");

		if (settings == null) {
			settings = Activator.getDefault().getDialogSettings()
					.addNewSection("Expressiondialog");
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
				Expression p = (Expression) item;
				return matches(p.getName());
			}

		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

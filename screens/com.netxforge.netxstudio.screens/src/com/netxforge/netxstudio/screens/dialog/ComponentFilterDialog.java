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

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class ComponentFilterDialog extends FilteredItemsSelectionDialog {

	private final Object scope;

	private ModelUtils modelUtils;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param scope
	 *            the model resource
	 */
	public ComponentFilterDialog(Shell shell, Object scope,
			ModelUtils modelUtils) {
		super(shell);
		super.setTitle("Select a Component");
		this.scope = scope;
		this.modelUtils = modelUtils;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return ComponentFilterDialog.this
						.getParentText((Component) element)
						+ " -- "
						+ ComponentFilterDialog.this
								.getText((Component) element);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return ComponentFilterDialog.this
						.getParentText((Component) element);
			}
		});
	}

	private String getText(Component component) {
		return modelUtils.componentName(component);
	}

	private String getParentText(Component p) {
		Node n;
		if ((n = this.resolveParentNode(p)) != null) {
			return n.getNodeID();
		}
		return "Unresolved Node!";
	}

	private Node resolveParentNode(EObject current) {
		if (current != null && current.eContainer() != null) {
			if (current.eContainer() instanceof Node) {
				return (Node) current.eContainer();
			} else {
				return resolveParentNode(current.eContainer());
			}
		} else {
			return null;
		}
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {

		return new Comparator<Component>() {
			public int compare(Component o1, Component o2) {
				return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		return getText((Component) item);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = ScreensActivator.getInstance()
				.getDialogSettings().getSection("Functiondialog");

		if (settings == null) {
			settings = ScreensActivator.getInstance().getDialogSettings()
					.addNewSection("Functiondialog");
		}
		return settings;
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {

		org.eclipse.emf.common.util.TreeIterator<EObject> ti = null;
		if (scope instanceof Resource) {
			ti = ((Resource) scope).getAllContents();
		} else {
			if (scope instanceof EObject) {
				ti = ((EObject) scope).eAllContents();
			}
		}
		if (ti != null) {
			while (ti.hasNext()) {
				EObject p = ti.next();
				if (p instanceof Component) {
					contentProvider.add(p, itemsFilter);
				}
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
				return matches(modelUtils.componentName((Component) item));
			}
		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

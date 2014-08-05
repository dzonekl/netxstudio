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
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class PersonFilterDialog extends FilteredItemsSelectionDialog {
	private final Netxstudio resource;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resource
	 *            the model resource
	 */
	public PersonFilterDialog(Shell shell, Netxstudio resource) {
		super(shell);
		this.resource = resource;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return PersonFilterDialog.this.getText(

				(Person) element

				);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return PersonFilterDialog.this.getText((Person) element);
			}
		});
	}

	private String getText(Person p) {
		return p.getLastName() + " " + p.getFirstName();
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<Person>() {

			public int compare(Person o1, Person o2) {
				return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		Person p = (Person) item;
		return getText(p);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = ScreensActivator.getInstance()
				.getDialogSettings().getSection("committerdialog");

		if (settings == null) {
			settings = ScreensActivator.getInstance().getDialogSettings()
					.addNewSection("committerdialog");
		}
		return settings;
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {
		for (Person p : resource.getUsers()) {
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
				Person p = (Person) item;
				return matches(p.getLastName() + " " + p.getFirstName());
			}

		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

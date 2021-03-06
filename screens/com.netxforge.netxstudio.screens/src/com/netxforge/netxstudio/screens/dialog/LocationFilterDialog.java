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

import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.Location;
import com.netxforge.netxstudio.geo.Room;
import com.netxforge.netxstudio.geo.Site;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class LocationFilterDialog extends FilteredItemsSelectionDialog {
	private final Resource resource;

	/**
	 * Create a new dialog
	 * 
	 * @param shell
	 *            the parent shell
	 * @param resource
	 *            the model resource
	 */
	public LocationFilterDialog(Shell shell, Resource resource) {
		super(shell);
		this.setTitle("Select a location (Room/Site/Country)");
		this.resource = resource;

		setListLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return LocationFilterDialog.this.getText((Location) element);
			}
		});

		setDetailsLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element == null) {
					return "";
				}
				return LocationFilterDialog.this.getText((Location) element);
			}
		});
	}

	private String getText(Location p) {
		
		StringBuilder sb = new StringBuilder();
		if(p instanceof Country){
			
			sb.append("Country: " + p.getName());
		}else if( p instanceof Site){
			if(p.eContainer() instanceof Country){
				Country c = (Country) p.eContainer();
				sb.append("Country: " + c.getName());
			}
			sb.append(" --> Site: " + p.getName());
		}else if( p instanceof Room){
			if(p.eContainer() instanceof Site){
				Site s = (Site) p.eContainer();
				if(s.eContainer() instanceof Country){
					Country c = (Country) s.eContainer();
					sb.append("Country: " + c.getName());
				}
				sb.append(" --> Site: " + s.getName());
			}
			sb.append(" --> Room: " + p.getName());
		}
		
		return sb.toString();
	}

	@Override
	protected IStatus validateItem(Object item) {
		return Status.OK_STATUS;
	}

	@Override
	protected Comparator<?> getItemsComparator() {
		return new Comparator<Location>() {

			public int compare(Location o1, Location o2) {
				return getText(o1).compareTo(getText(o2));
			}
		};
	}

	@Override
	public String getElementName(Object item) {
		Location p = (Location) item;
		return getText(p);
	}

	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = ScreensActivator.getInstance()
				.getDialogSettings().getSection("Locationdialog");

		if (settings == null) {
			settings = ScreensActivator.getInstance().getDialogSettings()
					.addNewSection("Locationdialog");
		}
		return settings;
	}

	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider,
			ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
			throws CoreException {
		
		
		org.eclipse.emf.common.util.TreeIterator<EObject> ti = resource.getAllContents();
		while(ti.hasNext()){
			EObject p = ti.next();
			if(p instanceof Location){
				contentProvider.add(p, itemsFilter);	
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
				Location p = (Location) item;
				return matches(p.getName());
			}
		};
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		return null;
	}
}

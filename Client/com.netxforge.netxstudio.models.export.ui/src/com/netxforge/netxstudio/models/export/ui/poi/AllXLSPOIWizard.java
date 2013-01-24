/*******************************************************************************
 * Copyright (c) 18 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.models.export.ui.poi;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.models.export.AbstractExportFilter;
import com.netxforge.netxstudio.models.export.IExportFilter;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * @author Christophe Bouhier
 */
public class AllXLSPOIWizard extends AbstractExportPOIRevengeWizard {

	@SuppressWarnings("unused")
	private IStructuredSelection selection;

	EPackage[] getEPackages() {
		return new EPackage[] {NetxstudioPackage.eINSTANCE, ServicesPackage.eINSTANCE,
				MetricsPackage.eINSTANCE, LibraryPackage.eINSTANCE,
				OperatorsPackage.eINSTANCE, GenericsPackage.eINSTANCE,
				SchedulingPackage.eINSTANCE, GeoPackage.eINSTANCE};
	}


	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("Export all Data to Excel format");
		setNeedsProgressMonitor(true);
		setBaseFileName("ExportAll");
	}

	@Override
	IExportFilter getExportFilter() {
		return new AbstractExportFilter.VolatileFilter();
	}
}

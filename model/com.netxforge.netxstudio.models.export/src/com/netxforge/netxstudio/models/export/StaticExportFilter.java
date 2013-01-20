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
package com.netxforge.netxstudio.models.export;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * An export filter, which gets rid of all volatile data, all super classes,
 * which would never have data, and all future purpose model data.
 * 
 * @author Christophe Bouhier
 * 
 */
public class StaticExportFilter extends AbstractExportFilter {
	
	public StaticExportFilter() {
		configure();
	}

	public void configure() {
		super.configure(); // should call to add, all non-relevant stuff to the filter. 
		{
			List<EClass> filteredClasses = filteredNonMasterClasses.get(MetricsPackage.eINSTANCE); 
			filteredClasses.add(MetricsPackage.Literals.METRIC_VALUE_RANGE);
			filteredNonMasterClasses.put(MetricsPackage.eINSTANCE,
					filteredClasses);
		}
		{
			List<EClass> filteredClasses = filteredNonMasterClasses.get(LibraryPackage.eINSTANCE);
			filteredClasses.add(LibraryPackage.Literals.NET_XRESOURCE);
			filteredNonMasterClasses.put(LibraryPackage.eINSTANCE,
					filteredClasses);
		}
		{
			List<EClass> filteredClasses = filteredNonMasterClasses.get(OperatorsPackage.eINSTANCE);;
			filteredClasses.add(OperatorsPackage.Literals.RESOURCE_MONITOR);
			filteredClasses.add(OperatorsPackage.Literals.TOLERANCE_MARKER);
			
			filteredNonMasterClasses.put(OperatorsPackage.eINSTANCE,
					filteredClasses);
		}

		{
			List<EClass> filteredClasses = filteredNonMasterClasses.get(ServicesPackage.eINSTANCE);;
			filteredClasses.add(ServicesPackage.Literals.SERVICE_MONITOR);
			filteredClasses.add(ServicesPackage.Literals.DERIVED_RESOURCE);

			filteredNonMasterClasses.put(ServicesPackage.eINSTANCE,
					filteredClasses);
		}

		{
			List<EClass> filteredClasses = filteredNonMasterClasses.get(GenericsPackage.eINSTANCE);;
			// filter, as used by MappingStats (Volatile) and ResourceMonitor (Dynamic).
			filteredClasses.add(GenericsPackage.Literals.VALUE);
			filteredClasses.add(GenericsPackage.Literals.DATE_TIME_RANGE);
			filteredNonMasterClasses.put(GenericsPackage.eINSTANCE,
					filteredClasses);
		}

		{
			List<EStructuralFeature> filteredFeatures = filteredNonMasterFeatures.get(GenericsPackage.Literals.BASE);
			filteredFeatures.add(GenericsPackage.Literals.BASE__DELETED);
			filteredNonMasterFeatures.put(GenericsPackage.Literals.BASE,
					filteredFeatures);
		}
		

	}

}

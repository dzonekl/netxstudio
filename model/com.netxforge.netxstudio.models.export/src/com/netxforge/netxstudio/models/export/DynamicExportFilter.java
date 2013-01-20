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

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * An export filter, which gets rid of all volatile data, all super classes,
 * which would never have data, and all future purpose model data.
 * 
 * @author Christophe Bouhier
 * 
 */
public class DynamicExportFilter extends AbstractExportFilter {

	public DynamicExportFilter() {
		configure();

	}

	public void configure() {
		super.configure(); // should call to add, all non-relevant stuff to the
							// filter.
		{ // METRICS_PACKAGE
			final List<EClass> filteredClasses = filteredNonMasterClasses
					.get(MetricsPackage.eINSTANCE);

			// Filter all metric info.
			filteredClasses.add(MetricsPackage.Literals.METRIC);
			filteredClasses.add(MetricsPackage.Literals.METRIC_SOURCE);
			
			// Filter metric retention rules. 
			filteredClasses.add(MetricsPackage.Literals.METRIC_RETENTION_RULE);
			filteredClasses.add(MetricsPackage.Literals.METRIC_RETENTION_RULES);
			
			// Filter all mapping info.
			filteredClasses.add(MetricsPackage.Literals.MAPPING_CSV);
			filteredClasses.add(MetricsPackage.Literals.MAPPING_RDBMS);
			filteredClasses.add(MetricsPackage.Literals.MAPPING_XLS);
			filteredClasses.add(MetricsPackage.Literals.MAPPING_COLUMN);
			filteredClasses.add(MetricsPackage.Literals.IDENTIFIER_DATA_KIND);
			filteredClasses.add(MetricsPackage.Literals.VALUE_DATA_KIND);

			filteredNonMasterClasses.put(MetricsPackage.eINSTANCE,
					filteredClasses);
		}
		{ // LIBRARY_PACKAGE
			final List<EClass> filteredClasses = filteredNonMasterClasses
					.get(LibraryPackage.eINSTANCE);

			// Filter all library info.
			filteredClasses.add(LibraryPackage.Literals.EQUIPMENT);
			filteredClasses.add(LibraryPackage.Literals.FUNCTION);
			filteredClasses.add(LibraryPackage.Literals.EXPRESSION);
			filteredClasses.add(LibraryPackage.Literals.NODE_TYPE);
			filteredClasses.add(LibraryPackage.Literals.PARAMETER);
			filteredClasses.add(LibraryPackage.Literals.TOLERANCE);
			filteredClasses.add(LibraryPackage.Literals.UNIT);
			filteredClasses.add(LibraryPackage.Literals.VENDOR);

			filteredNonMasterClasses.put(LibraryPackage.eINSTANCE,
					filteredClasses);
		}
		{ // OPERATORS_PACKAGE
			final List<EClass> filteredClasses = filteredNonMasterClasses
					.get(OperatorsPackage.eINSTANCE);

			// Filter all design info.
			filteredClasses
					.add(OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP);
			filteredClasses
					.add(OperatorsPackage.Literals.FUNCTION_RELATIONSHIP);
//			filteredClasses.add(OperatorsPackage.Literals.OPERATOR); NEED OPERATOR, FOR RESOURCE MONITORS. 
			filteredClasses.add(OperatorsPackage.Literals.NETWORK);
			filteredClasses.add(OperatorsPackage.Literals.NODE);
			filteredClasses.add(OperatorsPackage.Literals.WAREHOUSE);

			filteredNonMasterClasses.put(OperatorsPackage.eINSTANCE,
					filteredClasses);
		}

		{ // SERVICES_PACKAGE
			final List<EClass> filteredClasses = filteredNonMasterClasses
					.get(ServicesPackage.eINSTANCE);

			filteredClasses.add(ServicesPackage.Literals.DISTRIBUTION_ENTRY);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_DISTRIBUTION);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_PROFILE);
			filteredClasses.add(ServicesPackage.Literals.RFS_SERVICE);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_USER);

			filteredNonMasterClasses.put(ServicesPackage.eINSTANCE,
					filteredClasses);
		}

		{ // GENERICS_PACKAGE

			final List<EClass> filteredClasses = filteredNonMasterClasses
					.get(GenericsPackage.eINSTANCE);

			filteredClasses.add(GenericsPackage.Literals.PERSON);
			filteredClasses.add(GenericsPackage.Literals.ROLE);
			filteredClasses.add(GenericsPackage.Literals.LIFECYCLE); // STATIC
			filteredClasses.add(GenericsPackage.Literals.EXPANSION_DURATION_SETTING);
			filteredClasses.add(GenericsPackage.Literals.EXPANSION_DURATION_VALUE);
			
			filteredNonMasterClasses.put(GenericsPackage.eINSTANCE,
					filteredClasses);
		}

		// SCHEDULING_PACKAGE
		{

			final List<EClass> filteredClasses = filteredNonMasterClasses
					.get(SchedulingPackage.eINSTANCE);

			filteredClasses.add(SchedulingPackage.Literals.METRIC_SOURCE_JOB);
			filteredClasses.add(SchedulingPackage.Literals.NODE_REPORTER_JOB);
			filteredClasses
					.add(SchedulingPackage.Literals.NODE_TYPE_REPORTER_JOB);
			filteredClasses
					.add(SchedulingPackage.Literals.OPERATOR_REPORTER_JOB);
			filteredClasses.add(SchedulingPackage.Literals.RETENTION_JOB);
			filteredClasses
					.add(SchedulingPackage.Literals.RFS_SERVICE_MONITORING_JOB);
			filteredClasses
					.add(SchedulingPackage.Literals.RFS_SERVICE_REPORTER_JOB);

			filteredNonMasterClasses.put(SchedulingPackage.eINSTANCE,
					filteredClasses);
		}

		// GEO_PACKAGE
		{

			final List<EClass> filteredClasses = filteredNonMasterClasses
					.get(GeoPackage.eINSTANCE);

			filteredClasses.add(GeoPackage.Literals.COUNTRY);
			filteredClasses.add(GeoPackage.Literals.ROOM);
			filteredClasses.add(GeoPackage.Literals.SITE);

			filteredNonMasterClasses.put(GeoPackage.eINSTANCE, filteredClasses);
		}

		// NETXSTUDIO_PACKAGE.
		{
			final List<EClass> filteredClasses = filteredNonMasterClasses
					.get(NetxstudioPackage.eINSTANCE);

			filteredClasses.add(NetxstudioPackage.Literals.SERVER_SETTINGS); // UN-USED.
			filteredNonMasterClasses.put(NetxstudioPackage.eINSTANCE,
					filteredClasses);
		}

		// GENERICS_FEATURES
		{
			// Add unwanted features here. 
			
		}
	}
}

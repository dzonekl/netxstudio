package com.netxforge.netxstudio.models.export;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Lists;
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
 * @author Christophe
 * 
 */
public class DynamicExportFilter extends AbstractExportFilter {
	
	public DynamicExportFilter() {
		configure();

	}

	public void configure() {
		super.configure(); // should call to add, all non-relevant stuff to the
							// filter.
		{
			List<EClass> filteredClasses = filteredNonMasterClasses.get(MetricsPackage.eINSTANCE); 

			// Filter all metric info.
			filteredClasses.add(MetricsPackage.Literals.METRIC);
			filteredClasses.add(MetricsPackage.Literals.METRIC_SOURCE);

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
		{
			List<EClass> filteredClasses = Lists.newArrayList();

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
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			// Filter all design info.
			filteredClasses
					.add(OperatorsPackage.Literals.EQUIPMENT_RELATIONSHIP);
			filteredClasses
					.add(OperatorsPackage.Literals.FUNCTION_RELATIONSHIP);
			filteredClasses.add(OperatorsPackage.Literals.NETWORK);
			filteredClasses.add(OperatorsPackage.Literals.NODE);
			filteredClasses.add(OperatorsPackage.Literals.WAREHOUSE);

			filteredNonMasterClasses.put(OperatorsPackage.eINSTANCE,
					filteredClasses);
		}

		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(ServicesPackage.Literals.DISTRIBUTION_ENTRY);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_DISTRIBUTION);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_PROFILE);
			filteredClasses.add(ServicesPackage.Literals.RFS_SERVICE);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_USER);

			filteredNonMasterClasses.put(ServicesPackage.eINSTANCE,
					filteredClasses);
		}

		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(GenericsPackage.Literals.PERSON);
			filteredClasses.add(GenericsPackage.Literals.ROLE);
			filteredClasses.add(GenericsPackage.Literals.LIFECYCLE); // STATIC

			filteredNonMasterClasses.put(GenericsPackage.eINSTANCE,
					filteredClasses);
		}

		// SCHEDULING
		{
			List<EClass> filteredClasses = Lists.newArrayList();

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

		// GEO
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(GeoPackage.Literals.COUNTRY);
			filteredClasses.add(GeoPackage.Literals.ROOM);
			filteredClasses.add(GeoPackage.Literals.SITE);

			filteredNonMasterClasses.put(SchedulingPackage.eINSTANCE,
					filteredClasses);
		}

		// NETXSTUDIO PACKAGE.
		{
			List<EClass> filteredClasses = Lists.newArrayList();
			filteredClasses.add(NetxstudioPackage.Literals.SERVER_SETTINGS); // UN-USED.
			filteredNonMasterClasses.put(SchedulingPackage.eINSTANCE,
					filteredClasses);
		}

		{
			List<EStructuralFeature> filteredFeatures = Lists.newArrayList();
			filteredFeatures.add(GenericsPackage.Literals.BASE__DELETED);
			filteredNonMasterFeatures.put(GenericsPackage.Literals.BASE,
					filteredFeatures);
		}

	}

}

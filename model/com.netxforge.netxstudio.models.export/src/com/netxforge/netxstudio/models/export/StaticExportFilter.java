package com.netxforge.netxstudio.models.export;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.netxforge.netxstudio.generics.GenericsPackage;
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
			filteredClasses.add(GenericsPackage.Literals.DATE_TIME_RANGE);
			filteredClasses.add(GenericsPackage.Literals.VALUE);
			filteredNonMasterClasses.put(GenericsPackage.eINSTANCE,
					filteredClasses);
		}

		{
			List<EClass> filteredClasses = filteredNonMasterClasses.get(SchedulingPackage.eINSTANCE);;
			filteredNonMasterClasses.put(SchedulingPackage.eINSTANCE,
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

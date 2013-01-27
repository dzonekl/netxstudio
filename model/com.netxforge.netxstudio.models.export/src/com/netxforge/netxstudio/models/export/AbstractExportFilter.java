/*******************************************************************************
 * Copyright (c) Oct 27, 2011 NetXForge.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Maintains a table of EPackages's EClasses which are not to be exported.
 * 
 * @author Christophe Bouhier
 */
public abstract class AbstractExportFilter implements IExportFilter {

	/**
	 * A Filter which only clears the volatile objects.
	 * 
	 * @author Christophe
	 * 
	 */
	public static class VolatileFilter extends AbstractExportFilter {
		public VolatileFilter() {
			configure();
		}
	}

	/**
	 * Classes which are not "Master", meaning not exposed to the user.
	 */
	protected Map<EPackage, List<EClass>> filteredNonMasterClasses = Maps
			.newHashMap();

	/**
	 * Features which are not not "Master", meaning not exposed to the user.
	 */
	protected Map<EClass, List<EStructuralFeature>> filteredNonMasterFeatures = Maps
			.newHashMap();

	public void configure() {

		// METRIC PACKAGE.
		{
			final List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(MetricsPackage.Literals.DATA_KIND); // SUPER
			filteredClasses.add(MetricsPackage.Literals.MAPPING); // SUPER

			filteredClasses.add(MetricsPackage.Literals.MAPPING_RECORD); // VOLATILE
			filteredClasses.add(MetricsPackage.Literals.MAPPING_STATISTIC); // VOLATILE.

			filteredClasses.add(MetricsPackage.Literals.METRIC_RETENTION_RULE); // FIXTURE
			filteredClasses.add(MetricsPackage.Literals.METRIC_RETENTION_RULES); // FIXTURE

			filteredNonMasterClasses.put(MetricsPackage.eINSTANCE,
					filteredClasses);
		}
		// LIBRARY PACKAGE.
		{
			final List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(LibraryPackage.Literals.BASE_EXPRESSION_RESULT); // SUPER
			filteredClasses.add(LibraryPackage.Literals.BASE_RESOURCE); // SUPER
			filteredClasses.add(LibraryPackage.Literals.COMPONENT); // SUPER

			filteredClasses.add(LibraryPackage.Literals.EXPRESSION_RESULT); // VOLATILE
			filteredClasses
					.add(LibraryPackage.Literals.LAST_EVALUATION_EXPRESSION_RESULT); // VOLATILE

			filteredClasses.add(LibraryPackage.Literals.EQUIPMENT_GROUP); // FUTURE
			filteredClasses.add(LibraryPackage.Literals.PRODUCT_INFO); // FUTURE

			filteredClasses.add(LibraryPackage.Literals.LIBRARY); // UN-USED.

			filteredNonMasterClasses.put(LibraryPackage.eINSTANCE,
					filteredClasses);
		}
		// OPERATORS PACKAGE.
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(OperatorsPackage.Literals.RELATIONSHIP); // SUPER
			filteredClasses.add(OperatorsPackage.Literals.MARKER); // SUPER
			filteredClasses.add(OperatorsPackage.Literals.RESOURCE_EXPANSION); // FUTURE
			filteredClasses.add(OperatorsPackage.Literals.RESOURCE_FORECAST); // FUTURE
			filteredNonMasterClasses.put(OperatorsPackage.eINSTANCE,
					filteredClasses);
		}
		// SERVICES PACKAGE.
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(ServicesPackage.Literals.SERVICE); // SUPER.
			filteredClasses.add(ServicesPackage.Literals.SERVICE_FORECAST); // FUTURE
			filteredClasses
					.add(ServicesPackage.Literals.SERVICE_FORECAST_USERS); // FUTURE
			filteredClasses.add(ServicesPackage.Literals.CIID); // UN-USED
			filteredClasses.add(ServicesPackage.Literals.CFS_SERVICE); // UN-USED.

			filteredNonMasterClasses.put(ServicesPackage.eINSTANCE,
					filteredClasses);
		}

		// GENERICS PACKAGE.
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(GenericsPackage.Literals.BASE); // SUPER
			filteredClasses.add(GenericsPackage.Literals.COMPANY); // SUPER
			filteredClasses.add(GenericsPackage.Literals.DIAGRAM_INFO); // UN-USED.
			filteredClasses.add(GenericsPackage.Literals.COMMIT_LOG_ENTRY); // VOLATILE.
			filteredClasses.add(GenericsPackage.Literals.MULTI_IMAGE); // UN-USED
			filteredClasses.add(GenericsPackage.Literals.META); // UN-USED
			filteredClasses
					.add(GenericsPackage.Literals.EXPANSION_DURATION_SETTING); // FIXTURE
			filteredClasses
					.add(GenericsPackage.Literals.EXPANSION_DURATION_VALUE); // FIXTURE
			filteredClasses.add(GenericsPackage.Literals.ROLE); // FIXTURE.

			filteredNonMasterClasses.put(GenericsPackage.eINSTANCE,
					filteredClasses);
		}
		// SCHEDULING PACKAGE.
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(SchedulingPackage.Literals.JOB); // SUPER.
			filteredClasses.add(SchedulingPackage.Literals.FAILURE); // SUPER
			filteredClasses.add(SchedulingPackage.Literals.WORK_FLOW_RUN); // SUPER

			filteredClasses.add(SchedulingPackage.Literals.COMPONENT_FAILURE); // VOLATILE
			filteredClasses.add(SchedulingPackage.Literals.EXPRESSION_FAILURE); // VOLATILE
			filteredClasses
					.add(SchedulingPackage.Literals.SERVICE_USER_FAILURE); // VOLATILE

			filteredClasses
					.add(SchedulingPackage.Literals.COMPONENT_WORK_FLOW_RUN); // VOLATILE
			filteredClasses.add(SchedulingPackage.Literals.JOB_RUN_CONTAINER); // VOLATILE
			filteredClasses.add(SchedulingPackage.Literals.ANALYZER_JOB); // FUTURE
																			// USE
			filteredClasses.add(SchedulingPackage.Literals.RETENTION_JOB); // FIXTURE
			filteredNonMasterClasses.put(SchedulingPackage.eINSTANCE,
					filteredClasses);
		}
		// GEO PACKAGE.
		{
			List<EClass> filteredClasses = Lists.newArrayList();
			filteredClasses.add(GeoPackage.Literals.LOCATION); // SUPER
			filteredNonMasterClasses.put(GeoPackage.eINSTANCE, filteredClasses);
		}

		// NETXSTUDIO PACKAGE.
		{
			List<EClass> filteredClasses = Lists.newArrayList();
			filteredClasses.add(NetxstudioPackage.Literals.NETXSTUDIO); // UN-USED.
			filteredClasses.add(NetxstudioPackage.Literals.SERVER_SETTINGS); // FIXTURE
			filteredNonMasterClasses.put(NetxstudioPackage.eINSTANCE,
					filteredClasses);
		}

		// PROTOCOL PACKAGE.
		{
			List<EClass> filteredClasses = Lists.newArrayList();
			// NO filtered classes for protocol
			filteredNonMasterClasses.put(ProtocolsPackage.eINSTANCE,
					filteredClasses);
		}

		// FEATURES.
		{
			List<EStructuralFeature> filteredFeatures = Lists.newArrayList();
			filteredFeatures.add(GenericsPackage.Literals.BASE__DELETED);
			filteredNonMasterFeatures.put(GenericsPackage.Literals.BASE,
					filteredFeatures);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.models.export.IExportFilter#filteredClassesFor
	 * (org.eclipse.emf.ecore.EPackage)
	 */
	public List<EClass> filteredClassesFor(EPackage ePackage) {
		if (filteredNonMasterClasses.containsKey(ePackage)) {
			return filteredNonMasterClasses.get(ePackage);
		} else
			return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.models.export.IExportFilter#shouldFilterObject
	 * (org.eclipse.emf.ecore.EClass)
	 */
	public boolean shouldFilterObject(EClass eClass) {
		return filteredNonMasterClasses.get(eClass.getEPackage()).contains(
				eClass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.models.export.IExportFilter#nonFilteredClassesFor
	 * (org.eclipse.emf.ecore.EPackage)
	 */
	public ImmutableList<EClassifier> nonFilteredClassesFor(EPackage ePackage) {
		Iterable<EClassifier> filter = Iterables
				.filter(ePackage.getEClassifiers(),
						nonFilteredClassPredicate(ePackage));
		return ImmutableList.copyOf(filter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.models.export.IExportFilter#
	 * alphabetOrderedClassesFor(org.eclipse.emf.ecore.EPackage)
	 */
	public List<EClassifier> alphabetOrderedNonFilteredClassesFor(
			EPackage... ePackages) {
		List<EClassifier> forAllPackages = Lists.newArrayList();
		for (EPackage ePackage : ePackages) {
			forAllPackages.addAll(nonFilteredClassesFor(ePackage));
		}
		return Ordering.from(new ClassNameComparator()).sortedCopy(
				forAllPackages);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.models.export.IExportFilter#
	 * alphabetOrderedClassesFor(org.eclipse.emf.ecore.EPackage)
	 */
	public List<EClassifier> alphabetOrderedNonFilteredClassesFor(
			EPackage ePackage) {
		List<EClassifier> sortedCopy = Ordering.from(new ClassNameComparator())
				.sortedCopy(nonFilteredClassesFor(ePackage));
		return sortedCopy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.models.export.IExportFilter#filteredFeaturesFor
	 * (org.eclipse.emf.ecore.EClass)
	 */
	public List<EStructuralFeature> filteredFeaturesFor(EClass eClass) {

		// Evaluate the super types as well.
		ArrayList<EClass> selfAndSupers = Lists.newArrayList();

		selfAndSupers.add(eClass);
		selfAndSupers.addAll(eClass.getEAllSuperTypes());

		List<EStructuralFeature> resolvedFeatures = Lists.newArrayList();

		for (EClass ec : selfAndSupers) {
			if (filteredNonMasterFeatures.containsKey(ec)) {
				resolvedFeatures.addAll(filteredNonMasterFeatures.get(ec));
			}
		}
		return resolvedFeatures;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.models.export.IExportFilter#
	 * nonFilteredClassPredicate(org.eclipse.emf.ecore.EPackage)
	 */
	public FilteredClassPredicate nonFilteredClassPredicate(EPackage ePackage) {
		return new FilteredClassPredicate(
				filteredNonMasterClasses.get(ePackage));
	}

	/**
	 * A predicate for filtered.
	 */
	class FilteredClassPredicate implements Predicate<EClassifier> {
		private List<EClass> filtered;

		public FilteredClassPredicate(final List<EClass> filtered) {
			this.filtered = filtered;
		}

		public boolean apply(final EClassifier eClassifier) {
			if ((eClassifier instanceof EClass) && (filtered != null)) {
				return !filtered.contains((EClass) eClassifier);
			}
			return false;
		}
	}

	public static class ClassNameComparator implements Comparator<EClassifier> {
		public int compare(final EClassifier eClass1, EClassifier eClass2) {
			return eClass1.getName().compareTo(eClass2.getName());
		}
	};

}

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
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Maintains a table of EPackages's EClasses which are not to be exported.
 * 
 * @author dzonekl
 */
public class ExportFilter {

	/*
	 * Classes which are not "Master", meaning not exposed to the user.
	 */
	private static Map<EPackage, List<EClass>> filteredNonMasterClasses = Maps
			.newHashMap();

	/*
	 * Features which are not not "Master", meaning not exposed to the user.
	 */
	private static Map<EClass, List<EStructuralFeature>> filteredNonMasterFeatures = Maps
			.newHashMap();

	static {

		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(MetricsPackage.Literals.METRIC_RETENTION_RULE);
			filteredClasses.add(MetricsPackage.Literals.METRIC_RETENTION_RULES);
			// Keep the resource ranges. CB 16-01-2012
//			filteredClasses.add(MetricsPackage.Literals.METRIC_VALUE_RANGE);
			filteredClasses.add(MetricsPackage.Literals.MAPPING_STATISTIC);
			filteredClasses.add(MetricsPackage.Literals.DATA_KIND);
			filteredClasses.add(MetricsPackage.Literals.MAPPING_RECORD);
			filteredClasses.add(MetricsPackage.Literals.MAPPING);
			filteredNonMasterClasses.put(MetricsPackage.eINSTANCE,
					filteredClasses);
		}
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(LibraryPackage.Literals.BASE_EXPRESSION_RESULT);
			filteredClasses.add(LibraryPackage.Literals.BASE_RESOURCE);
			filteredClasses.add(LibraryPackage.Literals.COMPONENT);
			filteredClasses.add(LibraryPackage.Literals.EQUIPMENT_GROUP);
			filteredClasses.add(LibraryPackage.Literals.EXPRESSION_RESULT);
			filteredClasses
					.add(LibraryPackage.Literals.LAST_EVALUATION_EXPRESSION_RESULT);
			// Keep the resources. CB 16-01-2012
//			filteredClasses.add(LibraryPackage.Literals.NET_XRESOURCE);
			filteredClasses.add(LibraryPackage.Literals.LIBRARY);
			filteredClasses.add(LibraryPackage.Literals.PRODUCT_INFO);
			filteredNonMasterClasses.put(LibraryPackage.eINSTANCE,
					filteredClasses);
		}
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(OperatorsPackage.Literals.MARKER);
			filteredClasses.add(OperatorsPackage.Literals.RELATIONSHIP);
			filteredClasses.add(OperatorsPackage.Literals.RESOURCE_EXPANSION);
			filteredClasses.add(OperatorsPackage.Literals.RESOURCE_FORECAST);
			filteredClasses.add(OperatorsPackage.Literals.RESOURCE_MONITOR);
			// Keep the markers. CB 16-01-2012
//			filteredClasses.add(OperatorsPackage.Literals.TOLERANCE_MARKER);
			filteredClasses.add(OperatorsPackage.Literals.WAREHOUSE);
			filteredNonMasterClasses.put(OperatorsPackage.eINSTANCE,
					filteredClasses);
		}
		
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(ServicesPackage.Literals.CFS_SERVICE);
			filteredClasses.add(ServicesPackage.Literals.SERVICE);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_DISTRIBUTION);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_FORECAST);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_FORECAST_USERS);
			filteredClasses.add(ServicesPackage.Literals.SERVICE_MONITOR);
			filteredClasses.add(ServicesPackage.Literals.CIID);
			// Keep the derived resources. 
//			filteredClasses.add(ServicesPackage.Literals.DERIVED_RESOURCE);
			filteredClasses.add(ServicesPackage.Literals.DISTRIBUTION_ENTRY);
			
			filteredNonMasterClasses.put(ServicesPackage.eINSTANCE,
					filteredClasses);
		}
		
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(GenericsPackage.Literals.DIAGRAM_INFO);
			filteredClasses.add(GenericsPackage.Literals.BASE);
			filteredClasses.add(GenericsPackage.Literals.COMMIT_LOG_ENTRY);
			filteredClasses.add(GenericsPackage.Literals.COMPANY);
			filteredClasses.add(GenericsPackage.Literals.DATE_TIME_RANGE);
			filteredClasses.add(GenericsPackage.Literals.EXPANSION_DURATION_SETTING);
			filteredClasses.add(GenericsPackage.Literals.EXPANSION_DURATION_VALUE);
			filteredClasses.add(GenericsPackage.Literals.MULTI_IMAGE);
			filteredClasses.add(GenericsPackage.Literals.META);
			// Keep the values. 
//			filteredClasses.add(GenericsPackage.Literals.VALUE);
			filteredClasses.add(GenericsPackage.Literals.ROLE);
			
			filteredNonMasterClasses.put(GenericsPackage.eINSTANCE,
					filteredClasses);
		}
		
		{
			List<EClass> filteredClasses = Lists.newArrayList();

			filteredClasses.add(SchedulingPackage.Literals.JOB);
			filteredClasses.add(SchedulingPackage.Literals.COMPONENT_FAILURE);
			filteredClasses.add(SchedulingPackage.Literals.COMPONENT_WORK_FLOW_RUN);
			filteredClasses.add(SchedulingPackage.Literals.FAILURE);
			filteredClasses.add(SchedulingPackage.Literals.JOB_RUN_CONTAINER);
			filteredClasses.add(SchedulingPackage.Literals.SERVICE_USER_FAILURE);
			filteredClasses.add(SchedulingPackage.Literals.WORK_FLOW_RUN);
			
//			filteredClasses.add(SchedulingPackage.Literals.METRIC_SOURCE_JOB);
//			filteredClasses.add(SchedulingPackage.Literals.NODE_REPORTER_JOB);
//			filteredClasses.add(SchedulingPackage.Literals.NODE_TYPE_REPORTER_JOB);
//			filteredClasses.add(SchedulingPackage.Literals.OPERATOR_REPORTER_JOB);
			
			filteredNonMasterClasses.put(SchedulingPackage.eINSTANCE,
					filteredClasses);
		}
		
	}

	static {

		{
			List<EStructuralFeature> filteredFeatures = Lists.newArrayList();
			filteredFeatures.add(GenericsPackage.Literals.BASE__DELETED);
			filteredNonMasterFeatures.put(GenericsPackage.Literals.BASE,
					filteredFeatures);

		}
	}

	public static List<EClass> filteredClassesFor(EPackage ePackage) {
		if (filteredNonMasterClasses.containsKey(ePackage)) {
			return filteredNonMasterClasses.get(ePackage);
		} else
			return Collections.emptyList();
	}

	public static ImmutableList<EClassifier> nonFilteredClassesFor(
			EPackage ePackage) {
		Iterable<EClassifier> filter = Iterables
				.filter(ePackage.getEClassifiers(),
						nonFilteredClassPredicate(ePackage));
		return ImmutableList.copyOf(filter);
	}

	public static List<EClassifier> alphabetOrderedClassesFor(
			EPackage... ePackages) {
		List<EClassifier> forAllPackages = Lists.newArrayList();
		for (EPackage ePackage : ePackages) {
			forAllPackages.addAll(nonFilteredClassesFor(ePackage));
		}
		return Ordering.from(new ClassNameComparator()).sortedCopy(
				forAllPackages);
	}

	public static List<EClassifier> alphabetOrderedClassesFor(EPackage ePackage) {
		List<EClassifier> sortedCopy = Ordering.from(new ClassNameComparator())
				.sortedCopy(nonFilteredClassesFor(ePackage));
		return sortedCopy;
	}

	/**
	 * Also returns the filtered features for super classes.
	 * 
	 * @param eClass
	 * @return
	 */
	public static List<EStructuralFeature> filteredFeaturesFor(EClass eClass) {

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

	public static FilteredClassPredicate nonFilteredClassPredicate(
			EPackage ePackage) {
		return new FilteredClassPredicate(
				filteredNonMasterClasses.get(ePackage));
	}

	/*
	 * A predicate for filtered.
	 */
	public static class FilteredClassPredicate implements
			Predicate<EClassifier> {
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

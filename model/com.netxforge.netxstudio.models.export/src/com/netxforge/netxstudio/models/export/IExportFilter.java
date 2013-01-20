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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.ImmutableList;
import com.netxforge.netxstudio.models.export.AbstractExportFilter.FilteredClassPredicate;

/**
 * An export filter.
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IExportFilter {

	/**
	 * clients should implement this method, which will populate the EClass and
	 * EStructuralFeature maps.
	 */
	public abstract void configure();

	/**
	 * Get all filtered classes
	 * 
	 * @param ePackage
	 * @return
	 */
	public abstract List<EClass> filteredClassesFor(EPackage ePackage);

	/**
	 * Should this {@link EClass} be filtered according to this export filter?
	 * 
	 * @param eClass
	 * @return
	 */
	public abstract boolean shouldFilterObject(EClass eClass);

	/**
	 * Get all non-filtered classes for the provided package.
	 * 
	 * @param ePackage
	 * @return
	 */
	public abstract ImmutableList<EClassifier> nonFilteredClassesFor(
			EPackage ePackage);

	/**
	 * Get all non-filtered classes from the provided packages, sorted
	 * alphabetically.
	 * 
	 * @param ePackages
	 * @return
	 */
	public abstract List<EClassifier> alphabetOrderedNonFilteredClassesFor(
			EPackage... ePackages);

	/**
	 * Get all non-filtered classes from the provided package, sorted
	 * alphabetically.
	 * 
	 * @param ePackages
	 * @return
	 */
	public abstract List<EClassifier> alphabetOrderedNonFilteredClassesFor(
			EPackage ePackage);

	/**
	 * Also returns the filtered features for super classes.
	 * 
	 * @param eClass
	 * @return
	 */
	public abstract List<EStructuralFeature> filteredFeaturesFor(EClass eClass);

	public abstract FilteredClassPredicate nonFilteredClassPredicate(
			EPackage ePackage);

}
package com.netxforge.netxstudio.models.export;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.ImmutableList;
import com.netxforge.netxstudio.models.export.AbstractExportFilter.FilteredClassPredicate;

public interface IExportFilter {
	
	/**
	 * clients should implement this method, which will populate the EClass and EStructuralFeature maps.  
	 */
	public abstract void configure();
	
	/**
	 * Get all filtered classes 
	 * @param ePackage
	 * @return
	 */
	public abstract List<EClass> filteredClassesFor(EPackage ePackage);

	/**
	 * Get all non-filtered classes for the provided package. 
	 * @param ePackage
	 * @return
	 */
	public abstract ImmutableList<EClassifier> nonFilteredClassesFor(
			EPackage ePackage);

	/**
	 * Get all non-filtered classes from the provided packages, sorted alphabetically.
	 * @param ePackages
	 * @return
	 */
	public abstract List<EClassifier> alphabetOrderedClassesFor(
			EPackage... ePackages);

	/**
	 * Get all non-filtered classes from the provided package, sorted alphabetically.
	 * @param ePackages
	 * @return
	 */
	public abstract List<EClassifier> alphabetOrderedClassesFor(
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
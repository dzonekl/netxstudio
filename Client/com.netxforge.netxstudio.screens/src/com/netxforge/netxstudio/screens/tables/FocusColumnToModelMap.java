package com.netxforge.netxstudio.screens.tables;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;

public class FocusColumnToModelMap {
	
	Map<Integer, EStructuralFeature> columnFeatureMap = new HashMap<Integer, EStructuralFeature>();

	/**
	 * @return the columnFeatureMap
	 */
	public Map<Integer, EStructuralFeature> getColumnFeatureMap() {
		return columnFeatureMap;
	}
	
}

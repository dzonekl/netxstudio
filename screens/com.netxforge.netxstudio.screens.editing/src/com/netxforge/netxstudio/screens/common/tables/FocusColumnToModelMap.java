/*******************************************************************************
 * Copyright (c) 6 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.common.tables;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * Simple Convenience map. 
 * 
 * @author Christophe Bouhier
 *
 */
public class FocusColumnToModelMap {
	
	Map<Integer, EStructuralFeature> columnFeatureMap = new HashMap<Integer, EStructuralFeature>();

	/**
	 * @return the columnFeatureMap
	 */
	public Map<Integer, EStructuralFeature> getColumnFeatureMap() {
		return columnFeatureMap;
	}
	
}

/*******************************************************************************
 * Copyright (c) Jul 10, 2012 NetXForge.
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
package com.netxforge.interpreter;

import java.util.List;

import com.netxforge.netxstudio.generics.Value;

/**
 * API to apply native functions returning an evaluation which has the same type as the 
 * parameter type. 
 *  
 * @author Christophe
 */
public interface INativeFunctions2 {
	
	/**
	 * The max value in the range.
	 * @param range
	 * @return
	 */
	public abstract Value maxValue(List<Value> range);

	/**
	 * The min value in the range. 
	 * @param range
	 * @return
	 */
	public abstract Value minValue(List<Value> range);
	
	/**
	 * The mean value in the range. 
	 * @param range
	 * @return
	 */
	public abstract Value meanValue(List<Value> range);
	
	
}
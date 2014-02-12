/*******************************************************************************
 * Copyright (c) 28 jan. 2014 NetXForge.
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
package com.netxforge.netxstudio.common.math;

import java.math.BigDecimal;
import java.util.List;

import com.netxforge.netxstudio.common.GenericsTuple;

public interface INativeFunctions {

	/**
	 * Trend using linear regression. Feed with a matrix. 
	 * 
	 * 
	 * @param dataPair
	 * @return
	 */
	public abstract GenericsTuple<Double, Double> trend(double[][] dataPair);

	/**
	 * The Erlang B formula.
	 * 
	 * @param range
	 * @param gradeOfService
	 * @return
	 */
	public abstract BigDecimal erlangB(List<?> range, float gradeOfService);

	/**
	 * Count the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract BigDecimal count(List<?> range);

	/**
	 * Sum the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract BigDecimal sum(List<?> range);

	/**
	 * Sum the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract double sum(double[] range);

	/**
	 * Sum each entry of two ranges.
	 * 
	 * @param range
	 * @param range2
	 * @return
	 */
	public abstract double[] sumCollections(double[] range, double[] range2);

	/**
	 * Sum each entry for multiple ranges.
	 * 
	 * @param range
	 * @return
	 */
	public abstract double[] sumCollections(List<Double[]> collections);

	/**
	 * The max value in the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract BigDecimal max(List<?> range);

	/**
	 * The max value in the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract double max(double[] range);

	/**
	 * The min value in the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract BigDecimal min(List<?> range);

	/**
	 * The min value in the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract double min(double[] range);

	/**
	 * The arithmetic mean in the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract BigDecimal mean(List<?> range);

	/**
	 * The arithmetic mean in the range.
	 * 
	 * @param range
	 * @return
	 */
	public abstract double mean(double[] range);

	/**
	 * The standard deviation from a range. {@link http
	 * ://en.wikipedia.org/wiki/Standard_deviation }
	 * 
	 * @param range
	 * @return
	 */
	public abstract BigDecimal standardDeviation(List<?> range);

	/**
	 * The standard deviation from a range. {@link http
	 * ://en.wikipedia.org/wiki/Standard_deviation }
	 * 
	 * @param range
	 * @return
	 */
	public abstract double standardDeviation(double[] range);

}
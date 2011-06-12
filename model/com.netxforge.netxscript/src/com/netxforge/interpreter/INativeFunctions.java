package com.netxforge.interpreter;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;

public interface INativeFunctions {
	
	
	/**
	 * Count the range.
	 * @param range
	 * @return
	 */
	public abstract BigDecimal count(EList<?> range);
	
	/**
	 * Sum the range.
	 * @param range
	 * @return
	 */
	public abstract BigDecimal sum(EList<?> range);

	/**
	 * Sum the range. 
	 * @param range
	 * @return
	 */
	public abstract double sum(double[] range);

	/**
	 * The max value in the range.
	 * @param range
	 * @return
	 */
	public abstract BigDecimal max(EList<?> range);

	/**
	 * The max value in the range.
	 * @param range
	 * @return
	 */
	public abstract double max(double[] range);

	/**
	 * The min value in the range. 
	 * @param range
	 * @return
	 */
	public abstract BigDecimal min(EList<?> range);

	/**
	 * The min value in the range. 
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
	public abstract BigDecimal mean(EList<?> range);

	/**
	 * The arithmetic mean in the range. 
	 * 
	 * @param range
	 * @return
	 */
	public abstract double mean(double[] range);
	
	/**
	 * The standard deviation from a range. 
	 * {@link http://en.wikipedia.org/wiki/Standard_deviation }
	 * @param range
	 * @return
	 */
	public abstract BigDecimal standardDeviation(EList<?> range);

	/**
	 * The standard deviation from a range. 
	 * {@link http://en.wikipedia.org/wiki/Standard_deviation }
	 * 
	 * @param range
	 * @return
	 */
	public abstract double standardDeviation(double[] range);

}
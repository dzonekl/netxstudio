package com.netxforge.interpreter;

import java.math.BigDecimal;
import java.util.List;

public interface INativeFunctions {
	
	
	/**
	 * The Erlang B formula. 
	 * @param range
	 * @param gradeOfService
	 * @return
	 */
	public abstract BigDecimal erlangB(List<?> range, float gradeOfService);
	
	
	/**
	 * Count the range.
	 * @param range
	 * @return
	 */
	public abstract BigDecimal count(List<?> range);
	
	/**
	 * Sum the range.
	 * @param range
	 * @return
	 */
	public abstract BigDecimal sum(List<?> range);

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
	public abstract BigDecimal max(List<?> range);

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
	public abstract BigDecimal min(List<?> range);

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
	public abstract BigDecimal mean(List<?> range);

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
	public abstract BigDecimal standardDeviation(List<?> range);

	/**
	 * The standard deviation from a range. 
	 * {@link http://en.wikipedia.org/wiki/Standard_deviation }
	 * 
	 * @param range
	 * @return
	 */
	public abstract double standardDeviation(double[] range);

}
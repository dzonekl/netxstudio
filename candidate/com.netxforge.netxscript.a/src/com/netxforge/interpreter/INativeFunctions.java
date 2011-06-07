package com.netxforge.interpreter;

import library.Value;

import org.eclipse.emf.common.util.EList;

public interface INativeFunctions {

	/**
	 * Sum the range.
	 * @param range
	 * @return
	 */
	public abstract double sum(EList<Value> range);

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
	public abstract double max(EList<Value> range);

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
	public abstract double min(EList<Value> range);

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
	public abstract double mean(EList<Value> range);

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
	public abstract double standardDeviation(EList<Value> range);

	/**
	 * The standard deviation from a range. 
	 * {@link http://en.wikipedia.org/wiki/Standard_deviation }
	 * 
	 * @param range
	 * @return
	 */
	public abstract double standardDeviation(double[] range);

}
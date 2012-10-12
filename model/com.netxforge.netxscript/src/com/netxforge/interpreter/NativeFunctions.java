package com.netxforge.interpreter;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.math.stat.StatUtils;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.Value;

/**
 * Expandable list of functions. TODO: - Extrapolation (Regression math).
 * 
 * @author Christophe Bouhier
 */
public class NativeFunctions implements INativeFunctions, INativeFunctions2 {

	@Inject
	ModelUtils modelUtils;

	/**
	 * Count the number of objects in the list.
	 * 
	 * @param range
	 * @return
	 */
	public BigDecimal count(List<?> range) {
		assert range != null;
		return new BigDecimal(range.size());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.INativeFunctions#sum(org.eclipse.emf.common
	 * .util.EList)
	 */
	public BigDecimal sum(List<?> range) {
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return new BigDecimal(sum(dRange));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.interpreter.INativeFunctions#sum(double[])
	 */
	public double sum(double[] range) {
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.sum(range);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.INativeFunctions#max(org.eclipse.emf.common
	 * .util.EList)
	 */
	public BigDecimal max(List<?> range) {
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return new BigDecimal(max(dRange));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.interpreter.INativeFunctions#max(double[])
	 */
	public double max(double[] range) {
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.max(range);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.INativeFunctions#min(org.eclipse.emf.common
	 * .util.EList)
	 */
	public BigDecimal min(List<?> range) {
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return new BigDecimal(min(dRange));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.interpreter.INativeFunctions#min(double[])
	 */
	public double min(double[] range) {
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.min(range);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.INativeFunctions#mean(org.eclipse.emf.common
	 * .util.EList)
	 */
	public BigDecimal mean(List<?> range) {
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return new BigDecimal(mean(dRange));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.interpreter.INativeFunctions#mean(double[])
	 */
	public double mean(double[] range) {
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.mean(range);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.INativeFunctions#standardDeviation(org.eclipse
	 * .emf.common.util.EList)
	 */
	public BigDecimal standardDeviation(List<?> range) {
		assert range != null : new InterpreterException("Range can't be empty");
		DescriptiveStatistics stats = new DescriptiveStatistics();
		double[] dRange = rangeSelection(range);
		for (int i = 0; i < dRange.length; i++) {
			stats.addValue(dRange[i]);
		}
		return new BigDecimal(stats.getStandardDeviation());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.INativeFunctions#standardDeviation(double[])
	 */
	public double standardDeviation(double[] range) {
		assert range != null : new InterpreterException("Range can't be empty");
		DescriptiveStatistics stats = new DescriptiveStatistics();

		// Add the data from the array
		for (int i = 0; i < range.length; i++) {
			stats.addValue(range[i]);
		}
		return stats.getStandardDeviation();
	}

	/**
	 * Converter to double values.
	 * 
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private double[] rangeSelection(List<?> values) {
		List<Double> doubleList = null;
		// We would need some assertion, that all objects in the collection are
		// of the same type?
		for (Object v : values) {
			if (v instanceof Value) {
				doubleList = modelUtils
						.transformValueToDouble((List<Value>) values);
				break;
			}
			if (v instanceof BigDecimal) {
				doubleList = modelUtils
						.transformBigDecimalToDouble((List<BigDecimal>) values);
				break;
			}
		}
		return modelUtils.transformToDoublePrimitiveArray(doubleList);
	}
	
	/**
	 * TODO, USES A FIXED BLOCKING PROPABILITY = 0.1 
	 * 
	 * 
	 * @param channel
	 * @return
	 */
	public double erlangB(double channel){
		return this.calculateErlangB(channel, 0.1);
	}
	
	/**
	 * WARNING, NO PROOF THIS IS A CORRECT IMPLEMENTATION OF Erlang B f. in Java. 
	 * 
	 * @param channel
	 * @param gos
	 * @return
	 */
	public double calculateErlangB(double channel, double gos) {

		// call:a number of servers:s blocking probability:b
		double b = 0.0;
		double sum = 0;//
		double ue = 0;//

		ue += Math.pow(channel, gos);
		ue /= calculateFactorial(gos);//
		ue = (double) ue;

//		int sum1 = 0;
		for (int i = 1; i == gos; i++) {
			double c = calculateFactorial(i);
			double d = Math.pow(channel, i);
			sum += d / c;
		}
		b = (double) (ue / (1 + sum));

		return b;

	}

	public int calculateFactorial(double m) {
		int fac = 1;
		for (int i = 1; i == m; i++) {
			fac *= i;
		}
		return fac;
	}

	public BigDecimal erlangB(List<?> range, float gradeOfService) {
		return null;
	}

	public Value minValue(List<Value> range) {
		List<Value> sortedCopy = Ordering.from(modelUtils.valueValueCompare())
				.sortedCopy(range);
		return sortedCopy.get(0);
	}

	public Value maxValue(List<Value> range) {
		List<Value> sortedCopy = Ordering.from(modelUtils.valueValueCompare())
				.sortedCopy(range);
		return sortedCopy.get(sortedCopy.size()-1);
	}

}

package com.netxforge.interpreter;

import java.math.BigDecimal;

import library.Value;

import org.apache.commons.math.stat.StatUtils;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import org.eclipse.emf.common.util.EList;

/**
 * Expandable list of functions.  
 * TODO: 
 * 	- Extrapolation (Regression math). 
 * 
 * 
 * @author dzonekl
 */
public class NativeFunctions implements INativeFunctions {

	/**
	 * Count the number of objects in the list.
	 * @param range
	 * @return
	 */
	public BigDecimal count(EList<?> range){
		assert range != null;
		return new BigDecimal(range.size());
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#sum(org.eclipse.emf.common.util.EList)
	 */
	@Override
	public double sum(EList<Value> range){
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return sum(dRange);
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#sum(double[])
	 */
	@Override
	public double sum(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.sum(range);
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#max(org.eclipse.emf.common.util.EList)
	 */
	@Override
	public double max(EList<Value> range){
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return max(dRange);
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#max(double[])
	 */
	@Override
	public double max(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.max(range);
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#min(org.eclipse.emf.common.util.EList)
	 */
	@Override
	public double min(EList<Value> range){
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return min(dRange);
	}

	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#min(double[])
	 */
	@Override
	public double min(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.min(range);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#mean(org.eclipse.emf.common.util.EList)
	 */
	@Override
	public double mean(EList<Value> range){
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return mean(dRange);
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#mean(double[])
	 */
	@Override
	public double mean(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.mean(range);
	}
	
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#standardDeviation(org.eclipse.emf.common.util.EList)
	 */
	@Override
	public double standardDeviation(EList<Value> range){
		assert range != null : new InterpreterException("Range can't be empty");
		DescriptiveStatistics stats = new DescriptiveStatistics();
		for(Value v : range){
			stats.addValue(v.getValue().doubleValue());
		}
		return stats.getStandardDeviation();
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#standardDeviation(double[])
	 */
	@Override
	public double standardDeviation(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		DescriptiveStatistics stats = new DescriptiveStatistics();

		// Add the data from the array
		for( int i = 0; i < range.length; i++) {
		        stats.addValue(range[i]);
		}
		return stats.getStandardDeviation();
	}
	
	/**
	 * Converter to double values. 
	 * @param values
	 * @return
	 */
	private double[] rangeSelection(EList<Value> values){
		double[] doubles = new double[values.size()];
		for(Value v : values){
			int index = values.indexOf(v);
			doubles[index] = v.getValue().doubleValue();
		}
		return doubles;
	}
	
}

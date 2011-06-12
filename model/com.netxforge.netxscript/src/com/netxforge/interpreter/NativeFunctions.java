package com.netxforge.interpreter;

import java.math.BigDecimal;

import org.apache.commons.math.stat.StatUtils;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.generics.Value;

/**
 * Expandable list of functions.  
 * TODO: 
 * 	- Extrapolation (Regression math). 
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
	public BigDecimal sum(EList<?> range){
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return new BigDecimal(sum(dRange));
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#sum(double[])
	 */
	public double sum(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.sum(range);
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#max(org.eclipse.emf.common.util.EList)
	 */
	public BigDecimal max(EList<?> range){
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return new BigDecimal(max(dRange));
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#max(double[])
	 */
	public double max(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.max(range);
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#min(org.eclipse.emf.common.util.EList)
	 */
	public BigDecimal min(EList<?> range){
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return new BigDecimal(min(dRange));
	}

	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#min(double[])
	 */
	public double min(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.min(range);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#mean(org.eclipse.emf.common.util.EList)
	 */
	public BigDecimal mean(EList<?> range){
		assert range != null : new InterpreterException("Range can't be empty");
		double[] dRange = rangeSelection(range);
		return new BigDecimal(mean(dRange));
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#mean(double[])
	 */
	public double mean(double[] range){
		assert range != null : new InterpreterException("Range can't be empty");
		return StatUtils.mean(range);
	}
	
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#standardDeviation(org.eclipse.emf.common.util.EList)
	 */
	public BigDecimal standardDeviation(EList<?> range){
		assert range != null : new InterpreterException("Range can't be empty");
		DescriptiveStatistics stats = new DescriptiveStatistics();
		double[] dRange = rangeSelection(range);
		for(int i = 0; i < dRange.length;i++){
			stats.addValue(dRange[i]);
		}
		return new BigDecimal(stats.getStandardDeviation());
	}
	
	/* (non-Javadoc)
	 * @see com.netxforge.interpreter.INativeFunctions#standardDeviation(double[])
	 */
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
	private double[] rangeSelection(EList<?> values){
		double[] doubles = new double[values.size()];
		
		// We would need some assertion, that all objects in the collection are 
		// of the same type? 
		for(Object v : values){
			int index = values.indexOf(v);
			if(v instanceof Value){
				doubles[index] = ((Value)v).getValue();
			}
			if(v instanceof BigDecimal){
				doubles[index] = ((BigDecimal)v).doubleValue();
			}
		}
		return doubles;
	}
	
}

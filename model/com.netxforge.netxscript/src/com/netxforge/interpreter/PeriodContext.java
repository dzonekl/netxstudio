package com.netxforge.interpreter;

import library.Period;

/**
 * A placeholder for contextual interpretators. 
 * @author dzonekl
 *
 */
public class PeriodContext implements IInterpreterContext {
	
	private Period period;

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
	
	
}

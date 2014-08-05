package com.netxforge.interpreter;

import org.eclipse.emf.ecore.EObject;

public class InterpreterException extends Exception {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * An interpreter exception for a reference to the external model
	 * which is not found.
	 * 
	 * TODO, Find all external reference calls and wrap in an try/catch, to throw this exception. 
	 * 
	 */
	public static final int MODEL_REFERENCE_NOT_FOUND = 100;
	public static final int EXECUTION_LOGIC_PROBLEM = 100;
	
	private EObject failedWhileEvaluationMe; 
	
	private int exceptionType;
	
	public InterpreterException(String string) {
		super(string);
	}
	
	public EObject getFailedWhileEvaluationMe() {
		return failedWhileEvaluationMe;
	}

	public void setFailedWhileEvaluationMe(EObject failedWhileEvaluationMe) {
		this.failedWhileEvaluationMe = failedWhileEvaluationMe;
	}


	public int getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(int exceptionType) {
		this.exceptionType = exceptionType;
	}



}

package com.netxforge.interpreter;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Christophe Bouhier
 */
public class ObjectContext<T> extends AbstractInterpreterContext {
	
	private T internalObject;
	
	public ObjectContext(T object){
		this.internalObject = object;
	}
	
	public ObjectContext(T object, int kind){
			this.internalObject = object;
			this.contextKind = kind;
	}

	@Override
	public T getContext() {
		return internalObject;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(internalObject instanceof EObject){
			builder.append(((EObject)internalObject).eClass().getName());
		}
		return builder.toString();
	}
}

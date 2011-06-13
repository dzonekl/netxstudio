package com.netxforge.interpreter;

import org.eclipse.emf.ecore.EStructuralFeature;



/**
 * A placeholder for contextual interpretators. 
 * @author dzonekl
 */
public class FeatureContext implements IInterpreterContext {
	
	private EStructuralFeature internalfeature;
	
	public FeatureContext(EStructuralFeature feature){
		this.setFeature(feature);	
	}

	public EStructuralFeature getFeature() {
		return internalfeature;
	}

	public void setFeature(EStructuralFeature feature) {
		this.internalfeature = feature;
	}
	
}

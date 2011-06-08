package com.netxforge.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;

public class CDOScopeProvider extends AbstractGlobalScopeProvider {

	public IScope getScope(EObject context, EReference reference) {
		System.out.println("We are consulted?");
		return IScope.NULLSCOPE;
	}

}

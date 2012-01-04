/*
 * generated by Xtext
 */
package com.netxforge.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.netxforge.netxscript.Mod;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class NetxscriptScopeProvider extends AbstractDeclarativeScopeProvider {
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		System.out.println("SCOPING: looking for scope on " + context + " with reference" + reference);
		return super.getScope(context, reference);
	}

	/*
	 * NetxscriptPackage.Literals.RESOURCE_REF__RESOURCE
	 */
	IScope scope_ResourceRef_resource(Mod mod, EReference ref){
		System.out.println("SCOPING: custom scoping called. ");
		return null;
	}
	
	
}

/*
 * generated by Xtext
 */
package com.netxforge.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import com.netxforge.internal.RuntimeActivator;
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
		
		if(RuntimeActivator.DEBUG){
			RuntimeActivator.TRACE.trace(RuntimeActivator.TRACE_NETXSCRIPT_SCOPING_OPTION, "looking for scope on: " + context.eClass().getName() + " with reference: " + reference.getName());
		}
		
		return super.getScope(context, reference);
	}
	
	IScope scope_OperatorRef_function(final EObject context, EReference reference){
		if(RuntimeActivator.DEBUG){
			RuntimeActivator.TRACE.trace(RuntimeActivator.TRACE_NETXSCRIPT_SCOPING_OPTION, "custom scoping called, for scope_OperatorRef_function");
		}
		return null;
	}
	
	
	/*
	 * We need the current interpreter context, to narrow down the scope. 
	 * NetxscriptPackage.Literals.RESOURCE_REF__RESOURCE
	 */
	IScope scope_ResourceRef_resource(final EObject context, EReference reference){
		
		if( context instanceof Mod){
			((Mod)context).getStatements();
		}
		
		if(RuntimeActivator.DEBUG){
			RuntimeActivator.TRACE.trace(RuntimeActivator.TRACE_NETXSCRIPT_SCOPING_OPTION, "custom scoping called for scope_ResourceRef_resource");
		}
		return null;
	}
	
	
}
package com.netxforge.netxstudio.models.export;

import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.expression.Variable;


/**
 * Clients should implement this interface to customize the context of an XPand transformation. 
 * Also clients should extend a basic convenience implementation named <code>XpandTemplateImpl</code>
 * @see com.netxforge.netxstudio.m2t.XPandTemplateImpl 
 * @author Christophe Bouhier
 */
public interface XpandTemplate {

	/**
	 * Get the template description.
	 * 
	 * @return
	 */
	public abstract String getTemplateDescription();

	/**
	 * Return the template call parameter.
	 * 
	 * @return
	 */
	public abstract String getTemplateCall();

	/**
	 * Our templates
	 * 
	 * @return
	 */
	public abstract XpandEmfRegistryMetaModels getEmfMetaModels();

	/**
	 * A Map of global variables.
	 * 
	 * @return
	 */
	public abstract Map<String, Variable> getGlobalVarsMap();

	/**
	 * A Map of global variables.
	 * 
	 * @return
	 */
	public abstract void setGlobalVarsMap(Map<String, Variable> map);
	
	/**
	 * Override to implement the actual xpansion. 
	 * We don't specify a target, so this implies that the target is taken 
	 * from the instance itself
	 * 
	 * @param outRes
	 * @param target
	 */
	public abstract void xpand(IResource outRes);

	
	/**
	 * Set the target object.
	 * Use is optional, as the call to the operation <code>xpand()</code> a target object to be passed.
	 * @return
	 */
	public abstract void setTargetObject(Object target);
	

	/**
	 * Returns is the target object, is a predefined MetaModel. 
	 * In contrary a non-Meta target object, needs to be set with <code>setTargetObject(...)</code>
	 * @return
	 */
	public abstract boolean isMetaTarget();
	
	
	/**
	 * Get the expected extension symbolizing the content. 
	 * The emmitter should use to append this extension to a file name. 
	 * @return
	 */
	public abstract String getExtension();
	
	
	
}

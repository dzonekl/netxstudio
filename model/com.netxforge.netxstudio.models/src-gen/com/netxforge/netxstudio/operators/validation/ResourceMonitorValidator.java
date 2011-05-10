/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.operators.validation;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.operators.Marker;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.operators.ResourceMonitor}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ResourceMonitorValidator {
	boolean validate();

	boolean validateMarkers(EList<Marker> value);
}

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.services.validation;

import com.netxforge.netxstudio.library.NetXResource;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.services.ServiceProfile}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ServiceProfileValidator {
	boolean validate();

	boolean validateProfileResources(EList<NetXResource> value);
	boolean validateName(String value);
}

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.protocols.validation;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.protocols.Message;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.protocols.Procedure}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ProcedureValidator {
	boolean validate();

	boolean validateMessages(EList<Message> value);
	boolean validateName(String value);
}

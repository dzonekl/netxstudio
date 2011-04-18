/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.protocols.validation;

import com.netxforge.netxstudio.generics.Company;

import com.netxforge.netxstudio.protocols.OSIType;
import com.netxforge.netxstudio.protocols.Procedure;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.protocols.Protocol}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ProtocolValidator {
	boolean validate();

	boolean validateProcedures(EList<Procedure> value);
	boolean validateBodyRef(Company value);
	boolean validateDescription(String value);
	boolean validateName(String value);
	boolean validateOSI(OSIType value);
	boolean validateSpecification(String value);
}

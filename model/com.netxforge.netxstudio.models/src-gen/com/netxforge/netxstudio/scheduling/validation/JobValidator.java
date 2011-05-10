/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.scheduling.validation;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

import com.netxforge.netxstudio.scheduling.JobKinds;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.scheduling.Job}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface JobValidator {
	boolean validate();

	boolean validateJobExecution(EList<XMLGregorianCalendar> value);
	boolean validateJobKind(JobKinds value);
	boolean validateCurrentlyActive(boolean value);

	boolean validateEnded(XMLGregorianCalendar value);

	boolean validateName(String value);
	boolean validateStarted(XMLGregorianCalendar value);

	boolean validateStart(XMLGregorianCalendar value);
}

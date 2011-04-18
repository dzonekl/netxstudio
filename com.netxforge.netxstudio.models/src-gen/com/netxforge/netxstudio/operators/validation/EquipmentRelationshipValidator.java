/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.operators.validation;

import com.netxforge.netxstudio.library.Equipment;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.operators.EquipmentRelationship}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EquipmentRelationshipValidator {
	boolean validate();

	boolean validateEquipment1Ref(Equipment value);
	boolean validateEquipment2Ref(Equipment value);
}

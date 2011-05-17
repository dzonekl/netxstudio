/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.library.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.EquipmentGroup;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.services.ServiceProfile;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.library.Expression}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ExpressionValidator {
	boolean validate();

	boolean validateExpressionLines(EList<String> value);
	boolean validateEvaluationObject(EObject value);

	boolean validateEquipmentRefs(EList<Equipment> value);
	boolean validateFunctionRefs(EList<Function> value);
	boolean validateEquipmentGroupRefs(EList<EquipmentGroup> value);
	boolean validateServiceProfileRefs(EList<ServiceProfile> value);
	boolean validateName(String value);
}

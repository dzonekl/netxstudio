/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.operators.validation;

import com.netxforge.netxstudio.operators.Node;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.operators.Warehouse}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface WarehouseValidator {
	boolean validate();

	boolean validateNodes(EList<Node> value);
	boolean validateEquipments(EList<String> value);
	boolean validateDescription(String value);
	boolean validateName(String value);
}

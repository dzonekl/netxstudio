/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.mwe.core.container;

public class IfComponent extends ConditionalComponent {

	public IfComponent() {
		super("if");
	}

	private String condition = null;

	/**
	 * Sets the condition.
	 * 
	 * @param condition
	 *            the condition
	 */
	public void setCond(final String condition) {
		this.condition = condition;
	}

	/**
	 * @see org.eclipse.emf.mwe.core.container.WorkflowConditional#evaluate()
	 */
	public boolean evaluate() {
		return Boolean.valueOf(condition).booleanValue();
	}

	/**
	 * @see org.eclipse.emf.mwe.core.container.CompositeComponent#getLogMessage()
	 */
	@Override
	public String getLogMessage() {
		return "if ( " + condition + " ): " + evaluate();
	}
}

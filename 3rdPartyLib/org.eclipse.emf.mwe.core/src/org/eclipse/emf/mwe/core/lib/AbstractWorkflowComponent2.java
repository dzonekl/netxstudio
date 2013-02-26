/*******************************************************************************
 * Copyright (c) 2005, 2007 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.mwe.core.lib;

import org.eclipse.emf.mwe.core.issues.Issues;

public abstract class AbstractWorkflowComponent2 extends AbstractWorkflowComponent {

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	public final void checkConfiguration(final Issues issues) {
		checkConfigurationInternal(issues);
	}
	
	protected void checkConfigurationInternal(Issues issues) {}

}

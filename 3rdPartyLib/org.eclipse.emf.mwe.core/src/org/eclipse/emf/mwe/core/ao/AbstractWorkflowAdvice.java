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
package org.eclipse.emf.mwe.core.ao;

import java.util.List;

import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

public abstract class AbstractWorkflowAdvice extends AbstractWorkflowComponent {

	private String target;

	@Override
	public final void invokeInternal(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
	}

	/**
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	public void checkConfiguration(Issues issues) {
	}

	/**
	 * Sets the target of the advice.
	 * 
	 * @param adviceTarget
	 *            the advice target
	 */
	public void setAdviceTarget(String adviceTarget) {
		this.target = adviceTarget;
	}

	/**
	 * Returns the advice target.
	 * 
	 * @return the advice target
	 */
	public String getAdviceTarget() {
		return target;
	}

	/**
	 * Weaves the advices into the specified <code>component</code>.
	 * 
	 * @param component
	 *            the component
	 * @param issues
	 *            facility for reporting possible issues during weaving.
	 */
	public abstract void weave(WorkflowComponent c, Issues issues);

	protected String buildList(List<String> list) {
		StringBuilder b = new StringBuilder();
		boolean firstTime = true;
		for (String s : list) {
			if (!firstTime) {
				b.append(", ");
			}
			b.append(s);
			firstTime = false;
		}
		return b.toString();
	}

}

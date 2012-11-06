/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.projectedEditing;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ProjectionAwareProposalAcceptor implements ICompletionProposalAcceptor {
	private final ICompletionProposalAcceptor acceptor;
	private final IProjectedContent evaluatedTemplate;

	public ProjectionAwareProposalAcceptor(ICompletionProposalAcceptor acceptor, IProjectedContent projectionData) {
		this.acceptor = acceptor;
		this.evaluatedTemplate = projectionData;
	}

	public void accept(ICompletionProposal proposal) {
		if (proposal != null) {
			ConfigurableCompletionProposal configurableProposal = 
				(ConfigurableCompletionProposal) proposal;
			configurableProposal.setSelectionStart(evaluatedTemplate.getOriginalOffset(configurableProposal.getSelectionStart()));
			configurableProposal.setReplacementOffset(evaluatedTemplate.getOriginalOffset(configurableProposal.getReplacementOffset()));
			acceptor.accept(proposal);
		}
	}

	public boolean canAcceptMoreProposals() {
		return acceptor.canAcceptMoreProposals();
	}
}
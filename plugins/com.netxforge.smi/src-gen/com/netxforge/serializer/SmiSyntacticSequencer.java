package com.netxforge.serializer;

import com.google.inject.Inject;
import com.netxforge.services.SmiGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SmiSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SmiGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1;
	protected AbstractElementAlias match_Module_CRNLTerminalRuleCall_1_1_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SmiGrammarAccess) access;
		match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()));
		match_Module_CRNLTerminalRuleCall_1_1_a = new TokenAlias(true, true, grammarAccess.getModuleAccess().getCRNLTerminalRuleCall_1_1());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getCRNLRule())
			return getCRNLToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIA5STRINGRule())
			return getIA5STRINGToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal CRNL:
	 * 	('\r' | '\n')+;
	 */
	protected String getCRNLToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\r";
	}
	
	/**
	 * terminal IA5STRING:
	 * 	'"' ('\\' ('b'
	 * 	| 't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\') | !('\\' | '"'))* '"';
	 */
	protected String getIA5STRINGToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1.equals(syntax))
				emit_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Module_CRNLTerminalRuleCall_1_1_a.equals(syntax))
				emit_Module_CRNLTerminalRuleCall_1_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     IA5STRING | 'empty'
	 */
	protected void emit_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     CRNL*
	 */
	protected void emit_Module_CRNLTerminalRuleCall_1_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}

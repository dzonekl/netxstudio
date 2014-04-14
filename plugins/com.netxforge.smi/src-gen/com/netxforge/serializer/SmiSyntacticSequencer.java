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
	protected AbstractElementAlias match_ObjectIdentifierValue_ASN1_IDTerminalRuleCall_0_1_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SmiGrammarAccess) access;
		match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()));
		match_ObjectIdentifierValue_ASN1_IDTerminalRuleCall_0_1_q = new TokenAlias(false, true, grammarAccess.getObjectIdentifierValueAccess().getASN1_IDTerminalRuleCall_0_1());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getASN1_IDRule())
			return getASN1_IDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getIA5STRINGRule())
			return getIA5STRINGToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ASN1_ID:
	 * 	(ALPHA) (ALPHA | ALPHA_CAP | '-' | NUMERIC)*;
	 */
	protected String getASN1_IDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
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
			else if(match_ObjectIdentifierValue_ASN1_IDTerminalRuleCall_0_1_q.equals(syntax))
				emit_ObjectIdentifierValue_ASN1_IDTerminalRuleCall_0_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     ASN1_ID?
	 */
	protected void emit_ObjectIdentifierValue_ASN1_IDTerminalRuleCall_0_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}

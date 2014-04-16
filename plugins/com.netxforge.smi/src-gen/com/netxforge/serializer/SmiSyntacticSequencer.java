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
	protected AbstractElementAlias match_Macro_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_Macro_NEWLINETerminalRuleCall_10_p;
	protected AbstractElementAlias match_Macro_NEWLINETerminalRuleCall_13_q;
	protected AbstractElementAlias match_Macro_NEWLINETerminalRuleCall_16_p;
	protected AbstractElementAlias match_Macro_NEWLINETerminalRuleCall_6_p;
	protected AbstractElementAlias match_Module_NEWLINETerminalRuleCall_8_a;
	protected AbstractElementAlias match_ObjectIdentifier_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_TypeAssignment_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_TypeDefinition_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_Value_NEWLINETerminalRuleCall_0_q;
	protected AbstractElementAlias match_Value_NEWLINETerminalRuleCall_2_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SmiGrammarAccess) access;
		match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()));
		match_Macro_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0());
		match_Macro_NEWLINETerminalRuleCall_10_p = new TokenAlias(true, false, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_10());
		match_Macro_NEWLINETerminalRuleCall_13_q = new TokenAlias(false, true, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_13());
		match_Macro_NEWLINETerminalRuleCall_16_p = new TokenAlias(true, false, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_16());
		match_Macro_NEWLINETerminalRuleCall_6_p = new TokenAlias(true, false, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_6());
		match_Module_NEWLINETerminalRuleCall_8_a = new TokenAlias(true, true, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_8());
		match_ObjectIdentifier_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0());
		match_TypeAssignment_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0());
		match_TypeDefinition_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0());
		match_Value_NEWLINETerminalRuleCall_0_q = new TokenAlias(false, true, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_0());
		match_Value_NEWLINETerminalRuleCall_2_0_q = new TokenAlias(false, true, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_2_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getIA5STRINGRule())
			return getIA5STRINGToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNEWLINERule())
			return getNEWLINEToken(semanticObject, ruleCall, node);
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
	
	/**
	 * terminal NEWLINE:
	 * 	'\r'? | '\n';
	 */
	protected String getNEWLINEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1.equals(syntax))
				emit_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Macro_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_Macro_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Macro_NEWLINETerminalRuleCall_10_p.equals(syntax))
				emit_Macro_NEWLINETerminalRuleCall_10_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Macro_NEWLINETerminalRuleCall_13_q.equals(syntax))
				emit_Macro_NEWLINETerminalRuleCall_13_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Macro_NEWLINETerminalRuleCall_16_p.equals(syntax))
				emit_Macro_NEWLINETerminalRuleCall_16_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Macro_NEWLINETerminalRuleCall_6_p.equals(syntax))
				emit_Macro_NEWLINETerminalRuleCall_6_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Module_NEWLINETerminalRuleCall_8_a.equals(syntax))
				emit_Module_NEWLINETerminalRuleCall_8_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ObjectIdentifier_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_ObjectIdentifier_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypeAssignment_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_TypeAssignment_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypeDefinition_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_TypeDefinition_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Value_NEWLINETerminalRuleCall_0_q.equals(syntax))
				emit_Value_NEWLINETerminalRuleCall_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Value_NEWLINETerminalRuleCall_2_0_q.equals(syntax))
				emit_Value_NEWLINETerminalRuleCall_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
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
	 *     NEWLINE+
	 */
	protected void emit_Macro_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_Macro_NEWLINETerminalRuleCall_10_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE?
	 */
	protected void emit_Macro_NEWLINETerminalRuleCall_13_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_Macro_NEWLINETerminalRuleCall_16_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_Macro_NEWLINETerminalRuleCall_6_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE*
	 */
	protected void emit_Module_NEWLINETerminalRuleCall_8_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_ObjectIdentifier_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_TypeAssignment_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_TypeDefinition_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE?
	 */
	protected void emit_Value_NEWLINETerminalRuleCall_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE?
	 */
	protected void emit_Value_NEWLINETerminalRuleCall_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}

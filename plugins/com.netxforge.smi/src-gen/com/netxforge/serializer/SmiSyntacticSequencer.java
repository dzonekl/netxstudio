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
	protected AbstractElementAlias match_ASN1_CHOICE_ENTRY_NEWLINETerminalRuleCall_1_q;
	protected AbstractElementAlias match_ASN1_CHOICE_NEWLINETerminalRuleCall_2_p;
	protected AbstractElementAlias match_ASN1_CHOICE_NEWLINETerminalRuleCall_4_1_p;
	protected AbstractElementAlias match_ASN1_CHOICE_NEWLINETerminalRuleCall_5_p;
	protected AbstractElementAlias match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1;
	protected AbstractElementAlias match_AttributeValue_NEWLINETerminalRuleCall_0_q;
	protected AbstractElementAlias match_Attribute_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_a;
	protected AbstractElementAlias match_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_p;
	protected AbstractElementAlias match_ImportRefs_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_Imports_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_Macro_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_Macro_NEWLINETerminalRuleCall_4_p;
	protected AbstractElementAlias match_Macro_NEWLINETerminalRuleCall_9_p;
	protected AbstractElementAlias match_Module_NEWLINETerminalRuleCall_6_p;
	protected AbstractElementAlias match_Module_NEWLINETerminalRuleCall_8_a;
	protected AbstractElementAlias match_ObjectIdentifier_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_Object_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_Object_NEWLINETerminalRuleCall_4_p;
	protected AbstractElementAlias match_Tag_NEWLINETerminalRuleCall_0_q;
	protected AbstractElementAlias match_TypeAssignment_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_TypeDefinition_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_TypeNotation_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_ValueAssignment_NEWLINETerminalRuleCall_0_q;
	protected AbstractElementAlias match_ValueNotation_NEWLINETerminalRuleCall_0_p;
	protected AbstractElementAlias match_Value_NEWLINETerminalRuleCall_1_a;
	protected AbstractElementAlias match_Value_NEWLINETerminalRuleCall_4_0_a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SmiGrammarAccess) access;
		match_ASN1_CHOICE_ENTRY_NEWLINETerminalRuleCall_1_q = new TokenAlias(false, true, grammarAccess.getASN1_CHOICE_ENTRYAccess().getNEWLINETerminalRuleCall_1());
		match_ASN1_CHOICE_NEWLINETerminalRuleCall_2_p = new TokenAlias(true, false, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_2());
		match_ASN1_CHOICE_NEWLINETerminalRuleCall_4_1_p = new TokenAlias(true, false, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_4_1());
		match_ASN1_CHOICE_NEWLINETerminalRuleCall_5_p = new TokenAlias(true, false, grammarAccess.getASN1_CHOICEAccess().getNEWLINETerminalRuleCall_5());
		match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getASN1_SIMPLEAccess().getEmptyKeyword_0_1()), new TokenAlias(false, false, grammarAccess.getASN1_SIMPLEAccess().getIA5STRINGTerminalRuleCall_1_1()));
		match_AttributeValue_NEWLINETerminalRuleCall_0_q = new TokenAlias(false, true, grammarAccess.getAttributeValueAccess().getNEWLINETerminalRuleCall_0());
		match_Attribute_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getAttributeAccess().getNEWLINETerminalRuleCall_0());
		match_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_a = new TokenAlias(true, true, grammarAccess.getBracedTypeReferenceAccess().getQuotationMarkLeftCurlyBracketQuotationMarkKeyword_0());
		match_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_p = new TokenAlias(true, false, grammarAccess.getBracedTypeReferenceAccess().getQuotationMarkLeftCurlyBracketQuotationMarkKeyword_0());
		match_ImportRefs_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getImportRefsAccess().getNEWLINETerminalRuleCall_0());
		match_Imports_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getImportsAccess().getNEWLINETerminalRuleCall_0());
		match_Macro_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_0());
		match_Macro_NEWLINETerminalRuleCall_4_p = new TokenAlias(true, false, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_4());
		match_Macro_NEWLINETerminalRuleCall_9_p = new TokenAlias(true, false, grammarAccess.getMacroAccess().getNEWLINETerminalRuleCall_9());
		match_Module_NEWLINETerminalRuleCall_6_p = new TokenAlias(true, false, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_6());
		match_Module_NEWLINETerminalRuleCall_8_a = new TokenAlias(true, true, grammarAccess.getModuleAccess().getNEWLINETerminalRuleCall_8());
		match_ObjectIdentifier_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getObjectIdentifierAccess().getNEWLINETerminalRuleCall_0());
		match_Object_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getObjectAccess().getNEWLINETerminalRuleCall_0());
		match_Object_NEWLINETerminalRuleCall_4_p = new TokenAlias(true, false, grammarAccess.getObjectAccess().getNEWLINETerminalRuleCall_4());
		match_Tag_NEWLINETerminalRuleCall_0_q = new TokenAlias(false, true, grammarAccess.getTagAccess().getNEWLINETerminalRuleCall_0());
		match_TypeAssignment_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getTypeAssignmentAccess().getNEWLINETerminalRuleCall_0());
		match_TypeDefinition_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getTypeDefinitionAccess().getNEWLINETerminalRuleCall_0());
		match_TypeNotation_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getTypeNotationAccess().getNEWLINETerminalRuleCall_0());
		match_ValueAssignment_NEWLINETerminalRuleCall_0_q = new TokenAlias(false, true, grammarAccess.getValueAssignmentAccess().getNEWLINETerminalRuleCall_0());
		match_ValueNotation_NEWLINETerminalRuleCall_0_p = new TokenAlias(true, false, grammarAccess.getValueNotationAccess().getNEWLINETerminalRuleCall_0());
		match_Value_NEWLINETerminalRuleCall_1_a = new TokenAlias(true, true, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_1());
		match_Value_NEWLINETerminalRuleCall_4_0_a = new TokenAlias(true, true, grammarAccess.getValueAccess().getNEWLINETerminalRuleCall_4_0());
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
	 * 	'"' ('\\' ('b' |
	 * 	't' | 'n' | 'f' | 'r' | 'u' | '"' | "'" | '\\') | !('\\' | '"'))* '"';
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
			if(match_ASN1_CHOICE_ENTRY_NEWLINETerminalRuleCall_1_q.equals(syntax))
				emit_ASN1_CHOICE_ENTRY_NEWLINETerminalRuleCall_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ASN1_CHOICE_NEWLINETerminalRuleCall_2_p.equals(syntax))
				emit_ASN1_CHOICE_NEWLINETerminalRuleCall_2_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ASN1_CHOICE_NEWLINETerminalRuleCall_4_1_p.equals(syntax))
				emit_ASN1_CHOICE_NEWLINETerminalRuleCall_4_1_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ASN1_CHOICE_NEWLINETerminalRuleCall_5_p.equals(syntax))
				emit_ASN1_CHOICE_NEWLINETerminalRuleCall_5_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1.equals(syntax))
				emit_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AttributeValue_NEWLINETerminalRuleCall_0_q.equals(syntax))
				emit_AttributeValue_NEWLINETerminalRuleCall_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Attribute_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_Attribute_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_a.equals(syntax))
				emit_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_p.equals(syntax))
				emit_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ImportRefs_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_ImportRefs_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Imports_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_Imports_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Macro_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_Macro_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Macro_NEWLINETerminalRuleCall_4_p.equals(syntax))
				emit_Macro_NEWLINETerminalRuleCall_4_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Macro_NEWLINETerminalRuleCall_9_p.equals(syntax))
				emit_Macro_NEWLINETerminalRuleCall_9_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Module_NEWLINETerminalRuleCall_6_p.equals(syntax))
				emit_Module_NEWLINETerminalRuleCall_6_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Module_NEWLINETerminalRuleCall_8_a.equals(syntax))
				emit_Module_NEWLINETerminalRuleCall_8_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ObjectIdentifier_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_ObjectIdentifier_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Object_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_Object_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Object_NEWLINETerminalRuleCall_4_p.equals(syntax))
				emit_Object_NEWLINETerminalRuleCall_4_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Tag_NEWLINETerminalRuleCall_0_q.equals(syntax))
				emit_Tag_NEWLINETerminalRuleCall_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypeAssignment_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_TypeAssignment_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypeDefinition_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_TypeDefinition_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TypeNotation_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_TypeNotation_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ValueAssignment_NEWLINETerminalRuleCall_0_q.equals(syntax))
				emit_ValueAssignment_NEWLINETerminalRuleCall_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ValueNotation_NEWLINETerminalRuleCall_0_p.equals(syntax))
				emit_ValueNotation_NEWLINETerminalRuleCall_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Value_NEWLINETerminalRuleCall_1_a.equals(syntax))
				emit_Value_NEWLINETerminalRuleCall_1_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Value_NEWLINETerminalRuleCall_4_0_a.equals(syntax))
				emit_Value_NEWLINETerminalRuleCall_4_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     NEWLINE?
	 */
	protected void emit_ASN1_CHOICE_ENTRY_NEWLINETerminalRuleCall_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_ASN1_CHOICE_NEWLINETerminalRuleCall_2_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_ASN1_CHOICE_NEWLINETerminalRuleCall_4_1_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_ASN1_CHOICE_NEWLINETerminalRuleCall_5_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'empty' | IA5STRING
	 */
	protected void emit_ASN1_SIMPLE_EmptyKeyword_0_1_or_IA5STRINGTerminalRuleCall_1_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE?
	 */
	protected void emit_AttributeValue_NEWLINETerminalRuleCall_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_Attribute_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '"{"'*
	 */
	protected void emit_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '"{"'+
	 */
	protected void emit_BracedTypeReference_QuotationMarkLeftCurlyBracketQuotationMarkKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_ImportRefs_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_Imports_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	protected void emit_Macro_NEWLINETerminalRuleCall_4_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_Macro_NEWLINETerminalRuleCall_9_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_Module_NEWLINETerminalRuleCall_6_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	protected void emit_Object_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_Object_NEWLINETerminalRuleCall_4_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE?
	 */
	protected void emit_Tag_NEWLINETerminalRuleCall_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     NEWLINE+
	 */
	protected void emit_TypeNotation_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE?
	 */
	protected void emit_ValueAssignment_NEWLINETerminalRuleCall_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE+
	 */
	protected void emit_ValueNotation_NEWLINETerminalRuleCall_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE*
	 */
	protected void emit_Value_NEWLINETerminalRuleCall_1_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     NEWLINE*
	 */
	protected void emit_Value_NEWLINETerminalRuleCall_4_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}

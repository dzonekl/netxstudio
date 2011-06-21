package com.netxforge.serializer;

import com.google.inject.Inject;
import com.netxforge.services.NetxscriptGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractNetxscriptSyntacticSequencer extends AbstractSyntacticSequencer {

	protected NetxscriptGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Literal_ParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_1_1_RightParenthesisKeyword_2_p;
	protected AbstractElementAlias match_ParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedExpression_LeftParenthesisKeyword_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (NetxscriptGrammarAccess) access;
		match_Literal_ParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_1_1_RightParenthesisKeyword_2_p = new GroupAlias(false, false, new TokenAlias(false, true, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0()), new TokenAlias(false, false, grammarAccess.getLiteralAccess().getFalseKeyword_1_1_1()), new TokenAlias(false, true, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2()));
		match_ParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(false, true, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.isSyntacticallyAmbiguous())
			return;
		if(match_Literal_ParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_1_1_RightParenthesisKeyword_2_p.equals(transition.getAmbiguousSyntax()))
			emit_Literal_ParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_1_1_RightParenthesisKeyword_2_p(semanticObject, transition, fromNode, toNode);
		else if(match_ParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(transition.getAmbiguousSyntax()))
			emit_ParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, transition, fromNode, toNode);
		else if(match_ParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(transition.getAmbiguousSyntax()))
			emit_ParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, transition, fromNode, toNode);
		else acceptNodes(transition, fromNode, toNode);
	}

	/**
	 * Syntax:
	 *     '('+ 'false' ')'+
	 */
	protected void emit_Literal_ParenthesizedExpression_LeftParenthesisKeyword_0_p_FalseKeyword_1_1_1_RightParenthesisKeyword_2_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_ParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_ParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		acceptNodes(transition, fromNode, toNode);
	}
	
}

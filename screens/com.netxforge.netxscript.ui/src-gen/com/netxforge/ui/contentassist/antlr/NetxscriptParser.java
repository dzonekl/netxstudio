/*
* generated by Xtext
*/
package com.netxforge.ui.contentassist.antlr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;
import com.netxforge.services.NetxscriptGrammarAccess;

public class NetxscriptParser extends AbstractContentAssistParser {
	
	@Inject
	private NetxscriptGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected com.netxforge.ui.contentassist.antlr.internal.InternalNetxscriptParser createParser() {
		com.netxforge.ui.contentassist.antlr.internal.InternalNetxscriptParser result = new com.netxforge.ui.contentassist.antlr.internal.InternalNetxscriptParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getModAccess().getAlternatives_2(), "rule__Mod__Alternatives_2");
					put(grammarAccess.getAbstractVarOrArgumentAccess().getAlternatives(), "rule__AbstractVarOrArgument__Alternatives");
					put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
					put(grammarAccess.getStatementAccess().getAlternatives_0_0(), "rule__Statement__Alternatives_0_0");
					put(grammarAccess.getReferenceAssignmentStatementAccess().getAssignmentRefAlternatives_1_0(), "rule__ReferenceAssignmentStatement__AssignmentRefAlternatives_1_0");
					put(grammarAccess.getLogicalAccess().getAlternatives_1_0(), "rule__Logical__Alternatives_1_0");
					put(grammarAccess.getEqualityAccess().getAlternatives_1_0(), "rule__Equality__Alternatives_1_0");
					put(grammarAccess.getComparisonAccess().getAlternatives_1_0(), "rule__Comparison__Alternatives_1_0");
					put(grammarAccess.getAdditionAccess().getAlternatives_1_0(), "rule__Addition__Alternatives_1_0");
					put(grammarAccess.getMultiplicationAccess().getAlternatives_1_0(), "rule__Multiplication__Alternatives_1_0");
					put(grammarAccess.getUnaryAccess().getAlternatives(), "rule__Unary__Alternatives");
					put(grammarAccess.getUnaryAccess().getAlternatives_1_0(), "rule__Unary__Alternatives_1_0");
					put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives(), "rule__PrimaryExpression__Alternatives");
					put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
					put(grammarAccess.getLiteralAccess().getAlternatives_1_1(), "rule__Literal__Alternatives_1_1");
					put(grammarAccess.getReferenceAccess().getAlternatives(), "rule__Reference__Alternatives");
					put(grammarAccess.getContextRefAccess().getAlternatives_2(), "rule__ContextRef__Alternatives_2");
					put(grammarAccess.getNavigationAccess().getAlternatives_2(), "rule__Navigation__Alternatives_2");
					put(grammarAccess.getLeafReferenceAccess().getAlternatives(), "rule__LeafReference__Alternatives");
					put(grammarAccess.getIntervalAccess().getAlternatives(), "rule__Interval__Alternatives");
					put(grammarAccess.getSPACED_IDAccess().getAlternatives_0(), "rule__SPACED_ID__Alternatives_0");
					put(grammarAccess.getSPACED_IDAccess().getAlternatives_1(), "rule__SPACED_ID__Alternatives_1");
					put(grammarAccess.getNativeFunctionAccess().getAlternatives(), "rule__NativeFunction__Alternatives");
					put(grammarAccess.getIntervalKindAccess().getAlternatives(), "rule__IntervalKind__Alternatives");
					put(grammarAccess.getToleranceLevelAccess().getAlternatives(), "rule__ToleranceLevel__Alternatives");
					put(grammarAccess.getValueRangeAccess().getAlternatives(), "rule__ValueRange__Alternatives");
					put(grammarAccess.getValueKindAccess().getAlternatives(), "rule__ValueKind__Alternatives");
					put(grammarAccess.getModAccess().getGroup(), "rule__Mod__Group__0");
					put(grammarAccess.getModAccess().getGroup_0(), "rule__Mod__Group_0__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getFunctionAccess().getGroup(), "rule__Function__Group__0");
					put(grammarAccess.getFunctionAccess().getGroup_3(), "rule__Function__Group_3__0");
					put(grammarAccess.getFunctionAccess().getGroup_3_1(), "rule__Function__Group_3_1__0");
					put(grammarAccess.getBlockAccess().getGroup(), "rule__Block__Group__0");
					put(grammarAccess.getStatementAccess().getGroup_0(), "rule__Statement__Group_0__0");
					put(grammarAccess.getReturnStatementAccess().getGroup(), "rule__ReturnStatement__Group__0");
					put(grammarAccess.getIfStatementAccess().getGroup(), "rule__IfStatement__Group__0");
					put(grammarAccess.getIfStatementAccess().getGroup_6(), "rule__IfStatement__Group_6__0");
					put(grammarAccess.getWhileStatementAccess().getGroup(), "rule__WhileStatement__Group__0");
					put(grammarAccess.getVariableStatementAccess().getGroup(), "rule__VariableStatement__Group__0");
					put(grammarAccess.getVariableStatementAccess().getGroup_3(), "rule__VariableStatement__Group_3__0");
					put(grammarAccess.getAssignmentStatementAccess().getGroup(), "rule__AssignmentStatement__Group__0");
					put(grammarAccess.getPlusAssignmentStatementAccess().getGroup(), "rule__PlusAssignmentStatement__Group__0");
					put(grammarAccess.getReferenceAssignmentStatementAccess().getGroup(), "rule__ReferenceAssignmentStatement__Group__0");
					put(grammarAccess.getLogicalAccess().getGroup(), "rule__Logical__Group__0");
					put(grammarAccess.getLogicalAccess().getGroup_1(), "rule__Logical__Group_1__0");
					put(grammarAccess.getLogicalAccess().getGroup_1_0_0(), "rule__Logical__Group_1_0_0__0");
					put(grammarAccess.getLogicalAccess().getGroup_1_0_1(), "rule__Logical__Group_1_0_1__0");
					put(grammarAccess.getEqualityAccess().getGroup(), "rule__Equality__Group__0");
					put(grammarAccess.getEqualityAccess().getGroup_1(), "rule__Equality__Group_1__0");
					put(grammarAccess.getEqualityAccess().getGroup_1_0_0(), "rule__Equality__Group_1_0_0__0");
					put(grammarAccess.getEqualityAccess().getGroup_1_0_1(), "rule__Equality__Group_1_0_1__0");
					put(grammarAccess.getComparisonAccess().getGroup(), "rule__Comparison__Group__0");
					put(grammarAccess.getComparisonAccess().getGroup_1(), "rule__Comparison__Group_1__0");
					put(grammarAccess.getComparisonAccess().getGroup_1_0_0(), "rule__Comparison__Group_1_0_0__0");
					put(grammarAccess.getComparisonAccess().getGroup_1_0_1(), "rule__Comparison__Group_1_0_1__0");
					put(grammarAccess.getComparisonAccess().getGroup_1_0_2(), "rule__Comparison__Group_1_0_2__0");
					put(grammarAccess.getComparisonAccess().getGroup_1_0_3(), "rule__Comparison__Group_1_0_3__0");
					put(grammarAccess.getAdditionAccess().getGroup(), "rule__Addition__Group__0");
					put(grammarAccess.getAdditionAccess().getGroup_1(), "rule__Addition__Group_1__0");
					put(grammarAccess.getAdditionAccess().getGroup_1_0_0(), "rule__Addition__Group_1_0_0__0");
					put(grammarAccess.getAdditionAccess().getGroup_1_0_1(), "rule__Addition__Group_1_0_1__0");
					put(grammarAccess.getMultiplicationAccess().getGroup(), "rule__Multiplication__Group__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1(), "rule__Multiplication__Group_1__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1_0_0(), "rule__Multiplication__Group_1_0_0__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1_0_1(), "rule__Multiplication__Group_1_0_1__0");
					put(grammarAccess.getMultiplicationAccess().getGroup_1_0_2(), "rule__Multiplication__Group_1_0_2__0");
					put(grammarAccess.getUnaryAccess().getGroup_1(), "rule__Unary__Group_1__0");
					put(grammarAccess.getUnaryAccess().getGroup_1_0_0(), "rule__Unary__Group_1_0_0__0");
					put(grammarAccess.getUnaryAccess().getGroup_1_0_1(), "rule__Unary__Group_1_0_1__0");
					put(grammarAccess.getNativeExpressionAccess().getGroup(), "rule__NativeExpression__Group__0");
					put(grammarAccess.getNativeExpressionAccess().getGroup_1(), "rule__NativeExpression__Group_1__0");
					put(grammarAccess.getLiteralAccess().getGroup_1(), "rule__Literal__Group_1__0");
					put(grammarAccess.getNumberLiteralAccess().getGroup(), "rule__NumberLiteral__Group__0");
					put(grammarAccess.getRangeLiteralAccess().getGroup(), "rule__RangeLiteral__Group__0");
					put(grammarAccess.getRangeLiteralAccess().getGroup_2(), "rule__RangeLiteral__Group_2__0");
					put(grammarAccess.getRangeLiteralAccess().getGroup_2_1(), "rule__RangeLiteral__Group_2_1__0");
					put(grammarAccess.getFunctionCallAccess().getGroup(), "rule__FunctionCall__Group__0");
					put(grammarAccess.getFunctionCallAccess().getGroup_3(), "rule__FunctionCall__Group_3__0");
					put(grammarAccess.getFunctionCallAccess().getGroup_3_1(), "rule__FunctionCall__Group_3_1__0");
					put(grammarAccess.getIndexedCallAccess().getGroup(), "rule__IndexedCall__Group__0");
					put(grammarAccess.getIndexedCallAccess().getGroup_1(), "rule__IndexedCall__Group_1__0");
					put(grammarAccess.getVarOrArgumentCallAccess().getGroup(), "rule__VarOrArgumentCall__Group__0");
					put(grammarAccess.getParenthesizedExpressionAccess().getGroup(), "rule__ParenthesizedExpression__Group__0");
					put(grammarAccess.getParamRefAccess().getGroup(), "rule__ParamRef__Group__0");
					put(grammarAccess.getNodeTypeRefAccess().getGroup(), "rule__NodeTypeRef__Group__0");
					put(grammarAccess.getNodeRefAccess().getGroup(), "rule__NodeRef__Group__0");
					put(grammarAccess.getContextRefAccess().getGroup(), "rule__ContextRef__Group__0");
					put(grammarAccess.getPrimaryRefAccess().getGroup(), "rule__PrimaryRef__Group__0");
					put(grammarAccess.getPrimaryRefAccess().getGroup_2(), "rule__PrimaryRef__Group_2__0");
					put(grammarAccess.getNavigationAccess().getGroup(), "rule__Navigation__Group__0");
					put(grammarAccess.getNavigationAccess().getGroup_2_0(), "rule__Navigation__Group_2_0__0");
					put(grammarAccess.getNavigationAccess().getGroup_2_1(), "rule__Navigation__Group_2_1__0");
					put(grammarAccess.getResourceRefAccess().getGroup(), "rule__ResourceRef__Group__0");
					put(grammarAccess.getStatusRefAccess().getGroup(), "rule__StatusRef__Group__0");
					put(grammarAccess.getRangeRefAccess().getGroup(), "rule__RangeRef__Group__0");
					put(grammarAccess.getLinkRefAccess().getGroup(), "rule__LinkRef__Group__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getSPACED_IDAccess().getGroup(), "rule__SPACED_ID__Group__0");
					put(grammarAccess.getModAccess().getNameAssignment_0_1(), "rule__Mod__NameAssignment_0_1");
					put(grammarAccess.getModAccess().getImportsAssignment_1(), "rule__Mod__ImportsAssignment_1");
					put(grammarAccess.getModAccess().getFunctionsAssignment_2_0(), "rule__Mod__FunctionsAssignment_2_0");
					put(grammarAccess.getModAccess().getStatementsAssignment_2_1(), "rule__Mod__StatementsAssignment_2_1");
					put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
					put(grammarAccess.getFunctionAccess().getNameAssignment_1(), "rule__Function__NameAssignment_1");
					put(grammarAccess.getFunctionAccess().getArgsAssignment_3_0(), "rule__Function__ArgsAssignment_3_0");
					put(grammarAccess.getFunctionAccess().getArgsAssignment_3_1_1(), "rule__Function__ArgsAssignment_3_1_1");
					put(grammarAccess.getFunctionAccess().getBlockAssignment_5(), "rule__Function__BlockAssignment_5");
					put(grammarAccess.getArgumentAccess().getNameAssignment(), "rule__Argument__NameAssignment");
					put(grammarAccess.getBlockAccess().getStatementsAssignment_2(), "rule__Block__StatementsAssignment_2");
					put(grammarAccess.getStatementAccess().getExpressionAssignment_0_0_4(), "rule__Statement__ExpressionAssignment_0_0_4");
					put(grammarAccess.getReturnStatementAccess().getExpressionAssignment_2(), "rule__ReturnStatement__ExpressionAssignment_2");
					put(grammarAccess.getIfStatementAccess().getIfAssignment_3(), "rule__IfStatement__IfAssignment_3");
					put(grammarAccess.getIfStatementAccess().getThenAssignment_5(), "rule__IfStatement__ThenAssignment_5");
					put(grammarAccess.getIfStatementAccess().getElseAssignment_6_1(), "rule__IfStatement__ElseAssignment_6_1");
					put(grammarAccess.getWhileStatementAccess().getPredicateAssignment_3(), "rule__WhileStatement__PredicateAssignment_3");
					put(grammarAccess.getWhileStatementAccess().getBodyAssignment_5(), "rule__WhileStatement__BodyAssignment_5");
					put(grammarAccess.getVariableStatementAccess().getNameAssignment_2(), "rule__VariableStatement__NameAssignment_2");
					put(grammarAccess.getVariableStatementAccess().getExpressionAssignment_3_1(), "rule__VariableStatement__ExpressionAssignment_3_1");
					put(grammarAccess.getAssignmentStatementAccess().getVarAssignment_1(), "rule__AssignmentStatement__VarAssignment_1");
					put(grammarAccess.getAssignmentStatementAccess().getExpressionAssignment_3(), "rule__AssignmentStatement__ExpressionAssignment_3");
					put(grammarAccess.getPlusAssignmentStatementAccess().getVarAssignment_1(), "rule__PlusAssignmentStatement__VarAssignment_1");
					put(grammarAccess.getPlusAssignmentStatementAccess().getExpressionAssignment_3(), "rule__PlusAssignmentStatement__ExpressionAssignment_3");
					put(grammarAccess.getReferenceAssignmentStatementAccess().getAssignmentRefAssignment_1(), "rule__ReferenceAssignmentStatement__AssignmentRefAssignment_1");
					put(grammarAccess.getReferenceAssignmentStatementAccess().getExpressionAssignment_3(), "rule__ReferenceAssignmentStatement__ExpressionAssignment_3");
					put(grammarAccess.getLogicalAccess().getRightAssignment_1_1(), "rule__Logical__RightAssignment_1_1");
					put(grammarAccess.getEqualityAccess().getRightAssignment_1_1(), "rule__Equality__RightAssignment_1_1");
					put(grammarAccess.getComparisonAccess().getRightAssignment_1_1(), "rule__Comparison__RightAssignment_1_1");
					put(grammarAccess.getAdditionAccess().getRightAssignment_1_1(), "rule__Addition__RightAssignment_1_1");
					put(grammarAccess.getMultiplicationAccess().getRightAssignment_1_1(), "rule__Multiplication__RightAssignment_1_1");
					put(grammarAccess.getUnaryAccess().getOpAssignment_1_0_0_1(), "rule__Unary__OpAssignment_1_0_0_1");
					put(grammarAccess.getUnaryAccess().getOpAssignment_1_0_1_1(), "rule__Unary__OpAssignment_1_0_1_1");
					put(grammarAccess.getUnaryAccess().getRightAssignment_1_1(), "rule__Unary__RightAssignment_1_1");
					put(grammarAccess.getNativeExpressionAccess().getNativeFunctionAssignment_1_2(), "rule__NativeExpression__NativeFunctionAssignment_1_2");
					put(grammarAccess.getLiteralAccess().getConditionAssignment_1_1_0(), "rule__Literal__ConditionAssignment_1_1_0");
					put(grammarAccess.getNumberLiteralAccess().getValueAssignment_1(), "rule__NumberLiteral__ValueAssignment_1");
					put(grammarAccess.getRangeLiteralAccess().getValuesAssignment_2_0(), "rule__RangeLiteral__ValuesAssignment_2_0");
					put(grammarAccess.getRangeLiteralAccess().getValuesAssignment_2_1_1(), "rule__RangeLiteral__ValuesAssignment_2_1_1");
					put(grammarAccess.getFunctionCallAccess().getFuncAssignment_1(), "rule__FunctionCall__FuncAssignment_1");
					put(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_0(), "rule__FunctionCall__ArgsAssignment_3_0");
					put(grammarAccess.getFunctionCallAccess().getArgsAssignment_3_1_1(), "rule__FunctionCall__ArgsAssignment_3_1_1");
					put(grammarAccess.getIndexedCallAccess().getIndexAssignment_1_1(), "rule__IndexedCall__IndexAssignment_1_1");
					put(grammarAccess.getVarOrArgumentCallAccess().getCallAssignment_1(), "rule__VarOrArgumentCall__CallAssignment_1");
					put(grammarAccess.getParamRefAccess().getParamAssignment_2(), "rule__ParamRef__ParamAssignment_2");
					put(grammarAccess.getNodeTypeRefAccess().getNodetypeAssignment_2(), "rule__NodeTypeRef__NodetypeAssignment_2");
					put(grammarAccess.getNodeTypeRefAccess().getPrimaryRefAssignment_3(), "rule__NodeTypeRef__PrimaryRefAssignment_3");
					put(grammarAccess.getNodeRefAccess().getNodeAssignment_2(), "rule__NodeRef__NodeAssignment_2");
					put(grammarAccess.getNodeRefAccess().getPrimaryRefAssignment_3(), "rule__NodeRef__PrimaryRefAssignment_3");
					put(grammarAccess.getContextRefAccess().getPrimaryRefAssignment_2_0(), "rule__ContextRef__PrimaryRefAssignment_2_0");
					put(grammarAccess.getContextRefAccess().getRangeRefAssignment_2_1(), "rule__ContextRef__RangeRefAssignment_2_1");
					put(grammarAccess.getPrimaryRefAccess().getNavigationAssignment_1(), "rule__PrimaryRef__NavigationAssignment_1");
					put(grammarAccess.getPrimaryRefAccess().getLeafRefAssignment_2_1(), "rule__PrimaryRef__LeafRefAssignment_2_1");
					put(grammarAccess.getNavigationAccess().getFunctionAssignment_2_0_1(), "rule__Navigation__FunctionAssignment_2_0_1");
					put(grammarAccess.getNavigationAccess().getEquipmentAssignment_2_1_1(), "rule__Navigation__EquipmentAssignment_2_1_1");
					put(grammarAccess.getResourceRefAccess().getResourceAssignment_2(), "rule__ResourceRef__ResourceAssignment_2");
					put(grammarAccess.getResourceRefAccess().getAllAssignment_3(), "rule__ResourceRef__AllAssignment_3");
					put(grammarAccess.getResourceRefAccess().getRangeRefAssignment_4(), "rule__ResourceRef__RangeRefAssignment_4");
					put(grammarAccess.getStatusRefAccess().getTolerancelevelAssignment_1(), "rule__StatusRef__TolerancelevelAssignment_1");
					put(grammarAccess.getRangeRefAccess().getValuerangeAssignment_0(), "rule__RangeRef__ValuerangeAssignment_0");
					put(grammarAccess.getRangeRefAccess().getKindAssignment_1(), "rule__RangeRef__KindAssignment_1");
					put(grammarAccess.getRangeRefAccess().getIntervalAssignment_2(), "rule__RangeRef__IntervalAssignment_2");
					put(grammarAccess.getIntervalAccess().getIntervalAssignment_0(), "rule__Interval__IntervalAssignment_0");
					put(grammarAccess.getIntervalAccess().getKindAssignment_1(), "rule__Interval__KindAssignment_1");
					put(grammarAccess.getLinkRefAccess().getLinkAssignment_2(), "rule__LinkRef__LinkAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			com.netxforge.ui.contentassist.antlr.internal.InternalNetxscriptParser typedParser = (com.netxforge.ui.contentassist.antlr.internal.InternalNetxscriptParser) parser;
			typedParser.entryRuleMod();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public NetxscriptGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(NetxscriptGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

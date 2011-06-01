/*
* generated by Xtext
*/
grammar InternalNetxscript;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package com.netxforge.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package com.netxforge.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.netxforge.services.NetxscriptGrammarAccess;

}

@parser::members {

 	private NetxscriptGrammarAccess grammarAccess;
 	
    public InternalNetxscriptParser(TokenStream input, NetxscriptGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Mod";	
   	}
   	
   	@Override
   	protected NetxscriptGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleMod
entryRuleMod returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getModRule()); }
	 iv_ruleMod=ruleMod 
	 { $current=$iv_ruleMod.current; } 
	 EOF 
;

// Rule Mod
ruleMod returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='mod' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getModAccess().getModKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getModAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getModRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getModAccess().getImportsImportParserRuleCall_2_0()); 
	    }
		lv_imports_2_0=ruleImport		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModRule());
	        }
       		add(
       			$current, 
       			"imports",
        		lv_imports_2_0, 
        		"Import");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getModAccess().getFunctionsFunctionParserRuleCall_3_0()); 
	    }
		lv_functions_3_0=ruleFunction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModRule());
	        }
       		add(
       			$current, 
       			"functions",
        		lv_functions_3_0, 
        		"Function");
	        afterParserOrEnumRuleCall();
	    }

)
)+)
;





// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getImportRule()); }
	 iv_ruleImport=ruleImport 
	 { $current=$iv_ruleImport.current; } 
	 EOF 
;

// Rule Import
ruleImport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='import' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
    }
(
(
		lv_importURI_1_0=RULE_STRING
		{
			newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getImportRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"importURI",
        		lv_importURI_1_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRuleFunction
entryRuleFunction returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFunctionRule()); }
	 iv_ruleFunction=ruleFunction 
	 { $current=$iv_ruleFunction.current; } 
	 EOF 
;

// Rule Function
ruleFunction returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='def' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getFunctionAccess().getDefKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFunctionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_0_0()); 
	    }
		lv_args_3_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionRule());
	        }
       		add(
       			$current, 
       			"args",
        		lv_args_3_0, 
        		"Argument");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionAccess().getArgsArgumentParserRuleCall_3_1_1_0()); 
	    }
		lv_args_5_0=ruleArgument		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionRule());
	        }
       		add(
       			$current, 
       			"args",
        		lv_args_5_0, 
        		"Argument");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionAccess().getBlockBlockParserRuleCall_5_0()); 
	    }
		lv_block_7_0=ruleBlock		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionRule());
	        }
       		set(
       			$current, 
       			"block",
        		lv_block_7_0, 
        		"Block");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleArgument
entryRuleArgument returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getArgumentRule()); }
	 iv_ruleArgument=ruleArgument 
	 { $current=$iv_ruleArgument.current; } 
	 EOF 
;

// Rule Argument
ruleArgument returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getArgumentRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)
;









// Entry rule entryRuleBlock
entryRuleBlock returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getBlockRule()); }
	 iv_ruleBlock=ruleBlock 
	 { $current=$iv_ruleBlock.current; } 
	 EOF 
;

// Rule Block
ruleBlock returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0());
    }
(
    {
        $current = forceCreateModelElement(
            grammarAccess.getBlockAccess().getBlockAction_1(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0()); 
	    }
		lv_statements_2_0=ruleStatement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getBlockRule());
	        }
       		add(
       			$current, 
       			"statements",
        		lv_statements_2_0, 
        		"Statement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_3='}' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
    }
)
;





// Entry rule entryRuleStatement
entryRuleStatement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStatementRule()); }
	 iv_ruleStatement=ruleStatement 
	 { $current=$iv_ruleStatement.current; } 
	 EOF 
;

// Rule Statement
ruleStatement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(((
    {
        $current = forceCreateModelElement(
            grammarAccess.getStatementAccess().getBlankStatementAction_0_0(),
            $current);
    }
)	otherlv_1=';' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
    }
)
    |(
    { 
        newCompositeNode(grammarAccess.getStatementAccess().getVariableStatementParserRuleCall_1_0()); 
    }
    this_VariableStatement_2=ruleVariableStatement
    { 
        $current = $this_VariableStatement_2.current; 
        afterParserOrEnumRuleCall();
    }
	otherlv_3=';' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getStatementAccess().getSemicolonKeyword_1_1());
    }
)
    |
    { 
        newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_2()); 
    }
    this_Block_4=ruleBlock
    { 
        $current = $this_Block_4.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleVariableStatement
entryRuleVariableStatement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVariableStatementRule()); }
	 iv_ruleVariableStatement=ruleVariableStatement 
	 { $current=$iv_ruleVariableStatement.current; } 
	 EOF 
;

// Rule VariableStatement
ruleVariableStatement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_0_0()); 
	    }
		lv_expression_0_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVariableStatementRule());
	        }
       		set(
       			$current, 
       			"expression",
        		lv_expression_0_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
)
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getVariableStatementAccess().getVariableAction_1_0(),
            $current);
    }
)(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getVariableStatementAccess().getNameIDTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getVariableStatementRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"ID");
	    }

)
)	otherlv_3='=' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getVariableStatementAccess().getEqualsSignKeyword_1_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVariableStatementAccess().getExpressionExpressionParserRuleCall_1_3_0()); 
	    }
		lv_expression_4_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVariableStatementRule());
	        }
       		set(
       			$current, 
       			"expression",
        		lv_expression_4_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
)))
;





// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	 iv_ruleExpression=ruleExpression 
	 { $current=$iv_ruleExpression.current; } 
	 EOF 
;

// Rule Expression
ruleExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getExpressionAccess().getLogicalParserRuleCall()); 
    }
    this_Logical_0=ruleLogical
    { 
        $current = $this_Logical_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleLogical
entryRuleLogical returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLogicalRule()); }
	 iv_ruleLogical=ruleLogical 
	 { $current=$iv_ruleLogical.current; } 
	 EOF 
;

// Rule Logical
ruleLogical returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getLogicalAccess().getEqualityParserRuleCall_0()); 
    }
    this_Equality_0=ruleEquality
    { 
        $current = $this_Equality_0.current; 
        afterParserOrEnumRuleCall();
    }
((((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0(),
            $current);
    }
)	otherlv_2='&&' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getLogicalAccess().getAmpersandAmpersandKeyword_1_0_0_1());
    }
)
    |((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0(),
            $current);
    }
)	otherlv_4='||' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getLogicalAccess().getVerticalLineVerticalLineKeyword_1_0_1_1());
    }
))(
(
		{ 
	        newCompositeNode(grammarAccess.getLogicalAccess().getRightEqualityParserRuleCall_1_1_0()); 
	    }
		lv_right_5_0=ruleEquality		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLogicalRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_5_0, 
        		"Equality");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleEquality
entryRuleEquality returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEqualityRule()); }
	 iv_ruleEquality=ruleEquality 
	 { $current=$iv_ruleEquality.current; } 
	 EOF 
;

// Rule Equality
ruleEquality returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0()); 
    }
    this_Comparison_0=ruleComparison
    { 
        $current = $this_Comparison_0.current; 
        afterParserOrEnumRuleCall();
    }
((((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0(),
            $current);
    }
)	otherlv_2='==' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getEqualityAccess().getEqualsSignEqualsSignKeyword_1_0_0_1());
    }
)
    |((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0(),
            $current);
    }
)	otherlv_4='!=' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getEqualityAccess().getExclamationMarkEqualsSignKeyword_1_0_1_1());
    }
))(
(
		{ 
	        newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_1_0()); 
	    }
		lv_right_5_0=ruleComparison		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getEqualityRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_5_0, 
        		"Comparison");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleComparison
entryRuleComparison returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getComparisonRule()); }
	 iv_ruleComparison=ruleComparison 
	 { $current=$iv_ruleComparison.current; } 
	 EOF 
;

// Rule Comparison
ruleComparison returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getComparisonAccess().getAdditionParserRuleCall_0()); 
    }
    this_Addition_0=ruleAddition
    { 
        $current = $this_Addition_0.current; 
        afterParserOrEnumRuleCall();
    }
((((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0(),
            $current);
    }
)	otherlv_2='<' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getComparisonAccess().getLessThanSignKeyword_1_0_0_1());
    }
)
    |((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0(),
            $current);
    }
)	otherlv_4='<=' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getComparisonAccess().getLessThanSignEqualsSignKeyword_1_0_1_1());
    }
)
    |((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0(),
            $current);
    }
)	otherlv_6='>' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getComparisonAccess().getGreaterThanSignKeyword_1_0_2_1());
    }
)
    |((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0(),
            $current);
    }
)	otherlv_8='>=' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getComparisonAccess().getGreaterThanSignEqualsSignKeyword_1_0_3_1());
    }
))(
(
		{ 
	        newCompositeNode(grammarAccess.getComparisonAccess().getRightAdditionParserRuleCall_1_1_0()); 
	    }
		lv_right_9_0=ruleAddition		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComparisonRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_9_0, 
        		"Addition");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleAddition
entryRuleAddition returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAdditionRule()); }
	 iv_ruleAddition=ruleAddition 
	 { $current=$iv_ruleAddition.current; } 
	 EOF 
;

// Rule Addition
ruleAddition returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAdditionAccess().getMultiplicationParserRuleCall_0()); 
    }
    this_Multiplication_0=ruleMultiplication
    { 
        $current = $this_Multiplication_0.current; 
        afterParserOrEnumRuleCall();
    }
((((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(),
            $current);
    }
)	otherlv_2='+' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAdditionAccess().getPlusSignKeyword_1_0_0_1());
    }
)
    |((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(),
            $current);
    }
)	otherlv_4='-' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getAdditionAccess().getHyphenMinusKeyword_1_0_1_1());
    }
))(
(
		{ 
	        newCompositeNode(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0()); 
	    }
		lv_right_5_0=ruleMultiplication		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAdditionRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_5_0, 
        		"Multiplication");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleMultiplication
entryRuleMultiplication returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMultiplicationRule()); }
	 iv_ruleMultiplication=ruleMultiplication 
	 { $current=$iv_ruleMultiplication.current; } 
	 EOF 
;

// Rule Multiplication
ruleMultiplication returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getMultiplicationAccess().getUnaryParserRuleCall_0()); 
    }
    this_Unary_0=ruleUnary
    { 
        $current = $this_Unary_0.current; 
        afterParserOrEnumRuleCall();
    }
((((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(),
            $current);
    }
)	otherlv_2='*' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMultiplicationAccess().getAsteriskKeyword_1_0_0_1());
    }
)
    |((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(),
            $current);
    }
)	otherlv_4='/' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMultiplicationAccess().getSolidusKeyword_1_0_1_1());
    }
)
    |((
    {
        $current = forceCreateModelElementAndSet(
            grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0(),
            $current);
    }
)	otherlv_6='%' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMultiplicationAccess().getPercentSignKeyword_1_0_2_1());
    }
))(
(
		{ 
	        newCompositeNode(grammarAccess.getMultiplicationAccess().getRightUnaryParserRuleCall_1_1_0()); 
	    }
		lv_right_7_0=ruleUnary		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMultiplicationRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_7_0, 
        		"Unary");
	        afterParserOrEnumRuleCall();
	    }

)
))*)
;





// Entry rule entryRuleUnary
entryRuleUnary returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnaryRule()); }
	 iv_ruleUnary=ruleUnary 
	 { $current=$iv_ruleUnary.current; } 
	 EOF 
;

// Rule Unary
ruleUnary returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getUnaryAccess().getPrimaryExpressionParserRuleCall_0()); 
    }
    this_PrimaryExpression_0=rulePrimaryExpression
    { 
        $current = $this_PrimaryExpression_0.current; 
        afterParserOrEnumRuleCall();
    }

    |((((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUnaryAccess().getNegationAction_1_0_0_0(),
            $current);
    }
)(
(
		lv_op_2_0=	'!' 
    {
        newLeafNode(lv_op_2_0, grammarAccess.getUnaryAccess().getOpExclamationMarkKeyword_1_0_0_1_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUnaryRule());
	        }
       		setWithLastConsumed($current, "op", lv_op_2_0, "!");
	    }

)
))
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getUnaryAccess().getUnaryPlusMinusAction_1_0_1_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getUnaryAccess().getOpUnaryOperatorParserRuleCall_1_0_1_1_0()); 
	    }
		lv_op_4_0=ruleUnaryOperator		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnaryRule());
	        }
       		set(
       			$current, 
       			"op",
        		lv_op_4_0, 
        		"UnaryOperator");
	        afterParserOrEnumRuleCall();
	    }

)
)))(
(
		{ 
	        newCompositeNode(grammarAccess.getUnaryAccess().getRightUnaryParserRuleCall_1_1_0()); 
	    }
		lv_right_5_0=ruleUnary		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getUnaryRule());
	        }
       		set(
       			$current, 
       			"right",
        		lv_right_5_0, 
        		"Unary");
	        afterParserOrEnumRuleCall();
	    }

)
)))
;





// Entry rule entryRuleUnaryOperator
entryRuleUnaryOperator returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getUnaryOperatorRule()); } 
	 iv_ruleUnaryOperator=ruleUnaryOperator 
	 { $current=$iv_ruleUnaryOperator.current.getText(); }  
	 EOF 
;

// Rule UnaryOperator
ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='-' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
    }

    |
	kw='+' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getPlusSignKeyword_1()); 
    }
)
    ;





// Entry rule entryRulePrimaryExpression
entryRulePrimaryExpression returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrimaryExpressionRule()); }
	 iv_rulePrimaryExpression=rulePrimaryExpression 
	 { $current=$iv_rulePrimaryExpression.current; } 
	 EOF 
;

// Rule PrimaryExpression
rulePrimaryExpression returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='(' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_0_0());
    }

    { 
        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExpressionParserRuleCall_0_1()); 
    }
    this_Expression_1=ruleExpression
    { 
        $current = $this_Expression_1.current; 
        afterParserOrEnumRuleCall();
    }
	otherlv_2=')' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_0_2());
    }
)
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrimaryExpressionAccess().getNumberLiteralAction_1_0(),
            $current);
    }
)(
(
		lv_value_4_0=RULE_NUMBER
		{
			newLeafNode(lv_value_4_0, grammarAccess.getPrimaryExpressionAccess().getValueNUMBERTerminalRuleCall_1_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPrimaryExpressionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_4_0, 
        		"NUMBER");
	    }

)
))
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralAction_2_0(),
            $current);
    }
)(
(
		lv_condition_6_0=RULE_BOOLEAN
		{
			newLeafNode(lv_condition_6_0, grammarAccess.getPrimaryExpressionAccess().getConditionBOOLEANTerminalRuleCall_2_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getPrimaryExpressionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"condition",
        		true, 
        		"BOOLEAN");
	    }

)
))
    |((
    {
        $current = forceCreateModelElement(
            grammarAccess.getPrimaryExpressionAccess().getModelReferenceAction_3_0(),
            $current);
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNodeNodeDepthParserRuleCall_3_1_0()); 
	    }
		lv_node_8_0=ruleNodeDepth		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
	        }
       		set(
       			$current, 
       			"node",
        		lv_node_8_0, 
        		"NodeDepth");
	        afterParserOrEnumRuleCall();
	    }

)
))
    |
    { 
        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFunctionCallParserRuleCall_4()); 
    }
    this_FunctionCall_9=ruleFunctionCall
    { 
        $current = $this_FunctionCall_9.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getVarOrArgumentCallParserRuleCall_5()); 
    }
    this_VarOrArgumentCall_10=ruleVarOrArgumentCall
    { 
        $current = $this_VarOrArgumentCall_10.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleFunctionCall
entryRuleFunctionCall returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFunctionCallRule()); }
	 iv_ruleFunctionCall=ruleFunctionCall 
	 { $current=$iv_ruleFunctionCall.current; } 
	 EOF 
;

// Rule FunctionCall
ruleFunctionCall returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getFunctionCallAccess().getFunctionCallAction_0(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFunctionCallRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getFuncAbstractFunctionCrossReference_1_0()); 
	}

)
)	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_2());
    }
((
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_0_0()); 
	    }
		lv_args_3_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionCallRule());
	        }
       		add(
       			$current, 
       			"args",
        		lv_args_3_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_1_0()); 
	    }
		lv_args_5_0=ruleExpression		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFunctionCallRule());
	        }
       		add(
       			$current, 
       			"args",
        		lv_args_5_0, 
        		"Expression");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?	otherlv_6=')' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRuleVarOrArgumentCall
entryRuleVarOrArgumentCall returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVarOrArgumentCallRule()); }
	 iv_ruleVarOrArgumentCall=ruleVarOrArgumentCall 
	 { $current=$iv_ruleVarOrArgumentCall.current; } 
	 EOF 
;

// Rule VarOrArgumentCall
ruleVarOrArgumentCall returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getVarOrArgumentCallAccess().getVarOrArgumentCallAction_0(),
            $current);
    }
)(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getVarOrArgumentCallRule());
	        }
        }
	otherlv_1=RULE_ID
	{
		newLeafNode(otherlv_1, grammarAccess.getVarOrArgumentCallAccess().getCallAbstractVarOrArgumentCrossReference_1_0()); 
	}

)
))
;





// Entry rule entryRuleNodeDepth
entryRuleNodeDepth returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getNodeDepthRule()); }
	 iv_ruleNodeDepth=ruleNodeDepth 
	 { $current=$iv_ruleNodeDepth.current; } 
	 EOF 
;

// Rule NodeDepth
ruleNodeDepth returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='NODE.' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getNodeDepthAccess().getNODEKeyword_0());
    }

    { 
        newCompositeNode(grammarAccess.getNodeDepthAccess().getPrimaryNodeRefParserRuleCall_1()); 
    }
    this_PrimaryNodeRef_1=rulePrimaryNodeRef
    { 
        $current = $this_PrimaryNodeRef_1.current; 
        afterParserOrEnumRuleCall();
    }
(	otherlv_2='.' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getNodeDepthAccess().getFullStopKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getNodeDepthAccess().getDepthPrimaryNodeRefParserRuleCall_2_1_0()); 
	    }
		lv_depth_3_0=rulePrimaryNodeRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getNodeDepthRule());
	        }
       		add(
       			$current, 
       			"depth",
        		lv_depth_3_0, 
        		"PrimaryNodeRef");
	        afterParserOrEnumRuleCall();
	    }

)
))*	otherlv_4='.' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getNodeDepthAccess().getFullStopKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getNodeDepthRule());
	        }
        }
	otherlv_5=RULE_ID
	{
		newLeafNode(otherlv_5, grammarAccess.getNodeDepthAccess().getResRefResourceCrossReference_4_0()); 
	}

)
))
;





// Entry rule entryRulePrimaryNodeRef
entryRulePrimaryNodeRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getPrimaryNodeRefRule()); }
	 iv_rulePrimaryNodeRef=rulePrimaryNodeRef 
	 { $current=$iv_rulePrimaryNodeRef.current; } 
	 EOF 
;

// Rule PrimaryNodeRef
rulePrimaryNodeRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getPrimaryNodeRefRule());
	        }
        }
	otherlv_0=RULE_ID
	{
		newLeafNode(otherlv_0, grammarAccess.getPrimaryNodeRefAccess().getNodeRefNodeCrossReference_0()); 
	}

)
)
;





RULE_NUMBER : ('0'..'9')* ('.' ('0'..'9')+)?;

RULE_BOOLEAN : ('true'|'false');

RULE_INT : 'this one has been deactivated';

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;



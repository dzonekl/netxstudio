package com.netxforge.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.netxforge.netxscript.And;
import com.netxforge.netxscript.Argument;
import com.netxforge.netxscript.Assignment;
import com.netxforge.netxscript.Block;
import com.netxforge.netxscript.BooleanLiteral;
import com.netxforge.netxscript.ContextRef;
import com.netxforge.netxscript.Div;
import com.netxforge.netxscript.Equal;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.FunctionCall;
import com.netxforge.netxscript.Greater;
import com.netxforge.netxscript.GreaterEqual;
import com.netxforge.netxscript.If;
import com.netxforge.netxscript.Import;
import com.netxforge.netxscript.Interval;
import com.netxforge.netxscript.Lesser;
import com.netxforge.netxscript.LesserEqual;
import com.netxforge.netxscript.LinkRef;
import com.netxforge.netxscript.Minus;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.Modulo;
import com.netxforge.netxscript.Multi;
import com.netxforge.netxscript.NativeExpression;
import com.netxforge.netxscript.Negation;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.NodeRef;
import com.netxforge.netxscript.NodeTypeRef;
import com.netxforge.netxscript.NumberLiteral;
import com.netxforge.netxscript.OperatorRef;
import com.netxforge.netxscript.Or;
import com.netxforge.netxscript.ParamRef;
import com.netxforge.netxscript.Plus;
import com.netxforge.netxscript.PlusAssignment;
import com.netxforge.netxscript.RangeLiteral;
import com.netxforge.netxscript.RangeRef;
import com.netxforge.netxscript.RefAssignment;
import com.netxforge.netxscript.Reference;
import com.netxforge.netxscript.ResourceRef;
import com.netxforge.netxscript.Return;
import com.netxforge.netxscript.StatusRef;
import com.netxforge.netxscript.UnaryPlusMinus;
import com.netxforge.netxscript.Unequal;
import com.netxforge.netxscript.VarOrArgumentCall;
import com.netxforge.netxscript.Variable;
import com.netxforge.netxscript.While;
import com.netxforge.services.NetxscriptGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractNetxscriptSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected NetxscriptGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == NetxscriptPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case NetxscriptPackage.AND:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Logical_And(context, (And) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.ARGUMENT:
				if(context == grammarAccess.getArgumentRule() ||
				   context == grammarAccess.getAbstractVarOrArgumentRule()) {
					sequence_Argument_Argument(context, (Argument) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.ASSIGNMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getAssignmentStatementRule()) {
					sequence_AssignmentStatement_Assignment(context, (Assignment) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.BLOCK:
				if(context == grammarAccess.getBlockRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Block_Block(context, (Block) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.BOOLEAN_LITERAL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Literal_BooleanLiteral(context, (BooleanLiteral) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.CONTEXT_REF:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getReferenceRule() ||
				   context == grammarAccess.getContextRefRule()) {
					sequence_ContextRef_ContextRef(context, (ContextRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.DIV:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Multiplication_Div(context, (Div) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.EQUAL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Equality_Equal(context, (Equal) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.FUNCTION:
				if(context == grammarAccess.getFunctionRule() ||
				   context == grammarAccess.getAbstractFunctionRule()) {
					sequence_Function_Function(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.FUNCTION_CALL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getFunctionCallRule()) {
					sequence_FunctionCall_FunctionCall(context, (FunctionCall) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.GREATER:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Comparison_Greater(context, (Greater) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.GREATER_EQUAL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Comparison_GreaterEqual(context, (GreaterEqual) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.IF:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getIfStatementRule()) {
					sequence_IfStatement_If(context, (If) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.IMPORT:
				if(context == grammarAccess.getImportRule()) {
					sequence_Import_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.INTERVAL:
				if(context == grammarAccess.getIntervalRule()) {
					sequence_Interval_Interval(context, (Interval) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.LESSER:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Comparison_Lesser(context, (Lesser) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.LESSER_EQUAL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Comparison_LesserEqual(context, (LesserEqual) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.LINK_REF:
				if(context == grammarAccess.getLeafReferenceRule() ||
				   context == grammarAccess.getLinkRefRule()) {
					sequence_LinkRef_LinkRef(context, (LinkRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.MINUS:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Addition_Minus(context, (Minus) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.MOD:
				if(context == grammarAccess.getModRule()) {
					sequence_Mod_Mod(context, (Mod) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.MODULO:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Multiplication_Modulo(context, (Modulo) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.MULTI:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Multiplication_Multi(context, (Multi) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.NATIVE_EXPRESSION:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getNativeExpressionRule()) {
					sequence_NativeExpression_NativeExpression(context, (NativeExpression) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.NEGATION:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Unary_Negation(context, (Negation) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.NODE_REF:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getReferenceRule() ||
				   context == grammarAccess.getNodeRefRule()) {
					sequence_NodeRef_NodeRef(context, (NodeRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.NODE_TYPE_REF:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getReferenceRule() ||
				   context == grammarAccess.getNodeTypeRefRule()) {
					sequence_NodeTypeRef_NodeTypeRef(context, (NodeTypeRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.NUMBER_LITERAL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getNumberLiteralRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_NumberLiteral_NumberLiteral(context, (NumberLiteral) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.OPERATOR_REF:
				if(context == grammarAccess.getOperatorRefRule()) {
					sequence_OperatorRef_OperatorRef(context, (OperatorRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.OR:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Logical_Or(context, (Or) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.PARAM_REF:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getReferenceRule() ||
				   context == grammarAccess.getParamRefRule()) {
					sequence_ParamRef_ParamRef(context, (ParamRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.PLUS:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Addition_Plus(context, (Plus) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.PLUS_ASSIGNMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getPlusAssignmentStatementRule()) {
					sequence_PlusAssignmentStatement_PlusAssignment(context, (PlusAssignment) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.RANGE_LITERAL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getRangeRule() ||
				   context == grammarAccess.getRangeLiteralRule()) {
					sequence_RangeLiteral_RangeLiteral(context, (RangeLiteral) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.RANGE_REF:
				if(context == grammarAccess.getRangeRefRule()) {
					sequence_RangeRef_RangeRef(context, (RangeRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.REF_ASSIGNMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getReferenceAssignmentStatementRule()) {
					sequence_ReferenceAssignmentStatement_RefAssignment(context, (RefAssignment) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.REFERENCE:
				if(context == grammarAccess.getPrimaryRefRule()) {
					sequence_PrimaryRef_Reference(context, (Reference) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.RESOURCE_REF:
				if(context == grammarAccess.getLeafReferenceRule() ||
				   context == grammarAccess.getResourceRefRule()) {
					sequence_ResourceRef_ResourceRef(context, (ResourceRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.RETURN:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getReturnStatementRule()) {
					sequence_ReturnStatement_Return(context, (Return) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.STATUS_REF:
				if(context == grammarAccess.getLeafReferenceRule() ||
				   context == grammarAccess.getStatusRefRule()) {
					sequence_StatusRef_StatusRef(context, (StatusRef) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.UNARY_PLUS_MINUS:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Unary_UnaryPlusMinus(context, (UnaryPlusMinus) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.UNEQUAL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule()) {
					sequence_Equality_Unequal(context, (Unequal) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.VAR_OR_ARGUMENT_CALL:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getLogicalRule() ||
				   context == grammarAccess.getLogicalAccess().getAndLeftAction_1_0_0_0() ||
				   context == grammarAccess.getLogicalAccess().getOrLeftAction_1_0_1_0() ||
				   context == grammarAccess.getEqualityRule() ||
				   context == grammarAccess.getEqualityAccess().getEqualLeftAction_1_0_0_0() ||
				   context == grammarAccess.getEqualityAccess().getUnequalLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonRule() ||
				   context == grammarAccess.getComparisonAccess().getLesserLeftAction_1_0_0_0() ||
				   context == grammarAccess.getComparisonAccess().getLesserEqualLeftAction_1_0_1_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterLeftAction_1_0_2_0() ||
				   context == grammarAccess.getComparisonAccess().getGreaterEqualLeftAction_1_0_3_0() ||
				   context == grammarAccess.getAdditionRule() ||
				   context == grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0() ||
				   context == grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationRule() ||
				   context == grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0() ||
				   context == grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0() ||
				   context == grammarAccess.getMultiplicationAccess().getModuloLeftAction_1_0_2_0() ||
				   context == grammarAccess.getUnaryRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getIndexedCallRule()) {
					sequence_IndexedCall_VarOrArgumentCall(context, (VarOrArgumentCall) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getVarOrArgumentCallRule()) {
					sequence_VarOrArgumentCall_VarOrArgumentCall(context, (VarOrArgumentCall) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.VARIABLE:
				if(context == grammarAccess.getAbstractVarOrArgumentRule() ||
				   context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getVariableStatementRule()) {
					sequence_VariableStatement_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			case NetxscriptPackage.WHILE:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getWhileStatementRule()) {
					sequence_WhileStatement_While(context, (While) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (left=Addition_Minus_1_0_1_0 right=Multiplication)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Addition_Minus(EObject context, Minus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Addition_Plus_1_0_0_0 right=Multiplication)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Addition_Plus(EObject context, Plus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_Argument_Argument(EObject context, Argument semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.ARGUMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.ARGUMENT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getArgumentAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (var=[AbstractVarOrArgument|ID] expression=Expression)
	 *
	 * Features:
	 *    var[1, 1]
	 *    expression[1, 1]
	 */
	protected void sequence_AssignmentStatement_Assignment(EObject context, Assignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.ASSIGNMENT__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.ASSIGNMENT__VAR));
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.ASSIGNMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.ASSIGNMENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssignmentStatementAccess().getVarAbstractVarOrArgumentIDTerminalRuleCall_1_0_1(), semanticObject.getVar());
		feeder.accept(grammarAccess.getAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (statements+=Statement*)
	 *
	 * Features:
	 *    statements[0, *]
	 */
	protected void sequence_Block_Block(EObject context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Comparison_Greater_1_0_2_0 right=Addition)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Comparison_Greater(EObject context, Greater semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Comparison_GreaterEqual_1_0_3_0 right=Addition)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Comparison_GreaterEqual(EObject context, GreaterEqual semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Comparison_Lesser_1_0_0_0 right=Addition)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Comparison_Lesser(EObject context, Lesser semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Comparison_LesserEqual_1_0_1_0 right=Addition)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Comparison_LesserEqual(EObject context, LesserEqual semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (primaryRef=PrimaryRef | rangeRef=RangeRef)
	 *
	 * Features:
	 *    primaryRef[0, 1]
	 *         EXCLUDE_IF_SET rangeRef
	 *    rangeRef[0, 1]
	 *         EXCLUDE_IF_SET primaryRef
	 */
	protected void sequence_ContextRef_ContextRef(EObject context, ContextRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Equality_Equal_1_0_0_0 right=Comparison)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Equality_Equal(EObject context, Equal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Equality_Unequal_1_0_1_0 right=Comparison)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Equality_Unequal(EObject context, Unequal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (func=[AbstractFunction|ID] (args+=Expression args+=Expression*)?)
	 *
	 * Features:
	 *    func[1, 1]
	 *    args[0, *]
	 */
	protected void sequence_FunctionCall_FunctionCall(EObject context, FunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (args+=Argument args+=Argument*)? block=Block)
	 *
	 * Features:
	 *    name[1, 1]
	 *    args[0, *]
	 *    block[1, 1]
	 */
	protected void sequence_Function_Function(EObject context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (if=Logical then=Block else=Block?)
	 *
	 * Features:
	 *    if[1, 1]
	 *    then[1, 1]
	 *    else[0, 1]
	 */
	protected void sequence_IfStatement_If(EObject context, If semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importURI=STRING
	 *
	 * Features:
	 *    importURI[1, 1]
	 */
	protected void sequence_Import_Import(EObject context, Import semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.IMPORT__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.IMPORT__IMPORT_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (call=[AbstractVarOrArgument|ID] index=Expression?)
	 *
	 * Features:
	 *    index[0, 1]
	 *    call[1, 1]
	 */
	protected void sequence_IndexedCall_VarOrArgumentCall(EObject context, VarOrArgumentCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (interval=NUMBER | kind=IntervalKind)
	 *
	 * Features:
	 *    interval[0, 1]
	 *         EXCLUDE_IF_SET kind
	 *    kind[0, 1]
	 *         EXCLUDE_IF_SET interval
	 */
	protected void sequence_Interval_Interval(EObject context, Interval semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     link=[Relationship|ID]
	 *
	 * Features:
	 *    link[1, 1]
	 */
	protected void sequence_LinkRef_LinkRef(EObject context, LinkRef semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.LINK_REF__LINK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.LINK_REF__LINK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLinkRefAccess().getLinkRelationshipIDTerminalRuleCall_2_0_1(), semanticObject.getLink());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (condition?='true'?)
	 *
	 * Features:
	 *    condition[0, 1]
	 */
	protected void sequence_Literal_BooleanLiteral(EObject context, BooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Logical_And_1_0_0_0 right=Equality)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Logical_And(EObject context, And semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Logical_Or_1_0_1_0 right=Equality)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Logical_Or(EObject context, Or semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID? imports+=Import* (functions+=Function+ | statements+=Statement+))
	 *
	 * Features:
	 *    name[0, 1]
	 *    imports[0, *]
	 *    functions[0, *]
	 *         EXCLUDE_IF_SET statements
	 *    statements[0, *]
	 *         EXCLUDE_IF_SET functions
	 */
	protected void sequence_Mod_Mod(EObject context, Mod semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Div_1_0_1_0 right=Unary)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Multiplication_Div(EObject context, Div semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Modulo_1_0_2_0 right=Unary)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Multiplication_Modulo(EObject context, Modulo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication_Multi_1_0_0_0 right=Unary)
	 *
	 * Features:
	 *    left[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Multiplication_Multi(EObject context, Multi semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((range=RangeLiteral | ref=Reference | var=VarOrArgumentCall) nativeFunction=NativeFunction)
	 *
	 * Features:
	 *    range[0, 1]
	 *         EXCLUDE_IF_SET ref
	 *         EXCLUDE_IF_SET var
	 *    ref[0, 1]
	 *         EXCLUDE_IF_SET range
	 *         EXCLUDE_IF_SET var
	 *    var[0, 1]
	 *         EXCLUDE_IF_SET range
	 *         EXCLUDE_IF_SET ref
	 *    nativeFunction[1, 1]
	 */
	protected void sequence_NativeExpression_NativeExpression(EObject context, NativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (node=[Node|ID] primaryRef=PrimaryRef)
	 *
	 * Features:
	 *    node[1, 1]
	 *    primaryRef[1, 1]
	 */
	protected void sequence_NodeRef_NodeRef(EObject context, NodeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nodetype=[NodeType|ID] primaryRef=PrimaryRef)
	 *
	 * Features:
	 *    nodetype[1, 1]
	 *    primaryRef[1, 1]
	 */
	protected void sequence_NodeTypeRef_NodeTypeRef(EObject context, NodeTypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=NUMBER
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_NumberLiteral_NumberLiteral(EObject context, NumberLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((function=[Function|FQN] | equipment=[Equipment|FQN])?)
	 *
	 * Features:
	 *    function[0, 1]
	 *         EXCLUDE_IF_SET equipment
	 *    equipment[0, 1]
	 *         EXCLUDE_IF_SET function
	 */
	protected void sequence_OperatorRef_OperatorRef(EObject context, OperatorRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     param=[Parameter|FQN]
	 *
	 * Features:
	 *    param[1, 1]
	 */
	protected void sequence_ParamRef_ParamRef(EObject context, ParamRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (var=[AbstractVarOrArgument|ID] expression=Expression)
	 *
	 * Features:
	 *    var[1, 1]
	 *    expression[1, 1]
	 */
	protected void sequence_PlusAssignmentStatement_PlusAssignment(EObject context, PlusAssignment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.PLUS_ASSIGNMENT__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.PLUS_ASSIGNMENT__VAR));
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.PLUS_ASSIGNMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.PLUS_ASSIGNMENT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPlusAssignmentStatementAccess().getVarAbstractVarOrArgumentIDTerminalRuleCall_1_0_1(), semanticObject.getVar());
		feeder.accept(grammarAccess.getPlusAssignmentStatementAccess().getExpressionExpressionParserRuleCall_3_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (component=OperatorRef leafRef=LeafReference?)
	 *
	 * Features:
	 *    component[1, 1]
	 *    leafRef[0, 1]
	 */
	protected void sequence_PrimaryRef_Reference(EObject context, Reference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((values+=NUMBER values+=NUMBER*)?)
	 *
	 * Features:
	 *    values[0, *]
	 */
	protected void sequence_RangeLiteral_RangeLiteral(EObject context, RangeLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (valuerange=ValueRange kind=ValueKind? interval=Interval?)
	 *
	 * Features:
	 *    valuerange[1, 1]
	 *    kind[0, 1]
	 *    interval[0, 1]
	 */
	protected void sequence_RangeRef_RangeRef(EObject context, RangeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((assignmentRef=ContextRef | assignmentRef=NodeTypeRef) expression=Expression)
	 *
	 * Features:
	 *    assignmentRef[0, 2]
	 *    expression[1, 1]
	 */
	protected void sequence_ReferenceAssignmentStatement_RefAssignment(EObject context, RefAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((resource=[BaseResource|FQN] | all?='ALL') rangeRef=RangeRef)
	 *
	 * Features:
	 *    resource[0, 1]
	 *         EXCLUDE_IF_SET all
	 *    all[0, 1]
	 *         EXCLUDE_IF_SET resource
	 *    rangeRef[1, 1]
	 */
	protected void sequence_ResourceRef_ResourceRef(EObject context, ResourceRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=Expression?)
	 *
	 * Features:
	 *    expression[0, 1]
	 */
	protected void sequence_ReturnStatement_Return(EObject context, Return semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     tolerancelevel=ToleranceLevel
	 *
	 * Features:
	 *    tolerancelevel[1, 1]
	 */
	protected void sequence_StatusRef_StatusRef(EObject context, StatusRef semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.STATUS_REF__TOLERANCELEVEL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.STATUS_REF__TOLERANCELEVEL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatusRefAccess().getTolerancelevelToleranceLevelEnumRuleCall_1_0(), semanticObject.getTolerancelevel());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (op='!' right=Unary)
	 *
	 * Features:
	 *    op[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Unary_Negation(EObject context, Negation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (op=UnaryOperator right=Unary)
	 *
	 * Features:
	 *    op[1, 1]
	 *    right[1, 1]
	 */
	protected void sequence_Unary_UnaryPlusMinus(EObject context, UnaryPlusMinus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     call=[AbstractVarOrArgument|ID]
	 *
	 * Features:
	 *    call[1, 1]
	 */
	protected void sequence_VarOrArgumentCall_VarOrArgumentCall(EObject context, VarOrArgumentCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID expression=Expression?)
	 *
	 * Features:
	 *    name[1, 1]
	 *    expression[0, 1]
	 */
	protected void sequence_VariableStatement_Variable(EObject context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (predicate=Logical body=Block)
	 *
	 * Features:
	 *    predicate[1, 1]
	 *    body[1, 1]
	 */
	protected void sequence_WhileStatement_While(EObject context, While semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.WHILE__PREDICATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.WHILE__PREDICATE));
			if(transientValues.isValueTransient(semanticObject, NetxscriptPackage.Literals.WHILE__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, NetxscriptPackage.Literals.WHILE__BODY));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getWhileStatementAccess().getPredicateLogicalParserRuleCall_3_0(), semanticObject.getPredicate());
		feeder.accept(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_5_0(), semanticObject.getBody());
		feeder.finish();
	}
}

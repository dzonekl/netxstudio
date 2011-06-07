package com.netxforge.interpreter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import library.Value;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxscript.And;
import com.netxforge.netxscript.Argument;
import com.netxforge.netxscript.Assignment;
import com.netxforge.netxscript.Block;
import com.netxforge.netxscript.BooleanLiteral;
import com.netxforge.netxscript.Div;
import com.netxforge.netxscript.Equal;
import com.netxforge.netxscript.Expression;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.FunctionCall;
import com.netxforge.netxscript.Greater;
import com.netxforge.netxscript.GreaterEqual;
import com.netxforge.netxscript.If;
import com.netxforge.netxscript.Lesser;
import com.netxforge.netxscript.LesserEqual;
import com.netxforge.netxscript.LinkRef;
import com.netxforge.netxscript.Minus;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.Modulo;
import com.netxforge.netxscript.Multi;
import com.netxforge.netxscript.NativeFunction;
import com.netxforge.netxscript.Negation;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.NodeRef;
import com.netxforge.netxscript.NumberLiteral;
import com.netxforge.netxscript.Or;
import com.netxforge.netxscript.Plus;
import com.netxforge.netxscript.Reference;
import com.netxforge.netxscript.ResourceRef;
import com.netxforge.netxscript.Return;
import com.netxforge.netxscript.Statement;
import com.netxforge.netxscript.UnaryPlusMinus;
import com.netxforge.netxscript.Unequal;
import com.netxforge.netxscript.VarOrArgumentCall;
import com.netxforge.netxscript.Variable;
import com.netxforge.netxscript.While;

/**
 * an interpreter for instances of EClasses of the {@link NetxscriptPackage}.
 * 
 * It internally uses a polymorphic dispatcher to dispatch between the
 * implementations for the different EClasses.
 * 
 * TODO, all numeric evaluations, should consider ranges.
 * 
 * 
 * @author Sven Efftinge - initial contribution and API
 * @author dzonekl - Extended the grammar, see NetXScript.
 */
public class InterpreterTypeless {

	 @Inject
	INativeFunctions nativeFunctions;

	private PolymorphicDispatcher<BigDecimal> dispatcher = PolymorphicDispatcher
			.createForSingleTarget("internalEvaluate", 2, 2, this);

	// private PolymorphicDispatcher dispatcher = PolymorphicDispatcher
	// .createForVarTarget("internalEvaluate", this);

	/**
	 * Context corresponds to 'this' in the grammar.
	 */
	@SuppressWarnings("unused")
	private EObject context;

	/**
	 * Construct without a root object constraint.
	 */
	public InterpreterTypeless() {
	}

	/**
	 * Construct with an root object constraint.
	 * 
	 * @param context
	 */
	public InterpreterTypeless(EObject context) {
		this.context = context;
	}

	/**
	 * We execute the first function in the module. The subsequent functions,
	 * are considered internal and can be called from within the first function.
	 * Alternatively we execute the individual statements.
	 */
	public Object evaluate(Mod module) {
		if (module.getFunctions().size() > 0) {
			Function f = module.getFunctions().get(0);
			// TODO, this is where we need to set the arguments if any.
			// We would then call the function evaluation including values.
			// Or the first function has no arguments?
			System.out.println("Calling first function: '" + f.getName()
					+ "' Additional Functions:"
					+ (module.getFunctions().size() - 1));
			return evaluate(f);
		} else {
			// Dispatch on single statements.
			dispatcher.invoke(module.getStatements(),
					ImmutableMap.<String, Object> of());
			return null; // Nothing to return.
		}
	}

	/**
	 * The last statement of the function is returned.
	 * 
	 * @param function
	 * @return
	 */
	public Object evaluate(Function function) {
		return evaluate(function, ImmutableMap.<String, Object> of());
	}

	public Object evaluate(Function function,
			ImmutableMap<String, Object> values) {
		return evaluate(function.getBlock(), values);
	}

	/**
	 * External evaluate a block.
	 * 
	 * @param block
	 * @param values
	 * @return
	 */
	public Object evaluate(Block block, ImmutableMap<String, Object> values) {
		return dispatcher.invoke(block, values);
	}

	/**
	 * External evaluate a single statement
	 * 
	 * @param statement
	 * @return
	 */
	public Object evaluate(Statement statement,  ImmutableMap<String, Object> values) {
		return dispatcher.invoke(statement, values);
	}

	// Dispatch methods, main entry class.
	public Object evaluate(Expression obj) {
		return evaluate(obj, ImmutableMap.<String, Object> of());
	}

	public Object evaluate(Expression obj, ImmutableMap<String, Object> values) {
		return dispatcher.invoke(obj, values);
	}

	/**
	 * Legacy call, would not be called internally.
	 * 
	 * @param obj
	 * @return
	 */
	public BigDecimal evaluateNumeric(Expression obj) {
		return evaluateNumeric(obj, ImmutableMap.<String, Object> of());
	}

	/**
	 * A dispatch call, which we expect to return a decimal. Will throw an
	 * exception if not.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	public BigDecimal evaluateNumeric(Expression e,
			ImmutableMap<String, Object> values) {
		Object eval = dispatcher.invoke(e, values);
		if (assertNumeric(eval)) {
			return (BigDecimal) eval;
		} else {
			throw new UnsupportedOperationException(e.toString());
		}
	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	public EList<?> evaluateCollection(Expression e) {
		return evaluateCollection(e, ImmutableMap.<String, Object> of());
	}

	/**
	 * A dispatch call, which we expect to return a collection of values.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	public EList<?> evaluateCollection(Expression e,
			ImmutableMap<String, Object> values) {
		Object eval = dispatcher.invoke(e, values);
		if (assertCollection(eval)) {
			return (EList<?>) eval;
		} else {
			throw new UnsupportedOperationException(e.toString());
		}
	}

	/**
	 * A dispatch call, which we expect to return a boolean. Will throw an
	 * exception if not.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	public Boolean evaluateBoolean(Expression e,
			ImmutableMap<String, Object> values) {
		Object eval = dispatcher.invoke(e, values);
		if (assertBoolean(eval)) {
			return (Boolean) eval;
		} else {
			throw new UnsupportedOperationException(e.toString());
		}
	}

	/**
	 * TODO, Reference evaluation return void for now.
	 * 
	 * @param ref
	 * @param values
	 */
	public Object evaluate(Reference ref, ImmutableMap<String, Object> values) {
		Object eval = dispatcher.invoke(ref, values);
		return eval;
	}

	// /////////////////////////////////////
	// BLOCKS AND STATEMENTS
	// //////////////////////////////////////

	protected Object internalEvaluate(Block block,
			ImmutableMap<String, Object> values) {
		return internalEvaluate(block, null, values);
	}

	protected Object internalEvaluate(EList<Statement> statements,
			ImmutableMap<String, Object> values) {
		return internalEvaluate(null, statements, values);
	}

	/**
	 * A Block is a series of statements. Statements are evaluated, variable 
	 * definitions and assignments are pre-evaluated. We maintain a map of pre-evaluated
	 * values, to be used by calls. (Argument or Variable). 
	 * 
	 * Returns the last evaluation.
	 * 
	 */
	protected Object internalEvaluate(Block block, EList<Statement> statements,
			ImmutableMap<String, Object> values) {
		
		EList<Statement> internalStatements = null;
		if (block != null) {
			internalStatements = block.getStatements();
		}
		if (statements != null) {
			internalStatements = statements;
		}

		if (internalStatements == null)
			return null;
		
		
		// Merge local vars, with formal params. 
		Map<String, Object> localVarsAndArguments = Maps.newHashMap();
		localVarsAndArguments.putAll(ImmutableMap.copyOf(values));

		// Object eval = null;
		for (Statement statement : internalStatements) {
			int index = internalStatements.indexOf(statement);

			// When we define a variable or assign a value to a var, we
			// also store the expression result as a parameter which we pass on
			// to the next expression.

			// Abort this block (Actually the function), if we are a Return
			// statement.
			if (statement instanceof Return) {
				System.out
						.println("return encountered, postpone return evaluation");
				return statement;
			}

			Object eval = dispatcher.invoke(statement,
					ImmutableMap.copyOf(localVarsAndArguments));

			{ // Pre-evaluation of variables and assignments.
				Object varEval = null;
				Variable v = null;
				if (statement instanceof Variable) {
					v = (Variable) statement;
					if (v != null) {
						varEval = dispatcher.invoke(v.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));
					}
					localVarsAndArguments.put(v.getName(), varEval);

				}
				if (statement instanceof Assignment) {
					v = (Variable) ((Assignment) statement).getVar();
					if (v != null) {
						varEval = dispatcher.invoke(v.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));
					}
					localVarsAndArguments.put(v.getName(), varEval);

				}
			}

			// Print the evaluation result.
			// FIXME, remove. 
			if (eval != null) {
				System.out.print("Statement (" + index + ") result:");
				// The evaluation result, could be any type.
				// A variable assignment returns a string (Not the result of the
				// assigned expression).
				if (eval instanceof EList<?>) {
					for (Object o : (EList<?>) eval) {
						if (o instanceof Value) {
							System.out.print(" val=" + ((Value) o).getValue());
						}
					}
					System.out.println();
				} else
					System.out.println(eval);
			}
		}
		return null;
	}

	/**
	 * Root class, which contains an expression, evaluate on the expression, or
	 * threat as a blank.
	 * 
	 * @param statement
	 * @param values
	 * @return
	 */
	protected Object internalEvaluate(Statement statement,
			ImmutableMap<String, Object> values) {

		if (statement.getExpression() != null) {
			return evaluate((Expression) statement.getExpression(), values);
		} else {
			// TODO, blank Statement.
			return null;
		}
	}

	/**
	 * If statement.
	 * 
	 * @param statement
	 * @param values
	 * @return
	 */
	protected Object internalEvaluate(If statement,
			ImmutableMap<String, Object> values) {
		Expression ifExpression = statement.getIf();
		Boolean result = evaluateBoolean(ifExpression, values);
		if (result) {
			// This yields many results as a block execution.
			return evaluate(statement.getThen(), values);
		} else {
			return evaluate(statement.getElse(), values);
		}
	}

	/**
	 * While Statement.
	 * 
	 * @param statement
	 * @param values
	 * @return
	 */
	protected Object internalEvaluate(While statement,
			ImmutableMap<String, Object> values) {
		Expression predicateExpression = statement.getPredicate();
		Boolean result = evaluateBoolean(predicateExpression, values);
		Object bodyResult = null;
		while (result) {
			// This yields many results as a block execution.
			bodyResult = evaluate(statement.getBody(), values);
			// We should check for a return statements, and abort if
			// encountered.
			result = evaluateBoolean(predicateExpression, values);
		}
		return bodyResult;
	}

	/**
	 * Change the referenced variable expression, to the new assignment
	 * expression.
	 * 
	 * @param statement
	 * @param values
	 * @return
	 */
	protected Object internalEvaluate(Assignment statement,
			ImmutableMap<String, Object> values) {
		if (statement.getVar() instanceof Variable) {
			((Variable) statement.getVar()).setExpression(statement
					.getExpression());
		}

		return statement.getVar();
	}

	protected Object internalEvaluate(Variable var,
			ImmutableMap<String, Object> values) {
		return var;
	}

	// /////////////////////////////////////
	// REFERENCE EXPRESSIONS (CALLS)
	// //////////////////////////////////////

	protected Object internalEvaluate(Argument e,
			ImmutableMap<String, Object> values) {
		throw new UnsupportedOperationException(e.toString());
	}

	/**
	 * Function call. Executes the function definition, stored in the function
	 * call. the arguments of the function are first evaluated and, passed as
	 * values in the function evaluation.
	 */
	protected Object internalEvaluate(FunctionCall e,
			ImmutableMap<String, Object> values) {

		Function function = (Function) e.getFunc();

		Map<String, Object> params = Maps.newHashMap();

		for (int i = 0; i < e.getArgs().size(); i++) {
			Argument arg = function.getArgs().get(i);
			Expression argExpression = e.getArgs().get(i);
			Object evaluation = evaluate(argExpression, values);
			params.put(arg.getName(), evaluation);
		}

		// Puts the values of the arguments into a new evaluation, using the
		// expression of the definition, note: internal evaluators should consider
		// the type of the evaluation.

		Object result = evaluate(function, ImmutableMap.copyOf(params));
		if (result instanceof Return) {
			// Invoke the return expression.
			return dispatcher.invoke(result, ImmutableMap.copyOf(params));
		} else {
			return result;
		}

	}

	/**
	 * Assignment call, could be a defined function argument.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	protected Object internalEvaluate(VarOrArgumentCall e,
			ImmutableMap<String, Object> values) {

		if (e.getCall() instanceof Argument) {
			Argument arg = (Argument) e.getCall();
			Object preEvaluated = values.get(arg.getName());
			if(preEvaluated != null){
				return preEvaluated;
			}
		}
		// The result of the evaluation?
		if (e.getCall() instanceof Variable) {
			Variable var = (Variable) e.getCall();
			Object preEvaluated = values.get(var.getName());
			if (preEvaluated != null) {
				return preEvaluated;
			} else {
				return evaluate((Expression) var.getExpression(), values);
			}
		}
		throw new UnsupportedOperationException(e.toString());
	}

	// /////////////////////////////////////
	// REFERENCES
	// //////////////////////////////////////

	@SuppressWarnings("unchecked")
	protected Object internalEvaluate(Reference e,
			ImmutableMap<String, Object> params) {
		Object eval = evaluate(e.getRef(), ImmutableMap.copyOf(params));
		
		// Note type conformance for method signatures, will, also 
		// be needed in validation. 
		
		if (e.getNativeFunction() != null) {
			
			NativeFunction nf = e.getNativeFunction();
			switch (nf.getValue()) {
			case NativeFunction.SUM_VALUE: {
				if( !assertCollection(eval)){
					// Don't know what it is, but can't be processed.
					return eval;
				}
				nativeFunctions.sum((EList<Value>) eval);
				return eval;
			}
			case NativeFunction.COUNT_VALUE: {
				return eval;
			}
			case NativeFunction.MAX_VALUE:{
				return eval;
			}
			case NativeFunction.MIN_VALUE:{
				return eval;
			}
			case NativeFunction.MEAN_VALUE:{
				return eval;
			}
			case NativeFunction.DEVIATION_VALUE:{
				return eval;
			}
			
			}
		}
		return eval;
	}
	

	protected void internalEvaluate(NodeRef e,
			ImmutableMap<String, Object> values) {
		// Could be any type of reference, even nested.
		System.out.println("Found a node reference");
	}

	protected void internalEvaluate(LinkRef e,
			ImmutableMap<String, Object> values) {
		// Could be any type of reference, even nested.
		System.out.println("Found a link reference" + e.getLink().getName());
	}

	protected EList<Value> internalEvaluate(ResourceRef e,
			ImmutableMap<String, Object> values) {
		// This is where we grab the values based on a date range.
		// FIXME, we can't grab the whole range of values, use contextual 
		// information here See IIntepreterContext.  
		EList<Value> v = e.getResource().getValues();
		return v;
	}

	// /////////////////////////////////////
	// NATIVE FUNCTIONS
	// //////////////////////////////////////
	
	protected Object internalEvaluate(NativeFunction nf, ImmutableMap<String, Object> values){
		// TODO, not yet implemented, parameters, can be passed through the map. 
		return null;
	}
	
	// /////////////////////////////////////
	// UNSUPPORTED ABSTRACTS
	// //////////////////////////////////////

	protected void internalEvaluate(Expression e,
			ImmutableMap<String, Object> values) {
		System.out
				.println("TODO, implement evaluation rule for expression type: "
						+ e.eClass().getName());
		// throw new UnsupportedOperationException(e.toString());
	}

	// /////////////////////////////////////
	// NUMERIC EXPRESSIONS
	// //////////////////////////////////////
	protected BigDecimal internalEvaluate(NumberLiteral e,
			ImmutableMap<String, Object> values) {
		return e.getValue();
	}

	protected BigDecimal internalEvaluate(Plus plus,
			ImmutableMap<String, Object> values) {
		return evaluateNumeric(plus.getLeft(), values).add(
				evaluateNumeric(plus.getRight(), values));
	}

	protected BigDecimal internalEvaluate(Minus minus,
			ImmutableMap<String, Object> values) {
		return evaluateNumeric(minus.getLeft(), values).subtract(
				evaluateNumeric(minus.getRight(), values));
	}

	protected BigDecimal internalEvaluate(Div div,
			ImmutableMap<String, Object> values) {

		BigDecimal left = evaluateNumeric(div.getLeft(), values);
		BigDecimal right = evaluateNumeric(div.getRight(), values);
		return left.divide(right, 20, RoundingMode.HALF_UP);
	}

	protected BigDecimal internalEvaluate(Multi multi,
			ImmutableMap<String, Object> values) {
		return evaluateNumeric(multi.getLeft(), values).multiply(
				evaluateNumeric(multi.getRight(), values));
	}

	protected BigDecimal internalEvaluate(Modulo mod,
			ImmutableMap<String, Object> values) {

		// remainder(), can be negative.
		return evaluateNumeric(mod.getLeft(), values).remainder(
				evaluateNumeric(mod.getRight(), values));
	}

	// /////////////////////////////////////
	// Boolean returning expression methods.
	// //////////////////////////////////////

	protected Boolean internalEvaluate(And e,
			ImmutableMap<String, Object> values) {
		return evaluateBoolean(e.getLeft(), values)
				&& evaluateBoolean(e.getRight(), values);
	}

	protected Boolean internalEvaluate(Or e, ImmutableMap<String, Object> values) {
		return evaluateBoolean(e.getLeft(), values)
				|| evaluateBoolean(e.getRight(), values);
	}

	protected Boolean internalEvaluate(BooleanLiteral e,
			ImmutableMap<String, Object> values) {
		return e.isCondition();
	}

	protected Boolean internalEvaluate(Equal equal,
			ImmutableMap<String, Object> values) {
		int comp = internalEvaluate(equal.getLeft(), equal.getRight(), values);
		return (comp == 0);
	}

	protected Boolean internalEvaluate(Unequal unequal,
			ImmutableMap<String, Object> values) {
		int comp = internalEvaluate(unequal.getLeft(), unequal.getRight(),
				values);
		return (comp != 0);
	}

	// protected int internalEvaluateBoolean(Expression left, Expression right,
	// ImmutableMap<String, BigDecimal> values) {
	//
	// int comp = evaluateNumeric(left, values).compareTo(
	// evaluateNumeric(right, values));
	// return comp;
	// }

	protected Boolean internalEvaluate(Lesser lesser,
			ImmutableMap<String, Object> values) {
		int comp = internalEvaluate(lesser.getLeft(), lesser.getRight(), values);
		return (comp == -1);
	}

	protected Boolean internalEvaluate(LesserEqual lesserEqual,
			ImmutableMap<String, Object> values) {
		int comp = internalEvaluate(lesserEqual.getLeft(),
				lesserEqual.getRight(), values);
		return (comp == -1 || comp == 0);
	}

	protected Boolean internalEvaluate(Greater greater,
			ImmutableMap<String, Object> values) {
		int comp = internalEvaluate(greater.getLeft(), greater.getRight(),
				values);
		return (comp == 1);
	}

	protected Boolean internalEvaluate(GreaterEqual greaterEqual,
			ImmutableMap<String, Object> values) {
		int comp = internalEvaluate(greaterEqual.getLeft(),
				greaterEqual.getRight(), values);
		return (comp == 1);
	}

	/**
	 * Called by various comparison expressions.
	 * 
	 * @param left
	 * @param right
	 * @param values
	 * @return
	 */
	protected int internalEvaluate(Expression left, Expression right,
			ImmutableMap<String, Object> values) {

		Object leftEval = evaluate(left, values);
		Object rightEval = evaluate(right, values);
		if (assertNumeric(leftEval, rightEval)) {
			int comp = evaluateNumeric(left, values).compareTo(
					evaluateNumeric(right, values));
			return comp;
		}
		if (assertBoolean(leftEval, rightEval)) {
			int comp = (Boolean) leftEval == (Boolean) rightEval ? 0 : 1;
			return comp;
		}
		return 0;
	}

	// /////////////////////////////////////
	// UNARY EXPRESSIONS
	// //////////////////////////////////////

	/**
	 * Negation for boolean primary values. Throws a failure in case of a
	 * non-boolean negation.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	protected Boolean internalEvaluate(Negation e,
			ImmutableMap<String, Object> values) {
		Object rightEval = evaluate(e.getRight(), values);
		if (assertBoolean(rightEval)) {
			return !((Boolean) rightEval);
		} else {
			throw new UnsupportedOperationException(e.toString());
		}
	}

	/**
	 * Negation for boolean primary values. Throws a failure in case of a
	 * non-boolean negation.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	protected BigDecimal internalEvaluate(UnaryPlusMinus e,
			ImmutableMap<String, Object> values) {
		Object rightEval = evaluate(e.getRight(), values);
		if (assertNumeric(rightEval)) {
			if (e.getOp().equals("+")) {
				return (BigDecimal) rightEval;
			} else {
				return ((BigDecimal) rightEval).negate();
			}
		} else {
			throw new UnsupportedOperationException(e.toString());
		}
	}

	// Assertion on expected types.
	// How to build the grammar, that types represent expression types, and
	// avoid casting?

	protected boolean assertBoolean(Object eval) {
		return (eval instanceof Boolean);
	}

	protected boolean assertBoolean(Object left, Object right) {
		return (left instanceof Boolean && right instanceof Boolean);
	}

	protected boolean assertNumeric(Object eval) {
		return (eval instanceof BigDecimal);
	}

	protected boolean assertNumeric(Object left, Object right) {
		return (left instanceof BigDecimal && right instanceof BigDecimal);
	}

	protected boolean assertCollection(Object eval) {
		return (eval instanceof EList<?>);
	}
	
}

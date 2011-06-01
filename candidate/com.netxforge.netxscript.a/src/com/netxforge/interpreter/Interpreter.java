package com.netxforge.interpreter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.netxforge.netxscript.And;
import com.netxforge.netxscript.Argument;
import com.netxforge.netxscript.Block;
import com.netxforge.netxscript.BooleanLiteral;
import com.netxforge.netxscript.Div;
import com.netxforge.netxscript.Equal;
import com.netxforge.netxscript.Expression;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.FunctionCall;
import com.netxforge.netxscript.Greater;
import com.netxforge.netxscript.GreaterEqual;
import com.netxforge.netxscript.Lesser;
import com.netxforge.netxscript.LesserEqual;
import com.netxforge.netxscript.Minus;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.Modulo;
import com.netxforge.netxscript.Multi;
import com.netxforge.netxscript.Negation;
import com.netxforge.netxscript.NumberLiteral;
import com.netxforge.netxscript.Or;
import com.netxforge.netxscript.Plus;
import com.netxforge.netxscript.Statement;
import com.netxforge.netxscript.UnaryPlusMinus;
import com.netxforge.netxscript.Unequal;
import com.netxforge.netxscript.VarOrArgumentCall;
import com.netxforge.netxscript.Variable;


/**
 * an interpreter for instances of EClasses of the {@link ArithmeticsPackage}.
 * 
 * It internally uses a polymorphic dispatcher to dispatch between the
 * implementations for the different EClasses.
 *
 * 
 *
 *
 *
 * @author Sven Efftinge - initial contribution and API
 * @author dzonekl - Extended the grammar, see NetXScript.
 */
public class Interpreter {

	private PolymorphicDispatcher<BigDecimal> dispatcher = PolymorphicDispatcher
			.createForSingleTarget("internalEvaluate", 2, 2, this);

	// private PolymorphicDispatcher dispatcher = PolymorphicDispatcher
	// .createForVarTarget("internalEvaluate", this);

	/**
	 * We execute the first function in the module. The subsequent functions,
	 * are considered internal and can be called from within the first function.
	 * 
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
		}
		return null; // Shouldn't happen syntacticly as a module should have at
						// least one function.
	}

	/**
	 * The last statement of the function is returned.
	 * 
	 * @param function
	 * @return
	 */
	public Object evaluate(Function function) {
		return evaluate(function, ImmutableMap.<String, BigDecimal> of());
	}

	public Object evaluate(Function function,
			ImmutableMap<String, BigDecimal> values) {

		// TODO, remove later.
		// return evaluate(function.getScope(), values);
		return dispatcher.invoke(function.getBlock(), values);
	}

	// Dispatch methods, main entry class.
	public Object evaluate(Expression obj) {
		return evaluate(obj, ImmutableMap.<String, BigDecimal> of());
	}

	public Object evaluate(Expression obj,
			ImmutableMap<String, BigDecimal> values) {
		return dispatcher.invoke(obj, values);
	}

	/**
	 * Legacy call, would not be called internally.
	 * 
	 * @param obj
	 * @return
	 */
	public BigDecimal evaluateNumeric(Expression obj) {
		return evaluateNumeric(obj, ImmutableMap.<String, BigDecimal> of());
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
			ImmutableMap<String, BigDecimal> values) {
		Object eval = dispatcher.invoke(e, values);
		if (assertNumeric(eval)) {
			return (BigDecimal) eval;
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
			ImmutableMap<String, BigDecimal> values) {
		Object eval = dispatcher.invoke(e, values);
		if (assertBoolean(eval)) {
			return (Boolean) eval;
		} else {
			throw new UnsupportedOperationException(e.toString());
		}
	}

	// /////////////////////////////////////
	// BLOCKS AND STATEMENTS
	// //////////////////////////////////////

	/**
	 * A Block is a series of statements. Statements are either evaluated or
	 * simply defined. (Nothing happens). Side effects, (Setting of external
	 * variables) are parked.
	 */
	protected Object internalEvaluate(Block block,
			ImmutableMap<String, BigDecimal> values) {
		Object eval = null;
		for (Statement statement : block.getStatements()) {
			eval = dispatcher.invoke(statement, values);
			int index = block.getStatements().indexOf(statement);
			System.out.println("Statement (" + index + ") result:" + eval);
		}
		return eval;
	}
	
	
	/**
	 * Root class, which contains an expression, evaluate on the expression, or 
	 * threat as a blank. 
	 * @param statement
	 * @param values
	 * @return
	 */
	protected Object internalEvaluate(Statement statement,
			ImmutableMap<String, BigDecimal> values) {

		if (statement.getExpression() != null) {
			return evaluate((Expression) statement.getExpression(), values);
		} else {
			// TODO, blank Statement. 
			return null;
		}
	}

	protected Object internalEvaluate(Variable var,
			ImmutableMap<String, BigDecimal> values) {
		var.getName();
		// return evaluate((Expression) statement.getExpression(), values);
		return null;
	}

	// /////////////////////////////////////
	// REFERENCE EXPRESSIONS (CALLS)
	// //////////////////////////////////////

	protected Object internalEvaluate(Argument e,
			ImmutableMap<String, BigDecimal> values) {
		throw new UnsupportedOperationException(e.toString());
	}

	/**
	 * Function call. Executes the function definition, stored in the function
	 * call. the arguments of the function, are passed as values.
	 */
	protected Object internalEvaluate(FunctionCall e,
			ImmutableMap<String, BigDecimal> values) {

		// CB, moved to AssignementCall.
		// if (e.getFunc() instanceof DeclaredParameter) {
		// return values.get(e.getFunc().getName());
		// }

		Function function = (Function) e.getFunc();
		Map<String, BigDecimal> params = Maps.newHashMap();

		for (int i = 0; i < e.getArgs().size(); i++) {
			Argument arg = function.getArgs().get(i);
			BigDecimal evaluate = evaluateNumeric(e.getArgs().get(i), values);
			params.put(arg.getName(), evaluate);
		}

		// Puts the values of the arguments into a new evaluation, using the
		// expression
		// of the definition.
		return evaluate(function, ImmutableMap.copyOf(params));
	}

	/**
	 * Assignment call, could be a defined function argument.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	protected Object internalEvaluate(VarOrArgumentCall e,
			ImmutableMap<String, BigDecimal> values) {

		if (e.getCall() instanceof Argument) {
			return values.get(((Argument) e.getCall()).getName());
		}

		if (e.getCall() instanceof Variable) {
			Variable var = (Variable) e.getCall();
			return evaluate((Expression) var.getExpression(), values);
		}
		throw new UnsupportedOperationException(e.toString());
	}

	// /////////////////////////////////////
	// UNSUPPORTED EXPRESSIONS
	// //////////////////////////////////////

	protected void internalEvaluate(Expression e,
			ImmutableMap<String, BigDecimal> values) {
		System.out
				.println("TODO, implement evaluation rule for expression type: "
						+ e.eClass().getName());
		// throw new UnsupportedOperationException(e.toString());
	}

	// /////////////////////////////////////
	// NUMERIC EXPRESSIONS
	// //////////////////////////////////////
	protected BigDecimal internalEvaluate(NumberLiteral e,
			ImmutableMap<String, BigDecimal> values) {
		return e.getValue();
	}

	protected BigDecimal internalEvaluate(Plus plus,
			ImmutableMap<String, BigDecimal> values) {
		return evaluateNumeric(plus.getLeft(), values).add(
				evaluateNumeric(plus.getRight(), values));
	}

	protected BigDecimal internalEvaluate(Minus minus,
			ImmutableMap<String, BigDecimal> values) {
		return evaluateNumeric(minus.getLeft(), values).subtract(
				evaluateNumeric(minus.getRight(), values));
	}

	protected BigDecimal internalEvaluate(Div div,
			ImmutableMap<String, BigDecimal> values) {

		BigDecimal left = evaluateNumeric(div.getLeft(), values);
		BigDecimal right = evaluateNumeric(div.getRight(), values);
		return left.divide(right, 20, RoundingMode.HALF_UP);
	}

	protected BigDecimal internalEvaluate(Multi multi,
			ImmutableMap<String, BigDecimal> values) {
		return evaluateNumeric(multi.getLeft(), values).multiply(
				evaluateNumeric(multi.getRight(), values));
	}

	protected BigDecimal internalEvaluate(Modulo mod,
			ImmutableMap<String, BigDecimal> values) {

		// remainder(), can be negative.
		return evaluateNumeric(mod.getLeft(), values).remainder(
				evaluateNumeric(mod.getRight(), values));
	}

	// /////////////////////////////////////
	// Boolean returning expression methods.
	// //////////////////////////////////////

	protected Boolean internalEvaluate(And e,
			ImmutableMap<String, BigDecimal> values) {
		return evaluateBoolean(e.getLeft(), values)
				&& evaluateBoolean(e.getRight(), values);
	}

	protected Boolean internalEvaluate(Or e,
			ImmutableMap<String, BigDecimal> values) {
		return evaluateBoolean(e.getLeft(), values)
				|| evaluateBoolean(e.getRight(), values);
	}

	protected Boolean internalEvaluate(BooleanLiteral e,
			ImmutableMap<String, BigDecimal> values) {
		return e.isCondition();
	}

	protected Boolean internalEvaluate(Equal equal,
			ImmutableMap<String, BigDecimal> values) {
		int comp = internalEvaluate(equal.getLeft(), equal.getRight(), values);
		return (comp == 0);
	}

	protected Boolean internalEvaluate(Unequal unequal,
			ImmutableMap<String, BigDecimal> values) {
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
			ImmutableMap<String, BigDecimal> values) {
		int comp = internalEvaluate(lesser.getLeft(), lesser.getRight(), values);
		return (comp == -1);
	}

	protected Boolean internalEvaluate(LesserEqual lesserEqual,
			ImmutableMap<String, BigDecimal> values) {
		int comp = internalEvaluate(lesserEqual.getLeft(),
				lesserEqual.getRight(), values);
		return (comp == -1 || comp == 0);
	}

	protected Boolean internalEvaluate(Greater greater,
			ImmutableMap<String, BigDecimal> values) {
		int comp = internalEvaluate(greater.getLeft(), greater.getRight(),
				values);
		return (comp == 1);
	}

	protected Boolean internalEvaluate(GreaterEqual greaterEqual,
			ImmutableMap<String, BigDecimal> values) {
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
			ImmutableMap<String, BigDecimal> values) {

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
			ImmutableMap<String, BigDecimal> values) {
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
			ImmutableMap<String, BigDecimal> values) {
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
}

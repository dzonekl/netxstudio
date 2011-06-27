package com.netxforge.interpreter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxscript.AbsoluteRef;
import com.netxforge.netxscript.AbstractVarOrArgument;
import com.netxforge.netxscript.And;
import com.netxforge.netxscript.Argument;
import com.netxforge.netxscript.Assignment;
import com.netxforge.netxscript.Block;
import com.netxforge.netxscript.BooleanLiteral;
import com.netxforge.netxscript.ComponentRef;
import com.netxforge.netxscript.ContextRef;
import com.netxforge.netxscript.Div;
import com.netxforge.netxscript.Equal;
import com.netxforge.netxscript.Expression;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.FunctionCall;
import com.netxforge.netxscript.Greater;
import com.netxforge.netxscript.GreaterEqual;
import com.netxforge.netxscript.If;
import com.netxforge.netxscript.LeafReference;
import com.netxforge.netxscript.Lesser;
import com.netxforge.netxscript.LesserEqual;
import com.netxforge.netxscript.LinkRef;
import com.netxforge.netxscript.Minus;
import com.netxforge.netxscript.Mod;
import com.netxforge.netxscript.Modulo;
import com.netxforge.netxscript.Multi;
import com.netxforge.netxscript.NativeExpression;
import com.netxforge.netxscript.NativeFunction;
import com.netxforge.netxscript.Negation;
import com.netxforge.netxscript.NetxscriptFactory;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.NumberLiteral;
import com.netxforge.netxscript.Or;
import com.netxforge.netxscript.Plus;
import com.netxforge.netxscript.PlusAssignment;
import com.netxforge.netxscript.RangeLiteral;
import com.netxforge.netxscript.RefAssignment;
import com.netxforge.netxscript.Reference;
import com.netxforge.netxscript.ResourceRef;
import com.netxforge.netxscript.Return;
import com.netxforge.netxscript.Statement;
import com.netxforge.netxscript.UnaryPlusMinus;
import com.netxforge.netxscript.Unequal;
import com.netxforge.netxscript.ValueKind;
import com.netxforge.netxscript.ValueRange;
import com.netxforge.netxscript.VarOrArgumentCall;
import com.netxforge.netxscript.Variable;
import com.netxforge.netxscript.While;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.generics.impl.DateTimeRangeImpl;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.RangeKind;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;

/**
 * An interpreter for instances of EClasses of the {@link NetxscriptPackage}.
 * 
 * It internally uses a polymorphic dispatcher to dispatch between the
 * implementations for the different EClasses.
 * 
 * TODO Numeric evaluations, should consider ranges. TODO Perform error
 * handling, we know perform type specific evaluations which ought to succeed
 * with a post evaluation type check.
 * 
 * Has a context index, used by the eval-snippets.
 * 
 * TODO: When a context is mandatory, we would throw an exception for a Missing
 * Context.
 * 
 * @author Sven Efftinge - initial contribution and API
 * @author dzonekl - Extended the grammar, see NetXScript.
 */
public class InterpreterTypeless implements IInterpreter {

	@Inject
	INativeFunctions nativeFunctions;// = new NativeFunctions();

	@Inject
	IPrettyLog pLog;// = new PrettyLog();

	@Inject
	ModelUtils modelUtils;// = new ModelUtils();

	@Inject
	IDataService dataService;

	private PolymorphicDispatcher<BigDecimal> dispatcher = PolymorphicDispatcher
			.createForSingleTarget("internalEvaluate", 2, 2, this);

	// private PolymorphicDispatcher dispatcher = PolymorphicDispatcher
	// .createForVarTarget("internalEvaluate", this);

	/**
	 * The first Context always corresponds to 'this' in the grammar. Additional
	 * context, contain the period range for an expression.
	 * 
	 */
	private List<IInterpreterContext> contextList = Lists.newArrayList();

	/**
	 * An index of all context.
	 */
	Map<Class<?>, IInterpreterContext> contextIndex = Maps.newHashMap();

	/**
	 * The result of our expression.
	 */
	private List<ExpressionResult> result = Lists.newArrayList();

	/**
	 * Construct without a root object constraint.
	 */
	public InterpreterTypeless() {

	}

	/**
	 * Clear the interpreter if it's re-used.
	 */
	public void clear() {
		result.clear();
		contextIndex.clear();
		contextList.clear();
	}

	public void setContext(IInterpreterContext... context) {
		this.contextList.addAll(Lists.newArrayList(context));
		this.initialize();
	}

	public void setContext(IInterpreterContext context) {
		this.contextList.add(context);
		this.initialize();
	}

	private void initialize() {
		this.generateContextIndex();

	}

	/**
	 * The context index provides an easy lookup for expressions, which need
	 * access to certain types of context.
	 */
	private void generateContextIndex() {
		for (IInterpreterContext context : contextList) {
			contextIndex.put(context.getContext().getClass(), context);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.IInterpreter#evaluate(com.netxforge.netxscript
	 * .Mod)
	 */
	public Object evaluate(Mod module) {
		// Create an expression result:
		if (module.getFunctions().size() > 0) {
			Function f = module.getFunctions().get(0);
			// TODO, this is where we need to set the arguments if any.
			// We would then call the function evaluation including values.
			// Or the first function has no arguments?
			pLog.log("Calling first function: '" + f.getName()
					+ "' Additional Functions:"
					+ (module.getFunctions().size() - 1));
			return evaluate(f);
		} else {
			// Dispatch on single statements.
			return dispatcher.invoke(module.getStatements(),
					ImmutableMap.<String, Object> of());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.IInterpreter#evaluate(com.netxforge.netxscript
	 * .Function)
	 */
	public Object evaluate(Function function) {
		return evaluate(function, ImmutableMap.<String, Object> of());
	}

	private Object evaluate(Function function,
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
	private Object evaluate(Block block, ImmutableMap<String, Object> values) {
		return dispatcher.invoke(block, values);
	}

	// Dispatch methods, main entry class.
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.IInterpreter#evaluate(com.netxforge.netxscript
	 * .Expression)
	 */
	public Object evaluate(Expression obj) {
		return evaluate(obj, ImmutableMap.<String, Object> of());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.interpreter.IInterpreter#evaluate(com.netxforge.netxscript
	 * .Expression, com.google.common.collect.ImmutableMap)
	 */
	public Object evaluate(Expression obj, ImmutableMap<String, Object> values) {
		return dispatcher.invoke(obj, values);
	}

	/**
	 * A dispatch call, which we expect to return a decimal. Will throw an
	 * exception if not.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	private BigDecimal evaluateNumeric(Expression e,
			ImmutableMap<String, Object> values) {
		Object eval = dispatcher.invoke(e, values);
		if (assertNumeric(eval)) {
			return (BigDecimal) eval;
		} else {
			throw new UnsupportedOperationException(e.toString());
		}
	}

	/**
	 * A dispatch call, which we expect to return a collection of values.
	 * 
	 * @param e
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<?> evaluateCollection(Expression e,
			ImmutableMap<String, Object> values) {
		Object eval = dispatcher.invoke(e, values);
		if (assertCollection(eval)) {
			return (List<?>) eval;
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
	private Boolean evaluateBoolean(Expression e,
			ImmutableMap<String, Object> values) {
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
	 * definitions and assignments are pre-evaluated. We maintain a map of
	 * pre-evaluated values, to be used by calls. (Argument or Variable).
	 * 
	 * Returns either the return statement or a list of scoped variables.
	 * 
	 */
	@SuppressWarnings("unchecked")
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
				pLog.log("return encountered, postpone return evaluation");
				return statement;
			}

			// FIXME, SHOULD REALLY SKIP EVALUATION, IF WE DEAL WITH AN
			// ASSIGNEMNT
			// TYPE STATEMENT.
			Object eval = dispatcher.invoke(statement,
					ImmutableMap.copyOf(localVarsAndArguments));

			{
				// Merge the returned locals.
				if (eval instanceof Map<?, ?>) {
					Map<String, Object> innerMap = (Map<String, Object>) eval;
					for (String s : innerMap.keySet()) {
						if (localVarsAndArguments.containsKey(s)) {
							Object innerValue = innerMap.get(s);
							localVarsAndArguments.put(s, innerValue);
						}
					}
				}
			}

			{ // Pre-evaluation of variables and assignments.

				if (statement instanceof Argument) {
					// We don't reassign values to arguments.
				}

				if (statement instanceof Variable) {
					Variable v = (Variable) statement;
					if (v.getExpression() != null) {
						Object varEval = dispatcher.invoke(v.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));
						localVarsAndArguments.put(v.getName(), varEval);
					}
				}
				if (statement instanceof Assignment) {
					Assignment a = (Assignment) statement;
					// We now need to get 'left' as the expression will not have
					// been assigned to this.

					if (a.getExpression() != null) {

						Object varEval = dispatcher.invoke(a.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));
						localVarsAndArguments.put(
								((Variable) a.getVar()).getName(), varEval);

					}
				}

				if (statement instanceof PlusAssignment) {
					PlusAssignment pa = (PlusAssignment) statement;
					AbstractVarOrArgument var = pa.getVar();

					// TODO, supportin indexed assignements.
//					if (pa.getExpression().getIndex() != null) {
//					}

					VarOrArgumentCall call = NetxscriptFactory.eINSTANCE
							.createVarOrArgumentCall();
					call.setCall(var);

					// Now we need to construct a new Plus expression.
					// Left is our assigned variable made as a call.
					Plus p = NetxscriptFactory.eINSTANCE.createPlus();

					p.setLeft(call);
					// Oops, make a copy. 
					Expression eCopy = EcoreUtil.copy(pa.getExpression());
					p.setRight(eCopy);

					Object varEval = dispatcher.invoke(p,
							ImmutableMap.copyOf(localVarsAndArguments));

					localVarsAndArguments.put(((Variable) var).getName(),
							varEval);

				}

				if (statement instanceof RefAssignment) {
					RefAssignment refa = (RefAssignment) statement;

					// We unfortunately, can't use the dispatched to get to the
					// leaf
					// reference, so we use a recursive way to get it.
					Reference targetReference = refa.getRef();
					LeafReference resourceRef = null;
					if (targetReference instanceof AbsoluteRef) {
						resourceRef = ((AbsoluteRef) targetReference)
								.getPrimaryRef().getLeafRef();
					}
					if (targetReference instanceof ContextRef) {
						resourceRef = ((ContextRef) targetReference)
								.getPrimaryRef().getLeafRef();
					}
					if ((resourceRef instanceof ResourceRef)
							&& (refa.getExpression() != null)) {
						Object varEval = dispatcher.invoke(
								refa.getExpression(),
								ImmutableMap.copyOf(localVarsAndArguments));

						// We can only store ranges of values in an expression
						// result.
						if (varEval instanceof List<?>) {

							// Create a new expression result.
							// TODO, perhaps lookup if the target resource is
							// already being
							// written at????

							ExpressionResult er = LibraryFactory.eINSTANCE
									.createExpressionResult();

							NetXResource res = ((ResourceRef) resourceRef)
									.getResource();
							er.setTargetResource(res);

							// Nuts, to enums for the same type of info....
							ValueRange range = ((ResourceRef) resourceRef)
									.getValuerange();
							switch (range.getValue()) {
							case ValueRange.METRIC_VALUE: {

								// TODO, No Range for Metric.
								// er.setTargetRange(RangeKind.MCAP);
							}
							case ValueRange.CAP_VALUE: {
								er.setTargetRange(RangeKind.CAP);
							}
								break;
							case ValueRange.FORECAST_VALUE: {
								er.setTargetRange(RangeKind.FORECAST);
							}
								break;
							case ValueRange.FORECAST_CAP_VALUE: {
								er.setTargetRange(RangeKind.FORECASTCAP);
							}
								break;
							case ValueRange.UTILIZATION_VALUE: {
								er.setTargetRange(RangeKind.UTILIZATION);
							}
								break;
							}

							List<?> resultValues = (List<?>) varEval;
							for (Object entry : resultValues) {
								if (entry instanceof Value) {
									// rather clumsy way to check the type of a
									// list.
									er.getTargetValues()
											.addAll((Collection<? extends Value>) resultValues);
									break;
								}
								if (entry instanceof BigDecimal) {
									// TODO populate a value list, with
									// timestamp to make it a Value.
									
									
								}
							}
							result.add(er);

						}
						// Whatever was evaluated and should be assigned to a
						// resource.
						// is stored in an Expression result.
					}
				}
			}

			// Print the evaluation result.
			if (eval != null) {
				pLog.log("Statement (" + index + ") result:", eval);
			}
		}
		return localVarsAndArguments;
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
			if (statement.getElse() != null) {
				return evaluate(statement.getElse(), values);
			} else {
				return null;
			}
		}
	}

	/**
	 * While Statement.
	 * 
	 * @param statement
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Object internalEvaluate(While statement,
			ImmutableMap<String, Object> values) {
		Expression predicateExpression = statement.getPredicate();

		// A local map of variables, which corresponds to the underlying
		// variables in the block.
		Map<String, Object> localVarsAndArguments = Maps.newHashMap();
		localVarsAndArguments.putAll(ImmutableMap.copyOf(values));

		Boolean result = evaluateBoolean(predicateExpression,
				ImmutableMap.copyOf(localVarsAndArguments));
		while (result) {
			// This yields many results as a block execution.
			Object o = evaluate(statement.getBody(),
					ImmutableMap.copyOf(localVarsAndArguments));
			if (o instanceof Return) {
				return o;
			}
			if (o instanceof Map<?, ?>) {
				localVarsAndArguments = (Map<String, Object>) o;
				result = evaluateBoolean(predicateExpression,
						ImmutableMap.copyOf(localVarsAndArguments));
			}
		}
		return localVarsAndArguments;
	}

	/**
	 * Return the variable referenced in the assignement. (The expression
	 * evaluation is done in a Block evaluation).
	 * 
	 * @param statement
	 * @param values
	 * @return
	 */
	protected Object internalEvaluate(Assignment statement,
			ImmutableMap<String, Object> values) {
		return statement.getVar();
	}

	/**
	 * Return the variable(self. (The expression evaluation is done in a Block
	 * evaluation).
	 * 
	 * @param var
	 * @param values
	 * @return
	 */
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
		// expression of the definition, note: internal evaluators should
		// consider
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
			if (preEvaluated != null) {
				return preEvaluated;
			}
		}
		// The result of the evaluation?
		if (e.getCall() instanceof Variable) {
			Variable var = (Variable) e.getCall();
			Object preEvaluated = values.get(var.getName());
			if (preEvaluated != null) {
				if (preEvaluated instanceof List<?>) {
					// Get the member of a range.
					if (e.getIndex() != null) {
						Object eval = dispatcher.invoke(e.getIndex(),
								ImmutableMap.copyOf(values));
						if (this.assertNumeric(eval)) {
							return ((List<?>) preEvaluated)
									.get(((BigDecimal) eval).intValue());
						}
					}
				}
				// case for an index on a non-range.
				return preEvaluated;
			} else {
				throw new UnsupportedOperationException(
						"Unassigned variable (leads to cyclic expression call)");
				// if (var.getExpression() != null) {
				// return evaluate((Expression) var.getExpression(), values);
				// }
			}
		}
		// No expression evaluated, this could be as a variable has not been
		// initialized.
		throw new UnsupportedOperationException(e.toString());
	}

	// /////////////////////////////////////
	// REFERENCES
	// //////////////////////////////////////

	protected Object internalEvaluate(RefAssignment e,
			ImmutableMap<String, Object> params) {
		// This is a reference call, which should not do anything
		// really....
		return null;
	}

	protected Object internalEvaluate(Reference e,
			ImmutableMap<String, Object> params) {

		Object eval = null;
		if (e instanceof AbsoluteRef) {
			// What do we do here.
			Reference ref = ((AbsoluteRef) e).getPrimaryRef();
			eval = dispatcher.invoke(ref, ImmutableMap.copyOf(params));
			if(eval == null && ref.getComponents() != null){
				// We get an empty evaluation, so we use the children to return an eval. 
				Reference lastRef = ref.getComponents().get(ref.getComponents().size()-1);
				if(lastRef instanceof ComponentRef){
					// return either the functions or equipments. 
					ComponentRef cr = (ComponentRef)lastRef; 
					if( cr.getEquipment() != null){
						return cr.getEquipment();
					} 
					if( cr.getFunction() != null) {
						return cr.getFunction();
					}
				}
			}
		}
		if (e instanceof ContextRef) {
			// find the actual context. 
			Reference ref = ((ContextRef) e).getPrimaryRef();
			eval = dispatcher.invoke(ref, ImmutableMap.copyOf(params));
			if(eval == null && ref.getComponents() != null){
				// We get an empty evaluation, so we use the children to return an eval. 
				Reference lastRef = ref.getComponents().get(ref.getComponents().size());
				if(lastRef instanceof ComponentRef){
					// return either the functions or equipments. 
					ComponentRef cr = (ComponentRef)lastRef; 
					if( cr.getEquipment() != null){
						return cr.getEquipment();
					} 
					if( cr.getFunction() != null) {
						return cr.getFunction();
					}
				}
			}
		}
		
		// Evaluate a leaf reference (Actually get the values).
		if (e.getLeafRef() != null) {
			eval = dispatcher.invoke(e.getLeafRef(),
					ImmutableMap.copyOf(params));
		} else {
			// We hit a reference, with no end leaf.
			// So we propably mean the actual object.
		}
		return eval;
	}
	

	// TODO, Not implemented yet.
	protected void internalEvaluate(LinkRef e,
			ImmutableMap<String, Object> values) {
		// Could be any type of reference, even nested.
		pLog.log("Found a link reference", e.getLink());
	}

	protected List<Value> internalEvaluate(ResourceRef e,
			ImmutableMap<String, Object> values) {

		// This is where we grab the values based on a date range, if we have a
		// context.
		//
		List<Value> v = null; // Will be populated with the ranges.

		DateTimeRange dtr = null;
		IInterpreterContext context = contextIndex.get(DateTimeRangeImpl.class);
		if (context != null) {
			dtr = (DateTimeRange) context.getContext();
		} else {
			dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
		}

		// The period hint is 60 Minutes, but should be able to return
		// values for if this range is not available.
		NetXResource resource = e.getResource();
		boolean targetRangeAvailable = false;

		// Feed the query with the kind hint.
		KindHintType targetKind = null;
		if (e.getKind() != null) {
			if (e.getKind() == ValueKind.AVG) {
				targetKind = KindHintType.AVG;
			}
			if (e.getKind() == ValueKind.BH) {
				targetKind = KindHintType.BH;
			}
		}

		int targetPeriod;
		if (e.getPeriod() != null) {
			targetPeriod = e.getPeriod().intValue();
		} else {
			// Use hour values?
			// TODO MAKE THIS AN OPTIONAL PART, IN EXPRESSION AND APP WIDE>
			targetPeriod = 60;
		}

		// Loop the ranges, to find the correct range.
		for (MetricValueRange mvr : resource.getMetricValueRanges()) {
			int period = mvr.getPeriodHint();
			KindHintType kht = mvr.getKindHint();
			if (period == targetPeriod && kht == targetKind) {
				targetRangeAvailable = true;
				break;
			}
		}

		IQueryService qService = dataService.getQueryService();
		// We can only get the range, if it's actually available.
		if (targetRangeAvailable) {

			switch (e.getValuerange().getValue()) {
			case ValueRange.METRIC_VALUE: {
				// v = e.getResource().getMetricValueRanges().get(0)
				// .getMetricValues();
				// TODO, we should really accept the expression name here?
				v = qService.getValuesFromResource(
						resource.getExpressionName(), dtr.getBegin(),
						dtr.getEnd(), targetPeriod, targetKind);
			}
				break;
			case ValueRange.CAP_VALUE: {
				v = e.getResource().getCapacityValues();
				// TODO, need query for this!
			}
				break;
			case ValueRange.UTILIZATION_VALUE: {
				v = e.getResource().getUtilizationValues();
				// TODO, need query for this!
			}
				break;
			}

			// We want the Value object without the timestamp, as we know the
			// period
			// context.
			return v;
		} else {
			pLog.log("Target range is not available", new Object[] {});
			return null;
		}
	}

	// /////////////////////////////////////
	// NATIVE FUNCTIONS
	// //////////////////////////////////////

	protected Object internalEvaluate(NativeExpression ne,
			ImmutableMap<String, Object> values) {

		// Invocations on a RangeLiteral or Reference.
		List<?> range = null;
		if (ne.getRange() != null) {
			range = (List<?>) dispatcher.invoke(ne.getRange(),
					ImmutableMap.copyOf(values));
		}

		if (ne.getRef() != null) {
			Object eval = dispatcher.invoke(ne.getRef(),
					ImmutableMap.copyOf(values));
			if (eval instanceof List<?>) {
				range = (List<?>) eval;
			}
			if( eval instanceof com.netxforge.netxstudio.library.Function){
				// TODO, we need an ocl expression for this. 
//				range = ((com.netxforge.netxstudio.library.Function)eval).getAllFunctions();
				System.out.println("TODO : range =  the number of functions from this");
			}
			if(eval instanceof Equipment){
//				range = ((Equipment)eval).getAllEquipments();
				System.out.println("TODO : range =  the number of equipments from this");
			}
		}
		if (ne.getVar() != null) {
			// Lookup the variable, by it's expression.
			if (ne.getVar() != null) {
				Object eval = dispatcher.invoke(ne.getVar(),
						ImmutableMap.copyOf(values));
				if (eval instanceof List<?>) {
					range = (List<?>) eval;
				}
			}
		}

		if (range != null && ne.getNativeFunction() != null) {
			NativeFunction nf = ne.getNativeFunction();
			switch (nf.getValue()) {
			case NativeFunction.SUM_VALUE: {
				return nativeFunctions.sum(range);
			}
			case NativeFunction.COUNT_VALUE: {
				return nativeFunctions.count(range);
			}
			case NativeFunction.MAX_VALUE: {
				return nativeFunctions.max(range);
			}
			case NativeFunction.MIN_VALUE: {
				return nativeFunctions.min(range);
			}
			case NativeFunction.MEAN_VALUE: {
				return nativeFunctions.mean(range);
			}
			case NativeFunction.DEVIATION_VALUE: {
				return nativeFunctions.standardDeviation(range);
			}
			}
		}
		return range;
	}

	// /////////////////////////////////////
	// UNSUPPORTED ABSTRACTS
	// //////////////////////////////////////

	protected void internalEvaluate(Expression e,
			ImmutableMap<String, Object> values) {
		pLog.log("TODO, implement evaluation rule for expression type: ", e);
	}

	// /////////////////////////////////////
	// NUMERIC EXPRESSIONS
	// //////////////////////////////////////
	protected BigDecimal internalEvaluate(NumberLiteral e,
			ImmutableMap<String, Object> values) {
		return e.getValue();
	}

	protected List<BigDecimal> internalEvaluate(RangeLiteral e,
			ImmutableMap<String, Object> values) {

		// check for an empty range.
		if (e.getValues() == null) {
			return Lists.newArrayList();
		} else {
			return ImmutableList.copyOf(e.getValues());
		}
	}

	protected Object internalEvaluate(Plus plus,
			ImmutableMap<String, Object> values) {

		// Various adding combinations.
		//
		Object leftEval = evaluate(plus.getLeft(), values);
		Object rightEval = evaluate(plus.getRight(), values);

		if (assertNumeric(leftEval)) {
			if (assertNumeric(rightEval)) {
				return ((BigDecimal) leftEval).add((BigDecimal) rightEval);
			}
		}
		if (assertCollection(leftEval)) {
			List<Object> leftEvalAsList = Lists
					.newArrayList((List<?>) leftEval);
			if (assertNumeric(rightEval)) {
				// Build a new list.
				leftEvalAsList.add(rightEval);
				return ImmutableList.copyOf(leftEvalAsList);
			}
			if(assertValue(rightEval)){
				Value v = (Value)rightEval;
				leftEvalAsList.add(new BigDecimal(v.getValue()));
				return ImmutableList.copyOf(leftEvalAsList);
			}
		}
		

		throw new UnsupportedOperationException(
				"Plus expression for invalid types");

	}

	protected BigDecimal internalEvaluate(Minus minus,
			ImmutableMap<String, Object> values) {
		return evaluateNumeric(minus.getLeft(), values).subtract(
				evaluateNumeric(minus.getRight(), values));
	}

	protected BigDecimal internalEvaluate(Div div,
			ImmutableMap<String, Object> values) {

		// Evaluate as single value or range.
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
		return (comp == 1 || comp == 0);
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
	
	protected boolean assertValue(Object eval) {
		return (eval instanceof Value);
	}
	
	protected boolean assertValueOrNumeric(Object eval) {
		return assertNumeric(eval) || assertValue(eval);
	}

	protected boolean assertNumeric(Object left, Object right) {
		return (left instanceof BigDecimal && right instanceof BigDecimal);
	}

	protected boolean assertCollection(Object eval) {
		return (eval instanceof List<?>);
	}

	@Override
	public String toString() {
		return Joiner.on(",").join(contextList);
	}

	public List<ExpressionResult> getResult() {
		return result;
	}

}

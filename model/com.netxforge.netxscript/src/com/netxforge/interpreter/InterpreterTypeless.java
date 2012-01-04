package com.netxforge.interpreter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.netxscript.AbstractFunction;
import com.netxforge.netxscript.AbstractVarOrArgument;
import com.netxforge.netxscript.And;
import com.netxforge.netxscript.Argument;
import com.netxforge.netxscript.Assignment;
import com.netxforge.netxscript.Block;
import com.netxforge.netxscript.BooleanLiteral;
import com.netxforge.netxscript.ContextRef;
import com.netxforge.netxscript.Div;
import com.netxforge.netxscript.Equal;
import com.netxforge.netxscript.Expression;
import com.netxforge.netxscript.Function;
import com.netxforge.netxscript.FunctionCall;
import com.netxforge.netxscript.Greater;
import com.netxforge.netxscript.GreaterEqual;
import com.netxforge.netxscript.If;
import com.netxforge.netxscript.Interval;
import com.netxforge.netxscript.IntervalKind;
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
import com.netxforge.netxscript.Statement;
import com.netxforge.netxscript.StatusRef;
import com.netxforge.netxscript.ToleranceLevel;
import com.netxforge.netxscript.UnaryPlusMinus;
import com.netxforge.netxscript.Unequal;
import com.netxforge.netxscript.ValueKind;
import com.netxforge.netxscript.ValueRange;
import com.netxforge.netxscript.VarOrArgumentCall;
import com.netxforge.netxscript.Variable;
import com.netxforge.netxscript.While;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.generics.impl.DateTimeRangeImpl;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.ExpressionResult;
import com.netxforge.netxstudio.library.LastEvaluationExpressionResult;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Parameter;
import com.netxforge.netxstudio.library.RangeKind;
import com.netxforge.netxstudio.library.impl.EquipmentImpl;
import com.netxforge.netxstudio.library.impl.FunctionImpl;
import com.netxforge.netxstudio.library.impl.NetXResourceImpl;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.impl.NodeImpl;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.impl.RFSServiceImpl;
import com.netxforge.netxstudio.services.impl.ServiceUserImpl;

/**
 * An interpreter for instances of EClasses of the {@link NetxscriptPackage}.
 * 
 * It internally uses a polymorphic dispatcher to dispatch between the
 * implementations for the different EClasses.
 * 
 * We now perform type specific evaluations which ought to succeed with a post
 * evaluation type check.
 * 
 * Has a context index, used by the eval-snippets.
 * 
 * Note: All external references, are to be referenced by name and not use the
 * actual reference object. The AST is constructed with an arbitrary (actually
 * the first occurence) reference, according the xtext ResourceDescription )
 * when writing the expression.
 * 
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

	// @Inject
	// IDataService dataService;

	private PolymorphicDispatcher<BigDecimal> dispatcher = PolymorphicDispatcher
			.createForSingleTarget("internalEvaluate", 2, 2, this);

	// private PolymorphicDispatcher dispatcher = PolymorphicDispatcher
	// .createForVarTarget("internalEvaluate", this);

	/**
	 * The result of our expression.
	 */
	private List<BaseExpressionResult> expressionResults = Lists.newArrayList();

	/**
	 * Construct without a root object constraint.
	 */
	public InterpreterTypeless() {

	}

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
	 * Clear the interpreter if it's re-used.
	 */
	public void clear() {
		expressionResults.clear();
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

	private DateTimeRange getContextualPeriod() {
		IInterpreterContext periodContext = getContextFor(DateTimeRangeImpl.class);
		if (periodContext != null) {
			return (DateTimeRange) periodContext.getContext();
		} else {
			throw new java.lang.UnsupportedOperationException(
					"Period context unset, it is always required");
		}
	}

	private Component getContextualComponent() {
		IInterpreterContext componentContext = getContextFor(FunctionImpl.class);
		if (componentContext == null) {
			componentContext = getContextFor(EquipmentImpl.class);
		}
		if (componentContext != null) {
			Component c = (Component) componentContext.getContext();
			return c;
		}
		return null;
	}

	private Node getContextualNode() {

		DateTimeRange contextualPeriod = this.getContextualPeriod();

		// TODO, experiment with this.
		@SuppressWarnings("unused")
		long beginContext = contextualPeriod.getBegin().toGregorianCalendar()
				.getTimeInMillis();

		IInterpreterContext nodeContext = getContextFor(NodeImpl.class);
		if (nodeContext != null) {
			Node n = (Node) nodeContext.getContext();

			return n;
		}
		return null;
	}

	private NetXResource getContextualNetXResource() {
		IInterpreterContext resourceContext = getContextFor(NetXResourceImpl.class);
		if (resourceContext != null) {
			return (NetXResource) resourceContext.getContext();
		} else {
			throw new java.lang.UnsupportedOperationException(
					"Resource context unset, it was however requested for this evaluation");
		}
	}

	private Service getContextualService() {
		IInterpreterContext serviceContext = getContextFor(RFSServiceImpl.class);
		if (serviceContext != null) {
			return (Service) serviceContext.getContext();
		} else {
			return null;
		}
	}

	private ServiceUser getContextualServiceUser() {
		IInterpreterContext serviceContext = getContextFor(ServiceUserImpl.class);
		if (serviceContext != null) {
			return (ServiceUser) serviceContext.getContext();
		} else {
			return null;
		}
	}

	private RFSServiceSummary getContextualServiceSummary() {
		IInterpreterContext serviceContext = getContextFor(RFSServiceSummary.class);
		if (serviceContext != null) {
			return (RFSServiceSummary) serviceContext.getContext();
		} else {
			return null;
		}
	}

	private IInterpreterContext getContextFor(Class<?> claxx) {
		return this.contextIndex.get(claxx);
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
			// Dispatch without functions.
			Object result = dispatcher.invoke(module.getStatements(),
					ImmutableMap.<String, Object> of());
			LastEvaluationExpressionResult lastEvaluation = LibraryFactory.eINSTANCE
					.createLastEvaluationExpressionResult();
			lastEvaluation.setLastEvalResult(result);
			this.expressionResults.add(lastEvaluation);
			return result;
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

			if (statement instanceof Argument
					|| statement instanceof Assignment
					|| statement instanceof Variable
					|| statement instanceof PlusAssignment
					|| statement instanceof RefAssignment) {

				if (statement instanceof Argument) {
					// We don't reassign values to arguments.
				}

				if (statement instanceof Variable) {
					processStatementVariable(localVarsAndArguments, statement);
				}
				if (statement instanceof Assignment) {
					processStatementAssignment(localVarsAndArguments, statement);
				}
				// TODO, We also need other types of Assignments like :
				// *= /= -=
				if (statement instanceof PlusAssignment) {
					processStatementPlusAssignment(localVarsAndArguments,
							statement);
				}
				if (statement instanceof RefAssignment) {
					processStatementRefAssignment(localVarsAndArguments,
							statement);
				}

			} else {

				// For any other statement type, we execute the expression and
				// return the result.
				// In a block, the returned evaluation is merged with the
				// localscope.

				Object eval = dispatcher.invoke(statement,
						ImmutableMap.copyOf(localVarsAndArguments));

				// Print the evaluation result.
				if (eval != null) {
					pLog.log("Statement (" + index + ") result:", eval);
				}

				// Merge the returned locals.
				if (eval instanceof Map<?, ?>) {
					Map<String, Object> innerMap = (Map<String, Object>) eval;
					for (String s : innerMap.keySet()) {
						if (localVarsAndArguments.containsKey(s)) {
							Object innerValue = innerMap.get(s);
							localVarsAndArguments.put(s, innerValue);
						}
					}
				} else {
					// The evaluation is likely a non-assigned value
					// add it to the map with an arbitrary name.
					Random r = new Random();
					String randomName = new Long(r.nextLong()).toString();
					localVarsAndArguments.put(randomName, eval);
				}
			}
		}
		return localVarsAndArguments;
	}

	private void processStatementRefAssignment(
			Map<String, Object> localVarsAndArguments, Statement statement) {
		RefAssignment refa = (RefAssignment) statement;
		if (refa.getExpression() != null) {
			Object varEval = dispatcher.invoke(refa.getExpression(),
					ImmutableMap.copyOf(localVarsAndArguments));

			// Notice:
			// We unfortunately, can't use the dispatched to get to
			// the
			// leaf reference, so we use a recursive way to get it.
			Reference assignmentReference = refa.getAssignmentRef();
			List<BaseResource> targetResources = Lists.newArrayList();
			RangeRef targetRangeReference = null;

			if (assignmentReference instanceof NodeTypeRef) {
				NodeTypeRef nodeTypeRef = (NodeTypeRef) assignmentReference;
				if (nodeTypeRef.getLeafRef() != null) {
					LeafReference leafReference = nodeTypeRef.getPrimaryRef()
							.getLeafRef();
					if (leafReference instanceof ResourceRef) {
						Node n = this.getContextualNode();
						ResourceRef resourceRef = (ResourceRef) leafReference;
						List<NetXResource> netxResources = this
								.resourcesByName(n, resourceRef);
						targetResources
								.add(netxResources.size() > 0 ? netxResources
										.get(0) : null);
						targetRangeReference = resourceRef.getRangeRef();
					}

				}
			}
			if (assignmentReference instanceof ContextRef) {

				ContextRef cRef = (ContextRef) assignmentReference;
				if (cRef.getPrimaryRef() != null
						&& cRef.getPrimaryRef().getLeafRef() instanceof ResourceRef) {
					// evaluate the potential override of the target resource.
					// if there is some sort of navigation.
					// in case of duplicates we take the first occurence of a
					// BaseResource.

					ResourceRef resourceRef = (ResourceRef) cRef
							.getPrimaryRef().getLeafRef();
					if (resourceRef.getResource() instanceof NetXResource) {

						Node n = this.getContextualNode();
						Component c = this.getContextualComponent();

						// How about using the navigation component?
						Object extractLastComponent = this
								.extractLastComponent(cRef.getPrimaryRef(), n);
						if (extractLastComponent != null) {
							// FIXME
						}

						if (c != null) {

							// Rule: Apply to all resources?
							if (resourceRef.isAll()) {
								targetResources.addAll(c.getResourceRefs());
							} else {

								List<NetXResource> netxResources = this
										.resourcesByName(c, resourceRef);
								targetResources.add(netxResources.size() > 0 ? netxResources
										.get(0) : null);
							}

						}
					} else if (resourceRef.getResource() instanceof DerivedResource) {
						ServiceUser su = this.getContextualServiceUser();
						if (su != null) {
							for (DerivedResource dr : su.getServiceProfile()
									.getProfileResources()) {
								if (dr.getExpressionName().equals(
										resourceRef.getResource()
												.getExpressionName())) {
									targetResources.add(dr);
								}
							}
						}
					}

					targetRangeReference = resourceRef.getRangeRef();

					// if (leafReference instanceof StatusRef) {
					// // Can we assign a status?
					// }

				} else {
					// there is no navigation, so we simply set the context
					// resource.
					NetXResource netxRes = this.getContextualNetXResource();
					if (netxRes != null) {
						targetResources.add(netxRes);
					}
				}

				if (cRef.getRangeRef() != null) {
					targetRangeReference = cRef.getRangeRef();
				}
			}
			processExpressionResult(varEval, targetResources,
					targetRangeReference);

		}
	}

	private void processContextRef(ContextRef cRef) {
		BaseResource targetResource = null;
		RangeRef targetRangeReference = null;

		if (cRef.getPrimaryRef() != null && cRef.getRangeRef() != null) {

			LeafReference leafReference = cRef.getPrimaryRef().getLeafRef();
			if (leafReference instanceof ResourceRef) {
				ResourceRef resourceRef = (ResourceRef) leafReference;
				targetResource = resourceRef.getResource();
				targetRangeReference = resourceRef.getRangeRef();
			}
		}
		// Here we assume the context is a ..Resource as there is no
		// leaf.
		if (cRef.getRangeRef() != null) {
			targetResource = this.getContextualNetXResource();
			targetRangeReference = cRef.getRangeRef();
		}

		if (targetResource != null && targetRangeReference != null) {
			this.processExpressionResultRemoval(targetResource,
					targetRangeReference);
		}

	}

	private List<NetXResource> resourcesByName(Node n, ResourceRef resourceRef) {

		List<NetXResource> resources = Lists.newArrayList();
		BaseResource tmpResource = resourceRef.getResource();
		if (tmpResource.getExpressionName() != null) {
			// Find matching resources with this
			// name.
			resources = modelUtils.resourcesWithExpressionName(n,
					tmpResource.getExpressionName());
		}
		return resources;
	}

	private List<NetXResource> resourcesByName(Component c,
			ResourceRef resourceRef) {

		List<NetXResource> resources = Lists.newArrayList();
		BaseResource tmpResource = resourceRef.getResource();
		if (tmpResource.getExpressionName() != null) {
			// Find matching resources with this
			// name.
			resources = modelUtils.resourcesWithExpressionName(
					ImmutableList.of(c), tmpResource.getExpressionName());
		}
		return resources;
	}

	private void processExpressionResultRemoval(BaseResource targetResource,
			RangeRef targetRangeReference) {

		if (targetResource != null && targetRangeReference != null) {

			// Create the new result for this assignment.
			ExpressionResult er = LibraryFactory.eINSTANCE
					.createExpressionResult();

			// Set the target resource to write.
			er.setTargetResource(targetResource);

			int targetInterval = this.extractInterval(targetRangeReference);
			KindHintType type = this.extractKindHint(targetRangeReference);

			er.setTargetKindHint(type);
			er.setTargetIntervalHint(targetInterval);

			// Set the target range.
			ValueRange range = targetRangeReference.getValuerange();
			if (range.getValue() == ValueRange.METRIC_VALUE) {
				er.setTargetRange(RangeKind.METRICREMOVE);
				expressionResults.add(er);
			}

		}
	}

	private void processExpressionResult(Object varEval,
			Collection<? extends BaseResource> collection,
			RangeRef targetRangeReference) {

		if (targetRangeReference != null) {
			for (BaseResource br : collection) {

				// Create the new result for this assignment.
				ExpressionResult er = LibraryFactory.eINSTANCE
						.createExpressionResult();

				// Set the target resource to write.
				er.setTargetResource(br);

				// Note these are two optional paramters.
				int targetInterval = this.extractInterval(targetRangeReference);
				KindHintType type = this.extractKindHint(targetRangeReference);

				if (targetInterval != -1) {
					// Will return 60, if not specified.
					er.setTargetIntervalHint(targetInterval);
				}

				if (type != null) {
					er.setTargetKindHint(type);
				}

				// Set the target range.
				ValueRange range = targetRangeReference.getValuerange();
				switch (range.getValue()) {
				case ValueRange.METRIC_VALUE: {
					er.setTargetRange(RangeKind.METRIC);
				}
					break;
				case ValueRange.TOLERANCE_VALUE: {
					er.setTargetRange(RangeKind.TOLERANCE);
				}
					break;
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
				case ValueRange.DERIVED_VALUE: {
					er.setTargetRange(RangeKind.DERIVED);
				}
					break;

				}

				if (varEval instanceof BigDecimal) {
					// We return a single value.

					// Get the period context, and use the start
					// and end date.
					DateTimeRange dtr = this.getContextualPeriod();
					Value beginValue = GenericsFactory.eINSTANCE.createValue();
					// Set the ts/value.
					beginValue.setTimeStamp(dtr.getBegin());
					beginValue.setValue(((BigDecimal) varEval).doubleValue());

					Value endValue = GenericsFactory.eINSTANCE.createValue();

					// Set the ts/value.
					endValue.setTimeStamp(dtr.getEnd());
					endValue.setValue(((BigDecimal) varEval).doubleValue());

					er.getTargetValues().add(endValue);
					er.getTargetValues().add(beginValue);
					expressionResults.add(er);
				}
				if (varEval instanceof List<?>) {
					// We return a list of values.
					List<?> resultValues = (List<?>) varEval;
					for (Object entry : resultValues) {
						if (entry instanceof Value) {
							er.getTargetValues().add((Value) entry);
						} else if (entry instanceof BigDecimal) {
							Value v = GenericsFactory.eINSTANCE.createValue();
							v.setValue(((BigDecimal) entry).doubleValue());
							// FIXME, We don't set a timestamp!
							er.getTargetValues().add(v);
						}

					}
					expressionResults.add(er);
				}
				// Whatever was evaluated and should be assigned to
				// a
				// resource.
				// is stored in an Expression result.
			}
		}
	}

	private void processStatementPlusAssignment(
			Map<String, Object> localVarsAndArguments, Statement statement) {
		PlusAssignment pa = (PlusAssignment) statement;
		AbstractVarOrArgument var = pa.getVar();

		// TODO, supportin indexed assignements.
		// if (pa.getExpression().getIndex() != null) {
		// }

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

		localVarsAndArguments.put(((Variable) var).getName(), varEval);
	}

	private void processStatementAssignment(
			Map<String, Object> localVarsAndArguments, Statement statement) {
		Assignment a = (Assignment) statement;
		// We now need to get 'left' as the expression will not have
		// been assigned to this.

		if (a.getExpression() != null) {

			Object varEval = dispatcher.invoke(a.getExpression(),
					ImmutableMap.copyOf(localVarsAndArguments));
			localVarsAndArguments.put(((Variable) a.getVar()).getName(),
					varEval);

		}
	}

	private void processStatementVariable(
			Map<String, Object> localVarsAndArguments, Statement statement) {
		Variable v = (Variable) statement;
		if (v.getExpression() != null) {
			Object varEval = dispatcher.invoke(v.getExpression(),
					ImmutableMap.copyOf(localVarsAndArguments));
			localVarsAndArguments.put(v.getName(), varEval);
		}
	}

	private InterpreterException processException(Exception e,
			EObject expressionObject) {

		String msg = "";

		if (e instanceof IndexOutOfBoundsException) {
			msg = "Refering to non existing: " + " ...."; // TODO.
		}

		InterpreterException ie = new InterpreterException(msg);
		ie.setFailedWhileEvaluationMe(expressionObject);
		return ie;
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

		AbstractFunction af = e.getFunc();
		if (af instanceof Function) {
			Function function = (Function) af;

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
		throw new UnsupportedOperationException(
				"function call invalid for function" + e.getFunc());
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
		// Evaluate a leaf reference (Actually get the values).
		if (e.getLeafRef() != null) {
			eval = dispatcher.invoke(e.getLeafRef(),
					ImmutableMap.copyOf(params));
			return eval;
		}
		return eval;
	}

	protected BigDecimal internalEvaluate(ParamRef e,
			ImmutableMap<String, Object> values) {
		Parameter param = e.getParam();
		if (param != null
				&& param.eIsSet(LibraryPackage.Literals.PARAMETER__VALUE)) {
			return new BigDecimal(param.getValue());
		}
		return null;
	}

	protected Object internalEvaluate(NodeRef nodeReference,
			ImmutableMap<String, Object> params) {

		// Not implemented yet.

		return null;
	}

	/*
	 * Note: The NodeTypeRef is always in the context of a service. As from a
	 * node type, we have multiple Node references, Components and resources,
	 * the leaf reference result in evaluated.
	 */
	@SuppressWarnings("unchecked")
	protected Object internalEvaluate(NodeTypeRef nodeTypeReference,
			ImmutableMap<String, Object> params) {

		Service service = this.getContextualService();
		if (service != null) {
			Reference primaryRef = nodeTypeReference.getPrimaryRef();

			NodeType nt = nodeTypeReference.getNodetype();
			List<Node> nodes = modelUtils.nodesForNodeType(
					(RFSService) service, nt);

			List<Component> components = Lists.newArrayList();
			for (Node n : nodes) {
				Object result = extractLastComponent(primaryRef, n);
				if (result != null && (result instanceof List<?>)) {
					components.addAll((Collection<? extends Component>) result);
				}
			}

			if (primaryRef.getLeafRef() == null
					&& primaryRef.getComponents() != null) {
				return components;
			} else if (primaryRef.getLeafRef() != null) {

				List<Object> objects = Lists.newArrayList();
				for (Node n : nodes) {

					Map<String, Object> localVarsAndArguments = Maps
							.newHashMap();
					localVarsAndArguments.putAll(ImmutableMap.copyOf(params));
					localVarsAndArguments.put("node", n);

					Object eval = dispatcher.invoke(primaryRef,
							ImmutableMap.copyOf(localVarsAndArguments));
					if (eval instanceof List<?>) {
						objects.addAll((List<?>) eval);
					} else {
						objects.add(eval);
					}
				}
				return objects;
			}
		}

		return null;
	}

	/*
	 * A genric reference object, test the attributes to know which context is
	 * relevant for further evaluation
	 * 
	 * @param contextReference
	 * 
	 * @param params
	 * 
	 * @return
	 */
	protected Object internalEvaluate(ContextRef contextReference,
			ImmutableMap<String, Object> params) {
		Object eval = null;

		Map<String, Object> localVarsAndArguments = Maps.newHashMap();
		localVarsAndArguments.putAll(ImmutableMap.copyOf(params));

		if (contextReference.getPrimaryRef() != null) {
			Reference primaryRef = contextReference.getPrimaryRef();

			Node node = this.getContextualNode();

			// Check if there is no leaf ref, and it has components and a node
			// context.
			// to get the last referenced component for this node.
			if (primaryRef.getLeafRef() == null
					&& primaryRef.getComponents() != null && node != null) {

				// CB 16-12-2011, changed capacity expression context to be the
				// resource.
				//
				// Node extractNode = this.extractNode(primaryRef);
				// if(extractNode != null){
				// node = extractNode;
				// }

				return extractLastComponent(primaryRef, node);
			} else {
				// If we have a node or a service, set as a param and dispatch
				// for the leaf reference. (As primary ref is not evaluated),
				// the component is ignored!

				// FIXME, this doesn't work, the range ref expects a resource,
				// which should have been set from component evaluation, but
				// that's not done here.

				if (node != null) {
					// Evaluate for a Node.
					localVarsAndArguments.put("node", node);
				} else if (this.getContextualService() != null) {
					// Applies to STATUS and PROFILE keywords.
					Service service = this.getContextualService();
					localVarsAndArguments.put("service", service);
				}

				eval = dispatcher.invoke(primaryRef,
						ImmutableMap.copyOf(localVarsAndArguments));

			}
		}

		// We have a range set, so the context should be a resource.
		if (contextReference.getRangeRef() != null) {
			NetXResource resource = getContextualNetXResource();
			if (resource != null) {
				localVarsAndArguments.put("resource", resource);
				return dispatcher.invoke(contextReference.getRangeRef(),
						ImmutableMap.copyOf(localVarsAndArguments));
			}
		}
		return eval;

	}

	private Object extractLastComponent(Reference primaryRef, Node node) {

		Object result = null;

		// There is no leaf in this context reference,
		// We need to find the components referenced by their name in
		// the context "Node",
		// Let's get the last component referenced.
		Reference lastRef = primaryRef.getComponents().get(
				primaryRef.getComponents().size() - 1);

		if (lastRef instanceof OperatorRef) {
			// return either the functions or equipments.
			OperatorRef cr = (OperatorRef) lastRef;

			if (cr.getEquipment() != null) {

				String eCode = cr.getEquipment().getEquipmentCode();

				if (eCode != null) {
					List<Equipment> equipments = modelUtils.equimentsWithCode(
							node.getNodeType().getEquipments(), eCode);
					result = equipments;
				}

			}
			if (cr.getFunction() != null) {

				String name = cr.getFunction().getName();
				List<com.netxforge.netxstudio.library.Function> functions = modelUtils
						.functionsWithName(node.getNodeType().getFunctions(),
								name);
				result = functions;

				// dataService.getQueryService().getFunctions(
				// node.getNodeID(), name);
			}
		}
		return result;

	}

	// TODO, Not implemented yet.
	protected void internalEvaluate(LinkRef e,
			ImmutableMap<String, Object> values) {
		// Could be any type of reference, even nested.
		pLog.log("Found a link reference", e.getLink());
	}

	protected Object internalEvaluate(StatusRef statusRef,
			ImmutableMap<String, Object> values) {

		Service s = (Service) values.get("service");
		if (s != null) {
			ToleranceLevel tolerancelevel = statusRef.getTolerancelevel();
			// calculate the number of nodes meeting this tolerance level and
			// return the
			// count.
			int count = 0;
			RFSServiceSummary summary = this.getContextualServiceSummary();
			if (summary != null) {
				switch (tolerancelevel.getValue()) {
				case ToleranceLevel.RED_VALUE: {
					count = summary.getRedCountNodes();
				}
					break;
				case ToleranceLevel.AMBER_VALUE: {
					count = summary.getAmberCountNodes();
				}
					break;
				case ToleranceLevel.GREEN_VALUE: {
					count = summary.getGreenCountNodes();
				}
					break;
				case ToleranceLevel.YELLOW_VALUE: {
					// count = summary.getRedCountNodes();
				}
					break;
				}
			}
			return new Integer(count);
		}
		return null;
	}

	protected Object internalEvaluate(ResourceRef resourceRef,
			ImmutableMap<String, Object> params) {

		// copy the parameters.
		Map<String, Object> localVarsAndArguments = Maps.newHashMap();
		localVarsAndArguments.putAll(ImmutableMap.copyOf(params));

		Node n = null;
		if (params.containsKey("node")) {
			n = (Node) params.get("node");
		}

		Service s = null;
		if (params.containsKey("service")) {
			s = (Service) params.get("service");
		}

		try {

			BaseResource resource = null;

			if (n != null) {
				List<NetXResource> netxResources = this.resourcesByName(n,
						resourceRef);
				resource = netxResources.size() > 0 ? netxResources.get(0)
						: null;
			}
			if (s != null) {

				// TODO, What should happen here?
				for (@SuppressWarnings("unused")
				ServiceUser su : s.getServiceUserRefs()) {

				}
			}
			if (resource != null) {

				localVarsAndArguments.put("resource", resource);
				return dispatcher.invoke(resourceRef.getRangeRef(),
						ImmutableMap.copyOf(localVarsAndArguments));
			}

		} catch (Exception exception) {
			throw new IllegalStateException(processException(exception,
					resourceRef));
		}

		return null;

	}

	/**
	 * Received the resource as the first parameter in the map. named 'resource'
	 * Also notice this is a specialized map.
	 * 
	 * @param rr
	 * @param values
	 * @return
	 */
	protected List<?> internalEvaluate(RangeRef rangeRef,
			ImmutableMap<String, Object> params) {

		DateTimeRange dtr = this.getContextualPeriod();
		BaseResource resource = (BaseResource) params.get("resource");
		KindHintType targetKind = extractKindHint(rangeRef);
		int targetInterval = extractInterval(rangeRef);

		List<Value> v = null; // Will be populated with the ranges.

		if (resource instanceof NetXResource) {
			switch (rangeRef.getValuerange().getValue()) {
			case ValueRange.METRIC_VALUE: {

				v = modelUtils.metricValuesInRange((NetXResource) resource,
						targetInterval, targetKind, dtr);

				// Loop the metric ranges, to find the correct range, doesn't
				// apply
				// to
				// any other range
				// than the CAP range.
				// for (MetricValueRange mvr : ((NetXResource) resource)
				// .getMetricValueRanges()) {
				// int interval = mvr.getIntervalHint();
				// if (interval == targetInterval) {
				//
				// v = qService.getMetricsFromResource(
				// resource.getExpressionName(), dtr.getBegin(),
				// dtr.getEnd(), targetInterval, targetKind);
				// // FIXME, Ignore the Kind hint, as we are not sure it's
				// // always set
				// // when creating the resource in import.
				// @SuppressWarnings("unused")
				// KindHintType kht = mvr.getKindHint();
				// }
				// }
			}
				break;
			case ValueRange.CAP_VALUE: {
				// For capcity calculations, we likely
				// get a single value. To calculate the utilization,
				// it would be needed to make it a complete range.
				v = modelUtils.valuesInRange(
						((NetXResource) resource).getCapacityValues(), dtr);
			}
				break;
			case ValueRange.UTILIZATION_VALUE: {
				v = modelUtils.valuesInRange(
						((NetXResource) resource).getUtilizationValues(), dtr);
			}
				break;
			}
		}
		if (resource instanceof DerivedResource) {
			switch (rangeRef.getValuerange().getValue()) {
			case ValueRange.DERIVED_VALUE: {
				v = ((DerivedResource) resource).getValues();
				v = modelUtils.filterValueInRange(v, dtr);
			}
			}
		}

		// We want the Value object without the timestamp, as we know the
		// period
		// context.
		return v;
	}

	protected Object internalEvaluate(Interval interval,
			ImmutableMap<String, Object> params) {

		if (interval.getInterval() != null) {
			return interval.getInterval();
		} else if (interval.getKind() != null) {
			switch (interval.getKind().getValue()) {
			case IntervalKind.MONTH_VALUE: {
				return new BigDecimal(ModelUtils.MINUTES_IN_A_MONTH);
			}
			case IntervalKind.WEEK_VALUE: {
				return new BigDecimal(ModelUtils.MINUTES_IN_A_WEEK);
			}
			case IntervalKind.DAY_VALUE: {
				return new BigDecimal(ModelUtils.MINUTES_IN_A_DAY);
			}
			case IntervalKind.HOUR_VALUE: {
				return new BigDecimal(ModelUtils.MINUTES_IN_AN_HOUR);
			}
			}
		}
		return new BigDecimal(60);
	}

	private int extractInterval(RangeRef rangeRef) {
		int targetInterval;
		if (rangeRef.getInterval() != null) {

			BigDecimal result = dispatcher.invoke(rangeRef.getInterval(),
					ImmutableMap.<String, Object> of());
			targetInterval = result.intValue();
		} else {
			// Use hour values?
			targetInterval = 60;
		}
		return targetInterval;
	}

	private KindHintType extractKindHint(RangeRef rangeRef) {
		// Feed the query with the kind hint.
		// Note: the KindHintType comes with a default value (xtext generated
		// model for ValueKind).
		KindHintType targetKind = null;
		if (rangeRef.getKind() != null) {
			if (rangeRef.getKind() == ValueKind.AVG) {
				targetKind = KindHintType.AVG;
			}
			if (rangeRef.getKind() == ValueKind.BH) {
				targetKind = KindHintType.BH;
			}
		}
		return targetKind;
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
		// Invocation on a reference.
		if (ne.getRef() != null) {
			Object eval = dispatcher.invoke(ne.getRef(),
					ImmutableMap.copyOf(values));
			if (eval instanceof List<?>) {
				range = (List<?>) eval;
			}
		}
		// Invocation on a variable.
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
			case NativeFunction.ERLANGB_VALUE: {
				// TODO, Erlang B implementation.
			}
			case NativeFunction.DEVIATION_VALUE: {
				return nativeFunctions.standardDeviation(range);
			}
			case NativeFunction.CLEAR_VALUE: {
				// To a metric value range.
				if (ne.getRef() instanceof ContextRef) {
					this.processContextRef((ContextRef) ne.getRef());
				}
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

	// Our ranges can contain any object.
	protected List<?> internalEvaluate(RangeLiteral e,
			ImmutableMap<String, Object> values) {
		// check for an empty range.
		if (e.getValues() == null || e.getValues().size() == 0) {
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
			if (assertValue(rightEval)) {
				Value v = (Value) rightEval;
				// TODO How do we know the list can deal with a Value.
				leftEvalAsList.add(v);
				return ImmutableList.copyOf(leftEvalAsList);
			}
		}

		throw new UnsupportedOperationException(
				"Plus expression for invalid types, i.e. this could be adding a Range to a Numbers");

	}

	protected BigDecimal internalEvaluate(Minus minus,
			ImmutableMap<String, Object> values) {
		return evaluateNumeric(minus.getLeft(), values).subtract(
				evaluateNumeric(minus.getRight(), values));
	}

	protected Object internalEvaluate(Div div,
			ImmutableMap<String, Object> values) {

		Object leftEval = evaluate(div.getLeft(), values);
		Object rightEval = evaluate(div.getRight(), values);

		if (assertNumeric(leftEval)) {
			if (assertNumeric(rightEval)) {
				return ((BigDecimal) leftEval).divide((BigDecimal) rightEval,
						20, RoundingMode.HALF_UP);
			}
		}

		if (assertCollection(leftEval)) {
			List<Object> resultList = Lists.newArrayList();
			if (assertNumeric(rightEval)) {
				// Divide all contents of the left list by the numeric provided.
				for (Object leftO : (List<?>) leftEval) {
					if (assertNumeric(leftO)) {
						BigDecimal d = ((BigDecimal) leftEval).divide(
								(BigDecimal) rightEval, 20,
								RoundingMode.HALF_UP);
						resultList.add(d);
						continue;
					}
					if (assertValue(leftO)) {
						Value v = (Value) leftO;
						BigDecimal dValue = new BigDecimal(v.getValue());
						BigDecimal d = dValue.divide((BigDecimal) rightEval,
								20, RoundingMode.HALF_UP);
						Value copy = EcoreUtil.copy(v);
						copy.setValue(d.doubleValue());
						resultList.add(copy);
						continue;
					}
				}

				// Assert the number of entries are the same.
				assert resultList.size() == ((List<?>) leftEval).size() : new UnsupportedOperationException(
						"Dividing computation error, result range is a non-equal size to the left value");
				return ImmutableList.copyOf(resultList);
			}
			if (assertValue(rightEval)) {
				BigDecimal rightDividor = new BigDecimal(
						((Value) rightEval).getValue());
				// Divide all contents of the left list by the numeric provided.
				for (Object leftO : (List<?>) leftEval) {
					if (assertNumeric(leftO)) {
						BigDecimal d = ((BigDecimal) leftEval).divide(
								rightDividor, 20, RoundingMode.HALF_UP);
						resultList.add(d);
						continue;
					}
					if (assertValue(leftO)) {
						Value v = (Value) leftO;
						BigDecimal dValue = new BigDecimal(v.getValue());
						BigDecimal d = dValue.divide(rightDividor, 20,
								RoundingMode.HALF_UP);
						Value copy = EcoreUtil.copy(v);
						copy.setValue(d.doubleValue());
						resultList.add(copy);
						continue;
					}
				}

				// Assert the number of entries are the same.
				assert resultList.size() == ((List<?>) leftEval).size() : new UnsupportedOperationException(
						"Dividing computation error, result range is a non-equal size to the left range");
				return ImmutableList.copyOf(resultList);
			}
			if (assertCollection(rightEval)) {
				// divide two collections.
				// assert ((List<?>) leftEval).size() == ((List<?>) rightEval)
				// .size() : new UnsupportedOperationException(
				// "Dividing computation error, left and right range are not equal size");

				if (((List<?>) rightEval).isEmpty()) {
					return Lists.newArrayList();
				}

				// Use the left as the iterator, so make sure we never retrieve
				// more than size from right,
				// If we are over, take the last value.
				for (int j = 0; j < ((List<?>) leftEval).size(); j++) {
					Object leftVal = ((List<?>) leftEval).get(j);
					Object rightVal;
					if (j < ((List<?>) rightEval).size()) {
						rightVal = ((List<?>) rightEval).get(j);
					} else {
						rightVal = ((List<?>) rightEval)
								.get(((List<?>) rightEval).size() - 1);
					}
					if (assertNumeric(leftVal) && assertNumeric(rightVal)) {
						BigDecimal d = ((BigDecimal) leftVal)
								.divide((BigDecimal) rightVal, 20,
										RoundingMode.HALF_UP);
						resultList.add(d);
						continue;
					}
					if (assertValue(leftVal) && assertValue(rightVal)) {
						Value vl = (Value) leftVal;
						Value vr = (Value) rightVal;
						BigDecimal d = new BigDecimal(vl.getValue()).divide(
								new BigDecimal(vr.getValue()), 20,
								RoundingMode.HALF_UP);
						Value copy = EcoreUtil.copy(vl);
						copy.setValue(d.doubleValue());
						resultList.add(copy);
					}
				}
				return ImmutableList.copyOf(resultList);
			}
		}

		throw new UnsupportedOperationException(
				"Div expression for invalid types, i.e. This could be dividing a Number by a Range.");
	}

	protected Object internalEvaluate(Multi multi,
			ImmutableMap<String, Object> values) {

		Object leftEval = evaluate(multi.getLeft(), values);
		Object rightEval = evaluate(multi.getRight(), values);

		if (assertNumeric(leftEval)) {
			if (assertNumeric(rightEval)) {
				return ((BigDecimal) leftEval).multiply((BigDecimal) rightEval);
			}
		}

		if (assertCollection(leftEval)) {
			List<Object> resultList = Lists.newArrayList();
			if (assertNumeric(rightEval)) {
				// Divide all contents of the left list by the numeric provided.
				for (Object leftO : (List<?>) leftEval) {
					if (assertNumeric(leftO)) {
						BigDecimal d = ((BigDecimal) leftEval)
								.multiply((BigDecimal) rightEval);
						resultList.add(d);
						continue;
					}
					if (assertValue(leftO)) {
						Value v = (Value) leftO;
						BigDecimal dValue = new BigDecimal(v.getValue());
						BigDecimal d = dValue.multiply((BigDecimal) rightEval);
						Value copyOf = EcoreUtil.copy(v);
						copyOf.setValue(d.doubleValue());
						resultList.add(copyOf);
						continue;
					}
				}
				// Assert the number of entries are the same.
				assert resultList.size() == ((List<?>) leftEval).size() : new UnsupportedOperationException(
						"Multiplication computation error, result range is a non-equal size to the left range");
				return ImmutableList.copyOf(resultList);
			}
			if (assertValue(rightEval)) {
				BigDecimal rightMultiplier = new BigDecimal(
						((Value) rightEval).getValue());
				// Divide all contents of the left list by the numeric provided.
				for (Object leftO : (List<?>) leftEval) {
					if (assertNumeric(leftO)) {
						BigDecimal d = ((BigDecimal) leftEval)
								.multiply(rightMultiplier);
						resultList.add(d);
						continue;
					}
					if (assertValue(leftO)) {
						Value v = (Value) leftO;
						BigDecimal dValue = new BigDecimal(v.getValue());
						BigDecimal d = dValue.multiply(rightMultiplier);
						Value copyOf = EcoreUtil.copy(v);
						copyOf.setValue(d.doubleValue());
						resultList.add(copyOf);
						continue;
					}
				}

				// Assert the number of entries are the same.
				assert resultList.size() == ((List<?>) leftEval).size() : new UnsupportedOperationException(
						"Multiplication computation error, result range is a non-equal size to the left range");
				return ImmutableList.copyOf(resultList);
			}
			if (assertCollection(rightEval)) {
				// divide two collections.
				assert ((List<?>) leftEval).size() == ((List<?>) rightEval)
						.size() : new UnsupportedOperationException(
						"Multiplication computation error, left and right range are not equal size");

				for (int j = 0; j < ((List<?>) leftEval).size(); j++) {
					Object leftVal = ((List<?>) leftEval).get(j);
					Object rightVal = ((List<?>) rightEval).get(j);
					if (assertNumeric(leftVal) && assertNumeric(rightVal)) {
						BigDecimal d = ((BigDecimal) leftVal)
								.multiply((BigDecimal) rightVal);
						resultList.add(d);
					}
					if (assertValue(leftVal) && assertValue(rightVal)) {
						BigDecimal d = new BigDecimal(
								((Value) leftVal).getValue())
								.multiply(new BigDecimal(((Value) rightVal)
										.getValue()));
						resultList.add(d);
					}
				}
				return ImmutableList.copyOf(resultList);
			}
		}

		throw new UnsupportedOperationException(
				"Multiplication expression for invalid types, i.e. This could be multiplying a Number by a Range.");
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

	public List<BaseExpressionResult> getResult() {
		return expressionResults;
	}

}

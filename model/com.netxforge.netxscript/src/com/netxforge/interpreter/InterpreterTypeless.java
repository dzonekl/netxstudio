package com.netxforge.interpreter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.internal.RuntimeActivator;
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
import com.netxforge.netxscript.Navigation;
import com.netxforge.netxscript.Negation;
import com.netxforge.netxscript.NetxscriptFactory;
import com.netxforge.netxscript.NetxscriptPackage;
import com.netxforge.netxscript.NodeRef;
import com.netxforge.netxscript.NodeTypeRef;
import com.netxforge.netxscript.NumberLiteral;
import com.netxforge.netxscript.Or;
import com.netxforge.netxscript.ParamRef;
import com.netxforge.netxscript.Plus;
import com.netxforge.netxscript.PlusAssignment;
import com.netxforge.netxscript.PrimaryRef;
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
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.cdo.CDOQueryService;
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
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.impl.NodeImpl;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.impl.RFSServiceImpl;
import com.netxforge.netxstudio.services.impl.ServiceUserImpl;
import com.netxforge.scoping.IExternalContextAware;

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
 * @author Christophe Bouhier - Extended the grammar, see NetXScript.
 */
public class InterpreterTypeless implements IInterpreter, IExternalContextAware {

	@Inject
	INativeFunctions nativeFunctions;// = new NativeFunctions();

	IPrettyLog pLog;// = new PrettyLog();

	@Inject
	ModelUtils modelUtils;// = new ModelUtils();

	@Inject
	private IQueryService cdoQueryService;

	// Options Parameters.

	/**
	 * When enabled, the interpreter will prefer using CDO Queries to get
	 * external data. (Non-Context). Otherwise, external data will be deduced by
	 * iterating over known objects or using the DataProvider.
	 */
	private static final boolean USE_QUERIES = true;

	private PrintingPolymorphicDispatcher<BigDecimal> dispatcher = PrintingPolymorphicDispatcher
			.createForSingleTarget("internalEvaluate", 2, 2, this);

	// private PolymorphicDispatcher dispatcher = PolymorphicDispatcher
	// .createForVarTarget("internalEvaluate", this);

	/**
	 * The result of our expression.
	 */
	private List<BaseExpressionResult> expressionResults = Lists.newArrayList();

	/*
	 * Construct without a root object constraint.
	 */
	@Inject
	public InterpreterTypeless(IPrettyLog pLog) {
		this.pLog = pLog;
		dispatcher.setPrettyLog(pLog);
	}

	/*
	 * The first Context always corresponds to 'this' in the grammar. Additional
	 * context, contain the period range for an expression.
	 */
	private List<IInterpreterContext> contextList = Lists.newArrayList();

	/*
	 * An index of all context.
	 */
	private Map<Class<?>, IInterpreterContext> contextIndex = Maps.newHashMap();

	/*
	 * The target range interval for a reference assignment. Can be used
	 * customize how ranges are split. For a week target range interval, the
	 * split could be by week.
	 */
	private int targetRangeInterval = -1;

	/**
	 * Clear the interpreter if it's re-used.
	 */
	public void clearResults() {
		expressionResults.clear();

	}

	public void clearExternalContext() {
		contextIndex.clear();
		contextList.clear();
	}

	public void setExternalContext(IInterpreterContext... context) {
		this.contextList.addAll(Lists.newArrayList(context));
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

	@SuppressWarnings("unused")
	private MetricRetentionRule getContextualMetricRetentionRule() {
		IInterpreterContext ruleContext = getContextFor(MetricRetentionRule.class);
		if (ruleContext != null) {
			return (MetricRetentionRule) ruleContext.getContext();
		} else {
			throw new java.lang.UnsupportedOperationException(
					"RetentionRule unset, it was however requested for this evaluation");
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
			// pLog.log("Calling first function: '" + f.getName()
			// + "' Additional Functions:"
			// + (module.getFunctions().size() - 1));
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
			return asNum((BigDecimal) eval);
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

			// CB Unused, comment out.
			// int index = internalStatements.indexOf(statement);

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
				// if (eval != null) {
				// pLog.log("Statement (" + index + ") result:", eval);
				// }

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

			// Note:
			// We unfortunately, can't use the dispatched to get to
			// the leaf reference, so we use a recursive way to get it.
			final Reference assignmentReference = refa.getAssignmentRef();
			final List<BaseResource> targetResources = Lists.newArrayList();
			RangeRef targetRangeReference = null;

			if (assignmentReference instanceof NodeTypeRef) {
				NodeTypeRef nodeTypeRef = (NodeTypeRef) assignmentReference;

				if (nodeTypeRef.getPrimaryRef().getLeafRef() != null) {
					LeafReference leafReference = nodeTypeRef.getPrimaryRef()
							.getLeafRef();
					if (leafReference instanceof ResourceRef) {

						// ???? This is not a context ref???
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
					ResourceRef resourceRef = (ResourceRef) cRef
							.getPrimaryRef().getLeafRef();
					targetResources.addAll(resources(cRef));
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

				targetRangeInterval = extractInterval(targetRangeReference);

				Object varEval = dispatcher.invoke(refa.getExpression(),
						ImmutableMap.copyOf(localVarsAndArguments));
				processExpressionResult(varEval, targetResources,
						targetRangeReference);

			}

		}
	}

	private List<BaseResource> resources(ContextRef cRef) {

		final List<BaseResource> resources = Lists.newArrayList();
		ResourceRef resourceRef = (ResourceRef) cRef.getPrimaryRef()
				.getLeafRef();
		if (!(resourceRef instanceof ResourceRef)) {
			// there are no resources.
			return resources;
		}

		Node ctxNode = this.getContextualNode();
		Component ctxComponent = this.getContextualComponent();

		if (resourceRef.getResource() instanceof NetXResource) {

			// CB 07-02-2012, the navigation component is optional
			// in the syntax now.
			// most example expressions, will not include
			// navigation.

			List<? extends Component> navComponents = this.components(
					cRef.getPrimaryRef(), ctxNode);
			if (navComponents != null && navComponents.size() > 0) {
				// ignore the context Component, and look for the
				// resource in the explicit component, if no exact match take
				// the first one.
				Component navComponent = navComponents.get(0);
				// TODO, report that there are more than one components.

				List<NetXResource> netxResources = this.resourcesByName(
						navComponent, resourceRef);
				resources.addAll(netxResources);
			} else if (ctxComponent != null) {
				List<NetXResource> netxResources = this.resourcesByName(
						ctxComponent, resourceRef);
				resources.addAll(netxResources);
			}
		} else if (resourceRef.getResource() instanceof DerivedResource) {
			ServiceUser su = this.getContextualServiceUser();
			if (su != null) {
				for (DerivedResource dr : su.getServiceProfile()
						.getProfileResources()) {
					if (dr.getExpressionName().equals(
							resourceRef.getResource().getExpressionName())) {
						resources.add(dr);
					}
				}
			}
		}
		return resources;
	}

	private void removeFromContextRef(ContextRef cRef, List<?> values) {
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
					ImmutableList.of(c), tmpResource.getExpressionName(),
					resourceRef.isAll());
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

				// Note these are two optional parameters, and not relevant for
				// Util, Cap.
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

				if (assertNumeric(varEval)) {

					// Single values are extrapolated to each beginning of the
					// day, for each day in the period.
					// Get the period context, and use the start and end date
					// for the extrapolation.
					// Note: This is a design choice, and could be optional.
					// Note II: We do not check the range, so this could also
					// apply to other ranges, than the capacity value.
					DateTimeRange dtr = this.getContextualPeriod();
					List<XMLGregorianCalendar> transformPeriodToDailyTimestamps = modelUtils
							.transformPeriodToDailyTimestamps(dtr);
					for (XMLGregorianCalendar ts : transformPeriodToDailyTimestamps) {

						if (RuntimeActivator.DEBUG) {
							RuntimeActivator.TRACE
									.trace(RuntimeActivator.TRACE_NETXSCRIPT_EXPRESSION_OPTION,
											"Create value for TS = " + ts
													+ " with value " + varEval);
						}

						Value newValue = GenericsFactory.eINSTANCE
								.createValue();
						newValue.setTimeStamp(ts);
						newValue.setValue(asNum((BigDecimal) varEval)
								.doubleValue());
						er.getTargetValues().add(newValue);

					}
					expressionResults.add(er);
				}
				if (assertCollection(varEval)) {
					// We return a list of values, note values are contained, so
					// we should
					// make a copy, in an assignment.
					List<?> resultValues = (List<?>) varEval;
					for (Object entry : resultValues) {
						if (entry instanceof Value) {
							// The only place a Value object could have come
							// from, is from another range,
							// so we need to make a copy to avoid, the contained
							// value object from being "moved"
							// out of the source range.
							//
							// DO not make a copy, as a all expressions should
							// have returned a copy of referenced vales.
							Value copy = EcoreUtil.copy((Value) entry);
							er.getTargetValues().add(copy);
						} else if (assertNumeric(entry)) {

							Value v = GenericsFactory.eINSTANCE.createValue();
							v.setValue(asNum((BigDecimal) entry).doubleValue());
							// FIXME, We don't set a timestamp!
							// values without a timestamp, will not be visible
							// because
							// of UI filters.

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

	@SuppressWarnings("unused")
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

	// CB 06-01-2012 Removed, expression can't be a statement.
	/**
	 * Root class, which contains an expression, evaluate on the expression, or
	 * threat as a blank.
	 * 
	 * @param statement
	 * @param values
	 * @return
	 */
	// protected Object internalEvaluate(Statement statement,
	// ImmutableMap<String, Object> values) {
	//
	// if (statement.getExpression() != null) {
	// return evaluate((Expression) statement.getExpression(), values);
	// } else {
	// return null;
	// }
	// }

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
				if (assertCollection(preEvaluated)) {
					// Get the member of a range.
					if (e.getIndex() != null) {
						Object eval = dispatcher.invoke(e.getIndex(),
								ImmutableMap.copyOf(values));
						if (assertNumeric(eval)) {
							return ((List<?>) preEvaluated).get(asNum(
									(BigDecimal) eval).intValue());
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

	protected void internalEvaluate(Reference e,
			ImmutableMap<String, Object> params) {
		pLog.log("TODO, implement evaluation rule for expression type: ", e);
	}

	protected Object internalEvaluate(PrimaryRef e,
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
			PrimaryRef primaryRef = nodeTypeReference.getPrimaryRef();

			NodeType nt = nodeTypeReference.getNodetype();
			List<Node> nodes = modelUtils.nodesForNodeType(
					(RFSService) service, nt);

			List<Component> components = Lists.newArrayList();
			for (Node n : nodes) {
				Object result = components(primaryRef, n);
				if (result != null && (result instanceof List<?>)) {
					components.addAll((Collection<? extends Component>) result);
				}
			}

			if (primaryRef.getLeafRef() == null
					&& primaryRef.getNavigation() != null) {
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
			Node node = this.getContextualNode();

			// OPTION 1. THE COMPONENT WITHOUT RESOURCE
			// Check if there is no leaf ref, and it has components and a node
			// context.
			// to get the last referenced component for this node.
			if (contextReference.getPrimaryRef().getLeafRef() == null
					&& contextReference.getPrimaryRef().getNavigation() != null
					&& node != null) {

				// CB 16-12-2011, changed capacity expression context to be the
				// resource.
				//
				// Node extractNode = this.extractNode(primaryRef);
				// if(extractNode != null){
				// node = extractNode;
				// }

				return components(contextReference.getPrimaryRef(), node);
			} else {
				// OPTION 2: WITH RESOURCE
				if (contextReference.getPrimaryRef().getLeafRef() instanceof ResourceRef) {
					// Will evaluate and get the resources.
					List<BaseResource> resources = this
							.resources(contextReference);

					ResourceRef resourceRef = (ResourceRef) contextReference
							.getPrimaryRef().getLeafRef();

					List<Object> evals = Lists.newArrayList();

					for (BaseResource res : resources) {
						localVarsAndArguments.put("resource", res);
						Object subEval = dispatcher.invoke(
								resourceRef.getRangeRef(),
								ImmutableMap.copyOf(localVarsAndArguments));
						evals.add(subEval);
					}

					if (evals.size() == 1) {
						eval = evals.get(0);

					} else {
						eval = evals;
					}

				} else if (contextReference.getPrimaryRef().getLeafRef() instanceof StatusRef) {
					if (this.getContextualService() != null) {
						// Applies to STATUS and PROFILE keywords.
						Service service = this.getContextualService();
						localVarsAndArguments.put("service", service);
						eval = dispatcher.invoke(
								contextReference.getPrimaryRef(),
								ImmutableMap.copyOf(localVarsAndArguments));
					}
				}
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

	/*
	 * Returns a collection of components, with the same name as found in the
	 * Navigation AST node.
	 */
	private List<? extends Component> components(PrimaryRef primaryRef,
			Node node) {

		List<? extends Component> result = null;
		Navigation lastRef = primaryRef.getNavigation();

		// CB O6-01-2012 only one component exists.
		// Reference lastRef = primaryRef.getComponents().get(
		// primaryRef.getComponents().size() - 1);
		//
		if (lastRef instanceof Navigation) {
			// return either the functions or equipments.
			Navigation cr = (Navigation) lastRef;

			if (cr.getEquipment() != null) {
				Equipment eq = cr.getEquipment();
				if (eq.eIsSet(LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE)) {
					String eCode = eq.getEquipmentCode();
					// Match on Equipment Name as well
					// http://work.netxforge.com/issues/300
					if (eq.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)) {
						String eName = cr.getEquipment().getName();
						List<Equipment> equipments = modelUtils
								.equimentsWithCodeAndName(node.getNodeType()
										.getEquipments(), eCode, eName);
						result = equipments;
					} else {
						List<Equipment> equipments = modelUtils
								.equimentsWithCode(node.getNodeType()
										.getEquipments(), eCode);
						result = equipments;
					}
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

	protected void internalEvaluate(ResourceRef resourceRef,
			ImmutableMap<String, Object> params) {

		throw new UnsupportedOperationException(
				"ResourceRef AST node should not be evaluated.");

		// // copy the parameters.
		// Map<String, Object> localVarsAndArguments = Maps.newHashMap();
		// localVarsAndArguments.putAll(ImmutableMap.copyOf(params));
		//
		// Node n = null;
		// if (params.containsKey("node")) {
		// n = (Node) params.get("node");
		// }
		//
		// Component component = null;
		// if (params.containsKey("component")) {
		// component = (Component) params.get("component");
		// }
		//
		// Service s = null;
		// if (params.containsKey("service")) {
		// s = (Service) params.get("service");
		// }
		//
		// try {
		//
		// BaseResource resource = null;
		// if (component != null) {
		// List<NetXResource> netxResources = this.resourcesByName(
		// component, resourceRef);
		// resource = netxResources.size() > 0 ? netxResources.get(0)
		// : null;
		// } else if (n != null) {
		// List<NetXResource> netxResources = this.resourcesByName(n,
		// resourceRef);
		// resource = netxResources.size() > 0 ? netxResources.get(0)
		// : null;
		// } else if (s != null) {
		//
		// for (@SuppressWarnings("unused")
		// ServiceUser su : s.getServiceUserRefs()) {
		//
		// }
		// }
		//
		// if (resource != null) {
		//
		// localVarsAndArguments.put("resource", resource);
		// return dispatcher.invoke(resourceRef.getRangeRef(),
		// ImmutableMap.copyOf(localVarsAndArguments));
		// }
		//
		// } catch (Exception exception) {
		// throw new IllegalStateException(processException(exception,
		// resourceRef));
		// }
		//
		// return null;

	}

	/**
	 * Received the resource as the first parameter in the map. named 'resource'
	 * Also notice this is a specialized map.
	 * 
	 * FIXME, REPLACE WITH DB QUERIES.
	 * 
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

				if (USE_QUERIES && cdoQueryService instanceof CDOQueryService) {
					MetricValueRange mvr = modelUtils
							.valueRangeForIntervalAndKind(
									(NetXResource) resource, targetKind,
									targetInterval);
					v = cdoQueryService.mvrValues(resource.cdoView(), mvr,
							IQueryService.QUERY_MYSQL, dtr);
				} else {

					v = modelUtils.valuesForIntervalKindAndPeriod(
							(NetXResource) resource, targetInterval,
							targetKind, dtr);
				}
			}
				break;
			case ValueRange.CAP_VALUE: {
				v = modelUtils.valuesInsideRange(
						((NetXResource) resource).getCapacityValues(), dtr);
			}
				break;
			case ValueRange.UTILIZATION_VALUE: {
				v = modelUtils.valuesInsideRange(
						((NetXResource) resource).getUtilizationValues(), dtr);
			}
				break;
			}
		}
		if (resource instanceof DerivedResource) {
			switch (rangeRef.getValuerange().getValue()) {
			case ValueRange.DERIVED_VALUE: {
				v = ((DerivedResource) resource).getValues();
				v = modelUtils.valuesInsideRange(v, dtr);
			}
			}
		}
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
			} else if (rangeRef.getKind() == ValueKind.BH) {
				targetKind = KindHintType.BH;
			}
		}
		return targetKind;
	}

	// /////////////////////////////////////
	// NATIVE FUNCTIONS
	// /////////////////////////////////////

	// See the Native function range handling rules.
	protected Object internalEvaluate(NativeExpression ne,
			ImmutableMap<String, Object> values) {

		// Remember the interval if we are dealing with a range reference
		// the function handler will use this for value ranges, to break up the
		// range.
		int extractedRangeInterval = -1;
		if (ne.getLeft() instanceof ContextRef) {
			ContextRef cr = (ContextRef) ne.getLeft();
			if (cr.getRangeRef() != null) {
				extractedRangeInterval = this.extractInterval(cr.getRangeRef());
			}
		}

		Object eval = dispatcher.invoke(ne.getLeft(),
				ImmutableMap.copyOf(values));

		// Ignore if no function
		if (ne.getNativeFunction() != null) {
			List<?> range = null;
			if (assertCollection(eval)) {
				range = (List<?>) eval;
				if (!assertMatrix(range)) {

					// Doesn't apply to matrix ranges.
					if (assertValueCollection(range)
							&& extractedRangeInterval != -1) {

						// break up the range using the interval.
						@SuppressWarnings("unchecked")
						List<List<Value>> splitValueRange = modelUtils.values_(
								(List<Value>) eval, targetRangeInterval);

						List<Object> evalResult = Lists.newArrayList();
						// iterate through the sublists, and apply the native
						// expression. the results are.
						for (List<Value> subRange : splitValueRange) {
							Object subRangeResult = processNativeFunction(ne,
									subRange);
							if (assertValue(subRangeResult)) {
								// System.out.println(modelUtils
								// .value((Value) subRangeResult));
								evalResult.add(subRangeResult);
							}
						}
						// result with time stamps, otherwise eval will be nul.
						eval = evalResult;
					} else {
						// Note; the timestamp is lost here.
						eval = processNativeFunction(ne, range);
					}
				} else {

					// process a matrix of values, either horizontal or vertical

					// FIXME, We need a way to differentiate, either through
					// syntax, by grouping
					// or by configuration, or implicity.....

					// /////////////////////////////////////////////
					// 1 Process the ranges vertically, function is applied
					// to all similar timestamps of the ranges.
					List<Object> evalResult = Lists.newArrayList();
					if (true) {
						// use the first subrange as the reference list, make a
						// copy.
						// for each of the ranges, aggregate values with the
						// same timestamp.
						if (range.size() > 0 && range.get(0) instanceof List<?>) {
							ImmutableList<?> refRange = ImmutableList
									.copyOf((List<?>) range.get(0));
							for (Object refObject : refRange) {
								List<Value> sameTimestamps = Lists
										.newArrayList();
								Value refValue = null;
								if (refObject instanceof Value) {
									refValue = (Value) refObject;
								}
								for (Object rangeItem : range) {

									// Collections should be passed to the
									// evaluation,
									// and
									// returned as a range.
									if (assertCollection(rangeItem)) {
										for (Object ri : (List<?>) rangeItem) {

											if (ri instanceof Value
													&& modelUtils
															.valueTimeStampCompare()
															.compare(
																	(Value) ri,
																	refValue) == 0) {

												sameTimestamps.add((Value) ri);
											}
										}

									} else {

										// this value gets lost...
										continue;
									}
								}
								// Create a copy of the reference value to keep
								// the timestamp
								// , but store the evaluated native function
								// value.
								Value processedValue = EcoreUtil.copy(refValue);
								Object evalNative = processNativeFunction(ne,
										sameTimestamps);
								if (assertNumeric(evalNative)) {
									BigDecimal bdValue = asNum((BigDecimal) evalNative);
									processedValue.setValue(bdValue
											.doubleValue());
								}
								evalResult.add(processedValue);
							}
						}

					} else {
						// 2.Process the ranges horizontally, function is
						// applied
						// to the values of the range.
						// walk through the list twice, to swap the array.

						for (Object rangeItem : range) {
							// Collections should be passed to the evaluation,
							// and
							// returned as a range.
							if (assertCollection(rangeItem)) {

								// perform the native function here.
								evalResult.add(processNativeFunction(ne,
										(List<?>) rangeItem));
							} else {

								// this value gets lost...
								continue;
							}
						}
					}
					eval = evalResult;
				}
			}
		}
		return eval;
	}

	/**
	 * Execute the Native function in the Native expression on the specified
	 * range. </p> For ranges which contain the value object, the function is
	 * applied for sub-periods depending on the interval of the values.
	 * <ul>
	 * <li>For hourly values, the sub period is a day</li>
	 * <li>For daily values, the sub period is a week</li>
	 * <li>For week values, the sub period is a month</li>
	 * <li>For month values, the sub period is a year</li>
	 * </ul>
	 * 
	 * 
	 * @param ne
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Object processNativeFunction(NativeExpression ne, List<?> values) {

		INativeFunctions2 nativeFunctions2 = null;

		if (this.nativeFunctions instanceof INativeFunctions2) {
			nativeFunctions2 = (INativeFunctions2) nativeFunctions;
		}

		// Result could be an array, so aggregate...
		NativeFunction nf = ne.getNativeFunction();

		switch (nf.getValue()) {
		case NativeFunction.SUM_VALUE: {
			return nativeFunctions.sum(values);
		}
		case NativeFunction.COUNT_VALUE: {
			return nativeFunctions.count(values);
		}
		// Supports various implementations.
		case NativeFunction.MAX_VALUE: {
			if (assertValueCollection(values)) {
				return nativeFunctions2.maxValue((List<Value>) values);
			} else {
				return nativeFunctions.max(values);
			}

		}
		// Supports various implementations.
		case NativeFunction.MIN_VALUE: {
			if (assertValueCollection(values)) {
				return nativeFunctions2.minValue((List<Value>) values);
			} else {
				return nativeFunctions.min(values);
			}
		}
		case NativeFunction.MEAN_VALUE: {
			if (assertValueCollection(values)) {
				return nativeFunctions2.meanValue((List<Value>) values);
			} else {
				return nativeFunctions.mean(values);
			}
		}
		case NativeFunction.ERLANGB_VALUE: {
			// GoS is hardcoded.
			return nativeFunctions.erlangB(values, 0.01f);
		}
		case NativeFunction.DEVIATION_VALUE: {
			return nativeFunctions.standardDeviation(values);
		}
		case NativeFunction.CLEAR_VALUE: {
			if (ne.getLeft() instanceof ContextRef) {
				this.removeFromContextRef((ContextRef) ne.getLeft(), values);
			}
		}

		}
		return values;
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
		Object leftEval = evaluate(plus.getLeft(), values);
		Object rightEval = evaluate(plus.getRight(), values);
		return processArithmetic(leftEval, rightEval, plus);
	}

	protected Object internalEvaluate(Minus minus,
			ImmutableMap<String, Object> values) {
		Object leftEval = evaluate(minus.getLeft(), values);
		Object rightEval = evaluate(minus.getRight(), values);
		return processArithmetic(leftEval, rightEval, minus);
	}

	/*
	 * Capable to evaluate ranges on left and right side.
	 */
	protected Object internalEvaluate(Div div,
			ImmutableMap<String, Object> values) {

		Object leftEval = evaluate(div.getLeft(), values);
		Object rightEval = evaluate(div.getRight(), values);
		return processArithmetic(leftEval, rightEval, div);

	}

	protected Object internalEvaluate(Multi multi,
			ImmutableMap<String, Object> values) {

		Object leftEval = evaluate(multi.getLeft(), values);
		Object rightEval = evaluate(multi.getRight(), values);
		return processArithmetic(leftEval, rightEval, multi);
	}

	/*
	 * Applies an arithmetic operation on left with right. right is the
	 * transformation
	 */
	abstract class ArithmeticFunction {

		private Object operation;
		private BigDecimal leftNum;
		private boolean revert;

		public ArithmeticFunction(boolean revert) {
			this.revert = revert;
		}

		public void setOperation(Object operation) {
			this.operation = operation;
		}

		public void setNum(BigDecimal leftNum) {
			this.leftNum = leftNum;
		}

		public BigDecimal doApply(BigDecimal rightNum) {
			if (revert) {
				return doApplyRight(rightNum);
			} else {
				return doApplyLeft(rightNum);
			}
		}

		public BigDecimal doApplyLeft(BigDecimal rightNum) {
			if (leftNum == null || rightNum == null || operation == null) {
				throw new UnsupportedOperationException(
						"Null values in ArithmeticFunction");
			}
			BigDecimal numResult = null;
			if (operation instanceof Multi) {
				numResult = leftNum.multiply(rightNum);
			} else if (operation instanceof Div) {
				numResult = leftNum.divide(rightNum, 20, RoundingMode.HALF_UP);
			} else if (operation instanceof Plus) {
				numResult = leftNum.add(rightNum);
			} else if (operation instanceof Minus) {
				numResult = leftNum.subtract(rightNum);
			} else {
				throw new UnsupportedOperationException("Unsupported operation");
			}
			return numResult;
		}

		public BigDecimal doApplyRight(BigDecimal rightNum) {
			if (leftNum == null || rightNum == null || operation == null) {
				throw new UnsupportedOperationException(
						"Null values in ArithmeticFunction");
			}
			BigDecimal numResult = null;
			if (operation instanceof Multi) {
				numResult = rightNum.multiply(leftNum);
			} else if (operation instanceof Div) {
				numResult = rightNum.divide(leftNum, 20, RoundingMode.HALF_UP);
			} else if (operation instanceof Plus) {
				numResult = rightNum.add(leftNum);
			} else if (operation instanceof Minus) {
				numResult = rightNum.subtract(leftNum);
			} else {
				throw new UnsupportedOperationException("Unsupported operation");
			}
			return numResult;
		}

	}

	/*
	 * Apply with left and right are Numeric.
	 */
	class ArithmeticNumToNumFunction extends ArithmeticFunction implements
			com.google.common.base.Function<BigDecimal, BigDecimal> {

		public ArithmeticNumToNumFunction(Object operation, Value value,
				boolean revert) {
			super(revert);
			setOperation(operation);
			setNum(asNum(value));
		}

		public ArithmeticNumToNumFunction(Object operation, BigDecimal num,
				boolean revert) {
			super(revert);
			setOperation(operation);
			setNum(num);
		}

		public BigDecimal apply(BigDecimal rightNum) {
			return doApply(rightNum);
		}
	}

	/*
	 * Dual use:
	 * 
	 * 1) Apply with left and right Value, left is returned with the operation
	 * applied. ( The time stamps should be equal, otherwise left is returned
	 * not applying the operation). 2) Apply with left numeric and right Value,
	 * right is returned with the operation applied.
	 */
	class ArithmeticValueToValueFunction extends ArithmeticFunction implements
			com.google.common.base.Function<Value, Value> {

		private Value leftValue;
		private boolean matchTS = true;

		public ArithmeticValueToValueFunction(Object operation,
				Value leftValue, boolean revert) {
			super(revert);
			setOperation(operation);
			setNum(asNum(leftValue));
			this.leftValue = leftValue;
		}

		public ArithmeticValueToValueFunction(Object operation, BigDecimal num,
				boolean revert) {
			super(revert);
			setOperation(operation);
			setNum(num);
		}

		public void setMatchTS(Boolean matchTS) {
			this.matchTS = matchTS;

		}

		public Value apply(Value rightValue) {

			if (leftValue != null) {
				// assert value time stamps are equal, only if instructed to do
				// so.
				if (matchTS) {
					if (assertValueTSEqual(leftValue, rightValue)) {
						BigDecimal rightNum = asNum(rightValue);
						BigDecimal numResult = doApply(rightNum);
						leftValue.setValue(numResult.doubleValue());
						return leftValue;
					} else {
						// doesn't apply the operation.
						return leftValue;
					}
				} else {
					BigDecimal rightNum = asNum(rightValue);
					BigDecimal numResult = doApply(rightNum);
					leftValue.setValue(numResult.doubleValue());
					return leftValue;
				}
			} else {
				BigDecimal rightNum = asNum(rightValue);
				BigDecimal numResult = doApply(rightNum);
				rightValue.setValue(numResult.doubleValue());
				return rightValue;
			}
		}
	}

	ArithmeticNumToNumFunction opNumToNum(Object operation, BigDecimal num,
			boolean revert) {
		return new ArithmeticNumToNumFunction(operation, num, revert);
	}

	ArithmeticNumToNumFunction opNumToNum(Object operation, Value value,
			boolean revert) {
		return new ArithmeticNumToNumFunction(operation, value, revert);
	}

	ArithmeticValueToValueFunction opValueToValue(Object operation,
			Value value, boolean revert) {
		return new ArithmeticValueToValueFunction(operation, value, revert);
	}

	ArithmeticValueToValueFunction opValueToValue(Object operation,
			BigDecimal num, boolean revert) {
		return new ArithmeticValueToValueFunction(operation, num, revert);
	}

	/*
	 * Applies to the left range. Ranges, need to be equal size. For Values,
	 * time stamps do not need to match.
	 */
	void opValueToValue(Object operation, List<Value> leftValues,
			List<Value> rightValues) {

		boolean matchTS = true;

		// When sizes are unequal, we do not match on the timestamp.
		if (leftValues.size() != rightValues.size()) {
			matchTS = false;
		}

		for (int j = 0; j < leftValues.size(); j++) {

			Value leftVal = leftValues.get(j);
			Value rightVal = null;
			if (j < rightValues.size()) {
				rightVal = rightValues.get(j);
			} else {
				rightVal = rightValues.get(rightValues.size() - 1);
			}
			ArithmeticValueToValueFunction opValueToValue = opValueToValue(
					operation, leftVal, false);
			opValueToValue.setMatchTS(matchTS);
			opValueToValue.apply(rightVal);
		}
	}

	/**
	 * Uniform processing of arithmetic for all left and right type
	 * combinations. being BigDecimal, Value, Collection. Note: Matrix left and
	 * right are not supported.
	 * 
	 * 
	 * @param leftEval
	 * @param rightEval
	 * @param operation
	 * @return
	 */
	private Object processArithmetic(Object leftEval, Object rightEval,
			Object operation) {

		Object result = null;

		// Important: for readability and uniformity of method names, casts are
		// done through a method,
		// which should accept a casted argument of the target.
		if (assertNumeric(leftEval)) {
			if (assertNumeric(rightEval)) {
				result = opNumToNum(operation, asNum((BigDecimal) leftEval),
						false).apply(asNum((BigDecimal) rightEval));
			} else if (assertValue(rightEval)) {
				result = opValueToValue(operation,
						asNum((BigDecimal) leftEval), false).apply(
						(Value) rightEval);
			} else if (assertCollection(rightEval)) {
				if (assertValueCollection(rightEval)) {
					// Copy, as we will use it's values in the operation.
					List<Value> rightValueCollection = asCopyOfValueCollection(asCollection((List<?>) rightEval));
					Iterable<Value> transform = Iterables.transform(
							rightValueCollection,
							opValueToValue(operation, (BigDecimal) leftEval,
									false));
					result = Lists.newArrayList(transform);
				} else if (assertNumericCollection(rightEval)) {
					List<BigDecimal> rightNumericCollection = asNumericCollection(asCollection((List<?>) rightEval));
					Iterable<BigDecimal> transform = Iterables
							.transform(
									rightNumericCollection,
									opNumToNum(operation,
											(BigDecimal) leftEval, false));
					result = Lists.newArrayList(transform);
				}
			}
		} else if (assertValue(leftEval)) {
			// From the model, no reference will return a single value, so this
			// can be ignored.
			throw new UnsupportedOperationException(
					"Operation on single value is not supported");
		} else if (assertCollection(leftEval)) {
			// NOTE: Operations are reverted, apply to the left collection.
			if (assertValueCollection(leftEval)) {
				List<Value> leftValueCollection = asCopyOfValueCollection(asCollection((List<?>) leftEval));
				if (assertNumeric(rightEval)) {
					Iterable<Value> transform = Iterables.transform(
							leftValueCollection,
							opValueToValue(operation,
									asNum((BigDecimal) rightEval), true));
					result = Lists.newArrayList(transform);
				} else if (assertValue(rightEval)) {
					Iterable<Value> transform = Iterables.transform(
							leftValueCollection,
							opValueToValue(operation, (Value) rightEval, true));
					result = Lists.newArrayList(transform);
				} else if (assertCollection(rightEval)) {
					if (assertNumericCollection(rightEval)) {

						@SuppressWarnings("unused")
						List<BigDecimal> rightNumericCollection = asNumericCollection(asCollection((List<?>) rightEval));
						// TODO, apply collection left and right.

					} else if (assertValueCollection(rightEval)) {
						List<Value> rightValueCollection = asValueCollection(asCollection((List<?>) rightEval));
						opValueToValue(operation, leftValueCollection,
								rightValueCollection);
						result = leftValueCollection;
					}
				}
			} else if (assertNumericCollection(leftEval)) {
				List<BigDecimal> leftNumericCollection = asNumericCollection(asCollection((List<?>) leftEval));
				if (assertNumeric(rightEval)) {
					Iterable<BigDecimal> transform = Iterables.transform(
							leftNumericCollection,
							opNumToNum(operation,
									asNum((BigDecimal) rightEval), true));
					result = Lists.newArrayList(transform);
				} else if (assertValue(rightEval)) {
					Iterable<BigDecimal> transform = Iterables.transform(
							leftNumericCollection,
							opNumToNum(operation, (Value) rightEval, true));
					result = Lists.newArrayList(transform);
				} else if (assertCollection(rightEval)) {

					if (assertNumericCollection(rightEval)) {
						@SuppressWarnings("unused")
						List<BigDecimal> rightNumericCollection = asNumericCollection(asCollection((List<?>) rightEval));
					} else if (assertValueCollection(rightEval)) {
						@SuppressWarnings("unused")
						List<Value> rightValueCollection = asValueCollection(asCollection((List<?>) rightEval));
						// TODO, apply collection left and right.
					}
				}
			}
		}

		if (result != null) {
			return result;
		} else {
			// CB 09-04-2012, this would prevent any sub-sequent resource for a
			// component to be evaluated, so do not
			// throw an exception.

			// throw new UnsupportedOperationException(
			// "Multiplication expression for invalid types");

			return result;
		}

	}

	public static BigDecimal asNum(BigDecimal eval) {
		return (BigDecimal) eval;
	}

	public static BigDecimal asNum(Value eval) {
		return new BigDecimal(eval.getValue());
	}

	public static List<?> asCollection(List<?> collection) {
		return (List<?>) collection;
	}

	@SuppressWarnings("unchecked")
	public static List<Value> asValueCollection(List<?> collection) {
		return (List<Value>) collection;
	}

	private List<Value> asCopyOfValueCollection(List<?> collection) {

		List<Value> copyList = Lists.newArrayList();
		for (Object o : collection) {
			if (assertValue(o)) {
				Value copy = EcoreUtil.copy((Value) o);
				copyList.add(copy);
			}
		}
		return copyList;
	}

	@SuppressWarnings("unchecked")
	public static List<BigDecimal> asNumericCollection(List<?> collection) {
		return (List<BigDecimal>) collection;
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
				return asNum((BigDecimal) rightEval);
			} else {
				return asNum((BigDecimal) rightEval).negate();
			}
		} else {
			throw new UnsupportedOperationException(e.toString());
		}
	}

	// Assertion on expected types.
	// How to build the grammar, that types represent expression types, and
	// avoid casting?

	public static boolean assertBoolean(Object eval) {
		return (eval instanceof Boolean);
	}

	public static boolean assertBoolean(Object left, Object right) {
		return (left instanceof Boolean && right instanceof Boolean);
	}

	public static boolean assertNumeric(Object eval) {
		return (eval instanceof BigDecimal);
	}

	public static boolean assertNumeric(Object left, Object right) {
		return (left instanceof BigDecimal && right instanceof BigDecimal);
	}

	public static boolean assertValueOrNumeric(Object eval) {
		return assertNumeric(eval) || assertValue(eval);
	}

	public static boolean assertValue(Object eval) {
		return (eval instanceof Value);
	}

	/*
	 * Structural equality according to
	 */
	protected boolean assertValueTSEqual(Value leftValue, Value rightValue) {
		return modelUtils.valueTimeStampCompare()
				.compare(leftValue, rightValue) == 0;
	}

	public static boolean assertCollection(Object eval) {
		return (eval instanceof List<?>);
	}

	public static boolean assertValueCollection(Object eval) {
		if (eval instanceof List<?>) {
			for (Object o : asCollection((List<?>) eval)) {
				if (!assertValue(o)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public static boolean assertNumericCollection(Object eval) {
		if (eval instanceof List<?>) {
			for (Object o : asCollection((List<?>) eval)) {
				if (!assertNumeric(o)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public static boolean assertMatrix(List<?> collection) {
		if (collection.isEmpty()) {
			return false;
		}
		for (Object o : collection) {
			if (!assertCollection(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return Joiner.on(",").join(contextList);
	}

	public List<BaseExpressionResult> getResult() {
		return expressionResults;
	}

}

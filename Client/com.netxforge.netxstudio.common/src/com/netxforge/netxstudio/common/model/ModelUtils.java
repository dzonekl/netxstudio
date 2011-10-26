package com.netxforge.netxstudio.common.model;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.spi.common.id.AbstractCDOIDLong;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LevelKind;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.netxstudio.operators.ToleranceMarkerDirectionKind;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

public class ModelUtils {

	public static final String DATE_PATTERN_1 = "MM/dd/yyyy";
	public static final String DATE_PATTERN_2 = "dd-MM-yyyy";
	public static final String DATE_PATTERN_3 = "dd.MM.yyyy";

	public static final String TIME_PATTERN_1 = "HH:mm:ss"; // 24 hour.
	public static final String TIME_PATTERN_2 = "HH:mm"; // 24 hour
	public static final String TIME_PATTERN_3 = "hh:mm:ss"; // AM PM
	public static final String TIME_PATTERN_4 = "hh:mm"; // AM PM

	public static final String TIM_PATTERN_5 = "a"; // AM PM marker.
	public static final String DEFAULT_DATE_TIME_PATTERN = "MM/dd/yyyy HH:mm:ss";

	public static final int SECONDS_IN_A_MINUTE = 60;
	public static final int SECONDS_IN_A_QUARTER = SECONDS_IN_A_MINUTE * 15;
	public static final int SECONDS_IN_AN_HOUR = SECONDS_IN_A_MINUTE * 60;
	public static final int SECONDS_IN_A_DAY = SECONDS_IN_AN_HOUR * 24;
	public static final int SECONDS_IN_A_WEEK = SECONDS_IN_A_DAY * 7;

	public static final int MINUTES_IN_AN_HOUR = 60;
	public static final int MINUTES_IN_A_DAY = 60 * 24;
	public static final int MINUTES_IN_A_WEEK = MINUTES_IN_A_DAY * 4;

	// Note! For months, we better use a calendar function.
	public static final int MINUTES_IN_A_MONTH = MINUTES_IN_A_DAY * 30;

	/**
	 * Compare two dates.
	 */
	public class ValueTimeStampComparator implements Comparator<Value> {
		public int compare(final Value v1, final Value v2) {
			return v1.getTimeStamp().compare(v2.getTimeStamp());
		}
	};

	public ValueTimeStampComparator valueTimeStampCompare() {
		return new ValueTimeStampComparator();
	}

	public class MarkerTimeStampComparator implements Comparator<Marker> {
		public int compare(final Marker m1, final Marker m2) {
			return new ValueTimeStampComparator().compare(m1.getValueRef(),
					m2.getValueRef());
		}
	};

	public MarkerTimeStampComparator markerTimeStampCompare() {
		return new MarkerTimeStampComparator();
	}

	public class ServiceMonitorComparator implements Comparator<ServiceMonitor> {
		public int compare(final ServiceMonitor sm1, ServiceMonitor sm2) {
			// Simply compare the begin of the period, we do not check for
			// potential
			// overlap with the end of the period.
			return sm1.getPeriod().getBegin()
					.compare(sm2.getPeriod().getBegin());
		}
	};

	public ServerSettings serverSettings(Resource serverSettingsResource) {

		if (serverSettingsResource != null
				&& serverSettingsResource.getContents().size() == 1) {
			ServerSettings settings = (ServerSettings) serverSettingsResource
					.getContents().get(0);
			return settings;
		}

		return null;

	}

	public ServiceMonitorComparator serviceMonitorCompare() {
		return new ServiceMonitorComparator();
	}

	public class NodeTypeIsLeafComparator implements Comparator<NodeType> {
		public int compare(final NodeType nt1, NodeType nt2) {
			if (nt1.isLeafNode() && nt2.isLeafNode()) {
				return 0;
			}
			if (nt1.isLeafNode() && !nt2.isLeafNode()) {
				return 1;
			}
			if (!nt1.isLeafNode() && nt2.isLeafNode()) {
				return -1;
			}
			return 0;
		}
	};

	public NodeTypeIsLeafComparator nodeTypeIsLeafComparator() {
		return new NodeTypeIsLeafComparator();
	}

	public class ValuerInsideRange implements Predicate<Value> {
		private final DateTimeRange dtr;

		public ValuerInsideRange(final DateTimeRange dtr) {
			this.dtr = dtr;
		}

		public boolean apply(final Value v) {

			long begin = dtr.getBegin().toGregorianCalendar().getTimeInMillis();
			long end = dtr.getEnd().toGregorianCalendar().getTimeInMillis();
			long target = v.getTimeStamp().toGregorianCalendar()
					.getTimeInMillis();
			return begin <= target && end >= target;
		}
	}

	public ValuerInsideRange valueInsideRange(DateTimeRange dtr) {
		return new ValuerInsideRange(dtr);
	}

	public class NodeOfType implements Predicate<Node> {
		private final NodeType nt;

		public NodeOfType(final NodeType nt) {
			this.nt = nt;
		}

		public boolean apply(final Node node) {
			if (node.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
				if (node.getNodeType().eIsSet(
						LibraryPackage.Literals.NODE_TYPE__NAME)) {
					return node.getNodeType().getName().equals(nt.getName());
				}
			}
			return false;
		}
	}

	public NodeOfType nodeOfType(NodeType nodeType) {
		return new NodeOfType(nodeType);
	}

	public class NodeInRelationship implements Predicate<Node> {
		private final Relationship r;

		public NodeInRelationship(final Relationship r) {
			this.r = r;
		}

		public boolean apply(final Node n) {
			return r.getNodeID1Ref() == n;
		}
	}

	public class SourceRelationshipForNode implements Predicate<Relationship> {
		private final Node n;

		public SourceRelationshipForNode(final Node n) {
			this.n = n;
		}

		public boolean apply(final Relationship r) {
			return r.getNodeID1Ref() == n;
		}
	}

	public NodeInRelationship nodeInRelationship(Relationship r) {
		return new NodeInRelationship(r);
	}

	public SourceRelationshipForNode sourceRelationshipInNode(Node n) {
		return new SourceRelationshipForNode(n);
	}

	/*
	 * Note will not provide the ServiceMonitors for which the period is partly
	 * in range. targetBegin <= begin && targetEnd <= end. (Example of an
	 * overlapping).
	 */
	public class ServiceMonitorInsideRange implements Predicate<ServiceMonitor> {
		private final DateTimeRange dtr;

		public ServiceMonitorInsideRange(final DateTimeRange dtr) {
			this.dtr = dtr;
		}

		public boolean apply(final ServiceMonitor s) {

			long begin = dtr.getBegin().toGregorianCalendar().getTimeInMillis();
			long end = dtr.getEnd().toGregorianCalendar().getTimeInMillis();

			long targetBegin = s.getPeriod().getBegin().toGregorianCalendar()
					.getTimeInMillis();
			long targetEnd = s.getPeriod().getEnd().toGregorianCalendar()
					.getTimeInMillis();

			return targetBegin >= begin && targetEnd <= end;

		}
	}

	public ServiceMonitorInsideRange serviceMonitorinsideRange(DateTimeRange dtr) {
		return new ServiceMonitorInsideRange(dtr);
	}

	public class IsRelationship implements Predicate<EObject> {
		public boolean apply(final EObject eo) {
			return eo instanceof Relationship;
		}
	}

	public IsRelationship isRelationship() {
		return new IsRelationship();
	}

	public class MarkerForValue implements Predicate<Marker> {
		private final Value value;

		public MarkerForValue(final Value value) {
			this.value = value;
		}

		public boolean apply(final Marker m) {
			Value mValue = m.getValueRef();
			if (mValue != null) {
				return mValue == value;
			}
			return false;
		}
	}

	public MarkerForValue markerForValue(Value v) {
		return new MarkerForValue(v);
	}

	/**
	 * Will be valid when the lifecycle is not set.
	 * 
	 * @param node
	 * @return
	 */
	public boolean isInService(Node node) {
		if (node.getLifecycle() == null) {
			return true;
		}
		final long time = System.currentTimeMillis();
		if (node.getLifecycle().getInServiceDate() != null
				&& node.getLifecycle().getInServiceDate().toGregorianCalendar()
						.getTimeInMillis() > time) {
			return false;
		}
		if (node.getLifecycle().getOutOfServiceDate() != null
				&& node.getLifecycle().getOutOfServiceDate()
						.toGregorianCalendar().getTimeInMillis() < time) {
			return false;
		}
		return true;
	}

	@Inject
	private DatatypeFactory dataTypeFactory;

	/**
	 * Compute a resource path on the basis of an instance. Components generate
	 * a specific path based on their location in the node/nodetype tree.
	 */
	public String getResourcePath(EObject eObject) {
		if (eObject instanceof Component) {
			final Component component = (Component) eObject;
			return getResourcePath(component.eContainer()) + "/"
					+ component.getName();
		} else if (eObject instanceof Node) {
			return "/Node_/" + ((Node) eObject).getNodeID();
		} else if (eObject instanceof NodeType) {
			final NodeType nodeType = (NodeType) eObject;
			if (nodeType.eContainer() instanceof Node) {
				return getResourcePath(nodeType.eContainer());
			}
			return "/NodeType_/" + ((NodeType) eObject).getName();
		} else {
			return eObject.eClass().getName();
		}
	}

	public List<com.netxforge.netxstudio.library.Function> functionsWithName(
			List<com.netxforge.netxstudio.library.Function> functions,
			String name) {
		final List<com.netxforge.netxstudio.library.Function> fl = Lists
				.newArrayList();
		for (final com.netxforge.netxstudio.library.Function f : functions) {
			if (f.getName().equals(name)) {
				fl.add(f);
			}
			fl.addAll(this.functionsWithName(f.getFunctions(), name));
		}
		return fl;
	}

	public List<Equipment> equimentsWithCode(List<Equipment> equips, String code) {
		final List<Equipment> el = Lists.newArrayList();
		for (final Equipment e : equips) {
			if (e.getEquipmentCode().equals(code)) {
				el.add(e);
			}
			el.addAll(this.equimentsWithCode(e.getEquipments(), code));
		}
		return el;
	}

	public Collection<String> expressionLines(String Expression) {
		final String[] splitByNewLine = Expression.split("\n");
		final Collection<String> collection = Lists
				.newArrayList(splitByNewLine);
		return collection;
	}

	public List<NetXResource> allResources(Node node) {
		List<NetXResource> resources = Lists.newArrayList();
		TreeIterator<EObject> iterator = node.eAllContents();
		while (iterator.hasNext()) {
			EObject eo = iterator.next();
			if (eo instanceof NetXResource) {
				resources.add((NetXResource) eo);
			}
		}
		return resources;
	}

	public List<DerivedResource> derivedResourcesWithName(Service s,
			String expressionName) {

		final List<DerivedResource> drL = Lists.newArrayList();

		for (ServiceUser su : s.getServiceUserRefs()) {
			if (su.eIsSet(ServicesPackage.Literals.SERVICE_USER__SERVICE_PROFILE)) {
				for (DerivedResource dr : su.getServiceProfile()
						.getProfileResources()) {
					if (dr.getExpressionName().equals(expressionName)) {
						drL.add(dr);
					}
				}
			}
		}
		return drL;
	}

	public List<NetXResource> resourcesWithExpressionName(NodeType nt,
			String expressionName) {
		final List<Component> cl = Lists.newArrayList();
		cl.addAll(nt.getEquipments());
		cl.addAll(nt.getFunctions());
		return this.resourcesWithExpressionName(cl, expressionName);
	}

	public List<NetXResource> resourcesWithExpressionName(Node n,
			String expressionName) {
		final List<Component> cl = Lists.newArrayList();
		cl.addAll(n.getNodeType().getEquipments());
		cl.addAll(n.getNodeType().getFunctions());
		return this.resourcesWithExpressionName(cl, expressionName);
	}

	public List<Value> sortByTimeStampAndReverse(List<Value> values) {
		System.out.println("ResourceMonitor: sorting entries:" + values.size()
				+ new Date(System.currentTimeMillis()));

		List<Value> sortedCopy = Ordering.from(valueTimeStampCompare())
				.reverse().sortedCopy(values);

		System.out.println("ResourceMonitor: done sorting entries:"
				+ new Date(System.currentTimeMillis()));
		return sortedCopy;

	}

	public List<Value> sortValuesByTimeStamp(List<Value> values) {
		List<Value> sortedCopy = Ordering.from(valueTimeStampCompare())
				.sortedCopy(values);

		return sortedCopy;

	}

	public List<Marker> sortMarkersByTimeStamp(List<Marker> markers) {
		List<Marker> sortedCopy = Ordering.from(markerTimeStampCompare())
				.sortedCopy(markers);
		return sortedCopy;
	}

	public List<ServiceMonitor> filterSerciceMonitorInRange(
			List<ServiceMonitor> unfiltered, DateTimeRange dtr) {
		Iterable<ServiceMonitor> filterValues = Iterables.filter(unfiltered,
				this.serviceMonitorinsideRange(dtr));
		return (Lists.newArrayList(filterValues));
	}

	public List<Value> filterValueInRange(List<Value> unfiltered,
			DateTimeRange dtr) {
		Iterable<Value> filterValues = Iterables.filter(unfiltered,
				this.valueInsideRange(dtr));
		return (Lists.newArrayList(filterValues));
	}

	/**
	 * Return the Node or null if the target object, has a Node somewhere along
	 * the parent hiearchy.
	 * 
	 * @param target
	 * @return
	 */
	public Node resolveParentNode(EObject target) {
		if( target instanceof Node){
			return (Node) target;
		}
		if (target != null && target.eContainer() != null) {
			if (target.eContainer() instanceof Node) {
				return (Node) target.eContainer();
			} else {
				return resolveParentNode(target.eContainer());
			}
		} else {
			return null;
		}
	}

	/**
	 * Return the Node or null if the target object, has a NodeType somewhere
	 * along the parent hiearchy.
	 * 
	 * @param target
	 * @return
	 */
	public NodeType resolveParentNodeType(EObject target) {

		if (target instanceof NodeType) {
			return (NodeType) target;
		} else if (target != null && target.eContainer() != null) {
			if (target.eContainer() instanceof NodeType) {
				return (NodeType) target.eContainer();
			} else {
				return resolveParentNodeType(target.eContainer());
			}
		} else {
			return null;
		}
	}

	public ServiceMonitor lastServiceMonitor(Service service) {
		if (service.getServiceMonitors().isEmpty()) {
			return null;
		}
		int size = service.getServiceMonitors().size();
		ServiceMonitor sm = service.getServiceMonitors().get(size - 1);
		return sm;
	}

	/**
	 * Business Rule:
	 * 
	 * A Lifecycle is valid when the Lifecycle sequence are in chronological
	 * order.
	 * 
	 * @param lf
	 * @return
	 */
	public boolean lifeCycleValid(Lifecycle lf) {

		long proposed = lf.getProposed().toGregorianCalendar()
				.getTimeInMillis();
		long planned = lf.getPlannedDate().toGregorianCalendar()
				.getTimeInMillis();
		long construction = lf.getConstructionDate().toGregorianCalendar()
				.getTimeInMillis();
		long inService = lf.getInServiceDate().toGregorianCalendar()
				.getTimeInMillis();
		long outOfService = lf.getOutOfServiceDate().toGregorianCalendar()
				.getTimeInMillis();

		boolean proposed_planned = lf
				.eIsSet(GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE) ? proposed <= planned
				: true;
		boolean planned_construction = lf
				.eIsSet(GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE) ? planned <= construction
				: true;
		boolean construcion_inService = lf
				.eIsSet(GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE) ? construction <= inService
				: true;
		boolean inService_outOfService = lf
				.eIsSet(GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE) ? inService <= outOfService
				: true;

		return proposed_planned && planned_construction
				&& construcion_inService && inService_outOfService;
	}

	// public class HasNodeType implements Predicate<NodeType> {
	//
	// private List<NodeType> baseList;
	//
	// public HasNodeType(List<NodeType> baseList) {
	// this.baseList = baseList;
	// }
	// public boolean apply(final NodeType toApply) {
	// for(NodeType nt : baseList){
	// if(nt.getName().equals(toApply)){
	// return true;
	// }
	// }
	// return false;
	// }
	// }
	//
	// public Predicate<NodeType> hasNodeType(List<NodeType> nodeTypes){
	// return new HasNodeType(nodeTypes);
	// }

	public List<NodeType> uniqueNodeTypes(List<NodeType> unfiltered) {
		List<NodeType> uniques = Lists.newArrayList();
		for (NodeType nt : unfiltered) {
			ImmutableList<NodeType> uniquesCopy = ImmutableList.copyOf(uniques);
			boolean found = false;
			for (NodeType u : uniquesCopy) {
				if (nt.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)
						&& u.eIsSet(LibraryPackage.Literals.NODE_TYPE__NAME)) {
					if (u.getName().equals(nt.getName())) {
						found = true;
					}
				} else {
					continue;
				}
			}
			if (!found) {
				uniques.add(nt);
			}
		}
		return uniques;
	}

	public List<Node> nodesForNodeType(List<Node> nodes, NodeType targetNodeType) {
		Iterable<Node> filtered = Iterables.filter(nodes,
				this.nodeOfType(targetNodeType));
		return Lists.newArrayList(filtered);
	}

	public List<Node> nodesForNodeType(RFSService service,
			NodeType targetNodeType) {
		Iterable<Node> filtered = Iterables.filter(service.getNodes(),
				this.nodeOfType(targetNodeType));
		return Lists.newArrayList(filtered);
	}

	public RFSServiceSummary serviceSummaryForService(Service service,
			DateTimeRange dtr) {
		RFSServiceSummary serviceSummary = new RFSServiceSummary(
				(RFSService) service);

		if (service instanceof RFSService) {
			int[] ragTotalResources = new int[] { 0, 0, 0 };
			int[] ragTotalNodes = new int[] { 0, 0, 0 };
			for (Node n : ((RFSService) service).getNodes()) {
				int[] ragResources = ragCountResourcesForNode(service, n, dtr);
				for (int i = 0; i < ragTotalResources.length; i++) {
					ragTotalResources[i] += ragResources[i];
				}
				// Any of the levels > 0, we increase the total node count.
				ragTotalNodes[0] += ragResources[0] > 0 ? 1 : 0;
				ragTotalNodes[1] += ragResources[1] > 0 ? 1 : 0;
				ragTotalNodes[2] += ragResources[2] > 0 ? 1 : 0;
			}
			serviceSummary.setRagCountResources(ragTotalResources);
			serviceSummary.setRagCountNodes(ragTotalNodes);
		}
		return serviceSummary;
	}

	/**
	 * Overall RAG Status.
	 * 
	 * @param sm
	 * @return
	 * @deprecated DO NOT USE, no distinction per NetXResource.
	 */
	public int[] ragCountResources(ServiceMonitor sm) {

		int red = 0, amber = 0, green = 0;

		for (ResourceMonitor rm : sm.getResourceMonitors()) {
			int[] rag = ragForMarkers(rm.getMarkers());
			red += rag[0];
			amber += rag[1];
			green += rag[2];
		}
		return new int[] { red, amber, green };

	}

	public boolean ragShouldReport(int[] ragStatus) {
		if (ragStatus.length != 3) {
			return false;
		}

		if (ragStatus[0] > 0) {
			return true;
		}

		if (ragStatus[1] > 0) {
			return true;
		}

		return false;
	}

	/**
	 * Get the first marker with this value otherwise null.
	 * 
	 * @param markers
	 * @param v
	 * @return
	 */
	public Marker markerForValue(List<Marker> markers, Value v) {

		Iterable<Marker> filtered = Iterables.filter(markers,
				this.markerForValue(v));
		if (Iterables.size(filtered) > 0) {
			return filtered.iterator().next();
		}
		return null;
	}

	public Map<NetXResource, List<Marker>> markersForNode(Service service,
			Node n, DateTimeRange dtr) {

		// Sort and reverse the Service Monitors.
		List<ServiceMonitor> sortedCopy = Ordering
				.from(this.serviceMonitorCompare()).reverse()
				.sortedCopy(service.getServiceMonitors());

		// Filter ServiceMonitors on the time range.
		List<ServiceMonitor> filtered = this.filterSerciceMonitorInRange(
				sortedCopy, dtr);

		Map<NetXResource, List<Marker>> markersPerResource = Maps.newHashMap();

		for (ServiceMonitor sm : filtered) {

			for (ResourceMonitor rm : sm.getResourceMonitors()) {
				if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {

					// Analyze per resource.
					List<Marker> markers;
					NetXResource res = rm.getResourceRef();
					if (!markersPerResource.containsKey(res)) {
						markers = Lists.newArrayList();
						markersPerResource.put(res, markers);
					} else {
						markers = markersPerResource.get(res);
					}

					Marker[] markerArray = new Marker[rm.getMarkers().size()];
					rm.getMarkers().toArray(markerArray);
					List<Marker> toleranceMarkers = this
							.toleranceMarkers(markerArray);

					markers.addAll(toleranceMarkers);

				}
			}

		}
		return markersPerResource;

	}

	/**
	 * Provides a total list of markers for the Service Monitor, Node and Date
	 * Time Range. ,indiscreet of the NetXResource.
	 * 
	 * @param sm
	 * @param n
	 * @param dtr
	 * @return
	 */
	public List<Marker> markersWithinRange(ServiceMonitor sm, Node n) {
		// Process a ServiceMonitor for which the period is somehow within the
		// range.
		List<Marker> filtered = Lists.newArrayList();

		// Each RM represents a Resource.
		for (ResourceMonitor rm : sm.getResourceMonitors()) {
			if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {
				Marker[] markerArray = new Marker[rm.getMarkers().size()];
				rm.getMarkers().toArray(markerArray);
				List<Marker> markersForNodeList = this
						.toleranceMarkers(markerArray);
				if (markersForNodeList.size() > 0) {
					filtered.addAll(markersForNodeList);
				}
			}

		}

		return filtered;
	}

	// public int[] ragCount(ServiceMonitor sm, Node n,
	// DateTimeRange dtr) {
	//
	// int red = 0, amber = 0, green = 0;
	// //Each RM represents a Resource.
	// for (ResourceMonitor rm : sm.getResourceMonitors()) {
	// if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {
	// Marker[] markerArray = new Marker[rm.getMarkers().size()];
	// rm.getMarkers().toArray(markerArray);
	// List<Marker> markersForNodeList = this
	// .toleranceMarkers(markerArray);
	// int[] rag = this.ragForMarkers(markersForNodeList);
	// red += rag[0];
	// amber += rag[1];
	// green += rag[2];
	// }
	//
	// }
	//
	// return new int[]{red, amber, green};
	// }

	/**
	 * A two pass rag analyzer. First go through all ResourceMonitor and bundle
	 * the markers per NetXResource. Then count the RAG per NetXResource's
	 * markers. Note: Resources which are not referenced by a Resource Monitor
	 * from the specified node, are ignored.
	 * 
	 * @param sm
	 * @param n
	 * @return
	 */
	public int[] ragCountResourcesForNode(Service service, Node n,
			DateTimeRange dtr) {

		int red = 0, amber = 0, green = 0;

		// Sort and reverse the Service Monitors.
		List<ServiceMonitor> sortedCopy = Ordering
				.from(this.serviceMonitorCompare()).reverse()
				.sortedCopy(service.getServiceMonitors());

		// Filter ServiceMonitors on the time range.
		List<ServiceMonitor> filtered = this.filterSerciceMonitorInRange(
				sortedCopy, dtr);

		Map<NetXResource, List<Marker>> markersPerResource = Maps.newHashMap();

		for (ServiceMonitor sm : filtered) {

			for (ResourceMonitor rm : sm.getResourceMonitors()) {
				if (rm.getNodeRef().getNodeID().equals(n.getNodeID())) {

					// Analyze per resource.
					List<Marker> markers;
					NetXResource res = rm.getResourceRef();
					if (!markersPerResource.containsKey(res)) {
						markers = Lists.newArrayList();
						markersPerResource.put(res, markers);
					} else {
						markers = markersPerResource.get(res);
					}

					Marker[] markerArray = new Marker[rm.getMarkers().size()];
					rm.getMarkers().toArray(markerArray);
					List<Marker> toleranceMarkers = this
							.toleranceMarkers(markerArray);

					markers.addAll(toleranceMarkers);

				}
			}

		}

		for (NetXResource res : markersPerResource.keySet()) {

			List<Marker> markers = markersPerResource.get(res);
			int[] rag = ragForMarkers(markers);
			red += rag[0];
			amber += rag[1];
			green += rag[2];

		}

		return new int[] { red, amber, green };
	}

	public int[] ragForMarkers(List<Marker> markersForNodeList) {

		int red = 0, amber = 0, green = 0;
		Marker[] markerForNodeArray = new Marker[markersForNodeList.size()];
		markersForNodeList.toArray(markerForNodeArray);
		// Iterate markers per level.
		for (LevelKind lk : LevelKind.VALUES) {

			ToleranceMarker tm = lastToleranceMarker(lk, markerForNodeArray);
			if (tm != null) {
				switch (tm.getLevel().getValue()) {
				case LevelKind.RED_VALUE: {
					if (isStartOrUp(tm)) {
						red++;
					}
				}
					break;
				case LevelKind.AMBER_VALUE: {
					if (isStartOrUp(tm)) {
						amber++;
					}
				}
					break;
				case LevelKind.GREEN_VALUE: {
					if (isStartOrUp(tm)) {
						green++;
					}
				}
					break;
				}
			}
			// else {
			// green++;
			// }
		}

		// Clear the lower levels.
		if (red > 0) {
			amber = 0;
			green = 0;
		}
		if (amber > 0) {
			green = 0;
		}

		return new int[] { red, amber, green };
	}

	public boolean isStartOrUp(ToleranceMarker tm) {
		return tm.getDirection() == ToleranceMarkerDirectionKind.UP
				|| tm.getDirection() == ToleranceMarkerDirectionKind.START;
	}

	public List<Marker> toleranceMarkers(Marker... unfiltered) {
		List<Marker> resultList = Lists.newArrayList();
		List<Marker> markerList = Lists.newArrayList(unfiltered);
		for (Marker m : markerList) {
			if (m instanceof ToleranceMarker) {
				ToleranceMarker tempMarker = (ToleranceMarker) m;
				resultList.add(tempMarker);
			}
		}
		return resultList;
	}

	/**
	 * Return the last marker which is either START or UP. The lists is sorted
	 * and analyzed from the tail. (Newest first). Return null, if we can't find
	 * a marker matching the Level Kind.
	 * 
	 * @param lk
	 * @param markers
	 * @return
	 */
	public ToleranceMarker lastToleranceMarker(LevelKind lk, Marker... markers) {
		ToleranceMarker tm = null;
		List<Marker> markerList = Lists.newArrayList(markers);
		markerList = sortMarkersByTimeStamp(markerList);
		Collections.reverse(markerList);
		for (Marker m : markerList) {
			if (m instanceof ToleranceMarker
					&& ((ToleranceMarker) m).getLevel() == lk) {
				tm = (ToleranceMarker) m;
				break;
			}
		}
		return tm;
	}

	/**
	 * 
	 * Get the Job of a certain type with a target value for the target feature.
	 * 
	 * @param jobResource
	 * @param jobClass
	 * @param feature
	 * @param value
	 * @return
	 */
	public Job jobForSingleObject(Resource jobResource, EClass jobClass,
			EStructuralFeature feature, EObject value) {

		// The job Class should extend the Job EClass.
		if (!jobClass.getESuperTypes().contains(SchedulingPackage.Literals.JOB)) {
			return null;
		}

		for (EObject eo : jobResource.getContents()) {
			if (eo.eClass() == jobClass) {
				if (eo.eIsSet(feature)) {
					Object v = eo.eGet(feature);
					if (v == value) {
						return (Job) eo;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * Get the Job of a certain type with a target collection contained in the
	 * collection of the target feature.
	 * 
	 * @param jobResource
	 * @param jobClass
	 * @param feature
	 * @param targetValues
	 * @return
	 */
	public Job jobForMultipleObjects(Resource jobResource, EClass jobClass,
			EStructuralFeature feature, Collection<?> targetValues) {

		assert feature.isMany();

		int shouldMatch = targetValues.size();

		// The job Class should extend the Job EClass.
		if (!jobClass.getESuperTypes().contains(SchedulingPackage.Literals.JOB)) {
			return null;
		}

		for (EObject eo : jobResource.getContents()) {
			int actuallyMatches = 0;
			if (eo.eClass() == jobClass) {
				if (eo.eIsSet(feature)) {
					Object v = eo.eGet(feature);
					if (v instanceof List<?>) {
						for (Object listItem : (List<?>) v) {
							// Do we contain any of our objects?
							for (Object target : targetValues) {
								if (listItem == target) {
									actuallyMatches++;
								}
							}
						}
					}
				}
			}
			// Check if the number of entries are actually in the target job.
			if (actuallyMatches == shouldMatch) {
				return (Job) eo;
			}
		}
		return null;
	}

	public DateTimeRange lastMonthPeriod() {
		DateTimeRange dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
		dtr.setBegin(this.toXMLDate(oneMonthAgo()));
		dtr.setEnd(this.toXMLDate(todayAndNow()));
		return dtr;
	}

	public Date start(DateTimeRange dtr) {
		return this.fromXMLDate(dtr.getBegin());
	}

	public Date end(DateTimeRange dtr) {
		return this.fromXMLDate(dtr.getEnd());
	}

	public DateTimeRange period(Date start, Date end) {
		DateTimeRange dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
		dtr.setBegin(this.toXMLDate(start));
		dtr.setEnd(this.toXMLDate(end));
		return dtr;
	}

	public String formatLastMonitorDate(ServiceMonitor sm) {
		DateTimeRange dtr = sm.getPeriod();
		return formatPeriod(dtr);
	}

	public String formatPeriod(DateTimeRange dtr) {
		StringBuilder sb = new StringBuilder();
		Date begin = fromXMLDate(dtr.getBegin());
		Date end = fromXMLDate(dtr.getEnd());
		sb.append("From: ");
		sb.append(date(begin));
		sb.append(" @ ");
		sb.append(time(begin));
		sb.append(" To: ");
		sb.append(date(end));
		sb.append(" @ ");
		sb.append(time(end));
		return sb.toString();
	}

	public List<NetXResource> resourcesInMetricSource(
			EList<EObject> allMetrics, MetricSource ms) {

		List<Metric> targetListInMetricSource = Lists.newArrayList();

		// Cross reference the metrics.
		for (EObject o : allMetrics) {
			if (o instanceof CDOObject) {
				CDOView cdoView = ((CDOObject) o).cdoView();
				try {
					List<CDOObjectReference> queryXRefs = cdoView
							.queryXRefs(
									(CDOObject) o,
									new EReference[] { MetricsPackage.Literals.VALUE_DATA_KIND__METRIC_REF });

					if (queryXRefs != null) {
						for (CDOObjectReference xref : queryXRefs) {

							EObject referencingValueDataKind = xref
									.getSourceObject();
							EObject targetMetric = xref.getTargetObject();
							for (MappingColumn mc : ms.getMetricMapping()
									.getDataMappingColumns()) {
								DataKind dk = mc.getDataType();
								// auch, that hurts....
								if (dk instanceof ValueDataKind
										&& (dk.cdoID() == ((CDOObject) referencingValueDataKind)
												.cdoID())) {
									// Yes, this is the one, add the metric.
									targetListInMetricSource
											.add((Metric) targetMetric);
								}
							}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					// The query sometimes throws exeception, if i.e an entity
					// can't be found..
					// EClass ExpressionResult does not have an entity name, has
					// it been mapped to Hibernate?
				}
			}
		}

		return resourcesForMetrics(targetListInMetricSource);
	}

	public List<NetXResource> resourcesForMetrics(
			List<Metric> targetListInMetricSource) {
		List<NetXResource> targetListNetXResources = Lists.newArrayList();

		// Cross reference the metrics from the target MetricSource.
		for (EObject o : targetListInMetricSource) {

			System.out.println("Look for NetXResource referencing metric: "
					+ ((Metric) o).getName());

			if (o instanceof CDOObject) {
				CDOView cdoView = ((CDOObject) o).cdoView();
				try {
					List<CDOObjectReference> queryXRefs = cdoView
							.queryXRefs(
									(CDOObject) o,
									new EReference[] { LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF });

					if (queryXRefs != null) {
						for (CDOObjectReference xref : queryXRefs) {

							EObject referencingEObject = xref.getSourceObject();
							// Gather all metrics from the target source.
							if (referencingEObject instanceof NetXResource) {
								NetXResource res = (NetXResource) referencingEObject;
								Node n = this.resolveParentNode(res
										.getComponentRef());
								if (n != null) {
									targetListNetXResources
											.add((NetXResource) referencingEObject);
								}
							}

						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					// The query sometimes throws exeception, if i.e an entity
					// can't be found..
					// EClass ExpressionResult does not have an entity name, has
					// it been mapped to Hibernate?
				}
			}
		}

		return targetListNetXResources;
	}

	/**
	 * Get a collection from a target object, use the last occurrence in the
	 * collection, to get an attribute value. return the attribute value
	 * incremented by 1.
	 * 
	 * 
	 * @param targetObject
	 * @param collectionFeature
	 * @param identityFeature
	 *            An identity attribute which should be of type String.
	 * @return A String incremented by 1.
	 */
	public String getSequenceNumber(EObject targetObject,
			EStructuralFeature collectionFeature, EAttribute identityFeature) {
		String newName = null;
		if (collectionFeature.isMany()) {
			final List<?> collection = (List<?>) targetObject
					.eGet(collectionFeature);
			final int size = collection.size();
			if (size > 0) {
				final EObject lastChild = (EObject) collection.get(size - 1);
				if (lastChild.eIsSet(identityFeature)) {
					final String lastName = (String) lastChild
							.eGet(identityFeature);
					newName = nextIdentity(lastName);
				}
			}
			if (newName == null) {
				newName = "1";
			}
		}

		return newName;
	}

	public String nextIdentity(final String lastName) {
		String newName = new String();
		// See if the last 2 chars are a digit.
		try {

			final Pattern MY_PATTERN = Pattern.compile("[0-9]*");
			final Matcher m = MY_PATTERN.matcher(lastName);
			String lastDigits = null;
			while (m.find()) {
				final String match = m.group();
				if (!match.isEmpty())
					lastDigits = match;
			}
			if (lastDigits != null) {
				final String nameWithNoDigits = lastName.substring(0,
						lastName.indexOf(lastDigits));
				try {
					Integer ld = new Integer(lastDigits);
					ld++;
					// Perhaps format with 0...

					// Do a simple text format.
					final DecimalFormat format = new DecimalFormat();
					format.applyPattern("###");
					newName = nameWithNoDigits + format.format(ld);

				} catch (final NumberFormatException nfe) {
					System.err
							.println("ModelUtils: Can't formart" + lastDigits);
				}
			}
		} catch (final PatternSyntaxException pse) {
			System.err.println("ModelUtils: Wrong syntax");
		}
		return newName;
	}

	/**
	 * Iterate through the ranges, and find for this interval.
	 * 
	 * @param resource
	 * @param targetInterval
	 * @return
	 */
	public Value lastCapacityValue(NetXResource resource) {
		List<Value> values = this.sortByTimeStampAndReverse(resource
				.getCapacityValues());
		if (values.size() > 0) {
			return values.get(0);
		}
		return null;
	}

	/**
	 * Iterate through the ranges, and find for this interval.
	 * 
	 * @param resource
	 * @param targetInterval
	 * @return
	 */
	public MetricValueRange valueRangeForInterval(NetXResource resource,
			int targetInterval) {
		for (MetricValueRange mvr : resource.getMetricValueRanges()) {
			if (mvr.getIntervalHint() == targetInterval) {
				return mvr;
			}
		}
		return null;
	}

	public List<Value> valuesInRange(Iterable<Value> unfiltered,
			DateTimeRange dtr) {

		Iterable<Value> filterValues = Iterables.filter(unfiltered,
				valueInsideRange(dtr));
		return Lists.newArrayList(filterValues);
	}

	public List<Value> metricValuesInRange(NetXResource res, int intervalHint,
			KindHintType kh, DateTimeRange dtr) {

		MetricValueRange mvr;
		if (kh == null) {
			mvr = valueRangeForInterval(res, intervalHint);
		} else {
			mvr = valueRangeForIntervalAndKind(res, kh, intervalHint);
		}

		if (mvr != null) {
			Iterable<Value> filterValues = Iterables.filter(
					mvr.getMetricValues(), valueInsideRange(dtr));
			return Lists.newArrayList(filterValues);
		}
		return Lists.newArrayList();
	}

	/*
	 * Note, side effect of creating the value range if the range doesn't exist.
	 */
	public MetricValueRange valueRangeForIntervalAndKind(
			NetXResource foundNetXResource, KindHintType kindHintType,
			int periodHint) {
		MetricValueRange foundMvr = null;
		for (final MetricValueRange mvr : foundNetXResource
				.getMetricValueRanges()) {
			if (mvr.getKindHint() == kindHintType
					&& mvr.getIntervalHint() == periodHint) {
				foundMvr = mvr;
				break;
			}
		}

		if (foundMvr == null) {
			foundMvr = MetricsFactory.eINSTANCE.createMetricValueRange();
			foundMvr.setKindHint(kindHintType);
			foundMvr.setIntervalHint(periodHint);
			foundNetXResource.getMetricValueRanges().add(foundMvr);
		}
		return foundMvr;
	}

	public List<NetXResource> resourcesFromNodeTypes(List<NodeType> nodeTypes) {

		List<NetXResource> allResources = Lists.newArrayList();
		for (NodeType nt : nodeTypes) {
			TreeIterator<EObject> eAllContents = nt.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				if (next instanceof NetXResource) {
					allResources.add((NetXResource) next);
				}
			}
		}
		return allResources;
	}

	public List<NetXResource> resourcesWithExpressionNameFromNodeTypes(
			List<NodeType> nodeTypes, NetXResource resource) {

		List<NetXResource> allResources = Lists.newArrayList();
		for (NodeType nt : nodeTypes) {
			List<NetXResource> resources = resourcesWithExpressionName(nt,
					resource.getExpressionName());
			allResources.addAll(resources);
		}
		return allResources;
	}

	public void deriveValues(ServiceDistribution distribution, List<Node> nodes) {

		// Sequence of the nodes is by Leaf first, and then follow the
		// relationships.
		// Need an algo, to build a matrix of sorted nodes.

	}

	public void printMatrix(Node[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				Node n = matrix[i][j];
				if (n != null) {
					System.out.print(n.getNodeID() + ",");
				}
			}
			System.out.println("\n");
		}
	}

	public Node[][] matrix(List<Node> nodes) {

		// Node[][] emptyMatrix = new Node[0][0];

		List<NodeType> nts = this.transformNodeToNodeType(nodes);
		List<NodeType> unique = this.uniqueNodeTypes(nts);
		List<NodeType> sortedByIsLeafCopy = Ordering
				.from(this.nodeTypeIsLeafComparator()).reverse()
				.sortedCopy(unique);

		int ntCount = sortedByIsLeafCopy.size();
		int nodeDepth = 0;

		// We need a two pass, to determine the array size first.
		// Is there another trick?

		for (NodeType nt : sortedByIsLeafCopy) {
			Iterable<Node> filtered = Iterables.filter(nodes,
					this.nodeOfType(nt));
			if (Iterables.size(filtered) > nodeDepth) {
				nodeDepth = Iterables.size(filtered);
			}
		}

		Node[][] matrix = new Node[ntCount][nodeDepth];

		for (int i = 0; i < ntCount; i++) {
			NodeType nt = sortedByIsLeafCopy.get(i);
			Iterable<Node> filtered = Iterables.filter(nodes,
					this.nodeOfType(nt));
			for (int j = 0; j < Iterables.size(filtered); j++) {
				Node n = Iterables.get(filtered, j);
				matrix[i][j] = n;
			}
		}

		return matrix;
	}

	public List<Relationship> connections(RFSService service, Node n) {

		if (service.eContainer() instanceof Operator) {
			Operator op = (Operator) service.eContainer();

			List<Relationship> relationships = Lists.newArrayList();
			TreeIterator<EObject> eAllContents = op.eAllContents();
			while (eAllContents.hasNext()) {
				EObject eo = eAllContents.next();
				if (eo instanceof Relationship) {
					relationships.add((Relationship) eo);
				}
			}

			List<Relationship> filteredRelationships = Lists.newArrayList();
			Iterable<Relationship> filtered = Iterables.filter(relationships,
					this.sourceRelationshipInNode(n));
			if (Iterables.size(filtered) > 0) {
				filteredRelationships.addAll(Lists.newArrayList(filtered));
			}
			return filteredRelationships;
		}
		return null;
	};

	public List<Node> connectedNodes(RFSService service) {

		if (service.eContainer() instanceof Operator) {
			Operator op = (Operator) service.eContainer();

			List<Relationship> relationships = Lists.newArrayList();
			TreeIterator<EObject> eAllContents = op.eAllContents();
			while (eAllContents.hasNext()) {
				EObject eo = eAllContents.next();
				if (eo instanceof Relationship) {
					relationships.add((Relationship) eo);
				}
			}

			List<Relationship> filteredRelationships = Lists.newArrayList();

			for (Node n : service.getNodes()) {
				Iterable<Relationship> filtered = Iterables.filter(
						relationships, this.sourceRelationshipInNode(n));
				if (Iterables.size(filtered) > 0) {
					filteredRelationships.addAll(Lists.newArrayList(filtered));
				}
			}
		}
		return null;

	};

	/**
	 * Resources with this name. Notice: Matching is on regular expression, i.e.
	 * name = .* is all resources.
	 * 
	 * @param components
	 * @param name
	 * @return
	 */
	public List<NetXResource> resourcesWithExpressionName(
			List<Component> components, String name) {
		final List<NetXResource> rl = Lists.newArrayList();
		final List<Component> cl = Lists.newArrayList();
		for (final Component c : components) {
			for (final NetXResource r : c.getResourceRefs()) {
				if (r.getExpressionName().matches(name)) {
					rl.add(r);
				}
			}
			if (c instanceof Equipment) {
				cl.addAll(((Equipment) c).getEquipments());
			}
			if (c instanceof com.netxforge.netxstudio.library.Function) {
				cl.addAll(((com.netxforge.netxstudio.library.Function) c)
						.getFunctions());
			}
			rl.addAll(this.resourcesWithExpressionName(cl, name));
		}
		return rl;
	}

	/**
	 * Merge the time from a date into a given base date and return the result.
	 * 
	 * @param baseDate
	 * @param dateWithTime
	 * @return
	 */
	public Date mergeTimeIntoDate(Date baseDate, Date dateWithTime) {
		final Calendar baseCalendar = GregorianCalendar.getInstance();
		baseCalendar.setTime(baseDate);

		final Calendar dateWithTimeCalendar = GregorianCalendar.getInstance();
		dateWithTimeCalendar.setTime(dateWithTime);

		baseCalendar.set(Calendar.HOUR_OF_DAY,
				dateWithTimeCalendar.get(Calendar.HOUR_OF_DAY));
		baseCalendar.set(Calendar.MINUTE,
				dateWithTimeCalendar.get(Calendar.MINUTE));
		return baseCalendar.getTime();

	}

	public List<Integer> weekDaysAsInteger() {
		final List<Integer> week = ImmutableList.of(Calendar.MONDAY,
				Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY,
				Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY);
		return week;
	}

	public int weekDay(Date date) {

		final Function<Date, Integer> getDayString = new Function<Date, Integer>() {
			public Integer apply(Date from) {
				final Calendar c = GregorianCalendar.getInstance();
				c.setTime(from);
				return new Integer(c.get(Calendar.DAY_OF_WEEK));
			}
		};
		return getDayString.apply(date);
	}

	public String weekDay(Integer weekDay) {
		final Function<Integer, String> getDayString = new Function<Integer, String>() {
			public String apply(Integer from) {
				final Calendar c = GregorianCalendar.getInstance();
				c.set(Calendar.DAY_OF_WEEK, from.intValue());
				final Date date = c.getTime();
				final SimpleDateFormat df = new SimpleDateFormat("EEEE");
				return df.format(date);
			}
		};
		return getDayString.apply(weekDay);
	}

	public String date(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	public String folderDate(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	public String time(Date d) {
		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				return df.format(from);
			}
		};
		return getDateString.apply(d);
	}

	public String dateAndTime(XMLGregorianCalendar d) {
		Date date = fromXMLDate(d);
		return dateAndTime(date);
	}

	public String dateAndTime(Date d) {

		StringBuilder sb = new StringBuilder();

		final Function<Date, String> getDateString = new Function<Date, String>() {
			public String apply(Date from) {
				final SimpleDateFormat df = new SimpleDateFormat("HHmm");
				return df.format(from);
			}
		};
		sb.append(folderDate(d) + "_");
		sb.append(getDateString.apply(d));
		return sb.toString();
	}

	/**
	 * Get the days of the week, in a long textual format i.e. "Monday". The
	 * days of the week, adapts to the current Locale.
	 * 
	 * @return
	 */
	public List<String> weekDays() {
		final Function<Integer, String> getDayString = new Function<Integer, String>() {
			public String apply(Integer from) {
				final Calendar c = GregorianCalendar.getInstance();
				c.set(Calendar.DAY_OF_WEEK, from.intValue());
				final Date date = c.getTime();
				final SimpleDateFormat df = new SimpleDateFormat("EEEE");
				return df.format(date);
			}
		};

		return Lists.transform(weekDaysAsInteger(), getDayString);
	}

	public int weekDay(String day) {
		final Function<String, Integer> getDayFromString = new Function<String, Integer>() {
			public Integer apply(String from) {
				try {
					final Date d = DateFormat.getDateInstance().parse(from);
					final Calendar c = GregorianCalendar.getInstance();
					c.setTime(d);
					return c.get(Calendar.DAY_OF_WEEK);

				} catch (final ParseException e) {
					e.printStackTrace();
				}
				return -1;
			}
		};
		return getDayFromString.apply(day).intValue();
	}

	public Date mergeDateIntoTime(Date baseTime, Date targetDate) {

		final Calendar baseCalendar = GregorianCalendar.getInstance();
		baseCalendar.setTime(baseTime);

		final Calendar targetCalendar = GregorianCalendar.getInstance();
		targetCalendar.setTime(targetDate);

		// CB 06-09-2011, removed date has to be later requirement.
		// if (targetCalendar.compareTo(GregorianCalendar.getInstance()) > 0) {
		baseCalendar.set(Calendar.YEAR, targetCalendar.get(Calendar.YEAR));
		baseCalendar.set(Calendar.MONTH, targetCalendar.get(Calendar.MONTH));
		baseCalendar.set(Calendar.WEEK_OF_YEAR,
				targetCalendar.get(Calendar.WEEK_OF_YEAR));

		// We need to roll the week, if the target day
		// is after the current day in that same week
		if (targetCalendar.get(Calendar.WEEK_OF_YEAR) == baseCalendar
				.get(Calendar.WEEK_OF_YEAR)
				&& targetCalendar.get(Calendar.DAY_OF_WEEK) > baseCalendar
						.get(Calendar.DAY_OF_WEEK)) {
			baseCalendar.add(Calendar.WEEK_OF_YEAR, 1);
		}
		// baseCalendar.set(Calendar.DAY_OF_WEEK,
		// targetCalendar.get(Calendar.DAY_OF_WEEK));
		// }
		return baseCalendar.getTime();
	}

	/**
	 * Calculate a new date for a certain day of week and hour of day. If the
	 * startdate is not provided or earlier than today, the current date (today)
	 * is used.
	 * 
	 * @param baseDate
	 * @param dayOfWeek
	 * @return
	 */
	public Date mergeDayIntoDate(Date baseDate, int dayOfWeek) {

		final Calendar c = GregorianCalendar.getInstance();
		c.setTime(baseDate);
		if (dayOfWeek != -1) {
			c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		}
		return c.getTime();
	}

	public XMLGregorianCalendar toXMLDate(Date date) {
		final XMLGregorianCalendar gregCalendar = dataTypeFactory
				.newXMLGregorianCalendar();
		final Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);

		gregCalendar.setYear(calendar.get(Calendar.YEAR));
		gregCalendar.setMonth(calendar.get(Calendar.MONTH) + 1); // correct with
																	// 1 on
																	// purpose
		gregCalendar.setDay(calendar.get(Calendar.DAY_OF_MONTH));

		gregCalendar.setHour(calendar.get(Calendar.HOUR_OF_DAY));
		gregCalendar.setMinute(calendar.get(Calendar.MINUTE));
		gregCalendar.setSecond(calendar.get(Calendar.SECOND));
		gregCalendar.setMillisecond(calendar.get(Calendar.MILLISECOND));
		// gregCalendar.setTimezone(calendar.get(Calendar.ZONE_OFFSET));

		return gregCalendar;
	}

	public Date fromXMLDate(XMLGregorianCalendar date) {
		return date.toGregorianCalendar().getTime();
	}

	public int daysInJanuary(int year) {
		return daysInMonth(year, Calendar.JANUARY);
	}

	public int daysInFebruari(int year) {
		return daysInMonth(year, Calendar.FEBRUARY);
	}

	public int daysInMarch(int year) {
		return daysInMonth(year, Calendar.MARCH);
	}

	public int daysInApril(int year) {
		return daysInMonth(year, Calendar.APRIL);
	}

	// .... etc...

	public int daysInMonth(int year, int month) {
		final Calendar cal = new GregorianCalendar(year, month, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public Date lastWeek() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		return cal.getTime();
	}

	public Date yesterday() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_WEEK, -1);
		return cal.getTime();
	}

	public Date tomorrow() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_WEEK, 1);
		return cal.getTime();
	}

	public Date twoDaysAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -2);
		return cal.getTime();
	}

	public Date threeDaysAgo() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -3);
		return cal.getTime();
	}

	public Date fourDaysAgo() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_MONTH, -4);
		return cal.getTime();
	}

	public Date daysAgo(int days) {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.DAY_OF_YEAR, days);
		return cal.getTime();

	}

	public Date oneWeekAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.WEEK_OF_YEAR, -1);
		return cal.getTime();
	}

	public Date oneMonthAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}

	public Date twoMonthsAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -2);
		return cal.getTime();
	}

	public Date threeMonthsAgo() {
		final Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.add(Calendar.MONTH, -3);
		return cal.getTime();
	}

	public Date todayAndNow() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(System.currentTimeMillis()));
		return cal.getTime();
	}

	public int inSeconds(String field) {
		final Function<String, Integer> getFieldInSeconds = new Function<String, Integer>() {
			public Integer apply(String from) {
				if (from.equals("Week")) {
					return ModelUtils.SECONDS_IN_A_WEEK;
				}
				if (from.equals("Day")) {
					return ModelUtils.SECONDS_IN_A_DAY;
				}
				if (from.equals("Hour")) {
					return ModelUtils.SECONDS_IN_AN_HOUR;
				}
				if (from.equals("Quarter")) {
					return ModelUtils.SECONDS_IN_A_QUARTER;
				}
				try {
					return new Integer(from);
				} catch (final NumberFormatException nfe) {
					nfe.printStackTrace();
				}
				return -1;
			}
		};
		return getFieldInSeconds.apply(field);
	}

	public String fromMinutes(int minutes) {
		return this.fromSeconds(minutes * 60);
	}

	public String fromSeconds(int secs) {
		final Function<Integer, String> getFieldInSeconds = new Function<Integer, String>() {
			public String apply(Integer from) {

				if (from.equals(ModelUtils.SECONDS_IN_A_WEEK)) {
					return "Week";
				}
				if (from.equals(ModelUtils.SECONDS_IN_A_DAY)) {
					return "Day";
				}
				if (from.equals(ModelUtils.SECONDS_IN_AN_HOUR)) {
					return "Hour";
				}
				if (from.equals(ModelUtils.SECONDS_IN_A_QUARTER)) {
					return "Quarter";
				}
				return new Integer(from).toString();
			}
		};
		return getFieldInSeconds.apply(secs);
	}

	public int inWeeks(String field) {
		final Function<String, Integer> getFieldInSeconds = new Function<String, Integer>() {
			public Integer apply(String from) {
				if (from.equals("Week")) {
					return 1;
				}
				return null;
			}
		};
		return getFieldInSeconds.apply(field);
	}

	public String toString(Date date) {
		return DateFormat.getDateInstance().format(date);
	}

	/**
	 * limits occurences to 52.
	 * 
	 * @param start
	 * @param end
	 * @param interval
	 * @param repeat
	 * @return
	 */
	public List<Date> occurences(Date start, Date end, int interval, int repeat) {
		return this.occurences(start, end, interval, repeat, 52);
	}

	public List<Date> occurences(Date start, Date end, int interval,
			int repeat, int maxEntries) {

		final List<Date> occurences = Lists.newArrayList();
		Date occurenceDate = start;
		occurences.add(start);

		if (repeat > 0 && interval > 1) {
			// We roll on the interval from the start date until repeat is
			// reached.
			for (int i = 0; i < repeat; i++) {
				occurenceDate = rollSeconds(occurenceDate, interval);
				occurences.add(occurenceDate);
			}
			return occurences;
		}
		if (end != null && interval > 1) {
			// We roll on the interval from the start date until the end date.
			int i = 0;
			while (i < maxEntries) {
				occurenceDate = rollSeconds(occurenceDate, interval);
				if (!crossedDate(end, occurenceDate)) {
					occurences.add(occurenceDate);
				} else {
					break;
				}
				i++;
			}
			return occurences;
		}
		if (repeat == 0 && interval > 1) {
			int i = 0;
			while (i < maxEntries) {
				occurenceDate = rollSeconds(occurenceDate, interval);
				occurences.add(occurenceDate);
				i++;
			}
			return occurences;
		}

		return occurences;
	}

	public Date rollSeconds(Date baseDate, int seconds) {
		final Calendar c = GregorianCalendar.getInstance();
		c.setTime(baseDate);

		// We can't roll large numbers.
		if (seconds / SECONDS_IN_A_DAY > 0) {
			final int days = new Double(seconds / SECONDS_IN_A_DAY).intValue();
			c.add(Calendar.DAY_OF_YEAR, days);
			return c.getTime();
		}
		if (seconds / SECONDS_IN_AN_HOUR > 0) {
			final int hours = new Double(seconds / SECONDS_IN_AN_HOUR)
					.intValue();
			c.add(Calendar.HOUR_OF_DAY, hours);
			return c.getTime();
		}

		if (seconds / SECONDS_IN_A_MINUTE > 0) {
			final int minutes = new Double(seconds / SECONDS_IN_A_MINUTE)
					.intValue();
			c.add(Calendar.MINUTE, minutes);
			return c.getTime();
		}

		c.add(Calendar.SECOND, seconds);
		return c.getTime();

	}

	public boolean crossedDate(Date refDate, Date variantDate) {
		final Calendar refCal = GregorianCalendar.getInstance();
		refCal.setTime(refDate);

		final Calendar variantCal = GregorianCalendar.getInstance();
		variantCal.setTime(variantDate);

		return refCal.compareTo(variantCal) < 0;

	}

	/**
	 * Casts to AbstractCDOIDLong and returns the long as value.
	 * 
	 * @param cdoObject
	 * @return
	 */
	public String cdoLongIDAsString(CDOObject cdoObject) {
		long lValue = ((AbstractCDOIDLong) cdoObject.cdoID()).getLongValue();
		return new Long(lValue).toString();
	}

	/**
	 * Transform a list of resources to a list of URI for the resource.
	 * 
	 * @param resources
	 * @return
	 */
	public List<URI> transformResourceToURI(List<Resource> resources) {
		final Function<Resource, URI> resourceToURI = new Function<Resource, URI>() {
			public URI apply(Resource from) {
				return from.getURI();
			}
		};
		return Lists.transform(resources, resourceToURI);
	}

	public List<NodeType> transformNodeToNodeType(List<Node> nodes) {
		final Function<Node, NodeType> nodeTypeFromNode = new Function<Node, NodeType>() {
			public NodeType apply(Node from) {
				return from.getNodeType();
			}
		};
		return Lists.transform(nodes, nodeTypeFromNode);
	}

	/**
	 * Transform a list of Value object, to only the value part of the Value
	 * Object.
	 * 
	 * @param values
	 * @return
	 */
	public List<BigDecimal> transformValueToBigDecimal(List<Value> values) {
		final Function<Value, BigDecimal> valueToBigDecimal = new Function<Value, BigDecimal>() {
			public BigDecimal apply(Value from) {
				return new BigDecimal(from.getValue());
			}
		};
		return Lists.transform(values, valueToBigDecimal);
	}

	public List<Double> transformBigDecimalToDouble(List<BigDecimal> values) {
		final Function<BigDecimal, Double> valueToBigDecimal = new Function<BigDecimal, Double>() {
			public Double apply(BigDecimal from) {
				return from.doubleValue();
			}
		};
		return Lists.transform(values, valueToBigDecimal);
	}

	public double[] transformValueToDoubleArray(List<Value> values) {
		final Function<Value, Double> valueToDouble = new Function<Value, Double>() {
			public Double apply(Value from) {
				return from.getValue();
			}
		};
		List<Double> doubles = Lists.transform(values, valueToDouble);
		double[] doubleArray = new double[doubles.size()];
		for (int i = 0; i < doubles.size(); i++) {
			doubleArray[i] = doubles.get(i).doubleValue();
		}
		return doubleArray;
	}

	public List<Double> transformValueToDouble(List<Value> values) {
		final Function<Value, Double> valueToDouble = new Function<Value, Double>() {
			public Double apply(Value from) {
				return from.getValue();
			}
		};
		return Lists.transform(values, valueToDouble);
	}

	public List<Date> transformValueToDate(List<Value> values) {
		final Function<Value, Date> valueToDouble = new Function<Value, Date>() {
			public Date apply(Value from) {
				return fromXMLDate(from.getTimeStamp());
			}
		};
		return Lists.transform(values, valueToDouble);
	}

	/**
	 * FIXME, No other way that iterator through.
	 * 
	 * @param values
	 * @return
	 */
	public double[] transformToDoublePrimitiveArray(List<Double> values) {
		final double[] doubles = new double[values.size()];
		int i = 0;
		for (final Double d : values) {
			doubles[i] = d.doubleValue();
			i++;
		}
		return doubles;
	}

	/**
	 * look down the containment tree, and find the most recenrt date.
	 * 
	 * @param object
	 * @return
	 */
	public long mostRecentContainedDated(CDOObject object) {

		long ts = object.cdoRevision().getTimeStamp();

		TreeIterator<EObject> eAllContents = object.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eo = eAllContents.next();
			if (eo.eContainer() != null) {
				// We are contained, so we might have been updated.
				if (eo instanceof CDOObject) {
					long leafTS = ((CDOObject) eo).cdoRevision().getTimeStamp();
					if (leafTS > ts) {
						ts = leafTS;
					}
				}

			}
		}
		return ts;
	}

	public List<NodeType> allNodeTypes(Resource operatorsResource) {
		final List<NodeType> nodeTypes = new ArrayList<NodeType>();
		for (EObject eo : operatorsResource.getContents()) {
			if (eo instanceof Operator) {
				Operator op = (Operator) eo;
				for (Service service : op.getServices()) {
					nodeTypes.addAll(nodesForService(service));
				}
			}
		}
		return nodeTypes;
	}

	public List<NodeType> nodesForService(Service service) {
		final List<NodeType> nodeTypes = new ArrayList<NodeType>();
		if (service instanceof RFSService) {
			for (Node n : ((RFSService) service).getNodes()) {
				nodeTypes.add(n.getNodeType());
			}
			for (Service subService : service.getServices()) {
				nodeTypes.addAll(nodesForService(subService));
			}
		}
		return nodeTypes;
	}

}

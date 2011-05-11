package com.netxforge.netxstudio.emf.poi;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.netxforge.netxstudio.emf.poi.mappings.XLSMapping;
import com.netxforge.netxstudio.emf.teneo.TeneoService;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.operators.Node;

public class PoiCopyService {

	public static final PoiCopyService INSTANCE = new PoiCopyService();

	
	public void go(IProgressMonitor monitor, List<Tuple> records,
			XLSMapping mapping, MetricSource metricSource) {

		// Let's make sure we have a session.
		Session session = TeneoService.getInstance().getSession();
		this.go(monitor, session, records, mapping, metricSource);
		session.close();
	}
	
	
	/**
	 * tuple input, which would require the mapping for interpretation:
	 * <ul>
	 * <li>key => <code>List&lt;{@link Tuple}&gt;</code></li>
	 * <li>value ={@link Tuple}</li>
	 * </ul>
	 * The first Tuple, is the name of the metric and the value (Timestamp +
	 * actual value).
	 * <ul>
	 * <li>key => String</code></li>
	 * <li>value ={@link Value}</li>
	 * </ul>
	 * </p>
	 * 
	 * The second tuple is an object and string representing the ID. The object
	 * can be a special class. {@link XLSMapping}
	 * <ul>
	 * <li>key => {@link Object}</code></li>
	 * <li>value ={@link String}</li>
	 * </ul>
	 * </p>
	 * 
	 * @param monitor
	 * @param records
	 */
	@SuppressWarnings("unchecked")
	public void go(IProgressMonitor monitor, Session session, List<Tuple> records,
			XLSMapping mapping, MetricSource metricSource) {

		Transaction tx = session.beginTransaction();
		EObject currentRefObject = null;

		// Loop trough our records.
		for (Tuple tuple : records) {

			Object key = tuple.getKey();
			List<Tuple> ids = null;
			if (key instanceof List<?>) {
				ids = (List<Tuple>) key;
			} else {
				// fatal branch, our key should be ids.
			}

			Object value = tuple.getValue();
			if (value instanceof Tuple) {

				String valueKey = (String) ((Tuple) value).getKey();
				Value v = (Value) ((Tuple) value).getValue();

//				System.out.println(" Metric (" + valueKey + ") value:"
//						+ v.getValue() + " at: " + v.getTimeStamp().toString());

				// 1. Now get the relevant metrics from these guys.
				// Look for metric types.
				monitor.subTask("Identifying:");

				EObject refObject = this.resolveMetricContainer(session,
						metricSource, ids);
				if(refObject == null){
					System.out.println("Identifiers not found for: " + ids.toString());
					continue;
				}
				if (!refObject.equals(currentRefObject)) {
					currentRefObject = refObject;
				}

				// 2. add the value to the resource, (create a new one if
				// needed).
				EList<NetXResource> resources = null;
				if (currentRefObject instanceof Function) {
					resources = ((Function) currentRefObject)
							.getFunctionResources();
				}
				if (currentRefObject instanceof Equipment) {
					resources = ((Equipment) currentRefObject)
							.getEquipmentResources();
				}

				if (resources == null) {
					break; // Next record.
				}

				// TODO, use a DB query?
				NetXResource targetResource = null;
				for (NetXResource r : resources) {
					if (r.getShortName() != null && r.getShortName().equals(valueKey)) {
						targetResource = r;
					}
				}

				if (targetResource == null) {
					targetResource = LibraryFactory.eINSTANCE
							.createNetXResource();
					// Populate our new resource. 
					targetResource.setShortName(valueKey);
					resources.add(targetResource);
				}

				// TODO, find duplicates in the range, before updating,
				// or define some sort of
				// Strategy.
				monitor.subTask("Loading: " + value.toString());
				
				// As we have multiple ranges, we here simply take the first one, 
				// but this will depend on the interval attribute of the MetricSource
				targetResource.getMetricValueRanges().get(0).getMetricValues().add(v);
				// TODO Is the resource and value also saved?
				session.save(refObject);
			}
			// TODO, keep statistics of the loading.
			monitor.worked(1);
		}
		try{
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}

	}

	/**
	 * Pass through the referenced Metric object in the metric source and match
	 * on a list of ID's in the mapping format.
	 * 
	 * 
	 * @param session
	 * @param metricSource
	 * @param ids
	 * @return
	 */
	public EObject resolveMetricContainer(Session session,
			MetricSource metricSource, List<Tuple> ids) {

		Object[] allMetricRefs = null;

		EList<Metric> metrics = metricSource.getMetricRefs();
		if (metrics != null && metrics.size() > 0) {
			Metric m = metrics.get(0);

			allMetricRefs = TeneoService.getInstance().getDataStore()
					.getCrossReferencers(session, m);
			// BUG, doesn't work with Teneo objects!
			// Collection<Setting> referenced = EcoreUtil.UsageCrossReferencer
			// .find(m, targetNode);

		}

		if (allMetricRefs == null)
			return null;

		// Find the single object which corresponds to our ids, all should
		// match.
		// reduce our set which processing ID's.
		List<Object> allMetricRefList = Arrays.asList(allMetricRefs);

		int matchingIDs = 0;

		for (Object reference : allMetricRefList) {
			Node n = null;
			if (reference instanceof Function || reference instanceof Equipment) {
				EObject refObject = (EObject) reference;

				for (Tuple object : ids) {
					Tuple idTuple = (Tuple) object;

					Object type = idTuple.getKey();
					String ID = (String) idTuple.getValue();

					if (type instanceof XLSMapping.IEMFDestDescriptor) {
						XLSMapping.IEMFDestDescriptor descriptor = (XLSMapping.IEMFDestDescriptor) type;

						Object modelType = descriptor.getType();
						int featureID = descriptor.getFeatureID();
						if (modelType == Node.class) {
							n = resolveNode(refObject);
							if (n != null) {
								EStructuralFeature feature = n.eClass()
										.getEStructuralFeature(featureID);
								Object featureValue = null;
								if (feature != null) {
									featureValue = n.eGet(feature);
								}
								if (featureValue instanceof String
										&& ((featureValue)).equals(ID)) {
									matchingIDs += 1;
								}
							}
							continue;
						}
						// Check other ID's for this metric.
						if (n != null) {
							if (modelType == Function.class) {
								EStructuralFeature feature = refObject.eClass()
										.getEStructuralFeature(featureID);
								Object featureValue = null;
								if (feature != null) {
									featureValue = refObject.eGet(feature);
								}

								// Use some reflection to find the matching
								// attribute.
								// TODO, apply the mapping pattern!
								if (featureValue instanceof String
										&& ((featureValue)).equals(ID)) {
									matchingIDs += 1;
								}
							}
							continue;
						}
					}
				}

				if (matchingIDs == ids.size()) {
					// Found it, all ID's match.
					return refObject;
				}
			}
		}

		return null;
	}

	public Node resolveNode(EObject target) {
		EObject container = target.eContainer();
		if (container == null)
			return null;
		if (container instanceof Node) {
			return (Node) container;
		} else {
			return resolveNode(container);
		}
	}

	/**
	 * 
	 * @param ids
	 * @return
	 * @throws IllegalAccessException
	 */
//	public EObject resolveObject(Session session, Tuple... ids)
//			throws IllegalAccessException {
//
//		EObject result = null;
//
//		for (Tuple object : ids) {
//			Tuple idTuple = (Tuple) object;
//			String ID = (String) idTuple.getValue();
//
//			Object type = idTuple.getKey();
//			if (type instanceof XLSMapping.IEMFDestDescriptor) {
//				XLSMapping.IEMFDestDescriptor descriptor = (XLSMapping.IEMFDestDescriptor) type;
//
//				Object modelType = descriptor.getType();
//				int featureID = descriptor.getFeatureID();
//
//				// TODO, we need something more reflective to get our object.
//				// NetworksPackage.Literals.NODE__NODE_ID;
//				if (modelType == Node.class) {
//					if (featureID == OperatorsPackage.NODE__NODE_ID) {
//						result = TeneoModel.getNode(ID, session);
//						continue;
//					}
//				}
//				if (modelType == Equipment.class) {
//					if (featureID == LibraryPackage.EQUIPMENT__POSITION) {
//						result = TeneoModel.getNode(ID, session);
//					}
//				}
//
//			} else {
//				// we should really only deal with IEMFDestDescriptor
//				throw new java.lang.IllegalAccessException();
//			}
//		}
//		return result;
//	}

	/**
	 * 
	 * @param ids
	 * @return
	 * @throws IllegalAccessException
	 */
//	public EObject resolveObject(Resource res, Tuple... ids)
//			throws IllegalAccessException {
//
//		EObject result = null;
//
//		for (Tuple object : ids) {
//			Tuple idTuple = (Tuple) object;
//			String ID = (String) idTuple.getValue();
//
//			Object type = idTuple.getKey();
//			if (type instanceof XLSMapping.IEMFDestDescriptor) {
//				XLSMapping.IEMFDestDescriptor descriptor = (XLSMapping.IEMFDestDescriptor) type;
//
//				Object modelType = descriptor.getType();
//				int featureID = descriptor.getFeatureID();
//
//				if (modelType == Node.class) {
//					if (featureID == OperatorsPackage.NODE__NODE_ID) {
//
//						// TODO, we need something more reflective to get our
//						// object.
//						// NetworksPackage.Literals.NODE__NODE_ID;
//						Library lib = (Library) res.getContents().get(0);
//						Network net = (Network) lib.getNetworks().get(0);
//						for (Node node : net.getNodes()) {
//							if (node.getNodeID().equals(ID)) {
//								result = node;
//							}
//						}
//						continue;
//					}
//				}
//				if (modelType == Equipment.class) {
//					if (featureID == LibraryPackage.EQUIPMENT__POSITION) {
//						// TODO based on resource, implement.
//					}
//				}
//
//			} else {
//				// we should really only deal with IEMFDestDescriptor
//				throw new java.lang.IllegalAccessException();
//			}
//		}
//		return result;
//	}

}

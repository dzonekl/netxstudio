package com.netxforge.netxstudio.models.importer.ui;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.Site;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceUser;

/**
 * A tree content provider, which creates a root object of type EClass and
 * places items under it having this EClass.
 * 
 * @author dzonekl
 * 
 */
public class ImportResultTreeContentProvider implements ITreeContentProvider {

	List<EObject> originalList;

	public void dispose() {
		// Do nothing.
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Do nothing.
	}

	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof List<?>) {
			this.originalList = (List<EObject>) inputElement;
			List<EClass> uniqueClasses = Lists.newArrayList();
			// Convert to an object array containing the EClass of the
			// Objects.
			for (EObject o : originalList) {
				EClass eClass = o.eClass();
				if (!uniqueClasses.contains(eClass)) {
					uniqueClasses.add(eClass);
				}
			}
			return uniqueClasses.toArray();
		}
		return null;
	}

	public Object[] getChildren(Object parentElement) {
		return childrenEObjects(parentElement);
	}

	public Object getParent(Object element) {
		return null; // Not required.
	}

	public boolean hasChildren(Object element) {
		return this.childrenEObjects(element).length > 0;
	}

	private Object[] childrenEObjects(Object parentElement) {
		List<EObject> children = Lists.newArrayList();
		if (parentElement instanceof EClass) {
			for (EObject o : originalList) {
				if (o.eClass().equals(parentElement)) {
					children.add(o);
				}
			}
		} else if (parentElement instanceof Service) {
			children.addAll(((Service) parentElement).getServices());
		} else if (parentElement instanceof ServiceUser) {
			if (((ServiceUser) parentElement).getServiceProfile() != null) {
				children.add(((ServiceUser) parentElement)
						.getServiceProfile());
			}
		} else if (parentElement instanceof Country) {
			children.addAll(((Country) parentElement).getSites());
		} else if (parentElement instanceof Site) {
			children.addAll(((Site) parentElement).getRooms());
		} else if (parentElement instanceof Operator) {
			children.addAll(((Operator) parentElement).getNetworks());
			children.addAll(((Operator) parentElement).getServices());
			children.addAll(((Operator) parentElement).getServiceUsers());
			children.addAll(((Operator) parentElement).getWarehouses());
		} else if (parentElement instanceof Network) {
			children.addAll(((Network) parentElement).getNetworks());
			children.addAll(((Network) parentElement).getNodes());
			children.addAll(((Network) parentElement)
					.getEquipmentRelationships());
			children.addAll(((Network) parentElement)
					.getFunctionRelationships());
		} else if (parentElement instanceof Node) {
			NodeType nodeType = ((Node) parentElement).getNodeType();
			if (nodeType != null) {
				children.add(nodeType);
			}
		} else if (parentElement instanceof NetXResource) {
			NetXResource res = (NetXResource) parentElement;
			children.addAll(res.getMetricValueRanges());
		} else if ( parentElement instanceof MetricValueRange) {
			children.addAll(((MetricValueRange) parentElement).getMetricValues());
		}else if (parentElement instanceof NodeType) {
			children.addAll(((NodeType) parentElement).getFunctions());
			children.addAll(((NodeType) parentElement).getEquipments());
		} else if (parentElement instanceof Function) {
			children.addAll(((Function) parentElement).getFunctions());
		} else if (parentElement instanceof Equipment) {
			children.addAll(((Equipment) parentElement).getEquipments());
		} else if (parentElement instanceof Component) {
			children.addAll(((Component) parentElement).getResourceRefs());
		} else if (parentElement instanceof MetricSource) {

			Mapping metricMapping = ((MetricSource) parentElement)
					.getMetricMapping();
			if (metricMapping != null) {
				children.add(metricMapping);
			}
		} else if (parentElement instanceof Mapping) {
			children.addAll(((Mapping) parentElement)
					.getHeaderMappingColumns());
			children.addAll(((Mapping) parentElement)
					.getDataMappingColumns());
		} else if (parentElement instanceof MappingColumn) {

			DataKind dataType = ((MappingColumn) parentElement)
					.getDataType();
			if (dataType != null) {
				children.add(dataType);
			}

		}

		return children.toArray();
	}
}
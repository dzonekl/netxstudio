package com.netxforge.netxstudio.screens.f4.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;

import com.netxforge.netxstudio.metrics.Metric;

public class MetricTreeStructureAdvisor extends TreeStructureAdvisor {
	@Override
	public Object getParent(Object element) {
		if (element instanceof Metric) {
			// return ((Metric) element).ggetParent();
			// Parent?
			EObject container = ((Metric) element).eContainer();
			if (container != null && container instanceof Metric) {
				return container;
			}
		}
		return null;
	}

	@Override
	public Boolean hasChildren(Object element) {
		if (element instanceof Metric
				&& (((Metric) element).getMetrics().size() > 0)) {
			return Boolean.TRUE;
		}
		return super.hasChildren(element);
	}
}
package com.netxforge.netxstudio.screens.f4.support;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;

public class MetricTreeFactory implements IObservableFactory {
	private IEMFListProperty singleList = EMFProperties
			.list(MetricsPackage.Literals.METRIC_SOURCE__METRIC_REFS);

	public IObservable createObservable(final Object target) {
		if (target instanceof IObservableList) {
			return (IObservable) target;
		} else if (target instanceof Metric) {
			return singleList.observe(target);
		}
		return null;
	}
}
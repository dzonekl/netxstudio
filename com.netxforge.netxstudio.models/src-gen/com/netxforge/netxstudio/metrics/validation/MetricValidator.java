/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.netxforge.netxstudio.metrics.validation;

import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.netxforge.netxstudio.metrics.Metric}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MetricValidator {
	boolean validate();

	boolean validateMetrics(EList<Metric> value);
	boolean validateDescription(String value);
	boolean validateMeasurementKind(String value);
	boolean validateMeasurementPoint(String value);
	boolean validateMetricCalculation(String value);
	boolean validateMetricSourceRef(MetricSource value);
	boolean validateName(String value);
	boolean validateUnitRef(String value);
}

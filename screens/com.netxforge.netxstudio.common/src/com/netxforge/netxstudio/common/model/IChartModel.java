/*******************************************************************************
 * Copyright (c) 24 aug. 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.common.model;

import java.util.Collection;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * Defines a model for retrieving what is needed from one or more
 * {@link NetXResource resource}. The model can be used in several ways.
 * 
 * 
 * CB FIXME CHeck if applicable: Implementors should implement the
 * <code>has...</code> methods to match what is set on the model. The method
 * {@link IChartModel#isChartModelOk()} should return if the model is in such a
 * state that it can be used.
 * 
 * 
 * @author Christophe Bouhier
 */
public interface IChartModel {

	/**
	 * Add a {@link IChartResource} to the {@link IChartModel}. The first added
	 * {@link IChartResource} provides the initial information required for the
	 * chart. </br>This is the Charts
	 * {@link MetricsPackage#METRIC_VALUE_RANGE__KIND_HINT}
	 * {@link MetricsPackage#METRIC_VALUE_RANGE__INTERVAL_HINT}
	 * 
	 * </br> From subsequently added {@link IChartResource}, the matching
	 * {@link MetricsPackage#METRIC_VALUE_RANGE} is obtained (If it exists).
	 * 
	 * @param chartResource
	 */
	public abstract void addChartResource(NetxresourceSummary monitoringSummary);

	/**
	 * Remove a {@link IChartResource} from the {@link IChartModel}.
	 * 
	 * @param chartResource
	 */
	public abstract void removeChartResource(IChartResource chartResource);

	/**
	 * Get a collection of {@link IChartResource} currently in the model.
	 */
	public abstract Collection<IChartResource> getChartResources();

	/**
	 * Get the first {@link IChartResource} currently in the model.
	 */
	public abstract IChartResource getFirstChartResource();

	/**
	 * Get the non filtered {@link IChartResource} objects which do not have the
	 * filtered flag enabled.
	 * 
	 * @return
	 */
	public abstract Collection<IChartResource> getChartNonFilteredResources();

	/**
	 * Clear the {@link IChartResource} objects from the {@link IChartModel}.
	 */
	public abstract void clear();

	/**
	 * Set the {@link IChartModel} applicable period. The period can be
	 * retrieved from an {@link IMonitoringSummary#getPeriod()} context. When
	 * adding an {@link IChartResource}, implementers can potentially set the
	 * period.
	 * 
	 * @param period
	 */
	public abstract void setPeriod(DateTimeRange period);

	/**
	 * Get the {@link IChartModel }'s applicable period. The period is used to
	 * set the
	 * 
	 * @return
	 */
	public abstract DateTimeRange getPeriod();

	/**
	 * Get the {@link MetricValueRange#getIntervalHint() interval} , which
	 * applies for all {@link IChartResource} in the IChartModel.
	 * 
	 * @return
	 */
	public abstract int getInterval();

	/**
	 * Set the {@link MetricValueRange} interval. Implementors consider if the
	 * the first {@link IChartResource} has a range with this interval.
	 * 
	 * @param interval
	 */
	public abstract void setInterval(int interval);

	/**
	 * Get the {@link MetricValueRange#getKindHint() kind}, which applies for
	 * all {@link IChartResource} in the IChartModel.
	 * 
	 * @return
	 */
	public abstract KindHintType getKindHint();

	/**
	 * Set the {@link MetricValueRange#setKindHint(KindHintType) }. Implementors
	 * consider if the the first {@link IChartResource} has a range with this
	 * kind.
	 * 
	 * @param kind
	 */
	public abstract void setKindHint(KindHintType kind);

	/**
	 * The name of the charted objects (Usually {@link NetXResource} ),
	 * presented in a concatinated format.
	 * 
	 * @return
	 */
	public abstract String getChartText();

	/**
	 * Set if the charts should be {@link IChartModel#sum() summed}.
	 * 
	 * @param shouldSum
	 */
	public abstract void setShouldSum(boolean shouldSum);

	/**
	 * get if the charts should be {@link IChartModel#sum() summed}
	 * 
	 * @return
	 */
	public abstract boolean shouldSum();

	/**
	 * Set if the charts should be trended.
	 * 
	 * @param checked
	 */
	public abstract void setShouldTrend(boolean checked);

	/**
	 * get if the charts should be trended. {@link IChartResource#trend() trend}
	 * 
	 * @return
	 */
	public abstract boolean shouldTrend();

	/**
	 * Sum the {@link LibraryPackage#NET_XRESOURCE__METRIC_VALUE_RANGES value
	 * range}
	 * 
	 * @return
	 */
	public abstract double[] sum();

	/**
	 * reset the model, by reseting the {@link IChartResource} caches..
	 */
	public abstract void reset();

}
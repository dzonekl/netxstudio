/*******************************************************************************
 * Copyright (c) 26 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;

import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;

public class MetricSourceObservableMapLabelProvider extends
		ObservableMapLabelProvider {

	public MetricSourceObservableMapLabelProvider(IObservableMap[] attributeMaps) {
		super(attributeMaps);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		if (element instanceof MetricSource) {

			MetricSource ms = (MetricSource) element;
			switch (columnIndex) {
			case 0: {
				return ms.getName();
			}
			case 1: {
				return ms.getMetricLocation();
			}
			case 2: {
				if (ms.eIsSet(MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING)) {
					Mapping metricMapping = ms.getMetricMapping();
					if (metricMapping instanceof MappingCSV) {
						return "CSV";
					} else if (metricMapping instanceof MappingXLS) {
						return "XLS";
					}
					if (metricMapping instanceof MappingRDBMS) {
						return "RDBMS";
					}
				}
			}
			case 3: {
				if (ms.eIsSet(MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING)) {
					Mapping metricMapping = ms.getMetricMapping();
					if (metricMapping instanceof MappingCSV) {
						return ((MappingCSV) metricMapping).getFilterPattern();
					} else if (metricMapping instanceof MappingXLS) {
						return ((MappingXLS) metricMapping).getFilterPattern();
					}
					if (metricMapping instanceof MappingRDBMS) {
						return ((MappingRDBMS) metricMapping).getQuery();
					}
				}
			}
			}

		}
		return super.getColumnText(element, columnIndex);
	}

}
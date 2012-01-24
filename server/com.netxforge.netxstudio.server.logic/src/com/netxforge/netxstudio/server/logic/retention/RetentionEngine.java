/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.logic.retention;

import java.util.Date;
import java.util.List;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.monitoring.BaseComponentEngine;

/**
 * Performs the retention action for a component.
 * 
 * @author Martin Taal
 */
public class RetentionEngine extends BaseComponentEngine {

	private MetricRetentionRules rules;

	@Override
	public void doExecute() {
		// Run for each resource, each retention rule. 
		for (final NetXResource netXResource : getComponent().getResourceRefs()) {

			for (MetricRetentionRule rule : rules.getMetricRetentionRules()) {

				Expression expression = rule.getRetentionExpression();
				DateTimeRange dtr = null;
				switch (rule.getPeriod().getValue()) {
				case MetricRetentionPeriod.ALWAYS_VALUE: {
				}
					break;
				case MetricRetentionPeriod.ONE_MONTH_VALUE: {
					dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
					dtr.setBegin(this.getModelUtils().toXMLDate(this.getModelUtils().oneWeekAgo()));
					dtr.setEnd(this.getModelUtils().toXMLDate(this.getModelUtils().todayAndNow()));
				}
					break;
				case MetricRetentionPeriod.ONE_WEEK_VALUE: {
				}
				dtr = GenericsFactory.eINSTANCE.createDateTimeRange();
				dtr.setBegin(this.getModelUtils().toXMLDate(this.getModelUtils().oneMonthAgo()));
				dtr.setEnd(this.getModelUtils().toXMLDate(this.getModelUtils().todayAndNow()));

				break;

				}
				
				if(dtr != null && expression != null){
					getExpressionEngine().getContext().clear();
					getExpressionEngine().getContext().add(getPeriod());
					getExpressionEngine().getContext().add(this.getModelUtils().nodeFor(getComponent()));
					getExpressionEngine().getContext().add(netXResource);

					runForExpression(expression);
				}
			}

			

		}
	}

	@Override
	public Failure getFailure() {
		ComponentFailure f = SchedulingFactory.eINSTANCE
				.createComponentFailure();
		f.setComponentRef(this.getComponent());
		return f;
	}

	@Override
	protected void processResult(List<Object> currentContext,
			List<BaseExpressionResult> expressionResults, Date start, Date end) {

		// Note: For retention expressions, the order for which the expression
		// result is processed,
		// is relevant, as data is deleted after a while.

		this.getCommonLogic().processMonitoringResult(currentContext,
				expressionResults, start, end);

	}
	
	public void setRetentionRules(MetricRetentionRules rules){
		this.rules = rules;
	}
	

}

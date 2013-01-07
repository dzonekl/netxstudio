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

import java.util.List;

import com.google.common.collect.Ordering;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;
import com.netxforge.netxstudio.server.logic.monitoring.BaseComponentEngine;

/**
 * Performs the retention action for a component.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class RetentionEngine extends BaseComponentEngine {

	private MetricRetentionRules rules;
	
	/** 
	 * The number of years to consider in the aggregation and retention of values.
	 * It could be requested to i.e. keep one month of data evaluation a period of n years.   
	 */
	private static final int YEARS_TO_EVALUATE = 2;

	@Inject
	private ResultProcessor resultProcessor;

	@Override
	public void doExecute() {

		// Run for each resource, each retention rule.
		for (final NetXResource netXResource : getComponent().getResourceRefs()) {

			// Rules should execute considering the order of the smallest
			// interval first,
			// as to allow aggregation.
			
			
			//  Order the rules by smallest interval. 
			List<MetricRetentionRule> sortedCopy = Ordering.from(getModelUtils().retentionRuleCompare()).reverse().sortedCopy(rules.getMetricRetentionRules());
			
			if (LogicActivator.DEBUG) {
				LogicActivator.TRACE.trace(LogicActivator.TRACE_RETENTION_OPTION, "Processing retention rule in order: ");
				for(MetricRetentionRule rule: sortedCopy){
					StringBuilder sb = new StringBuilder(); 
					sb.append(rule.getName() + " "); 
					sb.append(rule.getIntervalHint() + " ");
					sb.append(rule.getPeriod() + " "); 
					sb.append(rule.getRetentionExpression() + " ");
					LogicActivator.TRACE.trace(LogicActivator.TRACE_RETENTION_OPTION, sb.toString()); 
				}
			}
			
			
			for (MetricRetentionRule rule : sortedCopy) {

				Expression expression = rule.getRetentionExpression();
				
				
				// If DTR is null, we keep all values.
				DateTimeRange dtr = this.getModelUtils()
						.getDTRForRetentionRule(rule, YEARS_TO_EVALUATE);
				
				this.setPeriod(dtr);
				
				if (expression != null) {
					
					// Data will be aggregated for the period specified by the logic period. 
					// For clearing data however, we need to set the MetricRetentionRule in the Interpreter.
					
					getExpressionEngine().getContext().clear();
					
					getExpressionEngine().getContext().add(getPeriod());
					getExpressionEngine().getContext().add(
							this.getModelUtils().nodeFor(getComponent()));
					getExpressionEngine().getContext().add(netXResource);
					getExpressionEngine().getContext().add(rule);

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
			List<BaseExpressionResult> expressionResults, DateTimeRange period) {

		// Note: For retention expressions, the order for which the expression
		// result is processed,
		// is relevant, as data is deleted after a while.

		resultProcessor.processMonitoringResult(currentContext,
				expressionResults, period);

	}

	public void setRetentionRules(MetricRetentionRules rules) {
		this.rules = rules;
	}

}

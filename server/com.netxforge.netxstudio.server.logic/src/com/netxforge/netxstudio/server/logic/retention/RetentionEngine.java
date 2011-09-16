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

import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.NetXResource;
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

	@Override
	public void doExecute() {
		// nothing todo, go away
		if (getComponent().getRetentionExpressionRef() == null) {
			return;
		}

		getExpressionEngine().getContext().add(getPeriod());
		getExpressionEngine().getContext().add(
				getCommonLogic().getNode(getComponent()));

		for (final NetXResource netXResource : getComponent().getResourceRefs()) {
			// remove the last entry
			if (getExpressionEngine().getContext().get(
					getExpressionEngine().getContext().size() - 1) instanceof NetXResource) {
				getExpressionEngine().getContext().remove(
						getExpressionEngine().getContext().size() - 1);
			}
			getExpressionEngine().getContext().add(netXResource);
			runForExpression(getComponent().getRetentionExpressionRef());
			if (getFailures().size() > 0) {
				return;
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
		this.getCommonLogic().processMonitoringResult(currentContext,
				expressionResults, start, end);

	}

}

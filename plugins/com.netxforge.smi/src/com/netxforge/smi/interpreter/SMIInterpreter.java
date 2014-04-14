/*******************************************************************************
 * Copyright (c) 10 apr. 2014 NetXForge.
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
package com.netxforge.smi.interpreter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.netxforge.base.IPrettyLog;
import com.netxforge.base.context.IComputationContext;
import com.netxforge.base.context.IExternalContextAware;
import com.netxforge.smi.SmiPackage;

/**
 * An interpreter for instances of EClasses of the {@link SmiPackage}.
 * 
 * It internally uses a polymorphic dispatcher to dispatch between the
 * implementations for the different EClasses.
 * 
 * @author Christophe Bouhier - An implementation for the SMI Language
 */
public class SMIInterpreter implements IExternalContextAware {

	IPrettyLog pLog;

	private PrintingPolymorphicDispatcher<BigDecimal> dispatcher = PrintingPolymorphicDispatcher
			.createForSingleTarget("internalEvaluate", 2, 2, this);

	/*
	 * Construct without a root object constraint.
	 */
	@Inject
	public SMIInterpreter(IPrettyLog pLog) {
		this.pLog = pLog;
		dispatcher.setPrettyLog(pLog);
	}

	/*
	 * The first Context always corresponds to 'this' in the grammar. Additional
	 * context, contain the period range for an expression.
	 */
	private List<IComputationContext> contextList = Lists.newArrayList();

	/*
	 * An index of all context.
	 */
	private Map<Class<?>, IComputationContext> contextIndex = Maps.newHashMap();

	public void clearExternalContext() {
		contextIndex.clear();
		contextList.clear();
	}

	public void setExternalContext(IComputationContext... context) {
		this.contextList.addAll(Lists.newArrayList(context));
		this.initialize();
	}

	@SuppressWarnings("unused")
	private IComputationContext getContextFor(Class<?> claxx) {
		return this.contextIndex.get(claxx);
	}

	private void initialize() {
		this.generateContextIndex();

	}

	/**
	 * The context index provides an easy lookup for expressions, which need
	 * access to certain types of context.
	 */
	private void generateContextIndex() {
		for (IComputationContext context : contextList) {

			Object contextObject = context.getContext();

			contextIndex.put(contextObject.getClass(), context);

		}
	}
	
	/**
	 * Example dispatch. 
	 */
//	public Object evaluate(Mod module) {
//		Object result = dispatcher.invoke(module.getStatements(),
//				ImmutableMap.<String, Object> of());
//	}

}

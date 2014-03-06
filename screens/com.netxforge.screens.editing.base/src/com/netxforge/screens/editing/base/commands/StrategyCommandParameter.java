/*******************************************************************************
 * Copyright (c) 13 jan. 2014 NetXForge.
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
package com.netxforge.screens.editing.base.commands;

import java.util.Collection;

import org.eclipse.emf.edit.command.CommandParameter;

public class StrategyCommandParameter extends CommandParameter {

	protected ICommandStrategy cmdStrategy;

	public StrategyCommandParameter(Object owner, Object feature,
			Collection<?> collection, int index) {
		super(owner, feature, collection, index);
	}

	public StrategyCommandParameter(Object owner, Object feature,
			Collection<?> collection) {
		super(owner, feature, collection);
	}

	public StrategyCommandParameter(Object owner, Object feature, Object value,
			Collection<?> collection, int index) {
		super(owner, feature, value, collection, index);
	}

	public StrategyCommandParameter(Object owner, Object feature, Object value,
			Collection<?> collection) {
		super(owner, feature, value, collection);
	}

	public StrategyCommandParameter(Object owner, Object feature, Object value,
			int index) {
		super(owner, feature, value, index);
	}

	public StrategyCommandParameter(Object owner, Object feature, Object value) {
		super(owner, feature, value);
	}

	public StrategyCommandParameter(Object owner) {
		super(owner);
	}

	public ICommandStrategy getCmdStrategy() {
		return cmdStrategy;
	}

	public void setCmdStrategy(ICommandStrategy cmdStrategy) {
		this.cmdStrategy = cmdStrategy;
	}

}

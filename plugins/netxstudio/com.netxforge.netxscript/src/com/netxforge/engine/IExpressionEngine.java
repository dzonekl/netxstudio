/*******************************************************************************
 * Copyright (c) 4 dec. 2012 NetXForge.
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
package com.netxforge.engine;

import java.util.List;

import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;

/**
 * An Expression engine 
 * 
 * @author Christophe Bouhier
 *
 */
public interface IExpressionEngine {

	public abstract void run();

	public abstract Expression getExpression();

	public abstract void setExpression(Expression expression);

	public abstract List<BaseExpressionResult> getExpressionResult();
	
	public boolean errorOccurred();
	
	public Throwable getThrowable();
	
	public List<Object> getContext();
}
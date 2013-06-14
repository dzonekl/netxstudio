/*******************************************************************************
 * Copyright (c) 6 jun. 2013 NetXForge.
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
package com.netxforge.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.google.inject.AbstractModule;
import com.netxforge.engine.ExpressionEngine;
import com.netxforge.engine.IExpressionEngine;

public class ScriptExportModule extends AbstractModule {

	@Override
	protected void configure() {
		
		///////////////////////////////////////////////////
		// EXPORT SERVICES. 
		
		// Note this is a single service, not sure it's ThreadSave (Reintrant safe).  
		bind(export(IExpressionEngine.class)).toProvider(
				service(ExpressionEngine.class).export());

	}

}

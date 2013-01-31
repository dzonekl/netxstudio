/*******************************************************************************
 * Copyright (c) 31 jan. 2013 NetXForge.
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;


/**
 * 
 * @author Christophe Bouhier
 *
 */
public class CDOAdapterFactoryImpl extends AdapterFactoryImpl{

	

	@Override
	public Adapter adapt(Notifier target, Object type) {
		// TODO Auto-generated method stub
		return super.adapt(target, type);
	}

	@Override
	public Adapter adaptNew(Notifier target, Object type) {
		// TODO Auto-generated method stub
		return super.adaptNew(target, type);
	}

	@Override
	public void adaptAllNew(Notifier target) {
		// TODO Auto-generated method stub
		super.adaptAllNew(target);
	}

	@Override
	protected Adapter createAdapter(Notifier target, Object type) {
		// TODO Auto-generated method stub
		return super.createAdapter(target, type);
	}

	@Override
	protected Adapter createAdapter(Notifier target) {
		// TODO Auto-generated method stub
		return super.createAdapter(target);
	}

	@Override
	protected void associate(Adapter adapter, Notifier target) {
		// TODO Auto-generated method stub
		super.associate(adapter, target);
	}
		
	
	
	
	
	
}

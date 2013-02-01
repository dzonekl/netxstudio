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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import com.netxforge.netxstudio.library.NetXResource;

/**
 * An adapter factory for monitoring objects. Currently supported.
 * 
 * {@link IMonitoringSummary}
 * 
 * The factory support CDOAdapter, any change on the object will notify us. 
 * 
 * 
 * </p>
 * Note: This factory is flat, in a way that it checks both the object type and the desired 
 * type for adaptation. 
 * 
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class MonitoringAdapterFactory extends CDOAdapterFactoryImpl {

	/**
	 * This keeps track of all the supported types checked by
	 * {@link #isFactoryForType isFactoryForType}.
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>)
					|| (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * Creates an adapter for the <code>target</code>.
	 * 
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		if(target instanceof NetXResource){
			// Use a generic adapter, regardless of the notifier. 
			return new MonitoringAdapter();
		}
		return null;
	}

	public MonitoringAdapterFactory() {
		supportedTypes.add(IMonitoringSummary.class);
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

}

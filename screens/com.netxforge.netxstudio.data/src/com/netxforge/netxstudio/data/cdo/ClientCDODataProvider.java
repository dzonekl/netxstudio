/*******************************************************************************
 * Copyright (c) 7 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.data.cdo;

import java.util.Collections;

import com.google.inject.Inject;
import com.netxforge.base.IComponentLifecycleListener;
import com.netxforge.base.cdo.ICDOData;

/**
 * DI Provider for {@link ClientCDOData}
 * 
 * @author Christophe Bouhier
 * 
 */
public class ClientCDODataProvider extends AbstractCDODataProvider implements
		IClientCDODataProvider, IComponentLifecycleListener {

	private ICDOConnection connection;

	@Inject
	public ClientCDODataProvider(ICDOConnection connection) {
		this.connection = connection;
	}

	public ICDOData get() {

		ClientCDOData clientCDOData = new ClientCDOData(connection);

		// We want to register for the lifecycle if this component.

		clientCDOData.register(this);
		clientCDOData.activate(this);

		// External processes will deactivate our component.

		return clientCDOData;
	}

	public void lifeEvent(LifeEvent event) {
		if (event.getEvent() == LIFE_EVENT.ACTIVATE) {

			Object target = event.getTarget();

			if (target instanceof ICDOData
					&& !cdoDataCollection.contains(target)) {
				cdoDataCollection.add((ICDOData) target); // Does this trigger a
															// Change?

				super.firePropertyChange("CDODataCollection",
						null, Collections.unmodifiableList(cdoDataCollection));
			}
		}

		if (event.getEvent() == LIFE_EVENT.DEACTIVATE) {

			Object target = event.getTarget();
			if (target instanceof ICDOData
					&& cdoDataCollection.contains(target)) {
				ICDOData data = (ICDOData) target;
				data.deregister(this);
				cdoDataCollection.remove(data); // Does this
												// trigger a
												// Change?
				super.firePropertyChange("CDODataCollection",
						null, Collections.unmodifiableList(cdoDataCollection));
			}

		}

	}
}

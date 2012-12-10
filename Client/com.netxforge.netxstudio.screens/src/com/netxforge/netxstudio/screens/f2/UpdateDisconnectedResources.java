/*******************************************************************************
 * Copyright (c) 5 dec. 2012 NetXForge.
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
 *******************************************************************************/ package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.ObservableEvent;
import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.core.databinding.observable.set.ISetChangeListener;
import org.eclipse.core.databinding.observable.set.SetChangeEvent;

import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/*
 * An IMap observable listener, which can be fed with IObservableMap's and will
 * refresh the provided viewer.
 */
public class UpdateDisconnectedResources implements IChangeListener,
		ISetChangeListener, IMapChangeListener {

	public static UpdateDisconnectedResources getInstance() {
		return new UpdateDisconnectedResources();
	}

	// Disallow instantation.
	private UpdateDisconnectedResources() {
	}

	/*
	 * Used to perform additional functionality for map change notifications.
	 */
	public void notifyObservableMap(IObservableMap... maps) {

		for (IObservableMap map : maps) {
			map.addChangeListener(this);
			map.addMapChangeListener(this);

		}
	}

	public void handleChange(ChangeEvent event) {
		this.handleEvent(event);
	}

	public void handleMapChange(MapChangeEvent event) {
		this.handleEvent(event);
	}

	public void handleSetChange(SetChangeEvent event) {
		this.handleEvent(event);
	}

	private void handleEvent(ObservableEvent event) {
		if (ScreensActivator.DEBUG) {
			ScreensActivator.TRACE.trace(
					ScreensActivator.TRACE_SCREENS_BINDING_OPTION,
					"Binding event " + event);
		}
	}

}
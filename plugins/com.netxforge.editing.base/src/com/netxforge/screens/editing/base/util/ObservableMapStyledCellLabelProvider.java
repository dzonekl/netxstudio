/*******************************************************************************
 * Copyright (c) 2 apr. 2014 NetXForge.
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
package com.netxforge.screens.editing.base.util;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;

/**
 * Instantiate with an {@link IObservableMap} and fire label updates for
 * {@link MapChangeEvent change events}
 * 
 * @author Christophe Bouhier
 * 
 */
public class ObservableMapStyledCellLabelProvider extends
		StyledCellLabelProvider {

	/**
	 * Observable maps typically mapping from viewer elements to label values.
	 * Subclasses may reference these maps to provide custom labels.
	 * 
	 */
	protected IObservableMap[] attributeMaps;

	private IMapChangeListener mapChangeListener = new IMapChangeListener() {
		public void handleMapChange(MapChangeEvent event) {
			@SuppressWarnings("rawtypes")
			Set affectedElements = event.diff.getChangedKeys();
			LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
					ObservableMapStyledCellLabelProvider.this,
					affectedElements.toArray());
			fireLabelProviderChanged(newEvent);
		}
	};

	public ObservableMapStyledCellLabelProvider(IObservableMap[] attributeMaps) {
		System.arraycopy(attributeMaps, 0,
				this.attributeMaps = new IObservableMap[attributeMaps.length],
				0, attributeMaps.length);
		for (int i = 0; i < this.attributeMaps.length; i++) {
			this.attributeMaps[i].addMapChangeListener(mapChangeListener);
		}
	}

	public void dispose() {
		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].removeMapChangeListener(mapChangeListener);
		}
		super.dispose();
		this.attributeMaps = null;
		this.mapChangeListener = null;
	}

}

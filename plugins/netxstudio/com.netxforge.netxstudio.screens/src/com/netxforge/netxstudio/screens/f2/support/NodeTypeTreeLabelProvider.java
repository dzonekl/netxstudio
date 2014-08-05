/*******************************************************************************
 * Copyright (c) Jun 24, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.f2.support;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.base.cdo.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateCallBack;
import com.netxforge.netxstudio.common.model.NodeTypeSummary;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public class NodeTypeTreeLabelProvider extends StyledCellLabelProvider {

	/** Our state Model **/
	private MonitoringStateModel stateModel;

	class LabelProviderCallBack implements MonitoringStateCallBack {

		public void callBackEvent(MonitoringStateEvent event) {
			Object result = event.getResult();
			if (result instanceof IMonitoringSummary) {
				final Notifier target = ((IMonitoringSummary) result)
						.getTarget();
				// We can't process the result, so fire a change for this
				// object, which should
				// force the viewer to query the alreayd installed and
				// computed adapter.

				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						fireLabelProviderChanged(new LabelProviderChangedEvent(
								NodeTypeTreeLabelProvider.this, target));
					}
				});

			}
		}
	};

	private IMapChangeListener mapChangeListener = new IMapChangeListener() {
		public void handleMapChange(MapChangeEvent event) {
			Set<?> affectedElements = event.diff.getChangedKeys();
			if (!affectedElements.isEmpty()) {
				LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
						NodeTypeTreeLabelProvider.this,
						affectedElements.toArray());
				fireLabelProviderChanged(newEvent);
			}
		}
	};

	@Inject
	public NodeTypeTreeLabelProvider(MonitoringStateModel stateModel) {
		this.stateModel = stateModel;
	}

	public void registerMap(IObservableMap... attributeMaps) {
		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].addMapChangeListener(mapChangeListener);
		}
	}

	// @Override
	// public String getToolTipText(Object element) {
	// return "#dummy#";
	// }

	@Override
	public void update(ViewerCell cell) {

		Object element = cell.getElement();

		if (element instanceof NodeType) {

			NodeType nt = (NodeType) element;

			StyledString styledString = new StyledString(
					nt.getName() != null ? nt.getName() : "?", null);
			
			if (!MonitoringStateModel.isAdapted(nt)) {
				stateModel
						.summary(
								new LabelProviderCallBack(),
								nt,
								MonitoringStateModel.MONITOR_COMPUTATION_REPETITIVE_MODE);
			} else {
				NodeTypeSummary summary = (NodeTypeSummary) MonitoringStateModel
						.getAdapted(nt);
				
				String decoration = " (" + summary.getFunctionCountAsString()
						+ " Functions)" + " ("
						+ summary.getEquipmentCountAsString() + " Equipments)";

				styledString.append(decoration, StyledString.COUNTER_STYLER);
			}
			
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Node_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());

		}

		if (element instanceof Function) {
			Function fc = (Function) element;

			StyledString styledString = new StyledString(
					fc.getName() != null ? fc.getName() : "?", null);
			String decoration = " (" + fc.getResourceRefs().size()
					+ " Resources)";
			styledString.append(decoration, StyledString.COUNTER_STYLER);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Function_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		}
		if (element instanceof Equipment) {

			Equipment eq = (Equipment) element;
			StyledString styledString = new StyledString(
					eq.getEquipmentCode() != null ? eq.getEquipmentCode() : "?",
					null);
			String decoration = " (" + eq.getResourceRefs().size()
					+ " Resources)";
			styledString.append(decoration, StyledString.COUNTER_STYLER);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Equipment_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		}

		if (element instanceof NetXResource) {

			NetXResource eq = (NetXResource) element;
			StyledString styledString = new StyledString(
					eq.getShortName() != null ? eq.getShortName() : "?", null);
			// String decoration = " (" + eq.getResources().size() +
			// " Resources)";
			// styledString.append(decoration, StyledString.COUNTER_STYLER);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Resource_H.gif");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		}
	}

	// @Override
	// public void dispose() {
	// super.dispose();
	//
	// // Dispose the images.
	// ResourceManager.dispose();
	// }

}

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
package com.netxforge.netxstudio.screens.f1.support;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.base.NonModelUtils;
import com.netxforge.base.Tuple;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.IMonitoringSummary.RAG;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.f3.support.NetworkTreeLabelProvider;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.screens.editing.base.ScreenUtil;

public class MonitoringTreeLabelProvider extends StyledCellLabelProvider {

	private IMapChangeListener mapChangeListener = new IMapChangeListener() {

		public void handleMapChange(MapChangeEvent event) {
			Set<?> affectedElements = event.diff.getChangedKeys();
			if (!affectedElements.isEmpty()) {
				LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
						MonitoringTreeLabelProvider.this,
						affectedElements.toArray());
				fireLabelProviderChanged(newEvent);
			}
		}
	};
	private NetworkTreeLabelProvider networkTreeLabelProvider;

	@SuppressWarnings("unused")
	private Styler ragRedStyler;
	@SuppressWarnings("unused")
	private Styler ragAmberStyler;
	@SuppressWarnings("unused")
	private Styler ragGreenStyler;
	@SuppressWarnings("unused")
	private Styler ragYellowStyler;

	public MonitoringTreeLabelProvider(MonitoringStateModel stateModel,
			IObservableMap... attributeMaps) {

		for (int i = 0; i < attributeMaps.length; i++) {
			attributeMaps[i].addMapChangeListener(mapChangeListener);
		}
		networkTreeLabelProvider = new NetworkTreeLabelProvider(attributeMaps);
	}

	@Override
	public void update(ViewerCell cell) {

		switch (cell.getColumnIndex()) {
		case 0: {
			processColumn0(cell);
		}
			break;
		default: {
			processRagColumns(cell);
		}
			break;

		}
	}

	private void processColumn0(ViewerCell cell) {
		Object element = cell.getElement();

		if (element instanceof Operator) {
			Operator o = (Operator) element;

			StyledString styledString = new StyledString(
					o.eIsSet(GenericsPackage.Literals.COMPANY__NAME) ? o.getName()
							: "?", null);
			// String decoration = " (" + tt.getFunctions() + " Functions)"
			// + " (" + tt.getEquipments() + " Equipments)";
			// styledString.append(decoration, StyledString.COUNTER_STYLER);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Company_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());

		} else if (element instanceof RFSService) {

			RFSService nt = (RFSService) element;

			StyledString styledString = new StyledString(
					nt.getServiceName() != null ? nt.getServiceName() : "?",
					null);
			// String decoration = " (" + tt.getFunctions() + " Functions)"
			// + " (" + tt.getEquipments() + " Equipments)";
			// styledString.append(decoration, StyledString.COUNTER_STYLER);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Service_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		} else if (element instanceof NetXResource) {
			NetXResource res = (NetXResource) element;
			StyledString styledString = new StyledString(
					res.getShortName() != null ? res.getShortName() : "?", null);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/NetXResource_H.gif");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());

		} else if (element instanceof MetricValueRange) {

			MetricValueRange mvr = (MetricValueRange) element;
			int size = mvr.getMetricValues().size();

			Tuple interval = NonModelUtils.interval(mvr.getIntervalHint());
			StyledString styledString = new StyledString(interval.getKey()
					+ " : " + mvr.getKindHint() + " : ("
					+ new Integer(size).toString() + ")");
			cell.setText(styledString.getString());
			cell.setStyleRanges(styledString.getStyleRanges());

		} else {

			networkTreeLabelProvider.update(cell);
		}
	}

	private void processRagColumns(ViewerCell cell) {
		Object element = cell.getElement();

		if (element instanceof EObject) {

			// For node, we need to present the nodetype summary.
			if (element instanceof Node) {
				if (((EObject) element)
						.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
					element = ((Node) element).getNodeType();
				}
			}

			if (!MonitoringStateModel.isAdapted((EObject) element)) {
				// We let our screen deal with calling the monitoring state
				// model.
				// System.out.println(" No monitor for: " + element);
			} else {
				IMonitoringSummary summary = MonitoringStateModel
						.getAdapted((EObject) element);

				StyledString styledString = backGroundAndStyleForRag(cell,
						summary);
				cell.setText(styledString.getString());
				cell.setStyleRanges(styledString.getStyleRanges());
			}
		}
	}

	/**
	 * @param cell
	 * @param summary
	 * @param rag
	 * @return
	 */
	private StyledString backGroundAndStyleForRag(ViewerCell cell,
			IMonitoringSummary summary) {

		String rag = "";

		StyledString styledString;
		switch (cell.getColumnIndex()) {
		case 1: {
			backGroundForRag(cell, summary.totalRag(RAG.RED),
					ScreenUtil.RED_MARKER);
			rag = new Integer(summary.totalRag(RAG.RED)).toString();
		}
			break;
		case 2: {
			backGroundForRag(cell, summary.totalRag(RAG.AMBER),
					ScreenUtil.AMBER_MARKER);
			rag = new Integer(summary.totalRag(RAG.AMBER)).toString();
		}
			break;
		case 3: {
			backGroundForRag(cell, summary.totalRag(RAG.GREEN),
					ScreenUtil.GREEN_MARKER);
			rag = new Integer(summary.totalRag(RAG.GREEN)).toString();
		}
			break;
		}

		styledString = new StyledString(rag);

		return styledString;
	}

	private void backGroundForRag(ViewerCell cell, int ragValue,
			String symbolicName) {
		// Determine if R, A or G from the RAG status, set the styler.
		if (ragValue > 0) {
			// remember the previous background.
			cell.setBackground(JFaceResources.getColorRegistry().get(
					symbolicName));
		} else {
			cell.setBackground(null);
		}
	}

}

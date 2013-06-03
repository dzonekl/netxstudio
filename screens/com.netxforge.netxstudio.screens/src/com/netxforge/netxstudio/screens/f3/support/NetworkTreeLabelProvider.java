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
package com.netxforge.netxstudio.screens.f3.support;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.Relationship;


/**
 * A Styled Label provider which deals with model objects like Operator, Network. 
 * 
 * @author Christophe Bouhier
 *
 */
public class NetworkTreeLabelProvider extends StyledCellLabelProvider {

	private static final String REL_NOTCONNECTED_COLOR_STYLER = "X_COLOR_STYLER";
	private static final String METRIC_COLOR_STYLER = "METRIC_COLOR_STYLER";
	private static final String EXPRESSION_COLOR_STYLER = "EXPRESSION_COLOR_STYLER";
	private static final String LIFECYCLE_COLOR_STYLER = "LIFECYCLE_COLOR_STYLER";
	
	private ModelUtils modelUtils;
	
	static {
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		colorRegistry.put(REL_NOTCONNECTED_COLOR_STYLER, new RGB(255, 0, 0)); // yellowish
		colorRegistry.put(METRIC_COLOR_STYLER, new RGB(0xBD, 0xB7, 0x6B)); // cherry
		colorRegistry.put(EXPRESSION_COLOR_STYLER, new RGB(235, 80, 75)); // red. 
		colorRegistry.put(LIFECYCLE_COLOR_STYLER, new RGB(241,146,69)); // fade grey
	}

	private IMapChangeListener mapChangeListener = new IMapChangeListener() {
		public void handleMapChange(MapChangeEvent event) {
			Set<?> affectedElements = event.diff.getChangedKeys();
			if (!affectedElements.isEmpty()) {
				LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
						NetworkTreeLabelProvider.this,
						affectedElements.toArray());
				fireLabelProviderChanged(newEvent);
			}
		}
	};
	

	public NetworkTreeLabelProvider(ModelUtils modelUtils, IObservableMap... attributeMaps ) {
		
		this.modelUtils = modelUtils;
		
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

		// We potentially support multiple columns.
		Object element = cell.getElement();
		int columnIndex = cell.getColumnIndex();

		switch (columnIndex) {
		case 0: {
			updateColumn0(cell, element);
		}
			break;
		case 1: {
			updateColumn1(cell, element);
		}
			break;
		case 2: {
			updateColumn2(cell, element);
		}
			break;
		case 3: {
			updateColumn3(cell, element);
		}
		}

	}

	// @Override
	// public void dispose() {
	// super.dispose();
	//
	// // Dispose the images.
	// ResourceManager.dispose();
	// }

	private void updateColumn1(ViewerCell cell, Object element) {

		StyledString styledString = new StyledString();
		// Styler expressionColorStyle = StyledString.createColorRegistryStyler(
		// EXPRESSION_COLOR_STYLER, null);
		Image img = null;
		if (element instanceof Component) {
			Component c = (Component) element;
			if (c.eIsSet(LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF)) {
				// styledString.append(" C ", expressionColorStyle);
				// cell.setText(styledString.getString());
				img = ResourceManager.getPluginImage(
						"com.netxforge.netxstudio.models.edit",
						"icons/full/obj16/Expression_H.png");
				cell.setImage(img);
				cell.setStyleRanges(styledString.getStyleRanges());
			} else {
				cell.setImage(null);
			}
		}

	}

	private void updateColumn2(ViewerCell cell, Object element) {

		StyledString styledString = new StyledString();
		// Styler expressionColorStyle = StyledString.createColorRegistryStyler(
		// EXPRESSION_COLOR_STYLER, null);
		Image img = null;

		if (element instanceof Component) {
			Component c = (Component) element;

			if (c.eIsSet(LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF)) {
				// styledString.append(" ,U ", expressionColorStyle);
				// cell.setText(styledString.getString());
				img = ResourceManager.getPluginImage(
						"com.netxforge.netxstudio.models.edit",
						"icons/full/obj16/Expression_H.png");
				cell.setImage(img);
				cell.setStyleRanges(styledString.getStyleRanges());
			} else {
				cell.setImage(null);
			}
		}
	}

	private void updateColumn3(ViewerCell cell, Object element) {

		StyledString styledString = new StyledString();
		if (element instanceof Component) {
			Component c = (Component) element;
			int size = c.getToleranceRefs().size();
			if (size > 0) {
				cell.setText(new Integer(size).toString());
				cell.setStyleRanges(styledString.getStyleRanges());
			}
		}
	}

	private void updateColumn0(ViewerCell cell, Object element) {
		if (element instanceof Operator) {

			Operator operator = (Operator) element;

			StyledString styledString = new StyledString(
					operator.getName() != null ? operator.getName() : "?", null);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Company_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		}

		if (element instanceof Network) {

			Network network = (Network) element;

			StyledString styledString = new StyledString(
					network.getName() != null ? network.getName() : "?", null);
			// String decoration = " (" + network.getFunctions().size() +
			// " Functions)"
			// + " (" + network.getFunctions().size() + " Equipments)";
			// styledString.append(decoration, StyledString.COUNTER_STYLER);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Network_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		}

		if (element instanceof Node) {

			Node node = (Node) element;

			StyledString styledString = new StyledString(
					node.getNodeID() != null ? node.getNodeID() : "?", null);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Node_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		}

		if (element instanceof Component) {
			
			
			Component c = (Component) element;
			StyledString styledString = new StyledString();
				
			
			Styler lifecycleColorStyler = StyledString.createColorRegistryStyler(
					LIFECYCLE_COLOR_STYLER, null);
			int lifeCycleState = modelUtils.lifecycleState(c.getLifecycle());
			
			styledString.append(modelUtils.componentName(c), null);
			
			if (element instanceof Function) {
				cell.setImage(ResourceManager.getPluginImage(
						"com.netxforge.netxstudio.models.edit",
						"icons/full/obj16/Function_H.png"));
			}
			if (element instanceof Equipment) {
				cell.setImage(ResourceManager.getPluginImage(
						"com.netxforge.netxstudio.models.edit",
						"icons/full/obj16/Equipment_H.png"));

			}

			Styler metricColorStyler = StyledString.createColorRegistryStyler(
					METRIC_COLOR_STYLER, null);
			
			// Add Resources info. 
			if (!c.getResourceRefs().isEmpty()) {
				String decoration = " (" + c.getResourceRefs().size()
						+ " Res.)";
				styledString.append(decoration, StyledString.COUNTER_STYLER);
			}
			
			// Add Metrics info. 
			if (!c.getMetricRefs().isEmpty()) {
				String decoration = " (" + c.getMetricRefs().size()
						+ " Metrics)";
				styledString.append(decoration, metricColorStyler);
			}
			
			// Add Life Cycle info. 
			if( lifeCycleState != ModelUtils.LIFECYCLE_NOTSET){
				String decoration = " (" + modelUtils.lifecycleText(lifeCycleState) + ")";
				styledString.append(decoration, lifecycleColorStyler);
			}

			cell.setText(styledString.getString());
			cell.setStyleRanges(styledString.getStyleRanges());

		}

		if (element instanceof Relationship) {

			Styler xColorStyler = StyledString.createColorRegistryStyler(
					REL_NOTCONNECTED_COLOR_STYLER, null);

			Relationship rel = (Relationship) element;
			StyledString styledString = new StyledString(
					rel.getName() != null ? rel.getName() : "?", null);

			StringBuffer decoration = new StringBuffer();
			decoration.append(" (");
			if (rel.getNodeID1Ref() != null) {
				decoration.append(rel.getNodeID1Ref().getNodeID());
				styledString.append(decoration.toString(),
						StyledString.COUNTER_STYLER);
			} else {
				styledString.append(decoration.toString(),
						StyledString.COUNTER_STYLER);
				styledString.append(" x", xColorStyler);
			}

			decoration = new StringBuffer();
			decoration.append(" <--> ");

			if (rel.getNodeID2Ref() != null) {
				decoration.append(rel.getNodeID2Ref().getNodeID());
				styledString.append(decoration.toString(),
						StyledString.COUNTER_STYLER);
			} else {
				styledString.append(decoration.toString(),
						StyledString.COUNTER_STYLER);
				styledString.append("x", xColorStyler);

			}
			decoration = new StringBuffer();
			decoration.append(" )");

			styledString.append(decoration.toString(),
					StyledString.COUNTER_STYLER);

			cell.setText(styledString.getString());

			Image img;
			if (element instanceof FunctionRelationship) {
				img = ResourceManager.getPluginImage(
						"com.netxforge.netxstudio.models.edit",
						"icons/full/obj16/FunctionRelationship_H.png");
				cell.setImage(img);
			}
			if (element instanceof EquipmentRelationship) {
				img = ResourceManager.getPluginImage(
						"com.netxforge.netxstudio.models.edit",
						"icons/full/obj16/EquipmentRelationship_H.png");
				cell.setImage(img);
			}

			cell.setStyleRanges(styledString.getStyleRanges());
		}
	}

}

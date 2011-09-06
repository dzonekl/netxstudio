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
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.Relationship;

public class NetworkTreeLabelProvider extends StyledCellLabelProvider {
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

	public NetworkTreeLabelProvider(IObservableMap... attributeMaps) {
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
			// String decoration = " (" + network.getFunctions().size() +
			// " Functions)"
			// + " (" + network.getFunctions().size() + " Equipments)";
			// styledString.append(decoration, StyledString.COUNTER_STYLER);
			cell.setText(styledString.getString());
			Image img = ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/obj16/Node_H.png");
			cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		}

		if (element instanceof NodeType) {

			NodeType nt = (NodeType) element;

			StyledString styledString = new StyledString(
					nt.getName() != null ? nt.getName() : "?", null);
			String decoration = " (" + nt.getFunctions().size() + " Functions)"
					+ " (" + nt.getFunctions().size() + " Equipments)";
			styledString.append(decoration, StyledString.COUNTER_STYLER);
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

			StringBuffer buf = new StringBuffer();
			buf.append(eq.getEquipmentCode() != null ? eq.getEquipmentCode()
					: "?");
			if(eq.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)){
				buf.append(" : " + eq.getName());
			}
			StyledString styledString = new StyledString(buf.toString(), null);

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

		if (element instanceof Relationship) {

			Relationship rel = (Relationship) element;
			StyledString styledString = new StyledString(
					rel.getName() != null ? rel.getName() : "?", null);

			StringBuffer decoration = new StringBuffer();
			decoration.append(" (");
			if (rel.getNodeID1Ref() != null) {
				decoration.append(rel.getNodeID1Ref().getNodeID());
			}
			decoration.append(" <--> ");

			if (rel.getNodeID2Ref() != null) {
				decoration.append(rel.getNodeID2Ref().getNodeID());
			}
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

	// @Override
	// public void dispose() {
	// super.dispose();
	//
	// // Dispose the images.
	// ResourceManager.dispose();
	// }

}
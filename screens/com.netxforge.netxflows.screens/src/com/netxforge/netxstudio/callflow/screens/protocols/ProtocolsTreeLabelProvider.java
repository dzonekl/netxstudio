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
package com.netxforge.netxstudio.callflow.screens.protocols;

import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.RGB;

import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.protocols.Procedure;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;

/*
 * General purpose for Call Flows and Relationships. 
 */
public class ProtocolsTreeLabelProvider extends StyledCellLabelProvider {

	private static final String REL_NOTCONNECTED_COLOR_STYLER = "X_COLOR_STYLER";
	private static final String YELLOW_COLOR_STYLER = "YELLOW_COLOR_STYLER";
	private static final String EXPRESSION_COLOR_STYLER = "EXPRESSION_COLOR_STYLER";

	static {
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		colorRegistry.put(REL_NOTCONNECTED_COLOR_STYLER, new RGB(255, 0, 0));
		colorRegistry.put(YELLOW_COLOR_STYLER, new RGB(0xBD, 0xB7, 0x6B)); // yellowish
		colorRegistry.put(EXPRESSION_COLOR_STYLER, new RGB(235, 80, 75)); // cherry
																			// red.
	}

	private IMapChangeListener mapChangeListener = new IMapChangeListener() {
		public void handleMapChange(MapChangeEvent event) {
			Set<?> affectedElements = event.diff.getChangedKeys();
			if (!affectedElements.isEmpty()) {
				LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
						ProtocolsTreeLabelProvider.this,
						affectedElements.toArray());
				fireLabelProviderChanged(newEvent);
			}
		}
	};

	public ProtocolsTreeLabelProvider() {
		super();
	}

	public ProtocolsTreeLabelProvider(IObservableMap... attributeMaps) {
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

		// Service Flow object
		// 0 = index
		// 1 = Name
		// 2 = empty (Perhaps the first element).
		// 3 = empty (Perhaps the last element)
		// 4 = Protocol.

		// Service Flow Relationship object.
		// 0 = empty
		// 1 = empty
		// 2 = NodeType A
		// 3 = NodeType B
		// 4 = Protocol
		//

		// We potentially support multiple columns, override as needed. binding
		// to features should return a reasonable default.
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

		default: {
			super.update(cell);
		}
		}
	}

	private void updateColumn1(ViewerCell cell, Object element) {
		if (element instanceof Protocol) {
			Protocol serviceFlow = (Protocol) element;
			StyledString styledString = new StyledString(serviceFlow.getName(),
					null);
			cell.setText(styledString.getString());
			// Image img = ResourceManager.getPluginImage(
			// "com.netxforge.netxstudio.models.edit",
			// "icons/full/obj16/Company_H.png");
			// cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		} else if (element instanceof Procedure) {
			Procedure procedure = (Procedure) element;
			StyledString styledString = new StyledString(procedure.getName());
			cell.setStyleRanges(styledString.getStyleRanges());
			cell.setText(styledString.getString());
		} else if (element instanceof Message) {
			Message procedure = (Message) element;
			StyledString styledString = new StyledString(procedure.getName());
			cell.setStyleRanges(styledString.getStyleRanges());
			cell.setText(styledString.getString());
		}
	}

	private void updateColumn0(ViewerCell cell, Object element) {
		if (element instanceof Protocol) {
			Protocol serviceFlow = (Protocol) element;
			StyledString styledString = new StyledString(indexFor(null,
					serviceFlow), null);
			cell.setText(styledString.getString());
			// Image img = ResourceManager.getPluginImage(
			// "com.netxforge.netxstudio.models.edit",
			// "icons/full/obj16/Company_H.png");
			// cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		} else if (element instanceof Procedure) {
			Procedure proc = (Procedure) element;
			StyledString styledString = new StyledString(indexFor(
					ProtocolsPackage.Literals.PROTOCOL__PROCEDURES, proc), null);
			cell.setText(styledString.getString());
			cell.setStyleRanges(styledString.getStyleRanges());
		} else if (element instanceof Message) {
			Message proc = (Message) element;
			StyledString styledString = new StyledString(indexFor(
					ProtocolsPackage.Literals.PROCEDURE__MESSAGES, proc), null);
			cell.setText(styledString.getString());
			cell.setStyleRanges(styledString.getStyleRanges());
		}
	}

	private String indexFor(EStructuralFeature feature, EObject childObject) {
		if (childObject.eContainer() != null) {
			EObject eContainer = childObject.eContainer();
			Object value = eContainer.eGet(feature);
			if (value instanceof List<?>) {
				List<?> list = (List<?>) value;
				int indexOf = list.indexOf(childObject);
				return new Integer(indexOf).toString();
			}
		} else if (childObject.eResource() != null) {
			Resource eResource = childObject.eResource();
			return new Integer((eResource).getContents().indexOf(childObject))
					.toString();
		}
		throw new IllegalArgumentException("Can't resolve feature " + feature
				+ " for child object" + childObject);
	}

}

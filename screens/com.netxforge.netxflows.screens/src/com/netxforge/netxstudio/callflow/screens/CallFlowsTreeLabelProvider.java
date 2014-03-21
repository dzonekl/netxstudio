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
package com.netxforge.netxstudio.callflow.screens;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IMapChangeListener;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.map.MapChangeEvent;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.RGB;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.services.ServiceFlow;
import com.netxforge.netxstudio.services.ServiceFlowDirection;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesPackage;

/*
 * General purpose for Call Flows and Relationships. 
 */
public class CallFlowsTreeLabelProvider extends StyledCellLabelProvider {

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
						CallFlowsTreeLabelProvider.this,
						affectedElements.toArray());
				fireLabelProviderChanged(newEvent);
			}
		}
	};

	public CallFlowsTreeLabelProvider() {
		super();
	}

	public CallFlowsTreeLabelProvider(IObservableMap... attributeMaps) {
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
		case 2: {
			updateColumn2(cell, element);
		}
			break;
		case 3: {
			updateColumn3(cell, element);
		}
			break;
		case 4: {
			updateColumn4(cell, element);
		}
			break;
		case 5: {
			updateColumn5(cell, element);
		}
			break;
		case 6: {
			updateColumn6(cell, element);
		}
			break;
		case 7: {
			updateColumn7(cell, element);
		}
			break;

		default: {
			super.update(cell);
		}
		}
	}

	private void updateColumn5(ViewerCell cell, Object element) {
		if (element instanceof ServiceFlowRelationship) {
			ServiceFlowRelationship rel = (ServiceFlowRelationship) element;

			if (rel.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
				ReferenceRelationship referenceRelationship = rel
						.getReferenceRelationship();

				// Check if the interface is set.
				if (referenceRelationship
						.eIsSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF)) {
					NodeType nodeTypeRef = referenceRelationship
							.getRefInterface2Ref();

					// Set the name of the Node Type.
					StyledString styledString = new StyledString(
							nodeTypeRef.getName(), null);
					cell.setText(styledString.getString());
					// Image img = ResourceManager.getPluginImage(
					// "com.netxforge.netxstudio.models.edit",
					// "icons/full/obj16/Company_H.png");
					// cell.setImage(img);
					cell.setStyleRanges(styledString.getStyleRanges());

				}
			} else {
				cell.setText("-");
			}
		}
	}

	private void updateColumn6(ViewerCell cell, Object element) {
		if (element instanceof ServiceFlowRelationship) {
			ServiceFlowRelationship sfRel = (ServiceFlowRelationship) element;
			if (sfRel
					.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__PROTOCOL)) {
				Protocol protocol = sfRel.getProtocol();

				// Set the name of the Node Type.
				StyledString styledString = new StyledString(
						protocol.getName(), null);
				cell.setText(styledString.getString());
				// Image img = ResourceManager.getPluginImage(
				// "com.netxforge.netxstudio.models.edit",
				// "icons/full/obj16/Company_H.png");
				// cell.setImage(img);
				cell.setStyleRanges(styledString.getStyleRanges());

			} else {
				cell.setText("-");
			}
		}
	}

	private void updateColumn7(ViewerCell cell, Object element) {
		if (element instanceof ServiceFlowRelationship) {
			ServiceFlowRelationship rel = (ServiceFlowRelationship) element;
			if (rel.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__MESSAGE)) {
				Message msg = rel.getMessage();

				// Set the name of the Node Type.
				StyledString styledString = new StyledString(msg.getName(),
						null);
				cell.setText(styledString.getString());
				// Image img = ResourceManager.getPluginImage(
				// "com.netxforge.netxstudio.models.edit",
				// "icons/full/obj16/Company_H.png");
				// cell.setImage(img);
				cell.setStyleRanges(styledString.getStyleRanges());

			} else {
				cell.setText("-");
			}
		}
	}

	private void updateColumn4(ViewerCell cell, Object element) {
		if (element instanceof ServiceFlowRelationship) {
			ServiceFlowRelationship rel = (ServiceFlowRelationship) element;
			if (rel.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
				ServiceFlowDirection direction = rel.getDirection();
				if (direction != null) {
					switch (direction.getValue()) {
					case ServiceFlowDirection.LEFTTORIGHT_VALUE: {
						cell.setText("-->");
					}
						break;
					case ServiceFlowDirection.RIGHTTOLEFT_VALUE: {
						cell.setText("<--");
					}
						break;
					}
				} else {
					cell.setText("-");
				}

			}
		} else if (element instanceof ReferenceRelationship) {
			ReferenceRelationship referenceRelationship = (ReferenceRelationship) element;

			if (referenceRelationship
					.eIsSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__PROTOCOL_REF)) {
				Protocol protocolRef = referenceRelationship.getProtocolRef();

				// Set the name of the Node Type.
				StyledString styledString = new StyledString(
						protocolRef.getName(), null);
				cell.setText(styledString.getString());
				// Image img = ResourceManager.getPluginImage(
				// "com.netxforge.netxstudio.models.edit",
				// "icons/full/obj16/Company_H.png");
				// cell.setImage(img);
				cell.setStyleRanges(styledString.getStyleRanges());

			} else {
				cell.setText("-");
			}
		}
	}

	private void updateColumn2(ViewerCell cell, Object element) {

		if (element instanceof ServiceFlowRelationship) {
			ServiceFlowRelationship rel = (ServiceFlowRelationship) element;
			if (rel.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
				ReferenceRelationship referenceRelationship = rel
						.getReferenceRelationship();

				// Set the name of the Node Type.
				StyledString styledString = new StyledString();

				NodeType nt1 = referenceRelationship.getRefInterface1Ref();
				NodeType nt2 = referenceRelationship.getRefInterface2Ref();

				StringBuffer buf = new StringBuffer();
				buf.append(" (");
				buf.append(nt1 != null ? nt1.getName() : " ?");
				buf.append(" <--> ");
				buf.append(nt2 != null ? nt2.getName() : " ?");
				buf.append(")");

				String typedName = referenceRelationship.getName();
				styledString
						.append(typedName != null && typedName.length() > 0 ? referenceRelationship
								.getName() + " :" + buf.toString()
								: buf.toString());

				// Image img = ResourceManager.getPluginImage(
				// "com.netxforge.netxstudio.models.edit",
				// "icons/full/obj16/Company_H.png");
				// cell.setImage(img);
				cell.setStyleRanges(styledString.getStyleRanges());
				cell.setText(styledString.getString());
			} else if (rel
					.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__SERVICE_FLOW)) {
				ServiceFlow serviceFlow = rel.getServiceFlow();
				StringBuffer buf = new StringBuffer();
				buf.append("[");
				buf.append(serviceFlow.getName());
				buf.append("]");
				cell.setText(buf.toString());
			} else {
				cell.setText("-");
			}
		} else if (element instanceof ReferenceRelationship) {
			ReferenceRelationship referenceRelationship = (ReferenceRelationship) element;

			if (referenceRelationship
					.eIsSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF)) {
				NodeType nodeTypeRef = referenceRelationship
						.getRefInterface1Ref();

				// Set the name of the Node Type.
				StyledString styledString = new StyledString(
						nodeTypeRef.getName(), null);
				cell.setText(styledString.getString());
				// Image img = ResourceManager.getPluginImage(
				// "com.netxforge.netxstudio.models.edit",
				// "icons/full/obj16/Company_H.png");
				// cell.setImage(img);
				cell.setStyleRanges(styledString.getStyleRanges());

			} else {
				cell.setText("-");
			}
		}
	}

	private void updateColumn3(ViewerCell cell, Object element) {
		if (element instanceof ServiceFlowRelationship) {
			ServiceFlowRelationship rel = (ServiceFlowRelationship) element;
			if (rel.eIsSet(ServicesPackage.Literals.SERVICE_FLOW_RELATIONSHIP__REFERENCE_RELATIONSHIP)) {
				ReferenceRelationship referenceRelationship = rel
						.getReferenceRelationship();

				// Check if the interface is set.
				if (referenceRelationship
						.eIsSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE1_REF)) {
					NodeType nodeTypeRef = referenceRelationship
							.getRefInterface1Ref();

					// Set the name of the Node Type.
					StyledString styledString = new StyledString(
							nodeTypeRef.getName(), null);
					cell.setText(styledString.getString());
					// Image img = ResourceManager.getPluginImage(
					// "com.netxforge.netxstudio.models.edit",
					// "icons/full/obj16/Company_H.png");
					// cell.setImage(img);
					cell.setStyleRanges(styledString.getStyleRanges());

				}
			} else {
				cell.setText("-");
			}
		} else if (element instanceof ReferenceRelationship) {
			ReferenceRelationship referenceRelationship = (ReferenceRelationship) element;

			if (referenceRelationship
					.eIsSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__REF_INTERFACE2_REF)) {
				NodeType nodeTypeRef = referenceRelationship
						.getRefInterface2Ref();

				// Set the name of the Node Type.
				StyledString styledString = new StyledString(
						nodeTypeRef.getName(), null);
				cell.setText(styledString.getString());
				// Image img = ResourceManager.getPluginImage(
				// "com.netxforge.netxstudio.models.edit",
				// "icons/full/obj16/Company_H.png");
				// cell.setImage(img);
				cell.setStyleRanges(styledString.getStyleRanges());

			} else {
				cell.setText("-");
			}
		}
	}

	private void updateColumn1(ViewerCell cell, Object element) {
		if (element instanceof ServiceFlow) {
			ServiceFlow serviceFlow = (ServiceFlow) element;
			StyledString styledString = new StyledString(serviceFlow.getName(),
					null);
			cell.setText(styledString.getString());
			// Image img = ResourceManager.getPluginImage(
			// "com.netxforge.netxstudio.models.edit",
			// "icons/full/obj16/Company_H.png");
			// cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		} else if (element instanceof ReferenceRelationship) {
			//
			ReferenceRelationship rel = (ReferenceRelationship) element;
			StyledString styledString = new StyledString();

			if (rel.eIsSet(LibraryPackage.Literals.REFERENCE_RELATIONSHIP__NAME)) {
				styledString.append(rel.getName(), null);
			}

			// Styler metricColorStyler =
			// StyledString.createColorRegistryStyler(
			// YELLOW_COLOR_STYLER, null);

			NodeType nt1 = rel.getRefInterface1Ref();
			NodeType nt2 = rel.getRefInterface2Ref();

			StringBuffer buf = new StringBuffer();
			buf.append(" (");
			buf.append(nt1 != null ? nt1.getName() : " ?");
			buf.append(" <--> ");
			buf.append(nt2 != null ? nt2.getName() : " ?");
			buf.append(")");
			// // Set the name of the Node Type.
			styledString.append(buf.toString(), StyledString.COUNTER_STYLER);
			// cell.setText(styledString.getString());
			// // // Image img = ResourceManager.getPluginImage(
			// // // "com.netxforge.netxstudio.models.edit",
			// // // "icons/full/obj16/Company_H.png");
			// // // cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
			cell.setText(styledString.getString());
		}
	}

	private void updateColumn0(ViewerCell cell, Object element) {
		if (element instanceof ServiceFlow) {
			ServiceFlow serviceFlow = (ServiceFlow) element;
			
			StyledString styledString = new StyledString("TODO An ID", null);
			cell.setText(styledString.getString());
			// Image img = ResourceManager.getPluginImage(
			// "com.netxforge.netxstudio.models.edit",
			// "icons/full/obj16/Company_H.png");
			// cell.setImage(img);
			cell.setStyleRanges(styledString.getStyleRanges());
		} else if (element instanceof ReferenceRelationship) {
			ReferenceRelationship relationship = (ReferenceRelationship) element;
			StyledString styledString = new StyledString("TODO An ID", null);
			cell.setText(styledString.getString());
			cell.setStyleRanges(styledString.getStyleRanges());
			
		}
	}

}

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
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.services.RFSService;

public class RFSServiceTreeLabelProvider extends StyledCellLabelProvider {
	private IMapChangeListener mapChangeListener = new IMapChangeListener() {
		public void handleMapChange(MapChangeEvent event) {
			Set<?> affectedElements = event.diff.getChangedKeys();
			if (!affectedElements.isEmpty()) {
				LabelProviderChangedEvent newEvent = new LabelProviderChangedEvent(
						RFSServiceTreeLabelProvider.this,
						affectedElements.toArray());
				fireLabelProviderChanged(newEvent);
			}
		}
	};

	public RFSServiceTreeLabelProvider(IObservableMap... attributeMaps) {
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

		}
		if (element instanceof RFSService) {

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

/*******************************************************************************
 * Copyright (c) 24 mrt. 2014 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens.referenceNetwork;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ReferenceRelationship;
import com.netxforge.netxstudio.protocols.Message;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.services.ServiceFlowDirection;

/**
 * Binds a combobox cell editor to a feature.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class ComboBoxCellEditingSupport extends ObservableValueEditingSupport {

	/*
	 * Our Combo cell editor.
	 */
	private ComboBoxViewerCellEditor cellEditor;

	/*
	 * The editing domain for databinding.
	 */
	private EditingDomain editingDomain;

	private FeaturePath path;

	public ComboBoxCellEditingSupport(ColumnViewer viewer,
			DataBindingContext dbc, Composite control, EditingDomain domain,
			FeaturePath path) {
		super(viewer, dbc);

		this.editingDomain = domain;
		this.path = path;

		cellEditor = new ComboBoxViewerCellEditor(control, SWT.READ_ONLY);

		// TODO, In a better version, use the editing service adapterfactory for
		// naming.
		cellEditor.setLabelProvider(new LabelProvider() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof NodeType) {
					return ((NodeType) element).getName();
				} else if (element instanceof Protocol) {
					return ((Protocol) element).getName();
				} else if (element instanceof ReferenceRelationship) {

					ReferenceRelationship rel = (ReferenceRelationship) element;
					NodeType nt1 = rel.getRefInterface1Ref();
					NodeType nt2 = rel.getRefInterface2Ref();

					StringBuffer buf = new StringBuffer();
					buf.append(" (");
					buf.append(nt1 != null ? nt1.getName() : " ?");
					buf.append(" <--> ");
					buf.append(nt2 != null ? nt2.getName() : " ?");
					buf.append(")");

					String name = rel.getName();
					return name != null ? name : buf.toString();
				} else if (element instanceof ServiceFlowDirection) {
					switch (((ServiceFlowDirection) element).getValue()) {
					case ServiceFlowDirection.LEFTTORIGHT_VALUE: {
						return "-->";
					}
					case ServiceFlowDirection.RIGHTTOLEFT_VALUE: {
						return "<--";
					}
					}
				} else if (element instanceof Message) {
					Message m = (Message) element;
					String name = m.getName();
					return name;
				}
				return super.getText(element);
			}

		});
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		cellEditor.setContentProvider(listContentProvider);

	}

	public void setInput(IObservableList observableList) {
		cellEditor.setInput(observableList);
	}

	@Override
	protected IObservableValue doCreateCellEditorObservable(
			CellEditor cellEditor) {

		// Unchecked cast, we know the type of cell editor.
		final IViewerObservableValue observeSingleSelection = ViewersObservables
				.observeSingleSelection(((ComboBoxViewerCellEditor) cellEditor)
						.getViewer());

		return observeSingleSelection;

	}

	@Override
	protected IObservableValue doCreateElementObservable(Object element,
			ViewerCell cell) {

		System.out
				.println("ComboBoxCellEditing, create element observable called");

		// This will likely crash the cell editor, so do we have a NULL,
		// observable?
		return EMFEditProperties.value(editingDomain, path).observe(element);

	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		// For tree viewers, we might not want to return a cell editor for
		// certain columns,
		// if the element class is known.
		if (element instanceof EObject) {
			EObject targetObject = (EObject) element;
			if (path.getFeaturePath().length > 0) {
				// the first feature should be of the element class.
				if (targetObject.eClass().getEAllStructuralFeatures()
						.contains(path.getFeaturePath()[0])) {
					return cellEditor;
				}
			}
		}
		return null;
	}
}
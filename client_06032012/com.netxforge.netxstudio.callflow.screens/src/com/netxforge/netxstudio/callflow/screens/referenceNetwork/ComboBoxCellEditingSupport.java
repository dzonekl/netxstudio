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
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.services.ServiceFlowDirection;

/**
 * Binds a combobox cell editor to a feature.
 * 
 * 
 * @author Christophe
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
					return ((ReferenceRelationship) element).getName();
				} else if (element instanceof ServiceFlowDirection) {
					switch (((ServiceFlowDirection) element).getValue()) {
					case ServiceFlowDirection.LEFTTORIGHT_VALUE: {
						return "-->";
					}
					case ServiceFlowDirection.RIGHTTOLEFT_VALUE: {
						return "<--";
					}
					}
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
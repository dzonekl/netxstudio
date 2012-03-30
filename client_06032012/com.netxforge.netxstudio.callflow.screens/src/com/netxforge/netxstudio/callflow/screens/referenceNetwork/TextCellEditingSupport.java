package com.netxforge.netxstudio.callflow.screens.referenceNetwork;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Binds a text cell editor to a feature.
 * 
 * @author Christophe
 * 
 */
public class TextCellEditingSupport extends ObservableValueEditingSupport {

	/*
	 * Our Text cell editor.
	 */
	private TextCellEditor cellEditor;

	/*
	 * The editing domain for databinding.
	 */
	private EditingDomain editingDomain;

	private FeaturePath path;

	public TextCellEditingSupport(ColumnViewer viewer, DataBindingContext dbc,
			Composite control, EditingDomain domain, FeaturePath path) {
		super(viewer, dbc);

		this.editingDomain = domain;
		this.path = path;

		cellEditor = new TextCellEditor(control, SWT.NONE);
	}

	@Override
	protected IObservableValue doCreateCellEditorObservable(
			CellEditor cellEditor) {
		return SWTObservables
				.observeDelayedValue(100, SWTObservables.observeText(
						((TextCellEditor) cellEditor).getControl(), SWT.Modify));
	}

	@Override
	protected IObservableValue doCreateElementObservable(Object element,
			ViewerCell cell) {
		return EMFEditProperties.value(editingDomain, path).observe(element);

	}

	@Override
	protected CellEditor getCellEditor(Object element) {

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
package com.netxforge.netxstudio.screens.dialog;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;

public class NodeTypeCheckedSelectionDialog extends CheckedTreeSelectionDialog {

	public NodeTypeCheckedSelectionDialog(Shell parent,
			ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
		super(parent, labelProvider, contentProvider);
	}
	

	public static class NodeTypeLabelProvider extends AdapterFactoryLabelProvider {
		public NodeTypeLabelProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		@Override
		public String getText(Object object) {
			return super.getText(object);
		}
	}

	/**
	 * Input should be a Collection<?>
	 * 
	 * @author Christophe Bouhier
	 *
	 */
	public static class NodeTypeFlatContentProvider implements ITreeContentProvider {

		public void dispose() {
			// DO nothing. 
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			
			if(inputElement instanceof List<?>){
				return ((List<?>)inputElement).toArray();
			}
			return null;
		}

		public Object[] getChildren(Object parentElement) {
			return null; // We are flat. 
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return false; // We are flat. 
		}
		
	}
}

package com.netxforge.netxstudio.screens.f4;

import java.util.Set;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.screens.editing.IDataScreenInjection;

public class JobFailuresDialog extends Dialog implements IDataScreenInjection {
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private WorkFlowRun workflowRun;
	private Composite container;
	private ListViewer listViewer;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public JobFailuresDialog(Shell parentShell) {
		super(parentShell);
		setShellStyle(SWT.RESIZE);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		buildUI();
		initBindings();

		return container;
	}

	public void buildUI() {

		Form frmNewForm = formToolkit.createForm(container);
		frmNewForm.setSeparatorVisible(true);
		formToolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText("Job Failures");
		frmNewForm.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		listViewer = new ListViewer(frmNewForm.getBody(), SWT.BORDER
				| SWT.V_SCROLL);
		List list = listViewer.getList();
		listViewer.setUseHashlookup(true);
		listViewer.getList();

		Menu menu = new Menu(list);
		list.setMenu(menu);

		MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JobFailuresDialog.this.close();
				ISelection sel = listViewer.getSelection();
				if (sel instanceof IStructuredSelection) {
					Object first = ((IStructuredSelection) sel)
							.getFirstElement();
					if (first instanceof Failure) {
						// TODO, Decide how to redirect based on the different
						// failure types.

						if (first instanceof ExpressionFailure) {

						}

						if (first instanceof ComponentFailure) {

						}
						
					}
				}
			}
		});
		mntmNewItem.setText("Expression...");
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	public int open(Object object) {
		injectData(null, object);
		return super.open();
	}

	private void initBindings() {
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		listViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] { SchedulingPackage.Literals.FAILURE__MESSAGE });
		listViewer.setLabelProvider(new FailureObservableMapLabelProvider(
				observeMaps));
		IEMFListProperty l = EMFProperties
				.list(SchedulingPackage.Literals.COMPONENT_WORK_FLOW_RUN__FAILURE_REFS);
		listViewer.setInput(l.observe(workflowRun));

	}

	class FailureObservableMapLabelProvider extends ObservableMapLabelProvider {

		public FailureObservableMapLabelProvider(IObservableMap attributeMap) {
			super(attributeMap);
		}

		public FailureObservableMapLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public String getText(Object element) {

			if (element instanceof Failure) {
				Failure f = (Failure) element;

				return f.getMessage();
			}
			return super.getText(element);
		}

	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 400);
	}

	public void injectData(Object parent, Object object) {
		if (object instanceof WorkFlowRun) {
			workflowRun = (WorkFlowRun) object;
		}
	}
	public void injectData() {
	}

	public void injectData(Object... params) {
	}
	public void addData() {
		// N/A, This is a view.
	}

	public boolean shouldInjectForObject(Set<CDOObject> injectionSet) {
		return false;
	}
	
}

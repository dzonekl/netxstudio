package com.netxforge.netxstudio.screens.nf3;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.ch9.NewEditExpression;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class Retention extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Resource expressionsResource;
	private Form frmDataRetention;
	

	@Inject
	ServerRequest serverActions;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Retention(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		frmDataRetention = toolkit.createForm(this);
		frmDataRetention.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmDataRetention);
		frmDataRetention.setText("Data Retention");
		frmDataRetention.getBody().setLayout(new FormLayout());
		
		Section section = toolkit.createSection(frmDataRetention.getBody(), Section.TITLE_BAR);
		FormData fd_section = new FormData();
		fd_section.top = new FormAttachment(0, 10);
		fd_section.left = new FormAttachment(0, 10);
		fd_section.bottom = new FormAttachment(0, 337);
		fd_section.right = new FormAttachment(0, 595);
		section.setLayoutData(fd_section);
		toolkit.paintBordersFor(section);
		
		Composite composite = toolkit.createComposite(section, SWT.NONE);
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		
		ImageHyperlink mghprlnkEditRetentionExpression = toolkit.createImageHyperlink(composite, SWT.NONE);
		mghprlnkEditRetentionExpression.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				NewEditExpression expressionScreen =  new NewEditExpression(screenService.getScreenContainer(), SWT.NONE);
				expressionScreen.setOperation(Screens.OPERATION_EDIT);
				expressionScreen.setScreenService(screenService);
//				expressionScreen.injectData(owner, object)
				
				
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(mghprlnkEditRetentionExpression);
		mghprlnkEditRetentionExpression.setText("Edit retention expression");
		
		ImageHyperlink mghprlnkInvokeDataRetention = toolkit.createImageHyperlink(composite, SWT.NONE);
		mghprlnkInvokeDataRetention.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
					try {
						serverActions.setServer(editingService.getDataService().getProvider().getServer());
						// TODO, We get the workflow run ID back, which could be used
						// to link back to the screen showing the running workflows.
						
						@SuppressWarnings("unused")
						String result = serverActions.callRetentionAction();
						MessageDialog.openInformation(
								Retention.this.getShell(),
								"Data retention action invoked",
								"Clear data invoked on the server");

					} catch (Exception e1) {
						e1.printStackTrace();
						MessageDialog.openError(
								Retention.this.getShell(),
								"Data retention action failed:",
								"Collection of data from metric source: ");

					}
				
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(mghprlnkInvokeDataRetention);
		mghprlnkInvokeDataRetention.setText("Invoke data cleanup");

	}

	public EMFDataBindingContext initDataBindings_() {
		// TODO Auto-generated method stub
		return null;
	}

	public void injectData() {
		expressionsResource = editingService.getData(LibraryPackage.Literals.EXPRESSION);
	}

	public void disposeData() {
		editingService.disposeData(expressionsResource);
		
	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return this.frmDataRetention;
	}
}

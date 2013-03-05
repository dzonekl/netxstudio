package com.netxforge.netxstudio.screens.f4;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class NewEditMappingColumnDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private NewEditMappingColumn mappingColumnScreen;
//	private Composite canvas;
	private Composite canvas;
private Button cancelButton;
private Button okButton;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public NewEditMappingColumnDialog(Shell parent, int style) {
		super(parent, style);
		setText("Map a Single Column");
		createContents();
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		shell.pack();
		shell.open();
		shell.layout();
		
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setLocation(200, 100);
		shell.setSize(700, 313);
		shell.setText(getText());
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		canvas = new Composite(shell, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1,false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
//		gridLayout.marginLeft = 0;
//		gridLayout.marginRight = 0;
		
		canvas.setLayout(gridLayout);
//		this.getMappingColumnScreen();
	}

	public NewEditMappingColumn getMappingColumnScreen() {
		if( mappingColumnScreen == null){
			setMappingColumnScreen(new NewEditMappingColumn(
					canvas, getStyle()));
			mappingColumnScreen.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			
			
			Composite buttonComposite = toolkit.createComposite(canvas);
			toolkit.adapt(buttonComposite);
			toolkit.paintBordersFor(buttonComposite);
			
			buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			buttonComposite.setLayout(new 
					RowLayout());
			
			okButton = toolkit.createButton(buttonComposite, "Ok", SWT.PUSH);
			okButton.addSelectionListener(new SelectionAdapter(){

				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO, call addData from IScreen.  
//					mappingColumnScreen.addData();
					// should call save() from the screenService
				}
			});
			cancelButton = toolkit.createButton(buttonComposite, "Cancel", SWT.PUSH);
			cancelButton.addSelectionListener(new SelectionAdapter(){

				@Override
				public void widgetSelected(SelectionEvent e) {
					// Should call back() from the screenService and close. 
					shell.close();
				}
			});
			
			shell.setDefaultButton(okButton);
			
		}
		return mappingColumnScreen;
	}

	public void setMappingColumnScreen(NewEditMappingColumn mappingColumnScreen) {
		this.mappingColumnScreen = mappingColumnScreen;
	}

	
}

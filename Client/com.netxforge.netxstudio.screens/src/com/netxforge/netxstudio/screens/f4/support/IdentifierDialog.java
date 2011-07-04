package com.netxforge.netxstudio.screens.f4.support;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.common.collect.ImmutableList;
import com.netxforge.netxstudio.metrics.ObjectKindType;

public class IdentifierDialog extends Dialog {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	private int selection =  ObjectKindType.NODE_VALUE;

	private ListViewer attributeListViewer;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public IdentifierDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = formToolkit.createComposite(container, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new FormLayout());
		
		Section sctnNewSection = formToolkit.createSection(composite, Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(0, 10);
		fd_sctnNewSection.left = new FormAttachment(0, 10);
		fd_sctnNewSection.bottom = new FormAttachment(0, 135);
		fd_sctnNewSection.right = new FormAttachment(0, 395);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Identifier Type");
		
		Composite composite_1 = formToolkit.createComposite(sctnNewSection, SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));
		
		Button btnNode = formToolkit.createButton(composite_1, "NODE", SWT.RADIO);
		btnNode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selection = ObjectKindType.NODE_VALUE;
				updateAttributeView(selection);
			}
		});
		
		attributeListViewer = new ListViewer(composite_1, SWT.BORDER | SWT.V_SCROLL);
		List list = attributeListViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		attributeListViewer.setContentProvider(new ArrayContentProvider());
		attributeListViewer.setLabelProvider(new LabelProvider(){
			@Override
			public String getText(Object element) {
				return (String) element;
			}
		});
		list.addSelectionListener(new SelectionAdapter(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				System.out.println(e);
			}
			
		});
		
		
		Button btnEquipment = formToolkit.createButton(composite_1, "EQUIPMENT", SWT.RADIO);
		btnEquipment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selection = ObjectKindType.EQUIPMENT_VALUE;
				updateAttributeView(selection);
			}
		});
		
		Button btnFunction = formToolkit.createButton(composite_1, "FUNCTION", SWT.RADIO);
		btnFunction.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		btnFunction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selection = ObjectKindType.FUNCTION_VALUE;
				updateAttributeView(selection);
			}
		});
		
		btnNode.setSelection(true);
		
		Button btnRelationship =  formToolkit.createButton(composite_1, "RELATIONSHIP", SWT.RADIO);
		btnRelationship.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selection = ObjectKindType.RELATIONSHIP_VALUE;
				updateAttributeView(selection);
			}
		});
		updateAttributeView(selection);
		
		return container;
	}
	
	Iterable<String> nodeAttributes =  ImmutableList.of("NodeID");
	Iterable<String> relAttributes =  ImmutableList.of("Name", "Protocol");
	Iterable<String> functionAttributes =  ImmutableList.of("Name");
	Iterable<String> equipmentAttributes =  ImmutableList.of("Name", "EquipmentCode", "Position");
	
	public void updateAttributeView(int master){
		switch(master){
		case ObjectKindType.NODE_VALUE:{
			this.attributeListViewer.setInput(nodeAttributes);
		}break;
		case ObjectKindType.EQUIPMENT_VALUE:{
			this.attributeListViewer.setInput(equipmentAttributes);
		}break;
		case ObjectKindType.FUNCTION_VALUE:{
			this.attributeListViewer.setInput(functionAttributes);
		}break;
		case ObjectKindType.RELATIONSHIP_VALUE:{
			this.attributeListViewer.setInput(relAttributes);
		}break;
		}
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(405, 217);
	}
	
	public int getSelection(){
		return selection;
	}
}

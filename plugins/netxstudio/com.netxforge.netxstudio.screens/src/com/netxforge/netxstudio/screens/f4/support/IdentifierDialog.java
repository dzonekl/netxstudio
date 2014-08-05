package com.netxforge.netxstudio.screens.f4.support;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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

import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.metrics.ObjectKindType;

public class IdentifierDialog extends Dialog {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	private int objectKind = ObjectKindType.NODE_VALUE;
	private String objectAttribute = "";

	private ListViewer attributeListViewer;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public IdentifierDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = formToolkit.createComposite(container, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new FormLayout());

		Section sctnNewSection = formToolkit.createSection(composite,
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(0, 10);
		fd_sctnNewSection.left = new FormAttachment(0, 10);
		fd_sctnNewSection.bottom = new FormAttachment(0, 135);
		fd_sctnNewSection.right = new FormAttachment(0, 395);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Identifier Type");

		Composite composite_1 = formToolkit.createComposite(sctnNewSection,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Button btnNode = formToolkit.createButton(composite_1,
				"NETWORK ELEMENT", SWT.RADIO);
		btnNode.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true,
				1, 1));
		btnNode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				objectKind = ObjectKindType.NODE_VALUE;
				updateAttributeView(objectKind);
			}
		});

		attributeListViewer = new ListViewer(composite_1, SWT.BORDER
				| SWT.V_SCROLL);
		List list = attributeListViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		attributeListViewer.setContentProvider(new ArrayContentProvider());
		attributeListViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return (String) element;
			}
		});
		attributeListViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {

					public void selectionChanged(SelectionChangedEvent event) {
						System.out.println(event);
						ISelection sel = event.getSelection();
						if (sel instanceof IStructuredSelection) {
							objectAttribute = (String) ((IStructuredSelection) sel)
									.getFirstElement();
						}
					}
				});

		Button btnFunction = formToolkit.createButton(composite_1, "FUNCTION",
				SWT.RADIO);
		btnFunction.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				true, 1, 1));
		btnFunction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				objectKind = ObjectKindType.FUNCTION_VALUE;
				updateAttributeView(objectKind);
			}
		});

		btnNode.setSelection(true);

		Button btnEquipment = formToolkit.createButton(composite_1,
				"EQUIPMENT", SWT.RADIO);
		btnEquipment.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				true, 1, 1));
		btnEquipment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				objectKind = ObjectKindType.EQUIPMENT_VALUE;
				updateAttributeView(objectKind);
			}
		});

		Button btnRelationship = formToolkit.createButton(composite_1,
				"RELATIONSHIP", SWT.RADIO);
		btnRelationship.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				objectKind = ObjectKindType.RELATIONSHIP_VALUE;
				updateAttributeView(objectKind);
			}
		});

		updateAttributeView(objectKind);

		return container;
	}
	

	public void updateAttributeView(int master) {
		switch (master) {
		case ObjectKindType.NODE_VALUE: {
			this.attributeListViewer.setInput(StudioUtils.MAPPING_NODE_ATTRIBUTES);
		}
			break;
		case ObjectKindType.EQUIPMENT_VALUE: {
			this.attributeListViewer.setInput(StudioUtils.MAPPING_EQUIPMENT_ATTRIBUTES);
		}
			break;
		case ObjectKindType.FUNCTION_VALUE: {
			this.attributeListViewer.setInput(StudioUtils.MAPPING_FUNCTION_ATTRIBUTES);
		}
			break;
		case ObjectKindType.RELATIONSHIP_VALUE: {
			this.attributeListViewer.setInput(StudioUtils.MAPPING_REL_ATTRIBUTES);
		}
			break;
		}
		if (this.attributeListViewer.getList().getItemCount() > 0) {
			attributeListViewer.setSelection(new StructuredSelection(
					attributeListViewer.getList().getItem(0)));
		}

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

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(405, 217);
	}

	public int getObjectKind() {
		return objectKind;
	}

	public String getObjectAttribute() {
		return objectAttribute;
	}

	public void setObjectKind(int objectKind) {
		this.objectKind = objectKind;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Select the identifier type and attribute");
	}

}

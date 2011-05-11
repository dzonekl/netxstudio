package com.netxforge.netxstudio.emf.teneo.ui.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.netxforge.netxstudio.emf.teneo.ui.internal.Activator;


/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class DBPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	@Override
	protected Control createContents(Composite parent) {
		return super.createContents(parent);

	}

	public DBPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription(Messages.PersistencePreferencePage_0);

	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		this.createGroup(getFieldEditorParent());
	}

	/**
	 * Create the font and colour group for the preference page
	 * 
	 * @param parent
	 * @return composite fontAndColourGroup
	 */
	protected Composite createGroup(Composite parent) {

		Group group = new Group(parent, SWT.NONE);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		group.setLayout(new GridLayout(2, false));
		Composite composite = new Composite(group, SWT.NONE);
		GridLayout gridLayout = new GridLayout(2, false);
		composite.setLayout(gridLayout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		composite.setLayoutData(gridData);
		group.setText(Messages.PersistencePreferencePage_6);
		
		addField(new StringFieldEditor(TeneoPreferenceConstants.P_DB_SERVER,
				Messages.PersistencePreferencePage_1, composite));
		addField(new StringFieldEditor(TeneoPreferenceConstants.P_DB_NAME,
				Messages.PersistencePreferencePage_2, composite));
		addField(new StringFieldEditor(TeneoPreferenceConstants.P_DB_DRIVER,
				Messages.PersistencePreferencePage_3, composite));
		addField(new StringFieldEditor(TeneoPreferenceConstants.P_DB_DIALECT,
				Messages.PersistencePreferencePage_7, composite));
		addField(new StringFieldEditor(TeneoPreferenceConstants.P_DB_USER,
				Messages.PersistencePreferencePage_4, composite));
		
		StringFieldEditor passEditor = new StringFieldEditor(
				TeneoPreferenceConstants.P_DB_PASSWORD,
				Messages.PersistencePreferencePage_5, composite);
		addField(passEditor);
		
		
//		Button testConnection = new Button(composite, SWT.PUSH);
//		testConnection.setText("Test Connection");
//		testConnection.addSelectionListener(new SelectionListener(){
//
//			public void widgetDefaultSelected(SelectionEvent e) {
//				if (!HibernateFactory.getInstance().isConnected()) {
//					try {
//						HibernateFactory.getInstance().connectHibernate();
//					} catch (IllegalAccessException ex) {
//						ex.printStackTrace();
//					}
//				}
//			}
//
//			public void widgetSelected(SelectionEvent e) {
//				if (!HibernateFactory.getInstance().isConnected()) {
//					try {
//						HibernateFactory.getInstance().connectHibernate();
//					} catch (IllegalAccessException ex) {
//						ex.printStackTrace();
//					}
//				}
//			}
//			
//		});
		
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 8;
		composite.setLayout(layout);

		return group;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}

}
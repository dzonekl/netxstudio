package com.netxforge.netxstudio.screens.f2;

import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.nebula.widgets.formattedtext.NumberFormatter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.screens.editing.IEditingService;

public class CapacityEditingDialog extends Dialog {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Text txtCapacityValue;
	private ModelUtils modelUtils;
	private CDateTime dateTimeTo;
	private CDateTime dateTimeFrom;
	private List<Value> values;
	private FormattedText formattedText;
	private IEditingService editingService;
	private NetXResource res;

	/**
	 * 
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public CapacityEditingDialog(Shell parentShell, IEditingService editingService, ModelUtils modelUtils) {
		super(parentShell);
		this.editingService = editingService;
		this.modelUtils = modelUtils;
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

		Form frmCapacityValue = formToolkit.createForm(container);
		formToolkit.paintBordersFor(frmCapacityValue);
		frmCapacityValue.setText("Most recent Capacity Value");
		frmCapacityValue.getBody().setLayout(new GridLayout(2, false));

		Label lblValue = formToolkit.createLabel(frmCapacityValue.getBody(),
				"Value:", SWT.NONE);
		lblValue.setAlignment(SWT.RIGHT);
		GridData gd_lblValue = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblValue.widthHint = 70;
		lblValue.setLayoutData(gd_lblValue);

		formattedText = new FormattedText(frmCapacityValue.getBody(),
				SWT.BORDER | SWT.RIGHT);
		NumberFormatter numberFormatter = new NumberFormatter("###,###,##0.00");
		numberFormatter.setDecimalSeparatorAlwaysShown(true);
		formattedText.setFormatter(numberFormatter);
		txtCapacityValue = formattedText.getControl();
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 100;
		txtCapacityValue.setLayoutData(gd_text);
		txtCapacityValue.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				updateResult();
			}
		});

		Label lblAppliesFrom = formToolkit.createLabel(
				frmCapacityValue.getBody(), "From:", SWT.NONE);
		lblAppliesFrom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		dateTimeFrom = new CDateTime(frmCapacityValue.getBody(), CDT.BORDER
				| CDT.DROP_DOWN | CDT.DATE_MEDIUM);
		GridData gd_dateTimeFrom = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTimeFrom.widthHint = 100;
		dateTimeFrom.setLayoutData(gd_dateTimeFrom);
		formToolkit.adapt(dateTimeFrom);
		formToolkit.paintBordersFor(dateTimeFrom);
		dateTimeFrom.setSelection(modelUtils.oneMonthAgo());

		Label lblTo = formToolkit.createLabel(frmCapacityValue.getBody(),
				"To:", SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblTo.setAlignment(SWT.RIGHT);

		dateTimeTo = new CDateTime(frmCapacityValue.getBody(), CDT.BORDER
				| CDT.DROP_DOWN | CDT.DATE_MEDIUM);
		GridData gd_dateTimeTo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTimeTo.widthHint = 100;
		dateTimeTo.setLayoutData(gd_dateTimeTo);
		formToolkit.adapt(dateTimeTo);
		formToolkit.paintBordersFor(dateTimeTo);
		dateTimeTo.setSelection(modelUtils.todayAndNow());

		init();

		return container;
	}

	private void init() {

		// get the last two capacity values and set the date choosers, if the
		// values are
		// the same.

		if (values != null && values.size() >= 2) {
			Value v1 = values.get(0);
			Value v2 = values.get(1);
			if (v1.getValue() == v2.getValue()) {
				Date v1Date = modelUtils.fromXMLDate(v1.getTimeStamp());
				Date v2Date = modelUtils.fromXMLDate(v2.getTimeStamp());
				dateTimeTo.setSelection(v1Date);
				dateTimeFrom.setSelection(v2Date);
				formattedText.setValue(v2.getValue());

			}
		}

		dateTimeTo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateResult();
			}

		});
		dateTimeFrom.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateResult();
			}

		});
	}

	public void injectData(NetXResource resource) {
		this.res = resource;
		values = resource.getCapacityValues();
		this.values = modelUtils.sortValuesByTimeStamp(values);
	}

	public List<Value> getResult() {
		return this.values;
	}

	public void updateResult() {

		Date fromTS = this.dateTimeFrom.getSelection();
		Date toTS = this.dateTimeTo.getSelection();
		Object value = formattedText.getValue();

		double doubleValue = 0.0;
		if (value instanceof Long) {
			doubleValue = ((Long) value).doubleValue();
		} else if (value instanceof Double) {
			doubleValue = (Double) value;
		}

		try {
			if (fromTS != null && toTS != null && doubleValue != 0.0) {

				// Either replace the last two values (If equal, as these would
				// have been set when init the dialog).
				if (this.lastTwoValuesEqual()) {
					this.setLastTwoValues(doubleValue, fromTS, doubleValue,
							toTS);
				} else {
					Value fromValue = GenericsFactory.eINSTANCE.createValue();
					fromValue.setTimeStamp(modelUtils.toXMLDate(fromTS));
					fromValue.setValue(doubleValue);

					Value toValue = GenericsFactory.eINSTANCE.createValue();
					toValue.setTimeStamp(modelUtils.toXMLDate(toTS));
					toValue.setValue(doubleValue);
					values.add(fromValue);
					values.add(toValue);
				}

			}

		} catch (NumberFormatException nfe) {
			// Can't create value.
		}

	}

	
	
	
	
	@Override
	protected void okPressed() {
		// Commit. 
		
		res.getCapacityValues().clear();
		res.getCapacityValues().addAll(values);
		
		if(editingService != null && editingService.isDirty()){
			editingService.doSave(new NullProgressMonitor());
		}
		
		super.okPressed();
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
		return new Point(364, 193);
	}

	public boolean lastTwoValuesEqual() {
		if (values != null && values.size() >= 2) {
			Value v1 = values.get(0);
			Value v2 = values.get(1);
			if (v1.getValue() == v2.getValue()) {
				return true;
			}
		}
		return false;
	}

	public void setLastTwoValues(double from, Date fromTS, double to, Date toTS) {
		if (values != null && values.size() >= 2) {
			Value v1 = values.get(0); // to value
			Value v2 = values.get(1); // from value
			if (v1.getValue() == v2.getValue()) {
				v1.setTimeStamp(modelUtils.toXMLDate(toTS));
				v1.setValue(to);

				v2.setTimeStamp(modelUtils.toXMLDate(fromTS));
				v2.setValue(from);
			}
		}
	}

}

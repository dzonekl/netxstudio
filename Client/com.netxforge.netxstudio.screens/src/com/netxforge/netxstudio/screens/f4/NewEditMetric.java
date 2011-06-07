package com.netxforge.netxstudio.screens.f4;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

public class NewEditMetric extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtNewText;
	private Text text;
	private Text text_1;
	private Text txtNewText_1;
	private Text text_2;
	private Text text_3;

	 /**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewEditMetric(Composite parent, int style) {
		this(parent, style, null);
	}
	
	public NewEditMetric(Composite parent, int style, IEditingService eService) {
		super(parent, style, eService);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);	
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmNewMappingColumn = toolkit.createForm(this);
		frmNewMappingColumn.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewMappingColumn);
		frmNewMappingColumn.setText("New Metric");
		frmNewMappingColumn.getBody().setLayout(new FormLayout());
		
		Composite composite = toolkit.createComposite(frmNewMappingColumn.getBody(), SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite = new FormData();
		fd_composite.right = new FormAttachment(100);
		fd_composite.bottom = new FormAttachment(0, 16);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		toolkit.paintBordersFor(composite);
		
		Label lblNewLabel = toolkit.createLabel(composite, "Data Entry Feedback", SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(154, 205, 50));
		lblNewLabel.setAlignment(SWT.CENTER);
		
		Section sctnMappings = toolkit.createSection(frmNewMappingColumn.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnMappings = new FormData();
		fd_sctnMappings.top = new FormAttachment(composite, 12);
		fd_sctnMappings.bottom = new FormAttachment(100, -12);
		fd_sctnMappings.right = new FormAttachment(100, -12);
		fd_sctnMappings.left = new FormAttachment(0, 12);
		sctnMappings.setLayoutData(fd_sctnMappings);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");
		
		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(3, false));
		
		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text = toolkit.createText(composite_1, "New Text", SWT.NONE);
		text.setText("");
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_text.widthHint = 150;
		text.setLayoutData(gd_text);
		
		Label lblDescription = toolkit.createLabel(composite_1, "Description:", SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		
		txtNewText = toolkit.createText(composite_1, "New Text", SWT.WRAP | SWT.MULTI);
		txtNewText.setText("");
		GridData gd_txtNewText = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		gd_txtNewText.heightHint = 57;
		txtNewText.setLayoutData(gd_txtNewText);
		
		Label lblNewLabel_1 = toolkit.createLabel(composite_1, "Unit:", SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text_1 = toolkit.createText(composite_1, "New Text", SWT.NONE);
		text_1.setText("");
		GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 50;
		text_1.setLayoutData(gd_text_1);
		
		Button btnSelect = toolkit.createButton(composite_1, "Select", SWT.NONE);
		
		ExpandableComposite xpndblcmpstMore = toolkit.createExpandableComposite(composite_1, ExpandableComposite.TREE_NODE);
		xpndblcmpstMore.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 3, 1));
		toolkit.paintBordersFor(xpndblcmpstMore);
		xpndblcmpstMore.setText("more...");
		xpndblcmpstMore.setExpanded(true);
		
		Composite composite_3 = toolkit.createComposite(xpndblcmpstMore, SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		xpndblcmpstMore.setClient(composite_3);
		composite_3.setLayout(new GridLayout(2, false));
		
		Label lblMeasurementPoint = toolkit.createLabel(composite_3, "Measurement Point:", SWT.WRAP);
		GridData gd_lblMeasurementPoint = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_lblMeasurementPoint.widthHint = 78;
		lblMeasurementPoint.setLayoutData(gd_lblMeasurementPoint);
		
		txtNewText_1 = toolkit.createText(composite_3, "New Text", SWT.WRAP | SWT.MULTI);
		GridData gd_txtNewText_1 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_txtNewText_1.heightHint = 70;
		txtNewText_1.setLayoutData(gd_txtNewText_1);
		txtNewText_1.setText("");
		
		Label lblMeasurementKind = toolkit.createLabel(composite_3, "Measurement Kind:", SWT.WRAP);
		GridData gd_lblMeasurementKind = new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1);
		gd_lblMeasurementKind.widthHint = 78;
		lblMeasurementKind.setLayoutData(gd_lblMeasurementKind);
		
		text_2 = toolkit.createText(composite_3, "New Text", SWT.WRAP | SWT.MULTI);
		text_2.setText("");
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_text_2.heightHint = 70;
		text_2.setLayoutData(gd_text_2);
		
		Label lblExpression = toolkit.createLabel(composite_3, "Expression:", SWT.NONE);
		lblExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		
		text_3 = toolkit.createText(composite_3, "New Text", SWT.WRAP | SWT.MULTI);
		text_3.setText("");
		GridData gd_text_3 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_3.heightHint = 70;
		text_3.setLayoutData(gd_text_3);
	}

	public EMFDataBindingContext initDataBindings_() {
		// TODO Auto-generated method stub
		return null;
	}

	public void injectData(Object owner, Object object) {
		// TODO Auto-generated method stub
		
	}

	public void addData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Viewer getViewer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Form getScreenForm() {
		// TODO Auto-generated method stub
		return null;
	}
}

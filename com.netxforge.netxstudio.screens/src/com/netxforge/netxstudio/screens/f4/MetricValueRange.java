package com.netxforge.netxstudio.screens.f4;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.swtchart.Chart;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries;

public class MetricValueRange extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text text;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MetricValueRange(Composite parent, int style) {
		super(parent, SWT.BORDER);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmFunction = toolkit.createForm(this);
		frmFunction.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmFunction);
		frmFunction.setText("Metric Value Range");
		frmFunction.getBody().setLayout(new FormLayout());
		
		Section sctnInfo = toolkit.createSection(frmFunction.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.bottom = new FormAttachment(0, 145);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");
		
		Composite composite = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		
		Label lblPeriod = toolkit.createLabel(composite, "Period (min):", SWT.NONE);
		lblPeriod.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text = toolkit.createText(composite, "New Text", SWT.READ_ONLY);
		text.setText("");
		
		Label lblType = toolkit.createLabel(composite, "Type (AVG / BH):", SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text_1 = toolkit.createText(composite, "New Text", SWT.READ_ONLY);
		text_1.setText("");
		
		FormText formText = toolkit.createFormText(frmFunction.getBody(), false);
		fd_sctnInfo.top = new FormAttachment(formText, 15);
		FormData fd_formText = new FormData();
		fd_formText.bottom = new FormAttachment(0, 40);
		fd_formText.right = new FormAttachment(100, -12);
		fd_formText.top = new FormAttachment(0, 12);
		fd_formText.left = new FormAttachment(0, 12);
		formText.setLayoutData(fd_formText);
		toolkit.paintBordersFor(formText);
		formText.setText("<form><p>A Metric value range is automaticly created by the <b>M</b>etric <b>C</b>ollection engine.</p></form>", true, false);
		
		// Manually coded SWT Chart.
		// TODO, put this in a factory? 
		
		Composite chartComposite = toolkit.createComposite(frmFunction.getBody(), SWT.NONE);
		chartComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_chartComposite = new FormData();
		fd_chartComposite.top = new FormAttachment(sctnInfo, 12);
		fd_chartComposite.right = new FormAttachment(100, -12);
		fd_chartComposite.bottom = new FormAttachment(100, -12);
		fd_chartComposite.left = new FormAttachment(0, 12);
		chartComposite.setLayoutData(fd_chartComposite);
		toolkit.paintBordersFor(chartComposite);
		
		
		double[] ySeries = { 0.3, 1.4, 1.3, 1.9, 2.1 };
		Chart chart = new Chart(chartComposite, SWT.NONE);
	
		chart.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		chart.getTitle().setVisible(false);
		chart.getAxisSet().getXAxis(0).getTitle().setText("Data Points");
		chart.getAxisSet().getYAxis(0).getTitle().setText("Amplitude");

		// create line series
		ILineSeries lineSeries = (ILineSeries) chart.getSeriesSet()
		    .createSeries(ISeries.SeriesType.LINE, "line series");
		lineSeries.setYSeries(ySeries);
		
		
		// adjust the axis range
		chart.getAxisSet().adjustRange();
		
		
	}
}

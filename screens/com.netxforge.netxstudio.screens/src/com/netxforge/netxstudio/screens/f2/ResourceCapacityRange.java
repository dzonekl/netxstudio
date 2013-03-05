package com.netxforge.netxstudio.screens.f2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.swtchart.Chart;
import org.swtchart.IAxisTick;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries;

public class ResourceCapacityRange extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtNewText;
	private Text txtNewText_1;
	private Chart chart;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	@SuppressWarnings("unused")
	public ResourceCapacityRange(Composite parent, int style) {
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
		frmFunction.setText("Resource Capacity Range");
		frmFunction.getBody().setLayout(new FormLayout());

		FormText formText = toolkit
				.createFormText(frmFunction.getBody(), false);
		FormData fd_formText = new FormData();
		fd_formText.bottom = new FormAttachment(0, 50);
		fd_formText.right = new FormAttachment(100, -12);
		fd_formText.top = new FormAttachment(0, 12);
		fd_formText.left = new FormAttachment(0, 12);
		formText.setLayoutData(fd_formText);
		toolkit.paintBordersFor(formText);
		formText.setText(
				"<form><p>The resource capacity value is derived from an expression, constituting the capacity from the installed HW , usage profile etc... The range shows these values over time.</p></form>",
				true, false);

		Section sctnInfo = toolkit.createSection(frmFunction.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(formText, 15);
		fd_sctnInfo.bottom = new FormAttachment(0, 150);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");

		Composite composite = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblStartsOn = toolkit.createLabel(composite, "Starts On:",
				SWT.NONE);
		lblStartsOn.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtNewText = toolkit.createText(composite, "New Text", SWT.READ_ONLY);
		txtNewText.setText("");
		txtNewText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Label lblEndsOn = toolkit.createLabel(composite, "Ends On:", SWT.NONE);
		lblEndsOn.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtNewText_1 = toolkit.createText(composite, "New Text", SWT.READ_ONLY);
		txtNewText_1.setText("");

		Section sctnPeriod = toolkit.createSection(frmFunction.getBody(),
				Section.EXPANDED | Section.TREE_NODE | Section.TITLE_BAR);
		FormData fd_sctnPeriod = new FormData();
		fd_sctnPeriod.bottom = new FormAttachment(100, -12);
		fd_sctnPeriod.right = new FormAttachment(100, -12);
		fd_sctnPeriod.top = new FormAttachment(sctnInfo, 12);
		fd_sctnPeriod.left = new FormAttachment(sctnInfo, 0, SWT.LEFT);
		sctnPeriod.setLayoutData(fd_sctnPeriod);
		toolkit.paintBordersFor(sctnPeriod);
		sctnPeriod.setText("Show Capacity Values:");

		Composite composite_2 = toolkit.createComposite(sctnPeriod, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnPeriod.setClient(composite_2);
		composite_2.setLayout(new GridLayout(4, false));

		Label lblFromDate = toolkit.createLabel(composite_2, "From:", SWT.NONE);

		DateChooserCombo dateChooserCombo = new DateChooserCombo(composite_2,
				SWT.BORDER | SWT.FLAT);
		dateChooserCombo.setWeeksVisible(true);
		GridData gd_dateChooserCombo = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_dateChooserCombo.heightHint = 19;
		dateChooserCombo.setLayoutData(gd_dateChooserCombo);
		toolkit.adapt(dateChooserCombo);
		toolkit.paintBordersFor(dateChooserCombo);

		Composite compositeScrollStick = toolkit.createComposite(composite_2,
				SWT.NO_BACKGROUND);
		compositeScrollStick.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 2, 2));
		toolkit.paintBordersFor(compositeScrollStick);
		GridLayout gl_compositeScrollStick = new GridLayout(3, false);
		gl_compositeScrollStick.marginTop = 3;
		gl_compositeScrollStick.verticalSpacing = 0;
		gl_compositeScrollStick.marginWidth = 0;
		gl_compositeScrollStick.marginHeight = 0;
		gl_compositeScrollStick.horizontalSpacing = 0;
		compositeScrollStick.setLayout(gl_compositeScrollStick);

		new Label(compositeScrollStick, SWT.NONE);
		Button btnUpScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.UP);
		btnUpScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getYAxis(0).scrollUp();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);

		Button btnLeftScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.LEFT);
		btnLeftScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getXAxis(0).scrollDown();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);
		Button btnRightScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.RIGHT);
		btnRightScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getXAxis(0).scrollUp();
				getChart().redraw();
			}
		});

		new Label(compositeScrollStick, SWT.NONE);
		Button btnDownScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.DOWN);
		btnDownScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getYAxis(0).scrollDown();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);

		Label lblToDate = toolkit.createLabel(composite_2, "To:", SWT.NONE);
		lblToDate.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		DateChooserCombo dateChooserCombo_1 = new DateChooserCombo(composite_2,
				SWT.BORDER | SWT.FLAT);
		dateChooserCombo_1.setWeeksVisible(true);
		GridData gd_dateChooserCombo_1 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_dateChooserCombo_1.heightHint = 19;
		dateChooserCombo_1.setLayoutData(gd_dateChooserCombo_1);
		toolkit.adapt(dateChooserCombo_1);
		toolkit.paintBordersFor(dateChooserCombo_1);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		// Manually coded SWT Chart.
		// TODO, put this in a factory?

		// Demo values. Use Databinding !
		long ts = System.currentTimeMillis();
		double v = 10;
		int ticks = 30;
		List<Date> dates = new ArrayList<Date>();
		double[] ySeries = new double[ticks];
		for (int i = 0; i < ticks; i++) {
			// x
			ts += (1000 * 60) * 15;
			dates.add(new Date(ts));
			// y
			v += 1;
			ySeries[i] = v;
		}

		Date[] xSeries = new Date[ticks];
		dates.toArray(xSeries);
		new Label(composite_2, SWT.NONE);

		chart = new Chart(composite_2, SWT.NONE);
		chart.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));

		chart.setBackground(Display.getDefault()
				.getSystemColor(SWT.COLOR_WHITE));

		chart.getTitle().setVisible(false);

		chart.getAxisSet().getXAxis(0).getTitle().setText("Time stamps");
		chart.getAxisSet().getYAxis(0).getTitle().setText("Value");

		// create line series
		ILineSeries lineSeries = (ILineSeries) chart.getSeriesSet()
				.createSeries(ISeries.SeriesType.LINE, "line series");
		lineSeries.enableStep(true);
		
		IAxisTick xTick = chart.getAxisSet().getXAxis(0).getTick();
		// ILineSeries xLineSeries = (ILineSeries) chart.getSeriesSet()
		// .createSeries(ISeries.SeriesType.LINE, "X line series");
		lineSeries.setXDateSeries(xSeries); // xSeries is an array of
											// java.util.Date
		xTick.setTickMarkStepHint(20);

		DateFormat format = new SimpleDateFormat("HH:mm");
		xTick.setFormat(format);
		
		lineSeries.setYSeries(ySeries);
		
		// adjust the axis range
		chart.getAxisSet().adjustRange();

		Button btnZoomIn = toolkit.createButton(composite_2, "Z+", SWT.NONE);
		btnZoomIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().zoomIn();
				getChart().redraw();
			}
		});
		GridData gd_btnZoomIn = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_btnZoomIn.widthHint = 24;
		gd_btnZoomIn.heightHint = 18;
		btnZoomIn.setLayoutData(gd_btnZoomIn);

		Button btnZoomOut = toolkit.createButton(composite_2, "Z-", SWT.NONE);
		btnZoomOut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().zoomOut();
				getChart().redraw();
			}
		});
		GridData gd_btnZoomOut = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_btnZoomOut.widthHint = 24;
		gd_btnZoomOut.heightHint = 18;
		btnZoomOut.setLayoutData(gd_btnZoomOut);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
	}

	public Chart getChart() {
		return chart;
	}

}

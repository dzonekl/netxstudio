/*******************************************************************************
 * Copyright (c) 27 jan. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f3.charts;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.ComputedList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.ToleranceMarker;
import com.netxforge.screens.editing.base.tables.TableHelper;
import com.netxforge.screens.editing.base.tables.TableHelper.TBVCFeatureSorter;

/**
 * A UI compoment for showing markers.
 * 
 * @author Christophe
 * 
 */
public class ChartMarkerComponent {

	private TableHelper tableHelper;

	private TableViewer markersTableViewer;

	private Table table;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	@Inject
	public ChartMarkerComponent(TableHelper tableHelper) {
		this.tableHelper = tableHelper;
	}

	public void buildUI(Composite parent, Object layoutData) {
		buildMarkersUI(parent, layoutData);
	}

	private void buildMarkersUI(Composite parent, Object layoutData) {

		Section sctnMarkers = toolkit.createSection(parent, Section.TWISTIE
				| Section.TITLE_BAR);

		toolkit.paintBordersFor(sctnMarkers);
		sctnMarkers.setText("Markers");
		sctnMarkers.setExpanded(false);

		Composite composite = toolkit.createComposite(sctnMarkers, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnMarkers.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

		markersTableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);

		// CB Let the screen implement the listener.
		// markersTableViewer
		// .addSelectionChangedListener(new ISelectionChangedListener() {
		//
		// public void selectionChanged(SelectionChangedEvent event) {
		// ISelection selection = event.getSelection();
		// if (selection instanceof IStructuredSelection) {
		// Object firstElement = ((IStructuredSelection) selection)
		// .getFirstElement();
		// if (firstElement instanceof ToleranceMarker) {
		// smartResourceChart
		// .showHover((ToleranceMarker) firstElement);
		// }
		// }
		//
		// }
		// });
		table = markersTableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		GridData gdMarkers = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gdMarkers.heightHint = 250;
		table.setLayoutData(gdMarkers);
		toolkit.paintBordersFor(table);

		{ // Column 1.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer, "Type",
					"Marker Type", 125, null,
					new TableHelper.ComparableComparator<String>());
		}

		{ // Column 2.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer,
					"Description", "Additional description for the Marker",
					200, null, new TableHelper.ComparableComparator<String>());
		}

		{ // Column 3.
			TableViewerColumn tbvcFor = tableHelper.new TBVC<Date>().tbvcFor(
					markersTableViewer, "TimeStamp",
					"The date and time the Marker occurred", 140,
					(EditingSupport) null);

			TBVCFeatureSorter<Value> tbvcFeatureSorter = tableHelper.new TBVCFeatureSorter<Value>(
					tbvcFor, OperatorsPackage.Literals.MARKER__VALUE_REF,
					StudioUtils.valueTimeStampCompare());
			tbvcFeatureSorter.setSorter(TBVCFeatureSorter.DESC);
		}

		{ // Column 4.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer, "Value",
					"The marked Value.", 100, null,
					new TableHelper.ComparableComparator<String>());
		}

		{ // Column 5.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer,
					"Direction", "The direction in which the Value moves.",
					100, null, new TableHelper.ComparableComparator<String>());
		}

		{ // Column 6.
			tableHelper.new TBVC<String>().tbvcFor(markersTableViewer, "Level",
					"The Marker level.", 100, null,
					new TableHelper.ComparableComparator<String>());
		}
	}

	public void initMarkersBindingCollection() {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		markersTableViewer.setContentProvider(listContentProvider);

		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						OperatorsPackage.Literals.MARKER__KIND,
						OperatorsPackage.Literals.MARKER__DESCRIPTION,
						OperatorsPackage.Literals.MARKER__VALUE_REF,
						OperatorsPackage.Literals.TOLERANCE_MARKER__DIRECTION,
						OperatorsPackage.Literals.TOLERANCE_MARKER__LEVEL });

		markersTableViewer
				.setLabelProvider(new MarkersObervableMapLabelProvider(
						observeMaps));

		ComputedList markersList = new ComputedList() {

			@SuppressWarnings("rawtypes")
			@Override
			protected List calculate() {
				return Collections.EMPTY_LIST;

				// FIXME Get rid of markers view, or base on aggregate of
				// resources shown by the
				// chart.
				// return chartModel.getMarkers();
			}

		};

		markersTableViewer.setInput(markersList);
	}

	public class MarkersObervableMapLabelProvider extends
			ObservableMapLabelProvider {

		public MarkersObervableMapLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return super.getColumnImage(element, columnIndex);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof ToleranceMarker) {
				ToleranceMarker rm = (ToleranceMarker) element;
				switch (columnIndex) {
				case 0:
					return rm.getKind().getName();
				case 1:
					return rm.getDescription();
				case 2:

					return NonModelUtils.date(NonModelUtils.fromXMLDate(rm
							.getValueRef().getTimeStamp()))
							+ "@"
							+ NonModelUtils.time(NonModelUtils.fromXMLDate(rm
									.getValueRef().getTimeStamp()));
				case 3:
					double value = rm.getValueRef().getValue();
					if (value != -1) {
						DecimalFormat numberFormatter = new DecimalFormat(
								"###,###,##0.00");
						numberFormatter.setDecimalSeparatorAlwaysShown(true);
						return numberFormatter.format(value);
					} else {
						return "invalid";
					}
				case 4:
					return rm.getDirection().getLiteral();
				case 5:
					return rm.getLevel().getLiteral();
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void dispose() {

	}

}

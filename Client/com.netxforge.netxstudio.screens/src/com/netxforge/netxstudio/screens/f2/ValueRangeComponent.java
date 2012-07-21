/*******************************************************************************
 * Copyright (c) Jul 1, 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f2;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;

/**
 * An injectable component showing a select for the value ranges in the target
 * {@link com.netxforge.netxstudio.library.NetXResource}
 * 
 * @author Christophe
 * 
 */
public class ValueRangeComponent {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private ModelUtils modelUtils;

	private Composite cmpValueRange;

	/*
	 * Defaults to show a border.
	 */
	private boolean showBorder = true;

	private ComboViewer cmbViewerValueRange;

	/*
	 * The selected metric value range.
	 */
	protected MetricValueRange mvr;

	@Inject
	public ValueRangeComponent(ModelUtils modelUtils) {
		super();
		this.modelUtils = modelUtils;
	}

	public void setShowBorder(boolean showBorder) {
		this.showBorder = showBorder;
	}

	public void buildUI(Composite parent, Object layoutData) {

		cmpValueRange = toolkit.createComposite(parent, showBorder ? SWT.BORDER
				: SWT.NONE);

		toolkit.adapt(cmpValueRange);

		if (layoutData != null) {
			cmpValueRange.setLayoutData(layoutData);
		}

		GridLayout periodGridLayout = new GridLayout();
		periodGridLayout.numColumns = 2;
		cmpValueRange.setLayout(periodGridLayout);

		Label createLabel = toolkit.createLabel(cmpValueRange,
				"Select the range: ");
		createLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1));

		cmbViewerValueRange = new ComboViewer(cmpValueRange, SWT.READ_ONLY);
		// cmbViewerValueRange.getCombo().setLayoutData(new GridData(SWT.LEFT,
		// SWT.CENTER));
	}

	public void setNetXResource(NetXResource resource) {
		cmbViewerValueRange.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return super.getText(element);
			}
		});
		cmbViewerValueRange.setContentProvider(new ArrayContentProvider() {
			List<String> content = Lists.newArrayList();

			@Override
			public Object[] getElements(Object inputElement) {

				if (inputElement instanceof NetXResource) {
					for (MetricValueRange mvr : ((NetXResource) inputElement)
							.getMetricValueRanges()) {
						StringBuffer sb = new StringBuffer();
						sb.append("range for: "
								+ modelUtils.fromSeconds(mvr.getIntervalHint()));
						sb.append(" values = " + mvr.getMetricValues().size()); //
						content.add(sb.toString());
					}
				}
				return super.getElements(inputElement);
			}
		});
		cmbViewerValueRange
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						if (event.getSelection() instanceof IStructuredSelection) {
							IStructuredSelection ss = (IStructuredSelection) event
									.getSelection();
							mvr = (MetricValueRange) ss.getFirstElement();
						}
					}
				});

	}

	public MetricValueRange getValueRange() {
		return mvr;
	}
}

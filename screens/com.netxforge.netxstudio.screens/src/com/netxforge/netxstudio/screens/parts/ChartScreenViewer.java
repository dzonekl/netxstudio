/*******************************************************************************
 * Copyright (c) 5 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.parts;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.IChartModel;
import com.netxforge.netxstudio.common.model.IChartResource;
import com.netxforge.netxstudio.screens.editing.AbstractScreenViewer;
import com.netxforge.netxstudio.screens.editing.IScreen;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.f3.charts.ChartModelDialog;
import com.netxforge.netxstudio.screens.f3.charts.ChartScreen;

/**
 * A Chart screen in a viewer.
 * 
 * @author Christophe Bouhier
 * 
 */
public class ChartScreenViewer extends AbstractScreenViewer {

	private ChartScreen chartScreen;

	/**
	 * An {@link IAction} for synchronizing screens.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class SumChartsAction extends Action {
		public SumChartsAction(String text) {
			super(text, SWT.TOGGLE);
		}

		public void run() {
			// TODO, turn on toggel to sum the selection of resources.
			System.out
					.println("TODO, turn on toggel to sum the selection of resources.");
		}
	}

	/**
	 * An {@link IAction} for synchronizing screens.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class TrendChartsAction extends Action {
		public TrendChartsAction(String text) {
			super(text, SWT.TOGGLE);
		}

		public void run() {
			// TODO, turn on toggel to trend the selection of resources.
			System.out
					.println("TODO, turn on toggle to trend the selection of resources.");
		}
	}

	/**
	 * An {@link IAction} for editing the {@link IChartModel}
	 * 
	 * @author Christophe Bouhier
	 */
	public class EditChartsAction extends Action {

		public EditChartsAction(String text) {
			super(text, SWT.PUSH);
		}

		public void run() {

			IChartModel chartModel = chartScreen.getChartModel();

			final ChartModelDialog chartModelDialog = new ChartModelDialog(
					ChartScreenViewer.this.getSite().getShell(),
					new ChartModelLabelProvider(), new ArrayContentProvider() {
						@Override
						public Object[] getElements(Object inputElement) {

							if (inputElement instanceof IChartModel) {
								IChartModel chartModel = (IChartModel) inputElement;
								return chartModel.getChartResources().toArray();
							}
							return super.getElements(inputElement);
						}
					});

			chartModelDialog.setInput(chartModel);

			chartModelDialog.setInitialSelections(chartModel
					.getChartNonFilteredResources().toArray());
			if (chartModelDialog.open() == Window.OK) {
				List<Object> selection = Lists.newArrayList(chartModelDialog
						.getResult());
				// update the chartModel with this selection, reinitialize
				// the chart.
				for (IChartResource cr : chartModel.getChartResources()) {
					if (!selection.contains(cr)) {
						cr.setFiltered(true);
					} else {
						cr.setFiltered(false);
					}
				}
				chartScreen.reinit();
			}
		}

		public class ChartModelLabelProvider extends LabelProvider implements
				ITableLabelProvider {
			@Override
			public String getText(Object element) {

				return super.getText(element);
			}

			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}

			public String getColumnText(Object element, int columnIndex) {
				if (element instanceof IChartResource) {
					IChartResource cr = (IChartResource) element;
					return cr.getNetXResource().getShortName();
				}
				return null;
			}
		}

	}

	public IScreen getScreen() {
		return chartScreen;
	}

	public void initScreen(Composite parent) {
		chartScreen = new ChartScreen(parent, SWT.NONE);
		chartScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
		chartScreen.setEditingService(getEditingService());
		chartScreen.buildUI();

		for (IAction action : getActions()) {
			getViewSite().getActionBars().getToolBarManager().add(action);
		}
	}

	public IAction[] getActions() {
		List<IAction> chartViewerActions = Lists.newArrayList();
		chartViewerActions.add(new EditChartsAction("Resource..."));
		chartViewerActions.add(new SumChartsAction("Sum"));
		chartViewerActions.add(new TrendChartsAction("Trend"));
		return chartViewerActions
				.toArray(new IAction[chartViewerActions.size()]);

	}

	@SuppressWarnings("unchecked")
	protected void processSelection(ISelection selection) {
		if (selection != null && !selection.isEmpty()
				&& selection instanceof StructuredSelection) {
			IStructuredSelection ss = (StructuredSelection) selection;

			if (!chartScreen.isDisposed()) {// Closing a view will dispose it!
				chartScreen.injectData(Lists.newArrayList(ss.iterator())
						.toArray());
			}
		}
	}

	@Override
	protected void customPartHook(IWorkbenchPart part, PART_EVENT event) {
		super.customPartHook(part, event);
		// hide the markers.
		chartScreen.focusLost(null);
	}

}

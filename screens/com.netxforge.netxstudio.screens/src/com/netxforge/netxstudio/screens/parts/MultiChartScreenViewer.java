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

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
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
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.IChartModel;
import com.netxforge.netxstudio.common.model.IChartResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.screens.editing.AbstractScreenViewer;
import com.netxforge.netxstudio.screens.editing.IScreen;
import com.netxforge.netxstudio.screens.editing.ScreenDropTargetAdapter;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.util.WinForms;
import com.netxforge.netxstudio.screens.f2.RangeSelectionDialog;
import com.netxforge.netxstudio.screens.f3.charts.ChartModelDialog;
import com.netxforge.netxstudio.screens.f3.charts.ChartScreen;
import com.netxforge.netxstudio.screens.showins.ChartInput;
import com.netxforge.netxstudio.screens.showins.ChartMergeInput;

/**
 * A Chart screen in a viewer.
 * 
 * @author Christophe Bouhier
 * 
 */
public class MultiChartScreenViewer extends AbstractScreenViewer {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private WinForms winForms;

	private Form form;

	private List<ChartScreen> chartList;

	// Our drag and drop external transfers...
	// Aren't these also part of the event?
	private Transfer[] transfers;

	public class ChartScreenDropTargetAdapter extends ScreenDropTargetAdapter {
		public ChartScreenDropTargetAdapter(IScreen screen) {
			super(screen);
		}

		@Override
		protected void screenDrop(DropTargetEvent event) {
			Object extractData = this.extractData(event);
			if (extractData instanceof StructuredSelection) {
				// Adapt to a show-in context...
				ShowInContext showInContext = new ShowInContext(
						new ChartInput(), (ISelection) extractData);

				// Are we in a screen?
				if (screen instanceof ChartScreen) {
					showInContext.setInput(new ChartMergeInput());
					screen.handleShowIn(showInContext);
				} else {

					show(showInContext);
				}
			}
		}

		@Override
		protected void screenAccept(DropTargetEvent event) {

		}
	}

	abstract class ChartAction extends Action {
		protected ChartScreen chartScreen;

		public ChartAction(String text, int asCheckBox) {
			super(text, asCheckBox);
		}

		public ChartScreen getChartScreen() {
			return chartScreen;
		}

		public void setChartScreen(ChartScreen chartScreen) {
			this.chartScreen = chartScreen;
		}
	}

	/**
	 * An {@link IAction} for synchronizing screens.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class SumChartsAction extends ChartAction {
		public SumChartsAction(String text, ChartScreen screen) {
			super(text, IAction.AS_CHECK_BOX);
			chartScreen = screen;
		}

		public void run() {
			chartScreen.toggleSum(isChecked());
		}
	}

	/**
	 * An {@link IAction} for synchronizing screens.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class TrendChartsAction extends ChartAction {
		public TrendChartsAction(String text, ChartScreen screen) {
			super(text, IAction.AS_CHECK_BOX);
			chartScreen = screen;
		}

		public void run() {
			// TODO, turn on toggel to trend the selection of resources.
			System.out
					.println("TODO, turn on toggle to trend the selection of resources.");
		}
	}

	/**
	 * An {@link IAction} for synchronizing screens.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class RangeSelectionAction extends ChartAction {
		public RangeSelectionAction(String text, ChartScreen screen) {
			super(text, IAction.AS_PUSH_BUTTON);
			chartScreen = screen;
		}

		public void run() {

			IChartResource cr = chartScreen.getChartModel()
					.getFirstChartResource();

			if (cr == null) {
				return; // invalid chartmodel.
			}

			RangeSelectionDialog selectDialog = new RangeSelectionDialog(
					MultiChartScreenViewer.this.getSite().getShell(),
					modelUtils);

			selectDialog.setBlockOnOpen(true);
			selectDialog.create();

			selectDialog.setMessage("Select the value range");
			selectDialog.injectData(cr.getNetXResource());

			MetricValueRange currentMVR = modelUtils
					.valueRangeForIntervalAndKind(cr.getNetXResource(),
							chartScreen.getChartModel().getKindHint(),
							chartScreen.getChartModel().getInterval());
			if (currentMVR != null) {
				StructuredSelection ss = new StructuredSelection(currentMVR);
				selectDialog.setInitialSelection(ss);
			}

			if (selectDialog.open() == Window.OK) {
				MetricValueRange mvr = selectDialog.getValueRange();
				if (mvr != null) {

					chartScreen.getChartModel().setInterval(
							mvr.getIntervalHint());
					chartScreen.getChartModel().setKindHint(mvr.getKindHint());
					chartScreen.getChartModel().reset();
					chartScreen.reinit();
				}
			}
		}
	}

	/**
	 * An {@link IAction} for editing the {@link IChartModel}
	 * 
	 * @author Christophe Bouhier
	 */
	public class EditChartsAction extends ChartAction {

		public EditChartsAction(String text, ChartScreen screen) {
			super(text, IAction.AS_PUSH_BUTTON);
			this.setImageDescriptor(ResourceManager.getPluginImageDescriptor(
					"com.netxforge.netxstudio.models.edit",
					"/icons/full/obj16/NetXResource_H.gif"));
			chartScreen = screen;
		}

		public void run() {

			IChartModel chartModel = chartScreen.getChartModel();

			final ChartModelDialog chartModelDialog = new ChartModelDialog(
					MultiChartScreenViewer.this.getSite().getShell(),
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

			chartModelDialog.setMessage("Visible resources");
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

	public MultiChartScreenViewer() {
		super(AbstractScreenViewer.VIEWER_NO_SYNC_OPTION);
	}

	public IScreen getScreen() {
		return null;
	}

	@Override
	public void initScreen(Composite parent) {

		form = toolkit.createForm(parent);
		form.setSeparatorVisible(true);
		toolkit.paintBordersFor(form);
		form.setText("Demo");
		form.getBody().setLayout(new FillLayout());

		winForms = new WinForms();
		winForms.buildUI(form.getBody(), toolkit);

		// Actions
		form.getToolBarManager().add(new Action("Clear") {

			@Override
			public void run() {
				winForms.clear();
				if (chartList != null) {
					chartList.clear();
					chartList = null;
				}
			}
		});
		form.getToolBarManager().update(true);

		transfers = new Transfer[] { LocalTransfer.getInstance() };

		DropTarget dropTarget = new DropTarget(form.getHead(),
				ScreenUtil.DROP_OPERATIONS);
		dropTarget.addDropListener(new ChartScreenDropTargetAdapter(this
				.getScreen()));

		dropTarget.setTransfer(transfers);
	}

	public ChartScreen addChartScreen() {

		final Form addWindow = winForms.addWindow();
		addWindow.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));
		addWindow.setText("initial text");
		// Composite headingComposite =
		// toolkit.createComposite(addWindow.getHead(), SWT.BORDER);
		// toolkit.paintBordersFor(headingComposite);
		// addWindow.setHeadClient(headingComposite);

		final ChartScreen chartScreen = new ChartScreen(addWindow.getBody(),
				SWT.BORDER);
		chartScreen.setOperation(ScreenUtil.OPERATION_READ_ONLY);
		chartScreen.setEditingService(getEditingService());
		chartScreen.buildUI(toolkit);

		if (chartList == null) {
			chartList = Lists.newArrayList();
		}
		chartList.add(chartScreen);

		// Add our actions.
		winForms.addWinFormActions(addWindow, getActions(chartScreen));
		addWindow.pack();

		// Add dnd.
		DropTarget dropTarget = new DropTarget(addWindow.getBody(),
				ScreenUtil.DROP_OPERATIONS);
		dropTarget
				.addDropListener(new ChartScreenDropTargetAdapter(chartScreen));
		dropTarget.setTransfer(transfers);

		// Add menu option to close the windows form.
		// Not sure how nested component menus are dealt with.....better to add
		// it to
		// the largest estate, which is the chart.
		Menu menu = chartScreen.getChart().getPlotArea().getMenu();
		MenuItem item = new MenuItem(menu, SWT.PUSH);
		item.setText("Close");
		item.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (chartList != null && chartList.contains(chartScreen)) {
					chartList.remove(chartScreen);
				}
				winForms.removeWindow(addWindow);
			}
		});

		return chartScreen;
		// for (IAction action : getActions()) {
		// getViewSite().getActionBars().getToolBarManager().add(action);
		// }
		// getViewSite().getActionBars().updateActionBars();
	}

	public IAction[] getActions(ChartScreen chartScreen) {
		List<IAction> chartViewerActions = Lists.newArrayList();
		chartViewerActions
				.add(new EditChartsAction("Resource...", chartScreen));
		chartViewerActions
				.add(new RangeSelectionAction("Range...", chartScreen));
		chartViewerActions.add(new SumChartsAction("Sum", chartScreen));
		chartViewerActions.add(new TrendChartsAction("Trend", chartScreen));
		return chartViewerActions
				.toArray(new IAction[chartViewerActions.size()]);

	}

	protected void processSelection(ISelection selection) {
		if (selection != null && !selection.isEmpty()
				&& selection instanceof StructuredSelection) {
			@SuppressWarnings("unused")
			IStructuredSelection ss = (StructuredSelection) selection;

			// Do we have a chart for this selection?

			// CopyOfChartScreen chartScreen = this.addChartScreen();
			//
			// if (!chartScreen.isDisposed()) {// Closing a view will dispose
			// it!
			// chartScreen.injectData(Lists.newArrayList(ss.iterator())
			// .toArray());
			// }
		}
	}

	@Override
	protected void customPartHook(IWorkbenchPart part, PART_EVENT event) {
		super.customPartHook(part, event);
		// hide the markers.
		// chartScreen.focusLost(null);
	}

	// protected void resetToggledActions() {
	// for (IAction a : getActions()) {
	// if (a.getStyle() == IAction.AS_CHECK_BOX) {
	// a.setChecked(false);
	// }
	// }
	// }

	@Override
	public boolean show(final ShowInContext context) {

		// Overidde to reset the viewer actions.
		// resetToggledActions();

		// As there will be multiple chart windows, show-in is not very handy as
		// we won't know which one is intended or a new one.
		// For Show-in there for we support:
		// For Component => Produces a new window.

		final ShowInContext finalContext = context;

		Shell shell = getSite().getShell();
		Menu menu = new Menu(shell, SWT.POP_UP);

		{
			MenuItem item = new MenuItem(menu, SWT.RADIO);
			item.setText("Merge");
			item.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					MenuItem item = (MenuItem) e.widget;
					if (item.getSelection()) {

						if (chartList != null && !chartList.isEmpty()) {

							finalContext.setInput(new ChartMergeInput());
							// find a chart to merge with...

							ElementListSelectionDialog dialog = new ElementListSelectionDialog(
									MultiChartScreenViewer.this.getSite()
											.getShell(), new LabelProvider());

							dialog.setElements(chartList.toArray());

							dialog.setTitle("Select the chart");
							// user pressed cancel
							if (dialog.open() == Window.OK) {
								Object[] result = dialog.getResult();
								if (result.length == 1) {
									ChartScreen s = (ChartScreen) result[0];
									s.handleShowIn(finalContext);
								}
							}
						} else {
							ChartScreen chartScreen = addChartScreen();
							chartScreen.handleShowIn(finalContext);

						}

					}

				}
			});
		}
		{
			MenuItem item = new MenuItem(menu, SWT.RADIO);
			item.setText("Add");
			item.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {

					MenuItem item = (MenuItem) e.widget;
					if (item.getSelection()) {
						ChartScreen chartScreen = addChartScreen();
						chartScreen.handleShowIn(finalContext);
					}
				}
			});
		}

		menu.setEnabled(true);
		menu.setVisible(true);
		// Process merge/replace.
		return true;
	}
}

/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f2.smarts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.screens.AbstractSmartTableScreen;
import com.netxforge.netxstudio.screens.actions.ScreenAction;
import com.netxforge.netxstudio.screens.f2.NewEditTolerance;
import com.netxforge.netxstudio.screens.f2.TolerancesLabelProvider;
import com.netxforge.screens.editing.base.ScreenUtil;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class SmartTolerances extends AbstractSmartTableScreen {

	private Form frmTolerances;
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private CDOResource toleranceResource;

	public SmartTolerances(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		@SuppressWarnings("unused")
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmTolerances = toolkit.createForm(this);
		frmTolerances.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmTolerances);
		frmTolerances.setText(getOperationText() + "Tolerances");
		frmTolerances.getBody().setLayout(new GridLayout(3, false));
		frmTolerances.getToolBarManager().add(
				new EditToleranceAction("", ResourceManager
						.getPluginImageDescriptor(
								"com.netxforge.netxstudio.models.edit",
								"icons/full/ctool16/Threshold_E.png"),
						ScreenAction.NEW_MODE));
		frmTolerances.getToolBarManager().update(true);
		super.buildUI(frmTolerances.getBody(), "?");
	}

	public Form getScreenForm() {
		return frmTolerances;
	}
	
	@Override
	public String getScreenName() {
		return "Tolerances";
	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	@Override
	public void injectData() {
		buildUI();
		toleranceResource = (CDOResource) editingService
				.getData(LibraryPackage.Literals.TOLERANCE);
		// tolResource.cdoPrefetch(CDORevision.DEPTH_INFINITE);

		// Must call to set the Selection History.
		super.injectData();
		
	}

	@Override
	protected List<?> delegateGetItems() {
		return toleranceResource.getContents();
	}

	protected void delegateBuildColumns(TableViewer viewer) {
		TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(143);
		tblclmnName.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(viewer,
				SWT.NONE);
		TableColumn tblclmnOwnedBy = tableViewerColumn_1.getColumn();
		tblclmnOwnedBy.setWidth(100);
		tblclmnOwnedBy.setText("Level");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(viewer,
				SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(250);
		tblclmnExpression.setText("Expression");
	}

	@Override
	protected IBaseLabelProvider delegateGetListLabelProvider() {
		return new TolerancesLabelProvider();
	}

	@Override
	protected boolean delegateMatchItem(Object item) {

		if (item instanceof Tolerance) {
			Tolerance t = (Tolerance) item;
			if (t.eIsSet(LibraryPackage.Literals.TOLERANCE__NAME)) {
				String match = (String) t
						.eGet(LibraryPackage.Literals.TOLERANCE__NAME);
				return lazyItemsFilter.matches(match);
			}
		}

		return false;
	}

	private final List<IAction> actions = Lists.newArrayList();

	@Override
	public IAction[] getActions() {
		if (actions.isEmpty()) {
			String actionText = ScreenUtil.isReadOnlyOperation(getOperation()) ? "View"
					: "Edit";
			actions.add(new EditToleranceAction(actionText + "...", ResourceManager
					.getPluginImageDescriptor(
							"com.netxforge.netxstudio.models.edit",
							"icons/full/obj16/Tolerance_H.png"),
					ScreenAction.EDIT_OR_VIEW_MODE));
			actions.addAll(Arrays.asList(super.getActions()));
		}

		return actions.toArray(new IAction[actions.size()]);
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditToleranceAction extends ScreenAction {

		public EditToleranceAction(String text, ImageDescriptor image, int mode) {
			super(text, image, mode);
		}

		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			return selection.getFirstElement() instanceof Tolerance;
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {

				if (this.getMode() == ScreenAction.EDIT_OR_VIEW_MODE) {
					ISelection selection = getViewer().getSelection();
					if (selection instanceof IStructuredSelection) {
						Object o = ((IStructuredSelection) selection)
								.getFirstElement();
						// We are going to edit this object, add it to the
						// history.
						getLazyTableViewer().addToHistory(o);

						if (o != null) {
							NewEditTolerance toleranceScreen = new NewEditTolerance(
									screenService.getScreenContainer(),
									SWT.NONE);
							toleranceScreen.setOperation(getOperation());
							toleranceScreen.setScreenService(screenService);
							toleranceScreen.injectData(toleranceResource, o);
							screenService.setActiveScreen(toleranceScreen);
						}
					}
				} else if (this.getMode() == ScreenAction.NEW_MODE) {
					NewEditTolerance toleranceScreen = new NewEditTolerance(
							screenService.getScreenContainer(), SWT.NONE);
					toleranceScreen.setOperation(ScreenUtil.OPERATION_NEW);
					toleranceScreen.setScreenService(screenService);
					Tolerance tolerance = LibraryFactory.eINSTANCE
							.createTolerance();
					toleranceScreen.injectData(toleranceResource, tolerance);
					screenService.setActiveScreen(toleranceScreen);
				}
			}

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Comparator<T> delegateGetItemsComparator() {
		Comparator<Tolerance> objectEAttributeComparator = NonModelUtils
				.<Tolerance, String> objectEAttributeComparator(LibraryPackage.Literals.TOLERANCE__NAME);
		return (Comparator<T>) objectEAttributeComparator;
	}

	@Override
	public CDOView delegateGetCDOView() {
		return toleranceResource.cdoView();
	}

	@Override
	protected Resource delegateGetResource() {
		return toleranceResource;
	}

	@Override
	protected void delegateHandleDoubleClick() {
		getActions()[0].run();
	}
	
}

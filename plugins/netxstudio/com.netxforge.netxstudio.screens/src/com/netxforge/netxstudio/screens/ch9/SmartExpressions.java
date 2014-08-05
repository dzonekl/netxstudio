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
package com.netxforge.netxstudio.screens.ch9;

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
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.screens.AbstractSmartTableScreen;
import com.netxforge.netxstudio.screens.actions.ScreenAction;
import com.netxforge.screens.editing.base.ScreenUtil;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class SmartExpressions extends AbstractSmartTableScreen {

	private Form frmExpressions;
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Resource expressionsResource;

	public SmartExpressions(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	/**
	 * Wrap in an action, to contribute to a menu manager.
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	class EditExpressionAction extends ScreenAction {

		public EditExpressionAction(String text, ImageDescriptor image, int mode) {
			super(text, image, mode);
		}

		@Override
		public void run() {
			super.run();
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (this.getMode() == ScreenAction.EDIT_OR_VIEW_MODE) {
					if (selection instanceof IStructuredSelection) {
						Object o = ((IStructuredSelection) selection)
								.getFirstElement();

						// We are going to edit this object, add it to the
						// history.
						getLazyTableViewer().addToHistory(o);
						if (o != null) {
							NewEditExpression editExpression = new NewEditExpression(
									screenService.getScreenContainer(),
									SWT.NONE);
							editExpression.setScreenService(screenService);
							editExpression
									.setOperation(ScreenUtil.OPERATION_NEW);
							editExpression.injectData(expressionsResource, o);
							screenService.setActiveScreen(editExpression);
						}
					}
				} else if (this.getMode() == ScreenAction.NEW_MODE) {
					NewEditExpression editExpression = new NewEditExpression(
							screenService.getScreenContainer(), SWT.NONE);
					editExpression.setScreenService(screenService);
					Expression newExpression = LibraryFactory.eINSTANCE
							.createExpression();

					editExpression.setOperation(ScreenUtil.OPERATION_NEW);
					editExpression.injectData(expressionsResource,
							newExpression);
					screenService.setActiveScreen(editExpression);
				}
			}
		}
	}

	public void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		@SuppressWarnings("unused")
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmExpressions = toolkit.createForm(this);
		frmExpressions.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmExpressions);
		frmExpressions.setText(getOperationText() + "Expressions");
		frmExpressions.getBody().setLayout(new GridLayout(3, false));
		frmExpressions.getToolBarManager().add(
				new EditExpressionAction("", ResourceManager
						.getPluginImageDescriptor(
								"com.netxforge.netxstudio.models.edit",
								"icons/full/ctool16/Expression_H.png"),
						ScreenAction.NEW_MODE));
		frmExpressions.getToolBarManager().update(true);
		super.buildUI(frmExpressions.getBody(), "?");
	}

	public Form getScreenForm() {
		return frmExpressions;
	}

	@Override
	public String getScreenName() {
		return "Expressions";
	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	@Override
	public void injectData() {
		buildUI();
		expressionsResource = editingService
				.getData(LibraryPackage.Literals.EXPRESSION);
		super.injectData();
	}

	@Override
	protected List<?> delegateGetItems() {
		return expressionsResource.getContents();
	}

	protected void delegateBuildColumns(TableViewer tableViewer) {

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(60);
		tblclmnName.setText("Used by");

		TableViewerColumn tableViewerColumn_0 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnName_0 = tableViewerColumn_0.getColumn();
		tblclmnName_0.setWidth(80);
		tblclmnName_0.setText("Source");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnName_1 = tableViewerColumn_1.getColumn();
		tblclmnName_1.setWidth(300);
		tblclmnName_1.setText("Name");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(250);
		tblclmnExpression.setText("Expression");

	}

	@Override
	protected IBaseLabelProvider delegateGetListLabelProvider() {
		ExpressionsLabelProvider expressionsLabelProvider = new ExpressionsLabelProvider();
		return expressionsLabelProvider;
	}

	@Override
	protected boolean delegateMatchItem(Object item) {

		if (item instanceof Expression) {
			Expression expression = (Expression) item;
			if(expression.eIsSet(LibraryPackage.Literals.EXPRESSION__NAME)){
				String match = (String) expression.eGet(LibraryPackage.Literals.EXPRESSION__NAME);
				boolean matchName = lazyItemsFilter.matches(match);
				if(!matchName){
					String expressionAsString = StudioUtils.expressionAsString(expression);
					return lazyItemsFilter.matches(expressionAsString);
				}else return matchName;
			}
		}

		return false;
	}

	private final List<IAction> actions = Lists.newArrayList();

	public IAction[] getActions() {
		if (actions.isEmpty()) {
			String actionText = ScreenUtil.isReadOnlyOperation(getOperation()) ? "View"
					: "Edit";
			actions.add(new EditExpressionAction(actionText + "...",
					ResourceManager.getPluginImageDescriptor(
							"com.netxforge.netxstudio.models.edit",
							"icons/full/obj16/Expression_H.png"),
					ScreenAction.EDIT_OR_VIEW_MODE));
			actions.addAll(Arrays.asList(super.getActions()));
		}

		return actions.toArray(new IAction[actions.size()]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Comparator<T> delegateGetItemsComparator() {
		Comparator<Tolerance> objectEAttributeComparator = NonModelUtils
				.<Tolerance, String> objectEAttributeComparator(LibraryPackage.Literals.EXPRESSION__NAME);
		return (Comparator<T>) objectEAttributeComparator;
	}

	@Override
	public CDOView delegateGetCDOView() {
		return expressionsResource instanceof CDOResource ? ((CDOResource) expressionsResource)
				.cdoView() : null;
	}

	@Override
	protected Resource delegateGetResource() {
		return expressionsResource;
	}

	@Override
	protected void delegateHandleDoubleClick() {
		getActions()[0].run();
	}

}

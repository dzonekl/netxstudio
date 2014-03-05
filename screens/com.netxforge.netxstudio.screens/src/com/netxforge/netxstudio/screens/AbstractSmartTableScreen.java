/*******************************************************************************
 * Copyright (c) 25 nov. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens;

import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.spi.cdo.FSMUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IMemento;

import com.netxforge.base.cdo.CDO;
import com.netxforge.netxstudio.screens.AbstractSmartTableViewer.SelectionHistory;
import com.netxforge.netxstudio.screens.editing.util.CDOMementoUtil;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.screens.editing.base.EMFEditingService;
import com.netxforge.screens.editing.base.IDataServiceInjection;
import com.netxforge.screens.editing.base.util.MementoUtil;

/**
 * An abstract implementation of a screen with an embedded tableviewer.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class AbstractSmartTableScreen extends AbstractScreen implements
		IDataServiceInjection {

	private LazyTableViewer lazyTableViewer;

	/*
	 * Expose so clients can utilize methods like matches().
	 */
	protected AbstractPatternItemsFilter lazyItemsFilter;

	/*
	 * Expose so clients can utilize
	 */
	protected AdapterFactoryItemDelegator adapterFactoryItemDelegator;

	public AbstractSmartTableScreen(Composite parent, int style) {
		super(parent, style);

		this.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (getLazyTableViewer() != null) {
					getLazyTableViewer().removeAdapterFactory();
				}
			}
		});
	}

	@Override
	public void injectData() {
		final CDOView view = delegateGetCDOView();
		lazyTableViewer.setSelectionHistory(new LazySelectionHistory(view));

	}

	public void buildUI(Composite parent, String pattern) {
		lazyTableViewer = new LazyTableViewer(this.getShell(), true);

		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				EMFEditingService.getAdapterFactory());

		// Set our adapter factory for additional facilities.
		lazyTableViewer
				.setAdapterFactory(EMFEditingService.getAdapterFactory());

		// Set a default or custom label provider. The default uses EMF.edit to
		// retrieve the ItemProvider getText()
		IBaseLabelProvider provider = delegateGetListLabelProvider();
		lazyTableViewer.setListLabelProvider(provider);

		// Do we have a custom selection decorator.
		ILabelDecorator decorator = delegateGetListSelectionDecorator();
		if (decorator != null) {
			lazyTableViewer.setListSelectionLabelDecorator(decorator);
		}

		lazyTableViewer.buildUI(parent);
	}

	/**
	 * A selection history which can restore a CDO Object using it's CDOID.
	 * 
	 * 
	 * @author Christophe Bouhier
	 */
	public class LazySelectionHistory extends SelectionHistory {

		private final String MEM_KEY_LAZY_OID = "MEM_KEY_LAZY_OID";
		private CDOView view;

		public LazySelectionHistory(CDOView view) {
			this.view = view;
		}

		@Override
		protected Object restoreItemFromMemento(IMemento memento) {

			String[] attributeKeys = memento.getAttributeKeys();
			if (attributeKeys.length == 1) {
				return CDOMementoUtil.retrieveCDOObject(memento, view,
						attributeKeys[0]);
			}
			return null;
		}

		@Override
		protected void storeItemToMemento(Object item, IMemento memento) {

			if (item instanceof CDOObject) {

				if (FSMUtil.isClean((CDOObject) item)) {
					String cdoLongIDAsString = CDO
							.cdoLongIDAsString((CDOObject) item);

					// This is the root memento, find children matching our ID.
					IMemento[] children = memento
							.getChildren(this.infoNodeName);

					for (IMemento m : children) {
						// find a key matching our ID.
						String[] attributeKeys = m.getAttributeKeys();
						for (String key : attributeKeys) {
							if (key.equals(MEM_KEY_LAZY_OID + cdoLongIDAsString)) {
								return; // We know this one already.
							}
						}
					}
					// Remember clean CDOObjects only.

					// Remember in a child node.
					CDOMementoUtil.rememberCDOObject(
							memento.createChild(this.infoNodeName),
							(CDOObject) item, MEM_KEY_LAZY_OID
									+ cdoLongIDAsString);
				}
			}
		}
	}

	public class LazyTableViewer extends AbstractSmartTableViewer {

		public LazyTableViewer(Shell shell, boolean multi) {
			super(shell, multi);
		}

		public LazyTableViewer(Shell shell) {
			super(shell);
		}

		public TableViewer getTableViewer() {
			return this.tblViewer;
		}

		@Override
		protected Control createExtendedContentArea(Composite parent) {
			return null;
		}

		@Override
		public void handleDoubleClick() {
			delegateHandleDoubleClick();
		}

		@Override
		protected IStatus validateItem(Object item) {
			return delegateValidateItem(item);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.netxforge.netxstudio.screens.AbstractLazyTableViewer#createFilter
		 * ()
		 */
		@Override
		protected IItemsFilter createFilter() {

			TextSearchPattern pattern = new TextSearchPattern();
			Control patternControl = LazyTableViewer.this.getPatternControl();
			if (patternControl instanceof Text) {
				pattern.setPattern(((Text) patternControl).getText());
			}

			// Note: We need to realize each time, the constructor reads the
			// pattern control (Text widget)
			// to get the current pattern to match against.
			lazyItemsFilter = new AbstractPatternItemsFilter(pattern) {

				@Override
				public boolean isConsistentItem(Object item) {
					return true;
				}

				@Override
				public boolean matchItem(Object item) {
					// As we are a generic implementation this delegates to the
					// concrete implememtation of the IScreen.
					return AbstractSmartTableScreen.this
							.delegateMatchItem(item);
				}
			};

			return lazyItemsFilter;
		}

		@Override
		protected void fillContentProvider(
				AbstractContentProvider contentProvider,
				IItemsFilter itemsFilter, IProgressMonitor progressMonitor)
				throws CoreException {

			if (ScreensActivator.DEBUG) {
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"filling content provider");
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"items filter pattern: " + itemsFilter.getPattern());

			}

			final Resource delegateGetResource = delegateGetResource();

			// Do in UI thread.

			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					if (!tblViewer.getInput().equals(delegateGetResource)) {
						tblViewer.setInput(delegateGetResource);
					}
				}
			});

			contentProvider.addCollection(delegateGetResource.getContents(),
					itemsFilter);

		}

		@Override
		public String getElementName(Object item) {
			return null;
		}

		@Override
		protected void buildColumns(TableViewer viewer) {
			delegateBuildColumns(viewer);

		}

		@Override
		protected <T> Comparator<T> getItemsComparator() {
			return delegateGetItemsComparator();
		}

	}

	/**
	 * Matches items based on the default EMF
	 * {@link AdapterFactoryItemDelegator#getText(Object)} method. Clients can
	 * override to match items in a customized way. I.e. this could be any
	 * EStructuralFeature of the EObject.
	 * 
	 * @param item
	 * @return
	 */
	protected boolean delegateMatchItem(Object item) {
		String match = adapterFactoryItemDelegator.getText(item);

		boolean result = lazyItemsFilter.matches(match);

		// make this optional, it cloudes the trace!

		// if (ScreensActivator.DEBUG) {
		// ScreensActivator.TRACE.trace(ScreensActivator.TRACE_SCREENS_OPTION,
		// "matching:" + item + " with text" + match
		// + " using pattern "
		// + lazyItemsFilter.patternMatcher.getPattern());
		//
		// ScreensActivator.TRACE.trace(ScreensActivator.TRACE_SCREENS_OPTION,
		// "result " + result);
		// }

		return result;
	}

	/*
	 * Clients can override. the default implementation does nothing.
	 */
	protected void delegateHandleDoubleClick() {

	}

	/*
	 * Clients must implement. The source for populating items.
	 */
	protected abstract List<?> delegateGetItems();

	/*
	 * Clients must implement. The source for populating items.
	 */
	protected abstract Resource delegateGetResource();

	/*
	 * Clients can override to validation of selected items. In the context of
	 * an editor (Not a selector) the need for this is limited.
	 */
	protected IStatus delegateValidateItem(Object item) {
		return Status.OK_STATUS;
	}

	/*
	 * Clients must implement.
	 */
	public abstract CDOView delegateGetCDOView();

	/*
	 * Clients must implement to provide a comparator.
	 */
	public abstract <T> Comparator<T> delegateGetItemsComparator();

	/*
	 * Clients can override to add columns. The default Impl. doesn't add any
	 * columns.
	 */
	protected void delegateBuildColumns(TableViewer viewer) {
	}

	/*
	 * Clients can override to add a custom label provider.
	 */
	protected IBaseLabelProvider delegateGetListLabelProvider() {
		return new LabelProvider() {

			@Override
			public String getText(Object element) {
				return adapterFactoryItemDelegator.getText(element);
			}
		};
	}

	/*
	 * Clients can override to add a custom label decorator for the selected
	 * element.
	 */
	protected ILabelDecorator delegateGetListSelectionDecorator() {
		return null;
	}

	public Viewer getViewer() {
		return lazyTableViewer.getTableViewer();
	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	@Override
	public void saveState(IMemento memento) {
		lazyTableViewer.saveState(memento);
		// sash state vertical.
		MementoUtil.rememberStructuredViewerSelection(memento,
				lazyTableViewer.getTableViewer(),
				MementoUtil.MEM_KEY_SELECTION_TABLE);

		// Note: Not compatible with the refresh algorithm of the underlying
		// viewer.
		MementoUtil.rememberStructuredViewerColumns(memento,
				lazyTableViewer.getTableViewer(),
				MementoUtil.MEM_KEY_COLUMNS_TABLE);

		if (lazyItemsFilter != null) {

			TextSearchPattern pattern = (TextSearchPattern) lazyItemsFilter
					.getPattern();
			MementoUtil.rememberString(memento, pattern.getPattern(),
					MementoUtil.MEM_KEY_SEARCH_PATTERN);
		}
	}

	@Override
	public void restoreState(IMemento memento) {
		String pattern = null;
		if (memento != null) {
			lazyTableViewer.restoreState(memento);

			CDOMementoUtil.retrieveStructuredViewerSelection(memento,
					lazyTableViewer.getTableViewer(),
					MementoUtil.MEM_KEY_SELECTION_TABLE, delegateGetCDOView());
			MementoUtil.retrieveStructuredViewerColumns(memento,
					lazyTableViewer.getTableViewer(),
					MementoUtil.MEM_KEY_COLUMNS_TABLE);

			pattern = MementoUtil.retrieveString(memento,
					MementoUtil.MEM_KEY_SEARCH_PATTERN);
		}

		if (pattern == null || pattern.equals("?*")) {
			this.getLazyTableViewer().setPattern("?"); // Show all when not set.
		} else {
			this.getLazyTableViewer().setPattern(pattern);
		}
		// this.getLazyTableViewer().applyFilter(); // Just show the history/
		// lazyTableViewer.applyFilter(); // Trigger the initial filtering,
		// which
		// will show history.

	}

	public LazyTableViewer getLazyTableViewer() {
		return lazyTableViewer;
	}

	@Override
	public IAction[] getActions() {
		return new IAction[] { lazyTableViewer.getRemoveHistoryItemAction() };
	}

}

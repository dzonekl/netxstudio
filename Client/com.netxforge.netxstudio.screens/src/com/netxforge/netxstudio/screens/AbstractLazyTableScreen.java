package com.netxforge.netxstudio.screens;

import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.spi.cdo.FSMUtil;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;

import com.netxforge.netxstudio.screens.AbstractLazyTableViewer.ItemsFilter;
import com.netxforge.netxstudio.screens.AbstractLazyTableViewer.SelectionHistory;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * An abstract implementation of a screen with an embedded tableviewer.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class AbstractLazyTableScreen extends AbstractScreen implements
		IDataServiceInjection {

	private LazyTableViewer lazyTableViewer;

	/*
	 * Expose so clients can utilize methods like matches().
	 */
	protected ItemsFilter lazyItemsFilter;

	/*
	 * Expose so clients can utilize
	 */
	protected AdapterFactoryItemDelegator adapterFactoryItemDelegator;

	public AbstractLazyTableScreen(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void injectData() {
		final CDOView view = delegateGetCDOView();
		lazyTableViewer.setSelectionHistory(new LazySelectionHistory(view));
	}

	public void buildUI(Composite parent) {
		lazyTableViewer = new LazyTableViewer(this.getShell());
		
		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				editingService.getAdapterFactory());

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
				return mementoUtils.retrieveCDOObject(memento, view,
						attributeKeys[0]);
			}
			return null;
		}

		@Override
		protected void storeItemToMemento(Object item, IMemento memento) {

			Assert.isTrue(item instanceof CDOObject);
			if (FSMUtil.isClean((CDOObject) item)) {
				String cdoLongIDAsString = modelUtils
						.cdoLongIDAsString((CDOObject) item);

				// This is the root memento, find children matching our ID.
				IMemento[] children = memento.getChildren(this.infoNodeName);
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
				mementoUtils.rememberCDOObject(
						memento.createChild(this.infoNodeName),
						(CDOObject) item, MEM_KEY_LAZY_OID + cdoLongIDAsString);
			}
		}
	}

	public class LazyTableViewer extends AbstractLazyTableViewer {

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
		protected ItemsFilter createFilter() {

			// Note: We need to realize each time, the constructor reads the
			// pattern control (Text widget)
			// to get the current pattern to match against.
			lazyItemsFilter = lazyTableViewer.new ItemsFilter() {

				@Override
				public boolean isConsistentItem(Object item) {
					return true;
				}

				@Override
				public boolean matchItem(Object item) {
					// As we are a generic implementation this delegates to the
					// concrete implememtation of the IScreen.
					return AbstractLazyTableScreen.this.delegateMatchItem(item);
				}
			};

			return lazyItemsFilter;
		}

		@Override
		protected void fillContentProvider(
				AbstractContentProvider contentProvider,
				ItemsFilter itemsFilter, IProgressMonitor progressMonitor)
				throws CoreException {

			if (ScreensActivator.DEBUG) {
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"filling content provider");
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"items filter pattern: " + itemsFilter.getPattern());

			}

			// We don't want to feed the whole list, this should really be done
			// when a specific filter applies.
			// If the filter is

			List<?> delegateGetItems = delegateGetItems();
			contentProvider.addCollection(delegateGetItems, itemsFilter);

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

	protected abstract List<?> delegateGetItems();

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
	}

	@Override
	public void restoreState(IMemento memento) {
		lazyTableViewer.restoreState(memento);
		lazyTableViewer.applyFilter(); // Trigger the initial filtering, which
										// will show history.
	}

	public LazyTableViewer getLazyTableViewer() {
		return lazyTableViewer;
	}

}

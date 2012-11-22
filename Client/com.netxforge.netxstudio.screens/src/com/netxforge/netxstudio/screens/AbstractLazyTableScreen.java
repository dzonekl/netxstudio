package com.netxforge.netxstudio.screens;

import java.util.Comparator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.netxforge.netxstudio.screens.AbstractLazyTableViewer.ItemsFilter;
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

	public void buildUI(Composite parent) {
		lazyTableViewer = new LazyTableViewer(this.getShell());

		adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
				editingService.getAdapterFactory());

		// Set a default or custom label provider. The default uses EMF.edit to retrieve the ItemProvider getText()
		IBaseLabelProvider provider = delegateGetListLabelProvider();
		lazyTableViewer.setListLabelProvider(provider);
		
		// Do we have a custom selection decorator. 
		ILabelDecorator decorator = delegateGetListSelectionDecorator();
		if (decorator != null) {
			lazyTableViewer.setListSelectionLabelDecorator(decorator);
		}
		
		lazyTableViewer.buildUI(parent);
	}

	class LazyTableViewer extends AbstractLazyTableViewer {

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
		protected Comparator getItemsComparator() {
			return null;
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

	protected abstract List<?> delegateGetItems();

	/*
	 * Clients can override to validation of selected items. In the context of
	 * an editor (Not a selector) the need for this is limited.
	 */
	protected IStatus delegateValidateItem(Object item) {
		return Status.OK_STATUS;
	}

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

}

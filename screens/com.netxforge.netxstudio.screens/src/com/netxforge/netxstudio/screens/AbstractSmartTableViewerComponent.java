package com.netxforge.netxstudio.screens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.jface.action.LegacyActionTools;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILazyContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.progress.UIJob;

import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * A Cached Viewer Component, which can be extended. It has no support for
 * history and Items filtering.
 * 
 */
public abstract class AbstractSmartTableViewerComponent {

	final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	/**
	 * Represents an empty selection in the pattern input field (used only for
	 * initial pattern).
	 */
	public static final int NONE = 0;

	/**
	 * Pattern input field selection where caret is at the beginning (used only
	 * for initial pattern).
	 */
	public static final int CARET_BEGINNING = 1;

	/**
	 * Represents a full selection in the pattern input field (used only for
	 * initial pattern).
	 */
	public static final int FULL_SELECTION = 2;

	/*
	 * Expose for selection handling.
	 */
	protected TableViewer tblViewer;

	private ItemsLabelProvider itemsListLabelProvider;

	private boolean multi;

	private Label progressLabel;

	private RefreshCacheJob refreshCacheJob;

	private RefreshProgressMessageJob refreshProgressMessageJob = new RefreshProgressMessageJob();

	private Object[] currentSelection;

	private ItemsContentProvider contentProvider;

	private FilterJob filterJob;

	private IItemsFilter filter;

	private List<?> lastCompletedResult;

	private IItemsFilter lastCompletedFilter;

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	/*
	 * When refreshing the UI, the selection can be restored if this flag is
	 * true
	 */
	private boolean refreshWithLastSelection = false;

	private IHandlerActivation showViewHandler;

	private Label listLabel;

	/**
	 * Creates a new instance of the class.
	 * 
	 * @param shell
	 *            shell to parent the dialog on
	 * @param multi
	 *            indicates whether dialog allows to select more than one
	 *            position in its list of items
	 */
	public AbstractSmartTableViewerComponent(Shell shell, boolean multi) {
		this.multi = multi;
		filterJob = new FilterJob();
		contentProvider = new ItemsContentProvider();
		refreshCacheJob = new RefreshCacheJob();
	}

	/**
	 * Creates a new instance of the class. Created dialog won't allow to select
	 * more than one item.
	 * 
	 * @param shell
	 *            shell to parent the dialog on
	 */
	public AbstractSmartTableViewerComponent(Shell shell) {
		this(shell, false);
	}

	/**
	 * Adds viewer filter to the dialog items list.
	 * 
	 * @param filter
	 *            the new filter
	 */
	public void addViewerFilter(ViewerFilter filter) {
		contentProvider.addFilter(filter);
	}

	/**
	 * Gets the list of currently installed viewer filters.
	 * 
	 * @return
	 */
	public List<ViewerFilter> getViewerFilters() {
		return contentProvider.getFilters();
	}

	/**
	 * Sets a new label provider for items in the list. If the label provider
	 * also implements
	 * {@link org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider .IStyledLabelProvider}
	 * , the style text labels provided by it will be used provided that the
	 * corresponding preference is set.
	 * 
	 * @see IWorkbenchPreferenceConstants#USE_COLORED_LABELS
	 * 
	 * @param listLabelProvider
	 *            the label provider for items in the list
	 */
	public void setListLabelProvider(IBaseLabelProvider listLabelProvider) {
		getItemsLabelProvider().setProvider(listLabelProvider);
	}

	/**
	 * Returns the label decorator for selected items in the list.
	 * 
	 * @return the label decorator for selected items in the list
	 */
	private ILabelDecorator getListSelectionLabelDecorator() {
		return getItemsLabelProvider().getSelectionDecorator();
	}

	/**
	 * Sets the label decorator for selected items in the list.
	 * 
	 * @param listSelectionLabelDecorator
	 *            the label decorator for selected items in the list
	 */
	public void setListSelectionLabelDecorator(
			ILabelDecorator listSelectionLabelDecorator) {
		getItemsLabelProvider().setSelectionDecorator(
				listSelectionLabelDecorator);
	}

	/**
	 * Returns the item list label provider.
	 * 
	 * @return the item list label provider
	 */
	private ItemsLabelProvider getItemsLabelProvider() {
		if (itemsListLabelProvider == null) {
			itemsListLabelProvider = new ItemsLabelProvider(
					new LabelProvider(), null);
		}
		return itemsListLabelProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.window.Window#close()
	 */
	public boolean close() {

		// Cancel all the jobs.
		this.filterJob.cancel();
		this.refreshCacheJob.cancel();
		this.refreshProgressMessageJob.cancel();

		if (showViewHandler != null) {
			IHandlerService service = (IHandlerService) PlatformUI
					.getWorkbench().getService(IHandlerService.class);
			service.deactivateHandler(showViewHandler);
			showViewHandler.getHandler().dispose();
			showViewHandler = null;
		}

		return true;
	}

	/**
	 * 
	 * CB Don not use for now. Create a new header which is labelled by
	 * headerLabel.
	 * 
	 * @param parent
	 * @return Label the label of the header
	 */
	@SuppressWarnings("unused")
	private Label createHeader(Composite parent) {
		Composite header = new Composite(parent, SWT.NONE);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		header.setLayout(layout);

		Label headerLabel = new Label(header, SWT.NONE);
		headerLabel
				.setText("Select an item to open (? = any character, * = any string):");

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		headerLabel.setLayoutData(gd);

		// createViewMenu(header);

		header.setLayoutData(gd);
		return headerLabel;
	}

	/**
	 * Create the labels for the list and the progress. Return the list label.
	 * 
	 * @param parent
	 * @return Label
	 */
	private Label createLabels(Composite parent) {

		Composite labels = toolkit.createComposite(parent, SWT.NONE);
		labels.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		GridLayout layout = new GridLayout();

		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.verticalSpacing = 0;
		labels.setLayout(layout);

		listLabel = toolkit.createLabel(labels, "", SWT.NONE);

		listLabel.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_MNEMONIC && e.doit) {
					e.detail = SWT.TRAVERSE_NONE;
					tblViewer.getTable().setFocus();
				}
			}
		});

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		listLabel.setLayoutData(gd);

		progressLabel = toolkit.createLabel(labels, "", SWT.RIGHT);
		progressLabel.setLayoutData(gd);

		return listLabel;
	}

	// CB Disable the view.

	// private void createViewMenu(Composite parent) {
	// toolBar = new ToolBar(parent, SWT.FLAT);
	// toolItem = new ToolItem(toolBar, SWT.PUSH, 0);
	//
	// GridData data = new GridData();
	// data.horizontalAlignment = GridData.END;
	// toolBar.setLayoutData(data);
	//
	// toolBar.addMouseListener(new MouseAdapter() {
	// public void mouseDown(MouseEvent e) {
	// showViewMenu();
	// }
	// });
	//
	// toolItem.setImage(WorkbenchImages
	// .getImage(IWorkbenchGraphicConstants.IMG_LCL_VIEW_MENU));
	// toolItem.setToolTipText(WorkbenchMessages.FilteredItemsSelectionDialog_menu);
	// toolItem.addSelectionListener(new SelectionAdapter() {
	// public void widgetSelected(SelectionEvent e) {
	// showViewMenu();
	// }
	// });
	//
	// menuManager = new MenuManager();
	//
	// fillViewMenu(menuManager);
	//
	// IHandlerService service = (IHandlerService) PlatformUI.getWorkbench()
	// .getService(IHandlerService.class);
	// IHandler handler = new AbstractHandler() {
	// public Object execute(ExecutionEvent event) {
	// showViewMenu();
	// return null;
	// }
	// };
	// showViewHandler = service.activateHandler(
	// IWorkbenchCommandConstants.WINDOW_SHOW_VIEW_MENU, handler,
	// new ActiveShellExpression(getShell()));
	// }

	// private void showViewMenu() {
	// Menu menu = menuManager.createContextMenu(getShell());
	// Rectangle bounds = toolItem.getBounds();
	// Point topLeft = new Point(bounds.x, bounds.y + bounds.height);
	// topLeft = toolBar.toDisplay(topLeft);
	// menu.setLocation(topLeft.x, topLeft.y);
	// menu.setVisible(true);
	// }

	/**
	 * Creates an extra content area, which will be located above the details.
	 * 
	 * @param parent
	 *            parent to create the dialog widgets in
	 * @return an extra content area
	 */
	protected abstract Control createExtendedContentArea(Composite parent);

	public Control buildUI(Composite parent) {

		Composite content = toolkit.createComposite(parent, SWT.NONE);
		toolkit.paintBordersFor(content);

		// CB Use form based.
		// Composite content = new Composite(parent, SWT.NONE);

		GridData gd = new GridData(GridData.FILL_BOTH);
		content.setLayoutData(gd);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		// layout.verticalSpacing = 0;
		content.setLayout(layout);

		// CB Decide later. Do not build the header for now.
		// final Label headerLabel = createHeader(content);

		final Label listLabel = createLabels(content);

		tblViewer = new TableViewer(content, (multi ? SWT.MULTI : SWT.SINGLE)
				| SWT.BORDER | SWT.V_SCROLL | SWT.VIRTUAL);
		tblViewer.getTable().getAccessible()
				.addAccessibleListener(new AccessibleAdapter() {
					public void getName(AccessibleEvent e) {
						if (e.childID == ACC.CHILDID_SELF) {
							e.result = LegacyActionTools
									.removeMnemonics(listLabel.getText());
						}
					}
				});
		tblViewer.setContentProvider(contentProvider);
		tblViewer.getTable().setLinesVisible(true);
		tblViewer.getTable().setHeaderVisible(true);

		tblViewer.setInput(new Object[0]);
		tblViewer.setItemCount(contentProvider.getNumberOfElements());
		gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = tblViewer.getTable().getItemHeight() * 15;
		tblViewer.getTable().setLayoutData(gd);

		buildColumns(tblViewer);

		// Do this after building the columns, as each ViewerColumn will have
		// the label provider set.
		tblViewer.setLabelProvider(getItemsLabelProvider());

		tblViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event
						.getSelection();
				handleSelected(selection);
			}
		});

		tblViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				handleDoubleClick();
			}
		});

		createExtendedContentArea(content);
		return content;
	}

	protected abstract void buildColumns(TableViewer viewer);

	/**
	 * Clients can use to i.e. edit a double clicked item.
	 */
	public abstract void handleDoubleClick();

	/**
	 * Handle selection in the items list by updating labels of selected and
	 * unselected items and refresh the details field using the selection.
	 * 
	 * @param selection
	 *            the new selection
	 */
	protected void handleSelected(StructuredSelection selection) {

		// Status could be used else where in the future.
		@SuppressWarnings("unused")
		IStatus status = new Status(IStatus.OK, PlatformUI.PLUGIN_ID,
				IStatus.OK, EMPTY_STRING, null);

		Object[] lastSelection = currentSelection;

		currentSelection = selection.toArray();

		if (selection.size() == 0) {
			status = new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID,
					IStatus.ERROR, EMPTY_STRING, null);

			if (lastSelection != null
					&& getListSelectionLabelDecorator() != null) {
				tblViewer.update(lastSelection, null);
			}

			currentSelection = null;

		} else {
			status = new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID,
					IStatus.ERROR, EMPTY_STRING, null);

			List<?> items = selection.toList();

			Object item = null;
			IStatus tempStatus = null;

			for (Iterator<?> it = items.iterator(); it.hasNext();) {
				Object o = it.next();

				item = o;
				tempStatus = validateItem(item);

				if (tempStatus.isOK()) {
					status = new Status(IStatus.OK, PlatformUI.PLUGIN_ID,
							IStatus.OK, EMPTY_STRING, null);
				} else {
					status = tempStatus;
					// if any selected element is not valid status is set to
					// ERROR
					break;
				}
			}

			if (lastSelection != null
					&& getListSelectionLabelDecorator() != null) {
				tblViewer.update(lastSelection, null);
			}

			if (getListSelectionLabelDecorator() != null) {
				tblViewer.update(currentSelection, null);
			}
		}

	}
	
	/**
	 * Control if the last selection should be restored. 
	 * @param refreshWithLastSelection
	 */
	public void setRefreshWithLastSelection(boolean refreshWithLastSelection) {
		this.refreshWithLastSelection = refreshWithLastSelection;
	}
	/**
	 * Refreshes the dialog - has to be called in UI thread.
	 */
	public void refresh() {
		if (tblViewer != null && !tblViewer.getTable().isDisposed()) {

			List<?> lastRefreshSelection = ((StructuredSelection) tblViewer
					.getSelection()).toList();
			tblViewer.getTable().deselectAll();

			tblViewer.setItemCount(contentProvider.getNumberOfElements());
			tblViewer.refresh();

			listLabel
					.setText(contentProvider.getNumberOfElements() > 0 ? "Items: "
							+ contentProvider.getNumberOfElements()
							: "");

			if (tblViewer.getTable().getItemCount() > 0) {
				// preserve previous selection
				if (refreshWithLastSelection && lastRefreshSelection != null
						&& lastRefreshSelection.size() > 0) {
					tblViewer.setSelection(new StructuredSelection(
							lastRefreshSelection));
				} else {
					refreshWithLastSelection = true;
					tblViewer.setSelection(StructuredSelection.EMPTY);
//					tblViewer.getTable().setSelection(0);
//					tblViewer.getTable().notifyListeners(SWT.Selection,
//							new Event());
				}
			} else {
				tblViewer.setSelection(StructuredSelection.EMPTY);
			}

		}

		scheduleProgressMessageRefresh();
	}

	/**
	 * Updates the progress label.
	 * 
	 * @deprecated
	 */
	public void updateProgressLabel() {
		scheduleProgressMessageRefresh();
	}

	public void setAdapterFactory(AdapterFactory adapterFactory) {
		contentProvider.setAdapterFactory(adapterFactory);
	}

	/**
	 * Notifies the content provider - fires filtering of content provider
	 * elements. During the filtering, a separator between history and workspace
	 * matches is added.
	 * <p>
	 * This is a long running operation and should be called in a job.
	 * 
	 * @param checkDuplicates
	 *            <code>true</code> if data concerning elements duplication
	 *            should be computed - it takes much more time than the standard
	 *            filtering
	 * @param monitor
	 *            a progress monitor or <code>null</code> if no monitor is
	 *            available
	 */
	public void reloadCache(boolean checkDuplicates, IProgressMonitor monitor) {
		if (tblViewer != null && !tblViewer.getTable().isDisposed()
				&& contentProvider != null) {
			contentProvider.reloadCache(checkDuplicates, monitor);
		}
	}

	/**
	 * Schedule refresh job.
	 */
	public void scheduleRefreshCache() {
		refreshCacheJob.cancelAll();
		refreshCacheJob.schedule();
	}

	/**
	 * Schedules progress message refresh.
	 */
	public void scheduleProgressMessageRefresh() {
		if (filterJob.getState() != Job.RUNNING
				&& refreshProgressMessageJob.getState() != Job.RUNNING)
			refreshProgressMessageJob.scheduleProgressRefresh(null);
	}

	/**
	 * Validates the item. When items on the items list are selected or
	 * deselected, it validates each item in the selection and the dialog status
	 * depends on all validations.
	 * 
	 * @param item
	 *            an item to be checked
	 * @return status of the dialog to be set
	 */
	protected abstract IStatus validateItem(Object item);

	/**
	 * Creates an instance of a filter.
	 * 
	 * @return a filter for items on the items list. Can be <code>null</code>,
	 *         no filtering will be applied then, causing no item to be shown in
	 *         the list.
	 */
	protected abstract IItemsFilter createFilter();

	/**
	 * Applies the filter created by <code>createFilter()</code> method to the
	 * items list. When new filter is different than previous one it will cause
	 * refiltering.
	 */
	public void applyFilter() {

		IItemsFilter newFilter = createFilter();

		// don't apply filtering for patterns which mean the same, for example:
		// *a**b and ***a*b
		if (filter != null && filter.equalsFilter(newFilter)) {
			return;
		}

		filterJob.cancel();
		this.filter = newFilter;

		if (this.filter != null) {
			filterJob.schedule();
		}
	}

	/**
	 * Clear the last completed filter.
	 */
	public void clearFilter() {
		lastCompletedFilter = null;
	}

	/**
	 * Returns comparator to sort items inside content provider. Returned object
	 * will be probably created as an anonymous class. Parameters passed to the
	 * <code>compare(java.lang.Object, java.lang.Object)</code> are going to be
	 * the same type as the one used in the content provider.
	 * 
	 * @return comparator to sort items content provider
	 */

	protected abstract <T> Comparator<T> getItemsComparator();

	/**
	 * Fills the content provider with matching items.
	 * 
	 * @param contentProvider
	 *            collector to add items to.
	 *            {@link FilteredItemsSelectionDialog.AbstractContentProvider#addItem(Object, FilteredItemsSelectionDialog.ItemsFilter)}
	 *            only adds items that pass the given <code>itemsFilter</code>.
	 * @param itemsFilter
	 *            the items filter
	 * @param progressMonitor
	 *            must be used to report search progress. The state of this
	 *            progress monitor reflects the state of the filtering process.
	 * @throws CoreException
	 */
	protected abstract void fillContentProvider(
			AbstractContentProvider contentProvider, IItemsFilter itemsFilter,
			IProgressMonitor progressMonitor) throws CoreException;

	/**
	 * Indicates whether the given item is a duplicate.
	 * 
	 * @param item
	 *            the item to be investigated
	 * @return <code>true</code> if the item is duplicate, <code>false</code>
	 *         otherwise
	 */
	public boolean isDuplicateElement(Object item) {
		return this.contentProvider.isDuplicateElement(item);
	}

	/**
	 * Returns name for then given object.
	 * 
	 * @param item
	 *            an object from the content provider. Subclasses should pay
	 *            attention to the passed argument. They should either only pass
	 *            objects of a known type (one used in content provider) or make
	 *            sure that passed parameter is the expected one (by type
	 *            checking like <code>instanceof</code> inside the method).
	 * @return name of the given item
	 */
	public abstract String getElementName(Object item);

	/**
	 * Only refreshes UI on the basis of an already sorted and filtered set of
	 * items.
	 * <p>
	 * Standard invocation scenario:
	 * <ol>
	 * <li>filtering job (<code>FilterJob</code> class extending
	 * <code>Job</code> class)</li>
	 * <li>cache refresh without checking for duplicates (
	 * <code>RefreshCacheJob</code> class extending <code>Job</code> class)</li>
	 * <li>UI refresh (<code>RefreshJob</code> class extending
	 * <code>UIJob</code> class)</li>
	 * <li>cache refresh with checking for duplicates
	 * (<cod>CacheRefreshJob</code> class extending <code>Job</code> class)</li>
	 * <li>UI refresh (<code>RefreshJob</code> class extending
	 * <code>UIJob</code> class)</li>
	 * </ol>
	 * The scenario is rather complicated, but it had to be applied, because:
	 * <ul>
	 * <li>refreshing cache is rather a long action and cannot be run in the UI
	 * - cannot be run in a UIJob</li>
	 * <li>refreshing cache checking for duplicates is twice as long as
	 * refreshing cache without checking for duplicates; results of the search
	 * could be displayed earlier</li>
	 * <li>refreshing the UI have to be run in a UIJob</li>
	 * </ul>
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.FilterJob
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.RefreshJob
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.RefreshCacheJob
	 */
	private class RefreshJob extends UIJob {

		/**
		 * Creates a new instance of the class.
		 */
		public RefreshJob() {
			super("refresh");
			setSystem(true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime
		 * .IProgressMonitor)
		 */
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if (monitor.isCanceled())
				return new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						IStatus.OK, EMPTY_STRING, null);

			if (AbstractSmartTableViewerComponent.this != null) {
				AbstractSmartTableViewerComponent.this.refresh();
			}

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK,
					EMPTY_STRING, null);
		}

	}

	/**
	 * Refreshes the progress message cyclically with 500 milliseconds delay.
	 * <code>RefreshProgressMessageJob</code> is strictly connected with
	 * <code>GranualProgressMonitor</code> and use it to to get progress message
	 * and to decide about break of cyclical refresh.
	 */
	private class RefreshProgressMessageJob extends UIJob {

		private GranualProgressMonitor progressMonitor;

		/**
		 * Creates a new instance of the class.
		 */
		public RefreshProgressMessageJob() {
			super("refresh progress");
			setSystem(true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime
		 * .IProgressMonitor)
		 */
		public IStatus runInUIThread(IProgressMonitor monitor) {

			if (!progressLabel.isDisposed()) {
				String p = (progressMonitor != null ? progressMonitor
						.getMessage() : EMPTY_STRING);
				progressLabel.setText(p);
				if (ScreensActivator.DEBUG) {
					ScreensActivator.TRACE.trace(
							ScreensActivator.TRACE_SCREENS_OPTION,
							"Refresh Progress called msg:" + p);
				}
			}
			if (progressMonitor == null || progressMonitor.isDone()) {
				return new Status(IStatus.CANCEL, PlatformUI.PLUGIN_ID,
						IStatus.CANCEL, EMPTY_STRING, null);
			}

			// Schedule cyclical with 500 milliseconds delay
			schedule(200);

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK,
					EMPTY_STRING, null);
		}

		/**
		 * Schedule progress refresh job.
		 * 
		 * @param progressMonitor
		 *            used during refresh progress label
		 */
		public void scheduleProgressRefresh(
				GranualProgressMonitor progressMonitor) {
			this.progressMonitor = progressMonitor;
			// Schedule with initial delay to avoid flickering when the user
			// types quickly
			schedule(200);
		}

	}

	/**
	 * A job responsible for computing filtered items list presented using
	 * <code>RefreshJob</code>.
	 * 
	 * @see FilteredItemsSelectionDialog.RefreshJob
	 * 
	 */
	private class RefreshCacheJob extends Job {

		private RefreshJob refreshJob = new RefreshJob();

		/**
		 * Creates a new instance of the class.
		 */
		public RefreshCacheJob() {
			super("Refresh Cache");
			setSystem(true);
		}

		/**
		 * Stops the job and all sub-jobs.
		 */
		public void cancelAll() {
			cancel();
			refreshJob.cancel();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
		 * IProgressMonitor)
		 */
		protected IStatus run(IProgressMonitor monitor) {

			if (ScreensActivator.DEBUG) {
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"reloading cache job invoked");
			}

			if (monitor.isCanceled()) {
				return new Status(IStatus.CANCEL, ScreensActivator.PLUGIN_ID,
						IStatus.CANCEL, EMPTY_STRING, null);
			}

			if (AbstractSmartTableViewerComponent.this != null) {
				GranualProgressMonitor wrappedMonitor = new GranualProgressMonitor(
						monitor);
				AbstractSmartTableViewerComponent.this.reloadCache(true,
						wrappedMonitor);
			}

			if (!monitor.isCanceled()) {
				refreshJob.schedule();
			}

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK,
					EMPTY_STRING, null);

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.jobs.Job#canceling()
		 */
		protected void canceling() {
			super.canceling();
			contentProvider.stopReloadingCache();
		}

	}

	private static boolean showColoredLabels() {
		return PlatformUI.getPreferenceStore().getBoolean(
				IWorkbenchPreferenceConstants.USE_COLORED_LABELS);
	}

	private class ItemsLabelProvider extends StyledCellLabelProvider implements
			ILabelProviderListener {
		private IBaseLabelProvider provider;

		private ILabelDecorator selectionDecorator;

		// Need to keep our own list of listeners
		private ListenerList listeners = new ListenerList();

		/**
		 * Creates a new instance of the class.
		 * 
		 * @param provider
		 *            the label provider for all items, not <code>null</code>
		 * @param selectionDecorator
		 *            the decorator for selected items, can be <code>null</code>
		 */
		public ItemsLabelProvider(ILabelProvider provider,
				ILabelDecorator selectionDecorator) {
			Assert.isNotNull(provider);
			this.provider = provider;
			this.selectionDecorator = selectionDecorator;

			setOwnerDrawEnabled(showColoredLabels()
					&& provider instanceof IStyledLabelProvider);

			provider.addListener(this);

			if (selectionDecorator != null) {
				selectionDecorator.addListener(this);
			}
		}

		/**
		 * Sets new selection decorator.
		 * 
		 * @param newSelectionDecorator
		 *            new label decorator for selected items in the list
		 */
		public void setSelectionDecorator(ILabelDecorator newSelectionDecorator) {
			if (selectionDecorator != null) {
				selectionDecorator.removeListener(this);
				selectionDecorator.dispose();
			}

			selectionDecorator = newSelectionDecorator;

			if (selectionDecorator != null) {
				selectionDecorator.addListener(this);
			}
		}

		/**
		 * Gets selection decorator.
		 * 
		 * @return the label decorator for selected items in the list
		 */
		public ILabelDecorator getSelectionDecorator() {
			return selectionDecorator;
		}

		/**
		 * Sets new label provider.
		 * 
		 * @param newProvider
		 *            new label provider for items in the list, not
		 *            <code>null</code>
		 */
		public void setProvider(IBaseLabelProvider newProvider) {
			Assert.isNotNull(newProvider);
			provider.removeListener(this);
			provider.dispose();

			provider = newProvider;

			if (provider != null) {
				provider.addListener(this);
			}

			setOwnerDrawEnabled(showColoredLabels()
					&& provider instanceof IStyledLabelProvider);
		}

		private Image getImage(Object element, int columnIndex) {
			if (provider instanceof ITableLabelProvider) {
				return ((ITableLabelProvider) provider).getColumnImage(element,
						columnIndex);
			} else if (provider instanceof ILabelProvider && columnIndex == 0) {
				return ((ILabelProvider) provider).getImage(element);
			}
			return null;
		}

		private boolean isSelected(Object element) {
			if (element != null && currentSelection != null) {
				for (int i = 0; i < currentSelection.length; i++) {
					if (element.equals(currentSelection[i]))
						return true;
				}
			}
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		private String getText(Object element, int columnIndex) {

			String str = "";
			if (provider instanceof ITableLabelProvider) {
				str = ((ITableLabelProvider) provider).getColumnText(element,
						columnIndex);

			} else if (provider instanceof ILabelProvider && columnIndex == 0) {
				str = ((ILabelProvider) provider).getText(element);
			}

			if (selectionDecorator != null && isSelected(element)) {
				return selectionDecorator.decorateText(str.toString(), element);
			}

			return str;
		}

		private StyledString getStyledText(Object element, int i,
				IStyledLabelProvider provider) {

			StyledString string = provider.getStyledText(element);

			if (selectionDecorator != null && isSelected(element)) {
				String decorated = selectionDecorator.decorateText(
						string.getString(), element);
				return StyledCellLabelProvider.styleDecoratedString(decorated,
						null, string);
				// no need to add colors when element is selected
			}
			return string;
		}

		public void update(ViewerCell cell) {
			Object element = cell.getElement();

			// TODO We could also check for CellLabelProvider, to delegate the
			// full update method.
			if (provider instanceof IStyledLabelProvider) {
				IStyledLabelProvider styledLabelProvider = (IStyledLabelProvider) provider;
				StyledString styledString = getStyledText(element,
						cell.getColumnIndex(), styledLabelProvider);

				cell.setText(styledString.getString());
				cell.setStyleRanges(styledString.getStyleRanges());
				cell.setImage(styledLabelProvider.getImage(element));
			} else {
				cell.setText(getText(element, cell.getColumnIndex()));
				cell.setImage(getImage(element, cell.getColumnIndex()));
			}
			cell.setFont(getFont(element));
			cell.setForeground(getForeground(element));
			cell.setBackground(getBackground(element));

			super.update(cell);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse
		 * .jface.viewers.ILabelProviderListener)
		 */
		public void addListener(ILabelProviderListener listener) {
			listeners.add(listener);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
		 */
		public void dispose() {
			provider.removeListener(this);
			provider.dispose();

			if (selectionDecorator != null) {
				selectionDecorator.removeListener(this);
				selectionDecorator.dispose();
			}

			super.dispose();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java
		 * .lang.Object, java.lang.String)
		 */
		public boolean isLabelProperty(Object element, String property) {
			if (provider.isLabelProperty(element, property)) {
				return true;
			}
			if (selectionDecorator != null
					&& selectionDecorator.isLabelProperty(element, property)) {
				return true;
			}
			return false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse
		 * .jface.viewers.ILabelProviderListener)
		 */
		public void removeListener(ILabelProviderListener listener) {
			listeners.remove(listener);
		}

		private Color getBackground(Object element) {
			if (provider instanceof IColorProvider) {
				return ((IColorProvider) provider).getBackground(element);
			}
			return null;
		}

		private Color getForeground(Object element) {
			if (provider instanceof IColorProvider) {
				return ((IColorProvider) provider).getForeground(element);
			}
			return null;
		}

		private Font getFont(Object element) {
			if (provider instanceof IFontProvider) {
				return ((IFontProvider) provider).getFont(element);
			}
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ILabelProviderListener#labelProviderChanged
		 * (org.eclipse.jface.viewers.LabelProviderChangedEvent)
		 */
		public void labelProviderChanged(LabelProviderChangedEvent event) {
			Object[] l = listeners.getListeners();
			for (int i = 0; i < listeners.size(); i++) {
				((ILabelProviderListener) l[i]).labelProviderChanged(event);
			}
		}
	}

	/**
	 * GranualProgressMonitor is used for monitoring progress of filtering
	 * process. It is used by <code>RefreshProgressMessageJob</code> to refresh
	 * progress message. State of this monitor illustrates state of filtering or
	 * cache refreshing process.
	 * 
	 */
	private class GranualProgressMonitor extends ProgressMonitorWrapper {

		private String name;

		private String subName;

		private int totalWork;

		private double worked;

		private boolean done;

		/**
		 * Creates instance of <code>GranualProgressMonitor</code>.
		 * 
		 * @param monitor
		 *            progress to be wrapped
		 */
		public GranualProgressMonitor(IProgressMonitor monitor) {
			super(monitor);
		}

		/**
		 * Checks if filtering has been done
		 * 
		 * @return true if filtering work has been done false in other way
		 */
		public boolean isDone() {
			return done;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.runtime.ProgressMonitorWrapper#setTaskName(java.
		 * lang.String)
		 */
		public void setTaskName(String name) {
			super.setTaskName(name);
			this.name = name;
			this.subName = null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.runtime.ProgressMonitorWrapper#subTask(java.lang
		 * .String)
		 */
		public void subTask(String name) {
			super.subTask(name);
			this.subName = name;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.runtime.ProgressMonitorWrapper#beginTask(java.lang
		 * .String, int)
		 */
		public void beginTask(String name, int totalWork) {
			super.beginTask(name, totalWork);
			if (this.name == null)
				this.name = name;
			this.totalWork = totalWork;
			refreshProgressMessageJob.scheduleProgressRefresh(this);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.ProgressMonitorWrapper#worked(int)
		 */
		public void worked(int work) {
			super.worked(work);
			internalWorked(work);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.ProgressMonitorWrapper#done()
		 */
		public void done() {
			done = true;
			super.done();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.runtime.ProgressMonitorWrapper#setCanceled(boolean)
		 */
		public void setCanceled(boolean b) {
			done = b;
			super.setCanceled(b);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.runtime.ProgressMonitorWrapper#internalWorked(double
		 * )
		 */
		public void internalWorked(double work) {
			worked = worked + work;
		}

		private String getMessage() {
			if (done)
				return ""; //$NON-NLS-1$

			String message;

			if (name == null) {
				message = subName == null ? "" : subName; //$NON-NLS-1$
			} else {
				message = subName == null ? name : name + " " + subName;
			}
			if (totalWork == 0)
				return message;

			return message
					+ ": "
					+ new Integer((int) ((worked * 100) / totalWork))
							.toString() + " %";

		}

	}

	/**
	 * Filters items in indicated set and history. During filtering, it
	 * refreshes the dialog (progress monitor and elements list).
	 * 
	 * Depending on the filter, <code>FilterJob</code> decides which kind of
	 * search will be run inside <code>filterContent</code>. If the last
	 * filtering is done (last completed filter), is not null, and the new
	 * filter is a sub-filter (
	 * {@link FilteredItemsSelectionDialog.ItemsFilter#isSubFilter(FilteredItemsSelectionDialog.ItemsFilter)}
	 * ) of the last, then <code>FilterJob</code> only filters in the cache. If
	 * it is the first filtering or the new filter isn't a sub-filter of the
	 * last one, a full search is run.
	 */
	private class FilterJob extends Job {

		/**
		 * Filter used during the filtering process.
		 */
		protected IItemsFilter itemsFilter;

		/**
		 * Creates new instance of FilterJob
		 */
		public FilterJob() {
			super("Filter Job");
			setSystem(true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
		 * IProgressMonitor)
		 */
		protected final IStatus run(IProgressMonitor parent) {
			GranualProgressMonitor monitor = new GranualProgressMonitor(parent);
			return doRun(monitor);
		}

		/**
		 * Executes job using the given filtering progress monitor. A hook for
		 * subclasses.
		 * 
		 * @param monitor
		 *            progress monitor
		 * @return result of the execution
		 */
		protected IStatus doRun(GranualProgressMonitor monitor) {
			try {
				internalRun(monitor);
			} catch (CoreException e) {
				cancel();
				return new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID,
						IStatus.ERROR, "Error", e);
			}
			return Status.OK_STATUS;
		}

		/**
		 * Main method for the job.
		 * 
		 * @param monitor
		 * @throws CoreException
		 */
		private void internalRun(GranualProgressMonitor monitor)
				throws CoreException {

			if (ScreensActivator.DEBUG) {
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"Filter Job Invoked");
			}

			// Reset the content
			contentProvider.reset();

			// Clear our cache.
			// contentProvider.reloadCache();

			try {
				if (monitor.isCanceled())
					return;

				this.itemsFilter = filter;

				if (!filter.getPattern().isEmpty()) {
					filterContent(monitor);
				}

				if (monitor.isCanceled())
					return;

				contentProvider.reloadCache();
			} finally {
				monitor.done();
			}
		}

		/**
		 * Filters items.
		 * 
		 * @param monitor
		 *            for monitoring progress
		 * @throws CoreException
		 */
		protected void filterContent(GranualProgressMonitor monitor)
				throws CoreException {

			if (lastCompletedFilter != null
					&& lastCompletedFilter.isSubFilter(this.itemsFilter)) {

				if (ScreensActivator.DEBUG) {
					ScreensActivator.TRACE.trace(
							ScreensActivator.TRACE_SCREENS_OPTION,
							"Current filter is a subfilter of: \""
									+ lastCompletedFilter.getPattern()
									+ "\", add matching items");
				}

				int length = lastCompletedResult.size() / 500;
				monitor.beginTask("caching", length);

				for (int pos = 0; pos < lastCompletedResult.size(); pos++) {

					Object item = lastCompletedResult.get(pos);
					if (monitor.isCanceled())
						break;
					contentProvider.addItem(item, itemsFilter);

					if ((pos % 500) == 0) {
						monitor.worked(1);
					}
				}

			} else {

				if (ScreensActivator.DEBUG) {
					ScreensActivator.TRACE
							.trace(ScreensActivator.TRACE_SCREENS_OPTION,
									"Current filter is new, (re)fill the content provider: ");
				}

				lastCompletedFilter = null;
				lastCompletedResult = null;

				SubProgressMonitor subMonitor = null;
				if (monitor != null) {
					monitor.beginTask("loading", 100);
					subMonitor = new SubProgressMonitor(monitor, 95);

				}

				fillContentProvider(contentProvider, itemsFilter, subMonitor);

				if (monitor != null && !monitor.isCanceled()) {
					monitor.worked(2);
					contentProvider.rememberResult(itemsFilter);
					monitor.worked(3);
				}
			}

		}

	}

	/**
	 * A Notifier for content change. Adapts to any possible EObject.
	 * Modifications on the model will be reflected by updating the content
	 * provider.
	 * <ul>
	 * <li>Additions => Are directly added to the history</li>
	 * <li>Removals => Are removed from the source content and sorted cache</li>
	 * </ul>
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public class ContentNotification implements INotifyChangedListener {

		private ItemsContentProvider icp;

		public ContentNotification(ItemsContentProvider icp) {
			this.icp = icp;
		}

		public void notifyChanged(Notification msg) {

			// For additions, as we add to history, cache will be reloaded.
			// For removals, explicitly reload the cache.

			if (msg instanceof ViewerNotification) {
				// See AdapterFactoryContentProvider on how to merge viewer
				// Notifications.
			}

			if (ScreensActivator.DEBUG) {
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"Received Notification" + msg);
			}

			final IItemsFilter itemsFilter = filter;

			if (icp == null) {
				return; // duh should not occure.
			}

			if (msg.getEventType() == Notification.ADD) {
				// We should be part of items first.
				// Filter might block the item from becoming visible, so we add
				// it
				// to history.
				Object item = msg.getNewValue();
				icp.addItem(item, itemsFilter);
			} else if (msg.getEventType() == Notification.ADD_MANY) {
				List<?> list = (List<?>) msg.getNewValue();
				for (Object item : list) {
					icp.addItem(item, itemsFilter);
				}
			} else if (msg.getEventType() == Notification.REMOVE) {
				// Removing, from source Items, LastSortedItems, Duplicates &
				// History.
				refreshWithLastSelection = false;
				Object item = msg.getOldValue();
				icp.removeItem(item);
			} else if (msg.getEventType() == Notification.REMOVE_MANY) {
				List<?> list = (List<?>) msg.getOldValue();
				for (Object item : list) {
					icp.removeItem(item);
				}
			}

			// Reload cache if we haven't received a notification within 1
			// second.
			refreshCacheJob.cancelAll();
			refreshCacheJob.schedule(500);
		}
	}

	/**
	 * An interface to content providers for
	 * <code>FilterItemsSelectionDialog</code>.
	 */
	protected abstract class AbstractContentProvider {
		/**
		 * Adds the item to the content provider if the filter matches the item.
		 * Otherwise does nothing.
		 * 
		 * @param item
		 *            the item to add
		 * @param itemsFilter
		 *            the filter
		 * 
		 * @see FilteredItemsSelectionDialog.ItemsFilter#matchItem(Object)
		 */
		public abstract void addItem(Object item, IItemsFilter itemsFilter);

	}

	/**
	 * Collects filtered elements. Contains one synchronized, sorted set for
	 * collecting filtered elements. All collected elements are sorted using
	 * comparator. Comparator is returned by getElementComparator() method.
	 * Implementation of <code>ItemsFilter</code> is used to filter elements.
	 * The key function of filter used in to filtering is
	 * <code>matchElement(Object item)</code>.
	 * <p>
	 * The <code>ContentProvider</code> class also provides item filtering
	 * methods. The filtering has been moved from the standard TableView
	 * <code>getFilteredItems()</code> method to content provider, because
	 * <code>ILazyContentProvider</code> and virtual tables are used. This class
	 * is responsible for adding a separator below history items and marking
	 * each items as duplicate if its name repeats more than once on the
	 * filtered list.
	 */
	private class ItemsContentProvider extends AbstractContentProvider
			implements IStructuredContentProvider, ILazyContentProvider {

		private ContentNotification contentNotification;

		public ContentNotification getContentNotification() {
			return contentNotification;
		}

		/**
		 * Raw result of the searching (unsorted, unfiltered).
		 * <p>
		 * Standard object flow:
		 * <code>items -> lastSortedItems -> lastFilteredItems</code>
		 */
		private Set<Object> items;

		/**
		 * Items that are duplicates.
		 */
		private Set<Object> duplicates;

		/**
		 * List of <code>ViewerFilter</code>s to be used during filtering
		 */
		private List<ViewerFilter> filters;

		/**
		 * Result of the last filtering.
		 * <p>
		 * Standard object flow:
		 * <code>items -> lastSortedItems -> lastFilteredItems</code>
		 */
		private List<Object> lastFilteredItems;

		/**
		 * Result of the last sorting.
		 * <p>
		 * Standard object flow:
		 * <code>items -> lastSortedItems -> lastFilteredItems</code>
		 */
		private List<Object> lastSortedItems;

		/**
		 * Used for <code>getFilteredItems()</code> method canceling (when the
		 * job that invoked the method was canceled).
		 * <p>
		 * Method canceling could be based (only) on monitor canceling
		 * unfortunately sometimes the method <code>getFilteredElements()</code>
		 * could be run with a null monitor, the <code>reset</code> flag have to
		 * be left intact.
		 */
		private boolean reset;

		private AdapterFactory adapterFactory;

		/**
		 * Creates new instance of <code>ContentProvider</code>.
		 */
		public ItemsContentProvider() {
			this.items = Collections.synchronizedSet(new LinkedHashSet<Object>(
					2048));
			this.duplicates = Collections.synchronizedSet(new HashSet<Object>(
					256));
			this.lastFilteredItems = new LinkedList<Object>();
			this.lastSortedItems = Collections
					.synchronizedList(new LinkedList<Object>());

			contentNotification = new ContentNotification(this);
		}

		/**
		 * Removes all content items and resets progress message.
		 */
		public void reset() {
			reset = true;
			this.items.clear();
			this.duplicates.clear();
			this.lastSortedItems.clear();
		}

		/**
		 * Stops reloading cache - <code>getFilteredItems()</code> method.
		 */
		public void stopReloadingCache() {
			reset = true;
		}

		/**
		 * Adds filtered item.
		 * 
		 * @param item
		 * @param itemsFilter
		 */

		public void addItem(Object item, IItemsFilter itemsFilter) {
			if (itemsFilter == filter) {
				if (itemsFilter != null) {
					if (itemsFilter.matchItem(item)) {
						this.items.add(item);
					}
				} else {
					this.items.add(item);
				}
			}
		}

		/**
		 * Remove an item. (Remove it from items, will recreated the sorted copy
		 * and apply duplicate check).
		 * 
		 * @param item
		 */
		public void removeItem(Object item) {
			items.remove(item);
			lastSortedItems.remove(item);
			duplicates.remove(item);
		}

		/**
		 * Refresh dialog.
		 */
		public void reloadCache() {
			scheduleRefreshCache();
		}

		/**
		 * Sets/unsets given item as duplicate.
		 * 
		 * @param item
		 *            item to change
		 * 
		 * @param isDuplicate
		 *            duplicate flag
		 */
		public void setDuplicateElement(Object item, boolean isDuplicate) {
			if (this.items.contains(item)) {
				if (isDuplicate)
					this.duplicates.add(item);
				else
					this.duplicates.remove(item);
			}
		}

		/**
		 * This sets the wrapped factory. If the adapter factory is an
		 * {@link IChangeNotifier}, a listener is added to it, so it's important
		 * to call {@link #dispose()}.
		 */
		public void setAdapterFactory(AdapterFactory adapterFactory) {
			if (this.adapterFactory instanceof IChangeNotifier) {
				((IChangeNotifier) this.adapterFactory).removeListener(this
						.getContentNotification());
			}

			if (adapterFactory instanceof IChangeNotifier) {
				((IChangeNotifier) adapterFactory).addListener(this
						.getContentNotification());
			}

			this.adapterFactory = adapterFactory;
		}

		/**
		 * Indicates whether given item is a duplicate.
		 * 
		 * @param item
		 *            item to check
		 * @return <code>true</code> if item is duplicate
		 */
		public boolean isDuplicateElement(Object item) {
			return duplicates.contains(item);
		}

		/**
		 * Gets sorted items.
		 * 
		 * CB Customize, to not sort, but simply invert the list, matching the
		 * order in which items were added.
		 * 
		 * 
		 * @return sorted items
		 */
		private Object[] getSortedItems() {
			if (lastSortedItems.size() != items.size()) {
				synchronized (lastSortedItems) {
					lastSortedItems.clear();

					if (ScreensActivator.DEBUG) {
						ScreensActivator.TRACE.trace(
								ScreensActivator.TRACE_SCREENS_OPTION,
								"updating sorting list with " + items.size()
										+ " items");
					}

					lastSortedItems.addAll(items);
					Collections.sort(lastSortedItems, getItemsComparator());
					// Alternative soring, why?
					// lastSortedItems.addAll(Ordering.from(getItemsComparator()).reverse().sortedCopy(items));

				}
			}
			return lastSortedItems.toArray();
		}

		/**
		 * Remember result of filtering.
		 * 
		 * @param itemsFilter
		 */
		public void rememberResult(IItemsFilter itemsFilter) {
			List<Object> itemsList = Collections.synchronizedList(Arrays
					.asList(getSortedItems()));
			// synchronization
			if (itemsFilter == filter) {
				lastCompletedFilter = itemsFilter;
				lastCompletedResult = itemsList;
			}

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(
		 * java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			return lastFilteredItems.toArray();
		}

		public int getNumberOfElements() {
			return lastFilteredItems.size();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse
		 * .jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput instanceof Notifier) {
				// Attach a Content Notifier to the adapterfactory.
				// The reflective Item provider is always attached to the
				// content, no need to
				// adapt to
				if (adapterFactory != null) {
					// Object adapt = adapterFactory.adapt(newInput,
					// IChangeNotifier.class);
				} else {
					// Notifications won't be supported!
				}

			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ILazyContentProvider#updateElement(int)
		 */
		public void updateElement(int index) {

			AbstractSmartTableViewerComponent.this.tblViewer.replace(
					(lastFilteredItems.size() > index) ? lastFilteredItems
							.get(index) : null, index);

		}

		/**
		 * Main method responsible for getting the filtered items and checking
		 * for duplicates. It is based on the
		 * {@link FilteredItemsSelectionDialog.ContentProvider#getFilteredItems(Object, IProgressMonitor)}
		 * .
		 * 
		 * @param checkDuplicates
		 *            <code>true</code> if data concerning elements duplication
		 *            should be computed - it takes much more time than standard
		 *            filtering
		 * 
		 * @param monitor
		 *            progress monitor
		 */
		public void reloadCache(boolean checkDuplicates,
				IProgressMonitor monitor) {

			reset = false;

			if (monitor != null) {
				// the work is divided into two actions of the same length
				int totalWork = checkDuplicates ? 200 : 100;

				monitor.beginTask("reload cache", totalWork);
			}

			// the TableViewer's root (the input) is treated as parent

			lastFilteredItems = Arrays.asList(getFilteredItems(tblViewer
					.getInput(), monitor != null ? new SubProgressMonitor(
					monitor, 100) : null));

			if (ScreensActivator.DEBUG) {
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"cache size is (incl. separator) : "
								+ lastFilteredItems.size());
			}

			if (reset || (monitor != null && monitor.isCanceled())) {
				if (monitor != null)
					monitor.done();
				return;
			}

			if (checkDuplicates) {
				checkDuplicates(monitor);
			}
			if (monitor != null)
				monitor.done();
		}

		private void checkDuplicates(IProgressMonitor monitor) {
			synchronized (lastFilteredItems) {
				IProgressMonitor subMonitor = null;
				int reportEvery = lastFilteredItems.size() / 20;
				if (monitor != null) {
					subMonitor = new SubProgressMonitor(monitor, 100);
					subMonitor.beginTask("check duplicates", 5);
				}
				HashMap<String, Object> helperMap = new HashMap<String, Object>();
				for (int i = 0; i < lastFilteredItems.size(); i++) {
					if (reset
							|| (subMonitor != null && subMonitor.isCanceled()))
						return;
					Object item = lastFilteredItems.get(i);

					Object previousItem = helperMap.put(getElementName(item),
							item);
					if (previousItem != null) {
						setDuplicateElement(previousItem, true);
						setDuplicateElement(item, true);
					} else {
						setDuplicateElement(item, false);
					}

					if (subMonitor != null && reportEvery != 0
							&& (i + 1) % reportEvery == 0)
						subMonitor.worked(1);
				}
				helperMap.clear();

				if (ScreensActivator.DEBUG) {
					ScreensActivator.TRACE.trace(
							ScreensActivator.TRACE_SCREENS_OPTION,
							"Duplicates check count: " + duplicates.size());
				}
			}
		}

		/**
		 * Returns an array of items filtered using the provided
		 * <code>ViewerFilter</code>s with a separator added.
		 * 
		 * @param parent
		 *            the parent
		 * @param monitor
		 *            progress monitor, can be <code>null</code>
		 * @return an array of filtered items
		 */
		protected Object[] getFilteredItems(Object parent,
				IProgressMonitor monitor) {
			int ticks = 100;
			if (monitor == null) {
				monitor = new NullProgressMonitor();
			}

			monitor.beginTask("get filtered items", ticks);
			if (filters != null) {
				ticks /= (filters.size() + 2);
			} else {
				ticks /= 2;
			}

			// get already sorted array
			Object[] filteredElements = getSortedItems();

			monitor.worked(ticks);

			// filter the elements using provided ViewerFilters
			if (filters != null && filteredElements != null) {
				for (Iterator<ViewerFilter> iter = filters.iterator(); iter
						.hasNext();) {
					ViewerFilter f = (ViewerFilter) iter.next();
					filteredElements = f.filter(tblViewer, parent,
							filteredElements);
					monitor.worked(ticks);
				}
			}
			monitor.done();

			return filteredElements;
		}

		/**
		 * Adds a filter to this content provider.
		 * 
		 * @param filter
		 *            the filter to be added
		 */
		public void addFilter(ViewerFilter filter) {
			if (filters == null) {
				filters = new ArrayList<ViewerFilter>();
			}
			filters.add(filter);
			// currently filters are only added when dialog is restored
			// if it is changed, refreshing the whole TableViewer should be
			// added
		}

		/**
		 * Get all the filters.
		 * 
		 * @return
		 */
		public List<ViewerFilter> getFilters() {
			return filters;
		}

	}

	public TableViewer getTableViewer() {
		return tblViewer;
	}

}

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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.LegacyActionTools;
import org.eclipse.jface.action.MenuManager;
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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
import org.eclipse.ui.internal.WorkbenchImages;
import org.eclipse.ui.progress.UIJob;

import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * Shows a list of items to the user with a text entry field for a string
 * pattern used to filter the list of items.
 * 
 * 
 * Christophe Bouhier
 * 
 * Customization, with SurpressWarnings on restrictions. (Mostly I18N
 * references), The ContentProvider maintains LinkedLists, to maintain the
 * order, and skips the sorter
 * 
 * 
 */
@SuppressWarnings({ "restriction", "unchecked", "rawtypes" })
public abstract class AbstractLazyTableViewer {

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

	private Text pattern;

	/*
	 * Expose for selection handling.
	 */
	protected TableViewer tblViewer;

	private ItemsLabelProvider itemsListLabelProvider;

	private MenuManager menuManager;

	private MenuManager contextMenuManager;

	private boolean multi;

	private Label progressLabel;

	private RemoveHistoryItemAction removeHistoryItemAction;

	private ActionContributionItem removeHistoryActionContributionItem;

	private RefreshCacheJob refreshCacheJob;

	private RefreshProgressMessageJob refreshProgressMessageJob = new RefreshProgressMessageJob();

	private Object[] currentSelection;

	private ItemsContentProvider contentProvider;

	private FilterHistoryJob filterHistoryJob;

	private FilterJob filterJob;

	private ItemsFilter filter;

	private List<?> lastCompletedResult;

	private ItemsFilter lastCompletedFilter;

	private String initialPatternText;

	private int selectionMode;

	private ItemsListSeparator itemsListSeparator;

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	/*
	 * When refreshing the UI, the selection can be restored if this flag is
	 * true
	 */
	private boolean refreshWithLastSelection = false;

	private IHandlerActivation showViewHandler;

	/**
	 * Creates a new instance of the class.
	 * 
	 * @param shell
	 *            shell to parent the dialog on
	 * @param multi
	 *            indicates whether dialog allows to select more than one
	 *            position in its list of items
	 */
	public AbstractLazyTableViewer(Shell shell, boolean multi) {
		this.multi = multi;
		filterHistoryJob = new FilterHistoryJob();
		filterJob = new FilterJob();
		contentProvider = new ItemsContentProvider();
		refreshCacheJob = new RefreshCacheJob();
		itemsListSeparator = new ItemsListSeparator("Matches");
		selectionMode = NONE;
	}

	/**
	 * Creates a new instance of the class. Created dialog won't allow to select
	 * more than one item.
	 * 
	 * @param shell
	 *            shell to parent the dialog on
	 */
	public AbstractLazyTableViewer(Shell shell) {
		this(shell, false);
	}

	/**
	 * Adds viewer filter to the dialog items list.
	 * 
	 * @param filter
	 *            the new filter
	 */
	protected void addListFilter(ViewerFilter filter) {
		contentProvider.addFilter(filter);
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

	/**
	 * Restores using persisted settings. The default implementation restores
	 * the status of the selection history.
	 * 
	 * @param settings
	 *            settings used to restore dialog
	 */
	protected void restoreState(IMemento memento) {
		this.contentProvider.loadHistory(memento);
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

		if (menuManager != null)
			menuManager.dispose();
		if (contextMenuManager != null)
			contextMenuManager.dispose();

		// CB TODO, called from the outside, as we don't close.
		// storeDialog();
		return true;
	}

	/**
	 * Stores the settings.
	 * 
	 * @param settings
	 *            settings used to store dialog
	 */
	protected void saveState(IMemento memento) {
		this.contentProvider.saveHistory(memento);
	}

	public void addToHistory(Object item) {
		accessedHistoryItem(item);
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

		// Skip traversal of this header.
		headerLabel.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_MNEMONIC && e.doit) {
					e.detail = SWT.TRAVERSE_NONE;
					pattern.setFocus();
				}
			}
		});

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

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		labels.setLayout(layout);

		Label listLabel = toolkit.createLabel(labels, "Matching Items",
				SWT.NONE);

		listLabel.addTraverseListener(new TraverseListener() {
			public void keyTraversed(TraverseEvent e) {
				if (e.detail == SWT.TRAVERSE_MNEMONIC && e.doit) {
					e.detail = SWT.TRAVERSE_NONE;
					tblViewer.getTable().setFocus();
				}
			}
		});

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		listLabel.setLayoutData(gd);

		progressLabel = toolkit.createLabel(labels, "", SWT.RIGHT);
		progressLabel.setLayoutData(gd);

		labels.setLayoutData(gd);
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
	 * Hook that allows to add actions to the context menu.
	 * <p>
	 * Subclasses may extend in order to add other actions.
	 * </p>
	 * 
	 * @param menuManager
	 *            the context menu manager
	 * @since 3.5
	 */
	protected void fillContextMenu(IMenuManager menuManager) {
		List selectedElements = ((StructuredSelection) tblViewer.getSelection())
				.toList();

		Object item = null;

		for (Iterator it = selectedElements.iterator(); it.hasNext();) {
			item = it.next();
			if (item instanceof ItemsListSeparator || !isHistoryElement(item)) {
				return;
			}
		}

		if (selectedElements.size() > 0) {
			removeHistoryItemAction.setText("Remove from history");

			menuManager.add(removeHistoryActionContributionItem);

		}
	}

	private void createPopupMenu() {
		removeHistoryItemAction = new RemoveHistoryItemAction();
		removeHistoryActionContributionItem = new ActionContributionItem(
				removeHistoryItemAction);

		contextMenuManager = new MenuManager();
		contextMenuManager.setRemoveAllWhenShown(true);
		contextMenuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});

		final Table table = tblViewer.getTable();
		Menu menu = contextMenuManager.createContextMenu(table);
		table.setMenu(menu);
	}

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
		content.setLayout(layout);

		// CB Decide later. Do not build the header for now.
		// final Label headerLabel = createHeader(content);

		pattern = toolkit.createText(content, "", SWT.SINGLE | SWT.BORDER
				| SWT.SEARCH | SWT.ICON_CANCEL);

		// pattern = new Text(content, SWT.SINGLE | SWT.BORDER | SWT.SEARCH
		// | SWT.ICON_CANCEL);

		// pattern.getAccessible().addAccessibleListener(new AccessibleAdapter()
		// {
		// public void getName(AccessibleEvent e) {
		// e.result = LegacyActionTools.removeMnemonics(headerLabel
		// .getText());
		// }
		// });

		gd = new GridData(GridData.FILL_HORIZONTAL);
		pattern.setLayoutData(gd);

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

		createPopupMenu();

		pattern.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				applyFilter();
			}
		});

		pattern.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					if (tblViewer.getTable().getItemCount() > 0) {
						tblViewer.getTable().setFocus();
					}
				}
			}
		});

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

		tblViewer.getTable().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				if (e.keyCode == SWT.DEL) {

					List<?> selectedElements = ((StructuredSelection) tblViewer
							.getSelection()).toList();

					Object item = null;
					boolean isSelectedHistory = true;

					for (Iterator<?> it = selectedElements.iterator(); it
							.hasNext();) {
						item = it.next();
						if (item instanceof ItemsListSeparator
								|| !isHistoryElement(item)) {
							isSelectedHistory = false;
							break;
						}
					}
					if (isSelectedHistory)
						removeSelectedItems(selectedElements);

				}

				if (e.keyCode == SWT.ARROW_UP && (e.stateMask & SWT.SHIFT) != 0
						&& (e.stateMask & SWT.CTRL) != 0) {
					StructuredSelection selection = (StructuredSelection) tblViewer
							.getSelection();

					if (selection.size() == 1) {
						Object element = selection.getFirstElement();
						if (element.equals(tblViewer.getElementAt(0))) {
							pattern.setFocus();
						}
						if (tblViewer.getElementAt(tblViewer.getTable()
								.getSelectionIndex() - 1) instanceof ItemsListSeparator)
							tblViewer.getTable()
									.setSelection(
											tblViewer.getTable()
													.getSelectionIndex() - 1);
						tblViewer.getTable().notifyListeners(SWT.Selection,
								new Event());

					}
				}

				if (e.keyCode == SWT.ARROW_DOWN
						&& (e.stateMask & SWT.SHIFT) != 0
						&& (e.stateMask & SWT.CTRL) != 0) {

					if (tblViewer.getElementAt(tblViewer.getTable()
							.getSelectionIndex() + 1) instanceof ItemsListSeparator)
						tblViewer.getTable().setSelection(
								tblViewer.getTable().getSelectionIndex() + 1);
					tblViewer.getTable().notifyListeners(SWT.Selection,
							new Event());
				}

			}
		});

		createExtendedContentArea(content);

		// CB restore is done externally.
		// restoreDialog(getDialogSettings());

		if (initialPatternText != null) {
			pattern.setText(initialPatternText);
		}

		switch (selectionMode) {
		case CARET_BEGINNING:
			pattern.setSelection(0, 0);
			break;
		case FULL_SELECTION:
			pattern.setSelection(0, initialPatternText.length());
			break;
		}

		// apply filter even if pattern is empty (display history)
		// Note, as our transaction won't be set yet. delay this after our data
		// has been injected.
		// applyFilter();

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

				if (o instanceof ItemsListSeparator) {
					continue;
				}

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
	 * Refreshes the dialog - has to be called in UI thread.
	 */
	public void refresh() {
		if (tblViewer != null && !tblViewer.getTable().isDisposed()) {

			List<?> lastRefreshSelection = ((StructuredSelection) tblViewer
					.getSelection()).toList();
			tblViewer.getTable().deselectAll();

			tblViewer.setItemCount(contentProvider.getNumberOfElements());
			tblViewer.refresh();

			if (tblViewer.getTable().getItemCount() > 0) {
				// preserve previous selection
				if (refreshWithLastSelection && lastRefreshSelection != null
						&& lastRefreshSelection.size() > 0) {
					tblViewer.setSelection(new StructuredSelection(
							lastRefreshSelection));
				} else {
					refreshWithLastSelection = true;
					tblViewer.getTable().setSelection(0);
					tblViewer.getTable().notifyListeners(SWT.Selection,
							new Event());
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
	 * Sets the initial pattern used by the filter. This text is copied into the
	 * selection input on the dialog. A full selection is used in the pattern
	 * input field.
	 * 
	 * @param text
	 *            initial pattern for the filter
	 * @see FilteredItemsSelectionDialog#FULL_SELECTION
	 */
	public void setInitialPattern(String text) {
		setInitialPattern(text, FULL_SELECTION);
	}

	/**
	 * Sets the initial pattern used by the filter. This text is copied into the
	 * selection input on the dialog. The <code>selectionMode</code> is used to
	 * choose selection type for the input field.
	 * 
	 * @param text
	 *            initial pattern for the filter
	 * @param selectionMode
	 *            one of: {@link FilteredItemsSelectionDialog#NONE},
	 *            {@link FilteredItemsSelectionDialog#CARET_BEGINNING},
	 *            {@link FilteredItemsSelectionDialog#FULL_SELECTION}
	 */
	public void setInitialPattern(String text, int selectionMode) {
		this.initialPatternText = text;
		this.selectionMode = selectionMode;
	}

	/**
	 * Gets initial pattern.
	 * 
	 * @return initial pattern, or <code>null</code> if initial pattern is not
	 *         set
	 */
	protected String getInitialPattern() {
		return this.initialPatternText;
	}

	/**
	 * Returns the current selection.
	 * 
	 * @return the current selection
	 */
	protected StructuredSelection getSelectedItems() {

		StructuredSelection selection = (StructuredSelection) tblViewer
				.getSelection();

		List selectedItems = selection.toList();
		Object itemToRemove = null;

		for (Iterator it = selection.iterator(); it.hasNext();) {
			Object item = it.next();
			if (item instanceof ItemsListSeparator) {
				itemToRemove = item;
				break;
			}
		}

		if (itemToRemove == null)
			return new StructuredSelection(selectedItems);
		// Create a new selection without the collision
		List newItems = new ArrayList(selectedItems);
		newItems.remove(itemToRemove);
		return new StructuredSelection(newItems);

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
	protected abstract ItemsFilter createFilter();

	/**
	 * Applies the filter created by <code>createFilter()</code> method to the
	 * items list. When new filter is different than previous one it will cause
	 * refiltering.
	 */
	public void applyFilter() {

		ItemsFilter newFilter = createFilter();

		// don't apply filtering for patterns which mean the same, for example:
		// *a**b and ***a*b
		if (filter != null && filter.equalsFilter(newFilter)) {
			return;
		}

		filterHistoryJob.cancel();
		filterJob.cancel();

		this.filter = newFilter;

		if (this.filter != null) {
			filterHistoryJob.schedule();
		}
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
			AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
			IProgressMonitor progressMonitor) throws CoreException;

	/**
	 * Removes selected items from history.
	 * 
	 * @param items
	 *            items to be removed
	 */
	private void removeSelectedItems(List items) {
		for (Iterator iter = items.iterator(); iter.hasNext();) {
			Object item = iter.next();
			removeHistoryItem(item);
		}
		refreshWithLastSelection = false;
		contentProvider.reloadCache();
	}

	/**
	 * Removes an item from history.
	 * 
	 * @param item
	 *            an item to remove
	 * @return removed item
	 */
	protected Object removeHistoryItem(Object item) {
		return contentProvider.removeHistoryElement(item);
	}

	/**
	 * Adds item to history.
	 * 
	 * @param item
	 *            the item to be added
	 */
	protected void accessedHistoryItem(Object item) {
		contentProvider.addHistoryItem(item);
	}

	/**
	 * Returns a history comparator.
	 * 
	 * @return decorated comparator
	 */
	private Comparator getHistoryComparator() {
		return new HistoryComparator();
	}

	/**
	 * Returns the history of selected elements.
	 * 
	 * @return history of selected elements, or <code>null</code> if it is not
	 *         set
	 */
	protected SelectionHistory getSelectionHistory() {
		return this.contentProvider.getSelectionHistory();
	}

	/**
	 * Sets new history.
	 * 
	 * @param selectionHistory
	 *            the history
	 */
	protected void setSelectionHistory(SelectionHistory selectionHistory) {
		if (this.contentProvider != null)
			this.contentProvider.setSelectionHistory(selectionHistory);
	}

	/**
	 * Indicates whether the given item is a history item.
	 * 
	 * @param item
	 *            the item to be investigated
	 * @return <code>true</code> if the given item exists in history,
	 *         <code>false</code> otherwise
	 */
	public boolean isHistoryElement(Object item) {
		return this.contentProvider.isHistoryElement(item);
	}

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
	 * Sets separator label
	 * 
	 * @param separatorLabel
	 *            the label showed on separator
	 */
	public void setSeparatorLabel(String separatorLabel) {
		this.itemsListSeparator = new ItemsListSeparator(separatorLabel);
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

			if (AbstractLazyTableViewer.this != null) {
				AbstractLazyTableViewer.this.refresh();
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
			schedule(500);

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

			if (AbstractLazyTableViewer.this != null) {
				GranualProgressMonitor wrappedMonitor = new GranualProgressMonitor(
						monitor);
				AbstractLazyTableViewer.this.reloadCache(true, wrappedMonitor);
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

	private class RemoveHistoryItemAction extends Action {

		/**
		 * Creates a new instance of the class.
		 */
		public RemoveHistoryItemAction() {
			super("Remove Items from history");
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.Action#run()
		 */
		public void run() {
			List selectedElements = ((StructuredSelection) tblViewer
					.getSelection()).toList();
			removeSelectedItems(selectedElements);
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
			if (element instanceof ItemsListSeparator && columnIndex == 0) {
				return WorkbenchImages
						.getImage(IWorkbenchGraphicConstants.IMG_OBJ_SEPARATOR);
			} else if (provider instanceof ITableLabelProvider) {
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
			if (element instanceof ItemsListSeparator) {
				return getSeparatorLabel(
						((ItemsListSeparator) element).getName(), columnIndex);
			}

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
			if (!(element instanceof ItemsListSeparator)
					&& provider instanceof IStyledLabelProvider) {
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

		private String getSeparatorLabel(String separatorLabel, int columnIndex) {

			int cwidth = tblViewer.getTable().getColumns()[columnIndex]
					.getWidth();

			// Rectangle rect = tblViewer.getTable().getBounds();

			int borderWidth = tblViewer.getTable().computeTrim(0, 0, 0, 0).width;

			// int width = rect.width - borderWidth - imageWidth;
			int width = 0;
			if (columnIndex == 0) {
				int imageWidth = WorkbenchImages.getImage(
						IWorkbenchGraphicConstants.IMG_OBJ_SEPARATOR)
						.getBounds().width;
				width = cwidth - borderWidth - imageWidth;
			} else {
				width = cwidth - borderWidth;
			}

			GC gc = new GC(tblViewer.getTable());
			gc.setFont(tblViewer.getTable().getFont());

			int dashWidth = gc.getAdvanceWidth('-');
			int fMessageLength = gc.textExtent(separatorLabel).x;

			gc.dispose();

			StringBuffer dashes = new StringBuffer();

			int chars = 0;

			if (columnIndex == 0) {
				chars = (((width - fMessageLength) / dashWidth) / 2) - 2;
			} else {
				chars = ((width / dashWidth) / 2) - 2;
			}

			for (int i = 0; i < chars; i++) {
				dashes.append('-');
			}

			StringBuffer result = new StringBuffer();

			if (columnIndex == 0) {
				result.append(dashes);
				result.append(" " + separatorLabel + " "); //$NON-NLS-1$//$NON-NLS-2$
				result.append(dashes);
			} else {
				result.append(dashes);
				result.append(dashes);
			}
			return result.toString().trim();
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
			if (element instanceof ItemsListSeparator) {
				return null;
			}
			if (provider instanceof IColorProvider) {
				return ((IColorProvider) provider).getBackground(element);
			}
			return null;
		}

		private Color getForeground(Object element) {
			if (element instanceof ItemsListSeparator) {
				return Display.getCurrent().getSystemColor(
						SWT.COLOR_WIDGET_NORMAL_SHADOW);
			}
			if (provider instanceof IColorProvider) {
				return ((IColorProvider) provider).getForeground(element);
			}
			return null;
		}

		private Font getFont(Object element) {
			if (element instanceof ItemsListSeparator) {
				return null;
			}
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
	 * Used in ItemsListContentProvider, separates history and non-history
	 * items.
	 */
	private class ItemsListSeparator {

		private String name;

		/**
		 * Creates a new instance of the class.
		 * 
		 * @param name
		 *            the name of the separator
		 */
		public ItemsListSeparator(String name) {
			this.name = name;
		}

		/**
		 * Returns the name of this separator.
		 * 
		 * @return the name of the separator
		 */
		public String getName() {
			return name;
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
	 * Filters items history and schedule filter job.
	 */
	private class FilterHistoryJob extends Job {

		/**
		 * Filter used during the filtering process.
		 */
		private ItemsFilter itemsFilter;

		/**
		 * Creates new instance of receiver.
		 */
		public FilterHistoryJob() {
			super("Items Filtering");
			setSystem(true);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.
		 * IProgressMonitor)
		 */
		protected IStatus run(IProgressMonitor monitor) {

			this.itemsFilter = filter;

			if (ScreensActivator.DEBUG) {
				ScreensActivator.TRACE.trace(
						ScreensActivator.TRACE_SCREENS_OPTION,
						"filter history job invoked with pattern: \""
								+ filter.getPattern() + "\"");
			}
			contentProvider.reset();

			refreshWithLastSelection = false;

			contentProvider.addHistoryItems(itemsFilter);

			if (!(lastCompletedFilter != null && lastCompletedFilter
					.isSubFilter(this.itemsFilter))) {

				if (ScreensActivator.DEBUG) {
					ScreensActivator.TRACE
							.trace(ScreensActivator.TRACE_SCREENS_OPTION,
									"Filter is new or not a sub-filter, refreshing content");
				}

				contentProvider.reloadCache();
			}

			filterJob.schedule();

			return Status.OK_STATUS;
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
		protected ItemsFilter itemsFilter;

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

			try {
				if (monitor.isCanceled())
					return;

				this.itemsFilter = filter;

				if (filter.getPattern().length() != 0) {
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
	 * History stores a list of key, object pairs. The list is bounded at a
	 * certain size. If the list exceeds this size the oldest element is removed
	 * from the list. An element can be added/renewed with a call to
	 * <code>accessed(Object)</code>.
	 * <p>
	 * The history can be stored to/loaded from an XML file.
	 */
	protected static abstract class SelectionHistory {

		private static final String DEFAULT_ROOT_NODE_NAME = "historyRootNode"; //$NON-NLS-1$

		private static final String DEFAULT_INFO_NODE_NAME = "infoNode"; //$NON-NLS-1$

		private static final int MAX_HISTORY_SIZE = 60;

		private final Set historyList;

		protected final String rootNodeName;

		protected final String infoNodeName;

		private SelectionHistory(String rootNodeName, String infoNodeName) {

			historyList = Collections.synchronizedSet(new LinkedHashSet() {

				private static final long serialVersionUID = 0L;

				/*
				 * (non-Javadoc)
				 * 
				 * @see java.util.LinkedList#add(java.lang.Object)
				 */
				public boolean add(Object arg0) {
					if (this.size() >= MAX_HISTORY_SIZE) {
						Iterator iterator = this.iterator();
						iterator.next();
						iterator.remove();
					}
					return super.add(arg0);
				}

			});

			this.rootNodeName = rootNodeName;
			this.infoNodeName = infoNodeName;
		}

		/**
		 * Creates new instance of <code>SelectionHistory</code>.
		 */
		public SelectionHistory() {
			this(DEFAULT_ROOT_NODE_NAME, DEFAULT_INFO_NODE_NAME);
		}

		/**
		 * Adds object to history.
		 * 
		 * @param object
		 *            the item to be added to the history
		 */
		public synchronized void accessed(Object object) {
			historyList.remove(object);
			historyList.add(object);
		}

		/**
		 * Returns <code>true</code> if history contains object.
		 * 
		 * @param object
		 *            the item for which check will be executed
		 * @return <code>true</code> if history contains object
		 *         <code>false</code> in other way
		 */
		public synchronized boolean contains(Object object) {
			return historyList.contains(object);
		}

		/**
		 * Returns <code>true</code> if history is empty.
		 * 
		 * @return <code>true</code> if history is empty
		 */
		public synchronized boolean isEmpty() {
			return historyList.isEmpty();
		}

		/**
		 * Remove element from history.
		 * 
		 * @param element
		 *            to remove form the history
		 * @return <code>true</code> if this list contained the specified
		 *         element
		 */
		public synchronized boolean remove(Object element) {
			return historyList.remove(element);
		}

		/**
		 * Load history elements from memento.
		 * 
		 * @param memento
		 *            memento from which the history will be retrieved
		 */
		public void load(IMemento memento) {

			XMLMemento historyMemento = (XMLMemento) memento
					.getChild(rootNodeName);

			if (historyMemento == null) {
				return;
			}

			IMemento[] mementoElements = historyMemento
					.getChildren(infoNodeName);
			for (int i = 0; i < mementoElements.length; ++i) {
				IMemento mementoElement = mementoElements[i];
				Object object = restoreItemFromMemento(mementoElement);
				if (object != null) {
					historyList.add(object);
				}
			}
		}

		/**
		 * Save history elements to memento.
		 * 
		 * @param memento
		 *            memento to which the history will be added
		 */
		public void save(IMemento memento) {

			IMemento historyMemento = memento.getChild(rootNodeName);
			if (historyMemento == null) {
				historyMemento = memento.createChild(rootNodeName);
			}

			Object[] items = getHistoryItems();

			for (int i = 0; i < items.length; i++) {
				Object item = items[i];
				storeItemToMemento(item, historyMemento);
			}

		}

		/**
		 * Gets array of history items.
		 * 
		 * @return array of history elements
		 */
		public synchronized Object[] getHistoryItems() {
			return historyList.toArray();
		}

		/**
		 * Creates an object using given memento.
		 * 
		 * @param memento
		 *            memento used for creating new object
		 * 
		 * @return the restored object
		 */
		protected abstract Object restoreItemFromMemento(IMemento memento);

		/**
		 * Store object in <code>IMemento</code>.
		 * 
		 * @param item
		 *            the item to store
		 * @param memento
		 *            the memento to store to
		 */
		protected abstract void storeItemToMemento(Object item, IMemento memento);

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
	public class ContentNotification extends AdapterImpl {

		private ItemsContentProvider icp;

		public ContentNotification(ItemsContentProvider icp) {
			this.icp = icp;
		}

		@Override
		public void notifyChanged(Notification msg) {
			
			
			// For additions, as we add to history, cache will be reloaded. 
			// For removals, explicitly reload the cache. 
			
			final ItemsFilter itemsFilter = filter;
			
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
				icp.addHistoryItem(item);
			} else if (msg.getEventType() == Notification.ADD_MANY) {
				List<?> list = (List<?>) msg.getNewValue();
				for (Object item : list) {
					icp.addItem(item, itemsFilter);
					icp.addHistoryItem(item);
				}
			} else if (msg.getEventType() == Notification.REMOVE) {
				// Removing, from source Items, LastSortedItems, Duplicates &
				// History.
				Object item = msg.getOldValue();
				icp.removeItem(item);
				icp.removeHistoryElement(item);
				icp.reloadCache();
			} else if (msg.getEventType() == Notification.REMOVE_MANY) {
				List<?> list = (List<?>) msg.getOldValue();
				for (Object item : list) {
					icp.removeItem(item);
					icp.removeHistoryElement(item);
				}
				icp.reloadCache();
			}
			
		}
	}

	/**
	 * Filters elements using SearchPattern by comparing the names of items with
	 * the filter pattern.
	 */
	public abstract class ItemsFilter {

		protected SearchPattern patternMatcher;

		/**
		 * Creates new instance of ItemsFilter.
		 */
		public ItemsFilter() {
			this(new SearchPattern());
		}

		/**
		 * Creates new instance of ItemsFilter.
		 * 
		 * @param searchPattern
		 *            the pattern to be used when filtering
		 */
		public ItemsFilter(SearchPattern searchPattern) {
			patternMatcher = searchPattern;
			String stringPattern = ""; //$NON-NLS-1$
			if (pattern != null && !pattern.getText().equals("*")) { //$NON-NLS-1$
				stringPattern = pattern.getText();
			}
			patternMatcher.setPattern(stringPattern);
		}

		/**
		 * Check if the given filter is a sub-filter of this filter. The default
		 * implementation checks if the <code>SearchPattern</code> from the
		 * given filter is a sub-pattern of the one from this filter.
		 * <p>
		 * <i>WARNING: This method is <b>not</b> defined in reading order, i.e.
		 * <code>a.isSubFilter(b)</code> is <code>true</code> iff <code>b</code>
		 * is a sub-filter of <code>a</code>, and not vice-versa. </i>
		 * </p>
		 * 
		 * @param filter
		 *            the filter to be checked, or <code>null</code>
		 * @return <code>true</code> if the given filter is sub-filter of this
		 *         filter, <code>false</code> if the given filter isn't a
		 *         sub-filter or is <code>null</code>
		 * 
		 * @see org.eclipse.ui.dialogs.SearchPattern#isSubPattern(org.eclipse.ui.dialogs.SearchPattern)
		 */
		public boolean isSubFilter(ItemsFilter filter) {
			if (filter != null) {
				return this.patternMatcher.isSubPattern(filter.patternMatcher);
			}
			return false;
		}

		/**
		 * Checks whether the provided filter is equal to the current filter.
		 * The default implementation checks if <code>SearchPattern</code> from
		 * current filter is equal to the one from provided filter.
		 * 
		 * @param filter
		 *            filter to be checked, or <code>null</code>
		 * @return <code>true</code> if the given filter is equal to current
		 *         filter, <code>false</code> if given filter isn't equal to
		 *         current one or if it is <code>null</code>
		 * 
		 * @see org.eclipse.ui.dialogs.SearchPattern#equalsPattern(org.eclipse.ui.dialogs.SearchPattern)
		 */
		public boolean equalsFilter(ItemsFilter filter) {
			if (filter != null
					&& filter.patternMatcher.equalsPattern(this.patternMatcher)) {
				return true;
			}
			return false;
		}

		/**
		 * Checks whether the pattern's match rule is camel case.
		 * 
		 * @return <code>true</code> if pattern's match rule is camel case,
		 *         <code>false</code> otherwise
		 */
		public boolean isCamelCasePattern() {
			return patternMatcher.getMatchRule() == SearchPattern.RULE_CAMELCASE_MATCH;
		}

		/**
		 * Returns the pattern string.
		 * 
		 * @return pattern for this filter
		 * 
		 * @see SearchPattern#getPattern()
		 */
		public String getPattern() {
			return patternMatcher.getPattern();
		}

		/**
		 * Returns the rule to apply for matching keys.
		 * 
		 * @return an implementation-specific match rule
		 * 
		 * @see SearchPattern#getMatchRule() for match rules returned by the
		 *      default implementation
		 */
		public int getMatchRule() {
			return patternMatcher.getMatchRule();
		}

		/**
		 * Matches text with filter.
		 * 
		 * @param text
		 *            the text to match with the filter
		 * @return <code>true</code> if text matches with filter pattern,
		 *         <code>false</code> otherwise
		 */
		public boolean matches(String text) {
			return patternMatcher.matches(text);
		}

		/**
		 * General method for matching raw name pattern. Checks whether current
		 * pattern is prefix of name provided item.
		 * 
		 * @param item
		 *            item to check
		 * @return <code>true</code> if current pattern is a prefix of name
		 *         provided item, <code>false</code> if item's name is shorter
		 *         than prefix or sequences of characters don't match.
		 */
		public boolean matchesRawNamePattern(Object item) {
			String prefix = patternMatcher.getPattern();
			String text = getElementName(item);

			if (text == null)
				return false;

			int textLength = text.length();
			int prefixLength = prefix.length();
			if (textLength < prefixLength) {
				return false;
			}
			for (int i = prefixLength - 1; i >= 0; i--) {
				if (Character.toLowerCase(prefix.charAt(i)) != Character
						.toLowerCase(text.charAt(i)))
					return false;
			}
			return true;
		}

		/**
		 * Matches an item against filter conditions.
		 * 
		 * @param item
		 * @return <code>true<code> if item matches against filter conditions, <code>false</code>
		 *         otherwise
		 */
		public abstract boolean matchItem(Object item);

		/**
		 * Checks consistency of an item. Item is inconsistent if was changed or
		 * removed.
		 * 
		 * @param item
		 * @return <code>true</code> if item is consistent, <code>false</code>
		 *         if item is inconsistent
		 */
		public abstract boolean isConsistentItem(Object item);

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
		public abstract void addItem(Object item, ItemsFilter itemsFilter);

		public abstract void addCollection(List<?> delegateGetItems,
				ItemsFilter itemsFilter);

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

		private SelectionHistory selectionHistory;

		private ContentNotification contentNotification;

		public ContentNotification getContentNotification() {
			return contentNotification;
		}

		// Decide if it's any use for Client control of the notification
		// handler.
		// public void setContentNotification(ContentNotification
		// contentNotification) {
		// this.contentNotification = contentNotification;
		// }

		/**
		 * Raw result of the searching (unsorted, unfiltered).
		 * <p>
		 * Standard object flow:
		 * <code>items -> lastSortedItems -> lastFilteredItems</code>
		 */
		private Set items;

		/**
		 * Items that are duplicates.
		 */
		private Set duplicates;

		/**
		 * List of <code>ViewerFilter</code>s to be used during filtering
		 */
		private List filters;

		/**
		 * Result of the last filtering.
		 * <p>
		 * Standard object flow:
		 * <code>items -> lastSortedItems -> lastFilteredItems</code>
		 */
		private List lastFilteredItems;

		/**
		 * Result of the last sorting.
		 * <p>
		 * Standard object flow:
		 * <code>items -> lastSortedItems -> lastFilteredItems</code>
		 */
		private List lastSortedItems;

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

		/**
		 * Creates new instance of <code>ContentProvider</code>.
		 */
		public ItemsContentProvider() {
			this.items = Collections.synchronizedSet(new LinkedHashSet(2048));
			this.duplicates = Collections.synchronizedSet(new HashSet(256));
			this.lastFilteredItems = new LinkedList();
			this.lastSortedItems = Collections
					.synchronizedList(new LinkedList());

			contentNotification = new ContentNotification(this);
		}

		/**
		 * Sets selection history.
		 * 
		 * @param selectionHistory
		 *            The selectionHistory to set.
		 */
		public void setSelectionHistory(SelectionHistory selectionHistory) {
			this.selectionHistory = selectionHistory;
		}

		/**
		 * @return Returns the selectionHistory.
		 */
		public SelectionHistory getSelectionHistory() {
			return selectionHistory;
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

		public void addItem(Object item, ItemsFilter itemsFilter) {
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
		 * Replace the collection without filtering. This should not involve a
		 * CDO round trip.
		 */
		@Override
		public void addCollection(List<?> delegateGetItems,
				ItemsFilter itemsFilter) {

			// no, this will add the whole lot@
			items.addAll(delegateGetItems);
		}

		/**
		 * Add all history items to <code>contentProvider</code>.
		 * 
		 * @param itemsFilter
		 */
		public void addHistoryItems(ItemsFilter itemsFilter) {
			if (this.selectionHistory != null) {
				Object[] items = this.selectionHistory.getHistoryItems();

				for (int i = 0; i < items.length; i++) {
					Object item = items[i];
					if (itemsFilter == filter) {
						if (itemsFilter != null) {
							if (itemsFilter.matchItem(item)) {
								if (itemsFilter.isConsistentItem(item)) {
									if (ScreensActivator.DEBUG) {
										ScreensActivator.TRACE
												.trace(ScreensActivator.TRACE_SCREENS_OPTION,
														"Adding consistent item: "
																+ item);
									}
									this.items.add(item);
								} else {
									if (ScreensActivator.DEBUG) {
										ScreensActivator.TRACE
												.trace(ScreensActivator.TRACE_SCREENS_OPTION,
														"Removing inconsistent item: "
																+ item);
									}
									this.selectionHistory.remove(item);
								}
							}
						}
					}
				}
			}
		}

		/**
		 * Refresh dialog.
		 */
		public void reloadCache() {
			scheduleRefreshCache();
		}

		/**
		 * Removes items from history and refreshes the view.
		 * 
		 * @param item
		 *            to remove
		 * 
		 * @return removed item
		 */
		public Object removeHistoryElement(Object item) {
			if (this.selectionHistory != null)
				this.selectionHistory.remove(item);
			if (filter == null || filter.getPattern().length() == 0) {
				items.remove(item);
				duplicates.remove(item);
				this.lastSortedItems.remove(item);
			}

			synchronized (lastSortedItems) {
				Collections.sort(lastSortedItems, getHistoryComparator());
			}
			return item;
		}

		/**
		 * Adds item to history and refresh view.
		 * 
		 * @param item
		 *            to add
		 */
		public void addHistoryItem(Object item) {
			if (this.selectionHistory != null)
				this.selectionHistory.accessed(item);
			if (filter == null || !filter.matchItem(item)) {
				this.items.remove(item);
				this.duplicates.remove(item);
				this.lastSortedItems.remove(item);
			}
			synchronized (lastSortedItems) {
				Collections.sort(lastSortedItems, getHistoryComparator());
			}
			this.reloadCache();
		}

		/**
		 * @param item
		 * @return <code>true</code> if given item is part of the history
		 */
		public boolean isHistoryElement(Object item) {
			if (this.selectionHistory != null) {
				return this.selectionHistory.contains(item);
			}
			return false;
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
		 * Load history from memento.
		 * 
		 * @param memento
		 *            memento from which the history will be retrieved
		 */
		public void loadHistory(IMemento memento) {
			if (this.selectionHistory != null)
				this.selectionHistory.load(memento);
		}

		/**
		 * Save history to memento.
		 * 
		 * @param memento
		 *            memento to which the history will be added
		 */
		public void saveHistory(IMemento memento) {
			if (this.selectionHistory != null)
				this.selectionHistory.save(memento);
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
					Collections.sort(lastSortedItems, getHistoryComparator());
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
		public void rememberResult(ItemsFilter itemsFilter) {
			List itemsList = Collections.synchronizedList(Arrays
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
				// Attach a Content Notifier.
				((Notifier) newInput).eAdapters().add(
						this.getContentNotification());
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.viewers.ILazyContentProvider#updateElement(int)
		 */
		public void updateElement(int index) {

			AbstractLazyTableViewer.this.tblViewer.replace((lastFilteredItems
					.size() > index) ? lastFilteredItems.get(index) : null,
					index);

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
						"cache size is : " + lastFilteredItems.size());
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
				HashMap helperMap = new HashMap();
				for (int i = 0; i < lastFilteredItems.size(); i++) {
					if (reset
							|| (subMonitor != null && subMonitor.isCanceled()))
						return;
					Object item = lastFilteredItems.get(i);

					if (!(item instanceof ItemsListSeparator)) {
						Object previousItem = helperMap.put(
								getElementName(item), item);
						if (previousItem != null) {
							setDuplicateElement(previousItem, true);
							setDuplicateElement(item, true);
						} else {
							setDuplicateElement(item, false);
						}
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
				for (Iterator iter = filters.iterator(); iter.hasNext();) {
					ViewerFilter f = (ViewerFilter) iter.next();
					filteredElements = f.filter(tblViewer, parent,
							filteredElements);
					monitor.worked(ticks);
				}
			}

			if (filteredElements == null || monitor.isCanceled()) {
				monitor.done();
				return new Object[0];
			}

			List preparedElements = new LinkedList();
			boolean hasHistory = false;

			if (filteredElements.length > 0) {
				if (isHistoryElement(filteredElements[0])) {
					hasHistory = true;
				}
			}

			int reportEvery = filteredElements.length / ticks;

			// add separator
			for (int i = 0; i < filteredElements.length; i++) {
				Object item = filteredElements[i];

				if (hasHistory && !isHistoryElement(item)) {
					preparedElements.add(itemsListSeparator);
					hasHistory = false;
				}

				preparedElements.add(item);

				if (reportEvery != 0 && ((i + 1) % reportEvery == 0)) {
					monitor.worked(1);
				}
			}

			monitor.done();

			return preparedElements.toArray();
		}

		/**
		 * Adds a filter to this content provider. For an example usage of such
		 * filters look at the project <code>org.eclipse.ui.ide</code>, class
		 * <code>org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog.CustomWorkingSetFilter</code>
		 * .
		 * 
		 * 
		 * @param filter
		 *            the filter to be added
		 */
		public void addFilter(ViewerFilter filter) {
			if (filters == null) {
				filters = new ArrayList();
			}
			filters.add(filter);
			// currently filters are only added when dialog is restored
			// if it is changed, refreshing the whole TableViewer should be
			// added
		}
	}

	/**
	 * Compares items according to the history.
	 */
	private class HistoryComparator implements Comparator {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		public int compare(Object o1, Object o2) {
			boolean h1 = isHistoryElement(o1);
			boolean h2 = isHistoryElement(o2);
			if (h1 == h2)
				return getItemsComparator().compare(o1, o2);

			if (h1)
				return -2;
			if (h2)
				return +2;

			return 0;
		}

	}

	/**
	 * Get the control where the search pattern is entered. Any filtering should
	 * be done using an {@link ItemsFilter}. This control should only be
	 * accessed for listeners that wish to handle events that do not affect
	 * filtering such as custom traversal.
	 * 
	 * @return Control or <code>null</code> if the pattern control has not been
	 *         created.
	 */
	public Control getPatternControl() {
		return pattern;
	}

}

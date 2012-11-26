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
package com.netxforge.netxstudio.screens.editing.selector;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.cdo.IFixtures;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.screens.editing.AbstractScreensViewPart;
import com.netxforge.netxstudio.screens.editing.CDOEditingService;
import com.netxforge.netxstudio.screens.editing.DataLoadingJobService;
import com.netxforge.netxstudio.screens.editing.DataLoadingJobService.DataPostLoadingJob;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;

/**
 * This service is capable to place a composite in a dedicated section (The
 * container), of a layout structure. The layout is a Selector pane, a Container
 * pane and a Toolbar pane.
 * 
 * </p>The container can be updated by placing selectors calling
 * <code>addScreenSelector(...)</code>. When the active screen in the container
 * is replaced by another screen, the previous screen is remembered and can be
 * retrieved by calling: <code>restorePreviousScreen()</code>
 * 
 * The screen (Which should be a form composite) should have a constructor with
 * arguments for <code>IEditingService</code> and
 * <code>IScreenFormService</code>. </p>The service also automatically shows a
 * toolbar with Hyperlinks to navigate and invoke actions, between the screens,
 * depending on the implemented interfaces: <uL <li>{@link IScreen}, for New,
 * Edit and Table type screens</li> <li>{@link IDataServiceInjection}, for
 * screens which get their data injected from {@link IDataService}</li> <li>
 * {@link IDataScreenInjection}, for screens which get their data injected from
 * another screen, will show the <b>Save</b> action</li> </ul>
 * 
 * First time users of the service should call <code>initialize()</code> to set
 * the parent composite. Also it's a good idea to call
 * <code>setEditingService</code>.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class ScreenFormService implements IScreenFormService {

	private SashForm sashForm;
	private Form selectorForm;

	private ScreenBody screenBody;

	private Composite rootComposite;

	private Stack<Composite> screenStack = new Stack<Composite>();

	private List<ImageHyperlink> screenSelectors = Lists.newArrayList();

	/*
	 * The associated AbstractScreensViewPart for this screen manager.
	 */
	private AbstractScreensViewPart absViewPart;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getActiveScreen
	 * ()
	 */
	public IScreen getActiveScreen() {
		Control c = screenBody.getScreenDeck().topControl;
		if (c instanceof Composite && ScreenUtil.isScreen((Composite) c)) {
			return ScreenUtil.screenFor((Composite) c);
		}
		return null;
	}

	public Composite getActiveComposite() {
		Control c = screenBody.getScreenDeck().topControl;
		return c instanceof Composite ? (Composite) c : null;
	}

	private void pushCurrentScreen() {
		Control c = screenBody.getScreenDeck().topControl;
		if (c instanceof Composite) {
			Composite screen = (Composite) c;
			screen.setVisible(false);
			saveScreenState(ScreenUtil.screenFor(screen));
			screenStack.push(screen);
		}
	}

	public void setActiveScreen(IScreen screen) {
		pushCurrentScreen();
		doSetActiveScreen(screen);
		restoreScreenState(screen);
		fireScreenChanged(screen);
	}

	private void doSetActiveScreen(IScreen screen) {
		// We need a copy of the composite, so it can work.
		final Composite activeScreen = ScreenUtil.compositeFor(screen);
		if (activeScreen.isDisposed()) {
			screenBody.getScreenDeck().topControl = null;
			return; // can't set this screen sorry.
		}

		formToolkit.adapt(activeScreen);
		formToolkit.paintBordersFor(activeScreen);

		screenBody.getScreenDeck().topControl = activeScreen;

		// screenBody.pack();
		updateScreenPath();

		try {
			getScreenContainer().layout(true, true);
		} catch (Exception e) {
			if (e instanceof SWTException) {
				System.out.println("bug widget disposed" + e.getMessage());
			} else {
				e.printStackTrace();

			}

		}

		this.updateScreenBarActions(activeScreen);
		screenBody.setScreenBarOn();

	}

	private void popScreen() {

		if (!screenStack.empty()) {

			Composite activeScreen = getActiveComposite();
			if (activeScreen != null) {
				activeScreen.dispose();
			}

			Composite popScreen = screenStack.pop();
			popScreen.setVisible(true);
			screenBody.getScreenDeck().topControl = popScreen;
			getScreenContainer().layout(true, true);
			updateScreenBarActions(popScreen);

			// We need to refresh the viewer in case objects have been
			// invalidated and need to be updated.
			Viewer v = ((IScreen) popScreen).getViewer();
			if (v != null) {
				v.refresh();
			}

			restoreScreenState(ScreenUtil.screenFor(popScreen));
			fireScreenChanged(ScreenUtil.screenFor(popScreen));

		} else {
			// Nothing to pop.
			screenBody.setScreenBarOff();
		}

		this.updateScreenPath();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#isActiveScreen
	 * (java.lang.Class)
	 */
	public boolean isActiveScreen(Class<?> proposedScreen) {

		Control c = screenBody.getScreenDeck().topControl;
		if (c != null) {
			return c.getClass().equals(proposedScreen);
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#initalize(
	 * org.eclipse.swt.widgets.Composite)
	 */
	public void initalize(AbstractScreensViewPart absViewPart, Composite parent) {

		this.absViewPart = absViewPart;

		rootComposite = new Composite(parent, SWT.NONE);
		rootComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			sashForm = new SashForm(rootComposite, SWT.SMOOTH);
			sashForm.setSashWidth(5);
			{
				Composite selectorComposite = formToolkit.createComposite(
						sashForm, SWT.NONE);
				formToolkit.paintBordersFor(selectorComposite);
				selectorComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
				{
					selectorForm = formToolkit.createForm(selectorComposite);
					selectorForm.setSeparatorVisible(true);
					formToolkit.paintBordersFor(selectorForm);
					selectorForm.setText("M");
					selectorForm.getBody().setLayout(new FormLayout());
				}
			}
			{
				screenBody = new ScreenBody(sashForm, SWT.NONE);

				// Install all the links on the screen bar.
				this.createBackLink(screenBody.getScreenBar());
				this.createSaveLink(screenBody.getScreenBar());
				screenBody.setScreenBarOff();
				screenBody.setScreenPathOff();
			}
			sashForm.setWeights(new int[] { 70, 491 });
		}
	}

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	public Composite addScreenSelector(String name, String iconPath,
			Class<?> screen, int position, int operation) {
		return addScreenSelector(null, name, iconPath, screen, position,
				operation);
	}

	public Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int operation) {
		return addScreenSelector(above, name, iconPath, screen, -1, operation);
	}

	public Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen, int position, int operation) {

		assert position >= 1 || above != null;

		try {

			// Experimental, move instantiation of screen to guice, to avoid
			// .injectMembers in Screen classes.
			// Object instance = EditingActivator.getDefault().getInjector()
			// .getInstance(screen);

			// We look for a constructor supporting the selector service.
			// Screens, will be able to use the selector to place themselves on
			// the
			// service container, calling updateComposite();
			Constructor<?> screenConstructor = null;
			try {
				screenConstructor = screen.getConstructor(Composite.class,
						int.class);
			} catch (NoSuchMethodException e2) {
				System.out
						.println("TODO, Implement correct screen signature on :"
								+ screen.getClass().getSimpleName());
			}

			// We need some finals, to invoke in the listener.
			final Constructor<?> finalScreenConstructor = screenConstructor;
			final Class<?> finalScreen = screen;

			// We operride the operation, depending on the user role.

			String currentUser = editingService.getDataService().getProvider()
					.getSessionUserID();
			Resource resource = editingService.getDataService().getProvider()
					.getResource(GenericsPackage.Literals.PERSON);
			List<Person> people = new ModelUtils.CollectionForObjects<Person>()
					.collectionForObjects(resource.getContents());

			// List<Person> people = Lists.transform(resource.getContents(),
			// new Function<EObject, Person>() {
			//
			// public Person apply(EObject from) {
			// if (from instanceof Person)
			// return (Person) from;
			// else
			// return null;
			// }
			// });

			final Role r = modelUtils.roleForUserWithName(currentUser, people);
			if (r.getName().equals(IFixtures.ROLE_READONLY)) {
				operation = ScreenUtil.OPERATION_READ_ONLY;
			}

			// editingService.getDataService().getProvider().commitTransaction();

			// editingService.getDataService().getQueryService().close();

			final int finalOperation = operation;

			ImageHyperlink lnk = formToolkit.createImageHyperlink(
					getSelectorForm().getBody(), SWT.NONE);

			screenSelectors.add(lnk);

			lnk.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {

					doSetScreen(finalScreen, finalScreenConstructor,
							finalOperation);
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});

			lnk.setImage(ResourceManager.getPluginImage(ICON_PATH, iconPath));
			FormData lnkFD = new FormData();

			if (position >= 1) {
				lnkFD.top = new FormAttachment(0, position * 12);
			}
			if (above != null) {
				lnkFD.top = new FormAttachment(above, 6);
			}

			lnkFD.left = new FormAttachment(0, 12);
			lnk.setLayoutData(lnkFD);
			formToolkit.paintBordersFor(lnk);
			lnk.setText(name);
			return lnk;

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	ObservablesManager obm = null;

	private void doSetScreen(final Class<?> screenClass,
			final Constructor<?> finalScreenConstructor,
			final int finalOperation) {
		if (isActiveScreen(screenClass)) {
			return; // Ignore we are there already.
		}

		// Warn for dirtyness.
		dirtyWarning();

		// Cancel any potential background loading of the active screen.
		doCancelLoading();

		// Reset the screen stack, and dispose observables.
		doReset();

		// Instantiate the new screen, from class and constructor, go through a
		// series of jobs to load the data and the UI of the
		// screen. Do this withing an Observable manager.
		obm = new ObservablesManager();
		obm.runAndCollect(new Runnable() {

			public void run() {

				try {
					final IScreen target = (IScreen) finalScreenConstructor
							.newInstance(getScreenContainer(), SWT.NONE);
					target.setOperation(finalOperation);
					target.setScreenService(ScreenFormService.this);

					// Clients supporting IScreenII will have
					// Note: Restoring the screen state which might depend
					// on the model being injected will fail.

					if (target instanceof IScreenII) {

						final long startTime = System.currentTimeMillis();

						if (EditingActivator.DEBUG) {
							EditingActivator.TRACE
									.trace(EditingActivator.TRACE_EDITING_LOADING_OPTION,
											"Start loading Screen: "
													+ target.getScreenName()
													+ " @ "
													+ modelUtils.todayAndNow());
						}
						// We are a new screen, instantiate and set active.
						((IScreenII) target).initUI();

						// Set the new instantiated screen as the active screen.
						doSetActiveScreen(target);

						((IScreenII) target).showPreLoadedUI();

						if (EditingActivator.DEBUG) {
							EditingActivator.TRACE
									.trace(EditingActivator.TRACE_EDITING_LOADING_OPTION,
											"..Pre loaded "
													+ target.getScreenName()
													+ " in: "
													+ modelUtils
															.timeDuration(startTime));
						}

						DataLoadingJobService dataLoadingJobService = new DataLoadingJobService();
						dataLoadingJobService.setScreenToLoad(target);
						dataLoadingJobService
								.addNotifier(new JobChangeAdapter() {

									@Override
									public void done(IJobChangeEvent event) {

										// This is our call back, we should be
										// done already.
										if (EditingActivator.DEBUG) {
											EditingActivator.TRACE
													.trace(EditingActivator.TRACE_EDITING_LOADING_OPTION,
															".."
																	+ event.getJob()
																			.getName()
																	+ " for "
																	+ target.getScreenName()
																	+ " completed in: "
																	+ modelUtils
																			.timeDuration(startTime));
										}

										if (event.getJob() instanceof DataPostLoadingJob) {
											restoreScreenState(target);
											fireScreenChanged(target);
										}
									}
								});
						// Should be executed sequentially.
						dataLoadingJobService.load();
						dataLoadingJobService.postLoad();

					} else {
						if (target instanceof IDataServiceInjection) {
							((IDataServiceInjection) target).injectData();
						}
						doSetActiveScreen(target);
						restoreScreenState(target);
						fireScreenChanged(target);
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void doCancelLoading() {
		if (getActiveScreen() instanceof IScreenII) {
			IScreenII activeScreen = (IScreenII) getActiveScreen();
			activeScreen.cancelLoading();
		}

	}

	private void doReset() {
		// Reset the screen memory.
		reset();

		// Dispose all previous observables.
		// we can then safely dispose the widget.
		if (obm != null) {
			obm.dispose();
			obm = null;
		}

		// Now unload the data.
		editingService.disposeData();
	}

	/**
	 * Warns if the current screen is dirty, if not saving, flush the command
	 * stack. If saving, save depending on the screen type.
	 */
	public void dirtyWarning() {
		// Warn for unsaved changes.
		if (editingService.isDirty()) {
			boolean result = MessageDialog
					.openQuestion(Display.getCurrent().getActiveShell(),
							"Save needed",
							"You have unsaved changes, which will be discarded when not saved, save?");
			if (result) {

				if (getActiveScreen() instanceof IDataScreenInjection) {
					((IDataScreenInjection) getActiveScreen()).addData();
				} else {
					editingService.doSave(new NullProgressMonitor());
				}

			} else {
				undoAndFlush();
			}
		} else {
			// Flush the stack anyway.
			editingService.getEditingDomain().getCommandStack().flush();
		}
	}

	public void undoAndFlush() {
		// This will flush the stack, but not undo all the commands.
		// We need to undo the executed editing commands.
		while (editingService.getEditingDomain().getCommandStack().canUndo()) {
			editingService.getEditingDomain().getCommandStack().undo();
		}
		editingService.getEditingDomain().getCommandStack().flush();
		// The data should have been disposed by now.

		if (editingService instanceof CDOEditingService) {
			if (((CDOEditingService) editingService).getView().isDirty()) {
				CDOTransaction transaction = (CDOTransaction) ((CDOEditingService) editingService)
						.getView();
				transaction.rollback();
			}
		}

	}

	public void reset() {
		// We might be cached, if a child is currently active,
		// but it's better to dispose the complete list and restart.
		while (!screenStack.empty()) {
			Composite c = screenStack.pop();
			IScreen screenFor = ScreenUtil.screenFor(c);
			saveScreenState(screenFor);
			c.dispose();
		}

		Control c = screenBody.getScreenDeck().topControl;
		if (c instanceof IScreen) {
			saveScreenState((IScreen) c);
			c.dispose();
		}
	}

	/*
	 * Save the screen state, get the memento from the Viewpart, and add a child
	 * with the screen name.
	 */
	private void saveScreenState(IScreen screen) {
		IMemento parent = absViewPart.getMemento();

		if (parent != null) {
			String validMementoElement = modelUtils
					.underscopeWhiteSpaces(screen.getScreenName());
			IMemento child = parent.getChild(validMementoElement);
			if (child == null) {
				child = parent.createChild(validMementoElement);
			}

			if (EditingActivator.DEBUG) {
				EditingActivator.TRACE.trace(
						EditingActivator.TRACE_EDITING_DETAILS_OPTION,
						" saving state for " + screen.getScreenName() + " mem:"
								+ child.getType());
			}
			screen.saveState(child);
		}
	}

	private void restoreScreenState(IScreen screen) {
		IMemento memento = absViewPart.getMemento();

		if (memento != null) {
			String validMementoElement = modelUtils
					.underscopeWhiteSpaces(screen.getScreenName());
			IMemento child = memento.getChild(validMementoElement);

			if (child != null) {
				if (EditingActivator.DEBUG) {
					EditingActivator.TRACE.trace(
							EditingActivator.TRACE_EDITING_DETAILS_OPTION,
							" restoring state for " + screen.getScreenName()
									+ " mem:" + child.getType());
				}
				screen.restoreState(child);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getSelectorForm
	 * ()
	 */
	public Form getSelectorForm() {
		return selectorForm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getScreenContainer
	 * ()
	 */
	public Composite getScreenContainer() {
		return this.screenBody.getScreenContainer();
	}

	/**
	 * Activation of actions, is depending on various flags maintained by
	 * interfaces implemented by the Screen.
	 * <ul>
	 * <li>IDataScreenInjection</li>
	 * <li>IDataServiceInjection</li>
	 * <li>IScreen</li>
	 * </ul>
	 * 
	 * @param activeScreen
	 */
	private void updateScreenBarActions(Composite activeScreen) {

		// Show the back link when then screen is triggered by another screen,
		// and should
		// have a return option.
		if (activeScreen instanceof IDataScreenInjection) {
			bckLnk.setVisible(true);
			IScreen screen = (IScreen) activeScreen;
			if (!ScreenUtil.isReadOnlyOperation(screen.getOperation())) {
				saveLnk.setVisible(true);
			}
		}
		if (activeScreen instanceof IDataServiceInjection) {
			bckLnk.setVisible(false);
			saveLnk.setVisible(false);
		}
	}

	// The screen bar links are exposed, to turn them on and off.
	private Hyperlink bckLnk;
	private Hyperlink saveLnk;

	private void createBackLink(Composite parent) {
		bckLnk = formToolkit.createHyperlink(parent, "Back", SWT.NONE);
		formToolkit.adapt(bckLnk);
		bckLnk.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (getActiveScreen().isValid()) {
					dirtyWarning();
					popScreen();
				} else {
					if (editingService.isDirty()) {
						boolean result = MessageDialog
								.openQuestion(Display.getCurrent()
										.getActiveShell(),
										"Save needed, but entry not valid",
										"You have unsaved changes, which are not valid yet, discard?");
						if (result) {
							// clean the service.
							undoAndFlush();
							popScreen();
						} else {
							// Stay on this screen.
						}
					} else {
						popScreen();
					}
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
	}

	private void createSaveLink(Composite parent) {
		saveLnk = formToolkit.createHyperlink(parent, "Save", SWT.NONE);
		formToolkit.adapt(saveLnk);
		saveLnk.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// Get the injected object and pass add it to the injector.
				if (getActiveScreen() instanceof IDataScreenInjection) {
					if (((IScreen) getActiveScreen()).isValid()) {
						((IDataScreenInjection) getActiveScreen()).addData();
						popScreen();
					} else {
						// The screen is not valid, save is not allowed.
					}
				} else {
					// Should not occure as the save lnk is not show, for
					// these types of screens.
					throw new java.lang.IllegalStateException(
							"Save link should not be presented");
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
	}

	@Inject
	IEditingService editingService;

	@Inject
	private ModelUtils modelUtils;

	// Notification of screen changing.
	// 29-05 these listeners will also be notified of a screen invalidation.

	List<ScreenChangeListener> screenChangedListeners = new ArrayList<ScreenChangeListener>();

	public void addScreenChangeListener(
			ScreenChangeListener screenChangedListener) {
		if (!screenChangedListeners.contains(screenChangedListener)) {
			screenChangedListeners.add(screenChangedListener);
		}
	}

	public void removeScreenChangeListener(
			ScreenChangeListener screenChangedListener) {
		if (screenChangedListeners.contains(screenChangedListener)) {
			screenChangedListeners.remove(screenChangedListener);
		}
	}

	public void fireScreenChangedExternal(IScreen screen) {
		this.fireScreenChanged(screen);
	}

	public void fireScreenWidgetChangedExternal(IScreen screen) {
		for (ScreenChangeListener l : screenChangedListeners) {
			l.screenWidgetChanged(screen);
		}
	}

	private void fireScreenChanged(IScreen screen) {
		for (ScreenChangeListener l : screenChangedListeners) {
			l.screenChanged(screen);
		}
	}

	public void fireScreenInvalidExternal(IScreen screen) {
		for (ScreenChangeListener l : screenChangedListeners) {
			l.screenInvalid(screen);
		}
	}

	public AbstractScreensViewPart getAbsViewPart() {
		return absViewPart;
	}

	/**
	 * Delegate to the screen body composite.
	 */
	public Composite getScreenActionBar() {
		return this.screenBody.getScreenBar();
	}

	public IEditingService getEditingService() {
		return editingService;
	}

	/**
	 * Runs through the list of screens on the stack and adds an entry on the
	 * screenpath composite.
	 */
	private void updateScreenPath() {

		Iterator<Composite> elements = screenStack.iterator();
		int count = Iterators.size(elements);
		elements = screenStack.iterator();
		this.screenBody.clearScreenPath();
		if (count > 0) {
			this.screenBody.setScreenPathOn();
			while (elements.hasNext()) {
				Composite composite = elements.next();
				if (ScreenUtil.isScreen(composite)) {
					createPathEntry(ScreenUtil.screenFor(composite));
				}
				if (elements.hasNext()) {
					formToolkit.createLabel(this.screenBody.getScreenPath(),
							"->");
				}
			}

			formToolkit.createLabel(this.screenBody.getScreenPath(), "->");

			this.createPathEntry(this.getActiveScreen());

			this.screenBody.getScreenPath().layout();
		} else {
			this.screenBody.setScreenPathOff();
		}
	}

	private void createPathEntry(IScreen screen) {
		String entry = screen.getScreenName();
		formToolkit.createLabel(this.screenBody.getScreenPath(), entry);
	}

	public void disable() {
		for (ImageHyperlink lnk : this.screenSelectors) {
			lnk.setEnabled(false);
		}
	}

}

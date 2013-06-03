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
package com.netxforge.netxstudio.screens.parts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public abstract class AbstractScreenSashSelector extends AbstractEditorViewPart {

	

	public static final String ID = "com.netxforge.netxstudio.screens.selector.AbstractScreenSelectorII"; //$NON-NLS-1$
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private SashForm sashForm;

	private Composite activeScreen = null;

	/**
	 * Get the currentScreen.
	 * 
	 * @return
	 */
	public Composite getActiveScreen() {
		return activeScreen;
	}

	/**
	 * Check if the propsed new screen is not the active screen already.
	 * 
	 * @param proposedScreen
	 * @return
	 */
	public boolean isActiveScreen(Class<?> proposedScreen) {
		return activeScreen.getClass().equals(proposedScreen);
	}

	/**
	 * The container which fills the ViewPart. Clients should respect the
	 * installed layout.
	 * 
	 * @return
	 */
	private Composite screenContainer;
	private Form frmNewForm;

	public AbstractScreenSashSelector() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			sashForm = new SashForm(container, SWT.SMOOTH);
			sashForm.setSashWidth(1);
			{
				Composite composite = formToolkit.createComposite(sashForm,
						SWT.BORDER);
				formToolkit.paintBordersFor(composite);
				composite.setLayout(new FillLayout(SWT.HORIZONTAL));
				{
					frmNewForm = formToolkit.createForm(composite);
					frmNewForm.setSeparatorVisible(true);
					formToolkit.paintBordersFor(frmNewForm);
					frmNewForm.setText("M");
					frmNewForm.getBody().setLayout(new FormLayout());
				}
			}
			{
				screenContainer = formToolkit.createComposite(sashForm,
						SWT.NONE);
				screenContainer.setLayout(new FillLayout());
				formToolkit.paintBordersFor(screenContainer);

			}
			sashForm.setWeights(new int[] { 100, 491 });
		}

		createActions();
		initializeToolBar();
		initializeMenu();

		buildSelector(screenContainer);
	}

	public abstract void buildSelector(Composite container);

	public void updateComposite(Composite control) {

		if (activeScreen != null) {
			activeScreen.dispose();
		}

		activeScreen = control;

		formToolkit.adapt(activeScreen);
		formToolkit.paintBordersFor(activeScreen);

		// screenContainer.pack();
		// parentComposite.pack();
		screenContainer.layout(true);
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		@SuppressWarnings("unused")
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		@SuppressWarnings("unused")
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart#initBindings
	 * ()
	 */
	@Override
	protected void initBindings() {

	}

	protected SashForm getSplitter() {
		return sashForm;
	}

	protected Form getSelectorForm() {
		return frmNewForm;
	}

	public Composite addLinkSelector(final Composite container, String name,
			String iconPath, Class<?> screen, int position) {
		return addLinkSelector(container, null, name, iconPath, screen,
				position);
	}

	public Composite addLinkSelector(final Composite container,
			Composite above, String name, String iconPath, Class<?> screen) {
		return addLinkSelector(container, above, name, iconPath, screen, -1);
	}
	
	public Composite addLinkSelector(final Composite container,
			Composite above, String name, String iconPath, Class<?> screen,
			int position) {

		assert position >= 1 || above != null;
		
		try {
			final Constructor<?> c;
			c = screen.getConstructors()[0];

			ImageHyperlink lnk = formToolkit.createImageHyperlink(
					getSelectorForm().getBody(), SWT.NONE);
			lnk.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					try {
						Composite target;
						target = (Composite) c.newInstance(container,
								SWT.NONE);
						updateComposite(target);
					} catch (IllegalArgumentException e1) {
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						e1.printStackTrace();
					}
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});

			lnk.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit", iconPath));
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
	
	@Override
	public void dispose() {
		super.dispose();
		
		// TODO Dispose used images. 
		
		
	}
	
}

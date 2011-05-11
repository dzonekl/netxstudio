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
package com.netxforge.netxstudio.screens.selector;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.data.IDataScreenInjection;
import com.netxforge.netxstudio.data.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.IEditingService;

/**
 * NOT READY FOR USE YET.
 * 
 * First time users of the service should call initialize() to set the parent
 * composite.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class ScreenFormService implements IScreenFormService {

	private SashForm sashForm;
	private Form selectorForm;

	private ScreenBody screenBody;

	private Composite activeScreen = null;
	private Composite previousScreen = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getActiveScreen
	 * ()
	 */
	@Override
	public Composite getActiveScreen() {
		return activeScreen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#isActiveScreen
	 * (java.lang.Class)
	 */
	@Override
	public boolean isActiveScreen(Class<?> proposedScreen) {
		return activeScreen.getClass().equals(proposedScreen);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#initalize(
	 * org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void initalize(Composite parent) {
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
					selectorForm = formToolkit.createForm(composite);
					selectorForm.setSeparatorVisible(true);
					formToolkit.paintBordersFor(selectorForm);
					selectorForm.setText("M");
					selectorForm.getBody().setLayout(new FormLayout());
				}
			}
			{
				screenBody = new ScreenBody(sashForm, SWT.NONE);

				// Install all the links on the screen bar.
				this.setBackLink(screenBody.getScreenBar());
				// this.setSaveLink(screenBody.getScreenBar());
				screenBody.setScreenBarOff();
			}
			sashForm.setWeights(new int[] { 100, 491 });
		}
	}

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	@Override
	public Composite addScreenSelector(String name, String iconPath,
			Class<?> screen, int position) {
		return addScreenSelector(null, name, iconPath, screen, position);
	}

	@Override
	public Composite addScreenSelector(Composite above, String name,
			String iconPath, Class<?> screen) {
		return addScreenSelector(above, name, iconPath, screen, -1);
	}

	@Override
	public Composite addScreenSelector(Composite above, String name, String iconPath, Class<?> screen,
			int position) {

		assert position >= 1 || above != null;
		
		try {
			
			// We look for a constructor supporting the selector service. 
			// Screens, will be able to use the selector to place themselves on the 
			// service container, calling updateComposite();
			Constructor<?> c = null;
			try {
				c = screen.getConstructor(Composite.class, int.class, IScreenFormService.class, IEditingService.class);
			} catch (NoSuchMethodException e2) {
				System.out.println("TODO, implement correct screen signature.");
				try {
					c = screen.getConstructor(Composite.class, int.class);
				}catch (NoSuchMethodException e3) {
					e3.printStackTrace();
				}
			}
			
			final Constructor<?> finalC = c; 

			ImageHyperlink lnk = formToolkit.createImageHyperlink(
					getSelectorForm().getBody(), SWT.NONE);
			lnk.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					try {
						
						// Try with 3, than with 2 parameters. 
						Composite target;
						if( finalC.getParameterTypes().length == 4){
							
							target = (Composite) finalC.newInstance(getScreenContainer(),
									SWT.NONE, ScreenFormService.this, editingService);
							
						}else{
							target = (Composite) finalC.newInstance(getScreenContainer(),
									SWT.NONE);
						}
						setActiveScreen(target);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#updateComposite
	 * (org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void setActiveScreen(Composite control) {

		if (activeScreen != null) {
			// We only remember the last screen.
			if (previousScreen != null) {
				previousScreen.dispose();
			}
			previousScreen = activeScreen;
			previousScreen.setVisible(false);
		}

		activeScreen = control;
		formToolkit.adapt(activeScreen);
		formToolkit.paintBordersFor(activeScreen);
		screenBody.getScreenDeck().topControl = activeScreen;
		getScreenContainer().layout(true);

		// Activate the screen bar, if the new composite implements an
		// injected data. (Meaning it's triggered by another screen, and should
		// return.
		if (activeScreen instanceof IDataScreenInjection) {
			bckLnk.setVisible(true);
		}
		if (activeScreen instanceof IDataServiceInjection) {
			bckLnk.setVisible(false);
		}

		screenBody.setScreenBarOn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.selector.ISelectorService#getSelectorForm
	 * ()
	 */
	@Override
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
	@Override
	public Composite getScreenContainer() {
		return this.screenBody.getScreenContainer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.selector.ISelectorService#
	 * restorePreviousScreen()
	 */
	@Override
	public void restorePreviousScreen() {
		if (activeScreen != null) {
			activeScreen.dispose();
			activeScreen = null;
		}
		if (previousScreen != null) {
			activeScreen = previousScreen;
			previousScreen = null;
			activeScreen.setVisible(true);
			// We might need to do something on the previous Screen.
			screenBody.getScreenDeck().topControl = activeScreen;
			getScreenContainer().layout(true);
			updateScreenBarActions(activeScreen);
		} else {
			screenBody.setScreenBarOff();
		}
	}

	public void updateScreenBarActions(Composite activeScreen) {

		// Activate the screen bar, if the new composite implements an
		// injected data. (Meaning it's triggered by another screen, and should
		// return.
		if (activeScreen instanceof IDataScreenInjection) {
			bckLnk.setVisible(true);
		}
		if (activeScreen instanceof IDataServiceInjection) {
			bckLnk.setVisible(false);
		}

	}

	// The screen bar links are exposed, to turn them on and off.
	private Hyperlink bckLnk;

	// private Hyperlink saveLnk;

	private void setBackLink(Composite parent) {
		bckLnk = formToolkit.createHyperlink(parent, "Back", SWT.NONE);
		formToolkit.adapt(bckLnk);
		bckLnk.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				restorePreviousScreen();
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
	}

	// private void setSaveLink(Composite parent){
	// saveLnk = formToolkit.createHyperlink(parent, "Save", SWT.NONE);
	// formToolkit.adapt(saveLnk);
	// saveLnk.addHyperlinkListener(new IHyperlinkListener() {
	// public void linkActivated(HyperlinkEvent e) {
	// // TODO Delegate to the editing service.
	// }
	// public void linkEntered(HyperlinkEvent e) {
	// }
	//
	// public void linkExited(HyperlinkEvent e) {
	// }
	// });
	// }
	IEditingService editingService;

	public void setEditingService(IEditingService eServ) {
		editingService = eServ;
	}

}

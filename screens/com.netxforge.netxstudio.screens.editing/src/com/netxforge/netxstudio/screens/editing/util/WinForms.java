/*******************************************************************************
 * Copyright (c) 31 jan. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.util;

import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.editing.ScreenUtil;

/**
 * Support for windows ( {@link Form} forms ) in a parent {@link Form}.
 * 
 * 
 * @author Christophe
 * 
 */
public class WinForms {

	private Composite content;
	private ScrolledComposite canvas;

	private FormToolkit toolkit;

	/**
	 * Our default Drop target adapter.
	 */
	private final DropTargetAdapter DEFAULT_DROP_ADAPTER = new DropTargetAdapter() {

		@Override
		public void drop(DropTargetEvent event) {

			LocalTransfer localTransfer = LocalTransfer.getInstance();
			if (localTransfer.isSupportedType(event.currentDataType)) {
				// Transfer the data and, if non-null, extract it.
				//
				Object object = localTransfer
						.nativeToJava(event.currentDataType);

				MessageDialog.openInformation(Display.getDefault()
						.getActiveShell(), "Thanx for droppint by!",
						"So you drop details: " + event.toString()
								+ " ...and the data is this: " + object);
			}
		}
	};

	public void buildUI(Composite parent, FormToolkit toolkit) {
		this.toolkit = toolkit;
		canvas = new ScrolledComposite(parent, SWT.NONE | SWT.V_SCROLL
				| SWT.H_SCROLL);

		canvas.addListener(SWT.Activate, new Listener() {
			public void handleEvent(Event e) {
				content.setFocus();
			}
		});

		toolkit.adapt(canvas);
		toolkit.paintBordersFor(canvas);
		canvas.setExpandVertical(true);
		canvas.setExpandHorizontal(true);

		content = toolkit.createComposite(canvas, SWT.NONE);
		RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = true;
		rowLayout.spacing = 10;
		rowLayout.marginLeft = 10;
		rowLayout.marginTop = 10;
		rowLayout.marginRight = 10;

		content.setLayout(rowLayout);
		JFaceResources.getColorRegistry().put("canvas_color",
				new RGB(255, 250, 221));
		content.setBackground(JFaceResources.getColorRegistry().get(
				"canvas_color"));
		toolkit.paintBordersFor(content);

		canvas.setContent(content);
		
		
		// When the row layout wraps, this changes the width of the content 
		// so we show a scrollbar when smaller than the computed width of the content.    
		canvas.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle r = canvas.getClientArea();
				canvas.setMinSize(content.computeSize(r.width, SWT.DEFAULT));
			}
		});

		// Add a local drop target to the content.
		// The windows will also support dropping stuff.

	}

	/**
	 * Add a window.
	 * 
	 * @return
	 */
	public Form addWindow() {
		return addWindow(null, null);
	}

	public Form addWindow(DropTargetAdapter dropTarget, Transfer[] transfers) {

		final Form winForm = toolkit.createForm(content);
		winForm.setSeparatorVisible(false);

		// Use a local transfer.
		winForm.addTitleDropSupport(
				ScreenUtil.DROP_OPERATIONS,
				transfers != null ? transfers : new Transfer[] { LocalTransfer
						.getInstance() }, dropTarget != null ? dropTarget
						: DEFAULT_DROP_ADAPTER);

		toolkit.paintBordersFor(winForm);
		toolkit.decorateFormHeading(winForm);
		winForm.setText("Chart:");
		winForm.getBody().setMenu(new Menu(winForm.getShell(), SWT.POP_UP));

		// Will push the content size, which should trigger the extension of the
		// ScrolledLayout.
		content.pack();
		canvas.layout();
		return winForm;

	}

	public void removeWindow(Form winForm) {
		winForm.dispose();
		content.layout();
	}

	public void addWinFormActions(Form winForm, IAction[] actions) {

		for (IAction a : actions) {
			winForm.getToolBarManager().add(a);
		}
		winForm.getToolBarManager().update(true);
	}

	public void clear() {
		for (Control c : content.getChildren()) {
			c.dispose();
		}
	}

	public void layout() {
		content.layout();
	}

	public Composite getContent() {
		return content;
	}
}

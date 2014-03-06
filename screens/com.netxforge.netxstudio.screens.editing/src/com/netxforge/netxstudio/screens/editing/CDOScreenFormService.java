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
package com.netxforge.netxstudio.screens.editing;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.fixtures.IFixtures;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.IDataServiceInjection;
import com.netxforge.screens.editing.base.IEditingService;
import com.netxforge.screens.editing.base.IScreen;
import com.netxforge.screens.editing.base.IScreenFactory;
import com.netxforge.screens.editing.base.ScreenFormService;
import com.netxforge.screens.editing.base.ScreenUtil;

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
public class CDOScreenFormService extends ScreenFormService {

	@Inject
	public CDOScreenFormService(IEditingService editingService,
			IScreenFactory screenFactory) {
		super(editingService, screenFactory);
	}

	/**
	 * @return
	 */
	public int operationForUser(int operation) {
		String currentUser = getCDOEditingService().getCDOData()
				.getSessionUserID();
		Resource resource = getCDOEditingService().getCDOData().getResource(
				GenericsPackage.Literals.PERSON);
		List<Person> people = new NonModelUtils.CollectionForObjects<Person>()
				.collectionForObjects(resource.getContents());

		final Role r = StudioUtils.roleForUserWithName(currentUser, people);
		if (r.getName().equals(IFixtures.ROLE_READONLY)) {
			operation = ScreenUtil.OPERATION_READ_ONLY;
		}
		return operation;
	}

	public CDOEditingService getCDOEditingService() {
		IEditingService es = getEditingService();
		if (es instanceof CDOEditingService) {
			return (CDOEditingService) es;
		}
		throw new IllegalStateException("Expected a CDOEditingService");
	}

	/**
	 * Warns if the current screen is dirty, if not saving, flush the command
	 * stack. If saving, save depending on the screen type.
	 * 
	 * @return false if cancelled
	 */
	public boolean dirtyWarning() {
		// Warn for unsaved changes.
		if (getCDOEditingService().isDirty()) {

			CDOView view = getCDOEditingService().getView();
			if (view instanceof CDOTransaction) {
				StudioUtils.cdoDumpDirtyObject((CDOTransaction) view);

				int result = DirtyStateMessageDialog
						.openAndReturn(
								MessageDialog.QUESTION_WITH_CANCEL,
								Display.getCurrent().getActiveShell(),
								"Save needed",
								"You have unsaved changes, which will be discarded when not saved, save?",
								(CDOTransaction) view);

				switch (result) {

				case DirtyStateMessageDialog.OK: {
					if (getActiveScreen() instanceof IDataScreenInjection) {
						((IDataScreenInjection) getActiveScreen()).addData();
					} else {
						getCDOEditingService()
								.doSave(new NullProgressMonitor());
					}
				}
					break;
				case 1: // NO
					undoAndFlush();
					break;
				case 2: // CANCEL;
					return true;
				}
			}

		} else {
			// Flush the stack anyway.
			getCDOEditingService().getEditingDomain().getCommandStack().flush();
		}
		return false;
	}

	public void undoAndFlush() {
		// This will flush the stack, but not undo all the commands.
		// We need to undo the executed editing commands.
		while (getCDOEditingService().getEditingDomain().getCommandStack()
				.canUndo()) {
			getCDOEditingService().getEditingDomain().getCommandStack().undo();
		}
		getCDOEditingService().getEditingDomain().getCommandStack().flush();
		// The data should have been disposed by now.

		if (getCDOEditingService().getView().isDirty()) {
			CDOTransaction transaction = (CDOTransaction) getCDOEditingService()
					.getView();
			transaction.rollback();
		}

	}

}

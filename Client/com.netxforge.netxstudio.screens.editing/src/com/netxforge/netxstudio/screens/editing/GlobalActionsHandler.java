package com.netxforge.netxstudio.screens.editing;

import org.eclipse.emf.edit.ui.action.CopyAction;
import org.eclipse.emf.edit.ui.action.CutAction;
import org.eclipse.emf.edit.ui.action.DeleteAction;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

/**
 * Views and editors, can register actions on the global action handlers. This
 * helper, retargets actions to the global handlers. (This code is originally
 * found in the EMF Editor Action Bard Contributor.
 * 
 * @author dzonekl
 * 
 */
public class GlobalActionsHandler  implements IPropertyListener {

	/**
	 * This is the action used to implement delete.
	 */
	protected DeleteAction deleteAction;

	/**
	 * This is the action used to implement cut.
	 */
	protected CutAction cutAction;

	/**
	 * This is the action used to implement copy.
	 */
	protected CopyAction copyAction;

	/**
	 * This is the action used to implement paste.
	 */
	protected PasteAction pasteAction;

	/**
	 * This is the action used to implement undo.
	 */
	protected UndoAction undoAction;

	/**
	 * This is the action used to implement redo.
	 */
	protected RedoAction redoAction;

	public void initActions(IActionBars actionBars) {
		ISharedImages sharedImages = PlatformUI.getWorkbench()
				.getSharedImages();

		deleteAction = createDeleteAction();
		deleteAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(),
				deleteAction);

		cutAction = createCutAction();
		cutAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cutAction);

		copyAction = createCopyAction();
		copyAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(),
				copyAction);

		pasteAction = createPasteAction();
		pasteAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(),
				pasteAction);

		undoAction = createUndoAction();
		undoAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_UNDO));
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(),
				undoAction);

		redoAction = createRedoAction();
		redoAction.setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_REDO));
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(),
				redoAction);
	}

	/**
	 * Returns the action used to implement delete.
	 * 
	 * @see #deleteAction
	 * @since 2.6
	 */
	protected DeleteAction createDeleteAction() {
		return new DeleteAction(removeAllReferencesOnDelete());
	}

	/**
	 * Returns the action used to implement cut.
	 * 
	 * @see #cutAction
	 * @since 2.6
	 */
	protected CutAction createCutAction() {
		return new CutAction();
	}

	/**
	 * Returns the action used to implement copy.
	 * 
	 * @see #copyAction
	 * @since 2.6
	 */
	protected CopyAction createCopyAction() {
		return new CopyAction();
	}

	/**
	 * Returns the action used to implement paste.
	 * 
	 * @see #pasteAction
	 * @since 2.6
	 */
	protected PasteAction createPasteAction() {
		return new PasteAction();
	}

	/**
	 * Returns the action used to implement undo.
	 * 
	 * @see #undoAction
	 * @since 2.6
	 */
	protected UndoAction createUndoAction() {
		return new UndoAction();
	}

	/**
	 * Returns the action used to implement redo.
	 * 
	 * @see #redoAction
	 * @since 2.6
	 */
	protected RedoAction createRedoAction() {
		return new RedoAction();
	}

	protected boolean removeAllReferencesOnDelete() {
		return true;
	}

	/**
	 * Registers the global actions on the workbench part. The part must
	 * implement.
	 * 
	 * @param part
	 */
	public void activate(IWorkbenchPart part) {
		
		part.addPropertyListener(this);
		
		deleteAction.setActiveWorkbenchPart(part);
		cutAction.setActiveWorkbenchPart(part);
		copyAction.setActiveWorkbenchPart(part);
		pasteAction.setActiveWorkbenchPart(part);
		undoAction.setActiveWorkbenchPart(part);
		redoAction.setActiveWorkbenchPart(part);

		ISelectionProvider selectionProvider = part instanceof ISelectionProvider ? (ISelectionProvider) part
				: part.getSite().getSelectionProvider();

		if (selectionProvider != null) {
			selectionProvider.addSelectionChangedListener(deleteAction);
			selectionProvider.addSelectionChangedListener(cutAction);
			selectionProvider.addSelectionChangedListener(copyAction);
			selectionProvider.addSelectionChangedListener(pasteAction);
		}

		update(part);
	}

	public void update(IWorkbenchPart part) {
		ISelectionProvider selectionProvider = part instanceof ISelectionProvider ? (ISelectionProvider) part
				: part.getSite().getSelectionProvider();

		if (selectionProvider != null) {
			ISelection selection = selectionProvider.getSelection();
			IStructuredSelection structuredSelection = selection instanceof IStructuredSelection ? (IStructuredSelection) selection
					: StructuredSelection.EMPTY;

			deleteAction.updateSelection(structuredSelection);
			cutAction.updateSelection(structuredSelection);
			copyAction.updateSelection(structuredSelection);
			pasteAction.updateSelection(structuredSelection);

			undoAction.update();
			redoAction.update();
		}
	}

	public void deactivate(IWorkbenchPart part) {
		
		part.removePropertyListener(this);

		deleteAction.setActiveWorkbenchPart(null);
		cutAction.setActiveWorkbenchPart(null);
		copyAction.setActiveWorkbenchPart(null);
		pasteAction.setActiveWorkbenchPart(null);
		undoAction.setActiveWorkbenchPart(null);
		redoAction.setActiveWorkbenchPart(null);

		ISelectionProvider selectionProvider = part instanceof ISelectionProvider ? (ISelectionProvider) part
				: part.getSite().getSelectionProvider();

		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(deleteAction);
			selectionProvider.removeSelectionChangedListener(cutAction);
			selectionProvider.removeSelectionChangedListener(copyAction);
			selectionProvider.removeSelectionChangedListener(pasteAction);

		}
	}

	public void propertyChanged(Object source, int propId) {
		System.out.println("WORK IN PROGESS : Property fired prop ID" + propId);
		update((IWorkbenchPart) source);
		
	}

}

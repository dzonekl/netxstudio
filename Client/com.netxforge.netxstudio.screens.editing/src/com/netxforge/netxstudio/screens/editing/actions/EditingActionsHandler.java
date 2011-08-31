package com.netxforge.netxstudio.screens.editing.actions;

import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.CopyAction;
import org.eclipse.emf.edit.ui.action.CutAction;
import org.eclipse.emf.edit.ui.action.PasteAction;
import org.eclipse.emf.edit.ui.action.RedoAction;
import org.eclipse.emf.edit.ui.action.UndoAction;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;

import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.IEditingService;


/**
 * Views and editors, can register actions on the global action handlers. This
 * helper, retargets actions to the global handlers. (This code is originally
 * found in the EMF Editor Action Bard Contributor.
 * 
 * @author dzonekl
 * 
 */
public class EditingActionsHandler implements  IActionHandler {

	/**
	 * This style bit indicates that the "additions" separator should come after
	 * the "edit" separator.
	 */
	public static final int ADDITIONS_LAST_STYLE = 0x1;

	/**
	 * This is used to encode the style bits.
	 */
	protected int style;

	/**
	 * This is the action used to implement delete, this is the real delete
	 * action.
	 */
	protected WarningDeleteAction deleteAction;

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

	private IEditingService editingService;

	
	@Inject
	public EditingActionsHandler(IEditingService editingService) {
		this.style = ADDITIONS_LAST_STYLE;
		this.editingService = editingService;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.actions.IActionHandler#initActions(org.eclipse.ui.IActionBars)
	 */
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
	 * @param editingServices 
	 * 
	 * @see #deleteAction
	 * @since 2.6
	 */
	protected WarningDeleteAction createDeleteAction() {
		return new WarningDeleteAction(removeAllReferencesOnDelete(), editingService);
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

	protected IWorkbenchPart activePart;

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.actions.IActionHandler#setActiveEditor(org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IWorkbenchPart part) {
		if (part != activePart) {
			if (activePart != null) {
				deactivate();
			}

			if (part instanceof IEditingDomainProvider) {
				activePart = part;
				activate();

			}
		}
	}

	/**
	 * Registers the global actions on the workbench part. The part must
	 * implement.
	 * 
	 * @param part
	 */
	private void activate() {

		activePart.addPropertyListener(this);

		deleteAction.setActiveWorkbenchPart(activePart);
		cutAction.setActiveWorkbenchPart(activePart);
		copyAction.setActiveWorkbenchPart(activePart);
		pasteAction.setActiveWorkbenchPart(activePart);
		undoAction.setActiveWorkbenchPart(activePart);
		redoAction.setActiveWorkbenchPart(activePart);

		ISelectionProvider selectionProvider = activePart instanceof ISelectionProvider ? (ISelectionProvider) activePart
				: activePart.getSite().getSelectionProvider();

		if (selectionProvider != null) {
			selectionProvider.addSelectionChangedListener(deleteAction);
			selectionProvider.addSelectionChangedListener(cutAction);
			selectionProvider.addSelectionChangedListener(copyAction);
			selectionProvider.addSelectionChangedListener(pasteAction);
		}

		update(activePart);
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

	public void deactivate() {

		activePart.removePropertyListener(this);

		deleteAction.setActiveWorkbenchPart(null);
		cutAction.setActiveWorkbenchPart(null);
		copyAction.setActiveWorkbenchPart(null);
		pasteAction.setActiveWorkbenchPart(null);
		undoAction.setActiveWorkbenchPart(null);
		redoAction.setActiveWorkbenchPart(null);

		ISelectionProvider selectionProvider = activePart instanceof ISelectionProvider ? (ISelectionProvider) activePart
				: activePart.getSite().getSelectionProvider();

		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(deleteAction);
			selectionProvider.removeSelectionChangedListener(cutAction);
			selectionProvider.removeSelectionChangedListener(copyAction);
			selectionProvider.removeSelectionChangedListener(pasteAction);

		}
	}

	public void propertyChanged(Object source, int propId) {
		update((IWorkbenchPart) source);
	}
	
	
	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.actions.IActionHandler#showMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void showMenu(ActionHandlerDescriptor descriptor) {
		IMenuManager menuManager = descriptor.getMenuManager();
		enableMarkers(menuManager);
		
		if(descriptor.enableEditActions){
			enableEditingActions(menuManager);	
		}
		
		menuManager.add(new Separator("additions-end"));
	}


	private void enableMarkers(IMenuManager menuManager){
		// Add our standard marker.
		if ((style & ADDITIONS_LAST_STYLE) == 0) {
			menuManager.add(new Separator("additions"));
		}

		menuManager.add(new Separator("screen"));
		menuManager.add(new Separator("edit"));
		// Add our other standard marker.
	}

	
	private void enableEditingActions(IMenuManager menuManager){
		// Add the edit menu actions.
		//
		menuManager.add(new ActionContributionItem(undoAction));
		menuManager.add(new ActionContributionItem(redoAction));
		menuManager.add(new Separator());
		menuManager.add(new ActionContributionItem(cutAction));
		menuManager.add(new ActionContributionItem(copyAction));
		menuManager.add(new ActionContributionItem(pasteAction));
		menuManager.add(new Separator());
		menuManager.add(new ActionContributionItem(deleteAction));
		menuManager.add(new Separator());

		if ((style & ADDITIONS_LAST_STYLE) != 0) {
			menuManager.add(new Separator("additions"));
			menuManager.add(new Separator());
		}
		
		
	}
	
}

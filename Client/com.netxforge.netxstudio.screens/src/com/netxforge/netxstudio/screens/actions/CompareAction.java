package com.netxforge.netxstudio.screens.actions;

import java.util.List;

import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.actions.BaseSelectionListenerAction;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.screens.FeatureDeltaDialog;

public class CompareAction extends BaseSelectionListenerAction {

	private final ModelUtils modelUtils;

	public CompareAction(ModelUtils modelUtils, String text) {
		super(text);
		this.modelUtils = modelUtils;
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		System.out.println(selection);
		return selection.size() == 2;
	}

	@Override
	public void run() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List twoSelectionList = Lists.newArrayList(this
				.getStructuredSelection().iterator());
		CDORevision rev = (CDORevision) twoSelectionList.get(0);
		CDORevision rev2 = (CDORevision) twoSelectionList.get(1);

		try {
			CDORevisionDelta delta = rev.compare(rev2);
			FeatureDeltaDialog featureDeltaDialog = new FeatureDeltaDialog(Display
					.getDefault().getActiveShell(), this.modelUtils);
			featureDeltaDialog.setDelta(delta);
			featureDeltaDialog.setDeltaInfo("version: " + rev.getVersion()
					+ " with version: " + rev2.getVersion());
			featureDeltaDialog.setBlockOnOpen(true);
			featureDeltaDialog.open();
		} catch (IllegalStateException iae) {
			// compare could throw this: java.lang.IllegalStateException: List contains proxy elements
			// see bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=337054
		}
	}
}
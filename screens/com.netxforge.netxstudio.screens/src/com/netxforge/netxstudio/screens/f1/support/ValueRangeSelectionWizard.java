package com.netxforge.netxstudio.screens.f1.support;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class ValueRangeSelectionWizard extends Wizard implements INewWizard {

	private static final String REPORTING_WIZARD = "reporting_period";

	@Inject
	private ModelUtils modelUtils;

	@Inject
	private ServerRequest serverActions;

	@Inject
	private IEditingService editingService;

	private Object firstSelectedObject;

	@Inject
	private ValueRangeSelectionPage valueRangeSelectionPage;

	private NetXResource netXRes;

	public NetXResource getNetXResource() {
		return netXRes;
	}

	public ValueRangeSelectionWizard() {
		setWindowTitle("Select a range");
		IDialogSettings ds = ScreensActivator.getInstance().getDialogSettings();
		IDialogSettings section = ds.getSection(REPORTING_WIZARD);
		if (section == null) {
			ds.addNewSection(REPORTING_WIZARD);
		}
		this.setDialogSettings(section);
	}

	@Override
	public void addPages() {
		this.addPage(valueRangeSelectionPage);
	}

	@Override
	public boolean performFinish() {
		finishPages();
		return true;
	}

	private void finishPages() {
		valueRangeSelectionPage.finish();

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		firstSelectedObject = ((IStructuredSelection) selection)
				.getFirstElement();
		if (firstSelectedObject instanceof NetXResource) {
			netXRes = (NetXResource) firstSelectedObject;
		}
	}

	public MetricValueRange getValueRange() {
		return valueRangeSelectionPage.getRange();
	}

}

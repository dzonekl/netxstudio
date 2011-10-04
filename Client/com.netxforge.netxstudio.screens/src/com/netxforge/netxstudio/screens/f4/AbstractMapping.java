package com.netxforge.netxstudio.screens.f4;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.f4.support.CSVServiceJob;
import com.netxforge.netxstudio.screens.f4.support.Tuple;
import com.netxforge.netxstudio.screens.f4.support.XLSServiceJob;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

public abstract class AbstractMapping extends AbstractScreen {

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public AbstractMapping(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * The key is the name of the metricsource.
	 * 
	 * @param key
	 * @param file
	 */
	public boolean storeMetricSourceSampleFile(MetricSource source, IFile file) {
		IPath path = file.getFullPath();
		return storePreference(source.getName(), path.toPortableString());
	}

	public IFile getMetricSourceSampleFile(MetricSource source) {
		String entry = findPreference(source.getName());
		if (entry != null) {
			IPath path = Path.fromPortableString(entry);
			IFile file = WorkspaceUtil.INSTANCE.createFileHandle(path);
			if (file.exists()) {
				return file;
			}
		}
		return null;
	}

	protected void loadXLSSampleFile(final MetricSource metricSource,
			final IFile f) {

		final XLSServiceJob job = new XLSServiceJob();
		job.addNotifier(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				super.done(event);
				List<Map<Integer, Tuple>> records = job.getRecords();
				if (records != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (AbstractMapping.this
									.storeMetricSourceSampleFile(metricSource,
											f)) {
								// Succesfully storing.
							} else {
								System.out
										.println("failed to store the sample file : "
												+ f.toString());
							}
							fillGrid(job.getRecords());
						}

					});
				}
			}
		});
		job.setResourceToProcess(f);
		job.go(); // Should spawn a job processing the xls.
	}

	protected void loadCSVSampleFile(final MetricSource metricSource,
			final IFile f) {

		final CSVServiceJob job = new CSVServiceJob();
		job.addNotifier(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				super.done(event);
				String[][] records = job.getRecords();
				if (records != null) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (AbstractMapping.this
									.storeMetricSourceSampleFile(metricSource,
											f)) {
								// Succesfully storing.
							} else {
								System.out
										.println("failed to store the sample file : "
												+ f.toString());
							}
							fillCSVGrid(job.getRecords());
						}

					});
				}
			}
		});
		job.setResourceToProcess(f);
		job.go(); // Should spawn a job processing the xls.
	}

	public abstract void fillGrid(List<Map<Integer, Tuple>> records);

	public abstract void fillCSVGrid(String[][] records);

}

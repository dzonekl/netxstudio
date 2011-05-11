package com.netxforge.netxstudio.emf.poi.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.hibernate.Session;

import com.netxforge.netxstudio.emf.poi.PoiCopyService;
import com.netxforge.netxstudio.emf.poi.PoiMappingService;
import com.netxforge.netxstudio.emf.poi.Tuple;
import com.netxforge.netxstudio.emf.poi.mappings.SGSNAttachedUsers;
import com.netxforge.netxstudio.emf.poi.mappings.XLSMapping;
import com.netxforge.netxstudio.emf.teneo.TeneoModel;
import com.netxforge.netxstudio.emf.teneo.TeneoService;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

/**
 * 
 * Parses all mapping definitions and looks for data to process.
 * 
 * @author dzonekl
 * 
 */
public class PoiScanningService implements IJobChangeListener {

	public static final PoiScanningService INSTANCE = new PoiScanningService();

	public void go() {
		ScanningJob j = new ScanningJob(Messages.PoiScanningService_0);
		j.addJobChangeListener(this);
		j.schedule(1000);
	}

	// Do a simple background job to get the metric sources.
	// This can run at ad-hoc scheduled times.
	protected class ScanningJob extends Job {

		public ScanningJob(String name) {
			super(name);
			super.setUser(true);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			// We need access to the DB, in a single user mode.
			// We don't care about resources here.
			if (TeneoService.getInstance().initialized()) {
				Session session = TeneoService.getInstance().getSession();
				if (TeneoModel.hasTeneoLibrary(session)) {
					Library lib = TeneoModel.firstTeneoLibrary(session);
					processReadingInternal(session, lib, monitor);
					session.close();
					return Status.OK_STATUS;
				}
			}
			return Status.CANCEL_STATUS;
		}
	}

	protected void  processReadingInternal(Session session, Library lib,
			final IProgressMonitor monitor) {

		// Note, this is the current state, any in between update will not be
		// noticed.
		
		if (lib.getMetricSources().size() <= 0) {
			monitor.setCanceled(true);
		}

		// Fake, we just get the metrics path and assume a fixed mapping.
		IPath path = WorkspaceUtil.INSTANCE.getMetricsPath();
		IFolder f = WorkspaceUtil.INSTANCE.createFolderHandle(path);
		try {
			List<IResource> club = Arrays.asList(f.members());
			for (IResource res : club) {

				if (!res.getFileExtension().equals("xls")) { //$NON-NLS-1$
					continue;
				}
				FileInputStream fis = new FileInputStream(res.getLocation()
						.toFile());
				
				// TODO find the corresponding metric source based on the
				// signature of the file.
				// For now hardcoded!
				MetricSource ms = null;
				for (EObject o : lib.getMetricSources()) {
					if (o instanceof MetricSource) {
						MetricSource testMs = (MetricSource) o;
						if (testMs.getName().equals("SGSN Attached Users")) { //$NON-NLS-1$
							ms = testMs;
						}
					}
				}

				if (ms != null) {
					
					XLSMapping mapping = new SGSNAttachedUsers();
					int result = PoiMappingService.INSTANCE.go(monitor, fis,
							mapping);
					if (result != PoiMappingService.OK) {
						// Something went wrong.
					} else {

						List<Tuple> records = PoiMappingService.INSTANCE
								.getRecords();
						PoiUI.INSTANCE.printResult(
								PoiMappingService.INSTANCE.getStatistics(),
								records);
						
						PoiCopyService.INSTANCE.go(new NullProgressMonitor(),session,
								records, mapping, ms);
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// msResource.unload();
		}
	}
	
	// TODO, later. 
//	protected void prepareProcessingStream(MetricSource src) {
//		// Location relative to the workspace for now.
//
//		MetricKind kind = src.getMetrickind();
//		String location = src.getMetricLocation();
//
//		assert location != null && location.length() > 0;
//		if (kind.getValue() == MetricKind.FILE_VALUE) {
//			// Interpret location as IPath
//			WorkspaceUtil.INSTANCE.getLocation(location);
//
//		}
//		if (kind.getValue() == MetricKind.RDMS_VALUE) {
//			// Interpret location as a RDMS URL.
//			// Note we also need a user/pass.
//		}
//
//		// Now get the mapping object.
//		if (src.getName().equals("SGSNAttachedUsers")) { //$NON-NLS-1$
//
//		}
//	}

	@Override
	public void aboutToRun(IJobChangeEvent event) {
		System.out
				.println("Job about to get busy: " + event.getJob().getName()); //$NON-NLS-1$
	}

	@Override
	public void awake(IJobChangeEvent event) {
	}

	@Override
	public void done(IJobChangeEvent event) {
		System.out.println("Job done: " + event.getJob().getName()); //$NON-NLS-1$
	}

	@Override
	public void running(IJobChangeEvent event) {
		System.out.println("Job running: " + event.getJob().getName()); //$NON-NLS-1$
	}

	@Override
	public void scheduled(IJobChangeEvent event) {
		System.out.println("Job scheduled: " + event.getJob().getName()); //$NON-NLS-1$
	}

	@Override
	public void sleeping(IJobChangeEvent event) {
		System.out.println("Job zzzzzz: " + event.getJob().getName()); //$NON-NLS-1$
	}
}

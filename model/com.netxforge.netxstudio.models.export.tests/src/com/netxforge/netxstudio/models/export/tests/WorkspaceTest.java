package com.netxforge.netxstudio.models.export.tests;

import junit.framework.TestCase;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.netxforge.netxstudio.workspace.WorkspaceUtil;


/**
 * Test the bundle com.netxforge.netxstudio.m2t
 * Note that the xpander, is not very clean in it's output. 
 * 
 * 
 * @author dzonekl
 *
 */
public class WorkspaceTest extends TestCase {
	
	private TestResourceChangeReporter resourceChangeReporter = new TestResourceChangeReporter();
	
	

	public WorkspaceTest(String name) {
		super(name);
	}


	@Override
	protected void setUp() throws Exception {

		// Create our workspace.
		if (!WorkspaceUtil.INSTANCE.isProjectInitialized()) {
			IProject proj = WorkspaceUtil.INSTANCE
					.createNewProject(WorkspaceUtil.DEFAULT_PROJ_NAME);
			proj.open(IResource.BACKGROUND_REFRESH, new NullProgressMonitor());
			WorkspaceUtil.INSTANCE.setDefaultProject(proj);
			WorkspaceUtil.INSTANCE.createWorkspaceStructure(proj);
		}
		
		WorkspaceUtil.INSTANCE.addChangeListener(resourceChangeReporter);

	

	}

	

	@Override
	protected void tearDown() throws Exception {
		WorkspaceUtil.INSTANCE.removeChangeListener(resourceChangeReporter);

		if (WorkspaceUtil.INSTANCE.isProjectInitialized()) {
			// if(WorkspaceUtil.INSTANCE.getDefaultProject().isOpen()){
			// WorkspaceUtil.INSTANCE.getDefaultProject().close(new
			// NullProgressMonitor());
			// }
			String name = WorkspaceUtil.INSTANCE.getDefaultProject().getName();
			WorkspaceUtil.INSTANCE.bruteDeleteProject(name);
		}
	}
	
	void refreshResource(IResource res){
		try {
			res.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	

	public class TestResourceChangeReporter implements IResourceChangeListener {
		public void resourceChanged(IResourceChangeEvent event) {
			IResource res = event.getResource();
			try {
				switch (event.getType()) {
				case IResourceChangeEvent.PRE_CLOSE:
					System.out.print("Project ");
					System.out.print(res.getFullPath());
					System.out.println(" is about to close.");
					break;
				case IResourceChangeEvent.PRE_DELETE:
					System.out.print("Project ");
					System.out.print(res.getFullPath());
					System.out.println(" is about to be deleted.");
					break;
				case IResourceChangeEvent.POST_CHANGE:
					System.out.println("Resources have changed.");
					event.getDelta().accept(new DeltaPrinter());
					break;
				case IResourceChangeEvent.PRE_BUILD:
					System.out.println("Build about to run.");
					event.getDelta().accept(new DeltaPrinter());
					break;
				case IResourceChangeEvent.POST_BUILD:
					System.out.println("Build complete.");
					event.getDelta().accept(new DeltaPrinter());
					break;
				}
			} catch (CoreException c) {

			}
		}
	}

	class DeltaPrinter implements IResourceDeltaVisitor {
		public boolean visit(IResourceDelta delta) {
			IResource res = delta.getResource();
			
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				System.out.print("Resource ");
				System.out.print(res.getFullPath());
				System.out.println(" was added.");
				break;
			case IResourceDelta.REMOVED:
				System.out.print("Resource ");
				System.out.print(res.getFullPath());
				System.out.println(" was removed.");
				break;
			case IResourceDelta.CHANGED:
				System.out.print("Resource ");
				System.out.print(res.getFullPath());
				System.out.println(" has changed.");
				break;
			}
			return true; // visit the children
		}
	}
	
	
	
	

}

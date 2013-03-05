package com.netxforge.netxstudio.screens.ide;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.osgi.framework.Bundle;

/**
 * 
 * Make sure we always have a workspace project to store resources in a
 * predifined structure.
 * 
 * We also expose various methods to deal with resources and our project
 * structure.
 * 
 * Set the workspace manually. 
 * 
 * http://hexapixel.com/2009/01/12/rcp-workspaces
 * 
 * @author Christophe Bouhier
 * 
 */
public class WorkspaceUtil implements IWorkspaceUtil {

	protected static String[] NETXSTUDIO_FOLDERS = new String[] { "Diagrams",
			"Imports", "Exports", "Scripts", "Transforms", "Models", "Metrics" };

	protected static int DIAGRAMS = 0;
	protected static int IMPORTS = 1;
	protected static int EXPORTS = 2;
	protected static int SCRIPT = 3;
	protected static int TRANSFORMS = 4;
	protected static int MODELS = 5;
	protected static int METRICS = 6;

	public static String DEFAULT_PROJ_NAME = "NetXStudio";
	protected IProject defaultProject = null;

	/**
	 * Singleton implementation
	 */
	public static IWorkspaceUtil INSTANCE = new WorkspaceUtil();

	public IWorkspaceRoot getRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public WorkspaceUtil() {

		ResourcesPlugin.getPlugin(); // Make sure ResourcesPlugin is loaded.

		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(WorkspaceUtil.DEFAULT_PROJ_NAME) != null ? ResourcesPlugin
				.getWorkspace().getRoot()
				.findMember(WorkspaceUtil.DEFAULT_PROJ_NAME).getProject()
				: null;

		if (project != null && validateProject(project))
			defaultProject = project;
	}

	public boolean isProjectInitialized() {
		if (defaultProject != null && defaultProject.isOpen())
			return validateProject(defaultProject);
		else // We need an open project
		if (defaultProject != null)
			try {
				defaultProject.open(new NullProgressMonitor());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#initDefaultProject()
	 */
	public void initDefaultProject() {
		defaultProject = createNewProject(WorkspaceUtil.DEFAULT_PROJ_NAME);
		createWorkspaceStructure(defaultProject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#initializeWorkspace()
	 */
	public void initProjectCreationWizard() {
		// If, we need to create a new project.
		if (!isProjectInitialized()) {

			BasicNewProjectResourceWizard createProjectWiz = new BasicNewProjectResourceWizard();

			IWorkbench workbench = PlatformUI.getWorkbench();
			Shell shell = workbench.getDisplay().getActiveShell();
			createProjectWiz.init(workbench, null);

			WizardDialog dialog = new WizardDialog(shell, createProjectWiz);
			dialog.create();
			dialog.getShell().setSize(
					Math.max(500, dialog.getShell().getSize().x), 500);
			int result = dialog.open();
			if (result == Window.OK) {
				IProject project = createProjectWiz.getNewProject();
				defaultProject = project;
			} else
				defaultProject = createNewProject(WorkspaceUtil.DEFAULT_PROJ_NAME);
		}
		createWorkspaceStructure(defaultProject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#createWorkspaceStructure
	 * (org.eclipse.core.resources.IProject)
	 */
	public void createWorkspaceStructure(IProject proj) {
		if (proj != null) {
			IPath containerPath = proj.getFullPath();
			for (String baseFolder : WorkspaceUtil.NETXSTUDIO_FOLDERS)
				createNewFolderClassic(baseFolder, containerPath, null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#getDefaultProject()
	 */
	public IProject getDefaultProject() {
		return defaultProject;
	}

	public IPath getModelsPath() {
		if (!isProjectInitialized())
			return null;
		return defaultProject.getFullPath().append(
				WorkspaceUtil.NETXSTUDIO_FOLDERS[WorkspaceUtil.MODELS]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#getDiagramsPath()
	 */
	public IPath getDiagramsPath() {
		if (!isProjectInitialized())
			return null;
		return defaultProject.getFullPath().append(
				WorkspaceUtil.NETXSTUDIO_FOLDERS[WorkspaceUtil.DIAGRAMS]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#getDiagramsPath()
	 */
	public IPath getMetricsPath() {
		if (!isProjectInitialized())
			return null;
		return defaultProject.getFullPath().append(
				WorkspaceUtil.NETXSTUDIO_FOLDERS[WorkspaceUtil.METRICS]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#getImportsPath()
	 */
	public IPath getImportsPath() {
		if (!isProjectInitialized())
			return null;

		return defaultProject.getFullPath().append(
				WorkspaceUtil.NETXSTUDIO_FOLDERS[WorkspaceUtil.IMPORTS]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#getExportsPath()
	 */
	public IPath getExportsPath() {
		if (!isProjectInitialized())
			return null;
		return defaultProject.getFullPath().append(
				WorkspaceUtil.NETXSTUDIO_FOLDERS[WorkspaceUtil.EXPORTS]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#getTransformsPath()
	 */
	public IPath getTransformsPath() {
		if (!isProjectInitialized())
			return null;
		return defaultProject.getFullPath().append(
				WorkspaceUtil.NETXSTUDIO_FOLDERS[WorkspaceUtil.TRANSFORMS]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#setDefaultProject(org
	 * .eclipse.core.resources.IProject)
	 */
	public void setDefaultProject(IProject defaultProject) {
		this.defaultProject = defaultProject;
	}

	public boolean validateProject(IProject project) {

		boolean structureFine = false;
		if (validateFolders(project))
			structureFine = true;
		return structureFine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#getUniqueDiagramFileName
	 * (org.eclipse.core.runtime.IPath, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */

	public String getUniqueDiagramFileName(IPath containerFullPath,
			String fileName, String extension, String hintName) {

		if (containerFullPath == null)
			containerFullPath = getDiagramsPath();
		return getUniqueFileName(containerFullPath, fileName, extension,
				hintName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#getDerivedFilePath(
	 * org.eclipse.core.runtime.IPath, java.lang.String, java.lang.String)
	 */

	public IPath getDerivedFilePath(IPath filePath, String suffix, String srcExt) {

		String extension;
		String fileName;
		IPath path;

		path = filePath.removeLastSegments(1);

		if (filePath.getFileExtension() != null) {
			extension = filePath.getFileExtension();
			fileName = filePath.removeFileExtension().lastSegment();
		} else {
			extension = srcExt;
			fileName = filePath.lastSegment();
		}

		path = path.append(fileName + suffix + '.' + extension);
		return path;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#getUniqueFileName(org
	 * .eclipse.core.runtime.IPath, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */

	public String getUniqueFileName(IPath containerFullPath, String fileName,
			String extension, String hintName) {

		if (fileName == null || fileName.trim().length() == 0)
			fileName = hintName == null ? "default" : hintName; //$NON-NLS-1$

		IPath filePath = containerFullPath.append(fileName);
		if (extension != null && !extension.equals(filePath.getFileExtension()))
			filePath = filePath.addFileExtension(extension);
		extension = filePath.getFileExtension();
		fileName = filePath.removeFileExtension().lastSegment();
		int i = 1;
		while (ResourcesPlugin.getWorkspace().getRoot().exists(filePath)) {
			i++;
			filePath = containerFullPath.append(fileName + i);
			if (extension != null)
				filePath = filePath.addFileExtension(extension);
		}
		return filePath.lastSegment();
	}

	protected boolean validateFolders(IProject project) {

		int matchingFolders = 0;

		try {
			IResource[] members = project.members();
			for (IResource iResource : members)
				if (iResource instanceof IFolder) {
					IFolder folder = (IFolder) iResource;
					String[] folders = WorkspaceUtil.NETXSTUDIO_FOLDERS;
					for (int i = 0; i < folders.length; i++) {
						String string = folders[i];
						if (folder.getName().equals(string))
							matchingFolders++;
					}
				}

			if (matchingFolders == WorkspaceUtil.NETXSTUDIO_FOLDERS.length)
				return true;

		} catch (CoreException e) {
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#createNewProject(java
	 * .lang.String)
	 */

	public IProject createNewProject(String projectName) {

		// get a project handle
		final IProject newProjectHandle = createProjectHandle(projectName);

		if (newProjectHandle.exists())
			return newProjectHandle;

		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				newProjectHandle.create(new NullProgressMonitor());
				newProjectHandle.open(new NullProgressMonitor());
			}
		};

		try {
			op.run(new NullProgressMonitor());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return newProjectHandle;
	}

	public void bruteDeleteProject(String projectName) {

		// get a project handle
		final IProject projectHandle = createProjectHandle(projectName);

		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {
				projectHandle.delete(true, true, new NullProgressMonitor());
				if (projectHandle.equals(defaultProject))
					defaultProject = null;
			}
		};
		try {
			op.run(new NullProgressMonitor());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a file from an inputstream in a workspace modification algorithm.
	 * 
	 * @param fileName
	 * @param containerPath
	 * @return
	 */

	public IFile createNewFile(final InputStream stream, String fileName,
			IPath containerPath) {

		assert stream != null && containerPath != null;

		IPath filePath = containerPath.append(fileName);
		final IFile file = createFileHandle(filePath);

		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {

				file.create(stream, true, monitor);
			}
		};

		try {
			op.run(new NullProgressMonitor());
		} catch (InvocationTargetException e) {
		} catch (InterruptedException e) {
		}
		return file;

	}

	/**
	 * @see com.netxforge.netxstudio.screens.ide.IWorkspaceUtil#createNewFolderClassic
	 *      (java.lang.String, org.eclipse.core.runtime.IPath, java.net.URI)
	 */
	public IFolder createNewFolderClassic(String folderName,
			IPath containerPath, final URI linkTargetPath) {

		IPath newFolderNamePath = new Path(folderName);
		// create the new folder and cache it if successful
		IPath newFolderPath = containerPath.append(newFolderNamePath);
		final IFolder folderHandle = createFolderHandle(newFolderPath);

		WorkspaceModifyOperation op = new WorkspaceModifyOperation() {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InvocationTargetException,
					InterruptedException {

				try {
					if (!folderHandle.exists())
						if (linkTargetPath != null)
							folderHandle.createLink(linkTargetPath,
									IResource.ALLOW_MISSING_LOCAL, monitor);
						else {
							IPath path = folderHandle.getFullPath();
							IWorkspaceRoot root = ResourcesPlugin
									.getWorkspace().getRoot();
							int numSegments = path.segmentCount();
							if (numSegments > 2
									&& !root.getFolder(
											path.removeLastSegments(1))
											.exists())
								// If the direct parent of the path doesn't
								// exist, try
								// to create the
								// necessary directories.
								for (int i = numSegments - 2; i > 0; i--) {
									IFolder folder = root.getFolder(path
											.removeLastSegments(i));
									if (!folder.exists())
										folder.create(false, true, monitor);
								}
							folderHandle.create(false, true, monitor);
						}
				} catch (CoreException e) {
					// If the folder already existed locally, just refresh to
					// get
					// contents
					if (e.getStatus().getCode() == IResourceStatus.PATH_OCCUPIED)
						folderHandle.refreshLocal(IResource.DEPTH_INFINITE,
								new SubProgressMonitor(monitor, 500));
					else
						throw e;
				}
			}
		};

		try {
			op.run(new NullProgressMonitor());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return folderHandle;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#createFolderHandle(
	 * org.eclipse.core.runtime.IPath)
	 */

	public IFolder createFolderHandle(IPath folderPath) {
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(folderPath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#createProjectHandle
	 * (java.lang.String)
	 */

	public IProject createProjectHandle(String projectName) {
		return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
	}

	public IFile createFileHandle(IPath filePath) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#getLocation(java.lang
	 * .String)
	 */

	public IPath getLocation(String text) {
		if (text.length() == 0)
			return null;
		IPath path = new Path(text);
		return makeFileSystemAbsolute(path);
	}

	public IPath makeFileSystemAbsolute(IPath path) {
		path = ResourcesPlugin.getWorkspace().getRoot().getLocation()
				.append(path);
		return path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#exists(org.eclipse.
	 * core.runtime.IPath)
	 */

	public boolean exists(IPath path) {
		// String fileName = path.lastSegment();
		path.removeLastSegments(1); // Strip the file name.
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		return file.exists();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#stripWorkspace(org.
	 * eclipse.core.runtime.IPath)
	 */

	public IPath stripWorkspace(IPath path) {
		IPath rootLoc = ResourcesPlugin.getWorkspace().getRoot().getLocation();
		if (rootLoc.isPrefixOf(path))
			path = path.setDevice(null).removeFirstSegments(
					rootLoc.segmentCount());
		return path.makeAbsolute();
	}

	int depth = 0;

	public void dumpWorkspace() {
		try {
			dumpWorkspace(getRoot().members());
		} catch (CoreException e) {
		}
	}

	public void dumpWorkspace(IResource[] res) {
		depth++;
		for (int i = 0; i < res.length; i++) {
			IResource resource = res[i];
			for (int j = 0; j < depth; j++)
				System.out.print('-');
			System.out.println(resource.getName());
			if (resource instanceof IContainer)
				try {
					dumpWorkspace(((IContainer) resource).members());
					depth--;
				} catch (CoreException e) {
				}

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#browse(org.eclipse.
	 * swt.widgets.Shell, org.eclipse.core.runtime.IPath, boolean)
	 */

	public IPath browseFileSystem(Shell shell, IPath path, boolean mustExist) {
		FileDialog dialog = new FileDialog(shell, mustExist ? SWT.OPEN
				: SWT.SAVE);
		if (path != null) {
			if (path.segmentCount() > 1)
				dialog.setFilterPath(path.removeLastSegments(1).toOSString());
			if (path.segmentCount() > 0)
				dialog.setFileName(path.lastSegment());
		}
		String result = dialog.open();
		if (result == null)
			return null;
		return new Path(result);
	}

	/**
	 * Browse the workspace and return multiple selected paths.
	 * 
	 * @param shell
	 * @return
	 */

	public IPath[] browseWorkspace(Shell shell) {
		ResourceSelectionDialog dialog = new ResourceSelectionDialog(shell,
				getDefaultProject(), "Select a resource");
		// dialog.setInitialSelections(selectedResources);
		dialog.open();
		// We only get the first resource.
		Object[] result = dialog.getResult();
		if (result == null)
			return null;
		List<IPath> pathResult = new ArrayList<IPath>();
		for (int i = 0; i < result.length; i++) {
			IFile f = (IFile) result[i];
			pathResult.add(f.getFullPath());
		}
		return pathResult.toArray(new IPath[pathResult.size()]);
	}

	public void copyFromFileSystem(int targetFolderFlag, URI sourceURI) {

	}

	public void copyFromPlugin(int targetFolderFlag, URI sourceURI) {

	}

	public void saveChanges() {
		try {
			ResourcesPlugin.getWorkspace().save(false,
					new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void addChangeListener(IResourceChangeListener listener) {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(listener);
	}

	public void removeChangeListener(IResourceChangeListener listener) {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(listener);
	}

	// PLUGIN STUFF
	// NetXStudio platform related methods. (Methods which do stuff with the
	// plugins).

	/**
	 * Extract plugin resources from our fixture plugin, and put them in the
	 * appropriate folder.
	 * 
	 * .qvto -> transforms.
	 * 
	 * 
	 */

	public void extractFixturePlugin() {
		Bundle b = Platform.getBundle("com.netxforge.netxstudio.fixtures");
		if (b != null) {
			Enumeration<URL> e = b.findEntries("transforms", "*.qvto", true);
			while (e != null && e.hasMoreElements()) {
				Object o = e.nextElement();
				if (o instanceof URL) {
					URL u = (URL) o;
					String filePathInBundle = u.getFile();
					IPath bPath = getBundleFullPath(b);
					IPath filePath = bPath.append(filePathInBundle);
					String fileName = filePath.lastSegment();
					try {
						InputStream s = u.openStream();
						createNewFile(s, fileName, getTransformsPath());

					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			e = b.findEntries("xls", "*.xml", false);
			while (e != null && e.hasMoreElements()) {
				Object o = e.nextElement();
				if (o instanceof URL) {
					URL u = (URL) o;
					String filePathInBundle = u.getFile();
					IPath bPath = getBundleFullPath(b);
					IPath filePath = bPath.append(filePathInBundle);
					String fileName = filePath.lastSegment();
					try {
						InputStream s = u.openStream();
						createNewFile(s, fileName, getImportsPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			e = b.findEntries("netxstudio", "*.netxstudio", false);
			while (e != null && e.hasMoreElements()) {
				Object o = e.nextElement();
				if (o instanceof URL) {
					URL u = (URL) o;
					String filePathInBundle = u.getFile();
					IPath bPath = getBundleFullPath(b);
					IPath filePath = bPath.append(filePathInBundle);
					String fileName = filePath.lastSegment();
					try {
						InputStream s = u.openStream();
						createNewFile(s, fileName, getModelsPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			e = b.findEntries("metrics", "*.xls", false);

			while (e != null && e.hasMoreElements()) {
				Object o = e.nextElement();
				if (o instanceof URL) {
					URL u = (URL) o;
					String filePathInBundle = u.getFile();
					IPath bPath = getBundleFullPath(b);
					IPath filePath = bPath.append(filePathInBundle);
					String fileName = filePath.lastSegment();
					try {
						InputStream s = u.openStream();
						createNewFile(s, fileName, getMetricsPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
			e = b.findEntries("metrics", "*.txt", false);

			while (e != null && e.hasMoreElements()) {
				Object o = e.nextElement();
				if (o instanceof URL) {
					URL u = (URL) o;
					String filePathInBundle = u.getFile();
					IPath bPath = getBundleFullPath(b);
					IPath filePath = bPath.append(filePathInBundle);
					String fileName = filePath.lastSegment();
					try {
						InputStream s = u.openStream();
						createNewFile(s, fileName, getMetricsPath());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

		}
	}

	/**
	 * We return the bundle full path.
	 * 
	 * @param path
	 * @return
	 */

	public Path getBundleFullPath(Bundle b) {
		String s = getBundlePathAsString(b);
		Path p = new Path(s);
		if (p.isValidPath(s))
			return p;
		return Path.EMPTY;
	}

	public String getBundlePathAsString(Bundle b) {
		String loc = b.getLocation();
		loc = loc.substring(loc.indexOf("file:"), loc.length());
		return loc;
	}

	/**
	 * 
	 * @param bundleSymbolicName
	 * @return
	 */

	public String getBundlePathAsString(String bundleSymbolicName) {
		Bundle b = Platform.getBundle(bundleSymbolicName);
		return this.getBundlePathAsString(b);
	}

}
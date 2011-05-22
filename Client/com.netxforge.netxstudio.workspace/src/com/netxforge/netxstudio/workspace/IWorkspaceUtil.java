package com.netxforge.netxstudio.workspace;

import java.io.InputStream;
import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

public interface IWorkspaceUtil {

	/**
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#initProjectCreationWizard()
	 */
	public abstract void initProjectCreationWizard();
	
	
	/**
	 * Init the project structure with the default project name.
	 */
	public abstract void initDefaultProject();
	
	/**
	 * Create the project structure with all subfolders. 
	 * @param proj
	 */
	public abstract void createWorkspaceStructure(IProject proj);

	/**
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#getDefaultProject()
	 **/
	public abstract IProject getDefaultProject();
	
	public abstract IPath getModelsPath();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#getDiagramsPath()
	 */
	public abstract IPath getDiagramsPath();
	
	
	public abstract IPath getMetricsPath();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#getImportsPath()
	 */
	public abstract IPath getImportsPath();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.workspace.IWorkspaceUtil#getExportsPath()
	 */
	public abstract IPath getExportsPath();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#getTransformsPath()
	 */
	public abstract IPath getTransformsPath();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#setDefaultProject(org
	 * .eclipse.core.resources.IProject)
	 */
	public abstract void setDefaultProject(IProject defaultProject);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.workspace.IWorkspaceUtil#getUniqueDiagramFileName
	 * (org.eclipse.core.runtime.IPath, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	public abstract String getUniqueDiagramFileName(IPath containerFullPath,
			String fileName, String extension, String hintName);

	/**
	 * Append a suffix to the file name of the provided path and return a new
	 * path from this. If the provided path has no file name has no extension we
	 * append the provided extension, otherwise the src file name extension is
	 * kept.
	 * 
	 * @param srcPath
	 * @param suffix
	 * @return
	 */
	public abstract IPath getDerivedFilePath(IPath filePath, String suffix,
			String srcExt);

	/**
	 * Get a unique filename
	 * 
	 * 
	 * @param containerFullPath
	 * @param fileName
	 * @param extension
	 * @param hintName
	 * @return
	 */
	public abstract String getUniqueFileName(IPath containerFullPath,
			String fileName, String extension, String hintName);

	/**
	 * Create a new project. The operations is executed in a workspace
	 * modification operation. The project description is empty. (No Natures, No
	 * build specs, No references).
	 * 
	 * @return
	 */
	public abstract IProject createNewProject(String projectName);

	/**
	 * 
	 * @param folderName
	 * @param containerPath
	 * @param linkTargetPath
	 * @return
	 */
	public abstract IFolder createNewFolderClassic(String folderName,
			IPath containerPath, final URI linkTargetPath);

	public abstract IFolder createFolderHandle(IPath folderPath);
	
	/**
	 * Create a Project handle for the given project name.
	 * @param projectName
	 * @return
	 */
	public abstract IProject createProjectHandle(String projectName);

	/**
	 * Get the IPath for a certain textual path. If relative, we prepend the
	 * workspace path.
	 * 
	 * @param text
	 * @return
	 */
	public abstract IPath getLocation(String text);

	public abstract boolean exists(IPath path);
	
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public abstract IPath stripWorkspace(IPath path);
	
	/**
	 * 
	 * @param shell
	 * @param path which will be set as filter. 
	 * @param mustExist if the dialog should be open or save.
	 * @return
	 */
	public abstract IPath browseFileSystem(Shell shell, IPath path, boolean mustExist);
	
	/**
	 * Browse the workspace and return one or more resources. 
	 * 
	 * @param shell
	 * @param path
	 * @param mustExist
	 * @return
	 */
	public abstract IPath[] browseWorkspace(Shell shell);

	/**
	 * 
	 * @param path
	 * @return
	 */
	public abstract IPath makeAbsolute(IPath path);
	
	
	/**
	 * Force a deletion of a project from the workspace, including the content on the file system. 
	 * @param projectName
	 */
	public abstract void bruteDeleteProject(String projectName);

	public abstract boolean isProjectInitialized();
	

	/**
	 * Perform validation on the project and underlying folder structure.
	 * 
	 * @param project
	 * @return
	 */
	public abstract boolean validateProject(IProject project);

	public abstract void saveChanges();

	public abstract void addChangeListener(IResourceChangeListener listener);
	
	/**
	 * 
	 * @param listener
	 */
	public abstract void removeChangeListener(IResourceChangeListener listener);
	
	/**
	 * 
	 */
	public abstract void extractFixturePlugin();
	
	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public abstract IFile createFileHandle(IPath filePath);
	
	/**
	 * 
	 * @param stream
	 * @param fileName
	 * @param containerPath
	 * @return
	 */
	public abstract IFile createNewFile(InputStream stream, String fileName, IPath containerPath);
	
	/**
	 * 
	 * @param b
	 * @return
	 */
	public abstract Path getBundleFullPath(Bundle b);

	/**
	 * 
	 * @param bundleSymbolicName
	 * @return
	 */
	public abstract String getBundlePathAsString(String bundleSymbolicName);

	/**
	 * 
	 * @param b
	 * @return
	 */
	public abstract String getBundlePathAsString(Bundle b);
	
	/**
	 * 
	 */
	public abstract void dumpWorkspace();

	/**
	 * 
	 * @param res
	 */
	public abstract void dumpWorkspace(IResource[] res);
	
	/**
	 * The workspace root.
	 * @return
	 */
	public abstract IWorkspaceRoot getRoot();

	
	

}
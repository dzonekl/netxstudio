package com.netxforge.netxstudio.models.export.tests;

import junit.textui.TestRunner;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.expression.Variable;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.models.export.XpandRegistryImpl;
import com.netxforge.netxstudio.models.export.XpandTemplate;
import com.netxforge.netxstudio.models.export.impl.XpandCallerService;
import com.netxforge.netxstudio.models.export.impl.XpandPackageImport;
import com.netxforge.netxstudio.workspace.WorkspaceUtil;

/**
 * Test the bundle com.netxforge.netxstudio.m2t Note that the xpander, is not
 * very clean in it's output.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class ImportTest extends WorkspaceTest {

	public static void main(String[] args) {
		TestRunner.run(ImportTest.class);
	}

	EPackage[] packages = new EPackage[] { LibraryPackage.eINSTANCE };

	public void testM2T() {
		// TODO, break-up in separate test cases.

		// 1ST TEST
		// Test output to a file with a standard template in our xpland plugin.
		IPath path = WorkspaceUtil.INSTANCE.getExportsPath();
		IContainer container = ResourcesPlugin.getWorkspace().getRoot()
				.getFolder(path);

		for (int i = 0; i < packages.length; i++) {
			
			XpandTemplate t = XpandRegistryImpl.INSTANCE.getTemplates().get(
					XpandPackageImport.XPAND_IMPORT);
			
			String fileName = packages[i].getName() + "." + t.getExtension(); // The name of the file to
														// be exported.

			t.getGlobalVarsMap().put(XpandCallerService.FILE_NAME,
					new Variable(XpandCallerService.FILE_NAME, fileName));
			if (t.isMetaTarget()) {
				t.setTargetObject(packages[i]);
				t.xpand(container);
			}

			// Xpand for some reason doesn't notify the workspace of a change,
			// so we can't refresh.
			// It uses some custom File handle and writing.
			this.refreshResource(container);

			IPath testPath = path.append(fileName);
			// Now get the file.

			IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(testPath);
			assertNotNull(file);
			assertTrue(file.exists());
		}
	}

	public ImportTest(String name) {
		super(name);
	}

}

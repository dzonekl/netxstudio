package com.netxforge.netxstudio.models.export.tests;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import junit.textui.TestRunner;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtend.expression.Variable;

import com.netxforge.netxstudio.models.export.XpandRegistryImpl;
import com.netxforge.netxstudio.models.export.XpandTemplate;
import com.netxforge.netxstudio.models.export.impl.XpandCallerService;
import com.netxforge.netxstudio.models.export.impl.XpandLibraryToXls;
import com.netxforge.netxstudio.models.export.impl.XpandNodeTypeToHtml;
import com.netxforge.netxstudio.screens.ide.WorkspaceUtil;


/**
 * Test the bundle com.netxforge.netxstudio.m2t
 * Note that the xpander, is not very clean in it's output. 
 * 
 * 
 * @author Christophe Bouhier
 *
 */
public class M2TTest extends WorkspaceTest {
	
	public static final String MODEL_NAME = "netxstudio/networks13102010.netxstudio";
	
	private Resource fixture;
	
	public static void main(String[] args) {
		TestRunner.run(M2TTest.class);
	}

	
	
	@Override
	protected void setUp() throws Exception {
		this.loadFixture();
		super.setUp();
	}



	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
		super.tearDown();
	}



	public void testM2T() {
		// TODO, break-up in separate test cases.
		
		// 1ST TEST
		// Test output to a file with a standard template in our xpland plugin.
		IPath path = WorkspaceUtil.INSTANCE.getExportsPath();
		IContainer container = ResourcesPlugin.getWorkspace().getRoot()
		.getFolder(path);
		
		XpandTemplate t = XpandRegistryImpl.INSTANCE.getTemplates().get(
				XpandLibraryToXls.XPAND_NETWORKS2XLS);
		t.getGlobalVarsMap().put(XpandCallerService.FILE_NAME, new Variable(XpandCallerService.FILE_NAME,
		"test"));
		if(t.isMetaTarget()){
			t.xpand(container);
		}

		// Xpand for some reason doesn't notify the workspace of a change, so we can't refresh.
		// It uses some custom File handle and writing. 
		this.refreshResource(container);
		
		IPath testPath = path.append("test.xls");
		// Now get the file.
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(testPath);
		assertNotNull(file);
		assertTrue(file.exists());
		
		// 2ND TEST
		
		t = XpandRegistryImpl.INSTANCE.getTemplates().get(
				XpandNodeTypeToHtml.XPAND_NODETYPE2HTML);
		t.getGlobalVarsMap().remove(XpandCallerService.FILE_NAME);
		t.getGlobalVarsMap().put(XpandCallerService.FILE_NAME, new Variable(XpandCallerService.FILE_NAME,
		"test2"));

		Resource res = this.getFixture();
		assertNotNull(res);
		
		
		// TODO, Migrate model exporter code. 
//		if(!t.isMetaTarget()){
//			t.setTargetObject(lib);
//			t.xpand(container);
//		}
		
		
		this.refreshResource(container);
		testPath = path.append("test2.htm");
		// Now get the file.
		
		file = ResourcesPlugin.getWorkspace().getRoot().getFile(testPath);
		assertNotNull(file);
		assertTrue(file.exists());
	}

	public M2TTest(String name) {
		super(name);
	}
	
	private void loadFixture() {
		// When setting up M2T, we:
		// Load a resource with our source model to act from.
		// Print our registered packages.
		Set<String> pKeys = EPackage.Registry.INSTANCE.keySet();
		for (String s : pKeys) {
			System.out.println("nsURI: " + s + " package Entry: "
					+ EPackage.Registry.INSTANCE.get(s));
		}

		URI model = URI.createFileURI(NetxstudioTests.FIXTURE_PATH
				+ MODEL_NAME);
		ResourceSetImpl set = new ResourceSetImpl();

		// Print the current URI map. (Also delegates to global for a resource).
		set.getURIConverter().getURIMap()
				.putAll(EcorePlugin.computePlatformURIMap());
		Map<URI, URI> map = set.getURIConverter().getURIMap();
		Set<URI> keys = map.keySet();
		// Collection<URI> values = map.values();
		for (URI u : keys) {
			System.out.println("URI:" + u + " nsURI: " + map.get(u));
		}

		// TODO, Optionally add Entries to the URI mapper to find packages and
		// nsURI's from the platform plugins and workspace plugins.
		Resource res = set.createResource(model);
		assert res != null;

		try {
			res.load(set.getLoadOptions());
		} catch (IOException e) {
			return;
		}
		setFixture(res);
	}
	
	protected void setFixture(Resource fixture) {
		this.fixture = fixture;
	}

	protected Resource getFixture() {
		return fixture;
	}
	
}

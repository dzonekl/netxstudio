package com.netxforge.releng.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.CoreException;
import org.junit.Test;

public class JavaDocRelengTest extends RelengAntRunnerTest {

	private static String ANT_JAVADOC = "platform:/plugin/com.netxforge.releng.product.client/build/javadoc.ant";
	private static String PROPERTIES = "platform:/plugin/com.netxforge.releng.product.client/properties/javadoc.properties";

	@Override
	protected String getAntBuildFileLocation() {
		URL url;
		try {
			url = new URL(ANT_JAVADOC);
			String externalForm = url.toExternalForm();
			System.out.println(externalForm);
			return externalForm;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Test
	public void testJavaDocReleng() {

		// Run the ANT task.
		try {
			runner.run();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected String[] getPropertiesFiles() {
		URL url;
		try {
			url = new URL(PROPERTIES);
			String externalForm = url.toExternalForm();
			System.out.println(externalForm);
			return new String[] { externalForm };
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// An empty String array.
		return new String[0];
	}

	@Override
	protected String[] getExecutionTargets() {
		return new String[] { "create.javadoc" };
	}

}

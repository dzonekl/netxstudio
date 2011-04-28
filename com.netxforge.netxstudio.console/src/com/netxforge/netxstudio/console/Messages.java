package com.netxforge.netxstudio.console;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.netxforge.netxstudio.console.messages"; //$NON-NLS-1$
	public static String ConsoleService_0;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}

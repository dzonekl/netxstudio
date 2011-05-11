package com.netxforge.netxstudio.emf.teneo.ui;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescriber;
import org.eclipse.core.runtime.content.IContentDescription;

public class TeneoContent implements IContentDescriber {

	@Override
	public int describe(InputStream contents, IContentDescription description)
			throws IOException {
		@SuppressWarnings("unused")
		IContentDescription desc = description;
		return 0;
	}

	@Override
	public QualifiedName[] getSupportedOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}

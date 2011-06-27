package com.netxforge.netxstudio.screens;

import com.google.inject.AbstractModule;

public class ScreensModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(SearchFilter.class);
	}

}

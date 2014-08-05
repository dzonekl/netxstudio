package com.netxforge.netxstudio.screens.f1.model;

import com.netxforge.netxstudio.services.RFSService;

public class WrappedRFSService {

	private RFSService service;

	public WrappedRFSService(RFSService service) {
		this.service = service;
	}
	
	public RFSService getService(){
		return service;
	}
	
}

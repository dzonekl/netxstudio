package com.netxforge.netxstudio.emf.teneo;

public class ServiceMediator implements IServiceMediator {
	
	private IPersistenceService service;
	
	@Override
	public void addService(IPersistenceService service) {
		this.service = service;
	}
	
	@Override
	public void removeService(IPersistenceService service) {
		this.service = null;
	}

	@Override
	public void addConsumer(IServiceConsumer consumer) {
		consumer.setService(service);
	}

	@Override
	public void removeConsumer(IServiceConsumer consumer) {
		consumer.setService(null);
	}



}

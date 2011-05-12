package com.netxforge.netxstudio.emf.teneo;

public interface IServiceMediator {
	
	public void addService(IPersistenceService service);
	public void removeService(IPersistenceService service);
	public void addConsumer(IServiceConsumer consumer);
	public void removeConsumer(IServiceConsumer consumer);
}

package com.netxforge.netxstudio.emf.teneo;

import org.osgi.framework.ServiceRegistration;

import com.netxforge.netxstudio.emf.teneo.internal.Activator;

public class PersistenceServiceConsumer implements IServiceConsumer {

	private IPersistenceService service;

	public void setService(IPersistenceService service) {
		this.service = service;
	}

	public void useService() {
		ServiceRegistration sr = null;
		try {
			sr = Activator.getContext().registerService(
					IServiceConsumer.class.getName(), this, null);
			assert service != null;
			// use the service
		} finally {
			if(sr != null)
				sr.unregister();
		}
	}

}

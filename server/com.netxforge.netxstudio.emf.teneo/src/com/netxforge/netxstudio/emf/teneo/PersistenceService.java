package com.netxforge.netxstudio.emf.teneo;

public class PersistenceService implements IPersistenceService {

	@Override
	public boolean isAvailable() {
		return TeneoService.getInstance().initialized();
	}

	@Override
	public void start() {
		// We would need to init, with a set of preferences from the preference store
		// and the packages we deal with. 
//		TeneoService.getInstance().initializeDataStore(ePackages, props, dbName)
	}

	@Override
	public void stop() {
	}

}

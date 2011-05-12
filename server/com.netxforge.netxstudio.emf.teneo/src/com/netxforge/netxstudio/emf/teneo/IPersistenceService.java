package com.netxforge.netxstudio.emf.teneo;

/**
 * Experimental DS service for Teneo.
 * @author dzonekl
 */
public interface IPersistenceService {
	public boolean isAvailable();
	public void start();
	public void stop();
}

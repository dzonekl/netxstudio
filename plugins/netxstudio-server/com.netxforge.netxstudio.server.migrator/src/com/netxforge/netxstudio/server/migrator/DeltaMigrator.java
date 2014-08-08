package com.netxforge.netxstudio.server.migrator;

import java.util.List;

import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.compare.Diff;


/**
 * The entry point for the migrator is: 
 * 
 * public final void exportRepository(OutputStream out) throws Exception
 * 
 * @author Christophe
 *
 */
public class DeltaMigrator extends CDOServerMigrator {

	public DeltaMigrator(IRepository repository, List<Diff> diffModel) {
		super(repository, diffModel);
	}
	
}

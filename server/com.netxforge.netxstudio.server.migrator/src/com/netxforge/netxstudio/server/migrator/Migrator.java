package com.netxforge.netxstudio.server.migrator;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.internal.server.bundle.CDOServerApplication;
import org.eclipse.emf.cdo.server.CDOServerUtil;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.db.CDODBUtil;
import org.eclipse.emf.cdo.server.db.IDBStore;
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy;
import org.eclipse.emf.cdo.spi.server.IAppExtension;
import org.eclipse.emf.cdo.spi.server.InternalRepository;
import org.eclipse.emf.cdo.spi.server.RepositoryFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.net4j.db.DBUtil;
import org.eclipse.net4j.db.IDBAdapter;
import org.eclipse.net4j.db.IDBConnectionProvider;
import org.eclipse.net4j.util.container.IElementProcessor;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * Handles model migrations, by either applying the change on the source
 * Repository or applying the change on the target Repository.
 * 
 * The LEFT source should be considered the currently loaded CDO Repository.
 * 
 * @author Christophe Bouhier
 * 
 */
@SuppressWarnings("restriction")
public class Migrator implements IElementProcessor, IAppExtension {

	private static final String TARGET_REPO = "target-repo";
	private static final String SOURCE_REPO = "source-repo";
	private static final String SOURCE_DB_NAME = "TM";
	private static final String TARGET_DB_NAME = "TARGET_TM";

	IManagedContainer container;

	public Object process(IManagedContainer container, String productGroup,
			String factoryType, String description, Object element) {

		// Print the container elements.
		System.out.println("Element: " + element.getClass().getName());
		System.out.println("  => Container: " + container);
		System.out.println("  => productGroup:" + productGroup);
		System.out.println("  => factoryType:" + factoryType);
		System.out.println("  => description:" + description);

		return null;
	}

	public void start(File configFile) throws Exception {
		// Our starting point.
		System.out.println(" Starting migrator ");
		container = IPluginContainer.INSTANCE;

		// Get a set from both packages to produce the diff.

		System.out.println("Loading specified metamodels for migration:");
		ResourceSet set1 = setForEcoreModel("com.netxforge.netxstudio.models/models/cdo/13042011/library.ecore");
		ResourceSet set2 = setForEcoreModel("com.netxforge.netxstudio.models/models/cdo/13042011_diff/library.ecore");

		List<Diff> diffModel = getDiff(set1, set2);

		// createSourceRepo(container);
		// createTargetRepo(container);

		DeltaMigrator deltaMigrator = new DeltaMigrator(
				this.getRepository(SOURCE_REPO), diffModel);

		System.out.println("Start migration process");
		deltaMigrator.migrateAll();

	}

	/**
	 * @return
	 */
	private ResourceSet setForEcoreModel(String platformURI) {

		System.out.println("Attempt to load: " + platformURI);

		URI ecoreMetaURI = URI.createPlatformPluginURI(platformURI, true);

		// Get the resource sets containing the epackages to diff.
		ResourceSet set1 = new ResourceSetImpl();

		// Create a resource for this file.
		Resource src = set1.getResource(ecoreMetaURI, true);

		// Test load the resource..
		if (src.isLoaded()) {
			EPackage foundPackage = null;
			for (EObject root : src.getContents()) {

				System.out.println(root);
				if (root instanceof EPackage) {
					foundPackage = (EPackage) root;
				}
			}
			if (foundPackage != null) {
				System.out.println("The resource: " + platformURI
						+ " with nsURI: " + foundPackage.getNsURI()
						+ " , seems OK, proceeding...");
			}
		}

		return set1;
	}

	public void stop() throws Exception {
		System.out.println(" Stopping migrator ");
	}

	public void createSourceRepo(IManagedContainer container) {

		IMappingStrategy mappingStrategy = createDefaultMappingStrategy();
		IDBStore store = createDefaultDBStore(mappingStrategy, SOURCE_DB_NAME);

		// Create a repository
		Map<String, String> props = new HashMap<String, String>();
		IRepository repository = CDOServerUtil.createRepository(SOURCE_REPO,
				store, props);
		CDOServerUtil.addRepository(container, repository);
	}

	public void createTargetRepo(IManagedContainer container) {
		IMappingStrategy mappingStrategy = createDefaultMappingStrategy();
		IDBStore store = createDefaultDBStore(mappingStrategy, TARGET_DB_NAME);

		// Create a repository
		Map<String, String> props = new HashMap<String, String>();
		IRepository repository = CDOServerUtil.createRepository(TARGET_REPO,
				store, props);
		CDOServerUtil.addRepository(container, repository);
	}

	/**
	 * @param mappingStrategy
	 * @param targetDbName
	 * @return
	 */
	private IDBStore createDefaultDBStore(IMappingStrategy mappingStrategy,
			String dbName) {
		IDBAdapter dbAdapter = DBUtil.getDBAdapter("mysql");

		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl("jdbc:mysql://localhost/" + dbName);
		dataSource.setUser("root");

		IDBConnectionProvider dbConnectionProvider = DBUtil
				.createConnectionProvider(dataSource);
		IDBStore store = CDODBUtil.createStore(mappingStrategy, dbAdapter,
				dbConnectionProvider);
		return store;
	}

	@SuppressWarnings({ "unused" })
	private InternalRepository getRepository(String name) {
		IManagedContainer container = CDOServerApplication.getContainer();
		for (Object element : container
				.getElements(RepositoryFactory.PRODUCT_GROUP)) {
			if (element instanceof InternalRepository) {
				InternalRepository repository = (InternalRepository) element;
				if (repository.getName().equals(name)) {
					return repository;
				}
			}
		}

		return null;
	}

	/**
	 * @return
	 */
	private IMappingStrategy createDefaultMappingStrategy() {
		IMappingStrategy mappingStrategy = CDODBUtil
				.createHorizontalMappingStrategy(false, false);
		Map<String, String> strategyProperties = new HashMap<String, String>();

		// Same as config..
		strategyProperties.put("qualifiedNames", "true");
		strategyProperties.put("toManyReferences", "ONE_TABLE_PER_REFERENCE");
		strategyProperties.put("toOneReferences", "LIKE_ATTRIBUTES");

		mappingStrategy.setProperties(strategyProperties);
		return mappingStrategy;
	}

	private List<Diff> getDiff(ResourceSet set1, ResourceSet set2) {

		System.out.println("Producing metamodel difference:");
		// Configure EMF Compare
		IEObjectMatcher matcher = DefaultMatchEngine
				.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(
				new DefaultEqualityHelperFactory());
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(
				matcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		EMFCompare comparator = EMFCompare.builder()
				.setMatchEngineFactoryRegistry(matchEngineRegistry).build();

		// Compare the two models
		IComparisonScope scope = EMFCompare.createDefaultScope(set1, set2);
		Comparison comparison = comparator.compare(scope);
		List<Diff> differences = comparison.getDifferences();

		System.out.println("Found : " + differences.size() + " differences");
		return differences;
	}

}

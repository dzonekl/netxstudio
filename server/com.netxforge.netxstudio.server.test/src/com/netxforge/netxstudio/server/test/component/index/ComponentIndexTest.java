package com.netxforge.netxstudio.server.test.component.index;

import java.util.List;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.data.importer.IComponentLocator.IdentifierDescriptor;
import com.netxforge.netxstudio.data.index.ComponentMappingIndex;
import com.netxforge.netxstudio.data.index.IComponentMappingIndex;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.server.test.dataprovider.AbstractDataServiceTest4;

/**
 * @author Christophe Bouhier
 * 
 */
public class ComponentIndexTest extends AbstractDataServiceTest4 {

	private IComponentMappingIndex index;

	@Inject
	private ModelUtils modelUtils;

	@Before
	public void before() {
		getInjector().injectMembers(this);
	}

	@Test
	public void testIndex() throws Exception {

		index = super.getInjector().getInstance(IComponentMappingIndex.class);

		IDataProvider provider = this.service.getProvider();
		provider.openSession("admin", "admin");

		((ComponentMappingIndex) index).setDataProvider(provider);

		long nanoTime = System.nanoTime();
		System.out.println("creating index");
		// Build the index.
		index.buildIndex();

		while (index.isIndexing()) {

		}
		;

		System.out.println("index creation took "
				+ modelUtils.timeDurationNanoFromStart(nanoTime));

		// print it.
		index.toString();

		final List<IdentifierDescriptor> descriptors = Lists.newArrayList();

		{
			{
				IdentifierDataKind nodeIDK = nodeIDK();
				Pattern pattern = Pattern.compile("arnstp01");
				IdentifierDescriptor d1 = IComponentLocator.IdentifierDescriptor
						.valueFor(nodeIDK, pattern, 100);

				descriptors.add(d1);
			}
			{
				IdentifierDataKind functionIDK = functionIDK("Name");
				Pattern pattern = Pattern.compile("Signaling");
				IdentifierDescriptor d2 = IComponentLocator.IdentifierDescriptor
						.valueFor(functionIDK, pattern, 100);

				descriptors.add(d2);
			}

		}

		// Find the component with Metric.
		// TODO, dig up a relevant Metric.

		List<Component> componentsForIdentifiers = index
				.componentsForIdentifiers(null, descriptors);

		for (Component c : componentsForIdentifiers) {
			System.err.println(modelUtils.printModelObject(c));
		}

		// Console c = System.console();
		// boolean oneMore = true;
		// while (oneMore) {
		//
		// boolean hasMoreDescriptors = true;
		//
		// while (hasMoreDescriptors) {
		// String s = c.readLine();
		//
		// StringTokenizer stringTokenizer = new StringTokenizer(s, "=");
		// String key = null;
		// String value = null;
		//
		// while (stringTokenizer.hasMoreTokens()) {
		// String nextToken = stringTokenizer.nextToken();
		// if (nextToken.equals("done")) {
		// hasMoreDescriptors = false;
		// break;
		// }else if(nextToken.equals("stop") ){
		// oneMore = false;
		// }else{
		// if(key == null){
		// value = nextToken;
		// }else if(value == null){
		// value = nextToken;
		// }
		// }
		// }
		// }
		//
		// }

		provider.closeSession();

	}

	/**
	 * 
	 */
	private IdentifierDataKind nodeIDK() {
		IdentifierDataKind idk = MetricsFactory.eINSTANCE
				.createIdentifierDataKind();
		// Set the default identifier.
		idk.setObjectKind(ObjectKindType.NODE);
		idk.setObjectProperty(ModelUtils.NODE_ID);
		return idk;
	}

	private IdentifierDataKind functionIDK(String property) {
		IdentifierDataKind idk = MetricsFactory.eINSTANCE
				.createIdentifierDataKind();
		// Set the default identifier.
		idk.setObjectKind(ObjectKindType.FUNCTION);
		idk.setObjectProperty(property);
		return idk;
	}

	@SuppressWarnings("unused")
	private IdentifierDataKind equipmentIDK(String property) {
		IdentifierDataKind idk = MetricsFactory.eINSTANCE
				.createIdentifierDataKind();
		// Set the default identifier.
		idk.setObjectKind(ObjectKindType.EQUIPMENT);
		idk.setObjectProperty(property);
		return idk;
	}

}

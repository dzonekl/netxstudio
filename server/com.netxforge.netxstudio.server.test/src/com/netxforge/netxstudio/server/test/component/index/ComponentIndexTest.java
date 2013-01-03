package com.netxforge.netxstudio.server.test.component.index;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
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

		System.out.println("index creation took "
				+ modelUtils.timeDurationNano(nanoTime));

		// print it.
		index.toString();

		final List<IdentifierDescriptor> descriptors = Lists.newArrayList();

		{
			IdentifierDataKind nodeIDK = nodeIDK();
			IdentifierDescriptor d1 = IComponentLocator.IdentifierDescriptor
					.valueFor(nodeIDK, "arnstp01", 100);
			
			descriptors.add(d1);
			
			IdentifierDataKind functionIDK = functionIDK("Name");
			IdentifierDescriptor d2 = IComponentLocator.IdentifierDescriptor
			.valueFor(functionIDK, "System", 100);
			
			descriptors.add(d2);

		}

		List<Component> componentsForIdentifiers = index
				.componentsForIdentifiers(descriptors);
		
		
		for(Component c : componentsForIdentifiers){
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

	private IdentifierDataKind equipmentIDK(String property) {
		IdentifierDataKind idk = MetricsFactory.eINSTANCE
				.createIdentifierDataKind();
		// Set the default identifier.
		idk.setObjectKind(ObjectKindType.EQUIPMENT);
		idk.setObjectProperty(property);
		return idk;
	}

}

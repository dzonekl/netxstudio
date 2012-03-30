package com.netxforge.netxstudio.data.index;

import java.util.List;

import com.netxforge.netxstudio.data.importer.ComponentLocator.IdentifierDescriptor;
import com.netxforge.netxstudio.library.NetXResource;

/**
 * Holds an index of resource and identifiers.
 */
public interface IResourceMappingIndex {

	/**
	 * build the index for all components and sub resources. 
	 * 
	 * Should walk the Metric Sources, retrieve the metrics and produce a branch of components and
	 * their children which are candidates for a mapping. Then it should for the 
	 * MetricSource get the MappingColumn IdentifierDatakind's. It should then iterate over 
	 * for each of the IdentifierDataKind's it should produce a descriptor holding the EStructuralFeature
	 * for the relevant property. 
	 * 
	 * Then it should walk the component branches matching the Metric, and for each component entry create an 
	 * index entry for each feature combination from the descriptors which occurs in the component. 
	 * 
	 * It should also register as a listener to feature changes 
	 * this could be updates on: 
	 * {@link com.netxforge.netxstudio.library.LibraryPackage.Literals.COMPONENT__METRIC_REFS
	 * Components Metric}
	 * 
	 * It could also be updates on newly created NetXResource objects (Have their own CDO Resource folder).  
	 * 
	 * 
	 */
	public void buildIndex();

	/**
	 * resolves a resource for the specified identifier descriptors.
	 * 
	 * 
	 * 
	 * @param descriptors
	 * @return
	 */
	public NetXResource resourceForIdentifiers(
			List<IdentifierDescriptor> descriptors);

}

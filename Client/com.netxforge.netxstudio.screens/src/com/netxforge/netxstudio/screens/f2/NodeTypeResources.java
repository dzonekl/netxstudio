package com.netxforge.netxstudio.screens.f2;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.Lists;

public class NodeTypeResources extends AbstractResources {

	public NodeTypeResources(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void injectData() {
		resourcesList = Lists.newArrayList();
		// Inject for Node type resources.  
		List<Resource> nodeTypeResources = editingService.getData("NodeType_");
		if (nodeTypeResources != null) {
			resourcesList.addAll(nodeTypeResources);
		}
		super.injectData();
	}

}

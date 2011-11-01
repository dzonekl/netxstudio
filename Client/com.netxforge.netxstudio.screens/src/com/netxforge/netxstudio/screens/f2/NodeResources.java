package com.netxforge.netxstudio.screens.f2;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.Lists;

public class NodeResources extends AbstractResources {

	public NodeResources(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void injectData() {
		
		
		resourcesList = Lists.newArrayList();
		// Inject for Node resources.
		System.out.println("Open NetXResource: " + modelUtils.todayAndNow());
		List<Resource> nodeResources = editingService.getData("Node_");
		if (nodeResources != null) {
			resourcesList.addAll(nodeResources);
		}
		System.out.println("Done open NetXResource: " + modelUtils.todayAndNow());
		super.injectData();
	}

	@Override
	public String getScreenName() {
		return "All Element Resources";
	}
	
}

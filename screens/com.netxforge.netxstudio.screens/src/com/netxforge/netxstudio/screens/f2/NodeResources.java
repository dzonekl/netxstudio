package com.netxforge.netxstudio.screens.f2;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.Lists;
import com.netxforge.base.NonModelUtils;

public class NodeResources extends AbstractResources {

	public NodeResources(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	public void injectData() {
		
		
		resourcesList = Lists.newArrayList();
		// Inject for Node resources.
		System.out.println("Open NetXResource: " + NonModelUtils.todayAndNow());
		
		List<Resource> nodeResources = editingService.getData("Node_");
		if (nodeResources != null) {
			resourcesList.addAll(nodeResources);
		}
		
		System.out.println("Done open NetXResource: " + NonModelUtils.todayAndNow());
		super.injectData();
	}

	@Override
	public String getScreenName() {
		return "All Element Resources";
	}
	
	public void buildColumns(){
		String[] properties = new String[] { "Network Element", "Component",
				"Metric", "Short Name", "Expression Name", "Long Name",
				"Capacity", "Unit" };

		int[] columnWidths = new int[] { 100, 100, 112, 76, 104, 200, 100, 68 };

		EditingSupport[] editingSupport = new EditingSupport[] { null, null,
				null, null, null, null,
				new CapacityEditingSupport(resourcesTableViewer), null };

		buildTableColumns(properties, columnWidths, editingSupport);
	}

	
}

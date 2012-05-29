package com.netxforge.netxstudio.screens.f2;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.EditingSupport;
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

	public void buildColumns() {
		
		String[] properties = new String[] { "Network Element Type",
				"Component", "Metric", "Short Name", "Expression Name",
				"Long Name", "Unit" };

		int[] columnWidths = new int[] { 130, 100, 112, 76, 104, 200, 68 };

		EditingSupport[] editingSupport = new EditingSupport[] { null, null,
				null, null, null, null, null };

		buildTableColumns(properties, columnWidths, editingSupport);
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.AbstractScreenImpl#getScreenName()
	 */
	@Override
	public String getScreenName() {
		return "Library Resources";
	}
	
	
	
	
}

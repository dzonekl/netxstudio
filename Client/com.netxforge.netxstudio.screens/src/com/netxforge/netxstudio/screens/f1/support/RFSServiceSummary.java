package com.netxforge.netxstudio.screens.f1.support;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceMonitor;

public class RFSServiceSummary {

	// Generated values.
	int subServices = 0;
	int nodes = 0;
	String lastMonitorFormattedString = "";
	int[] rag = new int[]{0,0,0};

	public int getRedStatus() {
		return rag[0];
	}

	public int getGreenStatus() {
		return rag[2];
	}

	public int getAmberStatus() {
		return rag[1];
	}

	public int getNodes() {
		return nodes;
	}

	public String getSubServices() {
		return new Integer(subServices).toString();
	}

	public String getLastMonitorFormattedString() {
		return lastMonitorFormattedString;
	}

	@SuppressWarnings("unused")
	private ModelUtils modelUtils;

	public RFSServiceSummary(ModelUtils modelUtils, RFSService service) {
		this.modelUtils = modelUtils;
		ServiceMonitor sm = modelUtils.lastServiceMonitor(service);
		if (sm != null) {
			this.lastMonitorFormattedString = modelUtils
					.formatLastMonitorDate(sm);
			rag = modelUtils.ragStatus(sm);
		}
		TreeIterator<EObject> iterator = service.eAllContents();
//		nodes += service.getNodes().size();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Service) {
				subServices += 1;
				nodes += service.getNodes().size();
			}
		}
	}
}
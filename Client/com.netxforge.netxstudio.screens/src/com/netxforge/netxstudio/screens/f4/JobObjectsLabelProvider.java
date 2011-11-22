package com.netxforge.netxstudio.screens.f4;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.services.RFSService;

public class JobObjectsLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof MetricSource) {
			if (columnIndex == 0) {
				return "Metric Source";
			} else if (columnIndex == 1) {
				return ((MetricSource) element).getName();
			}
		} else if (element instanceof Node) {
			if (columnIndex == 0) {
				return "Network Element";
			} else if (columnIndex == 1) {
				return ((Node) element).getNodeID();
			}
		} else if (element instanceof NodeType) {
			if (columnIndex == 0) {
				return "NE type";
			} else if (columnIndex == 1) {
				return ((NodeType) element).getName();
			}
		} else if (element instanceof RFSService) {
			if (columnIndex == 0) {
				return "Service";
			} else if (columnIndex == 1) {
				return ((RFSService) element).getServiceName();
			}
		} else if (element instanceof Operator) {
			if (columnIndex == 0) {
				return "Operator";
			} else if (columnIndex == 1) {
				return ((Operator) element).getName();
			}
		}
		return null;
	}

}

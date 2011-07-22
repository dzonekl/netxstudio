package com.netxforge.netxstudio.screens.f2.parts;

import java.util.List;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Panel;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.f2.model.WrappedNodeType;

public class LibraryEditPart extends AbstractLibraryEditPart {

	public LibraryEditPart(WrappedNodeType resource) {
		this.setModel(resource);
	}
	
	@Override
	protected IFigure createFigure() {
		IFigure canvas = new Panel();
		FlowLayout fl = new FlowLayout(false);
		fl.setMajorAlignment(FlowLayout.ALIGN_CENTER);
		fl.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		canvas.setLayoutManager(fl);
		return canvas;
	}

	public WrappedNodeType getWrappedNodeType() {
		return (WrappedNodeType) this.getModel();
	}

	@Override
	protected void createEditPolicies() {

	}

	@Override
	protected List<Object> getModelChildren() {
		List<Object> result = Lists.newArrayList();
		WrappedNodeType wnt = (WrappedNodeType) this.getModel();
		NodeType nt = wnt.getNodeType();
		result.add(nt);
		if (nt.getFunctions().size() > 0) {
			result.addAll(nt.getFunctions());
		}
		if (nt.getEquipments().size() > 0) {
			result.addAll(nt.getEquipments());
		}
		return result;
	}

}

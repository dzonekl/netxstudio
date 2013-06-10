package com.netxforge.netxstudio.screens.f2;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.IDataScreenInjection;
import com.netxforge.netxstudio.screens.f2.model.WrappedNodeType;
import com.netxforge.netxstudio.screens.f2.parts.NodeTypeEditPartsFactory;

public class NodeTypeHierarchy extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Form frmNodeTypeHierarchy;

	private ScrollingGraphicalViewer graphicalViewer;
	private NodeType nodeType;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NodeTypeHierarchy(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmNodeTypeHierarchy = toolkit.createForm(this);
//		frmNodeTypeHierarchy.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNodeTypeHierarchy);
		frmNodeTypeHierarchy.setText( nodeType.getName() + " structure");
		FillLayout fl = new FillLayout(SWT.HORIZONTAL);
		fl.marginHeight = 20;
		
		frmNodeTypeHierarchy.getBody().setLayout(fl);

		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		graphicalViewer = new ScrollingGraphicalViewer();
		graphicalViewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, true);
		graphicalViewer.createControl(frmNodeTypeHierarchy.getBody());
		graphicalViewer.getControl().setBackground(
				ColorConstants.listBackground);
		graphicalViewer.setRootEditPart(rootEditPart);
		graphicalViewer.setEditPartFactory(new NodeTypeEditPartsFactory());
		
		rootEditPart.refresh();

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		graphicalViewer.setContents(new WrappedNodeType(nodeType));
		return bindingContext;
	}

	public void injectData(Object owner, Object object) {

		if (object != null
				&& object instanceof NodeType) {
			nodeType = (NodeType)object;
		}

		buildUI();
		initDataBindings_();
	}

	public void disposeData() {
		// N/A
	}

	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmNodeTypeHierarchy;
	}

	public void addData() {
		// N/A
	}

	@Override
	public String getScreenName() {
		return "Network Element Type Structure";
	}
	
}

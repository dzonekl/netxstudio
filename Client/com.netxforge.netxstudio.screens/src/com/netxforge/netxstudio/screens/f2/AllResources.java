package com.netxforge.netxstudio.screens.f2;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.nattable.NatTable;
import net.sourceforge.nattable.data.IDataProvider;
import net.sourceforge.nattable.data.ListDataProvider;
import net.sourceforge.nattable.data.ReflectiveColumnPropertyAccessor;
import net.sourceforge.nattable.grid.data.DefaultColumnHeaderDataProvider;
import net.sourceforge.nattable.grid.data.DefaultCornerDataProvider;
import net.sourceforge.nattable.grid.data.DefaultRowHeaderDataProvider;
import net.sourceforge.nattable.grid.layer.ColumnHeaderLayer;
import net.sourceforge.nattable.grid.layer.CornerLayer;
import net.sourceforge.nattable.grid.layer.GridLayer;
import net.sourceforge.nattable.grid.layer.RowHeaderLayer;
import net.sourceforge.nattable.hideshow.ColumnHideShowLayer;
import net.sourceforge.nattable.layer.AbstractLayerTransform;
import net.sourceforge.nattable.layer.DataLayer;
import net.sourceforge.nattable.reorder.ColumnReorderLayer;
import net.sourceforge.nattable.selection.SelectionLayer;
import net.sourceforge.nattable.viewport.ViewportLayer;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;

/**
 * Advanced table using nattable.
 * 
 * 
 * @author dzonekl
 * 
 */
public class AllResources extends AbstractScreen implements IScreen,
		IDataServiceInjection {
	
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private net.sourceforge.nattable.data.IDataProvider bodyDataProvider;
	private String[] propertyNames;
	private BodyLayerStack bodyLayer;
	private Map<String, String> propertyToLabels;
	
	private NatTable natTable;
	
	private List<NetXResource> netXResources;

	private Form frmResources;

	public AllResources(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));
		frmResources = toolkit.createForm(this);
		frmResources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmResources);
		frmResources.setText("Resources");
		frmResources.getBody().setLayout(new GridLayout(3, false));

		buildLayers();

	}

	private void buildLayers() {

		DefaultColumnHeaderDataProvider colHeaderDataProvider = new DefaultColumnHeaderDataProvider(
				propertyNames, propertyToLabels);

		DefaultRowHeaderDataProvider rowHeaderDataProvider = new DefaultRowHeaderDataProvider(
				bodyDataProvider);

		bodyLayer = new BodyLayerStack(bodyDataProvider);
		ColumnHeaderLayerStack columnHeaderLayer = new ColumnHeaderLayerStack(
				colHeaderDataProvider);
		RowHeaderLayerStack rowHeaderLayer = new RowHeaderLayerStack(
				rowHeaderDataProvider);
		DefaultCornerDataProvider cornerDataProvider = new DefaultCornerDataProvider(
				colHeaderDataProvider, rowHeaderDataProvider);
		CornerLayer cornerLayer = new CornerLayer(new DataLayer(
				cornerDataProvider), rowHeaderLayer, columnHeaderLayer);

		GridLayer gridLayer = new GridLayer(bodyLayer, columnHeaderLayer,
				rowHeaderLayer, cornerLayer);
		natTable = new NatTable(frmResources.getBody(), gridLayer);
		natTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

	}

	public EMFDataBindingContext initDataBindings_() {

		propertyToLabels = new HashMap<String, String>();
		propertyToLabels.put("shortName", "Name");

		propertyNames = new String[] { "shortName" };
		bodyDataProvider = new ListDataProvider<NetXResource>(netXResources,
				new ReflectiveColumnPropertyAccessor<NetXResource>(
						propertyNames));
		return null;
	}

	@Override
	public Viewer getViewer() {
		// No viewer???
		return null;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Form getScreenForm() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public void injectData() {

		netXResources = Lists.newArrayList();
		List<Resource> resourcesList = Lists.newArrayList();

		// Inject for Node type resources.
		List<Resource> nodeTypeResources = editingService.getData("NodeType_");
		if (nodeTypeResources != null) {
			resourcesList.addAll(nodeTypeResources);
		}

		for (Resource res : nodeTypeResources) {
			netXResources.addAll((Collection<? extends NetXResource>) res
					.getContents());
		}

		this.initDataBindings_();
		this.buildUI();
		
		
	}

	public void disposeData() {
	}

	public class BodyLayerStack extends AbstractLayerTransform {

		private SelectionLayer selectionLayer;

		public BodyLayerStack(IDataProvider dataProvider) {
			DataLayer bodyDataLayer = new DataLayer(dataProvider);
			ColumnReorderLayer columnReorderLayer = new ColumnReorderLayer(
					bodyDataLayer);
			ColumnHideShowLayer columnHideShowLayer = new ColumnHideShowLayer(
					columnReorderLayer);
			selectionLayer = new SelectionLayer(columnHideShowLayer);
			ViewportLayer viewportLayer = new ViewportLayer(selectionLayer);
			setUnderlyingLayer(viewportLayer);
		}

		public SelectionLayer getSelectionLayer() {
			return selectionLayer;
		}
	}

	public class ColumnHeaderLayerStack extends AbstractLayerTransform {

		public ColumnHeaderLayerStack(IDataProvider dataProvider) {
			DataLayer dataLayer = new DataLayer(dataProvider);
			ColumnHeaderLayer colHeaderLayer = new ColumnHeaderLayer(dataLayer,
					bodyLayer, bodyLayer.getSelectionLayer());
			setUnderlyingLayer(colHeaderLayer);
		}
	}

	public class RowHeaderLayerStack extends AbstractLayerTransform {

		public RowHeaderLayerStack(IDataProvider dataProvider) {
			DataLayer dataLayer = new DataLayer(dataProvider, 50, 20);
			RowHeaderLayer rowHeaderLayer = new RowHeaderLayer(dataLayer,
					bodyLayer, bodyLayer.getSelectionLayer());
			setUnderlyingLayer(rowHeaderLayer);
		}
	}

}

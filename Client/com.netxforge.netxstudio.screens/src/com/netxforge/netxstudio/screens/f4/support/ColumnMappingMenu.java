package com.netxforge.netxstudio.screens.f4.support;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;

import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f4.AbstractMapping;
import com.netxforge.netxstudio.screens.f4.NewEditMappingColumn;

public class ColumnMappingMenu {

	private static final ColumnMappingMenu INSTANCE = new ColumnMappingMenu();

	public static ColumnMappingMenu getINSTANCE() {
		return INSTANCE;
	}

	public class MappingMenuListener implements MenuListener {

		private static final int IDENTIFIER_VALUE = 100;

		/* The current row index */
		private int currentRowIndex = -1;

		/* The current colomn index */
		private int currentColumnIndex = -1;

		public void setCurrentRowIndex(int currentRowIndex) {
			this.currentRowIndex = currentRowIndex;
		}

		public void setCurrentColumnIndex(int currentColumnIndex) {
			this.currentColumnIndex = currentColumnIndex;
		}

		private Menu gridMenu;
		private Mapping mapping;

		private IScreenFormService screenService;

		private Text txtFirstHeaderRow;
		private Text txtFirstDataRow;

		private MetricSource metricSource;

		public MappingMenuListener(Menu gridMenu, Mapping mapping,
				IScreenFormService screenService, Text txtFirstHeaderRow,
				Text txtFirstDataRow) {
			super();
			this.gridMenu = gridMenu;
			this.mapping = mapping;
			this.screenService = screenService;
			this.txtFirstHeaderRow = txtFirstHeaderRow;
			this.txtFirstDataRow = txtFirstDataRow;
		}

		public void setMetricSource(MetricSource metricSource) {
			this.metricSource = metricSource;
		}

		public void menuHidden(MenuEvent e) {
			System.out.println(e);
		}

		public void menuShown(MenuEvent e) {
			System.out.println(e);
			// Can we still build the menu here before it shows.
			// Clear the entries.
			MenuItem[] mis = gridMenu.getItems();
			for (int i = 0; i < mis.length; i++) {
				mis[i].dispose();
			}

			if (currentRowIndex != -1) {

				// Row Mappings
				if (txtFirstHeaderRow != null) {
					MenuItem mi = new MenuItem(gridMenu, SWT.PUSH);
					mi.setText("Set Header row index (" + currentRowIndex + ")");
					mi.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							txtFirstHeaderRow.setText(new Integer(
									currentRowIndex).toString());
						}
					});
				}

				// Header Column Mappings.
				MenuItem colHeaderMenuItem = new MenuItem(gridMenu, SWT.CASCADE);
				colHeaderMenuItem.setText("Header Column Mapping index=("
						+ currentColumnIndex + ")");
				{
					Menu colMenu = new Menu(colHeaderMenuItem);
					newHeaderMenus(colMenu);
					colHeaderMenuItem.setMenu(colMenu);
				}

				if (txtFirstDataRow != null) {
					MenuItem mi = new MenuItem(gridMenu, SWT.PUSH);
					mi.setText("Set Data row index (" + currentRowIndex + ")");
					mi.addSelectionListener(new SelectionAdapter() {

						@Override
						public void widgetSelected(SelectionEvent e) {
							txtFirstDataRow
									.setText(new Integer(currentRowIndex)
											.toString());
						}
					});
				}

				// Data Column Mappings.
				MenuItem colDataMenuItem = new MenuItem(gridMenu, SWT.CASCADE);
				colDataMenuItem.setText("Data Column Mapping index=("
						+ currentColumnIndex + ")");
				{
					Menu colMenu = new Menu(colDataMenuItem);
					newDataMenus(colMenu);
					colDataMenuItem.setMenu(colMenu);
				}

			}
		}

		private void newHeaderMenus(Menu colMenu) {
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Date mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newHeaderColumnMapping(currentColumnIndex,
								ValueKindType.DATE_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Date Time mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newHeaderColumnMapping(currentColumnIndex,
								ValueKindType.DATETIME_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Time mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newHeaderColumnMapping(currentColumnIndex,
								ValueKindType.TIME_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Identifier mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newHeaderColumnMapping(currentColumnIndex,
								IDENTIFIER_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Interval mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newHeaderColumnMapping(currentColumnIndex,
								ValueKindType.INTERVAL_VALUE);
					}
				});
			}
		}

		private void newDataMenus(Menu colMenu) {
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Date mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newDataColumnMapping(currentColumnIndex,
								ValueKindType.DATE_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Date Time mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newDataColumnMapping(currentColumnIndex,
								ValueKindType.DATETIME_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Time mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newDataColumnMapping(currentColumnIndex,
								ValueKindType.TIME_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Identifier mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newDataColumnMapping(currentColumnIndex,
								IDENTIFIER_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Interval mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newDataColumnMapping(currentColumnIndex,
								ValueKindType.INTERVAL_VALUE);
					}
				});
			}
			{
				MenuItem mi = new MenuItem(colMenu, SWT.PUSH);
				mi.setText("New Metric mapping");
				mi.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						newDataColumnMapping(currentColumnIndex,
								ValueKindType.METRIC_VALUE);
					}
				});
			}
		}

		private void newHeaderColumnMapping(int col, int kind) {

			MappingColumn mc = MetricsFactory.eINSTANCE.createMappingColumn();
			mc.setColumn(col);

			switch (kind) {
			case ValueKindType.DATE_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.DATE);
				mc.setDataType(vdk);
			}
				break;
			case ValueKindType.DATETIME_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.DATETIME);
				mc.setDataType(vdk);
			}
				break;
			case ValueKindType.TIME_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.TIME);
				mc.setDataType(vdk);
			}
				break;
			case ValueKindType.INTERVAL_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.INTERVAL);
				mc.setDataType(vdk);
			}
				break;
			case IDENTIFIER_VALUE: {
				IdentifierDataKind idk = MetricsFactory.eINSTANCE
						.createIdentifierDataKind();
				// Set the default identifier.
				idk.setObjectKind(ObjectKindType.NODE);
				idk.setObjectProperty(IdentifierDialog.NODE_ID);
				mc.setDataType(idk);
			}
				break;
			}

			IScreen activeScreen = screenService.getActiveScreen();
			if (activeScreen instanceof AbstractMapping) {
				((AbstractMapping) activeScreen).newColumnMappingScreenDialog(false, ScreenUtil.OPERATION_NEW,
				 mapping.getHeaderMappingColumns(), mc);
			}
			
//			newColumnMappingScreen(false,
//					Screens.OPERATION_NEW,
//					mapping.getHeaderMappingColumns(), mc);
			

		}

		private void newDataColumnMapping(int col, int kind) {

			MappingColumn mc = MetricsFactory.eINSTANCE.createMappingColumn();
			mc.setColumn(col);

			switch (kind) {
			case ValueKindType.DATE_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.DATE);
				mc.setDataType(vdk);
			}
				break;
			case ValueKindType.DATETIME_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.DATETIME);
				mc.setDataType(vdk);
			}
				break;
			case ValueKindType.TIME_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.TIME);
				mc.setDataType(vdk);
			}
				break;
			case ValueKindType.INTERVAL_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.INTERVAL);
				mc.setDataType(vdk);
			}
				break;
			case IDENTIFIER_VALUE: {
				IdentifierDataKind idk = MetricsFactory.eINSTANCE
						.createIdentifierDataKind();
				// Set the default identifier.
				idk.setObjectKind(ObjectKindType.NODE);
				idk.setObjectProperty(IdentifierDialog.NODE_ID);
				mc.setDataType(idk);
			}
				break;
			case ValueKindType.METRIC_VALUE: {
				ValueDataKind vdk = MetricsFactory.eINSTANCE
						.createValueDataKind();
				vdk.setValueKind(ValueKindType.METRIC);
				mc.setDataType(vdk);

			}
				break;
			}

			// newColumnMappingScreen(true, Screens.OPERATION_NEW,
			// mapping.getDataMappingColumns(), mc);

			IScreen activeScreen = screenService.getActiveScreen();
			if (activeScreen instanceof AbstractMapping) {
				((AbstractMapping) activeScreen).newColumnMappingScreenDialog(true, ScreenUtil.OPERATION_NEW,
				 mapping.getDataMappingColumns(), mc);
			}
		}

		@SuppressWarnings("unused")
		private void newColumnMappingScreen(boolean showDataMapping, int op,
				Object owner, Object target) {
			NewEditMappingColumn mappingColumnScreen = new NewEditMappingColumn(
					screenService.getScreenContainer(), SWT.NONE);
			mappingColumnScreen.setOperation(op);
			mappingColumnScreen.setScreenService(screenService);
			mappingColumnScreen.injectData(metricSource, showDataMapping,
					owner, target);
			screenService.setActiveScreen(mappingColumnScreen);
		}
	}

}

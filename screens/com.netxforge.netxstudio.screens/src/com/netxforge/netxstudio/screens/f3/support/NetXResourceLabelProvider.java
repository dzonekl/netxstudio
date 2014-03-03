package com.netxforge.netxstudio.screens.f3.support;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.netxforge.base.cdo.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateCallBack;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;

/**
 * Label provider for {@link NetXResource} object. Additionally enriched with
 * the current context aggregate.
 * 
 * @author Christophe Bouhier
 * 
 */
public class NetXResourceLabelProvider extends CellLabelProvider
		implements ITableLabelProvider {

	class LabelProviderCallBack implements MonitoringStateCallBack {

		private EObject target;

		public LabelProviderCallBack(EObject target) {
			this.target = target;
		}

		public void callBackEvent(MonitoringStateEvent event) {
			Object result = event.getResult();
			if (result instanceof IMonitoringSummary) {

				// We can't process the result, so fire a change for this
				// object, which should
				// force the viewer to query the alreayd installed and
				// computed adapter.

				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						fireLabelProviderChanged(new LabelProviderChangedEvent(
								NetXResourceLabelProvider.this,
								target));

					}
				});

			}
		}
	};

	public NetXResourceLabelProvider(IObservableMap[] attributeMaps) {
		// Should we not add something here...?

	}

	@Override
	public void update(ViewerCell cell) {

		final Object element = cell.getElement();
		final int columnIndex = cell.getColumnIndex();

		if (columnIndex == 5 && element instanceof NetXResource) {

		} else {

			// delegate to an ITableProvider, so this lp can be used in a
			// sorter.
			String result = this.getColumnText(element, columnIndex);
			if (result != null) {
				cell.setText(result);
			}
		}
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public String getColumnText(Object element, int columnIndex) {
		String result = null;
		if (element instanceof NetXResource) {

			final NetXResource resource = (NetXResource) element;
			Component c = null;
			if (resource
					.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__COMPONENT_REF)) {

				c = resource.getComponentRef();

			}
			switch (columnIndex) {
			case 0: {
				if (c != null) {
					if (c instanceof Function) {
						result = c.getName();
					}
					if (c instanceof Equipment) {
						Equipment eq = (Equipment) c;
						StringBuffer buf = new StringBuffer();
						buf.append(eq.getEquipmentCode() != null ? eq
								.getEquipmentCode() : "?");
						if (eq.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)) {
							buf.append(" : " + eq.getName());
						}
						result = buf.toString();
					}
				} else {
					result = "not connected";
				}
			}
				break;
			case 1:
				if (resource.getLongName() != null) {
					result = resource.getLongName();
				}
				break;

			case 2:
				if (resource
						.eIsSet(LibraryPackage.Literals.NET_XRESOURCE__METRIC_REF)) {
					result = resource.getMetricRef().getName();
				}
				break;
			case 3:
				if (resource
						.eIsSet(LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME)) {
					result = resource.getExpressionName();
				}
				break;
			// case 5:
			// Value v = modelUtils.mostRecentCapacityValue(resource);
			// if (v != null) {
			// DecimalFormat numberFormatter = new DecimalFormat(
			// "###,###,##0.00");
			// numberFormatter.setDecimalSeparatorAlwaysShown(true);
			// return numberFormatter.format(v.getValue());
			// } else {
			// return "<not set>";
			// }
			case 4:
				if (resource.getUnitRef() != null) {
					result = resource.getUnitRef().getCode();
				}
				break;
			case 5: {

				// CB Skip for now, to many objects. Use selection...

				// if (!MonitoringStateModel.isAdapted(resource)) {
				// monitoringStateModel.summary(new LabelProviderCallBack(
				// resource), resource,
				// new Object[] { aggregate.getCurrentService(),
				// aggregate.getCurrentPeriod() });
				// } else {
				// IMonitoringSummary summaryForContext =
				// MonitoringStateModel
				// .getAdapted(resource);
				// if (summaryForContext.isComputed()
				// && summaryForContext instanceof NetxresourceSummary) {
				// final List<Marker> markersForResource =
				// ((NetxresourceSummary) summaryForContext)
				// .markers();
				// if (markersForResource != null
				// && !markersForResource.isEmpty()) {
				// result = new Integer(markersForResource.size())
				// .toString();
				// }
				// }
				// }
			}
			}
		}
		return result;
	}
}
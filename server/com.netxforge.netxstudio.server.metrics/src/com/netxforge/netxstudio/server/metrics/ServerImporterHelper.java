/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server.metrics;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.BundleActivator;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.importer.AbstractMetricValuesImporter;
import com.netxforge.netxstudio.data.importer.IComponentLocator;
import com.netxforge.netxstudio.data.importer.IImporterHelper;
import com.netxforge.netxstudio.data.importer.ResultProcessor;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.JobHandler;
import com.netxforge.netxstudio.server.metrics.internal.MetricsActivator;

/**
 * A Helper which wraps the client or server side specific settings.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class ServerImporterHelper implements IImporterHelper {

	/* We need the importer to set the data provider */
	private AbstractMetricValuesImporter importer;

	@Inject
	private ResultProcessor resultProcessor;

	/*
	 * Keep a reference to our Job Handler.
	 */
	private JobHandler jobHandler;

	public ServerImporterHelper() {
	}

	public void setImporter(AbstractMetricValuesImporter importer) {
		this.importer = importer;
	}

	@Inject
	private ModelUtils modelUtils;

	private BundleActivator activator;

	public void initializeProviders(IComponentLocator networkElementLocator) {

		// NOT VALID: force that the same dataprovider is used
		// so that components retrieved by the networkElementLocator
		// participate in the same transaction

		// Use an own instance, as we are a singleton.
		networkElementLocator.setDataProvider(getDataProvider());
		networkElementLocator.initialize();
	}

	public IDataProvider getDataProvider() {
		// get it from the serverside
		final IDataProvider dataProvider = MetricsActivator.getInstance()
				.getInjector().getInstance(LocalDataProviderProvider.class)
				.getDataProvider();
		// Set in the importer so we are called only once.
		// importer.setDataProvider(dataProvider);
		return dataProvider;
	}

	public static class LocalDataProviderProvider {

		@Inject
		@Server
		private IDataProvider dataProvider;

		public IDataProvider getDataProvider() {
			return dataProvider;
		}
	}

	public void addToValueRange(NetXResource foundNetXResource, int periodHint,
			KindHintType kindHintType, List<Value> newValues, Date start,
			Date end) {
		resultProcessor.addToValueRange(foundNetXResource, periodHint,
				kindHintType, newValues, start, end);
	}

	public int addMetricValue(ValueDataKind valueDataKind, Date timeStamp,
			Component locatedComponent, Double dblValue, int intervalHint) {

		Metric metric = valueDataKind.getMetricRef();
		int createdNetXResource = 0; 
				
		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_IMPORT_HELPER_OPTION,
					"-- adding to: "
							+ modelUtils.printModelObject(locatedComponent)
							+ " with metric: "
							+ modelUtils.printModelObject(metric));
		}

		final Resource cdoResourceForNetXResource = modelUtils
				.cdoResourceForNetXResource(locatedComponent, importer
						.getDataProvider().getTransaction());
		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_IMPORT_HELPER_OPTION,
					"-- located CDO resource: "
							+ ((CDOResource) cdoResourceForNetXResource)
									.getPath());
		}

		final EList<EObject> netxResourcesList = cdoResourceForNetXResource
				.getContents();

		NetXResource foundNetXResource = null;
		for (final Object object : netxResourcesList) {
			final NetXResource netXResource = (NetXResource) object;

			// Match the resource on component, metric and also the name as
			// per
			// last identifier value.
			// Note, manually created resources, do not necessarly have a
			// metric
			// reference:
			// see http://work.netxforge.com/issues/264
			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_HELPER_OPTION,
						"-- checking resource: "
								+ netXResource.getShortName()
								+ " ID: "
								+ netXResource.cdoID()
								+ " metric ref: "
								+ modelUtils.printModelObject(netXResource
										.getMetricRef())
								+ " comp ref: "
								+ modelUtils.printModelObject(netXResource
										.getComponentRef()));
			}

			if (netXResource.getComponentRef() != null
					&& netXResource.getComponentRef().cdoID()
							.equals(locatedComponent.cdoID())
					&& netXResource.getMetricRef() != null
					&& netXResource.getMetricRef().cdoID()
							.equals(metric.cdoID())) {

				foundNetXResource = netXResource;

				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_IMPORT_HELPER_OPTION,
							"-- matching resource: "
									+ foundNetXResource.getShortName()
									+ " , for component: "
									+ locatedComponent.getName()
									+ ", on metric: " + metric.getName());
				}
				break;
			}
		}
		if (foundNetXResource == null) {

			if (DataActivator.DEBUG) {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_IMPORT_HELPER_OPTION,
						"-- No Matching resource for: "
								+ locatedComponent.getName() + ", on metric: "
								+ metric.getName() + " creating resource:");
			}
			foundNetXResource = LibraryFactory.eINSTANCE.createNetXResource();
			foundNetXResource.setComponentRef(locatedComponent);
			foundNetXResource.setMetricRef(metric);

			foundNetXResource.setShortName(metric.getName());
			if (metric.eIsSet(MetricsPackage.Literals.METRIC__DESCRIPTION)) {
				foundNetXResource.setLongName(metric.getDescription());
			} else {
				foundNetXResource.setLongName(metric.getName());
			}

			foundNetXResource.setExpressionName(importer
					.toValidExpressionName(metric.getName()));

			// }

			foundNetXResource.setUnitRef(metric.getUnitRef());
			locatedComponent.getResourceRefs().add(foundNetXResource);
			cdoResourceForNetXResource.getContents().add(foundNetXResource);
			
			createdNetXResource +=1;

		}

		final Value value = GenericsFactory.eINSTANCE.createValue();
		value.setTimeStamp(modelUtils.toXMLDate(timeStamp));
		value.setValue(dblValue);

		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(
					DataActivator.TRACE_IMPORT_HELPER_OPTION,
					"-- try to add value to resource : "
							+ foundNetXResource.getShortName() + " , value ="
							+ value.getValue() + " timestamp="
							+ modelUtils.dateAndTime(value.getTimeStamp())
							+ ", kind=" + valueDataKind.getKindHint().getName()
							+ " , interval =" + intervalHint);
		}

		addToValueRange(foundNetXResource, intervalHint,
				valueDataKind.getKindHint(), Collections.singletonList(value),
				null, null);
		if (DataActivator.DEBUG) {
			DataActivator.TRACE.trace(DataActivator.TRACE_IMPORT_HELPER_OPTION,
					"-- value added ");
		}
		return createdNetXResource;
	}

	public boolean cancelled() {
		Scheduler scheduler = jobHandler.getScheduler();
		try {
			if (scheduler.isInStandbyMode()) {
				return true;
			}
		} catch (SchedulerException e) {
			return false;
		}
		return false;
	}

	public JobHandler getJobHandler() {
		return jobHandler;
	}

	public void setJobHandler(JobHandler jobHandler) {
		this.jobHandler = jobHandler;
	}

	public BundleActivator getActivator() {
		return activator;
	}

	public void setActivator(BundleActivator a) {
		this.activator = a;

	}
}

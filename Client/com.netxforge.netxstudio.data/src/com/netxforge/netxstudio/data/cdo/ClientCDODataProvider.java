/*******************************************************************************
 * Copyright (c) May 3, 2011 NetXForge.
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
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.cdo;

import java.io.IOException;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.net4j.util.transaction.TransactionException;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.NetxstudioFactory;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.generics.ExpansionDurationSetting;
import com.netxforge.netxstudio.generics.ExpansionDurationValue;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.RetentionJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

/**
 * A CDO Data provider, for single threaded clients. The session and transaction
 * are stored in a static member and this object is a singleton.
 * 
 * CB TODO If a singleton, why a static session, we will always return the same session?  
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@Singleton
public class ClientCDODataProvider extends CDODataProvider implements IFixtures {

	@Inject
	ModelUtils modelUtils;

	@Inject
	public ClientCDODataProvider(ICDOConnection conn) {
		super(conn);
	}

	private static CDOSession session = null;

	private static CDOTransaction transaction = null;
	
	private CDOView view = null;
	

	@Override
	public CDOSession getSession() {
		if (session == null || session.isClosed()) {
			// We can't get a session, which has not be opened and
			// authenticated.
			
			throw new java.lang.IllegalStateException(session.isClosed() ? "Session closed" : "Session not set");
		} else {
			this.printSession();
			return session;
		}
	}

	@Override
	public CDOTransaction getTransaction() {
		if (transaction == null) {
			transaction = getSession().openTransaction();
		}
		return transaction;
	}

	@Override
	protected boolean isTransactionSet() {
		return transaction != null;
	}

	@Override
	protected void setSession(CDOSession session) {
		ClientCDODataProvider.session = session;
	}

	@Override
	protected void setTransaction(CDOTransaction transaction) {
		ClientCDODataProvider.transaction = transaction;
	}

	public void printSession() {
		
		if(session.isClosed()){
			System.out.println("ClientCDODataProvider: Session closed!, can not provide views or transactions");
			return;
		}
		
		// Report the transactions on our session:
		CDOView[] views = session.getElements();
		for (int i = 0; i < views.length; i++) {
			CDOView v = views[i];
			if (v instanceof CDOTransaction) {
				CDOTransaction t = (CDOTransaction) v;
				System.out.println("ClientCDODataProvider: transaction ID: " + t.getViewID()
						+ " ResourceSet hashcode:"
						+ v.getResourceSet().hashCode());
			} else {
				System.out.println("ClientCDODataProvider: view ID: " + v.getViewID()
						+ " ResourceSet hashcode:"
						+ v.getResourceSet().hashCode());
			}
			for (Resource res : v.getResourceSet().getResources()) {
				if (res instanceof CDOResource) {
					System.out.println("  Resource for set = " + res.getURI());
				}
			}
		}
		if(views.length > 0 ){
			System.out.println("ClientCDODataProvider: Number of views/transactions:" + session.getElements().length);
		}
	}

	public void loadFixtures() {
		loadSettings();
		loadRoles();
		loadRetentionRules();
	}

	private void loadSettings() {

		CDOTransaction transaction = this.getTransaction();

		final CDOResource settingsResource = (CDOResource) getResource(
				transaction, NetxstudioPackage.Literals.SERVER_SETTINGS);
		try {

			if (settingsResource.getContents().size() > 0) {
				return;
			}
			ServerSettings serverSettings = NetxstudioFactory.eINSTANCE
					.createServerSettings();
			serverSettings
					.setExportPath("/Users/dzonekl/Documents/Projects/NetXStudio/Reports");
			serverSettings
					.setImportPath("/Users/dzonekl/Documents/Projects/NetXStudio/TestData");
			settingsResource.getContents().add(serverSettings);

			ExpansionDurationSetting eds = GenericsFactory.eINSTANCE
					.createExpansionDurationSetting();
			{
				ExpansionDurationValue edv = GenericsFactory.eINSTANCE
						.createExpansionDurationValue();
				edv.setExpansionDuration(ExpansionDuration.QUICK);
				edv.setValue(7);
				eds.setQuickDuration(edv);
			}
			{
				ExpansionDurationValue edv = GenericsFactory.eINSTANCE
						.createExpansionDurationValue();
				edv.setExpansionDuration(ExpansionDuration.SHORT);
				edv.setValue(30);
				eds.setShortDuration(edv);
			}
			{
				ExpansionDurationValue edv = GenericsFactory.eINSTANCE
						.createExpansionDurationValue();
				edv.setExpansionDuration(ExpansionDuration.MEDIUM);
				edv.setValue(90);
				eds.setMediumDuration(edv);
			}
			{
				ExpansionDurationValue edv = GenericsFactory.eINSTANCE
						.createExpansionDurationValue();
				edv.setExpansionDuration(ExpansionDuration.LONG);
				edv.setValue(180);
				eds.setLongDuration(edv);
			}

			serverSettings.setExpansionDurationSettings(eds);

			settingsResource.save(null);

		} catch (final TransactionException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			this.commitTransaction();
		}
	}

	private void loadRetentionRules() {

		CDOTransaction transaction = this.getTransaction();

		Resource retentionRulesResource = getResource(transaction,
				MetricsPackage.Literals.METRIC_RETENTION_RULES);
		Resource expressionResource = getResource(transaction,
				LibraryPackage.Literals.EXPRESSION);
		// add to the job resource, that one is watched by the jobhandler
		Resource retentionResource = getResource(transaction,
				SchedulingPackage.Literals.JOB);

		try {

			EList<EObject> contents = retentionRulesResource.getContents();

			Expression weeklyRetentionExpression;
			Expression dailyRetentionExpression;
			Expression hourlyRetentionExpression;

			if (contents.size() == 1) {
				return;
			} else {
				MetricRetentionRules rules = MetricsFactory.eINSTANCE
						.createMetricRetentionRules();
				contents.add(rules);
				{
					// Add all expressions.
					{
						// Monthly expression
						weeklyRetentionExpression = LibraryFactory.eINSTANCE
								.createExpression();
						weeklyRetentionExpression
								.setName("Weekly retention rule");

						// Gets the max value from a range and assigns it to
						// another
						// range, clears the original range.
						final String eAsString = "this METRIC "
								+ ModelUtils.MINUTES_IN_A_MONTH
								+ " = this METRIC "
								+ ModelUtils.MINUTES_IN_A_WEEK
								+ " .max();this METRIC "
								+ ModelUtils.MINUTES_IN_A_WEEK + " .clear();";
						weeklyRetentionExpression.getExpressionLines().addAll(
								modelUtils.expressionLines(eAsString));
						expressionResource.getContents().add(
								weeklyRetentionExpression);
					}
					{
						dailyRetentionExpression = LibraryFactory.eINSTANCE
								.createExpression();
						dailyRetentionExpression
								.setName("Daily retention rule");

						// Gets the max value from a range and assigns it to
						// another
						// range, clears the original range.
						final String eAsString = "this METRIC "
								+ ModelUtils.MINUTES_IN_A_WEEK
								+ " = this METRIC "
								+ ModelUtils.MINUTES_IN_A_DAY
								+ " .max();this METRIC "
								+ ModelUtils.MINUTES_IN_A_DAY + " .clear();";
						dailyRetentionExpression.getExpressionLines().addAll(
								modelUtils.expressionLines(eAsString));
						expressionResource.getContents().add(
								dailyRetentionExpression);
					}

					{
						hourlyRetentionExpression = LibraryFactory.eINSTANCE
								.createExpression();
						hourlyRetentionExpression
								.setName("Hourly retention rule");

						// Gets the max value from a range and assigns it to
						// another
						// range, clears the original range.
						final String eAsString = "this METRIC DAY = this METRIC HOUR .max();\nthis METRIC HOUR .clear();";
						hourlyRetentionExpression.getExpressionLines().addAll(
								modelUtils.expressionLines(eAsString));
						expressionResource.getContents().add(
								hourlyRetentionExpression);
					}
				}

				if (rules.getMetricRetentionRules().size() == 0) {
					{
						MetricRetentionRule r = MetricsFactory.eINSTANCE
								.createMetricRetentionRule();
						r.setName("Monthly values");
						r.setPeriod(MetricRetentionPeriod.ALWAYS);
						rules.getMetricRetentionRules().add(r);
					}
					{
						MetricRetentionRule r = MetricsFactory.eINSTANCE
								.createMetricRetentionRule();
						r.setName("Weekly values");
						r.setPeriod(MetricRetentionPeriod.ALWAYS);
						r.setRetentionExpression(weeklyRetentionExpression);
						rules.getMetricRetentionRules().add(r);
					}
					{
						MetricRetentionRule r = MetricsFactory.eINSTANCE
								.createMetricRetentionRule();
						r.setName("Daily values");
						r.setPeriod(MetricRetentionPeriod.ONE_MONTH);
						r.setRetentionExpression(dailyRetentionExpression);
						rules.getMetricRetentionRules().add(r);

					}
					{
						MetricRetentionRule r = MetricsFactory.eINSTANCE
								.createMetricRetentionRule();
						r.setName("Hourly values");
						r.setPeriod(MetricRetentionPeriod.ONE_WEEK);
						r.setRetentionExpression(hourlyRetentionExpression);
						rules.getMetricRetentionRules().add(r);
					}

					final RetentionJob retentionJob = SchedulingFactory.eINSTANCE
							.createRetentionJob();
					retentionJob.setJobState(JobState.IN_ACTIVE);
					retentionJob.setStartTime(modelUtils.toXMLDate(modelUtils
							.tomorrow()));
					retentionJob.setInterval(600);
					retentionJob.setName("Data Retention");
					retentionResource.getContents().add(retentionJob);
				}

			}
			expressionResource.save(null);
			retentionRulesResource.save(null);
			retentionResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			this.commitTransaction();
		}
	}

	private void loadRoles() {

		CDOTransaction transaction = this.getTransaction();

		final CDOResource rolesResource = (CDOResource) getResource(
				transaction, GenericsPackage.Literals.ROLE);
		final CDOResource userResource = (CDOResource) getResource(GenericsPackage.Literals.PERSON);

		try {

			if (rolesResource.getContents().size() > 0) {
				return;
			}

			// Add the fixture roles.
			{
				final Role r = GenericsFactory.eINSTANCE.createRole();
				r.setName(ROLE_ADMIN);
				rolesResource.getContents().add(r);

				// FIXME, the admin user is hard coded for now.
				{
					final Person p = GenericsFactory.eINSTANCE.createPerson();
					p.setLogin("admin");
					p.setFirstName("admin");
					p.setLastName("admin");
					// p.setPassword("admin");
					p.setActive(true);
					p.setRoles(r);
					userResource.getContents().add(p);
				}
			}
			{
				final Role r = GenericsFactory.eINSTANCE.createRole();
				r.setName(ROLE_PLANNER);
				rolesResource.getContents().add(r);
			}
			{
				final Role r = GenericsFactory.eINSTANCE.createRole();
				r.setName(ROLE_READONLY);
				rolesResource.getContents().add(r);
			}
		} catch (final TransactionException e) {
			e.printStackTrace();
		} finally {
			commitTransaction();
		}
	}

	@SuppressWarnings("unused")
	private void loadLibrary() {

		CDOTransaction transaction = this.getTransaction();

		final CDOResource res = (CDOResource) getResource(LibraryPackage.Literals.LIBRARY);

		try {

			Library lib = null;

			// Should do some basic import data validation.
			if (res.getContents() != null && (res.getContents().size() > 0)) {
				if (res.getContents().get(0) instanceof Library) {
					// Ok, proceed.
					lib = (Library) res.getContents().get(0);
				}
			} else {
				lib = LibraryFactory.eINSTANCE.createLibrary();
				res.getContents().add(lib);
			}

			final NodeType sgsnType = LibraryFactory.eINSTANCE.createNodeType();
			final Function sgsnFunction = LibraryFactory.eINSTANCE
					.createFunction();
			sgsnFunction.setName("SGSN");
			sgsnType.getFunctions().add(sgsnFunction);

			lib.getNodeTypes().add(sgsnType);

			final NetXResource sgsnRes = LibraryFactory.eINSTANCE
					.createNetXResource();
			final MetricValueRange range = MetricsFactory.eINSTANCE
					.createMetricValueRange();
			sgsnRes.getMetricValueRanges().add(range);

			sgsnFunction.getResourceRefs().add(sgsnRes);

			final Value v = GenericsFactory.eINSTANCE.createValue();
			v.setValue(2.0);
			v.setTimeStamp(modelUtils.toXMLDate(modelUtils.yesterday()));

			final Value v1 = GenericsFactory.eINSTANCE.createValue();
			v1.setValue(2.1);
			v1.setTimeStamp(modelUtils.toXMLDate(modelUtils.twoDaysAgo()));

			final Value v2 = GenericsFactory.eINSTANCE.createValue();
			v2.setValue(2.1);
			v2.setTimeStamp(modelUtils.toXMLDate(modelUtils.threeDaysAgo()));

			range.getMetricValues().addAll(ImmutableList.of(v, v1, v2));

			res.save(null);
		} catch (final TransactionException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			commitTransaction();
		}

	}

	@Override
	public CDOView getView() {
		if(view == null){
			view = this.getSession().openView();
		}
		return view;
	}

	public void closeView() {
		if(this.view != null){
			this.view.close();
			view = null;
		}
	}

}

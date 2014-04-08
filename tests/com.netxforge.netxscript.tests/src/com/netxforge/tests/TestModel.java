/*******************************************************************************
 * Copyright (c) 8 apr. 2014 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.tests;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.ImmutableList;
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;

public class TestModel {

	public static final TestModel INSTANCE = new TestModel();

	/**
	 * Warning, we erase on the live DB!!!
	 */
	public Node createModelData(ICDOData cdoData) {
		{
			// Add some objects, which are referable from our xtext model.
			final CDOResource res = (CDOResource) cdoData
					.getResource(LibraryPackage.Literals.LIBRARY);

			CDOTransaction cdoTransaction = null;
			if (res.cdoView() instanceof CDOTransaction) {
				cdoTransaction = (CDOTransaction) res.cdoView();
			} else {
				throw new IllegalStateException(
						"Should use a CDOTransaction to work with resource: "
								+ res.getURI());
			}

			res.getContents().clear(); // Clear the Library resource from it's
										// contents.

			Library lib;
			if (res.getContents().size() > 0) {
				lib = (Library) res.getContents().get(0);
			} else {
				lib = LibraryFactory.eINSTANCE.createLibrary();
				res.getContents().add(lib);
			}

			final NodeType sgsnNodeType = LibraryFactory.eINSTANCE
					.createNodeType();
			sgsnNodeType.setName("SGSN");
			final Function sgsnFunction = LibraryFactory.eINSTANCE
					.createFunction();
			sgsnFunction.setName("Function1");
			sgsnNodeType.getFunctions().add(sgsnFunction);

			Resource netxResResource = StudioUtils.cdoResourceGetOrCreate(
					sgsnFunction, cdoTransaction);

			lib.getNodeTypes().add(sgsnNodeType);

			{
				final NetXResource sgsnRes = LibraryFactory.eINSTANCE
						.createNetXResource();
				sgsnRes.setShortName("RES1");
				sgsnRes.setExpressionName("RES1");
				// Create various ranges for AVG, BH.

				{
					final MetricValueRange range = MetricsFactory.eINSTANCE
							.createMetricValueRange();

					range.setKindHint(KindHintType.AVG); // Average values.
					range.setIntervalHint(60); // A 60 minute range.
					sgsnRes.getMetricValueRanges().add(range); // Index 0.
					final Value v = GenericsFactory.eINSTANCE.createValue();
					v.setValue(10.0);
					v.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.yesterday()));

					final Value v1 = GenericsFactory.eINSTANCE.createValue();
					v1.setValue(10.1);
					v1.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.twoDaysAgo()));

					final Value v2 = GenericsFactory.eINSTANCE.createValue();
					v2.setValue(9.8);
					v2.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.threeDaysAgo()));

					final Value v3 = GenericsFactory.eINSTANCE.createValue();
					v3.setValue(10.2);
					v3.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.fourDaysAgo()));
					range.getMetricValues().addAll(
							ImmutableList.of(v, v1, v2, v3));
				}

				{

					final MetricValueRange range = MetricsFactory.eINSTANCE
							.createMetricValueRange();

					range.setKindHint(KindHintType.BH); // Average values.
					range.setIntervalHint(60 * 24); // A one day range.
					sgsnRes.getMetricValueRanges().add(range); // Index 0.
					final Value v = GenericsFactory.eINSTANCE.createValue();
					v.setValue(2.0);
					v.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.yesterday()));

					final Value v1 = GenericsFactory.eINSTANCE.createValue();
					v1.setValue(2.1);
					v1.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.twoDaysAgo()));

					final Value v2 = GenericsFactory.eINSTANCE.createValue();
					v2.setValue(2.2);
					v2.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.threeDaysAgo()));

					final Value v3 = GenericsFactory.eINSTANCE.createValue();
					v3.setValue(1.5);
					v3.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.fourDaysAgo()));
					range.getMetricValues().addAll(
							ImmutableList.of(v, v1, v2, v3));
				}

				{

					final Value c = GenericsFactory.eINSTANCE.createValue();
					c.setValue(5.0);
					c.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.yesterday()));

					// Create capacity values.
					final Value c1 = GenericsFactory.eINSTANCE.createValue();
					c1.setValue(5.0);
					c1.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.twoDaysAgo()));

					final Value c2 = GenericsFactory.eINSTANCE.createValue();
					c2.setValue(5.0);
					c2.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.threeDaysAgo()));

					final Value c3 = GenericsFactory.eINSTANCE.createValue();
					c3.setValue(5.0);
					c3.setTimeStamp(NonModelUtils.toXMLDate(NonModelUtils
							.fourDaysAgo()));

					sgsnRes.getCapacityValues().addAll(
							ImmutableList.of(c, c1, c2, c3));
				}

				sgsnFunction.getResourceRefs().add(sgsnRes);
				netxResResource.getContents().add(sgsnRes);

			}
			{
				final NetXResource sgsnRes = LibraryFactory.eINSTANCE
						.createNetXResource();
				sgsnRes.setShortName("RES2");
				sgsnRes.setExpressionName("RES2");
				sgsnFunction.getResourceRefs().add(sgsnRes);
				netxResResource.getContents().add(sgsnRes);
			}

			// Create some equipment:
			final Equipment board = LibraryFactory.eINSTANCE.createEquipment();
			// board.setName("BOARD");
			board.setEquipmentCode("BOARD");
			board.setName("board1");

			// Copy 10 equipments.
			for (int i = 0; i < 10; i++) {
				sgsnNodeType.getEquipments().add(EcoreUtil.copy(board));
			}

			// From the Nodetype, we create a node, copying the content.

			Node n = OperatorsFactory.eINSTANCE.createNode();
			n.setNodeID("YPSGSN01");
			NodeType copyofType = EcoreUtil.copy(sgsnNodeType);
			n.setNodeType(copyofType);

			cdoData.commitTransactionThenClose();

			return n;

		}
	}

}

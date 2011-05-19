/*******************************************************************************
 * Copyright (c) Apr 26, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.nextstudio.server.test.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.cdo.server.hibernate.IHibernateStore;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOQuery;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.StateType;
import com.netxforge.nextstudio.server.test.base.BaseAuthTest;

/**
 * Test different aspects of HQL querying using the CDO query api.
 * 
 * @author Martin Taal
 */
public class HibernateQueryTest extends BaseAuthTest
{

  public void testSimpleQuery() throws Exception
  {
    final CDOSession session = openSession();
    final CDOTransaction transaction = session.openTransaction();

    {
      final CDOQuery cdoQuery = transaction.createQuery("hql", "from Equipment");
      addCacheParameter(cdoQuery);
      final List<Equipment> equipments = cdoQuery.getResult(Equipment.class);
      for (final Equipment equipment : equipments) {
    	  System.err.println(equipment);
      }
    }

    {
      final CDOQuery cdoQuery = transaction.createQuery("hql", "from Equipment where state=:state");
      cdoQuery.setParameter("state", StateType.ACTIVE);
      addCacheParameter(cdoQuery);
      final List<Equipment> equipments = cdoQuery.getResult(Equipment.class);
      assertTrue(!equipments.isEmpty());
      for (final Equipment equipment : equipments) {
    	  assertEquals(equipment.getState(), StateType.ACTIVE);
      }
    }

    transaction.commit();
  }
  
  public void testFunctions() throws Exception
  {
    final CDOSession session = openSession();
    final CDOTransaction transaction = session.openTransaction();

    {
      final CDOQuery cdoQuery = transaction.createQuery("hql", "select count(*) from Equipment");
      addCacheParameter(cdoQuery);
      final List<Long> counts = cdoQuery.getResult(Long.class);
      assertEquals(counts.size(), 1);
      System.err.println(counts.get(0));
    }

    {
      // result with arrays are tested below
      // CDOQuery cdoQuery = transaction.createQuery("hql",
      // "select so.id, sum(od.price) from SalesOrder so, OrderDetail od where od.order=so group by so.id");
//      CDOQuery cdoQuery = transaction.createQuery("hql",
//          "select sum(od.price) from SalesOrder so, OrderDetail od where od.order=so group by so.id");
//      addCacheParameter(cdoQuery);
//      final List<Double> results = cdoQuery.getResult(Double.class);
//      assertEquals(NUM_OF_SALES_ORDERS * NUM_OF_CUSTOMERS, results.size());
    }

    transaction.commit();
  }

  public void testQueryObjectArray() throws Exception
  {
    final CDOSession session = openSession();
    final CDOTransaction transaction = session.openTransaction();

    {
      final CDOQuery query = transaction.createQuery("hql",
          "select eq, eq.state from Equipment as eq where eq.state=:state");
      query.setParameter("state", StateType.ACTIVE);
      addCacheParameter(query);
      for (final Object[] values : query.getResult(Object[].class))
      {
        assertTrue(values[0] instanceof Equipment);
        assertTrue(values[1] instanceof StateType);
      }
    }

    transaction.commit();
  }

  public void testPaging() throws Exception
  {
    final CDOSession session = openSession();
    final CDOTransaction transaction = session.openTransaction();

    {
      final int pageSize = 5;
      final int numOfPages = 5;
      final List<Equipment> allEquipments = new ArrayList<Equipment>();
      for (int page = 0; page < numOfPages; page++)
      {
        final CDOQuery equipmentQuery = transaction.createQuery("hql", "from Equipment");
        equipmentQuery.setMaxResults(pageSize);
        equipmentQuery.setParameter(IHibernateStore.FIRST_RESULT, page * pageSize);
        addCacheParameter(equipmentQuery);
        final List<Equipment> queriedEquipments = equipmentQuery.getResult(Equipment.class);
        assertEquals(true, queriedEquipments.size() <= pageSize);
        // a product should not have been read yet
        for (final Equipment newEquipment : queriedEquipments)
        {
          assertEquals(true, !allEquipments.contains(newEquipment));
        }

        allEquipments.addAll(queriedEquipments);
      }
    }

    transaction.commit();
  }

  protected void addCacheParameter(CDOQuery query)
  {
    query.setParameter(IHibernateStore.CACHE_RESULTS, true);
  }
}

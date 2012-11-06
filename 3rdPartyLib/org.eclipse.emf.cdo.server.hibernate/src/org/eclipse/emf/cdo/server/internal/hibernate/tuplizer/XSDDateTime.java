/**
 * Copyright (c) 2004 - 2011 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Martin Taal - initial api
 *    Eike Stepper - maintenance
 */
package org.eclipse.emf.cdo.server.internal.hibernate.tuplizer;

import org.eclipse.emf.cdo.server.internal.hibernate.HibernateUtil;

import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.type.MutableType;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

/**
 * Implements the hibernate UserType for EMF's XMLGregorianCalendar ("datetime" type in XSD).
 * 
 * @author <a href="mailto:bvetter@alterpoint.com">Brian Vetter</a>
 * @version $Revision
 */
@SuppressWarnings("deprecation")
public class XSDDateTime extends MutableType
{

  static final long serialVersionUID = 1;

  // local copy of the datatype facatory
  private final DatatypeFactory dataTypeFactory;

  public XSDDateTime()
  {
    try
    {
      dataTypeFactory = DatatypeFactory.newInstance();
    }
    catch (DatatypeConfigurationException e)
    {
      throw new IllegalStateException("Exception ", e);
    }
  }

  /*
   * Returns the DATETIME type that maps to the sql TIMESTAMP type
   * @see org.hibernate.type.NullableType#sqlType()
   */
  @Override
  public int sqlType()
  {
    return Types.TIMESTAMP;
  }

  /*
   * Copy the XMLGregorianCalendar object
   * @see org.hibernate.type.MutableType#deepCopyNotNull(java.lang.Object)
   */
  @Override
  public Object deepCopyNotNull(Object value)
  {
    return dataTypeFactory.newXMLGregorianCalendar(((XMLGregorianCalendar)value).toGregorianCalendar());
  }

  /*
   * returns a name for the user type
   * @see org.hibernate.type.Type#getName()
   */
  public String getName()
  {
    return "xmldatetime";
  }

  /*
   * This returns an XMLGregorianCalendar.class type
   * @see org.hibernate.type.Type#getReturnedClass()
   */
  public Class<?> getReturnedClass()
  {
    return XMLGregorianCalendar.class;
  }

  /*
   * @see org.hibernate.type.NullableType#isEqual(java.lang.Object, java.lang.Object)
   */
  @Override
  public boolean isEqual(Object x, Object y) throws HibernateException
  {
    if (x == y)
    {
      return true;
    }
    if (x == null || y == null)
    {
      return false;
    }
    if (x.getClass() != y.getClass())
    {
      return false;
    }
    return x.equals(y);
  }

  /*
   * @see org.hibernate.type.AbstractType#getHashCode(java.lang.Object, org.hibernate.EntityMode)
   */
  @Override
  public int getHashCode(Object x, EntityMode entityMode) throws HibernateException
  {
    return x.hashCode();
  }

  /*
   * Transform the date in the resultSet into a XMLGregorianCalendar instance.
   * @see org.hibernate.type.NullableType#get(java.sql.ResultSet, java.lang.String)
   */
  @Override
  public Object get(ResultSet resultSet, String name) throws SQLException
  {
    // MT: changed this to timestamp to get the seconds right
    Timestamp ts = resultSet.getTimestamp(name);
    if (ts == null)
    {
      return null;
    }
    return HibernateUtil.getInstance().getXMLGregorianCalendarDate(ts, true);
  }

  /*
   * Transform the XMLGregorianCalendar into a timestamp type to store in the database
   * @see org.hibernate.type.NullableType#set(java.sql.PreparedStatement, java.lang.Object, int)
   */
  @Override
  public void set(PreparedStatement statement, Object value, int index) throws SQLException
  {
    Timestamp d = new Timestamp(((XMLGregorianCalendar)value).toGregorianCalendar().getTime().getTime());
    statement.setTimestamp(index, d);
  }

  /*
   * @see org.hibernate.type.NullableType#toString(java.lang.Object)
   */
  @Override
  public String toString(Object val)
  {

    return ((XMLGregorianCalendar)val).toString();
  }

  /*
   * @see org.hibernate.type.NullableType#fromStringValue(java.lang.String)
   */
  @Override
  public Object fromStringValue(String s) throws HibernateException
  {
    return dataTypeFactory.newXMLGregorianCalendar(s);
  }
}

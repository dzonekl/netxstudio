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

import org.hibernate.usertype.UserType;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Provides a Hibernate extension (called a UserType) to support the xml Duration type. The duration is persisted as a
 * string.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 */
public class XSDDuration implements UserType
{

  private static final int[] SQL_TYPES = { Types.VARCHAR };

  private final DatatypeFactory factory;

  /**
   * Construct a new VARCHAR custom data type.
   */
  public XSDDuration()
  {
    try
    {
      factory = DatatypeFactory.newInstance();
    }
    catch (Exception e)
    {
      throw new IllegalStateException("Exception while creating datatypefactory ", e);
    }
  }

  /**
   * Return the types of the columns that this UserType will serialize into.
   * 
   * @return a single column of type VARCHAR.
   */
  public int[] sqlTypes()
  {
    return SQL_TYPES;
  }

  /**
   * Return the Java class of the object that is serialized for the column.
   * 
   * @return the Java instance class associated with the EMF DataType.
   */
  public Class<?> returnedClass()
  {
    return javax.xml.datatype.Duration.class;
  }

  /**
   * Is this datatype mutable?
   * 
   * @return Being conservative - false always.
   */
  public boolean isMutable()
  {
    return false;
  }

  /**
   * Provide a copy of the datatypes. Converts to String and then back to datatype again.
   * 
   * @param value
   *          the value to copy.
   * @return the value always.
   */
  public Object deepCopy(Object value)
  {
    if (value == null)
    {
      return null;
    }
    return factory.newDuration(((Duration)value).toString());
  }

  /**
   * Are the two objects equal?
   * 
   * @param x
   *          an object to compare.
   * @param y
   *          an object to compare.
   * @return a standard equals test between the objects.
   */
  public boolean equals(Object x, Object y)
  {
    if (x == y)
    {
      return true;
    }
    if (x == null || y == null)
    {
      return false;
    }
    return x.equals(y);
  }

  /**
   * Populate the model object property from the ResultSet.
   * 
   * @param resultSet
   *          the non-null ResultSet from which the field will be populated.
   * @param names
   *          the names of the columns.
   * @param owner
   *          the owning object.
   * @return null if the column's value is null; otherwise, use the EMF factory to construct a new instance of the
   *         custom EMF data type from the contents of the String value of the column.
   * @throws SQLException
   *           if the value cannot be retrieved from the ResultSet.
   */
  public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner) throws SQLException
  {

    final String data = resultSet.getString(names[0]);
    if (data == null)
    {
      return null;
    }
    return factory.newDuration(data);
  }

  /**
   * Populate the database statement from the model object property.
   * 
   * @param statement
   *          the non-null Statement to insert the value into.
   * @param value
   *          the object to convert.
   * @param index
   *          the index into the statement where to insert the converted value.
   * @throws SQLException
   *           if the converted value cannot be set in the statement.
   */
  public void nullSafeSet(PreparedStatement statement, Object value, int index) throws SQLException
  {
    String pvalue = null;
    if (value != null)
    {
      pvalue = ((Duration)value).toString();
    }
    if (pvalue != null)
    {
      statement.setString(index, pvalue);
    }
    else
    {
      statement.setNull(index, Types.VARCHAR);
    }
  }

  /**
   * No-op implementation.
   * 
   * @param value
   *          the value to dissemble.
   * @return the value passed in.
   */
  public Serializable disassemble(Object value)
  {
    if (value == null)
    {
      return null;
    }
    return ((Duration)value).toString();
  }

  /**
   * No-op implementation.
   * 
   * @param cachedValue
   *          the value to assemble.
   * @param owner
   *          the owning object.
   * @return the cachedValue passed in.
   */
  public Object assemble(Serializable cachedValue, Object owner)
  {
    return cachedValue;
  }

  /**
   * No-op implementation.
   * 
   * @param original
   *          the value to replace.
   * @param target
   *          the target object.
   * @param owner
   *          the owning object.
   * @return the original value passed in.
   */
  public Object replace(Object original, Object target, Object owner)
  {
    return original;
  }

  /**
   * No-op implementation.
   * 
   * @param x
   *          the object to get the hashcode for.
   * @return x's hashcode.
   */
  public int hashCode(Object x)
  {
    return x.hashCode();
  }
}

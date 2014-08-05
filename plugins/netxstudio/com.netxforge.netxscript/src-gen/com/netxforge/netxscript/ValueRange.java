/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.netxscript;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Value Range</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxscript.NetxscriptPackage#getValueRange()
 * @model
 * @generated
 */
public enum ValueRange implements Enumerator
{
  /**
   * The '<em><b>METRIC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #METRIC_VALUE
   * @generated
   * @ordered
   */
  METRIC(0, "METRIC", "METRIC"),

  /**
   * The '<em><b>CAP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CAP_VALUE
   * @generated
   * @ordered
   */
  CAP(1, "CAP", "CAP"),

  /**
   * The '<em><b>FORECAST</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FORECAST_VALUE
   * @generated
   * @ordered
   */
  FORECAST(2, "FORECAST", "FORECAST"),

  /**
   * The '<em><b>FORECAST CAP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FORECAST_CAP_VALUE
   * @generated
   * @ordered
   */
  FORECAST_CAP(3, "FORECAST_CAP", "FORECAST_CAP"),

  /**
   * The '<em><b>TRENDED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TRENDED_VALUE
   * @generated
   * @ordered
   */
  TRENDED(4, "TRENDED", "TRENDED"),

  /**
   * The '<em><b>UTILIZATION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UTILIZATION_VALUE
   * @generated
   * @ordered
   */
  UTILIZATION(5, "UTILIZATION", "UTILIZATION"),

  /**
   * The '<em><b>TOLERANCE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TOLERANCE_VALUE
   * @generated
   * @ordered
   */
  TOLERANCE(6, "TOLERANCE", "TOLERANCE"),

  /**
   * The '<em><b>DERIVED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DERIVED_VALUE
   * @generated
   * @ordered
   */
  DERIVED(7, "DERIVED", "DERIVED");

  /**
   * The '<em><b>METRIC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>METRIC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #METRIC
   * @model
   * @generated
   * @ordered
   */
  public static final int METRIC_VALUE = 0;

  /**
   * The '<em><b>CAP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CAP</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CAP
   * @model
   * @generated
   * @ordered
   */
  public static final int CAP_VALUE = 1;

  /**
   * The '<em><b>FORECAST</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FORECAST</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FORECAST
   * @model
   * @generated
   * @ordered
   */
  public static final int FORECAST_VALUE = 2;

  /**
   * The '<em><b>FORECAST CAP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FORECAST CAP</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FORECAST_CAP
   * @model
   * @generated
   * @ordered
   */
  public static final int FORECAST_CAP_VALUE = 3;

  /**
   * The '<em><b>TRENDED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TRENDED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TRENDED
   * @model
   * @generated
   * @ordered
   */
  public static final int TRENDED_VALUE = 4;

  /**
   * The '<em><b>UTILIZATION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>UTILIZATION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #UTILIZATION
   * @model
   * @generated
   * @ordered
   */
  public static final int UTILIZATION_VALUE = 5;

  /**
   * The '<em><b>TOLERANCE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>TOLERANCE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TOLERANCE
   * @model
   * @generated
   * @ordered
   */
  public static final int TOLERANCE_VALUE = 6;

  /**
   * The '<em><b>DERIVED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DERIVED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DERIVED
   * @model
   * @generated
   * @ordered
   */
  public static final int DERIVED_VALUE = 7;

  /**
   * An array of all the '<em><b>Value Range</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ValueRange[] VALUES_ARRAY =
    new ValueRange[]
    {
      METRIC,
      CAP,
      FORECAST,
      FORECAST_CAP,
      TRENDED,
      UTILIZATION,
      TOLERANCE,
      DERIVED,
    };

  /**
   * A public read-only list of all the '<em><b>Value Range</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ValueRange> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Value Range</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ValueRange get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ValueRange result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Value Range</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ValueRange getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ValueRange result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Value Range</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ValueRange get(int value)
  {
    switch (value)
    {
      case METRIC_VALUE: return METRIC;
      case CAP_VALUE: return CAP;
      case FORECAST_VALUE: return FORECAST;
      case FORECAST_CAP_VALUE: return FORECAST_CAP;
      case TRENDED_VALUE: return TRENDED;
      case UTILIZATION_VALUE: return UTILIZATION;
      case TOLERANCE_VALUE: return TOLERANCE;
      case DERIVED_VALUE: return DERIVED;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private ValueRange(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //ValueRange

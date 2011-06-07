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
 * A representation of the literals of the enumeration '<em><b>Native Function</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxscript.NetxscriptPackage#getNativeFunction()
 * @model
 * @generated
 */
public enum NativeFunction implements Enumerator
{
  /**
   * The '<em><b>COUNT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #COUNT_VALUE
   * @generated
   * @ordered
   */
  COUNT(0, "COUNT", "COUNT"),

  /**
   * The '<em><b>SUM</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUM_VALUE
   * @generated
   * @ordered
   */
  SUM(1, "SUM", "SUM"),

  /**
   * The '<em><b>MIN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MIN_VALUE
   * @generated
   * @ordered
   */
  MIN(2, "MIN", "MIN"),

  /**
   * The '<em><b>MAX</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MAX_VALUE
   * @generated
   * @ordered
   */
  MAX(3, "MAX", "MAX"),

  /**
   * The '<em><b>MEAN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MEAN_VALUE
   * @generated
   * @ordered
   */
  MEAN(4, "MEAN", "MEAN"),

  /**
   * The '<em><b>DEVIATION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DEVIATION_VALUE
   * @generated
   * @ordered
   */
  DEVIATION(5, "DEVIATION", "DEVIATION");

  /**
   * The '<em><b>COUNT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>COUNT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #COUNT
   * @model
   * @generated
   * @ordered
   */
  public static final int COUNT_VALUE = 0;

  /**
   * The '<em><b>SUM</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUM</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUM
   * @model
   * @generated
   * @ordered
   */
  public static final int SUM_VALUE = 1;

  /**
   * The '<em><b>MIN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MIN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MIN
   * @model
   * @generated
   * @ordered
   */
  public static final int MIN_VALUE = 2;

  /**
   * The '<em><b>MAX</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MAX</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MAX
   * @model
   * @generated
   * @ordered
   */
  public static final int MAX_VALUE = 3;

  /**
   * The '<em><b>MEAN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MEAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MEAN
   * @model
   * @generated
   * @ordered
   */
  public static final int MEAN_VALUE = 4;

  /**
   * The '<em><b>DEVIATION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DEVIATION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DEVIATION
   * @model
   * @generated
   * @ordered
   */
  public static final int DEVIATION_VALUE = 5;

  /**
   * An array of all the '<em><b>Native Function</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final NativeFunction[] VALUES_ARRAY =
    new NativeFunction[]
    {
      COUNT,
      SUM,
      MIN,
      MAX,
      MEAN,
      DEVIATION,
    };

  /**
   * A public read-only list of all the '<em><b>Native Function</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<NativeFunction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Native Function</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NativeFunction get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      NativeFunction result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Native Function</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NativeFunction getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      NativeFunction result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Native Function</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static NativeFunction get(int value)
  {
    switch (value)
    {
      case COUNT_VALUE: return COUNT;
      case SUM_VALUE: return SUM;
      case MIN_VALUE: return MIN;
      case MAX_VALUE: return MAX;
      case MEAN_VALUE: return MEAN;
      case DEVIATION_VALUE: return DEVIATION;
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
  private NativeFunction(int value, String name, String literal)
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
  
} //NativeFunction

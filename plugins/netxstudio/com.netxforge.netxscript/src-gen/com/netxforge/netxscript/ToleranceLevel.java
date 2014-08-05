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
 * A representation of the literals of the enumeration '<em><b>Tolerance Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxscript.NetxscriptPackage#getToleranceLevel()
 * @model
 * @generated
 */
public enum ToleranceLevel implements Enumerator
{
  /**
   * The '<em><b>RED</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RED_VALUE
   * @generated
   * @ordered
   */
  RED(0, "RED", "RED"),

  /**
   * The '<em><b>AMBER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AMBER_VALUE
   * @generated
   * @ordered
   */
  AMBER(1, "AMBER", "AMBER"),

  /**
   * The '<em><b>GREEN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREEN_VALUE
   * @generated
   * @ordered
   */
  GREEN(2, "GREEN", "GREEN"),

  /**
   * The '<em><b>YELLOW</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #YELLOW_VALUE
   * @generated
   * @ordered
   */
  YELLOW(3, "YELLOW", "YELLOW");

  /**
   * The '<em><b>RED</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RED</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RED
   * @model
   * @generated
   * @ordered
   */
  public static final int RED_VALUE = 0;

  /**
   * The '<em><b>AMBER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AMBER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AMBER
   * @model
   * @generated
   * @ordered
   */
  public static final int AMBER_VALUE = 1;

  /**
   * The '<em><b>GREEN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GREEN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREEN
   * @model
   * @generated
   * @ordered
   */
  public static final int GREEN_VALUE = 2;

  /**
   * The '<em><b>YELLOW</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>YELLOW</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #YELLOW
   * @model
   * @generated
   * @ordered
   */
  public static final int YELLOW_VALUE = 3;

  /**
   * An array of all the '<em><b>Tolerance Level</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ToleranceLevel[] VALUES_ARRAY =
    new ToleranceLevel[]
    {
      RED,
      AMBER,
      GREEN,
      YELLOW,
    };

  /**
   * A public read-only list of all the '<em><b>Tolerance Level</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ToleranceLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Tolerance Level</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ToleranceLevel get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ToleranceLevel result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tolerance Level</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ToleranceLevel getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ToleranceLevel result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Tolerance Level</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ToleranceLevel get(int value)
  {
    switch (value)
    {
      case RED_VALUE: return RED;
      case AMBER_VALUE: return AMBER;
      case GREEN_VALUE: return GREEN;
      case YELLOW_VALUE: return YELLOW;
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
  private ToleranceLevel(int value, String name, String literal)
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
  
} //ToleranceLevel

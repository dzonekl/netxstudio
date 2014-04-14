/**
 */
package com.netxforge.smi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>VALUE CAP LITERALS</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.netxforge.smi.SmiPackage#getVALUE_CAP_LITERALS()
 * @model
 * @generated
 */
public enum VALUE_CAP_LITERALS implements Enumerator
{
  /**
   * The '<em><b>Oi Literal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OI_LITERAL_VALUE
   * @generated
   * @ordered
   */
  OI_LITERAL(0, "oiLiteral", "OBJECT IDENTIFIER"),

  /**
   * The '<em><b>Ia5 String Literal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IA5_STRING_LITERAL_VALUE
   * @generated
   * @ordered
   */
  IA5_STRING_LITERAL(1, "ia5StringLiteral", "IA5String");

  /**
   * The '<em><b>Oi Literal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Oi Literal</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OI_LITERAL
   * @model name="oiLiteral" literal="OBJECT IDENTIFIER"
   * @generated
   * @ordered
   */
  public static final int OI_LITERAL_VALUE = 0;

  /**
   * The '<em><b>Ia5 String Literal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Ia5 String Literal</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IA5_STRING_LITERAL
   * @model name="ia5StringLiteral" literal="IA5String"
   * @generated
   * @ordered
   */
  public static final int IA5_STRING_LITERAL_VALUE = 1;

  /**
   * An array of all the '<em><b>VALUE CAP LITERALS</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final VALUE_CAP_LITERALS[] VALUES_ARRAY =
    new VALUE_CAP_LITERALS[]
    {
      OI_LITERAL,
      IA5_STRING_LITERAL,
    };

  /**
   * A public read-only list of all the '<em><b>VALUE CAP LITERALS</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<VALUE_CAP_LITERALS> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>VALUE CAP LITERALS</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VALUE_CAP_LITERALS get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      VALUE_CAP_LITERALS result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>VALUE CAP LITERALS</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VALUE_CAP_LITERALS getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      VALUE_CAP_LITERALS result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>VALUE CAP LITERALS</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static VALUE_CAP_LITERALS get(int value)
  {
    switch (value)
    {
      case OI_LITERAL_VALUE: return OI_LITERAL;
      case IA5_STRING_LITERAL_VALUE: return IA5_STRING_LITERAL;
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
  private VALUE_CAP_LITERALS(int value, String name, String literal)
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
  
} //VALUE_CAP_LITERALS

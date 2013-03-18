/**
 * <copyright>
 * </copyright>
 *
 */
package com.netxforge.smi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>WELL KNOWN NAMES</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.netxforge.smi.SmiPackage#getWELL_KNOWN_NAMES()
 * @model
 * @generated
 */
public enum WELL_KNOWN_NAMES implements Enumerator
{
  /**
   * The '<em><b>Ccitt</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CCITT_VALUE
   * @generated
   * @ordered
   */
  CCITT(0, "ccitt", "ccitt"),

  /**
   * The '<em><b>Iso</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ISO_VALUE
   * @generated
   * @ordered
   */
  ISO(1, "iso", "iso"),

  /**
   * The '<em><b>Joint iso ccitt</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #JOINT_ISO_CCITT_VALUE
   * @generated
   * @ordered
   */
  JOINT_ISO_CCITT(2, "joint_iso_ccitt", "joint-iso-ccitt");

  /**
   * The '<em><b>Ccitt</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Ccitt</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CCITT
   * @model name="ccitt"
   * @generated
   * @ordered
   */
  public static final int CCITT_VALUE = 0;

  /**
   * The '<em><b>Iso</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Iso</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ISO
   * @model name="iso"
   * @generated
   * @ordered
   */
  public static final int ISO_VALUE = 1;

  /**
   * The '<em><b>Joint iso ccitt</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Joint iso ccitt</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #JOINT_ISO_CCITT
   * @model name="joint_iso_ccitt" literal="joint-iso-ccitt"
   * @generated
   * @ordered
   */
  public static final int JOINT_ISO_CCITT_VALUE = 2;

  /**
   * An array of all the '<em><b>WELL KNOWN NAMES</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final WELL_KNOWN_NAMES[] VALUES_ARRAY =
    new WELL_KNOWN_NAMES[]
    {
      CCITT,
      ISO,
      JOINT_ISO_CCITT,
    };

  /**
   * A public read-only list of all the '<em><b>WELL KNOWN NAMES</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<WELL_KNOWN_NAMES> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>WELL KNOWN NAMES</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static WELL_KNOWN_NAMES get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      WELL_KNOWN_NAMES result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>WELL KNOWN NAMES</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static WELL_KNOWN_NAMES getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      WELL_KNOWN_NAMES result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>WELL KNOWN NAMES</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static WELL_KNOWN_NAMES get(int value)
  {
    switch (value)
    {
      case CCITT_VALUE: return CCITT;
      case ISO_VALUE: return ISO;
      case JOINT_ISO_CCITT_VALUE: return JOINT_ISO_CCITT;
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
  private WELL_KNOWN_NAMES(int value, String name, String literal)
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
  
} //WELL_KNOWN_NAMES

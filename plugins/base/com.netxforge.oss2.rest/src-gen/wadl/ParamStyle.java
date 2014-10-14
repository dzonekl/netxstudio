/**
 */
package wadl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Param Style</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see wadl.WadlPackage#getParamStyle()
 * @model extendedMetaData="name='ParamStyle'"
 * @generated
 */
public enum ParamStyle implements Enumerator {
	/**
	 * The '<em><b>Plain</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAIN_VALUE
	 * @generated
	 * @ordered
	 */
	PLAIN(0, "plain", "plain"),

	/**
	 * The '<em><b>Query</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUERY_VALUE
	 * @generated
	 * @ordered
	 */
	QUERY(1, "query", "query"),

	/**
	 * The '<em><b>Matrix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATRIX_VALUE
	 * @generated
	 * @ordered
	 */
	MATRIX(2, "matrix", "matrix"),

	/**
	 * The '<em><b>Header</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	HEADER(3, "header", "header"),

	/**
	 * The '<em><b>Template</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE_VALUE
	 * @generated
	 * @ordered
	 */
	TEMPLATE(4, "template", "template");

	/**
	 * The '<em><b>Plain</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Plain</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAIN
	 * @model name="plain"
	 * @generated
	 * @ordered
	 */
	public static final int PLAIN_VALUE = 0;

	/**
	 * The '<em><b>Query</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Query</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUERY
	 * @model name="query"
	 * @generated
	 * @ordered
	 */
	public static final int QUERY_VALUE = 1;

	/**
	 * The '<em><b>Matrix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Matrix</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MATRIX
	 * @model name="matrix"
	 * @generated
	 * @ordered
	 */
	public static final int MATRIX_VALUE = 2;

	/**
	 * The '<em><b>Header</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Header</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEADER
	 * @model name="header"
	 * @generated
	 * @ordered
	 */
	public static final int HEADER_VALUE = 3;

	/**
	 * The '<em><b>Template</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Template</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPLATE
	 * @model name="template"
	 * @generated
	 * @ordered
	 */
	public static final int TEMPLATE_VALUE = 4;

	/**
	 * An array of all the '<em><b>Param Style</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ParamStyle[] VALUES_ARRAY =
		new ParamStyle[] {
			PLAIN,
			QUERY,
			MATRIX,
			HEADER,
			TEMPLATE,
		};

	/**
	 * A public read-only list of all the '<em><b>Param Style</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ParamStyle> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Param Style</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParamStyle get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ParamStyle result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Param Style</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParamStyle getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ParamStyle result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Param Style</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParamStyle get(int value) {
		switch (value) {
			case PLAIN_VALUE: return PLAIN;
			case QUERY_VALUE: return QUERY;
			case MATRIX_VALUE: return MATRIX;
			case HEADER_VALUE: return HEADER;
			case TEMPLATE_VALUE: return TEMPLATE;
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
	private ParamStyle(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ParamStyle

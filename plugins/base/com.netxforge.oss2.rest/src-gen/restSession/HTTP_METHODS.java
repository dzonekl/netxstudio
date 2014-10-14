/**
 */
package restSession;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>HTTP METHODS</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see restSession.RestSessionPackage#getHTTP_METHODS()
 * @model
 * @generated
 */
public enum HTTP_METHODS implements Enumerator {
	/**
	 * The '<em><b>GET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_VALUE
	 * @generated
	 * @ordered
	 */
	GET(200, "GET", "GET"),

	/**
	 * The '<em><b>POST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST_VALUE
	 * @generated
	 * @ordered
	 */
	POST(300, "POST", "POST"), /**
	 * The '<em><b>DELETE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE(400, "DELETE", "DELETE");

	/**
	 * The '<em><b>GET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GET_VALUE = 200;

	/**
	 * The '<em><b>POST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POST_VALUE = 300;

	/**
	 * The '<em><b>DELETE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DELETE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELETE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DELETE_VALUE = 400;

	/**
	 * An array of all the '<em><b>HTTP METHODS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HTTP_METHODS[] VALUES_ARRAY =
		new HTTP_METHODS[] {
			GET,
			POST,
			DELETE,
		};

	/**
	 * A public read-only list of all the '<em><b>HTTP METHODS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<HTTP_METHODS> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>HTTP METHODS</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HTTP_METHODS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HTTP_METHODS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>HTTP METHODS</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HTTP_METHODS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HTTP_METHODS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>HTTP METHODS</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HTTP_METHODS get(int value) {
		switch (value) {
			case GET_VALUE: return GET;
			case POST_VALUE: return POST;
			case DELETE_VALUE: return DELETE;
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
	private HTTP_METHODS(int value, String name, String literal) {
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
	
} //HTTP_METHODS

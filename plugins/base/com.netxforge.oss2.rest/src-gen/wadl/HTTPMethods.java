/**
 */
package wadl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>HTTP Methods</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see wadl.WadlPackage#getHTTPMethods()
 * @model extendedMetaData="name='HTTPMethods'"
 * @generated
 */
public enum HTTPMethods implements Enumerator {
	/**
	 * The '<em><b>GET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_VALUE
	 * @generated
	 * @ordered
	 */
	GET(0, "GET", "GET"),

	/**
	 * The '<em><b>POST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POST_VALUE
	 * @generated
	 * @ordered
	 */
	POST(1, "POST", "POST"),

	/**
	 * The '<em><b>PUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PUT_VALUE
	 * @generated
	 * @ordered
	 */
	PUT(2, "PUT", "PUT"),

	/**
	 * The '<em><b>HEAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEAD_VALUE
	 * @generated
	 * @ordered
	 */
	HEAD(3, "HEAD", "HEAD"),

	/**
	 * The '<em><b>DELETE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELETE_VALUE
	 * @generated
	 * @ordered
	 */
	DELETE(4, "DELETE", "DELETE");

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
	public static final int GET_VALUE = 0;

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
	public static final int POST_VALUE = 1;

	/**
	 * The '<em><b>PUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PUT_VALUE = 2;

	/**
	 * The '<em><b>HEAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEAD_VALUE = 3;

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
	public static final int DELETE_VALUE = 4;

	/**
	 * An array of all the '<em><b>HTTP Methods</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HTTPMethods[] VALUES_ARRAY =
		new HTTPMethods[] {
			GET,
			POST,
			PUT,
			HEAD,
			DELETE,
		};

	/**
	 * A public read-only list of all the '<em><b>HTTP Methods</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<HTTPMethods> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>HTTP Methods</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HTTPMethods get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HTTPMethods result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>HTTP Methods</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HTTPMethods getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HTTPMethods result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>HTTP Methods</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static HTTPMethods get(int value) {
		switch (value) {
			case GET_VALUE: return GET;
			case POST_VALUE: return POST;
			case PUT_VALUE: return PUT;
			case HEAD_VALUE: return HEAD;
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
	private HTTPMethods(int value, String name, String literal) {
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
	
} //HTTPMethods

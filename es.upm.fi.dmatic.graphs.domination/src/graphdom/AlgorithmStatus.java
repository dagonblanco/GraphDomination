/**
 */
package graphdom;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Algorithm Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see graphdom.GraphdomPackage#getAlgorithmStatus()
 * @model
 * @generated
 */
public enum AlgorithmStatus implements Enumerator {
	/**
	 * The '<em><b>UNINITIALIZED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNINITIALIZED_VALUE
	 * @generated
	 * @ordered
	 */
	UNINITIALIZED(0, "UNINITIALIZED", "UNINITIALIZED"),

	/**
	 * The '<em><b>INPROGRESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INPROGRESS_VALUE
	 * @generated
	 * @ordered
	 */
	INPROGRESS(1, "INPROGRESS", "INPROGRESS"),

	/**
	 * The '<em><b>ENDED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENDED_VALUE
	 * @generated
	 * @ordered
	 */
	ENDED(2, "ENDED", "ENDED");

	/**
	 * The '<em><b>UNINITIALIZED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNINITIALIZED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNINITIALIZED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNINITIALIZED_VALUE = 0;

	/**
	 * The '<em><b>INPROGRESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INPROGRESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INPROGRESS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INPROGRESS_VALUE = 1;

	/**
	 * The '<em><b>ENDED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENDED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENDED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENDED_VALUE = 2;

	/**
	 * An array of all the '<em><b>Algorithm Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AlgorithmStatus[] VALUES_ARRAY =
		new AlgorithmStatus[] {
			UNINITIALIZED,
			INPROGRESS,
			ENDED,
		};

	/**
	 * A public read-only list of all the '<em><b>Algorithm Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AlgorithmStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Algorithm Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AlgorithmStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AlgorithmStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Algorithm Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AlgorithmStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AlgorithmStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Algorithm Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AlgorithmStatus get(int value) {
		switch (value) {
			case UNINITIALIZED_VALUE: return UNINITIALIZED;
			case INPROGRESS_VALUE: return INPROGRESS;
			case ENDED_VALUE: return ENDED;
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
	private AlgorithmStatus(int value, String name, String literal) {
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
	
} //AlgorithmStatus

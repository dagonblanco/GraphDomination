/**
 */
package graphdom.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 */
public enum AlgorithmStatus {
	/**
	 * The '<em><b>UNINITIALIZED</b></em>' literal object.
	 */
	UNINITIALIZED(0, "UNINITIALIZED", "Uninitialized"),

	/**
	 * The '<em><b>INPROGRESS</b></em>' literal object.
	 * 
	 */
	INPROGRESS(1, "INPROGRESS", "In progress"),

	/**
	 * The '<em><b>ENDED</b></em>' literal object.
	 */
	ENDED(2, "ENDED", "Ended");

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private AlgorithmStatus(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * The '<em><b>UNINITIALIZED</b></em>' literal value.
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

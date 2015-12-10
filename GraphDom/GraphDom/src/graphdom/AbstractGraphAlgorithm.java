/**
 */
package graphdom;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Graph Algorithm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link graphdom.AbstractGraphAlgorithm#getInitialGraph <em>Initial Graph</em>}</li>
 *   <li>{@link graphdom.AbstractGraphAlgorithm#getProcessedGraph <em>Processed Graph</em>}</li>
 *   <li>{@link graphdom.AbstractGraphAlgorithm#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see graphdom.GraphdomPackage#getAbstractGraphAlgorithm()
 * @model abstract="true"
 * @generated
 */
public interface AbstractGraphAlgorithm extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Graph</em>' reference.
	 * @see #setInitialGraph(Graph)
	 * @see graphdom.GraphdomPackage#getAbstractGraphAlgorithm_InitialGraph()
	 * @model
	 * @generated
	 */
	Graph getInitialGraph();

	/**
	 * Sets the value of the '{@link graphdom.AbstractGraphAlgorithm#getInitialGraph <em>Initial Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Graph</em>' reference.
	 * @see #getInitialGraph()
	 * @generated
	 */
	void setInitialGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Processed Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processed Graph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processed Graph</em>' reference.
	 * @see #setProcessedGraph(Graph)
	 * @see graphdom.GraphdomPackage#getAbstractGraphAlgorithm_ProcessedGraph()
	 * @model
	 * @generated
	 */
	Graph getProcessedGraph();

	/**
	 * Sets the value of the '{@link graphdom.AbstractGraphAlgorithm#getProcessedGraph <em>Processed Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processed Graph</em>' reference.
	 * @see #getProcessedGraph()
	 * @generated
	 */
	void setProcessedGraph(Graph value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link graphdom.AlgorithmStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see graphdom.AlgorithmStatus
	 * @see #setStatus(AlgorithmStatus)
	 * @see graphdom.GraphdomPackage#getAbstractGraphAlgorithm_Status()
	 * @model
	 * @generated
	 */
	AlgorithmStatus getStatus();

	/**
	 * Sets the value of the '{@link graphdom.AbstractGraphAlgorithm#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see graphdom.AlgorithmStatus
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(AlgorithmStatus value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void runToEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void nextStep();

} // AbstractGraphAlgorithm

/**
 */
package graphdom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import graphdom.algorithms.GraphAlgorithm;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link graphdom.Graph#getGraphName <em>Graph Name</em>}</li>
 *   <li>{@link graphdom.Graph#getNodes <em>Nodes</em>}</li>
 *   <li>{@link graphdom.Graph#getEdges <em>Edges</em>}</li>
 *   <li>{@link graphdom.Graph#getNextNodeId <em>Next Node Id</em>}</li>
 * </ul>
 *
 * @see graphdom.GraphdomPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends EObject {
	/**
	 * Returns the value of the '<em><b>Graph Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Graph Name</em>' attribute.
	 * @see #setGraphName(String)
	 * @see graphdom.GraphdomPackage#getGraph_GraphName()
	 * @model default=""
	 * @generated
	 */
	String getGraphName();

	/**
	 * Sets the value of the '{@link graphdom.Graph#getGraphName <em>Graph Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graph Name</em>' attribute.
	 * @see #getGraphName()
	 * @generated
	 */
	void setGraphName(String value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link graphdom.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see graphdom.GraphdomPackage#getGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link graphdom.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see graphdom.GraphdomPackage#getGraph_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

	/**
	 * Returns the value of the '<em><b>Next Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Node Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Node Id</em>' attribute.
	 * @see #setNextNodeId(int)
	 * @see graphdom.GraphdomPackage#getGraph_NextNodeId()
	 * @model
	 * @generated
	 */
	int getNextNodeId();

	/**
	 * Sets the value of the '{@link graphdom.Graph#getNextNodeId <em>Next Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Node Id</em>' attribute.
	 * @see #getNextNodeId()
	 * @generated
	 */
	void setNextNodeId(int value);

	Node findNodeById(String id);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void unmarkAllNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void removeNode(Node node);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isDominated();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Node> getDominatingSet();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void checkNodesDomination();

	GraphAlgorithm getAlgorithm();

	void setAlgorithm(GraphAlgorithm algorithm);

} // Graph

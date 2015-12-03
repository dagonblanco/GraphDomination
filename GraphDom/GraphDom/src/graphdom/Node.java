/**
 */
package graphdom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link graphdom.Node#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link graphdom.Node#getColor <em>Color</em>}</li>
 *   <li>{@link graphdom.Node#getConnectedEdges <em>Connected Edges</em>}</li>
 * </ul>
 *
 * @see graphdom.GraphdomPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Name</em>' attribute.
	 * @see #setNodeName(String)
	 * @see graphdom.GraphdomPackage#getNode_NodeName()
	 * @model
	 * @generated
	 */
	String getNodeName();

	/**
	 * Sets the value of the '{@link graphdom.Node#getNodeName <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Name</em>' attribute.
	 * @see #getNodeName()
	 * @generated
	 */
	void setNodeName(String value);

	/**
	 * Returns the value of the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' attribute.
	 * @see #setColor(String)
	 * @see graphdom.GraphdomPackage#getNode_Color()
	 * @model
	 * @generated
	 */
	String getColor();

	/**
	 * Sets the value of the '{@link graphdom.Node#getColor <em>Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Color</em>' attribute.
	 * @see #getColor()
	 * @generated
	 */
	void setColor(String value);

	/**
	 * Returns the value of the '<em><b>Connected Edges</b></em>' reference list.
	 * The list contents are of type {@link graphdom.Edge}.
	 * It is bidirectional and its opposite is '{@link graphdom.Edge#getConnectedNodes <em>Connected Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected Edges</em>' reference list.
	 * @see graphdom.GraphdomPackage#getNode_ConnectedEdges()
	 * @see graphdom.Edge#getConnectedNodes
	 * @model opposite="connectedNodes"
	 * @generated
	 */
	EList<Edge> getConnectedEdges();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Node> getAdjacentNodes();

} // Node

/**
 */
package graphdom;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link graphdom.Edge#getConnectedNodes <em>Connected Nodes</em>}</li>
 * </ul>
 *
 * @see graphdom.GraphdomPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends EObject {
	/**
	 * Returns the value of the '<em><b>Connected Nodes</b></em>' reference list.
	 * The list contents are of type {@link graphdom.Node}.
	 * It is bidirectional and its opposite is '{@link graphdom.Node#getConnectedEdges <em>Connected Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connected Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connected Nodes</em>' reference list.
	 * @see graphdom.GraphdomPackage#getEdge_ConnectedNodes()
	 * @see graphdom.Node#getConnectedEdges
	 * @model opposite="connectedEdges" lower="2" upper="2" ordered="false"
	 * @generated
	 */
	EList<Node> getConnectedNodes();

} // Edge

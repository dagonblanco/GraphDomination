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
 *   <li>{@link graphdom.Edge#isMarked <em>Marked</em>}</li>
 *   <li>{@link graphdom.Edge#getGuid <em>Guid</em>}</li>
 *   <li>{@link graphdom.Edge#getWeight <em>Weight</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Marked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marked</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marked</em>' attribute.
	 * @see #setMarked(boolean)
	 * @see graphdom.GraphdomPackage#getEdge_Marked()
	 * @model
	 * @generated
	 */
	boolean isMarked();

	/**
	 * Sets the value of the '{@link graphdom.Edge#isMarked <em>Marked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marked</em>' attribute.
	 * @see #isMarked()
	 * @generated
	 */
	void setMarked(boolean value);

	/**
	 * Returns the value of the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guid</em>' attribute.
	 * @see #setGuid(String)
	 * @see graphdom.GraphdomPackage#getEdge_Guid()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getGuid();

	/**
	 * Sets the value of the '{@link graphdom.Edge#getGuid <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guid</em>' attribute.
	 * @see #getGuid()
	 * @generated
	 */
	void setGuid(String value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see #setWeight(int)
	 * @see graphdom.GraphdomPackage#getEdge_Weight()
	 * @model default="0"
	 * @generated
	 */
	int getWeight();

	/**
	 * Sets the value of the '{@link graphdom.Edge#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean flip();

} // Edge

/**
 */
package graphdom.impl;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.GraphdomPackage;
import graphdom.Node;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link graphdom.impl.GraphImpl#getGraphName <em>Graph Name</em>}</li>
 *   <li>{@link graphdom.impl.GraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link graphdom.impl.GraphImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link graphdom.impl.GraphImpl#getNextNodeId <em>Next Node Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphImpl extends MinimalEObjectImpl.Container implements Graph {
	/**
	 * The default value of the '{@link #getGraphName() <em>Graph Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphName()
	 * @generated
	 * @ordered
	 */
	protected static final String GRAPH_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getGraphName() <em>Graph Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGraphName()
	 * @generated
	 * @ordered
	 */
	protected String graphName = GRAPH_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edges;

	/**
	 * The default value of the '{@link #getNextNodeId() <em>Next Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextNodeId()
	 * @generated
	 * @ordered
	 */
	protected static final int NEXT_NODE_ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNextNodeId() <em>Next Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextNodeId()
	 * @generated
	 * @ordered
	 */
	protected int nextNodeId = NEXT_NODE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphdomPackage.Literals.GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGraphName() {
		return graphName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraphName(String newGraphName) {
		String oldGraphName = graphName;
		graphName = newGraphName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.GRAPH__GRAPH_NAME, oldGraphName, graphName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, GraphdomPackage.GRAPH__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentEList<Edge>(Edge.class, this, GraphdomPackage.GRAPH__EDGES);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getNextNodeId() {
		return nextNodeId++;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextNodeId(int newNextNodeId) {
		int oldNextNodeId = nextNodeId;
		nextNodeId = newNextNodeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.GRAPH__NEXT_NODE_ID, oldNextNodeId, nextNodeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node findNodeById(String id) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphdomPackage.GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GraphdomPackage.GRAPH__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphdomPackage.GRAPH__GRAPH_NAME:
				return getGraphName();
			case GraphdomPackage.GRAPH__NODES:
				return getNodes();
			case GraphdomPackage.GRAPH__EDGES:
				return getEdges();
			case GraphdomPackage.GRAPH__NEXT_NODE_ID:
				return getNextNodeId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphdomPackage.GRAPH__GRAPH_NAME:
				setGraphName((String)newValue);
				return;
			case GraphdomPackage.GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case GraphdomPackage.GRAPH__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case GraphdomPackage.GRAPH__NEXT_NODE_ID:
				setNextNodeId((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphdomPackage.GRAPH__GRAPH_NAME:
				setGraphName(GRAPH_NAME_EDEFAULT);
				return;
			case GraphdomPackage.GRAPH__NODES:
				getNodes().clear();
				return;
			case GraphdomPackage.GRAPH__EDGES:
				getEdges().clear();
				return;
			case GraphdomPackage.GRAPH__NEXT_NODE_ID:
				setNextNodeId(NEXT_NODE_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphdomPackage.GRAPH__GRAPH_NAME:
				return GRAPH_NAME_EDEFAULT == null ? graphName != null : !GRAPH_NAME_EDEFAULT.equals(graphName);
			case GraphdomPackage.GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case GraphdomPackage.GRAPH__EDGES:
				return edges != null && !edges.isEmpty();
			case GraphdomPackage.GRAPH__NEXT_NODE_ID:
				return nextNodeId != NEXT_NODE_ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphdomPackage.GRAPH___FIND_NODE_BY_ID__STRING:
				return findNodeById((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (graphName: ");
		result.append(graphName);
		result.append(", nextNodeId: ");
		result.append(nextNodeId);
		result.append(')');
		return result.toString();
	}

} //GraphImpl

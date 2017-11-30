/**
 */
package graphdom.impl;

import graphdom.AbstractGraphAlgorithm;
import graphdom.Edge;
import graphdom.Graph;
import graphdom.GraphdomPackage;
import graphdom.Node;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
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
 *   <li>{@link graphdom.impl.GraphImpl#getAssignedAlgorithm <em>Assigned Algorithm</em>}</li>
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
	 * The cached value of the '{@link #getAssignedAlgorithm() <em>Assigned Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected AbstractGraphAlgorithm assignedAlgorithm;

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
	public AbstractGraphAlgorithm getAssignedAlgorithm() {
		return assignedAlgorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignedAlgorithm(AbstractGraphAlgorithm newAssignedAlgorithm, NotificationChain msgs) {
		AbstractGraphAlgorithm oldAssignedAlgorithm = assignedAlgorithm;
		assignedAlgorithm = newAssignedAlgorithm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM, oldAssignedAlgorithm, newAssignedAlgorithm);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignedAlgorithm(AbstractGraphAlgorithm newAssignedAlgorithm) {
		if (newAssignedAlgorithm != assignedAlgorithm) {
			NotificationChain msgs = null;
			if (assignedAlgorithm != null)
				msgs = ((InternalEObject)assignedAlgorithm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM, null, msgs);
			if (newAssignedAlgorithm != null)
				msgs = ((InternalEObject)newAssignedAlgorithm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM, null, msgs);
			msgs = basicSetAssignedAlgorithm(newAssignedAlgorithm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM, newAssignedAlgorithm, newAssignedAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Node findNodeById(String id) {

		for (Node node : getNodes()) {
			if (node.getGuid().equals(id)){
				return node;
			}
			
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void unmarkAllNodes() {
		for (Node node : getNodes()) {
		node.setDominated(false);
		node.setDominating(false);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void removeNode(Node node) {

		
		
		// Remove referenced edges
		this.getEdges().removeAll(node.getConnectedEdges());
		
		node.getConnectedEdges().clear();
		
		// Remove node
		this.getNodes().remove(node);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public boolean isDominated() {
		for (Node node : this.getNodes()) {
			if (!node.isDominated() && !node.isDominating()){
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public EList<Node> getDominatingSet() {
		EList<Node> result = new BasicEList<Node>();
		for (Node node : this.getNodes()) {
			if (node.isDominating()){
				result.add(node);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void checkNodesDomination() {
		for (Node node : this.getNodes()) {
			node.setDominated(false);
		}

		for (Node node : this.getNodes()) {
			if (node.isDominating()){
				for (Node dominatedNode : node.getAdjacentNodes()) {
					dominatedNode.setDominated(true);
				}
			}
		}
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
			case GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM:
				return basicSetAssignedAlgorithm(null, msgs);
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
			case GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM:
				return getAssignedAlgorithm();
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
			case GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM:
				setAssignedAlgorithm((AbstractGraphAlgorithm)newValue);
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
			case GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM:
				setAssignedAlgorithm((AbstractGraphAlgorithm)null);
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
			case GraphdomPackage.GRAPH__ASSIGNED_ALGORITHM:
				return assignedAlgorithm != null;
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
			case GraphdomPackage.GRAPH___UNMARK_ALL_NODES:
				unmarkAllNodes();
				return null;
			case GraphdomPackage.GRAPH___REMOVE_NODE__NODE:
				removeNode((Node)arguments.get(0));
				return null;
			case GraphdomPackage.GRAPH___IS_DOMINATED:
				return isDominated();
			case GraphdomPackage.GRAPH___GET_DOMINATING_SET:
				return getDominatingSet();
			case GraphdomPackage.GRAPH___CHECK_NODES_DOMINATION:
				checkNodesDomination();
				return null;
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

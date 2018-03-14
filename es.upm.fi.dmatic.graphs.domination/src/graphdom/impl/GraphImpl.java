/**
 */
package graphdom.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;

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

import graphdom.Edge;
import graphdom.Graph;
import graphdom.GraphdomPackage;
import graphdom.Node;
import graphdom.algorithms.GraphAlgorithm;
import graphdom.algorithms.NullAlgorithm;

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

	protected GraphAlgorithm algorithm = new NullAlgorithm();
	
	protected PriorityQueue<Integer> freeNodeIds = null;
	
	@Override
	public GraphAlgorithm getAlgorithm() {
		return algorithm;
	}

	@Override
	public void setAlgorithm(GraphAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

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
	@Override
	public String getGraphName() {
		return graphName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public int getNextNodeId() {

		if (freeNodeIds == null) {
			initializeFreeNodeIds();
		}

		return (freeNodeIds.isEmpty() ? this.getNodes().size() : freeNodeIds.poll());
	}

	private void initializeFreeNodeIds() {
		int highestNodeId = 0;

		// Get highest node name
		for (Node node : getNodes()) {
			int nodeName = Integer.parseInt(node.getNodeName());
			if (nodeName > highestNodeId)
				highestNodeId = nodeName;
		}

		// Create queue and add each unused name
		freeNodeIds = new PriorityQueue<>();
		for (int i = 0; i < highestNodeId; i++) {
				freeNodeIds.add(i);
		}

		for (Node node : getNodes()) {
			freeNodeIds.remove(Integer.parseInt(node.getNodeName()));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNextNodeId(int newNextNodeId) {
		int oldNextNodeId = nextNodeId;
		nextNodeId = newNextNodeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.GRAPH__NEXT_NODE_ID, oldNextNodeId, nextNodeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
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
	@Override
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
	@Override
	public void removeNode(Node node) {

		if (freeNodeIds == null)
			initializeFreeNodeIds();

		freeNodeIds.add(Integer.parseInt(node.getNodeName()));
		
		// // Remove referenced edges
		// this.getEdges().removeAll(node.getConnectedEdges());
		//
		// node.getConnectedEdges().clear();
		//
		// // Remove node
		// this.getNodes().remove(node);

		checkNodesDomination();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
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
	@Override
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
	@Override
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	@Override
	public boolean isTotallyDominated() {

		if (!isDominated() || this.getNodes().isEmpty()) {
			return false;
		}

		for (Node node : this.getNodes()) {
			// All nodes must be dominated (even dominating ones!!!)
			if (!node.isDominated()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated not
	 */
	@Override
	public boolean isIndependentlyDominated() {

		if (!isDominated() || this.getNodes().isEmpty()) {
			return false;
		}

		for (Node node : this.getNodes()) {
			// All nodes must be dominated except for dominating ones
			if (!((!node.isDominated() && node.isDominating()) || (node.isDominated() && !node.isDominating()))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean isConnectedDomination() {

		if (!isDominated() || this.getNodes().isEmpty()) {
			return false;
		}

		// All dominating nodes go to unvisited
		HashSet<Node> unvisited = new HashSet<Node>();		
		unvisited.addAll(this.getDominatingSet());

		// toVisit is empty set
		EList<Node> toVisit = new BasicEList<Node>();

		// Get first node...
		Node firstNode = this.getDominatingSet().get(0);
		// ... and add it to the toVisit list
		toVisit.add(firstNode);
		
		// While there are unvisited nodes (i.e. the graph may not be connected)
		while (!unvisited.isEmpty()) {
			
			// If no more nodes to visit, then it's not connected
			if (toVisit.isEmpty()) {
				return false;
			} else {
				// Get first to visit (removing from the list)
				Node visiting = toVisit.remove(0);
				// Remove it from unvisited
				unvisited.remove(visiting);
				// Add every adjacent unvisited dominating node (if not already added)
				for (Node node : visiting.getAdjacentNodes()) {
					if (node.isDominating() && unvisited.contains(node) && !toVisit.contains(node)) {
						toVisit.add(node);
					}
				}
			}
		}

		// If all have been visited, it's a connected graph
		return true;
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
			case GraphdomPackage.GRAPH___IS_TOTALLY_DOMINATED:
				return isTotallyDominated();
			case GraphdomPackage.GRAPH___IS_INDEPENDENTLY_DOMINATED:
				return isIndependentlyDominated();
			case GraphdomPackage.GRAPH___IS_CONNECTED_DOMINATION:
				return isConnectedDomination();
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

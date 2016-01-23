/**
 */
package graphdom.impl;

import graphdom.Edge;
import graphdom.GraphdomPackage;
import graphdom.Node;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link graphdom.impl.NodeImpl#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link graphdom.impl.NodeImpl#getColor <em>Color</em>}</li>
 *   <li>{@link graphdom.impl.NodeImpl#getConnectedEdges <em>Connected Edges</em>}</li>
 *   <li>{@link graphdom.impl.NodeImpl#isDominating <em>Dominating</em>}</li>
 *   <li>{@link graphdom.impl.NodeImpl#getGrade <em>Grade</em>}</li>
 *   <li>{@link graphdom.impl.NodeImpl#getGuid <em>Guid</em>}</li>
 *   <li>{@link graphdom.impl.NodeImpl#getXCoord <em>XCoord</em>}</li>
 *   <li>{@link graphdom.impl.NodeImpl#getYCoord <em>YCoord</em>}</li>
 *   <li>{@link graphdom.impl.NodeImpl#isDominated <em>Dominated</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends MinimalEObjectImpl.Container implements Node {

	/**
	 * The default value of the '{@link #getNodeName() <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeName() <em>Node Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected String nodeName = NODE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected static final String COLOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getColor()
	 * @generated
	 * @ordered
	 */
	protected String color = COLOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectedEdges() <em>Connected Edges</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getConnectedEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> connectedEdges;

	/**
	 * The default value of the '{@link #isDominating() <em>Dominating</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDominating()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DOMINATING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDominating() <em>Dominating</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDominating()
	 * @generated
	 * @ordered
	 */
	protected boolean dominating = DOMINATING_EDEFAULT;

	/**
	 * The default value of the '{@link #getGrade() <em>Grade</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGrade()
	 * @generated
	 * @ordered
	 */
	protected static final long GRADE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getGrade() <em>Grade</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGrade()
	 * @generated
	 * @ordered
	 */
	protected long grade = GRADE_EDEFAULT;

	/**
	 * The default value of the '{@link #getGuid() <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGuid()
	 * @generated
	 * @ordered
	 */
	protected static final String GUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGuid() <em>Guid</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGuid()
	 * @generated
	 * @ordered
	 */
	protected String guid = GUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getXCoord() <em>XCoord</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXCoord()
	 * @generated
	 * @ordered
	 */
	protected static final int XCOORD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getXCoord() <em>XCoord</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXCoord()
	 * @generated
	 * @ordered
	 */
	protected int xCoord = XCOORD_EDEFAULT;

	/**
	 * The default value of the '{@link #getYCoord() <em>YCoord</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getYCoord()
	 * @generated
	 * @ordered
	 */
	protected static final int YCOORD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getYCoord() <em>YCoord</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getYCoord()
	 * @generated
	 * @ordered
	 */
	protected int yCoord = YCOORD_EDEFAULT;

	/**
	 * The default value of the '{@link #isDominated() <em>Dominated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDominated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DOMINATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDominated() <em>Dominated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDominated()
	 * @generated
	 * @ordered
	 */
	protected boolean dominated = DOMINATED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphdomPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeName(String newNodeName) {
		String oldNodeName = nodeName;
		nodeName = newNodeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.NODE__NODE_NAME, oldNodeName, nodeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getColor() {
		return color;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setColor(String newColor) {
		String oldColor = color;
		color = newColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.NODE__COLOR, oldColor, color));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getConnectedEdges() {
		if (connectedEdges == null) {
			connectedEdges = new EObjectWithInverseResolvingEList.ManyInverse<Edge>(Edge.class, this, GraphdomPackage.NODE__CONNECTED_EDGES, GraphdomPackage.EDGE__CONNECTED_NODES);
		}
		return connectedEdges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDominating() {
		return dominating;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setDominating(boolean newDominating) {
		boolean oldDominating = dominating;
		dominating = newDominating;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.NODE__DOMINATING, oldDominating,
					dominating));

		if (newDominating) {
			
			// If activating domination, all adjacent nodes become dominated
			for (Node node : this.getAdjacentNodes()) {
				node.setDominated(true);
			}
		} else {
			
			// If deactivating domination, all adjacent nodes MAY become non-dominated
			for (Node node : this.getAdjacentNodes()) {
				boolean newDominatedState = false;	
				for (Node adjacent : node.getAdjacentNodes()){
					if (adjacent.isDominating()){
						newDominatedState=true;
						break;
					}
				}
				node.setDominated(newDominatedState);
			}
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public long getGrade() {
		return getConnectedEdges().size();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrade(long newGrade) {
		long oldGrade = grade;
		grade = newGrade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.NODE__GRADE, oldGrade, grade));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGuid() {
		return guid;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuid(String newGuid) {
		String oldGuid = guid;
		guid = newGuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.NODE__GUID, oldGuid, guid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getXCoord() {
		return xCoord;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setXCoord(int newXCoord) {
		int oldXCoord = xCoord;
		xCoord = newXCoord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.NODE__XCOORD, oldXCoord, xCoord));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getYCoord() {
		return yCoord;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setYCoord(int newYCoord) {
		int oldYCoord = yCoord;
		yCoord = newYCoord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.NODE__YCOORD, oldYCoord, yCoord));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDominated() {
		return dominated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDominated(boolean newDominated) {
		boolean oldDominated = dominated;
		dominated = newDominated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.NODE__DOMINATED, oldDominated, dominated));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Node> getAdjacentNodes() {

		// Ensure that you remove @generated or mark it @generated NOT

		HashSet<Node> adjacentNodesSet = new HashSet<Node>();

		for (Edge edge : this.getConnectedEdges()) {
			adjacentNodesSet.addAll(edge.getConnectedNodes());
		}
		adjacentNodesSet.remove(this);		

		EList<Node> adjacentNodes = new BasicEList<Node>(adjacentNodesSet);
		
		return adjacentNodes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphdomPackage.NODE__CONNECTED_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectedEdges()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphdomPackage.NODE__CONNECTED_EDGES:
				return ((InternalEList<?>)getConnectedEdges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphdomPackage.NODE__NODE_NAME:
				return getNodeName();
			case GraphdomPackage.NODE__COLOR:
				return getColor();
			case GraphdomPackage.NODE__CONNECTED_EDGES:
				return getConnectedEdges();
			case GraphdomPackage.NODE__DOMINATING:
				return isDominating();
			case GraphdomPackage.NODE__GRADE:
				return getGrade();
			case GraphdomPackage.NODE__GUID:
				return getGuid();
			case GraphdomPackage.NODE__XCOORD:
				return getXCoord();
			case GraphdomPackage.NODE__YCOORD:
				return getYCoord();
			case GraphdomPackage.NODE__DOMINATED:
				return isDominated();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphdomPackage.NODE__NODE_NAME:
				setNodeName((String)newValue);
				return;
			case GraphdomPackage.NODE__COLOR:
				setColor((String)newValue);
				return;
			case GraphdomPackage.NODE__CONNECTED_EDGES:
				getConnectedEdges().clear();
				getConnectedEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case GraphdomPackage.NODE__DOMINATING:
				setDominating((Boolean)newValue);
				return;
			case GraphdomPackage.NODE__GRADE:
				setGrade((Long)newValue);
				return;
			case GraphdomPackage.NODE__GUID:
				setGuid((String)newValue);
				return;
			case GraphdomPackage.NODE__XCOORD:
				setXCoord((Integer)newValue);
				return;
			case GraphdomPackage.NODE__YCOORD:
				setYCoord((Integer)newValue);
				return;
			case GraphdomPackage.NODE__DOMINATED:
				setDominated((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphdomPackage.NODE__NODE_NAME:
				setNodeName(NODE_NAME_EDEFAULT);
				return;
			case GraphdomPackage.NODE__COLOR:
				setColor(COLOR_EDEFAULT);
				return;
			case GraphdomPackage.NODE__CONNECTED_EDGES:
				getConnectedEdges().clear();
				return;
			case GraphdomPackage.NODE__DOMINATING:
				setDominating(DOMINATING_EDEFAULT);
				return;
			case GraphdomPackage.NODE__GRADE:
				setGrade(GRADE_EDEFAULT);
				return;
			case GraphdomPackage.NODE__GUID:
				setGuid(GUID_EDEFAULT);
				return;
			case GraphdomPackage.NODE__XCOORD:
				setXCoord(XCOORD_EDEFAULT);
				return;
			case GraphdomPackage.NODE__YCOORD:
				setYCoord(YCOORD_EDEFAULT);
				return;
			case GraphdomPackage.NODE__DOMINATED:
				setDominated(DOMINATED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphdomPackage.NODE__NODE_NAME:
				return NODE_NAME_EDEFAULT == null ? nodeName != null : !NODE_NAME_EDEFAULT.equals(nodeName);
			case GraphdomPackage.NODE__COLOR:
				return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals(color);
			case GraphdomPackage.NODE__CONNECTED_EDGES:
				return connectedEdges != null && !connectedEdges.isEmpty();
			case GraphdomPackage.NODE__DOMINATING:
				return dominating != DOMINATING_EDEFAULT;
			case GraphdomPackage.NODE__GRADE:
				return grade != GRADE_EDEFAULT;
			case GraphdomPackage.NODE__GUID:
				return GUID_EDEFAULT == null ? guid != null : !GUID_EDEFAULT.equals(guid);
			case GraphdomPackage.NODE__XCOORD:
				return xCoord != XCOORD_EDEFAULT;
			case GraphdomPackage.NODE__YCOORD:
				return yCoord != YCOORD_EDEFAULT;
			case GraphdomPackage.NODE__DOMINATED:
				return dominated != DOMINATED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GraphdomPackage.NODE___GET_ADJACENT_NODES:
				return getAdjacentNodes();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (nodeName: ");
		result.append(nodeName);
		result.append(", color: ");
		result.append(color);
		result.append(", dominating: ");
		result.append(dominating);
		result.append(", grade: ");
		result.append(grade);
		result.append(", guid: ");
		result.append(guid);
		result.append(", xCoord: ");
		result.append(xCoord);
		result.append(", yCoord: ");
		result.append(yCoord);
		result.append(", dominated: ");
		result.append(dominated);
		result.append(')');
		return result.toString();
	}

} // NodeImpl

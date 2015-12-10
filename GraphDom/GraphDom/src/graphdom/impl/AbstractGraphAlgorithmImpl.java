/**
 */
package graphdom.impl;

import graphdom.AbstractGraphAlgorithm;
import graphdom.AlgorithmStatus;
import graphdom.Graph;
import graphdom.GraphdomPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Graph Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link graphdom.impl.AbstractGraphAlgorithmImpl#getInitialGraph <em>Initial Graph</em>}</li>
 *   <li>{@link graphdom.impl.AbstractGraphAlgorithmImpl#getProcessedGraph <em>Processed Graph</em>}</li>
 *   <li>{@link graphdom.impl.AbstractGraphAlgorithmImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractGraphAlgorithmImpl extends MinimalEObjectImpl.Container implements AbstractGraphAlgorithm {
	/**
	 * The cached value of the '{@link #getInitialGraph() <em>Initial Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph initialGraph;

	/**
	 * The cached value of the '{@link #getProcessedGraph() <em>Processed Graph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessedGraph()
	 * @generated
	 * @ordered
	 */
	protected Graph processedGraph;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final AlgorithmStatus STATUS_EDEFAULT = AlgorithmStatus.UNINITIALIZED;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected AlgorithmStatus status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractGraphAlgorithmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphdomPackage.Literals.ABSTRACT_GRAPH_ALGORITHM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getInitialGraph() {
		if (initialGraph != null && initialGraph.eIsProxy()) {
			InternalEObject oldInitialGraph = (InternalEObject)initialGraph;
			initialGraph = (Graph)eResolveProxy(oldInitialGraph);
			if (initialGraph != oldInitialGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__INITIAL_GRAPH, oldInitialGraph, initialGraph));
			}
		}
		return initialGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetInitialGraph() {
		return initialGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialGraph(Graph newInitialGraph) {
		Graph oldInitialGraph = initialGraph;
		initialGraph = newInitialGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__INITIAL_GRAPH, oldInitialGraph, initialGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getProcessedGraph() {
		if (processedGraph != null && processedGraph.eIsProxy()) {
			InternalEObject oldProcessedGraph = (InternalEObject)processedGraph;
			processedGraph = (Graph)eResolveProxy(oldProcessedGraph);
			if (processedGraph != oldProcessedGraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__PROCESSED_GRAPH, oldProcessedGraph, processedGraph));
			}
		}
		return processedGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph basicGetProcessedGraph() {
		return processedGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessedGraph(Graph newProcessedGraph) {
		Graph oldProcessedGraph = processedGraph;
		processedGraph = newProcessedGraph;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__PROCESSED_GRAPH, oldProcessedGraph, processedGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgorithmStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(AlgorithmStatus newStatus) {
		AlgorithmStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void runToEnd() {
		while (!getStatus().equals(AlgorithmStatus.ENDED)){
			nextStep();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void nextStep();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__INITIAL_GRAPH:
				if (resolve) return getInitialGraph();
				return basicGetInitialGraph();
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__PROCESSED_GRAPH:
				if (resolve) return getProcessedGraph();
				return basicGetProcessedGraph();
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__STATUS:
				return getStatus();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__INITIAL_GRAPH:
				setInitialGraph((Graph)newValue);
				return;
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__PROCESSED_GRAPH:
				setProcessedGraph((Graph)newValue);
				return;
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__STATUS:
				setStatus((AlgorithmStatus)newValue);
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
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__INITIAL_GRAPH:
				setInitialGraph((Graph)null);
				return;
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__PROCESSED_GRAPH:
				setProcessedGraph((Graph)null);
				return;
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__INITIAL_GRAPH:
				return initialGraph != null;
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__PROCESSED_GRAPH:
				return processedGraph != null;
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM__STATUS:
				return status != STATUS_EDEFAULT;
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
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM___RUN_TO_END:
				runToEnd();
				return null;
			case GraphdomPackage.ABSTRACT_GRAPH_ALGORITHM___NEXT_STEP:
				nextStep();
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
		result.append(" (status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //AbstractGraphAlgorithmImpl

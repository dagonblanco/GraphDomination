/**
 */
package graphdom;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see graphdom.GraphdomFactory
 * @model kind="package"
 * @generated
 */
public interface GraphdomPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphdom";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://es/upm/fi/dma/graphdom";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "es.upm.fi.dma.graphdom";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphdomPackage eINSTANCE = graphdom.impl.GraphdomPackageImpl.init();

	/**
	 * The meta object id for the '{@link graphdom.impl.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see graphdom.impl.GraphImpl
	 * @see graphdom.impl.GraphdomPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Graph Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__GRAPH_NAME = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = 1;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__EDGES = 2;

	/**
	 * The feature id for the '<em><b>Next Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NEXT_NODE_ID = 3;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Find Node By Id</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH___FIND_NODE_BY_ID__STRING = 0;

	/**
	 * The number of operations of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link graphdom.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see graphdom.impl.NodeImpl
	 * @see graphdom.impl.GraphdomPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 1;

	/**
	 * The feature id for the '<em><b>Node Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NODE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__COLOR = 1;

	/**
	 * The feature id for the '<em><b>Connected Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CONNECTED_EDGES = 2;

	/**
	 * The feature id for the '<em><b>Marked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__MARKED = 3;

	/**
	 * The feature id for the '<em><b>Grade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GRADE = 4;

	/**
	 * The feature id for the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GUID = 5;

	/**
	 * The feature id for the '<em><b>XCoord</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__XCOORD = 6;

	/**
	 * The feature id for the '<em><b>YCoord</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__YCOORD = 7;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 8;

	/**
	 * The operation id for the '<em>Get Adjacent Nodes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE___GET_ADJACENT_NODES = 0;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link graphdom.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see graphdom.impl.EdgeImpl
	 * @see graphdom.impl.GraphdomPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 2;

	/**
	 * The feature id for the '<em><b>Connected Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__CONNECTED_NODES = 0;

	/**
	 * The feature id for the '<em><b>Marked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__MARKED = 1;

	/**
	 * The feature id for the '<em><b>Guid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__GUID = 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__WEIGHT = 3;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link graphdom.impl.AbstractGraphAlgorithmImpl <em>Abstract Graph Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see graphdom.impl.AbstractGraphAlgorithmImpl
	 * @see graphdom.impl.GraphdomPackageImpl#getAbstractGraphAlgorithm()
	 * @generated
	 */
	int ABSTRACT_GRAPH_ALGORITHM = 3;

	/**
	 * The feature id for the '<em><b>Initial Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPH_ALGORITHM__INITIAL_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Processed Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPH_ALGORITHM__PROCESSED_GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPH_ALGORITHM__STATUS = 2;

	/**
	 * The number of structural features of the '<em>Abstract Graph Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPH_ALGORITHM_FEATURE_COUNT = 3;

	/**
	 * The operation id for the '<em>Run To End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPH_ALGORITHM___RUN_TO_END = 0;

	/**
	 * The operation id for the '<em>Next Step</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPH_ALGORITHM___NEXT_STEP = 1;

	/**
	 * The number of operations of the '<em>Abstract Graph Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_GRAPH_ALGORITHM_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link graphdom.AlgorithmStatus <em>Algorithm Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see graphdom.AlgorithmStatus
	 * @see graphdom.impl.GraphdomPackageImpl#getAlgorithmStatus()
	 * @generated
	 */
	int ALGORITHM_STATUS = 4;


	/**
	 * Returns the meta object for class '{@link graphdom.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see graphdom.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Graph#getGraphName <em>Graph Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Graph Name</em>'.
	 * @see graphdom.Graph#getGraphName()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_GraphName();

	/**
	 * Returns the meta object for the containment reference list '{@link graphdom.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see graphdom.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link graphdom.Graph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see graphdom.Graph#getEdges()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Edges();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Graph#getNextNodeId <em>Next Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Next Node Id</em>'.
	 * @see graphdom.Graph#getNextNodeId()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_NextNodeId();

	/**
	 * Returns the meta object for the '{@link graphdom.Graph#findNodeById(java.lang.String) <em>Find Node By Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Node By Id</em>' operation.
	 * @see graphdom.Graph#findNodeById(java.lang.String)
	 * @generated
	 */
	EOperation getGraph__FindNodeById__String();

	/**
	 * Returns the meta object for class '{@link graphdom.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see graphdom.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Node#getNodeName <em>Node Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Name</em>'.
	 * @see graphdom.Node#getNodeName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_NodeName();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Node#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see graphdom.Node#getColor()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Color();

	/**
	 * Returns the meta object for the reference list '{@link graphdom.Node#getConnectedEdges <em>Connected Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connected Edges</em>'.
	 * @see graphdom.Node#getConnectedEdges()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_ConnectedEdges();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Node#isMarked <em>Marked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Marked</em>'.
	 * @see graphdom.Node#isMarked()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Marked();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Node#getGrade <em>Grade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grade</em>'.
	 * @see graphdom.Node#getGrade()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Grade();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Node#getGuid <em>Guid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid</em>'.
	 * @see graphdom.Node#getGuid()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Guid();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Node#getXCoord <em>XCoord</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>XCoord</em>'.
	 * @see graphdom.Node#getXCoord()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_XCoord();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Node#getYCoord <em>YCoord</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>YCoord</em>'.
	 * @see graphdom.Node#getYCoord()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_YCoord();

	/**
	 * Returns the meta object for the '{@link graphdom.Node#getAdjacentNodes() <em>Get Adjacent Nodes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Adjacent Nodes</em>' operation.
	 * @see graphdom.Node#getAdjacentNodes()
	 * @generated
	 */
	EOperation getNode__GetAdjacentNodes();

	/**
	 * Returns the meta object for class '{@link graphdom.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see graphdom.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference list '{@link graphdom.Edge#getConnectedNodes <em>Connected Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Connected Nodes</em>'.
	 * @see graphdom.Edge#getConnectedNodes()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_ConnectedNodes();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Edge#isMarked <em>Marked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Marked</em>'.
	 * @see graphdom.Edge#isMarked()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Marked();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Edge#getGuid <em>Guid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guid</em>'.
	 * @see graphdom.Edge#getGuid()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Guid();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.Edge#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see graphdom.Edge#getWeight()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Weight();

	/**
	 * Returns the meta object for class '{@link graphdom.AbstractGraphAlgorithm <em>Abstract Graph Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Graph Algorithm</em>'.
	 * @see graphdom.AbstractGraphAlgorithm
	 * @generated
	 */
	EClass getAbstractGraphAlgorithm();

	/**
	 * Returns the meta object for the reference '{@link graphdom.AbstractGraphAlgorithm#getInitialGraph <em>Initial Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial Graph</em>'.
	 * @see graphdom.AbstractGraphAlgorithm#getInitialGraph()
	 * @see #getAbstractGraphAlgorithm()
	 * @generated
	 */
	EReference getAbstractGraphAlgorithm_InitialGraph();

	/**
	 * Returns the meta object for the reference '{@link graphdom.AbstractGraphAlgorithm#getProcessedGraph <em>Processed Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processed Graph</em>'.
	 * @see graphdom.AbstractGraphAlgorithm#getProcessedGraph()
	 * @see #getAbstractGraphAlgorithm()
	 * @generated
	 */
	EReference getAbstractGraphAlgorithm_ProcessedGraph();

	/**
	 * Returns the meta object for the attribute '{@link graphdom.AbstractGraphAlgorithm#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see graphdom.AbstractGraphAlgorithm#getStatus()
	 * @see #getAbstractGraphAlgorithm()
	 * @generated
	 */
	EAttribute getAbstractGraphAlgorithm_Status();

	/**
	 * Returns the meta object for the '{@link graphdom.AbstractGraphAlgorithm#runToEnd() <em>Run To End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Run To End</em>' operation.
	 * @see graphdom.AbstractGraphAlgorithm#runToEnd()
	 * @generated
	 */
	EOperation getAbstractGraphAlgorithm__RunToEnd();

	/**
	 * Returns the meta object for the '{@link graphdom.AbstractGraphAlgorithm#nextStep() <em>Next Step</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Next Step</em>' operation.
	 * @see graphdom.AbstractGraphAlgorithm#nextStep()
	 * @generated
	 */
	EOperation getAbstractGraphAlgorithm__NextStep();

	/**
	 * Returns the meta object for enum '{@link graphdom.AlgorithmStatus <em>Algorithm Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Algorithm Status</em>'.
	 * @see graphdom.AlgorithmStatus
	 * @generated
	 */
	EEnum getAlgorithmStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphdomFactory getGraphdomFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link graphdom.impl.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see graphdom.impl.GraphImpl
		 * @see graphdom.impl.GraphdomPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Graph Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__GRAPH_NAME = eINSTANCE.getGraph_GraphName();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
		 * The meta object literal for the '<em><b>Next Node Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__NEXT_NODE_ID = eINSTANCE.getGraph_NextNodeId();

		/**
		 * The meta object literal for the '<em><b>Find Node By Id</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GRAPH___FIND_NODE_BY_ID__STRING = eINSTANCE.getGraph__FindNodeById__String();

		/**
		 * The meta object literal for the '{@link graphdom.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see graphdom.impl.NodeImpl
		 * @see graphdom.impl.GraphdomPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Node Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NODE_NAME = eINSTANCE.getNode_NodeName();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__COLOR = eINSTANCE.getNode_Color();

		/**
		 * The meta object literal for the '<em><b>Connected Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CONNECTED_EDGES = eINSTANCE.getNode_ConnectedEdges();

		/**
		 * The meta object literal for the '<em><b>Marked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__MARKED = eINSTANCE.getNode_Marked();

		/**
		 * The meta object literal for the '<em><b>Grade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__GRADE = eINSTANCE.getNode_Grade();

		/**
		 * The meta object literal for the '<em><b>Guid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__GUID = eINSTANCE.getNode_Guid();

		/**
		 * The meta object literal for the '<em><b>XCoord</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__XCOORD = eINSTANCE.getNode_XCoord();

		/**
		 * The meta object literal for the '<em><b>YCoord</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__YCOORD = eINSTANCE.getNode_YCoord();

		/**
		 * The meta object literal for the '<em><b>Get Adjacent Nodes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE___GET_ADJACENT_NODES = eINSTANCE.getNode__GetAdjacentNodes();

		/**
		 * The meta object literal for the '{@link graphdom.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see graphdom.impl.EdgeImpl
		 * @see graphdom.impl.GraphdomPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Connected Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__CONNECTED_NODES = eINSTANCE.getEdge_ConnectedNodes();

		/**
		 * The meta object literal for the '<em><b>Marked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__MARKED = eINSTANCE.getEdge_Marked();

		/**
		 * The meta object literal for the '<em><b>Guid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__GUID = eINSTANCE.getEdge_Guid();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__WEIGHT = eINSTANCE.getEdge_Weight();

		/**
		 * The meta object literal for the '{@link graphdom.impl.AbstractGraphAlgorithmImpl <em>Abstract Graph Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see graphdom.impl.AbstractGraphAlgorithmImpl
		 * @see graphdom.impl.GraphdomPackageImpl#getAbstractGraphAlgorithm()
		 * @generated
		 */
		EClass ABSTRACT_GRAPH_ALGORITHM = eINSTANCE.getAbstractGraphAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Initial Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GRAPH_ALGORITHM__INITIAL_GRAPH = eINSTANCE.getAbstractGraphAlgorithm_InitialGraph();

		/**
		 * The meta object literal for the '<em><b>Processed Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_GRAPH_ALGORITHM__PROCESSED_GRAPH = eINSTANCE.getAbstractGraphAlgorithm_ProcessedGraph();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_GRAPH_ALGORITHM__STATUS = eINSTANCE.getAbstractGraphAlgorithm_Status();

		/**
		 * The meta object literal for the '<em><b>Run To End</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_GRAPH_ALGORITHM___RUN_TO_END = eINSTANCE.getAbstractGraphAlgorithm__RunToEnd();

		/**
		 * The meta object literal for the '<em><b>Next Step</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_GRAPH_ALGORITHM___NEXT_STEP = eINSTANCE.getAbstractGraphAlgorithm__NextStep();

		/**
		 * The meta object literal for the '{@link graphdom.AlgorithmStatus <em>Algorithm Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see graphdom.AlgorithmStatus
		 * @see graphdom.impl.GraphdomPackageImpl#getAlgorithmStatus()
		 * @generated
		 */
		EEnum ALGORITHM_STATUS = eINSTANCE.getAlgorithmStatus();

	}

} //GraphdomPackage

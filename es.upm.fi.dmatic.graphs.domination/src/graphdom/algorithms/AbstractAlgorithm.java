/**
 */
package graphdom.algorithms;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.GraphdomFactory;
import graphdom.Node;

/**
 * An implementation of the model object '<em><b>Abstract Graph Algorithm</b></em>'.
 */
public abstract class AbstractAlgorithm implements GraphAlgorithm {

	private static final AlgorithmStatus STATUS_DEFAULT = AlgorithmStatus.UNINITIALIZED;

	/**
	 */
	private Graph graph;


	/**
	 */
	protected AlgorithmStatus status = STATUS_DEFAULT;

	/**
	 */
	protected AbstractAlgorithm() {
		super();
	}

	/**
	 */
	protected AbstractAlgorithm(Graph graph) {
		super();
		this.graph = graph;

	}

	public Graph getGraph() {
		return graph;
	}

	/**
	 * 
	 */
	@Override
	public AlgorithmStatus getStatus() {
		return status;
	}

	/**
	 * 
	 */
	@Override
	public void setStatus(AlgorithmStatus newStatus) {
		status = newStatus == null ? STATUS_DEFAULT : newStatus;
	}

	/**
	 * 
	 */
	@Override
	public void runToEnd() {
		while (!getStatus().equals(AlgorithmStatus.ENDED)){
			nextStep();
		}
	}
	
	/**
	 */
	protected final void createEdge(Node source, Node target) {

		Edge myEdge = GraphdomFactory.eINSTANCE.createEdge();

		myEdge.getConnectedNodes().add(source);
		myEdge.getConnectedNodes().add(target);

		graph.getEdges().add(myEdge);

	}

	@Override
	public void initialize(Graph graph) {
		this.graph = graph;
		if (graph != null) {
			// Switch status from uninitialized
			setStatus(AlgorithmStatus.INPROGRESS);
		}
	}
} //AbstractGraphAlgorithmImpl

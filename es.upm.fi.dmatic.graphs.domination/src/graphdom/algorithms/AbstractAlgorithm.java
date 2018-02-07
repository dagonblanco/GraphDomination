/**
 */
package graphdom.algorithms;

import java.util.Random;

import org.eclipse.emf.ecore.util.EcoreUtil;

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

	private Random rnd = new Random();

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

	@Override
	public StatisticsResults runStatistics(StatisticsInfo info) {

		StatisticsResults results = new StatisticsResults();
		
		int maxDominationNumber = 0;
		int minDominationNumber = Integer.MAX_VALUE;
		int sumOfDominationNumbers = 0;

		// For each iteration...
		for (int i = 0; i < info.getExecutionNumber(); i++) {
			
			// Clone the graph
			Graph currentGraph = EcoreUtil.copy(getGraph());

			// Run the flips
			doSomeFlips(currentGraph, info.getFlipsNumber());

			// Run the algorithm
			initialize(currentGraph);
			runToEnd();

			// Extract information and add to results
			int dominatingSetSize = currentGraph.getDominatingSet().size();
			if (dominatingSetSize > maxDominationNumber) {
				// Found max
				maxDominationNumber = dominatingSetSize;
			}
			if (dominatingSetSize < minDominationNumber) {
				// Found min
				minDominationNumber = dominatingSetSize;
			}
			sumOfDominationNumbers += dominatingSetSize;

		}
		
		// Calculate statistics

		results.setAverageDominationNumber((double) sumOfDominationNumbers / (double) info.getExecutionNumber());
		results.setMaxDominationNumber(maxDominationNumber);
		results.setMinDominationNumber(minDominationNumber);

		return results;
	}

	private void doSomeFlips(Graph currentGraph, int flipsNumber) {

		int flipsDone = 0;
		int maxRetries = 10;

		while (flipsDone < flipsNumber) {
			// Maybe flip me
			boolean flipped = false;
			int retries = 0;

			// Avoid endless loop
			while (!flipped && (retries < maxRetries)) {
				// Choose edge
				int rand = rnd.nextInt(currentGraph.getEdges().size());
				Edge currentEdge = currentGraph.getEdges().get(rand);

				if (currentEdge.flip()) {
					flipped = true;
					flipsDone++;
				} else {
					retries++;
				}
			}
		}

	}
} //AbstractGraphAlgorithmImpl

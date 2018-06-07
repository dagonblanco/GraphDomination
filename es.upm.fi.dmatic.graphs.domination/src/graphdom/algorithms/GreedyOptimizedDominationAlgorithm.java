package graphdom.algorithms;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import graphdom.Graph;
import graphdom.Node;
import graphdom.util.Utils;

public class GreedyOptimizedDominationAlgorithm extends AbstractAlgorithm {

	EList<Node> dominatingNodes = new BasicEList<>();
	
	public GreedyOptimizedDominationAlgorithm() {
		super();
	}

	public GreedyOptimizedDominationAlgorithm(Graph graph) {
		super(graph);
		initialize(graph);
	}

	@Override
	public void nextStep() {		
		
		// Search node with highest number of undominated neighbours
		Node maxNode = Utils.findHighestUndominatedUndominatingGradeNode(getGraph().getNodes());

		maxNode.setDominating(true);

		if (getGraph().isDominated()) {
			setStatus(AlgorithmStatus.ENDED);
		}

	}

	@Override
	public String getName() {

		return "Greedy Optimized Domination";
	}

	@Override
	public void initialize(Graph graph) {
		super.initialize(graph);
		if (graph != null) {

			// Unmark all of its nodes, so we can mark the dominating ones
			getGraph().unmarkAllNodes();

			// Switch status from uninitialized
			setStatus(AlgorithmStatus.INPROGRESS);
		}

	}

}

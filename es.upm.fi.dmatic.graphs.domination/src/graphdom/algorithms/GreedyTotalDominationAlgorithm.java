package graphdom.algorithms;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import graphdom.Graph;
import graphdom.Node;
import graphdom.util.Utils;

public class GreedyTotalDominationAlgorithm extends AbstractAlgorithm {

	EList<Node> dominatingNodes = new BasicEList<>();
	
	public GreedyTotalDominationAlgorithm() {
		super();
	}

	public GreedyTotalDominationAlgorithm(Graph graph) {
		super(graph);
		initialize(graph);
	}

	@Override
	public void nextStep() {		
		
		// Search node with highest number of undominated neighbours
		Node maxNode = Utils.findHighestUndominatedGradeNode(getGraph().getNodes());

		maxNode.setDominating(true);

		if (getGraph().isTotallyDominated()) {
			setStatus(AlgorithmStatus.ENDED);
		}

	}

	@Override
	public String getName() {

		return "Greedy Total Domination";
	}

}

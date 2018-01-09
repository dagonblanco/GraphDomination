package graphdom.algorithms;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import graphdom.Graph;
import graphdom.Node;
import graphdom.util.Utils;

public class GreedyCompleteDominationAlgorithm extends AbstractAlgorithm {

	EList<Node> dominatingNodes = new BasicEList<Node>();
	
	public GreedyCompleteDominationAlgorithm(Graph graph) {
		super(graph);
		
		// Unmark all of its nodes, so we can mark the dominating ones
		getGraph().unmarkAllNodes();
		
		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {		
		
		// Search highest-grade node		
		Node maxNode = Utils.findHighestUndominatedGradeNode(getGraph().getNodes());
		
		// If maxNode has 0 undominated neighbours, we have finished
		if (Utils.findUndominatedGrade(maxNode) == 0) {
			setStatus(AlgorithmStatus.ENDED);
		} else {
			// Mark as dominating in graph
			maxNode.setDominating(true);
		}
				
		// Step ended
	}

	@Override
	public String getName() {

		return "Greedy Complete Domination";
	}

}

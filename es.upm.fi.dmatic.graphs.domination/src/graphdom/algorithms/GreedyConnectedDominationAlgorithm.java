package graphdom.algorithms;

import graphdom.Graph;
import graphdom.Node;
import graphdom.util.Utils;

public class GreedyConnectedDominationAlgorithm extends AbstractAlgorithm {
	
	public GreedyConnectedDominationAlgorithm(Graph graph) {
		super(graph);
		
		// Unmark all of its nodes, so we can mark the dominating ones
		getGraph().unmarkAllNodes();

		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {
		
		// Search highest-grade node		
		Node workingNode = Utils.findHighestGradeDominatedNode(getGraph().getNodes());
		if (workingNode==null){
			workingNode = Utils.findHighestGradeNode(getGraph().getNodes());
		}
		if (workingNode.isDominating()) {
			// We are looping, graph may not be connected, end algorithm
			setStatus(AlgorithmStatus.ENDED);
			return;
		}
		
		// Mark as dominating in real graph
		workingNode.setDominating(true);						
		
		// If no more nodes left, we have finished
		if (getGraph().isDominated()) {
			
			setStatus(AlgorithmStatus.ENDED);
		} 
		// Step ended
	}

}

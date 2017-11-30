package graphdom.algorithms;

import graphdom.AlgorithmStatus;
import graphdom.Graph;
import graphdom.Node;
import graphdom.impl.AbstractGraphAlgorithmImpl;
import graphdom.util.Utils;

public class GreedyConnectedDominationAlgorithm extends AbstractGraphAlgorithmImpl {
	
	@Override
	public void setInitialGraph(Graph newInitialGraph) {
		
		// Set graph to dominate
		super.setInitialGraph(newInitialGraph);

		// Unmark all of its nodes, so we can mark the dominating ones
		getInitialGraph().unmarkAllNodes();

		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {
		
		// Search highest-grade node		
		Node workingNode = Utils.findHighestGradeDominatedNode(getInitialGraph().getNodes());
		if (workingNode==null){
			workingNode = Utils.findHighestGradeNode(getInitialGraph().getNodes());
		}
		
		// Mark as dominating in real graph
		workingNode.setDominating(true);						
		
		// If no more nodes left, we have finished
		if (getInitialGraph().isDominated()){
			
			setStatus(AlgorithmStatus.ENDED);
		} 
		// Step ended
	}

}

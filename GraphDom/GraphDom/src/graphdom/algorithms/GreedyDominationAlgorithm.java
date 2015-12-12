package graphdom.algorithms;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import graphdom.Graph;
import graphdom.Node;
import graphdom.impl.AbstractGraphAlgorithmImpl;
import graphdom.util.Utils;

public class GreedyDominationAlgorithm extends AbstractGraphAlgorithmImpl {

	Graph workingGraph = null;
	
	@Override
	public void setInitialGraph(Graph newInitialGraph) {
		super.setInitialGraph(newInitialGraph);
		workingGraph = (Graph) EcoreUtil.copy(newInitialGraph);
	}

	@Override
	public void nextStep() {
		// TODO Auto-generated method stub
		
		// Search highest-grade node
		
		Node maxNode = Utils.findHighestGradeNode(workingGraph.getNodes());
		
		// Mark as part of domination
		processedGraph.getNodes().get(0).setMarked(true);
		
		
		// Remove node and connected nodes
		EList<Node> removeList = maxNode.getAdjacentNodes();
		
		for (Node node : removeList) {
			workingGraph.getNodes().remove(node);			
		}
		
		workingGraph.getNodes().remove(maxNode);
		
		// Step ended
	}

}

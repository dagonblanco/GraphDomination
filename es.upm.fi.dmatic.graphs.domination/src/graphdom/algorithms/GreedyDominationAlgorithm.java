package graphdom.algorithms;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import graphdom.Graph;
import graphdom.Node;
import graphdom.util.Utils;

public class GreedyDominationAlgorithm extends AbstractAlgorithm {

	Graph workingGraph = null;
	EList<Node> dominatingNodes = new BasicEList<Node>();
	
	public GreedyDominationAlgorithm(Graph graph) {
		super(graph);
		initialize(graph);

	}

	@Override
	public void nextStep() {		
		
		// Search highest-grade node		
		Node maxNode = Utils.findHighestGradeNode(workingGraph.getNodes());
		
		// Mark as dominating in real graph
		getGraph().findNodeById(maxNode.getGuid()).setDominating(true);
				
		// Remove node and connected (dominated) nodes from working graph
		EList<Node> removeList = maxNode.getAdjacentNodes();
		
		for (Node node : removeList) {
			workingGraph.getNodes().remove(node);			
		}
		
		workingGraph.getNodes().remove(maxNode);
		
		// If no more nodes left, we have finished
		if (workingGraph.getNodes().isEmpty()){
			
			setStatus(AlgorithmStatus.ENDED);
		}
				
		// Step ended
	}

	@Override
	public void initialize(Graph graph) {
		super.initialize(graph);
		// Unmark all of its nodes, so we can mark the dominating ones
		getGraph().unmarkAllNodes();

		// Get a working copy so we can delete nodes and change stuff
		workingGraph = EcoreUtil.copy(graph);

		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}
}

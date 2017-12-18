package graphdom.algorithms;

import graphdom.Graph;
import graphdom.Node;

public class FanTriangulationAlgorithm extends AbstractAlgorithm {

	int nodeNumber = 2;
	Node nodeZero=null; 
	

	public FanTriangulationAlgorithm(Graph graph) {

		super(graph);
		nodeZero = graph.getNodes().get(0);
		
		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {

		
		// If no more nodes left to connect, we have finished
		if (getGraph().getNodes().size() <= (nodeNumber + 1)) {
			setStatus(AlgorithmStatus.ENDED);
		}else{
			// Connect current node to node 0
			Node currentNode = getGraph().getNodes().get(nodeNumber);
			createEdge(nodeZero, currentNode);
			nodeNumber++;
		}
		
	}

}

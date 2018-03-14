package graphdom.algorithms;

import org.eclipse.emf.common.util.EList;

import graphdom.Graph;
import graphdom.Node;

public class FanTriangulationAlgorithm extends AbstractAlgorithm {

	int nodeNumber = 2;
	Node nodeZero=null; 
	EList<Node> nodeList;
	

	public FanTriangulationAlgorithm(Graph graph) {

		super(graph);
		nodeZero = graph.getNodes().get(0);
		nodeList = graph.getNodes();
		
		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	public FanTriangulationAlgorithm(Graph graph, Node initialNode, EList<Node> nodeList) {

		super(graph);
		nodeZero = initialNode;
		this.nodeList = nodeList;

		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {

		
		// If no more nodes left to connect, we have finished
		if (nodeList.size() <= (nodeNumber + 1)) {
			setStatus(AlgorithmStatus.ENDED);
		}else{
			// Connect current node to node 0
			Node currentNode = nodeList.get(nodeNumber);
			createEdge(nodeZero, currentNode);
			nodeNumber++;
		}
		
	}

}

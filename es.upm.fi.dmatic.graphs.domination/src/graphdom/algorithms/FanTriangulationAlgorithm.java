package graphdom.algorithms;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import graphdom.AlgorithmStatus;
import graphdom.Graph;
import graphdom.Node;
import graphdom.impl.AbstractGraphAlgorithmImpl;
import graphdom.util.GraphdomAdapterFactory;
import graphdom.util.Utils;

public class FanTriangulationAlgorithm extends AbstractGraphAlgorithmImpl {

	int nodeNumber = 2;
	Node nodeZero=null; 
	
	@Override
	public void setInitialGraph(Graph newInitialGraph) {
		
		// Set graph to dominate
		super.setInitialGraph(newInitialGraph);

		nodeZero = getInitialGraph().getNodes().get(0);	
		
		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {

		
		// If no more nodes left to connect, we have finished
		if (getInitialGraph().getNodes().size() <= (nodeNumber+1)){		
			setStatus(AlgorithmStatus.ENDED);
		}else{
			// Connect current node to node 0
			Node currentNode = getInitialGraph().getNodes().get(nodeNumber);			
			createEdge(nodeZero, currentNode);
			nodeNumber++;
		}
		
	}

}

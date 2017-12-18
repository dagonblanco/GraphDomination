package graphdom.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import graphdom.Graph;
import graphdom.Node;

public class ConvexHullAlgorithm extends AbstractAlgorithm {

	//Graph workingGraph = null;
	Stack<Node> hull = new Stack<Node>();
	EList<Node> dominatingNodes = new BasicEList<Node>();
	ArrayList<Node> sortedNodes = null;
	Node startNode = null;
	int nodeInProcess = 0;

	public ConvexHullAlgorithm(Graph graph) {
		
		super(graph);
		
		// Get a working copy so we can delete nodes and change stuff
		//workingGraph = (Graph) EcoreUtil.copy(newInitialGraph);
		sortedNodes = new ArrayList<Node>(graph.getNodes());
		
		if (sortedNodes.size() >= 3) {
		
		//Sort the nodes by Y coordinate
		Collections.sort(sortedNodes, new YCompare());
          
        
        
        // Get highest node as start node
        startNode = sortedNodes.get(0);
                
        sortedNodes.remove(0);
        
        // Sort the rest by polar order from start node
        Collections.sort(sortedNodes, new PolarOrder());
        
        //Push into hull start and second node (first in polar order)
        hull.push(startNode);
        hull.push(sortedNodes.get(0));
		
        //createEdge (startNode, sortedNodes.get(0));
        
        nodeInProcess=1;
        
		// Switch status from uninitialized
			setStatus(AlgorithmStatus.INPROGRESS);
		} else {
			
			setStatus(AlgorithmStatus.ENDED);
				
		}
	}



	@Override
	public void nextStep() {

			
		// If no more nodes left, we have finished
		if (nodeInProcess>=sortedNodes.size()){
			
			setStatus(AlgorithmStatus.ENDED);
			
			Node previousNode = startNode;
			while (!hull.isEmpty()) {
				Node currentNode = hull.pop();
				createEdge(previousNode, currentNode);
				previousNode = currentNode;				
			}
			
		} else {
			
			Node top = hull.pop();
            // could replace >= with > since no three collinear
            // could replace unnecessary popping/pushing with peekpeek()
            while (ccw(hull.peek(), top, sortedNodes.get(nodeInProcess)) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(sortedNodes.get(nodeInProcess));
            nodeInProcess++;                      
		}
				
		// Step ended
	}

	
	private boolean rightTurn(Node a, Node b, Node c)
    {
            return (b.getXCoord() - a.getXCoord())*(c.getYCoord() - a.getYCoord()) - (b.getYCoord() - a.getYCoord())*(c.getXCoord() - a.getXCoord()) > 0;
    }

    public static int ccw(Node a, Node b, Node c) {
        double area2 = (b.getXCoord()-a.getXCoord())*(c.getYCoord()-a.getYCoord()) - (b.getYCoord()-a.getYCoord())*(c.getXCoord()-a.getXCoord());
        if      (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else                return  0;
    }
    
    private class XCompare implements Comparator<Node>
    {
            @Override
            public int compare(Node o1, Node o2) 
            {
                    return (new Integer(o1.getXCoord())).compareTo(new Integer(o2.getXCoord()));
            }
    }
    
    private class YCompare implements Comparator<Node>
    {
            @Override
            public int compare(Node o1, Node o2) 
            {
                    return (new Integer(o1.getYCoord())).compareTo(new Integer(o2.getYCoord()));
            }
    }
    
 // compare other points relative to polar angle (between 0 and 2pi) they make with the start Node
    private class PolarOrder implements Comparator<Node> {
        @Override
		public int compare(Node q1, Node q2) {
            int dx1 = q1.getXCoord() - startNode.getXCoord();
            int dy1 = q1.getYCoord() - startNode.getYCoord();
            int dx2 = q2.getXCoord() - startNode.getXCoord();
            int dy2 = q2.getYCoord() - startNode.getYCoord();

            if      (dy1 >= 0 && dy2 < 0) return -1;    // q1 above; q2 below
            else if (dy2 >= 0 && dy1 < 0) return +1;    // q1 below; q2 above
            else if (dy1 == 0 && dy2 == 0) {            // 3-collinear and horizontal
                if      (dx1 >= 0 && dx2 < 0) return -1;
                else if (dx2 >= 0 && dx1 < 0) return +1;
                else                          return  0;
            }
            else return -ccw(startNode, q1, q2);     // both above or below
        }
    }
    
}

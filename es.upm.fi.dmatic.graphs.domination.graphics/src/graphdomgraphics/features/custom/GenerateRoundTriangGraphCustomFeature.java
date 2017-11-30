package graphdomgraphics.features.custom;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.Node;
import graphdom.algorithms.ConvexHullAlgorithm;
import graphdom.algorithms.FanTriangulationAlgorithm;
import graphdomgraphics.common.ExampleUtil;
import graphdomgraphics.features.AddEdgeConnectionFeature;
import graphdomgraphics.features.CreateEdgeConnectionFeature;
import graphdomgraphics.features.CreateNodeFeature;

public class GenerateRoundTriangGraphCustomFeature extends GraphdomAbstractCustomFeature {

	private static final int NODE_COUNT_FACTOR = 500;

	private static final int BASE_RADIUS = 50;

	private static final String TITLE = "Create round triangled graph";

	private static final String USER_QUESTION = "Enter number of nodes to create:";

	private boolean hasDoneChanges = false;

	public GenerateRoundTriangGraphCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Generate round triangled graph";
	}

	@Override
	public String getDescription() {
		return "Generate a round n-vertex triangled graph";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {

		// Ask user number of nodes

		String numberOfNodes = ExampleUtil.askString(TITLE, USER_QUESTION, "10");
		int nNodes = 0;
		try {
			nNodes = Integer.parseUnsignedInt(numberOfNodes);
		} catch (NumberFormatException e) {
			nNodes = 0;
		}

		double angleIncrement = 360.0 / nNodes;
		double circleRadius = BASE_RADIUS + (nNodes * NODE_COUNT_FACTOR / 100);
		double x = 0;
		double y = 0;

		CreateNodeFeature cnf = new CreateNodeFeature(getFeatureProvider());

		Node firstNode = null;
		Node currentNode = null;
		Node previousNode = null;

		for (int i = 0; i < nNodes; i++) {
			CreateContext cc = new CreateContext();
			x = (circleRadius * Math.cos((angleIncrement * i) * (Math.PI / 180)));
			y = (circleRadius * Math.sin((angleIncrement * i) * (Math.PI / 180)));

			cc.setTargetContainer(getDiagram());
			cc.setLocation(context.getX() + (int) x, context.getY() + (int) y);

			currentNode = (Node) cnf.create(cc)[0];

			
			if (i == 0) {
				// Save the first node (to connect it with the last one)
				firstNode = currentNode;
			} else {
				createEdge(currentNode, previousNode);
			}
			
			previousNode = currentNode;

		}
		
		if (firstNode != null && currentNode!=null && !firstNode.equals(currentNode)) {
			createEdge(currentNode, firstNode);
		}

		hasDoneChanges = nNodes > 0;
		
		// Now for the triangulation...
		
		// Access the graph
		Graph theGraph = ExampleUtil.getRootGraph(getDiagram());

		// Instance the related algorithm
		FanTriangulationAlgorithm gda = new FanTriangulationAlgorithm();

		// Initialize the algorithm with the graph
		gda.setInitialGraph(theGraph);

		// Run the algorithm to the end
		gda.runToEnd();

		// Model is modified now, with new edges

		updateEdges();
		
	}
	
	@Override
	public boolean hasDoneChanges() {
		return hasDoneChanges;
	}
}

package graphdomgraphics.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.GraphdomFactory;
import graphdom.Node;
import graphdomgraphics.common.GraphUtil;

public class CreateEdgeConnectionWithNodeFeature extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateEdgeConnectionWithNodeFeature(IFeatureProvider fp) {
		super(fp, "Edge and Node", "Creates a new connected Node");
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {

		return getBusinessObjectForPictogramElement(context.getSourcePictogramElement()) instanceof Node;

	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {

		Node source = getNode(context.getSourceAnchor());
		Node target = getNode(context.getTargetAnchor());

		if (source != null // Source must always exist
				&& (target == null // Create target...
						|| (target != null && source != target && !source.getAdjacentNodes().contains(target) // ...or
																												// connect
																												// target
		))) {
			return true;
		}

		return false;

	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;

		// get ENodes which should be connected
		Node source = getNode(context.getSourceAnchor());
		Node target = getNode(context.getTargetAnchor());
		ContainerShape addedShape = null;
		
		if (target == null) {
			
			// Create target node (domain object)

			target = GraphdomFactory.eINSTANCE.createNode();
			target.setNodeName(String.valueOf(GraphUtil.getRootGraph(getDiagram()).getNextNodeId()));
			target.setGuid(EcoreUtil.generateUUID());
			target.setXCoord(context.getTargetLocation().getX());
			target.setYCoord(context.getTargetLocation().getY());

			GraphUtil.getRootGraph(getDiagram()).getNodes().add(target);
			
			// Create shape
			AddContext ac = new AddContext();
			ac.setLocation(target.getXCoord(), target.getYCoord());
			ac.setNewObject(target);
			ac.setTargetContainer(getDiagram());
			 addedShape = (ContainerShape) getFeatureProvider().addIfPossible(ac);
		}

		// Link source and target
		if (source != null && target != null) {
			// create new business object
			Edge myEdge = createEdge(source, target);
			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(),
					(addedShape==null?context.getTargetAnchor():addedShape.getAnchors().get(0)));
			addContext.setNewObject(myEdge);
			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);

			// Add Edge to Diagram
			GraphUtil.getRootGraph(getDiagram()).getEdges().add(myEdge);
			updateGraph(GraphUtil.getRootGraph(getDiagram()));
		}

		return newConnection;
	}

	/**
	 * Returns the Node belonging to the anchor, or null if not available.
	 */
	private Node getNode(Anchor anchor) {
		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor.getParent());
			if (object instanceof Node) {
				return (Node) object;
			}
		}
		return null;
	}

	/**
	 * Creates a Edge between two Nodees.
	 */
	private Edge createEdge(Node source, Node target) {
		Edge myEdge = GraphdomFactory.eINSTANCE.createEdge();

		myEdge.getConnectedNodes().add(source);
		myEdge.getConnectedNodes().add(target);

		return myEdge;
	}

	private void updateGraph(Graph theGraph) {
		theGraph.checkNodesDomination();

		ILinkService linkserv = Graphiti.getLinkService();

		for (Node node : theGraph.getNodes()) {
			for (PictogramElement pe : linkserv.getPictogramElements(getDiagram(), node)) {
				updatePictogramElement(pe);
			}
		}

		for (Edge edge : theGraph.getEdges()) {
			for (PictogramElement pe : linkserv.getPictogramElements(getDiagram(), edge)) {
				updatePictogramElement(pe);
			}
		}
	}
}

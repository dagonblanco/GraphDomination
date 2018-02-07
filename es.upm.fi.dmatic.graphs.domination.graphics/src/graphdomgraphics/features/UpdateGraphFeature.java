package graphdomgraphics.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.DefaultUpdateDiagramFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.Node;
import graphdomgraphics.common.GraphUtil;
import graphdomgraphics.common.IColorConstants;

public class UpdateGraphFeature extends DefaultUpdateDiagramFeature {

	public UpdateGraphFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean update(IUpdateContext context) {
		updateAllNodes();
		updateAllEdges();
		return super.update(context);
	}

	@Override
	public void execute(IContext context) {
		super.execute(context);

		updateAllNodes();
		updateAllEdges();
		super.execute(context);
	}

	protected final void updateAllNodes() {

		// Access the graph
		Graph theGraph = GraphUtil.getRootGraph(getDiagram());

		// Model is modified now, with new edges

		// Get linkservice to ask for relations between DOs and PEs
		ILinkService linkserv = Graphiti.getLinkService();

		// Check the edges in the domain model
		for (Node node : theGraph.getNodes()) {

			for (PictogramElement pictogramElement : linkserv.getPictogramElements(getDiagram(), node)) {

				String businessName = node.getNodeName();
				boolean dominating = node.isDominating();
				boolean dominated = node.isDominated();

				// Set name and color in pictogram model
				if (pictogramElement instanceof ContainerShape) {
					ContainerShape cs = (ContainerShape) pictogramElement;
					if (cs.getGraphicsAlgorithm() instanceof Ellipse) {
						Ellipse ellipse = (Ellipse) cs.getGraphicsAlgorithm();
						if (dominating) {
							ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND_DOMINATING));
							ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND_DOMINATING));
						} else if (dominated) {
							ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND_DOMINATED));
							ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND_DOMINATED));
						} else {
							ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND));
							ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND));
						}
					}
					for (Shape shape : cs.getChildren()) {
						if (shape.getGraphicsAlgorithm() instanceof Text) {
							Text text = (Text) shape.getGraphicsAlgorithm();
							text.setValue(businessName);
						}
					}
				}
			}
		}
	}

	protected final void updateAllEdges() {

		// Access the graph
		Graph theGraph = GraphUtil.getRootGraph(getDiagram());

		// If there are no edges, abort
		if (theGraph.getEdges().isEmpty()) {
			return;
		}

		// Model is modified now, with new edges

		// Get linkservice to ask for relations between DOs and PEs
		ILinkService linkserv = Graphiti.getLinkService();

		// Check the edges in the domain model
		for (Edge edge : theGraph.getEdges()) {

			// For each edge, delete and add it again

			// If the connection exists
			if (!linkserv.getPictogramElements(getDiagram(), edge).isEmpty()) {
				Graphiti.getPeService()
						.deletePictogramElement(linkserv.getPictogramElements(getDiagram(), edge).get(0));
			}

			// Make sure the edge is correct (i.e. links 2 nodes)
			if (edge.getConnectedNodes().size() == 2) {

				// Call add feature to add the edge

				// We need the source anchor (from the first connected node)
				Anchor sourceAnchor = null;

				for (PictogramElement aPe : linkserv.getPictogramElements(getDiagram(),
						edge.getConnectedNodes().get(0))) {
					if (aPe instanceof ContainerShape) {
						sourceAnchor = ((ContainerShape) aPe).getAnchors().get(0);
					}
				}

				// And the target anchor (from the second connected node)
				Anchor targetAnchor = null;

				for (PictogramElement aPe : linkserv.getPictogramElements(getDiagram(),
						edge.getConnectedNodes().get(1))) {
					if (aPe instanceof ContainerShape) {
						targetAnchor = ((ContainerShape) aPe).getAnchors().get(0);
					}
				}

				// Now we can create the add connection context with both anchors
				AddConnectionContext acc = new AddConnectionContext(sourceAnchor, targetAnchor);

				// ... and the new edge
				acc.setNewObject(edge);

				// ... to be created into the diagram
				acc.setTargetContainer(getDiagram());

				// Instantiate the add feature
				AddEdgeConnectionFeature addCF = new AddEdgeConnectionFeature(getFeatureProvider());

				// And, if it can be added
				if (addCF.canAdd(acc)) {
					// Add and update
					PictogramElement pe = addCF.add(acc);
					updatePictogramElement(pe);
				}
			} else {
				// Remove the edge
				// TODO Can't remove here, mark for deletion
				// theGraph.getEdges().remove(edge);
			}
		}

	}

}

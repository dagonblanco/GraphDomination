package graphdomgraphics.features.custom;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.algorithms.ConvexHullAlgorithm;
import graphdomgraphics.common.ExampleUtil;
import graphdomgraphics.features.AddEdgeConnectionFeature;

public abstract class GraphdomAbstractCustomFeature extends AbstractCustomFeature {

	public GraphdomAbstractCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}


	protected final void updateEdges(){

		// Access the graph
		Graph theGraph = ExampleUtil.getRootGraph(getDiagram());

		// Model is modified now, with new edges

		// Get linkservice to ask for relations between DOs and PEs
		ILinkService linkserv = Graphiti.getLinkService();

		// Check the edges in the domain model
		for (Edge edge : theGraph.getEdges()) {
			
			// If an edge without graphical representation is found...
			if (linkserv.getPictogramElements(getDiagram(), edge).isEmpty()) {
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

			}

		}

		
	}

}

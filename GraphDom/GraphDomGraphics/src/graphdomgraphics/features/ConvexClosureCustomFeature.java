/**
 * 
 */
package graphdomgraphics.features;

import java.util.Random;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.services.IPeCreateService;

import graphdom.Graph;
import graphdom.Edge;
import graphdom.algorithms.ConvexHullAlgorithm;
import graphdom.algorithms.GreedyDominationAlgorithm;
import graphdomgraphics.common.ExampleUtil;

/**
 * @author David
 *
 */
public class ConvexClosureCustomFeature extends AbstractCustomFeature {

	/**
	 * @param fp
	 */
	public ConvexClosureCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Convex closure";
	}

	@Override
	public String getDescription() {
		return "Apply convex closure to a point cloud";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {

		// Access the graph
		Graph theGraph = ExampleUtil.getRootGraph(getDiagram());

		// Instance the related algorithm
		ConvexHullAlgorithm gda = new ConvexHullAlgorithm();

		// Initialize the algorithm with the graph
		gda.setInitialGraph(theGraph);

		// Run the algorithm to the end
		gda.runToEnd();

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

	@Override
	public boolean hasDoneChanges() {
		return true;
	}

}

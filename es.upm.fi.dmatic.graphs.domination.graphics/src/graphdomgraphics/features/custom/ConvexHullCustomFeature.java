/**
 * 
 */
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

/**
 * @author David
 *
 */
public class ConvexHullCustomFeature extends GraphdomAbstractCustomFeature {

	/**
	 * @param fp
	 */
	public ConvexHullCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Convex hull";
	}

	@Override
	public String getDescription() {
		return "Get the convex hull for a point cloud";
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
		updateEdges();

	}

	@Override
	public boolean hasDoneChanges() {
		return true;
	}

}

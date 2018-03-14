/**
 * 
 */
package graphdomgraphics.features.custom;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;

import graphdom.Graph;
import graphdom.algorithms.ConvexHullAlgorithm;
import graphdomgraphics.common.GraphUtil;

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
		Graph theGraph = GraphUtil.getRootGraph(getDiagram());

		// Instance the related algorithm
		ConvexHullAlgorithm gda = new ConvexHullAlgorithm(theGraph);

		// Run the algorithm to the end
		gda.runToEnd();

		// Model is modified now, with new edges
		updateEdges();
		updateGraph(GraphUtil.getRootGraph(getDiagram()));

	}

	@Override
	public boolean hasDoneChanges() {
		return true;
	}

}

package graphdomgraphics.features.custom;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.Node;
import graphdomgraphics.common.GraphUtil;

public class ReplaceGraphCustomFeature extends GraphdomAbstractCustomFeature {

	private boolean hasDoneChanges = false;
	private Graph newGraph;

	public ReplaceGraphCustomFeature(IFeatureProvider fp) {
			super(fp);
		}

	public ReplaceGraphCustomFeature(IFeatureProvider featureProvider, Graph newGraph) {
		super(featureProvider);
		this.newGraph = newGraph;
	}

	public Graph getNewGraph() {
		return newGraph;
	}

	public void setNewGraph(Graph newGraph) {
		this.newGraph = newGraph;
	}

	@Override
	public String getName() {
		return "Replace graph";
	}

	@Override
	public String getDescription() {
		return "Replace the graph with a given one";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {

		hasDoneChanges = true;


		// Access the graph
		Diagram diagram = getDiagram();
		Graph theGraph = GraphUtil.getRootGraph(diagram);

		for (int i = theGraph.getNodes().size() - 1; i >= 0; i--) {

			Node node = theGraph.getNodes().get(i);
			PictogramElement pictogramElement = Graphiti.getLinkService().getPictogramElements(diagram, node)
					.get(0);
			DeleteContext delContext = new DeleteContext(pictogramElement);
			delContext.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));
			getFeatureProvider().getDeleteFeature(delContext).execute(delContext);

		}
		
		for (int i = theGraph.getEdges().size() - 1; i >= 0; i--) {

			Edge edge = theGraph.getEdges().get(i);
			PictogramElement pictogramElement = Graphiti.getLinkService().getPictogramElements(diagram, edge)
					.get(0);
			DeleteContext delContext = new DeleteContext(pictogramElement);
			delContext.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 0));

			getFeatureProvider().getDeleteFeature(delContext).execute(delContext);

		}
		
		
		for (int i = newGraph.getNodes().size() - 1; i >= 0; i--) {

			Node node = newGraph.getNodes().get(i);
			theGraph.getNodes().add(node);
			AddContext addContext = new AddContext();
			addContext.setNewObject(node);
			addContext.setLocation(node.getXCoord(), node.getYCoord());
			addContext.setTargetContainer(diagram);
			getFeatureProvider().getAddFeature(addContext).add(addContext);
		}

		for (int i = newGraph.getEdges().size() - 1; i >= 0; i--) {

			Edge edge = newGraph.getEdges().get(i);
			theGraph.getEdges().add(edge);

		}

		// Update diagram
		updateAllEdges();
		updateGraph(theGraph);

	}

	@Override
	public boolean hasDoneChanges() {
		return hasDoneChanges;
	}

}

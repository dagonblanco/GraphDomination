package graphdomgraphics.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.Node;
import graphdomgraphics.common.GraphUtil;

public class DeleteEdgeFeature extends DefaultDeleteFeature {

	public DeleteEdgeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {

		super.preDelete(context);
	}

	@Override
	public void delete(IDeleteContext context) {

		// Access the graph
		Graph theGraph = GraphUtil.getRootGraph(getDiagram());

		PictogramElement pe = context.getPictogramElement();
		Object[] businessObjectsForPictogramElement = getAllBusinessObjectsForPictogramElement(pe);

		for (Object bo : businessObjectsForPictogramElement) {
			if (bo instanceof Edge) {
				((Edge) bo).getConnectedNodes().clear();
				theGraph.getEdges().remove(bo);
			}
		}

		super.delete(context);

		updateGraph(GraphUtil.getRootGraph(getDiagram()));
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

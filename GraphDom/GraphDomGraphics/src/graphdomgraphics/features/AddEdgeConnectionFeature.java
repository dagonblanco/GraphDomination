package graphdomgraphics.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import graphdom.Edge;

public class AddEdgeConnectionFeature extends AbstractAddFeature implements
		IAddFeature {

	 private static final IColorConstant EDGE_FOREGROUND = new ColorConstant(98, 131, 167);
	
	public AddEdgeConnectionFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context instanceof IAddConnectionContext  && context.getNewObject() instanceof Edge ;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		Edge addedEdge = (Edge) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();		
		IGaService gaService = Graphiti.getGaService();

		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

		Polyline polyline = gaService.createPolyline(connection);
        polyline.setLineWidth(2);
        polyline.setForeground(manageColor(EDGE_FOREGROUND));
		 
		link(connection, addedEdge);

		return connection;
	}

}

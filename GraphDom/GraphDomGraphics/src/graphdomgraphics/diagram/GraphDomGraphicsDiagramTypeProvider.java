package graphdomgraphics.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class GraphDomGraphicsDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public GraphDomGraphicsDiagramTypeProvider() {
		super();
		setFeatureProvider(new GraphDomGraphicsFeatureProvider(this));
	}
}

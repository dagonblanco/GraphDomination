package graphdomfiti.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class GraphDomFitiDiagramTypeProvider extends AbstractDiagramTypeProvider {

	public GraphDomFitiDiagramTypeProvider() {
		super();
		setFeatureProvider(new GraphDomFitiFeatureProvider(this));
	}
}

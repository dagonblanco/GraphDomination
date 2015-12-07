package graphdomgraphics.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;

public class GraphDomGraphicsDiagramTypeProvider extends AbstractDiagramTypeProvider {

	@Override
	public boolean isAutoUpdateAtRuntime() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAutoUpdateAtRuntimeWhenEditorIsSaved() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAutoUpdateAtStartup() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAutoUpdateAtReset() {
		// TODO Auto-generated method stub
		return true;
	}

	public GraphDomGraphicsDiagramTypeProvider() {
		super();
		setFeatureProvider(new GraphDomGraphicsFeatureProvider(this));
	}
}

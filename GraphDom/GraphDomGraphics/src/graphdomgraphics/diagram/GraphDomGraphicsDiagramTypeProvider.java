package graphdomgraphics.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

import graphdomgraphics.tools.GraphdomToolBehaviorProvider;

public class GraphDomGraphicsDiagramTypeProvider extends AbstractDiagramTypeProvider {

	private IToolBehaviorProvider[] toolBehaviorProviders;

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

	@Override
	public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
		if (toolBehaviorProviders == null) {
			toolBehaviorProviders = new IToolBehaviorProvider[] { new GraphdomToolBehaviorProvider(this) };
		}
		return toolBehaviorProviders;
	}
}

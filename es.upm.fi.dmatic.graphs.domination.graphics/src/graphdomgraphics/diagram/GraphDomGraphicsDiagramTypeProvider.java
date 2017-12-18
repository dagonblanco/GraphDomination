package graphdomgraphics.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

import graphdomgraphics.tools.GraphdomToolBehaviorProvider;

public class GraphDomGraphicsDiagramTypeProvider extends AbstractDiagramTypeProvider {

	private IToolBehaviorProvider[] toolBehaviorProviders;

	@Override
	public boolean isAutoUpdateAtRuntime() {
		return true;
	}

	@Override
	public boolean isAutoUpdateAtRuntimeWhenEditorIsSaved() {
		return true;
	}

	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}

	@Override
	public boolean isAutoUpdateAtReset() {
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

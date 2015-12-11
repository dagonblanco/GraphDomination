package graphdomgraphics.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDirectEditingInfo;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import graphdomgraphics.features.AddEdgeConnectionFeature;
import graphdomgraphics.features.AddNodeFeature;
import graphdomgraphics.features.CreateEdgeConnectionFeature;
import graphdomgraphics.features.CreateEdgeConnectionWithNodeFeature;
import graphdomgraphics.features.CreateNodeFeature;
import graphdomgraphics.features.LayoutNodeFeature;
import graphdomgraphics.features.ReconnectNodeFeature;
import graphdom.Node;
import graphdom.Edge;

public class GraphDomGraphicsFeatureProvider extends DefaultFeatureProvider {

	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {

		// return super.getResizeShapeFeature(context);
		return null;
	}

	public GraphDomGraphicsFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new CreateNodeFeature(this) };
	}

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] { 
				new CreateEdgeConnectionFeature(this),
				new CreateEdgeConnectionWithNodeFeature(this) };
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {

		if (context instanceof IAddConnectionContext && context.getNewObject() instanceof Edge) {
			return new AddEdgeConnectionFeature(this);
		} else if (context instanceof IAddContext && context.getNewObject() instanceof Node) {
			return new AddNodeFeature(this);
		}

		return super.getAddFeature(context);
	}

	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {

		if (context.getPictogramElement() instanceof ContainerShape
				&& getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof Node) {
			return new LayoutNodeFeature(this);
		}

		return super.getLayoutFeature(context);
	}

	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return new ReconnectNodeFeature(this);
	}
}

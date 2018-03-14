package graphdomgraphics.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import graphdom.Edge;
import graphdom.Node;
import graphdomgraphics.features.AddEdgeConnectionFeature;
import graphdomgraphics.features.AddNodeFeature;
import graphdomgraphics.features.CreateEdgeConnectionFeature;
import graphdomgraphics.features.CreateEdgeConnectionWithNodeFeature;
import graphdomgraphics.features.CreateNodeFeature;
import graphdomgraphics.features.DeleteEdgeFeature;
import graphdomgraphics.features.DeleteNodeFeature;
import graphdomgraphics.features.LayoutNodeFeature;
import graphdomgraphics.features.ReconnectNodeFeature;
import graphdomgraphics.features.UpdateEdgeFeature;
import graphdomgraphics.features.UpdateGraphFeature;
import graphdomgraphics.features.UpdateNodeFeature;
import graphdomgraphics.features.custom.ConvexHullCustomFeature;
import graphdomgraphics.features.custom.FlipEdgeCustomFeature;
import graphdomgraphics.features.custom.GenerateRandomNodesCustomFeature;
import graphdomgraphics.features.custom.GenerateRoundGraphCustomFeature;
import graphdomgraphics.features.custom.GenerateRoundTriangGraphCustomFeature;
import graphdomgraphics.features.custom.GreedyConnectedDominationCustomFeature;
import graphdomgraphics.features.custom.GreedyDominationCustomFeature;
import graphdomgraphics.features.custom.MarkDominatingCustomFeature;
import graphdomgraphics.features.custom.RandomFlipsByChanceCustomFeature;
import graphdomgraphics.features.custom.RandomFlipsByNumberCustomFeature;
import graphdomgraphics.features.custom.UnmarkAllNodesCustomFeature;

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
				new CreateEdgeConnectionWithNodeFeature(this)
				};
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

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] { 
				new MarkDominatingCustomFeature(this),
				new UnmarkAllNodesCustomFeature(this),
				new GenerateRandomNodesCustomFeature(this),
				new GenerateRoundGraphCustomFeature(this),
				new GreedyDominationCustomFeature(this),
				new GreedyConnectedDominationCustomFeature(this),				
				new ConvexHullCustomFeature(this),
				new GenerateRoundTriangGraphCustomFeature(this),
				new FlipEdgeCustomFeature(this),
				new RandomFlipsByChanceCustomFeature(this),
				new RandomFlipsByNumberCustomFeature(this)
				};
	}

	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape || pictogramElement instanceof Connection) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Node) {
				return new UpdateNodeFeature(this);
			} else if (bo instanceof Edge){
				return new UpdateEdgeFeature(this);
			}
		}

		return new UpdateGraphFeature(this);

	}

	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		/**
		 * return <code>NULL</code> will disable Remove action but at the same time
		 * disable Delete action, because delete uses remove.
		 */
		return new DefaultRemoveFeature(this) {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.graphiti.features.impl.AbstractFeature#isAvailable(org.eclipse.
			 * graphiti.features.context.IContext)
			 */
			@Override
			public boolean isAvailable(IContext context) {
				return false;
			}
		};
	}

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {

		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape || pictogramElement instanceof Connection) {
			Object bo = getBusinessObjectForPictogramElement(pictogramElement);
			if (bo instanceof Node) {
				return new DeleteNodeFeature(this);
			} else if (bo instanceof Edge) {
				return new DeleteEdgeFeature(this);
			}
		}
		return super.getDeleteFeature(context);
	}
}

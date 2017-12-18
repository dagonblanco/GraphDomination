package graphdomgraphics.features;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;

import graphdom.Node;

public class LayoutNodeFeature extends AbstractLayoutFeature implements
		ILayoutFeature {

	public LayoutNodeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canLayout(ILayoutContext context) {
		return context.getPictogramElement() instanceof ContainerShape  && getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof Node ;
	}

	@Override
	public boolean layout(ILayoutContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) pictogramElement;
			GraphicsAlgorithm outerGraphicsAlgorithm = containerShape.getGraphicsAlgorithm();
			if (outerGraphicsAlgorithm instanceof RoundedRectangle) {
				RoundedRectangle roundedRectangle = (RoundedRectangle) outerGraphicsAlgorithm;
				EList<Shape> children = containerShape.getChildren();
				if (!children.isEmpty()) {
					Shape shape = children.get(0);
					GraphicsAlgorithm graphicsAlgorithm = shape.getGraphicsAlgorithm();
					if (graphicsAlgorithm instanceof Text) {
						Graphiti.getGaLayoutService().setLocationAndSize(graphicsAlgorithm, 0, 0, roundedRectangle.getWidth(), roundedRectangle.getHeight());
						return true;
					}
				}
			}
		}
		return false;
	}
}

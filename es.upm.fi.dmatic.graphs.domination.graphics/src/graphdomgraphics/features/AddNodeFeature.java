package graphdomgraphics.features;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import graphdom.Node;
import graphdomgraphics.common.ExampleUtil;
import graphdomgraphics.common.IColorConstants;

public class AddNodeFeature extends AbstractAddFeature implements IAddFeature {

	
	public AddNodeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		// check if user wants to add a Node
		if (context.getNewObject() instanceof Node) {
			// check if user wants to add to a diagram
			if (context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		Node addedNode = (Node) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		int width = 20;
		int height = 20;

		addedNode.setXCoord(context.getX());
		addedNode.setYCoord(context.getY());

		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

		Ellipse ellipse = gaService.createEllipse(containerShape);
		ellipse.setHeight(height);
		ellipse.setWidth(width);
		
		if (addedNode.isDominating()) {
			ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND_DOMINATING));
			ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND_DOMINATING));
		} else if (addedNode.isDominated()){
			ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND_DOMINATED));
			ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND_DOMINATED));
		} else {
			ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND));
			ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND));
		}
		gaService.setLocationAndSize(ellipse, context.getX(), context.getY(), width, height);
		// if added node has no resource we add it to the resource
		// of the diagram
		if (addedNode.eResource() == null) {
			ExampleUtil.getRootGraph(getDiagram()).getNodes().add(addedNode);

		}
		// create link and wire it
		link(containerShape, addedNode);

		// create shape for text
		Shape shape = peCreateService.createShape(containerShape, false);

		// create and set text graphics algorithm
		Text text = gaService.createText(shape, addedNode.getNodeName());
		text.setForeground(manageColor(IColorConstants.NODE_TEXT_FOREGROUND));
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		// vertical alignment has as default value "center"
		text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		gaService.setLocationAndSize(text, 0, 0, width, 20);

		// create link and wire it
		link(shape, addedNode);

		// Shape shape = peCreateService.createShape(containerShape, false);
		// Text text = gaService.createText(shape, "Node");
		// text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		// text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		// gaService.setLocationAndSize(text, 0, 0, context.getWidth(),
		// context.getHeight());

		peCreateService.createChopboxAnchor(containerShape);

		// TODO: enable the link to the domain object
		// Object addedDomainObject = context.getNewObject();
		// link(containerShape, addedDomainObject);

		return containerShape;
	}
}
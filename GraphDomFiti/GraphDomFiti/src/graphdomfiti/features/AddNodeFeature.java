package graphdomfiti.features;

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

import graphDominationEMF.Node;

public class AddNodeFeature extends AbstractAddFeature implements
		IAddFeature {

	public AddNodeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		// TODO: check for right domain object instance below
		return /* context.getNewObject() instanceof Node && */ context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public PictogramElement add(IAddContext context) {

		Node addedClass = (Node) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

		Ellipse ellipse = gaService.createEllipse(containerShape);
		ellipse.setLineVisible(true);
		ellipse.setHeight(context.getHeight());
		ellipse.setWidth(context.getWidth());
		
		
		gaService.setLocationAndSize(ellipse, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		ellipse.setFilled(false);
		
		Shape shape = peCreateService.createShape(containerShape, false);
		Text text = gaService.createText(shape, "nodo");
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, 0, context.getWidth(), context.getHeight());

		peCreateService.createChopboxAnchor(containerShape);

		// TODO: enable the link to the domain object
		// Object addedDomainObject = context.getNewObject();
		//link(containerShape, addedClass);

		return containerShape;
	}
}

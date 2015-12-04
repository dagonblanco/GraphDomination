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
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import graphdom.Node;

public class AddNodeFeature extends AbstractAddFeature implements
		IAddFeature {
    private static final IColorConstant E_CLASS_TEXT_FOREGROUND =
            IColorConstant.BLACK;
     
        private static final IColorConstant E_CLASS_FOREGROUND =
            new ColorConstant(98, 131, 167);

        private static final IColorConstant E_CLASS_BACKGROUND =
            new ColorConstant(187, 218, 247);
	public AddNodeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
//	public boolean canAdd(IAddContext context) {
//		// TODO: check for right domain object instance below
//		return /* context.getNewObject() instanceof Node && */ context.getTargetContainer() instanceof Diagram;
//	}
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
		Node addedClass = (Node) context.getNewObject();
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		int width = 20;
        int height = 20;
        
        
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

		Ellipse ellipse = gaService.createEllipse(containerShape);
		ellipse.setHeight(height);
		ellipse.setWidth(width);
		ellipse.setForeground(manageColor(E_CLASS_FOREGROUND));
		ellipse.setBackground(manageColor(E_CLASS_BACKGROUND));
		gaService.setLocationAndSize(ellipse, context.getX(), context.getY(), width, height);
        // if added Class has no resource we add it to the resource 
        // of the diagram
		if (addedClass.eResource() == null) {
            getDiagram().eResource().getContents().add(addedClass);
   }
        // create link and wire it
        link(containerShape, addedClass);
		
//		RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
//		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), context.getWidth(), context.getHeight());
//		roundedRectangle.setFilled(false);


        // create shape for text
        Shape shape = peCreateService.createShape(containerShape, false);

        // create and set text graphics algorithm
        Text text = gaService.createText(shape, addedClass.getNodeName());
        text.setForeground(manageColor(E_CLASS_TEXT_FOREGROUND));
        text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER ); 
        // vertical alignment has as default value "center"
        text.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
        gaService.setLocationAndSize(text, 0, 0, width, 20);

        // create link and wire it
        link(shape, addedClass);
        
//		Shape shape = peCreateService.createShape(containerShape, false);
//		Text text = gaService.createText(shape, "Node");
//		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
//		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
//		gaService.setLocationAndSize(text, 0, 0, context.getWidth(), context.getHeight());

//		peCreateService.createChopboxAnchor(containerShape);

		// TODO: enable the link to the domain object
		// Object addedDomainObject = context.getNewObject();
		// link(containerShape, addedDomainObject);

		return containerShape;
	}
}

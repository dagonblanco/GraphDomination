/**
 * 
 */
package graphdomgraphics.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import graphdom.Node;
import graphdomgraphics.common.ExampleUtil;
import graphdomgraphics.common.IColorConstants;

/**
 * @author David
 *
 */
public class UpdateNodeFeature extends AbstractUpdateFeature {

	/**
	 * @param fp
	 */
	public UpdateNodeFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.IUpdate#canUpdate(org.eclipse.graphiti.features
	 * .context.IUpdateContext)
	 */
	@Override
	public boolean canUpdate(IUpdateContext context) {
		// return true, if linked business object is a Node
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return (bo instanceof Node);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.graphiti.func.IUpdate#updateNeeded(org.eclipse.graphiti.
	 * features.context.IUpdateContext)
	 */
	@Override
	public IReason updateNeeded(IUpdateContext context) {
		// retrieve name from pictogram model
		String pictogramName = null;
		Color pictogramColor = null;

		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;
			if (cs.getGraphicsAlgorithm() instanceof Ellipse) {
				Ellipse ellipse = (Ellipse) cs.getGraphicsAlgorithm();
				pictogramColor = ellipse.getForeground();
			}
			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					pictogramName = text.getValue();
				}
			}
		}

		// retrieve name from business model
		String businessName = null;
		boolean dominating = false;
		boolean dominated = false;

		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Node) {
			Node node = (Node) bo;
			businessName = node.getNodeName();
			dominating = node.isDominating();
			dominated = node.isDominated();
		}

		// update needed, if names are different
		boolean updateNameNeeded = ((pictogramName == null && businessName != null)
				|| (pictogramName != null && !pictogramName.equals(businessName)));

		boolean markChanged = (
				(dominating && !ExampleUtil.equalsColorAndConstant(pictogramColor, IColorConstants.NODE_FOREGROUND_DOMINATING))
				||(!dominating && dominated && !ExampleUtil.equalsColorAndConstant(pictogramColor, IColorConstants.NODE_FOREGROUND_DOMINATED))
				||(!dominating && !dominated && !ExampleUtil.equalsColorAndConstant(pictogramColor, IColorConstants.NODE_FOREGROUND))
				);
		if (updateNameNeeded) {
			return Reason.createTrueReason("Name is out of date");
		} else if (markChanged) {
			return Reason.createTrueReason("Domination state has changed");
		} else {
			return Reason.createFalseReason();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.graphiti.func.IUpdate#update(org.eclipse.graphiti.features.
	 * context.IUpdateContext)
	 */
	@Override
	public boolean update(IUpdateContext context) {
		// retrieve name from business model
		String businessName = null;
		boolean dominating = false;
		boolean dominated = false;
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Node) {
			Node node = (Node) bo;
			businessName = node.getNodeName();
			dominating = node.isDominating();
			dominated = node.isDominated();
		}

		// Set name and color in pictogram model
		if (pictogramElement instanceof ContainerShape) {
			ContainerShape cs = (ContainerShape) pictogramElement;
			if (cs.getGraphicsAlgorithm() instanceof Ellipse) {
				Ellipse ellipse = (Ellipse) cs.getGraphicsAlgorithm();
				if (dominating) {
					ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND_DOMINATING));
					ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND_DOMINATING));
				} else if (dominated){
					ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND_DOMINATED));
					ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND_DOMINATED));
				} else {
					ellipse.setForeground(manageColor(IColorConstants.NODE_FOREGROUND));
					ellipse.setBackground(manageColor(IColorConstants.NODE_BACKGROUND));
				}
			}
			for (Shape shape : cs.getChildren()) {
				if (shape.getGraphicsAlgorithm() instanceof Text) {
					Text text = (Text) shape.getGraphicsAlgorithm();
					text.setValue(businessName);
					return true;
				}
			}
		}

		// Set color

		return false;
	}

}

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
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import graphdom.Edge;
import graphdom.Node;
import graphdomgraphics.common.ExampleUtil;
import graphdomgraphics.common.IColorConstants;

/**
 * @author David
 *
 */
public class UpdateEdgeFeature extends AbstractUpdateFeature {

	/**
	 * @param fp
	 */
	public UpdateEdgeFeature(IFeatureProvider fp) {
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
		return (bo instanceof Edge);
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
		Color pictogramColor = null;

		PictogramElement pictogramElement = context.getPictogramElement();
		if (pictogramElement instanceof Connection) {
			Connection con = (Connection) pictogramElement;
			if (con.getGraphicsAlgorithm() instanceof Polyline) {
				Polyline pol = (Polyline) con.getGraphicsAlgorithm();
				pictogramColor = pol.getForeground();
			}
			
		}

		// retrieve name from business model
		boolean dominating = false;
		

		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Edge) {
			Edge edge = (Edge) bo;
			
			dominating = edge.getConnectedNodes().get(0).isDominating() && edge.getConnectedNodes().get(1).isDominating();

		}

		// update needed

		boolean markChanged = (
				(dominating && !ExampleUtil.equalsColorAndConstant(pictogramColor, IColorConstants.EDGE_FOREGROUND_DOMINATING))
				||(!dominating && !ExampleUtil.equalsColorAndConstant(pictogramColor, IColorConstants.EDGE_FOREGROUND))
				);
		if (markChanged) {
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
		// retrieve domination state from business model
		
		boolean dominating = false;
	
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof Edge) {
			Edge edge = (Edge) bo;
			dominating = edge.getConnectedNodes().get(0).isDominating() && edge.getConnectedNodes().get(1).isDominating();
		}

		// Set color in pictogram model
		if (pictogramElement instanceof Connection) {
			Connection con = (Connection) pictogramElement;
			if (con.getGraphicsAlgorithm() instanceof Polyline) {
				Polyline pol = (Polyline) con.getGraphicsAlgorithm();
				if (dominating) {
					pol.setForeground(manageColor(IColorConstants.EDGE_FOREGROUND_DOMINATING));
					pol.setBackground(manageColor(IColorConstants.EDGE_BACKGROUND_DOMINATING));
				} else {
					pol.setForeground(manageColor(IColorConstants.EDGE_FOREGROUND));
					pol.setBackground(manageColor(IColorConstants.EDGE_BACKGROUND));
				}
			}
		}

		// Set color

		return false;
	}

}

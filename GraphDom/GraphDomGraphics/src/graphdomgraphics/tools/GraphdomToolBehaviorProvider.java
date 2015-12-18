/**
 * 
 */
package graphdomgraphics.tools;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;

import graphdom.Node;
import graphdomgraphics.common.GraphdomImageProvider;

import graphdomgraphics.features.CreateEdgeConnectionWithNodeFeature;
import graphdomgraphics.features.CreateNodeFeature;
import graphdomgraphics.features.MarkNodeCustomFeature;

/**
 * @author xIS02028
 *
 */
public class GraphdomToolBehaviorProvider extends DefaultToolBehaviorProvider {

	private static final int MAX_DOMAIN_BUTTONS = 5;
	private static final int OFFSET = 15;

	/**
	 * @param diagramTypeProvider
	 */
	public GraphdomToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {

		IContextButtonPadData data = super.getContextButtonPad(context);
		PictogramElement pe = context.getPictogramElement();

		// 1. set the generic context buttons
		// note, that we do not add 'remove' (just as an example)
		setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE);

		// 2. add domain specific context-buttons, which offer all
		// available create-features

		// create new CreateConnectionContext

		CreateContext cc = new CreateContext();

		cc.setTargetContainer((ContainerShape) pe.eContainer());
		cc.setX(pe.getGraphicsAlgorithm().getX() + OFFSET);
		cc.setY(pe.getGraphicsAlgorithm().getY() + OFFSET);

		// create context buttons for all applicable features

//		ICreateFeature[] features = getFeatureProvider().getCreateFeatures();
//		for (ICreateFeature feature : features) {
//			if (feature.isAvailable(cc) && feature.canCreate(cc)) {
//				ContextButtonEntry button = new ContextButtonEntry(feature, cc);
//
//				button.setText(feature.getCreateDescription());
//				button.setIconId(IGraphdomImageConstants.IMG_NEW_NODE);
//				if (data.getDomainSpecificContextButtons().size() < MAX_DOMAIN_BUTTONS) {
//					data.getDomainSpecificContextButtons().add(button);
//				}
//			}
//		}

		// 3.a. create new CreateConnectionContext
		CreateConnectionContext ccc = new CreateConnectionContext();
		ccc.setSourcePictogramElement(pe);
		Anchor anchor = null;
		if (pe instanceof Anchor) {
			anchor = (Anchor) pe;
		} else if (pe instanceof AnchorContainer) {
			// assume, that our shapes always have chopbox anchors
			anchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) pe);
		}
		ccc.setSourceAnchor(anchor);

		// 3.b. create context button and add all applicable features
		ContextButtonEntry button = new ContextButtonEntry(null, context);
		button.setText("Create connection (and node)");
		button.setIconId(GraphdomImageProvider.IMG_NEW_NODE);
		ICreateConnectionFeature[] connectionFeatures = getFeatureProvider().getCreateConnectionFeatures();
		for (ICreateConnectionFeature feature : connectionFeatures) {
			if (feature.isAvailable(ccc) && feature.canStartConnection(ccc) && (feature instanceof CreateEdgeConnectionWithNodeFeature))
				button.addDragAndDropFeature(feature);
		}

		// 3.c. add context button, if it contains at least one feature
		if (button.getDragAndDropFeatures().size() > 0) {
			data.getDomainSpecificContextButtons().add(button);
		}

		return data;
	}
	
	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
	    // create a sub-menu for all custom features
	    ContextMenuEntry subMenu = new ContextMenuEntry(null, context);
	    subMenu.setText("Graphdom");
	    subMenu.setDescription("Graphdom features submenu");
	    // display sub-menu hierarchical or flat
	    subMenu.setSubmenu(true);

	    // create a menu-entry in the sub-menu for each custom feature
	    ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
	    for (int i = 0; i < customFeatures.length; i++) {
	         ICustomFeature customFeature = customFeatures[i];
	         if (customFeature.isAvailable(context)) {
	             ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
	             subMenu.add(menuEntry);
	         }
	     }

	     IContextMenuEntry ret[] = new IContextMenuEntry[] { subMenu };
	     return ret;
	}
	
	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
	    ICustomFeature customFeature =
	        new MarkNodeCustomFeature(getFeatureProvider());
	    // canExecute() tests especially if the context contains a node
	    if (customFeature.canExecute(context)) {
	        return customFeature;
	    }
	 
	    return super.getDoubleClickFeature(context);
	}
}

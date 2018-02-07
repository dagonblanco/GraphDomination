/**
 * 
 */
package graphdomgraphics.tools;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;

import graphdom.algorithms.GreedyTotalDominationAlgorithm;
import graphdomgraphics.common.GraphdomImageProvider;
import graphdomgraphics.features.CreateEdgeConnectionWithNodeFeature;
import graphdomgraphics.features.custom.ConvexHullCustomFeature;
import graphdomgraphics.features.custom.FlipEdgeCustomFeature;
import graphdomgraphics.features.custom.GenerateRandomNodesCustomFeature;
import graphdomgraphics.features.custom.GenerateRoundGraphCustomFeature;
import graphdomgraphics.features.custom.GenerateRoundTriangGraphCustomFeature;
import graphdomgraphics.features.custom.GenericAlgorithmCustomFeature;
import graphdomgraphics.features.custom.GreedyConnectedDominationCustomFeature;
import graphdomgraphics.features.custom.GreedyDominationCustomFeature;
import graphdomgraphics.features.custom.MarkDominatingCustomFeature;
import graphdomgraphics.features.custom.RandomFlipsByChanceCustomFeature;
import graphdomgraphics.features.custom.RandomFlipsByNumberCustomFeature;
import graphdomgraphics.features.custom.UnmarkAllNodesCustomFeature;

/**
 * @author xIS02028
 *
 */
public class GraphdomToolBehaviorProvider extends DefaultToolBehaviorProvider {


	/**
	 * @param diagramTypeProvider
	 */
	public GraphdomToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {

		IContextButtonPadData data = super.getContextButtonPad(context);
		PictogramElement pe = context.getPictogramElement();

		// set the generic context buttons
		// we do not add 'remove' (just as an example)
		setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE);


		// create context buttons for all applicable features

		// Create new CreateConnectionContext
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

		// Create context button with feature
		ContextButtonEntry button = new ContextButtonEntry(null, context);
		button.setText("Create connection (and node)");
		button.setIconId(GraphdomImageProvider.IMG_NEW_NODE);
		button.addDragAndDropFeature(new CreateEdgeConnectionWithNodeFeature(getFeatureProvider()));
		
		data.getDomainSpecificContextButtons().add(button);

		return data;
	}

	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {

		// create a sub-menu for each group of custom features

		ContextMenuEntry subMenuGraphGeneration = new ContextMenuEntry(null, context);
		subMenuGraphGeneration.setText("Generation");
		subMenuGraphGeneration.setDescription("Graph generation submenu");
		// display sub-menu hierarchical or flat
		subMenuGraphGeneration.setSubmenu(true);

		ContextMenuEntry subMenuSelectedObject = new ContextMenuEntry(null, context);
		subMenuSelectedObject.setText("");
		subMenuSelectedObject.setDescription("Selected object actions submenu");
		// display sub-menu hierarchical or flat
		subMenuSelectedObject.setSubmenu(false);

		ContextMenuEntry subMenuAlgorithms = new ContextMenuEntry(null, context);
		subMenuAlgorithms.setText("Algorithms");
		subMenuAlgorithms.setDescription("Domination algorithms submenu");
		// display sub-menu hierarchical or flat
		subMenuAlgorithms.setSubmenu(true);

		subMenuAlgorithms.add(new ContextMenuEntry(new UnmarkAllNodesCustomFeature(getFeatureProvider()), context));
		subMenuAlgorithms.add(new ContextMenuEntry(new GreedyDominationCustomFeature(getFeatureProvider()), context));
		subMenuAlgorithms
				.add(new ContextMenuEntry(new GreedyConnectedDominationCustomFeature(getFeatureProvider()), context));
		subMenuAlgorithms.add(new ContextMenuEntry(
				new GenericAlgorithmCustomFeature(getFeatureProvider(), GreedyTotalDominationAlgorithm.class),
				context));

		subMenuSelectedObject.add(new ContextMenuEntry(new MarkDominatingCustomFeature(getFeatureProvider()), context));
		subMenuSelectedObject.add(new ContextMenuEntry(new FlipEdgeCustomFeature(getFeatureProvider()), context));

		subMenuGraphGeneration
				.add(new ContextMenuEntry(new GenerateRandomNodesCustomFeature(getFeatureProvider()), context));
		subMenuGraphGeneration.add(new ContextMenuEntry(new ConvexHullCustomFeature(getFeatureProvider()), context));
		subMenuGraphGeneration
				.add(new ContextMenuEntry(new GenerateRoundGraphCustomFeature(getFeatureProvider()), context));
		subMenuGraphGeneration
				.add(new ContextMenuEntry(new GenerateRoundTriangGraphCustomFeature(getFeatureProvider()), context));
		subMenuGraphGeneration
				.add(new ContextMenuEntry(new RandomFlipsByChanceCustomFeature(getFeatureProvider()), context));
		subMenuGraphGeneration
				.add(new ContextMenuEntry(new RandomFlipsByNumberCustomFeature(getFeatureProvider()), context));

		IContextMenuEntry ret[] = new IContextMenuEntry[] { subMenuSelectedObject, subMenuGraphGeneration,
				subMenuAlgorithms };
		return ret;
	}
	
	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
	    ICustomFeature customFeature =
	        new MarkDominatingCustomFeature(getFeatureProvider());
	    // canExecute() tests especially if the context contains a node
	    if (customFeature.canExecute(context)) {
	        return customFeature;
	    }
	 
	    return super.getDoubleClickFeature(context);
	}

	@Override
	public ICustomFeature getCommandFeature(CustomContext context, String hint) {

		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
		for (int i = 0; i < customFeatures.length; i++) {
			ICustomFeature customFeature = customFeatures[i];
			if (customFeature.isAvailable(context) && customFeature.getClass().getSimpleName().equals(hint)) {
				return customFeature;
			}
		}
		return super.getCommandFeature(context, hint);
	}
}

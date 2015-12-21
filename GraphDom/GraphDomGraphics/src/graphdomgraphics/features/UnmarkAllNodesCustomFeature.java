/**
 * 
 */
package graphdomgraphics.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

import graphdom.Graph;
import graphdom.Node;
import graphdom.util.Utils;
import graphdomgraphics.common.ExampleUtil;

/**
 * @author David
 *
 */
public class UnmarkAllNodesCustomFeature extends AbstractCustomFeature {

	/**
	 * @param fp
	 */
	public UnmarkAllNodesCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	private boolean hasDoneChanges = false;

	@Override
	public String getName() {
		return "Unmark all Nodes";
	}

	@Override
	public String getDescription() {
		return "Reset the mark on all nodes";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		
		// Get the graph
		Graph theGraph = ExampleUtil.getRootGraph(getDiagram());

		// Get the linkservice
		ILinkService linkserv = Graphiti.getLinkService();

		// For every node in the graph
		for (Node node : theGraph.getNodes()) {
			// If marked...
			if (node.isDominating()) {				
				//unmark
				node.setDominating(false);
				// and update pictogram
				for (PictogramElement pe : linkserv.getPictogramElements(getDiagram(), node)) {
					updatePictogramElement(pe);
				}
				hasDoneChanges=true;
			}
		}
	}

	@Override
	public boolean hasDoneChanges() {
		return this.hasDoneChanges;
	}
}

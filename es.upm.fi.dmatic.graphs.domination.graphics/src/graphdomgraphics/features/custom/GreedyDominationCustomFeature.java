/**
 * 
 */
package graphdomgraphics.features.custom;

import java.util.Random;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.services.IPeCreateService;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.Node;
import graphdom.algorithms.GreedyDominationAlgorithm;
import graphdomgraphics.common.ExampleUtil;

/**
 * @author David
 *
 */
public class GreedyDominationCustomFeature extends AbstractCustomFeature {


	/**
	 * @param fp
	 */
	public GreedyDominationCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Greedy domination";
	}

	@Override
	public String getDescription() {
		return "Apply greedy domination algorithm";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {

		// Access the graph
		Graph theGraph = ExampleUtil.getRootGraph(getDiagram());

		GreedyDominationAlgorithm gda = new GreedyDominationAlgorithm();
		
		gda.setInitialGraph(theGraph);
		
		gda.runToEnd();
		
		ILinkService linkserv = Graphiti.getLinkService();
		
		for (Node node : theGraph.getNodes()){
			for (PictogramElement pe : linkserv.getPictogramElements(getDiagram(), node)){
				updatePictogramElement(pe);	
			}
		}
		
		for (Edge edge : theGraph.getEdges()){
			for (PictogramElement pe : linkserv.getPictogramElements(getDiagram(), edge)){
				updatePictogramElement(pe);	
			}
		}
		
	}

	@Override
	public boolean hasDoneChanges() {
		return true;
	}

}

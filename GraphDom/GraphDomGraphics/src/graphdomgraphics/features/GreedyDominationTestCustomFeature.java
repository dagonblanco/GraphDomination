/**
 * 
 */
package graphdomgraphics.features;

import java.util.Random;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

import graphdom.Graph;
import graphdom.algorithms.GreedyDominationAlgorithm;
import graphdomgraphics.common.ExampleUtil;

/**
 * @author David
 *
 */
public class GreedyDominationTestCustomFeature extends AbstractCustomFeature {

	private static final String TITLE = "Create random nodes";

	private static final String USER_QUESTION = "Enter number of nodes to create:";

	private boolean hasDoneChanges = false;

	/**
	 * @param fp
	 */
	public GreedyDominationTestCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return "Generate random nodes";
	}

	@Override
	public String getDescription() {
		return "Generate a number of random nodes";
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
		
	}

	@Override
	public boolean hasDoneChanges() {
		return hasDoneChanges;
	}

}

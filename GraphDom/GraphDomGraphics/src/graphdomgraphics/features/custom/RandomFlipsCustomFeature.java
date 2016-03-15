package graphdomgraphics.features.custom;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;

import graphdom.Graph;
import graphdom.algorithms.RandomFlipsAlgorithm;
import graphdomgraphics.common.ExampleUtil;

public class RandomFlipsCustomFeature extends GraphdomAbstractCustomFeature {


	private static final String TITLE = "Generate random flips";

	private static final String USER_QUESTION = "Enter chance of flipping an edge (0-100):";

	private boolean hasDoneChanges = false;

	public RandomFlipsCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Generate random flips";
	}

	@Override
	public String getDescription() {
		return "Generate random flips over the graph";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {

		// Ask user number of nodes

		String sChance = ExampleUtil.askString(TITLE, USER_QUESTION, "50");
		int nChance = 50;
		try {
			nChance = Integer.parseUnsignedInt(sChance);
		} catch (NumberFormatException e) {
			nChance = 50;
		}

		hasDoneChanges = nChance > 0;
		
		// Now for the random flips...
		
		// Access the graph
		Graph theGraph = ExampleUtil.getRootGraph(getDiagram());

		// Instance the related algorithm
		RandomFlipsAlgorithm rfa = new RandomFlipsAlgorithm(nChance);

		// Initialize the algorithm with the graph
		rfa.setInitialGraph(theGraph);

		// Run the algorithm to the end
		rfa.runToEnd();

		// Model is modified now, with new or different edges
		updateAllEdges();
		
	}
	
	@Override
	public boolean hasDoneChanges() {
		return hasDoneChanges;
	}
}

package graphdomgraphics.features.custom;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;

import graphdom.Graph;
import graphdom.algorithms.RandomFlipsByNumberAlgorithm;
import graphdomgraphics.common.GraphUtil;

public class RandomFlipsByNumberCustomFeature extends GraphdomAbstractCustomFeature {

	private static final String TITLE = "Generate random flips by number";

	private static final String USER_QUESTION = "Enter number flips to be done:";

	private boolean hasDoneChanges = false;

	public RandomFlipsByNumberCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Generate random flips by number";
	}

	@Override
	public String getDescription() {
		return "Generate a set number of flips over the graph randomly";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {

		// Ask user number of nodes

		String sFlips = GraphUtil.askString(TITLE, USER_QUESTION, "10");
		int nFlips = 10;
		try {
			nFlips = Integer.parseUnsignedInt(sFlips);
		} catch (NumberFormatException e) {
			nFlips = 10;
		}

		hasDoneChanges = nFlips > 0;

		// Now for the random flips...

		// Access the graph
		Graph theGraph = GraphUtil.getRootGraph(getDiagram());

		// Instance the related algorithm
		RandomFlipsByNumberAlgorithm rfa = new RandomFlipsByNumberAlgorithm(theGraph, nFlips);

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

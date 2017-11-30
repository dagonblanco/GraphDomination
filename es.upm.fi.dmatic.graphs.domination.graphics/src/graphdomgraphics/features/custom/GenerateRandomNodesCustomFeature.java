package graphdomgraphics.features.custom;

import java.util.Random;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import graphdom.Node;
import graphdomgraphics.common.ExampleUtil;
import graphdomgraphics.features.CreateNodeFeature;

public class GenerateRandomNodesCustomFeature extends AbstractCustomFeature {

	private static final String TITLE = "Create random nodes";

	private static final String USER_QUESTION = "Enter number of nodes to create:";

	private boolean hasDoneChanges = false;

	public GenerateRandomNodesCustomFeature(IFeatureProvider fp) {
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

		// Ask user number of nodes

		String numberOfNodes = ExampleUtil.askString(TITLE, USER_QUESTION, "30");
		int nNodes = 0;
		try {
			nNodes = Integer.parseUnsignedInt(numberOfNodes);
		} catch (NumberFormatException e) {
			nNodes = 0;
		}

		CreateNodeFeature cnf = new CreateNodeFeature(getFeatureProvider());
		Random rn = new Random();
		for (int i = 0; i < nNodes; i++) {
			CreateContext cc = new CreateContext();
			cc.setTargetContainer(getDiagram());
			cc.setLocation(rn.nextInt(500), rn.nextInt(500));
			cnf.create(cc);
		}

		hasDoneChanges = nNodes > 0;
	}

	@Override
	public boolean hasDoneChanges() {
		return hasDoneChanges;
	}
}

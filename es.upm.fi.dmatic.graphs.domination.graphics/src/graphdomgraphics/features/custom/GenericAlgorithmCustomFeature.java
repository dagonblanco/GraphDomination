package graphdomgraphics.features.custom;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.ILinkService;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.Node;
import graphdom.algorithms.GraphAlgorithm;
import graphdomgraphics.common.GraphUtil;

public class GenericAlgorithmCustomFeature extends GraphdomAbstractCustomFeature {

	private GraphAlgorithm algorithm;
	private Class algorithmClass;

	public GenericAlgorithmCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	public GenericAlgorithmCustomFeature(IFeatureProvider fp, GraphAlgorithm algorithm) {
		super(fp);
		this.algorithm = algorithm;
	}

	public GenericAlgorithmCustomFeature(IFeatureProvider fp, Class algorithmClass) {
		super(fp);
		this.algorithmClass = algorithmClass;
	}

	public GraphAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(GraphAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public Class getAlgorithmClass() {
		return algorithmClass;
	}

	public void setAlgorithmClass(Class algorithmClass) {
		this.algorithmClass = algorithmClass;
	}

	@Override
	public String getName() {
		return algorithm != null ? algorithm.getName() : algorithmClass.getSimpleName();
	}

	@Override
	public String getDescription() {
		return "Apply " + (algorithm != null ? algorithm.getName() : algorithmClass.getSimpleName()) + " algorithm";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		
		// Access the graph
		Graph theGraph = GraphUtil.getRootGraph(getDiagram());

		if (algorithm == null) {
			// Instantiate the algorithm
			try {
				algorithm = (GraphAlgorithm) algorithmClass.getConstructor(Graph.class).newInstance(theGraph);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		algorithm.runToEnd();

		ILinkService linkserv = Graphiti.getLinkService();

		for (Node node : theGraph.getNodes()) {
			for (PictogramElement pe : linkserv.getPictogramElements(getDiagram(), node)) {
				updatePictogramElement(pe);
			}
		}

		for (Edge edge : theGraph.getEdges()) {
			for (PictogramElement pe : linkserv.getPictogramElements(getDiagram(), edge)) {
				updatePictogramElement(pe);
			}
		}
	}

	@Override
	public boolean hasDoneChanges() {
		return true;
	}

}

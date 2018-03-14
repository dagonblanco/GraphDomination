/**
 * 
 */
package graphdomgraphics.features.custom;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import graphdom.Edge;
import graphdom.Node;
import graphdomgraphics.common.GraphUtil;

/**
 * @author David
 *
 */
public class FlipEdgeCustomFeature extends GraphdomAbstractCustomFeature {

	/**
	 * @param fp
	 */
	public FlipEdgeCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	private boolean hasDoneChanges = false;

	@Override
	public String getName() {
		return "Flip edge";
	}

	@Override
	public String getDescription() {
		return "Flip the edge if possible";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// allow mark if exactly one pictogram element
		// representing an Edge is selected
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Edge) {
				ret = isFlippable((Edge) bo);
			}
		}
		return ret;
	}

	private boolean isFlippable(Edge edge) {

		if (edge.getConnectedNodes().size() != 2)
			return false;

		Node nodeA = edge.getConnectedNodes().get(0);
		Node nodeB = edge.getConnectedNodes().get(1);

		EList<Node> adjacentToB = nodeB.getAdjacentNodes();

		EList<Node> adjacentToBoth = nodeA.getAdjacentNodes();
		adjacentToBoth.retainAll(adjacentToB);

		return (adjacentToBoth.size() == 2);

	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();

		if (pes != null && pes.length == 1) {
			List<PictogramElement> peList = null;
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Edge) {
				Edge edge = (Edge) bo;

				EList<Node> oldNodes = edge.getConnectedNodes();

				boolean flipped = ((Edge) bo).flip();

				hasDoneChanges = flipped;

				if (flipped) {

					List<PictogramElement> elements = Graphiti.getLinkService().getPictogramElements(getDiagram(),
							edge);

					for (PictogramElement pe : elements) {
						Graphiti.getPeService().deletePictogramElement(pe);
					}

					EList<Node> newNodes = edge.getConnectedNodes();

					peList = Graphiti.getLinkService().getPictogramElements(getDiagram(),
							new BasicEList<EObject>(oldNodes.get(0).getAdjacentNodes()), true);

					peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
							new BasicEList<EObject>(oldNodes.get(0).getConnectedEdges()), true));

					peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
							new BasicEList<EObject>(oldNodes.get(0).getAdjacentNodes()), true));

					peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
							new BasicEList<EObject>(oldNodes.get(0).getConnectedEdges()), true));

					peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
							new BasicEList<EObject>(newNodes.get(1).getAdjacentNodes()), true));

					peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
							new BasicEList<EObject>(newNodes.get(1).getConnectedEdges()), true));

					peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
							new BasicEList<EObject>(newNodes.get(1).getAdjacentNodes()), true));

					peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
							new BasicEList<EObject>(newNodes.get(1).getConnectedEdges()), true));

					updateEdges();
					for (PictogramElement pe : pes) {
						updatePictogramElement(pe);
					}
					for (PictogramElement pe : peList) {
						updatePictogramElement(pe);
					}

					updateGraph(GraphUtil.getRootGraph(getDiagram()));

				}
			}

		}
	}

	@Override
	public boolean hasDoneChanges() {
		return this.hasDoneChanges;
	}


}

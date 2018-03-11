/**
 * 
 */
package graphdomgraphics.features.custom;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.internal.features.context.impl.base.DoubleClickContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import graphdom.Edge;
import graphdom.GraphdomFactory;
import graphdom.Node;
import graphdomgraphics.common.GraphUtil;

/**
 * @author David
 *
 */
public class MarkDominatingCustomFeature extends AbstractCustomFeature {

	/**
	 * @param fp
	 */
	public MarkDominatingCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	private boolean hasDoneChanges = false;

	@Override
	public String getName() {
		return "(Un)Mark as dominating";
	}

	@Override
	public String getDescription() {
		return "Toggle the dominating on a node or edge";
	}

	@Override
	public boolean canExecute(ICustomContext context) {

		// Always allow execution as double click feature
		if (context instanceof DoubleClickContext) {
			return true;
		}

		// If not double-clicking...
		// allow mark if exactly one pictogram element
		// representing a Node is selected
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Node || bo instanceof Edge) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();

		if (pes != null && pes.length == 1) {
			List<PictogramElement> peList = null;
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Node) {
				Node node = (Node) bo;
				node.setDominating(!node.isDominating());
				updatePictogramElement(pes[0]);
				
				peList = Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(node.getAdjacentNodes()), true);
				
				peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(node.getConnectedEdges()), true));
				


			} else if (bo instanceof Edge) {
				Edge edge = (Edge) bo;
				EList<Node> nodes = edge.getConnectedNodes();
				if (nodes.get(0).isDominating() && nodes.get(1).isDominating()){
					nodes.get(0).setDominating(false);
					nodes.get(1).setDominating(false);
				} else {
					nodes.get(0).setDominating(true);
					nodes.get(1).setDominating(true);					
				}
				
				peList = Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(nodes.get(0).getAdjacentNodes()), true);
				
				peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(nodes.get(0).getConnectedEdges()), true));
				
				peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(nodes.get(1).getAdjacentNodes()), true));
				
				peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(nodes.get(1).getConnectedEdges()), true));
				
			} else {
				// Create a new node in the given position
				// Create target node (domain object)

				Node newNode = GraphdomFactory.eINSTANCE.createNode();
				newNode.setNodeName(String.valueOf(GraphUtil.getRootGraph(getDiagram()).getNextNodeId()));
				newNode.setGuid(EcoreUtil.generateUUID());
				newNode.setXCoord(context.getX());
				newNode.setYCoord(context.getY());

				GraphUtil.getRootGraph(getDiagram()).getNodes().add(newNode);

				// Create shape
				AddContext ac = new AddContext();
				ac.setLocation(newNode.getXCoord(), newNode.getYCoord());
				ac.setNewObject(newNode);
				ac.setTargetContainer(getDiagram());
				getFeatureProvider().addIfPossible(ac);

				peList = Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(newNode.getAdjacentNodes()), true);

				peList.addAll(Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(newNode.getConnectedEdges()), true));
			}
			for (PictogramElement pe : pes) {
				updatePictogramElement(pe);
			}
			for (PictogramElement pe : peList) {
				updatePictogramElement(pe);
			}
			
			// Update selection
			getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[] {});
		}
	}

	@Override
	public boolean hasDoneChanges() {
		return this.hasDoneChanges;
	}
}

/**
 * 
 */
package graphdomgraphics.features;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

import graphdom.Node;

/**
 * @author David
 *
 */
public class MarkNodeCustomFeature extends AbstractCustomFeature {

	/**
	 * @param fp
	 */
	public MarkNodeCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	private boolean hasDoneChanges = false;

	@Override
	public String getName() {
		return "(Un)Mark Node";
	}

	@Override
	public String getDescription() {
		return "Toggle the mark on a node";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		// allow mark if exactly one pictogram element
		// representing a Node is selected
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Node) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();

		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Node) {
				Node node = (Node) bo;
				node.setDominating(!node.isDominating());
				updatePictogramElement(pes[0]);
				
				List<PictogramElement> peList = Graphiti.getLinkService().getPictogramElements(getDiagram(),
						new BasicEList<EObject>(node.getAdjacentNodes()), true);
				
				for (PictogramElement pe : peList) {
					updatePictogramElement(pe);
				}

			}
		}
	}

	@Override
	public boolean hasDoneChanges() {
		return this.hasDoneChanges;
	}
}

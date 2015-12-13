/**
 * 
 */
package graphdomgraphics.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

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
		// allow rename if exactly one pictogram element
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
				node.setMarked(!node.isMarked());
				updatePictogramElement(pes[0]);
			}
		}
	}


	@Override
	public boolean hasDoneChanges() {
		return this.hasDoneChanges;
	}
}

package graphdomgraphics.features;

import java.util.Iterator;

import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

public class DeleteNodeFeature extends DefaultDeleteFeature {

	public DeleteNodeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void preDelete(IDeleteContext context) {

		super.preDelete(context);

		if (!(context.getPictogramElement() instanceof ContainerShape))
			return;

		ContainerShape container = (ContainerShape) context.getPictogramElement();

		for (Iterator<Anchor> iter = container.getAnchors().iterator(); iter.hasNext();) {
			Anchor anchor = iter.next();
			for (Iterator<Connection> iterator = Graphiti.getPeService().getAllConnections(anchor).iterator(); iterator
					.hasNext();) {
				Connection connection = iterator.next();
				DeleteContext ctx = new DeleteContext(connection);
				ctx.setMultiDeleteInfo(new MultiDeleteInfo(false, false, 1));
				IDeleteFeature deleteFeature = getFeatureProvider().getDeleteFeature(ctx);
				if (deleteFeature != null)
					deleteFeature.delete(ctx);
			}
		}
	}
}
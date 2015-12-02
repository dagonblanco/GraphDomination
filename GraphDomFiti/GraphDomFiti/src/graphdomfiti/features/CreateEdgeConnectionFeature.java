package graphdomfiti.features;

import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class CreateEdgeConnectionFeature extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateEdgeConnectionFeature(IFeatureProvider fp) {
		super(fp, "Edge", "Creates a new Edge between two Nodes");
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		// TODO: check for right domain object instance below
		// return getBusinessObjectForPictogramElement(context.getSourcePictogramElement()) instanceof <DomainObject>;

		return true;
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		PictogramElement sourcePictogramElement = context.getSourcePictogramElement();
		PictogramElement targetPictogramElement = context.getTargetPictogramElement();

		// TODO: check for right domain object instance below
		// if (getBusinessObjectForPictogramElement(sourcePictogramElement) instanceof <DomainObject> && getBusinessObjectForPictogramElement(targetPictogramElement) instanceof <DomainObject>) {
		//  	return true;
		// }
		
		return sourcePictogramElement != null && targetPictogramElement != null;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;

		// TODO: create the domain object connection here
		Object newDomainObjectConnetion = null;

		AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
		addContext.setNewObject(newDomainObjectConnetion);
		newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);

		return newConnection;
	}
}

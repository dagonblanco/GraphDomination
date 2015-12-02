package graphdomfiti.features;

import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateNodeFeature extends AbstractCreateFeature implements
		ICreateFeature {

	public CreateNodeFeature(IFeatureProvider fp) {
		super(fp, "Node", "Creates a new Node");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		// TODO: create the domain object here
		Object newNode = null;
		
		// TODO: in case of an EMF object add the new object to a suitable resource
		// getDiagram().eResource().getContents().add(newNode);

		addGraphicalRepresentation(context, newNode);
		return new Object[] { newNode };
	}
}

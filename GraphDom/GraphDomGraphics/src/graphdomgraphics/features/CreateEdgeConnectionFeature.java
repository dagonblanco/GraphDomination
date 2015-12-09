package graphdomgraphics.features;

import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import graphdom.Edge;
import graphdom.GraphdomFactory;
import graphdom.Node;

public class CreateEdgeConnectionFeature extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateEdgeConnectionFeature(IFeatureProvider fp) {
		super(fp, "Edge", "Creates a new Edge between two Nodes");
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
	
		return getBusinessObjectForPictogramElement(context.getSourcePictogramElement()) instanceof Node;

	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {		

		Node source = getNode(context.getSourceAnchor());
		Node target = getNode(context.getTargetAnchor());
		
        if (source != null && target != null && source != target && !source.getAdjacentNodes().contains(target)) {
		  	return true;
		 }
		
		return false;
		
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;

        // get ENodes which should be connected
		Node source = getNode(context.getSourceAnchor());
		Node target = getNode(context.getTargetAnchor());
        
		if (source != null && target != null) {
            // create new business object 
            Edge myEdge = createEdge(source, target);
            // add connection for business object
            AddConnectionContext addContext =
                new AddConnectionContext(context.getSourceAnchor(), context
                    .getTargetAnchor());
            addContext.setNewObject(myEdge);
            newConnection =
                (Connection) getFeatureProvider().addIfPossible(addContext);
            
            getDiagram().eResource().getContents().add(myEdge);
        }
        
		return newConnection;
	}
	
    /**
     * Returns the Node belonging to the anchor, or null if not available.
     */
    private Node getNode(Anchor anchor) {
        if (anchor != null) {
            Object object =
                getBusinessObjectForPictogramElement(anchor.getParent());
            if (object instanceof Node) {
                return (Node) object;
            }
        }
        return null;
    }
 
    /**
    * Creates a Edge between two Nodees.
    */
    private Edge createEdge(Node source, Node target) {
        Edge myEdge = GraphdomFactory.eINSTANCE.createEdge();
        
        myEdge.getConnectedNodes().add(source);
        myEdge.getConnectedNodes().add(target);
        
        return myEdge;
   }
}

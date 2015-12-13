package graphdomgraphics.features;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import graphdom.GraphdomFactory;
import graphdom.Node;
import graphdom.util.Utils;
import graphdomgraphics.common.ExampleUtil;

public class CreateNodeFeature extends AbstractCreateFeature implements
		ICreateFeature {
	   
	private static final String TITLE = "Create node";
	   
	private static final String USER_QUESTION = "Enter new node name";
	    
	public CreateNodeFeature(IFeatureProvider fp) {
		super(fp, "Node", "Creates a new Node");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {

//		String newClassName = ExampleUtil.askString(TITLE, USER_QUESTION, "");
//        if (newClassName == null || newClassName.trim().length() == 0) {
//            return EMPTY;
//        }
		
		Node newNode = GraphdomFactory.eINSTANCE.createNode();
		
		newNode.setNodeName(String.valueOf(ExampleUtil.getRootGraph(getDiagram()).getNextNodeId()));
		newNode.setGuid(EcoreUtil.generateUUID());
		newNode.setXCoord(context.getX());
		newNode.setYCoord(context.getY());
		
		//getDiagram().eResource().getContents().add(newNode);	
		ExampleUtil.getRootGraph(getDiagram()).getNodes().add(newNode);
		
		addGraphicalRepresentation(context, newNode);
		
		return new Object[] { newNode };
	}
}

package graphdomgraphics;

import org.eclipse.emf.ecore.EObject;

import graphdom.Graph;
import graphdom.GraphdomFactory;
import graphdom.GraphdomPackage;

public class GraphDomNewWizard extends GraphitiNewWizard {

	public GraphDomNewWizard(String name, String diagExt, String domainExt, String thediagramTypeName,
			String theeditorId) {
		super("Domination Graphs", "graphdiag", "graphdom", "GraphDomGraphics", org.eclipse.graphiti.ui.editor.DiagramEditor.DIAGRAM_EDITOR_ID);
	}

	@Override
	protected EObject createModel(String name) {
		// Initialize the model
	    GraphdomPackage.eINSTANCE.eClass();
	    // Retrieve the default factory singleton
	    GraphdomFactory factory = GraphdomFactory.eINSTANCE;

	    // create the content of the model via this program
	    Graph myGraph = factory.createGraph();
	    
		return myGraph;
	}

}

/**
 */
package graphdom.tests;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import graphdom.Edge;
import graphdom.Graph;
import graphdom.GraphdomFactory;
import graphdom.GraphdomPackage;
import graphdom.Node;
import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphTest extends TestCase {

	/**
	 * The fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphTest.class);
	}

	/**
	 * Constructs a new Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Graph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Graph getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GraphdomFactory.eINSTANCE.createGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	public void testLoad() throws Exception{
		// Initialize the model
	    GraphdomPackage.eINSTANCE.eClass();
	    
	    // Register the XMI resource factory for the .graphdom extension

	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("graphdom", new XMIResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // Get the resource
	    Resource resource = resSet.getResource(URI
	        //.createURI("file:///D:/EclipseModelling/runtime-GraphDomRCP/SecondGraph.graphdom"), true);
	    		.createURI("graphs/SimpleTestGraph.graphdom"), true);
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    Graph myGraph = (Graph) resource.getContents().get(0);
	    assertNotNull(myGraph);
		
	}
	
	public void testSave() throws Exception{
		// Initialize the model
	    GraphdomPackage.eINSTANCE.eClass();
	    // Retrieve the default factory singleton
	    GraphdomFactory factory = GraphdomFactory.eINSTANCE;

	    // create the content of the model via this program
	    Graph myGraph = factory.createGraph();
	    Node node1 = factory.createNode();
	    Node node2 = factory.createNode();
	    Edge edge1 = factory.createEdge();
	    
	    myGraph.setGraphName("SavedTestGraph");
	    
	    node1.setNodeName("TestNode1");
	    node2.setNodeName("TestNode2");
	    
	    edge1.getConnectedNodes().add(node1);
	    edge1.getConnectedNodes().add(node2);
	    
	    myGraph.getNodes().add(node1);
	    myGraph.getNodes().add(node2);
	    myGraph.getEdges().add(edge1);
	    
	    // As of here we preparing to save the model content

	    // Register the XMI resource factory for the .graphdom extension

	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("graphdom", new XMIResourceFactoryImpl());

	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // create a resource
	    Resource resource = resSet.createResource(URI
	        .createURI("graphs/SavedTestGraph.graphdom"));
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    resource.getContents().add(myGraph);

	    // now save the content.
	    resource.save(Collections.EMPTY_MAP);

	}
		
	
	

} //GraphTest

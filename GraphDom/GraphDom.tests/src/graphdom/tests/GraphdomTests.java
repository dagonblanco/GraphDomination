/**
 */
package graphdom.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>graphdom</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphdomTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new GraphdomTests("graphdom Tests");
		suite.addTestSuite(GraphTest.class);
		suite.addTestSuite(NodeTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphdomTests(String name) {
		super(name);
	}

} //GraphdomTests

/**
 */
package graphdom.algorithms;

import graphdom.Graph;

//TODO Documentar interfaz
/**
 */
public interface GraphAlgorithm {

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 */
	AlgorithmStatus getStatus();

	/**
	 * Sets the value of the '<em>Status</em>' attribute.
	 */
	void setStatus(AlgorithmStatus value);

	/**
	 * Run the algorithm to the end
	 */
	void runToEnd();

	/**
	 * Run a single step of the algorithm
	 */
	void nextStep();

	default String getName() {
		return this.getClass().getSimpleName();
	}

	default void initialize(Graph graph) {
		// Do nothing by default
	}

}

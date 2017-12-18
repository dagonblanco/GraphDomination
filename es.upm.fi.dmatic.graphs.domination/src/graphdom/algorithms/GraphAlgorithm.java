/**
 */
package graphdom.algorithms;

//TODO Documentar interfaz
/**
 */
public interface GraphAlgorithm {

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 */
	AlgorithmStatus getStatus();

	/**
	 * Sets the value of the '{@link graphdom.algorithms.GraphAlgorithm#getStatus <em>Status</em>}' attribute.
	 */
	void setStatus(AlgorithmStatus value);

	/**
	 */
	void runToEnd();

	/**
	 */
	void nextStep();

} // AbstractGraphAlgorithm

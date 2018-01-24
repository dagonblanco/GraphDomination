package graphdom.algorithms;

/**
 * Information required to run a statistics execution on an algorithm
 * 
 * @author David
 *
 */
public class StatisticsInfo {

	private int executionNumber;

	private int flipsNumber;

	public int getExecutionNumber() {
		return executionNumber;
	}
	public void setExecutionNumber(int executionNumber) {
		this.executionNumber = executionNumber;
	}
	public int getFlipsNumber() {
		return flipsNumber;
	}
	public void setFlipsNumber(int flipsNumber) {
		this.flipsNumber = flipsNumber;
	}

}

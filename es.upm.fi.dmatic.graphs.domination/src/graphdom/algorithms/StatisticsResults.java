package graphdom.algorithms;

import graphdom.Graph;

/**
 * Results of the execution of an algorithm's statistics
 * 
 * @author David
 *
 */
public class StatisticsResults {

	private int maxDominationNumber;
	private int minDominationNumber;
	private double averageDominationNumber;
	private Graph minGraph;
	private Graph maxGraph;
	private Graph backupGraph;

	public int getMaxDominationNumber() {
		return maxDominationNumber;
	}

	public void setMaxDominationNumber(int maxDominationNumber) {
		this.maxDominationNumber = maxDominationNumber;
	}

	public int getMinDominationNumber() {
		return minDominationNumber;
	}

	public void setMinDominationNumber(int minDominationNumber) {
		this.minDominationNumber = minDominationNumber;
	}

	public double getAverageDominationNumber() {
		return averageDominationNumber;
	}

	public void setAverageDominationNumber(double averageDominationNumber) {
		this.averageDominationNumber = averageDominationNumber;
	}

	public Graph getMinGraph() {
		return minGraph;
	}

	public void setMinGraph(Graph minGraph) {
		this.minGraph = minGraph;
	}

	public Graph getMaxGraph() {
		return maxGraph;
	}

	public void setMaxGraph(Graph maxGraph) {
		this.maxGraph = maxGraph;
	}

	public Graph getBackupGraph() {
		return backupGraph;
	}

	public void setBackupGraph(Graph backupGraph) {
		this.backupGraph = backupGraph;
	}

}

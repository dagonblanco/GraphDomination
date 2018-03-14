package graphdom.algorithms;

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

}

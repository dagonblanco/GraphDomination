package graphdom.algorithms;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import graphdom.Edge;
import graphdom.Graph;

public class RandomFlipsByNumberAlgorithm extends AbstractAlgorithm {

	int flipNumber = 10;
	int flipsDone = 0;
	int maxRetries = 10;
	Random rnd = new Random();

	public RandomFlipsByNumberAlgorithm(Graph graph, int flipNumber) {

		super(graph);

		// Overwrite default flip chance
		this.flipNumber = flipNumber;

		maxRetries = getGraph().getEdges().size();
		// Switch status from uninitialized
		if (maxRetries != 0) {
			setStatus(AlgorithmStatus.INPROGRESS);
		} else {
			setStatus(AlgorithmStatus.ENDED);
		}
	}

	@Override
	public void nextStep() {

		// If no more flips to do, we have finished
		if (flipsDone >= flipNumber) {
			setStatus(AlgorithmStatus.ENDED);
		} else {
			// Maybe flip me
			boolean flipped = false;
			int retries = 0;

			Set<Integer> alreadyTried = new HashSet<>(maxRetries);

			// Avoid endless loop
			while (!flipped && (retries < maxRetries)) {
				// Choose nontried edge
				int rand = nextNontriedInt(alreadyTried);
				Edge currentEdge = getGraph().getEdges().get(rand);

				if (currentEdge.flip()) {
					// One more flip done
					flipped = true;
					flipsDone++;
				} else {
					// Mark this number as tried and increase retry count
					alreadyTried.add(rand);
					retries++;
				}
			}
		}

	}

	private int nextNontriedInt(Set<Integer> alreadyTried) {
		int currentInt;
		do {
			currentInt = rnd.nextInt(getGraph().getEdges().size());
		} while (alreadyTried.contains(currentInt));

		return currentInt;
	}

}

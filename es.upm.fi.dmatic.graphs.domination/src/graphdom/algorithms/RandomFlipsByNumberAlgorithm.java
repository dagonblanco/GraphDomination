package graphdom.algorithms;

import java.util.Random;

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
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {

		// If no more edges left to check, we have finished
		if (flipsDone >= flipNumber) {
			setStatus(AlgorithmStatus.ENDED);
		} else {
			// Maybe flip me
			boolean flipped = false;
			int retries = 0;

			// Avoid endless loop
			while (!flipped && (retries < maxRetries)) {
				// Choose edge
				int rand = rnd.nextInt(getGraph().getEdges().size());
				Edge currentEdge = getGraph().getEdges().get(rand);

				if (currentEdge.flip()) {
					flipped = true;
					flipsDone++;
				} else {
					retries++;
				}
			}
		}

	}

}

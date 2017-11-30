package graphdom.algorithms;

import java.util.Random;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import graphdom.AlgorithmStatus;
import graphdom.Edge;
import graphdom.Graph;
import graphdom.Node;
import graphdom.impl.AbstractGraphAlgorithmImpl;
import graphdom.util.GraphdomAdapterFactory;
import graphdom.util.Utils;

public class RandomFlipsByNumberAlgorithm extends AbstractGraphAlgorithmImpl {

	int flipNumber = 10;
	int flipsDone = 0;
	int maxRetries = 10;
	Random rnd = new Random();

	public RandomFlipsByNumberAlgorithm(int flipNumber) {

		// Overwrite default flip chance
		this.flipNumber = flipNumber;

	}

	@Override
	public void setInitialGraph(Graph newInitialGraph) {

		// Set graph to dominate
		super.setInitialGraph(newInitialGraph);

		maxRetries = getInitialGraph().getEdges().size();
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
				int rand = rnd.nextInt(getInitialGraph().getEdges().size());
				Edge currentEdge = getInitialGraph().getEdges().get(rand);

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

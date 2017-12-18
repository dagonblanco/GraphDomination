package graphdom.algorithms;

import java.util.Random;

import graphdom.Edge;
import graphdom.Graph;

public class RandomFlipsByChanceAlgorithm extends AbstractAlgorithm {

	int edgeNumber = 0;
	int flipChance = 50;
	int flippedEdges = 0;
	Random rnd = new Random();

	public RandomFlipsByChanceAlgorithm(Graph graph, int flipChance) {

		super(graph);
		// Overwrite default flip chance
		this.flipChance = flipChance;

		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {

		// If no more edges left to check, we have finished
		if (edgeNumber >= getGraph().getEdges().size()) {
			setStatus(AlgorithmStatus.ENDED);
		} else {
			// Maybe flip me
			int rand = rnd.nextInt(100);
			if (rand <= flipChance) {
				Edge currentEdge = getGraph().getEdges().get(edgeNumber);
				if (currentEdge.flip()) {
					flippedEdges++;
				}
			}

			edgeNumber++;
		}

	}

}

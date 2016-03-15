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

public class RandomFlipsAlgorithm extends AbstractGraphAlgorithmImpl {

	int edgeNumber = 0;
	int flipChance = 50;
	int flippedEdges = 0;
	Random rnd = new Random();

	public RandomFlipsAlgorithm(int flipChance) {

		// Overwrite default flip chance
		this.flipChance = flipChance;

	}

	@Override
	public void setInitialGraph(Graph newInitialGraph) {

		// Set graph to dominate
		super.setInitialGraph(newInitialGraph);

		// Switch status from uninitialized
		setStatus(AlgorithmStatus.INPROGRESS);
	}

	@Override
	public void nextStep() {

		// If no more edges left to check, we have finished
		if (edgeNumber >= getInitialGraph().getEdges().size()) {
			setStatus(AlgorithmStatus.ENDED);
		} else {
			// Maybe flip me
			int rand = rnd.nextInt(100);
			if (rand <= flipChance) {
				Edge currentEdge = getInitialGraph().getEdges().get(edgeNumber);
				if (currentEdge.flip()) {
					flippedEdges++;
				}
			}

			edgeNumber++;
		}

	}

}

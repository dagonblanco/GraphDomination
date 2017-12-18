package graphdom.algorithms;

public class NullAlgorithm extends AbstractAlgorithm {

	@Override
	public AlgorithmStatus getStatus() {
		return AlgorithmStatus.ENDED;
	}

	@Override
	public void nextStep() {
		// Do nothing
	}

}

package graphdom.util;

import org.eclipse.emf.common.util.EList;

import graphdom.Node;

public class Utils {

	/**
	 * Finds the node with most neighbours
	 */

	public static Node findHighestGradeNode (EList<Node> nodelist) {
		
		Node maxNode = null;
		for (Node node : nodelist) {
			if (maxNode == null || node.getGrade() > maxNode.getGrade()) {
				maxNode = node;
			}
		}
		return maxNode;
	}

	/**
	 * Finds the dominated node with most neighbours
	 */

	public static Node findHighestGradeDominatedNode (EList<Node> nodelist) {
		
		Node maxNode = null;
		for (Node node : nodelist) {
			if ((maxNode == null || (node.getGrade() > maxNode.getGrade())) && node.isDominated() && !node.isDominating()) {
				maxNode = node;
			}
		}
		return maxNode;
	}

	/**
	 * Find the node with most undominated neighbours
	 */

	public static Node findHighestUndominatedGradeNode(EList<Node> nodelist) {
		Node maxNode = null;
		for (Node node : nodelist) {
			if (maxNode == null || findUndominatedGrade(node) > findUndominatedGrade(maxNode)) {
				maxNode = node;
			}
		}
		return maxNode;
	}

	/**
	 * Find the node with most undominated & undominating neighbours dominating
	 */

	public static Node findHighestUndominatedUndominatingGradeNode(EList<Node> nodelist) {
		Node maxNode = null;
		for (Node node : nodelist) {
			if (maxNode == null || findUndominatedUndominatingGrade(node) > findUndominatedUndominatingGrade(maxNode)) {
				maxNode = node;
			}
		}
		return maxNode;
	}

	/**
	 * Find the number of undominated adjacent nodes of a given node
	 * 
	 * @param node
	 * @return
	 */

	public static int findUndominatedGrade(Node node) {

		int undominatedGrade = 0;
		for (Node neighbour : node.getAdjacentNodes()) {
			if (!neighbour.isDominated()) {
				undominatedGrade++;
			}
		}
		return undominatedGrade;

	}

	/**
	 * Find the number of undominated & undominating adjacent nodes of a given node
	 * 
	 * @param node
	 * @return
	 */

	public static int findUndominatedUndominatingGrade(Node node) {

		int undominatedUndominatingGrade = 0;
		for (Node neighbour : node.getAdjacentNodes()) {
			if (!neighbour.isDominated() && !neighbour.isDominating()) {
				undominatedUndominatingGrade++;
			}
		}
		return undominatedUndominatingGrade;

	}
}

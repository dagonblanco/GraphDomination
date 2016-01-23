package graphdom.util;

import org.eclipse.emf.common.util.EList;

import graphdom.Node;

public class Utils {

	public static Node findHighestGradeNode (EList<Node> nodelist) {
		
		Node maxNode = null;
		for (Node node : nodelist) {
			if (maxNode == null || node.getGrade() > maxNode.getGrade()) {
				maxNode = node;
			}
		}
		return maxNode;
	}
	
	public static Node findHighestGradeDominatedNode (EList<Node> nodelist) {
		
		Node maxNode = null;
		for (Node node : nodelist) {
			if ((maxNode == null || (node.getGrade() > maxNode.getGrade())) && node.isDominated() && !node.isDominating()) {
				maxNode = node;
			}
		}
		return maxNode;
	}
}

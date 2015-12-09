/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2011 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *
 * </copyright>
 *
 *******************************************************************************/
package graphdomgraphics.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.impl.ReconnectionContext;
import org.eclipse.graphiti.features.impl.DefaultReconnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;

import graphdom.Edge;
import graphdom.Node;

public class ReconnectNodeFeature extends DefaultReconnectionFeature {

	public ReconnectNodeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canReconnect(IReconnectionContext context) {
		Node oldSource = getNode(context.getConnection().getStart());
		Node oldTarget = getNode(context.getConnection().getEnd());
		Node newAnchor = getNode(context.getNewAnchor());

		if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_SOURCE)) {
			return (newAnchor != null && !newAnchor.equals(oldTarget)
					&& !newAnchor.getAdjacentNodes().contains(oldTarget));
		} else if (context.getReconnectType().equals(ReconnectionContext.RECONNECT_TARGET)) {
			return (newAnchor != null && !newAnchor.equals(oldSource)
					&& !newAnchor.getAdjacentNodes().contains(oldSource));
		} else {
			return false;
		}

	}

	@Override
	public void preReconnect(IReconnectionContext context) {
		// TODO Auto-generated method stub
		super.preReconnect(context);
	}

	@Override
	public void postReconnect(IReconnectionContext context) {

		super.postReconnect(context);

		Edge edge = (Edge) getBusinessObjectForPictogramElement(context.getConnection());

		Node oldNode = getNode(context.getOldAnchor());
		Node newNode = getNode(context.getNewAnchor());

		// Disconnect old node
		edge.getConnectedNodes().remove(oldNode);

		// Connect new node from target
		edge.getConnectedNodes().add(newNode);
	}

	/**
	 * Returns the Node belonging to the anchor, or null if not available.
	 */
	private Node getNode(Anchor anchor) {
		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor.getParent());
			if (object instanceof Node) {
				return (Node) object;
			}
		}
		return null;
	}
}

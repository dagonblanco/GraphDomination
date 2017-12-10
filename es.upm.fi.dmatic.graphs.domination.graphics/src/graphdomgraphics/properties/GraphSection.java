/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2010 SAP AG.
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
package graphdomgraphics.properties;


import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import graphdom.Graph;
import graphdom.Node;

public class GraphSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Text nameText;
	private Text nodeCount;
	private Text edgeCount;
	private Text dominated;
	private Text dominatingSet;
	private Text matrixText;


	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite;

		composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = false;
		composite.setLayout(gridLayout);
		
		GridData defaultGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		GridData multiLineGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 5);

//		factory.createCLabel(composite, "Name:"); //$NON-NLS-1$
//		nameText = factory.createText(composite, ""); //$NON-NLS-1$
//		nameText.setEditable(false);

		factory.createCLabel(composite, "Number of nodes:"); //$NON-NLS-1$
		nodeCount = factory.createText(composite, ""); //$NON-NLS-1$
		nodeCount.setEditable(false);
		nodeCount.setLayoutData(defaultGridData);

		factory.createCLabel(composite, "Number of edges:"); //$NON-NLS-1$
		edgeCount = factory.createText(composite, ""); //$NON-NLS-1$
		edgeCount.setEditable(false);
		edgeCount.setLayoutData(defaultGridData);

		factory.createCLabel(composite, "Dominated:"); //$NON-NLS-1$
		dominated = factory.createText(composite, ""); //$NON-NLS-1$
		dominated.setEditable(false);
		dominated.setLayoutData(defaultGridData);

		factory.createCLabel(composite, "Dominating set:"); //$NON-NLS-1$
		dominatingSet = factory.createText(composite, "", SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL); //$NON-NLS-1$
		dominatingSet.setEditable(false);
		dominatingSet.setLayoutData(defaultGridData);

		
		factory.createCLabel(composite, "Adjacency matrix:"); //$NON-NLS-1$
		matrixText = factory.createText(composite, "", SWT.MULTI | SWT.BORDER | SWT.V_SCROLL); //$NON-NLS-1$
		matrixText.setEditable(false);
		matrixText.setLayoutData(multiLineGridData);

	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Graph theGraph = (Graph) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a Node
			if (theGraph == null)
				return;
//			String name = theGraph.getGraphName();
//			nameText.setText(name == null ? "" : name); //$NON-NLS-1$
			
			nodeCount.setText(String.valueOf(theGraph.getNodes().size()));
			edgeCount.setText(String.valueOf(theGraph.getEdges().size()));
			dominated.setText(String.valueOf(theGraph.isDominated()));
			
			StringBuilder matrix = null;
			for (Node theNode : theGraph.getNodes()) {
				if (matrix == null) {
					matrix = new StringBuilder(theNode.getNodeName()).append("-->");
				} else {
					matrix.append(System.lineSeparator()).append(theNode.getNodeName()).append("-->");
				}
				
				StringBuilder nodelist = null;
				for (Node adjnode : theNode.getAdjacentNodes()) {
					if (nodelist == null) {
						nodelist = new StringBuilder(adjnode.getNodeName());
					} else {
						nodelist.append(",").append(adjnode.getNodeName());
					}

				}
				matrix.append(nodelist == null ? "" : nodelist.toString());

			}
			if (matrix!=null) {
				matrixText.setText(matrix.toString());
			}
			
			StringBuilder domSet = null;
			for (Node theNode : theGraph.getDominatingSet()) {
				if (domSet == null) {
					domSet = new StringBuilder(theNode.getNodeName());
				} else {
					domSet.append(",").append(theNode.getNodeName());
				}								
			}
			if (domSet!=null) dominatingSet.setText(domSet.toString());
		}
	}
}

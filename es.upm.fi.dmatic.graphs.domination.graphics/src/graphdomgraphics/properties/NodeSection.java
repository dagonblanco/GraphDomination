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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import graphdom.Node;

public class NodeSection extends GFPropertySection implements ITabbedPropertyConstants {

	private Text nameText;
	private Text gradeText;
	private Text connectedNodesText;
	private Text dominatingText;
	private Text dominatedText;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite;

		composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		composite.setLayout(gridLayout);

		factory.createCLabel(composite, "Name:"); //$NON-NLS-1$
		nameText = factory.createText(composite, ""); //$NON-NLS-1$
		nameText.setEditable(false);

		factory.createCLabel(composite, "Grade:"); //$NON-NLS-1$
		gradeText = factory.createText(composite, ""); //$NON-NLS-1$
		gradeText.setEditable(false);

		factory.createCLabel(composite, "Dominating:"); //$NON-NLS-1$
		dominatingText = factory.createText(composite, ""); //$NON-NLS-1$
		dominatingText.setEditable(false);

		factory.createCLabel(composite, "Dominated:"); //$NON-NLS-1$
		dominatedText = factory.createText(composite, ""); //$NON-NLS-1$
		dominatedText.setEditable(false);

		factory.createCLabel(composite, "Adjacent node list:"); //$NON-NLS-1$
		connectedNodesText = factory.createText(composite, ""); //$NON-NLS-1$
		connectedNodesText.setEditable(false);

	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Node theNode = (Node) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a Node
			if (theNode == null)
				return;
			String name = theNode.getNodeName();
			nameText.setText(name == null ? "" : name); //$NON-NLS-1$
			long grade = theNode.getGrade();
			gradeText.setText(String.valueOf(grade)); // $NON-NLS-1$
			dominatedText.setText(String.valueOf(theNode.isDominated()));
			dominatingText.setText(String.valueOf(theNode.isDominating()));
			StringBuffer connected = null;
			for (Node adjnode : theNode.getAdjacentNodes()) {
				if (connected == null) {
					connected = new StringBuffer(adjnode.getNodeName());
				} else {
					connected.append(",").append(adjnode.getNodeName());
				}

			}
			connectedNodesText.setText(connected.toString());
		}
	}
}

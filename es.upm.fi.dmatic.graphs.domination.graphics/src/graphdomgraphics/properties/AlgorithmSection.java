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

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import graphdom.Graph;
import graphdom.algorithms.GreedyConnectedDominationAlgorithm;
import graphdom.algorithms.GreedyDominationAlgorithm;

public class AlgorithmSection extends GFPropertySection implements ITabbedPropertyConstants {

	Graph theGraph;
	CCombo algorithmCombo;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite;

		composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.makeColumnsEqualWidth = true;
		composite.setLayout(gridLayout);

		GridData defaultGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);

		GridData spanGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);

		CLabel algorithmLabel = factory.createCLabel(composite, "Algorithm Selection", SWT.CENTER); //$NON-NLS-1$
		algorithmLabel.setLayoutData(spanGridData);

		algorithmCombo = factory.createCCombo(composite);
		algorithmCombo.setLayoutData(spanGridData);
		algorithmCombo.add("Greedy domination");
		algorithmCombo.add("Greedy connecteddomination");

		Button buttonInit = factory.createButton(composite, "Initialize", SWT.PUSH);
		buttonInit.setLayoutData(defaultGridData);
		buttonInit.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						if (theGraph == null)
							return;
						switch (algorithmCombo.getSelectionIndex()) {
						case 0:
							theGraph.setAssignedAlgorithm(new GreedyDominationAlgorithm());
							break;
						case 1:
							theGraph.setAssignedAlgorithm(new GreedyConnectedDominationAlgorithm());
							break;
						default:
							break;
						}
						theGraph.getAssignedAlgorithm().setInitialGraph(theGraph);
					}
				});

			}
		});

		Button buttonNext = factory.createButton(composite, "Next Step", SWT.PUSH);
		buttonNext.setLayoutData(defaultGridData);
		buttonNext.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						theGraph.getAssignedAlgorithm().nextStep();
						
					}
				});

			}
		});

		Button buttonEnd = factory.createButton(composite, "Run to End", SWT.PUSH);
		buttonEnd.setLayoutData(defaultGridData);
		buttonEnd.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						theGraph.getAssignedAlgorithm().runToEnd();;
						
					}
				});

			}
		});

	}

	@Override
	public void refresh() {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			theGraph = (Graph) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a Node
			if (theGraph == null)
				return;

			theGraph.getAssignedAlgorithm();
		}
	}
}

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
import org.eclipse.graphiti.features.context.impl.CustomContext;
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
import graphdom.algorithms.AlgorithmStatus;
import graphdom.algorithms.GreedyConnectedDominationAlgorithm;
import graphdom.algorithms.GreedyDominationAlgorithm;
import graphdom.algorithms.GreedyTotalDominationAlgorithm;
import graphdomgraphics.common.GraphUtil;
import graphdomgraphics.features.UpdateGraphFeature;

public class AlgorithmSection extends GFPropertySection implements ITabbedPropertyConstants {

	Graph theGraph;
	CCombo algorithmCombo;
	private Button buttonInit;
	private Button buttonNext;
	private Button buttonEnd;
	private AlgorithmStatus status;

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
		algorithmCombo.add("Greedy connected domination");
		algorithmCombo.add("Greedy total domination");
		algorithmCombo.select(0);


		status = (theGraph != null && theGraph.getAlgorithm() != null
				? theGraph.getAlgorithm().getStatus()
				: AlgorithmStatus.UNINITIALIZED);
		
		buttonInit = factory.createButton(composite, "Initialize", SWT.PUSH);
		buttonInit.setLayoutData(defaultGridData);		
		buttonInit.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						if (theGraph == null)
							return;
						switch (algorithmCombo.getSelectionIndex()) {
						case 0:
							theGraph.setAlgorithm(new GreedyDominationAlgorithm(theGraph));
							break;
						case 1:
							theGraph.setAlgorithm(new GreedyConnectedDominationAlgorithm(theGraph));
							break;
						case 2:
							theGraph.setAlgorithm(new GreedyTotalDominationAlgorithm(theGraph));
							break;
						default:
							break;
						}
						new UpdateGraphFeature(getDiagramTypeProvider().getFeatureProvider())
								.execute(new CustomContext());
						refresh();

					}
				});

			}
		});

		buttonNext = factory.createButton(composite, "Next Step", SWT.PUSH);
		buttonNext.setLayoutData(defaultGridData);
		buttonNext.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						theGraph.getAlgorithm().nextStep();
						new UpdateGraphFeature(getDiagramTypeProvider().getFeatureProvider())
								.execute(new CustomContext());
						refresh();

					}
				});

			}
		});

		buttonEnd = factory.createButton(composite, "Run to End", SWT.PUSH);
		buttonEnd.setLayoutData(defaultGridData);
		buttonEnd.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						theGraph.getAlgorithm().runToEnd();
						new UpdateGraphFeature(getDiagramTypeProvider().getFeatureProvider())
								.execute(new CustomContext());
						refresh();

					}
				});

			}
		});

	}

	@Override
	public void refresh() {

		theGraph = GraphUtil.getRootGraph(getDiagram());

		status = (theGraph != null && theGraph.getAlgorithm() != null ? theGraph.getAlgorithm().getStatus()
				: AlgorithmStatus.UNINITIALIZED);

		buttonInit.setEnabled(true);
		buttonNext.setEnabled(status.equals(AlgorithmStatus.INPROGRESS));
		buttonEnd.setEnabled(status.equals(AlgorithmStatus.INPROGRESS));
	}
}

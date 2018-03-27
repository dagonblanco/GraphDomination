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

import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import graphdom.Graph;
import graphdom.algorithms.GreedyConnectedDominationAlgorithm;
import graphdom.algorithms.GreedyDominationAlgorithm;
import graphdom.algorithms.GreedyOptimizedDominationAlgorithm;
import graphdom.algorithms.GreedyTotalDominationAlgorithm;
import graphdom.algorithms.StatisticsInfo;
import graphdom.algorithms.StatisticsResults;
import graphdomgraphics.common.GraphUtil;
import graphdomgraphics.features.UpdateGraphFeature;
import graphdomgraphics.features.custom.ReplaceGraphCustomFeature;

public class StatisticsSection extends GFPropertySection implements ITabbedPropertyConstants {

	Graph theGraph;
	private Spinner executionCount;
	private Spinner flipsCount;
	CCombo algorithmCombo;
	private Button buttonRun;
	private Button buttonMax;
	private Button buttonMin;
	private Button buttonRestore;
	private Text minDomination;
	private Text maxDomination;
	private Text avgDomination;
	StatisticsResults runStatistics;

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

		GridData defaultGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);

		GridData spanGridData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);

		factory.createCLabel(composite, "Number of executions:"); //$NON-NLS-1$

		executionCount = new Spinner(composite, SWT.FILL);
		executionCount.setValues(20, 1, Integer.MAX_VALUE, 0, 1, 10);

		factory.createCLabel(composite, "Number of flips:"); //$NON-NLS-1$

		flipsCount = new Spinner(composite, SWT.FILL);
		flipsCount.setValues(50, 1, Integer.MAX_VALUE, 0, 1, 10);

		CLabel algorithmLabel = factory.createCLabel(composite, "Algorithm Selection:", SWT.NONE); //$NON-NLS-1$
		algorithmLabel.setLayoutData(defaultGridData);

		algorithmCombo = factory.createCCombo(composite);
		// algorithmCombo.setLayoutData(defaultGridData);
		algorithmCombo.add("Greedy domination");
		algorithmCombo.add("Greedy connected domination");
		algorithmCombo.add("Greedy total domination");
		algorithmCombo.add("Optimized greedy domination");

		algorithmCombo.select(0);

		buttonRun = factory.createButton(composite, "Run Statistics", SWT.PUSH);
		buttonRun.setLayoutData(spanGridData);

		buttonMin = factory.createButton(composite, "Switch to lowest domination number graph", SWT.PUSH);
		buttonMin.setLayoutData(defaultGridData);
		buttonMin.setEnabled(false);

		buttonMax = factory.createButton(composite, "Switch to highest domination number graph", SWT.PUSH);
		buttonMax.setLayoutData(defaultGridData);
		buttonMax.setEnabled(false);

		buttonRestore = factory.createButton(composite, "Restore original graph", SWT.PUSH);
		buttonRestore.setLayoutData(spanGridData);
		buttonRestore.setEnabled(false);

		factory.createCLabel(composite, "Max domination number:"); //$NON-NLS-1$
		maxDomination = factory.createText(composite, ""); //$NON-NLS-1$
		maxDomination.setEditable(false);
		maxDomination.setLayoutData(defaultGridData);

		factory.createCLabel(composite, "Min domination number:"); //$NON-NLS-1$
		minDomination = factory.createText(composite, ""); //$NON-NLS-1$
		minDomination.setEditable(false);
		minDomination.setLayoutData(defaultGridData);

		factory.createCLabel(composite, "Average domination number:"); //$NON-NLS-1$
		avgDomination = factory.createText(composite, ""); //$NON-NLS-1$
		avgDomination.setEditable(false);
		avgDomination.setLayoutData(defaultGridData);
		

		buttonRun.addSelectionListener(new SelectionAdapter() {

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
						case 3:
							theGraph.setAlgorithm(new GreedyOptimizedDominationAlgorithm(theGraph));
							break;
						default:
							break;
						}
						minDomination.setText("Processing...");
						maxDomination.setText("Processing...");
						avgDomination.setText("Processing...");
						buttonRun.setEnabled(false);
						refresh();
						minDomination.redraw();

						StatisticsInfo statisticsInfo = new StatisticsInfo();
						statisticsInfo.setExecutionNumber(executionCount.getSelection());
						statisticsInfo.setFlipsNumber(flipsCount.getSelection());
						runStatistics = theGraph.getAlgorithm().runStatistics(statisticsInfo);

						minDomination.setText(String.valueOf(runStatistics.getMinDominationNumber()));
						maxDomination.setText(String.valueOf(runStatistics.getMaxDominationNumber()));
						avgDomination.setText(String.valueOf(runStatistics.getAverageDominationNumber()));

						buttonMax.setEnabled(true);
						buttonMin.setEnabled(true);

						new UpdateGraphFeature(getDiagramTypeProvider().getFeatureProvider())
								.execute(new CustomContext());
						refresh();

					}
				});

			}
		});

		buttonMax.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						if (theGraph == null)
							return;
						new ReplaceGraphCustomFeature(getDiagramTypeProvider().getFeatureProvider(),
								EcoreUtil.copy(runStatistics.getMaxGraph())).execute(new CustomContext());

						new UpdateGraphFeature(getDiagramTypeProvider().getFeatureProvider())
								.execute(new CustomContext());
						buttonRestore.setEnabled(true);

						refresh();

					}
				});

			}
		});

		buttonMin.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						if (theGraph == null)
							return;
						new ReplaceGraphCustomFeature(getDiagramTypeProvider().getFeatureProvider(),
								EcoreUtil.copy(runStatistics.getMinGraph())).execute(new CustomContext());

						new UpdateGraphFeature(getDiagramTypeProvider().getFeatureProvider())
								.execute(new CustomContext());
						buttonRestore.setEnabled(true);

						refresh();

					}
				});

			}
		});

		buttonRestore.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(theGraph);
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						if (theGraph == null)
							return;
						new ReplaceGraphCustomFeature(getDiagramTypeProvider().getFeatureProvider(),
								EcoreUtil.copy(runStatistics.getBackupGraph())).execute(new CustomContext());

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
		buttonRun.setEnabled(true);

	}
	

}

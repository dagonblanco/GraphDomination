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
 *    Bug 336488 - DiagramEditor API
 *
 * </copyright>
 *
 *******************************************************************************/
package graphdomgraphics.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import graphdomgraphics.common.GraphdomAbstractUIPlugin;
import graphdomgraphics.common.FileService;
import graphdomgraphics.common.Messages;

/**
 * The Class CreateDiagramWizard.
 */
public class CreateDiagramWizard extends BasicNewResourceWizard {

	private static final String DIAGRAM_PATH = "diagrams/";
	private static final String PAGE_NAME_DIAGRAM_TYPE = Messages.CreateDiagramWizard_DiagramTypeField;
	private static final String PAGE_NAME_DIAGRAM_NAME = Messages.CreateDiagramWizard_DiagramNameField;
	private static final String WIZARD_WINDOW_TITLE = Messages.CreateDiagramWizard_WizardTitle;

	private Diagram diagram;

	@Override
	public void addPages() {
		super.addPages();
		// Only ask for type if more than 1 available
		if (GraphitiUi.getExtensionManager().getDiagramTypes().length != 1){
			addPage(new DiagramTypeWizardPage(PAGE_NAME_DIAGRAM_TYPE));
		}
		addPage(new DiagramNameWizardPage(PAGE_NAME_DIAGRAM_NAME));
	}

	@Override
	public boolean canFinish() {
		return super.canFinish();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(WIZARD_WINDOW_TITLE);
	}

	@Override
	public boolean performFinish() {
		
		
		// Get diagram selection only if more than one diagram type available
		String diagramTypeId;
		if (GraphitiUi.getExtensionManager().getDiagramTypes().length != 1){
		ITextProvider typePage = (ITextProvider) getPage(PAGE_NAME_DIAGRAM_TYPE);
			diagramTypeId = typePage.getText();
		} else {
			// Diagram selected is the only available one
			diagramTypeId = GraphitiUi.getExtensionManager().getDiagramTypes()[0].getId();
		}

		ITextProvider namePage = (ITextProvider) getPage(PAGE_NAME_DIAGRAM_NAME);
		final String diagramName = namePage.getText();

		IProject project = null;
		IFolder diagramFolder = null;

		Object element = getSelection().getFirstElement();
		if (element instanceof IProject) {
			project = (IProject) element;
//		} else if (element instanceof AbstractInstancesOfTypeContainerNode) {
//			AbstractInstancesOfTypeContainerNode aiocn = (AbstractInstancesOfTypeContainerNode) element;
//			project = aiocn.getProject();
		} else if (element instanceof IFolder) {
			diagramFolder = (IFolder) element;
			project = diagramFolder.getProject();
		}

		if (project == null || !project.isAccessible()) {
			String error = Messages.CreateDiagramWizard_NoProjectFoundError;
			IStatus status = new Status(IStatus.ERROR, GraphdomAbstractUIPlugin.getID(), error);
			ErrorDialog.openError(getShell(), Messages.CreateDiagramWizard_NoProjectFoundErrorTitle, null, status);
			return false;
		}

		Diagram diagram = Graphiti.getPeCreateService().createDiagram(diagramTypeId, diagramName, true);
		if (diagramFolder == null) {
			diagramFolder = project.getFolder(DIAGRAM_PATH); //$NON-NLS-1$
		}

		String editorID = DiagramEditor.DIAGRAM_EDITOR_ID;
		String editorExtension = "diagram"; //$NON-NLS-1$
		String diagramTypeProviderId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagramTypeId);
		String namingConventionID = diagramTypeProviderId + ".editor"; //$NON-NLS-1$
		IEditorDescriptor specificEditor = PlatformUI.getWorkbench().getEditorRegistry().findEditor(namingConventionID);

		// If there is a specific editor get the file extension
		if (specificEditor != null) {
			editorID = namingConventionID;
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint("org.eclipse.ui.editors"); //$NON-NLS-1$
			IExtension[] extensions = extensionPoint.getExtensions();
			for (IExtension ext : extensions) {
				IConfigurationElement[] configurationElements = ext.getConfigurationElements();
				for (IConfigurationElement ce : configurationElements) {
					String id = ce.getAttribute("id"); //$NON-NLS-1$
					if (editorID.equals(id)) {
						String fileExt = ce.getAttribute("extensions"); //$NON-NLS-1$
						if (fileExt != null) {
							editorExtension = fileExt;
							break;
						}
					}

				}
			}
		}

		IFile diagramFile = diagramFolder.getFile(diagramName + "." + editorExtension); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);

		FileService.createEmfFileForDiagram(uri, diagram);
		String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
		DiagramEditorInput editorInput = new DiagramEditorInput(EcoreUtil.getURI(diagram), providerId);
		
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(editorInput, editorID);
		} catch (PartInitException e) {
			String error = Messages.CreateDiagramWizard_OpeningEditorError;
			IStatus status = new Status(IStatus.ERROR, GraphdomAbstractUIPlugin.getID(), error, e);
			ErrorDialog.openError(getShell(), Messages.CreateDiagramWizard_ErrorOccuredTitle, null, status);
			return false;
		}

		return true;
	}

	public Diagram getDiagram() {
		return diagram;
	}
}

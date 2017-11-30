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
package graphdomgraphics.common;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class GraphdomProjectNature implements IProjectNature {

	public static final String NATURE_ID = "graphdomgraphics.graphdomnature"; //$NON-NLS-1$

	IProject p;

	public void configure() throws CoreException {

	}

	public void deconfigure() throws CoreException {

	}

	public IProject getProject() {
		return p;
	}

	public void setProject(IProject project) {
		p = project;

	}
}

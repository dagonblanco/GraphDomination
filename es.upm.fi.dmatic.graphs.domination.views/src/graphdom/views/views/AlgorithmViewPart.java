package graphdom.views.views;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

public class AlgorithmViewPart extends ViewPart {

	ListViewer viewer;
    Action initAlgorithm, stepAlgorithm, endAlgorithm;
    IMemento memento;
    
	public AlgorithmViewPart() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
            super.init(site);
            // Normally we might do other stuff here.
    }
	
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
        // Create viewer.
     viewer = new ListViewer(parent);
        //viewer.setContentProvider(new WordContentProvider());
        viewer.setLabelProvider(new LabelProvider());
        

        // Create menu and toolbars.
        createActions();
        //createMenu();
        //createToolbar();
        //createContextMenu();
       // hookGlobalActions();
        
        // Restore state from the previous session.
     restoreState();
	}

	private void restoreState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
	
    public void createActions() {
        Action initAlgorithAction = new Action("Initialize...") {
                public void run() { 
                           initialize();
                   }
           };
        initAlgorithAction.setImageDescriptor(getImageDescriptor("add.gif"));
        
         Action  deleteItemAction = new Action("Delete") {
                   public void run() {
                           deleteItem();
                   }
           };
           deleteItemAction.setImageDescriptor(getImageDescriptor("delete.gif"));
           
           // Add selection listener.
        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
                   public void selectionChanged(SelectionChangedEvent event) {
                           updateActionEnablement();
                   }
           });
   }

}

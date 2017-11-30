package graphdom.views.views;

import java.io.File;
import java.net.*;
import java.util.*;

import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.*;
import org.eclipse.ui.part.ViewPart;

/**
 * A WordView shows a bunch of words.
 */
public class WordView extends ViewPart 
{
	//WordFile input;
	ListViewer viewer;
	Action addItemAction, deleteItemAction, selectAllAction;
	IMemento memento;
	
	/**
	 * Constructor
	 */
	public WordView() {
		super();
		input = new WordFile(new File("list.lst"));
	}

	/**
	 * @see IViewPart.init(IViewSite)
	 */
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
	}

	/**
	 * Initializes this view with the given view site.  A memento is passed to
 	 * the view which contains a snapshot of the views state from a previous
	 * session.  	
	 */
	public void init(IViewSite site,IMemento memento) throws PartInitException {
		init(site);
		this.memento = memento;	
	}
	
	/**
	 * @see IWorkbenchPart#createPartControl(Composite)
	 */
	public void createPartControl(Composite parent) {
		// Create viewer.
		viewer = new ListViewer(parent);
		viewer.setContentProvider(new WordContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		viewer.setInput(input);
		getSite().setSelectionProvider(viewer);

		// Create menu and toolbars.
		createActions();
		createMenu();
		createToolbar();
		createContextMenu();
		hookGlobalActions();
		
		// Restore state from the previous session.
		restoreState();
	}
	
	/**
	 * @see WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * Create the actions.
	 */
	public void createActions() {
		addItemAction = new Action("Add...") {
			public void run() { 
				addItem();
			}
		};
		addItemAction.setImageDescriptor(getImageDescriptor("add.gif"));
		deleteItemAction = new Action("Delete") {
			public void run() {
				deleteItem();
			}
		};
		deleteItemAction.setImageDescriptor(getImageDescriptor("delete.gif"));
		selectAllAction = new Action("Select All") {
			public void run() {
				selectAll();
			}
		};
		
		// Add selection listener.
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateActionEnablement();
			}
		});
	}

	/**
	 * Returns the image descriptor with the given relative path.
	 */
	private ImageDescriptor getImageDescriptor(String relativePath) {
		String iconPath = "icons/";
		try {
			ViewsPlugin plugin = ViewsPlugin.getDefault();
			URL installURL = plugin.getDescriptor().getInstallURL();
			URL url = new URL(installURL, iconPath + relativePath);
			return ImageDescriptor.createFromURL(url);
		}
		catch (MalformedURLException e) {
			// should not happen
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
	
	/**
	 * Create menu.
	 */
	private void createMenu() {
		IMenuManager mgr = getViewSite().getActionBars().getMenuManager();
		mgr.add(selectAllAction);
	}
	
	/**
	 * Create toolbar.
	 */
	private void createToolbar() {
		IToolBarManager mgr = getViewSite().getActionBars().getToolBarManager();
		mgr.add(addItemAction);
		mgr.add(deleteItemAction);
	}
		
	/**
	 * Create context menu.
	 */
	private void createContextMenu() {
		// Create menu manager.
		MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillContextMenu(mgr);
			}
		});
		
		// Create menu.
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		
		// Register menu for extension.
		getSite().registerContextMenu(menuMgr, viewer);
	}

	/**
	 * Hook global actions
	 */
	private void hookGlobalActions() {
		IActionBars bars = getViewSite().getActionBars();
		bars.setGlobalActionHandler(IWorkbenchActionConstants.SELECT_ALL, selectAllAction);
		bars.setGlobalActionHandler(IWorkbenchActionConstants.DELETE, deleteItemAction);
		viewer.getControl().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if (event.character == SWT.DEL && 
					event.stateMask == 0 && 
					deleteItemAction.isEnabled()) 
				{
					deleteItemAction.run();
				}
			}
		});
	}
		
	private void fillContextMenu(IMenuManager mgr) {
		mgr.add(addItemAction);
		mgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		mgr.add(deleteItemAction);
		mgr.add(new Separator());
		mgr.add(selectAllAction);
	}
	private void updateActionEnablement() {
		IStructuredSelection sel = 
			(IStructuredSelection)viewer.getSelection();
		deleteItemAction.setEnabled(sel.size() > 0);
	}
	
	/**
	 * Add item to list.
	 */
	private void addItem() {
		String name = promptForValue("Enter name:", null);
		if (name != null) {
			Word word = new Word(name);
			input.add(word);
			viewer.setSelection(new StructuredSelection(word));
		}
	}
	
	/**
	 * Remove item from list.
	 */
	private void deleteItem() {
		IStructuredSelection sel = 
			(IStructuredSelection)viewer.getSelection();
		Iterator iter = sel.iterator();
		while (iter.hasNext()) {
			Word word = (Word)iter.next();
			input.remove(word);
		}
	}

	/**
	 * Select all items.
	 */
	private void selectAll() {
		viewer.getList().selectAll();
		updateActionEnablement();
	}
		
	/**
	 * Ask user for value.
	 */
	private String promptForValue(String text, String oldValue) {
		InputDialog dlg = new InputDialog(getSite().getShell(), 
			"List View", text, oldValue, null);
		if (dlg.open() != Window.OK)
			return null;
		return dlg.getValue();
	}
	
	/**
	 * Saves the object state within a memento.
	 */
	public void saveState(IMemento memento){
		IStructuredSelection sel = (IStructuredSelection)viewer.getSelection();
		if (sel.isEmpty())
			return;
		memento = memento.createChild("selection");
		Iterator iter = sel.iterator();
		while (iter.hasNext()) {
			Word word = (Word)iter.next();
			memento.createChild("descriptor", word.toString());
		}
	}

	/**
	 * Restores the viewer state from the memento.
	 */
	private void restoreState() {
		if (memento == null)
			return;
		memento = memento.getChild("selection");
		if (memento != null) {
			IMemento descriptors [] = memento.getChildren("descriptor");
			if (descriptors.length > 0) {
				ArrayList objList = new ArrayList(descriptors.length);
				for (int nX = 0; nX < descriptors.length; nX ++) {
					String id = descriptors[nX].getID();
					Word word = input.find(id);
					if (word != null)
						objList.add(word);		
				}
				viewer.setSelection(new StructuredSelection(objList));
			}
		}
		memento = null;
		updateActionEnablement();
	}	
}

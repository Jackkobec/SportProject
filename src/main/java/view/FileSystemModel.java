package view;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.io.File;
import java.util.Enumeration;
import java.util.Vector;

class FileSystemModel implements TreeModel {
    private String root; // The root identifier

    private Vector listeners; // Declare the listeners vector

    public FileSystemModel() {
        File[] froots = File.listRoots();
        String mainRoot = froots[0].getAbsolutePath();
        //root = System.getProperty("user.dir");
        root = mainRoot;
        // File tempFile = new File(root);
        File tempFile = new File(root);
        // root = tempFile.getParent();
        root = tempFile.getPath();
        listeners = new Vector();

    }

    public Object getRoot() {
        return (new File(root));
    }


    public Object getChild(Object parent, int index) {
        File directory = (File) parent;
        String[] directoryMembers = directory.list();
        return (new File(directory, directoryMembers[index]));
    }


    public int getChildCount(Object parent) {
        File fileSystemMember = (File) parent;
        if (fileSystemMember.isDirectory()) {
            String[] directoryMembers = fileSystemMember.list();
            return directoryMembers.length;
        } else {

            return 0;
        }
    }

    public int getIndexOfChild(Object parent, Object child) {
        File directory = (File) parent;
        File directoryMember = (File) child;
        String[] directoryMemberNames = directory.list();
        int result = -1;

        for (int i = 0; i < directoryMemberNames.length; ++i) {
            if (directoryMember.getName().equals(directoryMemberNames[i])) {
                result = i;
                break;
            }
        }

        return result;
    }

    public boolean isLeaf(Object node) {
        return ((File) node).isFile();
    }

    public void addTreeModelListener(TreeModelListener l) {
        if (l != null && !listeners.contains(l)) {
            listeners.addElement(l);
        }
    }

    public void removeTreeModelListener(TreeModelListener l) {
        if (l != null) {
            listeners.removeElement(l);
        }
    }

    public void valueForPathChanged(TreePath path, Object newValue) {
        // Does Nothing!
    }

    public void fireTreeNodesInserted(TreeModelEvent e) {
        Enumeration listenerCount = listeners.elements();
        while (listenerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();
            listener.treeNodesInserted(e);
        }
    }

    public void fireTreeNodesRemoved(TreeModelEvent e) {
        Enumeration listenerCount = listeners.elements();
        while (listenerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();
            listener.treeNodesRemoved(e);
        }

    }

    public void fireTreeNodesChanged(TreeModelEvent e) {
        Enumeration listenerCount = listeners.elements();
        while (listenerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();
            listener.treeNodesChanged(e);
        }

    }

    public void fireTreeStructureChanged(TreeModelEvent e) {
        Enumeration listenerCount = listeners.elements();
        while (listenerCount.hasMoreElements()) {
            TreeModelListener listener = (TreeModelListener) listenerCount.nextElement();
            listener.treeStructureChanged(e);
        }

    }
}
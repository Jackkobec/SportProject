package view.view_components;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import java.util.EventObject;

/**
 * CellEditorCurrentResaltTable
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class CellEditorCurrentResaltTable implements CellEditor {

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return false;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return false;
    }

    @Override
    public boolean stopCellEditing() {
        return false;
    }

    @Override
    public void cancelCellEditing() {

    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {

    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {

    }
}

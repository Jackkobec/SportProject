package view;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.HashSet;
import java.util.Set;

/**
 * CurrentResaltTableModel
 */
public class CurrentResaltTableModel extends AbstractTableModel {
    protected int userChooseNamberOfRepeats;
    protected Object[][] data;

    //обращаемся к внутрененму конструктору и передаем дефалтовое значение колисчества колонок
    public CurrentResaltTableModel() {
        this(3);
    }

    public CurrentResaltTableModel(int ColumnCount) {
        userChooseNamberOfRepeats = ColumnCount;
        this.data = new Object[1][ColumnCount];
        for (int i = 0; i < (ColumnCount); i++) {
            data[0][i] = "";

        }
    }

    public Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return userChooseNamberOfRepeats;
    }
//


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //запрет редактирования колонки резатултата
//        if (rowIndex == 0 && columnIndex == userChooseNamberOfRepeats) {
//            return false;
//        }
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      /*  public void setValueAt(Object value, int row, int col) {
            rowData[row][col] = value;
            fireTableCellUpdated(row, col);
        }*/
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public String getColumnName(int columnIndex) {
        final String columnName = "Подход " + (columnIndex + 1);

        switch (columnIndex) {
            case 0:
                return columnName;
            case 1:
                return columnName;
            case 2:
                return columnName;
            case 3:
                return columnName;
            case 4:
                return columnName;
            case 5:
                return columnName;
            case 6:
                return columnName;
            case 7:
                return columnName;
        }
        return null;
    }


}

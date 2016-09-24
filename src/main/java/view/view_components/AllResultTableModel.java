package view.view_components;

import model.roles.Gymnastic;
import view.CurrentResaltTableModel;

import java.util.List;

/**
 * AllResultTableModel
 */
public class AllResultTableModel extends CurrentResaltTableModel {
    public List<Gymnastic> defaultGymnastics;
   // public Object[][] data2;
    int RowCount;
    int ColumnCount;

    public AllResultTableModel(List<Gymnastic> defaultGymnastics) {
        this.defaultGymnastics = defaultGymnastics;
        this.RowCount = RowCount;
        this.ColumnCount = ColumnCount;
        this.data = new Object[7][defaultGymnastics.size()];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < defaultGymnastics.size(); j++) {
               data[i][j] = "";
            }
        }
    }
//    public AllResultTableModel(List<Gymnastic> defaultGymnastics, int RowCount, int ColumnCount) {
//        this.defaultGymnastics = defaultGymnastics;
//        this.RowCount = RowCount;
//        this.ColumnCount = ColumnCount;
//        this.data2 = new Object[RowCount][ColumnCount];
//        for (int i = 0; i < RowCount; i++) {
//            for (int j = 0; j < ColumnCount; j++) {
//                data2[i][j] = "";
//            }
//        }
//    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //запрет редактирования колонки резатултата
//        if (rowIndex == 0 && columnIndex == userChooseNamberOfRepeats) {
//            return false;
//        }
        return false;
    }

    @Override
    public int getRowCount() {
        return 7;
    }

    @Override
    public int getColumnCount() {
        return defaultGymnastics.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public String getColumnName(int columnIndex) {
        final String columnName = defaultGymnastics.get(columnIndex).getName() + "";

        return columnName;
    }


}

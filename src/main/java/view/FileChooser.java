package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FileChooser
 */
public class FileChooser extends JPanel {
    public JFileChooser fc;

    public FileChooser() {
        super(new BorderLayout());

        //Create a file chooser
        fc = new JFileChooser();
        //disable the all extention selection
        fc.setAcceptAllFileFilterUsed(false);
        //filter for extention *.TRN
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TRN", "*.*");
        fc.setFileFilter(filter);
        //fc.showOpenDialog(FileChooser.this);
        setVisible(true);

    }
}
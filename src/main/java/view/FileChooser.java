package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * FileChooser
 */
public class FileChooser extends JPanel implements ActionListener {
   public JFileChooser fc;

    public FileChooser() {
        super(new BorderLayout());

        //Create a file chooser
        fc = new JFileChooser();
        //fc.showOpenDialog(FileChooser.this);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {

    }
}
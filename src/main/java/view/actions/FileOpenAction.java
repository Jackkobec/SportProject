package view.actions;

import view.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

/**
 * Created by Стас on 20.09.2016.
 */
public class FileOpenAction extends AbstractAction {
    final private FileChooser fileChooser;

    public FileOpenAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
        super(text, icon);
        fileChooser = new FileChooser();
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.fc.showOpenDialog(new FileChooser());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.fc.getSelectedFile();
        }
    }
}

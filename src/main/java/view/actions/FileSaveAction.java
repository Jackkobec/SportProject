package view.actions;

import view.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * FileSaveAction
 */
public class FileSaveAction extends AbstractAction {
    final private FileChooser fileChooser;

    public FileSaveAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
        super(text, icon);
        fileChooser = new FileChooser();
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int returnVal = fileChooser.fc.showSaveDialog(new FileChooser());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.fc.getSelectedFile();
        }
    }
}

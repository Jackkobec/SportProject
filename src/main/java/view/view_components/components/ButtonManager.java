package view.view_components.components;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jack on 22.10.2016.
 */
public class ButtonManager {
    private JButton saveAndStart;

    public JButton createDisabletButton() {
        saveAndStart = new JButton("Save and Start");
        saveAndStart.setEnabled(false);
        return saveAndStart;
    }

    public void setEnableButton() {
        saveAndStart.setEnabled(true);
    }

    public void changeButtonColor(Color color) {
        saveAndStart.setForeground(color);
    }
}

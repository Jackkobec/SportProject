package view.view_components.components;

import view.MainFrameTraining;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jack on 22.10.2016.
 */
public class ButtonManager implements ActionListener {
    private JButton saveAndStart;

    public JButton createDisabletButton() {
        saveAndStart = new JButton("Save and Start");
        saveAndStart.setEnabled(false);
        saveAndStart.addActionListener(this);
        return saveAndStart;
    }

    public void setEnableButton() {
        saveAndStart.setEnabled(true);
    }

    public void changeButtonColor(Color color) {
        saveAndStart.setForeground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //String cmd = e.getActionCommand();

        new MainFrameTraining();
    }
}

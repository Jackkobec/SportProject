package view.view_components.components.splitpane;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Jack on 21.10.2016.
 */
public class GymSelectionMouseAdapter extends MouseAdapter {
    private String url = "github.com/jackkobec";
    private static JFrame controllingFrame; //needed for dialogs

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            JOptionPane.showMessageDialog(controllingFrame,
                    "Invalid password. Try again.\nEnter your Password. Length: 3-15, Symbols: A-Z,a-z,0-9_",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

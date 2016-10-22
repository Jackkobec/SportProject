package view.view_components.components.splitpane;

import view.view_components.components.ButtonManager;
import view.view_components.components.listpane.MyListPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * GymSelectionMouseAdapter
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class GymSelectionMouseAdapter extends MouseAdapter {
    private static JFrame controllingFrame; //needed for dialogs
    private MySplitPane mySplitPane;
    private MyListPane myListPane;
    ButtonManager buttonManager;

    public GymSelectionMouseAdapter(MySplitPane mySplitPane, MyListPane myListPane, ButtonManager buttonManager) {
        this.mySplitPane = mySplitPane;
        this.myListPane = myListPane;
        this.buttonManager = buttonManager;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (myListPane.addToTheEndOfList(mySplitPane.list.getSelectedValue().toString())) {

                JOptionPane.showMessageDialog(controllingFrame,
                        "Упражнение " + mySplitPane.list.getSelectedValue().toString() + " добавлено.",
                        "Info Message",
                        JOptionPane.INFORMATION_MESSAGE);
                buttonManager.changeButtonColor(Color.RED);
                buttonManager.setEnableButton();
            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                        "Упражнение уже есть в списке",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

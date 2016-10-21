package view.actions;

import controller.internetActions.InternetActionsImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Jack on 21.10.2016.
 */
public class LinkMouseAdapter extends MouseAdapter {
    private String url = "github.com/jackkobec";

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            new InternetActionsImpl().runBrowser(url);
        }
    }
}

package controller.internetActions;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * InternetActionsImpl
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class InternetActionsImpl implements InternetActions {

    @Override
    public  void runBrowser(String url) {
        Desktop desktop;

        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                // launch browser
                URI uri;
                try {
                    uri = new URI("https://" + url);
                    desktop.browse(uri);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (URISyntaxException use) {
                    use.printStackTrace();
                }
            }
        }
    }
}

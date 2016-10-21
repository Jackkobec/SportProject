package controller.internetActions;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Jack on 21.10.2016.
 */
public class InternetActionsImpl {
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

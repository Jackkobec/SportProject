package view.view_components;

import view.view_components.components.ButtonManager;
import view.view_components.components.listpane.MyListPane;

/**
 * CommunicationFactoryForMouseAdapter
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class CommunicationFactoryForMouseAdapter {
    ButtonManager buttonManager;
    public MyListPane myListPane;

    public CommunicationFactoryForMouseAdapter(ButtonManager buttonManager) {
        this.myListPane = new MyListPane(this.buttonManager = buttonManager);
    }
}

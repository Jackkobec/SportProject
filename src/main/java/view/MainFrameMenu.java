package view;

import view.actions.FileOpenAction;
import view.actions.FileSaveAction;
import view.view_components.components.MenuLookDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * MainFrameMenu
 */
public class MainFrameMenu implements ActionListener {
    //  private static String OPEN = "open";
    JTextArea output;
    JScrollPane scrollPane;
    FileChooser menuFileChoser = new FileChooser();
    Font font = new Font("Tamoha", Font.BOLD, 14);

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu(" File  ");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

        ImageIcon icon = new ImageIcon("D://open.gif");
        Action fileOpenAction = new FileOpenAction("Open new Private File", icon, "Open new Private File", KeyEvent.VK_F);
        //a group of JMenuItems
        menuItem = new JMenuItem(fileOpenAction);
        menuItem.setBackground(Color.orange);
        menuItem.setFont(font);
//        menuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int returnVal = menuFileChoser.fc.showOpenDialog(new FileChooser());
//                if (returnVal == JFileChooser.APPROVE_OPTION) {
//                    File file = menuFileChoser.fc.getSelectedFile();
//                }
//            }
//        });
        //setMnemonic - это буква, которая подчеркивается
        menuItem.setMnemonic(KeyEvent.VK_F); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));

        // menuItem.setActionCommand(OPEN);
        menu.add(menuItem);
       //Toolkit.getDefaultToolkit().getImage("java/view/icons/open.png");

        menuItem = new JMenuItem("Both text and icon", icon);
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(icon);
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);
        //
        menu.addSeparator();
        ImageIcon icon2 = new ImageIcon("D://save.gif");
        FileSaveAction fileSaveAction = new FileSaveAction("Save", icon2, "Save Private File", KeyEvent.VK_S);
        menuItem = new JMenuItem(fileSaveAction);
        menuItem.setBackground(Color.cyan);
        menuItem.setFont(font);
        menu.add(menuItem);

        //a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();

        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        //a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator(); // єто линия между строками в меню
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);

        menu.add(submenu);

        //Build second menu in the menu bar.
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);

        return menuBar;
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MainFrameMenu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
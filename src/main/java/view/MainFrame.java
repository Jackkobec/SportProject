package view;

import view.view_components.components.MenuLookDemo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Стас on 19.09.2016.
 */
public class MainFrame extends JFrame {
    private final JTabbedPane pane = new JTabbedPane();

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int sizeWidth = 800;
    public static int sizeHeight = 600;
    public int locationX = (screenSize.width - sizeWidth) / 2;
    public int locationY = (screenSize.height - sizeHeight) / 2;

    public MainFrame() throws HeadlessException {

        setLayout(new BorderLayout());
        setTitle("Sport Application");

        setBounds(locationX, locationY, sizeWidth, sizeHeight);

        setBounds(locationX, locationY, sizeWidth, sizeHeight);


        addComponents(getContentPane());
        getRootPane().setBackground(Color.orange);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    private void addComponents(Container contentPane) {
        contentPane.setLayout(new BorderLayout());

        Font font = new Font("Tamoha", Font.BOLD, 16);
        MainFrameMenu mfm = new MainFrameMenu();
        JMenuBar menuBar = mfm.createMenuBar();
        menuBar.setBackground(Color.ORANGE.brighter());
        menuBar.setFont(font);

        contentPane.setBackground(Color.ORANGE.darker());
        contentPane.add(menuBar, BorderLayout.NORTH);
    }
}
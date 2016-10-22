package view.view_components.components.splitpane;

import view.view_components.CommunicationFactoryForMouseAdapter;
import view.view_components.components.ButtonManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * MySplitPane
 *
 * @author Jack
 * @email jackkobec@gmail.com
 * @skype skypejs77
 */
public class MySplitPane extends JPanel
        implements ListSelectionListener {
    private JLabel picture;
    public JList list;
    private JSplitPane splitPane;
    private String[] imageNames = {"Отжимания", "Брусья", "Подтягивания", "Приседания", "Подъемы ног", "Борцовский мостик"};

    private JLabel label;
    public GymSelectionMouseAdapter gymSelectionMouseAdapter;
    private CommunicationFactoryForMouseAdapter communicationFactoryForMouseAdapter;
    ButtonManager buttonManager;

    public MySplitPane(CommunicationFactoryForMouseAdapter communicationFactoryForMouseAdapter, ButtonManager buttonManager) {
        this.communicationFactoryForMouseAdapter = communicationFactoryForMouseAdapter;
        this.buttonManager = buttonManager;
        this.gymSelectionMouseAdapter = new GymSelectionMouseAdapter(this, communicationFactoryForMouseAdapter.myListPane, buttonManager);

        list = new JList(imageNames);
        list.setBackground(Color.orange);//
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);


        JScrollPane listScrollPane = new JScrollPane(list);
        picture = new JLabel();
        picture.setFont(picture.getFont().

                deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);

        JScrollPane pictureScrollPane = new JScrollPane(picture);
       // pictureScrollPane.setMinimumSize(new Dimension(220,170));
        //Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                listScrollPane, pictureScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);

        //Provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(150, 50);
        Dimension minimumSizePicture = new Dimension(230, 170);
        listScrollPane.setMinimumSize(minimumSize);
        //pictureScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSizePicture);

        //Provide a preferred size for the split pane.
        splitPane.setPreferredSize(new Dimension(400, 200));

        updateLabel(imageNames[list.getSelectedIndex()]);
///
        getImageList().addListSelectionListener(this);

        JSplitPane top = getSplitPane();
        top.setBorder(null);

        //Create a regular old label
        label = new JLabel("Выберете упражнение и нажмите чтобы добавить",
                JLabel.CENTER);

        //Create a split pane and put "top" (a split pane)
        //and JLabel instance in it.
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                top, label);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(180);
        splitPane.setBackground(Color.ORANGE.brighter());//

        //Provide minimum sizes for the two components in the split pane
        top.setMinimumSize(new Dimension(100, 50));//
        Font font = new Font("Tamoha", Font.BOLD, 14);
        label.setMinimumSize(new Dimension(100, 30));
        //label.setForeground(Color.blue);
        label.setFont(font);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setToolTipText("Кликнете чтобы добавить себе");
        label.addMouseListener(gymSelectionMouseAdapter);//listeer
        //Add the split pane to this frame
        //getContentPane().add(splitPane);

    }


    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        updateLabel(imageNames[list.getSelectedIndex()]);

        if (e.getValueIsAdjusting())
            return;

        JList theList = (JList) e.getSource();
        if (theList.isSelectionEmpty()) {
            label.setText("Nothing selected.");
        } else {
            int index = theList.getSelectedIndex();
            // label.setText("Selected image number " + index);
            label.setText("Добавить себе упражнение: " + theList.getSelectedValue());
        }
    }
    //src/main/java/resources/Bird.gif
   // C:\Users\Jack\IdeaProjects\SportProject\src\main\java\view\view_components\components\splitpane\images\Bird.gif
    //src/main/java/view/view_components/components/splitpane/
    //Renders the selected image
    public void updateLabel(String name) {
       // ImageIcon icon = createImageIcon("images/" + name + ".gif");
       // ImageIcon icon = createImageIcon("C:\\Users\\Jack\\IdeaProjects\\SportProject\\src\\main\\java\\resources\\Bird.gif");
       // ImageIcon icon = new ImageIcon("src/main/java/view/view_components/components/splitpane/images/" + name + ".gif");//worked
        ImageIcon icon = new ImageIcon("src/main/java/view/view_components/components/splitpane/images/" + name + ".jpg");//worked
        picture.setIcon(icon);
      //  picture.addMouseListener(gymSelectionMouseAdapter);// вызывает дедлок программы
        if (icon != null) {
            picture.setText(null);
        } else {
            picture.setText("Image not found");
        }
    }

    public JList getImageList() {
        return list;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }


    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MySplitPane.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


   /* private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("MySplit Pane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MySplitPane mySplitPanel = new MySplitPane();//split panel
        frame.getContentPane().add(mySplitPanel.getSplitPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }*/
}

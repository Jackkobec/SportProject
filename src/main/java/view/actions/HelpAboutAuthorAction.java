package view.actions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Jack on 17.10.2016.
 */
public class HelpAboutAuthorAction extends AbstractAction {

    private static int sizeWidth = 435;
    private static int sizeHeight = 520;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int locationX = (screenSize.width - sizeWidth) / 2;
    private int locationY = (screenSize.height - sizeHeight) / 2;
    private LinkMouseAdapter linkMouseAdapter = new LinkMouseAdapter();

    public HelpAboutAuthorAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
        super(text, icon);
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel aboutAuthorLabel = new JLabel("<html><font size=\"5\" color=\"orange\" face=\"Arial\">Информация об авторе:</font></html>");
        aboutAuthorLabel.setHorizontalAlignment(JLabel.CENTER);
        //HAND_CURSOR when touch
        aboutAuthorLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //move link after left click
        aboutAuthorLabel.addMouseListener(linkMouseAdapter);

        JPanel imgPanel = new JPanel() {
            public void paint(Graphics g) {
                super.paint(g);
                try {
                    Image img = ImageIO.read(new File("src/main/java/view/icons/Author.png"));
                    g.drawImage(img, 5, 5, null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        imgPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imgPanel.addMouseListener(linkMouseAdapter);

        JPanel authorContactsPanel = new JPanel(new GridLayout(3, 0));
        JLabel skypeLabel = new JLabel("<html><font size=\"5\" color=\"orange\" face=\"Arial\">Skype: </font>" +
                "<font size=\"5\" color=\"green\" face=\"Arial\">skypejs77</font>");
        skypeLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel emailLabel = new JLabel("<html><font size=\"5\" color=\"orange\" face=\"Arial\">Email: </font>" +
                "<font size=\"5\" color=\"green\" face=\"Arial\">jackkobec@gmail.com</html>");
        emailLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton copyButton = new JButton("Копировать данные");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This method writes a string to the system clipboard.
                // otherwise it returns null.

                StringSelection ss = new StringSelection("Skype: skypejs77" + "\n" + "Email: jackkobec@gmail.com");
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
                JOptionPane.showMessageDialog(null,
                        "Данные скопированы в буфер обмена.\n" +
                                "Skype: skypejs77\n" +
                                "Email:   jackkobec@gmail.com",
                        "Информация об авторе скоп\nирована",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        });
        authorContactsPanel.add(skypeLabel);
        authorContactsPanel.add(emailLabel);
        authorContactsPanel.add(copyButton);

        JFrame aboutAuthorFrame = new JFrame();
        aboutAuthorFrame.setLayout(new BorderLayout());
        aboutAuthorFrame.setTitle("About Aothor");

        aboutAuthorFrame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
        aboutAuthorFrame.setMinimumSize(new Dimension(435, 520));
        aboutAuthorFrame.add(aboutAuthorLabel, BorderLayout.NORTH);
        aboutAuthorFrame.add(imgPanel, BorderLayout.CENTER);
        aboutAuthorFrame.add(authorContactsPanel, BorderLayout.SOUTH);
        aboutAuthorFrame.setVisible(true);
    }
}

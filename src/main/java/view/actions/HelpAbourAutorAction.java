package view.actions;

import view.FileChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.Color.orange;

/**
 * Created by Jack on 17.10.2016.
 */
public class HelpAbourAutorAction extends AbstractAction {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int sizeWidth = 435;
    public static int sizeHeight = 520;
    public int locationX = (screenSize.width - sizeWidth) / 2;
    public int locationY = (screenSize.height - sizeHeight) / 2;

    public HelpAbourAutorAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
        super(text, icon);
        putValue(SHORT_DESCRIPTION, desc);
        putValue(MNEMONIC_KEY, mnemonic);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JLabel aboutAuthorLabel = new JLabel("<html><font size=\"5\" color=\"orange\" face=\"Arial\">Информация об авторе:</font></html>");
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

        JPanel authorContactsPanel = new JPanel(new GridLayout(3, 0));
        JLabel skypeANDmail = new JLabel("<html><font size=\"5\" color=\"orange\" face=\"Arial\">Skype: </font>" +
                "<font size=\"5\" color=\"green\" face=\"Arial\">skypejs77</font>" +
                "<font size=\"5\" color=\"orange\" face=\"Arial\">Email: </font>" +
                "<font size=\"5\" color=\"green\" face=\"Arial\">jackkobec@gmail.com</html>"
        );

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
                                "Email: jackkobec@gmail.com",
                        "Информация об авторе скоп\nирована",
                        JOptionPane.INFORMATION_MESSAGE);

            }
        });
        authorContactsPanel.add(skypeANDmail);
        authorContactsPanel.add(copyButton);

        JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
        f.setTitle("About Aothor");

        f.setBounds(locationX, locationY, sizeWidth, sizeHeight);
        f.setMinimumSize(new Dimension(435, 520));
        f.add(aboutAuthorLabel, BorderLayout.NORTH);
        f.add(imgPanel, BorderLayout.CENTER);
        f.add(authorContactsPanel, BorderLayout.SOUTH);
        f.setVisible(true);
    }
}

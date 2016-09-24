package view.view_components.components;

/**
 * VerticalButton
 */
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JToggleButton;

public class VerticalButton extends JButton {

    XButton template;
    boolean clockwise;

    public VerticalButton(String text, boolean clockwise) {
        template = new XButton(text, getFont());
        this.clockwise = clockwise;

        Dimension d = template.getPreferredSize();
        setPreferredSize(new Dimension(d.height, d.width));
    }

    public void setFont(Font font) {
        super.setFont(font);
        if (template != null) {
            template.setFont(font);
        }
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        Dimension d = getSize();
        template.setSize(d.height, d.width);

        if (clockwise) {
            g2.rotate(Math.PI / 2.0);
            g2.translate(0, -getSize().width);
        } else {
            g2.translate(0, getSize().height);
            g2.rotate(-Math.PI / 2.0);
        }
        template.setSelected(this.getModel().isPressed());
        template.paintComponent(g2);
        g2.dispose();
    }

    private class XButton extends JToggleButton {
        XButton(String text, Font font) {
            super(text);
            setFont(font);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }
}
package org.example;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.awt.*;
import javax.swing.*;

public class GUI {
    public static String ThemeButton = "Dark Theme";
    public static String WhiteColorCode = "#FFFFFF";
    public static String BlackColorCode = "#22222B";
    public static String DarkBlueColorCode = "#003366";
    public static String LightBlueColorCode = "#027EFA";
    public static String LightGreyColorCode = "#919090";
    public static String DarkGreyColorCode = "#525151";





    // rectangle data type that contain 4 piece of data
    private final Rectangle box = new Rectangle();

    public void setPosition(Component comp, int x, int y, int w, int h) {
        box.setRect(x, y, w, h);
        comp.setBounds(box);
    }

    public void setPositionCenter(Component comp, Container parent, int w, int h) {
        int pW = parent.getWidth();
        int pH = parent.getHeight();
        int x = (pW - w) / 2;
        int y = (pH - h) / 2;
        setPosition(comp, x, y, w, h);

    }

    public void setPositionRelative(Component target, Component newComp, int offsetX, int offsetY, int w, int h) {
        int x = target.getX() + offsetX;
        int y = target.getY() + offsetY;

        setPosition(newComp, x, y, w, h);
    }

    /*
        //Label method (with font and font size)
        public JLabel createLabel(String text, int x, int y, int w, int h, String font, int size, int style) {
            JLabel label = new JLabel(text);
            label.setFont(new Font(font, style, size));
            setPosition(label, x, y, w, h);
            return label;
        }
        //Label method (default one without font and font size)
        public JLabel createLabel(String text, int x, int y, int w, int h) {
            JLabel label = new JLabel(text);
            label.setFont(new Font("Arial", Font.PLAIN, 14));
            setPosition(label, x, y, w, h);
            return label;
        }
        //Label method center






        //Text field method

        public JTextField createTextField(int col, int x, int y, int w, int h){
            JTextField textField = new JTextField(col);
            setPosition(textField, x, y, w, h);
            return textField;
        }
        //Button method
        public JButton createButton (String text, int x, int y, int w, int h) {
            JButton button = new JButton(text);
            setPosition(button, x, y, w, h);
            return button;
        }
    */
    public void ThemeChange() {
        //if Theme_status == false (default) then light mode else dar mode
        if (Main.Theme_status) {
            ThemeButton = "Dark Theme";
            WhiteColorCode = "#22222B";
            BlackColorCode = "#FFFFFF";
            DarkBlueColorCode = "#027EFA";
            LightBlueColorCode = "#003366";

        } else {
            ThemeButton = "Light Theme";
            WhiteColorCode = "#FFFFFF";
            BlackColorCode = "#22222B";
            DarkBlueColorCode = "#003366";
            LightBlueColorCode = "#027EFA";
        }


    }

    public static class GlassButton extends JButton {
        public GlassButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setForeground(Color.WHITE);
            setFont(new Font("Arial", Font.BOLD, 14));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();
            int arc = 30;

            // dark transparent base
            g2.setColor(new Color(0, 102, 255, 60));
            g2.fillRoundRect(0, 0, w, h, arc, arc);

            // top shine (bright white streak)
            g2.setColor(new Color(0, 102, 255,  70));
            g2.fillRoundRect(4, 4, w - 8, h / 3, arc, arc);

            // bottom subtle reflection
            g2.setColor(new Color(0, 102, 255, 60));
            g2.fillRoundRect(0, 0, w, h, arc, arc);

            // border
            g2.setColor(new Color(0, 102, 255, 150));
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(1, 1, w - 2, h - 2, arc, arc);

            g2.dispose();
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {}
    }

    public static class GlassPanel extends JPanel {
        public GlassPanel() {
            setOpaque(false);
            setLayout(null);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();
            int arc = 30;

            // color brightness --> a
            g2.setColor(new Color(0, 0, 0, 30));
            g2.fillRoundRect(0, 0, w, h, arc, arc);

            // color solidness --> a
            g2.setColor(new Color(255, 255, 255, 100));
            g2.fillRoundRect(0, 0, w, h, arc, arc);

            // border
            g2.setColor(new Color(255, 255, 255, 120));
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(1, 1, w - 2, h - 2, arc, arc);

            g2.dispose();
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {}
    }

    public void setTabSelected(JButton button, boolean isSelected) {
        if (isSelected) {
            // Show white underline 3px thick
            button.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
            button.setForeground(Color.WHITE);
        } else {
            // No border, and make text slightly grey/dim
            button.setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 0));
            button.setForeground(Color.LIGHT_GRAY);
        }
    }
}





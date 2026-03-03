package org.example;


import java.awt.*;

public class GUI {
    public static String ThemeButton = "Dark Theme";
    public static String WhiteColorCode = "#FFFFFF";
    public static String BlackColorCode = "#121212";
    public static String DarkBlueColorCode = "#003366";
    public static String LightBlueColorCode = "#027EFA";


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
            WhiteColorCode = "#121212";
            BlackColorCode = "#FFFFFF";
            DarkBlueColorCode = "#027EFA";
            LightBlueColorCode = "#003366";

        } else {
            ThemeButton = "Light Theme";
            WhiteColorCode = "#FFFFFF";
            BlackColorCode = "#121212";
            DarkBlueColorCode = "#003366";
            LightBlueColorCode = "#027EFA";
        }


    }


}


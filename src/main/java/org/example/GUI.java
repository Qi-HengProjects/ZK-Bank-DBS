package org.example;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Scanner;

public class GUI {

    // rectangle data type that contain 4 piece of data
    private Rectangle box = new Rectangle();

    public void setPosition (Component comp, int x, int y, int w, int h) {
        box.x = x;
        box.y = y;
        box.width = w;
        box.height = h;
        comp.setBounds(box);
    }
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
}

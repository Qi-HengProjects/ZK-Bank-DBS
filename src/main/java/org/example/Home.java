package org.example;
import java.awt.*;
import javax.swing.*;

public class Home extends JPanel {
    GUI ui = new GUI();
    private JLabel HelloLabel = new JLabel("Hello ");
    private JLabel NameLabel = new JLabel("");

    Image chinabackground3 = new ImageIcon("ChinaBackground3.jpg").getImage();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground3, 0, 0, getWidth(), getHeight(), this);
    }

    public Home(){
        this.setLayout(null);

        // Hello Label
        HelloLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        HelloLabel.setForeground(Color.decode(GUI.BlackColorCode));
        this.add(HelloLabel);

        // Name Label
        NameLabel.setFont(new Font("Arial", Font.ITALIC, 50));
        NameLabel.setForeground(Color.decode(GUI.BlackColorCode));
        this.add(NameLabel);

        // Transfer Button
        GUI.GlassButton TransferBtn = new GUI.GlassButton("Transfer");
        ui.setPosition(TransferBtn, 70, 300, 120, 120);
        TransferBtn.addActionListener( e -> {
            Main.showPage("Transfer");
        });
        this.add(TransferBtn);

        // Loan Application Button
        GUI.GlassButton LoanApplicationBtn = new GUI.GlassButton("<html><center>Loan<br>Application</center></html>");
        ui.setPositionRelative(TransferBtn, LoanApplicationBtn, 200, 0, 120, 120);
        LoanApplicationBtn.addActionListener(e -> {
            Main.showPage("LoanApp");
        });
        this.add(LoanApplicationBtn);

        // Currency Exchange Button
        GUI.GlassButton CurrencyExchangeBtn = new GUI.GlassButton("<html><center>Currency<br>Exchange</center></html>");
        ui.setPositionRelative(LoanApplicationBtn, CurrencyExchangeBtn, 200, 0, 120, 120);
        this.add(CurrencyExchangeBtn);

        // Profile Button
        GUI.GlassButton ProfileBtn = new GUI.GlassButton("Profile");
        ui.setPositionRelative(CurrencyExchangeBtn, ProfileBtn, 200, 0, 120, 120);
        ProfileBtn.addActionListener(e -> {
            Main.showPage("Profile");
        });
        this.add(ProfileBtn);

        //Create Account Button
        GUI.GlassButton CreateAccBtn = new GUI.GlassButton("Create Account");
        ui.setPositionRelative(ProfileBtn, CreateAccBtn, -50, -250, 200, 50);
        CreateAccBtn.addActionListener(e -> {
            Window parentWindow = SwingUtilities.getWindowAncestor(this);
            new CreateAccount((Frame) parentWindow);
        });

        this.add(CreateAccBtn);
    }

    public void refresh() {
        String username = LoginPanel.UsernameValue;
        if (username != null) {
            NameLabel.setText(username);

            FontMetrics fmPlain = HelloLabel.getFontMetrics(HelloLabel.getFont());
            FontMetrics fmItalic = NameLabel.getFontMetrics(NameLabel.getFont());

            int helloWidth = fmPlain.stringWidth("Hello ");
            int nameWidth = fmItalic.stringWidth(username);
            int startX = 425 - ((helloWidth + nameWidth) / 2);

            HelloLabel.setBounds(startX, 100, helloWidth + 10, 100);
            NameLabel.setBounds(startX + helloWidth, 100, nameWidth + 20, 100);

            this.revalidate();
            this.repaint();
        }
    }

    public void applyTheme() {
        this.setBackground(Color.decode(GUI.WhiteColorCode));
        this.repaint();
    }
}
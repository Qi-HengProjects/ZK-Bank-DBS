    package org.example;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.util.List;

    public class LoginPanel extends JPanel{
        // Create the panel
        GUI ui = new GUI();
        JTextField userTextField = new JTextField(15);
        JTextField passwordTextField = new JTextField(15);
        JPanel containerPanel = new JPanel(new GridBagLayout());
        public static String UsernameValue;

        Image chinabackground1 = new ImageIcon("ChinaBackground1.jpg").getImage();


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(chinabackground1, 0, 0, getWidth(), getHeight(), this);
        }
        public LoginPanel() {

            this.setLayout(new BorderLayout());

            // wrapper for login panel 中间那个方块的背景
            JPanel containerPanel = new JPanel(new GridBagLayout());
            containerPanel.setOpaque(false);

            // login panel setup 那个灰色方块的setup
            JPanel loginBox = new JPanel();
            loginBox.setPreferredSize(new Dimension(400, 300));
            loginBox.setBorder(BorderFactory.createLineBorder(Color.decode(GUI.LightGreyColorCode), 2)); // 灰色边线
            loginBox.setLayout(null);

            //Image
            ImageIcon image = new ImageIcon("logo_Icon.jpg");
            Image logo_icon_1 = image.getImage();
            Image scaled_image= logo_icon_1.getScaledInstance(100, 85, Image.SCALE_SMOOTH);
            ImageIcon scaled_logo_1 = new ImageIcon(scaled_image);

            JLabel logo = new JLabel(scaled_logo_1);
            logo.setForeground(Color.YELLOW);
            logo.setFont(new Font("Arial", Font.BOLD, 18));
            logo.setBounds(50, 10, 120, 100);
            loginBox.add(logo);

            //Next to icon label (ZK BANK)
            JLabel ZKBank = new JLabel("ZK BANK");
            ZKBank.setForeground(Color.decode("#000000"));
            ZKBank.setFont(new Font("Arial", Font.BOLD, 30));
            ZKBank.setBounds(190, 40, 300, 50);
            loginBox.add(ZKBank);

            //username label
            JLabel userLabel = new JLabel("Username :");// 把label做出来
            ui.setPosition(userLabel,50, 150, 150, 15);
            loginBox.add(userLabel);

            //password label
            JLabel passwordLabel = new JLabel("Password :");
            ui.setPositionRelative(userLabel, passwordLabel, 0, 50, 150, 15);
            loginBox.add(passwordLabel);

            //username text field
            //JTextField userTextField = ui.createTextField(15, 140, 150, 200, 20);
            // The line before cannot put here need to put up to make sure the method work
            ui.setPosition(userTextField, 140, 150, 200, 20);
            loginBox.add(userTextField);

            //password text field
            //JTextField passwordTextField = ui.createTextField(15, 140,200,200, 20);
            ui.setPositionRelative(userTextField, passwordTextField, 0,50,200, 20);
            loginBox.add(passwordTextField);

            //Log In Button
            JButton LogInButton = new JButton("Log In");
            LogInButton.setBounds(150,240,100,30);
            loginBox.add(LogInButton);
            LogInButton.addActionListener(this::LoginButtonClicked);


            //Sign Up Button
            JButton SignUp_Button = new JButton("<html><u>Sign Up?</u></html>");
            SignUp_Button.setFont(new Font("Arial",Font.ITALIC, 15));
            SignUp_Button.setBorderPainted(false);
            SignUp_Button.setContentAreaFilled(false);
            SignUp_Button.setFocusPainted(false);
            SignUp_Button.setForeground(Color.BLUE);
            SignUp_Button.setBounds(20,260,100,30);
            loginBox.add(SignUp_Button);
            //Pop to Sign Up pop up window
            SignUp_Button.addActionListener( e -> {
                Window parentWindow = SwingUtilities.getWindowAncestor(this);
                new SignUp((Frame) parentWindow);

            });


            // Add the box to the wrapper 把刚才的灰色格子放在frame前面
            containerPanel.add (loginBox);

            // add the top and login panel to the frame (InfoFrame) 排版
            this.add(containerPanel, BorderLayout.CENTER); //把那个wrapper放进那个frame


        }

        boolean loginSuccess = false;
        private void LoginButtonClicked(ActionEvent e) {
            String UsernameInput = userTextField.getText();
            LoginPanel.UsernameValue = UsernameInput;
            String PasswordInput = passwordTextField.getText();
            List<User> users = Main.dataManager.loadUsers();
            for (User user : users) {
                if (user.getUsername().equals(UsernameInput) && user.getPassword().equals(PasswordInput)) {
                    loginSuccess = true;
                    Main.currentSession = user.getUserID();
                    Main.currentObject = user;
                    break;
                }
            }

            if (loginSuccess) {
                System.out.println("Login Successfully!");
                Main.account_status = Main.AccountStatus.SignedIn;
                Main.bar.LockLogic();
                for (Component c : Main.mainPanel.getComponents()) {
                    if (c instanceof Home) {
                        ((Home) c).refresh();
                        break;
                    }
                }
                Main.showPage("Home");
            } else {
                JOptionPane.showMessageDialog(this, "Username or Password incorrect!");
            }
        }
        public void applyTheme() {
            this.repaint();
        }
    }
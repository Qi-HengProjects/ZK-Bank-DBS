package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class CurrencyPanel extends JPanel {

    private static final HashMap<String, BigDecimal> RATES = new HashMap<>();
    static {
        RATES.put("MYR_USD", new BigDecimal("0.2483")); RATES.put("MYR_SGD", new BigDecimal("0.3202"));
        RATES.put("MYR_AUD", new BigDecimal("0.3619")); RATES.put("MYR_CNY", new BigDecimal("1.7160"));
        RATES.put("USD_MYR", new BigDecimal("4.0280")); RATES.put("USD_SGD", new BigDecimal("1.2897"));
        RATES.put("USD_AUD", new BigDecimal("1.4576")); RATES.put("USD_CNY", new BigDecimal("6.9118"));
        RATES.put("SGD_MYR", new BigDecimal("3.1231")); RATES.put("SGD_USD", new BigDecimal("0.7754"));
        RATES.put("SGD_AUD", new BigDecimal("1.1301")); RATES.put("SGD_CNY", new BigDecimal("5.3591"));
        RATES.put("AUD_MYR", new BigDecimal("2.7635")); RATES.put("AUD_USD", new BigDecimal("0.6861"));
        RATES.put("AUD_SGD", new BigDecimal("0.8849")); RATES.put("AUD_CNY", new BigDecimal("4.7421"));
        RATES.put("CNY_MYR", new BigDecimal("0.5828")); RATES.put("CNY_USD", new BigDecimal("0.1447"));
        RATES.put("CNY_SGD", new BigDecimal("0.1866")); RATES.put("CNY_AUD", new BigDecimal("0.2109"));
    }

    private static final String[][] SYMBOLS = {
            {"USD", "$"}, {"MYR", "RM "}, {"SGD", "S$ "},
            {"AUD", "A$ "}, {"CNY", "¥ "}
    };

    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField inputField;
    private JLabel resultLabel;
    private JLabel rateLabel;
    private JLabel errorLabel;

    private final String[] currencies = {"MYR", "USD", "SGD", "AUD", "CNY"};

    // Image background
    Image chinabackground2 = new ImageIcon("ChinaBackground2.jpg").getImage();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(chinabackground2, 0, 0, getWidth(), getHeight(), this);
    }

    public CurrencyPanel() {
        setBackground(new Color(245, 247, 250));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(25, 25, 25, 25));

        buildUI();
        convert();
    }

    private void buildUI() {
        add(Box.createVerticalStrut(50));

        JLabel title = new JLabel("Currency Exchange");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(new Color(30, 30, 60));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);
        add(Box.createVerticalStrut(30));

        add(Box.createVerticalStrut(5));
        add(createInputCard());
        add(Box.createVerticalStrut(15));

        add(createSwapButton());
        add(Box.createVerticalStrut(15));

        add(Box.createVerticalStrut(5));
        add(createOutputCard());
        add(Box.createVerticalStrut(20));

        rateLabel = new JLabel("Rate: ...");
        rateLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        rateLabel.setForeground(new Color(0, 0, 0));
        rateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(rateLabel);
        add(Box.createVerticalStrut(10));

        errorLabel = new JLabel(" ");
        errorLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        errorLabel.setForeground(new Color(220, 50, 50));
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(errorLabel);
    }

    private JPanel createInputCard() {
        JPanel card = makeCard();
        inputField = new JTextField("1.00");
        inputField.setFont(new Font("SansSerif", Font.BOLD, 26));
        inputField.setBorder(null);
        inputField.setBackground(Color.WHITE);
        inputField.setForeground(new Color(30, 30, 60));
        inputField.addKeyListener(new KeyAdapter() {
            @Override public void keyReleased(KeyEvent e) { convert(); }
        });
        card.add(inputField, BorderLayout.CENTER);

        fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setSelectedItem("USD");
        fromCurrency.setFont(new Font("SansSerif", Font.BOLD, 16));
        fromCurrency.setBackground(new Color(240, 242, 255));
        fromCurrency.setFocusable(false);
        fromCurrency.addActionListener(e -> convert());
        card.add(fromCurrency, BorderLayout.EAST);

        return card;
    }

    private JPanel createOutputCard() {
        JPanel card = makeCard();
        resultLabel = new JLabel("...");
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        resultLabel.setForeground(new Color(0, 150, 100));
        card.add(resultLabel, BorderLayout.CENTER);

        toCurrency = new JComboBox<>(currencies);
        toCurrency.setSelectedItem("MYR");
        toCurrency.setFont(new Font("SansSerif", Font.BOLD, 16));
        toCurrency.setBackground(new Color(240, 242, 255));
        toCurrency.setFocusable(false);
        toCurrency.addActionListener(e -> convert());
        card.add(toCurrency, BorderLayout.EAST);

        return card;
    }

    private JPanel makeCard() {
        JPanel card = new JPanel(new BorderLayout(15, 0));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 222, 235), 1),
                new EmptyBorder(15, 20, 15, 20)
        ));
        card.setMaximumSize(new Dimension(800, 80));
        card.setAlignmentX(Component.CENTER_ALIGNMENT);
        return card;
    }

    private JPanel createSwapButton() {
        JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.setOpaque(false);
        wrapper.setMaximumSize(new Dimension(800, 40));

        JButton swapBtn = new JButton("⇅ Swap");
        swapBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        swapBtn.setBackground(new Color(0, 184, 255));
        swapBtn.setForeground(Color.WHITE);
        swapBtn.setFocusPainted(false);
        swapBtn.setBorderPainted(false);
        swapBtn.setOpaque(true);
        swapBtn.setPreferredSize(new Dimension(110, 36));
        swapBtn.addActionListener(e -> swap());

        wrapper.add(swapBtn);
        return wrapper;
    }

    private void convert() {
        errorLabel.setText(" ");

        String from = (String) fromCurrency.getSelectedItem();
        String to   = (String) toCurrency.getSelectedItem();
        String input = inputField.getText().trim();

        if (input.isEmpty()) {
            resultLabel.setText(getSymbol(to) + "0.00");
            rateLabel.setText("Rate: --");
            return;
        }

        int dotIndex = input.indexOf('.');
        if (dotIndex != -1 && (input.length() - dotIndex - 1) > 2) {
            errorLabel.setText("Maximum 2 decimal places allowed");
            resultLabel.setText("--");
            rateLabel.setText("Rate: N/A");
            return;
        }

        BigDecimal amount;
        try {
            amount = new BigDecimal(input);
        } catch (NumberFormatException e) {
            errorLabel.setText("Please enter a valid number");
            resultLabel.setText("--");
            rateLabel.setText("Rate: N/A");
            return;
        }

        if (from.equals(to)) {
            resultLabel.setText(getSymbol(to) + amount.setScale(2, RoundingMode.HALF_UP));
            rateLabel.setText("Rate: 1.00 (same currency)");
            return;
        }

        String key = from + "_" + to;
        BigDecimal rate = RATES.get(key);
        BigDecimal result = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);

        resultLabel.setText(getSymbol(to) + result.toPlainString());
        rateLabel.setText("1 " + from + " = " + rate.toPlainString() + " " + to);
    }

    private void swap() {
        String fromVal = (String) fromCurrency.getSelectedItem();
        String toVal   = (String) toCurrency.getSelectedItem();
        fromCurrency.setSelectedItem(toVal);
        toCurrency.setSelectedItem(fromVal);
        convert();
    }

    private String getSymbol(String currency) {
        for (String[] pair : SYMBOLS) {
            if (pair[0].equals(currency)) return pair[1];
        }
        return currency + " ";
    }

    public void applyTheme() {
        this.repaint();
    }
}
package BankingApp;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

public class Login {

    private static byte[] hash;

    public static void main(String[] args) {

        JFrame mainFrame = new JFrame("Login");
        mainFrame.setSize(1000, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tyler ist meine kleine Goonmaus

        mainFrame.setLayout(new BorderLayout());

        mainFrame.setVisible(true);
        logRegFrame(mainFrame);
    }

    public static void logRegFrame(JFrame menu) {

        JPanel logRegPanel = new JPanel();
        logRegPanel.setLayout(new GridLayout(2, 1, 1, 1)); // Maddin goont auf Goonmäuse!
        menu.add(logRegPanel);

        JButton login = new JButton("Login");
        login.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        logRegPanel.add(login);
        login.addActionListener(e -> {
            drawLogin(menu);
        });

        JButton register = new JButton("Register");
        register.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        logRegPanel.add(register);
        register.addActionListener(e -> {
            for (Component c : logRegPanel.getComponents()) {
                c.setEnabled(false);
                c.setVisible(false);
            }
            drawLogin(menu);
        });
    }

    public static void drawLogin(JFrame menu) {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 1, 1));
        menu.add(panel);

        JTextField username = new JTextField("Enter username");
        username.setHorizontalAlignment(JTextField.CENTER);
        username.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (username.getText().equals("Enter username")) {
                    username.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent e) {
                if (username.getText().isEmpty()) {
                    username.setText("Enter username");
                }
            }
        });
        panel.add(username);

        JTextField password = new JTextField("Enter password");
        password.setHorizontalAlignment(JTextField.CENTER);
        password.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e) {
                if (password.getText().equals("Enter password")) {
                    password.setText("");
                }
            }

            public void focusLost(java.awt.event.FocusEvent e) {
                if (password.getText().isEmpty()) {
                    password.setText("Enter password");
                }
            }
        });
        panel.add(password);

        JButton okBut = new JButton("Register");
        okBut.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        panel.add(okBut);
        okBut.addActionListener(e -> {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            String passwordText = password.getText();

            try {
                KeySpec spec = new PBEKeySpec(passwordText.toCharArray(), salt, 65536, 128);
                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                hash = factory.generateSecret(spec).getEncoded();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Username: " + username.getText() + " Password: " + hash.toString());
        });
    }
}
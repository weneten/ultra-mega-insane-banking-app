package BankingApp;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

public class GUI {

    static Konto konto;
    static Bank bank = new Bank("BW Bank");
    static Kontoinhaber kontoinhaber = new Kontoinhaber(bank, "Max Mustermann");

    public static void main(String[] args) {

        konto = kontoinhaber.erstelleKonto("Max Mustermann", "DE1234567890");
        Konto zweitesKonto = kontoinhaber.erstelleKonto("Testkunde", "1234");

        JFrame mainFrame = new JFrame("GUI");
        mainFrame.setSize(1000, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLayout(new BorderLayout());

        mainFrame.setVisible(true);

        menuButtons(mainFrame, kontoinhaber);
    }

    public static JLabel headerLabel;

    public static void menuButtons(JFrame frame, Kontoinhaber k) {

        JPanel menuPanel = new JPanel();
        menuPanel.setSize(900, 700);
        menuPanel.setLayout(new GridLayout(4, 1, 10, 10));
        frame.add(menuPanel, BorderLayout.CENTER);
        menuPanel.setVisible(true);

        headerLabel = new JLabel("", SwingConstants.CENTER);
        headerLabel.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 50));
        updateHeader(menuPanel); // Label-Text setzen
        menuPanel.add(headerLabel);

        JButton einzahlButton = new JButton("Einzahlen");
        einzahlButton.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 35));
        menuPanel.add(einzahlButton);
        einzahlButton.addActionListener(e -> {
            einzahlUI(menuPanel, frame);
        });

        JButton auszahlButton = new JButton("Auszahlen");
        auszahlButton.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 35));
        menuPanel.add(auszahlButton);
        auszahlButton.addActionListener(e -> {
            auszahlUI(menuPanel, frame);

        });

        JButton ueberweisButton = new JButton("Überweisen");
        ueberweisButton.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 35));
        menuPanel.add(ueberweisButton);
        ueberweisButton.addActionListener(e -> {
            ueberweisUI(menuPanel, frame);
        });

    }

    public static void updateHeader(JPanel menuPanel) {

        headerLabel.setText("Kontostand: " + (konto != null ? konto.getKontostand() : "0.00") + " €"
                + "   Nutzer: " + kontoinhaber.getName() + " Kontonummer: " + konto.getKontonummer());

    }

    public static void einzahlUI(JPanel menuPanel, JFrame mainFrame) {
        for (Component c : menuPanel.getComponents()) {
            c.setEnabled(false);
            c.setVisible(false);
        }
        menuPanel.setEnabled(false);

        JPanel einzahlPanel = new JPanel();
        einzahlPanel.setSize(900, 700);
        einzahlPanel.setLayout(new GridLayout(2, 1, 10, 10));
        mainFrame.add(einzahlPanel, BorderLayout.CENTER);
        einzahlPanel.setVisible(true);

        JTextField amount = new JTextField();
        amount.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        amount.setHorizontalAlignment(JTextField.CENTER);
        einzahlPanel.add(amount);

        JButton einzahlBesteaButton = new JButton("Bestätigen");
        einzahlBesteaButton.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 35)); // Schriftgröße 24
        einzahlPanel.add(einzahlBesteaButton);
        einzahlBesteaButton.addActionListener(e -> {
            float betrag = Float.parseFloat(amount.getText());
            konto.einzahlen(betrag);
            System.out.println(konto.getKontostand());
            for (Component x : einzahlPanel.getComponents()) {
                x.setEnabled(false);
                x.setVisible(false);
            }
            for (Component c : menuPanel.getComponents()) {
                c.setEnabled(true);
                c.setVisible(true);
            }

            einzahlPanel.setVisible(false);
            menuPanel.setVisible(true);
            updateHeader(menuPanel);
        });

    }

    public static void auszahlUI(JPanel menuPanel, JFrame mainFrame) {
        for (Component c : menuPanel.getComponents()) {
            c.setEnabled(false);
            c.setVisible(false);
        }
        menuPanel.setEnabled(false);

        JPanel auszahlPanel = new JPanel();
        auszahlPanel.setSize(900, 700);
        auszahlPanel.setLayout(new GridLayout(2, 1, 10, 10));
        mainFrame.add(auszahlPanel, BorderLayout.CENTER);
        auszahlPanel.setVisible(true);

        JTextField amount = new JTextField();
        amount.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        amount.setHorizontalAlignment(JTextField.CENTER);
        auszahlPanel.add(amount);

        JButton auszahlBestatigenButton = new JButton("Bestätigen");
        auszahlBestatigenButton.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 35)); // Schriftgröße 24
        auszahlPanel.add(auszahlBestatigenButton);
        auszahlBestatigenButton.addActionListener(e -> {
            float betrag = Float.parseFloat(amount.getText());
            konto.auszahlen(betrag);
            System.out.println(konto.getKontostand());
            for (Component x : auszahlPanel.getComponents()) {
                x.setEnabled(false);
                x.setVisible(false);
            }
            for (Component c : menuPanel.getComponents()) {
                c.setEnabled(true);
                c.setVisible(true);
            }

            auszahlPanel.setVisible(false);
            menuPanel.setVisible(true);
            updateHeader(menuPanel);
        });

    }

    public static void ueberweisUI(JPanel menuPanel, JFrame mainFrame) {
        for (Component c : menuPanel.getComponents()) {
            c.setEnabled(false);
            c.setVisible(false);
        }
        menuPanel.setEnabled(false);
        JPanel ueberweisPanel = new JPanel();
        ueberweisPanel.setSize(900, 700);
        ueberweisPanel.setLayout(new GridLayout(3, 1, 10, 10));
        mainFrame.add(ueberweisPanel, BorderLayout.CENTER);
        ueberweisPanel.setVisible(true);

        JTextField amount = new JTextField();
        amount.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        amount.setHorizontalAlignment(JTextField.CENTER);
        ueberweisPanel.add(amount);

        JTextField empfaenger = new JTextField();
        empfaenger.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
        empfaenger.setHorizontalAlignment(JTextField.CENTER);
        ueberweisPanel.add(empfaenger);

        JButton ueberweisBesteaButton = new JButton("Bestätigen");
        ueberweisBesteaButton.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 35)); // Schriftgröße 24
        ueberweisPanel.add(ueberweisBesteaButton);
        ueberweisBesteaButton.addActionListener(e -> {
            float betrag = Float.parseFloat(amount.getText());
            String empfaengerKontonummer = empfaenger.getText();
            for (Konto k : bank.getKonten()) {
                if (k.getKontonummer().equals(empfaengerKontonummer)) {
                    Ueberweisung ueberweisung = new Ueberweisung(betrag, konto, k, bank);
                    ueberweisung.doUeberweisung();
                }
            }
            System.out.println(konto.getKontostand());
            for (Component x : ueberweisPanel.getComponents()) {
                x.setEnabled(false);
                x.setVisible(false);
            }
            for (Component c : menuPanel.getComponents()) {
                c.setEnabled(true);
                c.setVisible(true);
            }

            ueberweisPanel.setVisible(false);
            menuPanel.setVisible(true);
            updateHeader(menuPanel);
        });

    }
}

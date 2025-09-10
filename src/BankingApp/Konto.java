package BankingApp;

import java.util.ArrayList;
import java.util.List;

public class Konto {

    private String kontonummer = "";
    private float kontostand = 100;
    private List<Ueberweisung> umsaetze;
    private Bank bank;
    private GUI gui;
    private String name;

    public Konto(String name, String kontonummer, float kontostand, Bank bank) {
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
        this.umsaetze = new ArrayList<>();
        this.bank = bank;
        this.name = name;
    }

    public void einzahlen(float betrag) {
        this.kontostand += betrag;
    }

    public void auszahlen(float betrag) {
        if (this.kontostand - betrag >= 0) {
            this.kontostand -= betrag;
        }
        else{
            gui.errorBalance();
        }
    }

    public float getKontostand() {
        return this.kontostand;
    }

    public String getKontonummer() {
        return this.kontonummer;
    }

    public void setKontonummer(String newKontnum) {
        this.kontonummer = newKontnum;
    }

    public void ueberweisen(float betrag, Konto empfaenger) {
        if (this.kontostand - betrag >= 0) {
            Ueberweisung ueberweisung = new Ueberweisung(betrag, empfaenger, kontonummer, bank);
            this.umsaetze.add(ueberweisung);
        }

    }

    public String getInhaber() {
        return this.name;
    }


}

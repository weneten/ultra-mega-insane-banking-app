package BankingApp;

import java.util.ArrayList;
import java.util.List;

public class Konto {

    private String kontonummer = "";
    private float kontostand = 100;
    private List<Ueberweisung> umsaetze;

    public Konto(String name, String kontonummer, float kontostand) {
        this.kontonummer = kontonummer;
        this.kontostand = kontostand;
        this.umsaetze = new ArrayList<>();
    }

    public void einzahlen(float betrag) {
        this.kontostand += betrag;
    }

    public void auszahlen(float betrag) {
        if (this.kontostand - betrag >= 0) {
            this.kontostand -= betrag;
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
            Ueberweisung ueberweisung = new Ueberweisung(betrag, this, empfaenger);
            this.umsaetze.add(ueberweisung);
        }

    }

}

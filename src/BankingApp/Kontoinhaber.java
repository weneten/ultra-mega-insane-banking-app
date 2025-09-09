package BankingApp;

import java.util.List;
import java.util.ArrayList;

public class Kontoinhaber {

    private String name;
    private List<Konto> konten = new ArrayList<>();

    private Bank bank;
    private Konto konto;

    public Kontoinhaber(Bank bank, String name) {
        this.bank = bank;
        this.name = name;
    }

    // In Kontoinhaber.java:
    public Konto erstelleKonto(String name, String iban) {
        Konto k = new Konto(name, iban, 100, bank); // Startbetrag 100
        bank.createKonto(k);
        konten.add(k);
        return k;
    }

    public String getName() {
        return name;
    }

    public float getKontostand() {
        if (konto != null) {
            return konto.getKontostand();
        }
        return 0;
    }

    public List<Konto> getKonten() {
        return konten;
    }

}

package BankingApp;

import java.util.List;
import java.util.ArrayList;

public class Kontoinhaber {

    private String name;
    private List<Konto> konten = new ArrayList<>();

    private Bank bank;

    public Kontoinhaber(String name, List<Konto> konten) {
        this.name = name;
        this.konten = konten;
    }

    public void erstelleKonto() {
        Konto neuesKonto = new Konto();
        this.konten.add(neuesKonto);
        bank.createKonto(neuesKonto);
    }

    public String getName() {
        return name;
    }

    public List<Konto> getKonten() {
        return konten;
    }

}

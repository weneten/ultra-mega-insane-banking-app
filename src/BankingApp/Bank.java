package BankingApp;

import java.util.List;
import java.util.ArrayList;

public class Bank {

    private String name;
    private List<Konto> konten;

    public Bank(String name) {
        this.name = name;
        this.konten = new ArrayList<>();
    }

    public void createKonto(Konto i){
        konten.add(i);
    }

    public void uberweisungDurchfuehren(Ueberweisung ueberweisung) {
        Konto sender = ueberweisung.getSender();
        Konto empfaengerKontonummer = ueberweisung.getEmpfaenger();
        float betrag = ueberweisung.getBetrag();

        sender.auszahlen(betrag);
        
        for(Konto k : konten) {
            if(k == empfaengerKontonummer) {
                sender.auszahlen(betrag);
                k.einzahlen(betrag);
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Konto> getKonten() {
        return konten;
    }





}

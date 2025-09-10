package BankingApp;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Bank {

    private String name;
    private List<Konto> konten;
    private GUI gui;

    public Bank(String name) {
        this.name = name;
        this.konten = new ArrayList<>();
    }

    public void createKonto(Konto i) {
        konten.add(i);
    }

    public void readInfo() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(this.konten);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void uberweisungDurchfuehren(Ueberweisung ueberweisung) {
        Konto sender = ueberweisung.getSender();
        Konto empfaengerKonto = findKontoByNummer(ueberweisung.getEmpfaengerKontonummer());
        float betrag = ueberweisung.getBetrag();

        if (empfaengerKonto == null) {
            System.out.println("Empfaenger Konto nicht bei dieser Bank!");
            gui.errorWrongClient();
            return;
        }

        if (sender.getKontostand() - betrag >= 0) {
            sender.auszahlen(betrag);
            empfaengerKonto.einzahlen(betrag);
        } else {
            System.out.println("Nicht genug Guthaben!");
            gui.errorBalance();
        }
    }

    public String getName() {
        return name;
    }

    public List<Konto> getKonten() {
        return konten;
    }

    public Konto findKontoByNummer(String kontonummer) {
        for (Konto k : konten) {
            if (k.getKontonummer().equals(kontonummer)) {
                return k;
            }
        }
        return null;
    }
}

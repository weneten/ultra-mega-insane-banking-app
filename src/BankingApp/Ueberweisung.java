package BankingApp;

public class Ueberweisung {

    private float betrag;
    private final Konto sender;
    private final String empfaengerKontonummer;
    private Bank bank;

    public Ueberweisung(float betrag, Konto sender, String empfaengerKontonummer2, Bank bank) {
        this.betrag = betrag;
        this.sender = sender;
        this.empfaengerKontonummer = empfaengerKontonummer2;
        this.bank = bank;
    }

    public float getBetrag() {
        return betrag;
    }

    public Konto getSender() {
        return sender;
    }

    public String getEmpfaengerKontonummer() {
        return empfaengerKontonummer;
    }

    public void doUeberweisung() {
        bank.uberweisungDurchfuehren(this);
    }
}

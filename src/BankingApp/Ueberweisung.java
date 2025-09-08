package BankingApp;

public class Ueberweisung {

    private float betrag;
    private final Konto sender;
    private final Konto empfaenger;

    private Bank bank;


    public Ueberweisung(float betrag, Konto sender, Konto empfaenger) {
        this.betrag = betrag;
        this.sender = sender;
        this.empfaenger = empfaenger;
    }

    public float getBetrag() {
        return betrag;
    }

    public Konto getSender() {
        return sender;
    }

    public Konto getEmpfaenger() {
        return empfaenger;
    }

    public void doUeberweisung(){
        bank.uberweisungDurchfuehren(this);
    }

}

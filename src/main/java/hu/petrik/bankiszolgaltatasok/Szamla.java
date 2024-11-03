package hu.petrik.bankiszolgaltatasok;

public abstract class Szamla extends BankiSzolgaltatas {
    private int egyenleg;

    public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.egyenleg = 0;
    }

    public int getEgyenleg() {
        return egyenleg;
    }

    public void befizet(int osszeg) {
        if (osszeg > 0) {
            this.egyenleg += osszeg;
        }
    }

    public abstract boolean kivesz(int osszeg);

    public Kartya ujKartya(String kartyaSzam) { // Added method for task 8
        return new Kartya(getTulajdonos(), this, kartyaSzam);
    }
}
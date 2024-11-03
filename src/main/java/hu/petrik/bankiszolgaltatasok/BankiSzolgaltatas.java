package hu.petrik.bankiszolgaltatasok;

public abstract class BankiSzolgaltatas { // abstract ensures it cannot be instantiated directly
    private final Tulajdonos tulajdonos;

    public BankiSzolgaltatas(Tulajdonos tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    public Tulajdonos getTulajdonos() {
        return tulajdonos;
    }
}
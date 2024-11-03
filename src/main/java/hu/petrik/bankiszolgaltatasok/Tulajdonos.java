package hu.petrik.bankiszolgaltatasok;

public final class Tulajdonos { // final keyword ensures it cannot be inherited
    private String nev;

    public Tulajdonos(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
}
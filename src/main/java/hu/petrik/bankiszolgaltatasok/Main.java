package hu.petrik.bankiszolgaltatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos tulajdonos = new Tulajdonos("John Doe");

        Bank bank = new Bank();

        Szamla megtakaritasiSzamla = bank.szamlaNyitas(tulajdonos, 0);

        Szamla hitelSzamla = bank.szamlaNyitas(tulajdonos, 1000);

        megtakaritasiSzamla.befizet(500);

        hitelSzamla.befizet(200);

        System.out.println("Össz egyenleg: " + bank.getOsszEgyenleg(tulajdonos));

        System.out.println("Legnagyobb egyenlegű számla: " + bank.getLegnagyobbEgyenleguSzamla(tulajdonos).getEgyenleg());

        System.out.println("Össz hitelkeret: " + bank.getOsszHitelkeret());
    }
}
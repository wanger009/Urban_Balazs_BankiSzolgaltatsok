package hu.petrik.bankiszolgaltatasok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank;
    Tulajdonos tulajdonos;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        tulajdonos = new Tulajdonos("Gipsz Jakab");
    }

    @Test
    void szamlaNyitas() {
        Szamla sz1 = bank.szamlaNyitas(tulajdonos, 0);
        Szamla sz2 = bank.szamlaNyitas(tulajdonos, 1);
        assertTrue(sz1 instanceof MegtakaritasiSzamla);
        assertTrue(sz2 instanceof HitelSzamla);
    }

    @Test
    void szamlaNyitasNegativHitelkeret() {
        assertThrows(IllegalArgumentException.class, () -> bank.szamlaNyitas(tulajdonos, -1));
    }

    @Test
    void getOsszEgyenleg() {
        Tulajdonos t2 = new Tulajdonos("Teszt Elek");
        Tulajdonos t3 = new Tulajdonos("Teszt Elek");
        Szamla sz1 = bank.szamlaNyitas(tulajdonos, 0);
        Szamla sz2 = bank.szamlaNyitas(tulajdonos, 1);
        Szamla sz3 = bank.szamlaNyitas(t2, 0);
        Szamla sz4 = bank.szamlaNyitas(t2, 1);
        Szamla sz5 = bank.szamlaNyitas(t3, 0);
        Szamla sz6 = bank.szamlaNyitas(t3, 1);
        sz1.befizet(15000);
        sz2.befizet(10000);
        sz3.befizet(30000);
        sz4.befizet(35000);
        sz5.befizet(70000);
        sz6.befizet(75000);
        assertEquals(25000, bank.getOsszEgyenleg(tulajdonos));
        assertEquals(65000, bank.getOsszEgyenleg(t2));
        assertEquals(145000, bank.getOsszEgyenleg(t3));
    }

    @Test
    void getLegnagyobbEgyenleguSzamla() {
        Tulajdonos t2 = new Tulajdonos("Teszt Elek");
        Tulajdonos t3 = new Tulajdonos("Teszt Elek");
        Szamla sz1 = bank.szamlaNyitas(tulajdonos, 0);
        Szamla sz2 = bank.szamlaNyitas(tulajdonos, 1);
        Szamla sz3 = bank.szamlaNyitas(t2, 0);
        Szamla sz4 = bank.szamlaNyitas(t2, 1);
        Szamla sz5 = bank.szamlaNyitas(t3, 0);
        Szamla sz6 = bank.szamlaNyitas(t3, 1);
        sz1.befizet(85000);
        sz2.befizet(10000);
        sz3.befizet(30000);
        sz4.befizet(35000);
        sz5.befizet(75000);
        sz6.befizet(70000);
        assertEquals(sz1, bank.getLegnagyobbEgyenleguSzamla(tulajdonos));
        assertEquals(sz4, bank.getLegnagyobbEgyenleguSzamla(t2));
        assertEquals(sz5, bank.getLegnagyobbEgyenleguSzamla(t3));
    }

    @Test
    void getOsszHitelkeret() {
        Tulajdonos t2 = new Tulajdonos("Teszt Elek");
        Tulajdonos t3 = new Tulajdonos("Teszt Elek");
        bank.szamlaNyitas(tulajdonos, 0);
        bank.szamlaNyitas(tulajdonos, 10000);
        bank.szamlaNyitas(t2, 0);
        bank.szamlaNyitas(t2, 15000);
        bank.szamlaNyitas(t3, 0);
        bank.szamlaNyitas(t3, 20000);
        assertEquals(45000, bank.getOsszHitelkeret());
    }
}

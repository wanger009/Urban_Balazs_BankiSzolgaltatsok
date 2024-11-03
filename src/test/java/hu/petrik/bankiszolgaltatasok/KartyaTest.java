package hu.petrik.bankiszolgaltatasok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KartyaTest {
    Kartya k;
    Szamla sz;

    @BeforeEach
    void setUp() {
        Tulajdonos tulajdonos = new Tulajdonos("Gipsz Jakab");
        sz = new MegtakaritasiSzamla(tulajdonos);
        k = new Kartya(tulajdonos, sz, "1234-5678");
    }

    @Test
    void getKartyaSzam() {
        assertEquals("1234-5678", k.getKartyaSzam());
    }

    @Test
    void vasarlas() {
        assertFalse(k.vasarlas(1));
        sz.befizet(10000);
        assertFalse(k.vasarlas(10001));
        assertEquals(10000, sz.getAktualisEgyenleg());
        assertTrue(k.vasarlas(10000));
        assertEquals(0, sz.getAktualisEgyenleg());
    }
}
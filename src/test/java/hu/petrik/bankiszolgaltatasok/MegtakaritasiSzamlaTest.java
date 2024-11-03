package hu.petrik.bankiszolgaltatasok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MegtakaritasiSzamlaTest {
    MegtakaritasiSzamla szamla;

    @BeforeEach
    void setUp() {
        Tulajdonos tulajdonos = new Tulajdonos("Gipsz Jakab");
        szamla = new MegtakaritasiSzamla(tulajdonos);
    }

    @Test
    void getKamat() {
        assertEquals(MegtakaritasiSzamla.alapKamat, szamla.getKamat());
    }

    @Test
    void setKamat() {
        szamla.setKamat(1.08);
        assertEquals(1.08, szamla.getKamat());
    }

    @Test
    void kivesz() {
        assertFalse(szamla.kivesz(1));
        szamla.befizet(10000);
        assertEquals(10000,szamla.getAktualisEgyenleg());
        assertFalse(szamla.kivesz(10001));
        assertTrue(szamla.kivesz(10000));
        assertEquals(0, szamla.getAktualisEgyenleg());
    }

    @Test
    void kamatJovairas() {
        szamla.befizet(10000);
        int ujEgyenleg = (int)(szamla.getAktualisEgyenleg() * MegtakaritasiSzamla.alapKamat);
        szamla.kamatJovairas();
        assertEquals(ujEgyenleg, szamla.getAktualisEgyenleg());
    }
}
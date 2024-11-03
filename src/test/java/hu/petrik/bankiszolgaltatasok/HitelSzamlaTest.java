package hu.petrik.bankiszolgaltatasok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HitelSzamlaTest {
    HitelSzamla szamla;

    @BeforeEach
    void setUp() {
        szamla = new HitelSzamla(new Tulajdonos("Gipsz Jakab"), 10000);
    }

    @Test
    void getHitelKeret() {
        assertEquals(10000, szamla.getHitelKeret());
    }

    @Test
    void kivesz() {
        assertFalse(szamla.kivesz(10001));
        assertEquals(0, szamla.getAktualisEgyenleg());
        assertTrue(szamla.kivesz(10000));
        assertEquals(-10000, szamla.getAktualisEgyenleg());
        szamla.befizet(20000);
        assertTrue(szamla.kivesz(5000));
        assertEquals(5000, szamla.getAktualisEgyenleg());
    }
}
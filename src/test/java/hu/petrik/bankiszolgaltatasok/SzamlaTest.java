package hu.petrik.bankiszolgaltatasok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class SzamlaTest {
    Szamla szamla;

    @BeforeEach
    void setUp() {
        Tulajdonos tulajdonos = new Tulajdonos("Gipsz Jakab");
        szamla = new Szamla(tulajdonos) {
            @Override
            public boolean kivesz(int osszeg) {
                szamla.aktualisEgyenleg -= osszeg;
                return true;
            }
        };
    }

    @Test
    void getAktualisEgyenleg() {
        assertEquals(0, szamla.getAktualisEgyenleg());
    }

    @Test
    void befizet() {
        assertEquals(0, szamla.getAktualisEgyenleg());
        szamla.befizet(10000);
        assertEquals(10000, szamla.getAktualisEgyenleg());
    }

    @Test
    void kivesz() throws ClassNotFoundException, NoSuchMethodException {
        Method method = Class.forName("hu.petrik.bankiszolgaltatasok.Szamla").getMethod("kivesz", int.class);
        assertTrue(Modifier.isAbstract(method.getModifiers()));
    }

    @Test
    void ujKartya() {
        Kartya k = new Kartya(szamla.getTulajdonos(), szamla, "1234-5678");
        szamla.befizet(10000);
        k.vasarlas(3000);
        assertEquals(7000, szamla.getAktualisEgyenleg());
    }

    @Test
    void classIsAbstract() throws ClassNotFoundException {
        Class<?> c = Class.forName("hu.petrik.bankiszolgaltatasok.Szamla");
        assertTrue(Modifier.isAbstract(c.getModifiers()));
    }
}
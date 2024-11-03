package hu.petrik.bankiszolgaltatasok;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class TulajdonosTest {
    Tulajdonos tulajdonos;

    @BeforeEach
    void setUp() {
        tulajdonos = new Tulajdonos("Gipsz Jakab");
    }

    @Test
    void getNev() {
        assertEquals("Gipsz Jakab", tulajdonos.getNev());
    }

    @Test
    void setNev() {
        tulajdonos.setNev("Teszt Elek");
        assertEquals("Teszt Elek", tulajdonos.getNev());
    }

    @Test
    void classIsFinal() throws ClassNotFoundException {
        Class c = Class.forName("hu.petrik.bankiszolgaltatasok.Tulajdonos");
        assertTrue(Modifier.isFinal(c.getModifiers()));
    }
}
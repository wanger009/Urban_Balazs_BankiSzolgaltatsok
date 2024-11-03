package hu.petrik.bankiszolgaltatasok;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class BankiSzolgaltatasTest {

    @Test
    void getTulajdonos() {
        Tulajdonos tulajdonos = new Tulajdonos("Gipsz Jakab");
        BankiSzolgaltatas szolgaltatas = new BankiSzolgaltatas(tulajdonos) {
        };
        assertEquals(tulajdonos, szolgaltatas.getTulajdonos());
    }

    @Test
    void classIsAbstract() throws ClassNotFoundException {
        Class<?> c = Class.forName("hu.petrik.bankiszolgaltatasok.BankiSzolgaltatas");
        assertTrue(Modifier.isAbstract(c.getModifiers()));
    }
}
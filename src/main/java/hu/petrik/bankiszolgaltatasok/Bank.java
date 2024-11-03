package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Szamla> szamlak = new ArrayList<>();

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelkeret) {
        if (hitelkeret < 0) {
            throw new IllegalArgumentException("A hitelkeret nem lehet negatív");
        }
        Szamla szamla;
        if (hitelkeret == 0) {
            szamla = new MegtakaritasiSzamla(tulajdonos);
        } else {
            szamla = new HitelSzamla(tulajdonos, hitelkeret);
        }
        szamlak.add(szamla);
        return szamla;
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos) {
        return szamlak.stream()
                .filter(szamla -> szamla.getTulajdonos().equals(tulajdonos))
                .mapToInt(Szamla::getEgyenleg)
                .sum();
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        return szamlak.stream()
                .filter(szamla -> szamla.getTulajdonos().equals(tulajdonos))
                .max((sz1, sz2) -> Integer.compare(sz1.getEgyenleg(), sz2.getEgyenleg()))
                .orElse(null);
    }

    public int getOsszHitelkeret() {
        return szamlak.stream()
                .filter(szamla -> szamla instanceof HitelSzamla)
                .mapToInt(szamla -> ((HitelSzamla) szamla).getHitelkeret())
                .sum();
    }
}
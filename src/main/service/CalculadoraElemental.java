package main.service;

import main.model.TipoElemental;

public class CalculadoraElemental {


    public int calcularBonus(String atacante, String defensor) {
        if (atacante.equals(TipoElemental.FOGO) && defensor.equals(TipoElemental.TERRA)) {
            return 10;
        } else if (atacante.equals(TipoElemental.AGUA) && defensor.equals(TipoElemental.FOGO)) {
            return 10;
        } else if (atacante.equals(TipoElemental.TERRA) && defensor.equals(TipoElemental.AR)) {
            return 10;
        } else if (atacante.equals(TipoElemental.AR) && defensor.equals(TipoElemental.AGUA)) {
            return 10;
        } else if (atacante.equals(TipoElemental.LUZ) && defensor.equals(TipoElemental.TREVAS)) {
            return 15;
        } else if (atacante.equals(TipoElemental.TREVAS) && defensor.equals(TipoElemental.LUZ)) {
            return 15;
        }
        return 0;
    }
}

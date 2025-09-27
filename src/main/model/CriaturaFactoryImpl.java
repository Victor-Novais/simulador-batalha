package main.model;

public class CriaturaFactoryImpl implements CriaturaFactory {

    public static String getNome(int tipo) {
        switch (tipo) {
            case TUBARAO: return "Tubarão";
            case GOLFINHO: return "Golfinho";
            case DRAGAO_DE_KOMODO: return "Dragão de Komodo";
            case MACACO_UACARI: return "Macaco Uacari";
            case TATU: return "Tatu";
            case COBRA_MAMBA: return "Cobra Mamba";
            case AGUIA: return "Águia";
            case PITOHUI: return "Pitohui";
            case CORUJA: return "Coruja";
            case CISNE: return "Cisne";
            case PEIXE_DIABO_NEGRO: return "Peixe-Diabo Negro";
            case CORVO: return "Corvo";
            default: return "Desconhecido";
        }
    }

    @Override
    public Criatura criaturaFactory(int tipoCriatura) {
        switch (tipoCriatura) {
            case TUBARAO: return new Tubarao();
            case GOLFINHO: return new Golfinho();
            case DRAGAO_DE_KOMODO: return new DragaoKomodo();
            case MACACO_UACARI: return new MacacoUacari();
            case TATU: return new Tatu();
            case COBRA_MAMBA: return new CobraMamba();
            case AGUIA: return new Aguia();
            case PITOHUI: return new Pitohui();
            case CORUJA: return new Coruja();
            case CISNE: return new Cisne();
            case PEIXE_DIABO_NEGRO: return new Peixe();
            case CORVO: return new Corvo();
            default: throw new IllegalArgumentException("ID de criatura inválido!");
        }
    }
}

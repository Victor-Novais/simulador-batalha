package main.service;

import java.util.Random;

import main.model.Criatura;
import main.model.EfeitoStatus;

public class GerenciadorEfeitos {

    private Random random = new Random();

    public void aplicarEfeitoAleatorio(Criatura alvo) {
        int chance = random.nextInt(100);
        if (chance < 15) {
            alvo.aplicarEfeito(EfeitoStatus.QUEIMAR);
        } else if (chance < 30) {
            alvo.aplicarEfeito(EfeitoStatus.ENVENENAR);
        }
    }

    public void aplicarEfeito(Criatura alvo, int efeito) {
        alvo.aplicarEfeito(efeito);
    }

    public void limparEfeitos(Criatura alvo) {
        alvo.limparEfeito();
    }
}

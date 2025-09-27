package main.model;

import java.util.List;

public class Cisne extends Criatura {

    public Cisne() {
        super(
                "Cisne",
                100,
                30,
                20,
                2,
                TipoElemental.LUZ,
                List.of(
                        new HabilidadeAtiva("Asas Protetoras", "Cura 20 HP de um aliado") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int cura = 20;
                                alvo.vida += cura;
                                if (alvo.vida > 100) alvo.vida = 100;
                                System.out.println(atacante.getNome() + " usou Asas Protetoras em " +
                                        alvo.getNome() + " curando " + cura + " de HP!");
                            }
                        },
                        new HabilidadeAtiva("Canção Serena", "Remove 1 efeito negativo de todos os aliados") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                alvo.limparEfeito();
                                System.out.println(atacante.getNome() + " usou Canção Serena em " +
                                        alvo.getNome() + " removendo efeitos negativos!");

                            }
                        },
                        new HabilidadeAtiva("Luz da Aurora", "Cura todos os aliados em 30 HP (ultimate)") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int cura = 30;
                                alvo.vida += cura;
                                if (alvo.vida > 100) alvo.vida = 100;
                                System.out.println(atacante.getNome() + " usou Luz da Aurora em " +
                                        alvo.getNome() + " curando " + cura + " de HP!");

                            }
                        }
                )
        );
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println("Escolha uma habilidade ativa para usar!");
    }
}

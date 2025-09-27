package main.model;

import java.util.List;

public class Peixe extends Criatura {

    public Peixe() {
        super(
                "Peixe-Diabo Negro",
                100,
                90,
                10,
                1,
                TipoElemental.TREVAS,
                List.of(
                        new HabilidadeAtiva("Mordida Sombria", "Dano alto + chance de amaldiçoar") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 40;
                                alvo.receberDano(dano);
                                if (Math.random() < 0.3) {
                                    alvo.aplicarEfeito(EfeitoStatus.AMALDICOAR);
                                }
                                System.out.println(atacante.getNome() + " usou Mordida Sombria em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Chama Abissal", "Reduz a cura recebida pelo inimigo por 2 turnos") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                System.out.println(atacante.getNome() + " usou Chama Abissal! " +
                                        alvo.getNome() + " terá sua cura reduzida por 2 turnos.");

                            }
                        },
                        new HabilidadeAtiva("Explosão Maldita", "Se HP <30%, explode causando grande dano") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                if (atacante.getVida() < 30) {
                                    int dano = 60;
                                    alvo.receberDano(dano);
                                    System.out.println(atacante.getNome() + " usou Explosão Maldita em " +
                                            alvo.getNome() + " causando " + dano + " de dano!");
                                } else {
                                    System.out.println(atacante.getNome() + " tentou usar Explosão Maldita, mas o HP é maior que 30!");
                                }
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

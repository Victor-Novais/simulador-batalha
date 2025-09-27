package main.model;

import java.util.List;

public class Corvo extends Criatura {

    public Corvo() {
        super(
                "Corvo",
                100,
                65,
                30,
                4,
                TipoElemental.TREVAS,
                List.of(
                        new HabilidadeAtiva("Bicada Sombria", "Dano físico + chance de amaldiçoar") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 25;
                                alvo.receberDano(dano);
                                if (Math.random() < 0.3) {
                                    alvo.aplicarEfeito(EfeitoStatus.AMALDICOAR);
                                }
                                System.out.println(atacante.getNome() + " usou Bicada Sombria em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Voo Noturno", "Esquiva garantida do próximo ataque") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                System.out.println(atacante.getNome() + " usou Voo Noturno! O próximo ataque será esquivado.");

                                atacante.aplicarEfeito(EfeitoStatus.ATORDOAR);
                            }
                        },
                        new HabilidadeAtiva("Maldição do Corvo", "O inimigo perde 10 HP a cada turno por 3 turnos") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                System.out.println(atacante.getNome() + " usou Maldição do Corvo em " +
                                        alvo.getNome() + "! Ele perderá 10 HP por 3 turnos.");

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

package main.model;

import java.util.List;

public class Tubarao extends Criatura {

    public Tubarao() {
        super(
                "Tubarão",
                100,
                85,
                45,
                3,
                TipoElemental.AGUA,
                List.of(
                        new HabilidadeAtiva("Mordida Brutal", "Dano físico pesado") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 40;
                                alvo.receberDano(dano);
                                System.out.println(atacante.getNome() + " usou Mordida Brutal em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Caça na Corrente", "Ataca primeiro no turno (ignora iniciativa)") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {

                                int originalVelocidade = atacante.getVelocidade();
                                atacante.velocidade = alvo.getVelocidade() + 1;
                                System.out.println(atacante.getNome() + " usou Caça na Corrente e atacará primeiro neste turno!");

                                atacante.velocidade = originalVelocidade;
                            }
                        },
                        new HabilidadeAtiva("Mergulho Sangrento", "Causa muito dano crítico") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = atacante.getAtaque() * 2;
                                alvo.receberDano(dano);
                                System.out.println(atacante.getNome() + " usou Mergulho Sangrento em " +
                                        alvo.getNome() + " causando " + dano + " de dano crítico!");
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

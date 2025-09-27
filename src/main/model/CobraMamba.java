package main.model;

import java.util.List;

public class CobraMamba extends Criatura {

    public CobraMamba() {
        super(
                "Cobra Mamba Negra",
                100,
                84,
                70,
                4,
                TipoElemental.TERRA,
                List.of(
                        new HabilidadeAtiva("Picada Mortal", "Dano físico + envenena") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 25;
                                alvo.receberDano(dano);
                                alvo.aplicarEfeito(EfeitoStatus.ENVENENAR);
                                System.out.println(atacante.getNome() + " usou Picada Mortal em " +
                                        alvo.getNome() + " causando " + dano + " de dano e envenenando!");
                            }
                        },
                        new HabilidadeAtiva("Golpe Ágil", "Ataca duas vezes seguidas com 60% do dano") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = (int)(atacante.getAtaque() * 0.6);
                                alvo.receberDano(dano);
                                alvo.receberDano(dano);
                                System.out.println(atacante.getNome() + " usou Golpe Ágil em " +
                                        alvo.getNome() + " atacando duas vezes e causando " + dano*2 + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Veneno Concentrado", "Aumenta o dano do envenenamento por 3 turnos") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                System.out.println(atacante.getNome() + " usou Veneno Concentrado! O dano do veneno aumentará por 3 turnos!");

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

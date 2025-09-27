package main.model;

import java.util.List;

public class Pitohui extends Criatura {

    public Pitohui() {
        super(
                "Pássaro Pitohui-Encapuzado",
                100,
                73,
                32,
                5,
                TipoElemental.AR,
                List.of(
                        new HabilidadeAtiva("Bicada Venenosa", "Dano + envenena") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 25;
                                alvo.receberDano(dano);
                                alvo.aplicarEfeito(EfeitoStatus.ENVENENAR);
                                System.out.println(atacante.getNome() + " usou Bicada Venenosa em " +
                                        alvo.getNome() + " causando " + dano + " de dano e envenenando!");
                            }
                        },
                        new HabilidadeAtiva("Plumagem Tóxica", "Inimigos que atacarem sofrem dano de veneno") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                System.out.println(atacante.getNome() + " ativou Plumagem Tóxica! Quem atacar sofrerá dano de veneno.");

                            }
                        },
                        new HabilidadeAtiva("Grito Estridente", "Reduz ataque dos inimigos em 20%") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int reducao = (int)(alvo.getAtaque() * 0.2);
                                alvo.ataque -= reducao;
                                System.out.println(atacante.getNome() + " usou Grito Estridente! " +
                                        alvo.getNome() + " teve seu ataque reduzido em " + reducao + "!");
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

package main.model;

import java.util.List;

public class DragaoKomodo extends Criatura {

    public DragaoKomodo() {
        super(
                "Dragão-De-Komodo",
                100 ,
                86,
                35,
                2,
                TipoElemental.FOGO,
                List.of(
                        new HabilidadeAtiva("Mordida Venenosa", "Dano médio + chance de envenenar") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 25;
                                alvo.receberDano(dano);
                                if(Math.random() < 0.3) {
                                    alvo.aplicarEfeito(EfeitoStatus.ENVENENAR);
                                }
                                System.out.println(atacante.getNome() + " usou Mordida Venenosa em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Cauda Flamejante", "Dano alto + queimadura por 2 turnos") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 40;
                                alvo.receberDano(dano);
                                alvo.aplicarEfeito(EfeitoStatus.QUEIMAR);
                                System.out.println(atacante.getNome() + " usou Cauda Flamejante em " +
                                        alvo.getNome() + " causando " + dano + " de dano e queimando!");
                            }
                        },
                        new HabilidadeAtiva("Rugido Incendiário", "Dano pequeno a todos inimigos + chance de queimar") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 15;
                                alvo.receberDano(dano);
                                if(Math.random() < 0.25) {
                                    alvo.aplicarEfeito(EfeitoStatus.QUEIMAR);
                                }
                                System.out.println(atacante.getNome() + " usou Rugido Incendiário em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
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

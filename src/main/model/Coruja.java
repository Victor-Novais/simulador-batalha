package main.model;

import java.util.List;

public class Coruja extends Criatura {

    public Coruja() {
        super(
                "Coruja das Neves",
                100,
                85,
                20,
                4,
                TipoElemental.LUZ,
                List.of(
                        new HabilidadeAtiva("Rajada Gélida", "Dano + chance de congelar") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 25;
                                alvo.receberDano(dano);
                                if (Math.random() < 0.3) {
                                    alvo.aplicarEfeito(EfeitoStatus.CONGELAR);
                                }
                                System.out.println(atacante.getNome() + " usou Rajada Gélida em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Olhar Intimidador", "Reduz ataque do inimigo em 25% por 2 turnos") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int reducao = (int)(alvo.getAtaque() * 0.25);
                                alvo.ataque -= reducao;
                                System.out.println(atacante.getNome() + " usou Olhar Intimidador! " +
                                        alvo.getNome() + " teve seu ataque reduzido em " + reducao + "!");
                               
                            }
                        },
                        new HabilidadeAtiva("Tempestade de Gelo", "Dano em área médio + chance de congelar todos") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 30; 
                                alvo.receberDano(dano);
                                if (Math.random() < 0.25) { 
                                    alvo.aplicarEfeito(EfeitoStatus.CONGELAR);
                                }
                                System.out.println(atacante.getNome() + " usou Tempestade de Gelo em " +
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

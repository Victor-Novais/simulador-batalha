package main.model;

import java.util.List;

public class Tatu extends Criatura {

    public Tatu() {
        super(
                "Tatu",
                100,
                60,
                70,
                1,
                TipoElemental.TERRA,
                List.of(
                        new HabilidadeAtiva("Rolamento Defensivo", "Dano baixo + aumenta defesa própria") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 15;
                                alvo.receberDano(dano);
                                atacante.defesa += 10;
                                System.out.println(atacante.getNome() + " usou Rolamento Defensivo em " +
                                        alvo.getNome() + ", causando " + dano + " de dano e aumentando sua defesa!");
                            }
                        },
                        new HabilidadeAtiva("Terremoto", "Dano em área + reduz velocidade dos inimigos") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 25;
                                alvo.receberDano(dano);
                                alvo.velocidade = Math.max(1, alvo.velocidade - 1);
                                System.out.println(atacante.getNome() + " usou Terremoto em " +
                                        alvo.getNome() + ", causando " + dano + " de dano e reduzindo velocidade!");
                            }
                        },
                        new HabilidadeAtiva("Casco Inquebrável", "Ignora 50% da defesa do inimigo") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = Math.max(20, atacante.getAtaque() - (alvo.getDefesa() / 2));
                                alvo.receberDano(dano);
                                System.out.println(atacante.getNome() + " usou Casco Inquebrável em " +
                                        alvo.getNome() + ", causando " + dano + " de dano!");
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

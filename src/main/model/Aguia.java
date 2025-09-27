package main.model;

import java.util.List;

public class Aguia extends Criatura {

    public Aguia() {
        super(
                "Águia",
                100,
                70,
                40,
                5,
                TipoElemental.AR,
                List.of(
                        new HabilidadeAtiva("Garras Velozes", "Dano normal + chance de envenenar") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 20;
                                alvo.receberDano(dano);
                                if (Math.random() < 0.3) {
                                    alvo.aplicarEfeito(EfeitoStatus.ENVENENAR);
                                }
                                System.out.println(atacante.getNome() + " usou Garras Velozes em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Voo Rasante", "Sempre ataca primeiro, dano médio") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int originalVelocidade = atacante.getVelocidade();
                                atacante.velocidade = alvo.getVelocidade() + 1;
                                int dano = 35;
                                alvo.receberDano(dano);
                                System.out.println(atacante.getNome() + " usou Voo Rasante em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                                atacante.velocidade = originalVelocidade;
                            }
                        },
                        new HabilidadeAtiva("Tempestade de Asas", "Ataque em área pequena + reduz precisão dos inimigos") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 25;
                                alvo.receberDano(dano);

                                System.out.println(atacante.getNome() + " usou Tempestade de Asas em " +
                                        alvo.getNome() + ", causando " + dano + " de dano e reduzindo precisão!");
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

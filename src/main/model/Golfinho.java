package main.model;

import java.util.List;

public class Golfinho extends Criatura {

    public Golfinho() {
        super(
                "Golfinho",
                100,
                60,
                30,
                4,
                TipoElemental.AGUA,
                List.of(
                        new HabilidadeAtiva("Onda Sonora", "Dano + chance de atordoar 1 turno") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 20;
                                alvo.receberDano(dano);
                                if(Math.random() < 0.25) {
                                    alvo.aplicarEfeito(EfeitoStatus.ATORDOAR);
                                }
                                System.out.println(atacante.getNome() + " usou Onda Sonora em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Salto Alegre", "Cura 15 HP") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int cura = 15;
                                atacante.vida += cura;
                                System.out.println(atacante.getNome() + " usou Salto Alegre e recuperou " + cura + " de HP!");
                            }
                        },
                        new HabilidadeAtiva("Onda Curativa", "Cura todo o time em 10 HP") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {

                                int cura = 10;
                                alvo.vida += cura;
                                System.out.println(atacante.getNome() + " usou Onda Curativa e curou " + alvo.getNome() +
                                        " em " + cura + " de HP!");
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

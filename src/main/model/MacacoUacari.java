package main.model;

import java.util.List;

public class MacacoUacari extends Criatura {

    public MacacoUacari() {
        super(
                "Macaco-Uacari",
                100,
                60,
                70,
                3,
                TipoElemental.FOGO,
                List.of(
                        new HabilidadeAtiva("Soco Flamejante", "Dano físico + chance de Queimar") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = 20;
                                alvo.receberDano(dano);
                                if(Math.random() < 0.3) {
                                    alvo.aplicarEfeito(EfeitoStatus.QUEIMAR);
                                }
                                System.out.println(atacante.getNome() + " usou Soco Flamejante em " +
                                        alvo.getNome() + " causando " + dano + " de dano!");
                            }
                        },
                        new HabilidadeAtiva("Agilidade Selvagem", "Ganha +30% de velocidade") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int bonusVelocidade = (int)(atacante.getVelocidade() * 0.3);
                                atacante.velocidade += bonusVelocidade;
                                System.out.println(atacante.getNome() + " usou Agilidade Selvagem e aumentou a velocidade em " +
                                        bonusVelocidade + "!");
                            }
                        },
                        new HabilidadeAtiva("Explosão Ígnea", "Ataque poderoso que ignora parte da defesa") {
                            @Override
                            public void executar(Criatura atacante, Criatura alvo) {
                                int dano = Math.max(25, atacante.getAtaque() - (alvo.getDefesa() / 2));
                                alvo.receberDano(dano);
                                System.out.println(atacante.getNome() + " usou Explosão Ígnea em " +
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

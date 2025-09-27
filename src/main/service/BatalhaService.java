package main.service;

import main.model.Criatura;
import java.util.List;
import java.util.Scanner;

public class BatalhaService {

    private CalculadoraElemental calculadora;
    private GerenciadorEfeitos gerenciadorEfeitos;
    private Scanner scanner;

    public BatalhaService() {
        this.calculadora = new CalculadoraElemental();
        this.gerenciadorEfeitos = new GerenciadorEfeitos();
        this.scanner = new Scanner(System.in);
    }

    public void batalhar(List<Criatura> time1, List<Criatura> time2) {
        System.out.println("=== Iniciando Batalha ===");

        int turno = 1;
        while (timeVivo(time1) && timeVivo(time2)) {
            System.out.println("\n===== TURNO " + turno + " =====");

            int maxAcoes = Math.max(time1.size(), time2.size());

            for (int i = 0; i < maxAcoes; i++) {

                if (i < time1.size() && time1.get(i).estaViva()) {
                    executarAcao("Jogador 1", time1.get(i), time1, time2);
                    if (!timeVivo(time2)) break;
                }


                if (i < time2.size() && time2.get(i).estaViva()) {
                    executarAcao("Jogador 2", time2.get(i), time2, time1);
                    if (!timeVivo(time1)) break;
                }
            }

            turno++;
        }

        if (timeVivo(time1)) {
            System.out.println("\nJogador 1 venceu a batalha!");
        } else {
            System.out.println("\nJogador 2 venceu a batalha!");
        }
    }

    private void executarAcao(String jogador, Criatura atacante,
                              List<Criatura> timeAtacante, List<Criatura> timeDefensor) {

        System.out.println("\n--- " + jogador + " ---");
        System.out.println(atacante.getNome() + " está pronto para agir!");


        for (int i = 0; i < atacante.getHabilidades().size(); i++) {
            System.out.println(i + " - " + atacante.getHabilidades().get(i).getNome() +
                    " (" + atacante.getHabilidades().get(i).getDescricao() + ")");
        }
        int escolhaHab = scanner.nextInt();


        List<Criatura> possiveisAlvos;
        if (atacante.getHabilidades().get(escolhaHab).getNome().toLowerCase().contains("cura")
                || atacante.getHabilidades().get(escolhaHab).getDescricao().toLowerCase().contains("cura")) {

            possiveisAlvos = timeAtacante;
        } else {
            possiveisAlvos = timeDefensor;
        }

        System.out.println("Escolha o alvo:");
        for (int i = 0; i < possiveisAlvos.size(); i++) {
            Criatura alvo = possiveisAlvos.get(i);
            if (alvo.estaViva()) {
                System.out.println(i + " - " + alvo.getNome() + " (HP: " + alvo.getVida() + ")");
            }
        }
        int escolhaAlvo = scanner.nextInt();


        atacante.usarHabilidade(escolhaHab, possiveisAlvos.get(escolhaAlvo));


        if (!possiveisAlvos.get(escolhaAlvo).estaViva()) {
            System.out.println(possiveisAlvos.get(escolhaAlvo).getNome() + " foi derrotado!");
        }
    }

    private boolean timeVivo(List<Criatura> time) {
        return time.stream().anyMatch(Criatura::estaViva);
    }
}

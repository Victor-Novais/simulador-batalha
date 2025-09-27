package main.service;


import main.model.Criatura;
import java.util.*;
import java.util.stream.Collectors;


public class BatalhaService {


    private Scanner scanner;


    public BatalhaService() {
        this.scanner = new Scanner(System.in);
    }


    public void batalhar(List<Criatura> time1, List<Criatura> time2, String nomeJogador1, String nomeJogador2) {
        System.out.println("=== Iniciando Batalha ===");


        int turno = 1;
        while (timeVivo(time1) && timeVivo(time2)) {
            System.out.println("\n===== TURNO " + turno + " =====");




            List<Criatura> ordem = new ArrayList<>();
            ordem.addAll(time1.stream().filter(Criatura::estaViva).collect(Collectors.toList()));
            ordem.addAll(time2.stream().filter(Criatura::estaViva).collect(Collectors.toList()));




            ordem.sort((a, b) -> Integer.compare(b.getVelocidade(), a.getVelocidade()));




            for (Criatura atacante : ordem) {
                if (!atacante.estaViva()) continue;


                List<Criatura> meuTime = time1.contains(atacante) ? time1 : time2;
                List<Criatura> inimigos = (meuTime == time1) ? time2 : time1;
                String jogador = (meuTime == time1) ? nomeJogador1 : nomeJogador2;




                executarAcao(jogador, atacante, meuTime, inimigos);


                if (!timeVivo(time1) || !timeVivo(time2)) break;
            }


            turno++;
        }


        if (timeVivo(time1)) {
            System.out.println("\n" + nomeJogador1 + " venceu a batalha!");
        } else {
            System.out.println("\n" + nomeJogador2 + " venceu a batalha!");
        }
    }


    private void executarAcao(String jogador, Criatura atacante,
                              List<Criatura> timeAtacante, List<Criatura> timeDefensor) {


        System.out.println("\n--- " + jogador + " ---");
        System.out.println(atacante.getNome() + " (Velocidade: " + atacante.getVelocidade() + ") está pronto para agir!");




        for (int i = 0; i < atacante.getHabilidades().size(); i++) {
            System.out.println(i + " - " + atacante.getHabilidades().get(i).getNome() +
                    " (" + atacante.getHabilidades().get(i).getDescricao() + ")");
        }
        int escolhaHab = scanner.nextInt();




        List<Criatura> possiveisAlvos;
        String nomeHab = atacante.getHabilidades().get(escolhaHab).getNome().toLowerCase();
        String descHab = atacante.getHabilidades().get(escolhaHab).getDescricao().toLowerCase();


        if (nomeHab.contains("cura") || descHab.contains("cura")) {


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

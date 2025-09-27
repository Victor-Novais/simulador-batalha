package main;


import main.model.*;
import main.service.BatalhaService;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BatalhaService batalhaService = new BatalhaService();
        System.out.println("=== Simulador de Batalha ===");
        System.out.print("Digite o nome do Jogador 1: ");
        Jogador j1 = new Jogador(sc.nextLine());
        System.out.print("Digite o nome do Jogador 2: ");
        Jogador j2 = new Jogador(sc.nextLine());
        System.out.println("\nEscolha suas criaturas (máx. 3 cada)");
        escolherTime(sc, j1);
        escolherTime(sc, j2);
        System.out.println("\n=== Começando a batalha entre " + j1.getNome() + " e " + j2.getNome() + " ===");
        batalhaService.batalhar(j1.getTime(), j2.getTime(),j1.getNome(), j2.getNome());
        if (j1.aindaTemCriaturas()) {
            System.out.println("\n" + j1.getNome() + " venceu a batalha!");
        } else {
            System.out.println("\n" + j2.getNome() + " venceu a batalha!");
        }
        sc.close();
    }


    private static void escolherTime(Scanner sc, Jogador jogador) {
        CriaturaFactory factory = new CriaturaFactoryImpl();
        for (int i = 0; i < 3; i++) {
            System.out.println("\n" + jogador.getNome() + ", escolha sua criatura " + (i + 1) + ":");
            for (int id = 0; id <= CriaturaFactory.CORVO; id++) {
                System.out.println(id + " - " + CriaturaFactoryImpl.getNome(id));
            }
            int opcao = sc.nextInt();
            sc.nextLine();
            try {
                Criatura escolhida = factory.criaturaFactory(opcao);
                jogador.adicionarCriatura(escolhida);
                System.out.println("OK,  " + CriaturaFactoryImpl.getNome(opcao) + " adicionado ao time!");
            } catch (Exception e) {
                System.out.println(" Opção inválida, escolhendo Águia por padrão.");
                jogador.adicionarCriatura(new Aguia());
            }
        }
    }
}



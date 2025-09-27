package main.model;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Criatura> criaturas;
    private List<Item> inventario;

    public Jogador(String nome) {
        this.nome = nome;
        this.criaturas = new ArrayList<>();
        this.inventario = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Criatura> getCriaturas() {
        return criaturas;
    }


    public List<Criatura> getTime() {
        return criaturas;
    }

    public void adicionarCriatura(Criatura criatura) {
        if (criaturas.size() < 3) {
            criaturas.add(criatura);
            System.out.println(nome + " escolheu " + criatura.getNome());
        } else {
            System.out.println("Time cheio! Máximo de 3 criaturas.");
        }
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public boolean aindaTemCriaturas() {
        return criaturas.stream().anyMatch(Criatura::estaViva);
    }

    public Criatura escolherCriaturaAtiva() {

        return criaturas.stream()
                .filter(Criatura::estaViva)
                .findFirst()
                .orElse(null);
    }
}

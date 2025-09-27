package main.service;

import java.util.ArrayList;
import java.util.List;

import main.model.Criatura;
import main.model.Item;

public class InventarioService {

    private List<Item> itens;

    public InventarioService() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void usarItem(int index, Criatura alvo) {
        if (index >= 0 && index < itens.size()) {
            Item item = itens.get(index);
            item.usar(alvo);
            itens.remove(index);
        } else {
            System.out.println("Item inválido!");
        }
    }

    public void listarItens() {
        System.out.println("Itens no inventário:");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println(i + " - " + itens.get(i).getNome());
        }
    }
}

package modelo;

import java.util.ArrayList;
import java.util.List;

public class CardapioCRUD {
    private List<Cardapio> cardapios = new ArrayList<>();

    // Adicionar novo cardápio
    public void adicionarCardapio(Cardapio cardapio) {
        cardapios.add(cardapio);
        System.out.println("Cardápio adicionado com sucesso!");
    }

    // Listar todos os cardápios
    public void listarCardapios() {
        if (cardapios.isEmpty()) {
            System.out.println("Nenhum cardápio cadastrado.");
            return;
        }

        for (Cardapio c : cardapios) {
            System.out.println("Nome: " + c.getNome() +
                               " | Descrição: " + c.getDescricao() +
                               " | Disponível: " + (c.isDisponivel() ? "Sim" : "Não") +
                               " | Itens: " + c.getCardapioItens().size());
        }
    }

    // Buscar cardápio pelo nome
    public Cardapio buscarCardapioPorNome(String nome) {
        for (Cardapio c : cardapios) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    // Atualizar cardápio existente
    public boolean atualizarCardapio(String nome, String novaDescricao, boolean novoDisponivel) {
        Cardapio c = buscarCardapioPorNome(nome);
        if (c != null) {
            c.setDescricao(novaDescricao);
            c.setDisponivel(novoDisponivel);
            System.out.println("Cardápio atualizado com sucesso!");
            return true;
        } else {
            System.out.println("Cardápio não encontrado.");
            return false;
        }
    }

    // Remover cardápio
    public boolean removerCardapio(String nome) {
        Cardapio c = buscarCardapioPorNome(nome);
        if (c != null) {
            cardapios.remove(c);
            System.out.println("Cardápio removido com sucesso!");
            return true;
        } else {
            System.out.println("Cardápio não encontrado.");
            return false;
        }
    }

    // Adicionar item em um cardápio
    public boolean adicionarItemAoCardapio(String nomeCardapio, CardapioItem item) {
        Cardapio c = buscarCardapioPorNome(nomeCardapio);
        if (c != null) {
            c.adicionarCardapioItem(item);
            System.out.println("Item adicionado ao cardápio com sucesso!");
            return true;
        } else {
            System.out.println("Cardápio não encontrado.");
            return false;
        }
    }

    // Remover item de um cardápio
    public boolean removerItemDoCardapio(String nomeCardapio, CardapioItem item) {
        Cardapio c = buscarCardapioPorNome(nomeCardapio);
        if (c != null) {
            c.removerCardapioItem(item);
            System.out.println("Item removido do cardápio com sucesso!");
            return true;
        } else {
            System.out.println("Cardápio não encontrado.");
            return false;
        }
    }
}

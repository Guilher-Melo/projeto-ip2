package modelo;

import java.util.ArrayList;
import java.util.List;

public class MesaCRUD {
    private List<Mesa> mesas = new ArrayList<>();

    // Adicionar nova mesa
    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
        System.out.println("Mesa adicionada com sucesso!");
    }

    // Listar todas as mesas
    public void listarMesas() {
        if (mesas.isEmpty()) {
            System.out.println("Nenhuma mesa cadastrada.");
            return;
        }

        for (Mesa mesa : mesas) {
            System.out.println("Número: " + mesa.getNumero() +
                               " | Capacidade: " + mesa.getCapacidade() +
                               " | Status: " + mesa.getStatus());
        }
    }

    // Buscar mesa pelo número
    public Mesa buscarMesaPorNumero(int numero) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numero) {
                return mesa;
            }
        }
        return null;
    }

    // Atualizar mesa existente
    public boolean atualizarMesa(int numero, int novaCapacidade, StatusMesa novoStatus) {
        Mesa mesa = buscarMesaPorNumero(numero);
        if (mesa != null) {
            mesa.setCapacidade(novaCapacidade);
            mesa.setStatus(novoStatus);
            System.out.println("Mesa atualizada com sucesso!");
            return true;
        } else {
            System.out.println("Mesa não encontrada.");
            return false;
        }
    }

    // Remover mesa
    public boolean removerMesa(int numero) {
        Mesa mesa = buscarMesaPorNumero(numero);
        if (mesa != null) {
            mesas.remove(mesa);
            System.out.println("Mesa removida com sucesso!");
            return true;
        } else {
            System.out.println("Mesa não encontrada.");
            return false;
        }
    }
}

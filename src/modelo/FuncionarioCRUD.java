
package modelo;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioCRUD {
    private List<Funcionario> funcionarios = new ArrayList<>();

    // Adicionar novo funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    // Listar todos os funcionários
    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
        }
    }

    // Buscar funcionário pelo nome
    public Funcionario buscarFuncionarioPorNome(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    // Atualizar funcionário
    public boolean atualizarFuncionario(String nome, String novoNome, String novoCargo) {
        Funcionario f = buscarFuncionarioPorNome(nome);
        if (f != null) {
            f.setNome(novoNome);
            f.setCargo(novoCargo);
            System.out.println("Funcionário atualizado com sucesso!");
            return true;
        } else {
            System.out.println("Funcionário não encontrado.");
            return false;
        }
    }

    // Remover funcionário
    public boolean removerFuncionario(String nome) {
        Funcionario f = buscarFuncionarioPorNome(nome);
        if (f != null) {
            funcionarios.remove(f);
            System.out.println("Funcionário removido com sucesso!");
            return true;
        } else {
            System.out.println("Funcionário não encontrado.");
            return false;
        }
    }
}

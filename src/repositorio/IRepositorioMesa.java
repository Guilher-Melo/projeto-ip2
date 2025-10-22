package repositorio;

import modelo.Mesa;
import java.util.List;

// Interface
public interface IRepositorioMesa {

    Mesa buscarPorNumero(int numero);
    void atualizar(Mesa mesa);
    void cadastrar(Mesa mesa); // Adicionado para os testes
    List<Mesa> listarTodas();
}
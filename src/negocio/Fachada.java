package negocio;

import modelo.Cliente;
import modelo.Mesa;
import modelo.Reserva;
import modelo.StatusMesa;
import repositorio.IRepositorioCliente;
import repositorio.IRepositorioReserva;

import java.time.Duration;
import java.time.LocalDateTime;

public class Fachada {

    private IRepositorioCliente repositorioCliente;
    private IRepositorioReserva repositorioReserva;

    public Fachada(IRepositorioCliente repositorioCliente,
            IRepositorioReserva repositorioReserva) {

        this.repositorioCliente = repositorioCliente;
        this.repositorioReserva = repositorioReserva;
    }

    // --- PACOTE 2: GESTÃO DE CLIENTES E RESERVAS ---

    // REQ01: Permitir o cadastro de clientes
    public void cadastrarCliente(String nome, String telefone, String email) {
        // REGRA DE NEGÓCIO: Não permitir cliente com mesmo telefone
        Cliente clienteExistente = this.repositorioCliente.buscarPorTelefone(telefone);

        if (clienteExistente != null) {
            System.err.println("Erro (REQ01): Já existe um cliente com o telefone " + telefone);
            return;
        }

        Cliente novoCliente = new Cliente(nome, telefone, email);
        this.repositorioCliente.cadastrar(novoCliente);
        System.out.println("Cliente " + nome + " cadastrado com sucesso.");
    }

    public Cliente buscarClientePorTelefone(String telefone) {
        return this.repositorioCliente.buscarPorTelefone(telefone);
    }

    // REQ02: Manter histórico de consumo por cliente
    public double consultarHistoricoCliente(Cliente cliente) {
        System.out.println("Consultando histórico do cliente: " + cliente.getNome());
        // TODO: A pessoa do Pacote 1 (Pedidos) deverá completar esta lógica.
        // Por enquanto, apenas chama o método original.
        return cliente.consultarHistorico();
    }

    // REQ14: Permitir que clientes façam reservas
    // REQ23: Não permitir reserva de mesa além da capacidade
    public void fazerReserva(String telefoneCliente, Mesa mesa, LocalDateTime dataHora, int numeroPessoas) {
        Cliente cliente = this.repositorioCliente.buscarPorTelefone(telefoneCliente);

        if (cliente == null) {
            System.err.println("Erro (REQ14): Cliente não encontrado.");
            return;
        }

        // REQ23: Não permitir reserva de mesa além da capacidade definida
        if (numeroPessoas > mesa.getCapacidade()) {
            System.err.println("Erro (REQ23): Número de pessoas (" + numeroPessoas +
                    ") excede a capacidade da mesa (" + mesa.getCapacidade() + ").");
            return;
        }

        if (!mesa.getStatus().getNome().equals("Livre")) {
            System.err.println("Erro (REQ14): Mesa " + mesa.getNumero() + " não está 'Livre'.");
            return;
        }

        Reserva novaReserva = new Reserva(dataHora, numeroPessoas, cliente, mesa);
        this.repositorioReserva.cadastrar(novaReserva);

        System.out.println("Sucesso (REQ14): Reserva para " + cliente.getNome() +
                " na Mesa " + mesa.getNumero() + " agendada.");
    }

    // REQ16: Cancelar reservas apenas com antecedência mínima de 1 hora
    public void cancelarReserva(Reserva reserva) {
        LocalDateTime agora = LocalDateTime.now();
        Duration duracao = Duration.between(agora, reserva.getDataHora());

        // REQ16: Regra da 1 hora
        if (duracao.toHours() < 1) {
            System.err.println("Erro (REQ16): Cancelamento não permitido. " +
                    "A reserva é em menos de 1 hora.");
            return;
        }

        this.repositorioReserva.remover(reserva);

        System.out.println("Sucesso (REQ16): Reserva para " + reserva.getCliente().getNome() + " foi cancelada.");
    }
}
import modelo.Cliente;
import modelo.Mesa;
import modelo.Reserva;
import modelo.StatusMesa;
import negocio.Fachada;
import repositorio.IRepositorioCliente;
import repositorio.IRepositorioReserva;
import repositorio.RepositorioClienteArray;
import repositorio.RepositorioReservaArray;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Teste do Pacote 2: Clientes e Reservas ---");

        IRepositorioCliente repoCliente = new RepositorioClienteArray();
        IRepositorioReserva repoReserva = new RepositorioReservaArray();

        Fachada fachada = new Fachada(repoCliente, repoReserva);

        System.out.println("\n--- Testando REQ01 ---");
        fachada.cadastrarCliente("Guilherme Melo", "98888-0001", "gui@email.com");

        fachada.cadastrarCliente("Outro Guilherme", "98888-0001", "gui2@email.com");

        System.out.println("\n--- Testando REQ14, 16, 23 ---");

        StatusMesa statusLivre = new StatusMesa(1, "Livre");
        Mesa mesaSimulada = new Mesa(5, 4, statusLivre);

        System.out.println("Testando REQ23 (Excesso de capacidade):");
        fachada.fazerReserva("98888-0001", mesaSimulada, LocalDateTime.now().plusHours(5), 5);

        System.out.println("\nTestando REQ14 (Reserva correta):");
        LocalDateTime dataReserva = LocalDateTime.now().plusHours(5);
        fachada.fazerReserva("98888-0001", mesaSimulada, dataReserva, 4); // Deve funcionar

        System.out.println("\nTestando REQ16 (Cancelamento OK):");
        // (Buscar a reserva no repositório para o teste)
        Reserva reserva = ((RepositorioReservaArray)repoReserva).listarTodas().get(0);
        fachada.cancelarReserva(reserva); // Deve funcionar

        System.out.println("\nTestando REQ16 (Cancelamento Atrasado):");
        LocalDateTime dataReservaUrgente = LocalDateTime.now().plusMinutes(30);
        fachada.fazerReserva("98888-0001", mesaSimulada, dataReservaUrgente, 2);
        Reserva reservaUrgente = ((RepositorioReservaArray)repoReserva).listarTodas().get(0);
        fachada.cancelarReserva(reservaUrgente); // Deve falhar
    }
}
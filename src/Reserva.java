import java.time.LocalDate;

public class Reserva {
    private LocalDate dataHora;
    private int numeroPessoas;

    public Reserva(LocalDate dataHora, int numeroPessoas) {
        this.dataHora = dataHora;
        this.numeroPessoas = numeroPessoas;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

    public void cancelarReserva() {
        // Lógica pra cancelar a reserva
    }
}
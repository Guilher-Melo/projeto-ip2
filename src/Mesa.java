public class Mesa {

    private int numero;
    private int capacidade;
    private StatusMesa status;

    public Mesa(int numero, int capacidade, StatusMesa status) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public StatusMesa getStatus() {
        return status;
    }

    public void setStatus(StatusMesa status) {
        this.status = status;
    }

    public StatusMesa alterarStatus(StatusMesa novoStatus) {
        // Lógica pra alterar o status da mesa
        this.status = novoStatus;
        return novoStatus;
    }
}
import java.time.LocalDate;

public class Pedido {
    private LocalDate dataHora;
    private double valorTotal;

    public Pedido(LocalDate dataHora, double valorTotal) {
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double calcularTotal(){
        // Implementar lógica para calcular o total do pedido
        return 0.0;
    }

    public void atualizarStatus(){
        // Implementar lógica para atualizar o status do pedido
    }

    public double fecharConta(){
        // Implementar lógica para fechar a conta do pedido
        return valorTotal;
    }
}
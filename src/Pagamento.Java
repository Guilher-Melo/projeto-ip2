import java.time.LocalDateTime;

public class Pagamento {

    private LocalDateTime dataHora;
    private double valor;
    private MetodoPagamento metodoPagamento;

    public Pagamento(double valor, MetodoPagamento metodoPagamento) {
        this.dataHora = LocalDateTime.now();
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public void processarPagamento() {
        System.out.println("Pagamento de R$ " + String.format("%.2f", valor)
                + " via " + metodoPagamento.getNome()
                + " processado em " + dataHora);
    }
}

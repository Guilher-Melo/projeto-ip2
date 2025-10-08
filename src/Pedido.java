import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDateTime dataHora;
    private double valorTotal;
    private Cliente cliente;
    private StatusPedido status;
    private Pagamento pagamento;
    private List<ItemPedido> itens;

    public Pedido(LocalDateTime dataHora, Cliente cliente) {
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public void adicionarItem(ItemPedido item) {
        this.itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getItemCardapio().getPreco() * item.getQuantidade();
        }
        this.valorTotal = total;
        return valorTotal;
    }

    public void atualizarStatus(StatusPedido novoStatus) {
        this.status = novoStatus;
        System.out.println("Status do pedido: " + novoStatus.getNome());
    }

    public double fecharConta() {
        System.out.println("Fechando a conta do pedido...");
        return calcularTotal();
    }
}
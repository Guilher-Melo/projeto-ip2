public class Funcionario {

    private String nome;
    private String cargo;

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Pedido criarPedido(Mesa mesa, Cliente cliente) {
        // A lógica de criação de pedido pode ser mais complexa,
        // mas aqui está um exemplo básico.
        return new Pedido(java.time.LocalDateTime.now(), cliente);
    }

    public void adicionarItemPedido(Pedido pedido, ItemCardapio itemCardapio, int quantidade, String observacoes) {
        ItemPedido novoItem = new ItemPedido(quantidade, observacoes, itemCardapio);
        pedido.adicionarItem(novoItem);
    }

    public void registrarPagamento(Pedido pedido, Pagamento pagamento) {
        pedido.setPagamento(pagamento);
        pagamento.processarPagamento();
    }
}
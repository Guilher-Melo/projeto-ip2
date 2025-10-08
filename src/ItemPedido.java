public class ItemPedido {

    private int quantidade;
    private String observacoes;
    private ItemCardapio itemCardapio;

    public ItemPedido(int quantidade, String observacoes, ItemCardapio itemCardapio) {
        this.quantidade = quantidade;
        this.observacoes = observacoes;
        this.itemCardapio = itemCardapio;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public ItemCardapio getItemCardapio() {
        return itemCardapio;
    }

    public void setItemCardapio(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }
}
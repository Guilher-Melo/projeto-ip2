

public class ItemCardapio {

    private String nome;
    private String descricao;
    private double preco;
    private boolean disponivel;
    private CategoriaItem categoria;

    public ItemCardapio(String nome, String descricao, double preco, CategoriaItem categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = true;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public CategoriaItem getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaItem categoria) {
        this.categoria = categoria;
    }

    public void atualizarDisponibilidade(boolean disponivel) {
        this.disponivel = disponivel;
    }
}


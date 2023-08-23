package model;

public class Produto {
    private String nome;
    private TipoProduto tipoproduto;
    private double preco;

    public Produto(String nome, double preco, TipoProduto tipoproduto) {
        this.nome = nome;
        this.preco = preco;
        this.tipoproduto = tipoproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

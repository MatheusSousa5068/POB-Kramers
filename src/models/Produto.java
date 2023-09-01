package models;

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

    public TipoProduto getProduto() {
        return tipoproduto;
    }

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", tipoproduto=" + tipoproduto.getNome() + ", preco=" + preco + "]";
	}
    
    
}

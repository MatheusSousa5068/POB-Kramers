package models;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Integer id;
    private String data;
    private List<Produto> produtos = new ArrayList<>();
    private double desconto;
    private double valorpago;

    public Venda(Integer id, String data, double desconto, double valorpago) {
        this.id = id;
        this.desconto = desconto;
        this.valorpago = valorpago;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorpago() {
        return valorpago;
    }

    public void setValorpago(double valorpago) {
        this.valorpago = valorpago;
    }

    public void adicionar(Produto p){
        produtos.add(p);
    }
    public void remover(Produto p){
        produtos.remove(p);
    }

    public Produto localizar(String nome){
        for(Produto p: produtos)
            if (p.getNome().equals(nome))
                return p;
        return null;
    }

	@Override
	public String toString() {
		return "Venda [id=" + id + ", data=" + data + ", produtos=" + produtos + ", desconto=" + desconto
				+ ", valorpago=" + valorpago + "]";
	}
    
    
}

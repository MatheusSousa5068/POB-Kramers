package appconsole;

import com.db4o.ObjectContainer;

import models.Produto;
import models.TipoProduto;
//import models.Venda;

public class Cadastrar {
	protected ObjectContainer manager;
	
	public Cadastrar() {
		try {
			manager = Util.conectarBanco();

			System.out.println("cadastrando...");
			TipoProduto tipoproduto1 = new TipoProduto("Diversos");
			manager.store(tipoproduto1);
			manager.commit();
			
			TipoProduto tipoproduto2 = new TipoProduto("Bebidas");
			manager.store(tipoproduto2);
			manager.commit();
			
			TipoProduto tipoproduto3 = new TipoProduto("Doces");
			manager.store(tipoproduto3);
			manager.commit();
			
			Produto produto1 = new Produto("Cheetos", 3.50, tipoproduto1);
			manager.store(produto1);
			manager.commit();
			
			Produto produto2 = new Produto("Coca-cola", 5.00, tipoproduto2);
			manager.store(produto2);
			manager.commit();
			
			Produto produto3 = new Produto("Chocolate", 4.00, tipoproduto3);
			manager.store(produto3);
			manager.commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Util.desconectar();
		System.out.println("\nfim do programa !");
	}
	
	public static void main(String[] args) {
		new Cadastrar();
	}
}


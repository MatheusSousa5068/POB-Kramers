package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import models.Produto;
import models.TipoProduto;
import models.Venda;

public class Deletar {
	protected ObjectContainer manager;

	public Deletar() {
		manager = Util.conectarBanco();
		apagar();
		//apagarTudo();
		Util.desconectar();
	}

	public void apagar() {
		// Deletar o produto cujo nome é chocolate
		Query qChocolate = manager.query();
		qChocolate.constrain(Produto.class);
		qChocolate.descend("nome").constrain("Chocolate");
		List<Produto> resultados1 = qChocolate.execute();
		
		if (resultados1.size() > 0) {
			manager.delete(resultados1.get(0));
			manager.commit();

			
			System.out.println("apagou chocolate");
		} 
		else
			System.out.println("inexistente");
		
		// Deletar tipo de produto "doces"
		Query qDoce = manager.query();
		qDoce.constrain(TipoProduto.class);
		qDoce.descend("nome").constrain("Doces");
		List<Produto> resultados2 = qDoce.execute();
		
		
		if (resultados2.size() > 0) {
			manager.delete(resultados2.get(0));
			manager.commit();

			
			System.out.println("apagou doces");
		} 
		else
			System.out.println("inexistente");
	}
	
	public void apagarTudo() {
		// Deletar todos os produtos
		Query qProdutos = manager.query();
		qProdutos.constrain(Produto.class);
		List<Produto> resultadosProdutos = qProdutos.execute();
		
		if (resultadosProdutos.size() > 0) {
			for (Produto p: resultadosProdutos) {
				manager.delete(p);
				manager.commit();
			}
			System.out.println("apagou todos os produtos");
		} else {
			System.out.println("produtos inexistentes");
		}
		
		// Deletar todos os tipos de produtos
		Query qTiposProdutos = manager.query();
		qTiposProdutos.constrain(TipoProduto.class);
		List<TipoProduto> resultadosTiposProdutos = qTiposProdutos.execute();
				
		if (resultadosTiposProdutos.size() > 0) {
			for (TipoProduto tp: resultadosTiposProdutos) {
				manager.delete(tp);
				manager.commit();
			}
			System.out.println("apagou todos os tipos de produtos");
		} else {
			System.out.println("tipos de produtos inexistentes");
		}
		
		// Deletar todas as vendas
		Query qVendas = manager.query();
		qVendas.constrain(Venda.class);
		List<Venda> resultadosVendas = qVendas.execute();
				
		if (resultadosVendas.size() > 0) {
			for (Venda v: resultadosVendas) {
				manager.delete(v);
				manager.commit();
			}
			System.out.println("apagou todas as vendas");
		} else {
			System.out.println("vendas inexistentes");
		}
		
	}

	// =================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

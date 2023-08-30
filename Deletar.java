package appconsole;



import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import models.Produto;
import models.TipoProduto;

public class Deletar {
	protected ObjectContainer manager;

	public Deletar() {
		manager = Util.conectarBanco();
		apagar();
		Util.desconectar();

		System.out.println("\n\n aviso: feche sempre o plugin OME antes de executar aplica��o");
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

	// =================================================
	public static void main(String[] args) {
		new Deletar();
	}
}

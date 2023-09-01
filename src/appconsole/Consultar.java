package appconsole;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.query.Query;

import models.Venda;
import models.TipoProduto;
import models.Produto;

public class Consultar {
	protected ObjectContainer manager;

	public Consultar() {
		try {
			manager = Util.conectarBanco();
			
			System.out.println("consultas... \n");
			System.out.println("\nQuais as vendas da data X");
			Query q;
			q = manager.query();
			q.constrain(Venda.class);
			q.descend("data").constrain("01/09/2023");
			List<Venda> resultados = q.execute();
			for(Venda v : resultados)
				System.out.println(v);
			
			
			System.out.println("\nQuais as vendas que contem um produto de preco X");
			Query q2 = manager.query();
			q2.constrain(Venda.class);
			q2.descend("produtos").descend("preco").constrain(4.0);
			List<Venda> resultados2 = q2.execute();
			for(Venda v : resultados2)
				System.out.println(v);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Util.desconectar();
		System.out.println("\nfim do programa !");
	}

	public static void main(String[] args) {
		new Consultar();
	}
}

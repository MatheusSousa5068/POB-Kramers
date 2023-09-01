package appconsole;

import com.db4o.ObjectContainer;

import models.Produto;
//import models.TipoProduto;
import models.Venda;

public class Alterar {
    protected ObjectContainer manager;

    public Alterar() {
        try {
            this.manager = Util.conectarBanco();

            System.out.println("Venda de chocolate");

            Query q1 = this.manager.query();
            q1.constrain(Produto.class);
            q1.descend("nome").constrain("Chocolate");
            List<Produto> resultados1 = q1.execute();

            if (resultados1.size() > 0) {
                Produto chocolate = (Produto)resultados1.get(0);
                Venda venda1 = new Venda("31/08/2023", 0.50, 3.50);
                int id = Util.gerarIdVenda();
                venda1.setId(id);
                venda1.adicionar(chocolate);
                this.manager.store(venda1);
                this.manager.commit();
            }

            System.out.println("Venda de coca-cola");

            Query q2 = this.manager.query();
            q2.constrain(Produto.class);
            q2.descend("nome").constrain("Coca-cola");
            List<Produto> resultados2 = q2.execute();

            if (resultados2.size() > 0) {
                Produto cocacola = (Produto)resultados2.get(0);
                Venda venda2 = new Venda("01/09/2023", 1.00, 4.00);
                int id = Util.gerarIdVenda();
                venda2.setId(id);
                venda2.adicionar(cocacola);
                this.manager.store(venda2);
                this.manager.commit();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Util.desconectar();
        System.out.println("\nfim do programa !");
    }
}

    public static void main(String[] args) {
        new Alterar();
    }
}
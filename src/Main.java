import data.Produto;
import service.ProdutoService;

public class Main {
    public static void main(String[] args) {

        ProdutoService xxx = new ProdutoService();
        Produto pd1 = new Produto("coxinha", 2.00, "fastfood", 0);
        Produto pd2 = new Produto("Pizza", 5.00, "fastfood", 1);
        Produto pd3 = new Produto("Lasanha", 4.00, "fastfood", 2);

        //Lista de produtos vazia
        System.out.println(xxx.listarProduto());
        xxx.adicionarProduto(pd1);
        xxx.adicionarProduto(pd2);
        xxx.adicionarProduto(pd3);

        //Lista com os produtos adicionados
        System.out.println(xxx.listarProduto());

        //Lista com produtos removidos
        xxx.deletarProduto(0);
        System.out.println(xxx.listarProduto());

        //Lista com produtos alterados
        xxx.alterarProduto(1, "soin", 22.0, "Animal");
        System.out.println(xxx.listarProduto());

    }
}
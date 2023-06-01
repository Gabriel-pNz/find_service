import model.Produto;
import service.ProdutoService;

public class Main {
    public static void main(String[] args) {

        ProdutoService produtoService = new ProdutoService();
        Produto pd1 = new Produto("coxinha", 2.00, "fastfood", 0);
        Produto pd2 = new Produto("Pizza", 55.00, "fastfood", 1);
        Produto pd3 = new Produto("Lasanha", 4.00, "fastfood", 2);

        //Lista de produtos vazia
        System.out.println(produtoService.listarProdutos());
        produtoService.adicionarProduto(pd1);
        produtoService.adicionarProduto(pd2);
        produtoService.adicionarProduto(pd3);

        //Lista com os produtos adicionados
        System.out.println(produtoService.listarProdutos());

        //Lista com produtos removidos
        produtoService.deletarProduto(0);
        System.out.println(produtoService.listarProdutos());

        //Lista com produtos alterados
        Produto produtoAlterar = new Produto(1);
        produtoAlterar.setPreco(22D);

        produtoService.alterarProduto(produtoAlterar);

        System.out.println(produtoService.listarProdutos());

    }
}
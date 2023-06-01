package service;
import data.Dados;
import data.DadosFixed;
import data.Produto;
import java.util.ArrayList;

public class ProdutoService {

    ArrayList<Produto> produtos = new ArrayList<>();

    public ArrayList<Produto> listarProduto() {
        return produtos;
    }

    public void adicionarProduto(Produto novoProduto) {

        produtos.add(novoProduto);

    }

    public void deletarProduto(int index) {

        produtos.remove(index);

    }

    public void alterarProduto(int index, String nome, Double preco, String descricao) {

        for (Produto p: produtos) {
            if(p.getId() == index) {
                p.setNome(nome);
                p.setPreco(preco);
                p.setDescricao(descricao);
            }
        }

    }

}

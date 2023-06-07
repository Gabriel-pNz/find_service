package service;

import model.Produto;
import java.util.ArrayList;

public class ProdutoService {
    private final ArrayList<Produto> produtos;

    public ProdutoService() {
        this.produtos = new ArrayList<>();
    }

    public Produto buscarUm(int index) {
        if (index < 0 || index > produtos.size()) {
            throw new RuntimeException("NAO DA PRA SEGUIR");
        }
            for (Produto produto : produtos){
                if(produto.getId() == index){
                    return produto;
                }
            }
        throw new RuntimeException("PRODUTO NAO ENCONTRADO");
    }

    public ArrayList<Produto> listarProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto novoProduto) {
        produtos.add(novoProduto);
    }

    public void deletarProduto(int id) {
        produtos.remove(buscarUm(id));
    }

    public void alterarProduto(Produto produtoNovo) {
       for (Produto p: produtos) {
            if(p.getId().equals(produtoNovo.getId())) {
                if (produtoNovo.getNome() != null) {
                    p.setNome(produtoNovo.getNome());
                }
                if (produtoNovo.getPreco() != null) {
                    p.setPreco(produtoNovo.getPreco());
                }
                if (produtoNovo.getDescricao() != null) {
                    p.setDescricao(produtoNovo.getDescricao());
                }
            }
        }

    }



}

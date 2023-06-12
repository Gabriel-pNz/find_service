package service;

import data.Repositorio;
import model.Produto;
import java.util.ArrayList;

public class ProdutoService extends Repositorio {

    private final ArrayList<Produto> produtos;

    public ProdutoService() {
        this.produtos = new ArrayList<>();
    }

    /*public Produto buscar(int index) {
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
        produtos.remove(buscar(id));
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

    }*/

    @Override
    public Produto buscar(Integer index) {
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

    @Override
    public ArrayList<Produto> listar() {

        return produtos;
    }

    @Override
    public void adicionar(Produto novoProduto) {
        produtos.add(novoProduto);
    }

    @Override
    public void remover(Integer id) {
        produtos.remove(buscar(id));
    } //isso é realmente um boolean?

    @Override
    public void atualizar(Produto produtoNovo) {
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

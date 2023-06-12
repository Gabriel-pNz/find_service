package service;

import data.Repositorio;
import model.Produto;
import model.enums.TipoModelEnum;
import service.file.FileService;
import service.file.FileServiceFactory;

import java.util.ArrayList;

public class ProdutoService extends Repositorio {

    private final ArrayList<Produto> produtos;
    private final FileService<Produto> fileService;

    public ProdutoService() {
        this.produtos = new ArrayList<>();
        this.fileService = FileServiceFactory.build(TipoModelEnum.PRODUTO);
    }

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
        throw new UnsupportedOperationException();
//        for (Produto p: produtos) {
//            if(p.getId().equals(produtoNovo.getId())) {
//                if (produtoNovo.getNome() != null) {
//                    p.setNome(produtoNovo.getNome());
//                }
//                if (produtoNovo.getPreco() != null) {
//                    p.setPreco(produtoNovo.getPreco());
//                }
//                if (produtoNovo.getDescricao() != null) {
//                    p.setDescricao(produtoNovo.getDescricao());
//                }
//            }
//        }

    }

}

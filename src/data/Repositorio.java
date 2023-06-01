package data;

import model.Produto;

import java.util.ArrayList;

public abstract class Repositorio {
    abstract Produto buscar(Integer id);
    abstract ArrayList<Produto> listar(Integer id);
    abstract boolean remover(Integer id);
    abstract Produto atualizar(Integer id);
}

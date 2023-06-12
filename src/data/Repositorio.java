package data;

import model.Produto;

import java.util.ArrayList;

public abstract class Repositorio {
    public abstract Produto buscar(Integer id);
    public abstract ArrayList<Produto> listar();
    public abstract void remover(Integer id);
    public abstract void atualizar(Produto produto);
    public abstract void adicionar(Produto produto);
}

package model;

public class Produto {

    private String nome;
    private Double preco;
    private String descricao;
    private Integer id;

    public Produto (String nome, Double preco, String descricao, int id) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.id = id;
    }

    public Produto(int id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produto{" + nome + '\'' +  preco + '\'' + descricao + '}';
    }

    @Override
    public boolean equals(Object o) {
        Produto produto = (Produto) o;

        return id.equals(produto.id);
    }

}

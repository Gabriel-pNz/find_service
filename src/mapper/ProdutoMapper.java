package mapper;

import model.Produto;

public class ProdutoMapper implements ObjectMapper<Produto> {
    @Override
    public Produto mapToObject(String objectString) {
        String[] attrs = objectString.split("_");
        return new Produto(attrs[0], Double.parseDouble(attrs[2]), attrs[3], Integer.parseInt(attrs[1]));
    }

    @Override
    public String mapToString(Produto produto) {
        return produto.getNome() + "_" +
                produto.getId().toString() +    "_" +
                produto.getPreco().toString() + "_" +
                produto.getDescricao();
    }
}
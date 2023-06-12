package service.file;


import mapper.EmpresaMapper;
import mapper.ObjectMapper;
import mapper.ProdutoMapper;
import model.enums.TipoModelEnum;

public class FileServiceFactory {
    private FileServiceFactory() {}

    public static <T> FileService<T> build(TipoModelEnum tipoModel) {
        return switch (tipoModel) {
            case PRODUTO: yield new FileService<T>((ObjectMapper<T>) new ProdutoMapper(), "produto.db");
            case EMPRESA: yield new FileService<T>((ObjectMapper<T>) new EmpresaMapper(), "empresa.db");
        };

    }
}

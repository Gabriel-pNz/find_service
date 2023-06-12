package service.file;

import mapper.ObjectMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Usada para abstrair operações com os arquivos de banco de dados.
 *
 * <p>Métodos: </p>
 * <ul>
 *     <li><b>save</b>: Salva um elemento no arquivo</li>
 *     <li><b>findOne</b>: Localiza um elemento no arquivo</li>
 *     <li><b>remove</b>: Remove um elemento no arquivo </li>
 *     <li><b>saveAll</b>: Salva uma lista no arquivo</li>
 *     <li><b>findAll</b>: Localiza todos os elementos no arquivo</li>
 *     <li><b>removeAll</b>: Limpa o arquivo</li>
 * </ul>
 *
 * @since   1.0
 */
public class FileService<T> {
    private final ObjectMapper<T> objectMapper;
    private final File file;

    protected FileService(ObjectMapper<T> objectMapper, String filename) {
        this.objectMapper = objectMapper;

        file = new File(filename);
        createFile();
    }

    public void save(T object) {
        List<T> objects = findAll();
        objects.add(object);
        saveAll(objects);
    }

    public void remove(Integer id) {
        List<T> objects = findAll();
        T object = findOne(id);

        objects.remove(object);
        saveAll(objects);
    }

    public void removeAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("");
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public T findOne(Integer id) {
        List<T> objects = findAll();
        for (T object: objects) {
            Integer searchId = idFromObject(object);
            if (searchId.equals(id)) {
                return object;
            }
        }
        throw new RuntimeException("Recurso não encontrado");
    }


    public void saveAll(List<T> objects) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (T object: objects) {
                String line = objectMapper.mapToString(object);
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Conteúdo gravado no arquivo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(objectMapper.mapToObject(line));
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return list;
    }

    private void createFile() {
        if (!file.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Integer idFromObject(Object object) {
        try {
            Class<T> clazz = (Class<T>) object.getClass();
            Method metodo = clazz.getMethod( "getId" );
            return Integer.parseInt(metodo.invoke(object) + "");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

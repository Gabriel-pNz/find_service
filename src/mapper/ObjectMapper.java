package mapper;

public interface ObjectMapper<T> {
    T mapToObject(String objectString);
    String mapToString(T object);
}

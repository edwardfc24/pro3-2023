package patrones.dao;

import java.util.List;

public interface Dao<T> {
    void insert(T object);

    void update(T object);

    void delete(T object);

    void deleteById(int id);

    T get(int id);

    List<T> getAll();

    void closeConnection();
}

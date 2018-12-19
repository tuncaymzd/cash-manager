package services.dataServices;

import java.util.List;

public interface IDataAccessor<T> {
    void create(T obj);
    List<T> readAll();
    T read(int id);
    boolean delete(T obj);
    boolean update(T obj);
}

package services.dataServices;

import java.util.ArrayList;

public interface IDataAccessor<T> {
    void create(T obj);
    ArrayList<T> readAll();
    T read(int id);
    boolean delete(T obj);
    boolean update(T obj);
}

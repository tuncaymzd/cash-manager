package services.dataServices;

import java.util.ArrayList;

public interface IDataAccessor<T> {
    void create(T obj);
    ArrayList<T> readAll();
    T read(int id);
    void delete(int index);
    void update(T obj);
}

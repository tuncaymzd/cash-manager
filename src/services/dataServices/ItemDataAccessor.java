package services.dataServices;

import models.Item;

import java.util.List;

public class ItemDataAccessor implements IDataAccessor<Item>{

    @Override
    public void create(Item obj) {

    }

    @Override
    public List<Item> readAll() {
        return null;
    }

    @Override
    public Item read(int id) {
        return null;
    }

    @Override
    public boolean delete(Item obj) {
        return false;
    }

    @Override
    public boolean update(Item obj) {
        return false;
    }
}

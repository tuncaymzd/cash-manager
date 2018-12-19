package services.dataServices;

import models.CreditCards;

import java.util.List;

public class CreditCardDataAccessor implements IDataAccessor<CreditCards> {
    @Override
    public void create(CreditCards obj) {

    }

    @Override
    public List<CreditCards> readAll() {
        return null;
    }

    @Override
    public CreditCards read(int id) {
        return null;
    }

    @Override
    public boolean delete(CreditCards obj) {
        return false;
    }

    @Override
    public boolean update(CreditCards obj) {
        return false;
    }
}

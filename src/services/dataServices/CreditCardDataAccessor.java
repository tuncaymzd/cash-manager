package services.dataServices;

import models.CreditCard;

import java.util.List;

public class CreditCardDataAccessor implements IDataAccessor<CreditCard> {
    @Override
    public void create(CreditCard obj) {

    }

    @Override
    public List<CreditCard> readAll() {
        return null;
    }

    @Override
    public CreditCard read(int id) {
        return null;
    }

    @Override
    public boolean delete(CreditCard obj) {
        return false;
    }

    @Override
    public boolean update(CreditCard obj) {
        return false;
    }
}

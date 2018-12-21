package services.dataServices;

import models.Settings;

import java.util.List;

public class SettingsDataAccessor implements IDataAccessor<Settings> {
    @Override
    public void create(Settings obj) {

    }

    @Override
    public List<Settings> readAll() {
        return null;
    }

    @Override
    public Settings read(int id) {
        return null;
    }

    @Override
    public boolean delete(Settings obj) {
        return false;
    }

    @Override
    public boolean update(Settings obj) {
        return false;
    }
}

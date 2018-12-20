package services.dataServices;

import models.Settings;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingsDataAccessor implements IDataAccessor<Settings> {
    @Override
    public void create(Settings obj) {
        SQLiteConnection.getInstance().Connect();
        Connection connection = SQLiteConnection.getInstance().getConnection();
        try {
            String sql = "INSERT INTO `Settings`(`Delay`,`Currency`,`PreferedPaymentMethod`) VALUES ('"+
                    obj.getDelay() + "'," + obj.getCurrency() +",'" + obj.getPreferedPaymentMethod() +"');";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an setting");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    @Override
    public List<Settings> readAll() {
        ArrayList<Settings> settingslist = new ArrayList<Settings>();
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From Items;");
            while (set.next()){
                Settings settingsTmp = null;
                settingsTmp = new Settings.Builder().Build();
                settingsTmp.setId(set.getInt("ID"));
                settingsTmp.setDelay(set.getInt("Delay"));
                settingsTmp.setCurrency(set.getString("Currency"));
                settingsTmp.setPreferedPaymentMethod(set.getString("PreferedPaymentMethod"));
                String s = set.getString("DateCreated");
                settingsTmp.setDateCreated(new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                        Locale.ENGLISH).parse(s));
                settingslist.add(settingsTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this item");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Error occured while parsing date in this item");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
        return settingslist;
    }

    @Override
    public Settings read(int id) {
        Settings setting = null;
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From Settings WHERE ID = "+id+";");
            Settings bufferSettings = new Settings.Builder().Build();
            while (set.next()){
                bufferSettings.setId(set.getInt("ID"));
                bufferSettings.setDelay(set.getInt("Delay"));
                bufferSettings.setCurrency(set.getString("Currency"));
                bufferSettings.setPreferedPaymentMethod(set.getString("PreferedPaymentMethod"));
                String s = set.getString("DateCreated");
                bufferSettings.setDateCreated(new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                        Locale.ENGLISH).parse(s));
            }
            setting = bufferSettings;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this setting");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Error occured while parsing date in this setting");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
        return setting;
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

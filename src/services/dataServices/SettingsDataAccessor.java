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

import static java.sql.Types.NULL;

public class SettingsDataAccessor implements IDataAccessor<Settings> {

    public SettingsDataAccessor() {

    }

    @Override
    public void create(Settings obj) {
        SQLiteConnection.getInstance().Connect();
        Connection connection = SQLiteConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT into 'Settings'('Delay','Currency','PreferedPaymentMethod') VALUES ('" + obj.getDelay() + "','" + obj.getCurrency() + "'" + ",'" + obj.getPreferedPaymentMethod()+"');");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an setting");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    @Override
    public ArrayList<Settings> readAll() {
        ArrayList<Settings> settingsList = new ArrayList<Settings>();
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From Settings;");
            while (set.next()){
                Settings settingsTmp = null;
                settingsTmp = new Settings.Builder().Build();
                settingsTmp.setId(set.getInt(1));
                settingsTmp.setCurrency(set.getString(3));
                settingsTmp.setDelay(set.getInt(2));
                settingsTmp.setPreferedPaymentMethod(set.getString(4));
                settingsList.add(settingsTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this item");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
        return settingsList;
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
                bufferSettings.setId(set.getInt(1));
                bufferSettings.setDelay(set.getInt(2));
                bufferSettings.setCurrency(set.getString(3));
                bufferSettings.setPreferedPaymentMethod(set.getString(4));
            }
            setting = bufferSettings;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this setting");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
        return setting;
    }

    @Override
    public void delete(int index) {
        try {
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM 'Settings' WHERE ID ="+index+";");
            System.out.println("This setting has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this setting");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    @Override
    public void update(Settings obj) {
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Settings SET Delay='"+obj.getDelay()+"', Currency='"+obj.getCurrency()+"', PreferedPaymentMethod='"+obj.getPreferedPaymentMethod()+"' WHERE ID="+obj.getId()+";");
            System.out.println("This setting hab been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this setting");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }
}

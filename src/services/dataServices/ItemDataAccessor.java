package services.dataServices;

import models.Item;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.sql.Types.NULL;

public class ItemDataAccessor implements IDataAccessor<Item>{

    public ItemDataAccessor() {

    }

    @Override
    public void create(Item obj) {
        SQLiteConnection.getInstance().Connect();
        Connection connection = SQLiteConnection.getInstance().getConnection();
        try {
            String sql = "INSERT INTO `Items`(`Name`,`Price`,`DateCreated`) VALUES ('"+
                    obj.getName() + "'," + obj.getPrice() +",'" + obj.getDateCreated().toString() +"');";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an item");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    @Override
    public ArrayList<Item> readAll() {
        ArrayList<Item> itemlist = new ArrayList<Item>();
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From Items;");
            while (set.next()){
                Item itemTmp = null;
                itemTmp = new Item.Builder().Build();
                itemTmp.setId(set.getInt("ID"));
                itemTmp.setName(set.getString("Name"));
                itemTmp.setPrice(set.getFloat("Price"));
                String s = set.getString("DateCreated");
                itemTmp.setDateCreated(new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                        Locale.ENGLISH).parse(s));
                itemlist.add(itemTmp);
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
        return itemlist;
    }

    @Override
    public Item read(int id) {
        Item item = null;
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From Items WHERE ID = "+id+";");
            Item bufferItem = new Item.Builder().Build();
            while (set.next()){
                bufferItem.setId(set.getInt("ID"));
                bufferItem.setName(set.getString("Name"));
                bufferItem.setPrice(set.getFloat("Price"));
                String s = set.getString("DateCreated");
                bufferItem.setDateCreated(new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                        Locale.ENGLISH).parse(s));
            }
            item = bufferItem;
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
        return item;
    }

    @Override
    public void delete(int index) {
        try {
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM 'Items' WHERE ID ="+index+";");
            System.out.println("This item has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while delete this item");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    @Override
    public void update(Item obj) {
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Items SET Name='"+obj.getName()+"', Price='"+obj.getPrice()+"', DateCreated='"+obj.getDateCreated()+"' WHERE ID="+obj.getId()+";");
            System.out.println("This items has been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this item");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }
}

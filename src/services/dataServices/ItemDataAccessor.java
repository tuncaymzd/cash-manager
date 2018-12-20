package services.dataServices;

import models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ItemDataAccessor implements IDataAccessor<Item>{

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
            SQLiteConnection.getInstance().DisConnect();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an item");
            e.printStackTrace();
        }
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

package services.dataServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

    private Connection connection;

    private static SQLiteConnection ourInstance = new SQLiteConnection();

    public static SQLiteConnection getInstance() {
        return ourInstance;
    }

    private SQLiteConnection() {
    }

    public void Connect(){
        try {
            String url = "jdbc:sqlite:C:\\Users\\dtohi\\Desktop\\Epitech\\Cash Manager\\CashManagerDB.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to database terminated");
        } catch (SQLException e){
            System.out.println("SQLite connection failed");
        }
    }
}

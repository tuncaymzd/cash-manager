package services.dataServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    private static SQLiteConnection ourInstance = new SQLiteConnection();

    public static SQLiteConnection getInstance() {
        return ourInstance;
    }

    private SQLiteConnection() {
    }

    public boolean Connect(){
        try {
            String url = "jdbc:sqlite:C:\\Users\\dtohi\\Desktop\\Epitech\\Cash Manager\\CashManagerDB.db";
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            System.out.println("Connection to database terminated");
            return true;
        } catch (SQLException e){
            System.out.println("SQLite connection failed");
            e.printStackTrace();
            return false;
        }
    }

    public boolean DisConnect(){
        try {
            connection.close();
            System.out.println("SQlite connection closed");
            return true;
        } catch (SQLException e) {
            System.out.println("SQLite Connection Could not be closed.");
            e.printStackTrace();
            return false;
        }
    }
}

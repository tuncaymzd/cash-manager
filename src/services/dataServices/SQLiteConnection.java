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

    public Connection getConnection(){
        return this.connection;
    }

    public boolean Connect(){
        try {
            String url = "jdbc:sqlite:/Users/Tuncay/Desktop/dossier sans titre/cash-manager/CashManagerDB.db";
            connection = DriverManager.getConnection(url);
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

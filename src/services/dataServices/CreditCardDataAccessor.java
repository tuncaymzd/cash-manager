package services.dataServices;

import models.CreditCards;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;

public class CreditCardDataAccessor implements IDataAccessor<CreditCards> {
    @Override
    public void create(CreditCards obj) {
        SQLiteConnection.getInstance().Connect();
        Connection connection = SQLiteConnection.getInstance().getConnection();
        try {
            String sql = "INSERT INTO `CreditCards`(`CreditCardCode`,`OwnerName`,`BackCVCode`,`BankName` ) VALUES ('"+
                    obj.getCreditCardCode() + "'," + obj.getOwnerName() +",'" + obj.getBankCVCode() + obj.getBankName()+"');";
            System.out.println(sql);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.commit();
            SQLiteConnection.getInstance().DisConnect();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an credit card");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    @Override
    public List<CreditCards> readAll() {

        ArrayList<CreditCards> cardslist = new ArrayList<CreditCards>();
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From Items;");
            while (set.next()){
                CreditCards cardsTmp = null;
                cardsTmp = new CreditCards.Builder().Build();
                cardsTmp.setId(set.getInt("ID"));
                cardsTmp.setCreditCardCode(set.getInt("CreditCardCode"));
                cardsTmp.setOwnerName(set.getString("OwnerName"));
                cardsTmp.setBackCVCode(set.getInt("BackCVCode"));
                cardsTmp.setBankName(set.getString("BankName"));
                String s = set.getString("DateCreated");
                cardsTmp.setDateCreated(new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                        Locale.ENGLISH).parse(s));
                cardslist.add(cardsTmp);
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
        return cardslist;
    }

    @Override
    public CreditCards read(int id) {
        CreditCards cards = null;
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From CreditCards WHERE ID = "+id+";");
            CreditCards bufferCards = new CreditCards.Builder().Build();
            while (set.next()){
                bufferCards.setId(set.getInt("ID"));
                bufferCards.setCreditCardCode(set.getInt("CreditCardCode"));
                bufferCards.setOwnerName(set.getString("OwnerName"));
                bufferCards.setBackCVCode(set.getInt("BackCVCode"));
                bufferCards.setBankName(set.getString("BankName"));
                String s = set.getString("DateCreated");
                bufferCards.setDateCreated(new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",
                        Locale.ENGLISH).parse(s));
            }
            cards = bufferCards;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this Credit card");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("Error occured while parsing date in this credit card");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
        return cards;
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

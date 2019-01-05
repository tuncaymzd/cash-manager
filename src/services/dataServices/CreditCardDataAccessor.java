package services.dataServices;

import models.CreditCard;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;

import static java.sql.Types.NULL;

public class CreditCardDataAccessor implements IDataAccessor<CreditCard> {

    public CreditCardDataAccessor(){

    }

    @Override
    public void create(CreditCard obj) {
        SQLiteConnection.getInstance().Connect();
        Connection connection = SQLiteConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT into CreditCard('CreditCardCode','OwnerName','BackCVCode','BankName') VALUES (" + obj.getCreditCardCode() + ",'" + obj.getOwnerName() + "'" + "," + obj.getBackCVCode()+", '"+ obj.getBankName() + "');");
            statement.close();
            SQLiteConnection.getInstance().DisConnect();
        } catch (SQLException e) {
            System.out.println("Error occured while creating an credit card");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    @Override
    public ArrayList<CreditCard> readAll() {

        ArrayList<CreditCard> cardsList = new ArrayList<CreditCard>();
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * From CreditCards;");
            while (set.next()){
                CreditCard cardsTmp = null;
                cardsTmp = new CreditCard.Builder().Build();
                cardsTmp.setId(set.getInt(1));
                cardsTmp.setCreditCardCode(set.getInt(2));
                cardsTmp.setOwnerName(set.getString(3));
                cardsTmp.setBackCVCode(set.getInt(4));
                cardsTmp.setBankName(set.getString(5));
                cardsList.add(cardsTmp);
            }
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this credit cards");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
        return cardsList;
    }

    @Override
    public CreditCard read(int id) {
        CreditCard cards = null;
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT * from 'CreditCards' WHERE ID = "+id+";");
            CreditCard bufferCards = new CreditCard.Builder().Build();
            while (set.next()){
                bufferCards.setId(set.getInt(1));
                bufferCards.setCreditCardCode(set.getInt(2));
                bufferCards.setOwnerName(set.getString(3));
                bufferCards.setBackCVCode(set.getInt(4));
                bufferCards.setBankName(set.getString(5));
            }
            cards = bufferCards;
            set.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this Credit card");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
        return cards;
    }

    @Override
    public void delete(int index) {
        try {
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete FROM CreditCard WHERE ID = "+index+";");
            System.out.println("This credit card has been deleted");
            statement.close();
        } catch (SQLException e){
            System.out.println("Error occured while getting this credit card");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    @Override
    public void update(CreditCard obj) {
        try{
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE CreditCards SET CreditCardCode='"+obj.getCreditCardCode()+"', OwnerName='"+obj.getOwnerName()+"', BackCVCode='"+obj.getBackCVCode()+"',BankName='"+obj.getBankName()+"' WHERE ID="+obj.getId()+";");
            System.out.println("This credit cards has been updated");
        } catch (SQLException e){
            System.out.println("Error occured while update this credit card");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
    }

    public boolean codeIsGood(long code, String name) {
        try {
            SQLiteConnection.getInstance().Connect();
            Connection connection = SQLiteConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("SELECT CreditCardCode from CreditCards WHERE OwnerName ='" + name + "';");
            if (set.next()) {
                long mdp = set.getLong("CreditCardCode");
                if (mdp == code) {
                    System.out.println("This code is good");
                    return true;
                } else {
                    System.out.println("This code is false");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error occured while verify code of cards");
            e.printStackTrace();
        } finally {
            SQLiteConnection.getInstance().DisConnect();
        }
        return false;
    }
}

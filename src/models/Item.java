package models;

import java.util.Date;

public class Item extends BaseModel {

    String name;
    float price;
    Date dateCreated;

    public Item(String name, float price, Date dateCreated){
        this.name = name;
        this.price = price;
        this.dateCreated = dateCreated;
    }

    public Item(){}

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

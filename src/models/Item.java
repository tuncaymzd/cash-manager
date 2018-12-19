package models;

import java.util.Date;

public class Item extends BaseModel {

    static class Builder{
        Item item = new Item();

        public Builder withName(String name){
            item.name = name;
            return this;
        }
        public Builder withPrice(float price){
            item.price = price;
            return this;
        }
        public Builder withDateCreated(Date date){
            item.dateCreated = date;
            return this;
        }
    }

    String name;
    float price;
    Date dateCreated;

    private Item(String name, float price, Date dateCreated){
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

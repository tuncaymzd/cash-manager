package models;

import java.util.Date;

public class Item extends BaseModel {

    public static class Builder{

        String name;
        float price;
        Date dateCreated;

        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withPrice(float price){
            this.price = price;
            return this;
        }
        public Builder withDateCreated(Date date){
            this.dateCreated = date;
            return this;
        }
        public Item Build(){
            Item item = new Item();
            item.dateCreated = dateCreated;
            item.name = name;
            item.price = price;
            return item;
        }
    }

    String name;
    float price;
    Date dateCreated;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    private Item(){
    }

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
package models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Item extends BaseModel implements Cloneable {

    String name;
    float price;
    Date dateCreated;
    public int index;

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
            item.setName(name);
            item.setPrice(price);
            return item;
        }
    }
    private final StringProperty nameProperty = new SimpleStringProperty();
    private final ObjectProperty<Float> priceProperty = new SimpleObjectProperty<Float>(0.0f);

    public void setName(String name) {
        this.name = name;
        this.nameProperty.setValue(name);
    }

    public void setPrice(float price) {
        this.price = price;
        this.priceProperty.set(price);
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }
    public String getObservableName(){
        return this.nameProperty.get();
    }

    public float getPrice() {
        return price;
    }
    public Float getObservablePrice(){
        return this.priceProperty.get();
    }

    public StringProperty getNameProperty(){
        return nameProperty;
    }

    public ObjectProperty<Float> getPriceProperty(){
        return priceProperty;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Item(String name, float price, Date dateCreated){
        this.name = name;
        this.price = price;
        this.dateCreated = dateCreated;
    }

    private Item(){}

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

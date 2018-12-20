package models;

import java.util.Date;

public class Settings extends BaseModel {

    int delay;
    String currency;
    String preferedPaymentMethod;

    public Settings() {

    }

    public static class Builder{

        int delay;
        String currency;
        String preferedPaymentMethod;
        Date dateCreated;

        public Builder withDelay(int delay){
            this.delay = delay;
            return this;
        }
        public Builder withCurrency(String currency){
            this.currency = currency;
            return  this;
        }
        public Builder withPreferedPaymentMethod(String paymentMethod){
            this.preferedPaymentMethod = paymentMethod;
            return this;
        }
        public Settings Build(){
            Settings settings = new Settings();
            settings.currency = this.currency;
            settings.preferedPaymentMethod = this.preferedPaymentMethod;
            settings.delay = this.delay;
            settings.dateCreated = dateCreated;
            return settings;
        }

        public Builder withDateCreated(Date date){
            this.dateCreated = date;
            return this;
        }
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPreferedPaymentMethod(String preferedPaymentMethod) {
        this.preferedPaymentMethod = preferedPaymentMethod;
    }

    public int getDelay() {
        return delay;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPreferedPaymentMethod() {
        return preferedPaymentMethod;
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

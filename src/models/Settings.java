package models;

public class Settings extends BaseModel {

    int delay;
    String currency;
    String preferedPaymentMethod;

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

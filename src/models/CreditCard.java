package models;

public class CreditCard extends BaseModel {
    long creditCardCode;
    String ownerName;
    int backCVCode;
    String bankName;

    public void setCreditCardCode(long creditCardCode) {
        this.creditCardCode = creditCardCode;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBackCVCode(int backCVCode) {
        this.backCVCode = backCVCode;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getCreditCardCode() {
        return creditCardCode;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getBackCVCode() {
        return backCVCode;
    }

    public String getBankName() {
        return bankName;
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

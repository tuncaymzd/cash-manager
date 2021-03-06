package models;

import java.util.Date;

public class CreditCard extends BaseModel {
    long creditCardCode;
    String ownerName;
    int backCVCode;
    String bankName;

    private CreditCard(){

    }

    public static class Builder{

        long creditCardCode;
        String ownerName;
        int backCVCode;
        String bankName;

        public Builder withCreditCardCode(long code){
            this.creditCardCode = code;
            return this;
        }
        public Builder withOwnerName(String name){
            ownerName = name;
            return this;
        }
        public Builder withBackCVcode(int code){
            backCVCode = code;
            return this;
        }
        public Builder withBankName(String name){
            bankName = name;
            return this;
        }

        public CreditCard Build(){
            CreditCard creditCards = new CreditCard();
            creditCards.backCVCode = this.backCVCode;
            creditCards.ownerName = this.ownerName;
            creditCards.creditCardCode = this.creditCardCode;
            creditCards.bankName = this.bankName;
            return creditCards;
        }
    }

    public void setCreditCardCode(long creditCardCode) {
        this.creditCardCode = creditCardCode;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBackCVCode(int bankCVCode) {
        this.backCVCode = bankCVCode;
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

    public Date getDateCreated() {
        return dateCreated;
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
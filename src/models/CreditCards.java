package models;

public class CreditCards  extends BaseModel {
    long creditCardCode;
    String ownerName;
    int bankCVCode;
    String bankName;

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
        public CreditCards Build(){
            CreditCards creditCards = new CreditCards();
            creditCards.bankCVCode = this.backCVCode;
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

    public void setBankCVCode(int bankCVCode) {
        this.bankCVCode = bankCVCode;
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

    public int getBankCVCode() {
        return bankCVCode;
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

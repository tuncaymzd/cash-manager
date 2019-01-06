package services.paymentServices;

public class CashPaymentService implements IPaymentService{
    @Override
    public float pay(float price, float amount) throws Exception {
        if(price > amount)
            throw new Exception("Money amount is less than the price.");
        else return amount - price;
    }
}

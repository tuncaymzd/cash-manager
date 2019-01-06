package services.paymentServices;

public interface IPaymentService {
    float pay(float price, float amount) throws Exception;
}

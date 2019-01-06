package shared;

public interface IListener {
    void onEventFired(String message);
    void updateTotalPrice(float price);
    void operatePayment(PaymentMethod method);
}

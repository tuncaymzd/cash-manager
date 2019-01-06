package controllers;

import shared.IListener;
import shared.PaymentMethod;

public class BaseController implements IListener {

    private IListener fistListener;

    public IListener getFistListener() {
        return fistListener;
    }

    public void setFistListener(IListener fistListener) {
        this.fistListener = fistListener;
    }

    @Override
    public void onEventFired(String message) {

    }

    @Override
    public void updateTotalPrice(float price) {

    }

    @Override
    public void operatePayment(PaymentMethod method) {

    }
}

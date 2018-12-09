package controllers;

import shared.IListener;

public class FirstScreenController extends BaseController {

    IListener secondListener;
    IListener thirdListener;

    public IListener getSecondListener() {
        return secondListener;
    }

    public IListener getThirdListener() {
        return thirdListener;
    }

    public void setSecondListener(IListener secondListener) {
        this.secondListener = secondListener;
    }

    public void setThirdListener(IListener thirdListener) {
        this.thirdListener = thirdListener;
    }

    @Override
    public void onEventFired(String message) {
        super.onEventFired(message);
    }
}

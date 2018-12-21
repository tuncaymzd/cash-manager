package controllers;

import shared.IListener;

public class BaseController implements IListener {

    private IListener fistListener;

    public IListener getListListener() {
        return fistListener;
    }

    public void setFistListener(IListener fistListener) {
        this.fistListener = fistListener;
    }

    @Override
    public void onEventFired(String message) {

    }
}

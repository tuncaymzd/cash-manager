package controllers;

import models.CreditCard;
import models.Item;
import models.Settings;
import services.dataServices.IDataAccessor;
import shared.IListener;

public class FirstScreenController extends BaseController {

    private IListener secondListener;
    private IListener thirdListener;
    private IDataAccessor<Item> itemDataAccessor;
    private IDataAccessor<Settings> settingsDataAccessor;
    private IDataAccessor<CreditCard> creditCardDataAccessor;

    public FirstScreenController(IDataAccessor<Item> itemDataAccessor,
            IDataAccessor<Settings> settingsDataAccessor,
            IDataAccessor<CreditCard> creditCardDataAccessor){
        this.itemDataAccessor = itemDataAccessor;
        this.settingsDataAccessor = settingsDataAccessor;
        this.creditCardDataAccessor = creditCardDataAccessor;
    }

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

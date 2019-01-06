package shared;

import models.CreditCard;
import models.Item;
import services.dataServices.IDataAccessor;
import models.Settings;
import services.dataServices.CreditCardDataAccessor;
import services.dataServices.ItemDataAccessor;
import services.dataServices.SettingsDataAccessor;
import services.paymentServices.CashPaymentService;

public class IOC {

    IDataAccessor<Item> itemDataAccessor;
    IDataAccessor<Settings> settingsDataAccessor;
    IDataAccessor<CreditCard> creditCardDataAccessor;
    CashPaymentService cashPaymentService;

    public IDataAccessor<Settings> getSettingsDataAccessor() {
        return settingsDataAccessor;
    }

    public IDataAccessor<CreditCard> getCreditCardDataAccessor() {
        return creditCardDataAccessor;
    }

    public IDataAccessor<Item> getItemDataAccessor() {
        return itemDataAccessor;
    }

    public CashPaymentService getCashPaymentService() {
        return cashPaymentService;
    }

    public IOC()
    {
        itemDataAccessor = new ItemDataAccessor();
        settingsDataAccessor = new SettingsDataAccessor();
        creditCardDataAccessor = new CreditCardDataAccessor();
        cashPaymentService = new CashPaymentService();
    }
}

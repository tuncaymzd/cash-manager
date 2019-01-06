
package shared;

import models.CreditCard;
import models.Item;
import services.dataServices.IDataAccessor;
import models.Settings;
import services.dataServices.CreditCardDataAccessor;
import services.dataServices.ItemDataAccessor;
import services.dataServices.SettingsDataAccessor;

public class IOC {

    IDataAccessor<Item> itemDataAccessor;
    IDataAccessor<Settings> settingsDataAccessor;
    IDataAccessor<CreditCard> creditCardDataAccessor;

    public void setItemDataAccessor(IDataAccessor<Item> itemDataAccessor) {
        this.itemDataAccessor = itemDataAccessor;
    }

    public void setSettingsDataAccessor(IDataAccessor<Settings> settingsDataAccessor) {
        this.settingsDataAccessor = settingsDataAccessor;
    }

    public void setCreditCardDataAccessor(IDataAccessor<CreditCard> creditCardDataAccessor) {
        this.creditCardDataAccessor = creditCardDataAccessor;
    }

    public IDataAccessor<Settings> getSettingsDataAccessor() {
        return settingsDataAccessor;
    }

    public IDataAccessor<CreditCard> getCreditCardDataAccessor() {
        return creditCardDataAccessor;
    }

    public IDataAccessor<Item> getItemDataAccessor() {
        return itemDataAccessor;
    }

    public IOC()
    {
        itemDataAccessor = new ItemDataAccessor();
        settingsDataAccessor = new SettingsDataAccessor();
        creditCardDataAccessor = new CreditCardDataAccessor();
    }
}
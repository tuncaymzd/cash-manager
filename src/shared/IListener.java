package shared;

import javafx.scene.Scene;

public interface IListener {
    void onEventFired(String message);
    void updateTotalPrice(float totalPrice);
}

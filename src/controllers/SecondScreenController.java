package controllers;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import shared.IListener;

public class SecondScreenController extends BaseController {

    @FXML
    Label totalLabel;

    public SecondScreenController() {
    }

    @Override
    public void onEventFired(String message) {
        super.onEventFired(message);
    }


    @Override
    public void updateTotalPrice(float price) {
        totalLabel.setText(Float.toString(price));
    }
}

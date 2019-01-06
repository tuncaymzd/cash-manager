package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.paymentServices.CashPaymentService;
import shared.IListener;
import shared.PaymentMethod;

import java.io.IOException;

public class ThirdScreenController extends BaseController {

    CashPaymentService paymentService;
    Stage stage;
    Scene cashScene;
    Scene checkScene;
    Scene creditCardScene;

    public ThirdScreenController(CashPaymentService paymentService, Stage stage){
        this.paymentService = paymentService;
        this.stage = stage;
    }

    public void Initialize() throws IOException {
    }

    @Override
    public void onEventFired(String message) {
        super.onEventFired(message);
    }

    @Override
    public void operatePayment(PaymentMethod method) {
        if(method == PaymentMethod.Cash){
            stage.setScene(cashScene);
        } else if(method == PaymentMethod.Check){
            stage.setScene(checkScene);
        } else if (method == PaymentMethod.CreditCard){
            stage.setScene(creditCardScene);
        }
    }
}

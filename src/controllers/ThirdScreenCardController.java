package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import services.dataServices.CreditCardDataAccessor;
import shared.IListener;
import javafx.scene.control.Button;

import java.io.IOException;

public class ThirdScreenCardController extends BaseController {
    private String monnaieInseree;
    IListener secondListener;
    IListener firstListener;

    @FXML
    private Button validate;
    @FXML
    private Label restantDu;
    @FXML
    private AnchorPane thirdScene;
    @FXML
    private TextField numCart;
    @FXML
    private TextField name;
    @FXML
    private Label statut;


    public void Initialize() {
        validate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                validateButtonAction(e);
            }
        });

        numCart.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    numCart.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public IListener getSecondListener() {
        return secondListener;
    }

    public IListener getFirstListener() {
        return firstListener;
    }

    public void setSecondListener(IListener secondListener) {
        this.secondListener = secondListener;
    }

    public void setThirdListener(IListener thirdListener) {
        this.firstListener = thirdListener;
    }

    @Override
    public void onEventFired(String message) {
        super.onEventFired(message);
    }

    private void validateButtonAction(ActionEvent event) {
        //CreditCardDataAccessor data = new CreditCardDataAccessor();
        //String user = name.getText();
        //long code = Long.parseLong(numCart.getText());

        //if (data.codeIsGood(code, user)) {
        //    thirdScene = FXMLLoader.load(getClass().getResource("PaimentDone.fxml"));
        //} else {
        //    thirdScene = FXMLLoader.load(getClass().getResource("PaimentDone.fxml"));
        //    statut.setText("Paiement refusé");
        //}
        System.out.println("Coucou");
    }
}

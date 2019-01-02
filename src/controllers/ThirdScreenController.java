package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import services.dataServices.CreditCardDataAccessor;
import shared.IListener;
import javafx.scene.control.Button;

import java.io.IOException;

public class ThirdScreenController extends BaseController {

    private String monnaieInseree;
    IListener secondListener;
    IListener firstListener;

    @FXML
    private Label montantTotal;
    @FXML
    private TextField insertMonnaie;
    @FXML
    private Button validateButton;
    @FXML
    private Button checkPresent;
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
        validateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                validateButtonAction(e);
            }
        });
        insertMonnaie.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    insertMonnaie.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        numCart.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    insertMonnaie.setText(newValue.replaceAll("[^\\d]", ""));
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
        this.firstListener= thirdListener;
    }

    @Override
    public void onEventFired(String message) {
        super.onEventFired(message);
    }

    private void validateButtonAction(ActionEvent event) {
        monnaieInseree = insertMonnaie.getText();

        restantDu.setText(monnaieInseree);
    }

    private void checkPaiement() throws IOException {
        int monnaieInsereeInt = Integer.parseInt(insertMonnaie.getText());
        int totalInt = Integer.parseInt(montantTotal.getText());

        if ((totalInt - monnaieInsereeInt) <= 0) {
            thirdScene = FXMLLoader.load(getClass().getResource("PaimentDone.fxml"));
        }

        CreditCardDataAccessor data = new CreditCardDataAccessor();
        String user = name.getText();
        long code = Long.parseLong(numCart.getText());

        if (data.codeIsGood(code, user)) {
            thirdScene = FXMLLoader.load(getClass().getResource("PaimentDone.fxml"));
        } else {
            thirdScene = FXMLLoader.load(getClass().getResource("PaimentDone.fxml"));
            statut.setText("Paiement refusé");
        }
    }
}

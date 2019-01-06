package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.dataServices.CreditCardDataAccessor;
import shared.IListener;
import javafx.scene.control.Button;

import java.io.IOException;

public class ThirdScreenChequeController extends BaseController {

    private String monnaieInseree;
    IListener secondListener;
    IListener firstListener;

    @FXML
    private Button validatecheque;
    @FXML
    private AnchorPane thirdScene;



    public void Initialize() {
        validatecheque.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    validateButtonAction(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
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

    private void validateButtonAction(ActionEvent event) throws IOException {
        System.out.println("Coucou");
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/PaiementDone.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
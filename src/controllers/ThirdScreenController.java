package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import shared.IListener;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ThirdScreenController extends BaseController {

    private String monnaieInseree;

    @FXML
    private TextField montantTotal;
    private TextField insertMonnaie;



    @FXML
    public void initialize() {
        montantTotal.setText("Montant Total");
    }

    @FXML
    public void handleButtonAction() {
        System.out.println("Coucou");
    }

    @FXML
    public void calculRestantDu() {
        monnaieInseree = insertMonnaie.getText();
        System.out.println("Coucou");
    }

    @FXML
    public void validationDuPaiement() {
        System.out.println("Coucou");
    }

}

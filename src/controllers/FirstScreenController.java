package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.Item;
import shared.IListener;

public class FirstScreenController extends BaseController {

    IListener secondListener;
    IListener thirdListener;
    final ObservableList<Item> items = FXCollections.observableArrayList();
    final ObservableList<Item> shoppingCard = FXCollections.observableArrayList();

    @FXML
    private Button validateButton;
    @FXML
    private TableView productTable;
    @FXML
    private TableView shoppingCardTable;
    @FXML
    private TableColumn<Item, String> nameColumn1;
    @FXML
    private TableColumn<Item, Float> priceColumn1;
    @FXML
    private TableColumn<Item, String> nameColumn2;
    @FXML
    private TableColumn<Item, Float> priceColumn2;

    public void Initialize(){

        Item firstItem = new Item();
        firstItem.setName("Mera");
        firstItem.setPrice(20000);
        items.add(firstItem);

        validateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                validateButtonClicked(e);
            }
        });
        productTable.setItems(items);
        shoppingCardTable.setItems(shoppingCard);
        nameColumn1.setCellValueFactory(rowData -> rowData.getValue().getNameProperty());
        priceColumn1.setCellValueFactory(rowData -> rowData.getValue().getPriceProperty());
        nameColumn2.setCellValueFactory(rowData -> rowData.getValue().getNameProperty());
        priceColumn2.setCellValueFactory(rowData -> rowData.getValue().getPriceProperty());
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

    private void validateButtonClicked(ActionEvent event) {

    }
}

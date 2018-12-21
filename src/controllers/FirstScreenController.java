package controllers;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Item;
import shared.IListener;

import java.util.Date;

public class FirstScreenController extends BaseController {

    private static float totalPrice;
    IListener secondListener;
    IListener thirdListener;
    final ObservableList<Item> items = FXCollections.observableArrayList();
    final ObservableList<Item> shoppingCard = FXCollections.observableArrayList();
    int previousIndex = -1;

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
    @FXML
    private Label totalAmountLabel;

    public void Initialize(){

        totalAmountLabel.setText("");
        Item firstItem = new Item.Builder().withName("Personal Computer").withPrice(400).Build();
        Item secondItem = new Item.Builder().withName("Phone").withPrice(300).Build();
        items.add(firstItem);
        items.add(secondItem);

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
        productTable.getSelectionModel().selectedItemProperty().addListener((obj, old, newValue) -> {
            try {
                itemSelected((Item)newValue);
            } catch (CloneNotSupportedException e) {
                System.out.println("Clone exception occured");
                e.printStackTrace();
            }
        });
        shoppingCardTable.getSelectionModel().selectedItemProperty().addListener((obj, old, newValue) -> {
            if(old != null){
                if(((Item)old).index == previousIndex){
                    previousIndex = -1;
                    return;
                }
            }
            itemRemoved((Item)newValue);
        });
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
    private void itemSelected(Item item) throws CloneNotSupportedException {
        if(item != null){
            totalPrice += item.getPrice();
            totalAmountLabel.setText(Float.toString(totalPrice));
            Item newItem = new Item.Builder().withPrice(item.getPrice())
                    .withDateCreated(item.getDateCreated())
                    .withName(item.getName()).Build();
            newItem.index = shoppingCard.size();
            shoppingCard.add((Item)newItem.clone());
        }
    }
    private void itemRemoved(Item item){
        if(item != null){
            totalPrice -= item.getPrice();
            totalAmountLabel.setText(Float.toString(totalPrice));

            Platform.runLater(() -> {
                previousIndex = item.index;
                shoppingCard.removeIf(i ->
                        i.index == item.index);
            });
        }
    }
}

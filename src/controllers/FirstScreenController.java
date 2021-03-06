package controllers;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Item;
import models.CreditCard;
import models.Item;
import models.Settings;
import services.dataServices.IDataAccessor;
import shared.IListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class FirstScreenController extends BaseController {

    private static float totalPrice;
    IListener secondListener;
    IListener thirdListener;
    final ObservableList<Item> items = FXCollections.observableArrayList();
    final ObservableList<Item> shoppingCard = FXCollections.observableArrayList();
    Item selectedItem = null;

    @FXML
    private Button removebutton;
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
    @FXML
    private CheckBox creditCardCheckBox;
    @FXML
    private CheckBox checkCheckBox;
    @FXML
    private CheckBox cashCheckBox;

    private IDataAccessor<Item> _itemDataAccessor;
    private IDataAccessor<Settings> settingsDataAccessor;
    private IDataAccessor<CreditCard> creditCardDataAccessor;


    public FirstScreenController(IDataAccessor<Item> itemDataAccessor,
                                 IDataAccessor<Settings> settingsDataAccessor,
                                 IDataAccessor<CreditCard> creditCardDataAccessor) {
        this._itemDataAccessor = itemDataAccessor;
        this.settingsDataAccessor = settingsDataAccessor;
        this.creditCardDataAccessor = creditCardDataAccessor;
    }

    private void addItemsToListUI(ArrayList<Item> itms) {
        if (itms != null) {
            for (Item i : itms) {
                items.add(i);
            }
        }
    }

    public void Initialize() {

        addItemsToListUI(_itemDataAccessor.readAll());
        totalAmountLabel.setText("");

        cashCheckBox.setSelected(true);

        cashCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (cashCheckBox.isSelected()) {
                    checkCheckBox.setSelected(false);
                    creditCardCheckBox.setSelected(false);
                }
            }
        });
        checkCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (checkCheckBox.isSelected()) {
                    cashCheckBox.setSelected(false);
                    creditCardCheckBox.setSelected(false);
                }
            }
        });
        creditCardCheckBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (creditCardCheckBox.isSelected()) {
                    checkCheckBox.setSelected(false);
                    cashCheckBox.setSelected(false);
                }
            }
        });
        removebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                removeButtonClicked(e);
            }
        });
        validateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
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
                itemSelected((Item) newValue);
            } catch (CloneNotSupportedException e) {
                System.out.println("Clone exception occured");
                e.printStackTrace();
            }
        });
        shoppingCardTable.getSelectionModel().selectedItemProperty().addListener((obj, old, newValue) -> {
            selectedItem = (Item) newValue;
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
        if (checkCheckBox.isSelected()) {
            ThirdScreenChequeController thirdScreenController = new ThirdScreenChequeController();
            Stage thirdStage = new Stage();

            FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("../views/ThirdScreenViewPaiementCheck.fxml"));
            thirdLoader.setController(thirdScreenController);
            Parent thirdRoot = null;
            try {
                thirdRoot = thirdLoader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Scene thirdScene = new Scene(thirdRoot);
            thirdStage.setTitle("Paiement par espèces");
            thirdStage.setScene(thirdScene);
            thirdStage.setResizable(false);
            thirdScreenController.Initialize();
            thirdStage.show();
        } else if (cashCheckBox.isSelected()) {
            ThirdScreenController thirdScreenController = new ThirdScreenController();
            Stage thirdStage = new Stage();

            FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("../views/ThirdScreenView.fxml"));
            thirdLoader.setController(thirdScreenController);
            Parent thirdRoot = null;
            try {
                thirdRoot = thirdLoader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Scene thirdScene = new Scene(thirdRoot);
            thirdStage.setTitle("Paiement par espèces");
            thirdStage.setScene(thirdScene);
            thirdStage.setResizable(false);
            thirdScreenController.Initialize();
            thirdStage.show();
        } else {
            ThirdScreenCardController thirdScreenController = new ThirdScreenCardController();
            Stage thirdStage = new Stage();

            FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("../views/ThirdScreenViewPaiementCard.fxml"));
            thirdLoader.setController(thirdScreenController);
            Parent thirdRoot = null;
            try {
                thirdRoot = thirdLoader.load();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            Scene thirdScene = new Scene(thirdRoot);
            thirdStage.setTitle("Paiement par carte");
            thirdStage.setScene(thirdScene);
            thirdStage.setResizable(false);
            thirdScreenController.Initialize();
            thirdStage.show();
            thirdListener.closeSCene();
        }
    }

    private void removeButtonClicked(ActionEvent event) {
        if (selectedItem != null) {
            totalPrice -= selectedItem.getPrice();
            secondListener.updateTotalPrice(totalPrice);
            totalAmountLabel.setText(Float.toString(totalPrice));
            shoppingCard.remove(selectedItem);
        }
    }

    private void itemSelected(Item item) throws CloneNotSupportedException {
        if (item != null) {
            totalPrice += item.getPrice();
            secondListener.updateTotalPrice(totalPrice);
            totalAmountLabel.setText(Float.toString(totalPrice));
            Item newItem = new Item.Builder().withPrice(item.getPrice())
                    .withDateCreated(item.getDateCreated())
                    .withName(item.getName()).Build();
            newItem.index = shoppingCard.size();
            shoppingCard.add((Item) newItem.clone());
        }
    }
}


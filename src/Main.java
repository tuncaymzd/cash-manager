import controllers.FirstScreenController;
import controllers.SecondScreenController;
import controllers.ThirdScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Item;
import services.dataServices.IDataAccessor;
import services.dataServices.ItemDataAccessor;

import java.util.Date;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import shared.IOC;

public class Main extends Application {
    static IOC ioc = new IOC();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage secondStage = new Stage();
        Stage thirdStage = new Stage();

        FirstScreenController firstScreenController = new FirstScreenController(ioc.getItemDataAccessor(),
                ioc.getSettingsDataAccessor(), ioc.getCreditCardDataAccessor());
        SecondScreenController secondScreenController = new SecondScreenController();
        ThirdScreenController thirdScreenController = new ThirdScreenController(ioc.getCashPaymentService(), thirdStage);


        Scene cashScene;
        Scene checkScene;
        Scene creditCardScene;

        FXMLLoader cashLoader = new FXMLLoader(getClass().getResource("views/CashPaymentScreen.fxml"));
        Parent cashRoot = cashLoader.load();
        cashScene = new Scene(cashRoot);

//        FXMLLoader checkLoader = new FXMLLoader(getClass().getResource("views/CheckPaymentScreen.fxml"));
//        Parent checkRoot = cashLoader.load();
//        checkScene = new Scene(cashRoot);


//        FXMLLoader creditCardLoader = new FXMLLoader(getClass().getResource("views/CreditCardPaymentScreen.fxml"));
//        Parent creditCardRoot = cashLoader.load();
//        creditCardScene = new Scene(cashRoot);

        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("views/FirstScreenView.fxml"));
        firstLoader.setController(firstScreenController);
        Parent root = firstLoader.load();
        Scene firstScene = new Scene(root, 600, 400);
        primaryStage.setTitle("First Screen");
        primaryStage.setScene(firstScene);
        primaryStage.setResizable(false);
        firstScreenController.Initialize();
        primaryStage.show();

        FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("views/SecondScreenView.fxml"));
        secondLoader.setController(secondScreenController);
        Parent secondRoot = secondLoader.load();
        Scene secondScene = new Scene(secondRoot, 300, 300);
        secondStage.setTitle("Second Screen");
        secondStage.setScene(secondScene);
        secondStage.setResizable(false);
        secondStage.show();

        FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("views/CashPaymentScreen.fxml"));
        Parent thirdRoot = thirdLoader.load();
        Scene thirdScene = new Scene(thirdRoot);
        thirdLoader.setController(thirdScreenController);
        thirdStage.setTitle("Third Screen");
        thirdStage.setScene(thirdScene);
        thirdStage.setResizable(false);
        thirdStage.show();

        firstScreenController.setSecondListener(secondScreenController);
        firstScreenController.setFistListener(thirdScreenController);
        thirdScreenController.Initialize();
        firstScreenController.setThirdListener(thirdScreenController);
        secondScreenController.setFistListener(firstScreenController);
        thirdScreenController.setFistListener(firstScreenController);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
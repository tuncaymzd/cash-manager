import controllers.FirstScreenController;
import controllers.SecondScreenController;
import controllers.ThirdScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Item;
import services.dataServices.ItemDataAccessor;

import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage secondStage = new Stage();
        Stage thirdStage = new Stage();

        ItemDataAccessor i = new ItemDataAccessor();
        Item item = i.read(1);
//        Item item = new Item.Builder().withDateCreated(new Date()).withName("Ear pods").withPrice(200).Build();
//        i.create(item);

        FirstScreenController firstScreenController = new FirstScreenController();
        SecondScreenController secondScreenController = new SecondScreenController();
        ThirdScreenController thirdScreenController = new ThirdScreenController();

        firstScreenController.setSecondListener(thirdScreenController);
        firstScreenController.setFistListener(secondScreenController);
        secondScreenController.setFistListener(firstScreenController);
        thirdScreenController.setFistListener(firstScreenController);

        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("views/FirstScreenView.fxml"));
        firstLoader.setController(firstScreenController);
        Parent root = firstLoader.load();
        primaryStage.setTitle("First Screen");
        primaryStage.show();

        FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("views/SecondScreenView.fxml"));
        secondLoader.setController(secondScreenController);
        Parent secondRoot = secondLoader.load();
        Scene secondScene = new Scene(secondRoot, 200, 200);
        secondStage.setTitle("Second Screen");
        secondStage.setScene(secondScene);
        secondStage.show();

        FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("views/ThirdScreenView.fxml"));
        thirdLoader.setController(thirdScreenController);
        Parent thirdRoot = thirdLoader.load();
        Scene thirdScene = new Scene(thirdRoot);
        thirdStage.setTitle("Third Screen");
        thirdStage.setScene(thirdScene);
        thirdStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

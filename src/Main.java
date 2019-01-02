import controllers.FirstScreenController;
import controllers.SecondScreenController;
import controllers.ThirdScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Settings;
import services.dataServices.SettingsDataAccessor;

public class Main extends Application {

    Settings settings = new Settings.Builder().Build();
    SettingsDataAccessor data = new SettingsDataAccessor();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage secondStage = new Stage();
        Stage thirdStage = new Stage();

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
        Scene firstScene = new Scene(root, 600, 400);
        primaryStage.setTitle("First Screen");
        primaryStage.setScene(firstScene);
        primaryStage.setResizable(false);
        firstScreenController.Initialize();
        primaryStage.show();

        FXMLLoader secondLoader = new FXMLLoader(getClass().getResource("views/SecondScreenView.fxml"));
        secondLoader.setController(secondScreenController);
        Parent secondRoot = secondLoader.load();
        Scene secondScene = new Scene(secondRoot, 200, 200);
        secondStage.setTitle("Second Screen");
        secondStage.setScene(secondScene);
        secondStage.setResizable(false);
        secondStage.show();

        FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("views/ThirdScreenView.fxml"));
        FXMLLoader thirdLoader2 = new FXMLLoader(getClass().getResource("views/ThirdScreenViewPaiementCard.fxml"));
        FXMLLoader thirdLoader3 = new FXMLLoader(getClass().getResource("views/ThirdScreenViewPaiementCheck.fxml"));
        thirdLoader.setController(thirdScreenController);
        Parent thirdRoot = thirdLoader.load();
        Scene thirdScene = new Scene(thirdRoot);
        Parent thirdRoot2 = thirdLoader2.load();
        Scene thirdScene2 = new Scene(thirdRoot2);
        Parent thirdRoot3 = thirdLoader3.load();
        Scene thirdScene3 = new Scene(thirdRoot3);
        switch (settings.getPreferedPaymentMethod()) {
            case "espece" :
                thirdStage.setScene(thirdScene);
                thirdStage.setTitle("Paiement par espèces");
            case "cartedecredit" :
                thirdStage.setScene(thirdScene2);
                thirdStage.setTitle("Paiement par carte de crédit");
            case "cheque" :
                thirdStage.setScene(thirdScene3);
                thirdStage.setTitle("Paiement par chèque");
            default :
                thirdStage.setScene(thirdScene);
                thirdStage.setTitle("Paiement par espèces");
        }
        thirdStage.setScene(thirdScene);
        thirdStage.setResizable(false);
        thirdScreenController.Initialize();
        thirdStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

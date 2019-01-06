import controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Settings;
import services.dataServices.SettingsDataAccessor;
import shared.IOC;

public class Main extends Application {
    static IOC ioc = new IOC();
    Settings settings = new Settings.Builder().Build();
    SettingsDataAccessor data = new SettingsDataAccessor();

    @Override
    public void start(Stage primaryStage) throws Exception {
        settings = data.read(13);
        Stage secondStage = new Stage();
        Stage thirdStage = new Stage();

        System.out.println(settings.getPreferedPaymentMethod());
        FirstScreenController firstScreenController = new FirstScreenController(ioc.getItemDataAccessor(),
                ioc.getSettingsDataAccessor(), ioc.getCreditCardDataAccessor());
        SecondScreenController secondScreenController = new SecondScreenController();
        ThirdScreenController thirdScreenController = new ThirdScreenController();
        ThirdScreenChequeController thirdScreenChequeController = new ThirdScreenChequeController();
        ThirdScreenCardController thirdScreenCardController = new ThirdScreenCardController();

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

        System.out.println(settings.getPreferedPaymentMethod());
        if (settings.getPreferedPaymentMethod().equals("espece")) {
            FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("views/ThirdScreenView.fxml"));
            thirdLoader.setController(thirdScreenController);
            Parent thirdRoot = thirdLoader.load();
            Scene thirdScene = new Scene(thirdRoot);
            thirdStage.setScene(thirdScene);
            thirdStage.setTitle("Paiement par espèces");
            thirdStage.setScene(thirdScene);
            thirdStage.setResizable(false);
            thirdScreenController.Initialize();
            thirdStage.show();
        } else if (settings.getPreferedPaymentMethod().equals("cartedecredit")) {
            System.out.println("Coucou");
            FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("views/ThirdScreenViewPaiementCard.fxml"));
            thirdLoader.setController(thirdScreenCardController);
            Parent thirdRoot = thirdLoader.load();
            Scene thirdScene = new Scene(thirdRoot);
            thirdStage.setScene(thirdScene);
            thirdStage.setTitle("Paiement par carte de crédit");
            thirdStage.setScene(thirdScene);
            thirdStage.setResizable(false);
            thirdScreenCardController.Initialize();
            thirdStage.show();
        } else if (settings.getPreferedPaymentMethod().equals("cheque")) {
            System.out.println("Coucou");
            FXMLLoader thirdLoader = new FXMLLoader(getClass().getResource("views/ThirdScreenViewPaiementCheck.fxml"));
            thirdLoader.setController(thirdScreenChequeController);
            Parent thirdRoot = thirdLoader.load();
            Scene thirdScene = new Scene(thirdRoot);
            thirdStage.setScene(thirdScene);
            thirdStage.setTitle("Paiement par carte de crédit");
            thirdStage.setScene(thirdScene);
            thirdStage.setResizable(false);
            thirdScreenChequeController.Initialize();
            thirdStage.show();
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
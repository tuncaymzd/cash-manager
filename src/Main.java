import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import controllers.FirstScreenController;
import controllers.SecondScreenController;
import controllers.ThirdScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.CreditCards;
import models.Item;
import models.Settings;
import services.dataServices.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
public class Main extends Application {
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
   */
public class Main {
    public static void main(String[] args) {
        //launch(args);
        //Settings settings = new Settings.Builder().Build();
        //settings.setCurrency("$&&&&");
        //settings.setDelay(1000);
        //settings.setPreferedPaymentMethod("euro");
        //SettingsDataAccessor data = new SettingsDataAccessor();
        //data.create(settings);
        //Item items = new Item.Builder().Build();
        //items.setName("mac book pro");
        //items.setPrice(1050);
        //items.setDateCreated(new Date());
        //ItemDataAccessor data = new ItemDataAccessor();
        //data.create(items);
        //CreditCards cards = new CreditCards.Builder().Build();
        //cards.setCreditCardCode(1234);
        //cards.setOwnerName("tuncay");
        //cards.setBackCVCode(123);
        //cards.setBankName("credit agricole");
        CreditCardDataAccessor data = new CreditCardDataAccessor();
        //data.create(cards);
        //System.out.println(data.read(1).getBackCVCode());
        //System.out.println(data.read(1).getBankName());
        //System.out.println(data.read(1).getCreditCardCode());
        //ArrayList<Settings> list = new ArrayList<Settings>();
        //ArrayList<Item> list = new ArrayList<Item>();
        //ArrayList<CreditCards> list = new ArrayList<CreditCards>();
        //list = data.readAll();
        //for (int i = 0; i < list.size(); i++) {
        //    System.out.println(list.get(i).getId());
        //}
        //Settings settings2 = new Settings.Builder().Build();
       // settings2.setId(7);
       // settings2.setCurrency("$&&&&update");
       // settings2.setDelay(59);
       // settings2.setPreferedPaymentMethod("euroupdate");
        //data.update(settings2);
        //Item items = new Item.Builder().Build();
        //items.setId(2);
        //items.setName("mac book pro");
        //items.setPrice(1050);
        //items.setDateCreated(new Date());
        //data.update(items);
        //CreditCards cards = new CreditCards.Builder().Build();
        //cards.setId(3);
        //cards.setCreditCardCode(12345677);
        //cards.setOwnerName("tuncayupdate");
        //cards.setBackCVCode(123456);
        //cards.setBankName("credit agricoleupdate");
        //data.update(cards);
    }
}

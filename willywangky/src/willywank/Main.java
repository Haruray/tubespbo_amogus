package willywank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import willywank.mainobjects.*;

public class Main extends Application {
    private static Stage mainStage;
    private static Stage startStage;
    private static Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("mainscreen.fxml"));
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("mainscreen.fxml"));
        controller =loader1.getController();
        primaryStage.setTitle("Main Game");
        primaryStage.setScene(new Scene(root, 1600, 900));
//        primaryStage.show();
//        NewGameNameInput.display();
        Parent root2 = FXMLLoader.load(getClass().getResource("start.fxml"));
        startStage = new Stage();
        startStage.setTitle("Start");
        startStage.setScene(new Scene(root2, 1600, 900));
        startStage.show();
    }

    public static Stage getMainScreen(){
        return mainStage;
    }
    public static Stage getStartScreen(){
        return startStage;
    }
    public static Controller getMainController(){
        return controller;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

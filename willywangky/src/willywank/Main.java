package willywank;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import willywank.mainobjects.*;

public class Main extends Application {
    private static Stage mainStage;
    private static Stage startStage;
    private static Stage inventoryStage;
    private static Stage breedStage;
    private static Stage inspectStage;
    private static Stage battleStage;
    private static Stage newGameStage;
    private static Stage changeEngimonStage;
    private static Stage useSkillItem;
    private static Stage skillItemTarget;
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
        //Inventory Window
        Parent root3 = FXMLLoader.load(getClass().getResource("inventory.fxml"));
        inventoryStage = new Stage();
        inventoryStage.initStyle(StageStyle.UNDECORATED);
        inventoryStage.setTitle("Inventory");
        inventoryStage.initModality(Modality.APPLICATION_MODAL);
        inventoryStage.setScene(new Scene(root3, 800, 800));
        //Inventory for breed and use skill item
        Parent root4 = FXMLLoader.load(getClass().getResource("inventoryengimononly.fxml"));
        breedStage = new Stage();
        breedStage.initStyle(StageStyle.UNDECORATED);
        breedStage.setTitle("Breed Inventory");
        breedStage.initModality(Modality.APPLICATION_MODAL);
        breedStage.setScene(new Scene(root4, 800, 800));
        //Inspect Screen
        Parent root5 = FXMLLoader.load(getClass().getResource("stats.fxml"));
        inspectStage = new Stage();
        inspectStage.setTitle("Inspect");
        inspectStage.initModality(Modality.APPLICATION_MODAL);
        inspectStage.setScene(new Scene(root5, 600, 400));
        //Battle screen
        Parent root6 = FXMLLoader.load(getClass().getResource("battle.fxml"));
        battleStage = new Stage();
        battleStage.setTitle("Battle");
        battleStage.initStyle(StageStyle.UNDECORATED);
        battleStage.initModality(Modality.APPLICATION_MODAL);
        battleStage.setScene(new Scene(root6, 400, 400));
        battleStage.setOnShowing(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Battle.updateEnemyInfo();
            }
        });
        //New game profile
        Parent root7 = FXMLLoader.load(getClass().getResource("newgame.fxml"));
        newGameStage = new Stage();
        newGameStage.setTitle("New Game");
        newGameStage.setScene(new Scene(root7, 1600, 900));
        //Change Engimon Stuff
        Parent root8 = FXMLLoader.load(getClass().getResource("inventorychangeengimon.fxml"));
        changeEngimonStage = new Stage();
        changeEngimonStage.initStyle(StageStyle.UNDECORATED);
        changeEngimonStage.setTitle("Change Engimon");
        changeEngimonStage.initModality(Modality.APPLICATION_MODAL);
        changeEngimonStage.setScene(new Scene(root8, 800, 800));
        //Use Skill
        Parent root9 = FXMLLoader.load(getClass().getResource("inventoryskilluse.fxml"));
        useSkillItem = new Stage();
        useSkillItem.initStyle(StageStyle.UNDECORATED);
        useSkillItem.setTitle("Use Skill Item");
        useSkillItem.initModality(Modality.APPLICATION_MODAL);
        useSkillItem.setScene(new Scene(root9, 800, 800));
        //skill item target
        Parent root10 = FXMLLoader.load(getClass().getResource("inventoryskilluseengimon.fxml"));
        skillItemTarget = new Stage();
        skillItemTarget.initStyle(StageStyle.UNDECORATED);
        skillItemTarget.setTitle("Target");
        skillItemTarget.initModality(Modality.APPLICATION_MODAL);
        skillItemTarget.setScene(new Scene(root10, 800, 800));
    }

    public static Stage getMainScreen(){
        return mainStage;
    }
    public static Stage getStartScreen(){
        return startStage;
    }
    public static Stage getInventoryStage(){
        return inventoryStage;
    }
    public static Stage getBreedStage(){return breedStage; }
    public static Stage getInspectStage(){return inspectStage;}
    public static Stage getBattleStage(){return battleStage;}
    public static Stage getNewGameStage(){return newGameStage;}
    public static Stage getChangeEngimonStage(){return changeEngimonStage;}
    public static Stage getUseSkillItem(){return useSkillItem;}
    public static Stage getSkillItemTarget(){return skillItemTarget;}
    public static Controller getMainController(){
        return controller;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

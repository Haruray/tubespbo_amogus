package willywank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import willywank.mainobjects.Enemy;
import willywank.mainobjects.EngimonUniverse;
import willywank.mainobjects.SupplementaryFunctions;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Battle implements Initializable {
    @FXML
    private Pane p1;
    @FXML
    private Pane p2;
    @FXML
    private Pane p3;
    @FXML
    private Pane p4;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private ImageView i1;
    @FXML
    private ImageView i2;
    @FXML
    private ImageView i3;
    @FXML
    private ImageView i4;
    @FXML
    private Text currPower;

    private boolean scanned;
    static String command;
    static Stage currWindow;
    public static List<Enemy> enemies;
    public static Enemy choosenEnemy;
    public static boolean choose;
    private Text t1;
    private Text t2;
    private Text t3;
    private Text t4;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choose = true;
//        //enemy di bawah kanan atas kiri
//        updateEnemyInfo();
//        Text t1 = new Text();
//        Text t2 = new Text();
//        Text t3 = new Text();
//        Text t4 = new Text();
//        float ourPower;
//        float enemyPower;
//        currPower.setText("your power x enemy power");
//        for (Enemy enemy : enemies){
//            System.out.println(enemy);
//        }
//        if (!enemies.get(2).getName().equals("None")){
//            ourPower = Controller.p.getActiveEngimon().getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(2).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(Controller.p.getActiveEngimon().getSkills());
//            enemyPower = enemies.get(2).getLevel()*SupplementaryFunctions.getHighestAdvantage(enemies.get(2).getElements(),Controller.p.getActiveEngimon().getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(enemies.get(2).getSkills());
//            i1.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(enemies.get(2).getSpecies())));
//            t1.setText(ourPower + "x"+enemyPower);
//            t1.setX(30);
//            t1.setY(20);
//            p1.getChildren().add(t1);
//        }
//        if (!enemies.get(1).getName().equals("None")){
//            ourPower = Controller.p.getActiveEngimon().getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(1).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(Controller.p.getActiveEngimon().getSkills());
//            enemyPower = enemies.get(1).getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(1).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(enemies.get(1).getSkills());
//            i2.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(enemies.get(1).getSpecies())));
//            t2.setText(ourPower+"x"+enemyPower);
//            t2.setX(30);
//            t2.setY(20);
//            p2.getChildren().add(t2);
//        }
//        if (!enemies.get(0).getName().equals("None")){
//            ourPower = Controller.p.getActiveEngimon().getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(0).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(Controller.p.getActiveEngimon().getSkills());
//            enemyPower = enemies.get(0).getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(0).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(enemies.get(0).getSkills());
//            i3.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(enemies.get(0).getSpecies())));
//            t3.setText(ourPower +"x"+enemyPower);
//            t3.setX(30);
//            t3.setY(20);
//            p3.getChildren().add(t3);
//        }
//        if (!enemies.get(3).getName().equals("None")){
//            ourPower = Controller.p.getActiveEngimon().getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(3).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(Controller.p.getActiveEngimon().getSkills());
//            enemyPower = enemies.get(3).getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(3).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(enemies.get(3).getSkills());
//            i4.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(enemies.get(3).getSpecies())));
//            t4.setText(ourPower + "x" + enemyPower);
//            t4.setX(30);
//            t4.setY(20);
//            p4.getChildren().add(t4);
//        }
    }

    public static void updateEnemyInfo(){
        //enemy di bawah kanan atas kiri
        enemies = SupplementaryFunctions.checkEnemiesOnAdjacentTiles(Controller.m, Controller.p.getPosX(), Controller.p.getPosY());
        for (Enemy enemy : enemies){
            System.out.println(enemy);
        }
    }

    public void updateView(){
        //enemy di bawah kanan atas kiri
        t1 = new Text();
        t2 = new Text();
        t3 = new Text();
        t4 = new Text();
        float ourPower;
        float enemyPower;
        currPower.setText("your power x enemy power");
        for (Enemy enemy : enemies){
            System.out.println(enemy);
        }
        if (!enemies.get(2).getName().equals("None")){
            ourPower = Controller.p.getActiveEngimon().getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(2).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(Controller.p.getActiveEngimon().getSkills());
            enemyPower = enemies.get(2).getLevel()*SupplementaryFunctions.getHighestAdvantage(enemies.get(2).getElements(),Controller.p.getActiveEngimon().getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(enemies.get(2).getSkills());
            i1.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(enemies.get(2).getSpecies())));
            t1.setText(ourPower + "x"+enemyPower);
            t1.setX(30);
            t1.setY(20);
            p1.getChildren().add(t1);
        }
        if (!enemies.get(1).getName().equals("None")){
            ourPower = Controller.p.getActiveEngimon().getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(1).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(Controller.p.getActiveEngimon().getSkills());
            enemyPower = enemies.get(1).getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(1).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(enemies.get(1).getSkills());
            i2.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(enemies.get(1).getSpecies())));
            t2.setText(ourPower+"x"+enemyPower);
            t2.setX(30);
            t2.setY(20);
            p2.getChildren().add(t2);
        }
        if (!enemies.get(0).getName().equals("None")){
            ourPower = Controller.p.getActiveEngimon().getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(0).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(Controller.p.getActiveEngimon().getSkills());
            enemyPower = enemies.get(0).getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(0).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(enemies.get(0).getSkills());
            i3.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(enemies.get(0).getSpecies())));
            t3.setText(ourPower +"x"+enemyPower);
            t3.setX(30);
            t3.setY(20);
            p3.getChildren().add(t3);
        }
        if (!enemies.get(3).getName().equals("None")){
            ourPower = Controller.p.getActiveEngimon().getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(3).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(Controller.p.getActiveEngimon().getSkills());
            enemyPower = enemies.get(3).getLevel()*SupplementaryFunctions.getHighestAdvantage(Controller.p.getActiveEngimon().getElements(), enemies.get(3).getElements()) + SupplementaryFunctions.sumSkillLevelAndPower(enemies.get(3).getSkills());
            i4.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(enemies.get(3).getSpecies())));
            t4.setText(ourPower + "x" + enemyPower);
            t4.setX(30);
            t4.setY(20);
            p4.getChildren().add(t4);
        }
    }
    public void up(){
        choose = true;
        if (!enemies.get(2).getName().equals("None")){
            choosenEnemy = enemies.get(2);
            i1.setImage(null);
            i2.setImage(null);
            i3.setImage(null);
            i4.setImage(null);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");

            Main.getBattleStage().close();
        }
    }
    public void right(){
        choose = true;
//        currWindow.close();
        if (!enemies.get(1).getName().equals("None")){
            choosenEnemy = enemies.get(1);
            i1.setImage(null);
            i2.setImage(null);
            i3.setImage(null);
            i4.setImage(null);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");

            Main.getBattleStage().close();
        }
    }
    public void down(){
        choose = true;
//        currWindow.close();
        if (!enemies.get(0).getName().equals("None")){
            choosenEnemy = enemies.get(0);
            i1.setImage(null);
            i2.setImage(null);
            i3.setImage(null);
            i4.setImage(null);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");

            Main.getBattleStage().close();
        }
    }
    public void left(){
        choose = true;
        if (!enemies.get(3).getName().equals("None")){
            choosenEnemy = enemies.get(3);
            i1.setImage(null);
            i2.setImage(null);
            i3.setImage(null);
            i4.setImage(null);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");

            Main.getBattleStage().close();
        }
    }
    public void scan(){
        scanned = true;
        enemies = SupplementaryFunctions.checkEnemiesOnAdjacentTiles(Controller.m, Controller.p.getPosX(), Controller.p.getPosY());
        updateView();
    }
    public void exit(){
        choose = false;
        i1.setImage(null);
        i2.setImage(null);
        i3.setImage(null);
        i4.setImage(null);
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");

        Main.getBattleStage().close();
    }
}

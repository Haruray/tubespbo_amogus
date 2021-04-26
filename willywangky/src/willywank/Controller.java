package willywank;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import willywank.mainobjects.*;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Variable global yang merupakan data player
    public static willywank.mainobjects.Inventory<Engimon> ie = new willywank.mainobjects.Inventory<>();
    public static willywank.mainobjects.Inventory<Skill> is = new willywank.mainobjects.Inventory<>();
    //Bagian ini cuma buat dummy engimon

    public static Engimon e = EngimonUniverse.Gaybon;
    //Dummy engimon created
    public static Player p;
    public static Map m = new Map(23);
    public static int timebomb = 11;

    //Dibawah ini adalah variable dari gui
    @FXML
    private Text playerName;
    @FXML
    private GridPane map;
    @FXML
    private Text engimonName;
    @FXML
    private Text health;
    @FXML
    private ProgressBar healthBar;
    @FXML
    private Text level;
    @FXML
    private Text warning;
    //Start game
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Info pemain
//        is=p.getInventorySkill();
//        ie=p.getInventoryEngimon();
        try{
            m.generateMapFromFile();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateData() throws Exception{
        warning.setText("");
        if (timebomb==0){
            for (Enemy enemy : EngimonUniverse.enemies){
                enemy.addExp(100);
            }
            SupplementaryFunctions.mapRandomizer(p, m, EngimonUniverse.enemyReserved);
            timebomb=10;
        }
        else {
            timebomb--;
        }

        for (int k = 0 ; k < EngimonUniverse.enemyReserved.size() ; k++){
            if (EngimonUniverse.enemyReserved.get(k)){
                SupplementaryFunctions.enemyRandomMove(EngimonUniverse.enemies.get(k), p, m);
                m.getCell(EngimonUniverse.enemies.get(k).getPosX(),EngimonUniverse.enemies.get(k).getPosY()).setEnemy(EngimonUniverse.enemies.get(k));
                m.getCell(EngimonUniverse.enemies.get(k).getPosX(),EngimonUniverse.enemies.get(k).getPosY()).setOccupy(true);
            }
        }
//        newGame.getScene().getWindow().hide();
        //Ini adalah controller new game
        //Fungsinya ngebuat window baru yang tampilannya dari mainscreen.fxml
//        Parent root = FXMLLoader.load(Move.class.getResource("mainscreen.fxml"));
//        Stage window = new Stage();
//        window.setTitle("Game");
//        window.setScene(new Scene(root, 1600, 900));
//        newGame.getScene().getWindow().hide(); //Menyembunyikan window sebelumnya
        //Setelah ini, ngesetup peta
        //greenland warna  #59dd60
        //mountains warna  #709fb0
        //tundra warna  #e4fbff
        //sea warna  #a4ebf3
        //Sekarang, isi dari map di loop dan akan dibuat kotak dengan warna yang sesuai.
        List<Pane> kotakPeta = new ArrayList<>();
        List<ImageView> views = new ArrayList<>();
        Image player = new Image("file:assets/player.png");
        Image grass = new Image("file:assets/tiles-grass.png");
        Image sea = new Image("file:assets/tiles-water.png");
        Image mountain = new Image("file:assets/tiles-mountain.png");
        Image tundra = new Image("file:assets/tiles-ice.png");
        Image space = new Image("file:assets/tiles-space.png");

        for (int i = 0 ; i < m.size ; i++){
            for (int j = 0 ; j < m.size ; j++){
                //ngebuat "Pane" (pane adalah kotak) di list kotakPeta
                kotakPeta.add(new Pane());

                if (m.getCell(i,j).getType().equals("Grassland")){
                    //kalau grassland, sesuaikan warna
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #59dd60 ; -fx-border-color : black");
                    //Image harus dicocokin apakah ada entity disana atau tidak ; menyusul
                    if (m.getCell(i,j).isOccupied()){
                        if (m.getCell(i, j).getEnemy().getLevel() > p.getActiveEngimon().getLevel()){
                            kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #59dd60 ; -fx-border-color : red ; -fx-border-width : 3px");
                            views.add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(m.getCell(i, j).getEnemy().getSpecies()))));
                            views.get(views.size()-1).setStyle("-fx-border-color : red ; -fx-border-width : 100px");
                            kotakPeta.get(kotakPeta.size()-1).getChildren().add(views.get(views.size()-1));
                        }
                        else{
                            kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(m.getCell(i, j).getEnemy().getSpecies()))));
                        }

                    }
                    else if (p.getPosX()==i && p.getPosY()==j){
                        kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #59dd60 ; -fx-border-color : yellow ; -fx-border-width : 3px");
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(player));
                    }
                    else if (p.ActiveX()==i && p.ActiveY()==j){
                        kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #59dd60 ; -fx-border-color : yellow ; -fx-border-width : 3px");
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(p.getActiveEngimon().getSpecies()))));
                    }
                    else{
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(grass));
                    }

                }
                else if (m.getCell(i,j).getType().equals("Sea")){
                    //karena di kodenya masih hanya ada dua jenis, maka percabangannya masih 2. update nanti
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #a4ebf3 ; -fx-border-color : black");
                    //Image harus dicocokin apakah ada entity disana atau tidak ; menyusul
                    if (m.getCell(i,j).isOccupied()){
                        if (m.getCell(i, j).getEnemy().getLevel() > p.getActiveEngimon().getLevel()){
                            kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #a4ebf3 ; -fx-border-color : red");
                            views.add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(m.getCell(i, j).getEnemy().getSpecies()))));
                            views.get(views.size()-1).setStyle("-fx-border-color : red ; -fx-border-width : 100px");
                            kotakPeta.get(kotakPeta.size()-1).getChildren().add(views.get(views.size()-1));
                        }
                        else{
                            kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(m.getCell(i, j).getEnemy().getSpecies()))));
                        }
                    }
                    else if (p.getPosX()==i && p.getPosY()==j){
                        kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #a4ebf3 ; -fx-border-color : yellow ; -fx-border-width : 3px");
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(player));
                    }
                    else if (p.ActiveX()==i && p.ActiveY()==j){
                        kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #a4ebf3 ; -fx-border-color : yellow ; -fx-border-width : 3px");
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(p.getActiveEngimon().getSpecies()))));
                    }
                    else{
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(sea));
                    }
                }
                else if (m.getCell(i,j).getType().equals("Mountains")){
                    //karena di kodenya masih hanya ada dua jenis, maka percabangannya masih 2. update nanti
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #eeeeee ; -fx-border-color : black");
                    //Image harus dicocokin apakah ada entity disana atau tidak ; menyusul
                    if (m.getCell(i,j).isOccupied()){
                        if (m.getCell(i, j).getEnemy().getLevel() > p.getActiveEngimon().getLevel()){
                            kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #eeeeee ; -fx-border-color : red");
                            views.add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(m.getCell(i, j).getEnemy().getSpecies()))));
                            views.get(views.size()-1).setStyle("-fx-border-color : red; -fx-border-width : 100px");
                            kotakPeta.get(kotakPeta.size()-1).getChildren().add(views.get(views.size()-1));
                        }
                        else{
                            kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(m.getCell(i, j).getEnemy().getSpecies()))));
                        }
                    }
                    else if (p.getPosX()==i && p.getPosY()==j){
                        kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #eeeeee ; -fx-border-color : yellow ; -fx-border-width : 3px");
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(player));
                    }
                    else if (p.ActiveX()==i && p.ActiveY()==j){
                        kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #eeeeee ; -fx-border-color : yellow ; -fx-border-width : 3px");
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(p.getActiveEngimon().getSpecies()))));
                    }
                    else{
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(mountain));
                    }
                }
                else if (m.getCell(i,j).getType().equals("Tundra")){
                    //karena di kodenya masih hanya ada dua jenis, maka percabangannya masih 2. update nanti
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #e4fbff ; -fx-border-color : black");
                    //Image harus dicocokin apakah ada entity disana atau tidak ; menyusul
                    if (m.getCell(i,j).isOccupied()){
                        if (m.getCell(i, j).getEnemy().getLevel() > p.getActiveEngimon().getLevel()){
                            kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #e4fbff ; -fx-border-color : red");
                            views.add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(m.getCell(i, j).getEnemy().getSpecies()))));
                            views.get(views.size()-1).setStyle("-fx-border-color : red; -fx-border-width : 10px"); //doesn't work
                            kotakPeta.get(kotakPeta.size()-1).getChildren().add(views.get(views.size()-1));
                        }
                        else{
                            kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(m.getCell(i, j).getEnemy().getSpecies()))));
                        }
                    }
                    else if (p.getPosX()==i && p.getPosY()==j){
                        kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #e4fbff ; -fx-border-color : yellow ; -fx-border-width : 3px");
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(player));
                    }
                    else if (p.ActiveX()==i && p.ActiveY()==j){
                        kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #e4fbff ; -fx-border-color : yellow ; -fx-border-width : 3px");
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImages.get(EngimonUniverse.singleElementSpecies.indexOf(p.getActiveEngimon().getSpecies()))));
                    }
                    else{
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(tundra));
                    }
                }
                //Setelah itu, atur kotak ini mau ditampilin di row dan column ke berapa
                GridPane.setConstraints(kotakPeta.get(kotakPeta.size()-1),j,i);
                //Habis itu, tambahkan kotak ke gui
                map.getChildren().add(kotakPeta.get(kotakPeta.size()-1));
            }
        }
        //Set tiles selain ukuran peta menjadi hitam
        for (int i =0 ; i < 23 ; i++){
            for (int j = 0 ; j < 23 ; j++){
                if (i > m.size-1 || j>m.size-1){
                    kotakPeta.add(new Pane());
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : black");
                    kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(space));
                    GridPane.setConstraints(kotakPeta.get(kotakPeta.size()-1),j,i);
                    map.getChildren().add(kotakPeta.get(kotakPeta.size()-1));
                }
            }
        }
        //Set Informasi Pemain di layar utama
        playerName.setText("Player : "+p.getPlayerName());
        engimonName.setText(p.getActiveEngimon().getName());
        health.setText("Health "+p.getActiveEngimon().getHealth()+"/3");
        healthBar.setProgress((float) p.getActiveEngimon().getHealth() / (float) 3);
        level.setText("Level "+p.getActiveEngimon().getLevel());
    }

    public void interactButton(){
//        Main.getInspectStage().showAndWait();
        Inspect.display(p.getActiveEngimon());
        /*
        System.out.println("interact");
        playerName.setText("Player : "+p.getPlayerName());
        Pane kotak = new Pane();
        kotak.setStyle("-fx-background-color : black");
        Image dababy = new Image("file:assets/dababy.png");
        kotak.getChildren().add(new ImageView(dababy));
        GridPane.setConstraints(kotak,0,0);
        map.getChildren().addAll(kotak);
         */

    }
    public void fillInventory(){
        /*
        ie.addItem(e);
        ie.addItem(e);
        List<Pane> kotaks = new ArrayList<>();
        for (int i = 0 ; i<ie.getSize() ; i++) {
            kotaks.add(new Pane());
            kotaks.get(kotaks.size()-1).setPrefHeight(100);
            kotaks.get(kotaks.size()-1).setPrefWidth(100);
            if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Fire")){
                kotaks.get(kotaks.size()-1).setStyle("-fx-background-color : red");
            }
            else {
                kotaks.get(kotaks.size()-1).setStyle("-fx-background-color : black");
            }

            container.getChildren().add(kotaks.get(kotaks.size()-1));
        }*/
    }


    public void moveButton() throws Exception{
        Move.display();
        changePlayerPos(Move.command);
        updateData();
    }

    public void changePlayerPos(String command){
        SupplementaryFunctions.playerMove(p,m,command);
    }

    public void battleButton() throws Exception{
        Engimon ifdead;
        Main.getBattleStage().showAndWait();
        if (Battle.choose){
            if (SupplementaryFunctions.battle(p.getActiveEngimon(), Battle.choosenEnemy)){
                //menang
                SupplementaryFunctions.winReward(p, Battle.choosenEnemy);
            }
            else{
                p.getActiveEngimon().decreaseHealth();
                updateData();
                if (p.getActiveEngimon().isDead()){
                    if (p.getInventoryEngimon().getSize() <= 0){
                        Main.getMainScreen().close();
                    }
                    else{
                        ifdead = p.getActiveEngimon();
                        Main.getChangeEngimonStage().showAndWait();
                        p.getInventoryEngimon().deleteItem(ifdead);
                    }
                }
            }
        }
        updateData();

    }
    public void chooseEnemyButton(){

    }
    public void inventoryButton() throws Exception{
        Main.getInventoryStage().show();
    }
    public void changeEngimonButton(){
        Main.getChangeEngimonStage().showAndWait();
        try{
            updateData();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void breedButton(){

    }
    public void useSkillItemButton(){
        Main.getUseSkillItem().showAndWait();
        //udah divalidasi inputnya
        try{
            InventorySkillUseTarget.selectedEngimon.addSkill(InventorySkillUse.selectedSkill);
            p.getInventorySkill().deleteItem(InventorySkillUse.selectedSkill);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }


}

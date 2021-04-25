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
    public Species s = new Species();
    public Element Fire = new Element("Fire");
    public Element Water = new Element("Water");
    public List<Skill> ls = new ArrayList<>();
    public List<Element> le= new ArrayList<Element>(){{
       add(Water);
    }};
    public Engimon e = new Engimon("cock3", null, null, s, ls, le, 10, 10);
    //Dummy engimon created
    public Player p = new Player("cock",is,ie,e,0,0); //player info
    public Map m = new Map();

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
    //Start game
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Info pemain
        ie.addItem(e);
        ie.addItem(e);
        try {
            updateData();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void updateData() throws Exception{

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
        Image dababy = new Image("file:assets/dababy.png");
        Image grass = new Image("file:assets/tiles-grass.png");
        Image sea = new Image("file:assets/tiles-water.png");
        Image mountain = new Image("file:assets/tiles-mountain.png");
        Image tundra = new Image("file:assets/tiles-ice.png");
        Image space = new Image("file:assets/tiles-space.png");
        m.generateMap();

        for (int i = 0 ; i < m.size ; i++){
            for (int j = 0 ; j < m.size ; j++){
                //ngebuat "Pane" (pane adalah kotak) di list kotakPeta
                kotakPeta.add(new Pane());
                if (m.getCell(i,j).getType().equals("Grassland")){
                    //kalau grassland, sesuaikan warna
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #59dd60 ; -fx-border-color : black");
                    //Image harus dicocokin apakah ada entity disana atau tidak ; menyusul
                    if (m.getCell(i,j).isOccupied()){
                        //gambar musuh
                    }
                    else if (p.getPosX()==i && p.getPosY()==j){
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(dababy));
                    }
                    else{
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(grass));
                    }

                }
                else{
                    //karena di kodenya masih hanya ada dua jenis, maka percabangannya masih 2. update nanti
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #a4ebf3 ; -fx-border-color : black");
                    //Image harus dicocokin apakah ada entity disana atau tidak ; menyusul
                    if (m.getCell(i,j).isOccupied()){
                        //gambar musuh
                    }
                    else if (p.getPosX()==i && p.getPosY()==j){
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(dababy));
                    }
                    else{
                        kotakPeta.get(kotakPeta.size()-1).getChildren().add(new ImageView(sea));
                    }
                }
                //Setelah itu, atur kotak ini mau ditampilin di row dan column ke berapa
                GridPane.setConstraints(kotakPeta.get(kotakPeta.size()-1),j,i);
                //Habis itu, tambahkan kotak ke gui
                map.getChildren().add(kotakPeta.get(kotakPeta.size()-1));
            }
        }
        //Set tiles selain ukuran peta menjadi hitam
        for (int i =0 ; i < 24 ; i++){
            for (int j = 0 ; j < 24 ; j++){
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
        healthBar.setProgress((float) (p.getActiveEngimon().getHealth() / 3));
        level.setText("Level "+p.getActiveEngimon().getLevel());
    }

    public void interactButton(){
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

    public void battleButton(){

    }
    public void chooseEnemyButton(){

    }
    public void inventoryButton() throws Exception{
        Main.getInventoryStage().show();
    }
    public void changeEngimonButton(){

    }
    public void breedButton(){

    }
    public void useSkillItemButton(){

    }


}

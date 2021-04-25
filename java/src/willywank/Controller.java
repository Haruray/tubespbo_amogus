package willywank;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import willywank.mainobjects.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    //Variable global yang merupakan data player
    public willywank.mainobjects.Inventory<Engimon> ie = new willywank.mainobjects.Inventory<>();
    public willywank.mainobjects.Inventory<Skill> is = new willywank.mainobjects.Inventory<>();
    //Bagian ini cuma buat dummy engimon
    public Species s = new Species();
    public Element Fire = new Element("Fire");
    public List<Skill> ls = new ArrayList<>();
    public List<Element> le= new ArrayList<Element>(){{
       add(Fire);
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
    private FlowPane container;
    //Start game
    @FXML
    private Button newGame;
    @FXML
    private Button loadGame;
    public void newGame() throws Exception{
        //Ini adalah controller new game
        //Fungsinya ngebuat window baru yang tampilannya dari mainscreen.fxml
        Parent root = FXMLLoader.load(Move.class.getResource("mainscreen.fxml"));
        Stage window = new Stage();
        window.setTitle("Game");
        window.setScene(new Scene(root, 1600, 900));
        newGame.getScene().getWindow().hide(); //Menyembunyikan window sebelumnya
        //Setelah ini, ngesetup peta
        //greenland warna  #59dd60
        //mountains warna  #709fb0
        //tundra warna  #e4fbff
        //sea warna  #a4ebf3
        //Sekarang, isi dari map di loop dan akan dibuat kotak dengan warna yang sesuai.
        List<Pane> kotakPeta = new ArrayList<>();
        for (int i = 0 ; i < m.size ; i++){
            for (int j = 0 ; j < m.size ; j++){
                //ngebuat "Pane" (pane adalah kotak) di list kotakPeta
                kotakPeta.add(new Pane());
                if (m.getCell(i,j).getType().equals("Grassland")){
                    //kalau grassland, sesuaikan warna
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #59dd60");
                }
                else{
                    //karena di kodenya masih hanya ada dua jenis, maka percabangannya masih 2. update nanti
                    kotakPeta.get(kotakPeta.size()-1).setStyle("-fx-background-color : #a4ebf3");
                }
                //Setelah itu, atur kotak ini mau ditampilin di row dan column ke berapa
                GridPane.setConstraints(kotakPeta.get(kotakPeta.size()-1),j,i);
                //Habis itu, tambahkan kotak ke gui
                map.getChildren().add(kotakPeta.get(kotakPeta.size()-1));
            }
        }
        window.show();
    }
    public void loadGame(){

    }
    public void exit(){

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
        }

    }
    public void moveButton() throws Exception{
        Move.display();
    }
    public void moveUpButton(){

    }
    public void moveRightButton(){

    }
    public void moveLeftButton(){

    }
    public void moveDownButton(){

    }
    public void battleButton(){

    }
    public void chooseEnemyButton(){

    }
    public void inventoryButton() throws Exception{
        Inventory.display();
    }
    public void changeEngimonButton(){

    }
    public void breedButton(){

    }
    public void useSkillItemButton(){

    }
}

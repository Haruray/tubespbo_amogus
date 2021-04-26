package willywank;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import willywank.mainobjects.Engimon;
import willywank.mainobjects.EngimonUniverse;
import willywank.mainobjects.Skill;

//import java.awt.*;
import java.net.URL;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Inventory implements Initializable {
    @FXML
    private FlowPane container; //buat inventory
    @FXML
    private Text capacity;
    private static List<CheckBox> engimonsChecked = new ArrayList<>();
    private static List<CheckBox> skillsChecked = new ArrayList<>();
    private static List<Integer> skillDeleteQty = new ArrayList<>();
    private static List<Tooltip> skillInfo = new ArrayList<>();
    javafx.scene.image.Image water = new javafx.scene.image.Image("file:assets/water.png");
    javafx.scene.image.Image water1 = new javafx.scene.image.Image("file:assets/water-1.png");
    javafx.scene.image.Image water2 = new javafx.scene.image.Image("file:assets/water-2.png");
    javafx.scene.image.Image water3 = new javafx.scene.image.Image("file:assets/water-3.png");

    javafx.scene.image.Image fire = new javafx.scene.image.Image("file:assets/fire.png");
    javafx.scene.image.Image fire1 = new javafx.scene.image.Image("file:assets/fire-1.png");
    javafx.scene.image.Image fire2 = new javafx.scene.image.Image("file:assets/fire-2.png");
    javafx.scene.image.Image fire3 = new javafx.scene.image.Image("file:assets/fire-3.png");

    javafx.scene.image.Image rock = new javafx.scene.image.Image("file:assets/rock.png");
    javafx.scene.image.Image rock1 = new javafx.scene.image.Image("file:assets/rock-1.png");
    javafx.scene.image.Image rock2 = new javafx.scene.image.Image("file:assets/rock-2.png");
    javafx.scene.image.Image rock3 = new javafx.scene.image.Image("file:assets/rock-3.png");

    javafx.scene.image.Image electric = new javafx.scene.image.Image("file:assets/thunder.png");
    javafx.scene.image.Image electric1 = new javafx.scene.image.Image("file:assets/thunder-1.png");
    javafx.scene.image.Image electric2 = new javafx.scene.image.Image("file:assets/thunder-2.png");
    javafx.scene.image.Image electric3 = new javafx.scene.image.Image("file:assets/thunder-3.png");

    javafx.scene.image.Image ice = new javafx.scene.image.Image("file:assets/ice.png");
    javafx.scene.image.Image ice1 = new javafx.scene.image.Image("file:assets/ice-1.png");
    javafx.scene.image.Image ice2 = new javafx.scene.image.Image("file:assets/ice-2.png");
    javafx.scene.image.Image ice3 = new javafx.scene.image.Image("file:assets/ice-3.png");

    //idk
    Integer selectedValue;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        container.getChildren().clear();
//        engimonsChecked.clear();
//        skillsChecked.clear();
//        willywank.mainobjects.Inventory<Engimon> ie = Controller.p.getInventoryEngimon();
//        List<Pane> engimons = new ArrayList<>();
//        try {
//            for (int i = 0 ; i<ie.getSize() ; i++) {
//                engimonsChecked.add(new CheckBox());
//                engimonsChecked.get(engimonsChecked.size()-1).prefWidth(100);
//                engimonsChecked.get(engimonsChecked.size()-1).prefHeight(100);
//                engimons.add(new Pane());
//                engimons.get(engimons.size()-1).setPrefHeight(100);
//                engimons.get(engimons.size()-1).setPrefWidth(100);
//                engimons.get(engimons.size()-1).getChildren().add(engimonsChecked.get(engimonsChecked.size()-1));
//                if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Fire")){
//                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : red");
//                }
//                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Water")){
//                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : #a4ebf3");
//                }
//                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Ground")){
//                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : #964B00");
//                }
//                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Ice")){
//                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : #4169E1");
//                }
//                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Electric")){
//                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : yellow");
//                }
//                engimons.get(engimons.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(ie.getItems().get(i).getSpecies()))));
//                int finalI = i;
//                engimons.get(engimons.size()-1).addEventHandler(ActionEvent.ACTION, e->{
//                    if (engimonsChecked.get(finalI).isSelected())
//                        Inspect.display(ie.getItems().get(finalI));
//                });
//                container.getChildren().add(engimons.get(engimons.size()-1));
//            }
//            capacity.setText("Capacity : "+ ie.getCurrentCap() + " / " + ie.getMaxCap());
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
    }

    public void showEngimonInventory(){
        container.getChildren().clear();
        engimonsChecked.clear();
        skillsChecked.clear();
        willywank.mainobjects.Inventory<Engimon> ie = Controller.p.getInventoryEngimon();
        List<Pane> engimons = new ArrayList<>();
        try {
            for (int i = 0 ; i<ie.getSize() ; i++) {
                engimonsChecked.add(new CheckBox());
                engimonsChecked.get(engimonsChecked.size()-1).prefWidth(50);
                engimonsChecked.get(engimonsChecked.size()-1).prefHeight(50);
                engimons.add(new Pane());
                engimons.get(engimons.size()-1).setPrefHeight(100);
                engimons.get(engimons.size()-1).setPrefWidth(100);
                engimons.get(engimons.size()-1).getChildren().add(engimonsChecked.get(engimonsChecked.size()-1));
                if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Fire")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : red");
                }
                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Water")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : #a4ebf3");
                }
                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Ground")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : #964B00");
                }
                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Ice")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : #4169E1");
                }
                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Electric")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : yellow");
                }

                engimons.get(engimons.size()-1).getChildren().add(new ImageView(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(ie.getItems().get(i).getSpecies()))));
                int finalI = i;
                engimons.get(engimons.size()-1).addEventHandler(ActionEvent.ACTION, e->{
                    if (engimonsChecked.get(finalI).isSelected())
                        Inspect.display(ie.getItems().get(finalI));
                });
                container.getChildren().add(engimons.get(engimons.size()-1));
            }
            capacity.setText("Capacity : "+ ie.getCurrentCap() + " / " + ie.getMaxCap());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void showSkillInventory(){
        container.getChildren().clear();
        engimonsChecked.clear();
        skillsChecked.clear();
        willywank.mainobjects.Inventory<Skill> is = Controller.p.getInventorySkill();
        List<Pane> skills = new ArrayList<>();
        boolean first = true;
        boolean diff = false;
        int currentQty = 1;
        int count=1;
        if (is.getSize() > 0){
            Skill currentSkill = is.getItems().get(0);
            try {
                for (int i = 0 ; i<is.getSize() ; i++) {
                    if (is.getItems().get(i).equals(currentSkill)){
                        if (first)
                            first=false;
                        else
                            currentQty++;
                        if (i == is.getSize()-1){
                            //Output ke i dengan currentqty
                            skillDeleteQty.add(0);
                            skillsChecked.add(new CheckBox());
                            skillInfo.add(new Tooltip());
                            skillInfo.get(skillInfo.size()-1).setText(is.getItems().get(i).toString());
                            skillsChecked.get(skillsChecked.size()-1).prefWidth(100);
                            skillsChecked.get(skillsChecked.size()-1).prefHeight(100);
                            skillsChecked.get(skillsChecked.size()-1).setOnAction(event -> {
                                getQtyToDelete(event);
                            });
                            skillsChecked.get(skillsChecked.size()-1).setTooltip(skillInfo.get(skillInfo.size()-1));
                            skills.add(new Pane());
                            skills.get(skills.size()-1).setPrefHeight(100);
                            skills.get(skills.size()-1).setPrefWidth(100);
                            skills.get(skills.size()-1).getChildren().add(skillsChecked.get(skillsChecked.size()-1));
                            if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Water")){
                                if (is.getItems().get(i).getMasteryLevel() == 1){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(water1));
                                }
                                else if (is.getItems().get(i).getMasteryLevel() == 2){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(water2));
                                }
                                else{
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(water3));
                                }
                            }
                            else if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Fire")){
                                if (is.getItems().get(i).getMasteryLevel() == 1){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(fire1));
                                }
                                else if (is.getItems().get(i).getMasteryLevel() == 2){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(fire2));
                                }
                                else{
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(fire3));
                                }
                            }
                            else if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Ground")){
                                if (is.getItems().get(i).getMasteryLevel() == 1){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(rock1));
                                }
                                else if (is.getItems().get(i).getMasteryLevel() == 2){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(rock2));
                                }
                                else{
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(rock3));
                                }
                            }
                            else if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Electric")){
                                if (is.getItems().get(i).getMasteryLevel() == 1){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(electric1));
                                }
                                else if (is.getItems().get(i).getMasteryLevel() == 2){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(electric2));
                                }
                                else{
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(electric3));
                                }
                            }
                            else if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Ice")){
                                if (is.getItems().get(i).getMasteryLevel() == 1){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(ice1));
                                }
                                else if (is.getItems().get(i).getMasteryLevel() == 2){
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(ice2));
                                }
                                else{
                                    skills.get(skills.size()-1).getChildren().add(new ImageView(ice3));
                                }
                            }
                            skills.get(skills.size()-1).setStyle("-fx-background-color : white");
                            Text skillCount = new Text();
                            skillCount.setText(Integer.toString(currentQty));
                            skillCount.setX(90);
                            skillCount.setY(20);
                            skills.get(skills.size()-1).getChildren().add(skillCount);
                            container.getChildren().add(skills.get(skills.size()-1));
                        }
                    }
                    else{
                        diff = true;
                        //output i-1
                        skillDeleteQty.add(0);
                        skillsChecked.add(new CheckBox());
                        skillInfo.add(new Tooltip());
                        skillInfo.get(skillInfo.size()-1).setText(is.getItems().get(i).toString());
                        skillsChecked.get(skillsChecked.size()-1).prefWidth(100);
                        skillsChecked.get(skillsChecked.size()-1).prefHeight(100);
                        skillsChecked.get(skillsChecked.size()-1).setOnAction(event -> {
                            getQtyToDelete(event);
                        });
                        skillsChecked.get(skillsChecked.size()-1).setTooltip(skillInfo.get(skillInfo.size()-1));
                        skills.add(new Pane());
                        skills.get(skills.size()-1).setPrefHeight(100);
                        skills.get(skills.size()-1).setPrefWidth(100);
                        skills.get(skills.size()-1).getChildren().add(skillsChecked.get(skillsChecked.size()-1));

                        if (is.getItems().get(i-1).getElmtReq().get(0).getElementName().equals("Water")){
                            if (is.getItems().get(i-1).getMasteryLevel() == 1){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(water1));
                            }
                            else if (is.getItems().get(i-1).getMasteryLevel() == 2){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(water2));
                            }
                            else{
                                skills.get(skills.size()-1).getChildren().add(new ImageView(water3));
                            }
                        }
                        else if (is.getItems().get(i-1).getElmtReq().get(0).getElementName().equals("Fire")){
                            if (is.getItems().get(i-1).getMasteryLevel() == 1){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(fire1));
                            }
                            else if (is.getItems().get(i-1).getMasteryLevel() == 2){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(fire2));
                            }
                            else{
                                skills.get(skills.size()-1).getChildren().add(new ImageView(fire3));
                            }
                        }
                        else if (is.getItems().get(i-1).getElmtReq().get(0).getElementName().equals("Ground")){
                            if (is.getItems().get(i-1).getMasteryLevel() == 1){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(rock1));
                            }
                            else if (is.getItems().get(i-1).getMasteryLevel() == 2){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(rock2));
                            }
                            else{
                                skills.get(skills.size()-1).getChildren().add(new ImageView(rock3));
                            }
                        }
                        else if (is.getItems().get(i-1).getElmtReq().get(0).getElementName().equals("Electric")){
                            if (is.getItems().get(i-1).getMasteryLevel() == 1){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(electric1));
                            }
                            else if (is.getItems().get(i-1).getMasteryLevel() == 2){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(electric2));
                            }
                            else{
                                skills.get(skills.size()-1).getChildren().add(new ImageView(electric3));
                            }
                        }
                        else if (is.getItems().get(i-1).getElmtReq().get(0).getElementName().equals("Ice")){
                            if (is.getItems().get(i-1).getMasteryLevel() == 1){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(ice1));
                            }
                            else if (is.getItems().get(i-1).getMasteryLevel() == 2){
                                skills.get(skills.size()-1).getChildren().add(new ImageView(ice2));
                            }
                            else{
                                skills.get(skills.size()-1).getChildren().add(new ImageView(ice3));
                            }
                        }
                        skills.get(skills.size()-1).setStyle("-fx-background-color : white");

                        Text skillCount = new Text();
                        skillCount.setText(Integer.toString(currentQty));
                        skillCount.setX(90);
                        skillCount.setY(20);
                        skills.get(skills.size()-1).getChildren().add(skillCount);
                        container.getChildren().add(skills.get(skills.size()-1));

                        count++;
                        currentSkill = is.getItems().get(i);
                        currentQty = 1;
                        first=true;
                    }
                    //output untuk terakhir kalinya
                }
                if (diff){
                    skillDeleteQty.add(0);
                    skillsChecked.add(new CheckBox());
                    skillInfo.add(new Tooltip());
                    skillInfo.get(skillInfo.size()-1).setText(is.getItems().get(is.getSize()-1).toString());
                    skillsChecked.get(skillsChecked.size()-1).prefWidth(100);
                    skillsChecked.get(skillsChecked.size()-1).prefHeight(100);
                    skillsChecked.get(skillsChecked.size()-1).setOnAction(event -> {
                        getQtyToDelete(event);
                    });
                    skillsChecked.get(skillsChecked.size()-1).setTooltip(skillInfo.get(skillInfo.size()-1));
                    skills.add(new Pane());
                    skills.get(skills.size()-1).setPrefHeight(100);
                    skills.get(skills.size()-1).setPrefWidth(100);
                    skills.get(skills.size()-1).getChildren().add(skillsChecked.get(skillsChecked.size()-1));
                    int i = is.getSize()-1;
                    if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Water")){
                        if (is.getItems().get(i).getMasteryLevel() == 1){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(water1));
                        }
                        else if (is.getItems().get(i).getMasteryLevel() == 2){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(water2));
                        }
                        else{
                            skills.get(skills.size()-1).getChildren().add(new ImageView(water3));
                        }
                    }
                    else if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Fire")){
                        if (is.getItems().get(i).getMasteryLevel() == 1){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(fire1));
                        }
                        else if (is.getItems().get(i).getMasteryLevel() == 2){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(fire2));
                        }
                        else{
                            skills.get(skills.size()-1).getChildren().add(new ImageView(fire3));
                        }
                    }
                    else if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Ground")){
                        if (is.getItems().get(i).getMasteryLevel() == 1){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(rock1));
                        }
                        else if (is.getItems().get(i).getMasteryLevel() == 2){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(rock2));
                        }
                        else{
                            skills.get(skills.size()-1).getChildren().add(new ImageView(rock3));
                        }
                    }
                    else if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Electric")){
                        if (is.getItems().get(i).getMasteryLevel() == 1){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(electric1));
                        }
                        else if (is.getItems().get(i).getMasteryLevel() == 2){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(electric2));
                        }
                        else{
                            skills.get(skills.size()-1).getChildren().add(new ImageView(electric3));
                        }
                    }
                    else if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Ice")){
                        if (is.getItems().get(i).getMasteryLevel() == 1){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(ice1));
                        }
                        else if (is.getItems().get(i).getMasteryLevel() == 2){
                            skills.get(skills.size()-1).getChildren().add(new ImageView(ice2));
                        }
                        else{
                            skills.get(skills.size()-1).getChildren().add(new ImageView(ice3));
                        }
                    }
                    skills.get(skills.size()-1).setStyle("-fx-background-color : white");
                    Text skillCount = new Text();
                    skillCount.setText(Integer.toString(currentQty));
                    skillCount.setX(90);
                    skillCount.setY(20);
                    skills.get(skills.size()-1).getChildren().add(skillCount);
                    container.getChildren().add(skills.get(skills.size()-1));
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        capacity.setText("Capacity : "+ is.getCurrentCap() + " / " + is.getMaxCap());

    }

    public void getQtyToDelete(ActionEvent event){
        CheckBox currCb = (CheckBox) event.getSource();
        if (currCb.isSelected()){
            int idx = 0;
            //Mencari idx checbox yang kecek
            for (int i = 0 ; i < skillsChecked.size() ; i++){
                if (skillsChecked.get(i).equals(currCb)){
                    idx = i;
                    break;
                }
            }
            //khusus skill : mendata berapa yang mau didelete
            Stage inputWindow = new Stage();
            inputWindow.initModality(Modality.APPLICATION_MODAL);
            inputWindow.setTitle("Number Input");
            VBox layout = new VBox(10);

            ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
            for (int i = 0 ; i < Controller.p.getInventorySkill().countItem(Controller.p.getInventorySkill().getDifferentItemAtX(idx)) ; i++ ){
                choiceBox.getItems().add(i+1);
            }
            choiceBox.setValue(1);
            Button submit = new Button("submit");
            inputWindow.initStyle(StageStyle.UNDECORATED);
            submit.setOnAction(e -> {
//                addItemQtyToDelete(idx, choiceBox);
//                skillDeleteQty.add(idx, choiceBox.getValue());
//                addItemQtyToDelete(idx, choiceBox.getValue());
                selectedValue = choiceBox.getValue();
                inputWindow.close();
            });
            layout.setAlignment(Pos.CENTER);
            layout.getChildren().addAll(choiceBox,submit);
            inputWindow.setScene(new Scene(layout,300,100));
            inputWindow.showAndWait();
            addItemQtyToDelete(idx, selectedValue);
        }
    }

    public void addItemQtyToDelete(int idx, int qty){
        skillDeleteQty.add(idx, qty);
    }

    public void deleteItems(){
        boolean engimonOrNot = false;
        for (int i = 0 ; i < engimonsChecked.size() ; i++){
            engimonOrNot = true;
            if (engimonsChecked.get(i).isSelected()){
                try{
                    Controller.p.getInventoryEngimon().deleteItem(i);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

        for (int i = 0 ; i < skillsChecked.size() ; i++){
            if (skillsChecked.get(i).isSelected()){
                for (int j = 0 ; j < skillDeleteQty.get(i) ; j++){
                    try{
                        Controller.p.getInventorySkill().deleteItem(Controller.p.getInventorySkill().getDifferentItemAtX(i));
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                }
            }
        }
        if (engimonOrNot){
            showEngimonInventory();
        }
        else {
            skillDeleteQty.clear();
            showSkillInventory();
        }
    }
    public void close(){
        container.getChildren().clear();
        Main.getInventoryStage().close();
    }
}

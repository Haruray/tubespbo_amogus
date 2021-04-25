package willywank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import willywank.mainobjects.Engimon;
import willywank.mainobjects.Skill;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Inventory implements Initializable {
    @FXML
    private FlowPane container; //buat inventory
    private static List<CheckBox> engimonsChecked = new ArrayList<>();
    private static List<CheckBox> skillsChecked = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        container.getChildren().clear();
        engimonsChecked.clear();
        skillsChecked.clear();
        willywank.mainobjects.Inventory<Engimon> ie = Controller.ie;
        List<Pane> engimons = new ArrayList<>();
        try {
            for (int i = 0 ; i<ie.getSize() ; i++) {
                engimonsChecked.add(new CheckBox());
                engimonsChecked.get(engimonsChecked.size()-1).prefWidth(100);
                engimonsChecked.get(engimonsChecked.size()-1).prefHeight(100);
                engimons.add(new Pane());
                engimons.get(engimons.size()-1).setPrefHeight(100);
                engimons.get(engimons.size()-1).setPrefWidth(100);
                engimons.get(engimons.size()-1).getChildren().add(engimonsChecked.get(engimonsChecked.size()-1));
                if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Fire")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : red");
                }
                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Water")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : #0000FF");
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

                container.getChildren().add(engimons.get(engimons.size()-1));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void showEngimonInventory(){
        container.getChildren().clear();
        engimonsChecked.clear();
        skillsChecked.clear();
        willywank.mainobjects.Inventory<Engimon> ie = Controller.ie;
        List<Pane> engimons = new ArrayList<>();
        try {
            for (int i = 0 ; i<ie.getSize() ; i++) {
                engimonsChecked.add(new CheckBox());
                engimonsChecked.get(engimonsChecked.size()-1).prefWidth(100);
                engimonsChecked.get(engimonsChecked.size()-1).prefHeight(100);
                engimons.add(new Pane());
                engimons.get(engimons.size()-1).setPrefHeight(100);
                engimons.get(engimons.size()-1).setPrefWidth(100);
                engimons.get(engimons.size()-1).getChildren().add(engimonsChecked.get(engimonsChecked.size()-1));
                if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Fire")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : red");
                }
                else if (ie.getItems().get(i).getElements().get(0).getElementName().equals("Water")){
                    engimons.get(engimons.size()-1).setStyle("-fx-background-color : #0000FF");
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

                container.getChildren().add(engimons.get(engimons.size()-1));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void showSkillInventory(){
        container.getChildren().clear();
        engimonsChecked.clear();
        skillsChecked.clear();
        willywank.mainobjects.Inventory<Skill> is = Controller.is;
        List<Pane> skills = new ArrayList<>();
        try {
            for (int i = 0 ; i<is.getSize() ; i++) {
                skillsChecked.add(new CheckBox());
                skillsChecked.get(skillsChecked.size()-1).prefWidth(100);
                skillsChecked.get(skillsChecked.size()-1).prefHeight(100);
                skills.add(new Pane());
                skills.get(skills.size()-1).setPrefHeight(100);
                skills.get(skills.size()-1).setPrefWidth(100);
                skills.get(skills.size()-1).getChildren().add(engimonsChecked.get(engimonsChecked.size()-1));
                if (is.getItems().get(i).getElmtReq().get(0).getElementName().equals("Fire")){
                    skills.get(skills.size()-1).setStyle("-fx-background-color : red");
                }
                else {
                    skills.get(skills.size()-1).setStyle("-fx-background-color : black");
                }

                container.getChildren().add(skills.get(skills.size()-1));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteItems(){
        for (int i = 0 ; i < engimonsChecked.size() ; i++){
            if (engimonsChecked.get(i).isSelected()){
                Controller.ie.deleteItem(i);
            }
        }
        for (int i = 0 ; i < skillsChecked.size() ; i++){
            if (engimonsChecked.get(i).isSelected()){
                Controller.is.deleteItem(i);
            }
        }
        showEngimonInventory();
    }
}

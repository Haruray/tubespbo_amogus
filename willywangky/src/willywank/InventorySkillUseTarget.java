package willywank;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import willywank.mainobjects.Element;
import willywank.mainobjects.Engimon;
import willywank.mainobjects.EngimonUniverse;
import willywank.mainobjects.Skill;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InventorySkillUseTarget implements Initializable {
    @FXML
    private FlowPane container; //buat inventory
    private static List<RadioButton> engimonsChecked = new ArrayList<>();
    private static ToggleGroup radioGroup = new ToggleGroup();
    public static Engimon selectedEngimon;
    //idk
    Integer selectedValue;
    public static String newname;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        container.getChildren().clear();
        engimonsChecked.clear();
    }

    private boolean engimonValid(Engimon engimon){
        for (Element e : InventorySkillUse.selectedSkill.getElmtReq()){
            if (!engimon.isElement(e)){
                return false;
            }
        }
        if (engimon.getSkills().size() >= 4){
            return false;
        }
        if (engimon.hasSkill(InventorySkillUse.selectedSkill)){
            return false;
        }

        return true;
    }

    public void showEngimonInventory(){
        container.getChildren().clear();
        engimonsChecked.clear();
        willywank.mainobjects.Inventory<Engimon> ie = Controller.p.getInventoryEngimon();
        List<Pane> engimons = new ArrayList<>();
        try {
            for (int i = 0 ; i<ie.getSize() ; i++) {
                if (engimonValid(ie.getItems().get(i))){
                    engimonsChecked.add(new RadioButton());
                    engimonsChecked.get(engimonsChecked.size()-1).prefWidth(100);
                    engimonsChecked.get(engimonsChecked.size()-1).prefHeight(100);
                    engimonsChecked.get(engimonsChecked.size()-1).setToggleGroup(radioGroup);
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
                    container.getChildren().add(engimons.get(engimons.size()-1));
                }
                else{
                    engimonsChecked.add(new RadioButton());
                    engimons.add(new Pane());
                }

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void selectEngimon(){
        RadioButton selected = (RadioButton) radioGroup.getSelectedToggle();
        int idx = 0;
        boolean found=false;
        for (RadioButton r : engimonsChecked){
            if (r.equals(selected)){
                found=true;
                break;
            }
            idx++;
        }
        if (found){
            selectedEngimon = Controller.p.getInventoryEngimon().getItems().get(idx);
            Main.getSkillItemTarget().close();
        }
    }

    public void cancel(){
        container.getChildren().clear();
        Main.getSkillItemTarget().close();
    }

}

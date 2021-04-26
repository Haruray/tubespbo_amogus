package willywank;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import willywank.mainobjects.Engimon;
import willywank.mainobjects.EngimonUniverse;
import willywank.mainobjects.Skill;
import willywank.mainobjects.SkillOverload;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InventorySkillUse implements Initializable {
    @FXML
    private FlowPane container; //buat inventory
    private static List<RadioButton> skillsChecked = new ArrayList<>();
    private static ToggleGroup radioGroup = new ToggleGroup();
    private static List<Tooltip> skillInfo = new ArrayList<>();
    public static Skill selectedSkill;
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
    public static String newname;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        container.getChildren().clear();
        skillsChecked.clear();
    }

    public void showSkillInventory(){
//        skillsChecked.get(skillsChecked.size()-1).setToggleGroup(radioGroup);
        container.getChildren().clear();
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
                            skillsChecked.add(new RadioButton());
                            skillsChecked.get(skillsChecked.size()-1).prefWidth(100);
                            skillsChecked.get(skillsChecked.size()-1).prefHeight(100);
                            skillInfo.add(new Tooltip());
                            skillInfo.get(skillInfo.size()-1).setText(is.getItems().get(i).toString());
                            skillsChecked.get(skillsChecked.size()-1).setTooltip(skillInfo.get(skillInfo.size()-1));
//                            skillsChecked.get(skillsChecked.size()-1).setOnAction(event -> {
//                                getQtyToDelete(event);
//                            });
                            skillsChecked.get(skillsChecked.size()-1).setToggleGroup(radioGroup);
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
                        skillsChecked.add(new RadioButton());
                        skillsChecked.get(skillsChecked.size()-1).prefWidth(100);
                        skillsChecked.get(skillsChecked.size()-1).prefHeight(100);
                        skillInfo.add(new Tooltip());
                        skillInfo.get(skillInfo.size()-1).setText(is.getItems().get(i).toString());
                        skillsChecked.get(skillsChecked.size()-1).setTooltip(skillInfo.get(skillInfo.size()-1));
//                        skillsChecked.get(skillsChecked.size()-1).setOnAction(event -> {
//                            getQtyToDelete(event);
//                        });
                        skillsChecked.get(skillsChecked.size()-1).setToggleGroup(radioGroup);
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
                    skillsChecked.add(new RadioButton());
                    skillsChecked.get(skillsChecked.size()-1).prefWidth(100);
                    skillsChecked.get(skillsChecked.size()-1).prefHeight(100);
                    skillInfo.add(new Tooltip());
                    skillInfo.get(skillInfo.size()-1).setText(is.getItems().get(is.getSize()-1).toString());
//                    skillsChecked.get(skillsChecked.size()-1).setOnAction(event -> {
//                        getQtyToDelete(event);
//                    });
                    skillsChecked.get(skillsChecked.size()-1).setToggleGroup(radioGroup);
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
    }

    public void selectEngimon(){
        RadioButton selected = (RadioButton) radioGroup.getSelectedToggle();
        int idx = 0;
        boolean found=false;
        for (RadioButton r : skillsChecked){
            if (r.equals(selected)){
                found=true;
                break;
            }
            idx++;
        }
        if (found){
            selectedSkill = Controller.p.getInventorySkill().getDifferentItemAtX(idx);
            Main.getUseSkillItem().close();
            Main.getSkillItemTarget().show();
        }
    }

    public void cancel(){
        container.getChildren().clear();
        Main.getUseSkillItem().close();
    }

}

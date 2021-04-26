package willywank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Inspect implements Initializable {

    @FXML
    private Text Name;
    @FXML
    private Text Parent;
    @FXML
    private Text Species;
    @FXML
    private Text Skills;
    @FXML
    private Text Element;
    @FXML
    private Text Level;
    @FXML
    private Text Exp;
    @FXML
    private Text CumExp;
    @FXML
    private Text ExpLimit;
    @FXML
    private Text Healt;
    @FXML
    private Text slogan;
    @FXML
    private Button changeName;
    @FXML
    private ImageView imageView;

    private static Text Name2;
    private static Text Parent2;
    private static Text Species2;
    private static Text Skills2;
    private static Text Element2;
    private static Text Level2;
    private static Text Exp2;
    private static Text CumExp2;
    private static Text ExpLimit2;
    private static Text Healt2;
    private static Text slogan2;
    private static Button changeName2;
    private static ImageView imageView2;

    public static String newName;
    public static Engimon currEngimon;

    static String command;
    static Stage currWindow;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Name2=Name;
        Parent2=Parent;
        Species2=Species;
        Skills2=Skills;
        Element2=Element;
        Level2=Level;
        Exp2=Exp;
        CumExp2=CumExp;
        ExpLimit2=ExpLimit;
        Healt2=Healt;
        slogan2=slogan;
        changeName2=changeName;
        imageView2=imageView;
//        currEngimon = Controller.p.getActiveEngimon();
//        String skills = "";
//        String elements="";
//        Name.setText("Name\t: "+Controller.p.getActiveEngimon().getName());
//        if (Controller.p.getActiveEngimon().getParents().get(0) != null){
//            Parent.setText("Parent\t: "+Controller.p.getActiveEngimon().getParents().get(0).getName() + " & " + Controller.p.getActiveEngimon().getParents().get(1).getName());
//        }
//        else{
//            Parent.setText("Parent\t: None");
//        }
//        Species.setText("Species\t: "+Controller.p.getActiveEngimon().getSpecies().getSpeciesName());
//        for (int i = 0 ; i < Controller.p.getActiveEngimon().getSkills().size() ; i++){
//            skills+=Controller.p.getActiveEngimon().getSkills().get(i).getSkillName();
//            if (i != Controller.p.getActiveEngimon().getSkills().size()-1){
//                skills+=", ";
//            }
//        }
//        Skills.setText("Skill\t\t: "+skills);
//        for (int i = 0 ; i < Controller.p.getActiveEngimon().getElements().size() ; i++){
//            elements+=Controller.p.getActiveEngimon().getElements().get(i).getElementName();
//            if (i!=Controller.p.getActiveEngimon().getElements().size()-1){
//                elements+=", ";
//            }
//        }
//        Element.setText("Element\t: "+elements);
//        Level.setText("Level\t: " + Controller.p.getActiveEngimon().getLevel());
//        Exp.setText("Exp\t\t: "+Controller.p.getActiveEngimon().getExp());
//        CumExp.setText("CumExp\t: "+Controller.p.getActiveEngimon().getCumulativeExp());
//        ExpLimit.setText("Exp Limit\t: "+Controller.p.getActiveEngimon().getCumExpLimit());
//        Healt.setText("Health\t: "+Controller.p.getActiveEngimon().getHealth());
//        slogan.setText("\""+Controller.p.getActiveEngimon().getSpecies().getSlogan()+"\"");
//        imageView.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(Controller.p.getActiveEngimon().getSpecies())));
    }
    public static void display(Engimon e){
        currEngimon = e;
        String skills = "";
        String elements="";
        Name2.setText("Name\t: "+e.getName());
        if (e.getParents().get(0) != null){
            Parent2.setText("Parent\t: "+e.getParents().get(0).getName() + " & " + e.getParents().get(1).getName());
        }
        else{
            Parent2.setText("Parent\t: None");
        }
        Species2.setText("Species\t: "+e.getSpecies().getSpeciesName());
        for (int i = 0 ; i < e.getSkills().size() ; i++){
            skills+=e.getSkills().get(i).getSkillName();
            if (i != e.getSkills().size()-1){
                skills+=", ";
            }
        }
        Skills2.setText("Skill\t\t: "+skills);
        for (int i = 0 ; i < e.getElements().size() ; i++){
            elements+=e.getElements().get(i).getElementName();
            if (i!=e.getElements().size()-1){
                elements+=", ";
            }
        }
        Element2.setText("Element\t: "+elements);
        Level2.setText("Level\t: " + e.getLevel());
        Exp2.setText("Exp\t\t: "+e.getExp());
        CumExp2.setText("CumExp\t: "+e.getCumulativeExp());
        ExpLimit2.setText("Exp Limit\t: "+e.getCumExpLimit());
        Healt2.setText("Health\t: "+e.getHealth());
        slogan2.setText("\""+e.getSpecies().getSlogan()+"\"");
        imageView2.setImage(EngimonUniverse.speciesImagesInventory.get(EngimonUniverse.singleElementSpecies.indexOf(e.getSpecies())));
        Main.getInspectStage().show();
    }

    public void changeName(){
        Stage inputWindow = new Stage();
        inputWindow.initStyle(StageStyle.UNDECORATED);
        inputWindow.initModality(Modality.APPLICATION_MODAL);
        inputWindow.setTitle("Number Input");
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        TextField input = new TextField();
        input.setPromptText("Enter a name");
        Button submit = new Button("submit");
        submit.setOnAction(e -> {
            if (!input.getText().equals("")){
                inputWindow.close();
            }
        });
        layout.getChildren().addAll(input,submit);
        inputWindow.setScene(new Scene(layout,300,100));
        inputWindow.showAndWait();
        newName = input.getText();
        currEngimon.setName(newName);
        Main.getInspectStage().close();
        display(currEngimon);
    }

    public void breed(){
        if (currEngimon.getLevel()>=4){
            Main.getBreedStage().showAndWait();
        }
    }
}

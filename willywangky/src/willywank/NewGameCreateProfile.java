package willywank;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import willywank.mainobjects.*;

import java.net.URL;
import java.util.ResourceBundle;

public class NewGameCreateProfile implements Initializable {
    @FXML
    private Button newGame;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private RadioButton r3;
    @FXML
    private TextField tf1;
    @FXML
    private Button b1;
    @FXML
    private ImageView iv1;
    @FXML
    private ImageView iv2;
    @FXML
    private ImageView iv3;

    private static ToggleGroup radioGroup = new ToggleGroup();
    public static Engimon selectedEngimon;
    public static String name;

    public void initialize(URL location, ResourceBundle resources) {
        r1.setToggleGroup(radioGroup);
        r2.setToggleGroup(radioGroup);
        r3.setToggleGroup(radioGroup);
        iv1.setImage(new Image("file:assets/Bufumon200x200.png"));
        iv2.setImage(new Image("file:assets/Golem200x200.png"));
        iv3.setImage(new Image("file:assets/Koikingu200x200.png"));
    }

    public void submit(){
        if (!tf1.getText().equals("")){
            RadioButton selected = (RadioButton) radioGroup.getSelectedToggle();
            if (selected.equals(r1)){
                selectedEngimon = EngimonUniverse.JackFrost;
            }
            else if (selected.equals(r2)){
                selectedEngimon = EngimonUniverse.Dababy;
            }
            else {
                selectedEngimon = EngimonUniverse.Waluigi;
            }
            name = tf1.getText();
            selectedEngimon.setLevel(5);
            Controller.p = new Player(name, Controller.is, Controller.ie, new Engimon(selectedEngimon), 0, 0);
            try{
                Controller.p.getInventorySkill().addItem(new Skill(NewGameCreateProfile.selectedEngimon.getSkills().get(0)));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            Controller.is = Controller.p.getInventorySkill();
            Controller.ie = Controller.p.getInventoryEngimon();
            SupplementaryFunctions.mapRandomizer(Controller.p ,Controller.m, EngimonUniverse.enemyReserved);
            try{
                Main.getMainController().updateData();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            Main.getNewGameStage().close();
            Main.getMainScreen().show();
        }
    }
}

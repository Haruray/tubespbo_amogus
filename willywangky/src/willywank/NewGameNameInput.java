package willywank;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import willywank.mainobjects.Engimon;
import willywank.mainobjects.EngimonUniverse;

import java.net.URL;
import java.util.ResourceBundle;

public class NewGameNameInput {

    public void newGame() throws Exception {
//        Main.getMainScreen().show();
        Main.getStartScreen().close();
        Main.getNewGameStage().show();
    }
    public void exit(){
        Main.getStartScreen().close();
    }
}

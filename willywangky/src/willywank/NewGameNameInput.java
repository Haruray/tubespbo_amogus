package willywank;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewGameNameInput {
    @FXML
    private Button newGame;

    public void newGame() throws Exception {
        Main.getMainScreen().show();
//        Main.getMainController().updateData();
        Main.getStartScreen().close();

    }
}

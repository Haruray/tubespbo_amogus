package willywank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.awt.*;

public class Move {
    static String command;
    static Stage currWindow;
    public static void display() throws Exception{
        Parent root = FXMLLoader.load(Move.class.getResource("move.fxml"));
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Move");
        window.setScene(new Scene(root, 400, 400));
        currWindow = window;
        window.showAndWait();
    }
    public void downClicked(){
        command="s";
        currWindow.close();
    }
    public void upClicked(){
        command="w";
        currWindow.close();
    }
    public void rightClicked(){
        command="d";
        currWindow.close();
    }
    public void leftClicked(){
        command="a";
        currWindow.close();
    }
}

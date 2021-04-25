package willywank;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.awt.*;

public class Move {
    static String command;
    static Stage currWindow;
    public static void display() throws Exception{
        Parent root = FXMLLoader.load(Move.class.getResource("move.fxml"));
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Move");
        window.setScene(new Scene(root, 600, 600));
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

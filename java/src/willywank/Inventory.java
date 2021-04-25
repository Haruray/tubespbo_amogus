package willywank;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Inventory {

    public static void display() throws Exception{
        Parent root = FXMLLoader.load(Inventory.class.getResource("inventory.fxml"));
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Move");
        window.setScene(new Scene(root, 800, 800));
        window.showAndWait();
    }
}

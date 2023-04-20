import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

import java.util.*;

public class Display extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root =
                FXMLLoader.load(getClass().getResource("JavaProjectFXML.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Day-Night Images");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
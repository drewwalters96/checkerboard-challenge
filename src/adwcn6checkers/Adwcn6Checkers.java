/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adwcn6checkers;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author drew
 */
public class Adwcn6Checkers extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCheckersBoard.fxml"));
        Parent root = loader.load();
        
        FXMLCheckersBoardController controller = loader.getController();
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
        // Create change listener for width/height
        ChangeListener<Number> sizeChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            controller.setGameBoard(); 
        };
        
        // Add change listeners to scene
        scene.widthProperty().addListener(sizeChangeListener);
        scene.heightProperty().addListener(sizeChangeListener);
        
        // Initialize game board
        controller.ready(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adwcn6checkers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author drew
 */
public class FXMLCheckersBoardController implements Initializable {
    
    private double boardHeight;
    private double boardWidth;
    private int numCols = 8;
    private int numRows = 8;
    
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private Scene scene;
    
    @FXML private AnchorPane anchorPane;
    @FXML private Menu gridMenu;
    @FXML private Menu colorsMenu;
    @FXML private MenuBar menuBar;
    @FXML private MenuItem defaultMenuItem;
    @FXML private MenuItem blueMenuItem;
    @FXML private MenuItem size3MenuItem;
    @FXML private MenuItem size8MenuItem;
    @FXML private MenuItem size10MenuItem;
    @FXML private MenuItem size16MenuItem;
    @FXML private VBox vBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML private void changeColor(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()) {
            case "defaultMenuItem":
                lightColor = Color.RED;
                darkColor = Color.BLACK;
                break;
            case "blueMenuItem":
                lightColor = Color.SKYBLUE;
                darkColor = Color.DARKBLUE;
                break;
            default:
                lightColor = Color.RED;
                darkColor = Color.BLACK;
                break;
        }
        
        // Reset gameboard
        setGameBoard();
    }
    
    @FXML private void changeSize(ActionEvent event) {
        MenuItem menuItem = (MenuItem)(event.getSource());
        
        switch(menuItem.getId()) {
            case "size3MenuItem":
                numRows = 3;
                numCols = 3;
                break;
            case "size8MenuItem":
                numRows = 8;
                numCols = 8;
                break;
            case "size10MenuItem":
                numRows = 10;
                numCols = 10;
                break;
            case "size16MenuItem":
                numRows = 16;
                numCols = 16;
                break;
            default:
                numRows = 8;
                numCols = 8;
                break;
        }
        
        // Reset gameboard
        setGameBoard();
    }
    
    public void ready(Scene scene) {
        this.scene = scene;
        
        // Create change listener for width/height
        ChangeListener<Number> sizeChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            setGameBoard(); 
        };
        
        // Add change listeners to scene
        scene.widthProperty().addListener(sizeChangeListener);
        scene.heightProperty().addListener(sizeChangeListener);
        
        setGameBoard();
    }
    
    public void setGameBoard() {
        boardWidth = scene.getWidth();
        boardHeight = scene.getHeight() - menuBar.getHeight();
        
        // Generate new gameboard
        Checkerboard checkerboard = new Checkerboard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane gameboard = checkerboard.build();
        
        // Clear previous gameboard and set new configuration
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(gameboard.getChildren()); 
    }  
}

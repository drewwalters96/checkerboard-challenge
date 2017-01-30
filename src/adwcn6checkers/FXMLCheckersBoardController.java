/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adwcn6checkers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML private void handleDefaultMenuItemClick(ActionEvent event) {
        lightColor = Color.RED;
        darkColor = Color.BLACK;
        
        // Reset gameboard
        setGameBoard();
    }
    
    @FXML private void handleBlueMenuItemClick(ActionEvent event) {
        lightColor = Color.SKYBLUE;
        darkColor = Color.DARKBLUE;
        
        // Reset gameboard
        setGameBoard();
    }
    
    @FXML private void handleSize3MenuItemClick(ActionEvent event) {
        numRows = 3;
        numCols = 3;
        
        // Reset gameboard
        setGameBoard();
    }
    
    @FXML private void handleSize8MenuItemClick(ActionEvent event) {
        numRows = 8;
        numCols = 8;
        
        // Reset gameboard
        setGameBoard();
    }
    
    @FXML private void handleSize10MenuItemClick(ActionEvent event) {
        numRows = 10;
        numCols = 10;
        
        // Reset gameboard
        setGameBoard();
    }
    
    @FXML private void handleSize16MenuItemClick(ActionEvent event) {
        numRows = 16;
        numCols = 16;
        
        // Reset gameboard
        setGameBoard();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    public void setGameBoard() {
        boardWidth = anchorPane.getWidth();
        boardHeight = anchorPane.getHeight();
        
        // Generate new gameboard
        Checkerboard checkerboard = new Checkerboard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        AnchorPane gameboard = checkerboard.build();
        
        // Clear previous gameboard and set new configuration
        anchorPane.getChildren().clear();
        anchorPane.getChildren().addAll(gameboard.getChildren());
        
    }
    
}

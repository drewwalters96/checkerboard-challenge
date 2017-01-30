/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adwcn6checkers;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author drew
 */
public class Checkerboard {
    private double boardHeight;
    private double boardWidth;
    private double rectangleHeight;
    private double rectangleWidth;
    private int numCols;
    private int numRows;
  
    private AnchorPane board = null;
    private Color lightColor;
    private Color darkColor;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build() {
        // Calculate the max width/height of the board squares
        rectangleWidth = boardWidth / numCols;
        rectangleHeight = boardHeight / numRows;
        
        AnchorPane anchorPane = new AnchorPane();
         
        // Create board squares
        for (int i = 0; i < numCols; i++) {
            Rectangle boardSquare = new Rectangle(rectangleWidth, rectangleHeight);
            
            // Assign board square color (evens are light, odds are dark)
            if (i % 2 == 0) {
                boardSquare.setFill(lightColor);
            }
            else {
                boardSquare.setFill(darkColor);
            }
            
            // Add board square to anchor pane
            anchorPane.getChildren().add(boardSquare);
        }
        
        board = anchorPane;
        
        return board;
    }
    
    public AnchorPane getBoard() {
        return board;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }
}

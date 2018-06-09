/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author skolniPC
 */
public class Movement {
        
        public Double initialX,initialY;
        public AnchorPane x;
        @FXML public ImageView close;
        
    
        
    @FXML
    public void mousePressed(MouseEvent evt)
    {
        initialX = evt.getSceneX();
        initialY = evt.getSceneY();
    }
    @FXML
    private void moveWindow(MouseEvent  evt)        
    {
        x=(AnchorPane) evt.getSource();
        x.getScene().getWindow().setX(evt.getScreenX()-initialX);
        x.getScene().getWindow().setY(evt.getScreenY()-initialY); 

    }
    @FXML
    private void close(MouseEvent event)
    {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
    
    
}

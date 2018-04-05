/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class menuController extends LoginController {
    @FXML private AnchorPane AnchorPane;
    @FXML private Pane pane;
    @FXML private Pane onePane,twoPane,threePane;
    @FXML private Scene tournamentScene,editScene,gamesScene;
    @FXML private Stage primaryStage;

    
    
    @FXML private void setBackgroundOnHover(MouseEvent mouse)
    {
        BoxBlur blur = new BoxBlur();
        blur.setWidth(8);
        blur.setHeight(8);
        blur.setIterations(10);
        this.pane.setEffect(blur);
        
       
        Pane pn = (Pane) mouse.getSource();
        
        if(pn.getId().equals("onePane"))  
        {
            this.twoPane.setEffect(blur);
            this.threePane.setEffect(blur);
            
            
        }
        
        if(pn.getId().equals("twoPane"))
        {
           
            this.onePane.setEffect(blur);
            this.threePane.setEffect(blur);
            
 
        }
        
        if(pn.getId().equals("threePane"))
        {
            this.onePane.setEffect(blur);
            this.twoPane.setEffect(blur);
           
        }
        
    }
    
    @FXML private void setBackgroundOnMouseExit(MouseEvent event)
    {
        this.onePane.setEffect(null);
        this.twoPane.setEffect(null);
        this.threePane.setEffect(null);
        this.pane.setEffect(null);
        this.onePane.setStyle(null);
        this.twoPane.setStyle(null);
        this.threePane.setStyle(null);
    
    }
    
    
    @FXML
    private void loadScene(MouseEvent event)
    {
        Pane pane = (Pane) event.getSource();
        
        
        switch(pane.getId())
        {
            case "onePane":
                primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                System.out.println(event.getSource());
                primaryStage.setScene(this.tournamentScene);
                System.out.println("hotov");
                 break;
            case "twoPane":
                primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                System.out.println(event.getSource());
                primaryStage.setScene(this.editScene);
                break;
                
            case "threePane":
                 primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                System.out.println(event.getSource());
                primaryStage.setScene(this.gamesScene);
                break;
                
        
        
        
    
    
    
    
    
         }
    }
    
    public void setScenes(Scene tournamentScene, Scene editScene, Scene gamesScene){
       this.tournamentScene = tournamentScene;
       this.editScene = editScene;
       this.gamesScene = gamesScene;
   }
    
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
}

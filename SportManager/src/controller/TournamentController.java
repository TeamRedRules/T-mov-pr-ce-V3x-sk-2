/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class TournamentController extends LoginController{

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private ImageView close;
    private Scene mainMenu;
    private Stage primaryStage;
    @FXML private Pane paneFootball, paneBasketball,paneFlorball, paneVoleyball;

    private int id = 1;
    @FXML private ImageView right,left,typeLeft,typeRight,leftGames,rightGames,leftPlayer,rightPlayer;
    @FXML private JFXTextField tournamentName;
    @FXML private Pane pane1,pane2,pane3;
    private int sceneID=1;
    
    private int teams,players,type =1,games ;
    @FXML private Label teamsCount,playersCount,gamesCount;
    @FXML private Label gameNumber;
    @FXML private Pane  groupPlayOff,playOff;
    
    @FXML private Label nameOfGame,tournamentType,typeOfGame;
    
    @FXML private Label gamesFinalCount,playersFinalCount,teamsFinalCount;
    
    
  
  
   
    
    
    
    public void setScenes(Scene main)
    {
        this.mainMenu = main;
    }
    @FXML
    private void menu(MouseEvent event)
    {
        ImageView img = (ImageView) event.getSource();
        if(img.getId().equals("left"))
            {
                this.id -=1;
                if(this.id < 1)
                    id=1;          
            }
        else
        {
            this.id+=1;
            if(this.id > 4)
                this.id =4;
        }
        System.out.println(id);
        switch(this.id)
        {
           
                
                
            case 1:
                this.paneFootball.setStyle(null);
                this.paneBasketball.setStyle("-fx-opacity:0;");
                this.left.setStyle("-fx-opacity:0;");
                this.left.setDisable(true);
                
                break;
                
            
            case 2:
                //basketball
                System.out.println("jede");
                this.paneBasketball.setStyle("-fx-opacity:1;");
                this.paneFootball.setStyle("-fx-opacity:0;");  
                this.left.setStyle(null);
                this.left.setDisable(false);
                this.paneFlorball.setStyle(null);
                
                break;
            case 3:
                
                //florball
                this.paneFootball.setStyle("-fx-opacity:0;"); 
                this.paneFlorball.setStyle("-fx-opacity:1");
                this.paneBasketball.setStyle(null);
                this.paneVoleyball.setStyle(null);
                this.right.setStyle("-fx-opacity:1");
                this.right.setDisable(false);
                break;
                
                //voleyball
            case 4:
                this.paneFootball.setStyle("-fx-opacity:0;"); 
                this.paneVoleyball.setStyle("-fx-opacity:1");
                this.paneFlorball.setStyle(null);
                this.right.setDisable(true);
                this.right.setStyle("-fx-opacity:0;");
        }
        
        
    
    
    }
    
    @FXML private void nextSubScene(MouseEvent event)
    {
        
        ImageView img = (ImageView) event.getSource();
        
        System.out.println(img.getId());
        if(img.getId().equals("previous"))
            this.sceneID -=1;
            
        else
            sceneID+=1;
            
       System.out.println(this.id);
       
        
        switch(sceneID){
            // turnament
            case 1:
                    
                    this.pane1.setStyle("-fx-opacity:1;");
                    this.pane2.setStyle("-fx-opacity:0;");
                    this.pane1.setDisable(false);
                    this.pane2.setDisable(true);
                    break;
                    
            case 2:
               
                this.pane1.setStyle("-fx-opacity:0;");
                this.pane2.setStyle("-fx-opacity:1;");
                this.pane1.setDisable(true);
                this.pane2.setDisable(false);
                this.pane3.setStyle("-fx-opacity:0;");
                this.pane3.setDisable(true);
                if(this.type ==1)
                {
                    this.gamesCount.setStyle("-fx-opacity:0;");
                    this.leftGames.setStyle("-fx-opacity:0;");
                    this.rightGames.setStyle("-fx-opacity:0;");
                    this.gameNumber.setStyle("-fx-opacity:0;");
                    
                
                    this.leftGames.setDisable(true);
                    this.rightGames.setDisable(true);
               
                }
                else
                {
                    this.gamesCount.setStyle("-fx-opacity:1;");
                    this.leftGames.setStyle("-fx-opacity:1;");
                    this.rightGames.setStyle("-fx-opacity:1;");
                    this.gameNumber.setStyle("-fx-opacity:1;");
                    this.leftGames.setDisable(false);
                    this.rightGames.setDisable(false);
                }
                break;
            case 3:
                this.pane1.setStyle("-fx-opacity:0;");
                this.pane2.setStyle("-fx-opacity:0;");
                this.pane3.setStyle("-fx-opacity:1;");
                
                
                this.gamesFinalCount.setText(String.valueOf(this.games));
                this.playersFinalCount.setText(String.valueOf(this.players));
                this.teamsFinalCount.setText(String.valueOf(this.teams));
                this.nameOfGame.setText(String.valueOf(this.tournamentName.getText()));
   
                
                if(this.id == 1)
                {
                    this.typeOfGame.setText("Football");
                }
                else if ( this.id == 2)
                {
                    this.typeOfGame.setText("BasketBall");
                }
                
                else if (this.id == 3)
                    
                {
                
                    this.typeOfGame.setText("Floorball");
                }
                else
                    this.typeOfGame.setText("VoleyBall");
                
                
                switch(this.type)
                {
                    case 1:
                        this.tournamentType.setText("Play Off");
                        break;
                    case 2 :
                        this.tournamentType.setText("Brackets");
                        break;
                
                }
                this.pane2.setDisable(true);
                this.pane3.setDisable(false);
                
                break;
                
                
            case 4:
                System.out.println("Objekt vytvořen");
                // InputDB x  = new InputDB();
                this.goBack(event);
                
        }
    }
    
    @FXML
    private void teamSettings(MouseEvent event)
    {
        ImageView view = (ImageView) event.getSource();
        
        System.out.println(this.teams + "" +this.players);
       
      
        
        switch(view.getId())
        {
            case "rightTeam":
                this.teams +=1;
                this.teamsCount.setText(String.valueOf(this.teams));
                break;
            case "leftTeam":
                this.teams -=1;
                this.teamsCount.setText(String.valueOf(this.teams));
                break;
            case "leftPlayer":
                this.players -=1;
                this.playersCount.setText((String.valueOf(this.players)));
                break;
            case "rightPlayer":
                this.players +=1;
                this.playersCount.setText((String.valueOf(this.players)));
                break;              
                
                //gamesCount games
            case "rightGames":
                this.games  +=1;
                this.gamesCount.setText((String.valueOf(this.games)));
                 System.out.println(this.games)    ;
                System.out.println(this.gamesCount.getText());
                break;
            case "leftGames":
                this.games  -=1;
               
                this.gamesCount.setText((String.valueOf(this.games)));
                
                break;
  }
         if (this.teams == 0 || this.teams == -1)
        {
            this.teams =0;
            this.teamsCount.setText((String.valueOf(this.teams)));
            }
        if(this.players  == 0 ||this.players == -1)
        {
            this.players =0;
            this.playersCount.setText((String.valueOf(this.players)));
        }
        if(this.games == -1 || this.games == 0)
        {
           this.games  = 0;      
           this.gamesCount.setText((String.valueOf(this.games)));
        }
        // diagram tříd, diagra užití diagram stavu / aktivi, sekvenční diagram //
    }
    
    
    
    
    @FXML private void  goBack(MouseEvent event)
    {
       // upravit podke ID sceny ze které vycházi pokyn 
        this.pane1.setStyle(null);
        this.pane2.setStyle("-fx-opacity:0;");
        this.pane2.setDisable(true);
        this.pane1.setDisable(false);
        this.pane3.setDisable(true);
        this.pane3.setStyle(null);
        System.out.println(this.id);
        this.sceneID =1;
        this.teams =0;
        this.players =0;
        this.teamsCount.setText("0");
        this.playersCount.setText("0");
         primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
         primaryStage.setScene(this.mainMenu);
    }
    
    
    
    
    @FXML private void changeType(MouseEvent event)
    {   
        
        ImageView img = (ImageView) event.getSource();
        
        if (img.getId().equals("typeLeft"))
        {
            this.type -=1;
            System.out.println(this.type)   ;
            if(this.type<1)
                this.type=1;
        }
       else{
            this.type+=1;
            System.out.println(this.type)   ;
            if(this.type > 2)
                this.type=2;
            
            }
        System.out.println("jde");
        
        switch (this.type)
        {
            //playOff
            case 1:
                
                this.typeLeft.setDisable(true);
                this.playOff.setStyle("-fx-opacity:1");
                this.typeLeft.setStyle("-fx-opacity:0;");
                this.typeRight.setStyle("-fx-opacity:1;");
                this.typeRight.setDisable(false);
                this.groupPlayOff.setStyle("-fx-opacity:0;");
                
                break;
            
            // tournament
            case 2:
                this.playOff.setStyle("-fx-opacity:0;");
                this.typeLeft.setDisable(false);
                this.typeLeft.setStyle("-fx-opacity:1;");
                this.typeRight.setStyle("-fx-opacity:0;");
                this.typeRight.setDisable(true);
                this.groupPlayOff.setStyle("-fx-opacity:1;");
                break;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

  
    
}

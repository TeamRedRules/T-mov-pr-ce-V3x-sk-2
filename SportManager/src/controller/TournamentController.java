/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
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
import sportmanager.DBconnection;
import sportmanager.Tournament;


/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class TournamentController extends Movement implements Initializable{

    @FXML private Scene mainMenu;
    // SubScene 1 settings buttons
    @FXML ImageView sportMinus,sportAdd,typeMinus,typeAdd,teamMinus,teamAdd,playersAdd,playersMinus,gamesMinus,gamesAdd,tbAdd,tbMinus,setsAdd,setsMinus,check;
    
    // SubScenes - Tournament, Team settings, Review
    @FXML Pane subPane1,subPane2,subPane3;
    
    // Menu  Panes,
    @FXML Pane sportPaneFootball,sportPaneBasketball,sportPaneFloorball,sportPaneVoleyball,sportPaneBadminton;
    
    // type menu Panes
    @FXML Pane typePaneTournament, typePaneGroups;
    
    @FXML Label labelGame,gamesCount,playersCount,teamsCount,labelError,labelSets,countSets,labelTB,countTB;
    
    @FXML Label typeFinal,gameFinal,setsFinal,teamsCountFinal,playersCountFinal,gameCountFinal;
    
    
    // Scene ID - id of scene, sportID - ID of choosen sport, typeID - ID of choosen type of tournament; 
    private int sceneID =1,sportID = 1,typeID = 1,players,games=1,teams = 1,sets,tbPoints;
    
    private EditController editController;
    
    @FXML private JFXTextField tournamentName;
    @FXML Stage primaryStage;
    @FXML ImageView close;
   
    
    
  
  
   
    
    
    
    public void setScenes(Scene main)
    {
        this.mainMenu = main;
    }
    public void setController(EditController controller)
    {
        this.editController = controller;
    
    
    }
    
    public void createTournament(MouseEvent event) throws SQLException
    {
        Tournament tournament = new Tournament(this.tournamentName.getText(),this.teams,"fotbal","Skupinový",games,"Not ready");
        
        System.out.println("creating Tournament");
        switch(this.sportID)
        {
            default:
                tournament = new Tournament(this.tournamentName.getText(),this.teams,"fotbal","Skupinový",games,"Not ready");
                break;
            case 1:
                switch(this.typeID)
                {   
                    case 1:
                        tournament = new Tournament(this.tournamentName.getText(),this.teams,"fotbal","Skupinový",games,"Not ready");
                        break;
                    case 2:
                         tournament = new Tournament(this.tournamentName.getText(),this.teams,"fotbal","Turnaj",games,"Not ready");
                        break;
                }
                break;
            case 2 :
                 switch(this.typeID)
                {   
                    case 1:
                        tournament = new Tournament(this.tournamentName.getText(),this.teams,"Basketball","Skupinový",games,"Not ready");
                           break;
                    case 2:
                         tournament = new Tournament(this.tournamentName.getText(),this.teams,"Basketball","Turnaj",games,"Not ready");
                           break;
                        
                }
                 break;
            case 3 :
                  switch(this.typeID)
                {   
                    case 1:
                        tournament = new Tournament(this.tournamentName.getText(),this.teams,"Florbal","Skupinový",games,"Not ready");
                           break;
                    case 2:
                        tournament = new Tournament(this.tournamentName.getText(),this.teams,"Florbal","Turnaj",games,"Not ready");
                           break;
                }
                  break;
            case 4 : 
                  switch(this.typeID)
                {   
                    case 1:
                        tournament = new Tournament(this.tournamentName.getText(),this.teams,"Volejbal","Skupinový",games,"Not ready");
                           break;
                    case 2:
                        tournament = new Tournament(this.tournamentName.getText(),this.teams,"Volejbal","Turnaj",games,"Not ready");
                           break;
                }
                  break;
            case 5:
                  switch(this.typeID)
                {   
                    case 1:
                        tournament = new Tournament(this.tournamentName.getText(),this.teams,"Badminton","Skupinový",games,"Not ready");
                        break;
                    case 2:
                        tournament = new Tournament(this.tournamentName.getText(),this.teams,"Badminton","Turnaj",games,"Not ready");
                        break;
                }
                  break;
                
                
            
        }
        
        
        this.editController.setTournamentObject(tournament);
        tournament.insertIntoDB();
        
       
        this.sceneID = 1;
        this.setVisibility("scene");
        
        primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(this.mainMenu);
        
    
    }
    
    
    
    @FXML private void changeSettings(MouseEvent event)       
    {
        switch(this.getImgID(event))
        {
            
            case "back":
                     primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                     primaryStage.setScene(this.mainMenu);
                     System.out.println("bacl jede");
                     
            /////////////// SPORT /////////////////////////////
            case "sportAdd":
                if(this.sportID == 5)
                    this.sportID = 5;
                else
                {
                    this.sportID +=1;
                }
                this.setVisibility("sport");
                break;

            case "sportMinus":
                    if(this.sportID == 1)
                    {
                        this.sportID =1;
                   }
                    else
                    {
                        this.sportID -=1;
                    }
                    this.setVisibility("sport");
                    break;

          /////////////// TYPE /////////////////////////////
            case "typeAdd" :
                if(this.typeID == 2)
                    this.typeID = 2;
                else
                    this.typeID +=1;
                this.setVisibility("type");
                break;
                
            // decrease id of var  typeID
            case "typeMinus":
                 if(this.typeID == 1)
                    this.typeID = 1;
                 
                else
                    this.typeID -=1;
                this.setVisibility("type");
                break;
                
                 /////////////// SCENE  /////////////////////////////
            case "nextScene" :
                if(this.sceneID == 3)
                    this.sceneID =3;
                else
                {
                    this.sceneID +=1;
                    this.setVisibility("scene");
                }
                    break;
                
            case "previousScene":
                if (this.sceneID == 0)
                    this.sceneID  =0;
                else
                {
                    this.sceneID -=1;
                    this.setVisibility("scene");
                    System.out.println("back Jede");
                }
                break;
                
            case "previousScene1":
                    if (this.sceneID == 0)
                    this.sceneID  =0;
                else
                {
                    this.sceneID -=1;
                    this.setVisibility("scene");
                    System.out.println("back Jede");
                }
                break;
                
                
            case "nextScene1":
                System.out.println("jede");
                this.sceneID +=1;
                this.setVisibility("scene");
                break;
                
///////////////// PLAYERS //////////////////////ú
            case "playersMinus":
                if(this.players == 0)
                    this.players  =0;
                else
                    this.players -=1;
                this.playersCount.setText(String.valueOf(this.players));
                break;
            case "playersAdd":
                  this.players +=1;
                this.playersCount.setText(String.valueOf(this.players));
                break;
          //////////// TEAM /////////////
            case "teamAdd":
                
                this.teams +=1;
                 this.teamsCount.setText(String.valueOf(this.teams));
                 if(this.typeID == 2)
                {
                    if(this.teams  != 4 && this.teams !=6 && this.teams != 8 && this.teams != 16)
                    {
                        this.labelError.setText("Pro turnaj je potreba 4/6/8/16 týmu");
                    }
                    else
                        this.labelError.setText("");
                        
                }
                break;
            case "teamMinus":
                if(this.teams == 0)
                    this.teams  =0;
                else
                    this.teams -=1;
                this.teamsCount.setText(String.valueOf(this.teams));
                 if(this.typeID == 2)
                {
                    if(this.teams  != 4 && this.teams != 8 && this.teams != 16)
                    {
                        this.labelError.setText("Pro turnaj je potreba 4/8/16 týmu");
                    }
                    else
                        this.labelError.setText("");
                        
                }
                break;
                ////////////// GAMES /////////////////////
            case "gamesAdd":
                 this.games +=1;
                 this.gamesCount.setText(String.valueOf(this.games));
                 break;
            case "gamesMinus":
                 if(this.games == 0)
                    this.games  =0;
                else
                    this.games -=1;
                this.gamesCount.setText(String.valueOf(this.games));
                break;
                
                ////////////////////// SETS //////////////////////////
            case "setsMinus":
                if (this.sets == 0)
                    this.sets =0;
                else
                    this.sets -=1;
                this.countSets.setText(String.valueOf(this.sets));
                break;
                
            case "setsAdd":
                this.sets +=1;
                this.countSets.setText(String.valueOf(this.sets));
                break;
                
                ///////////////////////////TB //////////////////////////ú
                
                
                // change ID because some unkown bug 
            case "tbAdd":
                if(this.tbPoints ==0)
                    this.tbPoints = 0;
                else
                    this.tbPoints -=1;
                System.out.println(this.tbPoints);
                System.out.println(event.getSource());
                this.countTB.setText(String.valueOf(this.tbPoints));
                break;
                
            case "tbMinus":
                 System.out.println(this.tbPoints);
                 System.out.println(event.getSource());
                 this.tbPoints +=1;
                 this.countTB.setText(String.valueOf(this.tbPoints));
                 break;
        }
    }
    
    private void setVisibility(String nameOfAction)
    {
        switch(nameOfAction)
        {
            case "sport":
                System.out.println("sport jede ");
                    switch(this.sportID)
                    {
                        //fotbal basketbal florbal voleyball badminton;
                        case 1:
                            this.sportMinus.setStyle("-fx-opacity:0");
                            this.sportMinus.setDisable(true);
                            this.sportPaneFootball.setStyle(null);
                            this.sportPaneBasketball.setStyle("-fx-opacity:0");
                            
                            
                            break;
                        case 2:
                             this.sportMinus.setStyle("-fx-opacity:1");
                            this.sportMinus.setDisable(false);
                            this.sportPaneFootball.setStyle("-fx-opacity:0");
                            this.sportPaneBasketball.setStyle("-fx-opacity:1");
                            this.sportPaneFloorball.setStyle("-fx-opacity:0");
                            
                            
                            break;
                        case 3:
                            this.sportPaneBasketball.setStyle("-fx-opacity:0");
                            this.sportPaneFloorball.setStyle("-fx-opacity:1");
                            this.sportPaneVoleyball.setStyle("-fx-opacity:0");
                            System.out.println(" neco dalsiho");
                            this.labelSets.setStyle("-fx-opacity:0");
                            this.countSets.setStyle("-fx-opacity:0;");
                            this.labelTB.setStyle("-fx-opacity:0;");
                            this.countTB.setStyle("-fx-opacity:0;");
                            this.tbAdd.setStyle("-fx-opacity:0;");
                            this.tbMinus.setStyle("-fx-opacity:0;");
                            this.setsAdd.setStyle("-fx-opacity:0;");
                             this.setsMinus.setStyle("-fx-opacity:0;");
                             this.tbAdd.setDisable(true);
                            this.tbMinus.setDisable(true);
                            this.setsAdd.setDisable(true);
                            this.setsMinus.setDisable(true);
                            
                            
                            break;
                            
                            //voleyball
                        case 4:
                            this.sportPaneFloorball.setStyle("-fx-opacity:0");
                            this.sportPaneVoleyball.setStyle("-fx-opacity:1");
                            this.sportPaneBadminton.setStyle("-fx-opacity:0;");
                            this.sportAdd.setStyle("-fx-opacity:1");
                            this.sportAdd.setDisable(false);
                            System.out.println("Voleyball");
                             this.labelSets.setStyle("-fx-opacity:1;");
                            this.countSets.setStyle("-fx-opacity:1;");
                            this.labelTB.setStyle("-fx-opacity:1;");
                            this.countTB.setStyle("-fx-opacity:1;");
                            this.tbAdd.setStyle("-fx-opacity:1;");
                            this.tbMinus.setStyle("-fx-opacity:1;");
                             this.setsAdd.setStyle("-fx-opacity:1;");
                             this.setsMinus.setStyle("-fx-opacity:1;");
                            this.tbAdd.setDisable(false);
                            this.tbMinus.setDisable(false);
                            this.setsAdd.setDisable(false);
                            this.setsMinus.setDisable(false);
                            break;
                            //labelSets,countSets,labelTB,countTB,tbAdd,tbMinus,setsAdd,setsMinus
                        case 5 :
                               this.labelSets.setStyle(null);
                               this.labelSets.setStyle("-fx-opacity:0;");
                            this.countSets.setStyle("-fx-opacity:0;");
                            
                            this.labelTB.setStyle("-fx-opacity:0;");
                            this.countTB.setStyle("-fx-opacity:0;");
                            this.tbAdd.setStyle("-fx-opacity:0;");
                            this.tbMinus.setStyle("-fx-opacity:0;");
                             this.tbAdd.setDisable(true);
                            this.tbMinus.setDisable(true);
                            this.setsAdd.setDisable(true);
                            this.setsMinus.setDisable(true);
                            this.setsAdd.setStyle("-fx-opacity:0;");
                             this.setsMinus.setStyle("-fx-opacity:0;");
                            
                            this.sportPaneVoleyball.setStyle("-fx-opacity:0");
                            this.sportPaneBadminton.setStyle("-fx-opacity:1");
                            this.sportAdd.setStyle("-fx-opacity:0");
                            this.sportAdd.setDisable(true);
                            break;
                    }
            break;
             /////////////// TYPE/////////////////////////////
            case "type":
                switch(this.typeID)
               {
                    case 1 :
                        this.typePaneTournament.setStyle("-fx-opacity:0");
                        this.typeMinus.setDisable(true);
                        this.typeMinus.setStyle("-fx-opacity:0;");
                        this.typePaneGroups.setStyle("-fx-opacity:1;");
                        this.typeAdd.setStyle("-fx-opacity:1;");
                        this.typeAdd.setDisable(false);
                        break;
                    case 2 : 
                        this.typePaneTournament.setStyle("-fx-opacity:1;");
                        this.typePaneGroups.setStyle("-fx-opacity:0");
                        this.typeAdd.setStyle("-fx-opacity:0;");
                        this.typeAdd.setDisable(true);
                        this.typeMinus.setDisable(false);
                        this.typeMinus.setStyle("-fx-opacity:1;");
                }
                break;
 ///////////////  SCENE ///////////////////////////// 
            case "scene":
                System.out.println(this.sceneID);
                switch(this.sceneID)
                {///////////SCENE 1//////////////////
                    case  1:
                        this.subPane2.setStyle("-fx-opacity:0;");
                        this.subPane3.setStyle("-fx-opacity:0;");
                        this.subPane2.setDisable(true);
                        this.subPane2.setStyle(null);
                        this.subPane1.setDisable(false);
                        this.subPane1.setStyle("-fx-opacity:1;");
                        
                        this.games =0;
                        this.teams=0;
                        this.players=0;
                        this.sets =0;
                        this.tbPoints =0;
                        
                        this.gamesCount.setText("0");
                        this.teamsCount.setText("0");
                        this.playersCount.setText("0");
                        this.countSets.setText("0");
                        this.countTB.setText("0");
                        break;
                        //////////////////////// SCENE 2 ///////////////////
                    case 2 :
                        this.subPane1.setDisable(true);
                        this.subPane1.setStyle("-fx-opacity:0;");
                        this.subPane2.setDisable(false);
                        this.subPane2.setStyle("-fx-opacity:1;");
                        if(this.typeID == 2)
                        {
                            this.gamesMinus.setDisable(true);
                            this.gamesMinus.setStyle("-fx-opacity:0;");
                            this.gamesAdd.setDisable(true);
                            this.gamesAdd.setStyle("-fx-opacity:0;");
                            this.labelGame.setStyle("-fx-opacity:0;");
                            this.labelGame.setDisable(true);
                            this.gamesCount.setStyle("-fx-opacity:0;");
                            this.gamesCount.setDisable(true);
                        }
                        else
                         {  this.gamesMinus.setDisable(false);
                            this.gamesMinus.setStyle("-fx-opacity:1;");
                            this.gamesAdd.setDisable(false);
                            this.gamesAdd.setStyle("-fx-opacity:1;");
                            this.labelGame.setStyle("-fx-opacity:1;");
                            this.labelGame.setDisable(false);
                            this.gamesCount.setStyle("-fx-opacity:1;");
                            this.gamesCount.setDisable(false);
                        }
                        
                        
                        
                        this.subPane3.setStyle("-fx-opacity:0;");
                        this.subPane3.setDisable(true);
                        break;
                        /////////////////////////// SCENE 3 /////////////////////
                    case 3:
                        if (this.sportID == 4)
                            
                          this.setsFinal.setText(String.valueOf(this.sets));
                        this.teamsCountFinal.setText(String.valueOf(this.teams));
                        this.playersCountFinal.setText(String.valueOf(this.players));
                        this.gameCountFinal.setText(String.valueOf(this.games));
                        
                        switch(this.typeID)
                        {
                            case 1:
                                this.typeFinal.setText("Skupinový");
                                break;
                            case 2:
                                this.typeFinal.setText("Turnaj");
                                break;
                             
                                        }
                        
                        switch ( this.sportID)
                        {
                            case 1:
                                this.gameFinal.setText("Fotbal");
                                break;
                            case 2:
                                this.gameFinal.setText("Basketbal");
                                break;
                            case 3 :
                                this.gameFinal.setText("Florbal");
                                break;
                            case 4:
                                this.gameFinal.setText("Volejbal");
                                break;
                            case 5:
                                this.gameFinal.setText("Badminton");
                                break;
                        
                        }
                        this.subPane2.setStyle("-fx-opacity:0;");
                        this.subPane2.setDisable(true);
                        
                        this.subPane3.setStyle("-fx-opacity:1;");
                        this.subPane3.setDisable(false);
                        break;
                
                
                
                
                
                
                }
                break;
        }
    
    
    
    }
    
    
    
    
    private String  getImgID(MouseEvent event)
    {
        ImageView view = (ImageView) event.getSource();
        return view.getId();
    }
        


 
    
    public void initialize(URL url, ResourceBundle rb) {
    System.out.println("Tournament Controller");
    }
             
}  
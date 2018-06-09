/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sportmanager.DBconnection;
import sportmanager.Tournament;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class EditController extends Movement implements Initializable{

   @FXML Stage primaryStage;
   @FXML Scene menuScene;
   @FXML private TableView  <Tournament> TournamentTable;
   @FXML private TableColumn <Tournament,String>  TournamentName;
   @FXML private TableColumn <Tournament,Integer>  NumberOfTeams;
   @FXML private TableColumn <Tournament,String>  TypeOfGame;
   private ObservableList<Tournament> tableData;
   private Tournament tournament;
   private Connection conn;
   @FXML
   private Button showTournamentButton,startTournamentButton;
   @FXML private Label registeredTeamsLabel,statusLabel;
   private Scene detailsScene;
   private GamesController gamesController;
   
   public void setTournamentObject(Tournament tournament)
   {
       this.tournament = tournament;
       this.tableData.add(tournament);
       this.TournamentTable.setItems(null);
       this.TournamentTable.setItems(tableData);
   }

    @FXML private void changeSettings(MouseEvent event)
    {
        switch(getID(event))
        {
            case "back":
                     primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                     primaryStage.setScene(this.menuScene);
                     System.out.println("jede");
                     break;     
        }
    } 
     
    public void showChoosenTournament() throws IOException
    {
        Tournament selectedTournament = this.TournamentTable.getSelectionModel().getSelectedItem();
      
       
       TournamentDetailsController TDController = (TournamentDetailsController) this.detailsScene.getUserData();
       
        System.out.println(TDController);
        TDController.setTournament(selectedTournament);
        Stage stage = new Stage();
        stage.setScene(this.detailsScene);
        stage.initStyle(StageStyle.UNDECORATED);
        this.showTournamentButton.setDisable(false);
        
        stage.show();
    }
    
    @FXML
    public void startTournament() throws SQLException
    {   
         Tournament selectedTournament = this.TournamentTable.getSelectionModel().getSelectedItem();
         selectedTournament.start();
         selectedTournament.createMatch();
         this.statusLabel.setStyle("-fx-background-color:green;");
         this.statusLabel.setText("Probíhá - viz panel hry");
         this.gamesController.addTournament(selectedTournament);
         this.startTournamentButton.setDisable(true);
         selectedTournament.updateDB();
         
         
        

    
    
    }
    
    public void setButtonAvailable() throws SQLException
    {
        Tournament selectedTournament = this.TournamentTable.getSelectionModel().getSelectedItem();
        this.registeredTeamsLabel.setText(selectedTournament.getArrayLengts() + "/" + selectedTournament.getTeam());
        this.showTournamentButton.setDisable(false);
        this.showTournamentButton.setStyle(null);
        
        if (selectedTournament.getArrayLengts()  ==  selectedTournament.getTeam() && !selectedTournament.getStatus().equals("Running"))
        {
            this.statusLabel.setText("Lze nastartovat");
            this.statusLabel.setStyle("-fx-background-color:orange");
            selectedTournament.setStatus("Ready");
            this.showTournamentButton.setDisable(false);
        }
        
        if(selectedTournament.getStatus().equals("Not ready"))
        {
            this.statusLabel.setText("V přípravě");
            this.statusLabel.setStyle("-fx-background-color:red");
            
        
        }
        else if (selectedTournament.getStatus().equals("Running")) 
        {
             this.statusLabel.setText("Probíhá - viz panel hry");
             this.statusLabel.setStyle("-fx-background-color:green");
             this.startTournament();
             
        }
       
       if (selectedTournament.getArrayLengts() == selectedTournament.getTeam() && !selectedTournament.getStatus().equals("Running"))
       {
           this.startTournamentButton.setDisable(false);
           this.startTournamentButton.setStyle(null);
           
       }
       else
       {
           this.startTournamentButton.setDisable(false);
           this.startTournamentButton.setStyle("-fx-background-color: rgba(153, 153, 102,0.5)");
       }   
            
    }
 
    private String getID(MouseEvent event)
    {
        ImageView img = (ImageView) event.getSource();
        return img.getId();
    }

   @FXML public void setScene(Scene menu)
    {
        this.menuScene = menu;

    }
   
    public void addScene(Scene advancedDetailsScene) {
            this.detailsScene = advancedDetailsScene;
            
    }

    public void setController(GamesController gamesController) {
       this.gamesController = gamesController;
       System.out.println("Controller jede");
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // nacist objekty z DB
        this.conn = DBconnection.connectToDB();
        this.tableData = FXCollections.observableArrayList();
        
       try {
           ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Turnaj");
            while (rs.next())
        {
            this.tableData.add(new Tournament(rs.getString(2),rs.getInt(3),rs.getString(5),rs.getString(4),rs.getInt(6),rs.getString(7)));   
          
 
        }
       
       } catch (SQLException ex) {
           Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       this.TournamentName.setCellValueFactory(new PropertyValueFactory<>("Name"));
       this.NumberOfTeams.setCellValueFactory(new PropertyValueFactory<>("team"));
       this.TypeOfGame.setCellValueFactory(new PropertyValueFactory<>("TournamentType"));
     

       this.TournamentTable.setItems(null);
       this.TournamentTable.setItems(this.tableData);
       System.out.println(this.TypeOfGame.getCellData(0));
       
       Tournament tourn;
       for (int i =0;i< this.tableData.size();i++)
       {
           tourn = this.tableData.get(i);
           // načte data do objektu torunament  - teamy a zápasy
            try {
                tourn.addTeam();
                tourn.loadMatches();
                
                
            } catch (SQLException ex) {
                Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
            }
           System.out.println(tourn);
           
       
       
       
       }
       
       
       
        
    }    
}

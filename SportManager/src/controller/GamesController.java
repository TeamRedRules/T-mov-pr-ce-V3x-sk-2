/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
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
public class GamesController extends Movement implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Stage primaryStage;
    private Scene menuScene;
    private ObservableList<Tournament> options;
    @FXML
    private JFXComboBox<Tournament> tournaments;
    private Scene scene4,scene6,scene8;
    private CreateBracketsController controller4;
    private Tournament6Controller controller6;
    private Tournament8Controller controller8;
    // private Controller6,Controller8;
    private Connection conn;
    
    @FXML
    public void back(MouseEvent event)
    {
        primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(this.menuScene);
        
        
    }
    public void setScene(Scene scene)
    {
     this.menuScene = scene;
    }
    
    public void addTournament(Tournament tournament)
    {
    
            this.options.clear();
            this.loadTournamentFromDB();
            this.tournaments.setItems(null);
            this.tournaments.setItems(this.options);
    }
    
    private void loadTournamentFromDB()
    {
        this.conn = DBconnection.connectToDB();
         try {
           ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Turnaj WHERE Status='Running'");
            while (rs.next())
        {   Tournament tourn = new Tournament(rs.getString(2),rs.getInt(3),rs.getString(5),rs.getString(4),rs.getInt(6),rs.getString(7));
            tourn.addTeam();
            tourn.loadMatches();
            this.options.add(tourn);   
            
 
        }
             } catch (SQLException ex) {
           Logger.getLogger(EditController.class.getName()).log(Level.SEVERE, null, ex);
       }
       this.tournaments.setItems(this.options);
    
    
    }
    
    @FXML private void generateTournament() throws IOException
    {
         Stage stage = new Stage();
         // TURNAJ M8 4 Týmy
        if(this.tournaments.getSelectionModel().getSelectedItem().getTeam() == 4)
        {
             
             stage.setScene(scene4);
             stage.initStyle(StageStyle.UNDECORATED);
             controller4.setTournament(this.tournaments.getSelectionModel().getSelectedItem());
        
        
        }
        // TURNAJ Má 6 týmu
        else if(this.tournaments.getSelectionModel().getSelectedItem().getTeam() == 6)
        {
            stage.setScene(scene6);
            stage.initStyle(StageStyle.UNDECORATED);
            controller6.setTournament(this.tournaments.getSelectionModel().getSelectedItem());
        
            
            System.out.println("6 týmů");
        }
        
        // 8 týmů
        else
        {
              stage.setScene(scene8);
            stage.initStyle(StageStyle.UNDECORATED);
          controller8.setTournament(this.tournaments.getSelectionModel().getSelectedItem());
            
        
        
        
        }
       
     
        stage.initStyle(StageStyle.UNDECORATED);
      //brController.setTournament(this.tournaments.getSelectionModel().getSelectedItem());
       
      
        stage.show();
        
        
    
    
    }
    
    public void setTournamentScenes(Scene scene,Scene scene2, Scene scene3)
    {
    
        this.scene4 = scene;
        this.scene6 = scene2;
        this.scene8 = scene3;
        controller4=  (CreateBracketsController) scene.getUserData();
        controller6  =(Tournament6Controller) scene2.getUserData();
        controller8 = (Tournament8Controller) scene3.getUserData();
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       options=FXCollections.observableArrayList();
       // this.tournaments = new JFXComboBox<Tournament>();
       this.loadTournamentFromDB();
    
    }    
    
}

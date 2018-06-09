/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sportmanager.Tournament;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class TournamentDetailsController extends Movement implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Tournament tournament;
    @FXML private JFXTextField teamName;
    @FXML private Button addTeamButton;
    
    
    
    public void setTournament(Tournament tournament)
    {
        this.tournament = tournament;
        System.out.println(tournament);  
    }
    
    @FXML public void enableButton()
    {
        if(!"".equals(this.teamName.getText()))
             this.addTeamButton.setDisable(false);
        else 
        this.addTeamButton.setDisable(true);
    
    }
    
    public void addTeam() throws SQLException
    {
        this.tournament.addTeam(this.teamName.getText());
        Stage stage = (Stage) teamName.getScene().getWindow();
        stage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

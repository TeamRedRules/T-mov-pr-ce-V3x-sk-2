/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sportmanager.Tournament;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class Tournament8Controller extends Movement implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Tournament tournament;
    @FXML private Label team1LabelTop,team2LabelTop,team3LabelTop,team4LabelTop,team5LabelTop,team6LabelTop,team7LabelTop,team8LabelTop,team1LabelSide,team2LabelSide,team3LabelSide,team4LabelSide,team5LabelSide,team6LabelSide,team7LabelSide;
    public void setTournament(Tournament tourn)
    {
      this.tournament = tourn ;
        ArrayList names = new ArrayList(this.tournament.getTeam());
        names = this.tournament.getTeamNames();
        this.team1LabelTop.setText((String) names.get(0));
        this.team2LabelTop.setText((String) names.get(1));
        this.team3LabelTop.setText((String) names.get(2));
        this.team4LabelTop.setText((String) names.get(3));
        this.team5LabelTop.setText((String) names.get(4));
        this.team6LabelTop.setText((String) names.get(5));
        this.team7LabelTop.setText((String) names.get(6));
        this.team8LabelTop.setText((String) names.get(7));
        
         this.team1LabelSide.setText((String) names.get(0));
        this.team2LabelSide.setText((String) names.get(1));
        this.team3LabelSide.setText((String) names.get(2));
        this.team4LabelSide.setText((String) names.get(3));
        this.team5LabelSide.setText((String) names.get(4));
         this.team6LabelSide.setText((String) names.get(5));
          this.team7LabelSide.setText((String) names.get(6));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    
}

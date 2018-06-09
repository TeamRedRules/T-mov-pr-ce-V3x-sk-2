/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import sportmanager.Tournament;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class CreateBracketsController extends Movement implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private Pane basePane;
     private Tournament  tournament;
    


    public void setTournament(Tournament tourn)
    {
        this.tournament = tourn ;
    
    }
    
    




    
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        // TODO
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXCheckBox;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import sportmanager.Team;
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
     @FXML private Label team1LabelTop,team2LabelTop,team3LabelTop,team4LabelTop,team1LabelSide,team2LabelSide,team3LabelSide;
     @FXML private  ArrayList<TextField> array;
     @FXML private TextField in12A,in12B,in13A,in13B,in14A,in14B,in23A,in23B,in24A,in24B,in34A,in34B;
     @FXML private JFXCheckBox pp12,pp13,pp14,pp23,pp24,pp34;
     

    public void setTournament(Tournament tourn)
    {
        this.tournament = tourn ;
        ArrayList names = new ArrayList(this.tournament.getTeam());
        names = this.tournament.getTeamNames();
        this.team1LabelTop.setText((String) names.get(0));
        this.team2LabelTop.setText((String) names.get(1));
        this.team3LabelTop.setText((String) names.get(2));
        this.team4LabelTop.setText((String) names.get(3));
        
        
        this.team1LabelSide.setText((String) names.get(0));
        this.team2LabelSide.setText((String) names.get(1));
        this.team3LabelSide.setText((String) names.get(2));
        this.calculateResults();
    
    
    }
    
    public void calculateResults()
    {
        Team mainTeam;
        Team secondaryTeam;
        int z =0;
        for(int i =1;i<this.tournament.getTeam();i++)
        {
            i -=1;
            mainTeam = this.tournament.getSingleTeam(i);
            System.out.println("tohle je : "+i);
           
            for (int y =0; y<this.array.size();y++)
            {
                System.out.println( i + " "  + y );
                System.out.println(mainTeam.getName() + " Team name ");
              switch(i)
              {
                   
                  // vyhodnocení zápasů pro tým 1
                  case 0:
                      if( y > 5)
                      {
                          
                          z = i;
                          i ++;
                          
                      }
                      break;
                      
                  case 1:
                    
                      if (y >9)
                      {
                           z = i;
                          i ++;
                         
                      }
                      break;
                      
                  case 2: 
                      if(y >11)
                      {
                        z = i;
                          i ++;
                          
                      }
                      break;
                      
                  default:
                 
                      break;
              
             
              }
          /*    if(z < i)
                  break;*/
                      
              
                   
            
            
            }
            
        
        
        
        }
    
    
    
    }
    
    
    




    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.array = new ArrayList();
      this.array.add(in12A);
      this.array.add(in12B);
      this.array.add(in13A);
      this.array.add(in13B);
      this.array.add(in14A);
      this.array.add(in14B);
      this.array.add(in23A);
      this.array.add(in23B);
      this.array.add(in24A);
      this.array.add(in24B);
      this.array.add(in34A);
      this.array.add(in34B);
      
    
}
}

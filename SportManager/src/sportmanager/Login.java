/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportmanager;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author skolniPC
 */
public class Login {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty passw;

    public Login(SimpleStringProperty name, SimpleIntegerProperty passw) {
        this.name = name;
        this.passw = passw;
    }
 
    
    public String getName()
      {
        return   this.name.get();
      
      }
    
    public int getPsw()
      {
          return this.passw.get();
      }
    
    
    
    }
    
    
    


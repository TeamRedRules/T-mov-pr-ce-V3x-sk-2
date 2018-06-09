package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sportmanager.DBconnection;

/**
 * FXML Controller class
 *
 * @author skolniPC
 */
public class LoginController implements Initializable {
    private Scene menuScene;
    private Connection con;
    private Stage primaryStage;
   
    
    
    private double initialX,initialY;
    private AnchorPane x;
    
    @FXML private JFXTextField inputName;
    @FXML private JFXPasswordField inputPsw;
    @FXML
    private ImageView close;
    @FXML private Button btnLogin;
    @FXML private Label labelWrong;
    
    
    @FXML
    public void mousePressed(MouseEvent evt)
    {
        initialX=evt.getSceneX();
        initialY= evt.getSceneY();
    }
    @FXML
    private void moveWindow(MouseEvent  evt)        
    {
        x=(AnchorPane) evt.getSource();
        x.getScene().getWindow().setX(evt.getScreenX()-initialX);
        x.getScene().getWindow().setY(evt.getScreenY()-initialY); 

    }
    @FXML
    private void close(MouseEvent event)
    {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
    
   public void setDB(Connection con)
   {
       this.con=con;
   }
    
   @FXML
   public boolean logIn(ActionEvent event) throws SQLException
     {
         System.out.println("jede");
         ResultSet rs =con.createStatement().executeQuery("SELECT * FROM Login");
         
         System.out.println(rs.getString(2));
         System.out.println(rs.getString(3));
         System.out.println(this.inputPsw.getText());
         System.out.println(this.inputName.getText());
         while(rs.next())
         {
             if( rs.getString(2).equals(this.inputName.getText()) && rs.getString(3).equals((String)this.inputPsw.getText()))
             {
             
                     primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
                     primaryStage.setScene(this.menuScene);
                     System.out.println("jede");
                     this.con.close();
                     return true;
                 
                
                     
             }
             else
                 this.labelWrong.setText("WRONG USERNAME OR PASSWORD");
           
                 
             
         }
         System.out.println("špatne heslo");
         return false;
         
     
     }
   

 
   
   
   public void setScene(Scene scene){
       this.menuScene = scene;
   }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       System.out.println("controller ");
       con = DBconnection.connectToDB();
    }   
}

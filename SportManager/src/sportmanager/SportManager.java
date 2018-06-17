/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportmanager;

import controller.EditController;
import controller.GamesController;
import controller.LoginController;
import controller.TournamentController;
import controller.menuController;
import java.io.IOException;
import java.sql.Connection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author skolniPC
 */
public class SportManager extends Application {
    
    private Connection con;
    private FXMLLoader loginScene;
    private FXMLLoader menu;
    private FXMLLoader turnament;
    private FXMLLoader editTournament;
    private FXMLLoader games;
    private FXMLLoader advancedDetails;
    private FXMLLoader bracket;
    private FXMLLoader loader6,loader8;
    
    @Override
    public void start(Stage Stage) throws IOException {
        loginScene = new FXMLLoader(getClass().getResource("layout/login.fxml"));
        Parent firstPane = loginScene.load();
        Scene login = new Scene(firstPane);

        
        turnament = new FXMLLoader(getClass().getResource("layout/CreateTourmanent.fxml"));
        Parent turnamentPane =  turnament.load();
        Scene turnamentScene = new Scene(turnamentPane);
        
        menu = new FXMLLoader(getClass().getResource("layout/mainMenu.fxml"));
        Parent menuPane = menu.load();
        Scene menuScene = new Scene(menuPane);
        
        
        editTournament= new FXMLLoader(getClass().getResource("layout/EditTournament.fxml"));
        Parent editPane = editTournament.load();
        Scene editScene = new Scene(editPane);
        
        games = new FXMLLoader(getClass().getResource("layout/Games.fxml"));
        Parent gamesPane = games.load();
        Scene gamesScene = new Scene(gamesPane);
        
        advancedDetails = new FXMLLoader(getClass().getResource("layout/TournamentDetails.fxml"));
        Parent details = advancedDetails.load();
        Scene advancedDetailsScene = new Scene(details);
        
        bracket = new FXMLLoader(getClass().getResource("layout/tournament.fxml"));
        Parent brackets = bracket.load();
        Scene scene4 = new Scene(brackets);
        
        
        /// TOURNAMENT SCENE 6/4/8 teams
        loader8 =   new FXMLLoader(getClass().getResource("layout/Tournament8.fxml"));
        
        Parent parent8 = loader8.load();
        Scene scene8 = new Scene(parent8);
        
        
        loader6 =  new FXMLLoader(getClass().getResource("layout/Tournament6.fxml"));
        Parent parent6 = loader6.load();
        Scene scene6 = new Scene(parent6);
        
        
        GamesController gamesController = (GamesController) games.getController();
        gamesController.setScene(menuScene);
       
        
        scene4.setUserData(this.bracket.getController());
        scene6.setUserData(this.loader6.getController());
        scene8.setUserData(this.loader8.getController());
        gamesController.setTournamentScenes(scene4,scene6,scene8);
        
        
        

        
        LoginController loginController = (LoginController) loginScene.getController();
        loginController.setScene(menuScene);
        
        
        menuController menuController = (menuController) menu.getController();
        menuController.setScenes(turnamentScene,editScene,gamesScene);
        
        TournamentController tournamentController = (TournamentController) turnament.getController();
        
        tournamentController.setScenes(menuScene);
        
        System.out.println("zkouska");
      
       
        EditController editController = (EditController) editTournament.getController();
        editController.setScene(menuScene);
        editController.setController(gamesController);
        
        advancedDetailsScene.setUserData(advancedDetails.getController());
        editController.addScene(advancedDetailsScene);
      
        tournamentController.setController(editController);
        
        
        
        

      /* Tournament tournament = new Tournament("test",4);
       for (int i = 0;i<4;i++)
       {
           tournament.addTeam(String.valueOf(i));
           System.out.println(i);
       }
       tournament.createMatch();
        */
        
     

        
        
        
        Stage.initStyle(StageStyle.UNDECORATED);
        Stage.setScene(login);
        Stage.show();
        
      
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

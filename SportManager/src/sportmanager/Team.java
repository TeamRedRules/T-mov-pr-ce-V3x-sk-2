/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author skolniPC
 */
public class Team {

    private String teamName;
    private int score, tournamentID;
    private Connection conn;
    private ArrayList<Match> matchArray;
    

    public Team(int tournamentID, String teamName, int score,int matches) {
        this.teamName = teamName;
        this.score = score;
        this.tournamentID = tournamentID;
        this.matchArray = new ArrayList();
       
        
        
    }
    public void insertIntoDB() throws SQLException
    {
         this.conn = DBconnection.connectToDB();
               ResultSet rs =conn.createStatement().executeQuery("SELECT ID FROM Tym WHERE NazevTymu = '" + this.teamName + "'");

    
    String sql = "INSERT INTO Tym(NazevTymu,Body) VALUES (?,?)";
    PreparedStatement stmt=conn.prepareStatement(sql);
    stmt.setString(1,this.teamName);
    stmt.setInt(2, score);
    stmt.executeUpdate();
    conn.close();
    
    conn = DBconnection.connectToDB();
    String sql2 = "INSERT INTO Turnaj_Tym (IDTurnaj, IDTym) values(?,?)";
    PreparedStatement stmt2 = conn.prepareStatement(sql2);
    stmt2.setInt(1, this.tournamentID);
    stmt2.setInt(2,this.getTeamID());
    stmt2.executeUpdate();
    conn.close();
    
    
    
        
    
    
    
    
    }
    public int getTeamID() throws SQLException
    {
     
       ResultSet rs =conn.createStatement().executeQuery("SELECT ID FROM Tym WHERE NazevTymu = '" + this.teamName + "'");
       int result = rs.getInt(1);
       
       return result;
    
    
    
    }
    
    public void createMatch(Team team) throws SQLException
    {
        this.matchArray.add(new Match(this.tournamentID,0,0,0,team,this.getTeamID()));
        System.out.println(" Pole zápasů " +matchArray);
       
        
    }
    


    @Override
    public String toString() {
        return "Team{" + "teamName=" + teamName + ", score=" + score + '}';
    }
    
    
    
    
    
    
    

}

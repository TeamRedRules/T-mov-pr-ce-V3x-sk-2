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

/**
 *
 * @author skolniPC
 */
public class Match {
    private int IDtournament,score1,score2,powerPlay,teamID;
    Team team;
    Connection conn;

    public Match(int IDtournament, int score1, int score2, int powerPlay,Team team, int teamID) throws SQLException {
        this.IDtournament = IDtournament;
        this.score1 = score1;
        this.score2 = score2;
        this.powerPlay = powerPlay;
        this.team = team;
        this.teamID = teamID;
        
    }
    
     public void saveMatch() throws SQLException
    { 
        this.conn = DBconnection.connectToDB();
        String sql = "INSERT INTO Zapas (IDTurnaj,Vysledek1,Vysledek2,Prodlouzeni) Values(?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1,this.IDtournament);
        stmt.setInt(2,this.score1);
        stmt.setInt(3,this.score2);
        stmt.setInt(4,this.powerPlay);
        stmt.executeUpdate();
        conn.close();
        
       this.conn = DBconnection.connectToDB();
       String sql2 = "INSERT INTO Tym_Zapas(IDZapas,IDTym1,IDTym2) Values(?,?,?)";
       PreparedStatement stmt2 = conn.prepareStatement(sql2);
        stmt2.setInt(1,this.getMatchID());
        stmt2.setInt(3,team.getTeamID());
        stmt2.setInt(2,this.teamID);
        stmt2.executeUpdate();
        conn.close();
        
    }

     
     
     public int getMatchID() throws SQLException
     {
         this.conn = DBconnection.connectToDB();
         String sql3 = "SELECT max(Zapas.IDZapas) from Zapas";
        ResultSet rs =conn.createStatement().executeQuery(sql3);
        int result = rs.getInt(1);
        this.conn.close();
        return result;
     }
     
    @Override
    public String toString() {
        return "Match{" + "IDtournament=" + IDtournament + ", score1=" + score1 + ", score2=" + score2 + ", powerPlay=" + powerPlay + '}';
    }
    
    
    
}

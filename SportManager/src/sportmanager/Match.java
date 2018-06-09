/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        this.saveMatch();
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
       String sql2 = "INSERT INTO Tym_Zapas() Values(?,?,?,?)";
       PreparedStatement stmt2 = conn.prepareStatement(sql2);
        stmt.setInt(1,this.IDtournament);
        stmt.setInt(3,team.getTeamID());
        stmt.setInt(2,this.teamID);
        stmt.executeUpdate();
        conn.close();
        
    }

    @Override
    public String toString() {
        return "Match{" + "IDtournament=" + IDtournament + ", score1=" + score1 + ", score2=" + score2 + ", powerPlay=" + powerPlay + '}';
    }
    
    
    
}

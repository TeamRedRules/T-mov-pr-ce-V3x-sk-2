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
import java.sql.Statement;
import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author skolniPC
 */
public class Tournament {
    private  final SimpleStringProperty name;
    private final ArrayList <Team>teams ;
    private final SimpleIntegerProperty team;
    private final SimpleStringProperty game;
    private final SimpleStringProperty tournamentType;
    private final SimpleIntegerProperty numberOfGames;
    private Connection conn;
    private final SimpleStringProperty status ;
    private int matches;
    
    public Tournament( String name, int teams,String game, String tournamentType,int games,String status) throws SQLException
    {
        this.name=  new SimpleStringProperty(name);
        this.teams = new ArrayList(teams);
        this.team = new SimpleIntegerProperty(teams);
        this.game = new SimpleStringProperty(game);
        this.tournamentType = new SimpleStringProperty(tournamentType);
        this.numberOfGames = new SimpleIntegerProperty(games);
        this.status =  new SimpleStringProperty(status);
        this.matches = this.team.get()*2;
        
        this.conn = DBconnection.connectToDB();  
    }
    
    public void insertIntoDB() throws SQLException
    {
    this.conn= DBconnection.connectToDB();
    String sql = "INSERT INTO Turnaj(Nazev,PocetTymu,HerniTyp,TypHry,PocetHer,Status) VALUES (?,?,?,?,?,?)";
    PreparedStatement stmt=conn.prepareStatement(sql);
    stmt.setString(1,name.get());
    stmt.setInt(2,team.get());
    stmt.setString(3,tournamentType.get());
    stmt.setString(4,game.get());
    stmt.setInt(5,numberOfGames.get());
    stmt.setString(6,status.get());
    stmt.executeUpdate();
    System.out.println("update probehl");
    this.conn.close();
    
    }
    
    public int getID() throws SQLException, SQLException, SQLException, SQLException, SQLException
    {
      this.conn = DBconnection.connectToDB();
      ResultSet rs =conn.createStatement().executeQuery("SELECT ID FROM Turnaj WHERE Nazev = '" + this.name.get() + "'");
       
       System.out.println(rs.getInt(1));
       int  id = rs.getInt(1);
       this.conn.close();
       return id;      
     
       
       
    
    
    
    }
    public void start()
    {
     this.status.set("Running");
    }
    public String getStatus()
    {
            return this.status.get();
    }
    public void setStatus(String string)
    {
        this.status.set(string);
    
    }
    
    /**
     *
     * @param teamName
     * @throws SQLException
     * Metoda zajišťuje přidání NOVÉHO TÝMU do DB a Tournament Objektu
     */
    public void addTeam(String teamName) throws SQLException
    {  
        Team team =new Team(this.getID(),teamName,0,this.matches);
        team.insertIntoDB();
        this.teams.add(team);
        
    }
    
    /**
     * Metoda která zajišťuje přidání týmu  z DB  do Obj Tournament
     *
     */
    public void addTeam() throws SQLException
    {
        this.conn = DBconnection.connectToDB();
        
        
       
       ResultSet rs =conn.createStatement().executeQuery("select Tym.NazevTymu , Tym.Body From Tym, Turnaj_Tym where Turnaj_Tym.IDTurnaj ='"+ this.getID() + "'  and Turnaj_Tym.IDTym = Tym.ID");
       while(rs.next())
       { 
               this.teams.add(new Team(this.getID(),rs.getString(1),rs.getInt(2),this.matches));
               System.out.println(teams); 
       }
       conn.close();
       
    }
    
    
    public void createMatch() throws SQLException
    {
        int x=0;
        
        if(this.tournamentType.get().equals("Skupinový"))
        {
               for(int z=0; z<this.numberOfGames.get();z++){
        System.out.println("kolo" + z);
        for(int i=0; i<this.teams.size(); i++)
        {
           System.out.println("Team");
            Team team = this.teams.get(i);
            for (x= i +1 ; x<this.teams.size(); x++)
                
              {
                    System.out.println(x);
                    
                   Team team2 = this.teams.get(x);
                    team.createMatch(team2);
                    System.out.println("Team 1 " + team + "team 2 " + this.teams.get(x) );
                }
        }
        }

        }
        else
           {
               
               
               
           }
    
  
    }
    
    
    public void loadMatches()
    {
    
    
    
    
    
    
    }
    public String getName()
    {
        return this.name.get();
    }
    
    public int getTeam()
    {
        return this.team.get();
    }
    
   public String getTournamentType()
    {
        return this.tournamentType.get();
    }
   public int getArrayLengts()
   {
       return this.teams.size();

   }
   
   
 

    @Override
    public String toString() {
        return this.getName();
    }

    public void updateDB() throws SQLException {
    this.conn= DBconnection.connectToDB();
    String sql = "UPDATE  Turnaj set Nazev = '" + this.name.get() + "', PocetTymu = '" + this.teams.size() +"', HerniTyp = '" + this.game.get() + "',  TypHry = '" + this.game.get() + "',  PocetHer = '" + this.numberOfGames.get() + "',  Status = '" + this.status.get() + "' WHERE Nazev = '" + this.name.get() +"'";
    // vytvořit string, update DB
    System.out.println(sql);
    PreparedStatement stmt = this.conn.prepareStatement(sql);
    stmt.execute();
    System.out.println("update probehl");
    this.conn.close();
        
    }

    
            
    
    
    
    
    
    
    
    
    
    

 
    
    
    
    
}

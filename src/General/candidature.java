package General;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class candidature {
	private int id, Guild_Id, user_id;
	private String guild_name, user_name, message, message_titre, situation;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuild_Id() {
		return Guild_Id;
	}
	public void setGuild_Id(int guild_Id) {
		Guild_Id = guild_Id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getGuild_name() {
		return guild_name;
	}
	public void setGuild_name(String guild_name) {
		this.guild_name = guild_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage_titre() {
		return message_titre;
	}
	public void setMessage_titre(String message_titre) {
		this.message_titre = message_titre;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static LinkedList<candidature> getcandidaturebyguildid(int id){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
        String sql =  " select * from candidature where guild_id = '"+id+"' ";
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        
	        LinkedList<candidature> allcandidatures = new LinkedList<candidature>();
	        candidature cand = new candidature();
	        
	          while (rs.next()) {
	        	  if ( rs.getString("id") != null ) {
	        		  cand = new candidature();
	        		  
	        		  cand.id = Integer.parseInt(rs.getString("id") );
	        		  cand.Guild_Id = Integer.parseInt(rs.getString("Guild_id") );
	        		  cand.user_id = Integer.parseInt(rs.getString("user_id") );
	        		  cand.guild_name = rs.getString("guild_name") ;
	        		  cand.user_name =rs.getString("user_name") ;
	        		  cand.message =rs.getString("message") ;
	        		  cand.message_titre =rs.getString("message_titre") ;
	        		  cand.situation =rs.getString("situation") ;

	        		  allcandidatures.add(cand);
	              }
	          }    
	          
	          return allcandidatures;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}	
        
        return null;
	}
	

	public static candidature getcandidaturebyID(int id){
	BDD unebdd = new BDD();
	unebdd.chargerPilote();
	unebdd.seConnecter();
	Connection con = unebdd.getMaConnection();
    String sql =  " select * from candidature where id = '"+id+"' ";
    
    try {
        Statement smt = con.createStatement() ;
        ResultSet rs = smt.executeQuery(sql) ;

        candidature cand = new candidature();
        
          while (rs.next()) {
        	  if ( rs.getString("id") != null ) {
        		  cand.id = Integer.parseInt(rs.getString("id") );
        		  cand.Guild_Id = Integer.parseInt(rs.getString("Guild_id") );
        		  cand.user_id = Integer.parseInt(rs.getString("user_id") );
        		  cand.guild_name = rs.getString("guild_name") ;
        		  cand.user_name =rs.getString("user_name") ;
        		  cand.message =rs.getString("message") ;
        		  cand.message_titre =rs.getString("message_titre");
        		  cand.situation =rs.getString("situation") ;
              }
          }    
          
          return cand;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("un truk a pas marcher ");
	}	
    
    return null;
    
}
	public static void deletcandidaturebyid(int id){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
	    String sql =  "DELETE FROM `symfony`.`candidature` WHERE `candidature`.`id` = "+id+"";
	    
	    try {
	        Statement smt = con.createStatement() ;
	        smt.executeUpdate(sql) ;
	         
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}	
	    		
	}
	
	
	public void createCandidature(){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "  " ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;

	        
	          while (rs.next()) {
	        	  if ( rs.getString("id") != null ) {
//	        		  this.id = Integer.parseInt(rs.getString("id") );
//	        		  this.username = rs.getString("username");
//	        		  this.email = rs.getString("email"); 
//	        		  this.password = rs.getString("password");
	              }
	          }    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}
	}
	
}

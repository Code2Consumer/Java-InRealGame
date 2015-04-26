package General;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class planing {
	private int id, guild_id, auteur_id;
	private String auteur_name, titre, infos;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuild_id() {
		return guild_id;
	}
	public void setGuild_id(int guild_id) {
		this.guild_id = guild_id;
	}
	public int getAuteur_id() {
		return auteur_id;
	}
	public void setAuteur_id(int auteur_id) {
		this.auteur_id = auteur_id;
	}
	public String getAuteur_name() {
		return auteur_name;
	}
	public void setAuteur_name(String auteur_name) {
		this.auteur_name = auteur_name;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static LinkedList<planing> getalleventbyguildID(int guildid){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
	    String sql =  " select * from planing where guild_id = '"+guildid+"' ";
	    
	    try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;

	        planing event = new planing();
	        LinkedList<planing> allevents = new LinkedList<planing>();
	        
	          while (rs.next()) {
	        	  if ( rs.getString("id") != null ) {
	        		  event = new planing();
	        		  
	        		  event.id = Integer.parseInt(rs.getString("id") );
	        		  event.guild_id = Integer.parseInt(rs.getString("guild_id") );
	        		  event.auteur_id = Integer.parseInt(rs.getString("auteur_id") );
	        		  event.auteur_name = rs.getString("auteur_name") ;
	        		  event.titre =rs.getString("titre") ;
	        		  event.infos =rs.getString("infos") ;
	        		  event.date =rs.getDate("date");
	        		  allevents.push(event);
	              }
	          }    
	          
	          return allevents;
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}	
	    
	    return null;
		
	}
	
	public static planing geteventbyid(int id){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
	    String sql =  " select * from planing where id = '"+id+"' ";
	    
	    try {
	    	
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;

	        planing event = new planing();

	        
	          while (rs.next()) {
	        	  if ( rs.getString("id") != null ) {
	        		  
	        		  event.id = Integer.parseInt(rs.getString("id") );
	        		  event.guild_id = Integer.parseInt(rs.getString("guild_id") );
	        		  event.auteur_id = Integer.parseInt(rs.getString("auteur_id") );
	        		  event.auteur_name = rs.getString("auteur_name") ;
	        		  event.titre =rs.getString("titre") ;
	        		  event.infos =rs.getString("infos") ;
	        		  event.date =rs.getDate("date");
	              }
	          }    
	          
	          return event;
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}
	
		return null; 
	
	}
	
	
}

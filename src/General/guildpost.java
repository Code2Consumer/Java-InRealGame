package General;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class guildpost {
	private int id, GuildId, UserId;
	private String UserName, Message;
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGuildId() {
		return GuildId;
	}
	public void setGuildId(int guildId) {
		GuildId = guildId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void getallpostforguild(int id){

		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  " select * from guildpost where GuildId = "+id ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        LinkedList<guildpost> touslesposts = new LinkedList<guildpost>();
	        
//	        ecrire un for instead of while 
//	          while (rs.next()) {
//	        	  touslesposts.get(i)
//	        	  this.setId(Integer.parseInt(rs.getString("id")));
//	        	  this.setUserid((Integer.parseInt(rs.getString("userid"))));
//	        	  this.setGuildid(Integer.parseInt(rs.getString("Guildid")));
//	        	  this.setUsername( rs.getString("username"));
//	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de recuperer ce membre. ");
		}
		
	}
	

}

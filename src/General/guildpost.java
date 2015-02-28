package General;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public void setDate(String date) {
		
        DateFormat formatter = null;
        Date convertedDate = null;
        String yyyyMMdd = "20110914";
        formatter = new SimpleDateFormat("yyyyMMdd");
        try {
			convertedDate = (Date) formatter.parse(yyyyMMdd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.date = convertedDate;
	}
	public static LinkedList<guildpost> getallpostforguild(int id){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  " select * from guildpost where GuildId = "+id ;
        
        LinkedList<guildpost> touslesposts = new LinkedList<guildpost>();
        guildpost guildpost = new guildpost();

        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        
	          while (rs.next()) {
	        	  guildpost.setId( Integer.parseInt(rs.getString("id"))  );
	        	  guildpost.setGuildId(Integer.parseInt(rs.getString("GuildId")));
	        	  guildpost.setUserId( Integer.parseInt(rs.getString("UserId")) );
	        	  guildpost.setUserName( rs.getString("UserName"));
	        	  guildpost.setDate( rs.getString("Date"));
	        	  guildpost.setMessage( rs.getString("Message"));
	        	  touslesposts.add(guildpost);
	           }
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de recuperer ce membre. ");
		}
		return touslesposts;
	}
	

}

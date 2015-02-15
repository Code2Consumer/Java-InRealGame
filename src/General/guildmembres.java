package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class guildmembres {
	private int id, userid, Guildid;
	private String username;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getGuildid() {
		return Guildid;
	}
	public void setGuildid(int guildid) {
		Guildid = guildid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public void getallguildmembresbyguildid(int id){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from guildmembres where id = '"+id+"'" ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	          while (rs.next()) {
	        	  this.setId(Integer.parseInt(rs.getString("id")));
	        	  this.setUserid((Integer.parseInt(rs.getString("userid"))));
	        	  this.setGuildid(Integer.parseInt(rs.getString("Guildid")));
	        	  this.setUsername( rs.getString("username"));
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de recuperer ce membre. ");
		}
        
	
	}

	

}

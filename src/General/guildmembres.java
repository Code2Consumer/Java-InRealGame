package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class guildmembres {
	public int id, userid, Guildid;
	public String username;
	
	
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
	
	public static void createmember(int Guild_id, int user_id, String username){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "INSERT INTO `symfony`.`guildmembres` (`id`, `Guildid`, `userid`, `username`) VALUES (NULL, '"+Guild_id+"', '"+user_id+"', '"+username+"'); " ;
        
        try {
	        Statement smt = con.createStatement() ;
	        smt.executeUpdate(sql) ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de recuperer ce membre. ");
		}
        		
	}

	
	public static LinkedList<guildmembres> getallguildmembresbyguildid(int id){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from guildmembres where Guildid = '"+id+"'" ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        
	        LinkedList<guildmembres> allmembres = new LinkedList<guildmembres>();
	        guildmembres membre = new guildmembres();
	        
	          while (rs.next()) {
	        	  membre.setId(Integer.parseInt(rs.getString("id")));
	        	  membre.setUserid((Integer.parseInt(rs.getString("userid"))));
	        	  membre.setGuildid(Integer.parseInt(rs.getString("Guildid")));
	        	  membre.setUsername( rs.getString("username"));
	        	  allmembres.add(membre);
	           }
	          
	          return allmembres;
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de recuperer ce membre. ");
		}
        
	return null;
	}

	

}

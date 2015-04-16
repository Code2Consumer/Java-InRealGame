package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class participant {
	private int id=0;
	private int event_id, user_id;
	private String role;
	private String user_name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public static participant getparticipant(int event_id, int user_id){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
	    String sql =  " select * from participant where event_id = '"+event_id+"' and user_id = '"+user_id+"' ";
	    
	    try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        participant par = new participant();
	          while (rs.next()) {
	        	  if ( rs.getString("id") != null ) {
	        		  par.id=Integer.parseInt(rs.getString("id"));
	        		  par.event_id=Integer.parseInt(rs.getString("event_id"));
	        		  par.user_id=Integer.parseInt(rs.getString("user_id"));
	        		  par.user_name=rs.getString("user_name");
	        		  par.role=rs.getString("role");
	        		  return par;
	              }
	          }    
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Connection impossible ");
		}
		return null;
	}
	
	public static void createparticipant(int event_id, int user_id, String user_name, String role){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
        String sql =  " INSERT INTO `symfony`.`participant` (`id`, `event_id`, `user_id`, `user_name`, `role`) VALUES (NULL, '"+event_id+"', '"+user_id+"', '"+user_name+"', '"+role+"'); ";
        try {
	        Statement smt = con.createStatement() ;
	        smt.executeUpdate(sql) ;
  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" impossible de s'inscrire :" + e);
		}
	}
	
}

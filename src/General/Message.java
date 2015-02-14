package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Message {
	public int  id;
	public String mess;
	
	Message(int id, String mess){
		this.id=id;
		this.mess=mess;
	}
	
	public void test(){
		
		BDD unebdd = new BDD("localhost", "test", "root", "");
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from Message" ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	          while (rs.next()) {
	              System.out.println(rs.getString("mess")) ;
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}
        
	
	}

}

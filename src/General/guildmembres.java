package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class guildmembres {
	public int id, userid, Guildid;
	public String username;
	
	

	public void getallguildmembresbyguildid(int id){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from utilisateur" ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	          while (rs.next()) {
	              System.out.println(rs.getString("mess") ) ;
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}
        
	
	}

	

}

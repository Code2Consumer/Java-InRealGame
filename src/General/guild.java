package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class guild {
	public int id, GM_id;
	public String Guild_name, GM, CoGM, MMO_Principale, Serveur;
	

	public guild(int id, int gM_id, String guild_name, String gM, String coGM,
			String mMO_Principale, String serveur) {
		super();
		this.id = id;
		GM_id = gM_id;
		Guild_name = guild_name;
		GM = gM;
		CoGM = coGM;
		MMO_Principale = mMO_Principale;
		Serveur = serveur;
	}
	public guild() {
		super();
	}

	static public LinkedList<guild> getallguilds(){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from guild" ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        
	        LinkedList<guild> allguilds = new LinkedList<guild>();
	        
	          while (rs.next()) {
	        	  
guild uneguild = 
new guild(
		Integer.parseInt( rs.getString("id") ), 
		Integer.parseInt( rs.getString("gM_id") ), 
		rs.getString("guild_name"), 
		rs.getString("gM"), 
		rs.getString("coGM"), 
		rs.getString("mMO_Principale"), 
		rs.getString("serveur")
		);
	       
	        	  allguilds.push(uneguild);
	           }
	          
	          return allguilds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}
		return null; 
	}
	
    public static void main(String[] args) {
    	
    	LinkedList<guild> allguilds = guild.getallguilds();
    	
        for (int i = 0; i < allguilds.size(); i++) {
            System.out.println(allguilds.get(i).GM );
        }
        
    }


}

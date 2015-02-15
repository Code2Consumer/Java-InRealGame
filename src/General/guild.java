package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class guild {
	private int id, GM_id;
	private String Guild_name, GM, CoGM, MMO_Principale, Serveur;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGM_id() {
		return GM_id;
	}
	public void setGM_id(int gM_id) {
		GM_id = gM_id;
	}
	public String getGuild_name() {
		return Guild_name;
	}
	public void setGuild_name(String guild_name) {
		Guild_name = guild_name;
	}
	public String getGM() {
		return GM;
	}
	public void setGM(String gM) {
		GM = gM;
	}
	public String getCoGM() {
		return CoGM;
	}
	public void setCoGM(String coGM) {
		CoGM = coGM;
	}
	public String getMMO_Principale() {
		return MMO_Principale;
	}
	public void setMMO_Principale(String mMO_Principale) {
		MMO_Principale = mMO_Principale;
	}
	public String getServeur() {
		return Serveur;
	}
	public void setServeur(String serveur) {
		Serveur = serveur;
	}
	
	
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
	
	public void getguild(){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from guild where id = '"+ this.getId()+ "' " ;
        
        try {
        	
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        
	          while (rs.next()) {
	        	  
	        	  this.setCoGM( rs.getString("CoGM") );
	        	  this.setGM( rs.getString("GM") );
	        	  this.setGM_id(Integer.parseInt(rs.getString(" GM_id")));
	        	  this.setGuild_name( rs.getString("Guild_name") );
	        	  this.setId( Integer.parseInt( rs.getString("id") ));
	        	  this.setMMO_Principale( rs.getString("MMO_Principale") );
	        	  this.setServeur(( rs.getString("Serveur")));
	        	  
	           }
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de rechercher la Guild. ");
		}
        
	
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
			System.out.println(" Impossible de recuperer toute les guilods. ");
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

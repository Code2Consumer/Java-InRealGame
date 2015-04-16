package General;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class message {
	private int id, _id_env, id_dest;
	private String name_env, name_dest, titre, message;
	private Date date;
	boolean vue;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int get_id_env() {
		return _id_env;
	}
	public void set_id_env(int _id_env) {
		this._id_env = _id_env;
	}
	public int getId_dest() {
		return id_dest;
	}
	public void setId_dest(int id_dest) {
		this.id_dest = id_dest;
	}
	public String getName_env() {
		return name_env;
	}
	public void setName_env(String name_env) {
		this.name_env = name_env;
	}
	public String getName_dest() {
		return name_dest;
	}
	public void setName_dest(String name_dest) {
		this.name_dest = name_dest;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isVue() {
		return vue;
	}
	public void setVue(boolean vue) {
		this.vue = vue;
	}
	
	
	public static void createmessage(int id_env, String name_env, int id_dest, String name_dest, String titre, String message){ 
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  " INSERT INTO `symfony`.`message` (`id`, `id_env`, `name_env`, `id_dest`, `name_dest`, `titre`, `message`, `date`, `vue`) VALUES (NULL, '"+id_env+"', '"+name_env+"', '"+id_dest+"', '"+name_dest+"', '"+titre+"', '"+message+"', CURRENT_DATE(), '0'); " ;
        
        try {
	        Statement smt = con.createStatement() ;
	        smt.executeUpdate(sql) ;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de recuperer ce membre. ");
		}
        		
	}
	
	public static message getmessagebyid(int id){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
        String sql =  "select * from message where id = '"+id+"'" ;
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        
	        message mess = new message();

	          while (rs.next()) {
	        	  mess.setId(Integer.parseInt(rs.getString("id")));
	        	  mess.set_id_env((Integer.parseInt(rs.getString("id_env"))));
	        	  mess.setId_dest(Integer.parseInt(rs.getString("id_dest")));
	        	  mess.setName_env( rs.getString("name_env"));
	        	  mess.setName_dest( rs.getString("name_dest"));
	        	  mess.setTitre( rs.getString("titre"));
	        	  mess.setMessage( rs.getString("message"));
	        	  mess.setDate( rs.getDate("date"));
	        	  mess.setVue( rs.getBoolean("vue"));
	           }
	          return mess;
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de recuperer ce membre. ");
		}
	return null;
	}

	
	public static LinkedList<message> getallmessageforuser(int id){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
        String sql =  "select * from message where id_dest = '"+id+"'" ;
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        
	        LinkedList<message> allmessages = new LinkedList<message>();
	        message mess = new message();

	          while (rs.next()) {
	        	  mess= new message();
	        	  mess.setId(Integer.parseInt(rs.getString("id")));
	        	  mess.set_id_env((Integer.parseInt(rs.getString("id_env"))));
	        	  mess.setId_dest(Integer.parseInt(rs.getString("id_dest")));
	        	  mess.setName_env( rs.getString("name_env"));
	        	  mess.setName_dest( rs.getString("name_dest"));
	        	  mess.setTitre( rs.getString("titre"));
	        	  mess.setMessage( rs.getString("message"));
	        	  mess.setDate( rs.getDate("date"));
	        	  mess.setVue( rs.getBoolean("vue"));
	        	  
	        	  allmessages.add(mess);
	           }
	          return allmessages;
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de recuperer ce membre. ");
		}
        
	return null;
	}
	
	

	

}
	
	


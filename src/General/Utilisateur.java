package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateur {
	public int id=1;
	public String email, password;
	public String username="Teros";

	
	public Utilisateur(int id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}


	public Utilisateur() {
	}


	public void connection(String login, String password){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from utilisateur where username='"+login+"' and password = '"+ password + "';" ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	          while (rs.next()) {
	        	  if ( rs.getString("id") != null ) {
	        		  this.id = Integer.parseInt(rs.getString("id") );
	        		  this.username = rs.getString("username");
	        		  this.email = rs.getString("email"); 
	        		  this.password = rs.getString("password");
	              }
	          }    
	          
//	          CurrentUser.loadcurrentuser(this);
	          
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" connection impossible:"+e);
		}
        
	}
	



	static public void inscription(String username, String email, String password){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql = " INSERT INTO `utilisateur`(`id`, `username`, `username_canonical`, `email`, `email_canonical`, `password`, `enabled`, `salt`, `locked`, `expired`, `roles`, `credentials_expired`, `credentials_expire_at`)"
        		+ "VALUES (NULL, '"+username+"','"+username+"javausername', '"+email+"', '"+email+"emailuserjava', '"+password+"', '1', 'eg5dcapmiko4oscg44ksk0440oksk4w', '0', '0', 'a:0:{}', '0', NULL ) ";
        
        try {
	        Statement smt = con.createStatement() ;
	        smt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println(" Impossible d'inscrire ");
			System.out.println(""+e);
			
		}
	
	}
	
	public static int checkifuserexist(String login){
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from utilisateur where username='"+login+"';" ;
        
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	          while (rs.next()) {
	        	  if ( rs.getString("id") != null ) {
	        		  return Integer.parseInt(rs.getString("id"));
	              }
	          }    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(" Impossible de verifier si l'utilisateur existe ");
			System.out.println(""+e);
		}		
		return 0;
	}
	
	public void getallusers(){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  "select * from utilisateur" ;
        try {
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	          while (rs.next()) {
	           }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

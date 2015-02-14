package General;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateur {
	public int id=0;
	public String username, email, password;

	
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("un truk a pas marcher ");
		}
        
	}
	



	public void inscription(){
		
		BDD unebdd = new BDD();
		unebdd.chargerPilote();
		unebdd.seConnecter();
		Connection con = unebdd.getMaConnection();
		
        String sql =  " INSERT INTO `utilisateur`(`id`, `username`, `username_canonical`, `email`, `email_canonical`, `password`) VALUES (NULL, 'usernamedoulebrazil','usernamedelebrazil', 'emaildoulebrazil', 'emailededoulebrazil', 'passworddoulebrazil')  " ;
        
        try {
        	
	        Statement smt = con.createStatement() ;
	        ResultSet rs = smt.executeQuery(sql) ;
	        
	        while (rs.next()) {
	        	
	            System.out.println( rs.getString("mess") ) ;
	            
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("un truk a pas marcher ");
			
		}
	
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
	              System.out.println(rs.getString("username")) ;
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
